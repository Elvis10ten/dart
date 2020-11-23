package com.fluentbuild.apollo.testsample

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.graphics.Bitmap
import android.graphics.PixelFormat
import android.os.*
import android.os.health.SystemHealthManager
import android.os.health.UidHealthStats
import android.util.Log
import android.view.*
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityRecord
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.fluentbuild.apollo.foundation.android.AndroidVersion
import com.fluentbuild.apollo.runner.base.screenshot.ReflectionScreenShotter
import com.fluentbuild.apollo.runner.base.screenshot.ScreenShotter
import com.jaredrummler.android.processes.models.Stat
import java.io.*
import java.lang.reflect.Field
import java.math.BigInteger

/**
 * An [Activity] that gets a text string from the user and displays it back when the user
 * clicks on one of the two buttons. The first one shows it in the same activity and the second
 * one opens another activity and displays the message.
 */
class MainActivity : Activity(), View.OnClickListener {
    // The TextView used to display the message inside the Activity.
    private var mTextView: TextView? = null
    // The EditText where the user types the message.
    private var mEditText: EditText? = null

    @Volatile
    var cpuCompute = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Set the listeners for the buttons.
        findViewById<View>(R.id.changeTextBt).setOnClickListener(this)
        findViewById<View>(R.id.activityChangeTextBtn).setOnClickListener(this)
        mTextView = findViewById<View>(R.id.textToBeChanged) as TextView
        mEditText = findViewById<View>(R.id.editTextUserInput) as EditText

        var topWindow = window
        while(true) {
            val newWindow = topWindow.container
            if(newWindow != null) {
                Log.d("TIMBER", "Bam")
                topWindow = newWindow
            } else {
                break
            }
        }

