package com.example.Barclay;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.Barclay.Entity.Trade;
import com.example.Barclay.repository.TradeRepository;
import com.example.Barclay.service.TradeService;
import com.example.Barclay.serviceImpl.TradeServiceImpl;

@SpringBootTest
class BarclayApplicationTests {
	
	@Autowired
	private TradeService tradeService;

	@MockBean
	private TradeRepository tradeRepository;
	
	@Test
	void contextLoads() {
	}
	
	
	@Test									//Test to create new trade
	public void createNewTradeTest() {
		
		Trade trade=new Trade();
		trade.setTradeId("T7");
		trade.setVersion(2);
		trade.setCounterPartyId("CP-3");
		trade.setBookId("B4");
		trade.setMatuarityDate("2022-12-13");
		trade.setCreatedDate("2021-01-03");
		
		Mockito.when(tradeRepository.save(trade)).thenReturn(trade);
		assertThat(tradeService.saveTrade(trade)).isEqualTo(trade);
		
	}
	
	
	@Test									//Test to validate whether automatically updated Expired status is correct or not
	public void expiredStatusTest() {
		
		Trade trade=new Trade();
		trade.setTradeId("T7");
		trade.setVersion(2);
		trade.setCounterPartyId("CP-3");
		trade.setBookId("B4");
		trade.setMatuarityDate("2025-02-13");
		trade.setCreatedDate("2021-01-03");
		Mockito.when(tradeRepository.save(trade)).thenReturn(trade);
		Trade t=tradeService.saveTrade(trade);
		char expected='N';
		
		assertThat(t.getExpired()).isEqualTo(expected);
	}
	
	
	@Test									//Test to check How application will respond when it get less maturity date then todays date
	public void lessMaturityDateTest() {   
		Trade trade=new Trade();
		trade.setTradeId("T7");
		trade.setVersion(2);
		trade.setCounterPartyId("CP-3");
		trade.setBookId("B4");
		trade.setMatuarityDate("2020-02-13");
		trade.setCreatedDate("2021-01-03");
		Mockito.when(tradeRepository.save(trade)).thenReturn(trade);
		Trade t=tradeService.saveTrade(trade);
		assertThat(t).isEqualTo(null);
		
		
		
	}
	
	
	
	@Test                                   // Test to check How application will respond when it get existing trade with less version
	public void lessVersionTest() {    
		Trade trade=new Trade();
		trade.setTradeId("T7");
		trade.setVersion(5);
		trade.setCounterPartyId("CP-3");
		trade.setBookId("B4");
		trade.setMatuarityDate("2020-02-13");
		trade.setCreatedDate("2021-01-03");
		Mockito.when(tradeRepository.save(trade)).thenReturn(trade);
		Trade t=tradeService.saveTrade(trade);
		
		Trade trade2=new Trade();
		trade2.setTradeId("T7");
		trade2.setVersion(2);
		trade2.setCounterPartyId("CP-3");
		trade2.setBookId("B4");
		trade2.setMatuarityDate("2020-02-13");
		trade2.setCreatedDate("2021-01-03");
		Mockito.when(tradeRepository.save(trade2)).thenReturn(trade2);
		Trade t2=tradeService.saveTrade(trade2);
		assertThat(t2).isEqualTo(null);
	}

}
