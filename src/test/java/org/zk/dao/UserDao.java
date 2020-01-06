package org.zk.dao;

import org.zk.domain.User;

/**
 * Created by zhangkang on 2019/1/6.
 */
public interface UserDao {

//  @Select("select * from tb_user where id = #{id}")
  // @SelectProvider(type = UserSqlProvider.class, method = "findById")
  User findById(int id);

}
