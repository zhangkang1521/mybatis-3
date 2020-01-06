package org.zk.dao;

public class UserSqlProvider {

  public String findById(int id) {
    return "select * from tb_user where id = #{id}";
  }
}
