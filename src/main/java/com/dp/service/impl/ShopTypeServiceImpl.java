package com.dp.service.impl;

import cn.hutool.json.JSONUtil;
import com.dp.dto.Result;
import com.dp.entity.ShopType;
import com.dp.mapper.ShopTypeMapper;
import com.dp.service.IShopTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static com.dp.utils.RedisConstants.CACHE_SHOP_TYPE_LIST_KEY;


@Service
public class ShopTypeServiceImpl extends ServiceImpl<ShopTypeMapper, ShopType> implements IShopTypeService {

    @Resource
    StringRedisTemplate stringRedisTemplate;
    @Override
    public Result queryTypeList() {
        // 从Redis中获取商铺信息
        List<String> shopJsonList = stringRedisTemplate.opsForList().range(CACHE_SHOP_TYPE_LIST_KEY,0,-1);

        if (shopJsonList != null && !shopJsonList.isEmpty()) {
            // 如果Redis中有数据，直接返回
            List<ShopType> typeList = new ArrayList<>();
            for (String shopJson : shopJsonList) {
                ShopType shopType = JSONUtil.toBean(shopJson, ShopType.class);
                typeList.add(shopType);
            }
            return Result.ok(typeList);
        }

        List<ShopType> typeList = query().orderByAsc("sort").list();
        // 判断数据库中是否存在
        if (typeList == null || typeList.isEmpty()) {
            // 数据库中也不存在，则返回 false
            return Result.fail("分类不存在！");
        }

        // 3数据库中存在，则将查询到的信息存入 Redis
        for (ShopType shopType : typeList) {
            stringRedisTemplate.opsForList().rightPushAll(CACHE_SHOP_TYPE_LIST_KEY, JSONUtil.toJsonStr(shopType));
        }

        // 返回
        return Result.ok(typeList);
    }
}
