package com.digitalone.cotacoes.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digitalone.cotacoes.entity.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {

	

	@Query("SELECT stock FROM Stock stock WHERE stock.name = :name AND stock.data = :data AND stock.id <> :id")
	Optional<Stock> findByStockUpdate(String name, LocalDate data, Long id);

	@Query("SELECT stock FROM Stock stock WHERE stock.data = CURRENT_DATE")
	List<Stock> findByToday();

	Optional<Stock> findByNameAndData(String name, LocalDate data);

}
