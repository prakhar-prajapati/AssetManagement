package dao;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;

import bean.RequestBean;
import bean.usersBean;

public class ManagerDao {
	
	// manager check
	public int mangerCheck(int id,String password,String Desgination)	 
	{
		
		System.out.println("emp dao call");
	     int x;
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
		Session ss=sf.openSession();
		Criteria ct=ss.createCriteria(usersBean.class);
		ct.add(Restrictions.eq("manager_Id",id));
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

	
	
//show pending request
	public ArrayList<RequestBean> ShowPendingReq() {
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
		Session ss=sf.openSession();
		Criteria ct=ss.createCriteria(RequestBean.class);
	//	ct.add(Restrictions.eq("emp_id",uid));
		ArrayList<RequestBean> list=(ArrayList<RequestBean>) ct.list();
		ss.close();
		return list;
	}
	
	//Approve request of employee 
	public int Approve(int rid,int action)
{
    int x=0; 
	SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
	Session ss=sf.openSession();

	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	java.util.Date utilDate = new java.util.Date();
	
	// contains only date information without time
	java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	System.out.println("SQL date in Java : " + dateFormat.format(sqlDate)); 
	Object o=ss.load(RequestBean.class,new Integer(rid));
	RequestBean s=(RequestBean)o;

    Transaction tt=ss.beginTransaction();
	s.setStatus(action);
	s.setManagerApprovedDate(sqlDate);

	ss.update(s);
	if(action==1)
	x=1;
	else
		x=2;
	tt.commit();
	ss.close();
	return x;
}

	
}
