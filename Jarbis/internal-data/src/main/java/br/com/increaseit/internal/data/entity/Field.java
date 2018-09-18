package br.com.increaseit.internal.data.entity;

import br.com.increaseit.common.constants.FormFieldType;

public class Field extends AEntity {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4541248767673424977L;
	private FormFieldType fieldType;
	private String fieldName;
	public FormFieldType getFieldType() {
		return fieldType;
	}
	public void setFieldType(FormFieldType fieldType) {
		this.fieldType = fieldType;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	
		
	
}
