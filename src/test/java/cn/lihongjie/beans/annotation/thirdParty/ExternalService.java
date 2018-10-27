package cn.lihongjie.beans.annotation.thirdParty;

import cn.lihongjie.beans.annotation.Service;

/**
 * @author 982264618@qq.com
 */
public class ExternalService {

	private long id;


	private String name;

	private Service service;

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("ExternalService{");
		sb.append("id=").append(id);
		sb.append(", name='").append(name).append('\'');
		sb.append('}');
		return sb.toString();
	}

	public ExternalService(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}
}
