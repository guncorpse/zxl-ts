package zxl.modals;

public class Book {
	
	private String id;
	private String doubanId;
	private String title;
	private String subtitle;
	private String author;
	private String pubdate;
	private String translator;
	private String catalog;
	private String ebook_url;
	private String origin_title;
	private String image;
	private String pages;
	private String alt;
	private String publisher;
	private String isbn10;
	private String isbn13;
	private String author_intro;
	private String summary;
	private String ebook_price;
	private String price;
	private String binding;
	private String tags;
	private Long createTimestamp;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDoubanId() {
		return doubanId;
	}
	public void setDoubanId(String doubanId) {
		this.doubanId = doubanId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPubdate() {
		return pubdate;
	}
	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}
	public String getTranslator() {
		return translator;
	}
	public void setTranslator(String translator) {
		this.translator = translator;
	}
	public String getCatalog() {
		return catalog;
	}
	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}
	public String getEbook_url() {
		return ebook_url;
	}
	public void setEbook_url(String ebook_url) {
		this.ebook_url = ebook_url;
	}
	public String getOrigin_title() {
		return origin_title;
	}
	public void setOrigin_title(String origin_title) {
		this.origin_title = origin_title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getPages() {
		return pages;
	}
	public void setPages(String pages) {
		this.pages = pages;
	}
	public String getAlt() {
		return alt;
	}
	public void setAlt(String alt) {
		this.alt = alt;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getIsbn10() {
		return isbn10;
	}
	public void setIsbn10(String isbn10) {
		this.isbn10 = isbn10;
	}
	public String getIsbn13() {
		return isbn13;
	}
	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}
	public String getAuthor_intro() {
		return author_intro;
	}
	public void setAuthor_intro(String author_intro) {
		this.author_intro = author_intro;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getEbook_price() {
		return ebook_price;
	}
	public void setEbook_price(String ebook_price) {
		this.ebook_price = ebook_price;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getBinding() {
		return binding;
	}
	public void setBinding(String binding) {
		this.binding = binding;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public Long getCreateTimestamp() {
		return createTimestamp;
	}
	public void setCreateTimestamp(Long createTimestamp) {
		this.createTimestamp = createTimestamp;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alt == null) ? 0 : alt.hashCode());
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((author_intro == null) ? 0 : author_intro.hashCode());
		result = prime * result + ((binding == null) ? 0 : binding.hashCode());
		result = prime * result + ((catalog == null) ? 0 : catalog.hashCode());
		result = prime * result + ((createTimestamp == null) ? 0 : createTimestamp.hashCode());
		result = prime * result + ((doubanId == null) ? 0 : doubanId.hashCode());
		result = prime * result + ((ebook_price == null) ? 0 : ebook_price.hashCode());
		result = prime * result + ((ebook_url == null) ? 0 : ebook_url.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((isbn10 == null) ? 0 : isbn10.hashCode());
		result = prime * result + ((isbn13 == null) ? 0 : isbn13.hashCode());
		result = prime * result + ((origin_title == null) ? 0 : origin_title.hashCode());
		result = prime * result + ((pages == null) ? 0 : pages.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((pubdate == null) ? 0 : pubdate.hashCode());
		result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
		result = prime * result + ((subtitle == null) ? 0 : subtitle.hashCode());
		result = prime * result + ((summary == null) ? 0 : summary.hashCode());
		result = prime * result + ((tags == null) ? 0 : tags.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((translator == null) ? 0 : translator.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (alt == null) {
			if (other.alt != null)
				return false;
		} else if (!alt.equals(other.alt))
			return false;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (author_intro == null) {
			if (other.author_intro != null)
				return false;
		} else if (!author_intro.equals(other.author_intro))
			return false;
		if (binding == null) {
			if (other.binding != null)
				return false;
		} else if (!binding.equals(other.binding))
			return false;
		if (catalog == null) {
			if (other.catalog != null)
				return false;
		} else if (!catalog.equals(other.catalog))
			return false;
		if (createTimestamp == null) {
			if (other.createTimestamp != null)
				return false;
		} else if (!createTimestamp.equals(other.createTimestamp))
			return false;
		if (doubanId == null) {
			if (other.doubanId != null)
				return false;
		} else if (!doubanId.equals(other.doubanId))
			return false;
		if (ebook_price == null) {
			if (other.ebook_price != null)
				return false;
		} else if (!ebook_price.equals(other.ebook_price))
			return false;
		if (ebook_url == null) {
			if (other.ebook_url != null)
				return false;
		} else if (!ebook_url.equals(other.ebook_url))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (isbn10 == null) {
			if (other.isbn10 != null)
				return false;
		} else if (!isbn10.equals(other.isbn10))
			return false;
		if (isbn13 == null) {
			if (other.isbn13 != null)
				return false;
		} else if (!isbn13.equals(other.isbn13))
			return false;
		if (origin_title == null) {
			if (other.origin_title != null)
				return false;
		} else if (!origin_title.equals(other.origin_title))
			return false;
		if (pages == null) {
			if (other.pages != null)
				return false;
		} else if (!pages.equals(other.pages))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (pubdate == null) {
			if (other.pubdate != null)
				return false;
		} else if (!pubdate.equals(other.pubdate))
			return false;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		if (subtitle == null) {
			if (other.subtitle != null)
				return false;
		} else if (!subtitle.equals(other.subtitle))
			return false;
		if (summary == null) {
			if (other.summary != null)
				return false;
		} else if (!summary.equals(other.summary))
			return false;
		if (tags == null) {
			if (other.tags != null)
				return false;
		} else if (!tags.equals(other.tags))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (translator == null) {
			if (other.translator != null)
				return false;
		} else if (!translator.equals(other.translator))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", doubanId=" + doubanId + ", title=" + title + ", subtitle=" + subtitle + ", author="
				+ author + ", pubdate=" + pubdate + ", translator=" + translator + ", catalog=" + catalog
				+ ", ebook_url=" + ebook_url + ", origin_title=" + origin_title + ", image=" + image + ", pages="
				+ pages + ", alt=" + alt + ", publisher=" + publisher + ", isbn10=" + isbn10 + ", isbn13=" + isbn13
				+ ", author_intro=" + author_intro + ", summary=" + summary + ", ebook_price=" + ebook_price
				+ ", price=" + price + ", binding=" + binding + ", tags=" + tags + ", createTimestamp="
				+ createTimestamp + "]";
	}
	
	
	
	
	
	
	

}
