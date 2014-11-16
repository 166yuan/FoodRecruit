package org.recruit.action;

/** 注册类
 * @author 陈思远
 *
 */
public class RegisterAction {
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String execute() throws Exception
	{
		try {
			RegisterController.addUser(getUsername(), getPassword());
			return "success"; 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
		
	}
	
}
