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
		ModelAndView page = null;
		try {
			user = userService.login(user);
			HttpSession session = this.getSession();
			session.setAttribute("userInfo", user);
			page = bookController.get(null, null, new Book());
		} catch (Exception e) {
			e.printStackTrace();
			page = bookController.get(null, null, new Book());
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
			page = bookController.get(null, null, new Book());
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
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public ModelAndView deleteuser(User user) {
		ModelAndView page = null;
		try {
			this.userService.delete(user);
			User u = (User)this.getSession().getAttribute("userInfo");
			if (u == null) {
				throw new Exception("未查询到登录信息，请登录");
			}
			if (u.getIsAdmin().equals("n")) {
				throw new Exception("401 权限不足");
			}
			page = users();
		} catch (Exception e) {
			e.printStackTrace();
			page = users();
			page.addObject("errorMessage", e.getMessage());
		}
		return page;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView update(String id) {
		ModelAndView page = null;
		try {
			User u = (User)this.getSession().getAttribute("userInfo");
			if (u == null) {
				throw new Exception("未查询到登录信息，请登录");
			}
			if (u.getIsAdmin().equals("n")) {
				throw new Exception("401 权限不足");
			}
			User user = userService.get(id);
			if (user == null) {
				throw new Exception("用户不存在");
			}
			if (user.getIsAdmin().equals("y")) {
				user.setIsAdmin("n");
			}else {
				user.setIsAdmin("y");
			}
			userService.update(user);
			page = users();
		} catch (Exception e) {
			e.printStackTrace();
			page = users();
			page.addObject("errorMessage", e.getMessage());
		}
		return page;
	}

}
