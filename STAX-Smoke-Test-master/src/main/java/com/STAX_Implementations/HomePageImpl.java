package com.STAX_Implementations;

import java.io.IOException;

import com.STAX_Interfaces.HomePage;
import com.STAX_Objects.STAX_Home;
import com.STAX_common.StaxBase;

public class HomePageImpl extends StaxBase implements HomePage {

	STAX_Home Home = new STAX_Home();
	
	
	@Override
	public String SelectSortOption(String SortOption) throws InterruptedException, IOException {
		type(Home.SortDropDown,SortOption);
		return SortOption;
	}

}
