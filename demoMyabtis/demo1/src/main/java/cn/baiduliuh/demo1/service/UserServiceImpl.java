package cn.baiduliuh.demo1.service;

import cn.baiduliuh.demo1.bean.User;
import cn.baiduliuh.demo1.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author hong
 */
@Service
public class UserServiceImpl implements UserService {
  @Autowired
  UserMapper userMapper;

  @Override
  public List<User> getAllUser() {

    return userMapper.getAllUser();
  }

  @Override
  public int addUser(User user) {

    return userMapper.addUser(user);
  }

  @Override
  public int deldeteUser(String mobile, String password) {

    return userMapper.deldeteUser(mobile, password);
  }

  @Override
  public int update(String sex, String birthdate, String address, String email, Date updateTime, int id) {
    return userMapper.update(sex, birthdate, address, email, updateTime, id);
  }
}