        val wrappedCallback = window.callback
        topWindow.callback = object: Window.Callback {

            override fun onActionModeFinished(mode: ActionMode?) {
                wrappedCallback?.onActionModeFinished(mode)
                Log.d("TIMBER", "onActionModeFinished : $mode")
            }

            override fun onCreatePanelView(featureId: Int): View? {
                Log.d("TIMBER", "onCreatePanelView : $featureId")
                return wrappedCallback?.onCreatePanelView(featureId)
            }

            override fun dispatchTouchEvent(event: MotionEvent): Boolean {
                Log.d("TIMBER", "dispatchTouchEvent : $event")
                Log.d("TIMBER", "toolMajor : ${event.toolMajor}")
                Log.d("TIMBER", "toolMinor : ${event.toolMinor}")
                Log.d("TIMBER", "device : ${event.device}")
                Log.d("TIMBER", "pressure : ${event.pressure}")
                Log.d("TIMBER", "yPrecision : ${event.yPrecision}")
                Log.d("TIMBER", "xPrecision : ${event.xPrecision}")
                Log.d("TIMBER", "size : ${event.size}")
                return wrappedCallback?.dispatchTouchEvent(event) ?: false
            }

            override fun onCreatePanelMenu(featureId: Int, menu: Menu): Boolean {
                Log.d("TIMBER", "onCreatePanelMenu : $featureId")
                return wrappedCallback?.onCreatePanelMenu(featureId, menu)  ?: false
            }

            override fun onWindowStartingActionMode(callback: ActionMode.Callback?): ActionMode? {
                Log.d("TIMBER", "onWindowStartingActionMode : ")
                return wrappedCallback?.onWindowStartingActionMode(callback)
            }

            override fun onWindowStartingActionMode(
                callback: ActionMode.Callback?,
                type: Int
            ): ActionMode? {
                Log.d("TIMBER", "onWindowStartingActionMode : $type")
                return wrappedCallback?.onWindowStartingActionMode(callback, type)
            }

            override fun onAttachedToWindow() {
                wrappedCallback?.onAttachedToWindow()
                Log.d("TIMBER", "onAttachedToWindow : ")
            }

            override fun dispatchGenericMotionEvent(event: MotionEvent?): Boolean {
                Log.d("TIMBER", "dispatchGenericMotionEvent : $event")
                return wrappedCallback?.dispatchGenericMotionEvent(event) ?: false
            }

            override fun dispatchPopulateAccessibilityEvent(event: AccessibilityEvent?): Boolean {
                Log.d("TIMBER", "dispatchPopulateAccessibilityEvent : $event")
                return wrappedCallback?.dispatchPopulateAccessibilityEvent(event) ?: false
            }

            override fun dispatchTrackballEvent(event: MotionEvent?): Boolean {
                Log.d("TIMBER", "dispatchTrackballEvent : $event")
                return wrappedCallback?.dispatchTrackballEvent(event) ?: false
            }

            override fun dispatchKeyShortcutEvent(event: KeyEvent?): Boolean {
                Log.d("TIMBER", "dispatchKeyShortcutEvent : $event")
                return wrappedCallback?.dispatchKeyShortcutEvent(event) ?: false
            }

            override fun dispatchKeyEvent(event: KeyEvent): Boolean {
                Log.d("TIMBER", "dispatchKeyEvent : $event")
                Log.d("TIMBER", "device : ${event.device}")
                return wrappedCallback?.dispatchKeyEvent(event) ?: false
            }

            override fun onMenuOpened(featureId: Int, menu: Menu): Boolean {
                Log.d("TIMBER", "onMenuOpened : $featureId")
                return wrappedCallback?.onMenuOpened(featureId, menu) ?: false
            }

            override fun onPanelClosed(featureId: Int, menu: Menu) {
                wrappedCallback?.onPanelClosed(featureId, menu)
                Log.d("TIMBER", "onPanelClosed : $featureId")
            }

            override fun onMenuItemSelected(featureId: Int, item: MenuItem): Boolean {
                Log.d("TIMBER", "onMenuItemSelected : $featureId")
                return wrappedCallback?.onMenuItemSelected(featureId, item) ?: false
            }

            override fun onDetachedFromWindow() {
                wrappedCallback?.onDetachedFromWindow()
                Log.d("TIMBER", "onDetachedFromWindow : ")
            }

            override fun onPreparePanel(featureId: Int, view: View?, menu: Menu): Boolean {
                Log.d("TIMBER", "onPreparePanel : $featureId")
                return wrappedCallback?.onPreparePanel(featureId, view, menu) ?: false
            }

            override fun onWindowAttributesChanged(attrs: WindowManager.LayoutParams?) {
                wrappedCallback?.onWindowAttributesChanged(attrs)
                Log.d("TIMBER", "onWindowAttributesChanged : $attrs")
            }

            override fun onWindowFocusChanged(hasFocus: Boolean) {
                wrappedCallback?.onWindowFocusChanged(hasFocus)
                Log.d("TIMBER", "onWindowFocusChanged : $hasFocus")
            }

            override fun onContentChanged() {
                wrappedCallback?.onContentChanged()
                Log.d("TIMBER", "onContentChanged : ")
            }

            override fun onSearchRequested(): Boolean {
                Log.d("TIMBER", "onSearchRequested : ")
                return wrappedCallback?.onSearchRequested() ?: false
            }

            override fun onSearchRequested(searchEvent: SearchEvent?): Boolean {
                Log.d("TIMBER", "onSearchRequested : $searchEvent")
                return wrappedCallback?.onSearchRequested(searchEvent) ?: false
            }

            override fun onActionModeStarted(mode: ActionMode?) {
                wrappedCallback?.onActionModeStarted(mode)
                Log.d("TIMBER", "onActionModeStarted : $mode")
            }

        }
        Log.d("CPU_INFO", "boom: " + BufferedReader(InputStreamReader(FileInputStream("/proc/${Process.myPid()}/io"))).readText())
        try {
            val DATA =
                arrayOf("/system/bin/cat", "/proc/stat")
            val processBuilder = ProcessBuilder(*DATA)
            val process = processBuilder.start()
            val inputStream: InputStream = process.inputStream

            Log.d("CPU_INFO", inputStream.reader().readText())
            inputStream.close()
        } catch (ex: Exception) {
            Log.e("CPU_INFO", "bo", ex)
            ex.printStackTrace()
        }

