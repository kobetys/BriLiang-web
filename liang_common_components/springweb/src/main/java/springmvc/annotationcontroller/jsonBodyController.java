package springmvc.annotationcontroller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import liang.domain.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value="/jsonBody",method=RequestMethod.GET)
public class jsonBodyController {
	@RequestMapping("/json")
	@ResponseBody
	public Map jsonBody(User user,HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map<String, String> map=new HashMap<String,String>();
		map.put("小拜年", "小编");
		map.put("说睇噶", "笑嗲");
		map.put("哈哈", "大富翁");
		return map;
	}
}
