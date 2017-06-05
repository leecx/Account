package com.bysj.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

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
    /**类型（收入/支出） 0为收入，1为支出*/  
    private String type;
    /**类别 */
    private Integer typeid;
    /**时间 */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date time;
    /**备注 */
    private String remark;
    /**金额 */
    private Double num;
    /**成员*/
    private String member;
    public String getMember() {
		return member;
	}

	public void setMember(String member) {
		this.member = member;
	}

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

    public Double getNum() {
        return num;
    }

    public void setNum(Double num) {
        this.num = num;
    }
}