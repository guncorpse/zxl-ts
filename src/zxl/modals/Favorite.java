package zxl.modals;

public class Favorite {
	
	private String id;
	private String userId;
	private String bookId;
	private String bookAlt;
	private String bookAuthor;
	private String userName;
	private String bookTitle;
	private String bookImage;
	private Long scTimestamp;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getBookImage() {
		return bookImage;
	}
	public void setBookImage(String bookImage) {
		this.bookImage = bookImage;
	}
	public Long getScTimestamp() {
		return scTimestamp;
	}
	public void setScTimestamp(Long scTimestamp) {
		this.scTimestamp = scTimestamp;
	}
	
	
	public String getBookAlt() {
		return bookAlt;
	}
	public void setBookAlt(String bookAlt) {
		this.bookAlt = bookAlt;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
		result = prime * result + ((bookImage == null) ? 0 : bookImage.hashCode());
		result = prime * result + ((bookTitle == null) ? 0 : bookTitle.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((scTimestamp == null) ? 0 : scTimestamp.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		Favorite other = (Favorite) obj;
		if (bookId == null) {
			if (other.bookId != null)
				return false;
		} else if (!bookId.equals(other.bookId))
			return false;
		if (bookImage == null) {
			if (other.bookImage != null)
				return false;
		} else if (!bookImage.equals(other.bookImage))
			return false;
		if (bookTitle == null) {
			if (other.bookTitle != null)
				return false;
		} else if (!bookTitle.equals(other.bookTitle))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (scTimestamp == null) {
			if (other.scTimestamp != null)
				return false;
		} else if (!scTimestamp.equals(other.scTimestamp))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Favorite [id=" + id + ", userId=" + userId + ", bookId=" + bookId + ", userName=" + userName
				+ ", bookTitle=" + bookTitle + ", bookImage=" + bookImage + ", scTimestamp=" + scTimestamp + "]";
	}

}
