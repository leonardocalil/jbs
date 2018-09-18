package br.com.increaseit.frontend.bean.flow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import br.com.increaseit.common.constants.EnumWeekDay;
import br.com.increaseit.common.constants.FlowFrequence;
import br.com.increaseit.common.constants.FormFieldAction;
import br.com.increaseit.common.constants.FormFieldDoOption;
import br.com.increaseit.common.constants.FormFieldLogicalOperator;
import br.com.increaseit.common.constants.FormFieldRelationalOperator;
import br.com.increaseit.common.constants.FormFieldType;
import br.com.increaseit.common.constants.FormFieldTypeWrite;
import br.com.increaseit.common.util.Constants;
import br.com.increaseit.common.vo.ActionVo;
import br.com.increaseit.common.vo.DateScheduledVo;
import br.com.increaseit.common.vo.DecisionActionVo;
import br.com.increaseit.common.vo.FlowVo;
import br.com.increaseit.common.vo.GroupActionVo;
import br.com.increaseit.common.vo.LogicalOperationVo;
import br.com.increaseit.common.vo.ParameterVo;
import br.com.increaseit.common.vo.RelationalOperationVo;
import br.com.increaseit.common.vo.WeekDayVo;
import br.com.increaseit.frontend.bean.Bean;
import br.com.increaseit.frontend.util.ApplicationContextProvider;
import br.com.increaseit.internal.data.entity.DecisionAction;
import br.com.increaseit.internal.data.repository.IRepositoryCustom;
import br.com.increaseit.internal.data.repository.impl.DecisionActionRepositoryImpl;

@ManagedBean(name="flowForm")
@ViewScoped
public class FlowFormBean extends Bean {


	private List<FlowFrequence> typeFrequences;
	private List<EnumWeekDay> weekDays;
	private EnumWeekDay weekDaySelected;
	
	private FlowVo flow;
	private Date dateSelected;
	private FlowFrequence frequenceSelected;
	
	private TreeNode root;
	
	private TreeNode selectedNode;
	
	private GroupActionVo groupActionSelected;
	
	private ActionVo actionSelected;
	
	private ActionVo actionSelectedForRemove;
	
	private DecisionActionVo decisionSelected;
	
	private DecisionActionVo decisionSelectedForRemove;
	
	private LogicalOperationVo logicalOperationSelectedForRemove;
	private RelationalOperationVo operationSelectedForRemove;
	
	private ParameterVo parameterConstant;
	private ParameterVo parameterGroup;
	private ParameterVo parameterAction;
	private ParameterVo parameterTableColumn;
	
	
	private GroupActionVo teste;
	
	private IRepositoryCustom<DecisionAction> decisionActionRepository;
	
	/**
	 * @return the teste
	 */
	public GroupActionVo getTeste() {
		return teste;
	}

	/**
	 * @param teste the teste to set
	 */
	public void setTeste(GroupActionVo teste) {
		this.teste = teste;
	}

