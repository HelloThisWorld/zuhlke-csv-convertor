package com.zuhlke.converter.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zuhlke.converter.model.dto.StoreOrderDTO;
import com.zuhlke.converter.repository.StoreOrderRepository;

@Service
public class StoreOrderService {
	@Autowired
	private StoreOrderRepository repo;
	
	public List<StoreOrderDTO> getAll() {
		List<StoreOrderDTO> result = new ArrayList<>();
		repo.findAll().forEach(result::add);
		return result;
	}
}
