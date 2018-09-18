package br.com.increaseit.internal.data.entity;

import java.util.ArrayList;
import java.util.List;

import br.com.increaseit.common.constants.FormFieldLogicalOperator;

public class LogicalOperation extends AEntity {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6564801100428915850L;
	private FormFieldLogicalOperator logicalOperator;
	private List<RelationalOperation> operations;
	public FormFieldLogicalOperator getLogicalOperator() {
		return logicalOperator;
	}
	public void setLogicalOperator(FormFieldLogicalOperator logicalOperator) {
		this.logicalOperator = logicalOperator;
	}
	public List<RelationalOperation> getOperations() {
		if (this.operations == null) {
			this.operations = new ArrayList<RelationalOperation>(); 
		}
		return this.operations;
	}
	public void setOperations(List<RelationalOperation> operations) {
		this.operations = operations;
	}
	
	
	
}
