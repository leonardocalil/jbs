package br.com.increaseit.common.vo;

import java.util.ArrayList;
import java.util.List;

import br.com.increaseit.common.constants.FormFieldLogicalOperator;

public class LogicalOperationVo extends ModelVo<LogicalOperationVo> {
	
	
	@Override
	protected Class<LogicalOperationVo> getInstance() {
		return LogicalOperationVo.class;
	}
	private static final long serialVersionUID = -5983763725908187300L;
	
	private FormFieldLogicalOperator logicalOperator;
	private List<RelationalOperationVo> operations;
	public FormFieldLogicalOperator getLogicalOperator() {
		return logicalOperator;
	}
	public void setLogicalOperator(FormFieldLogicalOperator logicalOperator) {
		this.logicalOperator = logicalOperator;
	}
	public List<RelationalOperationVo> getOperations() {
		if (this.operations == null) {
			this.operations = new ArrayList<RelationalOperationVo>(); 
		}
		return this.operations;
	}
	public void setOperations(List<RelationalOperationVo> operations) {
		this.operations = operations;
	}
	
	
	
}
