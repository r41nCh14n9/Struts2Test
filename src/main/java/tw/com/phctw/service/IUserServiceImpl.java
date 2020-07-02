package tw.com.phctw.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.phctw.dao.IUserDao;
import tw.com.phctw.entity.Userinfo;


@Service("userService")
@Transactional
public class IUserServiceImpl implements IUserService, IUserDao {

	@Autowired
	private IUserDao dao;
	
	@Override
	public Serializable savedao(Userinfo u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveUser(Userinfo u) {
		dao.savedao(u);
		}

}
