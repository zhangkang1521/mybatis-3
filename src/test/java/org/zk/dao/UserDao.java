package org.zk.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.zk.domain.User;

import java.util.List;

/**
 * Created by zhangkang on 2019/1/6.
 */
public interface UserDao {

//  @Select("select * from tb_user where id = #{id}")
//   @SelectProvider(type = UserSqlProvider.class, method = "findById")
  User findById(int id);

  User findByIdAndUsername(@Param("id") int id, @Param("username")String username);

  void update(int id, String username);

  void insert(User user);

  void asyncBatchInsert(@Param("eventLogs") List<User> eventLogs);



}
