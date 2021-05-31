package com.digitalone.cotacoes.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digitalone.cotacoes.dto.StockDTO;
import com.digitalone.cotacoes.entity.Stock;
import com.digitalone.cotacoes.exceptions.BussinessException;
import com.digitalone.cotacoes.exceptions.ResourceNotFoundException;
import com.digitalone.cotacoes.mapper.Mapper;
import com.digitalone.cotacoes.repositories.StockRepository;
import com.digitalone.cotacoes.utils.MessageUtils;


@Service
public class StockService {

	@Autowired
	private StockRepository stockRepository;

	@Autowired
	private Mapper mapper;

	@Transactional(readOnly = true)
	public List<StockDTO> findAll() {

		return stockRepository.findAll().stream().map(x -> new StockDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public StockDTO findById(Long id) {
		Optional<Stock> opt = stockRepository.findById(id);
		Stock entity = opt.orElseThrow(() -> new ResourceNotFoundException("Entity Not Found"));
		return new StockDTO(entity);
	}

	@Transactional
	public StockDTO insert(StockDTO stockDTO) {

		Optional<Stock> opt = stockRepository.findByNameAndData(stockDTO.getName(), stockDTO.getData());

		if (opt.isPresent()) {
			throw new BussinessException(MessageUtils.STOCK_ALREADY_EXISTS);
		}

		Stock stock = mapper.toEntityInsert(stockDTO);
		stock = stockRepository.save(stock);
		return new StockDTO(stock);
	}

	@Transactional
	public StockDTO update(StockDTO stocktDTO) {

		Optional<Stock> opt = stockRepository.findByStockUpdate(stocktDTO.getName(), stocktDTO.getData(),
				stocktDTO.getId());

		if (opt.isPresent()) {
			throw new BussinessException(MessageUtils.STOCK_ALREADY_EXISTS);
		}

		Stock stock = mapper.toEntityUpdate(stocktDTO);
		stock = stockRepository.save(stock);
		return new StockDTO(stock);

	}

	@Transactional
	public StockDTO delete(Long id) {
		
		Optional<Stock> opt = stockRepository.findById(id);
		Stock entity = opt.orElseThrow(() -> new ResourceNotFoundException("Entity Not Found"));
		stockRepository.deleteById(entity.getId());
		
		return new StockDTO(entity);
		

	}

	public List<StockDTO> findByToday() {
		return stockRepository.findByToday().stream().map(x -> new StockDTO(x)).collect(Collectors.toList());
	}

}
