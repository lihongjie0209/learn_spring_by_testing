package cn.lihongjie.beans.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author 982264618@qq.com
 */
@Component
@Profile("dev")
public class ServiceDevImpl implements Service {
}
