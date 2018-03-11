package com.ssmblog.core.service.impl;

import com.ssmblog.core.dao.UserDao;
import com.ssmblog.core.entity.User;
import com.ssmblog.core.service.UserService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author wangyj
 * @date 2018/3/11
 * @description
 */
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User login(User user) {
        return userDao.login(user);
    }

    @Override
    public List<User> findUser(Map<String, Object> map) {
        return userDao.findUsers(map);
    }

    @Override
    public Long getTotalUser(Map<String, Object> map) {
        return userDao.getToalUser(map);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public int addUser(User user) {
        if (user.getUserName() == null || user.getPassword() == null || getTotalUser(null) > 90) {
            return 0;
        }
        return userDao.addUser(user);
    }

    @Override
    public int deleteUser(Integer id) {
        return userDao.deleteUser(id);
    }
}
