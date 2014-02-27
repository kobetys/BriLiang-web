package springmvc.annotationcontroller;

import liang.domain.User;
import liang.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService IUserService;
	public void setIUserService(IUserService iUserService) {
		IUserService = iUserService;
	}
	/**
	* @Title: addUser
	* @Description: TODO(注解springmvc)
	* @return 返回类型  ModelAndView    
	* @throws Exception 
	 */
	@RequestMapping(value="/addUser")
	public String addUser(User user,@PathVariable String id){
		try {
			IUserService.addUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/show/user/addUser";
	}
	@RequestMapping(value="/addUser",params="method=showView")
	public String showView(){
		return "/show/user/addUser";
	}
}
