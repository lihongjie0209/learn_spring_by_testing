package cn.lihongjie.beans.conflict;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author 982264618@qq.com
 */
@Component
@Qualifier("proService")
public class ServiceProImpl implements Service {
}
