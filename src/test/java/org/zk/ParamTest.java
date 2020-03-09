package org.zk;

import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ParamTest {

	@Test
	public void test1() throws Exception{
    Method method = A.class.getDeclaredMethod("f", int.class);
    Parameter[] parameters = method.getParameters();
    for (Parameter p : parameters) {
      System.out.println(p.getName());
    }
	}

  public static void main(String[] args) throws Exception{
    Method method = A.class.getDeclaredMethod("f", int.class);
    Parameter[] parameters = method.getParameters();
    for (Parameter p : parameters) {
      System.out.println(p.getName());
    }
  }

	static class A {
		public void f(int a) {

		}
	}
}
