--------- beginning of main
         1606083392.674 12272 12272 I lla.focus.debu: Late-enabling -Xcheck:jni
         1606083392.705 12272 12272 E lla.focus.debu: Unknown bits set in runtime_flags: 0x8000
         1606083392.724 12272 12272 D ActivityThread: setConscryptValidator
         1606083392.724 12272 12272 D ActivityThread: setConscryptValidator - put
--------- beginning of system
         1606083392.758 12272 12272 W ActivityThread: Package uses different ABI(s) than its instrumentation: package[org.mozilla.focus.debug]: armeabi-v7a, null instrumentation[org.mozilla.focus.debug.test]: null, null
--------- switch to main
         1606083392.761 12272 12272 I lla.focus.debu: The ClassLoaderContext is a special shared library.
         1606083392.762 12272 12272 I lla.focus.debu: The ClassLoaderContext is a special shared library.
         1606083393.032 12272 12272 I lla.focus.debu: The ClassLoaderContext is a special shared library.
         1606083393.033 12272 12272 I lla.focus.debu: The ClassLoaderContext is a special shared library.
         1606083393.322 12272 12272 I RunnerHelper: Runner onCreate
         1606083393.324 12272 12272 V ClearDataTask: Deleting files dir
         1606083393.326 12272 12272 V ClearDataTask: Deleting cacheDir dir
         1606083393.326 12272 12272 V ClearDataTask: Deleting externalMediaDirs dir
         1606083393.338 12272 12272 V ClearDataTask: Deleting codeCacheDir dir
         1606083393.339 12272 12272 V ClearDataTask: Deleting externalCacheDir dir
         1606083393.351 12272 12272 V ClearDataTask: Deleting noBackupFilesDir dir
         1606083393.352 12272 12272 V ClearDataTask: Deleting data dir
         1606083393.358 12272 12272 I Logger  : Starting logging!
         1606083393.369 12272 12351 W ParcelFileDescriptor: Peer didn't provide a comm channel; unable to check for errors
         1606083393.422 12272 12272 E memtrack: Couldn't load memtrack module
         1606083393.422 12272 12272 W android.os.Debug: failed to get memory consumption info: -1
         1606083393.457 12272 12272 I MonitoringInstr: Instrumentation started!
         1606083393.459 12272 12272 I MonitoringInstr: Setting context classloader to 'dalvik.system.PathClassLoader[DexPathList[[zip file "/system/framework/android.test.runner.jar", zip file "/system/framework/android.test.mock.jar", zip file "/data/app/org.mozilla.focus.debug.test-fdh4xYhwfnzel_Af3O-usg==/base.apk", zip file "/data/app/org.mozilla.focus.debug-vjNiTia4m7zeAhMCVS-j3g==/base.apk"],nativeLibraryDirectories=[/data/app/org.mozilla.focus.debug.test-fdh4xYhwfnzel_Af3O-usg==/lib/arm64, /data/app/org.mozilla.focus.debug-vjNiTia4m7zeAhMCVS-j3g==/lib/arm, /data/app/org.mozilla.focus.debug.test-fdh4xYhwfnzel_Af3O-usg==/base.apk!/lib/armeabi-v7a, /data/app/org.mozilla.focus.debug-vjNiTia4m7zeAhMCVS-j3g==/base.apk!/lib/armeabi-v7a, /system/lib]]]', Original: 'dalvik.system.PathClassLoader[DexPathList[[zip file "/system/framework/android.test.runner.jar", zip file "/system/framework/android.test.mock.jar", zip file "/data/app/org.mozilla.focus.debug.test-fdh4xYhwfnzel_Af3O-usg==/base.apk", zip file "/data/app/org.mozilla.focus.debug-vjNiTia4m7zeAhMCVS-j3g==/base.apk"],nativeLibraryDirectories=[/data/app/org.mozilla.focus.debug.test-fdh4xYhwfnzel_Af3O-usg==/lib/arm64, /data/app/org.mozilla.focus.debug-vjNiTia4m7zeAhMCVS-j3g==/lib/arm, /data/app/org.mozilla.focus.debug.test-fdh4xYhwfnzel_Af3O-usg==/base.apk!/lib/armeabi-v7a, /data/app/org.mozilla.focus.debug-vjNiTia4m7zeAhMCVS-j3g==/base.apk!/lib/armeabi-v7a, /system/lib]]]'
         1606083393.460 12272 12359 I RunnerHelper: Runner onStart
         1606083393.460 12272 12272 I AppMonitor: Application: org.mozilla.focus.FocusApplication@1782245 is in stage: PRE_ON_CREATE
         1606083393.460 12272 12359 I TestClient: Connecting to runner service
         1606083393.470 12272 12361 I stetho  : Listening on @stetho_org.mozilla.focus.debug_devtools_remote
         1606083393.504 12272 12272 I AppMonitor: Application: org.mozilla.focus.FocusApplication@1782245 is in stage: CREATED
         1606083393.506 12272 12272 I TestClient: TestClient connected to runner service
         1606083393.508 12272 12272 I MonitoringInstr: No JSBridge.
         1606083393.511 12272 12359 I MonitoringInstr: Setting context classloader to 'dalvik.system.PathClassLoader[DexPathList[[zip file "/system/framework/android.test.runner.jar", zip file "/system/framework/android.test.mock.jar", zip file "/data/app/org.mozilla.focus.debug.test-fdh4xYhwfnzel_Af3O-usg==/base.apk", zip file "/data/app/org.mozilla.focus.debug-vjNiTia4m7zeAhMCVS-j3g==/base.apk"],nativeLibraryDirectories=[/data/app/org.mozilla.focus.debug.test-fdh4xYhwfnzel_Af3O-usg==/lib/arm64, /data/app/org.mozilla.focus.debug-vjNiTia4m7zeAhMCVS-j3g==/lib/arm, /data/app/org.mozilla.focus.debug.test-fdh4xYhwfnzel_Af3O-usg==/base.apk!/lib/armeabi-v7a, /data/app/org.mozilla.focus.debug-vjNiTia4m7zeAhMCVS-j3g==/base.apk!/lib/armeabi-v7a, /system/lib]]]', Original: 'dalvik.system.PathClassLoader[DexPathList[[zip file "/system/framework/android.test.runner.jar", zip file "/system/framework/android.test.mock.jar", zip file "/data/app/org.mozilla.focus.debug.test-fdh4xYhwfnzel_Af3O-usg==/base.apk", zip file "/data/app/org.mozilla.focus.debug-vjNiTia4m7zeAhMCVS-j3g==/base.apk"],nativeLibraryDirectories=[/data/app/org.mozilla.focus.debug.test-fdh4xYhwfnzel_Af3O-usg==/lib/arm64, /data/app/org.mozilla.focus.debug-vjNiTia4m7zeAhMCVS-j3g==/lib/arm, /data/app/org.mozilla.focus.debug.test-fdh4xYhwfnzel_Af3O-usg==/base.apk!/lib/armeabi-v7a, /data/app/org.mozilla.focus.debug-vjNiTia4m7zeAhMCVS-j3g==/base.apk!/lib/armeabi-v7a, /system/lib]]]'
         1606083393.541 12272 12272 I BootstrapService: Bound to BootstrapService
         1606083393.542 12272 12369 D NetworkSecurityConfig: No Network Security Config specified, using platform default
         1606083393.545 12272 12369 I System.out: (HTTPLog)-Static: isSBSettingEnabled false
         1606083393.545 12272 12369 I System.out: (HTTPLog)-Static: isSBSettingEnabled false
         1606083393.546 12272 12359 I UsageTrackerFacilitator: Usage tracking enabled
         1606083393.559 12272 12359 D TestExecutor: Adding listener androidx.test.internal.runner.listener.LogRunListener
         1606083393.559 12272 12359 D TestExecutor: Adding listener com.fluentbuild.apollo.runner.client.junit.TestObserver
         1606083393.560 12272 12359 D TestExecutor: Adding listener androidx.test.internal.runner.listener.ActivityFinisherRunListener
         1606083393.564 12272 12359 I TestRunner: run started: 4 tests
         1606083393.565 12272 12359 I TestObserver: RUN_STARTED:null
         1606083393.568 12272 12359 I TestRunner: started: AboutAndYourRightsPagesTest(org.mozilla.focus.activity.AccessAboutAndYourRightsPagesTest)
         1606083393.569 12272 12359 I TestObserver: TEST_STARTED:AboutAndYourRightsPagesTest(org.mozilla.focus.activity.AccessAboutAndYourRightsPagesTest)
         1606083393.570 12272 12272 I MonitoringInstr: Activities that are still in CREATED to STOPPED: 0
         1606083393.571 12272 12359 W ActivityTestRule: getActivityIntent() returned null using default: Intent(Intent.ACTION_MAIN)
         1606083393.572 12272 12359 E TestRunner: assumption failed: AboutAndYourRightsPagesTest(org.mozilla.focus.activity.AccessAboutAndYourRightsPagesTest)
         1606083393.572 12272 12359 E TestRunner: ----- begin exception -----
         1606083393.573 12272 12359 E TestRunner: org.junit.AssumptionViolatedException: got: <false>, expected: is <true>
         1606083393.573 12272 12359 E TestRunner: 	at org.junit.Assume.assumeThat(Assume.java:95)
         1606083393.573 12272 12359 E TestRunner: 	at org.junit.Assume.assumeTrue(Assume.java:41)
         1606083393.573 12272 12359 E TestRunner: 	at org.mozilla.focus.activity.AccessAboutAndYourRightsPagesTest$1.beforeActivityLaunched(AccessAboutAndYourRightsPagesTest.java:54)
         1606083393.573 12272 12359 E TestRunner: 	at androidx.test.rule.ActivityTestRule.launchActivity(ActivityTestRule.java:355)
         1606083393.573 12272 12359 E TestRunner: 	at androidx.test.rule.ActivityTestRu--------- beginning of main
         1606083392.674 12272 12272 I lla.focus.debu: Late-enabling -Xcheck:jni
         1606083392.705 12272 12272 E lla.focus.debu: Unknown bits set in runtime_flags: 0x8000
         1606083392.724 12272 12272 D ActivityThread: setConscryptValidator
         1606083392.724 12272 12272 D ActivityThread: setConscryptValidator - put
--------- beginning of system
         1606083392.758 12272 12272 W ActivityThread: Package uses different ABI(s) than its instrumentation: package[org.mozilla.focus.debug]: armeabi-v7a, null instrumentation[org.mozilla.focus.debug.test]: null, null
--------- switch to main
         1606083392.761 12272 12272 I lla.focus.debu: The ClassLoaderContext is a special shared library.
         1606083392.762 12272 12272 I lla.focus.debu: The ClassLoaderContext is a special shared library.
         1606083393.032 12272 12272 I lla.focus.debu: The ClassLoaderContext is a special shared library.
         1606083393.033 12272 12272 I lla.focus.debu: The ClassLoaderContext is a special shared library.
         1606083393.322 12272 12272 I RunnerHelper: Runner onCreate
         1606083393.324 12272 12272 V ClearDataTask: Deleting files dir
         1606083393.326 12272 12272 V ClearDataTask: Deleting cacheDir dir
         1606083393.326 12272 12272 V ClearDataTask: Deleting externalMediaDirs dir
         1606083393.338 12272 12272 V ClearDataTask: Deleting codeCacheDir dir
         1606083393.339 12272 12272 V ClearDataTask: Deleting externalCacheDir dir
         1606083393.351 12272 12272 V ClearDataTask: Deleting noBackupFilesDir dir
         1606083393.352 12272 12272 V ClearDataTask: Deleting data dir
         1606083393.358 12272 12272 I Logger  : Starting logging!
         1606083393.369 12272 12351 W ParcelFileDescriptor: Peer didn't provide a comm channel; unable to check for errors
         1606083393.422 12272 12272 E memtrack: Couldn't load memtrack module
         1606083393.422 12272 12272 W android.os.Debug: failed to get memory consumption info: -1
         1606083393.457 12272 12272 I MonitoringInstr: Instrumentation started!
         1606083393.459 12272 12272 I MonitoringInstr: Setting context classloader to 'dalvik.system.PathClassLoader[DexPathList[[zip file "/system/framework/android.test.runner.jar", zip file "/system/framework/android.test.mock.jar", zip file "/data/app/org.mozilla.focus.debug.test-fdh4xYhwfnzel_Af3O-usg==/base.apk", zip file "/data/app/org.mozilla.focus.debug-vjNiTia4m7zeAhMCVS-j3g==/base.apk"],nativeLibraryDirectories=[/data/app/org.mozilla.focus.debug.test-fdh4xYhwfnzel_Af3O-usg==/lib/arm64, /data/app/org.mozilla.focus.debug-vjNiTia4m7zeAhMCVS-j3g==/lib/arm, /data/app/org.mozilla.focus.debug.test-fdh4xYhwfnzel_Af3O-usg==/base.apk!/lib/armeabi-v7a, /data/app/org.mozilla.focus.debug-vjNiTia4m7zeAhMCVS-j3g==/base.apk!/lib/armeabi-v7a, /system/lib]]]', Original: 'dalvik.system.PathClassLoader[DexPathList[[zip file "/system/framework/android.test.runner.jar", zip file "/system/framework/android.test.mock.jar", zip file "/data/app/org.mozilla.focus.debug.test-fdh4xYhwfnzel_Af3O-usg==/base.apk", zip file "/data/app/org.mozilla.focus.debug-vjNiTia4m7zeAhMCVS-j3g==/base.apk"],nativeLibraryDirectories=[/data/app/org.mozilla.focus.debug.test-fdh4xYhwfnzel_Af3O-usg==/lib/arm64, /data/app/org.mozilla.focus.debug-vjNiTia4m7zeAhMCVS-j3g==/lib/arm, /data/app/org.mozilla.focus.debug.test-fdh4xYhwfnzel_Af3O-usg==/base.apk!/lib/armeabi-v7a, /data/app/org.mozilla.focus.debug-vjNiTia4m7zeAhMCVS-j3g==/base.apk!/lib/armeabi-v7a, /system/lib]]]'
         1606083393.460 12272 12359 I RunnerHelper: Runner onStart
         1606083393.460 12272 12272 I AppMonitor: Application: org.mozilla.focus.FocusApplication@1782245 is in stage: PRE_ON_CREATE
         1606083393.460 12272 12359 I TestClient: Connecting to runner service
         1606083393.470 12272 12361 I stetho  : Listening on @stetho_org.mozilla.focus.debug_devtools_remote
         1606083393.504 12272 12272 I AppMonitor: Application: org.mozilla.focus.FocusApplication@1782245 is in stage: CREATED
         1606083393.506 12272 12272 I TestClient: TestClient connected to runner service
         1606083393.508 12272 12272 I MonitoringInstr: No JSBridge.
         1606083393.511 12272 12359 I MonitoringInstr: Setting context classloader to 'dalvik.system.PathClassLoader[DexPathList[[zip file "/system/framework/android.test.runner.jar", zip file "/system/framework/android.test.mock.jar", zip file "/data/app/org.mozilla.focus.debug.test-fdh4xYhwfnzel_Af3O-usg==/base.apk", zip file "/data/app/org.mozilla.focus.debug-vjNiTia4m7zeAhMCVS-j3g==/base.apk"],nativeLibraryDirectories=[/data/app/org.mozilla.focus.debug.test-fdh4xYhwfnzel_Af3O-usg==/lib/arm64, /data/app/org.mozilla.focus.debug-vjNiTia4m7zeAhMCVS-j3g==/lib/arm, /data/app/org.mozilla.focus.debug.test-fdh4xYhwfnzel_Af3O-usg==/base.apk!/lib/armeabi-v7a, /data/app/org.mozilla.focus.debug-vjNiTia4m7zeAhMCVS-j3g==/base.apk!/lib/armeabi-v7a, /system/lib]]]', Original: 'dalvik.system.PathClassLoader[DexPathList[[zip file "/system/framework/android.test.runner.jar", zip file "/system/framework/android.test.mock.jar", zip file "/data/app/org.mozilla.focus.debug.test-fdh4xYhwfnzel_Af3O-usg==/base.apk", zip file "/data/app/org.mozilla.focus.debug-vjNiTia4m7zeAhMCVS-j3g==/base.apk"],nativeLibraryDirectories=[/data/app/org.mozilla.focus.debug.test-fdh4xYhwfnzel_Af3O-usg==/lib/arm64, /data/app/org.mozilla.focus.debug-vjNiTia4m7zeAhMCVS-j3g==/lib/arm, /data/app/org.mozilla.focus.debug.test-fdh4xYhwfnzel_Af3O-usg==/base.apk!/lib/armeabi-v7a, /data/app/org.mozilla.focus.debug-vjNiTia4m7zeAhMCVS-j3g==/base.apk!/lib/armeabi-v7a, /system/lib]]]'
         1606083393.541 12272 12272 I BootstrapService: Bound to BootstrapService
         1606083393.542 12272 12369 D NetworkSecurityConfig: No Network Security Config specified, using platform default
         1606083393.545 12272 12369 I System.out: (HTTPLog)-Static: isSBSettingEnabled false
         1606083393.545 12272 12369 I System.out: (HTTPLog)-Static: isSBSettingEnabled false
         1606083393.546 12272 12359 I UsageTrackerFacilitator: Usage tracking enabled
         1606083393.559 12272 12359 D TestExecutor: Adding listener androidx.test.internal.runner.listener.LogRunListener
         1606083393.559 12272 12359 D TestExecutor: Adding listener com.fluentbuild.apollo.runner.client.junit.TestObserver
         1606083393.560 12272 12359 D TestExecutor: Adding listener androidx.test.internal.runner.listener.ActivityFinisherRunListener
         1606083393.564 12272 12359 I TestRunner: run started: 4 tests
         1606083393.565 12272 12359 I TestObserver: RUN_STARTED:null
         1606083393.568 12272 12359 I TestRunner: started: AboutAndYourRightsPagesTest(org.mozilla.focus.activity.AccessAboutAndYourRightsPagesTest)
         1606083393.569 12272 12359 I TestObserver: TEST_STARTED:AboutAndYourRightsPagesTest(org.mozilla.focus.activity.AccessAboutAndYourRightsPagesTest)
         1606083393.570 12272 12272 I MonitoringInstr: Activities that are still in CREATED to STOPPED: 0
         1606083393.571 12272 12359 W ActivityTestRule: getActivityIntent() returned null using default: Intent(Intent.ACTION_MAIN)
         1606083393.572 12272 12359 E TestRunner: assumption failed: AboutAndYourRightsPagesTest(org.mozilla.focus.activity.AccessAboutAndYourRightsPagesTest)
         1606083393.572 12272 12359 E TestRunner: ----- begin exception -----
         1606083393.573 12272 12359 E TestRunner: org.junit.AssumptionViolatedException: got: <false>, expected: is <true>
         1606083393.573 12272 12359 E TestRunner: 	at org.junit.Assume.assumeThat(Assume.java:95)
         1606083393.573 12272 12359 E TestRunner: 	at org.junit.Assume.assumeTrue(Assume.java:41)
         1606083393.573 12272 12359 E TestRunner: 	at org.mozilla.focus.activity.AccessAboutAndYourRightsPagesTest$1.beforeActivityLaunched(AccessAboutAndYourRightsPagesTest.java:54)
         1606083393.573 12272 12359 E TestRunner: 	at androidx.test.rule.ActivityTestRule.launchActivity(ActivityTestRule.java:355)
         1606083393.573 12272 12359 E TestRunner: 	at androidx.test.rule.ActivityTestRule$ActivityStatement.evaluate(ActivityTestRule.java:529)
         1606083393.573 12272 12359 E TestRunner: 	at org.junit.rules.RunRules.evaluate(RunRules.java:20)
         1606083393.573 12272 12359 E TestRunner: 	at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)
         1606083393.573 12272 12359 E TestRunner: 	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)
         1606083393.573 12272 12359 E TestRunner: 	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)
         1606083393.573 12272 12359 E TestRunner: 	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
         1606083393.573 12272 12359 E TestRunner: 	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
         1606083393.573 12272 12359 E TestRunner: 	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
         1606083393.573 12272 12359 E TestRunner: 	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
         1606083393.573 12272 12359 E TestRunner: 	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
         1606083393.573 12272 12359 E TestRunner: 	at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
         1606083393.573 12272 12359 E TestRunner: 	at androidx.test.runner.AndroidJUnit4.run(AndroidJUnit4.java:104)
         1606083393.573 12272 12359 E TestRunner: 	at org.junit.runners.Suite.runChild(Suite.java:128)
         1606083393.573 12272 12359 E TestRunner: 	at org.junit.runners.Suite.runChild(Suite.java:27)
         1606083393.573 12272 12359 E TestRunner: 	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
         1606083393.573 12272 12359 E TestRunner: 	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
         1606083393.573 12272 12359 E TestRunner: 	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
         1606083393.573 12272 12359 E TestRunner: 	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
         1606083393.573 12272 12359 E TestRunner: 	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
         1606083393.573 12272 12359 E TestRunner: 	at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
         1606083393.573 12272 12359 E TestRunner: 	at org.junit.runner.JUnitCore.run(JUnitCore.java:137)
         1606083393.573 12272 12359 E TestRunner: 	at org.junit.runner.JUnitCore.run(JUnitCore.java:115)
         1606083393.573 12272 12359 E TestRunner: 	at androidx.test.internal.runner.TestExecutor.execute(TestExecutor.java:56)
         1606083393.573 12272 12359 E TestRunner: 	at androidx.test.runner.AndroidJUnitRunner.onStart(AndroidJUnitRunner.java:392)
         1606083393.573 12272 12359 E TestRunner: 	at com.fluentbuild.apollo.runner.client.androidx.AndroidXJUnitRunner.onStart(AndroidXJUnitRunner.kt:24)
         1606083393.573 12272 12359 E TestRunner: 	at org.mozilla.focus.Angelina.onStart(Angelina.kt:25)
         1606083393.573 12272 12359 E TestRunner: 	at android.app.Instrumentation$InstrumentationThread.run(Instrumentation.java:2214)
         1606083393.573 12272 12359 E TestRunner: ----- end exception -----
         1606083393.575 12272 12359 I TestObserver: TEST_ASSUME_FAILURE:AboutAndYourRightsPagesTest(org.mozilla.focus.activity.AccessAboutAndYourRightsPagesTest): got: <false>, expected: is <true>
         1606083393.575 12272 12359 I Logger  : Stopping logging!
         1606083393.576 12272 12351 W System.err: java.io.IOException: write failed: EBADF (Bad file descriptor)
         1606083393.578 12272 12351 W System.err: 	at libcore.io.IoBridge.write(IoBridge.java:544)
         1606083393.578 12272 12351 W System.err: 	at java.io.FileOutputStream.write(FileOutputStream.java:392)
         1606083393.579 12272 12351 W System.err: 	at sun.nio.cs.StreamEncoder.writeBytes(StreamEncoder.java:221)
         1606083393.579 12272 12351 W System.err: 	at sun.nio.cs.StreamEncoder.implClose(StreamEncoder.java:316)
         1606083393.579 12272 12351 W System.err: 	at sun.nio.cs.StreamEncoder.close(StreamEncoder.java:149)
         1606083393.579 12272 12351 W System.err: 	at java.io.OutputStreamWriter.close(OutputStreamWriter.java:233)
         1606083393.579 12272 12351 W System.err: 	at java.io.BufferedWriter.close(BufferedWriter.java:266)
         1606083393.579 12272 12351 W System.err: 	at com.fluentbuild.apollo.foundation.IoUtilsKt.closeCatching(IoUtils.kt:26)
         1606083393.579 12272 12351 W System.err: 	at com.fluentbuild.apollo.foundation.FileUtilsKt.autoCloseBufferedWriter(FileUtils.kt:115)
         1606083393.579 12272 12351 W System.err: 	at com.fluentbuild.apollo.foundation.FileUtilsKt.copyAllLines(FileUtils.kt:61)
         1606083393.579 12272 12351 W System.err: 	at com.fluentbuild.apollo.runner.client.collators.logs.Logger.logToFile(Logger.kt:47)
         1606083393.580 12272 12351 W System.err: 	at com.fluentbuild.apollo.runner.client.collators.logs.Logger.logResiliently(Logger.kt:69)
         1606083393.580 12272 12351 W System.err: 	at com.fluentbuild.apollo.runner.client.collators.logs.Logger.access$logResiliently(Logger.kt:18)
         1606083393.580 12272 12351 W System.err: 	at com.fluentbuild.apollo.runner.client.collators.logs.Logger$startLogging$1.run(Logger.kt:34)
         1606083393.580 12272 12351 W System.err: 	at java.lang.Thread.run(Thread.java:919)
         1606083393.580 12272 12351 W System.err: Caused by: android.system.ErrnoException: write failed: EBADF (Bad file descriptor)
         1606083393.581 12272 12351 W System.err: 	at libcore.io.Linux.writeBytes(Native Method)
         1606083393.581 12272 12351 W System.err: 	at libcore.io.Linux.write(Linux.java:294)
         1606083393.581 12272 12351 W System.err: 	at libcore.io.ForwardingOs.write(ForwardingOs.java:241)
         1606083393.581 12272 12351 W System.err: 	at libcore.io.BlockGuardOs.write(BlockGuardOs.java:416)
         1606083393.581 12272 12351 W System.err: 	at libcore.io.ForwardingOs.write(ForwardingOs.java:241)
         1606083393.581 12272 12351 W System.err: 	at libcore.io.IoBridge.write(IoBridge.java:539)
         1606083393.581 12272 12351 W System.err: 	... 14 more
         1606083393.585 12272 12351 E Logger  : Logging error
         1606083393.585 12272 12351 E Logger  : java.io.InterruptedIOException: read interrupted
         1606083393.585 12272 12351 E Logger  : 	at libcore.io.Linux.readBytes(Native Method)
         1606083393.585 12272 12351 E Logger  : 	at libcore.io.Linux.read(Linux.java:190)
         1606083393.585 12272 12351 E Logger  : 	at libcore.io.ForwardingOs.read(ForwardingOs.java:177)
         1606083393.585 12272 12351 E Logger  : 	at libcore.io.BlockGuardOs.read(BlockGuardOs.java:303)
         1606083393.585 12272 12351 E Logger  : 	at libcore.io.ForwardingOs.read(ForwardingOs.java:177)
         1606083393.585 12272 12351 E Logger  : 	at libcore.io.IoBridge.read(IoBridge.java:513)
         1606083393.585 12272 12351 E Logger  : 	at java.io.FileInputStream.read(FileInputStream.java:313)
         1606083393.585 12272 12351 E Logger  : 	at java.io.BufferedInputStream.read1(BufferedInputStream.java:286)
         1606083393.585 12272 12351 E Logger  : 	at java.io.BufferedInputStream.read(BufferedInputStream.java:347)
         1606083393.585 12272 12351 E Logger  : 	at sun.nio.cs.StreamDecoder.readBytes(StreamDecoder.java:291)
         1606083393.585 12272 12351 E Logger  : 	at sun.nio.cs.StreamDecoder.implRead(StreamDecoder.java:355)
         1606083393.585 12272 12351 E Logger  : 	at sun.nio.cs.StreamDecoder.read(StreamDecoder.java:181)
         1606083393.585 12272 12351 E Logger  : 	at java.io.InputStreamReader.read(InputStreamReader.java:184)
         1606083393.585 12272 12351 E Logger  : 	at java.io.BufferedReader.fill(BufferedReader.java:172)
         1606083393.585 12272 12351 E Logger  : 	at java.io.BufferedReader.readLine(BufferedReader.java:335)
         1606083393.585 12272 12351 E Logger  : 	at java.io.BufferedReader.readLine(BufferedReader.java:400)
         1606083393.585 12272 12351 E Logger  : 	at kotlin.io.LinesSequence$iterator$1.hasNext(ReadWrite.kt:80)
         1606083393.585 12272 12351 E Logger  : 	at com.fluentbuild.apollo.foundation.FileUtilsKt$copyAllLines$1$1.invoke(FileUtils.kt:101)
         1606083393.585 12272 12351 E Logger  : 	at com.fluentbuild.apollo.foundation.FileUtilsKt$copyAllLines$1$1.invoke(Unknown Source:2)
         1606083393.585 12272 12351 E Logger  : 	at com.fluentbuild.apollo.foundation.FileUtilsKt.autoCloseBufferedWriter(FileUtils.kt:52)
         1606083393.585 12272 12351 E Logger  : 	at com.fluentbuild.apollo.foundation.FileUtilsKt.copyAllLines(FileUtils.kt:61)
         1606083393.585 12272 12351 E Logger  : 	at com.fluentbuild.apollo.runner.client.collators.logs.Logger.logToFile(Logger.kt:47)
         1606083393.585 12272 12351 E Logger  : 	at com.fluentbuild.apollo.runner.client.collators.logs.Logger.logResiliently(Logger.kt:69)
         1606083393.585 12272 12351 E Logger  : 	at com.fluentbuild.apollo.runner.client.collators.logs.Logger.access$logResiliently(Logger.kt:18)
         1606083393.585 12272 12351 E Logger  : 	at com.fluentbuild.apollo.runner.client.collators.logs.Logger$startLogging$1.run(Logger.kt:34)
         1606083393.585 12272 12351 E Logger  : 	at java.lang.Thread.run(Thread.java:919)
         1606083393.634 12272 12359 E memtrack: Couldn't load memtrack module
         1606083393.634 12272 12359 W android.os.Debug: failed to get memory consumption info: -1
         1606083393.654 12272 12359 W ParcelFileDescriptor: Peer didn't provide a comm channel; unable to check for errors
         1606083393.655 12272 12359 W lla.focus.debu: Accessing hidden method Lsun/misc/Unsafe;->objectFieldOffset(Ljava/lang/reflect/Field;)J (greylist,core-platform-api, reflection, allowed)
         1606083393.655 12272 12359 W lla.focus.debu: Accessing hidden method Lsun/misc/Unsafe;->getByte(J)B (greylist,core-platform-api, reflection, allowed)
         1606083393.655 12272 12359 W lla.focus.debu: Accessing hidden method Lsun/misc/Unsafe;->getLong(Ljava/lang/Object;J)J (greylist,core-platform-api, reflection, allowed)
         1606083393.656 12272 12359 W lla.focus.debu: Accessing hidden method Lsun/misc/Unsafe;->putByte(JB)V (greylist,core-platform-api, reflection, allowed)
         1606083393.656 12272 12359 W lla.focus.debu: Accessing hidden method Lsun/misc/Unsafe;->getLong(J)J (greylist,core-platform-api, reflection, allowed)
         1606083393.656 12272 12359 W lla.focus.debu: Accessing hidden method Lsun/misc/Unsafe;->copyMemory(JJJ)V (greylist, reflection, allowed)
         1606083393.656 12272 12359 W lla.focus.debu: Accessing hidden method Lsun/misc/Unsafe;->arrayBaseOffset(Ljava/lang/Class;)I (greylist,core-platform-api, reflection, allowed)
         1606083393.656 12272 12359 W lla.focus.debu: Accessing hidden method Lsun/misc/Unsafe;->getByte(Ljava/lang/Object;J)B (greylist,core-platform-api, reflection, allowed)
         1606083393.656 12272 12359 W lla.focus.debu: Accessing hidden method Lsun/misc/Unsafe;->putByte(Ljava/lang/Object;JB)V (greylist,core-platform-api, reflection, allowed)
         1606083393.656 12272 12359 W lla.focus.debu: Accessing hidden method Lsun/misc/Unsafe;->getLong(Ljava/lang/Object;J)J (greylist,core-platform-api, reflection, allowed)
         1606083393.656 12272 12359 W lla.focus.debu: Accessing hidden field Ljava/nio/Buffer;->address:J (greylist, reflection, allowed)
         1606083393.666 12272 12359 I Logger  : Starting logging!
         1606083393.672 12272 12398 W ParcelFileDescriptor: Peer didn't provide a comm channel; unable to check for errors
         1606083393.724 12272 12359 E memtrack: Couldn't load memtrack module
         1606083393.724 12272 12359 W android.os.Debug: failed to get memory consumption info: -1
         1606083393.743 12272 12359 I TestRunner: finished: AboutAndYourRightsPagesTest(org.mozilla.focus.activity.AccessAboutAndYourRightsPagesTest)
         1606083393.744 12272 12359 I TestObserver: TEST_FINISHED:AboutAndYourRightsPagesTest(org.mozilla.focus.activity.AccessAboutAndYourRightsPagesTest)
         1606083393.744 12272 12359 I Logger  : Stopping logging!
         1606083393.744 12272 12398 W System.err: java.io.IOException: write failed: EBADF (Bad file descriptor)
         1606083393.744 12272 12398 W System.err: 	at libcore.io.IoBridge.write(IoBridge.java:544)
         1606083393.744 12272 12398 W System.err: 	at java.io.FileOutputStream.write(FileOutputStream.java:392)
         1606083393.744 12272 12398 W System.err: 	at sun.nio.cs.StreamEncoder.writeBytes(StreamEncoder.java:221)
         1606083393.744 12272 12398 W System.err: 	at sun.nio.cs.StreamEncoder.implWrite(StreamEncoder.java:282)
         1606083393.744 12272 12398 W System.err: 	at sun.nio.cs.StreamEncoder.write(StreamEncoder.java:125)
         1606083393.745 12272 12398 W System.err: 	at java.io.OutputStreamWriter.write(OutputStreamWriter.java:207)
         1606083393.745 12272 12398 W System.err: 	at java.io.BufferedWriter.flushBuffer(BufferedWriter.java:129)
         1606083393.745 12272 12398 W System.err: 	at java.io.BufferedWriter.close(BufferedWriter.java:265)
         1606083393.745 12272 12398 W System.err: 	at com.fluentbuild.apollo.foundation.IoUtilsKt.closeCatching(IoUtils.kt:26)
         1606083393.745 12272 12398 W System.err: 	at com.fluentbuild.apollo.foundation.FileUtilsKt.autoCloseBufferedWriter(FileUtils.kt:115)
         1606083393.745 12272 12398 W System.err: 	at com.fluentbuild.apollo.foundation.FileUtilsKt.copyAllLines(FileUtils.kt:61)
         1606083393.745 12272 12398 W System.err: 	at com.fluentbuild.apollo.runner.client.collators.logs.Logger.logToFile(Logger.kt:47)
         1606083393.745 12272 12398 W System.err: 	at com.fluentbuild.apollo.runner.client.collators.logs.Logger.logResiliently(Logger.kt:69)
         1606083393.745 12272 12398 W System.err: 	at com.fluentbuild.apollo.runner.client.collators.logs.Logger.access$logResiliently(Logger.kt:18)
         1606083393.745 12272 12398 W System.err: 	at com.fluentbuild.apollo.runner.client.collators.logs.Logger$startLogging$1.run(Logger.kt:34)
         1606083393.745 12272 12398 W System.err: 	at java.lang.Thread.run(Thread.java:919)
         1606083393.745 12272 12398 W System.err: Caused by: android.system.ErrnoException: write failed: EBADF (Bad file descriptor)
         1606083393.745 12272 12398 W System.err: 	at libcore.io.Linux.writeBytes(Native Method)
         1606083393.745 12272 12398 W System.err: 	at libcore.io.Linux.write(Linux.java:294)
         1606083393.745 12272 12398 W System.err: 	at libcore.io.ForwardingOs.write(ForwardingOs.java:241)
         1606083393.745 12272 12398 W System.err: 	at libcore.io.BlockGuardOs.write(BlockGuardOs.java:416)
         1606083393.745 12272 12398 W System.err: 	at libcore.io.ForwardingOs.write(ForwardingOs.java:241)
         1606083393.745 12272 12398 W System.err: 	at libcore.io.IoBridge.write(IoBridge.java:539)
         1606083393.745 12272 12398 W System.err: 	... 15 more
         1606083393.753 12272 12369 D TcpOptimizer: TcpOptimizer-ON
         1606083393.753 12272 12398 W ParcelFileDescriptor: Peer didn't provide a comm channel; unable to check for errors
         1606083393.797 12272 12369 D libmdf  : libmdf v2.9.0.0 On 32bit PLATFORM
         1606083393.800 12272 12348 E memtrack: Couldn't load memtrack module
         1606083393.800 12272 12348 W android.os.Debug: failed to get memory consumption info: -1
         1606083393.804 12272 12359 E memtrack: Couldn't load memtrack module
         1606083393.804 12272 12359 W android.os.Debug: failed to get memory consumption info: -1
         1606083393.825 12272 12359 W ParcelFileDescriptor: Peer didn't provide a comm channel; unable to check for errors
         1606083393.834 12272 12359 I Logger  : Starting logging!
         1606083393.840 12272 12421 W ParcelFileDescriptor: Peer didn't provide a comm channel; unable to check for errors
         1606083393.893 12272 12359 E memtrack: Couldn't load memtrack module
         1606083393.893 12272 12359 W android.os.Debug: failed to get memory consumption info: -1
         1606083393.912 12272 12272 I MonitoringInstr: Activities that are still in CREATED to STOPPED: 0
         1606083393.914 12272 12359 I TestRunner: started: FirstRunDialogueTest(org.mozilla.focus.activity.FirstRunDialogueTest)
         1606083393.914 12272 12359 I TestObserver: TEST_STARTED:FirstRunDialogueTest(org.mozilla.focus.activity.FirstRunDialogueTest)
         1606083393.915 12272 12272 I MonitoringInstr: Activities that are still in CREATED to STOPPED: 0
         1606083393.915 12272 12359 W ActivityTestRule: getActivityIntent() returned null using default: Intent(Intent.ACTION_MAIN)
         1606083393.924 12272 12434 W lla.focus.debu: Accessing hidden method Landroid/app/Instrumentation;->execStartActivity(Landroid/content/Context;Landroid/os/IBinder;Landroid/os/IBinder;Landroid/app/Activity;Landroid/content/Intent;ILandroid/os/Bundle;)Landroid/app/Instrumentation$ActivityResult; (greylist, linking, allowed)
         1606083393.942 12272 12272 W ActivityThread: handleWindowVisibility: no activity for token android.os.BinderProxy@7cd8bcf
         1606083393.969 12272 12348 E memtrack: Couldn't load memtrack module
         1606083393.969 12272 12348 W android.os.Debug: failed to get memory consumption info: -1
         1606083393.997 12272 12272 I ActivityMonitor: Activity: org.mozilla.focus.activity.MainActivity@b261f48 is in stage: PRE_ON_CREATE
         1606083393.998 12272 12272 D LifecycleMonitor: Lifecycle status change: org.mozilla.focus.activity.MainActivity@b261f48 in: PRE_ON_CREATE
         1606083394.037 12272 12272 E lla.focus.debu: Invalid ID 0x00000000.
         1606083394.044 12272 12272 D PhoneWindow: forceLight changed to true [] from com.android.internal.policy.PhoneWindow.updateForceLightNavigationBar:4274 com.android.internal.policy.DecorView.updateColorViews:1547 com.android.internal.policy.PhoneWindow.dispatchWindowAttributesChanged:3252 android.view.Window.setFlags:1153 com.android.internal.policy.PhoneWindow.generateLayout:2474 
         1606083394.046 12272 12272 I MultiWindowDecorSupport: [INFO] isPopOver = false
         1606083394.046 12272 12272 I MultiWindowDecorSupport: updateCaptionType >> DecorView@6f7c19[], isFloating: false, isApplication: true, hasWindowDecorCaption: false, hasWindowControllerCallback: true
         1606083394.046 12272 12272 D MultiWindowDecorSupport: setCaptionType = 0, DecorView = DecorView@6f7c19[]
         1606083394.062 12272 12272 W lla.focus.debu: Accessing hidden method Landroid/view/View;->computeFitSystemWindows(Landroid/graphics/Rect;Landroid/graphics/Rect;)Z (greylist, reflection, allowed)
         1606083394.063 12272 12272 W lla.focus.debu: Accessing hidden method Landroid/view/ViewGroup;->makeOptionalFitsSystemWindows()V (greylist, reflection, allowed)
         1606083394.080 12272 12436 D libEGL  : loaded /vendor/lib/egl/libGLES_mali.so
         1606083394.089 12272 12272 D GeckoThread: State changed to LAUNCHED
         1606083394.089 12272 12446 I GeckoThread: preparing to run Gecko
         1606083394.091 12272 12272 D GeckoRuntime: Lifecycle: onCreate
