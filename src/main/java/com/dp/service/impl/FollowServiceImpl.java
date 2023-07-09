package com.dp.service.impl;

import com.dp.entity.Follow;
import com.dp.mapper.FollowMapper;
import com.dp.service.IFollowService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class FollowServiceImpl extends ServiceImpl<FollowMapper, Follow> implements IFollowService {

}
