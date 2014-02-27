package springmvc.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
public class groupAdminDelegate {
	private String deleteSuccessViewName;
	public String getDeleteSuccessViewName() {
		return deleteSuccessViewName;
	}
	public void setDeleteSuccessViewName(String deleteSuccessViewName) {
		this.deleteSuccessViewName = deleteSuccessViewName;
	}
	
	public ModelAndView list(HttpServletRequest  request,HttpServletResponse response){
		return null;
	}
	public ModelAndView create(HttpServletRequest  request,HttpServletResponse response){
		return null;
	}
	public ModelAndView update(HttpServletRequest  request,HttpServletResponse response){
		return null;
	}
	public ModelAndView delete(HttpServletRequest  request,HttpServletResponse response){
		return new ModelAndView(getDeleteSuccessViewName());
	}
}
