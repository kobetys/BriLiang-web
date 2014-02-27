package liang.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import liang.Dao.IUserDao;
import liang.domain.User;
import liang.service.IUserService;
@Service("IUserService")
@Transactional(readOnly=true)
public class IUserServiceImpl implements IUserService {
	protected Logger logger = Logger.getLogger(IUserServiceImpl.class);
	@Autowired
	private IUserDao IUserDao;
	public void setIUserDao(IUserDao iUserDao) {
		IUserDao = iUserDao;
	}
	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRED,rollbackFor=RuntimeException.class
	,timeout=30,isolation=Isolation.REPEATABLE_READ)
	public boolean addUser(User user) throws Exception {
		try {
			IUserDao.addUser(user);
			//System.out.println(1/0);
		} catch (RuntimeException e) {
			e.printStackTrace();
			logger.info("添加用户错误", e);
			//throw new RuntimeException();
		}
		return true;
	}
	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRED
	,timeout=30,isolation=Isolation.REPEATABLE_READ)
	public boolean update(User user) throws Exception {
		try {
			
		} catch (Exception e) {
			
		}
		return false;
	}
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED,rollbackFor=Exception.class
	,timeout=30,isolation=Isolation.REPEATABLE_READ)
	public User getUser(User user) throws Exception {
		return null;
	}
	
}
