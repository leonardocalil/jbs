package br.com.increaseit.frontend.bean.flow;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.increaseit.internal.data.entity.Flow;

@ManagedBean(name="flowSearch")
@ViewScoped
public class FlowSearchBean {

	private final String PAGE_FORM = "flow_form.faces";
	
	private String nameSearch;
	private String filtered;

	private List<Flow> flows;
	
	@PostConstruct
	public void init() {
		
	}
	
	public String getNameSearch() {
		return nameSearch;
	}

	public void setNameSearch(String nameSearch) {
		this.nameSearch = nameSearch;
	}
	
	
	
	public String getFiltered() {
		return filtered;
	}

	public void setFiltered(String filtered) {
		this.filtered = filtered;
	}

	
	public List<Flow> getFlows() {
		return flows;
	}

	public void setFlows(List<Flow> flows) {
		this.flows = flows;
	}

	public void doSearch() {
		
	}
	public void doAdd() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(PAGE_FORM);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
