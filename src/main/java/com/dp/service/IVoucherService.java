package com.dp.service;

import com.dp.dto.Result;
import com.dp.entity.Voucher;
import com.baomidou.mybatisplus.extension.service.IService;


public interface IVoucherService extends IService<Voucher> {

    Result queryVoucherOfShop(Long shopId);

    void addSeckillVoucher(Voucher voucher);
}
