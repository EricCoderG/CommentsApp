package com.dp.service;

import com.dp.dto.Result;
import com.dp.entity.Shop;
import com.baomidou.mybatisplus.extension.service.IService;


public interface IShopService extends IService<Shop> {

    Result queryById(Long id);

    Result update(Shop shop);
}
