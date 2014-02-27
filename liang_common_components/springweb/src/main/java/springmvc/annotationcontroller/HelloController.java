package springmvc.annotationcontroller;

import liang.domain.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 
* @ClassName: HelloController
* @Description: TODO(spring控制器)
* @author BriLiang(liangwen.liang@vipshop.com)
* @date 2013年9月18日
 */
@Controller
@RequestMapping("/hello")
public class HelloController {
	private User user=new User();
	//采用model进行跳转
/*	@RequestMapping(method=RequestMethod.GET,value="/home")
	public ModelAndView home(Model model,String username){
		String message="suck_Bitch";
		user.setUsername(username);
		user.setPassword("lllll");
		//model.addAttribute("message","suck_Bitch");
		model.addAttribute(user);
		return new ModelAndView("/WEB-INF/views/hello.jsp");
	}*/
	
/*	@RequestMapping(method=RequestMethod.GET,value="/home")
	public String  home(Model model,String username){
		String message="suck_Bitch";
		user.setUsername(username);
		user.setPassword("擦擦擦");
		//model.addAttribute("message","suck_Bitch");
		model.addAttribute(user);
		return "hello";
	}*/
	
	
/*	@RequestMapping(method=RequestMethod.GET,value="/home")
	public User hello(String username){
		String message="suck_Bitch";
		user.setUsername(username);
		user.setPassword("擦擦擦");
		//model.addAttribute("message","suck_Bitch");
		//model.addAttribute(user);
		return user;
	}*/
	@RequestMapping(method=RequestMethod.GET,value="/home")
	public String hello(User user){
		System.out.println("servlet处理过程");
		return "post";
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/home")
	public User post(User user){
		return user;
	}
}
