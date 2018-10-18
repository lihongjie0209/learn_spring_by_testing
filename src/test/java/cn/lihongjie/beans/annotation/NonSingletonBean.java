package cn.lihongjie.beans.annotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author 982264618@qq.com
 */
@Component
@Scope("prototype")
public class NonSingletonBean {
}
