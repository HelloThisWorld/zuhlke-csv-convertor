package com.zuhlke.converter.service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.opencsv.bean.CsvToBeanBuilder;
import com.zuhlke.converter.model.csv.Sales;
import com.zuhlke.converter.model.dto.StoreOrderDTO;
import com.zuhlke.converter.repository.StoreOrderRepository;
import com.zuhlke.converter.service.utils.CSVToDTOUtil;

@Service
public class CSVService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CSVService.class);

	@Autowired
	private StoreOrderRepository repository;
	
	/**
	 * This function will be executed automatically after the bean be created
	 * This function will read the CSV file in data folder and insert data to MySql database
	 * If the data already existed, just log an error and do nothing
	 */
	@PostConstruct
	private void processData() {
		List<StoreOrderDTO> dtoList = getDataFromFile();
		try {
			repository.saveAll(dtoList);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
	}
	
	/**
	 * This function load data from resource
	 * And cover CSV format into data entity
	 * 
	 * @return
	 */
	protected List<StoreOrderDTO> getDataFromFile() {
		try {
			File csv = ResourceUtils.getFile("classpath:data/sales.csv");
			Reader targetReader = new FileReader(csv);

			List<Sales> sales = new CsvToBeanBuilder<Sales>(targetReader).withType(Sales.class).build().parse();
			LOGGER.info("sales order number {}", sales.size());
			List<StoreOrderDTO> dtoList = new ArrayList<>();
			for (Sales s : sales) {
				LOGGER.info("Processing {}", s);
				StoreOrderDTO data = CSVToDTOUtil.convert(s);
				if(data != null && !dtoList.contains(data)) {
					dtoList.add(data);
				}
			}
			
			return dtoList;
		} catch (IOException e) {
			LOGGER.error("No such file");
			return null;
		}
	}
}
