package com.digitalone.cotacoes.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.digitalone.cotacoes.entity.Stock;
import com.digitalone.cotacoes.repositories.StockRepository;

@Component
public class InsertDataForTesting {
	
	@Autowired
	private StockRepository stockRepository;
	
	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {
		Stock[] stocks = stocks();

	}

	private Stock[] stocks() {
		List<Stock> stocks = new ArrayList<>();
		
		Stock a = new Stock();
		a.setName("MAGALU");
		a.setPrice(22.5);
		a.setVariation(2.6);
		a.setData(LocalDate.now());
		stocks.add(a);
		stockRepository.save(a);
		
		Stock b = new Stock();
		b.setName("Pfizer");
		b.setPrice(35.5);
		b.setVariation(2.6);
		b.setData(LocalDate.now());
		stocks.add(b);
		stockRepository.save(b);
		
		Stock c = new Stock();
		c.setName("Ponto Frio");
		c.setPrice(20.5);
		c.setVariation(2.8);
		c.setData(LocalDate.now());
		stocks.add(c);
		stockRepository.save(c);
		
		Stock[] array = new Stock[stocks.size()];
		return stocks.toArray(array);
		
	}
	
}

