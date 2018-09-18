package br.com.increaseit.internal.data.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

import br.com.increaseit.common.constants.FormFieldDoOption;
import br.com.increaseit.common.util.Constants;
import br.com.increaseit.common.util.Messages;

@Entity(name="DECISION_ACTION")
public class DecisionAction extends AEntity {
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5032707879090065360L;
	
	public static String OWNER_NAME = "owner";
	public static String SEQUENCE_NAME = "SEQ_DECISION_ACTION";

	
	@Column(name="SEQUENCE")
	private Integer sequence;
	
	@Transient
	private List<LogicalOperation> logicalOperations;
	
	@Transient
	private FormFieldDoOption doOption;
	
	@Transient
	private GroupAction nextGroup;

	public GroupAction getNextGroup() {
		return nextGroup;
	}

	public void setNextGroup(GroupAction nextGroup) {
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
				this.nextGroup = new GroupAction(Messages.getInstance().getMessage(Constants.MESSAGE_NAME_DECISION_GROUP_DEFAULT));
			}
		}
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public List<LogicalOperation> getLogicalOperations() {
		if (logicalOperations == null) {
			logicalOperations = new ArrayList<LogicalOperation>();
		}
		return logicalOperations;
	}

	public void setLogicalOperations(List<LogicalOperation> logicalOperations) {
		this.logicalOperations = logicalOperations;
	}
	
		
	
}
