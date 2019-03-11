package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bean.AssetsBean;
import bean.RequestBean;
import dao.ManagerDao;


@Controller
public class ManagerController {
	@RequestMapping("/ViewPendingReq")
    public ModelAndView ViewPendingReq(@ModelAttribute AssetsBean e)
    {
		ManagerDao obj=new ManagerDao();
    	ModelAndView mv=null;
   	 	 mv=new ModelAndView("Manager_ViewPendingRequest");
	      ArrayList<RequestBean> list= obj.ShowPendingReq();
		 mv.addObject("LIST", list);
 	     return mv;
    }

	
	@RequestMapping("/Manager_AprooveReq")
    public ModelAndView Manager_AprooveReq(HttpServletRequest request,@ModelAttribute RequestBean e)
    {
		int rid =Integer.parseInt(request.getParameter("rid"));
		int action =Integer.parseInt(request.getParameter("action"));
	
		ManagerDao obj=new ManagerDao();
    	ModelAndView mv=null;
   	 	 mv=new ModelAndView("Manager_ViewPendingRequest");
	      int x= obj.Approve(rid,action);
	      if(x==1)
	      mv.addObject("msg", "Asset Approved");
	      if(x==2)
		      mv.addObject("msg", "Asset DisApproved");
		  ArrayList<RequestBean> list1= obj.ShowPendingReq();
		  mv.addObject("LIST", list1);
 	     return mv;
    }
	
}
