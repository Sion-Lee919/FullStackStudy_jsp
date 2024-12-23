package mvc;

public class BoardDTO {
	int number;
	String title ;
	String contents ;
	int pw ;
	String writer;
	int viewcount=0;
	String writingtime;
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public int getPw() {
		return pw;
	}
	public void setPw(int pw) {
		this.pw = pw;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getViewcount() {
		return viewcount;
	}
	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}
	public String getWritingtime() {
		return writingtime;
	}
	public void setWritingtime(String writingtime) {
		this.writingtime = writingtime;
	}
	public BoardDTO(int number, String title, String contents, int pw, String writer, int viewcount,
			String writingtime) {
		super();
		this.number = number;
		this.title = title;
		this.contents = contents;
		this.pw = pw;
		this.writer = writer;
		this.viewcount = viewcount;
		this.writingtime = writingtime;
	}
	public BoardDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "BoardDTO [number=" + number + ", title=" + title + ", contents=" + contents + ", pw=" + pw + ", writer="
				+ writer + ", viewcount=" + viewcount + ", writingtime=" + writingtime + "]";
	}

	
	
}