--------- beginning of events
         1606083394.092 12272 12272 I am_on_create_called: [0,org.mozilla.focus.activity.MainActivity,performCreate]
--------- switch to main
         1606083394.095 12272 12272 D LifecycleMonitor: Lifecycle status change: org.mozilla.focus.activity.MainActivity@b261f48 in: CREATED
         1606083394.095 12272 12272 I ActivityMonitor: Activity: org.mozilla.focus.activity.MainActivity@b261f48 is in stage: CREATED
         1606083394.096 12272 12446 D GeckoThread: State changed to MOZGLUE_READY
         1606083394.113 12272 12272 W lla.focus.debu: Accessing hidden method Lcom/android/org/conscrypt/OpenSSLSocketImpl;->setUseSessionTickets(Z)V (greylist,core-platform-api, reflection, allowed)
         1606083394.113 12272 12272 W lla.focus.debu: Accessing hidden method Lcom/android/org/conscrypt/OpenSSLSocketImpl;->setHostname(Ljava/lang/String;)V (greylist,core-platform-api, reflection, allowed)
         1606083394.113 12272 12272 W lla.focus.debu: Accessing hidden method Lcom/android/org/conscrypt/OpenSSLSocketImpl;->getAlpnSelectedProtocol()[B (greylist,core-platform-api, reflection, allowed)
         1606083394.113 12272 12272 W lla.focus.debu: Accessing hidden method Lcom/android/org/conscrypt/OpenSSLSocketImpl;->setAlpnProtocols([B)V (greylist,core-platform-api, reflection, allowed)
         1606083394.113 12272 12272 W lla.focus.debu: Accessing hidden method Ldalvik/system/CloseGuard;->get()Ldalvik/system/CloseGuard; (greylist,core-platform-api, reflection, allowed)
         1606083394.113 12272 12272 W lla.focus.debu: Accessing hidden method Ldalvik/system/CloseGuard;->open(Ljava/lang/String;)V (greylist,core-platform-api, reflection, allowed)
         1606083394.113 12272 12272 W lla.focus.debu: Accessing hidden method Ldalvik/system/CloseGuard;->warnIfOpen()V (greylist,core-platform-api, reflection, allowed)
         1606083394.121 12272 12446 W Settings: Setting animator_duration_scale has moved from android.provider.Settings.System to android.provider.Settings.Global, returning read-only global URI.
         1606083394.123 12272 12446 E GeckoLibLoad: Load sqlite start
         1606083394.126 12272 12446 E GeckoLibLoad: Load sqlite done
         1606083394.126 12272 12446 E GeckoLibLoad: Load nss start
         1606083394.126 12272 12446 E GeckoLibLoad: Load nss done
         1606083394.148 12272 12446 E GeckoLibLoad: Loaded libs in 22.016846ms total, 0ms(20ms) user, 12ms(16ms) system, 0(25) faults
         1606083394.148 12272 12446 D GeckoThread: State changed to LIBS_READY
         1606083394.150 12272 12446 W GeckoThread: zerdatime 201268985 - runGecko
         1606083394.151 12272 12446 D GeckoProfile: Loading profile at: null name: default
         1606083394.152 12272 12446 D GeckoProfile: Created new profile dir.
         1606083394.153 12272 12446 I GeckoProfile: Enqueuing profile init.
         1606083394.155 12272 12446 D GeckoProfile: Found profile dir: /data/user/0/org.mozilla.focus.debug/files/mozilla/rfc2ck6t.default
         1606083394.155 12272 12446 D GeckoProfile: Attempting to write new client ID properties
         1606083394.156 12272 12446 D GeckoProfile: Creating profile dir: /data/user/0/org.mozilla.focus.debug/files/mozilla/rfc2ck6t.default
         1606083394.247 12272 12446 I Gecko:DumpUtils: Fifo watcher disabled via pref.
         1606083394.266 12272 12446 D GeckoSysInfo: System memory: 5620MB.
         1606083394.267 12272 12446 W lla.focus.debu: Accessing hidden method Landroid/os/MessageQueue;->next()Landroid/os/Message; (greylist, JNI, allowed)
         1606083394.267 12272 12446 W lla.focus.debu: Accessing hidden field Landroid/os/MessageQueue;->mMessages:Landroid/os/Message; (greylist, JNI, allowed)
         1606083394.268 12272 12446 W lla.focus.debu: Accessing hidden field Ljava/lang/Boolean;->value:Z (greylist-max-p, JNI, allowed)
         1606083394.268 12272 12446 W lla.focus.debu: Accessing hidden field Ljava/lang/Integer;->value:I (greylist-max-p, JNI, allowed)
         1606083394.268 12272 12446 W lla.focus.debu: Accessing hidden field Ljava/lang/Double;->value:D (greylist-max-p, JNI, allowed)
         1606083394.269 12272 12446 D GeckoThread: State changed to JNI_READY
         1606083394.279 12272 12462 D ServiceAllocator: org.mozilla.gecko.process.GeckoChildProcessServices$tab0 updateBindings: BACKGROUND priority, 0 importance, 2 successful binds, 0 failed binds, 0 successful unbinds
         1606083394.300 12474 12474 I ocus.debug:tab: Late-enabling -Xcheck:jni
         1606083394.330 12474 12474 E ocus.debug:tab: Unknown bits set in runtime_flags: 0x8000
         1606083394.365 12474 12474 D ActivityThread: setConscryptValidator
         1606083394.365 12474 12474 D ActivityThread: setConscryptValidator - put
         1606083394.451 12272 12272 D LifecycleMonitor: Lifecycle status change: org.mozilla.focus.activity.MainActivity@b261f48 in: STARTED
         1606083394.451 12272 12272 I ActivityMonitor: Activity: org.mozilla.focus.activity.MainActivity@b261f48 is in stage: STARTED
--------- switch to events
         1606083394.451 12272 12272 I am_on_start_called: [0,org.mozilla.focus.activity.MainActivity,handleStartActivity]
--------- switch to main
         1606083394.480 12272 12272 D GeckoRuntime: Lifecycle: onStart
         1606083394.509 12272 12272 D LifecycleMonitor: Lifecycle status change: org.mozilla.focus.activity.MainActivity@b261f48 in: RESUMED
         1606083394.510 12272 12272 I ActivityMonitor: Activity: org.mozilla.focus.activity.MainActivity@b261f48 is in stage: RESUMED
--------- switch to events
         1606083394.510 12272 12272 I am_on_resume_called: [0,org.mozilla.focus.activity.MainActivity,RESUME_ACTIVITY]
--------- switch to main
         1606083394.511 12272 12272 D GeckoLocales: No selected locale. No correction needed.
         1606083394.521 12272 12272 D GeckoRuntime: Lifecycle: onResume
         1606083394.522 12272 12272 D GeckoNetworkManager: Incoming event start for state OffNoListeners -> OnNoListeners
         1606083394.530 12272 12272 D GeckoNetworkManager: New network state: UP, WIFI, WIFI
         1606083394.558 12272 12272 I ViewRootImpl@ece76c9[MainActivity]: setView = com.android.internal.policy.DecorView@6f7c19 TM=false MM=false
         1606083394.580 12272 12272 D StrictMode: StrictMode policy violation; ~duration=475 ms: android.os.strictmode.DiskReadViolation
         1606083394.580 12272 12272 D StrictMode: 	at android.os.StrictMode$AndroidBlockGuardPolicy.onReadFromDisk(StrictMode.java:1556)
         1606083394.580 12272 12272 D StrictMode: 	at libcore.io.BlockGuardOs.open(BlockGuardOs.java:247)
         1606083394.580 12272 12272 D StrictMode: 	at libcore.io.ForwardingOs.open(ForwardingOs.java:167)
         1606083394.580 12272 12272 D StrictMode: 	at android.app.ActivityThread$AndroidOs.open(ActivityThread.java:8044)
         1606083394.580 12272 12272 D StrictMode: 	at libcore.io.IoBridge.open(IoBridge.java:482)
         1606083394.580 12272 12272 D StrictMode: 	at java.io.FileInputStream.<init>(FileInputStream.java:159)
         1606083394.580 12272 12272 D StrictMode: 	at org.mozilla.gecko.util.DebugConfig.fromFile(DebugConfig.java:49)
         1606083394.580 12272 12272 D StrictMode: 	at org.mozilla.geckoview.GeckoRuntime.init(GeckoRuntime.java:361)
         1606083394.580 12272 12272 D StrictMode: 	at org.mozilla.geckoview.GeckoRuntime.create(GeckoRuntime.java:489)
         1606083394.580 12272 12272 D StrictMode: 	at org.mozilla.focus.web.GeckoWebViewProvider.createGeckoRuntime(GeckoWebViewProvider.kt:101)
         1606083394.580 12272 12272 D StrictMode: 	at org.mozilla.focus.web.GeckoWebViewProvider.preload(GeckoWebViewProvider.kt:59)
         1606083394.580 12272 12272 D StrictMode: 	at org.mozilla.focus.web.WebViewProvider.preload(WebViewProvider.kt:23)
         1606083394.580 12272 12272 D StrictMode: 	at org.mozilla.focus.activity.MainActivity.onCreate(MainActivity.kt:87)
         1606083394.580 12272 12272 D StrictMode: 	at android.app.Activity.performCreate(Activity.java:7963)
         1606083394.580 12272 12272 D StrictMode: 	at android.app.Activity.performCreate(Activity.java:7952)
         1606083394.580 12272 12272 D StrictMode: 	at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1307)
         1606083394.580 12272 12272 D StrictMode: 	at androidx.test.runner.MonitoringInstrumentation.callActivityOnCreate(MonitoringInstrumentation.java:702)
         1606083394.580 12272 12272 D StrictMode: 	at com.fluentbuild.apollo.runner.client.androidx.AndroidXJUnitRunner.access$callActivityOnCreate$s281125429(AndroidXJUnitRunner.kt:10)
         1606083394.580 12272 12272 D StrictMode: 	at com.fluentbuild.apollo.runner.client.androidx.AndroidXJUnitRunner$callActivityOnCreate$1.invoke(AndroidXJUnitRunner.kt:40)
         1606083394.580 12272 12272 D StrictMode: 	at com.fluentbuild.apollo.runner.client.androidx.AndroidXJUnitRunner$callActivityOnCreate$1.invoke(AndroidXJUnitRunner.kt:10)
         1606083394.580 12272 12272 D StrictMode: 	at com.fluentbuild.apollo.runner.client.instrumentation.lifecycle.ActivityMonitor.onCallActivityOnCreate(ActivityMonitor.kt:41)
         1606083394.580 12272 12272 D StrictMode: 	at com.fluentbuild.apollo.runner.client.androidx.RunnerHelper.onCallActivityOnCreate(RunnerHelper.kt:70)
         1606083394.580 12272 12272 D StrictMode: 	at com.fluentbuild.apollo.runner.client.androidx.AndroidXJUnitRunner.callActivityOnCreate(AndroidXJUnitRunner.kt:39)
         1606083394.580 12272 12272 D StrictMode: 	at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:3629)
         1606083394.580 12272 12272 D StrictMode: 	at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:3806)
         1606083394.580 12272 12272 D StrictMode: 	at android.app.servertransaction.LaunchActivityItem.execute(LaunchActivityItem.java:83)
         1606083394.580 12272 12272 D StrictMode: 	at android.app.servertransaction.TransactionExecutor.executeCallbacks(TransactionExecutor.java:135)
         1606083394.580 12272 12272 D StrictMode: 	at android.app.servertransaction.TransactionExecutor.execute(TransactionExecutor.java:95)
         1606083394.580 12272 12272 D StrictMode: 	at android.app.ActivityThread$H.handleMessage(ActivityThread.java:2267)
         1606083394.580 12272 12272 D StrictMode: 	at android.os.Handler.dispatchMessage(Handler.java:107)
         1606083394.580 12272 12272 D StrictMode: 	at android.os.Looper.loop(Looper.java:237)
         1606083394.580 12272 12272 D StrictMode: 	at android.app.ActivityThread.main(ActivityThread.java:8167)
         1606083394.580 12272 12272 D StrictMode: 	at java.lang.reflect.Method.invoke(Native Method)
         1606083394.580 12272 12272 D StrictMode: 	at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:496)
         1606083394.580 12272 12272 D StrictMode: 	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1100)
         1606083394.592 12272 12272 D StrictMode: StrictMode policy violation; ~duration=360 ms: android.os.strictmode.DiskReadViolation
         1606083394.592 12272 12272 D StrictMode: 	at android.os.StrictMode$AndroidBlockGuardPolicy.onReadFromDisk(StrictMode.java:1556)
         1606083394.592 12272 12272 D StrictMode: 	at libcore.io.BlockGuardOs.access(BlockGuardOs.java:69)
         1606083394.592 12272 12272 D StrictMode: 	at libcore.io.ForwardingOs.access(ForwardingOs.java:73)
         1606083394.592 12272 12272 D StrictMode: 	at android.app.ActivityThread$AndroidOs.access(ActivityThread.java:8035)
         1606083394.592 12272 12272 D StrictMode: 	at java.io.UnixFileSystem.checkAccess(UnixFileSystem.java:281)
         1606083394.592 12272 12272 D StrictMode: 	at java.io.File.exists(File.java:815)
         1606083394.592 12272 12272 D StrictMode: 	at android.app.ContextImpl.ensurePrivateDirExists(ContextImpl.java:674)
         1606083394.592 12272 12272 D StrictMode: 	at android.app.ContextImpl.ensurePrivateDirExists(ContextImpl.java:665)
         1606083394.592 12272 12272 D StrictMode: 	at android.app.ContextImpl.getPreferencesDir(ContextImpl.java:621)
         1606083394.592 12272 12272 D StrictMode: 	at android.app.ContextImpl.getSharedPreferencesPath(ContextImpl.java:830)
         1606083394.592 12272 12272 D StrictMode: 	at android.app.ContextImpl.getSharedPreferences(ContextImpl.java:458)
         1606083394.592 12272 12272 D StrictMode: 	at android.content.ContextWrapper.getSharedPreferences(ContextWrapper.java:184)
         1606083394.592 12272 12272 D StrictMode: 	at mozilla.components.service.fretboard.ExperimentEvaluator.evaluate(ExperimentEvaluator.kt:39)
         1606083394.592 12272 12272 D StrictMode: 	at mozilla.components.service.fretboard.ExperimentEvaluator.evaluate$default(ExperimentEvaluator.kt:35)
         1606083394.592 12272 12272 D StrictMode: 	at mozilla.components.service.fretboard.Fretboard.isInExperiment(Fretboard.kt:74)
         1606083394.592 12272 12272 D StrictMode: 	at org.mozilla.focus.utils.ExperimentsKt.isInExperiment(Experiments.kt:24)
         1606083394.592 12272 12272 D StrictMode: 	at org.mozilla.focus.tips.TipManager.getNextTipIfAvailable(TipManager.kt:226)
         1606083394.592 12272 12272 D StrictMode: 	at org.mozilla.focus.fragment.UrlInputFragment.updateTipsLabel(UrlInputFragment.kt:223)
         1606083394.592 12272 12272 D StrictMode: 	at org.mozilla.focus.fragment.UrlInputFragment.onViewCreated(UrlInputFragment.kt:346)
         1606083394.592 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.moveToState(FragmentManagerImpl.java:892)
         1606083394.592 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.moveFragmentToExpectedState(FragmentManagerImpl.java:1238)
         1606083394.592 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.moveToState(FragmentManagerImpl.java:1303)
         1606083394.592 12272 12272 D StrictMode: 	at androidx.fragment.app.BackStackRecord.executeOps(BackStackRecord.java:439)
         1606083394.592 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.executeOps(FragmentManagerImpl.java:2079)
         1606083394.592 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.executeOpsTogether(FragmentManagerImpl.java:1869)
         1606083394.592 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.removeRedundantOperationsAndExecute(FragmentManagerImpl.java:1824)
         1606083394.592 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.execPendingActions(FragmentManagerImpl.java:1727)
         1606083394.592 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.dispatchStateChange(FragmentManagerImpl.java:2663)
         1606083394.592 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.dispatchActivityCreated(FragmentManagerImpl.java:2613)
         1606083394.592 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentController.dispatchActivityCreated(FragmentController.java:246)
         1606083394.592 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentActivity.onStart(FragmentActivity.java:542)
         1606083394.592 12272 12272 D StrictMode: 	at androidx.appcompat.app.AppCompatActivity.onStart(AppCompatActivity.java:201)
         1606083394.592 12272 12272 D StrictMode: 	at android.app.Instrumentation.callActivityOnStart(Instrumentation.java:1433)
         1606083394.592 12272 12272 D StrictMode: 	at androidx.test.runner.MonitoringInstrumentation.callActivityOnStart(MonitoringInstrumentation.java:714)
         1606083394.592 12272 12272 D StrictMode: 	at com.fluentbuild.apollo.runner.client.androidx.AndroidXJUnitRunner.access$callActivityOnStart$s281125429(AndroidXJUnitRunner.kt:10)
         1606083394.592 12272 12272 D StrictMode: 	at com.fluentbuild.apollo.runner.client.androidx.AndroidXJUnitRunner$callActivityOnStart$1.invoke(AndroidXJUnitRunner.kt:56)
         1606083394.592 12272 12272 D StrictMode: 	at com.fluentbuild.apollo.runner.client.androidx.AndroidXJUnitRunner$callActivityOnStart$1.invoke(AndroidXJUnitRunner.kt:10)
         1606083394.592 12272 12272 D StrictMode: 	at com.fluentbuild.apollo.runner.client.instrumentation.lifecycle.ActivityMonitor.onCallActivityOnStart(ActivityMonitor.kt:57)
         1606083394.592 12272 12272 D StrictMode: 	at com.fluentbuild.apollo.runner.client.androidx.RunnerHelper.onCallActivityOnStart(RunnerHelper.kt:83)
         1606083394.592 12272 12272 D StrictMode: 	at com.fluentbuild.apollo.runner.client.androidx.AndroidXJUnitRunner.callActivityOnStart(AndroidXJUnitRunner.kt:55)
         1606083394.592 12272 12272 D StrictMode: 	at android.app.Activity.performStart(Activity.java:7986)
         1606083394.592 12272 12272 D StrictMode: 	at android.app.ActivityThread.handleStartActivity(ActivityThread.java:3677)
         1606083394.592 12272 12272 D StrictMode: 	at android.app.servertransaction.TransactionExecutor.performLifecycleSequence(TransactionExecutor.java:221)
         1606083394.592 12272 12272 D StrictMode: 	at android.app.servertransaction.TransactionExecutor.cycleToPath(TransactionExecutor.java:201)
         1606083394.592 12272 12272 D StrictMode: 	at android.app.servertransaction.TransactionExecutor.execute
         1606083394.602 12272 12272 D StrictMode: StrictMode policy violation; ~duration=350 ms: android.os.strictmode.DiskReadViolation
         1606083394.602 12272 12272 D StrictMode: 	at android.os.StrictMode$AndroidBlockGuardPolicy.onReadFromDisk(StrictMode.java:1556)
         1606083394.602 12272 12272 D StrictMode: 	at android.database.sqlite.SQLiteConnection.applyBlockGuardPolicy(SQLiteConnection.java:1524)
         1606083394.602 12272 12272 D StrictMode: 	at android.database.sqlite.SQLiteConnection.executeForCursorWindow(SQLiteConnection.java:1193)
         1606083394.602 12272 12272 D StrictMode: 	at android.database.sqlite.SQLiteSession.executeForCursorWindow(SQLiteSession.java:838)
         1606083394.602 12272 12272 D StrictMode: 	at android.database.sqlite.SQLiteQuery.fillWindow(SQLiteQuery.java:62)
         1606083394.602 12272 12272 D StrictMode: 	at android.database.sqlite.SQLiteCursor.fillWindow(SQLiteCursor.java:165)
         1606083394.602 12272 12272 D StrictMode: 	at android.database.sqlite.SQLiteCursor.getCount(SQLiteCursor.java:152)
         1606083394.602 12272 12272 D StrictMode: 	at android.database.AbstractCursor.moveToPosition(AbstractCursor.java:232)
         1606083394.602 12272 12272 D StrictMode: 	at android.database.AbstractCursor.moveToFirst(AbstractCursor.java:271)
         1606083394.602 12272 12272 D StrictMode: 	at com.android.server.enterprise.storage.EdmStorageProviderBase.getValues(EdmStorageProviderBase.java:388)
         1606083394.602 12272 12272 D StrictMode: 	at com.android.server.enterprise.application.ApplicationPolicy.queryAllDefaultAppIntents(ApplicationPolicy.java:12177)
         1606083394.602 12272 12272 D StrictMode: 	at com.android.server.enterprise.application.ApplicationPolicy.retrieveDefaultAppFromDb(ApplicationPolicy.java:12216)
         1606083394.602 12272 12272 D StrictMode: 	at com.android.server.enterprise.application.ApplicationPolicy.getDefaultApplicationInternal(ApplicationPolicy.java:11523)
         1606083394.602 12272 12272 D StrictMode: 	at com.android.server.pm.PackageManagerService.filterCandidatesWithDomainPreferredActivitiesLPr(PackageManagerService.java:9360)
         1606083394.602 12272 12272 D StrictMode: 	at com.android.server.pm.PackageManagerService.queryIntentActivitiesInternal(PackageManagerService.java:8946)
         1606083394.602 12272 12272 D StrictMode: 	at com.android.server.pm.PackageManagerService.queryIntentActivitiesInternal(PackageManagerService.java:8707)
         1606083394.602 12272 12272 D StrictMode: 	at com.android.server.pm.PackageManagerService.queryIntentActivities(PackageManagerService.java:8678)
         1606083394.602 12272 12272 D StrictMode: 	at android.content.pm.IPackageManager$Stub.onTransact(IPackageManager.java:2958)
         1606083394.602 12272 12272 D StrictMode: 	at com.android.server.pm.PackageManagerService.onTransact(PackageManagerService.java:5160)
         1606083394.602 12272 12272 D StrictMode: 	at android.os.Binder.execTransactInternal(Binder.java:1056)
         1606083394.602 12272 12272 D StrictMode: 	at android.os.Binder.execTransact(Binder.java:1029)
         1606083394.602 12272 12272 D StrictMode: # via Binder call with stack:
         1606083394.602 12272 12272 D StrictMode: 	at android.os.StrictMode.readAndHandleBinderCallViolations(StrictMode.java:2274)
         1606083394.602 12272 12272 D StrictMode: 	at android.os.Parcel.readExceptionCode(Parcel.java:2034)
         1606083394.602 12272 12272 D StrictMode: 	at android.os.Parcel.readException(Parcel.java:2001)
         1606083394.602 12272 12272 D StrictMode: 	at android.content.pm.IPackageManager$Stub$Proxy.queryIntentActivities(IPackageManager.java:6772)
         1606083394.602 12272 12272 D StrictMode: 	at android.app.ApplicationPackageManager.queryIntentActivitiesAsUser(ApplicationPackageManager.java:1243)
         1606083394.602 12272 12272 D StrictMode: 	at android.app.ApplicationPackageManager.queryIntentActivities(ApplicationPackageManager.java:1234)
         1606083394.602 12272 12272 D StrictMode: 	at org.mozilla.focus.utils.Browsers.resolveBrowsers(Browsers.java:126)
         1606083394.602 12272 12272 D StrictMode: 	at org.mozilla.focus.utils.Browsers.<init>(Browsers.java:86)
         1606083394.602 12272 12272 D StrictMode: 	at org.mozilla.focus.tips.Tip$Companion.createDefaultBrowserTip(TipManager.kt:94)
         1606083394.602 12272 12272 D StrictMode: 	at org.mozilla.focus.tips.TipManager.addDefaultBrowserTip(TipManager.kt:292)
         1606083394.602 12272 12272 D StrictMode: 	at org.mozilla.focus.tips.TipManager.populateListOfTips(TipManager.kt:216)
         1606083394.602 12272 12272 D StrictMode: 	at org.mozilla.focus.tips.TipManager.getNextTipIfAvailable(TipManager.kt:232)
         1606083394.602 12272 12272 D StrictMode: 	at org.mozilla.focus.fragment.UrlInputFragment.updateTipsLabel(UrlInputFragment.kt:223)
         1606083394.602 12272 12272 D StrictMode: 	at org.mozilla.focus.fragment.UrlInputFragment.onViewCreated(UrlInputFragment.kt:346)
         1606083394.602 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.moveToState(FragmentManagerImpl.java:892)
         1606083394.602 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.moveFragmentToExpectedState(FragmentManagerImpl.java:1238)
         1606083394.602 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.moveToState(FragmentManagerImpl.java:1303)
         1606083394.602 12272 12272 D StrictMode: 	at androidx.fragment.app.BackStackRecord.executeOps(BackStackRecord.java:439)
         1606083394.602 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.executeOps(FragmentManagerImpl.java:2079)
         1606083394.602 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.executeOpsTogether(FragmentManagerImpl.java:1869)
         1606083394.602 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.removeRedundantOperationsAndExecute(FragmentManagerImpl.java:1824)
         1606083394.602 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.execPendingActions(FragmentManagerImpl.java:1727)
         1606083394.602 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.dispatchStateChange(FragmentManagerImpl.java:2663)
         1606083394.602 12272 12272 D StrictMode: 	at androi
         1606083394.604 12272 12272 D StrictMode: StrictMode policy violation; ~duration=348 ms: android.os.strictmode.DiskReadViolation
         1606083394.604 12272 12272 D StrictMode: 	at android.os.StrictMode$AndroidBlockGuardPolicy.onReadFromDisk(StrictMode.java:1556)
         1606083394.604 12272 12272 D StrictMode: 	at android.database.sqlite.SQLiteConnection.applyBlockGuardPolicy(SQLiteConnection.java:1524)
         1606083394.604 12272 12272 D StrictMode: 	at android.database.sqlite.SQLiteConnection.executeForCursorWindow(SQLiteConnection.java:1193)
         1606083394.604 12272 12272 D StrictMode: 	at android.database.sqlite.SQLiteSession.executeForCursorWindow(SQLiteSession.java:838)
         1606083394.604 12272 12272 D StrictMode: 	at android.database.sqlite.SQLiteQuery.fillWindow(SQLiteQuery.java:62)
         1606083394.604 12272 12272 D StrictMode: 	at android.database.sqlite.SQLiteCursor.fillWindow(SQLiteCursor.java:165)
         1606083394.604 12272 12272 D StrictMode: 	at android.database.sqlite.SQLiteCursor.getCount(SQLiteCursor.java:152)
         1606083394.604 12272 12272 D StrictMode: 	at android.database.AbstractCursor.moveToPosition(AbstractCursor.java:232)
         1606083394.604 12272 12272 D StrictMode: 	at android.database.AbstractCursor.moveToFirst(AbstractCursor.java:271)
         1606083394.604 12272 12272 D StrictMode: 	at com.android.server.enterprise.storage.EdmStorageProviderBase.getValues(EdmStorageProviderBase.java:388)
         1606083394.604 12272 12272 D StrictMode: 	at com.android.server.enterprise.application.ApplicationPolicy.queryAllDefaultAppIntents(ApplicationPolicy.java:12177)
         1606083394.604 12272 12272 D StrictMode: 	at com.android.server.enterprise.application.ApplicationPolicy.retrieveDefaultAppFromDb(ApplicationPolicy.java:12216)
         1606083394.604 12272 12272 D StrictMode: 	at com.android.server.enterprise.application.ApplicationPolicy.getDefaultApplicationInternal(ApplicationPolicy.java:11523)
         1606083394.604 12272 12272 D StrictMode: 	at com.android.server.pm.PackageManagerService.filterCandidatesWithDomainPreferredActivitiesLPr(PackageManagerService.java:9360)
         1606083394.604 12272 12272 D StrictMode: 	at com.android.server.pm.PackageManagerService.queryIntentActivitiesInternal(PackageManagerService.java:8946)
         1606083394.604 12272 12272 D StrictMode: 	at com.android.server.pm.PackageManagerService.queryIntentActivitiesInternal(PackageManagerService.java:8707)
         1606083394.604 12272 12272 D StrictMode: 	at com.android.server.pm.PackageManagerService.queryIntentActivities(PackageManagerService.java:8678)
         1606083394.604 12272 12272 D StrictMode: 	at com.android.server.pm.PackageManagerService.getDefaultBrowserPackageName(PackageManagerService.java:17004)
         1606083394.604 12272 12272 D StrictMode: 	at com.android.server.pm.PackageManagerService.filterCandidatesWithDomainPreferredActivitiesLPr(PackageManagerService.java:9460)
         1606083394.604 12272 12272 D StrictMode: 	at com.android.server.pm.PackageManagerService.queryIntentActivitiesInternal(PackageManagerService.java:8946)
         1606083394.604 12272 12272 D StrictMode: 	at com.android.server.pm.PackageManagerService.queryIntentActivitiesInternal(PackageManagerService.java:8707)
         1606083394.604 12272 12272 D StrictMode: 	at com.android.server.pm.PackageManagerService.queryIntentActivities(PackageManagerService.java:8678)
         1606083394.604 12272 12272 D StrictMode: 	at android.content.pm.IPackageManager$Stub.onTransact(IPackageManager.java:2958)
         1606083394.604 12272 12272 D StrictMode: 	at com.android.server.pm.PackageManagerService.onTransact(PackageManagerService.java:5160)
         1606083394.604 12272 12272 D StrictMode: 	at android.os.Binder.execTransactInternal(Binder.java:1056)
         1606083394.604 12272 12272 D StrictMode: 	at android.os.Binder.execTransact(Binder.java:1029)
         1606083394.604 12272 12272 D StrictMode: # via Binder call with stack:
         1606083394.604 12272 12272 D StrictMode: 	at android.os.StrictMode.readAndHandleBinderCallViolations(StrictMode.java:2274)
         1606083394.604 12272 12272 D StrictMode: 	at android.os.Parcel.readExceptionCode(Parcel.java:2034)
         1606083394.604 12272 12272 D StrictMode: 	at android.os.Parcel.readException(Parcel.java:2001)
         1606083394.604 12272 12272 D StrictMode: 	at android.content.pm.IPackageManager$Stub$Proxy.queryIntentActivities(IPackageManager.java:6772)
         1606083394.604 12272 12272 D StrictMode: 	at android.app.ApplicationPackageManager.queryIntentActivitiesAsUser(ApplicationPackageManager.java:1243)
         1606083394.604 12272 12272 D StrictMode: 	at android.app.ApplicationPackageManager.queryIntentActivities(ApplicationPackageManager.java:1234)
         1606083394.604 12272 12272 D StrictMode: 	at org.mozilla.focus.utils.Browsers.resolveBrowsers(Browsers.java:126)
         1606083394.604 12272 12272 D StrictMode: 	at org.mozilla.focus.utils.Browsers.<init>(Browsers.java:86)
         1606083394.604 12272 12272 D StrictMode: 	at org.mozilla.focus.tips.Tip$Companion.createDefaultBrowserTip(TipManager.kt:94)
         1606083394.604 12272 12272 D StrictMode: 	at org.mozilla.focus.tips.TipManager.addDefaultBrowserTip(TipManager.kt:292)
         1606083394.604 12272 12272 D StrictMode: 	at org.mozilla.focus.tips.TipManager.populateListOfTips(TipManager.kt:216)
         1606083394.604 12272 12272 D StrictMode: 	at org.mozilla.focus.tips.TipManager.getNextTipIfAvailable(TipManager.kt:232)
         1606083394.604 12272 12272 D StrictMode: 	at org.mozilla.focus.fragment.UrlInputFragment.updateTipsLabel(UrlInputFragment.kt:223)
         1606083394.604 12272 12272 D StrictMode: 	at org.mozilla.focus.fragment.UrlInputFragment.onViewCreated(UrlInputFragment.kt:346)
         1606083394.604 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.moveToState(FragmentManagerImpl.java:892)
         1606083394.604 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.moveFragmentToExpectedState(FragmentManagerImpl.java:1238)
         1606083394.604 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.moveToState(FragmentManagerImpl.java:1303)
         1606083394.604 12272 12272 D StrictMode: 	at androidx.
         1606083394.605 12272 12272 D StrictMode: StrictMode policy violation; ~duration=342 ms: android.os.strictmode.DiskReadViolation
         1606083394.605 12272 12272 D StrictMode: 	at android.os.StrictMode$AndroidBlockGuardPolicy.onReadFromDisk(StrictMode.java:1556)
         1606083394.605 12272 12272 D StrictMode: 	at android.database.sqlite.SQLiteConnection.applyBlockGuardPolicy(SQLiteConnection.java:1524)
         1606083394.605 12272 12272 D StrictMode: 	at android.database.sqlite.SQLiteConnection.executeForCursorWindow(SQLiteConnection.java:1193)
         1606083394.605 12272 12272 D StrictMode: 	at android.database.sqlite.SQLiteSession.executeForCursorWindow(SQLiteSession.java:838)
         1606083394.605 12272 12272 D StrictMode: 	at android.database.sqlite.SQLiteQuery.fillWindow(SQLiteQuery.java:62)
         1606083394.605 12272 12272 D StrictMode: 	at android.database.sqlite.SQLiteCursor.fillWindow(SQLiteCursor.java:165)
         1606083394.605 12272 12272 D StrictMode: 	at android.database.sqlite.SQLiteCursor.getCount(SQLiteCursor.java:152)
         1606083394.605 12272 12272 D StrictMode: 	at android.database.AbstractCursor.moveToPosition(AbstractCursor.java:232)
         1606083394.605 12272 12272 D StrictMode: 	at android.database.AbstractCursor.moveToFirst(AbstractCursor.java:271)
         1606083394.605 12272 12272 D StrictMode: 	at com.android.server.enterprise.storage.EdmStorageProviderBase.getValues(EdmStorageProviderBase.java:388)
         1606083394.605 12272 12272 D StrictMode: 	at com.android.server.enterprise.application.ApplicationPolicy.queryAllDefaultAppIntents(ApplicationPolicy.java:12177)
         1606083394.605 12272 12272 D StrictMode: 	at com.android.server.enterprise.application.ApplicationPolicy.retrieveDefaultAppFromDb(ApplicationPolicy.java:12216)
         1606083394.605 12272 12272 D StrictMode: 	at com.android.server.enterprise.application.ApplicationPolicy.getDefaultApplicationInternal(ApplicationPolicy.java:11523)
         1606083394.605 12272 12272 D StrictMode: 	at com.android.server.pm.PackageManagerService.getDefaultBrowserPackageName(PackageManagerService.java:17008)
         1606083394.605 12272 12272 D StrictMode: 	at com.android.server.pm.PackageManagerService.filterCandidatesWithDomainPreferredActivitiesLPr(PackageManagerService.java:9460)
         1606083394.605 12272 12272 D StrictMode: 	at com.android.server.pm.PackageManagerService.queryIntentActivitiesInternal(PackageManagerService.java:8946)
         1606083394.605 12272 12272 D StrictMode: 	at com.android.server.pm.PackageManagerService.queryIntentActivitiesInternal(PackageManagerService.java:8707)
         1606083394.605 12272 12272 D StrictMode: 	at com.android.server.pm.PackageManagerService.queryIntentActivities(PackageManagerService.java:8678)
         1606083394.605 12272 12272 D StrictMode: 	at android.content.pm.IPackageManager$Stub.onTransact(IPackageManager.java:2958)
         1606083394.605 12272 12272 D StrictMode: 	at com.android.server.pm.PackageManagerService.onTransact(PackageManagerService.java:5160)
         1606083394.605 12272 12272 D StrictMode: 	at android.os.Binder.execTransactInternal(Binder.java:1056)
         1606083394.605 12272 12272 D StrictMode: 	at android.os.Binder.execTransact(Binder.java:1029)
         1606083394.605 12272 12272 D StrictMode: # via Binder call with stack:
         1606083394.605 12272 12272 D StrictMode: 	at android.os.StrictMode.readAndHandleBinderCallViolations(StrictMode.java:2274)
         1606083394.605 12272 12272 D StrictMode: 	at android.os.Parcel.readExceptionCode(Parcel.java:2034)
         1606083394.605 12272 12272 D StrictMode: 	at android.os.Parcel.readException(Parcel.java:2001)
         1606083394.605 12272 12272 D StrictMode: 	at android.content.pm.IPackageManager$Stub$Proxy.queryIntentActivities(IPackageManager.java:6772)
         1606083394.605 12272 12272 D StrictMode: 	at android.app.ApplicationPackageManager.queryIntentActivitiesAsUser(ApplicationPackageManager.java:1243)
         1606083394.605 12272 12272 D StrictMode: 	at android.app.ApplicationPackageManager.queryIntentActivities(ApplicationPackageManager.java:1234)
         1606083394.605 12272 12272 D StrictMode: 	at org.mozilla.focus.utils.Browsers.resolveBrowsers(Browsers.java:126)
         1606083394.605 12272 12272 D StrictMode: 	at org.mozilla.focus.utils.Browsers.<init>(Browsers.java:86)
         1606083394.605 12272 12272 D StrictMode: 	at org.mozilla.focus.tips.Tip$Companion.createDefaultBrowserTip(TipManager.kt:94)
         1606083394.605 12272 12272 D StrictMode: 	at org.mozilla.focus.tips.TipManager.addDefaultBrowserTip(TipManager.kt:292)
         1606083394.605 12272 12272 D StrictMode: 	at org.mozilla.focus.tips.TipManager.populateListOfTips(TipManager.kt:216)
         1606083394.605 12272 12272 D StrictMode: 	at org.mozilla.focus.tips.TipManager.getNextTipIfAvailable(TipManager.kt:232)
         1606083394.605 12272 12272 D StrictMode: 	at org.mozilla.focus.fragment.UrlInputFragment.updateTipsLabel(UrlInputFragment.kt:223)
         1606083394.605 12272 12272 D StrictMode: 	at org.mozilla.focus.fragment.UrlInputFragment.onViewCreated(UrlInputFragment.kt:346)
         1606083394.605 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.moveToState(FragmentManagerImpl.java:892)
         1606083394.605 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.moveFragmentToExpectedState(FragmentManagerImpl.java:1238)
         1606083394.605 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.moveToState(FragmentManagerImpl.java:1303)
         1606083394.605 12272 12272 D StrictMode: 	at androidx.fragment.app.BackStackRecord.executeOps(BackStackRecord.java:439)
         1606083394.605 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.executeOps(FragmentManagerImpl.java:2079)
         1606083394.605 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.executeOpsTogether(FragmentManagerImpl.java:1869)
         1606083394.605 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.removeRedundantOperationsAndExecute(FragmentManagerImpl.java:1824)
         1606083394.605 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.execPendingActions(FragmentManagerImpl.java:17
         1606083394.616 12272 12272 D StrictMode: StrictMode policy violation; ~duration=306 ms: android.os.strictmode.DiskReadViolation
         1606083394.616 12272 12272 D StrictMode: 	at android.os.StrictMode$AndroidBlockGuardPolicy.onReadFromDisk(StrictMode.java:1556)
         1606083394.616 12272 12272 D StrictMode: 	at android.database.sqlite.SQLiteConnection.applyBlockGuardPolicy(SQLiteConnection.java:1524)
         1606083394.616 12272 12272 D StrictMode: 	at android.database.sqlite.SQLiteConnection.executeForCursorWindow(SQLiteConnection.java:1193)
         1606083394.616 12272 12272 D StrictMode: 	at android.database.sqlite.SQLiteSession.executeForCursorWindow(SQLiteSession.java:838)
         1606083394.616 12272 12272 D StrictMode: 	at android.database.sqlite.SQLiteQuery.fillWindow(SQLiteQuery.java:62)
         1606083394.616 12272 12272 D StrictMode: 	at android.database.sqlite.SQLiteCursor.fillWindow(SQLiteCursor.java:165)
         1606083394.616 12272 12272 D StrictMode: 	at android.database.sqlite.SQLiteCursor.getCount(SQLiteCursor.java:152)
         1606083394.616 12272 12272 D StrictMode: 	at android.database.AbstractCursor.moveToPosition(AbstractCursor.java:232)
         1606083394.616 12272 12272 D StrictMode: 	at android.database.AbstractCursor.moveToFirst(AbstractCursor.java:271)
         1606083394.616 12272 12272 D StrictMode: 	at com.android.server.enterprise.storage.EdmStorageProviderBase.getValues(EdmStorageProviderBase.java:388)
         1606083394.616 12272 12272 D StrictMode: 	at com.android.server.enterprise.application.ApplicationPolicy.queryAllDefaultAppIntents(ApplicationPolicy.java:12177)
         1606083394.616 12272 12272 D StrictMode: 	at com.android.server.enterprise.application.ApplicationPolicy.retrieveDefaultAppFromDb(ApplicationPolicy.java:12216)
         1606083394.616 12272 12272 D StrictMode: 	at com.android.server.enterprise.application.ApplicationPolicy.getDefaultApplicationInternal(ApplicationPolicy.java:11523)
         1606083394.616 12272 12272 D StrictMode: 	at com.android.server.pm.PackageManagerService.filterCandidatesWithDomainPreferredActivitiesLPr(PackageManagerService.java:9360)
         1606083394.616 12272 12272 D StrictMode: 	at com.android.server.pm.PackageManagerService.queryIntentActivitiesInternal(PackageManagerService.java:8946)
         1606083394.616 12272 12272 D StrictMode: 	at com.android.server.pm.PackageManagerService.resolveIntentInternal(PackageManagerService.java:7854)
         1606083394.616 12272 12272 D StrictMode: 	at com.android.server.pm.PackageManagerService.resolveIntent(PackageManagerService.java:7824)
         1606083394.616 12272 12272 D StrictMode: 	at android.content.pm.IPackageManager$Stub.onTransact(IPackageManager.java:2887)
         1606083394.616 12272 12272 D StrictMode: 	at com.android.server.pm.PackageManagerService.onTransact(PackageManagerService.java:5160)
         1606083394.616 12272 12272 D StrictMode: 	at android.os.Binder.execTransactInternal(Binder.java:1056)
         1606083394.616 12272 12272 D StrictMode: 	at android.os.Binder.execTransact(Binder.java:1029)
         1606083394.616 12272 12272 D StrictMode: # via Binder call with stack:
         1606083394.616 12272 12272 D StrictMode: 	at android.os.StrictMode.readAndHandleBinderCallViolations(StrictMode.java:2274)
         1606083394.616 12272 12272 D StrictMode: 	at android.os.Parcel.readExceptionCode(Parcel.java:2034)
         1606083394.616 12272 12272 D StrictMode: 	at android.os.Parcel.readException(Parcel.java:2001)
         1606083394.616 12272 12272 D StrictMode: 	at android.content.pm.IPackageManager$Stub$Proxy.resolveIntent(IPackageManager.java:6674)
         1606083394.616 12272 12272 D StrictMode: 	at android.app.ApplicationPackageManager.resolveActivityAsUser(ApplicationPackageManager.java:1130)
         1606083394.616 12272 12272 D StrictMode: 	at android.app.ApplicationPackageManager.resolveActivity(ApplicationPackageManager.java:1124)
         1606083394.616 12272 12272 D StrictMode: 	at org.mozilla.focus.utils.Browsers.findDefault(Browsers.java:173)
         1606083394.616 12272 12272 D StrictMode: 	at org.mozilla.focus.utils.Browsers.<init>(Browsers.java:95)
         1606083394.616 12272 12272 D StrictMode: 	at org.mozilla.focus.tips.Tip$Companion.createDefaultBrowserTip(TipManager.kt:94)
         1606083394.616 12272 12272 D StrictMode: 	at org.mozilla.focus.tips.TipManager.addDefaultBrowserTip(TipManager.kt:292)
         1606083394.616 12272 12272 D StrictMode: 	at org.mozilla.focus.tips.TipManager.populateListOfTips(TipManager.kt:216)
         1606083394.616 12272 12272 D StrictMode: 	at org.mozilla.focus.tips.TipManager.getNextTipIfAvailable(TipManager.kt:232)
         1606083394.616 12272 12272 D StrictMode: 	at org.mozilla.focus.fragment.UrlInputFragment.updateTipsLabel(UrlInputFragment.kt:223)
         1606083394.616 12272 12272 D StrictMode: 	at org.mozilla.focus.fragment.UrlInputFragment.onViewCreated(UrlInputFragment.kt:346)
         1606083394.616 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.moveToState(FragmentManagerImpl.java:892)
         1606083394.616 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.moveFragmentToExpectedState(FragmentManagerImpl.java:1238)
         1606083394.616 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.moveToState(FragmentManagerImpl.java:1303)
         1606083394.616 12272 12272 D StrictMode: 	at androidx.fragment.app.BackStackRecord.executeOps(BackStackRecord.java:439)
         1606083394.616 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.executeOps(FragmentManagerImpl.java:2079)
         1606083394.616 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.executeOpsTogether(FragmentManagerImpl.java:1869)
         1606083394.616 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.removeRedundantOperationsAndExecute(FragmentManagerImpl.java:1824)
         1606083394.616 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.execPendingActions(FragmentManagerImpl.java:1727)
         1606083394.616 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.dispatchStateChange(FragmentManagerImpl.java:2663)
         1606083394.616 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.disp
         1606083394.624 12272 12272 D StrictMode: StrictMode policy violation; ~duration=305 ms: android.os.strictmode.DiskReadViolation
         1606083394.624 12272 12272 D StrictMode: 	at android.os.StrictMode$AndroidBlockGuardPolicy.onReadFromDisk(StrictMode.java:1556)
         1606083394.624 12272 12272 D StrictMode: 	at android.database.sqlite.SQLiteConnection.applyBlockGuardPolicy(SQLiteConnection.java:1524)
         1606083394.624 12272 12272 D StrictMode: 	at android.database.sqlite.SQLiteConnection.executeForCursorWindow(SQLiteConnection.java:1193)
         1606083394.624 12272 12272 D StrictMode: 	at android.database.sqlite.SQLiteSession.executeForCursorWindow(SQLiteSession.java:838)
         1606083394.624 12272 12272 D StrictMode: 	at android.database.sqlite.SQLiteQuery.fillWindow(SQLiteQuery.java:62)
         1606083394.624 12272 12272 D StrictMode: 	at android.database.sqlite.SQLiteCursor.fillWindow(SQLiteCursor.java:165)
         1606083394.624 12272 12272 D StrictMode: 	at android.database.sqlite.SQLiteCursor.getCount(SQLiteCursor.java:152)
         1606083394.624 12272 12272 D StrictMode: 	at android.database.AbstractCursor.moveToPosition(AbstractCursor.java:232)
         1606083394.624 12272 12272 D StrictMode: 	at android.database.AbstractCursor.moveToFirst(AbstractCursor.java:271)
         1606083394.624 12272 12272 D StrictMode: 	at com.android.server.enterprise.storage.EdmStorageProviderBase.getValues(EdmStorageProviderBase.java:388)
         1606083394.624 12272 12272 D StrictMode: 	at com.android.server.enterprise.application.ApplicationPolicy.queryAllDefaultAppIntents(ApplicationPolicy.java:12177)
         1606083394.624 12272 12272 D StrictMode: 	at com.android.server.enterprise.application.ApplicationPolicy.retrieveDefaultAppFromDb(ApplicationPolicy.java:12216)
         1606083394.624 12272 12272 D StrictMode: 	at com.android.server.enterprise.application.ApplicationPolicy.getDefaultApplicationInternal(ApplicationPolicy.java:11523)
         1606083394.624 12272 12272 D StrictMode: 	at com.android.server.pm.PackageManagerService.filterCandidatesWithDomainPreferredActivitiesLPr(PackageManagerService.java:9360)
         1606083394.624 12272 12272 D StrictMode: 	at com.android.server.pm.PackageManagerService.queryIntentActivitiesInternal(PackageManagerService.java:8946)
         1606083394.624 12272 12272 D StrictMode: 	at com.android.server.pm.PackageManagerService.queryIntentActivitiesInternal(PackageManagerService.java:8707)
         1606083394.624 12272 12272 D StrictMode: 	at com.android.server.pm.PackageManagerService.queryIntentActivities(PackageManagerService.java:8678)
         1606083394.624 12272 12272 D StrictMode: 	at com.android.server.pm.PackageManagerService.getDefaultBrowserPackageName(PackageManagerService.java:17004)
         1606083394.624 12272 12272 D StrictMode: 	at com.android.server.pm.PackageManagerService.filterCandidatesWithDomainPreferredActivitiesLPr(PackageManagerService.java:9460)
         1606083394.624 12272 12272 D StrictMode: 	at com.android.server.pm.PackageManagerService.queryIntentActivitiesInternal(PackageManagerService.java:8946)
         1606083394.624 12272 12272 D StrictMode: 	at com.android.server.pm.PackageManagerService.resolveIntentInternal(PackageManagerService.java:7854)
         1606083394.624 12272 12272 D StrictMode: 	at com.android.server.pm.PackageManagerService.resolveIntent(PackageManagerService.java:7824)
         1606083394.624 12272 12272 D StrictMode: 	at android.content.pm.IPackageManager$Stub.onTransact(IPackageManager.java:2887)
         1606083394.624 12272 12272 D StrictMode: 	at com.android.server.pm.PackageManagerService.onTransact(PackageManagerService.java:5160)
         1606083394.624 12272 12272 D StrictMode: 	at android.os.Binder.execTransactInternal(Binder.java:1056)
         1606083394.624 12272 12272 D StrictMode: 	at android.os.Binder.execTransact(Binder.java:1029)
         1606083394.624 12272 12272 D StrictMode: # via Binder call with stack:
         1606083394.624 12272 12272 D StrictMode: 	at android.os.StrictMode.readAndHandleBinderCallViolations(StrictMode.java:2274)
         1606083394.624 12272 12272 D StrictMode: 	at android.os.Parcel.readExceptionCode(Parcel.java:2034)
         1606083394.624 12272 12272 D StrictMode: 	at android.os.Parcel.readException(Parcel.java:2001)
         1606083394.624 12272 12272 D StrictMode: 	at android.content.pm.IPackageManager$Stub$Proxy.resolveIntent(IPackageManager.java:6674)
         1606083394.624 12272 12272 D StrictMode: 	at android.app.ApplicationPackageManager.resolveActivityAsUser(ApplicationPackageManager.java:1130)
         1606083394.624 12272 12272 D StrictMode: 	at android.app.ApplicationPackageManager.resolveActivity(ApplicationPackageManager.java:1124)
         1606083394.624 12272 12272 D StrictMode: 	at org.mozilla.focus.utils.Browsers.findDefault(Browsers.java:173)
         1606083394.624 12272 12272 D StrictMode: 	at org.mozilla.focus.utils.Browsers.<init>(Browsers.java:95)
         1606083394.624 12272 12272 D StrictMode: 	at org.mozilla.focus.tips.Tip$Companion.createDefaultBrowserTip(TipManager.kt:94)
         1606083394.624 12272 12272 D StrictMode: 	at org.mozilla.focus.tips.TipManager.addDefaultBrowserTip(TipManager.kt:292)
         1606083394.624 12272 12272 D StrictMode: 	at org.mozilla.focus.tips.TipManager.populateListOfTips(TipManager.kt:216)
         1606083394.624 12272 12272 D StrictMode: 	at org.mozilla.focus.tips.TipManager.getNextTipIfAvailable(TipManager.kt:232)
         1606083394.624 12272 12272 D StrictMode: 	at org.mozilla.focus.fragment.UrlInputFragment.updateTipsLabel(UrlInputFragment.kt:223)
         1606083394.624 12272 12272 D StrictMode: 	at org.mozilla.focus.fragment.UrlInputFragment.onViewCreated(UrlInputFragment.kt:346)
         1606083394.624 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.moveToState(FragmentManagerImpl.java:892)
         1606083394.624 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.moveFragmentToExpectedState(FragmentManagerImpl.java:1238)
         1606083394.624 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.moveToState(FragmentManagerImpl.java:1303)
         1606083394.624 12272 12272 D StrictMode: 	at androidx.fragment.app.BackStackRecord.executeOps(
         1606083394.628 12272 12272 D StrictMode: StrictMode policy violation; ~duration=304 ms: android.os.strictmode.DiskReadViolation
         1606083394.628 12272 12272 D StrictMode: 	at android.os.StrictMode$AndroidBlockGuardPolicy.onReadFromDisk(StrictMode.java:1556)
         1606083394.628 12272 12272 D StrictMode: 	at android.database.sqlite.SQLiteConnection.applyBlockGuardPolicy(SQLiteConnection.java:1524)
         1606083394.628 12272 12272 D StrictMode: 	at android.database.sqlite.SQLiteConnection.executeForCursorWindow(SQLiteConnection.java:1193)
         1606083394.628 12272 12272 D StrictMode: 	at android.database.sqlite.SQLiteSession.executeForCursorWindow(SQLiteSession.java:838)
         1606083394.628 12272 12272 D StrictMode: 	at android.database.sqlite.SQLiteQuery.fillWindow(SQLiteQuery.java:62)
         1606083394.628 12272 12272 D StrictMode: 	at android.database.sqlite.SQLiteCursor.fillWindow(SQLiteCursor.java:165)
         1606083394.628 12272 12272 D StrictMode: 	at android.database.sqlite.SQLiteCursor.getCount(SQLiteCursor.java:152)
         1606083394.628 12272 12272 D StrictMode: 	at android.database.AbstractCursor.moveToPosition(AbstractCursor.java:232)
         1606083394.628 12272 12272 D StrictMode: 	at android.database.AbstractCursor.moveToFirst(AbstractCursor.java:271)
         1606083394.628 12272 12272 D StrictMode: 	at com.android.server.enterprise.storage.EdmStorageProviderBase.getValues(EdmStorageProviderBase.java:388)
         1606083394.628 12272 12272 D StrictMode: 	at com.android.server.enterprise.application.ApplicationPolicy.queryAllDefaultAppIntents(ApplicationPolicy.java:12177)
         1606083394.628 12272 12272 D StrictMode: 	at com.android.server.enterprise.application.ApplicationPolicy.retrieveDefaultAppFromDb(ApplicationPolicy.java:12216)
         1606083394.628 12272 12272 D StrictMode: 	at com.android.server.enterprise.application.ApplicationPolicy.getDefaultApplicationInternal(ApplicationPolicy.java:11523)
         1606083394.628 12272 12272 D StrictMode: 	at com.android.server.pm.PackageManagerService.getDefaultBrowserPackageName(PackageManagerService.java:17008)
         1606083394.628 12272 12272 D StrictMode: 	at com.android.server.pm.PackageManagerService.filterCandidatesWithDomainPreferredActivitiesLPr(PackageManagerService.java:9460)
         1606083394.628 12272 12272 D StrictMode: 	at com.android.server.pm.PackageManagerService.queryIntentActivitiesInternal(PackageManagerService.java:8946)
         1606083394.628 12272 12272 D StrictMode: 	at com.android.server.pm.PackageManagerService.resolveIntentInternal(PackageManagerService.java:7854)
         1606083394.628 12272 12272 D StrictMode: 	at com.android.server.pm.PackageManagerService.resolveIntent(PackageManagerService.java:7824)
         1606083394.628 12272 12272 D StrictMode: 	at android.content.pm.IPackageManager$Stub.onTransact(IPackageManager.java:2887)
         1606083394.628 12272 12272 D StrictMode: 	at com.android.server.pm.PackageManagerService.onTransact(PackageManagerService.java:5160)
         1606083394.628 12272 12272 D StrictMode: 	at android.os.Binder.execTransactInternal(Binder.java:1056)
         1606083394.628 12272 12272 D StrictMode: 	at android.os.Binder.execTransact(Binder.java:1029)
         1606083394.628 12272 12272 D StrictMode: # via Binder call with stack:
         1606083394.628 12272 12272 D StrictMode: 	at android.os.StrictMode.readAndHandleBinderCallViolations(StrictMode.java:2274)
         1606083394.628 12272 12272 D StrictMode: 	at android.os.Parcel.readExceptionCode(Parcel.java:2034)
         1606083394.628 12272 12272 D StrictMode: 	at android.os.Parcel.readException(Parcel.java:2001)
         1606083394.628 12272 12272 D StrictMode: 	at android.content.pm.IPackageManager$Stub$Proxy.resolveIntent(IPackageManager.java:6674)
         1606083394.628 12272 12272 D StrictMode: 	at android.app.ApplicationPackageManager.resolveActivityAsUser(ApplicationPackageManager.java:1130)
         1606083394.628 12272 12272 D StrictMode: 	at android.app.ApplicationPackageManager.resolveActivity(ApplicationPackageManager.java:1124)
         1606083394.628 12272 12272 D StrictMode: 	at org.mozilla.focus.utils.Browsers.findDefault(Browsers.java:173)
         1606083394.628 12272 12272 D StrictMode: 	at org.mozilla.focus.utils.Browsers.<init>(Browsers.java:95)
         1606083394.628 12272 12272 D StrictMode: 	at org.mozilla.focus.tips.Tip$Companion.createDefaultBrowserTip(TipManager.kt:94)
         1606083394.628 12272 12272 D StrictMode: 	at org.mozilla.focus.tips.TipManager.addDefaultBrowserTip(TipManager.kt:292)
         1606083394.628 12272 12272 D StrictMode: 	at org.mozilla.focus.tips.TipManager.populateListOfTips(TipManager.kt:216)
         1606083394.628 12272 12272 D StrictMode: 	at org.mozilla.focus.tips.TipManager.getNextTipIfAvailable(TipManager.kt:232)
         1606083394.628 12272 12272 D StrictMode: 	at org.mozilla.focus.fragment.UrlInputFragment.updateTipsLabel(UrlInputFragment.kt:223)
         1606083394.628 12272 12272 D StrictMode: 	at org.mozilla.focus.fragment.UrlInputFragment.onViewCreated(UrlInputFragment.kt:346)
         1606083394.628 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.moveToState(FragmentManagerImpl.java:892)
         1606083394.628 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.moveFragmentToExpectedState(FragmentManagerImpl.java:1238)
         1606083394.628 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.moveToState(FragmentManagerImpl.java:1303)
         1606083394.628 12272 12272 D StrictMode: 	at androidx.fragment.app.BackStackRecord.executeOps(BackStackRecord.java:439)
         1606083394.628 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.executeOps(FragmentManagerImpl.java:2079)
         1606083394.628 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.executeOpsTogether(FragmentManagerImpl.java:1869)
         1606083394.628 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.removeRedundantOperationsAndExecute(FragmentManagerImpl.java:1824)
         1606083394.628 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.execPendingActions(FragmentManagerImpl.java:1727)
         1606083394.628 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentMa
--------- switch to events
         1606083394.630 12272 12272 I am_on_top_resumed_gained_called: [0,org.mozilla.focus.activity.MainActivity,topStateChangedWhenResumed]
--------- switch to main
         1606083394.631 12272 12347 W ScreenShotCollator: Activity not ready for auto screenshot
         1606083394.639 12272 12272 D GeckoNetworkManager: Incoming event receivedUpdate for state OnNoListeners -> OnNoListeners
         1606083394.647 12272 12272 D GeckoNetworkManager: New network state: UP, WIFI, WIFI
         1606083394.648 12272 12348 E memtrack: Couldn't load memtrack module
         1606083394.648 12272 12348 W android.os.Debug: failed to get memory consumption info: -1
         1606083394.766 12272 12272 D ScrollView: initGoToTop
         1606083394.811 12272 12272 D ScrollView: initGoToTop
         1606083394.866 12474 12523 I stetho  : Listening on @stetho_org.mozilla.focus.debug:tab0_devtools_remote
         1606083394.871 12272 12272 I ViewRootImpl@ece76c9[MainActivity]: Relayout returned: old=(0,0,1080,2220) new=(0,0,1080,2220) req=(1080,2220)0 dur=11 res=0x6 s={true 3441362944} ch=true
         1606083394.872 12272 12435 D OpenGLRenderer: createReliableSurface : 0xd3919a00(0xcd1f0800)
         1606083394.894 12272 12435 D OpenGLRenderer: makeCurrent EglSurface : 0x0 -> 0x0
         1606083394.896 12272 12272 D ScrollView:  onsize change changed 
         1606083394.901 12272 12272 D ScrollView:  onsize change changed 
         1606083394.927 12272 12435 I mali_winsys: new_window_surface() [1080x2220] return: 0x3000
         1606083394.927 12272 12435 D OpenGLRenderer: eglCreateWindowSurface : 0xd391c6e0
         1606083394.945 12272 12435 D OpenGLRenderer: makeCurrent EglSurface : 0x0 -> 0xd391c6e0
         1606083394.951 12272 12435 W Gralloc3: mapper 3.x is not supported
         1606083394.954 12474 12474 D GeckoThread: State changed to LAUNCHED
         1606083394.959 12272 12435 I gralloc : Arm Module v1.0
         1606083394.971 12474 12551 I GeckoThread: preparing to run Gecko
         1606083395.003 12474 12544 D NetworkSecurityConfig: No Network Security Config specified, using platform default
         1606083395.009 12474 12544 I System.out: (HTTPLog)-Static: isSBSettingEnabled false
         1606083395.009 12474 12544 I System.out: (HTTPLog)-Static: isSBSettingEnabled false
         1606083395.011 12272 12446 D GeckoThread: State changed to PROFILE_READY
         1606083395.018 12474 12544 D TcpOptimizer: TcpOptimizer-ON
         1606083395.047 12474 12544 D libmdf  : libmdf v2.9.0.0 On 32bit PLATFORM
         1606083395.069 12272 12446 D GeckoThread: State changed to RUNNING
         1606083395.078 12272 12446 I Gecko   : -*- nsDNSServiceDiscovery.js : nsDNSServiceDiscovery
         1606083395.202 12272 12272 D GeckoNetworkManager: Incoming event enableNotifications for state OnNoListeners -> OnWithListeners
         1606083395.207 12272 12272 D GeckoNetworkManager: New network state: UP, WIFI, WIFI
         1606083395.317 12272 12272 I ViewRootImpl@ece76c9[MainActivity]: MSG_WINDOW_FOCUS_CHANGED 1 0
         1606083395.317 12272 12272 D InputMethodManager: prepareNavigationBarInfo() DecorView@6f7c19[MainActivity]
         1606083395.319 12272 12272 D InputMethodManager: getNavigationBarColor() -855310
         1606083395.327 12272 12272 D EmergencyMode: [EmergencyManager] android createPackageContext successful: org.mozilla.focus.debug
         1606083395.331 12272 12348 E memtrack: Couldn't load memtrack module
         1606083395.331 12272 12348 W android.os.Debug: failed to get memory consumption info: -1
         1606083395.331 12272 12347 W ParcelFileDescriptor: Peer didn't provide a comm channel; unable to check for errors
         1606083395.340 12272 12272 D InputMethodManager: prepareNavigationBarInfo() DecorView@6f7c19[MainActivity]
         1606083395.340 12272 12272 D InputMethodManager: getNavigationBarColor() -855310
         1606083395.340 12272 12272 V InputMethodManager: Starting input: tba=org.mozilla.focus.debug ic=null mNaviBarColor -855310 mIsGetNaviBarColorSuccess true , NavVisible : true , NavTrans : false
         1606083395.340 12272 12272 D InputMethodManager: startInputInner - Id : 0
         1606083395.340 12272 12272 I InputMethodManager: startInputInner - mService.startInputOrWindowGainedFocus
         1606083395.346 12272 12272 I ViewRootImpl@ece76c9[MainActivity]: MSG_RESIZED: frame=(0,0,1080,2220) ci=(0,63,0,126) vi=(0,63,0,126) or=1
         1606083395.349 12272 12272 D InputMethodManager: prepareNavigationBarInfo() DecorView@6f7c19[MainActivity]
         1606083395.349 12272 12272 D InputMethodManager: getNavigationBarColor() -855310
         1606083395.349 12272 12272 V InputMethodManager: Starting input: tba=org.mozilla.focus.debug ic=null mNaviBarColor -855310 mIsGetNaviBarColorSuccess true , NavVisible : true , NavTrans : false
         1606083395.349 12272 12272 D InputMethodManager: startInputInner - Id : 0
         1606083395.904 12272 12348 E memtrack: Couldn't load memtrack module
         1606083395.904 12272 12348 W android.os.Debug: failed to get memory consumption info: -1
         1606083396.086 12272 12347 W ParcelFileDescriptor: Peer didn't provide a comm channel; unable to check for errors
         1606083396.501 12272 12348 E memtrack: Couldn't load memtrack module
         1606083396.501 12272 12348 W android.os.Debug: failed to get memory consumption info: -1
         1606083396.734 12272 12347 W ParcelFileDescriptor: Peer didn't provide a comm channel; unable to check for errors
         1606083397.162 12272 12348 E memtrack: Couldn't load memtrack module
         1606083397.162 12272 12348 W android.os.Debug: failed to get memory consumption info: -1
         1606083397.318 12272 12347 W ParcelFileDescriptor: Peer didn't provide a comm channel; unable to check for errors
         1606083397.369 12272 12359 D EventInjectionStrategy: Creating injection strategy with input manager.
         1606083397.372 12272 12359 W lla.focus.debu: Accessing hidden method Landroid/hardware/input/InputManager;->getInstance()Landroid/hardware/input/InputManager; (greylist, reflection, allowed)
         1606083397.372 12272 12359 W lla.focus.debu: Accessing hidden method Landroid/hardware/input/InputManager;->injectInputEvent(Landroid/view/InputEvent;I)Z (greylist, reflection, allowed)
         1606083397.372 12272 12359 W lla.focus.debu: Accessing hidden field Landroid/hardware/input/InputManager;->INJECT_INPUT_EVENT_MODE_WAIT_FOR_FINISH:I (greylist, reflection, allowed)
         1606083397.381 12272 12359 W lla.focus.debu: Accessing hidden method Landroid/view/ViewConfiguration;->getDoubleTapMinTime()I (greylist, reflection, allowed)
         1606083397.383 12272 12359 W lla.focus.debu: Accessing hidden method Lsun/misc/Unsafe;->getUnsafe()Lsun/misc/Unsafe; (greylist,core-platform-api, linking, allowed)
         1606083397.384 12272 12272 W lla.focus.debu: Accessing hidden method Landroid/os/Message;->recycleUnchecked()V (greylist, reflection, allowed)
         1606083397.385 12272 12359 W lla.focus.debu: Accessing hidden method Lsun/misc/Unsafe;->compareAndSwapObject(Ljava/lang/Object;JLjava/lang/Object;Ljava/lang/Object;)Z (greylist, linking, allowed)
         1606083397.385 12272 12272 W lla.focus.debu: Accessing hidden method Landroid/view/WindowManagerGlobal;->getInstance()Landroid/view/WindowManagerGlobal; (greylist, reflection, allowed)
         1606083397.385 12272 12272 W lla.focus.debu: Accessing hidden field Landroid/view/WindowManagerGlobal;->mViews:Ljava/util/ArrayList; (greylist, reflection, allowed)
         1606083397.385 12272 12272 W lla.focus.debu: Accessing hidden field Landroid/view/WindowManagerGlobal;->mParams:Ljava/util/ArrayList; (greylist, reflection, allowed)
--------- switch to events
         1606083397.454 12272 12272 I am_on_top_resumed_lost_called: [0,org.mozilla.focus.activity.MainActivity,topStateChangedWhenResumed]
         1606083397.462 12272 12272 I am_on_paused_called: [0,org.mozilla.focus.activity.MainActivity,performPause]
--------- switch to main
         1606083397.462 12272 12272 D LifecycleMonitor: Lifecycle status change: org.mozilla.focus.activity.MainActivity@b261f48 in: PAUSED
         1606083397.462 12272 12272 D LifecycleMonitor: running callback: androidx.test.rule.ActivityTestRule$LifecycleCallback@2075088
         1606083397.462 12272 12272 D LifecycleMonitor: callback completes: androidx.test.rule.ActivityTestRule$LifecycleCallback@2075088
         1606083397.462 12272 12272 I ActivityMonitor: Activity: org.mozilla.focus.activity.MainActivity@b261f48 is in stage: PAUSED
         1606083397.475 12272 12272 W lla.focus.debu: Accessing hidden field Landroid/app/Activity;->mResultCode:I (greylist, reflection, allowed)
         1606083397.475 12272 12272 W lla.focus.debu: Accessing hidden field Landroid/app/Activity;->mResultData:Landroid/content/Intent; (greylist, reflection, allowed)
         1606083397.476 12272 12359 E TestRunner: failed: FirstRunDialogueTest(org.mozilla.focus.activity.FirstRunDialogueTest)
         1606083397.477 12272 12359 E TestRunner: ----- begin exception -----
         1606083397.479 12272 12272 I ViewRootImpl@ece76c9[MainActivity]: MSG_WINDOW_FOCUS_CHANGED 0 0
         1606083397.480 12272 12359 E TestRunner: androidx.test.espresso.AmbiguousViewMatcherException: 'with id: org.mozilla.focus.debug:id/next' matches multiple views in the hierarchy.
         1606083397.480 12272 12359 E TestRunner: Problem views are marked with '****MATCHES****' below.
         1606083397.480 12272 12359 E TestRunner: 
         1606083397.480 12272 12359 E TestRunner: View Hierarchy:
         1606083397.480 12272 12359 E TestRunner: +>DecorView{id=-1, visibility=VISIBLE, width=1080, height=2220, has-focus=true, has-focusable=true, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, layout-params={(0,0)(fillxfill) sim={state=always_hidden adjust=resize} ty=BASE_APPLICATION wanim=0x1030305
         1606083397.480 12272 12359 E TestRunner:   fl=81810100
         1606083397.480 12272 12359 E TestRunner:   pfl=10020000 naviIconColor=0}, tag=null, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=0.0, child-count=2} 
         1606083397.480 12272 12359 E TestRunner: |
         1606083397.480 12272 12359 E TestRunner: +->LinearLayout{id=-1, visibility=VISIBLE, width=1080, height=2094, has-focus=true, has-focusable=true, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, layout-params=android.widget.FrameLayout$LayoutParams@c449211, tag=null, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=0.0, child-count=2} 
         1606083397.480 12272 12359 E TestRunner: |
         1606083397.480 12272 12359 E TestRunner: +-->ViewStub{id=16908694, res-name=action_mode_bar_stub, visibility=GONE, width=0, height=0, has-focus=false, has-focusable=false, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=true, is-selected=false, layout-params=android.widget.LinearLayout$LayoutParams@7d98f76, tag=null, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=0.0} 
         1606083397.480 12272 12359 E TestRunner: |
         1606083397.480 12272 12359 E TestRunner: +-->FrameLayout{id=-1, visibility=VISIBLE, width=1080, height=2094, has-focus=true, has-focusable=true, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, layout-params=android.widget.LinearLayout$LayoutParams@c9c3977, tag=null, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=0.0, child-count=1} 
         1606083397.480 12272 12359 E TestRunner: |
         1606083397.480 12272 12359 E TestRunner: +--->FitWindowsLinearLayout{id=2131296303, res-name=action_bar_root, visibility=VISIBLE, width=1080, height=2094, has-focus=true, has-focusable=true, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, layout-params=android.widget.FrameLayout$LayoutParams@5cf3e4d, tag=null, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=0.0, child-count=2} 
         1606083397.480 12272 12359 E TestRunner: |
         1606083397.480 12272 12359 E TestRunner: +---->ViewStubCompat{id=2131296315, res-name=action_mode_bar_stub, visibility=GONE, width=0, height=0, has-focus=false, has-focusable=false, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=true, is-selected=false, layout-params=android.widget.LinearLayout$LayoutParams@ac72d02, tag=null, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=0.0} 
         1606083397.480 12272 12359 E TestRunner: |
         1606083397.480 12272 12359 E TestRunner: +---->ContentFrameLayout{id=16908290, res-name=content, visibility=VISIBLE, width=1080, height=2094, has-focus=true, has-focusable=true, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, layout-params=android.widget.LinearLayout$LayoutParams@810f613, tag=null, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=0.0, child-count=1} 
         1606083397.480 12272 12359 E TestRunner: |
         1606083397.480 12272 12359 E TestRunner: +----->FrameLayout{id=2131296377, res-name=container, visibility=VISIBLE, width=1080, height=2094, has-focus=true, has-focusable=true, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, layout-params=android.widget.FrameLayout$LayoutParams@fe4c050, tag=null, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=0.0, child-count=2} 
         1606083397.480 12272 12359 E TestRunner: |
         1606083397.480 12272 12359 E TestRunner: +------>FrameLayout{id=2131296334, res-name=backgroundView, visibility=VISIBLE, width=1080, height=2094, has-focus=true, has-focusable=true, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, layout-params=android.
         1606083397.480 12272 12359 E TestRunner: ----- end exception -----
         1606083397.484 12272 12272 D InputMethodManager: prepareNavigationBarInfo() DecorView@6f7c19[MainActivity]
         1606083397.484 12272 12272 D InputMethodManager: getNavigationBarColor() -855310
         1606083397.489 12272 12359 I TestObserver: TEST_FAILURE:FirstRunDialogueTest(org.mozilla.focus.activity.FirstRunDialogueTest): 'with id: org.mozilla.focus.debug:id/next' matches multiple views in the hierarchy.
         1606083397.489 12272 12359 I TestObserver: Problem views are marked with '****MATCHES****' below.
         1606083397.489 12272 12359 I TestObserver: 
         1606083397.489 12272 12359 I TestObserver: View Hierarchy:
         1606083397.489 12272 12359 I TestObserver: +>DecorView{id=-1, visibility=VISIBLE, width=1080, height=2220, has-focus=true, has-focusable=true, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, layout-params={(0,0)(fillxfill) sim={state=always_hidden adjust=resize} ty=BASE_APPLICATION wanim=0x1030305
         1606083397.489 12272 12359 I TestObserver:   fl=81810100
         1606083397.489 12272 12359 I TestObserver:   pfl=10020000 naviIconColor=0}, tag=null, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=0.0, child-count=2} 
         1606083397.489 12272 12359 I TestObserver: |
         1606083397.489 12272 12359 I TestObserver: +->LinearLayout{id=-1, visibility=VISIBLE, width=1080, height=2094, has-focus=true, has-focusable=true, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, layout-params=android.widget.FrameLayout$LayoutParams@c449211, tag=null, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=0.0, child-count=2} 
         1606083397.489 12272 12359 I TestObserver: |
         1606083397.489 12272 12359 I TestObserver: +-->ViewStub{id=16908694, res-name=action_mode_bar_stub, visibility=GONE, width=0, height=0, has-focus=false, has-focusable=false, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=true, is-selected=false, layout-params=android.widget.LinearLayout$LayoutParams@7d98f76, tag=null, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=0.0} 
         1606083397.489 12272 12359 I TestObserver: |
         1606083397.489 12272 12359 I TestObserver: +-->FrameLayout{id=-1, visibility=VISIBLE, width=1080, height=2094, has-focus=true, has-focusable=true, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, layout-params=android.widget.LinearLayout$LayoutParams@c9c3977, tag=null, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=0.0, child-count=1} 
         1606083397.489 12272 12359 I TestObserver: |
         1606083397.489 12272 12359 I TestObserver: +--->FitWindowsLinearLayout{id=2131296303, res-name=action_bar_root, visibility=VISIBLE, width=1080, height=2094, has-focus=true, has-focusable=true, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, layout-params=android.widget.FrameLayout$LayoutParams@5cf3e4d, tag=null, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=0.0, child-count=2} 
         1606083397.489 12272 12359 I TestObserver: |
         1606083397.489 12272 12359 I TestObserver: +---->ViewStubCompat{id=2131296315, res-name=action_mode_bar_stub, visibility=GONE, width=0, height=0, has-focus=false, has-focusable=false, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=true, is-selected=false, layout-params=android.widget.LinearLayout$LayoutParams@ac72d02, tag=null, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=0.0} 
         1606083397.489 12272 12359 I TestObserver: |
         1606083397.489 12272 12359 I TestObserver: +---->ContentFrameLayout{id=16908290, res-name=content, visibility=VISIBLE, width=1080, height=2094, has-focus=true, has-focusable=true, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, layout-params=android.widget.LinearLayout$LayoutParams@810f613, tag=null, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=0.0, child-count=1} 
         1606083397.489 12272 12359 I TestObserver: |
         1606083397.489 12272 12359 I TestObserver: +----->FrameLayout{id=2131296377, res-name=container, visibility=VISIBLE, width=1080, height=2094, has-focus=true, has-focusable=true, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, layout-params=android.widget.FrameLayout$LayoutParams@fe4c050, tag=null, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=0.0, child-count=2} 
         1606083397.489 12272 12359 I TestObserver: |
         1606083397.489 12272 12359 I TestObserver: +------>FrameLayout{id=2131296334, res-name=backgroundView, visibility=VISIBLE, width=1080, height=2094, has-focus=true, has-focusable=true, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-select
         1606083397.489 12272 12359 I Logger  : Stopping logging!
         1606083397.491 12272 12421 W System.err: java.io.IOException: write failed: EBADF (Bad file descriptor)
         1606083397.491 12272 12421 W System.err: 	at libcore.io.IoBridge.write(IoBridge.java:544)
         1606083397.491 12272 12421 W System.err: 	at java.io.FileOutputStream.write(FileOutputStream.java:392)
         1606083397.491 12272 12421 W System.err: 	at sun.nio.cs.StreamEncoder.writeBytes(StreamEncoder.java:221)
         1606083397.491 12272 12421 W System.err: 	at sun.nio.cs.StreamEncoder.implWrite(StreamEncoder.java:282)
         1606083397.492 12272 12421 W System.err: 	at sun.nio.cs.StreamEncoder.write(StreamEncoder.java:125)
         1606083397.492 12272 12421 W System.err: 	at java.io.OutputStreamWriter.write(OutputStreamWriter.java:207)
         1606083397.492 12272 12421 W System.err: 	at java.io.BufferedWriter.flushBuffer(BufferedWriter.java:129)
         1606083397.492 12272 12421 W System.err: 	at java.io.BufferedWriter.close(BufferedWriter.java:265)
         1606083397.492 12272 12421 W System.err: 	at com.fluentbuild.apollo.foundation.IoUtilsKt.closeCatching(IoUtils.kt:26)
         1606083397.492 12272 12421 W System.err: 	at com.fluentbuild.apollo.foundation.FileUtilsKt.autoCloseBufferedWriter(FileUtils.kt:115)
         1606083397.492 12272 12421 W System.err: 	at com.fluentbuild.apollo.foundation.FileUtilsKt.copyAllLines(FileUtils.kt:61)
         1606083397.492 12272 12421 W System.err: 	at com.fluentbuild.apollo.runner.client.collators.logs.Logger.logToFile(Logger.kt:47)
         1606083397.492 12272 12421 W System.err: 	at com.fluentbuild.apollo.runner.client.collators.logs.Logger.logResiliently(Logger.kt:69)
         1606083397.492 12272 12421 W System.err: 	at com.fluentbuild.apollo.runner.client.collators.logs.Logger.access$logResiliently(Logger.kt:18)
         1606083397.492 12272 12421 W System.err: 	at com.fluentbuild.apollo.runner.client.collators.logs.Logger$startLogging$1.run(Logger.kt:34)
         1606083397.492 12272 12421 W System.err: 	at java.lang.Thread.run(Thread.java:919)
         1606083397.493 12272 12421 W System.err: Caused by: android.system.ErrnoException: write failed: EBADF (Bad file descriptor)
         1606083397.493 12272 12421 W System.err: 	at libcore.io.Linux.writeBytes(Native Method)
         1606083397.493 12272 12421 W System.err: 	at libcore.io.Linux.write(Linux.java:294)
         1606083397.493 12272 12421 W System.err: 	at libcore.io.ForwardingOs.write(ForwardingOs.java:241)
         1606083397.493 12272 12421 W System.err: 	at libcore.io.BlockGuardOs.write(BlockGuardOs.java:416)
         1606083397.493 12272 12421 W System.err: 	at libcore.io.ForwardingOs.write(ForwardingOs.java:241)
         1606083397.493 12272 12421 W System.err: 	at libcore.io.IoBridge.write(IoBridge.java:539)
         1606083397.493 12272 12421 W System.err: 	... 15 more
         1606083397.498 12272 12421 E Logger  : Logging error
         1606083397.498 12272 12421 E Logger  : java.io.InterruptedIOException: read interrupted
         1606083397.498 12272 12421 E Logger  : 	at libcore.io.Linux.readBytes(Native Method)
         1606083397.498 12272 12421 E Logger  : 	at libcore.io.Linux.read(Linux.java:190)
         1606083397.498 12272 12421 E Logger  : 	at libcore.io.ForwardingOs.read(ForwardingOs.java:177)
         1606083397.498 12272 12421 E Logger  : 	at libcore.io.BlockGuardOs.read(BlockGuardOs.java:303)
         1606083397.498 12272 12421 E Logger  : 	at libcore.io.ForwardingOs.read(ForwardingOs.java:177)
         1606083397.498 12272 12421 E Logger  : 	at libcore.io.IoBridge.read(IoBridge.java:513)
         1606083397.498 12272 12421 E Logger  : 	at java.io.FileInputStream.read(FileInputStream.java:313)
         1606083397.498 12272 12421 E Logger  : 	at java.io.BufferedInputStream.read1(BufferedInputStream.java:286)
         1606083397.498 12272 12421 E Logger  : 	at java.io.BufferedInputStream.read(BufferedInputStream.java:347)
         1606083397.498 12272 12421 E Logger  : 	at sun.nio.cs.StreamDecoder.readBytes(StreamDecoder.java:291)
         1606083397.498 12272 12421 E Logger  : 	at sun.nio.cs.StreamDecoder.implRead(StreamDecoder.java:355)
         1606083397.498 12272 12421 E Logger  : 	at sun.nio.cs.StreamDecoder.read(StreamDecoder.java:181)
         1606083397.498 12272 12421 E Logger  : 	at java.io.InputStreamReader.read(InputStreamReader.java:184)
         1606083397.498 12272 12421 E Logger  : 	at java.io.BufferedReader.fill(BufferedReader.java:172)
         1606083397.498 12272 12421 E Logger  : 	at java.io.BufferedReader.readLine(BufferedReader.java:335)
         1606083397.498 12272 12421 E Logger  : 	at java.io.BufferedReader.readLine(BufferedReader.java:400)
         1606083397.498 12272 12421 E Logger  : 	at kotlin.io.LinesSequence$iterator$1.hasNext(ReadWrite.kt:80)
         1606083397.498 12272 12421 E Logger  : 	at com.fluentbuild.apollo.foundation.FileUtilsKt$copyAllLines$1$1.invoke(FileUtils.kt:101)
         1606083397.498 12272 12421 E Logger  : 	at com.fluentbuild.apollo.foundation.FileUtilsKt$copyAllLines$1$1.invoke(Unknown Source:2)
         1606083397.498 12272 12421 E Logger  : 	at com.fluentbuild.apollo.foundation.FileUtilsKt.autoCloseBufferedWriter(FileUtils.kt:52)
         1606083397.498 12272 12421 E Logger  : 	at com.fluentbuild.apollo.foundation.FileUtilsKt.copyAllLines(FileUtils.kt:61)
         1606083397.498 12272 12421 E Logger  : 	at com.fluentbuild.apollo.runner.client.collators.logs.Logger.logToFile(Logger.kt:47)
         1606083397.498 12272 12421 E Logger  : 	at com.fluentbuild.apollo.runner.client.collators.logs.Logger.logResiliently(Logger.kt:69)
         1606083397.498 12272 12421 E Logger  : 	at com.fluentbuild.apollo.runner.client.collators.logs.Logger.access$logResiliently(Logger.kt:18)
         1606083397.498 12272 12421 E Logger  : 	at com.fluentbuild.apollo.runner.client.collators.logs.Logger$startLogging$1.run(Logger.kt:34)
         1606083397.498 12272 12421 E Logger  : 	at java.lang.Thread.run(Thread.java:919)
         1606083397.584 12272 12359 E memtrack: Couldn't load memtrack module
         1606083397.584 12272 12359 W android.os.Debug: failed to get memory consumption info: -1
         1606083397.611 12272 12435 D OpenGLRenderer: makeCurrent EglSurface : 0xd391c6e0 -> 0x0
         1606083397.611 12272 12435 D OpenGLRenderer: destroyEglSurface : 0xd391c6e0
         1606083397.611 12272 12435 I mali_egl: eglDestroySurface() in
         1606083397.613 12272 12435 I mali_winsys: delete_surface() [1080x2220] return
         1606083397.613 12272 12435 I mali_egl: eglDestroySurface() out
         1606083397.614 12272 12435 E OpenGLRenderer: ReliableSurface: perform returned an error
         1606083397.614 12272 12435 W libEGL  : EGLNativeWindowType 0xd3919a08 disconnect failed
         1606083397.614 12272 12435 D OpenGLRenderer: ~ReliableSurface : 0xd3919a00
         1606083397.628 12272 12359 W ParcelFileDescriptor: Peer didn't provide a comm channel; unable to check for errors
         1606083397.652 12272 12272 I ViewRootImpl@ece76c9[MainActivity]: Relayout returned: old=(0,0,1080,2220) new=(0,0,1080,2220) req=(1080,2220)8 dur=37 res=0x4 s={false 0} ch=true
         1606083397.653 12272 12359 I Logger  : Starting logging!
         1606083397.659 12272 12272 D InputTransport: Input channel destroyed: 'ClientS', fd=150
         1606083397.661 12272 12272 I ViewRootImpl@ece76c9[MainActivity]: stopped(true) old=false
         1606083397.680 12272 12729 W ParcelFileDescriptor: Peer didn't provide a comm channel; unable to check for errors
         1606083397.682 12272 12272 D LifecycleMonitor: Lifecycle status change: org.mozilla.focus.activity.MainActivity@b261f48 in: STOPPED
         1606083397.682 12272 12272 I ActivityMonitor: Activity: org.mozilla.focus.activity.MainActivity@b261f48 is in stage: STOPPED
--------- switch to events
         1606083397.682 12272 12272 I am_on_stop_called: [0,org.mozilla.focus.activity.MainActivity,LIFECYCLER_STOP_ACTIVITY]
--------- switch to main
         1606083397.684 12272 12272 I ActivityMonitor: Activity: org.mozilla.focus.activity.MainActivity@b261f48 is in stage: DESTROYED
--------- switch to events
         1606083397.701 12272 12272 I am_on_destroy_called: [0,org.mozilla.focus.activity.MainActivity,performDestroy]
--------- switch to main
         1606083397.701 12272 12272 D LifecycleMonitor: Lifecycle status change: org.mozilla.focus.activity.MainActivity@b261f48 in: DESTROYED
         1606083397.708 12272 12272 I ViewRootImpl@ece76c9[MainActivity]: dispatchDetachedFromWindow
         1606083397.714 12272 12272 D InputTransport: Input channel destroyed: 'b07e772', fd=115
         1606083397.731 12272 12272 E ViewRootImpl: sendUserActionEvent() mView returned.
         1606083397.733 12272 12359 E memtrack: Couldn't load memtrack module
         1606083397.733 12272 12359 W android.os.Debug: failed to get memory consumption info: -1
         1606083397.744 12272 12733 I System.out: (HTTPLog)-Static: isSBSettingEnabled false
         1606083397.745 12272 12733 I System.out: (HTTPLog)-Static: isSBSettingEnabled false
         1606083397.756 12272 12359 W InstrumentationResultPrinter: Stack trace too long, trimmed to first 32768 characters.
         1606083397.760 12272 12359 I TestRunner: finished: FirstRunDialogueTest(org.mozilla.focus.activity.FirstRunDialogueTest)
         1606083397.762 12272 12359 I TestObserver: TEST_FINISHED:FirstRunDialogueTest(org.mozilla.focus.activity.FirstRunDialogueTest)
         1606083397.762 12272 12359 I Logger  : Stopping logging!
         1606083397.764 12272 12729 W System.err: java.io.IOException: write failed: EBADF (Bad file descriptor)
         1606083397.764 12272 12729 W System.err: 	at libcore.io.IoBridge.write(IoBridge.java:544)
         1606083397.764 12272 12729 W System.err: 	at java.io.FileOutputStream.write(FileOutputStream.java:392)
         1606083397.765 12272 12729 W System.err: 	at sun.nio.cs.StreamEncoder.writeBytes(StreamEncoder.java:221)
         1606083397.765 12272 12729 W System.err: 	at sun.nio.cs.StreamEncoder.implWrite(StreamEncoder.java:282)
         1606083397.765 12272 12729 W System.err: 	at sun.nio.cs.StreamEncoder.write(StreamEncoder.java:125)
         1606083397.765 12272 12729 W System.err: 	at java.io.OutputStreamWriter.write(OutputStreamWriter.java:207)
         1606083397.765 12272 12729 W System.err: 	at java.io.BufferedWriter.flushBuffer(BufferedWriter.java:129)
         1606083397.765 12272 12729 W System.err: 	at java.io.BufferedWriter.close(BufferedWriter.java:265)
         1606083397.765 12272 12729 W System.err: 	at com.fluentbuild.apollo.foundation.IoUtilsKt.closeCatching(IoUtils.kt:26)
         1606083397.765 12272 12729 W System.err: 	at com.fluentbuild.apollo.foundation.FileUtilsKt.autoCloseBufferedWriter(FileUtils.kt:115)
         1606083397.765 12272 12729 W System.err: 	at com.fluentbuild.apollo.foundation.FileUtilsKt.copyAllLines(FileUtils.kt:61)
         1606083397.765 12272 12729 W System.err: 	at com.fluentbuild.apollo.runner.client.collators.logs.Logger.logToFile(Logger.kt:47)
         1606083397.765 12272 12729 W System.err: 	at com.fluentbuild.apollo.runner.client.collators.logs.Logger.logResiliently(Logger.kt:69)
         1606083397.765 12272 12729 W System.err: 	at com.fluentbuild.apollo.runner.client.collators.logs.Logger.access$logResiliently(Logger.kt:18)
         1606083397.765 12272 12729 W System.err: 	at com.fluentbuild.apollo.runner.client.collators.logs.Logger$startLogging$1.run(Logger.kt:34)
         1606083397.765 12272 12729 W System.err: 	at java.lang.Thread.run(Thread.java:919)
         1606083397.765 12272 12729 W System.err: Caused by: android.system.ErrnoException: write failed: EBADF (Bad file descriptor)
         1606083397.765 12272 12729 W System.err: 	at libcore.io.Linux.writeBytes(Native Method)
         1606083397.765 12272 12729 W System.err: 	at libcore.io.Linux.write(Linux.java:294)
         1606083397.765 12272 12729 W System.err: 	at libcore.io.ForwardingOs.write(ForwardingOs.java:241)
         1606083397.765 12272 12729 W System.err: 	at libcore.io.BlockGuardOs.write(BlockGuardOs.java:416)
         1606083397.765 12272 12729 W System.err: 	at libcore.io.ForwardingOs.write(ForwardingOs.java:241)
         1606083397.765 12272 12729 W System.err: 	at libcore.io.IoBridge.write(IoBridge.java:539)
         1606083397.765 12272 12729 W System.err: 	... 15 more
         1606083397.766 12272 12729 E Logger  : Logging error
         1606083397.766 12272 12729 E Logger  : java.io.InterruptedIOException: read interrupted
         1606083397.766 12272 12729 E Logger  : 	at libcore.io.Linux.readBytes(Native Method)
         1606083397.766 12272 12729 E Logger  : 	at libcore.io.Linux.read(Linux.java:190)
         1606083397.766 12272 12729 E Logger  : 	at libcore.io.ForwardingOs.read(ForwardingOs.java:177)
         1606083397.766 12272 12729 E Logger  : 	at libcore.io.BlockGuardOs.read(BlockGuardOs.java:303)
         1606083397.766 12272 12729 E Logger  : 	at libcore.io.ForwardingOs.read(ForwardingOs.java:177)
         1606083397.766 12272 12729 E Logger  : 	at libcore.io.IoBridge.read(IoBridge.java:513)
         1606083397.766 12272 12729 E Logger  : 	at java.io.FileInputStream.read(FileInputStream.java:313)
         1606083397.766 12272 12729 E Logger  : 	at java.io.BufferedInputStream.read1(BufferedInputStream.java:286)
         1606083397.766 12272 12729 E Logger  : 	at java.io.BufferedInputStream.read(BufferedInputStream.java:347)
         1606083397.766 12272 12729 E Logger  : 	at sun.nio.cs.StreamDecoder.readBytes(StreamDecoder.java:291)
         1606083397.766 12272 12729 E Logger  : 	at sun.nio.cs.StreamDecoder.implRead(StreamDecoder.java:355)
         1606083397.766 12272 12729 E Logger  : 	at sun.nio.cs.StreamDecoder.read(StreamDecoder.java:181)
         1606083397.766 12272 12729 E Logger  : 	at java.io.InputStreamReader.read(InputStreamReader.java:184)
         1606083397.766 12272 12729 E Logger  : 	at java.io.BufferedReader.fill(BufferedReader.java:172)
         1606083397.766 12272 12729 E Logger  : 	at java.io.BufferedReader.readLine(BufferedReader.java:335)
         1606083397.766 12272 12729 E Logger  : 	at java.io.BufferedReader.readLine(BufferedReader.java:400)
         1606083397.766 12272 12729 E Logger  : 	at kotlin.io.LinesSequence$iterator$1.hasNext(ReadWrite.kt:80)
         1606083397.766 12272 12729 E Logger  : 	at com.fluentbuild.apollo.foundation.FileUtilsKt$copyAllLines$1$1.invoke(FileUtils.kt:101)
         1606083397.766 12272 12729 E Logger  : 	at com.fluentbuild.apollo.foundation.FileUtilsKt$copyAllLines$1$1.invoke(Unknown Source:2)
         1606083397.766 12272 12729 E Logger  : 	at com.fluentbuild.apollo.foundation.FileUtilsKt.autoCloseBufferedWriter(FileUtils.kt:52)
         1606083397.766 12272 12729 E Logger  : 	at com.fluentbuild.apollo.foundation.FileUtilsKt.copyAllLines(FileUtils.kt:61)
         1606083397.766 12272 12729 E Logger  : 	at com.fluentbuild.apollo.runner.client.collators.logs.Logger.logToFile(Logger.kt:47)
         1606083397.766 12272 12729 E Logger  : 	at com.fluentbuild.apollo.runner.client.collators.logs.Logger.logResiliently(Logger.kt:69)
         1606083397.766 12272 12729 E Logger  : 	at com.fluentbuild.apollo.runner.client.collators.logs.Logger.access$logResiliently(Logger.kt:18)
         1606083397.766 12272 12729 E Logger  : 	at com.fluentbuild.apollo.runner.client.collators.logs.Logger$startLogging$1.run(Logger.kt:34)
         1606083397.766 12272 12729 E Logger  : 	at java.lang.Thread.run(Thread.java:919)
         1606083397.857 12272 12348 E memtrack: Couldn't load memtrack module
         1606083397.857 12272 12348 W android.os.Debug: failed to get memory consumption info: -1
         1606083397.864 12272 12359 E memtrack: Couldn't load memtrack module
         1606083397.864 12272 12359 W android.os.Debug: failed to get memory consumption info: -1
         1606083397.885 12272 12359 W ParcelFileDescriptor: Peer didn't provide a comm channel; unable to check for errors
         1606083397.911 12272 12359 I Logger  : Starting logging!
         1606083397.922 12272 12737 W ParcelFileDescriptor: Peer didn't provide a comm channel; unable to check for errors
         1606083398.004 12272 12359 E memtrack: Couldn't load memtrack module
         1606083398.004 12272 12359 W android.os.Debug: failed to get memory consumption info: -1
         1606083398.025 12272 12347 W ParcelFileDescriptor: Peer didn't provide a comm channel; unable to check for errors
         1606083398.036 12272 12272 I MonitoringInstr: Activities that are still in CREATED to STOPPED: 0
         1606083398.037 12272 12359 I TestRunner: started: testVisitingMultipleSites(org.mozilla.focus.activity.MultitaskingTest)
         1606083398.038 12272 12359 I TestObserver: TEST_STARTED:testVisitingMultipleSites(org.mozilla.focus.activity.MultitaskingTest)
         1606083398.038 12272 12272 I MonitoringInstr: Activities that are still in CREATED to STOPPED: 0
         1606083398.039 12272 12359 W ActivityTestRule: getActivityIntent() returned null using default: Intent(Intent.ACTION_MAIN)
         1606083398.039 12272 12359 E TestRunner: assumption failed: testVisitingMultipleSites(org.mozilla.focus.activity.MultitaskingTest)
         1606083398.039 12272 12359 E TestRunner: ----- begin exception -----
         1606083398.040 12272 12359 E TestRunner: org.junit.AssumptionViolatedException: got: <false>, expected: is <true>
         1606083398.040 12272 12359 E TestRunner: 	at org.junit.Assume.assumeThat(Assume.java:95)
         1606083398.040 12272 12359 E TestRunner: 	at org.junit.Assume.assumeTrue(Assume.java:41)
         1606083398.040 12272 12359 E TestRunner: 	at org.junit.Assume.assumeFalse(Assume.java:48)
         1606083398.040 12272 12359 E TestRunner: 	at org.mozilla.focus.activity.MultitaskingTest$1.beforeActivityLaunched(MultitaskingTest.java:73)
         1606083398.040 12272 12359 E TestRunner: 	at androidx.test.rule.ActivityTestRule.launchActivity(ActivityTestRule.java:355)
         1606083398.040 12272 12359 E TestRunner: 	at androidx.test.rule.ActivityTestRule$ActivityStatement.evaluate(ActivityTestRule.java:529)
         1606083398.040 12272 12359 E TestRunner: 	at org.junit.rules.RunRules.evaluate(RunRules.java:20)
         1606083398.040 12272 12359 E TestRunner: 	at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)
         1606083398.040 12272 12359 E TestRunner: 	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)
         1606083398.040 12272 12359 E TestRunner: 	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)
         1606083398.040 12272 12359 E TestRunner: 	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
         1606083398.040 12272 12359 E TestRunner: 	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
         1606083398.040 12272 12359 E TestRunner: 	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
         1606083398.040 12272 12359 E TestRunner: 	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
         1606083398.040 12272 12359 E TestRunner: 	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
         1606083398.040 12272 12359 E TestRunner: 	at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
         1606083398.040 12272 12359 E TestRunner: 	at androidx.test.runner.AndroidJUnit4.run(AndroidJUnit4.java:104)
         1606083398.040 12272 12359 E TestRunner: 	at org.junit.runners.Suite.runChild(Suite.java:128)
         1606083398.040 12272 12359 E TestRunner: 	at org.junit.runners.Suite.runChild(Suite.java:27)
         1606083398.040 12272 12359 E TestRunner: 	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
         1606083398.040 12272 12359 E TestRunner: 	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
         1606083398.040 12272 12359 E TestRunner: 	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
         1606083398.040 12272 12359 E TestRunner: 	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
         1606083398.040 12272 12359 E TestRunner: 	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
         1606083398.040 12272 12359 E TestRunner: 	at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
         1606083398.040 12272 12359 E TestRunner: 	at org.junit.runner.JUnitCore.run(JUnitCore.java:137)
         1606083398.040 12272 12359 E TestRunner: 	at org.junit.runner.JUnitCore.run(JUnitCore.java:115)
         1606083398.040 12272 12359 E TestRunner: 	at androidx.test.internal.runner.TestExecutor.execute(TestExecutor.java:56)
         1606083398.040 12272 12359 E TestRunner: 	at androidx.test.runner.AndroidJUnitRunner.onStart(AndroidJUnitRunner.java:392)
         1606083398.040 12272 12359 E TestRunner: 	at com.fluentbuild.apollo.runner.client.androidx.AndroidXJUnitRunner.onStart(AndroidXJUnitRunner.kt:24)
         1606083398.040 12272 12359 E TestRunner: 	at org.mozilla.focus.Angelina.onStart(Angelina.kt:25)
         1606083398.040 12272 12359 E TestRunner: 	at android.app.Instrumentation$InstrumentationThread.run(Instrumentation.java:2214)
         1606083398.040 12272 12359 E TestRunner: ----- end exception -----
         1606083398.041 12272 12359 I TestObserver: TEST_ASSUME_FAILURE:testVisitingMultipleSites(org.mozilla.focus.activity.MultitaskingTest): got: <false>, expected: is <true>
         1606083398.041 12272 12359 I Logger  : Stopping logging!
         1606083398.042 12272 12737 W System.err: java.io.IOException: write failed: EBADF (Bad file descriptor)
         1606083398.043 12272 12737 W System.err: 	at libcore.io.IoBridge.write(IoBridge.java:544)
         1606083398.043 12272 12737 W System.err: 	at java.io.FileOutputStream.write(FileOutputStream.java:392)
         1606083398.043 12272 12737 W System.err: 	at sun.nio.cs.StreamEncoder.writeBytes(StreamEncoder.java:221)
         1606083398.043 12272 12737 W System.err: 	at sun.nio.cs.StreamEncoder.implWrite(StreamEncoder.java:282)
         1606083398.043 12272 12737 W System.err: 	at sun.nio.cs.StreamEncoder.write(StreamEncoder.java:125)
         1606083398.043 12272 12737 W System.err: 	at java.io.OutputStreamWriter.write(OutputStreamWriter.java:207)
         1606083398.043 12272 12737 W System.err: 	at java.io.BufferedWriter.flushBuffer(BufferedWriter.java:129)
         1606083398.043 12272 12737 W System.err: 	at java.io.BufferedWriter.close(BufferedWriter.java:265)
         1606083398.043 12272 12737 W System.err: 	at com.fluentbuild.apollo.foundation.IoUtilsKt.closeCatching(IoUtils.kt:26)
         1606083398.044 12272 12737 W System.err: 	at com.fluentbuild.apollo.foundation.FileUtilsKt.autoCloseBufferedWriter(FileUtils.kt:115)
         1606083398.044 12272 12737 W System.err: 	at com.fluentbuild.apollo.foundation.FileUtilsKt.copyAllLines(FileUtils.kt:61)
         1606083398.044 12272 12737 W System.err: 	at com.fluentbuild.apollo.runner.client.collators.logs.Logger.logToFile(Logger.kt:47)
         1606083398.044 12272 12737 W System.err: 	at com.fluentbuild.apollo.runner.client.collators.logs.Logger.logResiliently(Logger.kt:69)
         1606083398.044 12272 12737 W System.err: 	at com.fluentbuild.apollo.runner.client.collators.logs.Logger.access$logResiliently(Logger.kt:18)
         1606083398.044 12272 12737 W System.err: 	at com.fluentbuild.apollo.runner.client.collators.logs.Logger$startLogging$1.run(Logger.kt:34)
         1606083398.044 12272 12737 W System.err: 	at java.lang.Thread.run(Thread.java:919)
         1606083398.044 12272 12737 W System.err: Caused by: android.system.ErrnoException: write failed: EBADF (Bad file descriptor)
         1606083398.044 12272 12737 W System.err: 	at libcore.io.Linux.writeBytes(Native Method)
         1606083398.045 12272 12737 W System.err: 	at libcore.io.Linux.write(Linux.java:294)
         1606083398.045 12272 12737 W System.err: 	at libcore.io.ForwardingOs.write(ForwardingOs.java:241)
         1606083398.045 12272 12737 W System.err: 	at libcore.io.BlockGuardOs.write(BlockGuardOs.java:416)
         1606083398.045 12272 12737 W System.err: 	at libcore.io.ForwardingOs.write(ForwardingOs.java:241)
         1606083398.045 12272 12737 W System.err: 	at libcore.io.IoBridge.write(IoBridge.java:539)
         1606083398.045 12272 12737 W System.err: 	... 15 more
         1606083398.047 12272 12737 E Logger  : Logging error
         1606083398.047 12272 12737 E Logger  : java.io.InterruptedIOException: read interrupted
         1606083398.047 12272 12737 E Logger  : 	at libcore.io.Linux.readBytes(Native Method)
         1606083398.047 12272 12737 E Logger  : 	at libcore.io.Linux.read(Linux.java:190)
         1606083398.047 12272 12737 E Logger  : 	at libcore.io.ForwardingOs.read(ForwardingOs.java:177)
         1606083398.047 12272 12737 E Logger  : 	at libcore.io.BlockGuardOs.read(BlockGuardOs.java:303)
         1606083398.047 12272 12737 E Logger  : 	at libcore.io.ForwardingOs.read(ForwardingOs.java:177)
         1606083398.047 12272 12737 E Logger  : 	at libcore.io.IoBridge.read(IoBridge.java:513)
         1606083398.047 12272 12737 E Logger  : 	at java.io.FileInputStream.read(FileInputStream.java:313)
         1606083398.047 12272 12737 E Logger  : 	at java.io.BufferedInputStream.read1(BufferedInputStream.java:286)
         1606083398.047 12272 12737 E Logger  : 	at java.io.BufferedInputStream.read(BufferedInputStream.java:347)
         1606083398.047 12272 12737 E Logger  : 	at sun.nio.cs.StreamDecoder.readBytes(StreamDecoder.java:291)
         1606083398.047 12272 12737 E Logger  : 	at sun.nio.cs.StreamDecoder.implRead(StreamDecoder.java:355)
         1606083398.047 12272 12737 E Logger  : 	at sun.nio.cs.StreamDecoder.read(StreamDecoder.java:181)
         1606083398.047 12272 12737 E Logger  : 	at java.io.InputStreamReader.read(InputStreamReader.java:184)
         1606083398.047 12272 12737 E Logger  : 	at java.io.BufferedReader.fill(BufferedReader.java:172)
         1606083398.047 12272 12737 E Logger  : 	at java.io.BufferedReader.readLine(BufferedReader.java:335)
         1606083398.047 12272 12737 E Logger  : 	at java.io.BufferedReader.readLine(BufferedReader.java:400)
         1606083398.047 12272 12737 E Logger  : 	at kotlin.io.LinesSequence$iterator$1.hasNext(ReadWrite.kt:80)
         1606083398.047 12272 12737 E Logger  : 	at com.fluentbuild.apollo.foundation.FileUtilsKt$copyAllLines$1$1.invoke(FileUtils.kt:101)
         1606083398.047 12272 12737 E Logger  : 	at com.fluentbuild.apollo.foundation.FileUtilsKt$copyAllLines$1$1.invoke(Unknown Source:2)
         1606083398.047 12272 12737 E Logger  : 	at com.fluentbuild.apollo.foundation.FileUtilsKt.autoCloseBufferedWriter(FileUtils.kt:52)
         1606083398.047 12272 12737 E Logger  : 	at com.fluentbuild.apollo.foundation.FileUtilsKt.copyAllLines(FileUtils.kt:61)
         1606083398.047 12272 12737 E Logger  : 	at com.fluentbuild.apollo.runner.client.collators.logs.Logger.logToFile(Logger.kt:47)
         1606083398.047 12272 12737 E Logger  : 	at com.fluentbuild.apollo.runner.client.collators.logs.Logger.logResiliently(Logger.kt:69)
         1606083398.047 12272 12737 E Logger  : 	at com.fluentbuild.apollo.runner.client.collators.logs.Logger.access$logResiliently(Logger.kt:18)
         1606083398.047 12272 12737 E Logger  : 	at com.fluentbuild.apollo.runner.client.collators.logs.Logger$startLogging$1.run(Logger.kt:34)
         1606083398.047 12272 12737 E Logger  : 	at java.lang.Thread.run(Thread.java:919)
         1606083398.097 12272 12348 E memtrack: Couldn't load memtrack module
         1606083398.097 12272 12348 W android.os.Debug: failed to get memory consumption info: -1
         1606083398.113 12272 12359 E memtrack: Couldn't load memtrack module
         1606083398.113 12272 12359 W android.os.Debug: failed to get memory consumption info: -1
         1606083398.134 12272 12359 W ParcelFileDescriptor: Peer didn't provide a comm channel; unable to check for errors
         1606083398.146 12272 12359 I Logger  : Starting logging!
         1606083398.155 12272 12750 W ParcelFileDescriptor: Peer didn't provide a comm channel; unable to check for errors
         1606083398.159 12272 12272 D GeckoRuntime: Lifecycle: onPause
         1606083398.159 12272 12272 D GeckoNetworkManager: Incoming event stop for state OnWithListeners -> OffWithListeners
         1606083398.225 12272 12359 E memtrack: Couldn't load memtrack module
         1606083398.225 12272 12359 W android.os.Debug: failed to get memory consumption info: -1
         1606083398.245 12272 12359 I TestRunner: finished: testVisitingMultipleSites(org.mozilla.focus.activity.MultitaskingTest)
         1606083398.246 12272 12359 I TestObserver: TEST_FINISHED:testVisitingMultipleSites(org.mozilla.focus.activity.MultitaskingTest)
         1606083398.246 12272 12359 I Logger  : Stopping logging!
         1606083398.248 12272 12750 W System.err: java.io.IOException: write failed: EBADF (Bad file descriptor)
         1606083398.248 12272 12750 W System.err: 	at libcore.io.IoBridge.write(IoBridge.java:544)
         1606083398.248 12272 12750 W System.err: 	at java.io.FileOutputStream.write(FileOutputStream.java:392)
         1606083398.248 12272 12750 W System.err: 	at sun.nio.cs.StreamEncoder.writeBytes(StreamEncoder.java:221)
         1606083398.248 12272 12750 W System.err: 	at sun.nio.cs.StreamEncoder.implWrite(StreamEncoder.java:282)
         1606083398.248 12272 12750 W System.err: 	at sun.nio.cs.StreamEncoder.write(StreamEncoder.java:125)
         1606083398.248 12272 12750 W System.err: 	at java.io.OutputStreamWriter.write(OutputStreamWriter.java:207)
         1606083398.248 12272 12750 W System.err: 	at java.io.BufferedWriter.flushBuffer(BufferedWriter.java:129)
         1606083398.249 12272 12750 W System.err: 	at java.io.BufferedWriter.close(BufferedWriter.java:265)
         1606083398.249 12272 12750 W System.err: 	at com.fluentbuild.apollo.foundation.IoUtilsKt.closeCatching(IoUtils.kt:26)
         1606083398.249 12272 12750 W System.err: 	at com.fluentbuild.apollo.foundation.FileUtilsKt.autoCloseBufferedWriter(FileUtils.kt:115)
         1606083398.249 12272 12750 W System.err: 	at com.fluentbuild.apollo.foundation.FileUtilsKt.copyAllLines(FileUtils.kt:61)
         1606083398.249 12272 12750 W System.err: 	at com.fluentbuild.apollo.runner.client.collators.logs.Logger.logToFile(Logger.kt:47)
         1606083398.249 12272 12750 W System.err: 	at com.fluentbuild.apollo.runner.client.collators.logs.Logger.logResiliently(Logger.kt:69)
         1606083398.249 12272 12750 W System.err: 	at com.fluentbuild.apollo.runner.client.collators.logs.Logger.access$logResiliently(Logger.kt:18)
         1606083398.249 12272 12750 W System.err: 	at com.fluentbuild.apollo.runner.client.collators.logs.Logger$startLogging$1.run(Logger.kt:34)
         1606083398.249 12272 12750 W System.err: 	at java.lang.Thread.run(Thread.java:919)
         1606083398.250 12272 12750 W System.err: Caused by: android.system.ErrnoException: write failed: EBADF (Bad file descriptor)
         1606083398.250 12272 12750 W System.err: 	at libcore.io.Linux.writeBytes(Native Method)
         1606083398.250 12272 12750 W System.err: 	at libcore.io.Linux.write(Linux.java:294)
         1606083398.250 12272 12750 W System.err: 	at libcore.io.ForwardingOs.write(ForwardingOs.java:241)
         1606083398.250 12272 12750 W System.err: 	at libcore.io.BlockGuardOs.write(BlockGuardOs.java:416)
         1606083398.250 12272 12750 W System.err: 	at libcore.io.ForwardingOs.write(ForwardingOs.java:241)
         1606083398.250 12272 12750 W System.err: 	at libcore.io.IoBridge.write(IoBridge.java:539)
         1606083398.250 12272 12750 W System.err: 	... 15 more
         1606083398.254 12272 12750 E Logger  : Logging error
         1606083398.254 12272 12750 E Logger  : java.io.InterruptedIOException: read interrupted
         1606083398.254 12272 12750 E Logger  : 	at libcore.io.Linux.readBytes(Native Method)
         1606083398.254 12272 12750 E Logger  : 	at libcore.io.Linux.read(Linux.java:190)
         1606083398.254 12272 12750 E Logger  : 	at libcore.io.ForwardingOs.read(ForwardingOs.java:177)
         1606083398.254 12272 12750 E Logger  : 	at libcore.io.BlockGuardOs.read(BlockGuardOs.java:303)
         1606083398.254 12272 12750 E Logger  : 	at libcore.io.ForwardingOs.read(ForwardingOs.java:177)
         1606083398.254 12272 12750 E Logger  : 	at libcore.io.IoBridge.read(IoBridge.java:513)
         1606083398.254 12272 12750 E Logger  : 	at java.io.FileInputStream.read(FileInputStream.java:313)
         1606083398.254 12272 12750 E Logger  : 	at java.io.BufferedInputStream.read1(BufferedInputStream.java:286)
         1606083398.254 12272 12750 E Logger  : 	at java.io.BufferedInputStream.read(BufferedInputStream.java:347)
         1606083398.254 12272 12750 E Logger  : 	at sun.nio.cs.StreamDecoder.readBytes(StreamDecoder.java:291)
         1606083398.254 12272 12750 E Logger  : 	at sun.nio.cs.StreamDecoder.implRead(StreamDecoder.java:355)
         1606083398.254 12272 12750 E Logger  : 	at sun.nio.cs.StreamDecoder.read(StreamDecoder.java:181)
         1606083398.254 12272 12750 E Logger  : 	at java.io.InputStreamReader.read(InputStreamReader.java:184)
         1606083398.254 12272 12750 E Logger  : 	at java.io.BufferedReader.fill(BufferedReader.java:172)
         1606083398.254 12272 12750 E Logger  : 	at java.io.BufferedReader.readLine(BufferedReader.java:335)
         1606083398.254 12272 12750 E Logger  : 	at java.io.BufferedReader.readLine(BufferedReader.java:400)
         1606083398.254 12272 12750 E Logger  : 	at kotlin.io.LinesSequence$iterator$1.hasNext(ReadWrite.kt:80)
         1606083398.254 12272 12750 E Logger  : 	at com.fluentbuild.apollo.foundation.FileUtilsKt$copyAllLines$1$1.invoke(FileUtils.kt:101)
         1606083398.254 12272 12750 E Logger  : 	at com.fluentbuild.apollo.foundation.FileUtilsKt$copyAllLines$1$1.invoke(Unknown Source:2)
         1606083398.254 12272 12750 E Logger  : 	at com.fluentbuild.apollo.foundation.FileUtilsKt.autoCloseBufferedWriter(FileUtils.kt:52)
         1606083398.254 12272 12750 E Logger  : 	at com.fluentbuild.apollo.foundation.FileUtilsKt.copyAllLines(FileUtils.kt:61)
         1606083398.254 12272 12750 E Logger  : 	at com.fluentbuild.apollo.runner.client.collators.logs.Logger.logToFile(Logger.kt:47)
         1606083398.254 12272 12750 E Logger  : 	at com.fluentbuild.apollo.runner.client.collators.logs.Logger.logResiliently(Logger.kt:69)
         1606083398.254 12272 12750 E Logger  : 	at com.fluentbuild.apollo.runner.client.collators.logs.Logger.access$logResiliently(Logger.kt:18)
         1606083398.254 12272 12750 E Logger  : 	at com.fluentbuild.apollo.runner.client.collators.logs.Logger$startLogging$1.run(Logger.kt:34)
         1606083398.254 12272 12750 E Logger  : 	at java.lang.Thread.run(Thread.java:919)
         1606083398.313 12272 12348 E memtrack: Couldn't load memtrack module
         1606083398.314 12272 12348 W android.os.Debug: failed to get memory consumption info: -1
         1606083398.322 12272 12359 E memtrack: Couldn't load memtrack module
         1606083398.322 12272 12359 W android.os.Debug: failed to get memory consumption info: -1
         1606083398.343 12272 12359 W ParcelFileDescriptor: Peer didn't provide a comm channel; unable to check for errors
         1606083398.360 12272 12359 I Logger  : Starting logging!
         1606083398.375 12272 12756 W ParcelFileDescriptor: Peer didn't provide a comm channel; unable to check for errors
         1606083398.438 12272 12359 E memtrack: Couldn't load memtrack module
         1606083398.438 12272 12359 W android.os.Debug: failed to get memory consumption info: -1
         1606083398.458 12272 12272 I MonitoringInstr: Activities that are still in CREATED to STOPPED: 0
         1606083398.460 12272 12359 I TestRunner: started: testCustomTabUI(org.mozilla.focus.activity.CustomTabTest)
         1606083398.460 12272 12359 I TestObserver: TEST_STARTED:testCustomTabUI(org.mozilla.focus.activity.CustomTabTest)
         1606083398.461 12272 12272 I MonitoringInstr: Activities that are still in CREATED to STOPPED: 0
         1606083398.474 12272 12762 I MockWebServer: MockWebServer[59235] starting to accept connections
         1606083398.510 12272 12272 W ActivityThread: handleWindowVisibility: no activity for token android.os.BinderProxy@153c351
         1606083398.530 12272 12348 E memtrack: Couldn't load memtrack module
         1606083398.530 12272 12348 W android.os.Debug: failed to get memory consumption info: -1
         1606083398.547 12272 12272 I ActivityMonitor: Activity: org.mozilla.focus.activity.IntentReceiverActivity@939bc24 is in stage: PRE_ON_CREATE
         1606083398.547 12272 12272 D LifecycleMonitor: Lifecycle status change: org.mozilla.focus.activity.IntentReceiverActivity@939bc24 in: PRE_ON_CREATE
         1606083398.561 12272 12272 W Focus   : Could not read from intent.
         1606083398.561 12272 12272 W Focus   : kotlin.TypeCastException: null cannot be cast to non-null type T
         1606083398.561 12272 12272 W Focus   : 	at mozilla.components.support.utils.SafeIntent$getParcelableExtra$1.invoke(SafeIntent.kt:68)
         1606083398.561 12272 12272 W Focus   : 	at mozilla.components.support.utils.SafeIntent$getParcelableExtra$1.invoke(SafeIntent.kt:20)
         1606083398.561 12272 12272 W Focus   : 	at mozilla.components.support.utils.SafeIntent.safeAccess(SafeIntent.kt:85)
         1606083398.561 12272 12272 W Focus   : 	at mozilla.components.support.utils.SafeIntent.safeAccess$default(SafeIntent.kt:83)
         1606083398.561 12272 12272 W Focus   : 	at mozilla.components.support.utils.SafeIntent.getParcelableExtra(SafeIntent.kt:67)
         1606083398.561 12272 12272 W Focus   : 	at mozilla.components.feature.customtabs.CustomTabConfigHelperKt.getCloseButtonIcon(CustomTabConfigHelper.kt:115)
         1606083398.561 12272 12272 W Focus   : 	at mozilla.components.feature.customtabs.CustomTabConfigHelperKt.createCustomTabConfigFromIntent(CustomTabConfigHelper.kt:93)
         1606083398.561 12272 12272 W Focus   : 	at org.mozilla.focus.session.IntentProcessor.createSession(IntentProcessor.kt:139)
         1606083398.561 12272 12272 W Focus   : 	at org.mozilla.focus.session.IntentProcessor.createSessionFromIntent(IntentProcessor.kt:90)
         1606083398.561 12272 12272 W Focus   : 	at org.mozilla.focus.session.IntentProcessor.handleIntent(IntentProcessor.kt:48)
         1606083398.561 12272 12272 W Focus   : 	at org.mozilla.focus.activity.IntentReceiverActivity.onCreate(IntentReceiverActivity.kt:32)
         1606083398.561 12272 12272 W Focus   : 	at android.app.Activity.performCreate(Activity.java:7963)
         1606083398.561 12272 12272 W Focus   : 	at android.app.Activity.performCreate(Activity.java:7952)
         1606083398.561 12272 12272 W Focus   : 	at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1307)
         1606083398.561 12272 12272 W Focus   : 	at androidx.test.runner.MonitoringInstrumentation.callActivityOnCreate(MonitoringInstrumentation.java:702)
         1606083398.561 12272 12272 W Focus   : 	at com.fluentbuild.apollo.runner.client.androidx.AndroidXJUnitRunner.access$callActivityOnCreate$s281125429(AndroidXJUnitRunner.kt:10)
         1606083398.561 12272 12272 W Focus   : 	at com.fluentbuild.apollo.runner.client.androidx.AndroidXJUnitRunner$callActivityOnCreate$1.invoke(AndroidXJUnitRunner.kt:40)
         1606083398.561 12272 12272 W Focus   : 	at com.fluentbuild.apollo.runner.client.androidx.AndroidXJUnitRunner$callActivityOnCreate$1.invoke(AndroidXJUnitRunner.kt:10)
         1606083398.561 12272 12272 W Focus   : 	at com.fluentbuild.apollo.runner.client.instrumentation.lifecycle.ActivityMonitor.onCallActivityOnCreate(ActivityMonitor.kt:41)
         1606083398.561 12272 12272 W Focus   : 	at com.fluentbuild.apollo.runner.client.androidx.RunnerHelper.onCallActivityOnCreate(RunnerHelper.kt:70)
         1606083398.561 12272 12272 W Focus   : 	at com.fluentbuild.apollo.runner.client.androidx.AndroidXJUnitRunner.callActivityOnCreate(AndroidXJUnitRunner.kt:39)
         1606083398.561 12272 12272 W Focus   : 	at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:3629)
         1606083398.561 12272 12272 W Focus   : 	at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:3806)
         1606083398.561 12272 12272 W Focus   : 	at android.app.servertransaction.LaunchActivityItem.execute(LaunchActivityItem.java:83)
         1606083398.561 12272 12272 W Focus   : 	at android.app.servertransaction.TransactionExecutor.executeCallbacks(TransactionExecutor.java:135)
         1606083398.561 12272 12272 W Focus   : 	at android.app.servertransaction.TransactionExecutor.execute(TransactionExecutor.java:95)
         1606083398.561 12272 12272 W Focus   : 	at android.app.ActivityThread$H.handleMessage(ActivityThread.java:2267)
         1606083398.561 12272 12272 W Focus   : 	at android.os.Handler.dispatchMessage(Handler.java:107)
         1606083398.561 12272 12272 W Focus   : 	at android.os.Looper.loop(Looper.java:237)
         1606083398.561 12272 12272 W Focus   : 	at android.app.ActivityThread.main(ActivityThread.java:8167)
         1606083398.561 12272 12272 W Focus   : 	at java.lang.reflect.Method.invoke(Native Method)
         1606083398.561 12272 12272 W Focus   : 	at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:496)
         1606083398.561 12272 12272 W Focus   : 	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1100)
