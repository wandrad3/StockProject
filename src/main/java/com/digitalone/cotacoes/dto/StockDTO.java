package com.digitalone.cotacoes.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.digitalone.cotacoes.entity.Stock;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class StockDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private Double price;
	private Double variation;
	private LocalDate data;
	
	public StockDTO(Stock entity) {
		
		this.id = entity.getId();
		this.name = entity.getName();
		this.price = entity.getPrice();
		this.variation = entity.getVariation();
		this.data = entity.getData();
		
	}
	

}
