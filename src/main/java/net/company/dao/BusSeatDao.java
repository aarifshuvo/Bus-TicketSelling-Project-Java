package main.java.net.company.dao;

public interface BusSeatDao {

	public void showSeatsByCoachNumber();
	public boolean reserveSeatofCoachNumber();
	public void cancelTicketBySeatNo();
	
}
