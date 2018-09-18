package br.com.increaseit.internal.data.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.increaseit.internal.data.entity.DecisionAction;
import br.com.increaseit.internal.data.repository.IRepositoryCustom;

@Repository("decisionActionRepository")
public class DecisionActionRepositoryImpl implements IRepositoryCustom<DecisionAction>{

	@PersistenceContext 
	private EntityManager em;

	@Override
	public Long getNextRowId() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ");
		sql.append(DecisionAction.OWNER_NAME);
		sql.append(".");
		sql.append(DecisionAction.SEQUENCE_NAME);
		sql.append(".nextval FROM dual");
		
		Query query = em.createNativeQuery(sql.toString());
		return (Long) query.getSingleResult();
	}

}
