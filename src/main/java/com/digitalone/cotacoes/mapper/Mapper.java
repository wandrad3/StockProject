package com.digitalone.cotacoes.mapper;

import org.springframework.stereotype.Component;

import com.digitalone.cotacoes.dto.StockDTO;
import com.digitalone.cotacoes.entity.Stock;


@Component
public class Mapper {
	
	public Stock toEntityInsert(StockDTO stockDTO) {
		Stock stock = new Stock();
		
		stock.setName(stockDTO.getName());
		stock.setPrice(stockDTO.getPrice());
		stock.setVariation(stockDTO.getVariation());
		stock.setData(stockDTO.getData());
		
		return stock;
		
		
	}
	
	public Stock toEntityUpdate(StockDTO stockDTO) {
		Stock stock = new Stock();
		stock.setId(stockDTO.getId());
		stock.setName(stockDTO.getName());
		stock.setPrice(stockDTO.getPrice());
		stock.setVariation(stockDTO.getVariation());
		stock.setData(stockDTO.getData());
		
		return stock;
		
		
	}

}
