package com.fb.main;

import java.io.IOException;
import java.util.List;

import org.testng.TestNG;

import com.beust.jcommander.internal.Lists;

public class FbSuiteTest {

	public static void main(String[] args) throws InterruptedException, IOException {

	//	TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		List<String> suites = Lists.newArrayList();
		suites.add("testng.xml");
		testng.setTestSuites(suites);
		testng.run();		
	}
}
