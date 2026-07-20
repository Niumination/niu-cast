package com.transsion.widgetsliquid.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.AbsSavedState;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.app.NotificationCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupKt;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FloatValueHolder;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.transsion.widgetslib.R$attr;
import com.transsion.widgetslib.R$color;
import com.transsion.widgetslib.R$styleable;
import com.transsion.widgetslib.widget.OSIconTextView;
import com.transsion.widgetsliquid.R;
import com.transsion.widgetsliquid.effect.OSLiquidContainerRootLayout;
import com.transsion.widgetsliquid.view.OSLiquidFootOperationBar;
import hd.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import je.c;
import je.d;
import je.e;
import je.f;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt___RangesKt;
import pd.j;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0016\u0018\u0000 \u0092\u00012\u00020\u0001:\b\u0092\u0001\u0093\u0001\u0094\u0001\u0095\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ'\u0010.\u001a\u00020/2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u0007012\f\u00102\u001a\b\u0012\u0004\u0012\u00020301¢\u0006\u0002\u00104J\u0018\u00105\u001a\u00020/2\b\b\u0001\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u000203J\"\u00108\u001a\u00020/2\u0006\u00109\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\f2\b\b\u0002\u0010;\u001a\u00020\fH\u0002J\u0012\u0010<\u001a\u00020/2\b\b\u0002\u0010;\u001a\u00020\fH\u0002J\u001a\u0010=\u001a\u00020/2\b\b\u0002\u0010;\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0007H\u0002J\u0010\u0010>\u001a\u00020/2\u0006\u0010?\u001a\u00020\u0007H\u0002J\b\u0010@\u001a\u00020\u0007H\u0002J\b\u0010A\u001a\u00020BH\u0002J \u0010C\u001a\u00020D2\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u0002032\u0006\u0010E\u001a\u00020\u0007H\u0002J\u0010\u0010F\u001a\u00020\f2\u0006\u0010G\u001a\u00020HH\u0016J.\u0010I\u001a\u00020/2\b\b\u0002\u0010J\u001a\u00020\f2\b\b\u0002\u0010K\u001a\u00020\u00072\b\b\u0002\u0010;\u001a\u00020\f2\b\b\u0002\u0010L\u001a\u00020\u0007J,\u0010M\u001a\u00020/2\b\b\u0002\u0010J\u001a\u00020\f2\b\b\u0002\u0010N\u001a\u00020\f2\b\b\u0002\u0010O\u001a\u00020\f2\u0006\u0010P\u001a\u00020\u0007J\u001a\u0010Q\u001a\u0004\u0018\u00010D2\u0006\u0010R\u001a\u00020\u000e2\u0006\u0010S\u001a\u00020\u000eH\u0002J\b\u0010T\u001a\u00020\u000eH\u0002J\u0006\u0010U\u001a\u00020\u0007J\u0010\u0010V\u001a\u00020\u00072\u0006\u0010G\u001a\u00020HH\u0002J\u0010\u0010W\u001a\u00020\u000e2\u0006\u0010G\u001a\u00020HH\u0002J\b\u0010X\u001a\u00020\u0007H\u0002J\u0010\u0010Y\u001a\u00020\u00072\u0006\u0010E\u001a\u00020\u0007H\u0002J\u0006\u0010Z\u001a\u00020\u0007J\u0006\u0010[\u001a\u00020\u0007J\u0010\u0010\\\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u0007H\u0002J\u0006\u0010]\u001a\u00020\u0007J(\u0010^\u001a\u00020/2\u0006\u0010:\u001a\u00020\f2\u0006\u0010_\u001a\u00020\u000e2\u0006\u0010`\u001a\u00020\u00072\u0006\u0010a\u001a\u00020DH\u0002J(\u0010b\u001a\u00020/2\u0006\u0010:\u001a\u00020\f2\u0006\u0010c\u001a\u00020\u00072\u0006\u0010_\u001a\u00020\u000e2\u0006\u0010d\u001a\u00020\u0007H\u0002J\u0006\u0010e\u001a\u00020\fJ\b\u0010f\u001a\u00020/H\u0002J\b\u0010g\u001a\u00020/H\u0014J\u0018\u0010h\u001a\u00020/2\u0006\u0010i\u001a\u00020\u00072\u0006\u0010j\u001a\u00020\u0007H\u0014J\u0012\u0010k\u001a\u00020/2\b\u0010l\u001a\u0004\u0018\u00010mH\u0014J\n\u0010n\u001a\u0004\u0018\u00010mH\u0014J\u0010\u0010o\u001a\u00020/2\u0006\u0010p\u001a\u00020\fH\u0016J\u0010\u0010q\u001a\u00020\f2\u0006\u0010r\u001a\u00020\u0007H\u0002J\u000e\u0010s\u001a\u00020/2\u0006\u0010E\u001a\u00020\u0007J\u001f\u0010t\u001a\u00020/2\u0006\u0010E\u001a\u00020\u00072\n\b\u0002\u0010u\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010vJ\u001f\u0010w\u001a\u00020/2\u0006\u0010E\u001a\u00020\u00072\n\b\u0002\u0010u\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010vJ\u0012\u0010x\u001a\u00020/2\b\u0010y\u001a\u0004\u0018\u00010zH\u0016J\u000e\u0010{\u001a\u00020/2\u0006\u0010|\u001a\u00020\u001fJ\u000e\u0010}\u001a\u00020/2\u0006\u0010~\u001a\u00020\u0007J\u000f\u0010\u007f\u001a\u00020/2\u0007\u0010\u0080\u0001\u001a\u00020\fJ\u0018\u0010\u0081\u0001\u001a\u00020/2\u0006\u0010E\u001a\u00020\u00072\u0007\u0010\u0082\u0001\u001a\u00020\fJ\u0010\u0010\u0083\u0001\u001a\u00020/2\u0007\u0010\u0084\u0001\u001a\u00020\u0007J\u0012\u0010\u0085\u0001\u001a\u00020/2\u0007\u0010\u0086\u0001\u001a\u00020DH\u0002J\u0012\u0010\u0087\u0001\u001a\u00020/2\u0007\u0010\u0086\u0001\u001a\u00020DH\u0002J\u0019\u0010\u0088\u0001\u001a\u00020/2\u0006\u0010K\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0002J2\u0010\u0089\u0001\u001a\u00020/2\u0007\u0010\u008a\u0001\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020\f2\u0006\u0010_\u001a\u00020\u000e2\u0006\u0010a\u001a\u00020D2\u0006\u0010`\u001a\u00020\u0007H\u0002J2\u0010\u008b\u0001\u001a\u00020/2\u0007\u0010\u008a\u0001\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020\f2\u0006\u0010_\u001a\u00020\u000e2\u0006\u0010a\u001a\u00020D2\u0006\u0010`\u001a\u00020\u0007H\u0002J!\u0010\u008c\u0001\u001a\u00020/2\u0006\u0010E\u001a\u00020\u00072\b\b\u0001\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u000203J\u001b\u0010\u008d\u0001\u001a\u00020/2\u0007\u0010\u008e\u0001\u001a\u00020+2\u0007\u0010\u008f\u0001\u001a\u00020\fH\u0002J\u0011\u0010\u0090\u0001\u001a\u00020/2\u0006\u0010E\u001a\u00020\u0007H\u0002J\t\u0010\u0091\u0001\u001a\u00020/H\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000e0\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0096\u0001"}, d2 = {"Lcom/transsion/widgetsliquid/view/OSLiquidFootOperationBar;", "Lcom/transsion/widgetsliquid/effect/OSLiquidContainerRootLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "currentScaleAnimator", "Landroidx/dynamicanimation/animation/SpringAnimation;", "downOnCurrentItem", "", "dragStartX", "", "initialIndicatorX", "initialTouchX", "isBeingDragged", "isDragging", "lastTouchX", "mHorizontalSpace", "mItemSpace", "mSelectColor", "mSelectedBackgroundColor", "mSelectedBackgroundColorA", "mSelectedBackgroundColorRGB", "mUnSelectColor", "mWhichSearchMode", "maxItemWidth", "maxTotalWidth", "onTabSelectedListener", "Lcom/transsion/widgetsliquid/view/OSLiquidFootOperationBar$OnTabSelectedListener;", "originalWidth", "savedItemPositions", "", "savedItemPositionsP", "searchModeAnimator", "selectedPosition", "singleItemWidth", "swipeEnabled", "tabContainer", "Lcom/transsion/widgetsliquid/view/OSLiquidFobItemContainer;", "tabItems", "Lcom/transsion/widgetsliquid/view/OSLiquidFootOperationBar$TabItem;", "tabTextHeight", "touchSlop", "addAllTabs", "", "iconArr", "", "titleArr", "", "([Ljava/lang/Integer;[Ljava/lang/String;)V", "addTab", "iconRes", "title", "animateContainerWidth", "targetWidth", "enterSearch", "isIconMode", "animateFromWhichSearchMode", "animateToSearchMode", "applyUniformWidth", "width", "calculateRequiredWidth", "createSelectedBackground", "Landroid/graphics/drawable/GradientDrawable;", "createTabView", "Landroid/view/View;", "position", "dispatchTouchEvent", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "enterSearchMode", "animated", "fromState", "toSearchMode", "exitSearchMode", "forceState", "iconMode", "toState", "findTabAtPosition", "x", "y", "getCurrentIndicatorX", "getCurrentSearchMode", "getEventPosition", "getEventPositionX", "getInitHeight", "getItemCenterX", "getSelectPosition", "getSelectedPosition", "getSingleItemWidth", "getTabCount", "iconModeIndicatorAnim", "progress", "diff", "selectedChild", "iconModeItemAnim", "iconHeight", "iconModeHeight", "isInSearchMode", "measureTabItems", "onDetachedFromWindow", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onRestoreInstanceState", "state", "Landroid/os/Parcelable;", "onSaveInstanceState", "onVisibilityAggregated", "isVisible", "positionAssert", "eventPosition", "removeTab", "selectTab", "animatable", "(ILjava/lang/Boolean;)V", "selectTabWithoutNotify", "setLayoutParams", "params", "Landroid/view/ViewGroup$LayoutParams;", "setOnTabSelectedListener", "listener", "setSelectColor", "selectColor", "setSwipeEnabled", "enabled", "setTabShowBadge", "show", "setUnSelectColor", "unSelectColor", "startPressAnimation", "hostView", "stopPressAnimation", "toSearchModeWithoutAnimSearchMode", "updateSearchIconMode", "value", "updateSearchMode", "updateTab", "updateTabAppearance", "tabView", "isSelected", "updateTabSelection", "updateTabWeights", "Companion", "LiquidSearchBarSavedState", "OnTabSelectedListener", "TabItem", "widgetsliquid_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nOSLiquidFootOperationBar.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OSLiquidFootOperationBar.kt\ncom/transsion/widgetsliquid/view/OSLiquidFootOperationBar\n+ 2 ContextFunc.kt\ncom/transsion/widgetslib/util/ContextFuncKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1426:1\n13#2,9:1427\n13#2,9:1436\n13644#3,3:1445\n13694#3,3:1482\n1306#4,3:1448\n1306#4,3:1451\n1295#4,2:1457\n1306#4,3:1459\n205#4,8:1462\n1306#4,3:1470\n1306#4,3:1473\n1864#5,3:1454\n1864#5,3:1476\n1864#5,3:1479\n*S KotlinDebug\n*F\n+ 1 OSLiquidFootOperationBar.kt\ncom/transsion/widgetsliquid/view/OSLiquidFootOperationBar\n*L\n120#1:1427,9\n148#1:1436,9\n198#1:1445,3\n1301#1:1482,3\n299#1:1448,3\n325#1:1451,3\n470#1:1457,2\n497#1:1459,3\n626#1:1462,8\n905#1:1470,3\n961#1:1473,3\n382#1:1454,3\n1071#1:1476,3\n1164#1:1479,3\n*E\n"})
public class OSLiquidFootOperationBar extends OSLiquidContainerRootLayout {
    private static final long ANIMATION_DURATION = 200;
    private static final float ANIMATION_START_PRESS_DAMPING_RATIO = 0.99f;
    private static final float ANIMATION_START_PRESS_STIFFNESS = 250.0f;
    private static final float ANIMATION_STOP_PRESS_DAMPING_RATIO = 0.4f;
    private static final float ANIMATION_STOP_PRESS_STIFFNESS = 250.0f;
    private static final int HEIGHT_DP = 60;
    private static final int ICON_SIZE = 24;
    private static final int MAX_ITEM_WIDTH = 150;
    private static final int PAD_HEIGHT_DP = 48;
    private static final int PAD_SCREEN_PADDING = 40;
    private static final float SCALE_FACTOR_NORMAL = 1.0f;
    private static final float SCALE_FACTOR_PRESSED = 1.02f;
    private static final float SEARCH_MODE_DAMPING_RATIO = 0.75f;
    private static final float SEARCH_MODE_STIFFNESS = 300.0f;
    private static final float SNAP_THRESHOLD = 20.0f;
    private static final int TAB_PADDING_HORIZONTAL = 16;
    private static final int TAB_PADDING_VERTICAL = 12;
    private static final String TAG = "OSLiquidFootOper";
    private static final int TEXT_HEIGHT = 14;
    private static final float TEXT_SIZE = 10.0f;
    private static final float TEXT_SIZE_LARGE = 12.0f;
    private SpringAnimation currentScaleAnimator;
    private boolean downOnCurrentItem;
    private float dragStartX;
    private float initialIndicatorX;
    private float initialTouchX;
    private boolean isBeingDragged;
    private boolean isDragging;
    private float lastTouchX;
    private int mHorizontalSpace;
    private int mItemSpace;
    private int mSelectColor;
    private int mSelectedBackgroundColor;
    private int mSelectedBackgroundColorA;
    private int mSelectedBackgroundColorRGB;
    private int mUnSelectColor;
    private int mWhichSearchMode;
    private int maxItemWidth;
    private int maxTotalWidth;
    private OnTabSelectedListener onTabSelectedListener;
    private int originalWidth;
    private List<Float> savedItemPositions;
    private List<Float> savedItemPositionsP;
    private SpringAnimation searchModeAnimator;
    private int selectedPosition;
    private int singleItemWidth;
    private boolean swipeEnabled;
    private final OSLiquidFobItemContainer tabContainer;
    private final List<TabItem> tabItems;
    private float tabTextHeight;
    private int touchSlop;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/transsion/widgetsliquid/view/OSLiquidFootOperationBar$OnTabSelectedListener;", "", "onTabSelected", "", "position", "", "widgetsliquid_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface OnTabSelectedListener {
        void onTabSelected(int position);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSLiquidFootOperationBar(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addAllTabs$lambda$6(OSLiquidFootOperationBar this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        OSLiquidFobItemContainer oSLiquidFobItemContainer = this$0.tabContainer;
        Boolean bool = Boolean.FALSE;
        oSLiquidFobItemContainer.setSelectedPosition(0, bool);
        this$0.tabContainer.updateBackgroundPosition(bool);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addTab$lambda$7(OSLiquidFootOperationBar this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        OSLiquidFobItemContainer oSLiquidFobItemContainer = this$0.tabContainer;
        Boolean bool = Boolean.FALSE;
        oSLiquidFobItemContainer.setSelectedPosition(0, bool);
        this$0.tabContainer.updateBackgroundPosition(bool);
    }

    private final void animateContainerWidth(final int targetWidth, final boolean enterSearch, final boolean isIconMode) {
        SpringAnimation springAnimation = this.searchModeAnimator;
        if (springAnimation != null) {
            springAnimation.cancel();
        }
        setVisibility(0);
        setClipChildren(true);
        final int iA = this.originalWidth;
        if (targetWidth == iA) {
            if (isIconMode) {
                Context context = getContext();
                String[] strArr = j.f8764a;
                iA = a.a(context, 44);
            } else {
                iA = this.singleItemWidth;
            }
        }
        SpringAnimation springAnimation2 = new SpringAnimation(new FloatValueHolder());
        springAnimation2.setSpring(new SpringForce());
        springAnimation2.getSpring().setStiffness(300.0f);
        springAnimation2.getSpring().setDampingRatio(0.75f);
        springAnimation2.setStartValue(iA);
        final View view = this.tabItems.get(this.selectedPosition).getView();
        final int i8 = iA;
        springAnimation2.addUpdateListener(new DynamicAnimation.OnAnimationUpdateListener() { // from class: je.g
            @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
            public final void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f4) {
                OSLiquidFootOperationBar.animateContainerWidth$lambda$42$lambda$40(i8, targetWidth, isIconMode, this, enterSearch, view, dynamicAnimation, f, f4);
            }
        });
        springAnimation2.addEndListener(new DynamicAnimation.OnAnimationEndListener() { // from class: je.h
            @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
            public final void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z2, float f, float f4) {
                OSLiquidFootOperationBar.animateContainerWidth$lambda$42$lambda$41(iA, targetWidth, isIconMode, this, dynamicAnimation, z2, f, f4);
            }
        });
        springAnimation2.animateToFinalPosition(targetWidth);
        this.searchModeAnimator = springAnimation2;
    }

    public static /* synthetic */ void animateContainerWidth$default(OSLiquidFootOperationBar oSLiquidFootOperationBar, int i8, boolean z2, boolean z3, int i9, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateContainerWidth");
        }
        if ((i9 & 4) != 0) {
            z3 = false;
        }
        oSLiquidFootOperationBar.animateContainerWidth(i8, z2, z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateContainerWidth$lambda$42$lambda$40(int i8, int i9, boolean z2, OSLiquidFootOperationBar this$0, boolean z3, View selectedChild, DynamicAnimation dynamicAnimation, float f, float f4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(selectedChild, "$selectedChild");
        int i10 = i8 - i9;
        float fAbs = Math.abs((i8 - f) / i10);
        if (z2) {
            this$0.updateSearchIconMode(f, z3, fAbs, selectedChild, i10);
        } else {
            this$0.updateSearchMode(f, z3, fAbs, selectedChild, i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateContainerWidth$lambda$42$lambda$41(int i8, int i9, boolean z2, OSLiquidFootOperationBar this$0, DynamicAnimation dynamicAnimation, boolean z3, float f, float f4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i10 = i8 - i9;
        if (!z2) {
            this$0.setVisibility(i10 > 0 ? 8 : 0);
        }
        this$0.setClipChildren(false);
    }

    private final void animateFromWhichSearchMode(boolean isIconMode) {
        animateContainerWidth(this.originalWidth, false, isIconMode);
    }

    public static /* synthetic */ void animateFromWhichSearchMode$default(OSLiquidFootOperationBar oSLiquidFootOperationBar, boolean z2, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateFromWhichSearchMode");
        }
        if ((i8 & 1) != 0) {
            z2 = false;
        }
        oSLiquidFootOperationBar.animateFromWhichSearchMode(z2);
    }

    private final void animateToSearchMode(boolean isIconMode, int mWhichSearchMode) {
        int iA;
        int i8;
        int i9;
        this.mWhichSearchMode = mWhichSearchMode;
        int measuredWidth = this.originalWidth;
        if (measuredWidth <= 0) {
            measuredWidth = getMeasuredWidth();
        }
        this.originalWidth = measuredWidth;
        this.singleItemWidth = getSingleItemWidth(measuredWidth);
        this.savedItemPositions.clear();
        this.savedItemPositionsP.clear();
        int i10 = 0;
        for (View view : ViewGroupKt.getChildren(this.tabContainer)) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            View view2 = view;
            TabItem tabItem = this.tabItems.get(i10);
            if (j.v()) {
                int size = this.tabItems.size() - i10;
                i8 = (this.mItemSpace * size) + (this.singleItemWidth * (size - 1));
            } else {
                i8 = (this.mItemSpace * i11) + (this.singleItemWidth * i10);
            }
            tabItem.setX(i8);
            if (j.v()) {
                i9 = (this.mItemSpace * i11) + (this.singleItemWidth * i10);
            } else {
                int size2 = this.tabItems.size() - i10;
                i9 = (this.mItemSpace * size2) + (this.singleItemWidth * (size2 - 1));
            }
            float f = i9;
            TabItem tabItem2 = this.tabItems.get(i10);
            Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type android.view.ViewGroup");
            tabItem2.setTextHeight(((ViewGroup) view2).getChildAt(1).getMeasuredHeight());
            this.savedItemPositions.add(Float.valueOf(this.tabItems.get(i10).getX()));
            this.savedItemPositionsP.add(Float.valueOf(f));
            i10 = i11;
        }
        if (isIconMode) {
            Context context = getContext();
            String[] strArr = j.f8764a;
            iA = a.a(context, 44);
        } else {
            iA = this.singleItemWidth;
        }
        animateContainerWidth(iA, true, isIconMode);
    }

    public static /* synthetic */ void animateToSearchMode$default(OSLiquidFootOperationBar oSLiquidFootOperationBar, boolean z2, int i8, int i9, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateToSearchMode");
        }
        if ((i9 & 1) != 0) {
            z2 = false;
        }
        oSLiquidFootOperationBar.animateToSearchMode(z2, i8);
    }

    private final void applyUniformWidth(int width) {
        int i8 = 0;
        for (View view : ViewGroupKt.getChildren(this.tabContainer)) {
            int i9 = i8 + 1;
            if (i8 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            View view2 = view;
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams2.width = width;
            layoutParams2.weight = 0.0f;
            if (this.tabContainer.getChildCount() == 1) {
                layoutParams2.setMarginStart(this.mItemSpace);
                layoutParams2.setMarginEnd(this.mItemSpace);
            } else if (i8 == 0) {
                layoutParams2.setMarginStart(this.mItemSpace);
                layoutParams2.setMarginEnd(0);
            } else if (i8 == this.tabContainer.getChildCount() - 1) {
                layoutParams2.setMarginStart(this.mItemSpace);
                layoutParams2.setMarginEnd(this.mItemSpace);
            } else {
                layoutParams2.setMarginStart(this.mItemSpace);
                layoutParams2.setMarginEnd(0);
            }
            view2.setLayoutParams(layoutParams2);
            i8 = i9;
        }
    }

    private final int calculateRequiredWidth() {
        if (this.tabItems.isEmpty()) {
            return 0;
        }
        return (this.tabItems.size() * this.singleItemWidth) + ((this.tabItems.size() + 1) * this.mItemSpace) + (this.mHorizontalSpace * 2);
    }

    private final GradientDrawable createSelectedBackground() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(this.mSelectedBackgroundColor);
        gradientDrawable.setAlpha(51);
        Context context = getContext();
        String[] strArr = j.f8764a;
        gradientDrawable.setCornerRadius(a.a(context, 30));
        return gradientDrawable;
    }

    private final View createTabView(int iconRes, String title, int position) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.getContext();
        boolean z2 = j.f8768g;
        linearLayout.setOrientation(!z2 ? 1 : 0);
        linearLayout.setGravity(17);
        linearLayout.setClickable(false);
        linearLayout.setFocusable(true);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        OSIconTextView oSIconTextView = new OSIconTextView(context, null, 0, 14);
        oSIconTextView.setText(iconRes);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a.a(oSIconTextView.getContext(), 24), a.a(oSIconTextView.getContext(), 24));
        oSIconTextView.getContext();
        if (z2) {
            layoutParams.setMarginEnd(a.a(oSIconTextView.getContext(), 4));
        } else {
            layoutParams.bottomMargin = a.a(oSIconTextView.getContext(), 1);
        }
        oSIconTextView.setLayoutParams(layoutParams);
        oSIconTextView.setTextColor(R.attr.os_icon_primary);
        oSIconTextView.setClickable(false);
        TextView textView = new TextView(getContext());
        textView.setText(title);
        textView.getContext();
        if (z2) {
            textView.setTextSize(1, TEXT_SIZE_LARGE);
        } else {
            textView.setTextSize(1, TEXT_SIZE);
        }
        textView.setGravity(17);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, a.a(textView.getContext(), 14)));
        textView.setTextColor(R.attr.os_icon_primary);
        textView.setMaxLines(1);
        textView.setTextAppearance(R.style.os_regular_fontweight);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        linearLayout.addView(oSIconTextView);
        linearLayout.addView(textView);
        return linearLayout;
    }

    public static /* synthetic */ void enterSearchMode$default(OSLiquidFootOperationBar oSLiquidFootOperationBar, boolean z2, int i8, boolean z3, int i9, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enterSearchMode");
        }
        if ((i10 & 1) != 0) {
            z2 = true;
        }
        if ((i10 & 2) != 0) {
            i8 = -1;
        }
        if ((i10 & 4) != 0) {
            z3 = false;
        }
        if ((i10 & 8) != 0) {
            i9 = -1;
        }
        oSLiquidFootOperationBar.enterSearchMode(z2, i8, z3, i9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enterSearchMode$lambda$35(OSLiquidFootOperationBar this$0, boolean z2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.animateFromWhichSearchMode(z2);
    }

    public static /* synthetic */ void exitSearchMode$default(OSLiquidFootOperationBar oSLiquidFootOperationBar, boolean z2, boolean z3, boolean z5, int i8, int i9, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: exitSearchMode");
        }
        if ((i9 & 1) != 0) {
            z2 = true;
        }
        if ((i9 & 2) != 0) {
            z3 = false;
        }
        if ((i9 & 4) != 0) {
            z5 = false;
        }
        oSLiquidFootOperationBar.exitSearchMode(z2, z3, z5, i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void exitSearchMode$lambda$36(OSLiquidFootOperationBar this$0, boolean z2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.animateFromWhichSearchMode(z2);
    }

    private final View findTabAtPosition(float x2, float y3) {
        if (this.tabItems.isEmpty()) {
            return null;
        }
        boolean z2 = getLayoutDirection() == 1;
        int i8 = this.mHorizontalSpace;
        if (z2) {
            i8 = -i8;
        }
        View view = this.tabItems.get(0).getView();
        View view2 = ((TabItem) a1.a.j(1, this.tabItems)).getView();
        if (!z2 ? x2 - i8 >= view.getLeft() - this.mItemSpace : x2 - i8 <= view.getRight() + this.mItemSpace) {
            return view;
        }
        if (!z2 ? x2 - i8 <= view2.getRight() + this.mItemSpace : x2 - i8 >= view2.getLeft() - this.mItemSpace) {
            return view2;
        }
        Iterator<TabItem> it = this.tabItems.iterator();
        while (it.hasNext()) {
            View view3 = it.next().getView();
            int right = (z2 ? view3.getRight() + this.mItemSpace : view3.getLeft() - this.mItemSpace) + i8;
            int left = (z2 ? view3.getLeft() - this.mItemSpace : view3.getRight() + this.mItemSpace) + i8;
            if (z2) {
                if (x2 <= right && x2 >= left) {
                    return view3;
                }
            } else if (x2 >= right && x2 <= left) {
                return view3;
            }
        }
        return null;
    }

    private final float getCurrentIndicatorX() {
        return this.tabContainer.getCurrentBackgroundLeft();
    }

    private final int getEventPosition(MotionEvent event) {
        View viewFindTabAtPosition = findTabAtPosition(event.getX(), event.getY());
        if (viewFindTabAtPosition == null) {
            return -1;
        }
        int i8 = 0;
        for (View view : ViewGroupKt.getChildren(this.tabContainer)) {
            if (i8 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (Intrinsics.areEqual(view, viewFindTabAtPosition)) {
                return i8;
            }
            i8++;
        }
        return -1;
    }

    private final float getEventPositionX(MotionEvent event) {
        View viewFindTabAtPosition = findTabAtPosition(event.getX(), event.getY());
        if (viewFindTabAtPosition != null) {
            return viewFindTabAtPosition.getX() - this.mItemSpace;
        }
        return 0.0f;
    }

    private final int getInitHeight() {
        getContext();
        return j.f8768g ? a.a(getContext(), 48) : a.a(getContext(), HEIGHT_DP);
    }

    private final int getItemCenterX(int position) {
        int singleItemWidth = getSingleItemWidth(getMeasuredWidth());
        int i8 = this.mHorizontalSpace;
        int i9 = this.mItemSpace;
        return (singleItemWidth / 2) + ((singleItemWidth + i9) * position) + i8 + i9;
    }

    private final int getSingleItemWidth(int width) {
        if (this.tabItems.isEmpty()) {
            return 0;
        }
        getContext();
        if (j.f8768g) {
            return this.singleItemWidth;
        }
        return (int) (((width - (this.mHorizontalSpace * 2)) - ((this.tabItems.size() + 1) * this.mItemSpace)) / this.tabItems.size());
    }

    private final void iconModeIndicatorAnim(boolean enterSearch, float progress, int diff, View selectedChild) {
        if (!enterSearch) {
            float f = 100;
            float f4 = f * 0.2f;
            float f10 = f * progress;
            if (f10 <= 20 + f4 && f10 >= f4) {
                this.tabContainer.setSelectedBackgroundColor((((int) (((progress - 0.2f) * this.mSelectedBackgroundColorA) * 5)) << 24) | this.mSelectedBackgroundColorRGB);
            } else if (f10 <= f4) {
                this.tabContainer.setSelectedBackgroundColor(0);
            } else {
                this.tabContainer.setSelectedBackgroundColor(this.mSelectedBackgroundColor);
            }
        } else if (100 * progress <= SNAP_THRESHOLD) {
            this.tabContainer.setSelectedBackgroundColor((((int) ((1 - (progress * 5)) * this.mSelectedBackgroundColorA)) << 24) | this.mSelectedBackgroundColorRGB);
        } else {
            this.tabContainer.setSelectedBackgroundColor(0);
        }
        float x2 = selectedChild.getX();
        OSLiquidFobItemContainer oSLiquidFobItemContainer = this.tabContainer;
        int i8 = this.singleItemWidth;
        Context context = getContext();
        String[] strArr = j.f8764a;
        oSLiquidFobItemContainer.setIndicatorWidth(a.a(context, 16) + i8, x2 - this.mItemSpace);
    }

    private final void iconModeItemAnim(boolean enterSearch, int iconHeight, float progress, int iconModeHeight) {
        float f;
        float f4;
        int i8;
        float f10 = 100 * progress;
        int i9 = 0;
        for (Object obj : this.tabItems) {
            int i10 = i9 + 1;
            if (i9 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            TabItem tabItem = (TabItem) obj;
            if (i9 == this.selectedPosition) {
                ViewGroup.LayoutParams layoutParams = tabItem.getView().getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                layoutParams2.weight = 0.0f;
                if (enterSearch) {
                    int i11 = this.singleItemWidth;
                    f = i11 - ((i11 - iconHeight) * progress);
                } else {
                    f = ((this.singleItemWidth - iconHeight) * progress) + iconHeight;
                }
                layoutParams2.width = (int) f;
                float f11 = ((iconModeHeight - iconHeight) / 2.0f) - this.mHorizontalSpace;
                float x2 = tabItem.getX() - f11;
                if (enterSearch) {
                    tabItem.getView().setX(tabItem.getX() - (x2 * progress));
                } else {
                    tabItem.getView().setX((x2 * progress) + f11);
                }
                TextView titleView = tabItem.getTitleView();
                if (f10 <= SNAP_THRESHOLD) {
                    titleView.setAlpha(enterSearch ? 1 - (5 * progress) : 5 * progress);
                } else {
                    titleView.setAlpha(enterSearch ? 0.0f : 1.0f);
                }
                if (f10 <= SNAP_THRESHOLD) {
                    ViewGroup.LayoutParams layoutParams3 = titleView.getLayoutParams();
                    if (enterSearch) {
                        if (this.mWhichSearchMode == 5) {
                            i8 = 0;
                        } else {
                            float f12 = this.tabTextHeight;
                            f4 = f12 - ((f12 * progress) * 5);
                        }
                        layoutParams3.height = i8;
                        titleView.setLayoutParams(layoutParams3);
                    } else {
                        f4 = this.tabTextHeight * progress * 5;
                    }
                    i8 = (int) f4;
                    layoutParams3.height = i8;
                    titleView.setLayoutParams(layoutParams3);
                } else {
                    ViewGroup.LayoutParams layoutParams4 = titleView.getLayoutParams();
                    layoutParams4.height = enterSearch ? 0 : (int) this.tabTextHeight;
                    titleView.setLayoutParams(layoutParams4);
                }
                tabItem.getView().setAlpha(1.0f);
            } else {
                ViewGroup.LayoutParams layoutParams5 = tabItem.getView().getLayoutParams();
                Intrinsics.checkNotNull(layoutParams5, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) layoutParams5;
                layoutParams6.width = this.singleItemWidth;
                layoutParams6.weight = 0.0f;
                if (enterSearch) {
                    tabItem.getView().setX(tabItem.getX() - ((tabItem.getX() - this.mItemSpace) * progress));
                } else {
                    View view = tabItem.getView();
                    float x8 = tabItem.getX();
                    int i12 = this.mItemSpace;
                    view.setX(((x8 - i12) * progress) + i12);
                }
                if (enterSearch) {
                    if (f10 <= SNAP_THRESHOLD) {
                        tabItem.getView().setAlpha(1 - (5 * progress));
                    } else {
                        tabItem.getView().setAlpha(0.0f);
                    }
                } else if (f10 > 20 + SNAP_THRESHOLD || f10 < SNAP_THRESHOLD) {
                    tabItem.getView().setAlpha(f10 <= SNAP_THRESHOLD ? 0.0f : 1.0f);
                } else {
                    tabItem.getView().setAlpha((progress - 0.2f) * 5);
                }
            }
            i9 = i10;
        }
    }

    private final void measureTabItems() {
        if (this.maxItemWidth == 0) {
            Context context = getContext();
            String[] strArr = j.f8764a;
            this.maxItemWidth = a.a(context, MAX_ITEM_WIDTH);
        }
        if (this.maxTotalWidth == 0) {
            this.maxTotalWidth = j.k(getContext()) - a.a(getContext(), 40);
        }
        int i8 = 0;
        for (View view : ViewGroupKt.getChildren(this.tabContainer)) {
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            int measuredWidth = (this.mHorizontalSpace * 2) + view.getMeasuredWidth() + this.mItemSpace;
            if (measuredWidth > i8) {
                i8 = measuredWidth;
            }
        }
        this.singleItemWidth = Math.min(i8, this.maxItemWidth);
        if (!this.tabItems.isEmpty()) {
            int size = this.tabItems.size() * this.singleItemWidth;
            int i9 = this.maxTotalWidth;
            if (size > i9) {
                this.singleItemWidth = (int) (((i9 - (this.mHorizontalSpace * 2)) - ((this.tabItems.size() + 1) * this.mItemSpace)) / this.tabItems.size());
            }
        }
        applyUniformWidth(this.singleItemWidth);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onVisibilityAggregated$lambda$34(OSLiquidFootOperationBar this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.tabContainer.updateBackgroundPosition(Boolean.FALSE);
    }

    private final boolean positionAssert(int eventPosition) {
        return eventPosition >= 0 && eventPosition < this.tabItems.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeTab$lambda$33(OSLiquidFootOperationBar this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.updateTabSelection(this$0.selectedPosition);
        this$0.tabContainer.setSelectedPosition(this$0.selectedPosition, Boolean.TRUE);
        this$0.tabContainer.updateBackgroundPosition(Boolean.FALSE);
    }

    public static /* synthetic */ void selectTab$default(OSLiquidFootOperationBar oSLiquidFootOperationBar, int i8, Boolean bool, int i9, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectTab");
        }
        if ((i9 & 2) != 0) {
            bool = Boolean.TRUE;
        }
        oSLiquidFootOperationBar.selectTab(i8, bool);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void selectTab$lambda$16(OSLiquidFootOperationBar this$0, int i8, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.tabContainer.setSelectedPosition(i8, bool);
    }

    public static /* synthetic */ void selectTabWithoutNotify$default(OSLiquidFootOperationBar oSLiquidFootOperationBar, int i8, Boolean bool, int i9, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectTabWithoutNotify");
        }
        if ((i9 & 2) != 0) {
            bool = Boolean.TRUE;
        }
        oSLiquidFootOperationBar.selectTabWithoutNotify(i8, bool);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void selectTabWithoutNotify$lambda$17(OSLiquidFootOperationBar this$0, int i8, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.tabContainer.setSelectedPosition(i8, bool);
    }

    private final void startPressAnimation(View hostView) {
        SpringAnimation springAnimation = this.currentScaleAnimator;
        if (springAnimation != null) {
            springAnimation.cancel();
        }
        SpringAnimation springAnimation2 = new SpringAnimation(this, DynamicAnimation.SCALE_X);
        SpringForce springForce = new SpringForce();
        springForce.setStiffness(250.0f);
        springForce.setDampingRatio(ANIMATION_START_PRESS_DAMPING_RATIO);
        springForce.setFinalPosition(1.05f);
        springAnimation2.setSpring(springForce);
        springAnimation2.addUpdateListener(new c(1, hostView));
        springAnimation2.start();
        this.currentScaleAnimator = springAnimation2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startPressAnimation$lambda$28$lambda$27(View hostView, DynamicAnimation dynamicAnimation, float f, float f4) {
        Intrinsics.checkNotNullParameter(hostView, "$hostView");
        hostView.setScaleY(f);
    }

    private final void stopPressAnimation(View hostView) {
        SpringAnimation springAnimation = this.currentScaleAnimator;
        if (springAnimation != null) {
            springAnimation.cancel();
        }
        SpringAnimation springAnimation2 = new SpringAnimation(this, DynamicAnimation.SCALE_X);
        SpringForce springForce = new SpringForce();
        springForce.setStiffness(250.0f);
        springForce.setDampingRatio(ANIMATION_STOP_PRESS_DAMPING_RATIO);
        springForce.setFinalPosition(1.0f);
        springAnimation2.setSpring(springForce);
        springAnimation2.addUpdateListener(new c(0, hostView));
        springAnimation2.start();
        this.currentScaleAnimator = springAnimation2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void stopPressAnimation$lambda$31$lambda$30(View hostView, DynamicAnimation dynamicAnimation, float f, float f4) {
        Intrinsics.checkNotNullParameter(hostView, "$hostView");
        hostView.setScaleY(f);
    }

    private final void toSearchModeWithoutAnimSearchMode(int fromState, int mWhichSearchMode) {
        int i8;
        int i9;
        this.mWhichSearchMode = mWhichSearchMode;
        int measuredWidth = this.originalWidth;
        if (measuredWidth <= 0) {
            measuredWidth = getMeasuredWidth();
        }
        this.originalWidth = measuredWidth;
        this.singleItemWidth = getSingleItemWidth(measuredWidth);
        SpringAnimation springAnimation = this.searchModeAnimator;
        if (springAnimation != null) {
            springAnimation.cancel();
        }
        int i10 = 0;
        setVisibility(0);
        setClipChildren(true);
        Context context = getContext();
        String[] strArr = j.f8764a;
        int iA = a.a(context, 44);
        View view = this.tabItems.get(this.selectedPosition).getView();
        int iA2 = a.a(getContext(), 44);
        int iA3 = a.a(getContext(), 24);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = iA2;
        layoutParams.width = iA;
        setLayoutParams(layoutParams);
        iconModeItemAnim(true, iA3, 0.0f, iA2);
        iconModeIndicatorAnim(true, 1.0f, 0, view);
        this.savedItemPositions.clear();
        this.savedItemPositionsP.clear();
        for (View view2 : ViewGroupKt.getChildren(this.tabContainer)) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            TabItem tabItem = this.tabItems.get(i10);
            if (j.v()) {
                int size = this.tabItems.size() - i10;
                i8 = (this.mItemSpace * size) + (this.singleItemWidth * (size - 1));
            } else {
                i8 = (this.mItemSpace * i11) + (this.singleItemWidth * i10);
            }
            tabItem.setX(i8);
            if (j.v()) {
                i9 = (this.mItemSpace * i11) + (this.singleItemWidth * i10);
            } else {
                int size2 = this.tabItems.size() - i10;
                i9 = (this.mItemSpace * size2) + (this.singleItemWidth * (size2 - 1));
            }
            float f = i9;
            this.savedItemPositions.add(Float.valueOf(this.tabItems.get(i10).getX()));
            this.savedItemPositionsP.add(Float.valueOf(f));
            i10 = i11;
        }
    }

    private final void updateSearchIconMode(float value, boolean enterSearch, float progress, View selectedChild, int diff) {
        int i8;
        int initHeight = getInitHeight();
        Context context = getContext();
        String[] strArr = j.f8764a;
        int iA = a.a(context, 44);
        int iA2 = a.a(getContext(), 24);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (enterSearch) {
            i8 = (int) (initHeight - ((initHeight - iA) * progress));
        } else {
            i8 = (int) (((initHeight - iA) * progress) + iA);
        }
        layoutParams.height = i8;
        layoutParams.width = (int) value;
        setLayoutParams(layoutParams);
        iconModeItemAnim(enterSearch, iA2, progress, iA);
        iconModeIndicatorAnim(enterSearch, progress, diff, selectedChild);
    }

    private final void updateSearchMode(float value, boolean enterSearch, float progress, View selectedChild, int diff) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = (int) value;
        setLayoutParams(layoutParams);
        int i8 = 0;
        for (Object obj : this.tabItems) {
            int i9 = i8 + 1;
            if (i8 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            TabItem tabItem = (TabItem) obj;
            ViewGroup.LayoutParams layoutParams2 = tabItem.getView().getLayoutParams();
            Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams2;
            layoutParams3.width = this.singleItemWidth;
            layoutParams3.weight = 0.0f;
            if (enterSearch) {
                tabItem.getView().setX(tabItem.getX() - ((tabItem.getX() - this.mItemSpace) * progress));
            } else {
                View view = tabItem.getView();
                float x2 = tabItem.getX();
                int i10 = this.mItemSpace;
                view.setX(((x2 - i10) * progress) + i10);
            }
            i8 = i9;
        }
        float x8 = selectedChild.getX();
        OSLiquidFobItemContainer oSLiquidFobItemContainer = this.tabContainer;
        int i11 = this.singleItemWidth;
        Context context = getContext();
        String[] strArr = j.f8764a;
        oSLiquidFobItemContainer.setIndicatorWidth(a.a(context, 16) + i11, x8 - this.mItemSpace);
        if (diff > 0) {
            progress = 1 - progress;
        }
        setAlpha(progress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateTab$lambda$32(OSLiquidFootOperationBar this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.tabContainer.updateBackgroundPosition(Boolean.FALSE);
    }

    private final void updateTabAppearance(TabItem tabView, boolean isSelected) {
        OSIconTextView iconView = tabView.getIconView();
        TextView titleView = tabView.getTitleView();
        if (isSelected) {
            titleView.setTextColor(this.mUnSelectColor);
            iconView.setTextColor(this.mUnSelectColor);
            titleView.setTextAppearance(R.style.os_semibold_font);
        } else {
            titleView.setTextColor(this.mUnSelectColor);
            iconView.setTextColor(this.mUnSelectColor);
            titleView.setTextAppearance(R.style.os_regular_fontweight);
        }
    }

    private final void updateTabSelection(int position) {
        int i8 = 0;
        for (Object obj : this.tabItems) {
            int i9 = i8 + 1;
            if (i8 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            updateTabAppearance((TabItem) obj, i8 == position);
            i8 = i9;
        }
    }

    private final void updateTabWeights() {
        getContext();
        if (j.f8768g) {
            int i8 = 0;
            for (View view : ViewGroupKt.getChildren(this.tabContainer)) {
                int i9 = i8 + 1;
                if (i8 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                View view2 = view;
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                layoutParams2.width = -2;
                layoutParams2.weight = 0.0f;
                if (this.tabContainer.getChildCount() <= 1) {
                    layoutParams2.setMarginStart(this.mItemSpace);
                    layoutParams2.setMarginEnd(this.mItemSpace);
                } else if (i8 != this.tabContainer.getChildCount() - 1) {
                    layoutParams2.setMarginStart(this.mItemSpace);
                    layoutParams2.setMarginEnd(0);
                } else {
                    layoutParams2.setMarginEnd(this.mItemSpace);
                    layoutParams2.setMarginStart(this.mItemSpace);
                }
                view2.setLayoutParams(layoutParams2);
                i8 = i9;
            }
            requestLayout();
            return;
        }
        float size = 1.0f / this.tabItems.size();
        int i10 = 0;
        for (View view3 : ViewGroupKt.getChildren(this.tabContainer)) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            View view4 = view3;
            ViewGroup.LayoutParams layoutParams3 = view4.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) layoutParams3;
            layoutParams4.weight = size;
            layoutParams4.width = 0;
            if (this.tabContainer.getChildCount() <= 1) {
                layoutParams4.setMarginStart(this.mItemSpace);
                layoutParams4.setMarginEnd(this.mItemSpace);
            } else if (i10 != this.tabContainer.getChildCount() - 1) {
                layoutParams4.setMarginStart(this.mItemSpace);
                layoutParams4.setMarginEnd(0);
            } else {
                layoutParams4.setMarginEnd(this.mItemSpace);
                layoutParams4.setMarginStart(this.mItemSpace);
            }
            view4.setLayoutParams(layoutParams4);
            i10 = i11;
        }
    }

    public final void addAllTabs(Integer[] iconArr, String[] titleArr) {
        Intrinsics.checkNotNullParameter(iconArr, "iconArr");
        Intrinsics.checkNotNullParameter(titleArr, "titleArr");
        if (iconArr.length != 0 && iconArr.length == titleArr.length) {
            this.tabItems.clear();
            this.tabContainer.removeAllViews();
            int length = iconArr.length;
            int i8 = 0;
            int i9 = 0;
            while (i8 < length) {
                iconArr[i8].intValue();
                addTab(iconArr[i9].intValue(), titleArr[i9]);
                i8++;
                i9++;
            }
            getContext();
            if (j.f8768g) {
                updateTabWeights();
                updateTabSelection(0);
                this.tabContainer.post(new e(this, 2));
            }
        }
    }

    public final void addTab(@StringRes int iconRes, String title) {
        float dimension;
        Intrinsics.checkNotNullParameter(title, "title");
        View viewCreateTabView = createTabView(iconRes, title, this.tabItems.size());
        this.tabItems.add(new TabItem(iconRes, title, viewCreateTabView, 0.0f, 0.0f, 0.0f, false, false, 248, null));
        this.tabContainer.addView(viewCreateTabView);
        updateTabWeights();
        updateTabSelection(0);
        this.tabContainer.post(new e(this, 4));
        if (this.tabItems.size() == 2) {
            dimension = getContext().getResources().getDimension(R.dimen.os_liquid_fob_two_item_total_width);
        } else if (this.tabItems.size() == 3) {
            dimension = getContext().getResources().getDimension(R.dimen.os_liquid_fob_three_item_total_width);
        } else {
            dimension = this.tabItems.size() == 4 ? getContext().getResources().getDimension(R.dimen.os_liquid_fob_four_item_total_width) : getContext().getResources().getDimension(R.dimen.os_liquid_fob_five_item_total_width);
        }
        this.originalWidth = (int) dimension;
        Context context = getContext();
        String[] strArr = j.f8764a;
        this.tabTextHeight = a.a(context, 14);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!this.swipeEnabled) {
            return super.dispatchTouchEvent(event);
        }
        int action = event.getAction();
        boolean z2 = false;
        if (action == 0) {
            if (this.mWhichSearchMode != 2) {
                this.dragStartX = event.getX();
                this.isDragging = false;
                int eventPosition = getEventPosition(event);
                if (positionAssert(eventPosition) && eventPosition == this.selectedPosition) {
                    z2 = true;
                }
                this.downOnCurrentItem = z2;
                if (z2) {
                    this.initialIndicatorX = getCurrentIndicatorX();
                } else {
                    float eventPositionX = getEventPositionX(event);
                    this.tabContainer.animateToFinalPosition(eventPositionX);
                    this.initialIndicatorX = eventPositionX;
                }
            }
            startPressAnimation(this);
            return true;
        }
        if (action != 1) {
            if (action == 2) {
                if (this.mWhichSearchMode == 2) {
                    return true;
                }
                float x2 = event.getX() - this.dragStartX;
                float fAbs = Math.abs(x2);
                if (!this.isDragging && fAbs > this.touchSlop) {
                    this.isDragging = true;
                }
                if (this.isDragging) {
                    this.tabContainer.animateToFinalPosition(RangesKt___RangesKt.coerceIn(this.initialIndicatorX + x2, 0.0f, (this.tabContainer.getMeasuredWidth() - getSingleItemWidth(getMeasuredWidth())) - (this.mItemSpace * 2)));
                }
                return true;
            }
            if (action != 3) {
                return true;
            }
        }
        int i8 = this.mWhichSearchMode;
        if (i8 == 2) {
            exitSearchMode(true, false, true, i8);
            return true;
        }
        int eventPosition2 = getEventPosition(event);
        this.tabContainer.animateToFinalPosition(getEventPositionX(event));
        this.tabContainer.updFinalPosition(eventPosition2);
        boolean zPositionAssert = positionAssert(eventPosition2);
        if (isInSearchMode()) {
            OnTabSelectedListener onTabSelectedListener = this.onTabSelectedListener;
            if (onTabSelectedListener != null) {
                onTabSelectedListener.onTabSelected(this.selectedPosition);
            }
        } else if (zPositionAssert && this.selectedPosition != eventPosition2) {
            this.selectedPosition = eventPosition2;
            updateTabSelection(eventPosition2);
            OnTabSelectedListener onTabSelectedListener2 = this.onTabSelectedListener;
            if (onTabSelectedListener2 != null) {
                onTabSelectedListener2.onTabSelected(eventPosition2);
            }
        }
        this.isDragging = false;
        stopPressAnimation(this);
        return true;
    }

    public final void enterSearchMode(boolean animated, int fromState, boolean isIconMode, int toSearchMode) {
        this.mWhichSearchMode = toSearchMode;
        setVisibility(0);
        Log.i(TAG, "footbar enterSearchMode fromState: " + fromState + " toWhichSearchMode: " + this.mWhichSearchMode);
        if (toSearchMode == 3) {
            int i8 = this.mWhichSearchMode;
            if (i8 == -1 || i8 == toSearchMode || fromState == -1) {
                return;
            }
            post(new d(this, isIconMode, 0));
            return;
        }
        if (toSearchMode == 4) {
            setVisibility(8);
        } else {
            if (toSearchMode != 5) {
                return;
            }
            if (fromState == -1) {
                toSearchModeWithoutAnimSearchMode(fromState, this.mWhichSearchMode);
            } else {
                animateToSearchMode(isIconMode, this.mWhichSearchMode);
            }
        }
    }

    public final void exitSearchMode(boolean animated, boolean forceState, boolean iconMode, int toState) {
        Log.i(TAG, "exitSearchMode  iconMode " + iconMode + "   tostate: " + toState + " mFromSearchMode:" + this.mWhichSearchMode);
        int i8 = this.mWhichSearchMode;
        if (i8 == -1 || i8 == toState) {
            return;
        }
        setVisibility(0);
        if (animated) {
            post(new d(this, iconMode, 1));
        }
        this.mWhichSearchMode = -1;
    }

    /* JADX INFO: renamed from: getCurrentSearchMode, reason: from getter */
    public final int getMWhichSearchMode() {
        return this.mWhichSearchMode;
    }

    /* JADX INFO: renamed from: getSelectPosition, reason: from getter */
    public final int getSelectedPosition() {
        return this.selectedPosition;
    }

    public final int getSelectedPosition() {
        return this.selectedPosition;
    }

    public final int getTabCount() {
        return this.tabItems.size();
    }

    public final boolean isInSearchMode() {
        int i8 = this.mWhichSearchMode;
        return i8 == 1 || i8 == 5;
    }

    @Override // com.transsion.widgetslib.view.liquid.effect.OSLiquidContainerRootLayoutInner, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SpringAnimation springAnimation = this.currentScaleAnimator;
        if (springAnimation != null) {
            springAnimation.cancel();
        }
        this.currentScaleAnimator = null;
        SpringAnimation springAnimation2 = this.searchModeAnimator;
        if (springAnimation2 != null) {
            springAnimation2.cancel();
        }
        this.searchModeAnimator = null;
    }

    @Override // com.transsion.widgetslib.view.liquid.effect.OSLiquidContainerRootLayoutInner, android.widget.FrameLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int iA;
        getContext();
        if (!j.f8768g) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(a.a(getContext(), 48), BasicMeasure.EXACTLY);
        if (isInSearchMode()) {
            super.onMeasure(widthMeasureSpec, iMakeMeasureSpec);
            return;
        }
        if (this.tabItems.isEmpty() || this.tabContainer.getChildCount() <= 0) {
            super.onMeasure(widthMeasureSpec, iMakeMeasureSpec);
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            iA = marginLayoutParams.getMarginEnd() + marginLayoutParams.getMarginStart();
        } else {
            iA = a.a(getContext(), 40);
        }
        this.maxTotalWidth = j.k(getContext()) - iA;
        measureTabItems();
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(calculateRequiredWidth(), BasicMeasure.EXACTLY), iMakeMeasureSpec);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof LiquidSearchBarSavedState)) {
            super.onRestoreInstanceState(state);
            return;
        }
        LiquidSearchBarSavedState liquidSearchBarSavedState = (LiquidSearchBarSavedState) state;
        super.onRestoreInstanceState(liquidSearchBarSavedState.getSuperState());
        this.mWhichSearchMode = liquidSearchBarSavedState.getSearchMode();
        this.originalWidth = liquidSearchBarSavedState.getOriginWidth();
        this.singleItemWidth = liquidSearchBarSavedState.getSingleItemWidth();
        if (liquidSearchBarSavedState.getItemPositions().length == 0) {
            return;
        }
        this.savedItemPositions.clear();
        this.savedItemPositionsP.clear();
        this.savedItemPositions.addAll(ArraysKt.toList(liquidSearchBarSavedState.getItemPositions()));
        this.savedItemPositionsP.addAll(ArraysKt.toList(liquidSearchBarSavedState.getItemPositionsP()));
        float[] itemPositions = liquidSearchBarSavedState.getItemPositions();
        int length = itemPositions.length;
        int i8 = 0;
        int i9 = 0;
        while (i8 < length) {
            float f = itemPositions[i8];
            int i10 = i9 + 1;
            if (i9 < this.tabItems.size()) {
                if ((liquidSearchBarSavedState.getRtl() == 1) != j.v()) {
                    this.tabItems.get(i9).setX(liquidSearchBarSavedState.getItemPositionsP()[i9]);
                    liquidSearchBarSavedState.getItemPositionsP()[i9] = liquidSearchBarSavedState.getItemPositions()[i9];
                    liquidSearchBarSavedState.getItemPositions()[i9] = this.tabItems.get(i9).getX();
                } else {
                    this.tabItems.get(i9).setX(liquidSearchBarSavedState.getItemPositions()[i9]);
                }
                this.tabItems.get(i9).setMRtl(j.v());
                this.tabItems.get(i9).setTextHeight(liquidSearchBarSavedState.getTextHeight());
            }
            i8++;
            i9 = i10;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        LiquidSearchBarSavedState liquidSearchBarSavedState = new LiquidSearchBarSavedState(super.onSaveInstanceState());
        liquidSearchBarSavedState.setSearchMode(this.mWhichSearchMode);
        liquidSearchBarSavedState.setSelectedPosition(this.selectedPosition);
        liquidSearchBarSavedState.setOriginWidth(this.originalWidth);
        liquidSearchBarSavedState.setSingleItemWidth(this.singleItemWidth);
        liquidSearchBarSavedState.setItemPositions(CollectionsKt.toFloatArray(this.savedItemPositions));
        liquidSearchBarSavedState.setItemPositionsP(CollectionsKt.toFloatArray(this.savedItemPositionsP));
        liquidSearchBarSavedState.setRtl(j.v() ? 1 : 0);
        return liquidSearchBarSavedState;
    }

    @Override // android.view.View
    public void onVisibilityAggregated(boolean isVisible) {
        super.onVisibilityAggregated(isVisible);
        if (isVisible) {
            this.tabContainer.post(new e(this, 1));
        }
    }

    public final void removeTab(int position) {
        if (position < 0 || position >= this.tabItems.size() || this.tabItems.size() <= 1) {
            return;
        }
        this.tabContainer.removeView(this.tabItems.get(position).getView());
        this.tabItems.remove(position);
        updateTabWeights();
        int i8 = this.selectedPosition;
        if (position == i8 || i8 >= this.tabItems.size()) {
            this.selectedPosition = 0;
        } else {
            int i9 = this.selectedPosition;
            if (position < i9) {
                this.selectedPosition = i9 - 1;
            }
        }
        OnTabSelectedListener onTabSelectedListener = this.onTabSelectedListener;
        if (onTabSelectedListener != null) {
            onTabSelectedListener.onTabSelected(this.selectedPosition);
        }
        post(new e(this, 3));
    }

    public final void selectTab(int position, Boolean animatable) {
        OnTabSelectedListener onTabSelectedListener;
        if (position < 0 || position >= this.tabItems.size()) {
            return;
        }
        int i8 = this.selectedPosition;
        this.selectedPosition = position;
        updateTabSelection(position);
        this.tabContainer.post(new f(this, position, animatable, 0));
        if (i8 == position || (onTabSelectedListener = this.onTabSelectedListener) == null) {
            return;
        }
        onTabSelectedListener.onTabSelected(position);
    }

    public final void selectTabWithoutNotify(int position, Boolean animatable) {
        if (position < 0 || position >= this.tabItems.size()) {
            return;
        }
        updateTabSelection(position);
        this.tabContainer.post(new f(this, position, animatable, 1));
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams params) {
        if (params instanceof ViewGroup.MarginLayoutParams) {
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.os_space250);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) params;
            if (marginLayoutParams.getMarginStart() < dimensionPixelSize) {
                marginLayoutParams.setMarginStart(dimensionPixelSize);
            }
            if (marginLayoutParams.getMarginEnd() < dimensionPixelSize) {
                marginLayoutParams.setMarginEnd(dimensionPixelSize);
            }
        }
        super.setLayoutParams(params);
    }

    public final void setOnTabSelectedListener(OnTabSelectedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onTabSelectedListener = listener;
    }

    public final void setSelectColor(int selectColor) {
        if (this.mSelectColor != selectColor) {
            this.mSelectColor = selectColor;
            this.tabContainer.setSelectColor(selectColor);
            updateTabSelection(this.selectedPosition);
        }
    }

    public final void setSwipeEnabled(boolean enabled) {
        this.swipeEnabled = enabled;
    }

    public final void setTabShowBadge(int position, boolean show) {
        this.tabContainer.setItemShowBadge(position, show);
    }

    public final void setUnSelectColor(int unSelectColor) {
        if (this.mUnSelectColor != unSelectColor) {
            this.mUnSelectColor = unSelectColor;
            updateTabSelection(this.selectedPosition);
        }
    }

    public final void updateTab(int position, @StringRes int iconRes, String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        if (position < 0 || position >= this.tabItems.size()) {
            return;
        }
        View view = this.tabItems.get(position).getView();
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) view;
        View childAt = linearLayout.getChildAt(0);
        Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type com.transsion.widgetslib.widget.OSIconTextView");
        View childAt2 = linearLayout.getChildAt(1);
        Intrinsics.checkNotNull(childAt2, "null cannot be cast to non-null type android.widget.TextView");
        ((OSIconTextView) childAt).setText(iconRes);
        ((TextView) childAt2).setText(title);
        if (position == this.selectedPosition) {
            updateTabAppearance(this.tabItems.get(position), true);
        }
        this.tabContainer.post(new e(this, 0));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSLiquidFootOperationBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000 )2\u00020\u0001:\u0001)B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010&\u001a\u00020'2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0012H\u0016R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001a\u0010\u001a\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001a\u0010\u001d\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R\u001a\u0010 \u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016R\u001a\u0010#\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0014\"\u0004\b%\u0010\u0016¨\u0006*"}, d2 = {"Lcom/transsion/widgetsliquid/view/OSLiquidFootOperationBar$LiquidSearchBarSavedState;", "Landroid/view/AbsSavedState;", "superState", "Landroid/os/Parcelable;", "(Landroid/os/Parcelable;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "itemPositions", "", "getItemPositions", "()[F", "setItemPositions", "([F)V", "itemPositionsP", "getItemPositionsP", "setItemPositionsP", "originWidth", "", "getOriginWidth", "()I", "setOriginWidth", "(I)V", "rtl", "getRtl", "setRtl", "searchMode", "getSearchMode", "setSearchMode", "selectedPosition", "getSelectedPosition", "setSelectedPosition", "singleItemWidth", "getSingleItemWidth", "setSingleItemWidth", "textHeight", "getTextHeight", "setTextHeight", "writeToParcel", "", "flags", "CREATOR", "widgetsliquid_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class LiquidSearchBarSavedState extends AbsSavedState {

        /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private float[] itemPositions;
        private float[] itemPositionsP;
        private int originWidth;
        private int rtl;
        private int searchMode;
        private int selectedPosition;
        private int singleItemWidth;
        private int textHeight;

        /* JADX INFO: renamed from: com.transsion.widgetsliquid.view.OSLiquidFootOperationBar$LiquidSearchBarSavedState$CREATOR, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/transsion/widgetsliquid/view/OSLiquidFootOperationBar$LiquidSearchBarSavedState$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/transsion/widgetsliquid/view/OSLiquidFootOperationBar$LiquidSearchBarSavedState;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/transsion/widgetsliquid/view/OSLiquidFootOperationBar$LiquidSearchBarSavedState;", "widgetsliquid_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion implements Parcelable.Creator<LiquidSearchBarSavedState> {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public LiquidSearchBarSavedState createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new LiquidSearchBarSavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public LiquidSearchBarSavedState[] newArray(int size) {
                return new LiquidSearchBarSavedState[size];
            }
        }

        public LiquidSearchBarSavedState(Parcelable parcelable) {
            super(parcelable);
            this.itemPositions = new float[0];
            this.itemPositionsP = new float[0];
        }

        public final float[] getItemPositions() {
            return this.itemPositions;
        }

        public final float[] getItemPositionsP() {
            return this.itemPositionsP;
        }

        public final int getOriginWidth() {
            return this.originWidth;
        }

        public final int getRtl() {
            return this.rtl;
        }

        public final int getSearchMode() {
            return this.searchMode;
        }

        public final int getSelectedPosition() {
            return this.selectedPosition;
        }

        public final int getSingleItemWidth() {
            return this.singleItemWidth;
        }

        public final int getTextHeight() {
            return this.textHeight;
        }

        public final void setItemPositions(float[] fArr) {
            Intrinsics.checkNotNullParameter(fArr, "<set-?>");
            this.itemPositions = fArr;
        }

        public final void setItemPositionsP(float[] fArr) {
            Intrinsics.checkNotNullParameter(fArr, "<set-?>");
            this.itemPositionsP = fArr;
        }

        public final void setOriginWidth(int i8) {
            this.originWidth = i8;
        }

        public final void setRtl(int i8) {
            this.rtl = i8;
        }

        public final void setSearchMode(int i8) {
            this.searchMode = i8;
        }

        public final void setSelectedPosition(int i8) {
            this.selectedPosition = i8;
        }

        public final void setSingleItemWidth(int i8) {
            this.singleItemWidth = i8;
        }

        public final void setTextHeight(int i8) {
            this.textHeight = i8;
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            super.writeToParcel(parcel, flags);
            parcel.writeInt(this.searchMode);
            parcel.writeInt(this.selectedPosition);
            parcel.writeInt(this.originWidth);
            parcel.writeInt(this.singleItemWidth);
            parcel.writeFloatArray(this.itemPositions);
            parcel.writeFloatArray(this.itemPositionsP);
            parcel.writeInt(this.textHeight);
            parcel.writeInt(this.rtl);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LiquidSearchBarSavedState(Parcel parcel) {
            super(parcel);
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            this.itemPositions = new float[0];
            this.itemPositionsP = new float[0];
            this.searchMode = parcel.readInt();
            this.selectedPosition = parcel.readInt();
            this.originWidth = parcel.readInt();
            this.singleItemWidth = parcel.readInt();
            float[] fArrCreateFloatArray = parcel.createFloatArray();
            this.itemPositions = fArrCreateFloatArray == null ? new float[0] : fArrCreateFloatArray;
            float[] fArrCreateFloatArray2 = parcel.createFloatArray();
            this.itemPositionsP = fArrCreateFloatArray2 == null ? new float[0] : fArrCreateFloatArray2;
            this.textHeight = parcel.readInt();
            this.rtl = parcel.readInt();
        }
    }

    public /* synthetic */ OSLiquidFootOperationBar(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSLiquidFootOperationBar(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.checkNotNullParameter(context, "context");
        this.tabItems = new ArrayList();
        this.swipeEnabled = true;
        this.mWhichSearchMode = -1;
        this.savedItemPositions = new ArrayList();
        this.savedItemPositionsP = new ArrayList();
        int[] OSLiquidFootOperationBar = R.styleable.OSLiquidFootOperationBar;
        Intrinsics.checkNotNullExpressionValue(OSLiquidFootOperationBar, "OSLiquidFootOperationBar");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, OSLiquidFootOperationBar, 0, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        int i9 = R.styleable.OSLiquidFootOperationBar_os_liquid_fob_select_color;
        int i10 = R$attr.os_platform_basic_color;
        int i11 = R$color.os_platform_basic_color_hios;
        String[] strArr = j.f8764a;
        this.mSelectColor = typedArrayObtainStyledAttributes.getColor(i9, j.d(i10, context.getColor(i11), context));
        this.mUnSelectColor = typedArrayObtainStyledAttributes.getColor(R.styleable.OSLiquidFootOperationBar_os_liquid_fob_un_select_color, j.d(R.attr.os_icon_primary, context.getColor(R.color.os_icon_primary_hios), context));
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.OSLiquidFootOperationBar_os_liquid_fob_indicator_color, context.getColor(R.color.os_liquid_fob_indicator_color));
        this.mSelectedBackgroundColor = color;
        this.mSelectedBackgroundColorA = Color.alpha(color);
        this.mSelectedBackgroundColorRGB = this.mSelectedBackgroundColor & ViewCompat.MEASURED_SIZE_MASK;
        this.mItemSpace = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.OSLiquidFootOperationBar_os_liquid_fob_item_space, context.getResources().getDimensionPixelSize(R.dimen.os_space100));
        this.mHorizontalSpace = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.OSLiquidFootOperationBar_os_liquid_fob_horizontal_space, context.getResources().getDimensionPixelSize(R.dimen.os_space050));
        this.selectedPosition = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.OSLiquidFootOperationBar_os_liquid_fob_horizontal_default_select_position, 0);
        typedArrayObtainStyledAttributes.recycle();
        int[] OSLiquidContainer = R$styleable.OSLiquidContainer;
        Intrinsics.checkNotNullExpressionValue(OSLiquidContainer, "OSLiquidContainer");
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, OSLiquidContainer, 0, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes2, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        if (!typedArrayObtainStyledAttributes2.hasValue(R.styleable.OSLiquidContainer_os_liquid_mixlevel)) {
            setMixLevel(2);
        }
        typedArrayObtainStyledAttributes2.recycle();
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        OSLiquidFobItemContainer oSLiquidFobItemContainer = new OSLiquidFobItemContainer(context, null, 0, 6, null);
        oSLiquidFobItemContainer.setOrientation(0);
        oSLiquidFobItemContainer.setGravity(17);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.setMarginStart(this.mHorizontalSpace);
        layoutParams.setMarginEnd(this.mHorizontalSpace);
        oSLiquidFobItemContainer.setLayoutParams(layoutParams);
        oSLiquidFobItemContainer.setSelectedBackgroundColor(this.mSelectedBackgroundColor);
        oSLiquidFobItemContainer.setSelectColor(this.mSelectColor);
        this.tabContainer = oSLiquidFobItemContainer;
        addView(oSLiquidFobItemContainer);
        setScaleRatio(SCALE_FACTOR_PRESSED);
        detachPressAnim();
        setClipChildren(false);
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0002\u0010\u000fJ\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003J\t\u0010'\u001a\u00020\tHÆ\u0003J\t\u0010(\u001a\u00020\tHÆ\u0003J\t\u0010)\u001a\u00020\tHÆ\u0003J\t\u0010*\u001a\u00020\rHÆ\u0003J\t\u0010+\u001a\u00020\rHÆ\u0003JY\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\rHÆ\u0001J\u0013\u0010-\u001a\u00020\r2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010/\u001a\u000200J\u0006\u00101\u001a\u000202J\t\u00103\u001a\u00020\u0003HÖ\u0001J\t\u00104\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\n\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u000e\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001a\u0010\u000b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0017\"\u0004\b#\u0010\u0019¨\u00065"}, d2 = {"Lcom/transsion/widgetsliquid/view/OSLiquidFootOperationBar$TabItem;", "", "iconRes", "", "title", "", "view", "Landroid/view/View;", "x", "", "px", "textHeight", "mRtl", "", "showBadgeView", "(ILjava/lang/String;Landroid/view/View;FFFZZ)V", "getIconRes", "()I", "getMRtl", "()Z", "setMRtl", "(Z)V", "getPx", "()F", "setPx", "(F)V", "getShowBadgeView", "setShowBadgeView", "getTextHeight", "setTextHeight", "getTitle", "()Ljava/lang/String;", "getView", "()Landroid/view/View;", "getX", "setX", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "getIconView", "Lcom/transsion/widgetslib/widget/OSIconTextView;", "getTitleView", "Landroid/widget/TextView;", "hashCode", "toString", "widgetsliquid_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class TabItem {
        private final int iconRes;
        private boolean mRtl;
        private float px;
        private boolean showBadgeView;
        private float textHeight;
        private final String title;
        private final View view;
        private float x;

        public TabItem(int i8, String title, View view, float f, float f4, float f10, boolean z2, boolean z3) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(view, "view");
            this.iconRes = i8;
            this.title = title;
            this.view = view;
            this.x = f;
            this.px = f4;
            this.textHeight = f10;
            this.mRtl = z2;
            this.showBadgeView = z3;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getIconRes() {
            return this.iconRes;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final View getView() {
            return this.view;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final float getX() {
            return this.x;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final float getPx() {
            return this.px;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final float getTextHeight() {
            return this.textHeight;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final boolean getMRtl() {
            return this.mRtl;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final boolean getShowBadgeView() {
            return this.showBadgeView;
        }

        public final TabItem copy(int iconRes, String title, View view, float x2, float px, float textHeight, boolean mRtl, boolean showBadgeView) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(view, "view");
            return new TabItem(iconRes, title, view, x2, px, textHeight, mRtl, showBadgeView);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TabItem)) {
                return false;
            }
            TabItem tabItem = (TabItem) other;
            return this.iconRes == tabItem.iconRes && Intrinsics.areEqual(this.title, tabItem.title) && Intrinsics.areEqual(this.view, tabItem.view) && Float.compare(this.x, tabItem.x) == 0 && Float.compare(this.px, tabItem.px) == 0 && Float.compare(this.textHeight, tabItem.textHeight) == 0 && this.mRtl == tabItem.mRtl && this.showBadgeView == tabItem.showBadgeView;
        }

        public final int getIconRes() {
            return this.iconRes;
        }

        public final OSIconTextView getIconView() {
            View view = this.view;
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
            View childAt = ((ViewGroup) view).getChildAt(0);
            Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type com.transsion.widgetslib.widget.OSIconTextView");
            return (OSIconTextView) childAt;
        }

        public final boolean getMRtl() {
            return this.mRtl;
        }

        public final float getPx() {
            return this.px;
        }

        public final boolean getShowBadgeView() {
            return this.showBadgeView;
        }

        public final float getTextHeight() {
            return this.textHeight;
        }

        public final String getTitle() {
            return this.title;
        }

        public final TextView getTitleView() {
            View view = this.view;
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
            View childAt = ((ViewGroup) view).getChildAt(1);
            Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.widget.TextView");
            return (TextView) childAt;
        }

        public final View getView() {
            return this.view;
        }

        public final float getX() {
            return this.x;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v12, types: [int] */
        /* JADX WARN: Type inference failed for: r0v14, types: [int] */
        /* JADX WARN: Type inference failed for: r2v10, types: [int] */
        /* JADX WARN: Type inference failed for: r2v11 */
        /* JADX WARN: Type inference failed for: r2v12 */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1, types: [int] */
        /* JADX WARN: Type inference failed for: r3v2 */
        public int hashCode() {
            int iHashCode = (Float.hashCode(this.textHeight) + ((Float.hashCode(this.px) + ((Float.hashCode(this.x) + ((this.view.hashCode() + a1.a.e(Integer.hashCode(this.iconRes) * 31, 31, this.title)) * 31)) * 31)) * 31)) * 31;
            boolean z2 = this.mRtl;
            ?? r7 = z2;
            if (z2) {
                r7 = 1;
            }
            int i8 = (iHashCode + r7) * 31;
            boolean z3 = this.showBadgeView;
            return i8 + (z3 ? 1 : z3);
        }

        public final void setMRtl(boolean z2) {
            this.mRtl = z2;
        }

        public final void setPx(float f) {
            this.px = f;
        }

        public final void setShowBadgeView(boolean z2) {
            this.showBadgeView = z2;
        }

        public final void setTextHeight(float f) {
            this.textHeight = f;
        }

        public final void setX(float f) {
            this.x = f;
        }

        public String toString() {
            return "TabItem(iconRes=" + this.iconRes + ", title=" + this.title + ", view=" + this.view + ", x=" + this.x + ", px=" + this.px + ", textHeight=" + this.textHeight + ", mRtl=" + this.mRtl + ", showBadgeView=" + this.showBadgeView + ")";
        }

        public /* synthetic */ TabItem(int i8, String str, View view, float f, float f4, float f10, boolean z2, boolean z3, int i9, DefaultConstructorMarker defaultConstructorMarker) {
            this(i8, str, view, (i9 & 8) != 0 ? 0.0f : f, (i9 & 16) != 0 ? 0.0f : f4, (i9 & 32) != 0 ? 0.0f : f10, (i9 & 64) != 0 ? false : z2, (i9 & 128) != 0 ? false : z3);
        }
    }
}
