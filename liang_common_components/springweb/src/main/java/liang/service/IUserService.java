package liang.service;

import liang.domain.User;

public interface IUserService {
	/**
	 * 
	* @Title: addUser
	* @Description: TODO(添加用户)
	* @param user
	* @return 返回类型  boolean    
	* @throws Exception
	 */
	public boolean addUser(User user) throws Exception;
	/**
	 * 
	* @Title: update
	* @Description: TODO(描述这个方法的作用)
	* @param user
	* @throws Exception   
	* @return 返回类型  boolean    
	 */
	public boolean update (User user) throws Exception;
	/**
	 * 
	* @Title: getUser
	* @Description: TODO(查询User)
	* @param 
	* @throws Exception   
	* @return 返回类型  User    
	 */
	public User getUser(User user ) throws Exception;
	
}
