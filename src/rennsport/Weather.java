package rennsport;

import java.time.LocalDate;
import java.time.LocalTime;

public class Weather {
	public LocalDate addDate = LocalDate.now();
	public LocalTime addTime = LocalTime.now();
	private double airTemparatur;
	private double trackTemparatur;
	private String trackVerhaeltnis;
	
	public Weather(double airTemparatur, double trackTemparatur, String trackVerhaeltnis) {		
		this.airTemparatur = airTemparatur;
		this.trackTemparatur = trackTemparatur;
		this.trackVerhaeltnis = trackVerhaeltnis;
		
	}
	
	public double getAirTemparatur() {
		return airTemparatur;
	}
	
	public void setAirTemparatur(float airTemparatur) {
		this.airTemparatur = airTemparatur;
	}
	
	public double getTrackTemparatur() {
		return trackTemparatur;
	}
	
	public void setTrackTemparatur(float trackTemparatur) {
		this.trackTemparatur = trackTemparatur;
	}
	
	public String getTrackVerhaeltnis() {
		return trackVerhaeltnis;
	}
	
	public void setTrackVerhaeltnis(String trackVerhaeltnis) {
		this.trackVerhaeltnis = trackVerhaeltnis;
	}
	
}
