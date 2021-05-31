package com.digitalone.cotacoes.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.digitalone.cotacoes.dto.StockDTO;
import com.digitalone.cotacoes.service.StockService;

@RestController
@RequestMapping(value = "/stocks")
public class StockController {
	
	@Autowired
	private StockService stockService;
	
	
	@GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<StockDTO>> findAll(){
		
		List<StockDTO> listStock = stockService.findAll();
		
		return ResponseEntity.ok().body(listStock);
		
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StockDTO> findById(@PathVariable Long id){
		
		StockDTO stock = stockService.findById(id);
		return ResponseEntity.ok().body(stock);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StockDTO> insert(@RequestBody StockDTO stockDTO){
		
		stockDTO = stockService.insert(stockDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(stockDTO.getId())
				.toUri();
		return ResponseEntity.created(uri).body(stockDTO);
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StockDTO> update(@RequestBody StockDTO stocktDTO){
		
		stocktDTO =  stockService.update(stocktDTO);
		return ResponseEntity.ok().body(stocktDTO);
	}
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StockDTO> delete(@PathVariable Long id){
		
		StockDTO stock = stockService.delete(id);
		return ResponseEntity.ok().body(stock);
	}
	
	@GetMapping(value = "{/today}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<StockDTO>> findByToday(){
		
		List<StockDTO> stockDTO = stockService.findByToday();
		return ResponseEntity.ok().body(stockDTO);
	}
	

}
