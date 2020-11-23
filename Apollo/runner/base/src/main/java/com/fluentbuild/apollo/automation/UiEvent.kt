package com.fluentbuild.apollo.automation

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityRecord
import androidx.annotation.RequiresApi

@Suppress("unused")
class UiEvent(
    val id: Long,
    val accessibilityEvent: AccessibilityEvent
) : Parcelable {

    lateinit var server: AutomationServer

    fun getWindowId(): Int {
        return accessibilityEvent.windowId
    }

    fun getMaxScrollX(): Int {
        return accessibilityEvent.maxScrollX
    }

    fun getEventTime(): Long {
        return accessibilityEvent.eventTime
    }

    fun isScrollable(): Boolean {
        return accessibilityEvent.isScrollable
    }

    fun getContentDescription(): CharSequence {
        return accessibilityEvent.contentDescription
    }

    fun getBeforeText(): CharSequence {
        return accessibilityEvent.beforeText
    }

    fun getText(): MutableList<CharSequence> {
        return accessibilityEvent.text
    }

    fun getParcelableData(): Parcelable {
        return accessibilityEvent.parcelableData
    }

    fun setMaxScrollX(maxScrollX: Int) {
        accessibilityEvent.maxScrollX = maxScrollX
    }

    fun setAddedCount(addedCount: Int) {
        accessibilityEvent.addedCount = addedCount
    }

    fun setEnabled(isEnabled: Boolean) {
        accessibilityEvent.isEnabled = isEnabled
    }

    fun setChecked(isChecked: Boolean) {
        accessibilityEvent.isChecked = isChecked
    }

    fun setFullScreen(isFullScreen: Boolean) {
        accessibilityEvent.isFullScreen = isFullScreen
    }

    @RequiresApi(Build.VERSION_CODES.P)
    fun getScrollDeltaY(): Int {
        return accessibilityEvent.scrollDeltaY
    }

    fun setScrollable(scrollable: Boolean) {
        accessibilityEvent.isScrollable = scrollable
    }

    fun setCurrentItemIndex(currentItemIndex: Int) {
        accessibilityEvent.currentItemIndex = currentItemIndex
    }

    fun setFromIndex(fromIndex: Int) {
        accessibilityEvent.fromIndex = fromIndex
    }

    fun setClassName(className: CharSequence) {
        accessibilityEvent.className = className
    }

    fun setMovementGranularity(granularity: Int) {
        accessibilityEvent.movementGranularity = granularity
    }

    // todo: start reviewing here
    fun getMaxScrollY(): Int {
        return accessibilityEvent.maxScrollY
    }

    fun setBeforeText(beforeText: CharSequence?) {
        accessibilityEvent.beforeText = beforeText
    }

    fun setEventTime(eventTime: Long) {
        accessibilityEvent.eventTime = eventTime
    }

    fun getScrollY(): Int {
        return accessibilityEvent.scrollY
    }

    fun setScrollX(scrollX: Int) {
        accessibilityEvent.scrollX = scrollX
    }

    fun isEnabled(): Boolean {
        return accessibilityEvent.isEnabled
    }

    fun getContentChangeTypes(): Int {
        return accessibilityEvent.contentChangeTypes
    }

    fun setAction(action: Int) {
        accessibilityEvent.action = action
    }

    @RequiresApi(Build.VERSION_CODES.P)
    fun getScrollDeltaX(): Int {
        return accessibilityEvent.scrollDeltaX
    }

    fun getMovementGranularity(): Int {
        return accessibilityEvent.movementGranularity
    }

    fun getToIndex(): Int {
        return accessibilityEvent.toIndex
    }

    fun getPackageName(): CharSequence {
        return accessibilityEvent.packageName
    }

    fun getRecordCount(): Int {
        return accessibilityEvent.recordCount
    }

    fun getClassName(): CharSequence {
        return accessibilityEvent.className
    }

    fun setItemCount(itemCount: Int) {
        accessibilityEvent.itemCount = itemCount
    }

    fun getScrollX(): Int {
        return accessibilityEvent.scrollX
    }

    @RequiresApi(Build.VERSION_CODES.P)
    fun setScrollDeltaY(scrollDeltaY: Int) {
        accessibilityEvent.scrollDeltaY = scrollDeltaY
    }

    fun setScrollY(scrollY: Int) {
        accessibilityEvent.scrollY = scrollY
    }

    fun isChecked(): Boolean {
        return accessibilityEvent.isChecked
    }

    fun isPassword(): Boolean {
        return accessibilityEvent.isPassword
    }

    fun getItemCount(): Int {
        return accessibilityEvent.itemCount
    }

    fun setPackageName(packageName: CharSequence?) {
        accessibilityEvent.packageName = packageName
    }

    fun getCurrentItemIndex(): Int {
        return accessibilityEvent.currentItemIndex
    }

    fun getEventType(): Int {
        return accessibilityEvent.eventType
    }

    fun setRemovedCount(removedCount: Int) {
        accessibilityEvent.removedCount = removedCount
    }

    fun getAction(): Int {
        return accessibilityEvent.action
    }

    fun getFromIndex(): Int {
        return accessibilityEvent.fromIndex
    }

    @RequiresApi(Build.VERSION_CODES.P)
    fun getWindowChanges(): Int {
        return accessibilityEvent.windowChanges
    }

    fun getRemovedCount(): Int {
        return accessibilityEvent.removedCount
    }

    fun setContentDescription(contentDescription: CharSequence?) {
        accessibilityEvent.contentDescription = contentDescription
    }

    @RequiresApi(Build.VERSION_CODES.P)
    fun setScrollDeltaX(scrollDeltaX: Int) {
        accessibilityEvent.scrollDeltaX = scrollDeltaX
    }

    fun getAddedCount(): Int {
        return accessibilityEvent.addedCount
    }

    fun setPassword(isPassword: Boolean) {
        accessibilityEvent.isPassword = isPassword
    }

    fun setMaxScrollY(maxScrollY: Int) {
        accessibilityEvent.maxScrollY = maxScrollY
    }

    fun isFullScreen(): Boolean {
        return accessibilityEvent.isFullScreen
    }

    fun setToIndex(toIndex: Int) {
        accessibilityEvent.toIndex = toIndex
    }

    fun setParcelableData(parcelableData: Parcelable?) {
        accessibilityEvent.parcelableData = parcelableData
    }

    fun setEventType(eventType: Int) {
        accessibilityEvent.eventType = eventType
    }

    fun setContentChangeTypes(changeTypes: Int) {
        accessibilityEvent.contentChangeTypes = changeTypes
    }

    // region: Complex

    fun setSource(source: View?) {
        accessibilityEvent.setSource(source)
    }

    fun setSource(root: View?, virtualDescendantId: Int) {
        accessibilityEvent.setSource(root, virtualDescendantId)
    }

    fun recycle() {
        accessibilityEvent.recycle()
    }

    fun appendRecord(record: AccessibilityRecord?) {
        accessibilityEvent.appendRecord(record)
    }

    fun getRecord(index: Int): AccessibilityRecord {
        return accessibilityEvent.getRecord(index)
    }

    fun getSource(): UiNodeInfo? {
        return server.getUiEventSource(this)?.apply { server = this@UiEvent.server }
    }

    // endregion

    private fun attachServer(uiEvent: UiEvent) {
        uiEvent.server = server
    }

    override fun toString() = accessibilityEvent.toString()

    override fun equals(other: Any?): Boolean {
        return other is UiEvent && other.id == id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readParcelable<AccessibilityEvent>(AccessibilityEvent::class.java.classLoader)!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeParcelable(accessibilityEvent, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UiEvent> {
        override fun createFromParcel(parcel: Parcel): UiEvent {
            return UiEvent(parcel)
        }

        override fun newArray(size: Int): Array<UiEvent?> {
            return arrayOfNulls(size)
        }
    }


}