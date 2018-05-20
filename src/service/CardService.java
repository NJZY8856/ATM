package service;

import java.sql.Date;
import java.util.List;

import dao.CardDao;
import dao.TradDao;
import model.CardModel;
import model.TradModel;
import util.CurrentCardInfo;

public class CardService {

	/**
	 * 通过卡号 查询获取卡信息
	 * 
	 * @param card_id
	 * @return
	 */
	public CardModel getCardModel(String card_id) {
		return CardDao.checkCard(card_id);
	}

	/**
	 * 修改状态
	 * 
	 * @param card
	 * @return
	 * @author Lanny
	 */
	public boolean updateCardStatus(int status, String card_id) {
		CardDao.updateStatus(status, card_id);
		return false;
	}

	/**
	 * 添加银行卡信息
	 * 
	 * @param card
	 * @return
	 */
	public boolean addCrad(CardModel card) {
		return CardDao.addCard(card);
	}

	// 修改银行卡密码
	// public boolean changeCardPasswd(String password,String card_id){

	// }
	/**
	 * 存款逻辑实现
	 * 
	 * @param money
	 *            获取输入得到的money
	 * @param card_id
	 *            获取存款对象 
	 * @return
	 * @author Lanny
	 */
	public boolean storeCardMoneys(double money, String card_id) {
		CardModel card = CardDao.checkCard(card_id);
		TradModel trade = new TradModel();
		double tstore_line = TradDao.getTodayTrad(card_id, 1);// 今日已存款额度
		double moneys=0;// 存款后余额
		double credit = card.getCredit_line();//透支额度
		new TradDao();
		// 此笔存款后是否超过存款上限
		tstore_line += money;
		// System.out.println("1tstore_line="+tstore_line);
		if (tstore_line > 20000) {
			return false;
		}
		// 是否跨行 手续费收取
		if (!(card.getBank_code().equals(CurrentCardInfo.bankcode))) {
			money -= money * 0.001;
		}
		/*
		 * 是否是信用卡\是否透支 透支额度与余额分别与存款做加减法
		 */
		if (card.getType() == 1) {
			credit = card.getCredit_line();
			if (credit < 2000) {// 有透支
				moneys = money + credit - 2000;
				// 存款小于透支 money<2000-credit
				if (moneys < 0) {
					moneys = 0;
						credit=money + credit;
				}else{
					moneys=money+credit-2000;
					credit=2000;
				}
			} else {// 无透支，相当于储蓄卡
				moneys = card.getMoneys() + money;
				credit=2000;
			}
		} else {
			moneys = card.getMoneys() + money;
		}
		/*
		 * 数据库更新card的透支额度与余额
		 */
		if (CardDao.updateMoney(moneys, credit, card.getCard_id())) {
			trade.setCard_id(card.getCard_id());
			trade.setTrad_to(card.getCard_id());
			trade.setAmount(money);
			trade.setTrad_type(1);
			TradDao.addTrad(trade);
			new CurrentCardInfo().getCardInfo().setMoneys(CardDao.checkCard(card_id).getMoneys());//更新当前卡余额
			return true;
		}
		return false;
	}
	
	/**
	 * 转账  (交易类型：03转出，04转入)
	 * @param money
	 * @param card_id
	 * @return
	 */
	public boolean TradCardMoneys(double money, String card_id,int type) {
		CardModel card = CardDao.checkCard(card_id);
		double moneys = card.getMoneys();// 转账后余额
		double credit = card.getCredit_line();//透支额度
		if (card.getType() == 1 && type == 4) {				//信用卡  被转入
			credit = card.getCredit_line();
			if (credit < 2000) {// 透支
				moneys = money + credit - 2000;
				// 存款小于透支 money<2000-credit
				if (moneys < 0) {
					moneys = 0;
					credit=money + credit;
				}else{
					moneys=money+credit-2000;
					credit=2000;
				}
			} else {// 无透支
				moneys = card.getMoneys() + money;
				credit=2000;
			}
		} else if (card.getType() != 1 && type == 4){		//储蓄卡 被转入
			moneys = card.getMoneys() + money;
			
			
		}else if (card.getType() == 1 && type == 3) {		//信用卡 转出
			credit = card.getCredit_line();
			if (money > card.getMoneys()) {//余额不足，透支
				moneys = 0.0;
				credit -= money - card.getMoneys();
			} else {// 无透支
				moneys = card.getMoneys() - money;
				credit=2000;
			}
		} else if (card.getType() != 1 && type == 3){		//储蓄卡 转出
			moneys = card.getMoneys() - money;
		}
		// 数据库更新card的透支额度与余额
		if (CardDao.updateMoney(moneys, credit, card.getCard_id())) {
			return true;
		}
		return false;
	}
}
