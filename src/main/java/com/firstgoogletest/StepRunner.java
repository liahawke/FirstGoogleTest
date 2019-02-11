package com.firstgoogletest;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class StepRunner {
    public static void main(String[] args) {

        Result result = JUnitCore.runClasses(GoogleSearchTest.class);

        if (result.wasSuccessful()) {
            System.out.println("Link was found!");
        } else {
            for (Failure failure : result.getFailures()) {
                System.err.println("Exception - " + failure.getException());
                System.err.println("Trace - " + failure.getTrace());
            }

        }
    }
}