--------- switch to events
         1606083398.633 12272 12272 I am_on_create_called: [0,org.mozilla.focus.activity.IntentReceiverActivity,performCreate]
         1606083398.633 12272 12272 I am_on_create_called: [0,org.mozilla.focus.activity.IntentReceiverActivity,performCreate]
--------- switch to main
         1606083398.644 12272 12272 D PhoneWindow: forceLight changed to true [] from com.android.internal.policy.PhoneWindow.updateForceLightNavigationBar:4274 com.android.internal.policy.DecorView.updateColorViews:1547 com.android.internal.policy.PhoneWindow.dispatchWindowAttributesChanged:3252 android.view.Window.setFlags:1153 com.android.internal.policy.PhoneWindow.generateLayout:2474 
         1606083398.646 12272 12272 I MultiWindowDecorSupport: [INFO] isPopOver = false
         1606083398.646 12272 12272 I MultiWindowDecorSupport: updateCaptionType >> DecorView@bfa8b89[], isFloating: false, isApplication: true, hasWindowDecorCaption: false, hasWindowControllerCallback: true
         1606083398.646 12272 12272 D MultiWindowDecorSupport: setCaptionType = 0, DecorView = DecorView@bfa8b89[]
         1606083398.659 12272 12272 D LifecycleMonitor: Lifecycle status change: org.mozilla.focus.activity.IntentReceiverActivity@939bc24 in: CREATED
         1606083398.659 12272 12272 I ActivityMonitor: Activity: org.mozilla.focus.activity.IntentReceiverActivity@939bc24 is in stage: CREATED
         1606083398.669 12272 12347 W ParcelFileDescriptor: Peer didn't provide a comm channel; unable to check for errors
         1606083398.673 12272 12272 D StrictMode: StrictMode policy violation; ~duration=81 ms: android.os.strictmode.DiskReadViolation
         1606083398.673 12272 12272 D StrictMode: 	at android.os.StrictMode$AndroidBlockGuardPolicy.onReadFromDisk(StrictMode.java:1556)
         1606083398.673 12272 12272 D StrictMode: 	at android.database.sqlite.SQLiteConnection.applyBlockGuardPolicy(SQLiteConnection.java:1524)
         1606083398.673 12272 12272 D StrictMode: 	at android.database.sqlite.SQLiteConnection.executeForCursorWindow(SQLiteConnection.java:1193)
         1606083398.673 12272 12272 D StrictMode: 	at android.database.sqlite.SQLiteSession.executeForCursorWindow(SQLiteSession.java:838)
         1606083398.673 12272 12272 D StrictMode: 	at android.database.sqlite.SQLiteQuery.fillWindow(SQLiteQuery.java:62)
         1606083398.673 12272 12272 D StrictMode: 	at android.database.sqlite.SQLiteCursor.fillWindow(SQLiteCursor.java:165)
         1606083398.673 12272 12272 D StrictMode: 	at android.database.sqlite.SQLiteCursor.getCount(SQLiteCursor.java:152)
         1606083398.673 12272 12272 D StrictMode: 	at android.database.AbstractCursor.moveToPosition(AbstractCursor.java:232)
         1606083398.673 12272 12272 D StrictMode: 	at android.database.AbstractCursor.moveToNext(AbstractCursor.java:281)
         1606083398.673 12272 12272 D StrictMode: 	at com.android.server.enterprise.storage.EdmStorageProviderBase.getBooleanList(EdmStorageProviderBase.java:129)
         1606083398.673 12272 12272 D StrictMode: 	at com.android.server.enterprise.storage.EdmStorageProviderBase.getBoolean(EdmStorageProviderBase.java:1016)
         1606083398.673 12272 12272 D StrictMode: 	at com.android.server.enterprise.storage.EdmStorageProvider.getBoolean(EdmStorageProvider.java:236)
         1606083398.673 12272 12272 D StrictMode: 	at com.samsung.android.knox.custom.KnoxCustomManagerService.getProKioskState(KnoxCustomManagerService.java:1449)
         1606083398.673 12272 12272 D StrictMode: 	at com.samsung.android.knox.custom.ProKioskManager.getProKioskState(ProKioskManager.java:120)
         1606083398.673 12272 12272 D StrictMode: 	at com.android.server.pm.PackageManagerService.chooseBestActivity(PackageManagerService.java:8051)
         1606083398.673 12272 12272 D StrictMode: 	at com.android.server.pm.PackageManagerService.resolveIntentInternal(PackageManagerService.java:7870)
         1606083398.673 12272 12272 D StrictMode: 	at com.android.server.pm.PackageManagerService.access$10000(PackageManagerService.java:569)
         1606083398.673 12272 12272 D StrictMode: 	at com.android.server.pm.PackageManagerService$PackageManagerInternalImpl.resolveIntent(PackageManagerService.java:30986)
         1606083398.673 12272 12272 D StrictMode: 	at com.android.server.wm.ActivityStackSupervisor.resolveIntent(ActivityStackSupervisor.java:869)
         1606083398.673 12272 12272 D StrictMode: 	at com.android.server.wm.ActivityStarter.startActivityMayWait(ActivityStarter.java:1693)
         1606083398.673 12272 12272 D StrictMode: 	at com.android.server.wm.ActivityStarter.execute(ActivityStarter.java:646)
         1606083398.673 12272 12272 D StrictMode: 	at com.android.server.wm.ActivityTaskManagerService.startActivityAsUser(ActivityTaskManagerService.java:1717)
         1606083398.673 12272 12272 D StrictMode: 	at com.android.server.wm.ActivityTaskManagerService.startActivityAsUser(ActivityTaskManagerService.java:1613)
         1606083398.673 12272 12272 D StrictMode: 	at com.android.server.wm.ActivityTaskManagerService.startActivity(ActivityTaskManagerService.java:1566)
         1606083398.673 12272 12272 D StrictMode: 	at android.app.IActivityTaskManager$Stub.onTransact(IActivityTaskManager.java:1746)
         1606083398.673 12272 12272 D StrictMode: 	at android.os.Binder.execTransactInternal(Binder.java:1056)
         1606083398.673 12272 12272 D StrictMode: 	at android.os.Binder.execTransact(Binder.java:1029)
         1606083398.673 12272 12272 D StrictMode: # via Binder call with stack:
         1606083398.673 12272 12272 D StrictMode: 	at android.os.StrictMode.readAndHandleBinderCallViolations(StrictMode.java:2274)
         1606083398.673 12272 12272 D StrictMode: 	at android.os.Parcel.readExceptionCode(Parcel.java:2034)
         1606083398.673 12272 12272 D StrictMode: 	at android.os.Parcel.readException(Parcel.java:2001)
         1606083398.673 12272 12272 D StrictMode: 	at android.app.IActivityTaskManager$Stub$Proxy.startActivity(IActivityTaskManager.java:4454)
         1606083398.673 12272 12272 D StrictMode: 	at android.app.Instrumentation.execStartActivity(Instrumentation.java:1716)
         1606083398.673 12272 12272 D StrictMode: 	at androidx.test.runner.MonitoringInstrumentation.execStartActivity(MonitoringInstrumentation.java:536)
         1606083398.673 12272 12272 D StrictMode: 	at android.app.Activity.startActivityForResult(Activity.java:5258)
         1606083398.673 12272 12272 D StrictMode: 	at android.app.Activity.startActivityForResult(Activity.java:5203)
         1606083398.673 12272 12272 D StrictMode: 	at android.app.Activity.startActivity(Activity.java:5587)
         1606083398.673 12272 12272 D StrictMode: 	at android.app.Activity.startActivity(Activity.java:5555)
         1606083398.673 12272 12272 D StrictMode: 	at org.mozilla.focus.activity.IntentReceiverActivity.dispatchCustomTabsIntent(IntentReceiverActivity.kt:52)
         1606083398.673 12272 12272 D StrictMode: 	at org.mozilla.focus.activity.IntentReceiverActivity.onCreate(IntentReceiverActivity.kt:35)
         1606083398.673 12272 12272 D StrictMode: 	at android.app.Activity.performCreate(Activity.java:7963)
         1606083398.673 12272 12272 D StrictMode: 	at android.app.Activity.performCreate(Activity.java:7952)
         1606083398.673 12272 12272 D StrictMode: 	at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1307)
         1606083398.673 12272 12272 D StrictMode: 	at androidx.test.runner.MonitoringInstrumentation.callActivityOnCreate(MonitoringInstrumentation.java:702)
         1606083398.673 12272 12272 D StrictMode: 	at com.fluentbuild.apollo.runner.client.androidx.AndroidXJUnitRunner.access$callActivityOnCreate$s281125429(AndroidXJUnitRunner.kt:10)
         1606083398.673 12272 12272 D StrictMode: 	at com.fluentbuild.apollo.runner.client.androidx.AndroidXJUnitRunner$callActivityOnCreate$1.i
         1606083398.727 12272 12272 W ActivityThread: handleWindowVisibility: no activity for token android.os.BinderProxy@32771a7
         1606083398.733 12272 12272 I ActivityMonitor: Activity: org.mozilla.focus.activity.CustomTabActivity@94f8143 is in stage: PRE_ON_CREATE
         1606083398.733 12272 12272 D LifecycleMonitor: Lifecycle status change: org.mozilla.focus.activity.CustomTabActivity@94f8143 in: PRE_ON_CREATE
         1606083398.743 12272 12272 D PhoneWindow: forceLight changed to true [] from com.android.internal.policy.PhoneWindow.updateForceLightNavigationBar:4274 com.android.internal.policy.DecorView.updateColorViews:1547 com.android.internal.policy.PhoneWindow.dispatchWindowAttributesChanged:3252 android.view.Window.setFlags:1153 com.android.internal.policy.PhoneWindow.generateLayout:2474 
         1606083398.744 12272 12272 I MultiWindowDecorSupport: [INFO] isPopOver = false
         1606083398.744 12272 12272 I MultiWindowDecorSupport: updateCaptionType >> DecorView@802a24a[], isFloating: false, isApplication: true, hasWindowDecorCaption: false, hasWindowControllerCallback: true
         1606083398.744 12272 12272 D MultiWindowDecorSupport: setCaptionType = 0, DecorView = DecorView@802a24a[]
         1606083398.754 12272 12272 D GeckoWebViewProvider: Sending change to Gecko ping
