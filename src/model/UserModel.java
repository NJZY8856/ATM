package model;
/**
 * 用户属性
 *
 */
public class UserModel {
	private String id;//身份证号
	private String name;//姓名
	private String phone;//电话
	private String address;//地址
	private String admin_id;//管理员ID
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	
	public String toString(){
		return "id="+id+",name="+name+",phone="+phone+",address="+address+",admin_id="+admin_id;
	}

}
