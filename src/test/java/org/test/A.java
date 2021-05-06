package org.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class A {

	@DataProvider
	private Object[][] data() {

		return new Object[][] {

				{ "123", "Anu" },
				{ "223", "riya" },
		};
	}
	@Test(dataProvider="data")
	private void test(String s1,String s2) {
		System.out.println(s1);
		System.out.println(s2);

	}
}
