package day_05;

public class BoardDto {
	private int bno ;
	private String bTitle;
	private String bContent;
	private String bWriter;
	private String bPwd;
	private int bView;
	private String bDate;
	
	public BoardDto(){}

	public BoardDto(int bno, String bTitle, String bContent, String bWriter, String bPwd, int bView, String bDate) {
		super();
		this.bno = bno;
		this.bTitle = bTitle;
		this.bContent = bContent;
		this.bWriter = bWriter;
		this.bPwd = bPwd;
		this.bView = bView;
		this.bDate = bDate;
	}

	
	public BoardDto(String bTitle, String bContent, String bWriter, String bPwd) {
		super();
		this.bTitle = bTitle;
		this.bContent = bContent;
		this.bWriter = bWriter;
		this.bPwd = bPwd;
	}

	public BoardDto(int bno, String bTitle, String bContent) {
		super();
		this.bno = bno;
		this.bTitle = bTitle;
		this.bContent = bContent;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getbContent() {
		return bContent;
	}

	public void setbContent(String bContent) {
		this.bContent = bContent;
	}

	public String getbWriter() {
		return bWriter;
	}

	public void setbWriter(String bWriter) {
		this.bWriter = bWriter;
	}

	public String getbPwd() {
		return bPwd;
	}

	public void setbPwd(String bPwd) {
		this.bPwd = bPwd;
	}

	public int getbView() {
		return bView;
	}

	public void setbView(int bView) {
		this.bView = bView;
	}

	
	public String getbDate() {
		return bDate;
	}

	public void setbDate(String bDate) {
		this.bDate = bDate;
	}

	@Override
	public String toString() {
		return "BoardDto [bno=" + bno + ", bTitle=" + bTitle + ", bContent=" + bContent + ", bWriter=" + bWriter
				+ ", bPwd=" + bPwd + ", bView=" + bView + ", bDate=" + bDate + "]";
	}

	
	
	
	
}