--------- switch to events
         1606083398.755 12272 12272 I am_on_create_called: [0,org.mozilla.focus.activity.CustomTabActivity,performCreate]
--------- switch to main
         1606083398.755 12272 12272 D LifecycleMonitor: Lifecycle status change: org.mozilla.focus.activity.CustomTabActivity@94f8143 in: CREATED
         1606083398.755 12272 12272 I ActivityMonitor: Activity: org.mozilla.focus.activity.CustomTabActivity@94f8143 is in stage: CREATED
         1606083398.774 12272 12272 I OpenGLRenderer: RenderNode setPositionListener(0xb6adea20) is called
         1606083398.784 12272 12272 W lla.focus.debu: Accessing hidden field Landroid/widget/EdgeEffect;->mPaint:Landroid/graphics/Paint; (greylist-max-p, reflection, allowed)
         1606083398.786 12272 12446 I Gecko   : Can't find symbol 'eglQuerySurfacePointerANGLE'.
         1606083398.786 12272 12446 I Gecko   : Can't find symbol 'eglQueryDisplayAttribEXT'.
         1606083398.786 12272 12272 W GeckoEventDispatcher: No listener for GeckoView:AccessibilityEnabled
         1606083398.786 12272 12446 I Gecko   : Can't find symbol 'eglQueryDeviceAttribEXT'.
         1606083398.786 12272 12446 I Gecko   : Can't find symbol 'eglStreamConsumerGLTextureExternalAttribsNV'.
         1606083398.787 12272 12446 I Gecko   : Can't find symbol 'eglCreateStreamProducerD3DTextureANGLE'.
         1606083398.787 12272 12446 I Gecko   : Can't find symbol 'eglStreamPostD3DTextureANGLE'.
         1606083398.788 12272 12446 I mali_egl: eglDestroySurface() in
         1606083398.788 12272 12446 I mali_egl: eglDestroySurface() out
         1606083398.792 12272 12446 I mali_egl: eglDestroySurface() in
         1606083398.792 12272 12446 I mali_egl: eglDestroySurface() out
         1606083398.809 12272 12272 D skia    : approximate: numPoints=46, lengths[0]=0.000000, totalLength=620.200073, segmentPoints[0]=[-197.600006,0.000000]
         1606083398.809 12272 12272 D skia    : approximate: approximation[0]=0.000000, approximation[1]=-197.600006, approximation[2]=0.000000
         1606083398.809 12272 12272 D skia    : approximate: numPoints=46, lengths[45]=620.200073, totalLength=620.200073, segmentPoints[45]=[422.600037,0.000000]
         1606083398.809 12272 12272 D skia    : approximate: approximation[135]=1.000000, approximation[136]=422.600037, approximation[137]=0.000000
         1606083398.810 12272 12272 D skia    : approximate: numPoints=4, lengths[0]=0.000000, totalLength=3.448155, segmentPoints[0]=[0.000000,0.100000]
         1606083398.810 12272 12272 D skia    : approximate: approximation[0]=0.000000, approximation[1]=0.000000, approximation[2]=0.100000
         1606083398.810 12272 12272 D skia    : approximate: numPoints=4, lengths[3]=3.448155, totalLength=3.448155, segmentPoints[3]=[3.000000,0.100000]
         1606083398.810 12272 12272 D skia    : approximate: approximation[9]=1.000000, approximation[10]=3.000000, approximation[11]=0.100000
         1606083398.811 12272 12272 D skia    : approximate: numPoints=43, lengths[0]=0.000000, totalLength=722.199951, segmentPoints[0]=[-522.599976,0.000000]
         1606083398.811 12272 12272 D skia    : approximate: approximation[0]=0.000000, approximation[1]=-522.599976, approximation[2]=0.000000
         1606083398.811 12272 12272 D skia    : approximate: numPoints=43, lengths[42]=722.199951, totalLength=722.199951, segmentPoints[42]=[199.600006,0.000000]
         1606083398.811 12272 12272 D skia    : approximate: approximation[126]=1.000000, approximation[127]=199.600006, approximation[128]=0.000000
         1606083398.812 12272 12272 D skia    : approximate: numPoints=3, lengths[0]=0.000000, totalLength=2.472497, segmentPoints[0]=[0.000000,0.100000]
         1606083398.812 12272 12272 D skia    : approximate: approximation[0]=0.000000, approximation[1]=0.000000, approximation[2]=0.100000
         1606083398.812 12272 12272 D skia    : approximate: numPoints=3, lengths[2]=2.472497, totalLength=2.472497, segmentPoints[2]=[2.000000,0.100000]
         1606083398.812 12272 12272 D skia    : approximate: approximation[6]=1.000000, approximation[7]=2.000000, approximation[8]=0.100000
         1606083398.899 12272 12446 W GeckoEventDispatcher: No listener for GeckoView:AccessibilityEnabled
         1606083398.913 12272 12272 D LifecycleMonitor: Lifecycle status change: org.mozilla.focus.activity.CustomTabActivity@94f8143 in: STARTED
         1606083398.913 12272 12272 I ActivityMonitor: Activity: org.mozilla.focus.activity.CustomTabActivity@94f8143 is in stage: STARTED
