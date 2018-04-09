/* MULTITHREADING <MyClass.java>
 * EE422C Project 6 submission by
 * Replace <...> with your actual data.
 * Albert Bautista
 * abb2639
 * 15505
 * Slip days used: <0>
 * Spring 2018
 */
package assignment6;

import java.util.List;

public class Theater {
	private int rowNum;
	private int colNum;
	private String showName;

	/*
	 * Represents a seat in the theater A1, A2, A3, ... B1, B2, B3 ... Assume that
	 * seatNum & rowNum starts from 0 and ends at MAX_INT
	 */
	static class Seat {
		private int rowNum;
		private int seatNum;

		public Seat(int rowNum, int seatNum) {
			this.rowNum = rowNum;
			this.seatNum = seatNum;
		}

		public int getSeatNum() {
			return seatNum;
		}

		public int getRowNum() {
			return rowNum;
		}

		/**
		 * Returns the full Seat Location Assumes that seatNum and rowNum are 0-indexed
		 * also that they are both positive
		 */
		@Override
		public String toString() {
			// Implement this method to return the full Seat location ex: A1
			String seatString = Integer.toString(seatNum + 1);
			String rowString = "";
			int rows = rowNum / 26;
			int shift = rowNum % 26;
			for (int i = 0; i < rows; ++i) {
				rowString += "A";
			}
			if (shift >= 0) {
				rowString += (char) ('A' + shift);
			}
			return rowString + seatString;
		}
	}

	/*
	 * Represents a ticket purchased by a client
	 */
	static class Ticket {
		private String show;
		private String boxOfficeId;
		private Seat seat;
		private int client;
		private boolean reserved;

		public Ticket(String show, String boxOfficeId, Seat seat, int client) {
			this.show = show;
			this.boxOfficeId = boxOfficeId;
			this.seat = seat;
			this.client = client;
			reserved = false;
		}

		public Seat getSeat() {
			return seat;
		}

		public String getShow() {
			return show;
		}

		public String getBoxOfficeId() {
			return boxOfficeId;
		}

		public int getClient() {
			return client;
		}

		@Override
		public String toString() {
			// TODO: Implement this method to return a string that resembles a ticket
			String border = "-------------------------------\n";
			String showRow = "| Show: " + show;
			String boxRow = "| Box Office ID: " + boxOfficeId;
			String seatRow = "| Seat: " + seat.toString();
			String clientRow = "| Client: " + Integer.toString(client);

			int spaceLength = border.length() - 2;
			showRow = rowHelper(spaceLength, showRow);
			boxRow = rowHelper(spaceLength, boxRow);
			seatRow = rowHelper(spaceLength, seatRow);
			clientRow = rowHelper(spaceLength, clientRow);
			return border + showRow + boxRow + seatRow + clientRow + border;
		}

		private String rowHelper(int spaceLength, String row) {
			spaceLength -= row.length();
			String endLine = "|\n";
			String ret = row;
			for (int i = 0; i < spaceLength; ++i) {
				ret += " ";
			}
			return ret + endLine;
		}
	}

	public Theater(int numRows, int seatsPerRow, String show) {
		// TODO: Implement this constructor
		rowNum = numRows;
		colNum = seatsPerRow;
		showName = show;
	}

	/*
	 * Calculates the best seat not yet reserved
	 *
	 * @return the best seat or null if theater is full
	 */
	public Seat bestAvailableSeat() {
		// TODO: Implement this method
	}

	/*
	 * Prints a ticket for the client after they reserve a seat Also prints the
	 * ticket to the console
	 *
	 * @param seat a particular seat in the theater
	 * 
	 * @return a ticket or null if a box office failed to reserve the seat
	 */
	public Ticket printTicket(String boxOfficeId, Seat seat, int client) {
		// TODO: Implement this method
		if (seat.equals(bestAvailableSeat())) {
			Ticket t = new Ticket(showName, boxOfficeId, seat, client);
			return t;
		}
		else {
			return null;
		}
	}

	/*
	 * Lists all tickets sold for this theater in order of purchase
	 *
	 * @return list of tickets sold
	 */
	public List<Ticket> getTransactionLog() {
		// TODO: Implement this method
	}
}
