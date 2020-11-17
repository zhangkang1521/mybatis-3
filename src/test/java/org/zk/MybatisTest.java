package org.zk;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.zk.dao.UserDao;
import org.zk.domain.User;

import java.io.Reader;
import java.util.*;

/**
 * Created by Administrator on 7/16/2017.
 */
public class MybatisTest {

    SqlSessionFactory sqlSessionFactory;
    SqlSession session;

    @Before
    public void before() throws Exception {
        Reader reader = Resources.getResourceAsReader("mybatis.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        session = sqlSessionFactory.openSession(ExecutorType.BATCH);
    }

    @After
    public void after() {
        session.close();
    }

    @Test
    public void testIbatis() {
      User user = session.selectOne("org.zk.dao.UserDao.findById", 1);
      User user2 = session.selectOne("org.zk.dao.UserDao.findById", 2);
    }

    @Test
    public void testSave() {
      User user = new User();
      user.setUsername("zk-test");
      user.setCreateTime("2020-05-06");
      session.insert("org.zk.dao.UserDao.insert", user);
//      if (true) throw new RuntimeException("xx");
      session.commit();
    }

  @Test
  public void testUpdate() {
   Map<String, Object> parameter = new HashMap<>();
    parameter.put("id", 1);
    parameter.put("username", "a");
    session.update("org.zk.dao.UserDao.update", parameter);
    parameter.put("id", 2);
    parameter.put("username", "b");
    session.update("org.zk.dao.UserDao.update", parameter);
    session.commit();
  }

    @Test
    public void testDao(){
        UserDao userDao = session.getMapper(UserDao.class);
        User user = new User();
        user.setUsername("zk");
      userDao.asyncBatchInsert(Arrays.asList(user));
      System.out.println(user);
//      System.out.println(user.getOrderList2());
    }

  @Test
  public void testParam(){
    UserDao userDao = session.getMapper(UserDao.class);
    userDao.findByIdAndUsername(1, "zk");
  }









}
