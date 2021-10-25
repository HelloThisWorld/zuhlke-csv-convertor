package com.zuhlke.converter.service.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.zuhlke.converter.model.csv.Sales;
import com.zuhlke.converter.model.dto.StoreOrderDTO;

public class CSVToDTOUtil {
	public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yy");

	/**
	 * Convert Sales type to dto type
	 * If dto invalid return null
	 * 
	 * @param Sales sales
	 * @return StoreOrderDTO valid dto
	 */
	public static StoreOrderDTO convert(Sales sales) {
		StoreOrderDTO dto = StoreOrderDTO.builder()
				.orderId(sales.getOrderId())
				.orderDate(setDateValue(sales.getOrderDate()))
				.shipDate(setDateValue(sales.getShipDate()))
				.shipMode(sales.getShipMode())
				.quantity(sales.getQuantity())
				.discount(sales.getDiscount())
				.profit(sales.getProfit())
				.productId(sales.getProductId())
				.customerName(sales.getCustomerName())
				.category(sales.getCategory())
				.customerId(sales.getCustomerId())
				.productName(sales.getProductName())
				.build();
		return validateDTO(dto);
	}

	/**
	 * This function will check if the input dto missing any of the essential values
	 * If any required value is missing, the input dto will be discard
	 * 
	 * @param StoreOrderDTO
	 * @return StoreOrderDTO - valid dto
	 */
	private static StoreOrderDTO validateDTO(StoreOrderDTO dto) {
		StoreOrderDTO result;
		if (!isNotEmpty(dto.getOrderId()) || !isNotEmpty(dto.getOrderDate()) || !isNotEmpty(dto.getShipDate())
				|| !isNotEmpty(dto.getQuantity()) || !isNotEmpty(dto.getProfit()) || !isNotEmpty(dto.getProductId())
				|| !isNotEmpty(dto.getCustomerName()) || !isNotEmpty(dto.getCategory())
				|| !isNotEmpty(dto.getCustomerId())) {
			result = null;
		} else {
			result = dto;
		}

		return result;
	}

	/**
	 * Format date
	 * 'dd.MM.yy'
	 * 
	 * @param String - string date
	 * @return java.util.Date - UTC date
	 */
	private static Date setDateValue(String input) {
		Date result;
		if (input != null && input.length() > 0) {
			// All the date should be store at UTC time zone
			result = Date.from(
					LocalDate.parse(input, DATE_TIME_FORMATTER).atStartOfDay().atZone(ZoneId.of("UTC")).toInstant());
		} else {
			result = null;
		}

		return result;
	}

	/**
	 * <p>
	 * Internal helper function</br>
	 * This function to help filter check if the string value is empty
	 * </p>
	 * Ex:
	 * <li>value is null return false</li>
	 * <li>value is "" return false</li>
	 * <li>value is "0" return true</li>
	 * <li>value is "some thing" return true</li>
	 * 
	 * @param String - any
	 * @return boolean
	 */
	private static boolean isNotEmpty(String value) {
		return value != null && value.length() > 0;
	}

	/**
	 * <p>
	 * Internal helper function</br>
	 * This function to help filter check if the Object value is empty
	 * </p>
	 * 
	 * @param value
	 * @return
	 */
	private static boolean isNotEmpty(Object value) {
		return value != null;
	}
}
