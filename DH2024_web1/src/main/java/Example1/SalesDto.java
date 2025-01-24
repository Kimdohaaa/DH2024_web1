package Example1;

public class SalesDto {
	private int sno;
	private int scost;
	private int scount;
	private int sprice;
	private String scode;
	private String sdate;
	private int mno;
	
	public SalesDto() {}

	public SalesDto(int sno, int scost, int scount, int sprice, String scode, String sdate, int mno) {
		super();
		this.sno = sno;
		this.scost = scost;
		this.scount = scount;
		this.sprice = sprice;
		this.scode = scode;
		this.sdate = sdate;
		this.mno = mno;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public int getScost() {
		return scost;
	}

	public void setScost(int scost) {
		this.scost = scost;
	}

	public int getScount() {
		return scount;
	}

	public void setScount(int scount) {
		this.scount = scount;
	}

	public int getSprice() {
		return sprice;
	}

	public void setSprice(int sprice) {
		this.sprice = sprice;
	}

	public String getScode() {
		return scode;
	}

	public void setScode(String scode) {
		this.scode = scode;
	}

	public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	@Override
	public String toString() {
		return "SalesDto [sno=" + sno + ", scost=" + scost + ", scount=" + scount + ", sprice=" + sprice + ", scode="
				+ scode + ", sdate=" + sdate + ", mno=" + mno + "]";
	}
	
	
}
