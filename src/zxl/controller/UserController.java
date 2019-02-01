package zxl.controller;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import zxl.modals.Book;
import zxl.modals.User;
import zxl.service.IUserService;

@Controller
@RequestMapping(value = "user")
public class UserController extends BaseController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private BookController bookController;
	
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public ModelAndView getrRegister() {
		ModelAndView page = this.createView("/register.ftl");
		return page;
	}
	
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public ModelAndView register(User user) {
		ModelAndView page = getrRegister();
		try {
			user = userService.save(user);
			page.addObject("success", "success");
		} catch (Exception e) {
			page.addObject("errorMessage", e.getMessage());
		}
		return page;
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ModelAndView login(User user) {
		ModelAndView page = bookController.get(null, null, new Book());
		try {
			user = userService.login(user);
			HttpSession session = this.getSession();
			session.setAttribute("userInfo", user);
		} catch (Exception e) {
			e.printStackTrace();
			page.addObject("errorMessage", e.getMessage());
		}
		return page;
	}
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public ModelAndView logout() {
		ModelAndView page = null;
		try {
			HttpSession session = this.getSession();
			session.invalidate();
			page = bookController.get(null, null, new Book());
		} catch (Exception e) {
			e.printStackTrace();
			page.addObject("errorMessage", e.getMessage());
		}
		return page;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView users() {
		ModelAndView page = this.createView("/user.ftl");
		try {
			Collection<User> users = userService.get(new User());
			page.addObject("users", users);
		} catch (Exception e) {
			e.printStackTrace();
			page.addObject("errorMessage", e.getMessage());
		}
		return page;
	}

}
