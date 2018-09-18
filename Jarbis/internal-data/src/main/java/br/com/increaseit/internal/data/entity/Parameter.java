package br.com.increaseit.internal.data.entity;

import br.com.increaseit.common.vo.ParameterVo;

public class Parameter extends AEntity {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4182156900633032647L;

	public Parameter(String name) {
		this.setName(name);
		if (ParameterVo.PARAMETER_VARIABLE_GROUP.equals(name)) {
			value = new GroupAction();
		}
		if (ParameterVo.PARAMETER_VARIABLE_ACTION.equals(name)) {
			value = new Action();
		}
	}
	
	private Object value;

	/**
	 * @return the value
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(Object value) {
		this.value = value;
	}

	
	
}
