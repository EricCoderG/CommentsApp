package com.dp.service.impl;

import com.dp.entity.UserInfo;
import com.dp.mapper.UserInfoMapper;
import com.dp.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

}
