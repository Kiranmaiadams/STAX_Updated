package com.STAX_Objects;

import org.openqa.selenium.By;

public class STAX_EmailUs {

	public final By EmailUsButton = By.xpath("//a[@class='emailPopUp btn-sta btn-email']");
	
	public final By EmailUs_FirstName = By.id("txteffirstname");
	
	public final By EmailUs_LastName = By.id("txteflastname");
	
	public final By EmailUs_EmailId = By.id("txtefemail");
	
	public final By EmailUs_PhoneNo = By.id("txtefphone");
	
	public final By EmailUs_SendMyEmail = By.id("btnSubmit");
	
	public final By EmailUs_Close = By.xpath("//div/a[contains(.,'Close')]");
	
}
