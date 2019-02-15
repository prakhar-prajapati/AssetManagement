package dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;

import bean.AssetsBean;
import bean.RequestBean;
import bean.usersBean;



public class EmployeeDao {
	
	//get all data from Assets table 
	public ArrayList<AssetsBean> getAssetsByaid() {
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
		Session ss=sf.openSession();
		Criteria ct=ss.createCriteria(AssetsBean.class);
		ArrayList<AssetsBean> list=(ArrayList<AssetsBean>) ct.list();
		ss.close();
		return list;
	}

	//Raise request from employe model
	public int RaiseRequest(RequestBean e)
{
    int x=0; 
	SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
	Session ss=sf.openSession();
	Transaction tt=ss.beginTransaction();
	Object o=ss.save(e);
	if(o!=null)
		x=1;
	tt.commit();
	ss.close();
	return x;
}
	
	
	
	//get manager id from userbean and return
	public ArrayList<usersBean> getMangerId(int uid)
	{
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
		Session ss=sf.openSession();
		Criteria ct=ss.createCriteria(usersBean.class);
		ct.add(Restrictions.eq("emp_id",uid));
		ArrayList<usersBean> list=(ArrayList<usersBean>) ct.list();
		ss.close();
		return list;
		
	}
	
	
	
	public ArrayList<RequestBean> EmpViewRequest(int uid) {
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
		Session ss=sf.openSession();
		Criteria ct=ss.createCriteria(RequestBean.class);
		ct.add(Restrictions.eq("emp_id",uid));
		ArrayList<RequestBean> list=(ArrayList<RequestBean>) ct.list();
		ss.close();
		return list;
	}

	
	
}
