package org.zk.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 7/16/2017.
 */
public class User implements Serializable{


    private static final long serialVersionUID = 3641942761064124282L;

    private Integer id;
    private String username;
    private Date day;
    private Boolean enable;
    private List<Order> orderList;
    private List<Order> orderList2;

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
        this.username = username;
    }

  public Date getDay() {
    return day;
  }

  public void setDay(Date day) {
    this.day = day;
  }

  public Boolean getEnable() {
    return enable;
  }

  public void setEnable(Boolean enable) {
    this.enable = enable;
  }

  public List<Order> getOrderList() {
    return orderList;
  }

  public void setOrderList(List<Order> orderList) {
    this.orderList = orderList;
  }

  public List<Order> getOrderList2() {
    return orderList2;
  }

  public void setOrderList2(List<Order> orderList2) {
    this.orderList2 = orderList2;
  }
}