--------- switch to events
         1606083398.913 12272 12272 I am_on_start_called: [0,org.mozilla.focus.activity.CustomTabActivity,handleStartActivity]
--------- switch to main
         1606083398.914 12272 12272 D GeckoRuntime: Lifecycle: onStart
         1606083398.920 12272 12272 D LifecycleMonitor: Lifecycle status change: org.mozilla.focus.activity.CustomTabActivity@94f8143 in: RESUMED
         1606083398.920 12272 12272 I ActivityMonitor: Activity: org.mozilla.focus.activity.CustomTabActivity@94f8143 is in stage: RESUMED
--------- switch to events
         1606083398.920 12272 12272 I am_on_resume_called: [0,org.mozilla.focus.activity.CustomTabActivity,RESUME_ACTIVITY]
--------- switch to main
         1606083398.921 12272 12272 D GeckoLocales: No selected locale. No correction needed.
         1606083398.922 12272 12272 D GeckoRuntime: Lifecycle: onResume
         1606083398.922 12272 12272 D GeckoNetworkManager: Incoming event start for state OffWithListeners -> OnWithListeners
         1606083398.931 12272 12272 I ViewRootImpl@38b7ec6[CustomTabActivity]: setView = com.android.internal.policy.DecorView@802a24a TM=true MM=false
         1606083398.934 12272 12272 D StrictMode: StrictMode policy violation; ~duration=25 ms: android.os.strictmode.DiskReadViolation
         1606083398.934 12272 12272 D StrictMode: 	at android.os.StrictMode$AndroidBlockGuardPolicy.onReadFromDisk(StrictMode.java:1556)
         1606083398.934 12272 12272 D StrictMode: 	at libcore.io.BlockGuardOs.access(BlockGuardOs.java:69)
         1606083398.934 12272 12272 D StrictMode: 	at libcore.io.ForwardingOs.access(ForwardingOs.java:73)
         1606083398.934 12272 12272 D StrictMode: 	at android.app.ActivityThread$AndroidOs.access(ActivityThread.java:8035)
         1606083398.934 12272 12272 D StrictMode: 	at java.io.UnixFileSystem.checkAccess(UnixFileSystem.java:281)
         1606083398.934 12272 12272 D StrictMode: 	at java.io.File.exists(File.java:815)
         1606083398.934 12272 12272 D StrictMode: 	at android.app.ContextImpl.ensurePrivateDirExists(ContextImpl.java:674)
         1606083398.934 12272 12272 D StrictMode: 	at android.app.ContextImpl.ensurePrivateDirExists(ContextImpl.java:665)
         1606083398.934 12272 12272 D StrictMode: 	at android.app.ContextImpl.getPreferencesDir(ContextImpl.java:621)
         1606083398.934 12272 12272 D StrictMode: 	at android.app.ContextImpl.getSharedPreferencesPath(ContextImpl.java:830)
         1606083398.934 12272 12272 D StrictMode: 	at android.app.ContextImpl.getSharedPreferences(ContextImpl.java:458)
         1606083398.934 12272 12272 D StrictMode: 	at android.content.ContextWrapper.getSharedPreferences(ContextWrapper.java:184)
         1606083398.934 12272 12272 D StrictMode: 	at org.mozilla.focus.exceptions.ExceptionDomains.preferences(ExceptionDomains.kt:77)
         1606083398.934 12272 12272 D StrictMode: 	at org.mozilla.focus.exceptions.ExceptionDomains.load(ExceptionDomains.kt:28)
         1606083398.934 12272 12272 D StrictMode: 	at org.mozilla.focus.fragment.BrowserFragment$sessionObserver$1.onUrlChanged(BrowserFragment.kt:1455)
         1606083398.934 12272 12272 D StrictMode: 	at org.mozilla.focus.fragment.BrowserFragment.onViewCreated(BrowserFragment.kt:347)
         1606083398.934 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.moveToState(FragmentManagerImpl.java:892)
         1606083398.934 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.moveFragmentToExpectedState(FragmentManagerImpl.java:1238)
         1606083398.934 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.moveToState(FragmentManagerImpl.java:1303)
         1606083398.934 12272 12272 D StrictMode: 	at androidx.fragment.app.BackStackRecord.executeOps(BackStackRecord.java:439)
         1606083398.934 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.executeOps(FragmentManagerImpl.java:2079)
         1606083398.934 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.executeOpsTogether(FragmentManagerImpl.java:1869)
         1606083398.934 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.removeRedundantOperationsAndExecute(FragmentManagerImpl.java:1824)
         1606083398.934 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.execPendingActions(FragmentManagerImpl.java:1727)
         1606083398.934 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.dispatchStateChange(FragmentManagerImpl.java:2663)
         1606083398.934 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.dispatchActivityCreated(FragmentManagerImpl.java:2613)
         1606083398.934 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentController.dispatchActivityCreated(FragmentController.java:246)
         1606083398.934 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentActivity.onStart(FragmentActivity.java:542)
         1606083398.934 12272 12272 D StrictMode: 	at androidx.appcompat.app.AppCompatActivity.onStart(AppCompatActivity.java:201)
         1606083398.934 12272 12272 D StrictMode: 	at android.app.Instrumentation.callActivityOnStart(Instrumentation.java:1433)
         1606083398.934 12272 12272 D StrictMode: 	at androidx.test.runner.MonitoringInstrumentation.callActivityOnStart(MonitoringInstrumentation.java:714)
         1606083398.934 12272 12272 D StrictMode: 	at com.fluentbuild.apollo.runner.client.androidx.AndroidXJUnitRunner.access$callActivityOnStart$s281125429(AndroidXJUnitRunner.kt:10)
         1606083398.934 12272 12272 D StrictMode: 	at com.fluentbuild.apollo.runner.client.androidx.AndroidXJUnitRunner$callActivityOnStart$1.invoke(AndroidXJUnitRunner.kt:56)
         1606083398.934 12272 12272 D StrictMode: 	at com.fluentbuild.apollo.runner.client.androidx.AndroidXJUnitRunner$callActivityOnStart$1.invoke(AndroidXJUnitRunner.kt:10)
         1606083398.934 12272 12272 D StrictMode: 	at com.fluentbuild.apollo.runner.client.instrumentation.lifecycle.ActivityMonitor.onCallActivityOnStart(ActivityMonitor.kt:57)
         1606083398.934 12272 12272 D StrictMode: 	at com.fluentbuild.apollo.runner.client.androidx.RunnerHelper.onCallActivityOnStart(RunnerHelper.kt:83)
         1606083398.934 12272 12272 D StrictMode: 	at com.fluentbuild.apollo.runner.client.androidx.AndroidXJUnitRunner.callActivityOnStart(AndroidXJUnitRunner.kt:55)
         1606083398.934 12272 12272 D StrictMode: 	at android.app.Activity.performStart(Activity.java:7986)
         1606083398.934 12272 12272 D StrictMode: 	at android.app.ActivityThread.handleStartActivity(ActivityThread.java:3677)
         1606083398.934 12272 12272 D StrictMode: 	at android.app.servertransaction.TransactionExecutor.performLifecycleSequence(TransactionExecutor.java:221)
         1606083398.934 12272 12272 D StrictMode: 	at android.app.servertransaction.TransactionExecutor.cycleToPath(TransactionExecutor.java:201)
         1606083398.934 12272 12272 D StrictMode: 	at android.app.servertransaction.TransactionExecutor.executeLifecycleState(TransactionExecutor.java:173)
         1606083398.934 12272 12272 D StrictMode: 	at android.app.servertransaction.TransactionExecutor.execute(TransactionExecutor.java:97)
         1606083398.934 12272 12272 D StrictMode: 	at android.app.ActivityThread$H.handleMessage(ActivityThread.java:2267)
         1606083398.934 12272 12272 D StrictMode: 	at android.os.Handler.dispatchMessage(Handler.java:107
         1606083398.935 12272 12272 D StrictMode: StrictMode policy violation; ~duration=22 ms: android.os.strictmode.DiskReadViolation
         1606083398.935 12272 12272 D StrictMode: 	at android.os.StrictMode$AndroidBlockGuardPolicy.onReadFromDisk(StrictMode.java:1556)
         1606083398.935 12272 12272 D StrictMode: 	at android.app.SharedPreferencesImpl.awaitLoadedLocked(SharedPreferencesImpl.java:261)
         1606083398.935 12272 12272 D StrictMode: 	at android.app.SharedPreferencesImpl.getString(SharedPreferencesImpl.java:287)
         1606083398.935 12272 12272 D StrictMode: 	at org.mozilla.focus.exceptions.ExceptionDomains.load(ExceptionDomains.kt:29)
         1606083398.935 12272 12272 D StrictMode: 	at org.mozilla.focus.fragment.BrowserFragment$sessionObserver$1.onUrlChanged(BrowserFragment.kt:1455)
         1606083398.935 12272 12272 D StrictMode: 	at org.mozilla.focus.fragment.BrowserFragment.onViewCreated(BrowserFragment.kt:347)
         1606083398.935 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.moveToState(FragmentManagerImpl.java:892)
         1606083398.935 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.moveFragmentToExpectedState(FragmentManagerImpl.java:1238)
         1606083398.935 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.moveToState(FragmentManagerImpl.java:1303)
         1606083398.935 12272 12272 D StrictMode: 	at androidx.fragment.app.BackStackRecord.executeOps(BackStackRecord.java:439)
         1606083398.935 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.executeOps(FragmentManagerImpl.java:2079)
         1606083398.935 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.executeOpsTogether(FragmentManagerImpl.java:1869)
         1606083398.935 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.removeRedundantOperationsAndExecute(FragmentManagerImpl.java:1824)
         1606083398.935 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.execPendingActions(FragmentManagerImpl.java:1727)
         1606083398.935 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.dispatchStateChange(FragmentManagerImpl.java:2663)
         1606083398.935 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentManagerImpl.dispatchActivityCreated(FragmentManagerImpl.java:2613)
         1606083398.935 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentController.dispatchActivityCreated(FragmentController.java:246)
         1606083398.935 12272 12272 D StrictMode: 	at androidx.fragment.app.FragmentActivity.onStart(FragmentActivity.java:542)
         1606083398.935 12272 12272 D StrictMode: 	at androidx.appcompat.app.AppCompatActivity.onStart(AppCompatActivity.java:201)
         1606083398.935 12272 12272 D StrictMode: 	at android.app.Instrumentation.callActivityOnStart(Instrumentation.java:1433)
         1606083398.935 12272 12272 D StrictMode: 	at androidx.test.runner.MonitoringInstrumentation.callActivityOnStart(MonitoringInstrumentation.java:714)
         1606083398.935 12272 12272 D StrictMode: 	at com.fluentbuild.apollo.runner.client.androidx.AndroidXJUnitRunner.access$callActivityOnStart$s281125429(AndroidXJUnitRunner.kt:10)
         1606083398.935 12272 12272 D StrictMode: 	at com.fluentbuild.apollo.runner.client.androidx.AndroidXJUnitRunner$callActivityOnStart$1.invoke(AndroidXJUnitRunner.kt:56)
         1606083398.935 12272 12272 D StrictMode: 	at com.fluentbuild.apollo.runner.client.androidx.AndroidXJUnitRunner$callActivityOnStart$1.invoke(AndroidXJUnitRunner.kt:10)
         1606083398.935 12272 12272 D StrictMode: 	at com.fluentbuild.apollo.runner.client.instrumentation.lifecycle.ActivityMonitor.onCallActivityOnStart(ActivityMonitor.kt:57)
         1606083398.935 12272 12272 D StrictMode: 	at com.fluentbuild.apollo.runner.client.androidx.RunnerHelper.onCallActivityOnStart(RunnerHelper.kt:83)
         1606083398.935 12272 12272 D StrictMode: 	at com.fluentbuild.apollo.runner.client.androidx.AndroidXJUnitRunner.callActivityOnStart(AndroidXJUnitRunner.kt:55)
         1606083398.935 12272 12272 D StrictMode: 	at android.app.Activity.performStart(Activity.java:7986)
         1606083398.935 12272 12272 D StrictMode: 	at android.app.ActivityThread.handleStartActivity(ActivityThread.java:3677)
         1606083398.935 12272 12272 D StrictMode: 	at android.app.servertransaction.TransactionExecutor.performLifecycleSequence(TransactionExecutor.java:221)
         1606083398.935 12272 12272 D StrictMode: 	at android.app.servertransaction.TransactionExecutor.cycleToPath(TransactionExecutor.java:201)
         1606083398.935 12272 12272 D StrictMode: 	at android.app.servertransaction.TransactionExecutor.executeLifecycleState(TransactionExecutor.java:173)
         1606083398.935 12272 12272 D StrictMode: 	at android.app.servertransaction.TransactionExecutor.execute(TransactionExecutor.java:97)
         1606083398.935 12272 12272 D StrictMode: 	at android.app.ActivityThread$H.handleMessage(ActivityThread.java:2267)
         1606083398.935 12272 12272 D StrictMode: 	at android.os.Handler.dispatchMessage(Handler.java:107)
         1606083398.935 12272 12272 D StrictMode: 	at android.os.Looper.loop(Looper.java:237)
         1606083398.935 12272 12272 D StrictMode: 	at android.app.ActivityThread.main(ActivityThread.java:8167)
         1606083398.935 12272 12272 D StrictMode: 	at java.lang.reflect.Method.invoke(Native Method)
         1606083398.935 12272 12272 D StrictMode: 	at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:496)
         1606083398.935 12272 12272 D StrictMode: 	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1100)
