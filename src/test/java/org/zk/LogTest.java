package org.zk;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.Test;

public class LogTest {

  @Test
  public void test1() {
    Log log = LogFactory.getLog("xxx");
    log.debug("hello,debug");
    log.error("ss");
  }
}
