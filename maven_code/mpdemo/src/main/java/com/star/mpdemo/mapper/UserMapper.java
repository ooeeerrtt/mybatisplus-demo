package com.star.mpdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.star.mpdemo.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {
}
