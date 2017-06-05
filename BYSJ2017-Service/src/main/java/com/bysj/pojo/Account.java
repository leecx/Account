package com.bysj.pojo;

/**
 * 账户
 * @author chenxin
 *
 */
public class Account {
	/**id */
    private Integer id;       
    /**用户id */
    private Integer userid;   
    /**账户类型 */
    private String type;    
    /**金额 */
    private Double num;     
    
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Double getNum() {
        return num;
    }

    public void setNum(Double num) {
        this.num = num;
    }
}