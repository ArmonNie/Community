package bean;

public class History {
	
	private int historyid;
	private String historynumber;
	private String historytime;
	private String historyfilenumber;
	private String historyusernumber;
	
	/*
	 * Getter and Setter
	 */
	public int getHistoryid() {
		return historyid;
	}
	public void setHistoryid(int historyid) {
		this.historyid = historyid;
	}
	public String getHistorynumber() {
		return historynumber;
	}
	public void setHistorynumber(String historynumber) {
		this.historynumber = historynumber;
	}
	public String getHistorytime() {
		return historytime;
	}
	public void setHistorytime(String historytime) {
		this.historytime = historytime;
	}
	public String getHistoryfilenumber() {
		return historyfilenumber;
	}
	public void setHistoryfilenumber(String historyfilenumber) {
		this.historyfilenumber = historyfilenumber;
	}
	public String getHistoryusernumber() {
		return historyusernumber;
	}
	public void setHistoryusernumber(String historyusernumber) {
		this.historyusernumber = historyusernumber;
	}
	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "historynumber" + this.historynumber + "\nfilenumber" + this.historyfilenumber 
				+ "\nusernumber" + this.historyusernumber + "\ntime" + this.historytime;
	}

}
