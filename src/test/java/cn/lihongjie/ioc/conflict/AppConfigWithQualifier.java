package cn.lihongjie.ioc.conflict;

import cn.lihongjie.beans.conflict.Conflict;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author 982264618@qq.com
 */
@Configuration
@ComponentScan(basePackageClasses = Conflict.class)
public class AppConfigWithQualifier {




}
