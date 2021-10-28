package com.zuhlke.converter.model.csv;

import com.opencsv.bean.CsvBindByName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
@ToString
public class Sales {
	@CsvBindByName(column = "Order ID")
	private String orderId;
	@CsvBindByName(column = "Order Date")
	private String orderDate;
	@CsvBindByName(column = "Ship Date")
	private String shipDate;
	@CsvBindByName(column = "Ship Mode")
	private String shipMode;
	@CsvBindByName(column = "Customer ID")
	private String customerId;
	@CsvBindByName(column = "Customer Name")
	private String customerName;
	@CsvBindByName(column = "Segment")
	private String segment;
	@CsvBindByName(column = "Country")
	private String country;
	@CsvBindByName(column = "City")
	private String city;
	@CsvBindByName(column = "State")
	private String state;
	@CsvBindByName(column = "Postal Code")
	private String postalCode;
	@CsvBindByName(column = "Region")
	private String region;
	@CsvBindByName(column = "Product ID")
	private String productId;
	@CsvBindByName(column = "Category")
	private String category;
	@CsvBindByName(column = "Sub-Category")
	private String subCategory;
	@CsvBindByName(column = "Product Name")
	private String productName;
	@CsvBindByName(column = "Sales")
	private double sales;
	@CsvBindByName(column = "Quantity")
	private int quantity;
	@CsvBindByName(column = "Discount")
	private double discount;
	@CsvBindByName(column = "Profit")
	private double profit;
}
