package com.STAX_Objects;

import org.openqa.selenium.By;

public class staxFlightspage {

	public static final By mainMenu = By.xpath("//ul[@class='sta-searchTabs sta-contain']");
	public static final By flightlink = By.xpath("//*[@id=\"qbtb_2_0_id_0\"]/div[2]/div[1]/div/ul/li[1]/a");
	public static final By fromFlightdropdown = By.xpath("//li[@class='ui-menu-item']");
	public static final By destinationFlightinputbox = By
			.xpath("//input[@class='sta-flight_arrive_location sta-non-touch ui-autocomplete-input']");

	public static final By fromFlightinputbox = By
			.xpath("//input[@class='sta-flight_depart_location sta-non-touch ui-autocomplete-input']");
	public static final By flightDepatureDate = By.xpath("//input [@class='sta-date_pick sta-flight_depart_date hasDatepicker']");
	public static final By flightReturnDate = By.xpath("//input [@class='sta-date_pick sta-flight_depart_date hasDatepicker']");
	public static final By findFlightbutton = By.xpath("//*[@id=\"qbtb_2_0_id_0\"]/div[2]/div[1]/div/div[4]/form/fieldset[8]/p/button");
	
	public static final By whoIsgoing = By.xpath("//div[@class='sta-travellers-selector-key']");
	
	
	
}
