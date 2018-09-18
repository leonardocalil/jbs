package br.com.increaseit.common.vo;

import br.com.increaseit.common.constants.FormFieldRelationalOperator;

public class RelationalOperationVo extends ModelVo<RelationalOperationVo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1306352046139544682L;

	private ActionVo action;
	private FormFieldRelationalOperator operator;
	private String value;
	
	public ActionVo getAction() {
		return action;
	}
	public void setAction(ActionVo action) {
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
	@Override
	protected Class<RelationalOperationVo> getInstance() {
		// TODO Auto-generated method stub
		return RelationalOperationVo.class;
	}
	
	
	
		
}
