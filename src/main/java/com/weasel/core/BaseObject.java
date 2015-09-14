/**
 * BaseObject.java
 */
package com.weasel.core;

import java.io.Serializable;

import com.weasel.core.annotation.Id;

/**我们猜想，每个对象都会有一个id作为唯一标识，BaseObject就是有这样的作用。子类继承了BaseObject，就继承了BaseObject的id。
 * id的类型通过泛型由用户自定义
 * @author Dylan
 * @time 2013-4-17
 */
public abstract class BaseObject<ID extends Object> implements Serializable{

	private static final long serialVersionUID = 1L;

	
	@Id
	protected ID id;

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}
	

}
