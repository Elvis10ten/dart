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
         1606083394.624 12272 12272 D StrictMode: 	at com.android.server.pm.PackageManagerService.resolveIntentInternal(PackageManagerService.