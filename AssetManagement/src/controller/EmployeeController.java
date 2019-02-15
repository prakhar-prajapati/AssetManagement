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
import bean.RequestBean;
import bean.usersBean;
import dao.EmployeeDao;

@Controller
public class EmployeeController {

	@RequestMapping("/EmpAddRequest")
    public ModelAndView EmpAddRequest(@ModelAttribute AssetsBean e)
    {
		EmployeeDao obj=new EmployeeDao();
    	ModelAndView mv=null;
   	 	 mv=new ModelAndView("EmpAssetRequest");
	      ArrayList<AssetsBean> list= obj.getAssetsByaid();
		 mv.addObject("LIST", list);
 	     return mv;
    }

	
	@RequestMapping("/EmpViewRequest")
    public ModelAndView EmpViewRequest(HttpSession session,@ModelAttribute RequestBean e)
    {
		int uid=(Integer)session.getAttribute("uid");
		EmployeeDao obj=new EmployeeDao();
    	ModelAndView mv=null;
   	 	 mv=new ModelAndView("EmpViewRequest");
	      ArrayList<RequestBean> list= obj.EmpViewRequest(uid);
		 mv.addObject("LIST", list);
 	     return mv;
    }
	
	
	
	@RequestMapping("/RaiseRequest")
    public ModelAndView Insert(HttpServletRequest request,@RequestParam String asset_name)
    {	
		EmployeeDao obj=new EmployeeDao();
    	String s[]=asset_name.split("=");
		HttpSession session=request.getSession();
		int uid=(Integer)session.getAttribute("uid");
    
		//get manager id from userbean using function
		ArrayList<usersBean> list1=obj.getMangerId(uid);
		
		ModelAndView mv=new ModelAndView("EmpAssetRequest");
   	    RequestBean e=new RequestBean();
    	e.setAsst_id(Integer.parseInt(s[0]));
    	e.setAsset_name(s[1]);
    	for(usersBean rs:list1)
    	e.setManger_id(rs.getManager_Id());
    	e.setEmp_id(uid);
    	e.setStatus(0);
    	e.setManagerApprovedDate(null);
    	int x=obj.RaiseRequest(e);
 	   if(x==1) {
 		  mv=new ModelAndView("EmpAssetRequest");
	      ArrayList<AssetsBean> list= obj.getAssetsByaid();
		 mv.addObject("LIST", list);
 	       mv.addObject("msg","Request Raise ....");
 	   }else {
 		 mv=new ModelAndView("EmpAssetRequest");
	     ArrayList<AssetsBean> list= obj.getAssetsByaid();
		 mv.addObject("LIST", list);	
		 mv.addObject("msg","Request Not Raise....");
 	 	 }
 	  return mv;
 	  }

	
	
	
	
	
	
	
}
