package com.ssmblog.core.dao;

import com.ssmblog.core.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author wangyj
 * @date 2018/3/10
 * @description
 */
@Repository
public interface UserDao {

    /**
     * 登录
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * 查找用户列表
     * @param map
     * @return
     */
    public List<User> findUsers(Map<String, Object> map);

    /**
     * 获取所有用户数
     * @param map
     * @return
     */
    public Long getTotalUser(Map<String,Object> map);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    public int updateUser(User user);

    /**
     * 新增用户
     * @param user
     * @return
     */
    public int addUser(User user);

    /**
     * 删除用户
     * @param id
     * @return
     */
    public int deleteUser(Integer id);

}
