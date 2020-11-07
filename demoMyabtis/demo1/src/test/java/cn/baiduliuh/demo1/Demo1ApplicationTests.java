package cn.baiduliuh.demo1;

import cn.baiduliuh.demo1.bean.User;
import cn.baiduliuh.demo1.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class Demo1ApplicationTests {
  @Autowired
  UserService userService;

  final static String MODILE = "15023134459";
  final static String PASSWORD = "123";

  /**
   * 查询全部用户表的测试方法
   */
  @Test
  void contextLoads() {
    List<User> allUser = userService.getAllUser();
    for (User all : allUser) {
      System.out.println(all);
    }

  }

  /**
   * 增加用户表数据的测试方法
   */
  @Test
  public void addtest() {

    User user = new User();

    user.setMobile("15023134458");
    user.setPassword("456");
    user.setSex("男");
    user.setBirthdate("1999.07.6");
    user.setAddress("");
    user.setEmail("2422011527@qq.com");
    user.setState("1");
    user.setCreateTime(new Date());
    user.setUpdateTime(new Date());

    int i = userService.addUser(user);
    System.out.println(i);
  }

  /**
   * 删除用户表的测试方法
   */
  @Test
  public void deleteUser() {
    System.out.println(userService.deldeteUser(MODILE, PASSWORD));
  }

  /**
   * 修改用户数据
   */
  @Test
  public void update() {
    int update = userService.update("女", "2020.07.06", "", "123@qq.com", new Date(), 4);
    System.out.println(update);
  }
}
