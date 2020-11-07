package cn.baiduliuh.demo1.dao;

import cn.baiduliuh.demo1.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author hong
 * 简单的增删改查功能
 */
@Mapper
@Repository
public interface UserMapper {

  /**
   * 查
   *
   * @return List<User></>
   */
  List<User> getAllUser();

  /**
   * 增
   *
   * @param user
   * @return int
   */
  int addUser(User user);


  /**
   * 删除账户
   *
   * @param mobile
   * @param password
   * @return
   */
  int deldeteUser(@Param("mobile") String mobile, @Param("password") String password);

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
  int update(@Param("sex") String sex, @Param("birthdate") String birthdate, @Param("address") String address, @Param("email") String email, @Param("updateTime") Date updateTime, @Param("id") int id);
}
