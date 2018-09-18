package br.com.increaseit.internal.data.entity;

import br.com.increaseit.common.constants.FormFieldRelationalOperator;

public class RelationalOperation extends AEntity {


	/**
	 * 
	 */
	private static final long serialVersionUID = 2342058474625330465L;
	private Action action;
	private FormFieldRelationalOperator operator;
	private String value;
	
	public Action getAction() {
		return action;
	}
	public void setAction(Action action) {
		this.action = action;
	}
	
	public FormFieldRelationalOperator getOperator() {
		return operator;
	}
	public void setOperator(FormFieldRelationalOperator operator) {
		this.operator = operator;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
		
}
