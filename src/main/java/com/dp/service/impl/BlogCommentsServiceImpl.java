package com.dp.service.impl;

import com.dp.entity.BlogComments;
import com.dp.mapper.BlogCommentsMapper;
import com.dp.service.IBlogCommentsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class BlogCommentsServiceImpl extends ServiceImpl<BlogCommentsMapper, BlogComments> implements IBlogCommentsService {

}
