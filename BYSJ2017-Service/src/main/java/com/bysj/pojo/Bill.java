package com.bysj.pojo;

import java.util.Date;

/**
 * 记账数据
 * @author chenxin
 *
 */
public class Bill {
	/**id */
    private Integer id;	
    /**用户id */
    private Integer userid;
    /**账户id */
    private Integer accountid;
    /**类型（收入/支出） */
    private String type;
    /**类别 */
    private Integer typeid;
    /**时间 */
    private Date time;
    /**备注 */
    private String remark;
    /**金额 */
    private String num;

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

    public Integer getAccountid() {
        return accountid;
    }

    public void setAccountid(Integer accountid) {
        this.accountid = accountid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num == null ? null : num.trim();
    }
}