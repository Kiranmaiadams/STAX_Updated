package com.STAX_Implementations;

import java.io.IOException;

import com.STAX_Interfaces.EmailUs;
import com.STAX_Objects.STAX_EmailUs;
import com.STAX_common.StaxBase;

public class EmailUsImpl extends StaxBase implements EmailUs {

	STAX_EmailUs Email = new STAX_EmailUs();
	
	/*
	 * public void test() throws Exception{ click(EmailUsBut); }
	 */
	
	@Override
	public void ClickEmailUs() throws Exception {
			SwitchToNewWindow();
			ClickAfterElementBecomesClickable(Email.EmailUsButton);
	}

	@Override
	public void EnterEmailDetails() throws IOException {
			type(Email.EmailUs_FirstName, "Test");
			type(Email.EmailUs_LastName,"Automation");
			type(Email.EmailUs_EmailId,"kiranmai.adams@statravel.com");
			type(Email.EmailUs_PhoneNo,"0123456789");			
	}

	@Override
	public void ClickSendMyEmail() throws Exception {
			click(Email.EmailUs_SendMyEmail);
	}

	@Override
	public void VerifyEmailSentText() {
		verifyThePageContentWithParticularText("Thank you for your enquiry");
		verifyThePageContentWithParticularText("We will be in touch shortly");
	}

	@Override
	public void CloseEmailPopup() throws Exception {
			click(Email.EmailUs_Close);
	}

}
