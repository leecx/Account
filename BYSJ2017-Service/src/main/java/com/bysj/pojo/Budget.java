package com.bysj.pojo;

/**
 * 预算
 * @author chenxin
 *
 */
public class Budget {
	/**id */
    private Integer id;
    /**用户id */
    private Integer userid;
    /**月份 */
    private Integer month;
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

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num == null ? null : num.trim();
    }
}