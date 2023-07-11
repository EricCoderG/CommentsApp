package com.dp.service;

import com.dp.dto.Result;
import com.dp.entity.ShopType;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IShopTypeService extends IService<ShopType> {

    Result queryTypeList();
}
