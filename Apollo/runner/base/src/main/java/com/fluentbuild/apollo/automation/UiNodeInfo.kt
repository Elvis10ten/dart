package com.fluentbuild.apollo.automation

import android.graphics.Rect
import android.os.Build
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.view.accessibility.AccessibilityNodeInfo
import android.view.accessibility.AccessibilityWindowInfo
import androidx.annotation.RequiresApi

@Suppress("unused")
class UiNodeInfo(
    val id: Long,
    val accessibilityNodeInfo: AccessibilityNodeInfo
): Parcelable {

    lateinit var server: AutomationServer

    // todo: start reviewing here
    fun setViewIdResourceName(viewIdResName: String?) {
        accessibilityNodeInfo.viewIdResourceName = viewIdResName
    }

    fun getWindowId(): Int {
        return accessibilityNodeInfo.windowId
    }

    fun getLiveRegion(): Int {
        return accessibilityNodeInfo.liveRegion
    }

    fun getError(): CharSequence {
        return accessibilityNodeInfo.error
    }

    @RequiresApi(Build.VERSION_CODES.P)
    fun isScreenReaderFocusable(): Boolean {
        return accessibilityNodeInfo.isScreenReaderFocusable
    }

    @Suppress("SpellCheckingInspection")
    fun setDismissable(dismissable: Boolean) {
        accessibilityNodeInfo.isDismissable = dismissable
    }

    fun isEditable(): Boolean {
        return accessibilityNodeInfo.isEditable
    }

    fun getMovementGranularities(): Int {
        return accessibilityNodeInfo.movementGranularities
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun setAvailableExtraData(extraDataKeys: MutableList<String>?) {
        accessibilityNodeInfo.availableExtraData = extraDataKeys
    }

    @RequiresApi(Build.VERSION_CODES.P)
    fun getTooltipText(): CharSequence? {
        return accessibilityNodeInfo.tooltipText
    }

    fun setMaxTextLength(max: Int) {
        accessibilityNodeInfo.maxTextLength = max
    }

    fun getChildCount(): Int {
        return accessibilityNodeInfo.childCount
    }

    fun setLiveRegion(mode: Int) {
        accessibilityNodeInfo.liveRegion = mode
    }

    fun setEnabled(enabled: Boolean) {
        accessibilityNodeInfo.isEnabled = enabled
    }

    fun isClickable(): Boolean {
        return accessibilityNodeInfo.isClickable
    }

    fun setAccessibilityFocused(focused: Boolean) {
        accessibilityNodeInfo.isAccessibilityFocused = focused
    }

    @Suppress("SpellCheckingInspection")
    @RequiresApi(Build.VERSION_CODES.P)
    fun getPaneTitle(): CharSequence? {
        return accessibilityNodeInfo.paneTitle
    }

    fun setMultiLine(multiLine: Boolean) {
        accessibilityNodeInfo.isMultiLine = multiLine
    }

    fun setScrollable(scrollable: Boolean) {
        accessibilityNodeInfo.isScrollable = scrollable
    }

    fun setContentInvalid(contentInvalid: Boolean) {
        accessibilityNodeInfo.isContentInvalid = contentInvalid
    }

    fun getInputType(): Int {
        return accessibilityNodeInfo.inputType
    }

    fun setClassName(className: CharSequence?) {
        accessibilityNodeInfo.className = className
    }

    fun setLongClickable(longClickable: Boolean) {
        accessibilityNodeInfo.isLongClickable = longClickable
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getAvailableExtraData(): MutableList<String> {
        return accessibilityNodeInfo.availableExtraData
    }

    fun setTextEntryKey(isTextEntryKey: Boolean) {
        accessibilityNodeInfo.isTextEntryKey = isTextEntryKey
    }

    fun setInputType(inputType: Int) {
        accessibilityNodeInfo.inputType = inputType
    }

    fun isCheckable(): Boolean {
        return accessibilityNodeInfo.isCheckable
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getHintText(): CharSequence {
        return accessibilityNodeInfo.hintText
    }

    fun isVisibleToUser(): Boolean {
        return accessibilityNodeInfo.isVisibleToUser
    }

    fun isLongClickable(): Boolean {
        return accessibilityNodeInfo.isLongClickable
    }

    @Deprecated("Use {@link #getActionList()}")
    fun getActions(): Int {
        @Suppress("DEPRECATION")
        return accessibilityNodeInfo.actions
    }

    fun setEditable(editable: Boolean) {
        accessibilityNodeInfo.isEditable = editable
    }

    fun isMultiLine(): Boolean {
        return accessibilityNodeInfo.isMultiLine
    }

    fun setClickable(clickable: Boolean) {
        accessibilityNodeInfo.isClickable = clickable
    }

    @RequiresApi(Build.VERSION_CODES.P)
    fun setTooltipText(tooltipText: CharSequence?) {
        accessibilityNodeInfo.tooltipText = tooltipText
    }

    fun isSelected(): Boolean {
        return accessibilityNodeInfo.isSelected
    }

    fun isPassword(): Boolean {
        return accessibilityNodeInfo.isPassword
    }

    @RequiresApi(Build.VERSION_CODES.P)
    fun setPaneTitle(paneTitle: CharSequence?) {
        accessibilityNodeInfo.paneTitle = paneTitle
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun getDrawingOrder(): Int {
        return accessibilityNodeInfo.drawingOrder
    }

    fun isTextEntryKey(): Boolean {
        return accessibilityNodeInfo.isTextEntryKey
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun isImportantForAccessibility(): Boolean {
        return accessibilityNodeInfo.isImportantForAccessibility
    }

    fun setFocused(focused: Boolean) {
        accessibilityNodeInfo.isFocused = focused
    }

    fun getTextSelectionStart(): Int {
        return accessibilityNodeInfo.textSelectionStart
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun refreshWithExtraData(extraDataKey: String?, args: Bundle?): Boolean {
        return accessibilityNodeInfo.refreshWithExtraData(extraDataKey, args)
    }

    @Deprecated("Use {@link #removeAction(AccessibilityAction)}")
    fun removeAction(action: Int) {
        @Suppress("DEPRECATION")
        accessibilityNodeInfo.removeAction(action)
    }

    fun isFocused(): Boolean {
        return accessibilityNodeInfo.isFocused
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun setHintText(hintText: CharSequence?) {
        accessibilityNodeInfo.hintText = hintText
    }

    fun setCheckable(checkable: Boolean) {
        accessibilityNodeInfo.isCheckable = checkable
    }

    fun setFocusable(focusable: Boolean) {
        accessibilityNodeInfo.isFocusable = focusable
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun isContextClickable(): Boolean {
        return accessibilityNodeInfo.isContextClickable
    }

    fun setMovementGranularities(granularities: Int) {
        accessibilityNodeInfo.movementGranularities = granularities
    }


    fun isScrollable(): Boolean {
        return accessibilityNodeInfo.isScrollable
    }

    fun getContentDescription(): CharSequence {
        return accessibilityNodeInfo.contentDescription
    }

    fun getText(): CharSequence {
        return accessibilityNodeInfo.text
    }

    fun setText(text: CharSequence?) {
        accessibilityNodeInfo.text = text
    }

    fun isContentInvalid(): Boolean {
        return accessibilityNodeInfo.isContentInvalid
    }

    fun setChecked(checked: Boolean) {
        accessibilityNodeInfo.isChecked = checked
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun setContextClickable(contextClickable: Boolean) {
        accessibilityNodeInfo.isContextClickable = contextClickable
    }

    fun isDismissable(): Boolean {
        return accessibilityNodeInfo.isDismissable
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun isShowingHintText(): Boolean {
        return accessibilityNodeInfo.isShowingHintText
    }

    fun isEnabled(): Boolean {
        return accessibilityNodeInfo.isEnabled
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun setImportantForAccessibility(important: Boolean) {
        accessibilityNodeInfo.isImportantForAccessibility = important
    }

    fun isFocusable(): Boolean {
        return accessibilityNodeInfo.isFocusable
    }

    @RequiresApi(Build.VERSION_CODES.P)
    fun isHeading(): Boolean {
        return accessibilityNodeInfo.isHeading
    }

    fun getPackageName(): CharSequence {
        return accessibilityNodeInfo.packageName
    }

    fun setCanOpenPopup(opensPopup: Boolean) {
        accessibilityNodeInfo.setCanOpenPopup(opensPopup)
    }

    fun setVisibleToUser(visibleToUser: Boolean) {
        accessibilityNodeInfo.isVisibleToUser = visibleToUser
    }

    fun getExtras(): Bundle {
        return accessibilityNodeInfo.extras
    }

    fun getClassName(): CharSequence {
        return accessibilityNodeInfo.className
    }

    fun setTextSelection(start: Int, end: Int) {
        accessibilityNodeInfo.setTextSelection(start, end)
    }

    fun isChecked(): Boolean {
        return accessibilityNodeInfo.isChecked
    }

    fun isAccessibilityFocused(): Boolean {
        return accessibilityNodeInfo.isAccessibilityFocused
    }

    fun getViewIdResourceName(): String? {
        return accessibilityNodeInfo.viewIdResourceName
    }

    fun getTextSelectionEnd(): Int {
        return accessibilityNodeInfo.textSelectionEnd
    }

    fun setPackageName(packageName: CharSequence?) {
        accessibilityNodeInfo.packageName = packageName
    }

    @RequiresApi(Build.VERSION_CODES.P)
    fun setHeading(isHeading: Boolean) {
        accessibilityNodeInfo.isHeading = isHeading
    }

    fun getMaxTextLength(): Int {
        return accessibilityNodeInfo.maxTextLength
    }

    fun setError(error: CharSequence?) {
        accessibilityNodeInfo.error = error
    }

    fun canOpenPopup(): Boolean {
        return accessibilityNodeInfo.canOpenPopup()
    }

    @RequiresApi(Build.VERSION_CODES.P)
    fun setScreenReaderFocusable(screenReaderFocusable: Boolean) {
        accessibilityNodeInfo.isScreenReaderFocusable = screenReaderFocusable
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun setShowingHintText(showingHintText: Boolean) {
        accessibilityNodeInfo.isShowingHintText = showingHintText
    }

    fun getWindow(): AccessibilityWindowInfo {
        return accessibilityNodeInfo.window
    }

    fun setContentDescription(contentDescription: CharSequence?) {
        accessibilityNodeInfo.contentDescription = contentDescription
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun setDrawingOrder(drawingOrderInParent: Int) {
        accessibilityNodeInfo.drawingOrder = drawingOrderInParent
    }

    fun setPassword(password: Boolean) {
        accessibilityNodeInfo.isPassword = password
    }

    fun setSelected(selected: Boolean) {
        accessibilityNodeInfo.isSelected = selected
    }

    fun getActionList(): MutableList<AccessibilityNodeInfo.AccessibilityAction> {
        return accessibilityNodeInfo.actionList
    }

    // region: A bit complex

    @Deprecated("This has been deprecated for {@link #addAction(AccessibilityAction)}")
    fun addAction(action: Int) {
        @Suppress("DEPRECATION")
        accessibilityNodeInfo.addAction(action)
    }

    fun getBoundsInScreen(outBounds: Rect?) {
        accessibilityNodeInfo.getBoundsInScreen(outBounds)
    }

    fun addChild(child: View?) {
        accessibilityNodeInfo.addChild(child)
    }

    fun addChild(root: View?, virtualDescendantId: Int) {
        accessibilityNodeInfo.addChild(root, virtualDescendantId)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP_MR1)
    fun setTraversalAfter(view: View?) {
        accessibilityNodeInfo.setTraversalAfter(view)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP_MR1)
    fun setTraversalAfter(root: View?, virtualDescendantId: Int) {
        accessibilityNodeInfo.setTraversalAfter(root, virtualDescendantId)
    }

    fun setLabeledBy(label: View?) {
        accessibilityNodeInfo.setLabeledBy(label)
    }

    fun setLabeledBy(root: View?, virtualDescendantId: Int) {
        accessibilityNodeInfo.setLabeledBy(root, virtualDescendantId)
    }

    @Deprecated("Accessibility services should not care about these bounds.")
    fun setBoundsInParent(bounds: Rect?) {
        @Suppress("DEPRECATION")
        accessibilityNodeInfo.setBoundsInParent(bounds)
    }

    fun setLabelFor(labeled: View?) {
        accessibilityNodeInfo.setLabelFor(labeled)
    }

    fun setLabelFor(root: View?, virtualDescendantId: Int) {
        accessibilityNodeInfo.setLabelFor(root, virtualDescendantId)
    }

    fun removeAction(action: AccessibilityNodeInfo.AccessibilityAction?): Boolean {
        return accessibilityNodeInfo.removeAction(action)
    }

    fun setCollectionInfo(collectionInfo: AccessibilityNodeInfo.CollectionInfo?) {
        accessibilityNodeInfo.collectionInfo = collectionInfo
    }

    fun getCollectionInfo(): AccessibilityNodeInfo.CollectionInfo {
        return accessibilityNodeInfo.collectionInfo
    }

    fun getCollectionItemInfo(): AccessibilityNodeInfo.CollectionItemInfo {
        return accessibilityNodeInfo.collectionItemInfo
    }

    fun addAction(action: AccessibilityNodeInfo.AccessibilityAction?) {
        accessibilityNodeInfo.addAction(action)
    }

    fun getRangeInfo(): AccessibilityNodeInfo.RangeInfo {
        return accessibilityNodeInfo.rangeInfo
    }

    fun setRangeInfo(rangeInfo: AccessibilityNodeInfo.RangeInfo) {
        accessibilityNodeInfo.rangeInfo = rangeInfo
    }

    fun setCollectionItemInfo(collectionItemInfo: AccessibilityNodeInfo.CollectionItemInfo?) {
        accessibilityNodeInfo.collectionItemInfo = collectionItemInfo
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP_MR1)
    fun setTraversalBefore(view: View?) {
        accessibilityNodeInfo.setTraversalBefore(view)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP_MR1)
    fun setTraversalBefore(root: View?, virtualDescendantId: Int) {
        accessibilityNodeInfo.setTraversalBefore(root, virtualDescendantId)
    }

    fun removeChild(child: View?): Boolean {
        return accessibilityNodeInfo.removeChild(child)
    }

    fun removeChild(root: View?, virtualDescendantId: Int): Boolean {
        return accessibilityNodeInfo.removeChild(root, virtualDescendantId)
    }

    fun setParent(root: View?, virtualDescendantId: Int) {
        accessibilityNodeInfo.setParent(root, virtualDescendantId)
    }

    fun setParent(parent: View?) {
        accessibilityNodeInfo.setParent(parent)
    }

    fun setBoundsInScreen(bounds: Rect?) {
        accessibilityNodeInfo.setBoundsInScreen(bounds)
    }

    @Deprecated("Use {@link #getBoundsInScreen(Rect)} instead.")
    fun getBoundsInParent(outBounds: Rect?) {
        @Suppress("DEPRECATION")
        accessibilityNodeInfo.getBoundsInParent(outBounds)
    }
    // endregion

    // region: Complex

    fun performAction(action: Int): Boolean {
        return server.performNodeAction(this, action)
    }

    fun performAction(action: Int, arguments: Bundle?): Boolean {
        return accessibilityNodeInfo.performAction(action, arguments)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP_MR1)
    fun getTraversalAfter(): AccessibilityNodeInfo {
        return accessibilityNodeInfo.traversalAfter
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP_MR1)
    fun getTraversalBefore(): AccessibilityNodeInfo {
        return accessibilityNodeInfo.traversalBefore
    }

    fun getTouchDelegateInfo(): AccessibilityNodeInfo.TouchDelegateInfo? {
        return accessibilityNodeInfo.touchDelegateInfo
    }

    fun findAccessibilityNodeInfosByText(text: String): List<UiNodeInfo> {
        return server.findAccessibilityNodeInfosByText(this, text).attachServer(server)
    }

    fun findAccessibilityNodeInfosByViewId(viewId: String): List<UiNodeInfo> {
        return server.findAccessibilityNodeInfosByViewId(this, viewId).attachServer(server)
    }

    fun findFocus(focus: Int): AccessibilityNodeInfo {
        return accessibilityNodeInfo.findFocus(focus)
    }

    fun setTouchDelegateInfo(delegatedInfo: AccessibilityNodeInfo.TouchDelegateInfo) {
        accessibilityNodeInfo.setTouchDelegateInfo(delegatedInfo)
    }

    fun getLabelFor(): AccessibilityNodeInfo {
        return accessibilityNodeInfo.labelFor
    }

    fun getChild(index: Int): AccessibilityNodeInfo {
        return accessibilityNodeInfo.getChild(index)
    }

    fun getLabeledBy(): AccessibilityNodeInfo {
        return accessibilityNodeInfo.labeledBy
    }

    fun focusSearch(direction: Int): AccessibilityNodeInfo {
        return accessibilityNodeInfo.focusSearch(direction)
    }

    fun getParent(): AccessibilityNodeInfo {
        return accessibilityNodeInfo.parent
    }

    fun refresh(): Boolean {
        return accessibilityNodeInfo.refresh()
    }

    fun recycle() {
        accessibilityNodeInfo.recycle()
    }

    fun recycleSafely() {
        try {
            accessibilityNodeInfo.recycle()
        } catch (ignored: Exception) {}
    }

    fun setSource(source: View?) {
        accessibilityNodeInfo.setSource(source)
    }

    fun setSource(root: View?, virtualDescendantId: Int) {
        accessibilityNodeInfo.setSource(root, virtualDescendantId)
    }
    // endregion

    override fun toString() = accessibilityNodeInfo.toString()

    override fun equals(other: Any?): Boolean {
        return other is UiNodeInfo && other.id == id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readParcelable<AccessibilityNodeInfo>(AccessibilityNodeInfo::class.java.classLoader)!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeParcelable(accessibilityNodeInfo, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UiNodeInfo> {
        override fun createFromParcel(parcel: Parcel): UiNodeInfo {
            return UiNodeInfo(parcel)
        }

        override fun newArray(size: Int): Array<UiNodeInfo?> {
            return arrayOfNulls(size)
        }
    }

}

private fun List<UiNodeInfo>.attachServer(server: AutomationServer): List<UiNodeInfo> {
    forEach { it.server = server }
    return this
}