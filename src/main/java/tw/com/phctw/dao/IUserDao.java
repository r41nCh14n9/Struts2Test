package tw.com.phctw.dao;

import java.io.Serializable;

import tw.com.phctw.entity.Userinfo;

public interface IUserDao {
	public Serializable savedao(Userinfo u);
}
