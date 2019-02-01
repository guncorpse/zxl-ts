package zxl.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BaseController {
	
	private String assetsPath = "http://localhost:8080/zxl-ts";
	
	@Autowired
	private HttpServletRequest request;
	
	protected ModelAndView createView(String name) {
		ModelAndView view = new ModelAndView(name);
		view.addObject("assets_path", assetsPath);
		HttpSession session = this.getSession();
		if (session.getAttribute("userInfo") != null) {
			view.addObject("userInfo", session.getAttribute("userInfo"));
		}
		return view;
	}
	
	protected HttpSession getSession() {
		return request.getSession();
	}

}
