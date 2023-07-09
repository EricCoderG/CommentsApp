package com.dp.service.impl;

import com.dp.entity.Blog;
import com.dp.mapper.BlogMapper;
import com.dp.service.IBlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements IBlogService {

}
