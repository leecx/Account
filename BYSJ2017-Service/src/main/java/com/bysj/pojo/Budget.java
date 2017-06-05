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
    /**年份*/
    private Integer year;
    /**金额 */
    private Double num;
    /**类型*/
    private int typeId;
  
    
    public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
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

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Double getNum() {
        return num;
    }

    public void setNum(Double num) {
        this.num = num ;
    }
	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Budget [id=" + id + ", userid=" + userid + ", month=" + month
				+ ", year=" + year + ", num=" + num + ", typeId=" + typeId
				+ "]";
	}

	
    
}