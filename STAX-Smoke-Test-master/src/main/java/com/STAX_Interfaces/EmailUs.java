package com.STAX_Interfaces;

import java.io.IOException;

import org.openqa.selenium.By;

public interface EmailUs {
	public final By EmailUsBut = By.xpath("//a[@class='emailPopUp btn-sta btn-email']");

	public void ClickEmailUs() throws Exception;

	public void EnterEmailDetails() throws IOException;

	public void ClickSendMyEmail() throws Exception;

	public void VerifyEmailSentText();

	public void CloseEmailPopup() throws Exception;

}