        val handler = Handler()
        val runnable = object: Runnable {

            override fun run() {
                val stat = Stat.get(Process.myPid())
                for(method in Stat::class.java.declaredMethods) {
                    if(method.name.toLowerCase() in arrayListOf("writetoparcel", "get", "rsslim")) continue
                    Log.d("CPU_INFO", method.name + ": " + method.invoke(stat))
                }
                handler.postDelayed(this, 5000)
            }
        }
        //handler.postDelayed(runnable, 1000)
        doStuff()
    }

    @SuppressLint("NewApi")
    private fun printCpu() {
        val health = (getSystemService(Context.SYSTEM_HEALTH_SERVICE) as SystemHealthManager)
        Log.d("CPU_INFO", "Boom: " + health.takeMyUidSnapshot())
        Log.d("CPU_INFO", "Boom: " + health.takeMyUidSnapshot().getMeasurement(UidHealthStats.MEASUREMENT_BUTTON_USER_ACTIVITY_COUNT))
        Log.d("CPU_INFO", "Boom: " + health.takeMyUidSnapshot().getMeasurement(UidHealthStats.MEASUREMENT_OTHER_USER_ACTIVITY_COUNT))
        Log.d("CPU_INFO", "Boom: " + health.takeMyUidSnapshot().getMeasurement(UidHealthStats.MEASUREMENT_TOUCH_USER_ACTIVITY_COUNT))

        return
        val stat = Stat.get(Process.myPid())
        for(method in Stat::class.java.declaredMethods) {
            if(method.name.toLowerCase() in arrayListOf("writetoparcel", "get", "rsslim")) continue
            Log.d("CPU_INFO", method.name + ": " + method.invoke(stat))
        }
    }

    private fun getWindowParams(): WindowManager.LayoutParams {
        val type = if(AndroidVersion.isAtLeastOreo()) {
            WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
        } else {
            @Suppress("DEPRECATION")
            WindowManager.LayoutParams.TYPE_PHONE
        }

        val formats = WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE or
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or
                WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON or
                WindowManager.LayoutParams.FLAG_FULLSCREEN

        return WindowManager.LayoutParams(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT,
            type,
            formats,
            PixelFormat.TRANSPARENT
        )
    }

    lateinit var overlay: ScreenOverlay

    override fun onResume() {
        super.onResume()
        overlay = ScreenOverlay(this, object: ScreenOverlay.Consumer {
            override fun setLabelUpdater(labelUpdater: ((String) -> Unit)?) {

            }

        })

        AlertDialog.Builder(this)
            .setTitle("Testing here")
            .setMessage("Mask oooo sfjklsjfklsfj fkjaklf")
            .show()

        Handler().postDelayed({
            val eventTime = SystemClock.uptimeMillis()
            dispatchKeyEvent(KeyEvent(eventTime, eventTime, KeyEvent.KEYCODE_VOLUME_UP,
                KeyEvent.KEYCODE_HOME, 0, 0, KeyCharacterMap.VIRTUAL_KEYBOARD, 0, 0,
                InputDevice.SOURCE_KEYBOARD))
            dispatchKeyEvent(KeyEvent(eventTime, eventTime, KeyEvent.KEYCODE_VOLUME_UP,
                KeyEvent.KEYCODE_HOME, 0, 0, KeyCharacterMap.VIRTUAL_KEYBOARD, 0, 0,
                InputDevice.SOURCE_KEYBOARD))
        }, 2000)
        /*Handler().postDelayed({
            var topWindow = window
            while(true) {
                val newWindow = topWindow.container
                if(newWindow != null) {
                    Log.d("TIMBER", "Bam")
                    topWindow = newWindow
                } else {
                    break
                }
            }
            val root = topWindow.decorView.rootView

            if(root is ViewGroup) {
                shot(root)
            }
        }, 5000)*/
    }

    private var count = 0

    private fun shot(root: View) {
        ReflectionScreenShotter(
            Handler()
        ).take(this, overlay.rootView, object: ScreenShotter.Callback {

            override fun onSuccess(bitmap: Bitmap) {
                FileOutputStream(File(filesDir, "boom.webp")).use {
                    bitmap.compress(Bitmap.CompressFormat.WEBP, 10, it)
                    it.flush()
                    it.fd.sync()
                }
            }

            override fun onError(error: Throwable) {
                TODO("Not yet implemented")
            }

        })
        return

        val previousDrawingCacheValue = root.isDrawingCacheEnabled
        root.isDrawingCacheEnabled = true
        val bitmap2 = Bitmap.createBitmap(root.drawingCache)

        FileOutputStream(File(filesDir, "boom2.webp")).use {
            bitmap2.compress(Bitmap.CompressFormat.WEBP, 10, it)
            it.flush()
            it.fd.sync()
        }
    }

    private var identity = -1

    override fun onClick(view: View) { // Get the text from the EditText view.
        val text = mEditText!!.text.toString()
        val changeTextBtId = R.id.changeTextBt
        val activityChangeTextBtnId = R.id.activityChangeTextBtn
        if (view.id == changeTextBtId) { // First button's interaction: set a text in a text view.
            //mTextView!!.text = text
            if(cpuCompute) {
                stop()
            } else {
                start()
            }
        } else if (view.id == activityChangeTextBtnId) { // Second button's interaction: start an activity and send a message to it.
            /*val intent = ShowTextActivity.newStartIntent(this, text)
            startActivity(intent)*/
            //printCpu()
            Toast.makeText(this, "dart!!!!!", Toast.LENGTH_LONG).show()
        }
    }

    private fun start() {
        cpuCompute = true
        Thread({
            Log.d("CPU_INFO", "Started CPU")
            var number = BigInteger.ONE
            while(cpuCompute) {
                isPrime(number)
                number = number.add(BigInteger.ONE)
            }
            Log.d("CPU_INFO", "StOPPED CPU")
        }).start()

        Debug.threadCpuTimeNanos()
        Process.getElapsedCpuTime()
    }

    private fun stop() {
        cpuCompute = false
    }

    fun isPrime(n: BigInteger): Boolean {
        var counter = BigInteger.ONE.add(BigInteger.ONE)
        var isPrime = true

        while (counter.compareTo(n) == -1) {
            if(!cpuCompute) return false

            if (n.remainder(counter).compareTo(BigInteger.ZERO) == 0) {
                isPrime = false
                break
            }
            counter = counter.add(BigInteger.ONE)
        }
        return isPrime
    }

    //private var automation: UiAutomation? = null

    override fun onDestroy() {
        super.onDestroy()
        //automation?.disconnect()
    }

    private fun getPrinterField(): Field {
        return AccessibilityRecord::class.java.getDeclaredField("mConnectionId")
            .apply { isAccessible = true }
    }

    private var time = 0L

    private fun doStuff() {
        /*UiAutomationCreator(this, Handler(), LogWrapper(true)).create(0, object: UiAutomationCreator.Callback {

            override fun onCreated(uiAutomation: UiAutomation) {
                Log.d("BOOM", "onCreated")
                automation = uiAutomation
                uiAutomation.setOnAccessibilityEventListener(object: UiAutomation.OnAccessibilityEventListener {

                    override fun onAccessibilityEvent(event: UiEvent) {
                        Log.d("dart", "Event: " + event)
                        Log.d("dart ", "SOURCE: " + event?.getSource())

                        val timeDiff = System.currentTimeMillis() - time
                        if(timeDiff > 5_000L) {
                            event.getSource()?.findAccessibilityNodeInfosByText("Open activity and change text".toUpperCase())
                                ?.forEach { node ->
                                    Log.d("dart", "Clicking: $node")
                                    time = System.currentTimeMillis()
                                    node.performAction(AccessibilityNodeInfo.ACTION_CLICK)
                                }
                        }
                    }
                })
            }

            override fun onCreateTimeout() {
                Log.d("BOOM", "onCreateTimeout")
            }

            override fun onServiceFailure() {
                Log.d("BOOM", "onServiceFailure")
            }

        })*/
    }
}