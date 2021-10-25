package com.zuhlke.converter.model.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
@ToString
@Entity(name = "STORE_ORDER")
@EqualsAndHashCode(of = {"orderId"})
public class StoreOrderDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "ORDER_ID")
	private String orderId;
	@Column(name = "ORDER_DATE")
	private Date orderDate;
	@Column(name = "SHIP_DATE")
	private Date shipDate;
	@Column(name = "SHIP_MODE")
	private String shipMode;
	@Column(name = "QUANTITY")
	private Integer quantity;
	@Column(name = "DISCOUNT")
	private Double discount;
	@Column(name = "PROFIT")
	private Double profit;
	@Column(name = "PRODUCT_ID")
	private String productId;
	@Column(name = "CUSTOMER_NAME")
	private String customerName;
	@Column(name = "CATEGORY")
	private String category;
	@Column(name = "CUSTOMER_ID")
	private String customerId;
	@Column(name = "PRODUCT_NAME")
	private String productName;
}
