package com.uregina.app;

import com.uregina.exceptions.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
/**
 * Class Ticket, a List of Flights in ordered sequences
 */
public class Ticket
{
	
	
	private static final String [] SchengenAirportsCode = new String[] { "VIE","BRU","PRG","CPH","TLL","HEL","CDG","FRA","MUC","ATH","BUD","KEF","CIA","RIX","VNO","LUX","MLA","AMS","OSL","WAW","LIS","LJU","KSC","MAD","ARN","BRN"};
	/**
	 * The function checks the validaity of a ticket
	 * It checks
	 *		1. airports code are in IATA format (any three uppercases letters)
	 *		2. maximum flights Count >= number of flights in the ticket
	 *		3. maximum flight time >= Total flight times ( sum of flight time of each flight)
	 *		4. maximum layover time >= Total layover times ( sum of layover time between each consequative flight)
	 *		5. no flight between two airports in the Schengen area unless the passenger has a valid SchengenVisa
	 *		6. no cyclic trip
	 *		7. The sequence of flights in correct ( the arrival airport of a flight is the departure airport of the next flight)
	 * 		8. any other logical constraints 
	 * @param	ticket				List of ordered sequences of flights
	 * @param	maxFlightsCount		Maximum number of flights in the ticket
	 * @param	maxFlightTime		Maximum allowable total flight times in minutes
	 * @param	maxLayoverTime		Maximum allowable total layover times in minutes
	 * @param	hasSchengenVisa		to indicate if the passenger has a valid Schengen Visa or not
	 * @return	true if the ticket is valid, false otherwise
	 * usefeul functions that you may use
	 * 		(class: Flight , method: getArrivalAirport)
	 * 		(class: Flight , method: getDepatureAirport)
	 * 		(class: Flight , method: calculateFlightTime)
	 * 		(class: Flight , method: calculateLayoverTime)
	 * 		(class: ticket , method: hasCyclicTrip)
	 * @throws NegativeTimeException 
	 * @throws MoreThanOneDayException 
	*/
	public static boolean checkTicket( ArrayList<Flight> ticket, int maxFlightsCount, int maxFlightTime, int maxLayoverTime, boolean hasSchengenVisa) throws MoreThanOneDayException, NegativeTimeException
	{
		//Todo: add your code here
		String departureAirport;
		int totalFlightTime = 0;
		int flightTime = 0;
		int maxFlights = 0;
		int checkDepAirSize = 0;
		int checkDepAirFormat = 0;
		//int totalLayoverTime = 0;
		
		//Code for loop referenced from https://stackoverflow.com/questions/40336374/how-do-i-check-if-a-java-string-contains-at-least-one-capital-letter-lowercase
		for (int i = 0; i < ticket.size(); i++) {
			departureAirport = ticket.get(i).getDepatureAirport();
			
			if(departureAirport.length() != 3) {
				checkDepAirSize = 1;
			} else {
				checkDepAirSize = 0;
				for(int j = 0; j < departureAirport.length(); j++) {
					char ch = departureAirport.charAt(j);
					if(Character.isUpperCase(ch)) {
						checkDepAirFormat = 0;
					} else {
						checkDepAirFormat = 1;
					}
				}
			}
				
		}
		
		if(ticket.size() <= maxFlightsCount) {
			maxFlights = 0;
		} else {
			maxFlights = 1;
		}
		
		for(int k = 0; k < ticket.size(); k++) {
			totalFlightTime += ticket.get(k).calculateFlightTime();
		}
		
		if(maxFlightTime >= totalFlightTime) {
			flightTime = 0;
		} else {
			flightTime = 1;
		}
		
	
		if(checkDepAirSize == 0 && checkDepAirFormat == 0 && maxFlights == 0 && flightTime == 0) {
			return true;
		} else {
			return false;
		}	

		//end of your code
	}
		/**
	 * The function checks if the ticket has a cyclic trip
	 * (that is, no passenger can arrive at the same airport more than once within the same ticket)
	 * @param	ticket				List of ordered sequences of flights
	 * @return	true if the ticket has a cyclic trip, false otherwise
	 * usefeul functions that you may use
	 * 		(class: Flight , method: getArrivalAirport)
	 * 		(class: Flight , method: getDepatureAirport)
	*/
	public static boolean hasCyclicTrip(ArrayList<Flight> ticket)
	{
		//Todo : add your code here
		
		

		//Todo : end of your code

		return false;
	}
}