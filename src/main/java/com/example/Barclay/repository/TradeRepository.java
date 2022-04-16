package com.example.Barclay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Barclay.Entity.Trade;


public interface TradeRepository extends JpaRepository<Trade,String> {

	
	
}
