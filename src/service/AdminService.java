package service;

import dao.AdminDao;
import dao.CardDao;
import model.AdminModel;
import model.CardModel;

public class AdminService {
	
	/**
	 * 
	 * @param admin_id
	 * @return
	 * @author Lanny
	 */
	public AdminModel getAdminModel(String admin_id) {
		return AdminDao.checkAdmin(admin_id);
	}

	/**
	 * 添加管理员
	 * @param admin
	 * @return
	 */
	public boolean addAdmin(AdminModel admin) {
		return AdminDao.addAdmin(admin);
	}
}
