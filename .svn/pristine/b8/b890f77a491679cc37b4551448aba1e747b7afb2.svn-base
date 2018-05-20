package service;

import java.util.List;

import dao.TradDao;
import model.TradModel;

/**
 * 交易信息处理
 * @author LiangShuilian
 *
 */
public class TradService {

	/**
	 * 通过 卡号、类型  ，获取当天“取款”或“存款”或“转账”的交易金额 
	 * 
	 * @param 卡号、类型
	 * @return  统计当天（类型）交易的金额
	 */
	public double getTodayTrad(String card_id, int trad_type) {
		double today_trad_money = 0.0;
		today_trad_money = TradDao.getTodayTrad(card_id,trad_type);
		return today_trad_money;
	}
	
	/**
	 * 查询交易明细
	 * @param date
	 * @author Lanny
	 */
	public List<TradModel> checkTradWithDate(String card_id, String startStr, String finalStr, int trad_type) {
		List<TradModel> trade=null;
		trade=new TradDao().findByIDADateAType(card_id, startStr, finalStr, trad_type);
		return trade;
	}

	/**
	 * 添加交易信息
	 * @param trad
	 * @return
	 */
	public boolean addTrad(TradModel trad) {
		return TradDao.addTrad(trad);
	}

}
