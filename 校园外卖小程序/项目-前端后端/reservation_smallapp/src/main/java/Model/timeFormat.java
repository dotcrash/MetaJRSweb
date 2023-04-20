package Model;

public class timeFormat {
	/*
	 * public timeFormat() { // TODO Auto-generated constructor stub }
	 */
	public float timeformat(String time) {
		float timetoInt=0;
		String[] stringArr=time.split(":|-");
		timetoInt=Integer.valueOf(stringArr[0]);
		if (stringArr[1].equals("30")) {
			timetoInt+=0.5;
		}		
		
		return timetoInt;
	}
}
