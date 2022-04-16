package com.example.Barclay.Entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Trade")
public class Trade {
	
	@Id
	@Column(name="TradeId")
	private String tradeId;
	
	@Column(name="Version")
	private int version;
	
	@Column(name="CounterPartyId")
	private String counterPartyId;
	
	@Column(name="BookId")
	private String bookId;
	
	@Column(name="MatuarityDate")
	private String matuarityDate;
	
	@Column(name="CreatedDate")
	private String createdDate;
	
	@Column(name="Expired")
	private char expired;
	
	
	

	public Trade() {
		
	}

	public Trade(String tradeId, int version, String counterPartyId, String bookId, String matuarityDate,
			String createdDate, char expired) {
		super();
		this.tradeId = tradeId;
		this.version = version;
		this.counterPartyId = counterPartyId;
		this.bookId = bookId;
		this.matuarityDate = matuarityDate;
		this.createdDate = createdDate;
		this.expired = expired;
	}

	public String getTradeId() {
		return tradeId;
	}

	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getCounterPartyId() {
		return counterPartyId;
	}

	public void setCounterPartyId(String counterPartyId) {
		this.counterPartyId = counterPartyId;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getMatuarityDate() {
		return matuarityDate;
	}

	public void setMatuarityDate(String matuarityDate) {
		this.matuarityDate = matuarityDate;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public char getExpired() {
		return expired;
	}

	public void setExpired(char expired) {
		this.expired = expired;
	}
	
	
	

}
