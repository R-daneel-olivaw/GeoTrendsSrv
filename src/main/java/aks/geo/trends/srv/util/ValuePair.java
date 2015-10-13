package aks.geo.trends.srv.util;

public class ValuePair {

	private String firstValue;
	private String secondValue;
	
	public ValuePair (String first, String second)
	{
		firstValue = first;
		secondValue = second;
	}

	public String getFirstValue() {
		return firstValue;
	}

	public void setFirstValue(String firstValue) {
		this.firstValue = firstValue;
	}

	public String getSecondValue() {
		return secondValue;
	}

	public void setSecondValue(String secondValue) {
		this.secondValue = secondValue;
	}

}
