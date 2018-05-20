package service;

import javax.swing.JTextField;

import dao.UserDao;
import model.UserModel;
/**
 * 用户信息处理
 * @author LiangShuilian
 *
 */
public class UserService {

	/**
	 * 添加用户信息
	 * @param user
	 * @return
	 */
	public boolean addUser(UserModel user) {
		return UserDao.addUser(user);
	}

	/**
	 * 通过 身份证号 ID  获取信息
	 * @param id
	 * @return
	 */
	public UserModel getUserModel(String id) {
		return UserDao.getUser(id);
	}

	/**
	 * 更新用户信息
	 * @param updateuser
	 * @return
	 */
	public boolean updateUser(UserModel updateuser) {
		return UserDao.updateUser(updateuser);
	}


}
