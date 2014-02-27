package liang.Dao;

import java.util.List;

import liang.domain.User;

public interface IUserDao {
	/**
	 * 
	* @Title: addUser
	* @Description: TODO(增加用户)
	* @param user
	* @throws Exception   
	* @return 返回类型  boolean    
	 */
	public boolean addUser(User user) throws Exception;
	/**
	 * 
	* @Title: addUser
	* @Description: TODO(修改用户)
	* @param user
	* @throws Exception   
	* @return 返回类型  boolean    
	 */
	public boolean update(User user) throws Exception;
	/**
	 * 
	* @Title: getUser
	* @Description: TODO(根据条件查询用户)
	* @param user
	* @throws Exception   
	* @return 返回类型  List<User>    
	 */
	public List<User> getUser(User user) throws Exception;
	/**
	 * 
	* @Title: delete
	* @Description: TODO(根据条件删除用户)
	* @param user
	* @throws Exception   
	* @return 返回类型  void    
	 */
	public void delete (User user) throws Exception;
}
