package br.com.increaseit.internal.data.entity;

import java.util.ArrayList;
import java.util.List;

public class GroupAction extends AEntity {


	/**
	 * 
	 */
	private static final long serialVersionUID = 6803953547769355029L;
	private String description;
	private String url;
	private List<Action> actions;
	
	private List<DecisionAction> decisions;
	private Finalize finalize;
	
	public GroupAction() {
		this.actions = new ArrayList<Action>();
		this.decisions = new ArrayList<DecisionAction>();
		this.finalize = null;
		this.name = "Node";
	}
	public GroupAction(String name) {
		this.actions = new ArrayList<Action>();
		this.decisions = new ArrayList<DecisionAction>();
		this.finalize = null;
		this.name = name;
	}
	
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}


	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Finalize getFinalize() {
		return finalize;
	}
	public void setFinalize(Finalize finalize) {
		this.finalize = finalize;
	}

	public List<DecisionAction> getDecisions() {
		return decisions;
	}

	public void setDecisions(List<DecisionAction> decisions) {
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

		 return (other instanceof GroupAction) && (rowId != null)
		            ? rowId.equals(((GroupAction) other).rowId)
		            : (other == this);
	}

	
	
	
	
	
}
