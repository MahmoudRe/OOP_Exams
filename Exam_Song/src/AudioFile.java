
/**
 * This class implements a simple Audio File to be inherit later on.
 * @author Mahmoud
 * @version 1.0
 * 
 */
public class AudioFile {
	
	private int min;
	private int sec;
	String length;
	
	/**
	 * This contracts a AudioFile object with a specified minutes and seconds length
	 * @param min the minutes of the length of this audio file
	 * @param sec the seconds of the length of this audio file
	 */
	public AudioFile (int min, int sec) {
		this.setMin(min);
		this.setSec(sec);
		length = min + ":" + sec;
	}
	
	
	/**
	 * This method set the length of the audio file simply by 
	 * implementing it with the minutes and the seconds of its length 
	 * @param min the minutes of the length of this audio file
	 * @param sec the seconds of the length of this audio file
	 */
	public void setLength(int min, int sec) {
		this.setMin(min);
		this.setSec(sec);
		this.length = min + ":" + sec;
	}
	
	/**
	 * get the length of this sound clip as a String consist of min:sec 
	 * @return the length of this audio file
	 */
	public String getLength() {
		return length;
	}


	public int getMin() {
		return min;
	}


	public void setMin(int min) {
		this.min = min;
	}


	public int getSec() {
		return sec;
	}


	public void setSec(int sec) {
		this.sec = sec;
	}
	
	
}
