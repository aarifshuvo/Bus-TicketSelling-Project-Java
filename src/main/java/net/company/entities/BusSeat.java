package main.java.net.company.entities;

public class BusSeat extends Passenger{

	private int seat_no;
	private Passenger passenger; 
	
	public BusSeat()
	{
		passenger = new Passenger();
	}

	public void book(int sid)
	{
		this.seat_no = sid;
		this.passenger.setPassenger();
	}
	
	public int getSeat_no() {
		return seat_no;
	}

	public void setSeat_no(int seat_no) {
		this.seat_no = seat_no;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

}
 