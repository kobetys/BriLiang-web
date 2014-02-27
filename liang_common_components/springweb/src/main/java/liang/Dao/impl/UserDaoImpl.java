package liang.Dao.impl;

import java.util.List;

import liang.Dao.IUserDao;
import liang.domain.User;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
@Repository
public class UserDaoImpl implements IUserDao {
	@Autowired
	@Qualifier("sessionFactory")  
	private SessionFactory sessionfactory;
	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}
	private synchronized Session getSession(){
		return sessionfactory.getCurrentSession();
	}
	@Override
	public boolean addUser(User user){
		getSession().save(user);
		/*sessionfactory.getCurrentSession().save(user);*/
		return true;
	}
	@Override
	public boolean update(User user) throws Exception {
		getSession().saveOrUpdate(user);
		return false;
	}
	@Override
	public List<User> getUser(User user) throws Exception {
		StringBuffer buffer=new StringBuffer("from User where 1=1");
		if(!user.getUserName().isEmpty()){
			buffer.append("and userName="+user.getUserName());
		}
		if(!user.getPassword().isEmpty()){
			buffer.append("and password="+user.getPassword());
		}
		Query query=getSession().createQuery(buffer.toString());
		return query.list();
	}
	@Override
	public void delete(User user) throws Exception {
	    getSession().delete(user);
	}

}
