package zxl.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import zxl.dao.IBookDao;
import zxl.modals.Book;
import zxl.service.IBookService;
import zxl.tools.RequestUtils;

@Service
public class BookServiceImpl implements IBookService {
	
	@Autowired
	private IBookDao bookDao;

	@Override
	public Book save(Book book) throws Exception {
		return bookDao.save(book);
	}

	@Override
	public Book update(Book book) throws Exception {
		return null;
	}

	@Override
	public void delete(Book book) throws Exception {
		bookDao.delete(book);
	}

	@Override
	public Collection<Book> get(Book book) throws Exception {
		return bookDao.get(book);
	}

	@Override
	public Book get(String id) throws Exception {
		return bookDao.getById(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> search(String keyword, Integer start, Integer count) throws Exception {
		String url = "https://api.douban.com/v2/book/search?q=" + keyword + "&start=" + start + "&count=" + count;
		String responseStr = RequestUtils.doGet(url);
		GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
		Map<String, Object> responseMap = gson.fromJson(responseStr, new TypeToken<HashMap<String,Object>>(){}.getType());
		if (responseMap.get("start") == null) {
			throw new Exception("查询失败了，请稍后再试一次。");
		}
		Integer s = ((Double)responseMap.get("start")).intValue();
		Integer c = ((Double)responseMap.get("count")).intValue();
		Integer total = ((Double)responseMap.get("total")).intValue();
		List<Object> bookObjs = (ArrayList<Object>)responseMap.get("books");
		List<Book> books = new ArrayList<>();
		for (Object obj: bookObjs) {
			Map<String, Object> bookMap = (Map<String, Object>)obj;
			Book book = new Book();
			book.setDoubanId((String)bookMap.get("id"));
			book.setAlt((String)bookMap.get("alt"));
			List<String> authors = (ArrayList<String>)bookMap.get("author");
			StringBuilder author = new StringBuilder("作者暂无");
			if (!authors.isEmpty()) {
				author = new StringBuilder();
				for (int i = 0; i<authors.size(); i++) {
					if (i != authors.size() - 1 && authors.get(i).trim().length() > 0) {
						author.append(authors.get(i)).append(", ");
					} else {
						author.append(authors.get(i));
					}
				}
			}
			book.setAuthor(author.toString());
			book.setAuthor_intro((String)bookMap.get("author_intro"));
			book.setBinding((String)bookMap.get("binding"));
			book.setCatalog((String)bookMap.get("catalog"));
			book.setCreateTimestamp(new Date().getTime());
			book.setEbook_price((String)bookMap.get("ebook_price"));
			book.setEbook_url((String)bookMap.get("ebook_url"));
			book.setId(UUID.randomUUID().toString());
			book.setImage((String)bookMap.get("image"));
			book.setIsbn10((String)bookMap.get("isbn10"));
			book.setIsbn13((String)bookMap.get("isbn13"));
			book.setOrigin_title((String)bookMap.get("origin_title"));
			book.setPages((String)bookMap.get("pages"));
			book.setPrice((String)bookMap.get("price"));
			book.setPubdate((String)bookMap.get("pubdate"));
			book.setPublisher((String)bookMap.get("publisher"));
			book.setSubtitle((String)bookMap.get("subtitle"));
			book.setSummary((String)bookMap.get("summary"));
			List<Object> tagStrs = (ArrayList<Object>)bookMap.get("tags");
			StringBuilder tags = new StringBuilder();
			for (int i=0; i<tagStrs.size(); i++) {
				Map<String, Object> tagMap = (Map<String, Object>)tagStrs.get(i);
				if (i != tagStrs.size() - 1) {
					tags.append(tagMap.get("name")).append(", ");
				} else {
					tags.append(tagMap.get("name"));
				}
			}
			book.setTags(tags.toString());
			book.setTitle((String)bookMap.get("title"));
			List<String> translators = (ArrayList<String>)bookMap.get("translator");
			StringBuilder translator = new StringBuilder("译者暂无");
			if (!translators.isEmpty()) {
				translator = new StringBuilder();
				for (int i = 0; i<translators.size(); i++) {
					if (i != translators.size() - 1 && translators.get(i).trim().length() > 0) {
						translator.append(translators.get(i)).append(", ");
					} else {
						translator.append(translators.get(i));
					}
				}
			}
			book.setTranslator(translator.toString());
			books.add(book);
		}
		for (Book book: books) {
			Book exist = bookDao.getByDoubanId(book.getDoubanId());
			if (exist != null) continue;
			bookDao.save(book);
		}
		Map<String, Object> result = new HashMap<>();
		result.put("start", s);
		result.put("count", c);
		result.put("total", total);
		result.put("books", books);
		return result;
	}

	@Override
	public Map<String, Object> getPage(Integer start, Integer count, Book book) throws Exception {
		Collection<Book> books = bookDao.getPage(start, count, book);
		Integer size = bookDao.get(book).size();
		Map<String, Object> result = new HashMap<>();
		result.put("books", books);
		result.put("total", size);
		return result;
	}

}