--------- switch to events
         1606083398.936 12272 12272 I am_on_top_resumed_gained_called: [0,org.mozilla.focus.activity.CustomTabActivity,topStateChangedWhenResumed]
--------- switch to main
         1606083398.936 12272 12272 I ActivityMonitor: Activity: org.mozilla.focus.activity.IntentReceiverActivity@939bc24 is in stage: DESTROYED
--------- switch to events
         1606083398.936 12272 12272 I am_on_destroy_called: [0,org.mozilla.focus.activity.IntentReceiverActivity,performDestroy]
--------- switch to main
         1606083398.936 12272 12272 D LifecycleMonitor: Lifecycle status change: org.mozilla.focus.activity.IntentReceiverActivity@939bc24 in: DESTROYED
         1606083398.949 12272 12272 I SurfaceView: onWindowVisibilityChanged(0) true android.view.SurfaceView{330c152 V.E...... ......ID 0,0-0,0} of ViewRootImpl@38b7ec6[CustomTabActivity]
         1606083398.966 12272 12272 I ViewRootImpl@38b7ec6[CustomTabActivity]: Relayout returned: old=(0,0,1080,2220) new=(0,0,1080,2220) req=(1080,2220)0 dur=6 res=0x7 s={true 2998466560} ch=true
         1606083398.966 12272 12435 D OpenGLRenderer: createReliableSurface : 0xd3919a00(0xb2b8f800)
         1606083398.967 12272 12435 I mali_winsys: new_window_surface() [1080x2220] return: 0x3000
         1606083398.967 12272 12435 D OpenGLRenderer: eglCreateWindowSurface : 0xd391c6e0
         1606083398.979 12272 12272 I SurfaceView: surfaceCreated 1 #8 android.view.SurfaceView{330c152 V.E...... ......ID 0,0-1080,1884}
         1606083398.979 12272 12272 I SurfaceView: surfaceChanged (1080,1884) 1 #8 android.view.SurfaceView{330c152 V.E...... ......ID 0,0-1080,1884}
         1606083398.987 12272 12435 D OpenGLRenderer: makeCurrent EglSurface : 0x0 -> 0xd391c6e0
         1606083398.987 12272 12435 I OpenGLRenderer: onPositionUpdated - left: 0.000000, right: 1080.000000, top: 210.000000, botton: 2094.000000
         1606083398.987 12272 12578 I OpenGLRenderer: doUpdatePositionAsync is called and callVoidMethod
         1606083398.989 12272 12462 D ServiceAllocator: org.mozilla.gecko.process.GeckoChildProcessServices$tab0 updateBindings: FOREGROUND priority, 0 importance, 1 successful binds, 0 failed binds, 0 successful unbinds
         1606083399.001 12474 12551 D GeckoThread: State changed to MOZGLUE_READY
         1606083399.013 12474 12551 W Settings: Setting animator_duration_scale has moved from android.provider.Settings.System to android.provider.Settings.Global, returning read-only global URI.
         1606083399.015 12474 12551 E GeckoLibLoad: Load sqlite start
         1606083399.017 12474 12551 E GeckoLibLoad: Load sqlite done
         1606083399.017 12474 12551 E GeckoLibLoad: Load nss start
         1606083399.017 12474 12551 E GeckoLibLoad: Load nss done
         1606083399.026 12474 12551 E GeckoLibLoad: Loaded libs in 9.327577ms total, 8ms(4ms) user, 0ms(4ms) system, 0(0) faults
         1606083399.027 12474 12551 D GeckoThread: State changed to LIBS_READY
         1606083399.027 12474 12551 W GeckoThread: zerdatime 201273862 - runGecko
         1606083399.031 12272 12446 W AudioCapabilities: Unsupported mime audio/x-ima
         1606083399.035 12272 12446 W AudioCapabilities: Unsupported mime audio/mpeg-L1
         1606083399.035 12272 12446 W AudioCapabilities: Unsupported mime audio/mpeg-L2
         1606083399.035 12272 12446 W AudioCapabilities: Unsupported mime audio/x-ms-wma
         1606083399.051 12272 12446 W AudioCapabilities: Unsupported mime audio/x-ape
         1606083399.058 12272 12272 D GeckoNetworkManager: Incoming event receivedUpdate for state OnWithListeners -> OnWithListeners
         1606083399.061 12272 12272 D GeckoNetworkManager: New network state: UP, WIFI, WIFI
         1606083399.063 12272 12446 W VideoCapabilities: Unsupported mime video/wvc1
         1606083399.069 12272 12446 W VideoCapabilities: Unsupported mime video/avc-wfd
         1606083399.070 12272 12446 W VideoCapabilities: Unsupported mime video/avc-wfd
         1606083399.072 12272 12446 W VideoCapabilities: Unsupported mime video/avc-wfd
         1606083399.074 12272 12272 I ViewRootImpl@38b7ec6[CustomTabActivity]: Relayout returned: old=(0,0,1080,2220) new=(0,0,1080,2220) req=(1080,2220)0 dur=12 res=0x1 s={true 2998466560} ch=false
         1606083399.075 12272 12446 W VideoCapabilities: Unsupported mime video/hevc-wfd
         1606083399.076 12272 12435 D OpenGLRenderer: mPreviousPosition == bounds[l=0.00 t=210.00 r=1080.00 b=2094.00]
         1606083399.076 12272 12446 W VideoCapabilities: Unsupported mime video/hevc-wfd
         1606083399.077 12272 12272 I ViewRootImpl@38b7ec6[CustomTabActivity]: MSG_WINDOW_FOCUS_CHANGED 1 1
         1606083399.078 12272 12272 D InputMethodManager: prepareNavigationBarInfo() DecorView@802a24a[CustomTabActivity]
         1606083399.078 12272 12272 D InputMethodManager: getNavigationBarColor() -855310
         1606083399.085 12272 12272 D InputMethodManager: prepareNavigationBarInfo() DecorView@802a24a[CustomTabActivity]
         1606083399.085 12272 12272 D InputMethodManager: getNavigationBarColor() -855310
         1606083399.085 12272 12272 V InputMethodManager: Starting input: tba=org.mozilla.focus.debug ic=null mNaviBarColor -855310 mIsGetNaviBarColorSuccess true , NavVisible : true , NavTrans : false
         1606083399.085 12272 12272 D InputMethodManager: startInputInner - Id : 0
         1606083399.085 12272 12272 I InputMethodManager: startInputInner - mService.startInputOrWindowGainedFocus
         1606083399.106 12272 12771 I mali_winsys: new_window_surface() [1080x1884] return: 0x3000
         1606083399.106 12272 12272 I ViewRootImpl@38b7ec6[CustomTabActivity]: MSG_RESIZED: frame=(0,0,1080,2220) ci=(0,63,0,126) vi=(0,63,0,126) or=1
         1606083399.112 12272 12435 D OpenGLRenderer: mPreviousPosition == bounds[l=0.00 t=210.00 r=1080.00 b=2094.00]
         1606083399.124 12272 12435 D OpenGLRenderer: mPreviousPosition == bounds[l=0.00 t=210.00 r=1080.00 b=2094.00]
         1606083399.127 12272 12446 W VideoCapabilities: Unsupported mime video/mp43
         1606083399.127 12272 12446 W VideoCapabilities: Unrecognized profile/level 1/32 for video/mp4v-es
         1606083399.127 12272 12446 W VideoCapabilities: Unrecognized profile/level 32768/2 for video/mp4v-es
         1606083399.128 12272 12446 W VideoCapabilities: Unrecognized profile/level 32768/64 for video/mp4v-es
         1606083399.129 12272 12446 W VideoCapabilities: Unsupported mime video/wvc1
         1606083399.132 12272 12446 W VideoCapabilities: Unsupported mime video/x-ms-wmv7
         1606083399.133 12272 12446 W VideoCapabilities: Unsupported mime video/x-ms-wmv8
         1606083399.134 12272 12446 D HardwareCodecCapability: Found candidate encoder OMX.Exynos.AVC.Encoder
         1606083399.134 12272 12446 V HardwareCodecCapability:    Color: 0x7f420888
         1606083399.134 12272 12446 V HardwareCodecCapability:    Color: 0x13
         1606083399.134 12272 12446 V HardwareCodecCapability:    Color: 0x15
         1606083399.134 12272 12446 V HardwareCodecCapability:    Color: 0x7f000011
         1606083399.134 12272 12446 V HardwareCodecCapability:    Color: 0x10
         1606083399.134 12272 12446 V HardwareCodecCapability:    Color: 0x7f00a000
         1606083399.134 12272 12446 V HardwareCodecCapability:    Color: 0x7f000789
         1606083399.134 12272 12446 V HardwareCodecCapability:    Color: 0x7f000012
         1606083399.134 12272 12446 D HardwareCodecCapability: Found target encoder OMX.Exynos.AVC.Encoder. Color: 0x13
         1606083399.134 12272 12446 D HardwareCodecCapability: Found candidate decoder OMX.Exynos.avc.dec
         1606083399.134 12272 12446 V HardwareCodecCapability:    Color: 0x7f420888
         1606083399.134 12272 12446 V HardwareCodecCapability:    Color: 0x15
         1606083399.134 12272 12446 V HardwareCodecCapability:    Color: 0x13
         1606083399.134 12272 12446 V HardwareCodecCapability:    Color: 0x10
         1606083399.134 12272 12446 V HardwareCodecCapability:    Color: 0x7f000012
         1606083399.134 12272 12446 V HardwareCodecCapability:    Color: 0x7f000011
         1606083399.135 12272 12446 D HardwareCodecCapability: Found target decoder OMX.Exynos.avc.dec. Color: 0x13
         1606083399.135 12272 12446 D HardwareCodecCapability: Found candidate encoder OMX.Exynos.VP8.Encoder
         1606083399.135 12272 12446 D HardwareCodecCapability: Found candidate encoder c2.android.vp8.encoder
         1606083399.135 12272 12446 D HardwareCodecCapability: Found candidate encoder OMX.google.vp8.encoder
         1606083399.136 12272 12446 D HardwareCodecCapability: Found candidate decoder OMX.Exynos.vp8.dec
         1606083399.136 12272 12446 V HardwareCodecCapability:    Color: 0x7f420888
         1606083399.136 12272 12446 V HardwareCodecCapability:    Color: 0x15
         1606083399.136 12272 12446 V HardwareCodecCapability:    Color: 0x13
         1606083399.136 12272 12446 V HardwareCodecCapability:    Color: 0x10
         1606083399.136 12272 12446 V HardwareCodecCapability:    Color: 0x7f000012
         1606083399.136 12272 12446 V HardwareCodecCapability:    Color: 0x7f000011
         1606083399.136 12272 12446 D HardwareCodecCapability: Found target decoder OMX.Exynos.vp8.dec. Color: 0x13
         1606083399.141 12272 12435 D OpenGLRenderer: mPreviousPosition == bounds[l=0.00 t=210.00 r=1080.00 b=2094.00]
         1606083399.144 12272 12462 D ServiceAllocator: org.mozilla.gecko.process.GeckoChildProcessServices$tab0 updateBindings: FOREGROUND priority, 2 importance, 1 successful binds, 0 failed binds, 0 successful unbinds
         1606083399.158 12272 12435 D OpenGLRenderer: mPreviousPosition == bounds[l=0.00 t=210.00 r=1080.00 b=2094.00]
         1606083399.164 12272 12446 I GeckoSession: zerdatime 201274000 - chrome startup finished
         1606083399.181 12272 12435 D OpenGLRenderer: mPreviousPosition == bounds[l=0.00 t=210.00 r=1080.00 b=2094.00]
         1606083399.181 12272 12348 E memtrack: Couldn't load memtrack module
         1606083399.181 12272 12348 W android.os.Debug: failed to get memory consumption info: -1
         1606083399.191 12272 12435 D OpenGLRenderer: mPreviousPosition == bounds[l=0.00 t=210.00 r=1080.00 b=2094.00]
         1606083399.208 12474 12551 D GeckoThread: State changed to RUNNING
         1606083399.209 12272 12435 D OpenGLRenderer: mPreviousPosition == bounds[l=0.00 t=210.00 r=1080.00 b=2094.00]
         1606083399.224 12272 12435 D OpenGLRenderer: mPreviousPosition == bounds[l=0.00 t=210.00 r=1080.00 b=2094.00]
         1606083399.225 12272 12831 I MockWebServer: MockWebServer[59235] received request: GET / HTTP/1.1 and responded: HTTP/1.1 200 OK
         1606083399.241 12272 12435 D OpenGLRenderer: mPreviousPosition == bounds[l=0.00 t=210.00 r=1080.00 b=2094.00]
         1606083399.255 12272 12446 D GeckoScreenOrientation: unlocking
         1606083399.257 12272 12435 D OpenGLRenderer: mPreviousPosition == bounds[l=0.00 t=210.00 r=1080.00 b=2094.00]
         1606083399.276 12272 12435 D OpenGLRenderer: mPreviousPosition == bounds[l=0.00 t=210.00 r=1080.00 b=2094.00]
         1606083399.277 12272 12272 D GeckoSession: handleMessage GeckoView:PageStart uri=about:blank
         1606083399.278 12272 12272 I LoadTimeObserver: zerdatime 201274113 - page load start
         1606083399.281 12272 12272 D GeckoSession: handleMessage GeckoView:LocationChange uri=about:blank
         1606083399.281 12272 12272 I LoadTimeObserver: zerdatime 201274117 - url changed, new page load start
         1606083399.283 12272 12272 D GeckoSession: handleMessage GeckoView:PageStop uri=null
         1606083399.284 12272 12272 I LoadTimeObserver: Loaded page at Session(5096b5e9-0c7f-41e9-b99a-df3215b6f892, about:blank).url.value
         1606083399.284 12272 12272 I LoadTimeObserver: zerdatime 201274119 - page load stop
         1606083399.284 12272 12272 I LoadTimeObserver: 2 - elapsed load
         1606083399.301 12272 12435 D OpenGLRenderer: mPreviousPosition == bounds[l=0.00 t=210.00 r=1080.00 b=2094.00]
         1606083399.306 12474 12474 D GeckoNetworkManager: Incoming event enableNotifications for state OffNoListeners -> OffWithListeners
         1606083399.308 12272 12435 D OpenGLRenderer: mPreviousPosition == bounds[l=0.00 t=210.00 r=1080.00 b=2094.00]
         1606083399.309 12474 12474 D GeckoNetworkManager: New network state: UP, WIFI, WIFI
         1606083399.313 12272 12446 D GeckoScreenOrientation: unlocking
         1606083399.323 12272 12272 D GeckoSession: handleMessage GeckoView:ProgressChanged uri=null
         1606083399.325 12272 12435 D OpenGLRenderer: mPreviousPosition == bounds[l=0.00 t=210.00 r=1080.00 b=2094.00]
         1606083399.325 12272 12272 D GeckoSession: handleMessage GeckoView:PageStart uri=http://localhost:59235/
         1606083399.326 12272 12272 D GeckoSession: handleMessage GeckoView:ProgressChanged uri=null
         1606083399.327 12272 12272 I LoadTimeObserver: Loaded page at Session(5096b5e9-0c7f-41e9-b99a-df3215b6f892, about:blank).url.value
         1606083399.327 12272 12272 I LoadTimeObserver: zerdatime 201274162 - page load stop
         1606083399.327 12272 12272 I LoadTimeObserver: 45 - elapsed load
         1606083399.327 12272 12272 D GeckoSession: handleMessage GeckoView:PageStop uri=null
         1606083399.328 12272 12272 D GeckoSession: handleMessage GeckoView:ProgressChanged uri=null
         1606083399.328 12272 12272 D GeckoSession: handleMessage GeckoView:PageStart uri=http://localhost:59235/
         1606083399.341 12272 12347 W ParcelFileDescriptor: Peer didn't provide a comm channel; unable to check for errors
         1606083399.345 12272 12435 D OpenGLRenderer: mPreviousPosition == bounds[l=0.00 t=210.00 r=1080.00 b=2094.00]
         1606083399.359 12272 12359 W lla.focus.debu: Accessing hidden method Lsun/misc/Unsafe;->compareAndSwapObject(Ljava/lang/Object;JLjava/lang/Object;Ljava/lang/Object;)Z (greylist, linking, allowed)
         1606083399.359 12272 12728 W lla.focus.debu: Accessing hidden method Lsun/misc/Unsafe;->compareAndSwapObject(Ljava/lang/Object;JLjava/lang/Object;Ljava/lang/Object;)Z (greylist, linking, allowed)
         1606083399.401 12272 12272 I ViewInteraction: Checking 'MatchesViewAssertion{viewMatcher=is displayed on the screen to the user}' assertion on view with content description text: is "TestButton1337"
         1606083399.404 12272 12272 I ViewInteraction: Performing 'single click' action on view with id: org.mozilla.focus.debug:id/menuView
         1606083399.412 12272 12272 I ViewRootImpl@38b7ec6[CustomTabActivity]: ViewPostIme pointer 0
         1606083399.461 12272 12272 I ViewRootImpl@38b7ec6[CustomTabActivity]: ViewPostIme pointer 1
         1606083399.475 12272 12435 D OpenGLRenderer: mPreviousPosition == bounds[l=0.00 t=210.00 r=1080.00 b=2094.00]
         1606083399.522 12272 12272 I ViewRootImpl@f3ab274[PopupWindow:2ba2261]: setView = android.widget.PopupWindow$PopupDecorView@815839d TM=true MM=false
         1606083399.524 12272 12272 D StrictMode: StrictMode policy violation; ~duration=35 ms: android.os.strictmode.DiskReadViolation
         1606083399.524 12272 12272 D StrictMode: 	at android.os.StrictMode$AndroidBlockGuardPolicy.onReadFromDisk(StrictMode.java:1556)
         1606083399.524 12272 12272 D StrictMode: 	at android.database.sqlite.SQLiteConnection.applyBlockGuardPolicy(SQLiteConnection.java:1524)
         1606083399.524 12272 12272 D StrictMode: 	at android.database.sqlite.SQLiteConnection.executeForCursorWindow(SQLiteConnection.java:1193)
         1606083399.524 12272 12272 D StrictMode: 	at android.database.sqlite.SQLiteSession.executeForCursorWindow(SQLiteSession.java:838)
         1606083399.524 12272 12272 D StrictMode: 	at android.database.sqlite.SQLiteQuery.fillWindow(SQLiteQuery.java:62)
         1606083399.524 12272 12272 D StrictMode: 	at android.database.sqlite.SQLiteCursor.fillWindow(SQLiteCursor.java:165)
         1606083399.524 12272 12272 D StrictMode: 	at android.database.sqlite.SQLiteCursor.getCount(SQLiteCursor.java:152)
         1606083399.524 12272 12272 D StrictMode: 	at android.database.AbstractCursor.moveToPosition(AbstractCursor.java:232)
         1606083399.524 12272 12272 D StrictMode: 	at android.database.AbstractCursor.moveToNext(AbstractCursor.java:281)
         1606083399.524 12272 12272 D StrictMode: 	at com.android.server.enterprise.storage.EdmStorageProviderBase.getBooleanList(EdmStorageProviderBase.java:129)
         1606083399.524 12272 12272 D StrictMode: 	at com.android.server.enterprise.storage.EdmStorageProviderBase.getBoolean(EdmStorageProviderBase.java:1016)
         1606083399.524 12272 12272 D StrictMode: 	at com.android.server.enterprise.storage.EdmStorageProvider.getBoolean(EdmStorageProvider.java:236)
         1606083399.524 12272 12272 D StrictMode: 	at com.samsung.android.knox.custom.KnoxCustomManagerService.getProKioskState(KnoxCustomManagerService.java:1449)
         1606083399.524 12272 12272 D StrictMode: 	at com.samsung.android.knox.custom.ProKioskManager.getProKioskState(ProKioskManager.java:120)
         1606083399.524 12272 12272 D StrictMode: 	at com.android.server.pm.PackageManagerService.chooseBestActivity(PackageManagerService.java:8051)
         1606083399.524 12272 12272 D StrictMode: 	at com.android.server.pm.PackageManagerService.resolveIntentInternal(PackageManagerService.java:7870)
         1606083399.524 12272 12272 D StrictMode: 	at com.android.server.pm.PackageManagerService.resolveIntent(PackageManagerService.java:7824)
         1606083399.524 12272 12272 D StrictMode: 	at android.content.pm.IPackageManager$Stub.onTransact(IPackageManager.java:2887)
         1606083399.524 12272 12272 D StrictMode: 	at com.android.server.pm.PackageManagerService.onTransact(PackageManagerService.java:5160)
         1606083399.524 12272 12272 D StrictMode: 	at android.os.Binder.execTransactInternal(Binder.java:1056)
         1606083399.524 12272 12272 D StrictMode: 	at android.os.Binder.execTransact(Binder.java:1029)
         1606083399.524 12272 12272 D StrictMode: # via Binder call with stack:
         1606083399.524 12272 12272 D StrictMode: 	at android.os.StrictMode.readAndHandleBinderCallViolations(StrictMode.java:2274)
         1606083399.524 12272 12272 D StrictMode: 	at android.os.Parcel.readExceptionCode(Parcel.java:2034)
         1606083399.524 12272 12272 D StrictMode: 	at android.os.Parcel.readException(Parcel.java:2001)
         1606083399.524 12272 12272 D StrictMode: 	at android.content.pm.IPackageManager$Stub$Proxy.resolveIntent(IPackageManager.java:6674)
         1606083399.524 12272 12272 D StrictMode: 	at android.app.ApplicationPackageManager.resolveActivityAsUser(ApplicationPackageManager.java:1130)
         1606083399.524 12272 12272 D StrictMode: 	at android.app.ApplicationPackageManager.resolveActivity(ApplicationPackageManager.java:1124)
         1606083399.524 12272 12272 D StrictMode: 	at org.mozilla.focus.utils.Browsers.findKnownBrowsers(Browsers.java:157)
         1606083399.524 12272 12272 D StrictMode: 	at org.mozilla.focus.utils.Browsers.<init>(Browsers.java:92)
         1606083399.524 12272 12272 D StrictMode: 	at org.mozilla.focus.menu.browser.BrowserMenuAdapter.initializeMenu(BrowserMenuAdapter.kt:68)
         1606083399.524 12272 12272 D StrictMode: 	at org.mozilla.focus.menu.browser.BrowserMenuAdapter.<init>(BrowserMenuAdapter.kt:63)
         1606083399.524 12272 12272 D StrictMode: 	at org.mozilla.focus.menu.browser.BrowserMenu.<init>(BrowserMenu.java:38)
         1606083399.524 12272 12272 D StrictMode: 	at org.mozilla.focus.fragment.BrowserFragment.onClick(BrowserFragment.kt:1019)
         1606083399.524 12272 12272 D StrictMode: 	at android.view.View.performClick(View.java:7862)
         1606083399.524 12272 12272 D StrictMode: 	at android.view.View.performClickInternal(View.java:7831)
         1606083399.524 12272 12272 D StrictMode: 	at android.view.View.access$3600(View.java:879)
         1606083399.524 12272 12272 D StrictMode: 	at android.view.View$PerformClick.run(View.java:29359)
         1606083399.524 12272 12272 D StrictMode: 	at android.os.Handler.handleCallback(Handler.java:883)
         1606083399.524 12272 12272 D StrictMode: 	at android.os.Handler.dispatchMessage(Handler.java:100)
         1606083399.524 12272 12272 D StrictMode: 	at androidx.test.espresso.base.Interrogator.loopAndInterrogate(Interrogator.java:148)
         1606083399.524 12272 12272 D StrictMode: 	at androidx.test.espresso.base.UiControllerImpl.loopUntil(UiControllerImpl.java:525)
         1606083399.524 12272 12272 D StrictMode: 	at androidx.test.espresso.base.UiControllerImpl.loopUntil(UiControllerImpl.java:484)
         1606083399.524 12272 12272 D StrictMode: 	at androidx.test.espresso.base.UiControllerImpl.injectMotionEvent(UiControllerImpl.java:236)
         1606083399.524 12272 12272 D StrictMode: 	at androidx.test.espresso.action.MotionEvents.sendUp(MotionEvents.java:162)
         1606083399.524 12272 12272 D StrictMode: 	at androidx.test.espresso.action.MotionEvents.sendUp(MotionEvents.java:139)
         1606083399.524 12272 12272 D StrictMode: 	at androidx.test.espresso.action.Tap.sendSingleTap(Tap.java:170)
         1606083399.524 12272 12272 D StrictMode: 	at androidx.test.espresso.action.Tap.access$100(Tap.java:31)
         1606083399.524 12272 12272 D StrictMode: 	at androidx.test.espresso.action.Tap$1.sendTap(Tap.java:47)
         1606083399.524 12272 12272 D StrictMode: 	at androidx.test.espresso.action.GeneralClickAction.perform(GeneralClickAction.java:137)
         1606083399.524 12272 12272 D StrictMode: 	at androidx.test
         1606083399.525 12272 12272 D StrictMode: StrictMode policy violation; ~duration=23 ms: android.os.strictmode.DiskReadViolation
         1606083399.525 12272 12272 D StrictMode: 	at android.os.StrictMode$AndroidBlockGuardPolicy.onReadFromDisk(StrictMode.java:1556)
         1606083399.525 12272 12272 D StrictMode: 	at android.database.sqlite.SQLiteConnection.applyBlockGuardPolicy(SQLiteConnection.java:1524)
         1606083399.525 12272 12272 D StrictMode: 	at android.database.sqlite.SQLiteConnection.executeForCursorWindow(SQLiteConnection.java:1193)
         1606083399.525 12272 12272 D StrictMode: 	at android.database.sqlite.SQLiteSession.executeForCursorWindow(SQLiteSession.java:838)
         1606083399.525 12272 12272 D StrictMode: 	at android.database.sqlite.SQLiteQuery.fillWindow(SQLiteQuery.java:62)
         1606083399.525 12272 12272 D StrictMode: 	at android.database.sqlite.SQLiteCursor.fillWindow(SQLiteCursor.java:165)
         1606083399.525 12272 12272 D StrictMode: 	at android.database.sqlite.SQLiteCursor.getCount(SQLiteCursor.java:152)
         1606083399.525 12272 12272 D StrictMode: 	at android.database.AbstractCursor.moveToPosition(AbstractCursor.java:232)
         1606083399.525 12272 12272 D StrictMode: 	at android.database.AbstractCursor.moveToNext(AbstractCursor.java:281)
         1606083399.525 12272 12272 D StrictMode: 	at com.android.server.enterprise.storage.EdmStorageProviderBase.getBooleanList(EdmStorageProviderBase.java:129)
         1606083399.525 12272 12272 D StrictMode: 	at com.android.server.enterprise.storage.EdmStorageProviderBase.getBoolean(EdmStorageProviderBase.java:1016)
         1606083399.525 12272 12272 D StrictMode: 	at com.android.server.enterprise.storage.EdmStorageProvider.getBoolean(EdmStorageProvider.java:236)
         1606083399.525 12272 12272 D StrictMode: 	at com.samsung.android.knox.custom.KnoxCustomManagerService.getProKioskState(KnoxCustomManagerService.java:1449)
         1606083399.525 12272 12272 D StrictMode: 	at com.samsung.android.knox.custom.ProKioskManager.getProKioskState(ProKioskManager.java:120)
         1606083399.525 12272 12272 D StrictMode: 	at com.android.server.pm.PackageManagerService.chooseBestActivity(PackageManagerService.java:8051)
         1606083399.525 12272 12272 D StrictMode: 	at com.android.server.pm.PackageManagerService.resolveIntentInternal(PackageManagerService.java:7870)
         1606083399.525 12272 12272 D StrictMode: 	at com.android.server.pm.PackageManagerService.resolveIntent(PackageManagerService.java:7824)
         1606083399.525 12272 12272 D StrictMode: 	at android.content.pm.IPackageManager$Stub.onTransact(IPackageManager.java:2887)
         1606083399.525 12272 12272 D StrictMode: 	at com.android.server.pm.PackageManagerService.onTransact(PackageManagerService.java:5160)
         1606083399.525 12272 12272 D StrictMode: 	at android.os.Binder.execTransactInternal(Binder.java:1056)
         1606083399.525 12272 12272 D StrictMode: 	at android.os.Binder.execTransact(Binder.java:1029)
         1606083399.525 12272 12272 D StrictMode: # via Binder call with stack:
         1606083399.525 12272 12272 D StrictMode: 	at android.os.StrictMode.readAndHandleBinderCallViolations(StrictMode.java:2274)
         1606083399.525 12272 12272 D StrictMode: 	at android.os.Parcel.readExceptionCode(Parcel.java:2034)
         1606083399.525 12272 12272 D StrictMode: 	at android.os.Parcel.readException(Parcel.java:2001)
         1606083399.525 12272 12272 D StrictMode: 	at android.content.pm.IPackageManager$Stub$Proxy.resolveIntent(IPackageManager.java:6674)
         1606083399.525 12272 12272 D StrictMode: 	at android.app.ApplicationPackageManager.resolveActivityAsUser(ApplicationPackageManager.java:1130)
         1606083399.525 12272 12272 D StrictMode: 	at android.app.ApplicationPackageManager.resolveActivity(ApplicationPackageManager.java:1124)
         1606083399.525 12272 12272 D StrictMode: 	at org.mozilla.focus.utils.Browsers.findDefault(Browsers.java:173)
         1606083399.525 12272 12272 D StrictMode: 	at org.mozilla.focus.utils.Browsers.<init>(Browsers.java:95)
         1606083399.525 12272 12272 D StrictMode: 	at org.mozilla.focus.menu.browser.BrowserMenuAdapter.initializeMenu(BrowserMenuAdapter.kt:68)
         1606083399.525 12272 12272 D StrictMode: 	at org.mozilla.focus.menu.browser.BrowserMenuAdapter.<init>(BrowserMenuAdapter.kt:63)
         1606083399.525 12272 12272 D StrictMode: 	at org.mozilla.focus.menu.browser.BrowserMenu.<init>(BrowserMenu.java:38)
         1606083399.525 12272 12272 D StrictMode: 	at org.mozilla.focus.fragment.BrowserFragment.onClick(BrowserFragment.kt:1019)
         1606083399.525 12272 12272 D StrictMode: 	at android.view.View.performClick(View.java:7862)
         1606083399.525 12272 12272 D StrictMode: 	at android.view.View.performClickInternal(View.java:7831)
         1606083399.525 12272 12272 D StrictMode: 	at android.view.View.access$3600(View.java:879)
         1606083399.525 12272 12272 D StrictMode: 	at android.view.View$PerformClick.run(View.java:29359)
         1606083399.525 12272 12272 D StrictMode: 	at android.os.Handler.handleCallback(Handler.java:883)
         1606083399.525 12272 12272 D StrictMode: 	at android.os.Handler.dispatchMessage(Handler.java:100)
         1606083399.525 12272 12272 D StrictMode: 	at androidx.test.espresso.base.Interrogator.loopAndInterrogate(Interrogator.java:148)
         1606083399.525 12272 12272 D StrictMode: 	at androidx.test.espresso.base.UiControllerImpl.loopUntil(UiControllerImpl.java:525)
         1606083399.525 12272 12272 D StrictMode: 	at androidx.test.espresso.base.UiControllerImpl.loopUntil(UiControllerImpl.java:484)
         1606083399.525 12272 12272 D StrictMode: 	at androidx.test.espresso.base.UiControllerImpl.injectMotionEvent(UiControllerImpl.java:236)
         1606083399.525 12272 12272 D StrictMode: 	at androidx.test.espresso.action.MotionEvents.sendUp(MotionEvents.java:162)
         1606083399.525 12272 12272 D StrictMode: 	at androidx.test.espresso.action.MotionEvents.sendUp(MotionEvents.java:139)
         1606083399.525 12272 12272 D StrictMode: 	at androidx.test.espresso.action.Tap.sendSingleTap(Tap.java:170)
         1606083399.525 12272 12272 D StrictMode: 	at androidx.test.espresso.action.Tap.access$100(Tap.java:31)
         1606083399.525 12272 12272 D StrictMode: 	at androidx.test.espresso.action.Tap$1.sendTap(Tap.java:47)
         1606083399.525 12272 12272 D StrictMode: 	at androidx.test.espresso.action.GeneralClickAction.perform(GeneralClickAction.java:137)
         1606083399.525 12272 12272 D StrictMode: 	at androidx.test.espre
         1606083399.661 12272 12272 I ViewRootImpl@f3ab274[PopupWindow:2ba2261]: Relayout returned: old=(0,63,1080,2094) new=(345,74,1080,1696) req=(735,1622)0 dur=15 res=0x7 s={true 2996121600} ch=true
         1606083399.662 12272 12435 D OpenGLRenderer: createReliableSurface : 0xb5f51e40(0xb2953000)
         1606083399.662 12272 12435 I mali_winsys: new_window_surface() [819x1706] return: 0x3000
         1606083399.662 12272 12435 D OpenGLRenderer: eglCreateWindowSurface : 0xa7a62420
         1606083399.682 12272 12435 D OpenGLRenderer: makeCurrent EglSurface : 0xd391c6e0 -> 0xa7a62420
         1606083399.746 12272 12272 I ViewRootImpl@f3ab274[PopupWindow:2ba2261]: MSG_WINDOW_FOCUS_CHANGED 1 1
         1606083399.746 12272 12272 D InputMethodManager: prepareNavigationBarInfo() android.widget.PopupWindow$PopupDecorView{815839d V.E...... R....... 0,0-735,1622}
         1606083399.746 12272 12272 D InputMethodManager: getNavigationBarColor this view is not DecorView or null
         1606083399.746 12272 12272 D InputMethodManager: getNavigationBarColor() Fail
         1606083399.748 12272 12272 D InputMethodManager: prepareNavigationBarInfo() android.widget.PopupWindow$PopupDecorView{815839d V.E...... R......D 0,0-735,1622}
         1606083399.748 12272 12272 D InputMethodManager: getNavigationBarColor this view is not DecorView or null
         1606083399.748 12272 12272 D InputMethodManager: getNavigationBarColor() Fail
         1606083399.748 12272 12272 V InputMethodManager: Starting input: tba=org.mozilla.focus.debug ic=null mNaviBarColor Fail mIsGetNaviBarColorSuccess false , NavVisible : true , NavTrans : false
         1606083399.748 12272 12272 D InputMethodManager: startInputInner - Id : 0
         1606083399.748 12272 12272 I InputMethodManager: startInputInner - mService.startInputOrWindowGainedFocus
         1606083399.754 12272 12272 D InputTransport: Input channel destroyed: 'ClientS', fd=158
         1606083399.763 12272 12435 D OpenGLRenderer: makeCurrent EglSurface : 0xa7a62420 -> 0xd391c6e0
         1606083399.763 12272 12435 D OpenGLRenderer: mPreviousPosition == bounds[l=0.00 t=210.00 r=1080.00 b=2094.00]
         1606083399.768 12272 12272 I ViewRootImpl@38b7ec6[CustomTabActivity]: MSG_WINDOW_FOCUS_CHANGED 0 1
         1606083399.768 12272 12272 D InputMethodManager: prepareNavigationBarInfo() DecorView@802a24a[CustomTabActivity]
         1606083399.768 12272 12272 D InputMethodManager: getNavigationBarColor() -855310
         1606083399.770 12272 12272 I ViewRootImpl@f3ab274[PopupWindow:2ba2261]: MSG_RESIZED: frame=(345,74,1080,1696) ci=(0,0,0,0) vi=(0,0,0,0) or=1
         1606083399.789 12272 12435 D OpenGLRenderer: makeCurrent EglSurface : 0xd391c6e0 -> 0xa7a62420
         1606083399.825 12272 12348 E memtrack: Couldn't load memtrack module
         1606083399.825 12272 12348 W android.os.Debug: failed to get memory consumption info: -1
         1606083400.001 12272 12347 W ParcelFileDescriptor: Peer didn't provide a comm channel; unable to check for errors
         1606083400.038 12272 12272 I ViewInteraction: Checking 'MatchesViewAssertion{viewMatcher=is displayed on the screen to the user}' assertion on view with id: org.mozilla.focus.debug:id/share
         1606083400.071 12272 12272 I ViewInteraction: Checking 'MatchesViewAssertion{viewMatcher=is displayed on the screen to the user}' assertion on view with text: is "TestItem4223"
         1606083400.076 12272 12272 I ViewInteraction: Performing 'send keyCode: 4, metaState: 0 key event' action on view is a root view.
         1606083400.083 12272 12272 I ViewRootImpl@f3ab274[PopupWindow:2ba2261]: ViewPostIme key 0
         1606083400.089 12272 12272 I ViewRootImpl@f3ab274[PopupWindow:2ba2261]: ViewPostIme key 1
         1606083400.097 12272 12435 D OpenGLRenderer: makeCurrent EglSurface : 0xa7a62420 -> 0x0
         1606083400.097 12272 12435 D OpenGLRenderer: destroyEglSurface : 0xa7a62420
         1606083400.097 12272 12435 I mali_egl: eglDestroySurface() in
         1606083400.097 12272 12435 I mali_winsys: delete_surface() [819x1706] return
         1606083400.097 12272 12435 I mali_egl: eglDestroySurface() out
         1606083400.098 12272 12435 E OpenGLRenderer: ReliableSurface: perform returned an error
         1606083400.098 12272 12435 W libEGL  : EGLNativeWindowType 0xb5f51e48 disconnect failed
         1606083400.098 12272 12435 D OpenGLRenderer: ~ReliableSurface : 0xb5f51e40
         1606083400.098 12272 12272 I ViewRootImpl@f3ab274[PopupWindow:2ba2261]: dispatchDetachedFromWindow
         1606083400.103 12272 12272 D InputTransport: Input channel destroyed: '200505b', fd=211
         1606083400.103 12272 12272 W InputEventReceiver: Attempted to finish an input event but the input event receiver has already been disposed.
         1606083400.105 12272 12272 I ViewRootImpl@38b7ec6[CustomTabActivity]: MSG_WINDOW_FOCUS_CHANGED 1 1
         1606083400.105 12272 12272 D InputMethodManager: prepareNavigationBarInfo() DecorView@802a24a[CustomTabActivity]
         1606083400.105 12272 12272 D InputMethodManager: getNavigationBarColor() -855310
         1606083400.107 12272 12272 D InputMethodManager: prepareNavigationBarInfo() DecorView@802a24a[CustomTabActivity]
         1606083400.107 12272 12272 D InputMethodManager: getNavigationBarColor() -855310
         1606083400.107 12272 12272 V InputMethodManager: Starting input: tba=org.mozilla.focus.debug ic=null mNaviBarColor -855310 mIsGetNaviBarColorSuccess true , NavVisible : true , NavTrans : false
         1606083400.107 12272 12272 D InputMethodManager: startInputInner - Id : 0
         1606083400.107 12272 12272 I InputMethodManager: startInputInner - mService.startInputOrWindowGainedFocus
         1606083400.109 12272 12272 D InputTransport: Input channel destroyed: 'ClientS', fd=213
         1606083400.110 12272 12272 E ViewRootImpl: sendUserActionEvent() mView returned.
         1606083400.280 12272 12272 E KeyEventActionBase: Back was pressed but there was no Activity stage transition in 150ms, possibly due to a delay calling super.onBackPressed() from your Activity.
         1606083400.286 12272 12272 I ViewInteraction: Checking 'MatchesViewAssertion{viewMatcher=is displayed on the screen to the user}' assertion on view with id: org.mozilla.focus.debug:id/customtab_close
         1606083400.289 12272 12272 I ViewInteraction: Performing 'single click' action on view with id: org.mozilla.focus.debug:id/customtab_close
         1606083400.293 12272 12272 I ViewRootImpl@38b7ec6[CustomTabActivity]: ViewPostIme pointer 0
         1606083400.321 12272 12272 D GeckoSession: handleMessage GeckoView:StateUpdated uri=null
         1606083400.333 12272 12272 I ViewRootImpl@38b7ec6[CustomTabActivity]: ViewPostIme pointer 1
         1606083400.347 12272 12435 D OpenGLRenderer: makeCurrent EglSurface : 0x0 -> 0xd391c6e0
         1606083400.347 12272 12435 D OpenGLRenderer: mPreviousPosition == bounds[l=0.00 t=210.00 r=1080.00 b=2094.00]
         1606083400.349 12272 12771 I mali_egl: eglDestroySurface() in
         1606083400.353 12272 12771 I mali_winsys: delete_surface() [1080x1884] return
         1606083400.353 12272 12771 I mali_egl: eglDestroySurface() out
         1606083400.353 12272 12771 W libEGL  : EGLNativeWindowType 0xcd1f4008 disconnect failed
         1606083400.362 12272 12834 W MockWebServer: MockWebServer[59235] connection from /127.0.0.1 didn't make a request
