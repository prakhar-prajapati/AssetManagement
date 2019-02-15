package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bean.AssetsBean;
import bean.usersBean;
import dao.MyDao;

@Controller
//@SessionAttributes("uid")
public class MainController {

	@RequestMapping("/")
    public ModelAndView login()
    {
     ModelAndView mv=new ModelAndView("Login");
     //mv.addObject("msg","Admin login page");
     return mv;
    }

	@RequestMapping("/AdminHome")
	public ModelAndView AdminHomePage()
	{
		ModelAndView mv=new ModelAndView("AdimnHome");
		return mv;
	}
 
 
	
	@RequestMapping("/CreateUser")
    public ModelAndView CreateUser()
    {
     ModelAndView mv=new ModelAndView("CreateUser");
     //mv.addObject("msg","Admin login page");
     return mv;
    }
	
	
	@RequestMapping("/updateUsers_view")
    public ModelAndView updateUsers(@RequestParam int uid)
    {
		MyDao obj=new MyDao();
		ArrayList<usersBean> list=obj.getUsersByUid(uid);
     ModelAndView mv=new ModelAndView("UpdateUser_view");
     mv.addObject("LIST",list);
     return mv;
    }

	@RequestMapping("/UpdateUsers_details")
    public ModelAndView UpdateUsers_details(@ModelAttribute usersBean e)
    {
		MyDao obj=new MyDao();
    	ModelAndView mv=null;
   	  int x=obj.UpdateUsers(e);
 	   if(x==1)
 	   {
 		   ArrayList<usersBean> list= obj.View_users();
 		   mv=new ModelAndView("Admin_View","msg","Data updated successfully..");
	     mv.addObject("LIST", list);
    	    }
 	   else {
 		  mv.addObject("msg","Data not Updated....");
 	   }
 		  return mv;
 	
    }

	
	@RequestMapping("/Admin_View")
    public ModelAndView Admin_View()
    {
     ModelAndView mv=new ModelAndView("Admin_View");
     //mv.addObject("msg","Admin login page");
     MyDao obj=new MyDao();
     ArrayList<usersBean>list=(ArrayList<usersBean>)obj.View_users();
     mv.addObject("LIST",list);
     return mv;
    }
   
	
	
	  @RequestMapping("/AdminLoginCheck")
	    public ModelAndView loginCheck(HttpServletRequest request,@RequestParam int id,@RequestParam String password,@RequestParam String Designation)
	    {   
	        	ModelAndView mv=null;
	    MyDao obj=new MyDao();
	    if(Designation.equals("admin"))
	    {
	    	int x=obj.AdminLoginCheck(id, password,Designation);
		 if(x==1)
		  {   
			 mv=new ModelAndView("AdimnHome");
			 HttpSession session=request.getSession();
			 session.setAttribute("uid",id);
			 mv.addObject("msg","Login success...");
		} else{
	    	 mv=new ModelAndView("Login");
			  mv.addObject("msg","Login failed , try again...");
	         }
		}
	    else if(Designation!="assets")
		 {
	    	int y=0;
			if(Designation.equals("employee")) 
			{
	    	 y=obj.LoginCheck(id,password,Designation);
			}
			if(Designation.equals("manager")) 
			{
	    	 y=obj.mangerCheck(id,password,Designation);
			}
			if(y==1)
	 		  {   
	 			 mv=new ModelAndView("Home");
	 			HttpSession session=request.getSession();
				 session.setAttribute("uid",id);
				 mv.addObject("msg",Designation);
	          }
	 		else{
		    	 mv=new ModelAndView("Login");
				  mv.addObject("msg","Login failed , try again...");
		         }
			
		 }   
		 else{
	    	 mv=new ModelAndView("Login");
			  mv.addObject("msg","Login failed , try again...");
	         }
		return mv;
	    }
	  
	  
	  
	  
	  @RequestMapping("/InsertUser_details")
	    public ModelAndView Insert(@ModelAttribute usersBean e)
	    {
	    	MyDao obj=new MyDao();
	    	ModelAndView mv=new ModelAndView("CreateUser");
	   	  int x=obj.Insert(e);
	 	   if(x==1) {
	 	  mv.addObject("msg","Data inserted....");
	 	   }else {
	 		  mv.addObject("msg","Data not inserted....");
	 	 	 }
	 	  return mv;
	 	  }

	  @RequestMapping("/logout")
	    public ModelAndView logout(HttpSession session)
	    { session.removeAttribute("uid");
		  session.invalidate();//destroy all session attribute from server
	    ModelAndView mv=new ModelAndView("Login");
	     return mv;
	    }

	  @RequestMapping("/Add_Assets")
		public ModelAndView Add_Assets()
		{
			ModelAndView mv=new ModelAndView("Add_Assets");
			return mv;
		}
	 
	  @RequestMapping("/addAssets")
	    public ModelAndView addAssets(@ModelAttribute AssetsBean e)
	    {
	    	MyDao obj=new MyDao();
	    	ModelAndView mv=new ModelAndView("Add_Assets");
	   	  int x=obj.addAssets(e);
	 	   if(x==1) {
	 	  mv.addObject("msg","Assets inserted....");
	 	   }else {
	 		  mv.addObject("msg","Assets not inserted....");
	 	 	 }
	 	  return mv;
	 	  }

     @RequestMapping("/Assets_View")
     public ModelAndView Assets_View() {
    	    ModelAndView mv=new ModelAndView("Assets_View");
    	     MyDao obj=new MyDao();
    	     ArrayList<AssetsBean>list=(ArrayList<AssetsBean>)obj.View_Assets();
    	     mv.addObject("LIST",list);
    	     return mv;
    	 }


 	@RequestMapping("/Home")
    public ModelAndView Home()
    {
     ModelAndView mv=new ModelAndView("Home");
    
     return mv;
    }
 	
 	  @RequestMapping("/LoginCheck")
 	    public ModelAndView loginCheck(@RequestParam int id,@RequestParam String password,@RequestParam String Designation )
 	    {   
 	      ModelAndView mv=null;
 	    MyDao obj=new MyDao();
 	    	System.out.println("login check");
 	    int x=obj.LoginCheck(id,password,Designation);
 		 if(x==1)
 		  {   
 			 mv=new ModelAndView("Home");
 			 mv.addObject("msg","Login success...");
 			 
 		  }else if(x==0)
 		  {
 			 mv=new ModelAndView("Login");
 			  mv.addObject("msg","Login failed , try again...");
 		  }
 		 return mv;
 	    }
 	

 	   
}
