package com.transsion.widgetsliquid.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlendMode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toolbar;
import androidx.annotation.ColorRes;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.ActionMenuView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import b4.f;
import com.transsion.widgetslib.R$styleable;
import com.transsion.widgetslib.view.OSCheckBox;
import com.transsion.widgetslib.widget.OSIconTextView;
import com.transsion.widgetsliquid.R;
import com.transsion.widgetsliquid.effect.OSLiquidContainerRootLayout;
import com.transsion.widgetsliquid.effect.OSMaskConstraintLayout;
import id.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import je.c;
import je.q;
import je.r;
import je.s;
import je.t;
import je.v;
import je.w;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import pd.j;
import zd.n;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\n\u0018\u0000 \u0093\u00012\u00020\u0001:\u0004\u0093\u0001\u0094\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010B\u001a\u00020C2\u0006\u0010,\u001a\u00020-J\u0006\u0010D\u001a\u00020CJ\b\u0010E\u001a\u0004\u0018\u00010\nJ\b\u0010F\u001a\u0004\u0018\u00010\u000fJ\b\u0010G\u001a\u0004\u0018\u00010\u0017J\u0006\u0010H\u001a\u00020\u000fJ\u0014\u0010I\u001a\u0004\u0018\u00010J2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002J9\u0010K\u001a\u0002032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010L\u001a\u0004\u0018\u00010J2\u0006\u0010M\u001a\u00020\u00072\u000e\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150NH\u0002¢\u0006\u0002\u0010OJ\u0006\u0010P\u001a\u00020\u0007J\b\u0010Q\u001a\u0004\u0018\u00010!J\u0010\u0010R\u001a\u0004\u0018\u00010J2\u0006\u0010S\u001a\u00020\u0007J\u0006\u0010T\u001a\u000209J\b\u0010U\u001a\u0004\u0018\u00010&J\u0006\u0010V\u001a\u000209J\u0006\u0010W\u001a\u00020CJ\u0012\u0010X\u001a\u00020C2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010Y\u001a\u00020C2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0006\u0010Z\u001a\u00020CJ\b\u0010[\u001a\u00020CH\u0014J\u000e\u0010\\\u001a\u00020C2\u0006\u0010]\u001a\u00020^J\u0012\u0010_\u001a\u00020C2\b\u0010`\u001a\u0004\u0018\u00010+H\u0002J\u001a\u0010a\u001a\u00020C2\b\u0010`\u001a\u0004\u0018\u00010\u00152\b\b\u0001\u0010b\u001a\u00020\u0007J\u0016\u0010c\u001a\u00020C2\u0006\u0010d\u001a\u00020^2\u0006\u0010e\u001a\u00020\u0007J\u0015\u0010f\u001a\u00020C2\b\u0010g\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010hJ\u000e\u0010i\u001a\u00020C2\u0006\u0010j\u001a\u00020\u0007J\u0010\u0010k\u001a\u00020C2\u0006\u0010l\u001a\u00020\u0007H\u0007J\u0010\u0010m\u001a\u00020C2\b\u0010n\u001a\u0004\u0018\u00010oJ\u001a\u0010p\u001a\u00020C2\u0012\u0010n\u001a\u000e\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020C0qJ\u0012\u0010r\u001a\u00020C2\b\u0010s\u001a\u0004\u0018\u00010tH\u0002J\u0010\u0010u\u001a\u00020C2\b\u00100\u001a\u0004\u0018\u000101J\u0010\u0010v\u001a\u00020C2\b\u0010n\u001a\u0004\u0018\u00010oJ\u0006\u0010w\u001a\u00020CJ\b\u0010x\u001a\u00020CH\u0002J\u001c\u0010y\u001a\u00020C2\b\u0010z\u001a\u0004\u0018\u00010{2\b\u0010|\u001a\u0004\u0018\u00010{H\u0007J\u000e\u0010}\u001a\u00020C2\u0006\u0010~\u001a\u00020\u0007J\u0015\u0010\u007f\u001a\u00020C2\b\u0010g\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010hJ\"\u0010\u0080\u0001\u001a\u00020C2\u0013\u0010\u0081\u0001\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150N\"\u00020\u0015¢\u0006\u0003\u0010\u0082\u0001J\u0011\u0010\u0083\u0001\u001a\u00020C2\b\u0010`\u001a\u0004\u0018\u00010\u0015J\u0012\u0010\u0084\u0001\u001a\u00020C2\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0015J\u0014\u0010\u0086\u0001\u001a\u00020C2\t\u00107\u001a\u0005\u0018\u00010\u0087\u0001H\u0016J\u001c\u0010\u0088\u0001\u001a\u00020C2\u0007\u0010\u0089\u0001\u001a\u0002092\b\u0010\u008a\u0001\u001a\u00030\u008b\u0001H\u0002J\u0014\u0010\u008c\u0001\u001a\u00020C2\t\u0010>\u001a\u0005\u0018\u00010\u0087\u0001H\u0016J\u0007\u0010\u008d\u0001\u001a\u00020CJ\u001b\u0010\u008e\u0001\u001a\u00020C2\u0007\u0010\u008f\u0001\u001a\u00020J2\u0007\u0010\u0090\u0001\u001a\u00020\u0007H\u0002J\u0012\u0010\u0091\u0001\u001a\u00020C2\u0007\u0010\u008f\u0001\u001a\u00020JH\u0002J\t\u0010\u0092\u0001\u001a\u00020CH\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001c\u0010\u0011R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0013\u001a\u0004\b\"\u0010#R\u001b\u0010%\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0013\u001a\u0004\b'\u0010(R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u00104\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u001505j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0015`6X\u0082.¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u00108\u001a\u0002098BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\u0013\u001a\u0004\b:\u0010;R\u0010\u0010=\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010?\u001a\u0002098BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bA\u0010\u0013\u001a\u0004\b@\u0010;¨\u0006\u0095\u0001"}, d2 = {"Lcom/transsion/widgetsliquid/view/OSLiquidWidgetToolBar;", "Landroid/widget/Toolbar;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "checkBox", "Lcom/transsion/widgetslib/view/OSCheckBox;", "currentScaleAnimator", "Landroidx/dynamicanimation/animation/SpringAnimation;", "iconColor", "leftIcon", "Lcom/transsion/widgetsliquid/view/OSLiquidButton;", "getLeftIcon", "()Lcom/transsion/widgetsliquid/view/OSLiquidButton;", "leftIcon$delegate", "Lkotlin/Lazy;", "leftIconRes", "", "mOSMaskConstraintLayout", "Lcom/transsion/widgetsliquid/effect/OSMaskConstraintLayout;", "getMOSMaskConstraintLayout", "()Lcom/transsion/widgetsliquid/effect/OSMaskConstraintLayout;", "mOSMaskConstraintLayout$delegate", "mPopMenuButton", "getMPopMenuButton", "mPopMenuButton$delegate", "mPopupList", "Landroid/widget/ListView;", "mRightContainer", "Lcom/transsion/widgetsliquid/effect/OSLiquidContainerRootLayout;", "getMRightContainer", "()Lcom/transsion/widgetsliquid/effect/OSLiquidContainerRootLayout;", "mRightContainer$delegate", "mTextLinearLayout", "Landroid/widget/LinearLayout;", "getMTextLinearLayout", "()Landroid/widget/LinearLayout;", "mTextLinearLayout$delegate", "mainIcon", "Lcom/transsion/widgetslib/widget/OSIconTextView;", "menu", "Landroid/view/Menu;", "menuItem", "Landroid/view/MenuItem;", "onIconClickListener", "Lcom/transsion/widgetsliquid/view/OSLiquidWidgetToolBar$OnIconClickListener;", "popupWindow", "Landroid/widget/PopupWindow;", "stringArray", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "subtitle", "subtitleTextView", "Landroid/widget/TextView;", "getSubtitleTextView", "()Landroid/widget/TextView;", "subtitleTextView$delegate", "textButton", "title", "titleTextView", "getTitleTextView", "titleTextView$delegate", "createOptionsMenuPopupWindow", "", "dismissPopupWindow", "getCheckBox", "getLeftIconView", "getMaskConstraintLayout", "getPopMenuButton", "getPopupListContentView", "Landroid/view/View;", "getPopupWindow", "anchor", "selectId", "", "(Landroid/content/Context;Landroid/view/View;I[Ljava/lang/String;)Landroid/widget/PopupWindow;", "getRightChildCount", "getRightContainer", "getRightIconChildAt", "index", "getSubTitleView", "getTextLinearLayout", "getTitleView", "hideOriginalMenuView", "initAttributes", "initView", "invalidateRightIconsLayout", "onDetachedFromWindow", "setBlurNightMode", "nightMode", "", "setIconTouchAnim", "icon", "setLeftIcon", "colorRes", "setLeftIconEnable", "enable", "marginStart", "setLeftIconFillColor", "fillColor", "(Ljava/lang/Integer;)V", "setMaskVisibility", "visibility", "setMixLevel", "mixLevel", "setMoreIconClickListener", "listener", "Landroid/view/View$OnClickListener;", "setOnLeftIconClickListener", "Lkotlin/Function1;", "setOnMenuClickListener", "onItemClickListener", "Landroid/widget/AdapterView$OnItemClickListener;", "setOnRightIconClickListener", "setOnRightMainIconClickListener", "setRightCheckBox", "setRightContainerAnim", "setRightIconBgBlendMode", "basicBlendMode", "Landroid/graphics/BlendMode;", "maskBlendMode", "setRightIconColor", TypedValues.Custom.S_COLOR, "setRightIconFillColor", "setRightIcons", "icons", "([Ljava/lang/String;)V", "setRightMainIcon", "setRightTextIcon", TypedValues.Custom.S_STRING, "setSubtitle", "", "setTextExceedSize", "textView", "size", "", "setTitle", "showPopupWindow", "startPressAnimation", "hostView", "iconCount", "stopPressAnimation", "updateMenuList", "Companion", "OnIconClickListener", "widgetsliquid_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nOSLiquidWidgetToolBar.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OSLiquidWidgetToolBar.kt\ncom/transsion/widgetsliquid/view/OSLiquidWidgetToolBar\n+ 2 ContextFunc.kt\ncom/transsion/widgetslib/util/ContextFuncKt\n+ 3 Menu.kt\nandroidx/core/view/MenuKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 5 ViewGroup.kt\nandroidx/core/view/ViewGroupKt\n*L\n1#1,739:1\n13#2,9:740\n13#2,9:749\n49#3:758\n37#4,2:759\n51#5:761\n51#5:762\n*S KotlinDebug\n*F\n+ 1 OSLiquidWidgetToolBar.kt\ncom/transsion/widgetsliquid/view/OSLiquidWidgetToolBar\n*L\n96#1:740,9\n124#1:749,9\n157#1:758\n205#1:759,2\n425#1:761\n455#1:762\n*E\n"})
public final class OSLiquidWidgetToolBar extends Toolbar {
    private static final float ANIMATION_START_PRESS_DAMPING_RATIO = 0.99f;
    private static final float ANIMATION_START_PRESS_STIFFNESS = 250.0f;
    private static final float ANIMATION_STOP_PRESS_DAMPING_RATIO = 0.4f;
    private static final float ANIMATION_STOP_PRESS_STIFFNESS = 250.0f;
    private static final String EE1 = "ru";
    private static final int LINE_ONE = 1;
    private static final int LINE_TWO = 2;
    private static final String TAG = "OSLiquidToolBar";
    private OSCheckBox checkBox;
    private SpringAnimation currentScaleAnimator;
    private int iconColor;

    /* JADX INFO: renamed from: leftIcon$delegate, reason: from kotlin metadata */
    private final Lazy leftIcon;
    private String leftIconRes;

    /* JADX INFO: renamed from: mOSMaskConstraintLayout$delegate, reason: from kotlin metadata */
    private final Lazy mOSMaskConstraintLayout;

    /* JADX INFO: renamed from: mPopMenuButton$delegate, reason: from kotlin metadata */
    private final Lazy mPopMenuButton;
    private ListView mPopupList;

    /* JADX INFO: renamed from: mRightContainer$delegate, reason: from kotlin metadata */
    private final Lazy mRightContainer;

    /* JADX INFO: renamed from: mTextLinearLayout$delegate, reason: from kotlin metadata */
    private final Lazy mTextLinearLayout;
    private OSIconTextView mainIcon;
    private Menu menu;
    private MenuItem menuItem;
    private OnIconClickListener onIconClickListener;
    private PopupWindow popupWindow;
    private ArrayList<String> stringArray;
    private String subtitle;

    /* JADX INFO: renamed from: subtitleTextView$delegate, reason: from kotlin metadata */
    private final Lazy subtitleTextView;
    private TextView textButton;
    private String title;

    /* JADX INFO: renamed from: titleTextView$delegate, reason: from kotlin metadata */
    private final Lazy titleTextView;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/transsion/widgetsliquid/view/OSLiquidWidgetToolBar$OnIconClickListener;", "", "onIconClicked", "", "position", "", "enable", "", "widgetsliquid_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public interface OnIconClickListener {
        void onIconClicked(int position, boolean enable);
    }

    /* JADX INFO: renamed from: com.transsion.widgetsliquid.view.OSLiquidWidgetToolBar$setTextExceedSize$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/transsion/widgetsliquid/view/OSLiquidWidgetToolBar$setTextExceedSize$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "widgetsliquid_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class AnonymousClass1 implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ String $currentLanguage;
        final /* synthetic */ float $size;
        final /* synthetic */ TextView $textView;
        final /* synthetic */ OSLiquidWidgetToolBar this$0;

        public AnonymousClass1(TextView textView, String str, OSLiquidWidgetToolBar oSLiquidWidgetToolBar, float f) {
            this.$textView = textView;
            this.$currentLanguage = str;
            this.this$0 = oSLiquidWidgetToolBar;
            this.$size = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onGlobalLayout$lambda$0(TextView textView, float f) {
            Intrinsics.checkNotNullParameter(textView, "$textView");
            Layout layout = textView.getLayout();
            if ((layout != null ? layout.getEllipsisCount(textView.getLineCount() - 1) : 0) > 0) {
                textView.setTextSize(0, f);
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            this.$textView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            if (this.$textView.getLayout() != null) {
                if (!OSLiquidWidgetToolBar.EE1.equals(this.$currentLanguage)) {
                    if (this.$textView.getLayout().getEllipsisCount(0) > 0) {
                        this.$textView.setTextSize(0, this.$size);
                    }
                } else if (TextUtils.isEmpty(this.this$0.getSubtitleTextView().getText())) {
                    this.this$0.getTitleTextView().setMaxLines(2);
                    TextView textView = this.$textView;
                    textView.post(new v(textView, 1, this.$size));
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSLiquidWidgetToolBar(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createOptionsMenuPopupWindow$lambda$6(OSLiquidWidgetToolBar this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showPopupWindow();
    }

    private final OSLiquidButton getLeftIcon() {
        Object value = this.leftIcon.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-leftIcon>(...)");
        return (OSLiquidButton) value;
    }

    private final OSMaskConstraintLayout getMOSMaskConstraintLayout() {
        Object value = this.mOSMaskConstraintLayout.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mOSMaskConstraintLayout>(...)");
        return (OSMaskConstraintLayout) value;
    }

    private final OSLiquidButton getMPopMenuButton() {
        Object value = this.mPopMenuButton.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mPopMenuButton>(...)");
        return (OSLiquidButton) value;
    }

    private final OSLiquidContainerRootLayout getMRightContainer() {
        Object value = this.mRightContainer.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mRightContainer>(...)");
        return (OSLiquidContainerRootLayout) value;
    }

    private final LinearLayout getMTextLinearLayout() {
        Object value = this.mTextLinearLayout.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mTextLinearLayout>(...)");
        return (LinearLayout) value;
    }

    private final View getPopupListContentView(Context context) {
        if (this.mPopupList == null) {
            View viewInflate = View.inflate(context, R.layout.os_liquid_popup_window_layout, null);
            Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.widget.ListView");
            this.mPopupList = (ListView) viewInflate;
        }
        return this.mPopupList;
    }

    private final PopupWindow getPopupWindow(Context context, View anchor, int selectId, String[] stringArray) {
        dismissPopupWindow();
        getPopupListContentView(context);
        Intrinsics.checkNotNull(context);
        a aVar = new a(context, Arrays.asList(stringArray));
        Intrinsics.checkNotNullExpressionValue(aVar, "createFromStringArray(\n …!!, stringArray\n        )");
        aVar.setSelected(selectId);
        ListView listView = this.mPopupList;
        if (listView != null) {
            listView.setAdapter((ListAdapter) aVar);
        }
        n nVar = new n(context, -1, R.style.OsListPopupWindowStyle);
        nVar.setContentView(this.mPopupList);
        int iD = j.D(context, aVar);
        nVar.setBackgroundDrawable(new InsetDrawable((Drawable) new ColorDrawable(0), (int) getResources().getDimension(R.dimen.os_popup_menu_inset_left), 0, (int) getResources().getDimension(R.dimen.os_popup_menu_inset_left), (int) getResources().getDimension(R.dimen.os_popup_menu_bg_margin_bottom)));
        nVar.setWidth(iD);
        nVar.setOutsideTouchable(true);
        nVar.setFocusable(true);
        return nVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView getSubtitleTextView() {
        Object value = this.subtitleTextView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-subtitleTextView>(...)");
        return (TextView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView getTitleTextView() {
        Object value = this.titleTextView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-titleTextView>(...)");
        return (TextView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hideOriginalMenuView$lambda$5(OSLiquidWidgetToolBar this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int childCount = this$0.getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = this$0.getChildAt(i8);
            if ((childAt instanceof ActionMenuView) || (childAt instanceof android.widget.ActionMenuView)) {
                childAt.setVisibility(8);
            }
        }
    }

    private final void initAttributes(AttributeSet attrs) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int[] OSLiquidToolBar = R.styleable.OSLiquidToolBar;
        Intrinsics.checkNotNullExpressionValue(OSLiquidToolBar, "OSLiquidToolBar");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, OSLiquidToolBar, 0, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        this.leftIconRes = typedArrayObtainStyledAttributes.getString(R.styleable.OSLiquidToolBar_os_liquid_toolbar_left_icon);
        this.title = typedArrayObtainStyledAttributes.getString(R.styleable.OSLiquidToolBar_os_liquid_toolbar_title);
        this.subtitle = typedArrayObtainStyledAttributes.getString(R.styleable.OSLiquidToolBar_os_liquid_toolbar_subtitle);
        typedArrayObtainStyledAttributes.recycle();
    }

    private final void initView(AttributeSet attrs) {
        removeAllViews();
        LayoutInflater.from(getContext()).inflate(R.layout.os_liquid_toolbar_layout, (ViewGroup) this, true);
        String str = this.leftIconRes;
        if (str != null) {
            getLeftIcon().getMIconText().setTextColor(j.e(getContext(), R.attr.os_icon_primary, R.color.os_icon_primary_hios));
            getLeftIcon().setIcon(str);
            getLeftIcon().setVisibility(0);
        }
        String str2 = this.title;
        if (str2 != null) {
            setTitle(str2);
        }
        String str3 = this.subtitle;
        if (str3 != null) {
            setSubtitle(str3);
        }
        setClipChildren(false);
        setClipToPadding(false);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int[] OSLiquidContainer = R$styleable.OSLiquidContainer;
        Intrinsics.checkNotNullExpressionValue(OSLiquidContainer, "OSLiquidContainer");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, OSLiquidContainer, 0, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        if (!typedArrayObtainStyledAttributes.hasValue(R.styleable.OSLiquidContainer_os_liquid_mixlevel)) {
            setMixLevel(2);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private final void setIconTouchAnim(OSIconTextView icon) {
        if (getMRightContainer() == null || icon == null) {
            return;
        }
        icon.setOnTouchListener(new f(this, 4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setIconTouchAnim$lambda$28(OSLiquidWidgetToolBar this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (motionEvent != null && motionEvent.getAction() == 0) {
            this$0.startPressAnimation(this$0.getMRightContainer(), 1);
            return false;
        }
        if ((motionEvent == null || motionEvent.getAction() != 1) && (motionEvent == null || motionEvent.getAction() != 3)) {
            return false;
        }
        this$0.stopPressAnimation(this$0.getMRightContainer());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setOnLeftIconClickListener$lambda$19(Function1 tmp0, View view) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(view);
    }

    private final void setOnMenuClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        ListView listView = this.mPopupList;
        if (listView != null) {
            Intrinsics.checkNotNull(listView);
            listView.setOnItemClickListener(onItemClickListener);
        }
    }

    private final void setRightContainerAnim() {
        if (getMRightContainer() != null) {
            View childAt = getMRightContainer().getChildAt(1);
            int i8 = 0;
            if (!(childAt instanceof LinearLayout)) {
                int childCount = getMRightContainer().getChildCount();
                while (i8 < childCount) {
                    View childAt2 = getMRightContainer().getChildAt(i8);
                    if (childAt2.isEnabled()) {
                        childAt2.setOnTouchListener(new r(i8, 1, childAt2, this));
                    }
                    i8++;
                }
                return;
            }
            LinearLayout linearLayout = (LinearLayout) childAt;
            int childCount2 = linearLayout.getChildCount();
            while (i8 < childCount2) {
                View childAt3 = linearLayout.getChildAt(i8);
                if (childAt3.isEnabled()) {
                    childAt3.setOnTouchListener(new q(this, (LinearLayout) childAt, i8, childAt3, 1));
                }
                i8++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setRightContainerAnim$lambda$26(OSLiquidWidgetToolBar this$0, View view, int i8, View view2, View view3, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (motionEvent != null && motionEvent.getAction() == 0) {
            this$0.startPressAnimation(this$0.getMRightContainer(), ((LinearLayout) view).getChildCount());
            return false;
        }
        if (motionEvent == null || motionEvent.getAction() != 1) {
            if (motionEvent == null || motionEvent.getAction() != 3) {
                return false;
            }
            this$0.stopPressAnimation(this$0.getMRightContainer());
            return false;
        }
        this$0.stopPressAnimation(this$0.getMRightContainer());
        OnIconClickListener onIconClickListener = this$0.onIconClickListener;
        if (onIconClickListener == null) {
            return false;
        }
        onIconClickListener.onIconClicked(i8, view2.isEnabled());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setRightContainerAnim$lambda$27(OSLiquidWidgetToolBar this$0, int i8, View view, View view2, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (motionEvent != null && motionEvent.getAction() == 0) {
            this$0.startPressAnimation(this$0.getMRightContainer(), this$0.getMRightContainer().getChildCount());
            return false;
        }
        if (motionEvent == null || motionEvent.getAction() != 1) {
            if (motionEvent == null || motionEvent.getAction() != 3) {
                return false;
            }
            this$0.stopPressAnimation(this$0.getMRightContainer());
            return false;
        }
        this$0.stopPressAnimation(this$0.getMRightContainer());
        OnIconClickListener onIconClickListener = this$0.onIconClickListener;
        if (onIconClickListener == null) {
            return false;
        }
        onIconClickListener.onIconClicked(i8 - 1, view.isEnabled());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setRightTextIcon$lambda$13(OSLiquidWidgetToolBar this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.textButton;
        int width = textView != null ? textView.getWidth() : 0;
        this$0.getMRightContainer().getLayoutParams().width = width;
        this$0.getMRightContainer().setActualWidth(width);
        this$0.getMRightContainer().requestLayout();
    }

    private final void setTextExceedSize(TextView textView, float size) {
        textView.getViewTreeObserver().addOnGlobalLayoutListener(new AnonymousClass1(textView, Locale.getDefault().getLanguage(), this, size));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPopupWindow$lambda$10(OSLiquidWidgetToolBar this$0, AdapterView adapterView, View view, int i8, long j8) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ArrayList<String> arrayList = this$0.stringArray;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stringArray");
            arrayList = null;
        }
        String strValueOf = String.valueOf(arrayList.get(i8));
        Menu menu = this$0.menu;
        if (menu != null) {
            int size = menu.size();
            for (int i9 = 0; i9 < size; i9++) {
                Menu menu2 = this$0.menu;
                Intrinsics.checkNotNull(menu2);
                MenuItem item = menu2.getItem(i9);
                this$0.menuItem = item;
                if ((item != null ? item.getTitle() : null) != null) {
                    MenuItem menuItem = this$0.menuItem;
                    if (Intrinsics.areEqual(strValueOf, String.valueOf(menuItem != null ? menuItem.getTitle() : null)) && (this$0.getContext() instanceof Activity)) {
                        Context context = this$0.getContext();
                        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                        MenuItem menuItem2 = this$0.menuItem;
                        Intrinsics.checkNotNull(menuItem2);
                        ((Activity) context).onMenuItemSelected(0, menuItem2);
                    }
                }
            }
        }
        this$0.dismissPopupWindow();
    }

    private final void startPressAnimation(View hostView, int iconCount) {
        float f;
        SpringAnimation springAnimation = this.currentScaleAnimator;
        if (springAnimation != null) {
            springAnimation.cancel();
        }
        SpringAnimation springAnimation2 = new SpringAnimation(getMRightContainer(), DynamicAnimation.SCALE_X);
        SpringForce springForce = new SpringForce();
        springForce.setStiffness(250.0f);
        springForce.setDampingRatio(ANIMATION_START_PRESS_DAMPING_RATIO);
        if (iconCount == 1) {
            f = 1.25f;
        } else if (iconCount != 2) {
            f = iconCount != 3 ? 1.05f : 1.1f;
        } else {
            f = 1.2f;
        }
        springForce.setFinalPosition(f);
        springAnimation2.setSpring(springForce);
        springAnimation2.addUpdateListener(new c(4, hostView));
        springAnimation2.start();
        this.currentScaleAnimator = springAnimation2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startPressAnimation$lambda$22$lambda$21(View hostView, DynamicAnimation dynamicAnimation, float f, float f4) {
        Intrinsics.checkNotNullParameter(hostView, "$hostView");
        hostView.setScaleY(f);
    }

    private final void stopPressAnimation(View hostView) {
        SpringAnimation springAnimation = this.currentScaleAnimator;
        if (springAnimation != null) {
            springAnimation.cancel();
        }
        SpringAnimation springAnimation2 = new SpringAnimation(getMRightContainer(), DynamicAnimation.SCALE_X);
        SpringForce springForce = new SpringForce();
        springForce.setStiffness(250.0f);
        springForce.setDampingRatio(ANIMATION_STOP_PRESS_DAMPING_RATIO);
        springForce.setFinalPosition(1.0f);
        springAnimation2.setSpring(springForce);
        springAnimation2.addUpdateListener(new c(5, hostView));
        springAnimation2.start();
        this.currentScaleAnimator = springAnimation2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void stopPressAnimation$lambda$25$lambda$24(View hostView, DynamicAnimation dynamicAnimation, float f, float f4) {
        Intrinsics.checkNotNullParameter(hostView, "$hostView");
        hostView.setScaleY(f);
    }

    private final void updateMenuList() {
        ArrayList<String> arrayList = this.stringArray;
        ArrayList<String> arrayList2 = null;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stringArray");
            arrayList = null;
        }
        if (!arrayList.isEmpty()) {
            ArrayList<String> arrayList3 = this.stringArray;
            if (arrayList3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("stringArray");
                arrayList3 = null;
            }
            arrayList3.clear();
        }
        Menu menu = this.menu;
        if (menu != null) {
            int size = menu.size();
            for (int i8 = 0; i8 < size; i8++) {
                Menu menu2 = this.menu;
                Intrinsics.checkNotNull(menu2);
                MenuItem item = menu2.getItem(i8);
                this.menuItem = item;
                if (item != null && item.isVisible()) {
                    ArrayList<String> arrayList4 = this.stringArray;
                    if (arrayList4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("stringArray");
                        arrayList4 = null;
                    }
                    Menu menu3 = this.menu;
                    Intrinsics.checkNotNull(menu3);
                    arrayList4.add(String.valueOf(menu3.getItem(i8).getTitle()));
                }
            }
        }
        ArrayList<String> arrayList5 = this.stringArray;
        if (arrayList5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stringArray");
        } else {
            arrayList2 = arrayList5;
        }
        if (arrayList2.isEmpty()) {
            getMPopMenuButton().setVisibility(8);
        } else {
            getMPopMenuButton().setVisibility(0);
        }
    }

    public final void createOptionsMenuPopupWindow(Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        ArrayList<String> arrayList = null;
        if (menu.size() == 0) {
            Log.i(TAG, "menu is empty");
            PopupWindow popupWindow = this.popupWindow;
            if (popupWindow != null && popupWindow.isShowing()) {
                PopupWindow popupWindow2 = this.popupWindow;
                if (popupWindow2 != null) {
                    popupWindow2.dismiss();
                }
                this.popupWindow = null;
            }
            getMPopMenuButton().setVisibility(8);
            return;
        }
        this.menu = menu;
        this.stringArray = new ArrayList<>();
        updateMenuList();
        ArrayList<String> arrayList2 = this.stringArray;
        if (arrayList2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stringArray");
        } else {
            arrayList = arrayList2;
        }
        if (arrayList.isEmpty()) {
            getMPopMenuButton().setVisibility(8);
        } else {
            getMPopMenuButton().setVisibility(0);
        }
        getMPopMenuButton().setOnClickListener(new ce.a(this, 6));
    }

    public final void dismissPopupWindow() {
        updateMenuList();
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow != null && popupWindow.isShowing()) {
            PopupWindow popupWindow2 = this.popupWindow;
            if (popupWindow2 != null) {
                popupWindow2.dismiss();
            }
            this.popupWindow = null;
        }
        this.mPopupList = null;
    }

    public final OSCheckBox getCheckBox() {
        return this.checkBox;
    }

    public final OSLiquidButton getLeftIconView() {
        return getLeftIcon();
    }

    public final OSMaskConstraintLayout getMaskConstraintLayout() {
        return getMOSMaskConstraintLayout();
    }

    public final OSLiquidButton getPopMenuButton() {
        return getMPopMenuButton();
    }

    public final int getRightChildCount() {
        View childAt = getMRightContainer().getChildAt(1);
        return childAt instanceof LinearLayout ? ((LinearLayout) childAt).getChildCount() : getMRightContainer().getChildCount() - 1;
    }

    public final OSLiquidContainerRootLayout getRightContainer() {
        return getMRightContainer();
    }

    public final View getRightIconChildAt(int index) {
        if (index < 0) {
            return null;
        }
        View childAt = getMRightContainer().getChildAt(1);
        return childAt instanceof LinearLayout ? ((LinearLayout) childAt).getChildAt(index) : getMRightContainer().getChildAt(index + 1);
    }

    public final TextView getSubTitleView() {
        return getSubtitleTextView();
    }

    public final LinearLayout getTextLinearLayout() {
        return getMTextLinearLayout();
    }

    public final TextView getTitleView() {
        return getTitleTextView();
    }

    public final void hideOriginalMenuView() {
        post(new w(this, 1));
    }

    public final void invalidateRightIconsLayout() {
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.os_tool_bar_button_padding);
        View childAt = getMRightContainer().getChildAt(1);
        if (childAt instanceof LinearLayout) {
            LinearLayout linearLayout = (LinearLayout) childAt;
            if (linearLayout.getChildCount() > 0) {
                int childCount = linearLayout.getChildCount();
                int i8 = 0;
                for (int i9 = 0; i9 < childCount; i9++) {
                    if (linearLayout.getChildAt(i9).getVisibility() == 0) {
                        i8++;
                    }
                }
                Log.i(TAG, "invalidateRightIconsLayout :" + linearLayout.getChildCount() + " visiableIconCount:" + i8);
                if (i8 > 1) {
                    int i10 = dimensionPixelSize / 2;
                    childAt.setPadding(i10, 0, i10, 0);
                } else {
                    int childCount2 = linearLayout.getChildCount();
                    for (int i11 = 0; i11 < childCount2; i11++) {
                        linearLayout.getChildAt(i11).getLayoutParams().width = getContext().getResources().getDimensionPixelSize(R.dimen.os_tool_bar_right_one_button_size);
                    }
                    childAt.setPadding(0, 0, 0, 0);
                }
                childAt.requestLayout();
            }
        }
    }

    @Override // android.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SpringAnimation springAnimation = this.currentScaleAnimator;
        if (springAnimation != null) {
            springAnimation.cancel();
        }
    }

    public final void setBlurNightMode(boolean nightMode) {
        getLeftIcon().setBlurNightMode(nightMode);
        getMRightContainer().setBlurNightMode(nightMode);
    }

    public final void setLeftIcon(String icon, @ColorRes int colorRes) {
        if (getLeftIcon() != null) {
            OSLiquidButton leftIcon = getLeftIcon();
            Intrinsics.checkNotNull(leftIcon);
            Intrinsics.checkNotNull(icon);
            leftIcon.setIcon(icon);
            OSLiquidButton leftIcon2 = getLeftIcon();
            Intrinsics.checkNotNull(leftIcon2);
            leftIcon2.setVisibility(0);
            getLeftIcon().setIconColor(colorRes);
        }
    }

    public final void setLeftIconEnable(boolean enable, int marginStart) {
        if (enable) {
            getLeftIcon().setVisibility(0);
        } else {
            getLeftIcon().setVisibility(8);
        }
        LinearLayout textLinearLayout = getTextLinearLayout();
        ViewGroup.LayoutParams layoutParams = textLinearLayout != null ? textLinearLayout.getLayoutParams() : null;
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams).setMarginStart(marginStart);
    }

    public final void setLeftIconFillColor(Integer fillColor) {
        if (getLeftIcon() == null || fillColor == null) {
            return;
        }
        OSLiquidButton leftIcon = getLeftIcon();
        Intrinsics.checkNotNull(leftIcon);
        leftIcon.setVisibility(0);
        getLeftIcon().setFillBasicColor(fillColor.intValue());
    }

    public final void setMaskVisibility(int visibility) {
        getMOSMaskConstraintLayout().setMaskVisibility(visibility);
    }

    @RequiresApi(31)
    public final void setMixLevel(int mixLevel) {
        getLeftIcon().setMixLevel(mixLevel);
        getMRightContainer().setMixLevel(mixLevel);
    }

    public final void setMoreIconClickListener(View.OnClickListener listener) {
        OSIconTextView oSIconTextView = this.mainIcon;
        if (oSIconTextView == null || !oSIconTextView.isEnabled()) {
            return;
        }
        OSIconTextView oSIconTextView2 = this.mainIcon;
        if (oSIconTextView2 != null) {
            oSIconTextView2.setOnClickListener(listener);
        }
        setIconTouchAnim(this.mainIcon);
    }

    public final void setOnLeftIconClickListener(Function1<? super View, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (getLeftIcon() != null) {
            OSLiquidButton leftIcon = getLeftIcon();
            Intrinsics.checkNotNull(leftIcon);
            leftIcon.setOnClickListener(new s(1, listener));
        }
    }

    public final void setOnRightIconClickListener(OnIconClickListener onIconClickListener) {
        this.onIconClickListener = onIconClickListener;
        setRightContainerAnim();
    }

    public final void setOnRightMainIconClickListener(View.OnClickListener listener) {
        OSIconTextView oSIconTextView = this.mainIcon;
        if (oSIconTextView == null || !oSIconTextView.isEnabled()) {
            return;
        }
        OSIconTextView oSIconTextView2 = this.mainIcon;
        if (oSIconTextView2 != null) {
            oSIconTextView2.setOnClickListener(listener);
        }
        setIconTouchAnim(this.mainIcon);
    }

    public final void setRightCheckBox() {
        getMRightContainer().setVisibility(0);
        if (getMRightContainer().getChildCount() != 0) {
            int childCount = getMRightContainer().getChildCount();
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = getMRightContainer().getChildAt(i8);
                if (childAt instanceof LinearLayout) {
                    getMRightContainer().removeView(childAt);
                }
            }
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(linearLayout.getContext().getResources().getDimensionPixelSize(R.dimen.os_tool_bar_right_one_button_size), -1));
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        OSCheckBox oSCheckBox = new OSCheckBox(getContext());
        oSCheckBox.setLayoutParams(new LinearLayout.LayoutParams(-2, oSCheckBox.getContext().getResources().getDimensionPixelSize(R.dimen.os_tool_bar_right_one_button_size)));
        oSCheckBox.setGravity(17);
        this.checkBox = oSCheckBox;
        linearLayout.addView(oSCheckBox);
        getMRightContainer().addView(linearLayout);
    }

    @RequiresApi(29)
    public final void setRightIconBgBlendMode(BlendMode basicBlendMode, BlendMode maskBlendMode) {
        if (basicBlendMode == null || maskBlendMode == null) {
            return;
        }
        getMRightContainer().setVisibility(0);
        getMRightContainer().setBgBlendMode(basicBlendMode, maskBlendMode);
    }

    public final void setRightIconColor(int color) {
        this.iconColor = color;
        int childCount = getMRightContainer().getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getMRightContainer().getChildAt(i8);
            if (childAt instanceof OSIconTextView) {
                ((OSIconTextView) childAt).setTextColor(this.iconColor);
            }
        }
    }

    public final void setRightIconFillColor(Integer fillColor) {
        if (fillColor != null) {
            OSLiquidContainerRootLayout mRightContainer = getMRightContainer();
            Intrinsics.checkNotNull(mRightContainer);
            mRightContainer.setVisibility(0);
            getMRightContainer().setFillBasicColor(fillColor.intValue());
        }
    }

    public final void setRightIcons(String... icons) {
        Intrinsics.checkNotNullParameter(icons, "icons");
        getMRightContainer().setVisibility(0);
        if (getMRightContainer().getChildCount() != 0) {
            int childCount = getMRightContainer().getChildCount();
            for (int i8 = 1; i8 < childCount; i8++) {
                getMRightContainer().removeView(getMRightContainer().getChildAt(i8));
            }
        }
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.os_tool_bar_right_one_button_size);
        int dimensionPixelSize2 = getContext().getResources().getDimensionPixelSize(R.dimen.os_tool_bar_right_one_button_width);
        int dimensionPixelSize3 = getContext().getResources().getDimensionPixelSize(R.dimen.os_tool_bar_button_padding);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        for (String str : icons) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            OSIconTextView oSIconTextView = new OSIconTextView(context, null, 0, 14);
            oSIconTextView.setLayoutParams(new LinearLayout.LayoutParams(dimensionPixelSize2, dimensionPixelSize));
            oSIconTextView.setGravity(17);
            oSIconTextView.setTextAlignment(4);
            oSIconTextView.setIncludeFontPadding(false);
            oSIconTextView.setTextColor(this.iconColor);
            oSIconTextView.setClickable(true);
            oSIconTextView.setText(str);
            linearLayout.addView(oSIconTextView);
        }
        if (linearLayout.getChildCount() > 1) {
            int i9 = dimensionPixelSize3 / 2;
            linearLayout.setPadding(i9, 0, i9, 0);
        } else {
            linearLayout.getLayoutParams().width = getContext().getResources().getDimensionPixelSize(R.dimen.os_tool_bar_right_one_button_size);
            linearLayout.setPadding(0, 0, 0, 0);
        }
        getMRightContainer().addView(linearLayout);
    }

    public final void setRightMainIcon(String icon) {
        getMRightContainer().setVisibility(0);
        if (getMRightContainer().getChildCount() > 0) {
            int childCount = getMRightContainer().getChildCount();
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = getMRightContainer().getChildAt(i8);
                if (childAt instanceof OSIconTextView) {
                    getMRightContainer().removeView(childAt);
                }
            }
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        OSIconTextView oSIconTextView = new OSIconTextView(context, null, 0, 14);
        oSIconTextView.setLayoutParams(new LinearLayout.LayoutParams(oSIconTextView.getContext().getResources().getDimensionPixelSize(R.dimen.os_tool_bar_right_one_button_size), -1));
        oSIconTextView.setGravity(17);
        oSIconTextView.setTextColor(this.iconColor);
        oSIconTextView.setClickable(true);
        oSIconTextView.setText(icon);
        this.mainIcon = oSIconTextView;
        getMRightContainer().addView(this.mainIcon);
    }

    public final void setRightTextIcon(String string) {
        getMRightContainer().setVisibility(string != null ? 0 : 8);
        TextView textView = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, textView.getContext().getResources().getDimensionPixelSize(R.dimen.os_tool_bar_right_one_button_size));
        textView.setMaxWidth(textView.getContext().getResources().getDimensionPixelSize(R.dimen.os_tool_bar_button_text_max_size));
        layoutParams.gravity = 17;
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setPadding(textView.getContext().getResources().getDimensionPixelSize(R.dimen.os_tool_bar_button_text_padding), 0, textView.getContext().getResources().getDimensionPixelSize(R.dimen.os_tool_bar_button_text_padding), 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(17);
        textView.setClickable(true);
        textView.setText(string);
        textView.setTextSize(0, textView.getContext().getResources().getDimensionPixelSize(R.dimen.os_body_font_nrsp));
        textView.setTextColor(j.h(textView.getContext()));
        this.textButton = textView;
        getMRightContainer().addView(this.textButton);
        TextView textView2 = this.textButton;
        if (textView2 != null) {
            textView2.post(new w(this, 0));
        }
    }

    @Override // android.widget.Toolbar
    public void setSubtitle(CharSequence subtitle) {
        if (getSubtitleTextView() != null) {
            getSubtitleTextView().setTextColor(j.e(getContext(), R.attr.os_text_secondary, R.color.os_text_secondary_hios));
            getSubtitleTextView().setText(subtitle);
            getSubtitleTextView().setVisibility((subtitle == null || subtitle.length() == 0) ? 8 : 0);
            getTitleTextView().setMaxLines(1);
        }
    }

    @Override // android.widget.Toolbar
    public void setTitle(CharSequence title) {
        if (getTitleTextView() != null) {
            getTitleTextView().setTextColor(j.e(getContext(), R.attr.os_text_primary, R.color.os_text_primary_hios));
            getTitleTextView().setText(title);
            getTitleTextView().setVisibility((title == null || title.length() == 0) ? 8 : 0);
            setTextExceedSize(getTitleTextView(), getResources().getDimensionPixelSize(R.dimen.os_body_font_nrsp));
        }
    }

    public final void showPopupWindow() {
        updateMenuList();
        Context context = getContext();
        OSLiquidButton mPopMenuButton = getMPopMenuButton();
        ArrayList<String> arrayList = this.stringArray;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stringArray");
            arrayList = null;
        }
        PopupWindow popupWindow = getPopupWindow(context, mPopMenuButton, -1, (String[]) arrayList.toArray(new String[0]));
        this.popupWindow = popupWindow;
        if (popupWindow != null) {
            popupWindow.showAsDropDown(getMRightContainer(), 0, -((int) getResources().getDimension(R.dimen.os_tool_bar_right_one_button_size)));
        }
        setOnMenuClickListener(new t(this, 1));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSLiquidWidgetToolBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ OSLiquidWidgetToolBar(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSLiquidWidgetToolBar(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.checkNotNullParameter(context, "context");
        this.leftIcon = LazyKt.lazy(new Function0<OSLiquidButton>() { // from class: com.transsion.widgetsliquid.view.OSLiquidWidgetToolBar$leftIcon$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final OSLiquidButton invoke() {
                return (OSLiquidButton) this.this$0.findViewById(R.id.toolbar_left_icon);
            }
        });
        this.titleTextView = LazyKt.lazy(new Function0<TextView>() { // from class: com.transsion.widgetsliquid.view.OSLiquidWidgetToolBar$titleTextView$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) this.this$0.findViewById(R.id.toolbar_title);
            }
        });
        this.subtitleTextView = LazyKt.lazy(new Function0<TextView>() { // from class: com.transsion.widgetsliquid.view.OSLiquidWidgetToolBar$subtitleTextView$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) this.this$0.findViewById(R.id.toolbar_subtitle);
            }
        });
        this.mRightContainer = LazyKt.lazy(new Function0<OSLiquidContainerRootLayout>() { // from class: com.transsion.widgetsliquid.view.OSLiquidWidgetToolBar$mRightContainer$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final OSLiquidContainerRootLayout invoke() {
                return (OSLiquidContainerRootLayout) this.this$0.findViewById(R.id.toolbar_right_icon_container);
            }
        });
        this.mPopMenuButton = LazyKt.lazy(new Function0<OSLiquidButton>() { // from class: com.transsion.widgetsliquid.view.OSLiquidWidgetToolBar$mPopMenuButton$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final OSLiquidButton invoke() {
                return (OSLiquidButton) this.this$0.findViewById(R.id.toolbar_pop_menu_btn);
            }
        });
        this.mOSMaskConstraintLayout = LazyKt.lazy(new Function0<OSMaskConstraintLayout>() { // from class: com.transsion.widgetsliquid.view.OSLiquidWidgetToolBar$mOSMaskConstraintLayout$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final OSMaskConstraintLayout invoke() {
                return (OSMaskConstraintLayout) this.this$0.findViewById(R.id.os_liquid_toolbar_layout);
            }
        });
        this.mTextLinearLayout = LazyKt.lazy(new Function0<LinearLayout>() { // from class: com.transsion.widgetsliquid.view.OSLiquidWidgetToolBar$mTextLinearLayout$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                return (LinearLayout) this.this$0.findViewById(R.id.toobar_title_text);
            }
        });
        this.iconColor = j.e(context, R.attr.os_icon_primary, R.color.os_icon_primary_hios);
        initAttributes(attributeSet);
        initView(attributeSet);
    }
}
