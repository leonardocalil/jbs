package br.com.increaseit.internal.data.service;

import br.com.increaseit.internal.data.entity.AEntity;

public interface IService <T extends AEntity> {

	Long getNextRowId();
}