--------- switch to events
         1606083400.374 12272 12272 I am_on_top_resumed_lost_called: [0,org.mozilla.focus.activity.CustomTabActivity,topStateChangedWhenResumed]
         1606083400.383 12272 12272 I am_on_paused_called: [0,org.mozilla.focus.activity.CustomTabActivity,performPause]
--------- switch to main
         1606083400.383 12272 12272 D LifecycleMonitor: Lifecycle status change: org.mozilla.focus.activity.CustomTabActivity@94f8143 in: PAUSED
         1606083400.383 12272 12272 D LifecycleMonitor: running callback: androidx.test.rule.ActivityTestRule$LifecycleCallback@825d8c5
         1606083400.383 12272 12272 D LifecycleMonitor: callback completes: androidx.test.rule.ActivityTestRule$LifecycleCallback@825d8c5
         1606083400.384 12272 12272 I ActivityMonitor: Activity: org.mozilla.focus.activity.CustomTabActivity@94f8143 is in stage: PAUSED
         1606083400.425 12272 12348 E memtrack: Couldn't load memtrack module
         1606083400.426 12272 12348 W android.os.Debug: failed to get memory consumption info: -1
         1606083400.427 12272 12272 I ViewRootImpl@38b7ec6[CustomTabActivity]: MSG_WINDOW_FOCUS_CHANGED 0 1
         1606083400.427 12272 12272 D InputMethodManager: prepareNavigationBarInfo() DecorView@802a24a[CustomTabActivity]
         1606083400.427 12272 12272 D InputMethodManager: getNavigationBarColor() -855310
         1606083400.437 12272 12462 D ServiceAllocator: org.mozilla.gecko.process.GeckoChildProcessServices$tab0 updateBindings: IDLE priority, 6 importance, 1 successful binds, 0 failed binds, 2 successful unbinds
         1606083400.446 12272 12435 D OpenGLRenderer: mPreviousPosition == bounds[l=0.00 t=210.00 r=1080.00 b=2094.00]
         1606083400.509 12272 12272 I SurfaceView: onWindowVisibilityChanged(8) false android.view.SurfaceView{330c152 V.E...... ........ 0,0-1080,1884} of ViewRootImpl@38b7ec6[CustomTabActivity]
         1606083400.511 12272 12272 I SurfaceView: surfaceDestroyed callback.size 1 #2 android.view.SurfaceView{330c152 V.E...... ........ 0,0-1080,1884}
         1606083400.514 12272 12272 I SurfaceView: remove() android.view.SurfaceView{330c152 V.E...... ........ 0,0-1080,1884} Surface(name=SurfaceView - org.mozilla.focus.debug/org.mozilla.focus.activity.CustomTabActivity@330c152@0)/@0xe8ba5e6
         1606083400.519 12272 12435 I OpenGLRenderer: onPositionLost call JNI callbacks
         1606083400.520 12272 12435 D OpenGLRenderer: makeCurrent EglSurface : 0xd391c6e0 -> 0x0
         1606083400.520 12272 12435 D OpenGLRenderer: destroyEglSurface : 0xd391c6e0
         1606083400.520 12272 12435 I mali_egl: eglDestroySurface() in
         1606083400.529 12272 12435 I mali_winsys: delete_surface() [1080x2220] return
         1606083400.529 12272 12435 I mali_egl: eglDestroySurface() out
         1606083400.529 12272 12435 E OpenGLRenderer: ReliableSurface: perform returned an error
         1606083400.529 12272 12435 W libEGL  : EGLNativeWindowType 0xd3919a08 disconnect failed
         1606083400.529 12272 12435 D OpenGLRenderer: ~ReliableSurface : 0xd3919a00
         1606083400.550 12272 12272 I ViewRootImpl@38b7ec6[CustomTabActivity]: Relayout returned: old=(0,0,1080,2220) new=(0,0,1080,2220) req=(1080,2220)8 dur=20 res=0x5 s={false 0} ch=true
         1606083400.552 12272 12272 D InputTransport: Input channel destroyed: 'ClientS', fd=194
         1606083400.553 12272 12272 I ViewRootImpl@38b7ec6[CustomTabActivity]: stopped(true) old=false
         1606083400.553 12272 12272 I SurfaceView: windowStopped(true) false android.view.SurfaceView{330c152 V.E...... ......ID 0,0-1080,1884} of ViewRootImpl@38b7ec6[CustomTabActivity]
         1606083400.565 12272 12272 D LifecycleMonitor: Lifecycle status change: org.mozilla.focus.activity.CustomTabActivity@94f8143 in: STOPPED
         1606083400.565 12272 12272 D LifecycleMonitor: running callback: androidx.test.rule.ActivityTestRule$LifecycleCallback@825d8c5
         1606083400.565 12272 12272 D LifecycleMonitor: callback completes: androidx.test.rule.ActivityTestRule$LifecycleCallback@825d8c5
         1606083400.565 12272 12272 I ActivityMonitor: Activity: org.mozilla.focus.activity.CustomTabActivity@94f8143 is in stage: STOPPED
