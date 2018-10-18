package cn.lihongjie.beans.aop;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author 982264618@qq.com
 */
@Component
@Qualifier("dependency2")

public class DependencyImpl2 implements Dependency {
}
