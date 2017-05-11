package com.bysj.pojo;

/**
 * 共享账户
 * @author chenxin
 *
 */
public class Shareaccount {
	/**id */
    private Integer id;
    /**用户id */
    private Integer userid;
    /**对方id */
    private Integer friendid;
    /**账户id */
    private Integer accountid;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getFriendid() {
        return friendid;
    }

    public void setFriendid(Integer friendid) {
        this.friendid = friendid;
    }

    public Integer getAccountid() {
        return accountid;
    }

    public void setAccountid(Integer accountid) {
        this.accountid = accountid;
    }
}