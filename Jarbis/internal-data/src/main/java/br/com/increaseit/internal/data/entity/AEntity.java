package br.com.increaseit.internal.data.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.MappedSuperclass;




//@Entity
@MappedSuperclass
@Inheritance
public abstract class AEntity implements Serializable {

	private static final long serialVersionUID = 597532642589949137L;
	
	@Id
	@Column(name="ROW_ID")
	protected Long rowId;
	
	@Column(name="NAME")
	protected String name;

	public Long getRowId() {
		return rowId;
	}

	public void setRowId(Long rowId) {
		this.rowId = rowId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((rowId == null) ? 0 : rowId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AEntity other = (AEntity) obj;
		if (rowId == null) {
			if (other.rowId != null)
				return false;
		} else if (!rowId.equals(other.rowId))
			return false;
		return true;
	}


	
	

	
	
}
