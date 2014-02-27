package springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class multiActionController extends MultiActionController{
	public ModelAndView add(HttpServletRequest request,HttpServletResponse response) throws Exception{
		ModelAndView model=new ModelAndView();
		model.setViewName("show/multiActionController");
		return model;
	}
	public ModelAndView update(HttpServletRequest request,HttpServletResponse response){
		ModelAndView model=new ModelAndView();
		model.setViewName("show/multiActionController");
		return model;
	}
}
