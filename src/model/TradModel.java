package model;

import java.sql.Date;

/**
 * 交易属性
 *
 */
public class TradModel {
	private String card_id;//卡号
	private String trad_time;//时间
//	private String trad_time;//时间
	private double amount;//交易金额
	/**
	 * 交易类型：01存款，02取款，03转出，04转入
	 */
	private int trad_type;
	/**
	 * 目标卡号
	 */
	private String trad_to;
	public String getCard_id() {
		return card_id;
	}
	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}
	public String getTrad_time() {
		return trad_time;
	}
	public void setTrad_time(String trad_time) {
		this.trad_time = trad_time;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getTrad_type() {
		return trad_type;
	}
	public void setTrad_type(int trad_type) {
		this.trad_type = trad_type;
	}
	public String getTrad_to() {
		return trad_to;
	}
	public void setTrad_to(String trad_to) {
		this.trad_to = trad_to;
	}
	
	public String toString(){
		return "card_id="+card_id+",trad_time="+trad_time+",amount="+amount+",type="+trad_type;
	}
}
