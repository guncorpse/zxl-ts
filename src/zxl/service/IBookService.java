package zxl.service;

import java.util.Collection;
import java.util.Map;

import zxl.modals.Book;

public interface IBookService {
	
	public Book save(Book book) throws Exception;
	
	public Book update(Book book) throws Exception;
	
	public void delete(Book book) throws Exception;
	
	public Collection<Book> get(Book book) throws Exception;
	
	public Book get(String id) throws Exception;
	
	public Map<String, Object> getPage(Integer start, Integer count, Book book) throws Exception;
	
	public Map<String, Object> search(String keyword, Integer start, Integer count) throws Exception;

}