--------- switch to events
         1606083400.566 12272 12272 I am_on_stop_called: [0,org.mozilla.focus.activity.CustomTabActivity,LIFECYCLER_STOP_ACTIVITY]
--------- switch to main
         1606083400.566 12272 12272 I ActivityMonitor: Activity: org.mozilla.focus.activity.CustomTabActivity@94f8143 is in stage: DESTROYED
--------- switch to events
         1606083400.573 12272 12272 I am_on_destroy_called: [0,org.mozilla.focus.activity.CustomTabActivity,performDestroy]
--------- switch to main
         1606083400.573 12272 12272 D LifecycleMonitor: Lifecycle status change: org.mozilla.focus.activity.CustomTabActivity@94f8143 in: DESTROYED
         1606083400.573 12272 12272 D LifecycleMonitor: running callback: androidx.test.rule.ActivityTestRule$LifecycleCallback@825d8c5
         1606083400.573 12272 12272 D LifecycleMonitor: callback completes: androidx.test.rule.ActivityTestRule$LifecycleCallback@825d8c5
         1606083400.574 12272 12272 I ViewRootImpl@38b7ec6[CustomTabActivity]: dispatchDetachedFromWindow
         1606083400.577 12272 12272 D InputTransport: Input channel destroyed: 'c08418f', fd=147
         1606083400.593 12272 12859 I System.out: (HTTPLog)-Static: isSBSettingEnabled false
         1606083400.594 12272 12859 I System.out: (HTTPLog)-Static: isSBSettingEnabled false
         1606083400.667 12272 12347 W ParcelFileDescriptor: Peer didn't provide a comm channel; unable to check for errors
         1606083400.681 12272 12762 I MockWebServer: MockWebServer[59235] done accepting connections: Socket closed
         1606083400.683 12272 12827 W MockWebServer: MockWebServer[59235] connection from /127.0.0.1 didn't make a request
         1606083400.684 12272 12831 I MockWebServer: MockWebServer[59235] connection from localhost/127.0.0.1 failed: java.net.SocketException: Socket closed
         1606083400.684 12272 12828 W MockWebServer: MockWebServer[59235] connection from /127.0.0.1 didn't make a request
         1606083400.685 12272 12359 W ActivityTestRule: Activity wasn't created yet or already stopped
         1606083400.685 12272 12359 E TestRunner: failed: testCustomTabUI(org.mozilla.focus.activity.CustomTabTest)
         1606083400.685 12272 12359 E TestRunner: ----- begin exception -----
         1606083400.687 12272 12359 E TestRunner: java.lang.NullPointerException: Attempt to invoke virtual method 'void org.mozilla.focus.activity.IntentReceiverActivity.finishAndRemoveTask()' on a null object reference
         1606083400.687 12272 12359 E TestRunner: 	at org.mozilla.focus.activity.CustomTabTest.tearDown(CustomTabTest.java:79)
         1606083400.687 12272 12359 E TestRunner: 	at java.lang.reflect.Method.invoke(Native Method)
         1606083400.687 12272 12359 E TestRunner: 	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
         1606083400.687 12272 12359 E TestRunner: 	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
         1606083400.687 12272 12359 E TestRunner: 	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
         1606083400.687 12272 12359 E TestRunner: 	at androidx.test.internal.runner.junit4.statement.RunAfters.evaluate(RunAfters.java:80)
         1606083400.687 12272 12359 E TestRunner: 	at androidx.test.rule.ActivityTestRule$ActivityStatement.evaluate(ActivityTestRule.java:531)
         1606083400.687 12272 12359 E TestRunner: 	at org.junit.rules.RunRules.evaluate(RunRules.java:20)
         1606083400.687 12272 12359 E TestRunner: 	at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)
         1606083400.687 12272 12359 E TestRunner: 	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)
         1606083400.687 12272 12359 E TestRunner: 	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)
         1606083400.687 12272 12359 E TestRunner: 	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
         1606083400.687 12272 12359 E TestRunner: 	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
         1606083400.687 12272 12359 E TestRunner: 	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
         1606083400.687 12272 12359 E TestRunner: 	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
         1606083400.687 12272 12359 E TestRunner: 	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
         1606083400.687 12272 12359 E TestRunner: 	at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
         1606083400.687 12272 12359 E TestRunner: 	at androidx.test.runner.AndroidJUnit4.run(AndroidJUnit4.java:104)
         1606083400.687 12272 12359 E TestRunner: 	at org.junit.runners.Suite.runChild(Suite.java:128)
         1606083400.687 12272 12359 E TestRunner: 	at org.junit.runners.Suite.runChild(Suite.java:27)
         1606083400.687 12272 12359 E TestRunner: 	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
         1606083400.687 12272 12359 E TestRunner: 	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
         1606083400.687 12272 12359 E TestRunner: 	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
         1606083400.687 12272 12359 E TestRunner: 	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
         1606083400.687 12272 12359 E TestRunner: 	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
         1606083400.687 12272 12359 E TestRunner: 	at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
         1606083400.687 12272 12359 E TestRunner: 	at org.junit.runner.JUnitCore.run(JUnitCore.java:137)
         1606083400.687 12272 12359 E TestRunner: 	at org.junit.runner.JUnitCore.run(JUnitCore.java:115)
         1606083400.687 12272 12359 E TestRunner: 	at androidx.test.internal.runner.TestExecutor.execute(TestExecutor.java:56)
         1606083400.687 12272 12359 E TestRunner: 	at androidx.test.runner.AndroidJUnitRunner.onStart(AndroidJUnitRunner.java:392)
         1606083400.687 12272 12359 E TestRunner: 	at com.fluentbuild.apollo.runner.client.androidx.AndroidXJUnitRunner.onStart(AndroidXJUnitRunner.kt:24)
         1606083400.687 12272 12359 E TestRunner: 	at org.mozilla.focus.Angelina.onStart(Angelina.kt:25)
         1606083400.687 12272 12359 E TestRunner: 	at android.app.Instrumentation$InstrumentationThread.run(Instrumentation.java:2214)
         1606083400.687 12272 12359 E TestRunner: ----- end exception -----
         1606083400.690 12272 12359 I TestObserver: TEST_FAILURE:testCustomTabUI(org.mozilla.focus.activity.CustomTabTest): Attempt to invoke virtual method 'void org.mozilla.focus.activity.IntentReceiverActivity.finishAndRemoveTask()' on a null object reference
         1606083400.690 12272 12359 I Logger  : Stopping logging!
         1606083400.691 12272 12756 W System.err: java.io.IOException: write failed: EBADF (Bad file descriptor)
         1606083400.692 12272 12756 W System.err: 	at libcore.io.IoBridge.write(IoBridge.java:544)
         1606083400.692 12272 12756 W System.err: 	at java.io.FileOutputStream.write(FileOutputStream.java:392)
         1606083400.692 12272 12756 W System.err: 	at sun.nio.cs.StreamEncoder.writeBytes(StreamEncoder.java:221)
         1606083400.692 12272 12756 W System.err: 	at sun.nio.cs.StreamEncoder.implWrite(StreamEncoder.java:282)
         1606083400.692 12272 12756 W System.err: 	at sun.nio.cs.StreamEncoder.write(StreamEncoder.java:125)
         1606083400.692 12272 12756 W System.err: 	at java.io.OutputStreamWriter.write(OutputStreamWriter.java:207)
         1606083400.692 12272 12756 W System.err: 	at java.io.BufferedWriter.flushBuffer(BufferedWriter.java:129)
         1606083400.692 12272 12756 W System.err: 	at java.io.BufferedWriter.close(BufferedWriter.java:265)
         1606083400.692 12272 12756 W System.err: 	at com.fluentbuild.apollo.foundation.IoUtilsKt.closeCatching(IoUtils.kt:26)
         1606083400.692 12272 12756 W System.err: 	at com.fluentbuild.apollo.foundation.FileUtilsKt.autoCloseBufferedWriter(FileUtils.kt:115)
         1606083400.692 12272 12756 W System.err: 	at com.fluentbuild.apollo.foundation.FileUtilsKt.copyAllLines(FileUtils.kt:61)
         1606083400.692 12272 12756 W System.err: 	at com.fluentbuild.apollo.runner.client.collators.logs.Logger.logToFile(Logger.kt:47)
         1606083400.692 12272 12756 W System.err: 	at com.fluentbuild.apollo.runner.client.collators.logs.Logger.logResiliently(Logger.kt:69)
         1606083400.692 12272 12756 W System.err: 	at com.fluentbuild.apollo.runner.client.collators.logs.Logger.access$logResiliently(Logger.kt:18)
         1606083400.693 12272 12756 W System.err: 	at com.fluentbuild.apollo.runner.client.collators.logs.Logger$startLogging$1.run(Logger.kt:34)
         1606083400.693 12272 12756 W System.err: 	at java.lang.Thread.run(Thread.java:919)
         1606083400.