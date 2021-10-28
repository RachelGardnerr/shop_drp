package com.sk.service.impl;

import com.sk.dao.UserMapper;
import com.sk.domain.User;
import com.sk.domain.UserExample;
import com.sk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> queryUserByLoginAccount(String account) {
        if (account != null){
            UserExample example = new UserExample();
            example.createCriteria().andLoginAccountEqualTo(account);
            return userMapper.selectByExample(example);
        }
        return Collections.emptyList();
    }

    @Override
    public int updateUser(User user) {
        if (user != null) {
            user.setUpdateTime(new Date());
            userMapper.updateByPrimaryKeySelective(user);
        }
        return 0;
    }

    @Override
    public int deleteUserById(Integer id) {
        if (id != null) {
            return userMapper.deleteByPrimaryKey(id);
        }
        return 0;
    }

    @Override
    public int addUser(User user) {
        if (user != null) {
            user.setId(null);
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());
            return userMapper.insertSelective(user);
        }
        return 0;
    }

    @Override
    public List<User> queryUserByUsername(String username) {
        if (username != null) {
            UserExample example = new UserExample();
            example.createCriteria().andUserNameEqualTo(username);
            return userMapper.selectByExample(example);
        }
        return Collections.emptyList();
    }

    @Override
    public List<User> queryAllUser() {
        return userMapper.selectByExample(null);
    }

    @Override
    public List<User> queryUser(User user) {
        if (user != null) {
            UserExample example = new UserExample();
            UserExample.Criteria criteria = example.createCriteria();
            criteria.andLoginAccountEqualTo(user.getLoginAccount()).andPasswordEqualTo(user.getPassword());
            return userMapper.selectByExample(example);
        }
        return Collections.emptyList();
    }
}
