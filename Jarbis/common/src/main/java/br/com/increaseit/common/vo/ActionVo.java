package br.com.increaseit.common.vo;

import java.util.ArrayList;
import java.util.List;

import br.com.increaseit.common.constants.FormFieldAction;
import br.com.increaseit.common.constants.FormFieldTypeWrite;

public class ActionVo extends FieldVo {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1983767672865518966L;
	
	private FormFieldAction doAction;
	private FormFieldTypeWrite typeWrite;
	
	
	private List<ParameterVo> parameters;
	
	private WaitVo preAction;
	private WaitVo posAction;
	
	private boolean waitPreAction;
	private boolean waitPosAction;
	
	
	public ActionVo() {
		preAction = null;
		posAction = null;
	}
	
	public FormFieldAction getDoAction() {
		return doAction;
	}
	public void setDoAction(FormFieldAction doAction) {
		this.doAction = doAction;
	}
	public WaitVo getPreAction() {
		return preAction;
	}
	public void setPreAction(WaitVo preAction) {
		this.preAction = preAction;
	}
	public WaitVo getPosAction() {
		return posAction;
	}
	public void setPosAction(WaitVo posAction) {
		this.posAction = posAction;
		if (this.waitPreAction) {
			posAction = new WaitVo();
		} else {
			posAction = null;
		}
	}

	public boolean getWaitPreAction() {
		if (preAction != null) {
			waitPreAction = true;
		} else {
			waitPreAction = false;
		}
		return waitPreAction;
	}

	public void setWaitPreAction(boolean waitPreAction) {
		this.waitPreAction = waitPreAction;
		if (this.waitPreAction) {
			preAction = new WaitVo();
		} else {
			preAction = null;
		}
	}

	public boolean getWaitPosAction() {
		if (posAction != null) {
			waitPosAction = true;			
		} else {
			waitPosAction = false;
		}
		return waitPosAction;
	}

	public void setWaitPosAction(boolean waitPosAction) {
		this.waitPosAction = waitPosAction;
		if (this.waitPosAction) {
			posAction = new WaitVo();
		} else {
			posAction = null;
		}
		
	}

	/**
	 * @return the typeWrite
	 */
	public FormFieldTypeWrite getTypeWrite() {
		return typeWrite;
	}

	/**
	 * @param typeWrite the typeWrite to set
	 */
	public void setTypeWrite(FormFieldTypeWrite typeWrite) {
		this.typeWrite = typeWrite;
	}

	/**
	 * @return the parameters
	 */
	public List<ParameterVo> getParameters() {
		if (parameters == null) {
			parameters = new ArrayList<ParameterVo>();
		}
		return parameters;
	}

	/**
	 * @param parameters the parameters to set
	 */
	public void setParameters(List<ParameterVo> parameters) {
		this.parameters = parameters;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((doAction == null) ? 0 : doAction.hashCode());
		result = prime * result + ((parameters == null) ? 0 : parameters.hashCode());
		result = prime * result + ((posAction == null) ? 0 : posAction.hashCode());
		result = prime * result + ((preAction == null) ? 0 : preAction.hashCode());
		result = prime * result + ((typeWrite == null) ? 0 : typeWrite.hashCode());
		result = prime * result + (waitPosAction ? 1231 : 1237);
		result = prime * result + (waitPreAction ? 1231 : 1237);
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof ActionVo)) {
			return false;
		}
		ActionVo other = (ActionVo) obj;
		if (doAction != other.doAction) {
			return false;
		}
		if (parameters == null) {
			if (other.parameters != null) {
				return false;
			}
		} else if (!parameters.equals(other.parameters)) {
			return false;
		}
		if (posAction == null) {
			if (other.posAction != null) {
				return false;
			}
		} else if (!posAction.equals(other.posAction)) {
			return false;
		}
		if (preAction == null) {
			if (other.preAction != null) {
				return false;
			}
		} else if (!preAction.equals(other.preAction)) {
			return false;
		}
		if (typeWrite != other.typeWrite) {
			return false;
		}
		if (waitPosAction != other.waitPosAction) {
			return false;
		}
		if (waitPreAction != other.waitPreAction) {
			return false;
		}
		return true;
	}
	
	
	
	
	
	
}
