package com.fluentbuild.apollo.automation;

import com.fluentbuild.apollo.automation.UiEvent;

/**
* Note that this is a one-way interface so the server does not block waiting for the client.
 */
oneway interface OnAccessibilityEventListener {
    void onAccessibilityEvent(in UiEvent event);
}
