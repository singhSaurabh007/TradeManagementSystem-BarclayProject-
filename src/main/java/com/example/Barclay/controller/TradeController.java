package com.example.Barclay.controller;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.Barclay.Entity.Trade;
import com.example.Barclay.service.TradeService;
import com.example.Barclay.serviceImpl.TradeServiceImpl;



@Controller
public class TradeController {

	@Autowired
	private TradeService tradeService;
	
	@Autowired
	private TradeServiceImpl tradeServiceImpl;
	
	
	
	public TradeController(TradeService tradeService) {
		super();
		this.tradeService = tradeService;
	}

	


	@GetMapping("/trade")
	public String listTrade(Model model) {
		
		model.addAttribute("trade", tradeService.getAllTrade());
		return "Trade";
	}
	
	@GetMapping("/trade/new")
	public String createTradeForm(Model model) {
		
		Trade trade=new Trade();
		model.addAttribute("trade", trade);
		return "Create_trade";
		
	}
	
	@PostMapping("/trade")
	public String saveStudent(@ModelAttribute("trade") Trade trade ,RedirectAttributes ra) {
		
		tradeService.saveTrade(trade);
		if(tradeServiceImpl.checkv==1)
			ra.addFlashAttribute("error","Higher version is already present in database");   //showing alert message
		if(tradeServiceImpl.checkm==1)
			ra.addFlashAttribute("error","Store should not allow the trade which has less maturity date then today date"); //showing alert message
		return "redirect:/trade";
	}
	
	@GetMapping("/trade/{id}")
	public String deleteStudent(@PathVariable String id) {
		tradeService.deleteTradeById(id);
		return "redirect:/trade";
	}
}
