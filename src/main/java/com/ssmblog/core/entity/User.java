package com.ssmblog.core.entity;

/**
 * @author wangyj
 * @date 2018/3/10
 * @description 用户实体类
 */
public class User {

    //主键
    private Integer id;
    // 用户名
    private String userName;
    // 密码
    private String password;
    //角色
    private String roleName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", userName=" + userName + ", password="
                + password + ", roleName=" + roleName + "]";
    }

}
