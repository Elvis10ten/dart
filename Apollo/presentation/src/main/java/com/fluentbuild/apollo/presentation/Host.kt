package com.fluentbuild.apollo.presentation

import android.content.Intent
import android.view.ViewGroup
import androidx.annotation.MainThread
import com.fluentbuild.apollo.foundation.async.requireMainThread
import com.fluentbuild.apollo.views.ViewHolder
import timber.log.Timber
import kotlin.IllegalStateException

abstract class Host<VM: Any, VH: ViewHolder<VM>> {

    private var viewHolder: VH? = null
    private var viewModel: VM? = null

    @MainThread
    fun init() {
        Timber.d("Initializing")
        requireMainThread()
        require(viewModel == null) { "Host has already been initialized" }
        viewModel = createInitialViewModel()
        onInit()
    }

    @MainThread
    fun show(container: ViewGroup) {
        Timber.d("Showing host: %s", container)
        requireMainThread()
        val viewModel = requireViewModel()

        viewHolder = createViewHolder(container).apply {
            create()
            container.addView(getRoot())
        }

        updateViewHolder(viewModel)
        onShow(container)
    }

    @MainThread
    fun hide(container: ViewGroup) {
        Timber.d("Hiding host: %s", container)
        requireMainThread()
        requireViewModel()

        if(viewHolder != null) {
            onHide(container)
            requireViewHolder().apply {
                destroy()
                container.removeView(getRoot())
            }

            viewHolder = null
        }
    }

    @MainThread
    fun destroy() {
        Timber.d("Destroy host")
        requireMainThread()
        requireViewModel()
        onDestroy()
        viewModel = null
    }

    @MainThread
    open fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?): Boolean {
        return false
    }

    internal fun requireViewHolder() =
        viewHolder ?: throw IllegalStateException("ViewHolder is not initialized")

    internal fun requireViewModel() =
        viewModel ?: throw IllegalStateException("ViewModel is not initialized")

    @MainThread
    internal fun updateViewHolder(viewModel: VM) {
        requireMainThread()
        updateViewModel(viewModel)
        viewHolder!!.setViewModel(viewModel)
    }

    @MainThread
    internal fun updateViewModel(viewModel: VM) {
        Timber.v("Updating view model: %s", viewModel)
        requireMainThread()
        this.viewModel = viewModel
    }

    @MainThread
    internal abstract fun createViewHolder(container: ViewGroup): VH

    @MainThread
    internal abstract fun createInitialViewModel(): VM

    @MainThread
    internal open fun onShow(container: ViewGroup) {}

    @MainThread
    internal open fun onHide(container: ViewGroup) {}

    @MainThread
    internal open fun onBackPressed(): Boolean {
        return false
    }

    @MainThread
    internal open fun onInit() {}

    @MainThread
    internal open fun onDestroy() {}
}
