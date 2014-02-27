package springmvc.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.support.RequestContextUtils;

@Controller
@RequestMapping("/spring")
public class SpringController {
	/*注入接口实现的一种方式@Resource(name="SpringManager")*/
	//@Autowired
	//private ISpring ispring;
	@RequestMapping("/get")
	public String get(HttpServletRequest request){
		//spirng 上下文
		WebApplicationContext con1=WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
		//spring mvc上下文
		WebApplicationContext con2=RequestContextUtils.getWebApplicationContext(request);
		//ISpring ISpring=(ISpring) con1.getBean("SpringManager");
		//ISpring ISpring=(ISpring) con2.getBean("SpringManager");
		//System.out.println(ispring.get());
		return "/show/success";
	}
}
