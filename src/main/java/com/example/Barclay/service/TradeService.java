package com.example.Barclay.service;

import com.example.Barclay.Entity.Trade;

import java.text.ParseException;
import java.util.*;

import org.springframework.data.jpa.repository.Query;



public interface TradeService {

	

	List<Trade> getAllTrade();
	
	Trade saveTrade(Trade t) ;
	
	Trade getTradeById(String s);
	
	Trade updateTrade(Trade t);
	
	void deleteTradeById(String id);
	
	void updateExpired(Trade t);
	
	
	
}
