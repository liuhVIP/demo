package cn.baiduliuh.demo1.myconfig;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 阿里巴巴连接池的配置类
 *
 * @author hong
 */

/*配置类*/
@Configuration
public class Driudconifg {


  /*使得druid的配置文件生效*/
  @ConfigurationProperties(prefix = "spring.datasource")
  @Bean
  public DataSource druid() {
    return new DruidDataSource();
  }

  /* 配置druid servlet管理后台 */
  @Bean
  public ServletRegistrationBean statViewServlet() {
    ServletRegistrationBean registrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");

    Map<String, String> map = new HashMap<>(16);

    map.put("loginUsername", "root");
    map.put("loginPassword", "root");
    //可以写ip地址，默认允许所有访问
    map.put("allow", "");
    //禁止访问的ip
    map.put("deny", "");

    /*初始化参数*/
    registrationBean.setInitParameters(map);
    return registrationBean;
  }

  @Bean
  public FilterRegistrationBean webStatFilter() {
    FilterRegistrationBean registrationBean = new FilterRegistrationBean(new WebStatFilter());
    Map<String, String> map = new HashMap<>(16);
    /*不拦截静态资源和*/
    map.put("exclusions", "*.js,*.css,/druid/*");
    map.put("", "");
    registrationBean.setInitParameters(map);
    /*做拦截*/
    registrationBean.setUrlPatterns(Arrays.asList("/*"));
    return registrationBean;
  }

}
