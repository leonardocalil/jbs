package br.com.increaseit.common.vo;

public class ParameterVo extends ModelVo<ParameterVo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8768947596537465969L;

	public static final String PARAMETER_CONSTANT = "CONSTANT";
	public static final String PARAMETER_VARIABLE_GROUP = "VARIABLE_GROUP";
	public static final String PARAMETER_VARIABLE_ACTION = "VARIABLE_ACTION";
	public static final String PARAMETER_VARIABLE_TABLE_COLUMN = "VARIABLE_TABLE_COLUMN";
	
	public ParameterVo(String name) {
		this.setName(name);
		if (PARAMETER_VARIABLE_GROUP.equals(name)) {
			value = new GroupActionVo();
		}
		if (PARAMETER_VARIABLE_ACTION.equals(name)) {
			value = new ActionVo();
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

	@Override
	protected Class<ParameterVo> getInstance() {
		return ParameterVo.class;
	}
	
	
	
}
