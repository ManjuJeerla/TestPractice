package com.nt.junit;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestSuite {

	public static void main(String[] args) {

		Result result = JUnitCore.runClasses(AllTests.class);

		System.out.println("Failures.....!");

		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}

		System.out.println("Total Tests::" + result.getRunCount());
		System.out.println("Total failures::" + result.getFailureCount());
		System.out.println("Total Ignores::" + result.getIgnoreCount());
	}

}
