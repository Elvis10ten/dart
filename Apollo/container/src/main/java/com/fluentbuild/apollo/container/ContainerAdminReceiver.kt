package com.fluentbuild.apollo.container

import android.app.admin.DeviceAdminReceiver
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.util.Log

class ContainerAdminReceiver: DeviceAdminReceiver() {

    override fun onProfileProvisioningComplete(context: Context, intent: Intent) {
        Log.e("luke", "Aramco")
        super.onProfileProvisioningComplete(context, intent)
    }

    override fun onNetworkLogsAvailable(context: Context, intent: Intent, batchToken: Long, networkLogsCount: Int) {
        super.onNetworkLogsAvailable(context, intent, batchToken, networkLogsCount)
    }

    override fun onSecurityLogsAvailable(context: Context, intent: Intent) {
        super.onSecurityLogsAvailable(context, intent)
    }

    companion object {

        fun getComponentName(context: Context) = ComponentName(context.applicationContext, ContainerAdminReceiver::class.java)
    }
}
