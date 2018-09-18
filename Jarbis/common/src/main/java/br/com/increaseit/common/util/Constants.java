package br.com.increaseit.common.util;

import java.util.ArrayList;
import java.util.List;

public class Constants {

	private static Constants instance;
	
	private List<String> ignoreFields; 
	
	private Constants() {
		ignoreFields = new ArrayList<String>();
		ignoreFields.add("serialVersionUID");
	}
	public static Constants getInstance() {
		if (instance == null) {
			instance = new Constants();
		}
		return instance;
	}
	public List<String> getIgnoreFields() {
		return ignoreFields;
	}
	public void setIgnoreFields(List<String> ignoreFields) {
		this.ignoreFields = ignoreFields;
	}
	
	
	
	public static final String FORM_FLOW_ACTION_DIALOG = "dialogAction";
	public static final String FORM_FLOW_DECISION_DIALOG = "dialogDecision";
	
	public static final String MESSAGE_NAME_DECISION_GROUP_DEFAULT = "message.name.decision.group.default";
	
	
	public static final String MESSAGE_ERROR_DECISION_NOT_SELECTED = "message.error.decision.not.selected";
	public static final String MESSAGE_ERROR_DECISION_SEQUENCE_ALREADY_EXISTS = "message.error.decision.sequece.already.exists";
	public static final String MESSAGE_ERROR_DECISION_LOGICAL_OPERATOR_NO_REGISTER = "message.error.decision.logical.operator.no.register";
	public static final String MESSAGE_ERROR_DECISION_LOGICAL_OPERATOR_NOT_SELECTED = "message.error.decision.logical.operator.not.selected";
	public static final String MESSAGE_ERROR_DECISION_RELATIONAL_OPERATOR_NO_REGISTER = "message.error.decision.relational.operator.no.register";
	
	public static final String MESSAGE_ERROR_DECISION_RELATIONAL_OPERATOR_NO_ACTION = "message.error.decision.relational.operator.no.action";
	public static final String MESSAGE_ERROR_DECISION_RELATIONAL_OPERATOR_NO_OPERATOR = "message.error.decision.relational.operator.no.operator";
	public static final String MESSAGE_ERROR_DECISION_RELATIONAL_OPERATOR_NO_VALUE = "message.error.decision.relational.operator.no.value";
	
	public static final String MESSAGE_WARNING_FUNCTION_NOT_AVAILABLE = "message.warning.function.not.available";
		
	
}
