package util;

import model.CardModel;

/**
 * 存储当前登录的银行卡的信息
 * @author LiangShuilian
 *
 */
public class CurrentCardInfo {//登录判断 密码正确后，把卡信息set进来

	public static CardModel cardInfo;
	public static String admin_id;//存储 管理员编号——用于开户
	public static String admin_pwd;//存储管理员密码，用于修改密码
	
	public static String bankcode = "105";//本行的银行编号
	public static double maxGetMoney = 5000;//一天累计最大取款金额
	
	
	public void setCardInfo(CardModel card){
		this.cardInfo = card;
	}
	
	public CardModel getCardInfo() {
		return cardInfo;
	}

	public static String getAdmin_id() {
		return admin_id;
	}

	public static void setAdmin_id(String admin_id) {
		CurrentCardInfo.admin_id = admin_id;
	}
	
	public static String getAdmin_pwd() {
		return admin_pwd;
	}

	public static void setAdmin_pwd(String admin_pwd) {
		CurrentCardInfo.admin_pwd = admin_pwd;
	}
}
