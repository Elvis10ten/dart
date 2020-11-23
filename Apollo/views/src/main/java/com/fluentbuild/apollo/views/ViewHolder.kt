package com.fluentbuild.apollo.views

import android.view.View

/**
 * A ViewHolder is simply just a stateless holder for views.
 *
 * It is responsible for:
 * 1. Inflating views
 * 2. Attaching view callbacks
 * 3. Detaching view callbacks
 * 4. Clearing whatever resources the views hold
 *
 * A ViewHolder MUST be stateless. All data about the current view state is stored in the ViewModel [VM].
 * That is, passing the same [VM] multiple times should bring the ViewHolder to the same state.
 */
interface ViewHolder<VM: Any> {

    fun create()

    fun destroy()

    fun setViewModel(viewModel: VM)

    fun getRoot(): View
}
