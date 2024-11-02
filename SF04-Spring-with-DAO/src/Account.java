import java.io.Serializable;

public class Account implements Serializable {
	private int accno;
	private String accName;
	private String accType;
	private double bal;

	public Account() {
	}

	public int getAccno() {
		return accno;
	}

	public void setAccno(int accno) {
		this.accno = accno;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public String getAccType() {
		return accType; 	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public double getBal() {
		return bal;
	}

	public void setBal(double bal) {
		this.bal = bal;
	}
}
