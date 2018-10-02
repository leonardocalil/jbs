package br.com.increaseit.internal.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.increaseit.internal.data.entity.DecisionAction;
import br.com.increaseit.internal.data.repository.IRepository;
import br.com.increaseit.internal.data.service.IService;

@Service
public class DecisionActionService implements IService<DecisionAction> {

	@Autowired
//	@Qualifier("decisionActionRepository")
	private IRepository<DecisionAction> repository;

	@Override
	public Long getNextRowId() {
		return repository.getNextRowId();
	}
}
