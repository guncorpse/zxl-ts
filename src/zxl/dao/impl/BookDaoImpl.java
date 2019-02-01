package zxl.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Repository;

import zxl.dao.IBookDao;
import zxl.modals.Book;

@Repository
public class BookDaoImpl extends BaseDao implements IBookDao {
	
	static final String tableName = "zxl_ts_book";
	
	static final String[] columns = {"ID", "DOUBAN_ID", "TITLE", "SUBTITLE", "AUTHOR", "PUBDATE", "TRANSLATOR",
			"CATALOG", "EBOOK_URL", "ORIGIN_TITLE", "IMAGE", "PAGES", "ALT", "PUBLISHER",
			"ISBN10", "ISBN13", "AUTHOR_INTRO", "SUMMARY", "EBOOK_PRICE", "PRICE", "BINDING",
			"TAGS", "CREATE_TIMESTAMP"};

	@Override
	public Book save(Book book) throws Exception {
		PreparedStatement state = null;
		try {
			StringBuilder sql = this.insertSQL(tableName, columns);
			state = this.getPreparedStmt(sql.toString());
			state.setString(1, book.getId());
			state.setString(2, book.getDoubanId());
			state.setString(3, book.getTitle());
			state.setString(4, book.getSubtitle());
			state.setString(5, book.getAuthor());
			state.setString(6, book.getPubdate());
			state.setString(7, book.getTranslator());
			state.setString(8, book.getCatalog());
			state.setString(9, book.getEbook_url());
			state.setString(10, book.getOrigin_title());
			state.setString(11, book.getImage());
			state.setString(12, book.getPages());
			state.setString(13, book.getAlt());
			state.setString(14, book.getPublisher());
			state.setString(15, book.getIsbn10());
			state.setString(16, book.getIsbn13());
			state.setString(17, book.getAuthor_intro());
			state.setString(18, book.getSummary());
			state.setString(19, book.getEbook_price());
			state.setString(20, book.getPrice());
			state.setString(21, book.getBinding());
			state.setString(22, book.getTags());
			state.setLong(23, book.getCreateTimestamp());
			state.executeUpdate();
			return this.getById(book.getId());
		} catch (Exception e) {
			throw new Exception("书籍保存错误:"+e.getMessage());
		} finally {
			if (state != null) {
				state.getConnection().close();
				state.close();
			}
		}
	}

	@Override
	public void delete(Book book) throws Exception {
		PreparedStatement state = null;
		try {
			StringBuilder sql = this.deleteSql(tableName);
			sql.append(" AND ID = '" + book.getId() + "'");
			state = this.getPreparedStmt(sql.toString());
			state.executeUpdate();
		} catch (Exception e) {
			throw new Exception("书籍删除错误:"+e.getMessage());
		} finally {
			if (state != null) {
				state.getConnection().close();
				state.close();
			}
		}
	}

