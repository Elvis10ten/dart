package com.fluentbuild.apollo.runner;

import com.fluentbuild.apollo.runner.TestDescription;
import com.fluentbuild.apollo.runner.ProcessFailure;
import com.fluentbuild.apollo.runner.TestFailure;
import com.fluentbuild.apollo.runner.TestResult;
import com.fluentbuild.apollo.runner.Finisher;

interface TestCallback {

    void onTestRunStarted(in TestDescription description);

    void onTestRunFinished(in TestResult result);

    void onTestStarted(
        in TestDescription description,
        String logFileName,
        String profilerFileName,
        String autoScreenShotNamePrefix
    );

    void onTestFinished(in TestDescription description);

    void onTestFailure(in TestFailure failure);

    void onTestAssumptionFailure(in TestFailure failure);

    void onTestIgnored(in TestDescription description);

    void onProcessCrashed(in TestDescription failure, String stackTrace);

    void onClientConnected(Finisher finisher);

    void onInterrupted(int reasonId);

    void sendString(String message);
}