	@PostConstruct
	public void init() {
		typeFrequences = new ArrayList<FlowFrequence>();
		typeFrequences.addAll(Arrays.asList(FlowFrequence.values()));
		
		this.decisionActionRepository = ApplicationContextProvider.getBean("decisionActionRepository", DecisionActionRepositoryImpl.class);
		
		weekDays = new ArrayList<EnumWeekDay>();
		weekDays.addAll(Arrays.asList(EnumWeekDay.values()));
		
		flow = new FlowVo();
		
		flow.getGroupAction().setName("Teste1");
		flow.getGroupAction().getDecisions().add(new DecisionActionVo());
		flow.getGroupAction().getDecisions().add(new DecisionActionVo());
		flow.getGroupAction().getDecisions().get(0).setNextGroup(new GroupActionVo());
		flow.getGroupAction().getDecisions().get(0).getNextGroup().setName("Teste2");
		flow.getGroupAction().getDecisions().get(1).setNextGroup(new GroupActionVo());
		flow.getGroupAction().getDecisions().get(1).getNextGroup().setName("Teste3");
		
		GroupActionVo groupAction = flow.getGroupAction().getDecisions().get(1).getNextGroup();
		groupAction.getDecisions().add(new DecisionActionVo());
		groupAction.getDecisions().add(new DecisionActionVo());
		groupAction.getDecisions().add(new DecisionActionVo());
		
		groupAction.getDecisions().get(0).setNextGroup(new GroupActionVo());
		groupAction.getDecisions().get(0).getNextGroup().setName("Teste4");
		
		groupAction.getDecisions().get(1).setNextGroup(new GroupActionVo());
		groupAction.getDecisions().get(1).getNextGroup().setName("Teste5");
		
		groupAction.getDecisions().get(2).setNextGroup(new GroupActionVo());
		groupAction.getDecisions().get(2).getNextGroup().setName("Teste6");
		
		List<ActionVo> listAction = new ArrayList<ActionVo>();
		ActionVo vo = new ActionVo();
		vo.setRowId(1L);
		vo.setName("Action1");
		vo.setDoAction(FormFieldAction.READ_TABLE);
		listAction.add(vo);
		
		vo = new ActionVo();
		vo.setRowId(2L);
		vo.setName("Action2");
		vo.setDoAction(FormFieldAction.READ_FIELD);
		listAction.add(vo);
		
		vo = new ActionVo();
		vo.setRowId(3L);
		vo.setName("Action3");
		listAction.add(vo);
		
		
		groupAction.getDecisions().get(2).getNextGroup().setActions(listAction);
		
		root = loadTreeNode(flow.getGroupAction(), null);
	}
	
	private TreeNode loadTreeNode(final GroupActionVo groupAction, final TreeNode root) {
		TreeNode node = new DefaultTreeNode(groupAction, root);
		
		for (DecisionActionVo decisionAction :  groupAction.getDecisions()) {
			if (decisionAction.getNextGroup() != null) {
				loadTreeNode(decisionAction.getNextGroup(), node);
			}
		}
				
		return node;
	}
	public void doAddStep() {
		this.actionSelected = new ActionVo();				
	}
	public void doEditStep(ActionVo action) {
		this.actionSelected = action;
	}
	public void doRemoveAction() {
		this.groupActionSelected.getActions().remove(this.actionSelectedForRemove);
	}
	
	public void setActionForRemove(ActionVo action) {
		this.actionSelectedForRemove = action;
	}
	public void doAddDecision() {
		this.decisionSelected = new DecisionActionVo();
		this.decisionSelected.setRowId(decisionActionRepository.getNextRowId());
	}
	
