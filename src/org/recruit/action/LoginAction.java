package org.recruit.action;


/**这是structs2的简单示例
 * @author 陈思远（以后你们每个类都加上作者可以拼音）
 *
 */
public class LoginAction
{
	
	private String username;
	private String password;
	
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String execute() throws Exception
	{
		
		if (getUsername().equals("crazyit")
			&& getPassword().equals("leegang"))
		{
			return "success";
		}
		else
		{
			return "error";
		}
	}
}
