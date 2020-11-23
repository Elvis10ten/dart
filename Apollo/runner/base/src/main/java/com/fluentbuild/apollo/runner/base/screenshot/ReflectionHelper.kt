package com.fluentbuild.apollo.runner.base.screenshot

import android.app.Activity
import android.os.IBinder
import android.view.View
import android.view.WindowManager
import com.fluentbuild.apollo.foundation.android.getStartCoordinates
import java.util.*

internal object ReflectionHelper {

    private const val FIELD_NAME_GLOBAL = "mGlobal"
    private const val FIELD_NAME_ROOTS = "mRoots"
    private const val FIELD_NAME_PARAMS = "mParams"
    private const val FIELD_NAME_VIEW = "mView"
    private const val FIELD_NAME_VIEWS = "mViews"

    fun getRootViews(activity: Activity): List<RootViewInfo> {
        val rootViews = ArrayList<RootViewInfo>()

        val globalWindowManager = getFieldValue(FIELD_NAME_GLOBAL, activity.windowManager) ?: return rootViews
        val roots = getFieldValue(FIELD_NAME_ROOTS, globalWindowManager) as List<*>
        val params = getFieldValue(FIELD_NAME_PARAMS, globalWindowManager) as List<WindowManager.LayoutParams>

        for (viewIndex in roots.indices) {
            val view = (getFieldValue(FIELD_NAME_VIEW, roots[viewIndex]) as View?) ?: continue
            if (view.visibility == View.VISIBLE) {
                rootViews.add(RootViewInfo(view, params[viewIndex]))
            }
        }

        if(rootViews.isEmpty()){
            val views = getFieldValue(FIELD_NAME_VIEWS, globalWindowManager) as List<View>?
            views?.mapIndexedTo(rootViews) { viewIndex, view ->
                RootViewInfo(view, params[viewIndex])
            }
        }

        ensureDialogsAreAfterItsParentActivities(rootViews)
        return rootViews
    }

    // Fix from: https://github.com/jraska/Falcon/issues/11
    // It is not perfect solution and maybe there is another case of different type of view,
    // but it works for most common case of dialogs.
    private fun ensureDialogsAreAfterItsParentActivities(rootViews: MutableList<RootViewInfo>) {
        if (rootViews.size <= 1) {
            return
        }

        for (dialogIndex in 0 until rootViews.size - 1) {
            val viewRoot = rootViews[dialogIndex]
            if (!viewRoot.isDialogType) {
                continue
            }

            if (viewRoot.windowToken == null) {
                // make sure we will never compare null == null
                return
            }

            for (parentIndex in dialogIndex + 1 until rootViews.size) {
                val possibleParent = rootViews[parentIndex]
                if (possibleParent.isActivityType && possibleParent.windowToken === viewRoot.windowToken) {
                    rootViews.remove(possibleParent)
                    rootViews.add(dialogIndex, possibleParent)
                    break
                }
            }
        }
    }

    @Throws(NoSuchFieldException::class, IllegalAccessException::class)
    private fun getFieldValue(fieldName: String, target: Any?): Any? {
        return try {
            val field = target?.javaClass?.getDeclaredField(fieldName)
            field?.isAccessible = true
            field?.get(target)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}

class RootViewInfo(
    val view: View,
    val layoutParams: WindowManager.LayoutParams
) {

    val startCoordinates = view.getStartCoordinates()

    val isDialogType = layoutParams.type == WindowManager.LayoutParams.TYPE_APPLICATION

    val isActivityType = layoutParams.type == WindowManager.LayoutParams.TYPE_BASE_APPLICATION

    val windowToken: IBinder? = layoutParams.token
}