	@Override
	public Collection<Book> get(Book book) throws Exception {
		PreparedStatement state = null;
		try {
			StringBuilder sql = this.getSql(tableName);
			if (book.getAlt() != null && book.getAlt().trim().length() > 0) {
				sql.append(" AND ALT = '" + book.getAlt() + "'");
			}
			if (book.getAuthor() != null && book.getAuthor().trim().length() > 0) {
				sql.append(" AND AUTHOR = '" + book.getAuthor() + "'");
			}
			if (book.getPubdate() != null && book.getPubdate().trim().length() > 0) {
				sql.append(" AND PUBDATE = '" + book.getPubdate() + "'");
			}
			if (book.getAuthor_intro() != null && book.getAuthor_intro().trim().length() > 0) {
				sql.append(" AND AUTHOR_INTRO = '" + book.getAuthor_intro() + "'");
			}
			if (book.getBinding() != null && book.getBinding().trim().length() > 0) {
				sql.append(" AND BINDING = '" + book.getBinding() + "'");
			}
			if (book.getCatalog() != null && book.getCatalog().trim().length() > 0) {
				sql.append(" AND CATALOG = '" + book.getCatalog() + "'");
			}
			if (book.getDoubanId() != null && book.getDoubanId().trim().length() > 0) {
				sql.append(" AND DOUBAN_ID = '" + book.getDoubanId() + "'");
			}
			if (book.getEbook_price() != null && book.getEbook_price().trim().length() > 0) {
				sql.append(" AND EBOOK_PRICE = '" + book.getEbook_price() + "'");
			}
			if (book.getEbook_url() != null && book.getEbook_url().trim().length() > 0) {
				sql.append(" AND EBOOK_URL = '" + book.getEbook_url() + "'");
			}
			if (book.getId() != null && book.getId().trim().length() > 0) {
				sql.append(" AND ID = '" + book.getId() + "'");
			}
			if (book.getImage() != null && book.getImage().trim().length() > 0) {
				sql.append(" AND IMAGE = '" + book.getImage() + "'");
			}
			if (book.getIsbn10() != null && book.getIsbn10().trim().length() > 0) {
				sql.append(" AND ISBN10 = '" + book.getIsbn10() + "'");
			}
			if (book.getIsbn13() != null && book.getIsbn13().trim().length() > 0) {
				sql.append(" AND ISBN13 = '" + book.getIsbn13() + "'");
			}
			if (book.getOrigin_title() != null && book.getOrigin_title().trim().length() > 0) {
				sql.append(" AND ORIGIN_TITLE = '" + book.getOrigin_title() + "'");
			}
			if (book.getPages() != null && book.getPages().trim().length() > 0) {
				sql.append(" AND PAGES = '" + book.getPages() + "'");
			}
			if (book.getPrice() != null && book.getPrice().trim().length() > 0) {
				sql.append(" AND PRICE = '" + book.getPrice() + "'");
			}
			if (book.getPublisher() != null && book.getPublisher().trim().length() > 0) {
				sql.append(" AND PUBLISHER = '" + book.getPublisher() + "'");
			}
			if (book.getSubtitle() != null && book.getSubtitle().trim().length() > 0) {
				sql.append(" AND SUBTITLE = '" + book.getSubtitle() + "'");
			}
			if (book.getSummary() != null && book.getSummary().trim().length() > 0) {
				sql.append(" AND SUMMARY = '" + book.getSummary() + "'");
			}
			if (book.getTags() != null && book.getTags().trim().length() > 0) {
				sql.append(" AND TAGS = '" + book.getTags() + "'");
			}
			if (book.getTitle() != null && book.getTitle().trim().length() > 0) {
				sql.append(" AND TITLE = '" + book.getTitle() + "'");
			}
			if (book.getTranslator() != null && book.getTranslator().trim().length() > 0) {
				sql.append(" AND TRANSLATOR = '" + book.getTranslator() + "'");
			}
			sql.append(" ORDER BY CREATE_TIMESTAMP DESC ");
			state = this.getPreparedStmt(sql.toString());
			ResultSet rs = state.executeQuery();
			return rsToBook(rs);
		} catch (Exception e) {
			throw new Exception("书籍查询错误:"+e.getMessage());
		} finally {
			if (state != null) {
				state.getConnection().close();
				state.close();
			}
		}
	}

	@Override
	public Book getById(String id) throws Exception {
		PreparedStatement state = null;
		try {
			StringBuilder sql = this.getSql(tableName);
			sql.append(" AND ID = ? ");
			state = this.getPreparedStmt(sql.toString());
			state.setString(1, id);
			ResultSet rs = state.executeQuery();
			return rsToBook(rs).iterator().next();
		} catch (Exception e) {
			throw new Exception("通过ID查询书籍错误:"+e.getMessage());
		} finally {
			if (state != null) {
				state.getConnection().close();
				state.close();
			}
		}
	}
	
	private Collection<Book> rsToBook(ResultSet rs) throws Exception {
		Collection<Book> books = new ArrayList<>();
		while(rs.next()) {
			Book book = new Book();
			book.setAlt(rs.getString("ALT"));
			book.setAuthor(rs.getString("AUTHOR"));
			book.setAuthor_intro(rs.getString("AUTHOR_INTRO"));
			book.setBinding(rs.getString("BINDING"));
			book.setCatalog(rs.getString("CATALOG"));
			book.setDoubanId(rs.getString("DOUBAN_ID"));
			book.setEbook_price(rs.getString("EBOOK_PRICE"));
			book.setEbook_url(rs.getString("EBOOK_URL"));
			book.setId(rs.getString("ID"));
			book.setImage(rs.getString("IMAGE"));
			book.setIsbn10(rs.getString("ISBN10"));
			book.setIsbn13(rs.getString("ISBN13"));
			book.setOrigin_title(rs.getString("ORIGIN_TITLE"));
			book.setPages(rs.getString("PAGES"));
			book.setPrice(rs.getString("PRICE"));
			book.setPublisher(rs.getString("PUBLISHER"));
			book.setSubtitle(rs.getString("SUBTITLE"));
			book.setSummary(rs.getString("SUMMARY"));
			book.setTags(rs.getString("TAGS"));
			book.setTitle(rs.getString("TITLE"));
			book.setTranslator(rs.getString("TRANSLATOR"));
			books.add(book);
		}
		return books;
	}