	public void doEditDecision(DecisionActionVo decision) {
		
		try {
			this.decisionSelected = (DecisionActionVo) decision.clone();			
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
	public void doRemoveDecision() {
		this.groupActionSelected.getDecisions().remove(this.decisionSelectedForRemove);
	}
	
	public void doAddLogicalOperator(DecisionActionVo decisionSelected) {
		decisionSelected.getLogicalOperations().add(new LogicalOperationVo());
	}
	public void doAddRelationalOperator(LogicalOperationVo logicalOperation) {
		logicalOperation.getOperations().add(new RelationalOperationVo());
	}
	public void setLogicalOperatorForRemove(LogicalOperationVo logicalOperation) {
		this.logicalOperationSelectedForRemove = logicalOperation;
	}
	public void doRemoveLogicalOperator() {
		this.decisionSelected.getLogicalOperations().remove(this.logicalOperationSelectedForRemove);
	}
	
	public void setRelationalOperatorForRemove(LogicalOperationVo logicalOperation, RelationalOperationVo operation) {
		this.logicalOperationSelectedForRemove = logicalOperation;
		this.operationSelectedForRemove = operation;
	}
	public void doRemoveRelationalOperator() {
		this.logicalOperationSelectedForRemove.getOperations().remove(this.operationSelectedForRemove);
	}
	public void changeWeekDayStatus(WeekDayVo weekDay) {
		String summary = weekDay.isActive() ? "Checked" : "Unchecked";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
	}
	
	public void changeScheduledStatus(DateScheduledVo scheduled) {
		String summary = scheduled.isActive() ? "Checked" : "Unchecked";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
	}
	
	public void changeTypeWrite() {
		if (actionSelected == null) {
			return;
		}
		actionSelected.getParameters().clear();
		switch(actionSelected.getTypeWrite()) {
			case CONSTANT: {
				this.parameterConstant = new ParameterVo(ParameterVo.PARAMETER_CONSTANT);
				this.parameterGroup = null;
				this.parameterAction = null;
				this.parameterTableColumn = null;
			}; break;
			case VARIABLE: {
				this.parameterAction = new ParameterVo(ParameterVo.PARAMETER_VARIABLE_ACTION);
				this.parameterGroup = new ParameterVo(ParameterVo.PARAMETER_VARIABLE_GROUP);
				this.parameterConstant = null;								
				this.parameterTableColumn = null;
			}; break;
		}
	}
	
	public void changeVariableAction() {
		
		if (this.parameterGroup != null && this.parameterGroup.getValue() != null) {		
			for (ActionVo action : ((GroupActionVo)this.parameterGroup.getValue()).getActions()) {
				
				
				if (action.getRowId().equals(((ActionVo)this.parameterAction.getValue()).getRowId())) {
					this.parameterAction.setValue(action);
					break;
				}													
			}
		}
		
	}
	public void changeVariableGroup() {
		List<GroupActionVo> groups = this.getGroups();
		for (GroupActionVo group : groups) {
			if (group.getName().equals(parameterGroup.getValue())) {
				parameterGroup.setValue(group);
				break;
			}
		}
	}
	
	
	public FlowVo getFlow() {
		return flow;
	}



	public void setFlow(FlowVo flow) {
		this.flow = flow;
	}



	public void doSearch() {
		
	}

	public List<FlowFrequence> getTypeFrequences() {
		return typeFrequences;
	}

	public void setTypeFrequences(List<FlowFrequence> typeFrequences) {
		this.typeFrequences = typeFrequences;
	}



	public List<EnumWeekDay> getWeekDays() {
		return weekDays;
	}



	public void setWeekDays(List<EnumWeekDay> weekDays) {
		this.weekDays = weekDays;
	}



	public EnumWeekDay getWeekDaySelected() {
		return weekDaySelected;
	}



	public void setWeekDaySelected(EnumWeekDay weekDaySelected) {
		this.weekDaySelected = weekDaySelected;
	}

	public Date getDateSelected() {
		return dateSelected;
	}

	public void setDateSelected(Date dateSelected) {
		this.dateSelected = dateSelected;
	}

	public FlowFrequence getFrequenceSelected() {
		return frequenceSelected;
	}

	public void setFrequenceSelected(FlowFrequence frequenceSelected) {
		this.frequenceSelected = frequenceSelected;
	}

	public TreeNode getRoot() {
		root = loadTreeNode(flow.getGroupAction(), null);
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	public TreeNode getSelectedNode() {
		return selectedNode;
	}

	public void setSelectedNode(TreeNode selectedNode) {
		this.selectedNode = selectedNode;
		if (this.selectedNode != null) {
			this.groupActionSelected = (GroupActionVo) selectedNode.getData();
		}
	}

	public GroupActionVo getGroupActionSelected() {
		return groupActionSelected;
	}

	public void setGroupActionSelected(GroupActionVo groupActionSelected) {
		this.groupActionSelected = groupActionSelected;
				
	}

	public ActionVo getActionSelected() {
		return actionSelected;
	}

	public void setActionSelected(ActionVo actionSelected) {
		this.decisionSelected = null;
		this.actionSelected = actionSelected;
	}

	public DecisionActionVo getDecisionSelected() {
		return decisionSelected;
	}

	public void setDecisionSelected(DecisionActionVo decisionSelected) {
		this.actionSelected = null;
		this.decisionSelected = decisionSelected;
	}

	public FormFieldType[] getFormFieldTypes() {
	        return FormFieldType.values();
	}
	public FormFieldAction[] getFormFieldActions() {
        return FormFieldAction.values();
	}
	
	public FormFieldTypeWrite[] getFormFieldTypeWrites() {
        return FormFieldTypeWrite.values();
	}
	
	public FormFieldLogicalOperator[] getFormFieldLogicalOperators() {
        return FormFieldLogicalOperator.values();
	}
	public FormFieldRelationalOperator[] getFormFieldRelationalOperators() {
        return FormFieldRelationalOperator.values();
	}
	
	public FormFieldDoOption[] getFormFieldDoOptions() {
		return FormFieldDoOption.values();
	}
	
	public List<GroupActionVo> getGroups() {
		List<GroupActionVo> result = new ArrayList<GroupActionVo>();
		loadGroups(flow.getGroupAction(), this.groupActionSelected, result);
		return result;

	}
	public List<ActionVo> getActions() {
		List <ActionVo> result = new ArrayList<ActionVo>();
		if (this.parameterGroup != null && this.parameterGroup.getValue() != null) {		
			for (ActionVo action : ((GroupActionVo)this.parameterGroup.getValue()).getActions()) {
				
				if (this.actionSelected != null &&
						action.getRowId().equals(this.actionSelected.getRowId())) {
					return result;
				}
				if(FormFieldAction.READ_FIELD.equals(action.getDoAction()) 
						|| FormFieldAction.READ_TABLE.equals(action.getDoAction())) {
					result.add(action);
				}									
			}
		}
		return result;
		
	}
	
	public List<ActionVo> getGroupActions() {
		List <ActionVo> result = new ArrayList<ActionVo>();
		if (groupActionSelected != null) {
			result.addAll(groupActionSelected.getActions());
		}
		return result;
	}
	
	private boolean loadGroups(final GroupActionVo groupAction, 
							final GroupActionVo selectedGroupAction, 
							List<GroupActionVo> result) {
		if (groupAction == selectedGroupAction) {
			result.add(groupAction);
			return true;
		} 
		
		for (DecisionActionVo decisionAction :  groupAction.getDecisions()) {

			if (decisionAction.getNextGroup() != null) {				
				if(loadGroups(decisionAction.getNextGroup(), selectedGroupAction, result)) {
					result.add(groupAction);
					return true;
				}
			}
			
		}
		return false;
		
				
	}
	
	public void saveStep() {
		if(this.actionSelected.getRowId() == null || this.actionSelected.getRowId() == 0) {
			this.groupActionSelected.getActions().add(this.actionSelected);
		}
		RequestContext.getCurrentInstance().execute("PF('" + Constants.FORM_FLOW_ACTION_DIALOG + "').hide()");		
	}
	public void saveDecision() {
		if (!validateDecision()) {
			return;
		}
		
		if(this.decisionSelected.getRowId() == null || this.decisionSelected.getRowId() == 0) {
			this.groupActionSelected.getDecisions().add(this.decisionSelected);
		} else {
			for(int ix = 0; ix < this.groupActionSelected.getDecisions().size(); ix++) {
				DecisionActionVo decision = this.groupActionSelected.getDecisions().get(ix);
				
				if (decision.getRowId().equals(this.decisionSelected.getRowId())) {
					this.groupActionSelected.getDecisions().set(ix, this.decisionSelected);					
					this.decisionSelected = null;
					break;
				}
			}			
		}
		RequestContext.getCurrentInstance().execute("PF('" + Constants.FORM_FLOW_DECISION_DIALOG + "').hide()");		
	}
	
	private boolean validateDecision() {
		
		if (this.decisionSelected == null) {
			this.addErrorMessage(this.getMessage(Constants.MESSAGE_ERROR_DECISION_NOT_SELECTED));
			return false;
		}
		if (FormFieldDoOption.SEND_EMAIL.equals(this.decisionSelected.getDoOption()) 
				|| FormFieldDoOption.WRITE_LOG.equals(this.decisionSelected.getDoOption())) {
			String message = this.getMessage(Constants.MESSAGE_WARNING_FUNCTION_NOT_AVAILABLE).replace("{}", this.getMessage(this.decisionSelected.getDoOption().getLabel()));
			this.addWarningMessage(message);
			return false;
		}
		for (DecisionActionVo decision: this.groupActionSelected.getDecisions()) {
			if (!decision.equals(decisionSelected) 
					&& decisionSelected.getSequence().equals(decision.getSequence())) {
				String message = this.getMessage(Constants.MESSAGE_ERROR_DECISION_SEQUENCE_ALREADY_EXISTS).replace("{}", decisionSelected.getSequence().toString());
				this.addErrorMessage(message);
				return false;
			}
		}
			
		if( decisionSelected.getLogicalOperations() != null 
				&& decisionSelected.getLogicalOperations().size() > 0) {
			
			for (LogicalOperationVo lo : decisionSelected.getLogicalOperations()) {
				if (lo.getLogicalOperator() == null ) {
					this.addErrorMessage(this.getMessage(Constants.MESSAGE_ERROR_DECISION_LOGICAL_OPERATOR_NOT_SELECTED));
					return false;
				} else {
					if (lo.getOperations() == null 
							|| lo.getOperations().size() == 0) {
						this.addErrorMessage(this.getMessage(Constants.MESSAGE_ERROR_DECISION_RELATIONAL_OPERATOR_NO_REGISTER));
						return false;
					} else {
						boolean erro = false;
						for (RelationalOperationVo ro : lo.getOperations()) {
							if (ro.getAction() == null) {
								erro = true;
								this.addErrorMessage(this.getMessage(Constants.MESSAGE_ERROR_DECISION_RELATIONAL_OPERATOR_NO_ACTION));
							}
							if (ro.getOperator() == null) {
								erro = true;
								this.addErrorMessage(this.getMessage(Constants.MESSAGE_ERROR_DECISION_RELATIONAL_OPERATOR_NO_OPERATOR));
							}
							if (ro.getValue() == null 
									|| ro.getValue().length() == 0) {
								erro = true;
								this.addErrorMessage(this.getMessage(Constants.MESSAGE_ERROR_DECISION_RELATIONAL_OPERATOR_NO_VALUE));
							}
							if(erro) {
								return false;
							}
						}
						
					}
				}
				
			}
		}
		
		
		
		
		
		return true;
	}
	
	public boolean validateActionFields() {
		if(actionSelected.getWaitPreAction()) {
			
		}
		return true;
	}

	/**
	 * @return the parameterConstant
	 */
	public ParameterVo getParameterConstant() {
		return parameterConstant;
	}

	/**
	 * @param parameterConstant the parameterConstant to set
	 */
	public void setParameterConstant(ParameterVo parameterConstant) {
		this.parameterConstant = parameterConstant;
	}

	/**
	 * @return the parameterGroup
	 */
	public ParameterVo getParameterGroup() {
		return parameterGroup;
	}

	/**
	 * @param parameterGroup the parameterGroup to set
	 */
	public void setParameterGroup(ParameterVo parameterGroup) {
		this.parameterGroup = parameterGroup;
	}

	/**
	 * @return the parameterAction
	 */
	public ParameterVo getParameterAction() {
		return parameterAction;
	}

	/**
	 * @param parameterAction the parameterAction to set
	 */
	public void setParameterAction(ParameterVo parameterAction) {
		this.parameterAction = parameterAction;
	}

	/**
	 * @return the parameterTableColumn
	 */
	public ParameterVo getParameterTableColumn() {
		return parameterTableColumn;
	}

	/**
	 * @param parameterTableColumn the parameterTableColumn to set
	 */
	public void setParameterTableColumn(ParameterVo parameterTableColumn) {
		this.parameterTableColumn = parameterTableColumn;
	}

	/**
	 * @return the actionSelectedForRemove
	 */
	public ActionVo getActionSelectedForRemove() {
		return actionSelectedForRemove;
	}

	/**
	 * @param actionSelectedForRemove the actionSelectedForRemove to set
	 */
	public void setActionSelectedForRemove(ActionVo actionSelectedForRemove) {
		this.actionSelectedForRemove = actionSelectedForRemove;
	}

	public DecisionActionVo getDecisionSelectedForRemove() {
		return decisionSelectedForRemove;
	}

	public void setDecisionForRemove(DecisionActionVo decisionSelectedForRemove) {
		this.decisionSelectedForRemove = decisionSelectedForRemove;
	}

	public IRepositoryCustom<DecisionAction> getDecisionActionRepository() {
		return decisionActionRepository;
	}

	public void setDecisionActionRepository(IRepositoryCustom<DecisionAction> decisionActionRepository) {
		this.decisionActionRepository = decisionActionRepository;
	}

	
	
	
	
	
	
}
