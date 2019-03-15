package zxl.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import zxl.modals.Book;
import zxl.modals.Favorite;
import zxl.modals.User;
import zxl.service.IBookService;
import zxl.service.IFavoriteService;
import zxl.service.IUserService;

@Controller
public class BookController extends BaseController {
	
	@Autowired
	private IBookService bookService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IFavoriteService favoriteService;
	
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView get(Integer pagen, Integer count, Book book) {
		ModelAndView page = this.createView("/index.ftl");
		try {
			if (pagen == null) pagen = 1;
			if (count == null) count = 24;
			Integer start = (pagen - 1) * 24 + 1;
			page.addObject("pageName", "index");
			page.addObject("pagen", pagen);
			page.addObject("count", count);
			Integer total = 0;
			page.addObject("total", total);
			page.addObject("books", Collections.emptyList());
			User user = (User)this.getSession().getAttribute("userInfo");
			Map<String, Object> result = bookService.getPage(start, count, book, user);
			if (result.get("total") != null) {
				total = (Integer)result.get("total");
			}
			page.addObject("total", total);
			page.addObject("books", (ArrayList<?>)result.get("books"));
			page.addObject("users", userService.get(new User()));
			//page.addObject("userSize", userService.get(new User()).size());
		} catch (Exception e) {
			page.addObject("errorMessage", e.getMessage());
			page.addObject("users", Collections.emptyList());
		}
		return page;
	}
	
	@RequestMapping(value = "search", method = RequestMethod.GET)
	public ModelAndView search(String keyword, Integer pagen, Integer count) {
		ModelAndView page = this.createView("/result.ftl");
		try {
			if (pagen == null) pagen = 1;
			if (count == null) count = 24;
			Integer start = (pagen - 1) * 24 + 1;
			page.addObject("pageName", "search");
			page.addObject("keyword", keyword);
			page.addObject("pagen", pagen);
			page.addObject("count", count);
			Integer total = 0;
			page.addObject("total", total);
			page.addObject("books", Collections.emptyList());
			if (StringUtils.isEmpty(keyword)) {
				throw new Exception("请输入关键字，再次查询");
			}
			Map<String, Object> result = bookService.search(keyword, start, count);
			if (result.get("total") != null) {
				total = (Integer)result.get("total");
			}
			page.addObject("total", total);
			page.addObject("books", (ArrayList<?>)result.get("books"));
		} catch (Exception e) {
			e.printStackTrace();
			page.addObject("errorMessage", e.getMessage());
		}
		return page;
	}
	
	@RequestMapping(value = "book/delete", method = RequestMethod.GET)
	public ModelAndView delete(Book book) {
		ModelAndView page = null;
		try {
			bookService.delete(book);
			page = this.get(null, null, new Book());
		} catch (Exception e) {
			e.printStackTrace();
			page = this.get(null, null, new Book());
			page.addObject("errorMessage", e.getMessage());
		}
		return page;
	}
	
	@RequestMapping(value = "favorite/{id}", method = RequestMethod.GET)
	public ModelAndView favorite(@PathVariable String id) {
		ModelAndView page = this.createView("/favorite.ftl");
		try {
			Favorite favorite = new Favorite();
			favorite.setUserId(id);
			Collection<Favorite> favorites = favoriteService.get(favorite);
			page.addObject("favorites", favorites);
		} catch (Exception e) {
			e.printStackTrace();
			page.addObject("errorMessage", e.getMessage());
		}
		return page;
	}
	
	@RequestMapping(value = "addfavorite/{id}", method = RequestMethod.GET)
	public ModelAndView addfavorite(Integer pagen, Integer count, @PathVariable String id) {
		ModelAndView page = null;
		try {
			User user = (User)this.getSession().getAttribute("userInfo");
			if (user == null) {
				throw new Exception("未查询到登录信息，请登录");
			}
			Favorite favorite = new Favorite();
			Book book = this.bookService.get(id);
			favorite.setBookId(book.getId());
			favorite.setUserId(user.getId());
			Collection<Favorite> exists = this.favoriteService.get(favorite);
			if (!exists.isEmpty()) {
				throw new Exception("此书已经收藏");
			}
			favorite.setBookAlt(book.getAlt());
			favorite.setBookAuthor(book.getAuthor());
			favorite.setBookImage(book.getImage());
			favorite.setBookTitle(book.getTitle());
			favorite.setUserName(user.getName());
			favorite = this.favoriteService.save(favorite);
			page = get(pagen, count, new Book());
		} catch (Exception e) {
			e.printStackTrace();
			page = get(pagen, count, new Book());
			page.addObject("errorMessage", e.getMessage());
		}
		return page;
	}
	
	@RequestMapping(value = "favorite/delete", method = RequestMethod.GET)
	public ModelAndView deletefavorite(Favorite favorite) {
		ModelAndView page = null;
		try {
			this.favoriteService.delete(favorite);
			User user = (User)this.getSession().getAttribute("userInfo");
			if (user == null) {
				throw new Exception("未查询到登录信息，请登录");
			}
			page = favorite(user.getId());
		} catch (Exception e) {
			e.printStackTrace();
			page.addObject("errorMessage", e.getMessage());
		}
		return page;
	}
	
}
