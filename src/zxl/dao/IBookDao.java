package zxl.dao;

import java.util.Collection;

import zxl.modals.Book;

public interface IBookDao {
	
	public Book save(Book book) throws Exception;
	
	public void delete(Book book)  throws Exception;
	
	public Collection<Book> get(Book book)  throws Exception;
	
	public Collection<Book> getPage(Integer start, Integer count, Book book)  throws Exception;
	
	public Book getById(String id) throws Exception;
	
	public Book getByDoubanId(String doubanId) throws Exception;

}
