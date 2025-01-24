package parking0123;

public class ParkingDto {
	private int num;
	private int clot;
	private String cnum;
	private String time;
	private boolean state;
	private int money;
	
	public ParkingDto() {}

	public ParkingDto(int num, int clot, String cnum, String time, boolean state, int money) {
		super();
		this.num = num;
		this.clot = clot;
		this.cnum = cnum;
		this.time = time;
		this.state = state;
		this.money = money;
	}

	@Override
	public String toString() {
		return "ParkingDto [num=" + num + ", clot=" + clot + ", cnum=" + cnum + ", time=" + time + ", state=" + state
				+ ", money=" + money + "]";
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getClot() {
		return clot;
	}

	public void setClot(int clot) {
		this.clot = clot;
	}

	public String getCnum() {
		return cnum;
	}

	public void setCnum(String cnum) {
		this.cnum = cnum;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
}
