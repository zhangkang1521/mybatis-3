package org.zk;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.zk.dao.UserDao;
import org.zk.domain.User;

import java.io.Reader;
import java.util.Arrays;

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
        session = sqlSessionFactory.openSession();
    }

    @After
    public void after() {
        session.close();
    }

    @Test
    public void testIbatis() {
      User user = session.selectOne("org.zk.dao.UserDao.findById", 1);
      session.commit();
      User user2 = session.selectOne("org.zk.dao.UserDao.findById", 1);
      session.commit();
      System.gc();
      session.selectOne("org.zk.dao.UserDao.findById", 1);
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
