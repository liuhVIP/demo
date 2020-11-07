package cn.baiduliuh.demo1.service;

import cn.baiduliuh.demo1.bean.User;

import java.util.Date;
import java.util.List;

/**
 * @author hong
 */
public interface UserService {
  /**
   * 查询全部
   *
   * @return
   */
  public List<User> getAllUser();

  /**
   * 添加用户
   *
   * @param user
   * @return
   */
  public int addUser(User user);

  /**
   * 删除用户
   *
   * @param mobile
   * @param password
   * @return
   */
  int deldeteUser(String mobile, String password);

  /**
   * 修改账户数据
   *
   * @param sex
   * @param birthdate
   * @param address
   * @param email
   * @param updateTime
   * @param id
   * @return
   */
  int update(String sex, String birthdate, String address, String email, Date updateTime, int id);
}
