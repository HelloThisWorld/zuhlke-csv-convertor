package com.zuhlke.converter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zuhlke.converter.model.dto.StoreOrderDTO;
import com.zuhlke.converter.service.StoreOrderService;

@RestController
@RequestMapping("/")
public class RestAPIController {
	@Autowired
	private StoreOrderService service;
	
	@GetMapping("orders")
    public List<StoreOrderDTO> registerTopic() {
        return service.getAll();
    }
}
