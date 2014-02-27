package springmvc.annotationcontroller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import liang.domain.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/userOdd")
public class UserControllerOdd {
	/**
	 * 
	* @Title: addUser
	* @Description: TODO(注解springmvc)
	* @return 返回类型  ModelAndView    
	* @throws
	 */
	@RequestMapping(value="/addUser")
	public ModelAndView addUser(){
		ModelAndView model=new ModelAndView();
		model.addObject("result", "注解添加用户方法");
		model.setViewName("/show/annotationController");
		return model;
	}
	@RequestMapping(value="/deleteUser",method=RequestMethod.GET)
	public ModelAndView deleteUser(){
		ModelAndView model=new ModelAndView();
		model.addObject("result", "注解删除用户方法");
		model.setViewName("/show/annotationController");
		return model;
	}
	/**
	 * 
	* @Title: postMethod
	* @Description: TODO(不区分请求方式的删除方法，method指定url参数方法)
	* @return 返回类型  ModelAndView    
	 */
	@RequestMapping(value="/post",params="method=postMethod")
	public ModelAndView postMethod(User user,HttpServletRequest request) throws Exception{
		//ajax请求GET方法中文乱码
/*		if(user.getUsername()!=null){
			String userName=URLDecoder.decode(user.getUsername(), "utf-8");
			request.setAttribute("userName",userName);
		}
		if(user.getPassword()!=null){
			String password=URLDecoder.decode(user.getPassword(), "utf-8");
			request.setAttribute("password",password);
		}*/
		
		ModelAndView model=new ModelAndView();
		//model.addObject("result", "注解POST用户请求");
		model.setViewName("/show/annotationController");
		return model;
	}
	/**
	 * 
	* @Title: postMethod
	* @Description: TODO(不区分请求方式的删除方法，method指定url参数方法)
	* @return 返回类型  ModelAndView    
	 */
	@RequestMapping(value="/post",params="method=getMethod")
	public ModelAndView getMethod(){
		ModelAndView model=new ModelAndView();
		//model.addObject("result", "注解POST用户请求");
		model.setViewName("/show/annotationController");
		return model;
	}
	/**
	 * 
	* @Title: jsonMethod
	* @Description: TODO(json处理类)
	* @param user
	* @param request
	* @param response
	* @param @throws Exception   
	* @return 返回类型  void    
	 */
	@RequestMapping(value="/json")
	public void jsonMethod(User user,HttpServletRequest request,HttpServletResponse response) throws Exception{
		PrintWriter out=null;
		String result="{\"userName\":\""+user.getUserName()+"\",\"password\":\""+user.getPassword()+"\"}";
		ModelAndView model=new ModelAndView();
		//model.addObject("result", "注解POST用户请求");
		model.setViewName("/show/annotationController");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out=response.getWriter();
		out.write(result);
	}
}