	@Override
	public Book getByDoubanId(String doubanId) throws Exception {
		PreparedStatement state = null;
		try {
			StringBuilder sql = this.getSql(tableName);
			sql.append(" AND DOUBAN_ID = ? ");
			state = this.getPreparedStmt(sql.toString());
			state.setString(1, doubanId);
			ResultSet rs = state.executeQuery();
			Collection<Book> books = rsToBook(rs);
			if (books.isEmpty()) return null;
			return books.iterator().next();
		} catch (Exception e) {
			throw new Exception("通过豆瓣ID查询书籍错误:"+e.getMessage());
		} finally {
			if (state != null) {
				state.getConnection().close();
				state.close();
			}
		}
	}

	@Override
	public Collection<Book> getPage(Integer start, Integer count, Book book) throws Exception {
		PreparedStatement state = null;
		try {
			StringBuilder sql = this.getSql(tableName);
			if (book.getAlt() != null && book.getAlt().trim().length() > 0) {
				sql.append(" AND ALT = '" + book.getAlt() + "'");
			}
			if (book.getAuthor() != null && book.getAuthor().trim().length() > 0) {
				sql.append(" AND AUTHOR = '" + book.getAuthor() + "'");
			}
			if (book.getPubdate() != null && book.getPubdate().trim().length() > 0) {
				sql.append(" AND PUBDATE = '" + book.getPubdate() + "'");
			}
			if (book.getAuthor_intro() != null && book.getAuthor_intro().trim().length() > 0) {
				sql.append(" AND AUTHOR_INTRO = '" + book.getAuthor_intro() + "'");
			}
			if (book.getBinding() != null && book.getBinding().trim().length() > 0) {
				sql.append(" AND BINDING = '" + book.getBinding() + "'");
			}
			if (book.getCatalog() != null && book.getCatalog().trim().length() > 0) {
				sql.append(" AND CATALOG = '" + book.getCatalog() + "'");
			}
			if (book.getDoubanId() != null && book.getDoubanId().trim().length() > 0) {
				sql.append(" AND DOUBAN_ID = '" + book.getDoubanId() + "'");
			}
			if (book.getEbook_price() != null && book.getEbook_price().trim().length() > 0) {
				sql.append(" AND EBOOK_PRICE = '" + book.getEbook_price() + "'");
			}
			if (book.getEbook_url() != null && book.getEbook_url().trim().length() > 0) {
				sql.append(" AND EBOOK_URL = '" + book.getEbook_url() + "'");
			}
			if (book.getId() != null && book.getId().trim().length() > 0) {
				sql.append(" AND ID = '" + book.getId() + "'");
			}
			if (book.getImage() != null && book.getImage().trim().length() > 0) {
				sql.append(" AND IMAGE = '" + book.getImage() + "'");
			}
			if (book.getIsbn10() != null && book.getIsbn10().trim().length() > 0) {
				sql.append(" AND ISBN10 = '" + book.getIsbn10() + "'");
			}
			if (book.getIsbn13() != null && book.getIsbn13().trim().length() > 0) {
				sql.append(" AND ISBN13 = '" + book.getIsbn13() + "'");
			}
			if (book.getOrigin_title() != null && book.getOrigin_title().trim().length() > 0) {
				sql.append(" AND ORIGIN_TITLE = '" + book.getOrigin_title() + "'");
			}
			if (book.getPages() != null && book.getPages().trim().length() > 0) {
				sql.append(" AND PAGES = '" + book.getPages() + "'");
			}
			if (book.getPrice() != null && book.getPrice().trim().length() > 0) {
				sql.append(" AND PRICE = '" + book.getPrice() + "'");
			}
			if (book.getPublisher() != null && book.getPublisher().trim().length() > 0) {
				sql.append(" AND PUBLISHER = '" + book.getPublisher() + "'");
			}
			if (book.getSubtitle() != null && book.getSubtitle().trim().length() > 0) {
				sql.append(" AND SUBTITLE = '" + book.getSubtitle() + "'");
			}
			if (book.getSummary() != null && book.getSummary().trim().length() > 0) {
				sql.append(" AND SUMMARY = '" + book.getSummary() + "'");
			}
			if (book.getTags() != null && book.getTags().trim().length() > 0) {
				sql.append(" AND TAGS = '" + book.getTags() + "'");
			}
			if (book.getTitle() != null && book.getTitle().trim().length() > 0) {
				sql.append(" AND TITLE = '" + book.getTitle() + "'");
			}
			if (book.getTranslator() != null && book.getTranslator().trim().length() > 0) {
				sql.append(" AND TRANSLATOR = '" + book.getTranslator() + "'");
			}
			sql.append(" ORDER BY CREATE_TIMESTAMP DESC ");
			sql.append(" LIMIT ").append(start).append(",").append(count);
			System.out.println(sql.toString());
			state = this.getPreparedStmt(sql.toString());
			ResultSet rs = state.executeQuery();
			return rsToBook(rs);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("书籍查询错误:"+e.getMessage());
		} finally {
			if (state != null) {
				state.getConnection().close();
				state.close();
			}
		}
	}

}
