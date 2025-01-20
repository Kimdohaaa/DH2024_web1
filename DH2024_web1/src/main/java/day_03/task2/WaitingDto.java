package day_03.task2;

public class WaitingDto {
	private String tel;
	private int count;
	
	public WaitingDto () {}

	public WaitingDto(String tel, int count) {
		super();
		this.tel = tel;
		this.count = count;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "WaitingDto [tel=" + tel + ", count=" + count + "]";
	}
	
}
