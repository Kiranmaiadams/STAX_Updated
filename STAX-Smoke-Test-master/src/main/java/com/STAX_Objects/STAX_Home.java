package com.STAX_Objects;

import org.openqa.selenium.By;

public class STAX_Home {
	
	public  final By Signinbutton = By.xpath("//li[@class='account nav-dropdown']");
	
	public  final By priceXpath = By.xpath("//span[contains(@class,'trip-price-inner ng-binding')]");

	public  final By daysXpath = By.xpath("//span[@class='trip-days ng-binding']");

	public  final By TourCountInLabel = By.xpath("//span[@class='ng-binding']");
	
	public final By SortDropDown = By.id("sortSelect");
	
}
