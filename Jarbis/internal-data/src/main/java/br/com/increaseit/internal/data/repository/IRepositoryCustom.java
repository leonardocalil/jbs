package br.com.increaseit.internal.data.repository;

import br.com.increaseit.internal.data.entity.AEntity;

public interface IRepositoryCustom<T extends AEntity> {
	Long getNextRowId();
}
