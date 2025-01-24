package Example1;

public class MemberDto {
	private int mno;
	private String mname;
	private String mphone;
	private String maddr;
	private String mdate;
	private String mgrade;
	private String mcity;
	
	public MemberDto() {}

	public MemberDto(int mno, String mname, String mphone, String maddr, String mdate, String mgrade, String mcity) {
		super();
		this.mno = mno;
		this.mname = mname;
		this.mphone = mphone;
		this.maddr = maddr;
		this.mdate = mdate;
		this.mgrade = mgrade;
		this.mcity = mcity;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMphone() {
		return mphone;
	}

	public void setMphone(String mphone) {
		this.mphone = mphone;
	}

	public String getMaddr() {
		return maddr;
	}

	public void setMaddr(String maddr) {
		this.maddr = maddr;
	}

	public String getMdate() {
		return mdate;
	}

	public void setMdate(String mdate) {
		this.mdate = mdate;
	}

	public String getMgrade() {
		return mgrade;
	}

	public void setMgrade(String mgrade) {
		this.mgrade = mgrade;
	}

	public String getMcity() {
		return mcity;
	}

	public void setMcity(String mcity) {
		this.mcity = mcity;
	}

	@Override
	public String toString() {
		return "MemberDto [mno=" + mno + ", mname=" + mname + ", mphone=" + mphone + ", maddr=" + maddr + ", mdate="
				+ mdate + ", mgrade=" + mgrade + ", mcity=" + mcity + "]";
	}
	
	
	
}
