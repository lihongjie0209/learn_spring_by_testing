package cn.lihongjie.beans;

/**
 * @author 982264618@qq.com
 */
public class BeanWithLifeCycle {

	boolean init = false;

	public BeanWithLifeCycle() {
	}

	public boolean isInit() {
		return init;
	}

	public void init() {
		init = true;
	}



}
