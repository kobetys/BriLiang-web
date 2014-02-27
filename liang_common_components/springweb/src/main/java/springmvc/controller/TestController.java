package springmvc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class TestController implements Controller{
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("���뵽controller");
		String str="String���͵�ֵ";
		Map<String,String> map=new HashMap<String,String>();
		map.put("map1", "map��ModelAndView��ʾֵ");
		map.put("map2","map��ModelAndView��ʾֵ");
		ModelAndView model=new ModelAndView();
		model.addObject("welcomeKey", map);
		model.addObject("StringKey", str);
		model.setViewName("/welcome");
		return model;
	}
	
}
