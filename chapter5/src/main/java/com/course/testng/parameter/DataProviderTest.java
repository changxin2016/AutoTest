package com.course.testng.parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest {

    @Test(dataProvider = "data")
    public void testDataProvider(String name, int age) {
        System.out.println("name=" + name + "; age=" + age);
    }

    @DataProvider(name = "data")
    public Object[][] providerData() {

        Object[][] o = new Object[][]{
                {"name1", 10},
                {"name2", 20},
                {"wangwu", 30}
        };
        return o;
    }


    //支持根据方法进行参数化
    @Test(dataProvider = "methodData")
    public void test1(String name, int age) {
        System.out.println("test1方法" + "name=" + name + "; age=" + age);
    }

    @Test(dataProvider = "methodData")
    public void test2(String name, int age) {
        System.out.println("test2方法" + "name=" + name + "; age=" + age);
    }

    @DataProvider(name = "methodData")
    public Object[][] methodDataTest(Method method) {
        Object[][] result = null;
        if (method.getName().equals("test1")) {
            result = new Object[][]{
                    {"name1", 10},
                    {"name2", 20},
                    {"wangwu", 30}
            };
        } else if (method.getName().equals("test2")) {
            result = new Object[][]{
                    {"name3", 100},
                    {"name4", 120}
            };

        }
        return result;
    }
}


