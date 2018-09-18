package br.com.increaseit.common.vo;

import java.util.ArrayList;
import java.util.List;

import br.com.increaseit.common.constants.FormFieldDoOption;
import br.com.increaseit.common.util.Constants;
import br.com.increaseit.common.util.Messages;

public class DecisionActionVo extends ModelVo<DecisionActionVo> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4055174234133965159L;
	
	
	private Integer sequence;
	
	private List<LogicalOperationVo> logicalOperations;
	
	
	private FormFieldDoOption doOption;
	
	private GroupActionVo nextGroup;

	@Override
	protected Class<DecisionActionVo> getInstance() {
		// TODO Auto-generated method stub
		return DecisionActionVo.class;
	}
	
	public GroupActionVo getNextGroup() {
		return nextGroup;
	}

	public void setNextGroup(GroupActionVo nextGroup) {
		this.nextGroup = nextGroup;
	}


	public FormFieldDoOption getDoOption() {
		return doOption;
	}

	public void setDoOption(FormFieldDoOption doOption) {
		this.doOption = doOption;
		if (FormFieldDoOption.NOTHING.equals(doOption)) {
			this.nextGroup = null;
		} else if (FormFieldDoOption.GOTO_NEXT.equals(doOption)) {
			if (this.nextGroup == null) {
				this.nextGroup = new GroupActionVo(Messages.getInstance().getMessage(Constants.MESSAGE_NAME_DECISION_GROUP_DEFAULT));
			}
		}
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public List<LogicalOperationVo> getLogicalOperations() {
		if (logicalOperations == null) {
			logicalOperations = new ArrayList<LogicalOperationVo>();
		}
		return logicalOperations;
	}

	public void setLogicalOperations(List<LogicalOperationVo> logicalOperations) {
		this.logicalOperations = logicalOperations;
	}
	
		
	
}
