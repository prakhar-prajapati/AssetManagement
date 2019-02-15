package dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;

import bean.AdminBean;
import bean.AssetsBean;
import bean.usersBean;

public class MyDao {
	
	public MyDao()
	{   int x=0;
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
		Session ss=sf.openSession();
		Transaction tt=ss.beginTransaction();
		AdminBean a=new AdminBean();
		//a.setEmail_Id("101");
		a.setAid(101);
		a.setPassword("admin");
        a.setDesignation("admin");	
		ss.saveOrUpdate(a);
		tt.commit();
		ss.close();

	}

	//	Admin login 
	public int AdminLoginCheck(int id , String password,String Designation)	 
	{
	     int x;
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
		Session ss=sf.openSession();
		//Transaction tt=ss.beginTransaction();
		Criteria ct=ss.createCriteria(AdminBean.class);
		ct.add(Restrictions.eq("aid", id));
		ct.add(Restrictions.eq("password",password));
		ct.add(Restrictions.eq("Designation", Designation));
		ArrayList<AdminBean> list=(ArrayList<AdminBean>)ct.list();
		if(list.isEmpty())
			x=0;
		else
			x=1;
    //	tt.commit();
		ss.close();
		return x;
	}

	//user create
	public int Insert(usersBean e)
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

	//View all user details
	public ArrayList<usersBean> View_users()	 
	{ 
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
		Session ss=sf.openSession();
		//Transaction tt=ss.beginTransaction();
		Criteria ct=ss.createCriteria(usersBean.class);
		
		ArrayList<usersBean> list=(ArrayList<usersBean>)ct.list();
					for(usersBean u:list)
						System.out.println(u);
	//	tt.commit();
		ss.close();
		return list;
	}

//view all assets in admin panel
	public ArrayList<AssetsBean> View_Assets()
	{
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
		Session ss=sf.openSession();
		Criteria ct=ss.createCriteria(AssetsBean.class);
		ArrayList<AssetsBean>list=(ArrayList<AssetsBean>) ct.list();
		ss.close();
		return list;
	}
	
	//get all data from Users table nd display in feild for update purpose in admin panel
		public ArrayList<usersBean> getUsersByUid(int uid) {
			//System.out.println("dao="+uid);
			SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
			Session ss=sf.openSession();
			Criteria ct=ss.createCriteria(usersBean.class);
			ct.add(Restrictions.eq("uid", uid));
			ArrayList<usersBean> list=(ArrayList<usersBean>) ct.list();
			ss.close();
			return list;
		}

		//user Update
		public int UpdateUsers(usersBean e)
	{
	    int x=0; 
		
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
		Session ss=sf.openSession();
		Transaction tt=ss.beginTransaction();
		System.out.println("BEFORE UPDATE"+ e);
		ss.update(e);
		 x=1;
		tt.commit();
		ss.close();
		return x;
	}

		//Add assets
		public int addAssets(AssetsBean e)
	{
	    int x=0; 
		
	    SessionFactory sf=new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session ss=sf.openSession();
		Transaction tt=ss.beginTransaction();
		Object o=ss.save(e);
		if(o!=null)
			x=1;
		tt.commit();
		ss.close();
		return x;
	}

		
			// emp check
				public int LoginCheck(int id,String password,String Desgination)	 
				{
					
					System.out.println("emp dao call");
				     int x;
					SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
					Session ss=sf.openSession();
					Criteria ct=ss.createCriteria(usersBean.class);
					ct.add(Restrictions.eq("emp_id",id));
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
	
				
				
				
				
}
