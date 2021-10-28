package com.zuhlke.converter.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.zuhlke.converter.model.dto.StoreOrderDTO;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CSVServiceTest {
	@Autowired
	private CSVService servcie;
	
	@Test
	public void testGetDataFromFileWithHappyPath() {
		// Invoke
		List<StoreOrderDTO> result = servcie.getDataFromFile();
		
		// Assertion
		assertEquals(5, result.size());
		assertEquals("CA-2016-152156", result.get(0).getOrderId());
		assertEquals("FUR-BO-10001798", result.get(0).getProductId());
		assertEquals("CA-2016-138688", result.get(1).getOrderId());
		assertEquals("US-2015-108966", result.get(2).getOrderId());
		assertEquals("CA-2014-115812", result.get(3).getOrderId());
		assertEquals("FUR-FU-10001487", result.get(3).getProductId());
	}
	
}
