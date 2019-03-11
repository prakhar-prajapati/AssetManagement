package dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;

import bean.usersBean;

public class SupportDao {

	// Support check
	public int supportCheck(int id,String password,String Desgination)	 
	{
	     int x;
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
		Session ss=sf.openSession();
		Criteria ct=ss.createCriteria(usersBean.class);
		ct.add(Restrictions.eq("support_id",id));
		ct.add(Restrictions.eq("password",password));
		ct.add(Restrictions.eq("Designation",Desgination));
		ArrayList<usersBean> list=(ArrayList<usersBean>)ct.list();
		if(list.isEmpty())
			x=0;
		else
			x=1;
  	ss.close();
		return x;
	}

}
