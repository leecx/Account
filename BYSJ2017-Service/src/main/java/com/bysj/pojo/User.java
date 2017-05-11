package com.bysj.pojo;

/**
 * 用户
 * @author chenxin
 *
 */
public class User {
	/**id */
    private Integer id;
    /**用户名 */
    private String username;
    /**密码 */
    private String password;
    /**头像 */
    private String icon;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }
}