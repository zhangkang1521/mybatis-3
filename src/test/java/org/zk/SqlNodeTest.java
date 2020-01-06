package org.zk;

import org.apache.ibatis.scripting.xmltags.*;
import org.apache.ibatis.session.Configuration;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SqlNodeTest {

  @Test
  public void sqlNode() {
    SqlNode sqlNode1 = new StaticTextSqlNode("select * from tb_user where 1=1");
    SqlNode sqlNode2 = new IfSqlNode(new StaticTextSqlNode("and id = #{id}"), "id != null");
    SqlNode mixSqlNode = new MixedSqlNode(Arrays.asList(sqlNode1, sqlNode2));
    Map<String, Object> params = new HashMap<>();
    params.put("id", 1);
    DynamicContext dynamicContext = new DynamicContext(new Configuration(), params);
    mixSqlNode.apply(dynamicContext);
    System.out.println(dynamicContext.getSql());
  }
}
