package com.zuhlke.converter.repository;

import org.springframework.data.repository.CrudRepository;

import com.zuhlke.converter.model.dto.StoreOrderDTO;

public interface StoreOrderRepository extends CrudRepository<StoreOrderDTO, Long> {

}
