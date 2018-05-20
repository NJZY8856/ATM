package model;

import java.sql.Date;

/**
 * 银行卡属性
 *
 */
public class CardModel {
	private String card_id;//卡号
	private String password;//密码
	private String id;//用户身份证号
	private String bank_code;//所属银行
	private double moneys;//余额
	/**
	 * 透支限额
	 */
	private double credit_line;
	/**
	 * 类型：1信用卡，2储蓄卡
	 */
	private int type;
	/**
	 * 状态：01正常 02挂失  03冻结  04销户
	 */
	private int status;
	private String open_date;//开卡时间
	
	public String getCard_id() {
		return card_id;
	}

	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBank_code() {
		return bank_code;
	}

	public void setBank_code(String bank_code) {
		this.bank_code = bank_code;
	}

	public double getMoneys() {
		return moneys;
	}

	public void setMoneys(double moneys) {
		this.moneys = moneys;
	}

	public double getCredit_line() {
		return credit_line;
	}

	public void setCredit_line(double credit_line) {
		this.credit_line = credit_line;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getOpen_date() {
		return open_date;
	}

	public void setOpen_date(String open_date) {
		this.open_date = open_date;
	}

	public String toString(){
		return "card_id="+card_id+",password="+password+",id="+id+
				",bank_code="+bank_code+",moneys="+moneys;
	}
}
