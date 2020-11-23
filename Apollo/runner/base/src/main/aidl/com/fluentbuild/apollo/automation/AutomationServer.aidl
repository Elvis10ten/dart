package com.fluentbuild.apollo.automation;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityWindowInfo;
import android.view.accessibility.AccessibilityNodeInfo;
import android.graphics.Bitmap;
import com.fluentbuild.apollo.automation.ActionStatus;
import com.fluentbuild.apollo.automation.OnAccessibilityEventListener;
import com.fluentbuild.apollo.automation.UiEvent;
import com.fluentbuild.apollo.automation.UiNodeInfo;

interface AutomationServer {

    @nullable
    AccessibilityNodeInfo findFocus(int focus);

    @nullable
    AccessibilityServiceInfo getServiceInfo();

    @nullable
    AccessibilityNodeInfo getRootInActiveWindow();

    @nullable
    AccessibilityEvent getLastEvent();

    boolean freezeCurrentRotation();

    boolean unfreezeCurrentRotation();

    boolean setRotation(int rotation);

    boolean restoreInitialRotation();

    boolean setServiceInfo(in AccessibilityServiceInfo serviceInfo);

    boolean performGlobalAction(int action);

    List<AccessibilityWindowInfo> getWindows();

    @nullable
    Bitmap takeScreenshot();

    ActionStatus actionRuntimePermission(String packageName, String permission, int actionId);

    void setOnAccessibilityEventListener(@nullable OnAccessibilityEventListener listener);

    UiNodeInfo getUiEventSource(in UiEvent event);

    List<UiNodeInfo> findAccessibilityNodeInfosByText(in UiNodeInfo nodeInfo, String text);

    List<UiNodeInfo> findAccessibilityNodeInfosByViewId(in UiNodeInfo nodeInfo, String viewId);

    boolean performNodeAction(in UiNodeInfo nodeInfo, int action);

    void recycleEvent(in UiEvent event);

    void recycleNodeInfo(in UiNodeInfo nodeInfo);
}
