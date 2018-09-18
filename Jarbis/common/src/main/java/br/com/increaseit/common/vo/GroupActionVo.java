package br.com.increaseit.common.vo;

import java.util.ArrayList;
import java.util.List;

public class GroupActionVo extends ModelVo<GroupActionVo> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6254384123086160304L;
	private String description;
	private String url;
	private List<ActionVo> actions;
	
	private List<DecisionActionVo> decisions;
	private FinalizeVo finalize;
	
	public GroupActionVo() {
		this.actions = new ArrayList<ActionVo>();
		this.decisions = new ArrayList<DecisionActionVo>();
		this.finalize = null;
		this.name = "Node";
	}
	public GroupActionVo(String name) {
		this.actions = new ArrayList<ActionVo>();
		this.decisions = new ArrayList<DecisionActionVo>();
		this.finalize = null;
		this.name = name;
	}
	
	@Override
	protected Class<GroupActionVo> getInstance() {
		// TODO Auto-generated method stub
		return GroupActionVo.class;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}


	public List<ActionVo> getActions() {
		return actions;
	}

	public void setActions(List<ActionVo> actions) {
		this.actions = actions;
	}

	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public FinalizeVo getFinalize() {
		return finalize;
	}
	public void setFinalize(FinalizeVo finalize) {
		this.finalize = finalize;
	}

	public List<DecisionActionVo> getDecisions() {
		return decisions;
	}

	public void setDecisions(List<DecisionActionVo> decisions) {
		this.decisions = decisions;
	}

	@Override
	public String toString() {
		return name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		 return (rowId != null)
		            ? (this.getClass().hashCode() + rowId.hashCode())
		            : super.hashCode();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object other) {

		 return (other instanceof GroupActionVo) && (rowId != null)
		            ? rowId.equals(((GroupActionVo) other).rowId)
		            : (other == this);
	}

	
	
	
	
	
}
