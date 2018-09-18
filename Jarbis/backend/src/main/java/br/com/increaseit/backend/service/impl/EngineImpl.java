package br.com.increaseit.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.increaseit.backend.service.Engine;

@Service("engine")
public class EngineImpl implements Engine{

	@Autowired
	@Qualifier(value="threadEngine")
	private Engine thread;
	

	public void execute() {
		
		thread.execute();

	}

}
