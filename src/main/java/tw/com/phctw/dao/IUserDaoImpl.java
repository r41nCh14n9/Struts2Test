package tw.com.phctw.dao;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tw.com.phctw.entity.Userinfo;


@Repository("dao")
public class IUserDaoImpl implements IUserDao {

	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public Serializable savedao(Userinfo u) {
		return sessionfactory.getCurrentSession().save(u);
	}


}
