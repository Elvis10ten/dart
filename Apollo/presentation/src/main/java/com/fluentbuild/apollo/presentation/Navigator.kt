package com.fluentbuild.apollo.presentation

import android.content.Intent
import android.view.ViewGroup
import androidx.annotation.MainThread
import com.fluentbuild.apollo.foundation.async.requireMainThread
import com.fluentbuild.apollo.views.ViewHolder
import timber.log.Timber

class Navigator {

    private var backStack = ArrayList<Host<Any, ViewHolder<Any>>>()
    private var hostContainer: ViewGroup? = null

    @MainThread
    fun onStart(hostContainer: ViewGroup) {
        Timber.d("On start")
        requireMainThread()
        this.hostContainer = hostContainer
        showCurrentHost()
    }

    @MainThread
    fun onStop() {
        Timber.d("On stop")
        requireMainThread()
        hideCurrentHost()
        hostContainer = null
    }

    @MainThread
    fun <VM: Any, VH: ViewHolder<VM>> goto(host: Host<VM, VH>, popCurrentFromBackStack: Boolean = false) {
        Timber.d("Goto: %s, popCurrent: %s", host, popCurrentFromBackStack)
        requireMainThread()

        host.init()
        hideCurrentHost(popCurrentFromBackStack)
        host.show(requireHostContainer())
        backStack.add(host as Host<Any, ViewHolder<Any>>)
    }

    @MainThread
    fun <VM: Any, VH: ViewHolder<VM>> clearAndGoto(host: Host<VM, VH>) {
        while(backStack.isNotEmpty()) {
            hideCurrentHost(true)
        }

        goto(host)
    }

    @MainThread
    fun isBackStackEmpty(): Boolean {
        requireMainThread()
        return backStack.isEmpty()
    }

    @MainThread
    fun onNavigateBack(): Boolean {
        Timber.d("On navigate back pressed")
        requireMainThread()
        // TODO: Handle when navigate back, but there are no screens left after popping back stack
        return onBackPressed()
    }

    @MainThread
    fun onBackPressed(): Boolean {
        Timber.d("On back pressed")
        requireMainThread()

        return if(!isBackStackEmpty()) {
            if(backStack.last().onBackPressed()) {
                true
            } else {
                popBackStack()
                return !isBackStackEmpty() // If after popping the back stack we have nothing left, allow the Activity to handle back presses.
            }
        } else {
            false
        }
    }

    @MainThread
    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?): Boolean {
        Timber.d("On activity result, requestCode: %s, resultCode: %s, data: %s", requestCode, resultCode, data)
        return if(isBackStackEmpty()) {
            false
        } else {
            backStack.last().onActivityResult(requestCode, resultCode, data)
        }
    }

    private fun popBackStack() {
        Timber.d("Popping back stack")
        hideCurrentHost(true)
        showCurrentHost()
    }

    private fun showCurrentHost() {
        Timber.d("Showing current host")
        val lastHost = backStack.lastOrNull() ?: return
        lastHost.show(requireHostContainer())
    }

    private fun hideCurrentHost(popFromBackStack: Boolean = false) {
        Timber.d("Hide current host, should pop: %s", popFromBackStack)
        val currentHost = backStack.lastOrNull() ?: return
        currentHost.hide(requireHostContainer())

        if(popFromBackStack) {
            currentHost.destroy()
            backStack.removeAt(backStack.lastIndex)
        }
    }

    private fun requireHostContainer() = hostContainer ?: throw IllegalStateException("Host home is null")
}
