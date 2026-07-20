package com.transsion.widgetsliquid.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.AbsSavedState;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.annotation.CallSuper;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FloatValueHolder;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.transsion.connectx.sdk.TCCPSourceApi;
import com.transsion.core.pool.TranssionPoolExecutor;
import com.transsion.widgetslib.R$styleable;
import com.transsion.widgetslib.widget.OSIconTextView;
import com.transsion.widgetsliquid.R;
import com.transsion.widgetsliquid.effect.OSLiquidContainerRootLayout;
import com.transsion.widgetsliquid.view.OSLiquidSearchBar;
import gd.h;
import hd.a;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import k3.z8;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import o.d;
import pd.j;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b2\b\u0016\u0018\u0000 °\u00012\u00020\u0001:\n°\u0001±\u0001²\u0001³\u0001´\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010P\u001a\u0002082\u0006\u0010Q\u001a\u00020\u0000J\b\u0010R\u001a\u000208H\u0002J\u0010\u0010S\u001a\u0002082\u0006\u0010T\u001a\u00020\u0007H\u0003J\b\u0010U\u001a\u0004\u0018\u00010\u001fJ\u0018\u0010U\u001a\u0004\u0018\u00010\u001f2\u0006\u0010V\u001a\u00020\"2\u0006\u0010W\u001a\u00020\"J\u0012\u0010X\u001a\u0002082\b\b\u0002\u0010Y\u001a\u00020\nH\u0002J\u0006\u0010Z\u001a\u000208J\u0006\u0010[\u001a\u000207J\b\u0010\\\u001a\u00020\u0007H\u0002J\u0006\u0010]\u001a\u000207J\u0006\u0010^\u001a\u00020_J\u0006\u0010`\u001a\u00020\u0014J\u0006\u0010a\u001a\u00020bJ\b\u0010c\u001a\u00020\u0007H\u0002J\b\u0010d\u001a\u00020\u0007H\u0002J\u0012\u0010e\u001a\u00020\u00072\b\b\u0002\u0010Y\u001a\u00020\nH\u0002J\u0012\u0010f\u001a\u00020\u00072\b\b\u0002\u0010Y\u001a\u00020\nH\u0002J\b\u0010g\u001a\u00020\u0007H\u0002J\u0006\u0010h\u001a\u000207J\u0006\u0010i\u001a\u00020-J\b\u0010j\u001a\u00020\u0007H\u0002J\u0006\u0010k\u001a\u00020-J\b\u0010l\u001a\u00020\u0007H\u0002J\u0006\u0010m\u001a\u00020-J\b\u0010n\u001a\u00020\u0007H\u0002J\b\u0010o\u001a\u00020\u0007H\u0002J\u0006\u0010p\u001a\u00020\u0007J\u0006\u0010q\u001a\u000207J\b\u0010r\u001a\u00020\u0007H\u0002J\u0006\u0010s\u001a\u00020\u0012J\u0019\u0010t\u001a\u0002082\n\b\u0002\u0010u\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u0010vJ\u0010\u0010w\u001a\u0002082\b\b\u0002\u0010x\u001a\u00020\nJ\b\u0010y\u001a\u00020\nH\u0002J\b\u0010z\u001a\u00020\nH\u0002J\b\u0010{\u001a\u000208H\u0002J\u0012\u0010|\u001a\u0002082\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010}\u001a\u0002082\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0006\u0010~\u001a\u00020\nJ\b\u0010\u007f\u001a\u000208H\u0014J\t\u0010\u0080\u0001\u001a\u000208H\u0014J\u0015\u0010\u0081\u0001\u001a\u0002082\n\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0083\u0001H\u0014J\f\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0083\u0001H\u0014J\u0010\u0010\u0085\u0001\u001a\u0002082\u0007\u0010\u0085\u0001\u001a\u00020\nJ\u000f\u0010\u0086\u0001\u001a\u0002082\u0006\u0010V\u001a\u00020\nJ\u0010\u0010\u0087\u0001\u001a\u0002082\u0007\u0010\u0088\u0001\u001a\u00020\nJ\u0010\u0010\u0089\u0001\u001a\u0002082\u0007\u0010\u008a\u0001\u001a\u00020\u0012J\u0010\u0010\u008b\u0001\u001a\u0002082\u0007\u0010\u008c\u0001\u001a\u00020\"J\u0012\u0010\u008d\u0001\u001a\u0002082\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0012J\u0019\u0010\u008f\u0001\u001a\u0002082\u0007\u0010\u0090\u0001\u001a\u00020\u00072\u0007\u0010\u0091\u0001\u001a\u00020\u0007J\u001b\u0010\u008f\u0001\u001a\u0002082\u0007\u0010\u0090\u0001\u001a\u00020\u00072\t\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u0093\u0001\u001a\u0002082\u0007\u0010\u0094\u0001\u001a\u00020\u0012J\u0012\u0010\u0095\u0001\u001a\u0002082\u0007\u0010\u0096\u0001\u001a\u00020\u0007H\u0007J\u0016\u0010\u0097\u0001\u001a\u0002082\r\u0010\u0098\u0001\u001a\b\u0012\u0004\u0012\u0002080>J\u0016\u0010\u0099\u0001\u001a\u0002082\r\u0010\u0098\u0001\u001a\b\u0012\u0004\u0012\u0002080>J\u0016\u0010\u009a\u0001\u001a\u0002082\r\u0010\u0098\u0001\u001a\b\u0012\u0004\u0012\u0002080>J\u001c\u0010\u009b\u0001\u001a\u0002082\u0013\u0010\u0098\u0001\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020806J\u001c\u0010\u009c\u0001\u001a\u0002082\u0013\u0010\u0098\u0001\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020806J\u001c\u0010\u009d\u0001\u001a\u0002082\u0013\u0010\u0098\u0001\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020806J\u0012\u0010\u009e\u0001\u001a\u0002082\t\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u0012J\u0012\u0010\u009f\u0001\u001a\u0002082\t\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u0012J6\u0010 \u0001\u001a\u0002082\u0006\u0010T\u001a\u00020\u00072\u0007\u0010¡\u0001\u001a\u00020\u00072\t\b\u0002\u0010¢\u0001\u001a\u00020\n2\u000b\b\u0002\u0010£\u0001\u001a\u0004\u0018\u00010\n¢\u0006\u0003\u0010¤\u0001J\u0012\u0010¥\u0001\u001a\u0002082\u0007\u0010¦\u0001\u001a\u00020\nH\u0002J\u0010\u0010§\u0001\u001a\u0002082\u0007\u0010¨\u0001\u001a\u00020\u0012J\u0010\u0010©\u0001\u001a\u0002082\u0007\u0010ª\u0001\u001a\u00020\nJ\t\u0010«\u0001\u001a\u000208H\u0002J\t\u0010¬\u0001\u001a\u000208H\u0002J\t\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u001fJ\u0019\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u001f2\u0006\u0010V\u001a\u00020\"2\u0006\u0010W\u001a\u00020\"J \u0010®\u0001\u001a\u000208*\u00020\f2\t\b\u0002\u0010¯\u0001\u001a\u00020\n2\b\u0010*\u001a\u0004\u0018\u00010\u0012R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0010\u001a\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010#\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0010\u001a\u0004\b$\u0010\u000eR\u0010\u0010&\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010'\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0010\u001a\u0004\b(\u0010\u000eR\u0010\u0010*\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010,\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\u0010\u001a\u0004\b.\u0010/R\u0010\u00101\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00105\u001a\u0010\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u000208\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00109\u001a\u0010\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u000208\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010:\u001a\u0010\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u000208\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010=\u001a\n\u0012\u0004\u0012\u000208\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010?\u001a\n\u0012\u0004\u0012\u000208\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010@\u001a\n\u0012\u0004\u0012\u000208\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010A\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010\u0010\u001a\u0004\bB\u0010/R\u001b\u0010D\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bF\u0010\u0010\u001a\u0004\bE\u0010/R\u0010\u0010G\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010I\u001a\u00020J8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bM\u0010\u0010\u001a\u0004\bK\u0010LR\u000e\u0010N\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000¨\u0006µ\u0001"}, d2 = {"Lcom/transsion/widgetsliquid/view/OSLiquidSearchBar;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backIconAlphaAnimInitialized", "", "buttonMode", "Lcom/transsion/widgetslib/widget/OSIconTextView;", "getButtonMode", "()Lcom/transsion/widgetslib/widget/OSIconTextView;", "buttonMode$delegate", "Lkotlin/Lazy;", "buttonModeIconRes", "", "editeTextContainer", "Lcom/transsion/widgetsliquid/effect/OSLiquidContainerRootLayout;", "getEditeTextContainer", "()Lcom/transsion/widgetsliquid/effect/OSLiquidContainerRootLayout;", "editeTextContainer$delegate", "edittextLayoutRes", "edittextViewStub", "Landroid/view/ViewStub;", "getEdittextViewStub", "()Landroid/view/ViewStub;", "edittextViewStub$delegate", "expandAnimator", "Landroidx/dynamicanimation/animation/SpringAnimation;", "hintText", "imeMaxHeight", "", "innerLeftIcon", "getInnerLeftIcon", "innerLeftIcon$delegate", "innerLeftIconRes", "innerRightIcon", "getInnerRightIcon", "innerRightIcon$delegate", "innerRightIconRes", "isUseUnionBlur", "leftIcon", "Lcom/transsion/widgetsliquid/view/OSLiquidButton;", "getLeftIcon", "()Lcom/transsion/widgetsliquid/view/OSLiquidButton;", "leftIcon$delegate", "leftIconRes", "mCurrentSearchState", "mHaveRightIcon", "mRequireSearchAnimManagerTrans", "mSearchBarClickListener", "Lkotlin/Function1;", "Landroid/view/View;", "", "mSearchBarInnerRightIconClickListener", "mSearchButtonModeClickListener", "mTextWatcher", "Landroid/text/TextWatcher;", "onBackClickListener", "Lkotlin/Function0;", "onRightIcon2ClickListener", "onRightIconClickListener", "rightIcon", "getRightIcon", "rightIcon$delegate", "rightIcon2", "getRightIcon2", "rightIcon2$delegate", "rightIconRes", "rightIconRes2", "searchEditText", "Lcom/transsion/widgetsliquid/view/OSAutoCompleteTextView;", "getSearchEditText", "()Lcom/transsion/widgetsliquid/view/OSAutoCompleteTextView;", "searchEditText$delegate", "showRightIcon", "singleIconDimen", "copyScale", "osLiquidSearchBar", "dealDeleteIconVisibility", "doBackIconAlphaAnim", "fromState", "endSearchForTransition", "scale", TypedValues.CycleType.S_WAVE_OFFSET, "exitSearchState", "isEntrance", "exitSearchStateCompose", "getBackView", "getButtonModeHeight", "getDeleteButton", "getEditText", "Landroid/widget/EditText;", "getEditTextContainer", "getEditTextView", "Landroid/widget/AutoCompleteTextView;", "getEditeDefaultMarginEnd", "getEditeDefaultMarginStart", "getEditeTotalMarginEnd", "getEditeTotalMarginEndNoAnim", "getEditeTotalMarginStart", "getInnerRightIconView", "getLeftIconView", "getLeftIconWidth", "getRightIcon2View", "getRightIcon2Width", "getRightIconView", "getRightIconWidth", "getRightSingleIconWidth", "getSearchBarState", "getSearchIconView", "getSearchModeHeight", "getText", "goSearchState", "isScaleHeight", "(Ljava/lang/Boolean;)V", "goSearchStateForCompose", "isBackIconVisible", "haveRight2Icon", "haveRightIcon", "hideKeyboard", "initAttributes", "initViews", "isOnSearch", "onAttachedToWindow", "onDetachedFromWindow", "onRestoreInstanceState", "state", "Landroid/os/Parcelable;", "onSaveInstanceState", "requireSearchAnimManagerTrans", "scaleButtonMode", "setBlurNightMode", "nightMode", "setHint", "hint", "setImeHeight", "imeHeight", "setInnerRightIconRes", "iconRes", "setInputMax", "max", "resId", "resStr", "setLeftIcon", "drawable", "setMixLevel", "mixLevel", "setOnBackClickListener", "listener", "setOnRightIcon2ClickListener", "setOnRightIconClickListener", "setOnSearchBarInnerRightIconClickListener", "setOnSearchBarListener", "setOnSearchButtonModeClickListener", "setRightIcon", "setRightIcon2", "setSearchBarState", "toState", "animation", "scaleHeight", "(IIZLjava/lang/Boolean;)V", "setShadowShow", "showShadow", "setText", "text", "setTextHeightElegant", "elegant", "setupClickListeners", "showKeyboard", "startSearchForTransition", "changeIcon", "isCloseIcon", "Companion", "LIQUID_SEARCHBAR_STATE", "OSLengthFilter", "SavedState", "SearchBarTextWatcher", "widgetsliquid_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nOSLiquidSearchBar.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OSLiquidSearchBar.kt\ncom/transsion/widgetsliquid/view/OSLiquidSearchBar\n+ 2 ContextFunc.kt\ncom/transsion/widgetslib/util/ContextFuncKt\n*L\n1#1,1269:1\n13#2,9:1270\n13#2,9:1279\n*S KotlinDebug\n*F\n+ 1 OSLiquidSearchBar.kt\ncom/transsion/widgetsliquid/view/OSLiquidSearchBar\n*L\n147#1:1270,9\n205#1:1279,9\n*E\n"})
public class OSLiquidSearchBar extends FrameLayout {
    public static final int LIQUID_SEARCHBAR_COMPOSE_TAB_CONTRACTED_STATE = 5;
    public static final int LIQUID_SEARCHBAR_EXIT_SPRING_FINAL_POSITION = 124;
    public static final float LIQUID_SEARCHBAR_SCALE_MIN = 0.3f;
    public static final float LIQUID_SEARCHBAR_SPRING_DAMPING = 0.75f;
    public static final float LIQUID_SEARCHBAR_SPRING_STIFFNESS = 300.0f;
    public static final int LIQUID_SEARCHBAR_STATE_ACTIVE_BK = 1;
    public static final int LIQUID_SEARCHBAR_STATE_ACTIVE_NO_BK = 2;
    public static final int LIQUID_SEARCHBAR_STATE_COMPOSE_END_STATE = 4;
    public static final int LIQUID_SEARCHBAR_STATE_COMPOSE_START_STATE = 3;
    public static final int LIQUID_SEARCHBAR_STATE_ENTRANCE = 0;
    public static final int LIQUID_SEARCHBAR_STATE_NONE = -1;
    private static final String TAG = "OSLiquidSearchBar";
    private boolean backIconAlphaAnimInitialized;

    /* JADX INFO: renamed from: buttonMode$delegate, reason: from kotlin metadata */
    private final Lazy buttonMode;
    private String buttonModeIconRes;

    /* JADX INFO: renamed from: editeTextContainer$delegate, reason: from kotlin metadata */
    private final Lazy editeTextContainer;
    private int edittextLayoutRes;

    /* JADX INFO: renamed from: edittextViewStub$delegate, reason: from kotlin metadata */
    private final Lazy edittextViewStub;
    private SpringAnimation expandAnimator;
    private String hintText;
    private float imeMaxHeight;

    /* JADX INFO: renamed from: innerLeftIcon$delegate, reason: from kotlin metadata */
    private final Lazy innerLeftIcon;
    private String innerLeftIconRes;

    /* JADX INFO: renamed from: innerRightIcon$delegate, reason: from kotlin metadata */
    private final Lazy innerRightIcon;
    private String innerRightIconRes;
    private boolean isUseUnionBlur;

    /* JADX INFO: renamed from: leftIcon$delegate, reason: from kotlin metadata */
    private final Lazy leftIcon;
    private String leftIconRes;
    private int mCurrentSearchState;
    private boolean mHaveRightIcon;
    private boolean mRequireSearchAnimManagerTrans;
    private Function1<? super View, Unit> mSearchBarClickListener;
    private Function1<? super View, Unit> mSearchBarInnerRightIconClickListener;
    private Function1<? super View, Unit> mSearchButtonModeClickListener;
    private TextWatcher mTextWatcher;
    private Function0<Unit> onBackClickListener;
    private Function0<Unit> onRightIcon2ClickListener;
    private Function0<Unit> onRightIconClickListener;

    /* JADX INFO: renamed from: rightIcon$delegate, reason: from kotlin metadata */
    private final Lazy rightIcon;

    /* JADX INFO: renamed from: rightIcon2$delegate, reason: from kotlin metadata */
    private final Lazy rightIcon2;
    private String rightIconRes;
    private String rightIconRes2;

    /* JADX INFO: renamed from: searchEditText$delegate, reason: from kotlin metadata */
    private final Lazy searchEditText;
    private boolean showRightIcon;
    private final int singleIconDimen;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/transsion/widgetsliquid/view/OSLiquidSearchBar$LIQUID_SEARCHBAR_STATE;", "", "widgetsliquid_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface LIQUID_SEARCHBAR_STATE {
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ<\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0016R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/transsion/widgetsliquid/view/OSLiquidSearchBar$OSLengthFilter;", "Landroid/text/InputFilter$LengthFilter;", "context", "Landroid/content/Context;", "max", "", "tipInputMax", "", "(Landroid/content/Context;ILjava/lang/String;)V", "mContextWeakReference", "Ljava/lang/ref/WeakReference;", "mTextNum", "mTipInputMax", "mToast", "Landroid/widget/Toast;", "filter", "", TranssionPoolExecutor.DEFAULT_SOURCE_EXECUTOR_NAME, "start", "end", "dest", "Landroid/text/Spanned;", "dstart", "dend", "widgetsliquid_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class OSLengthFilter extends InputFilter.LengthFilter {
        private WeakReference<Context> mContextWeakReference;
        private int mTextNum;
        private String mTipInputMax;
        private Toast mToast;

        public OSLengthFilter(Context context, int i8, String str) {
            super(i8);
            if (context != null) {
                this.mContextWeakReference = new WeakReference<>(context);
                this.mTextNum = i8;
                this.mTipInputMax = str;
            }
        }

        @Override // android.text.InputFilter.LengthFilter, android.text.InputFilter
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            Intrinsics.checkNotNullParameter(source, "source");
            CharSequence charSequenceFilter = super.filter(source, start, end, dest, dstart, dend);
            if (dest == null) {
                return charSequenceFilter;
            }
            int length = dest.length();
            WeakReference<Context> weakReference = this.mContextWeakReference;
            Intrinsics.checkNotNull(weakReference);
            Context context = weakReference.get();
            if (context == null || length < this.mTextNum || length == 0 || charSequenceFilter == null || TextUtils.isEmpty(this.mTipInputMax)) {
                return charSequenceFilter;
            }
            if (this.mToast == null) {
                this.mToast = Toast.makeText(context, this.mTipInputMax, 1);
            }
            Toast toast = this.mToast;
            if (toast != null) {
                toast.show();
            }
            return charSequenceFilter;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0012\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\tH\u0016R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/transsion/widgetsliquid/view/OSLiquidSearchBar$SavedState;", "Landroid/view/AbsSavedState;", "superState", "Landroid/os/Parcelable;", "(Landroid/os/Parcelable;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "searchState", "", "getSearchState", "()I", "setSearchState", "(I)V", "writeToParcel", "", "out", "flags", "CREATOR", "widgetsliquid_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class SavedState extends AbsSavedState {

        /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private int searchState;

        /* JADX INFO: renamed from: com.transsion.widgetsliquid.view.OSLiquidSearchBar$SavedState$CREATOR, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/transsion/widgetsliquid/view/OSLiquidSearchBar$SavedState$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/transsion/widgetsliquid/view/OSLiquidSearchBar$SavedState;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/transsion/widgetsliquid/view/OSLiquidSearchBar$SavedState;", "widgetsliquid_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class Companion implements Parcelable.Creator<SavedState> {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new SavedState(parcel, null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        }

        public /* synthetic */ SavedState(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
            this(parcel);
        }

        public final int getSearchState() {
            return this.searchState;
        }

        public final void setSearchState(int i8) {
            this.searchState = i8;
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel out, int flags) {
            Intrinsics.checkNotNullParameter(out, "out");
            super.writeToParcel(out, flags);
            out.writeInt(this.searchState);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.searchState = parcel.readInt();
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J*\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016J*\u0010\u000e\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0017¨\u0006\u000f"}, d2 = {"Lcom/transsion/widgetsliquid/view/OSLiquidSearchBar$SearchBarTextWatcher;", "Landroid/text/TextWatcher;", "(Lcom/transsion/widgetsliquid/view/OSLiquidSearchBar;)V", "afterTextChanged", "", "editable", "Landroid/text/Editable;", "beforeTextChanged", "s", "", "start", "", "before", "count", "onTextChanged", "widgetsliquid_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public final class SearchBarTextWatcher implements TextWatcher {
        public SearchBarTextWatcher() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s2, int start, int before, int count) {
        }

        @Override // android.text.TextWatcher
        @CallSuper
        public void onTextChanged(CharSequence s2, int start, int before, int count) {
            OSLiquidSearchBar.this.dealDeleteIconVisibility();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSLiquidSearchBar(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static /* synthetic */ void changeIcon$default(OSLiquidSearchBar oSLiquidSearchBar, OSIconTextView oSIconTextView, boolean z2, String str, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: changeIcon");
        }
        if ((i8 & 1) != 0) {
            z2 = true;
        }
        oSLiquidSearchBar.changeIcon(oSIconTextView, z2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dealDeleteIconVisibility() {
        int i8 = 8;
        if (this.mCurrentSearchState == 3) {
            getInnerRightIcon().setVisibility(8);
            return;
        }
        OSIconTextView innerRightIcon = getInnerRightIcon();
        if (TextUtils.isEmpty(getSearchEditText().getText()) || getSearchEditText().getText().toString().length() <= 0) {
            if (!TextUtils.isEmpty(this.innerRightIconRes)) {
                changeIcon(getInnerRightIcon(), false, this.innerRightIconRes);
            }
            innerRightIcon.setVisibility(i8);
        }
        changeIcon(getInnerRightIcon(), true, getResources().getString(R.string.os_Close_fill));
        i8 = 0;
        innerRightIcon.setVisibility(i8);
    }

    @RequiresApi(ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_BIAS)
    private final void doBackIconAlphaAnim(final int fromState) {
        if (this.backIconAlphaAnimInitialized) {
            return;
        }
        this.backIconAlphaAnimInitialized = true;
        getLeftIcon().setAlpha(0.0f);
        ViewCompat.setWindowInsetsAnimationCallback(this, new WindowInsetsAnimationCompat.Callback() { // from class: com.transsion.widgetsliquid.view.OSLiquidSearchBar.doBackIconAlphaAnim.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
            public void onEnd(WindowInsetsAnimationCompat animation) {
                Insets insets;
                Intrinsics.checkNotNullParameter(animation, "animation");
                if ((animation.getTypeMask() & WindowInsetsCompat.Type.ime()) != 0) {
                    WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(OSLiquidSearchBar.this);
                    float f = OSLiquidSearchBar.this.imeMaxHeight > 0.0f ? ((rootWindowInsets == null || (insets = rootWindowInsets.getInsets(WindowInsetsCompat.Type.ime())) == null) ? 0 : insets.bottom) / OSLiquidSearchBar.this.imeMaxHeight : 0.0f;
                    if (fromState == 4) {
                        OSLiquidSearchBar.this.getLeftIcon().setAlpha(1.0f);
                    } else {
                        OSLiquidSearchBar.this.getLeftIcon().setAlpha(f);
                    }
                }
            }

            @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
            public WindowInsetsCompat onProgress(WindowInsetsCompat insets, List<WindowInsetsAnimationCompat> runningAnimations) {
                float f;
                Intrinsics.checkNotNullParameter(insets, "insets");
                Intrinsics.checkNotNullParameter(runningAnimations, "runningAnimations");
                List<WindowInsetsAnimationCompat> list = runningAnimations;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        if ((((WindowInsetsAnimationCompat) it.next()).getTypeMask() & WindowInsetsCompat.Type.ime()) != 0) {
                            Insets insets2 = insets.getInsets(WindowInsetsCompat.Type.ime());
                            Intrinsics.checkNotNullExpressionValue(insets2, "insets.getInsets(WindowInsetsCompat.Type.ime())");
                            Insets insetsOf = Insets.of(insets2.left, insets2.top, insets2.right, insets2.bottom);
                            Intrinsics.checkNotNullExpressionValue(insetsOf, "of(\n                    …                        )");
                            float f4 = insetsOf.top - insetsOf.bottom;
                            OSLiquidSearchBar.this.setTranslationY(f4);
                            Insets insets3 = insets.getInsets(WindowInsetsCompat.Type.ime());
                            Intrinsics.checkNotNullExpressionValue(insets3, "insets.getInsets(WindowInsetsCompat.Type.ime())");
                            if (OSLiquidSearchBar.this.imeMaxHeight > 0.0f) {
                                f = insets3.bottom / OSLiquidSearchBar.this.imeMaxHeight;
                            } else {
                                f = insets3.bottom > 0 ? 1.0f : 0.0f;
                            }
                            if (fromState != 4) {
                                if (Math.abs(f4) <= OSLiquidSearchBar.this.getHeight() * 2) {
                                    OSLiquidSearchBar.this.getLeftIcon().setAlpha(0.0f);
                                    break;
                                }
                                OSLiquidSearchBar.this.getLeftIcon().setAlpha(f);
                                break;
                            }
                            OSLiquidSearchBar.this.getLeftIcon().setAlpha(1.0f);
                            break;
                        }
                    }
                }
                return insets;
            }
        });
    }

    private final void exitSearchState(final boolean isEntrance) {
        SpringAnimation springAnimation = this.expandAnimator;
        if (springAnimation != null) {
            springAnimation.cancel();
        }
        getLeftIconWidth();
        final int editeDefaultMarginStart = getEditeDefaultMarginStart();
        final int editeTotalMarginStart = getEditeTotalMarginStart();
        final boolean zHaveRightIcon = haveRightIcon();
        final boolean zHaveRight2Icon = haveRight2Icon();
        Context context = getContext();
        String[] strArr = j.f8764a;
        final float fA = a.a(context, LIQUID_SEARCHBAR_EXIT_SPRING_FINAL_POSITION);
        SpringAnimation springAnimation2 = new SpringAnimation(new FloatValueHolder());
        SpringForce springForce = new SpringForce();
        springForce.setDampingRatio(0.75f);
        springForce.setStiffness(300.0f);
        springForce.setFinalPosition(fA);
        springAnimation2.setSpring(springForce);
        springAnimation2.setStartValue(0.0f);
        springAnimation2.addUpdateListener(new DynamicAnimation.OnAnimationUpdateListener() { // from class: je.n
            @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
            public final void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f4) {
                OSLiquidSearchBar.exitSearchState$lambda$45$lambda$43(fA, this, zHaveRightIcon, zHaveRight2Icon, isEntrance, editeTotalMarginStart, editeDefaultMarginStart, dynamicAnimation, f, f4);
            }
        });
        springAnimation2.addEndListener(new je.j(this, 4));
        springAnimation2.start();
        this.expandAnimator = springAnimation2;
    }

    public static /* synthetic */ void exitSearchState$default(OSLiquidSearchBar oSLiquidSearchBar, boolean z2, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: exitSearchState");
        }
        if ((i8 & 1) != 0) {
            z2 = false;
        }
        oSLiquidSearchBar.exitSearchState(z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void exitSearchState$lambda$45$lambda$43(float f, OSLiquidSearchBar this$0, boolean z2, boolean z3, boolean z5, int i8, int i9, DynamicAnimation dynamicAnimation, float f4, float f10) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        float fAbs = Math.abs(f4) / f;
        float f11 = 1 - fAbs;
        this$0.getLeftIcon().setAlpha(f11);
        float f12 = (f11 * 0.7f) + 0.3f;
        this$0.getLeftIcon().setScaleX(f12);
        this$0.getLeftIcon().setScaleY(f12);
        float f13 = (0.7f * fAbs) + 0.3f;
        if (z2) {
            this$0.getRightIcon().setAlpha(fAbs);
            this$0.getRightIcon().setScaleX(f13);
            this$0.getRightIcon().setScaleY(f13);
        }
        if (z3) {
            this$0.getRightIcon2().setAlpha(fAbs);
            this$0.getRightIcon2().setScaleX(f13);
            this$0.getRightIcon2().setScaleY(f13);
        }
        ViewGroup.LayoutParams layoutParams = this$0.getEditeTextContainer().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.setMarginEnd((int) (this$0.getEditeTotalMarginEnd(z5) * fAbs));
        layoutParams2.setMarginStart((int) (((i8 - i9) * f11) + i9));
        this$0.getEditeTextContainer().setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void exitSearchState$lambda$45$lambda$44(OSLiquidSearchBar this$0, DynamicAnimation dynamicAnimation, boolean z2, float f, float f4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLeftIcon().setVisibility(8);
        this$0.getEditeTextContainer().setClickable(true);
        this$0.getEditeTextContainer().attachPressAnim();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void exitSearchStateCompose$lambda$27$lambda$25(int i8, int i9, float f, OSLiquidSearchBar this$0, int i10, int i11, int i12, int i13, DynamicAnimation dynamicAnimation, float f4, float f10) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        float f11 = i9;
        float fAbs = Math.abs(f4 - f11) / (f - f11);
        float f12 = 1;
        float f13 = ((f12 - fAbs) * 0.7f) + 0.3f;
        this$0.getLeftIcon().setScaleX(f13);
        this$0.getLeftIcon().setScaleY(f13);
        ViewGroup.LayoutParams layoutParams = this$0.getEditeTextContainer().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = (int) (i10 - ((i10 - i11) * fAbs));
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = (int) (i12 - ((i12 - i13) * fAbs));
        this$0.getEditeTextContainer().setLayoutParams(layoutParams2);
        float f14 = 100 * fAbs;
        if (f14 <= 20.0f) {
            float f15 = fAbs * 5;
            float f16 = f12 - f15;
            this$0.getLeftIcon().setAlpha(f16);
            this$0.getInnerRightIcon().setAlpha(f16);
            this$0.getButtonMode().setAlpha(f15);
        } else {
            this$0.getLeftIcon().setAlpha(0.0f);
            this$0.getInnerRightIcon().setAlpha(0.0f);
            this$0.getButtonMode().setAlpha(1.0f);
        }
        if (f14 >= 20.0f && f14 <= 40.0f) {
            float f17 = 1.0f - (((f14 - 20) / 100.0f) * 5);
            this$0.getInnerLeftIcon().setAlpha(f17);
            this$0.getSearchEditText().setAlpha(f17);
        } else if (f14 > 40.0f) {
            this$0.getInnerLeftIcon().setAlpha(0.0f);
            this$0.getSearchEditText().setAlpha(0.0f);
        } else {
            this$0.getInnerLeftIcon().setAlpha(1.0f);
            this$0.getSearchEditText().setAlpha(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void exitSearchStateCompose$lambda$27$lambda$26(OSLiquidSearchBar this$0, DynamicAnimation dynamicAnimation, boolean z2, float f, float f4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getEditeTextContainer().setClickable(true);
        this$0.getLeftIcon().setVisibility(8);
        this$0.getSearchEditText().setVisibility(8);
        this$0.getInnerLeftIcon().setVisibility(8);
    }

    private final OSIconTextView getButtonMode() {
        Object value = this.buttonMode.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-buttonMode>(...)");
        return (OSIconTextView) value;
    }

    private final int getButtonModeHeight() {
        return getResources().getDimensionPixelSize(R.dimen.os_search_bar_btn_mode_height);
    }

    private final int getEditeDefaultMarginEnd() {
        return getResources().getDimensionPixelSize(R.dimen.os_space150);
    }

    private final int getEditeDefaultMarginStart() {
        return getResources().getDimensionPixelSize(R.dimen.os_space150);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OSLiquidContainerRootLayout getEditeTextContainer() {
        Object value = this.editeTextContainer.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-editeTextContainer>(...)");
        return (OSLiquidContainerRootLayout) value;
    }

    private final int getEditeTotalMarginEnd(boolean isEntrance) {
        int editeDefaultMarginEnd = getEditeDefaultMarginEnd();
        int rightIconWidth = (haveRightIcon() ? getRightIconWidth() + editeDefaultMarginEnd : 0) + (haveRight2Icon() ? getRightIcon2Width() + editeDefaultMarginEnd : 0);
        if (!haveRightIcon() && !haveRight2Icon() && !isEntrance) {
            editeDefaultMarginEnd = 0;
        }
        return rightIconWidth + editeDefaultMarginEnd;
    }

    public static /* synthetic */ int getEditeTotalMarginEnd$default(OSLiquidSearchBar oSLiquidSearchBar, boolean z2, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getEditeTotalMarginEnd");
        }
        if ((i8 & 1) != 0) {
            z2 = false;
        }
        return oSLiquidSearchBar.getEditeTotalMarginEnd(z2);
    }

    private final int getEditeTotalMarginEndNoAnim(boolean isEntrance) {
        int editeDefaultMarginEnd = 0;
        int rightIconWidth = (getRightIcon().getVisibility() != 8 ? getRightIconWidth() + getEditeDefaultMarginEnd() : 0) + (getRightIcon2().getVisibility() != 8 ? getRightIcon2Width() + getEditeDefaultMarginEnd() : 0);
        if (getRightIcon2().getVisibility() == 0 || getRightIcon().getVisibility() == 0 || isEntrance) {
            editeDefaultMarginEnd = getEditeDefaultMarginEnd();
        }
        return rightIconWidth + editeDefaultMarginEnd;
    }

    public static /* synthetic */ int getEditeTotalMarginEndNoAnim$default(OSLiquidSearchBar oSLiquidSearchBar, boolean z2, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getEditeTotalMarginEndNoAnim");
        }
        if ((i8 & 1) != 0) {
            z2 = false;
        }
        return oSLiquidSearchBar.getEditeTotalMarginEndNoAnim(z2);
    }

    private final int getEditeTotalMarginStart() {
        return getEditeDefaultMarginStart() + (getLeftIcon().getVisibility() != 8 ? getLeftIconWidth() : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ViewStub getEdittextViewStub() {
        Object value = this.edittextViewStub.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-edittextViewStub>(...)");
        return (ViewStub) value;
    }

    private final OSIconTextView getInnerLeftIcon() {
        Object value = this.innerLeftIcon.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-innerLeftIcon>(...)");
        return (OSIconTextView) value;
    }

    private final OSIconTextView getInnerRightIcon() {
        Object value = this.innerRightIcon.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-innerRightIcon>(...)");
        return (OSIconTextView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OSLiquidButton getLeftIcon() {
        Object value = this.leftIcon.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-leftIcon>(...)");
        return (OSLiquidButton) value;
    }

    private final int getLeftIconWidth() {
        return getResources().getDimensionPixelSize(R.dimen.os_search_bar_out_icon_size);
    }

    private final OSLiquidButton getRightIcon() {
        Object value = this.rightIcon.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-rightIcon>(...)");
        return (OSLiquidButton) value;
    }

    private final OSLiquidButton getRightIcon2() {
        Object value = this.rightIcon2.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-rightIcon2>(...)");
        return (OSLiquidButton) value;
    }

    private final int getRightIcon2Width() {
        return getResources().getDimensionPixelSize(R.dimen.os_search_bar_out_icon_size);
    }

    private final int getRightIconWidth() {
        return getResources().getDimensionPixelSize(R.dimen.os_search_bar_out_icon_size);
    }

    private final int getRightSingleIconWidth() {
        return getResources().getDimensionPixelSize(R.dimen.os_search_bar_out_icon_size);
    }

    private final OSAutoCompleteTextView getSearchEditText() {
        Object value = this.searchEditText.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-searchEditText>(...)");
        return (OSAutoCompleteTextView) value;
    }

    private final int getSearchModeHeight() {
        return getResources().getDimensionPixelSize(R.dimen.os_search_bar_out_icon_size);
    }

    private final void goSearchState(final Boolean isScaleHeight) {
        SpringAnimation springAnimation = this.expandAnimator;
        if (springAnimation != null) {
            springAnimation.cancel();
        }
        final int leftIconWidth = getLeftIconWidth();
        final int editeDefaultMarginStart = getEditeDefaultMarginStart();
        int editeTotalMarginStart = getEditeTotalMarginStart();
        final boolean zHaveRightIcon = haveRightIcon();
        final boolean zHaveRight2Icon = haveRight2Icon();
        final float scaleY = getEditeTextContainer().getScaleY();
        SpringAnimation springAnimation2 = new SpringAnimation(new FloatValueHolder());
        SpringForce springForce = new SpringForce();
        springForce.setDampingRatio(0.75f);
        springForce.setStiffness(300.0f);
        springForce.setFinalPosition(editeTotalMarginStart);
        springAnimation2.setSpring(springForce);
        springAnimation2.setStartValue(editeDefaultMarginStart);
        getLeftIcon().setVisibility(0);
        getLeftIcon().setAlpha(0.0f);
        springAnimation2.addUpdateListener(new DynamicAnimation.OnAnimationUpdateListener() { // from class: je.m
            @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
            public final void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f4) {
                OSLiquidSearchBar.goSearchState$lambda$40$lambda$38(editeDefaultMarginStart, leftIconWidth, this, zHaveRightIcon, zHaveRight2Icon, isScaleHeight, scaleY, dynamicAnimation, f, f4);
            }
        });
        springAnimation2.addEndListener(new je.j(this, 3));
        springAnimation2.start();
        this.expandAnimator = springAnimation2;
    }

    public static /* synthetic */ void goSearchState$default(OSLiquidSearchBar oSLiquidSearchBar, Boolean bool, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: goSearchState");
        }
        if ((i8 & 1) != 0) {
            bool = Boolean.FALSE;
        }
        oSLiquidSearchBar.goSearchState(bool);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void goSearchState$lambda$40$lambda$38(int i8, int i9, OSLiquidSearchBar this$0, boolean z2, boolean z3, Boolean bool, float f, DynamicAnimation dynamicAnimation, float f4, float f10) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        float f11 = (f4 - i8) / i9;
        this$0.getLeftIcon().setAlpha(f11);
        float f12 = (f11 * 0.7f) + 0.3f;
        this$0.getLeftIcon().setScaleX(f12);
        this$0.getLeftIcon().setScaleY(f12);
        float f13 = 1 - f11;
        float f14 = (0.7f * f13) + 0.3f;
        if (z2) {
            this$0.getRightIcon().setScaleX(f14);
            this$0.getRightIcon().setScaleY(f14);
            this$0.getRightIcon().setAlpha(f13);
        }
        if (z3) {
            this$0.getRightIcon2().setScaleX(f14);
            this$0.getRightIcon2().setScaleY(f14);
            this$0.getRightIcon2().setAlpha(f13);
        }
        ViewGroup.LayoutParams layoutParams = this$0.getEditeTextContainer().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.setMarginEnd((int) (this$0.getEditeTotalMarginEnd(true) * f13));
        layoutParams2.setMarginStart((int) f4);
        this$0.getEditeTextContainer().setLayoutParams(layoutParams2);
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            float fB = a1.a.b(f, 1.0f, f13, 1.0f);
            this$0.getEditeTextContainer().setScaleX(fB);
            this$0.getEditeTextContainer().setScaleY(fB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void goSearchState$lambda$40$lambda$39(OSLiquidSearchBar this$0, DynamicAnimation dynamicAnimation, boolean z2, float f, float f4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z2) {
            return;
        }
        this$0.getLeftIcon().setVisibility(0);
    }

    public static /* synthetic */ void goSearchStateForCompose$default(OSLiquidSearchBar oSLiquidSearchBar, boolean z2, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: goSearchStateForCompose");
        }
        if ((i8 & 1) != 0) {
            z2 = true;
        }
        oSLiquidSearchBar.goSearchStateForCompose(z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void goSearchStateForCompose$lambda$22$lambda$20(int i8, int i9, OSLiquidSearchBar this$0, int i10, int i11, DynamicAnimation dynamicAnimation, float f, float f4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        float f10 = i8;
        float f11 = i9 - i8;
        float f12 = (f - f10) / f11;
        float f13 = (0.7f * f12) + 0.3f;
        this$0.getLeftIcon().setScaleX(f13);
        this$0.getLeftIcon().setScaleY(f13);
        ViewGroup.LayoutParams layoutParams = this$0.getEditeTextContainer().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = (int) (((i10 - i11) * f12) + i11);
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = (int) ((f11 * f12) + f10);
        this$0.getEditeTextContainer().setLayoutParams(layoutParams2);
        float f14 = 100 * f12;
        if (f14 <= 20.0f) {
            float f15 = f12 * 5;
            this$0.getLeftIcon().setAlpha(f15);
            this$0.getInnerRightIcon().setAlpha(f15);
            this$0.getButtonMode().setAlpha(1 - f15);
        } else {
            this$0.getLeftIcon().setAlpha(1.0f);
            this$0.getInnerRightIcon().setAlpha(1.0f);
            this$0.getButtonMode().setAlpha(0.0f);
        }
        if (f14 >= 20.0f && f14 <= 40.0f) {
            float f16 = ((f14 - 20) / 100.0f) * 5;
            this$0.getInnerLeftIcon().setAlpha(f16);
            this$0.getSearchEditText().setAlpha(f16);
        } else if (f14 > 40.0f) {
            this$0.getInnerLeftIcon().setAlpha(1.0f);
            this$0.getSearchEditText().setAlpha(1.0f);
        } else {
            this$0.getInnerLeftIcon().setAlpha(0.0f);
            this$0.getSearchEditText().setAlpha(0.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void goSearchStateForCompose$lambda$22$lambda$21(OSLiquidSearchBar this$0, DynamicAnimation dynamicAnimation, boolean z2, float f, float f4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getButtonMode().setVisibility(8);
        this$0.getSearchEditText().requestFocus();
    }

    private final boolean haveRight2Icon() {
        return this.rightIconRes2 != null;
    }

    private final boolean haveRightIcon() {
        return this.rightIconRes != null;
    }

    private final void hideKeyboard() {
        Object systemService = getContext().getSystemService(TCCPSourceApi.KEY_FEATURE_INPUT_METHOD);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(getSearchEditText().getWindowToken(), 0);
    }

    private final void initAttributes(AttributeSet attrs) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int[] OSLiquidSearchBar = R.styleable.OSLiquidSearchBar;
        Intrinsics.checkNotNullExpressionValue(OSLiquidSearchBar, "OSLiquidSearchBar");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, OSLiquidSearchBar, 0, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        this.leftIconRes = typedArrayObtainStyledAttributes.getString(R.styleable.OSLiquidSearchBar_os_search_left_icon);
        this.rightIconRes = typedArrayObtainStyledAttributes.getString(R.styleable.OSLiquidSearchBar_os_search_right_icon);
        this.rightIconRes2 = typedArrayObtainStyledAttributes.getString(R.styleable.OSLiquidSearchBar_os_search_right_icon_2);
        this.innerRightIconRes = typedArrayObtainStyledAttributes.getString(R.styleable.OSLiquidSearchBar_os_search_inner_right_icon);
        this.innerLeftIconRes = typedArrayObtainStyledAttributes.getString(R.styleable.OSLiquidSearchBar_os_search_inner_left_icon);
        String string = typedArrayObtainStyledAttributes.getString(R.styleable.OSLiquidSearchBar_os_search_hint);
        if (string == null) {
            string = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.styleable.OS…Bar_os_search_hint) ?: \"\"");
        }
        this.hintText = string;
        String string2 = typedArrayObtainStyledAttributes.getString(R.styleable.OSLiquidSearchBar_os_search_button_mode_icon);
        if (string2 == null) {
            string2 = typedArrayObtainStyledAttributes.getResources().getString(R.string.os_search);
        }
        this.buttonModeIconRes = string2;
        this.edittextLayoutRes = typedArrayObtainStyledAttributes.getResourceId(R.styleable.OSLiquidSearchBar_os_search_edittext_layout, -1);
        this.mCurrentSearchState = typedArrayObtainStyledAttributes.getInt(R.styleable.OSLiquidSearchBar_os_search_init_state, 0);
        this.edittextLayoutRes = typedArrayObtainStyledAttributes.getResourceId(R.styleable.OSLiquidSearchBar_os_search_edittext_layout, -1);
        this.isUseUnionBlur = typedArrayObtainStyledAttributes.getBoolean(R.styleable.OSLiquidSearchBar_os_enable_union_effect, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    private final void initViews(AttributeSet attrs) {
        removeAllViews();
        LayoutInflater.from(getContext()).inflate(R.layout.os_liquid_searchbar_layout, (ViewGroup) this, true);
        ViewStub edittextViewStub = getEdittextViewStub();
        int i8 = this.edittextLayoutRes;
        if (i8 <= -1) {
            i8 = R.layout.os_liquid_searchbar_edittext_default_layout;
        }
        edittextViewStub.setLayoutResource(i8);
        getEditeTextContainer().setScaleRatio(1.05f);
        String str = this.rightIconRes;
        if (str != null) {
            this.mHaveRightIcon = true;
            getRightIcon().setIcon(str);
            getRightIcon().setVisibility(0);
        }
        String str2 = this.rightIconRes2;
        if (str2 != null) {
            this.mHaveRightIcon = true;
            getRightIcon2().setIcon(str2);
            getRightIcon2().setVisibility(0);
        }
        String str3 = this.rightIconRes2;
        if (str3 != null) {
            this.mHaveRightIcon = true;
            getRightIcon2().setIcon(str3);
            getRightIcon2().setVisibility(0);
        }
        String str4 = this.innerLeftIconRes;
        if (str4 != null) {
            getInnerLeftIcon().setText(str4);
        }
        String str5 = this.innerRightIconRes;
        if (str5 != null) {
            changeIcon(getInnerRightIcon(), false, str5);
            getInnerRightIcon().setVisibility(0);
        }
        getButtonMode().setText(this.buttonModeIconRes);
        getSearchEditText().setHint(this.hintText);
        setSearchBarState$default(this, -1, this.mCurrentSearchState, false, null, 12, null);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void scaleButtonMode$lambda$33$lambda$31(OSLiquidSearchBar this$0, DynamicAnimation dynamicAnimation, float f, float f4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewGroup.LayoutParams layoutParams = this$0.getButtonMode().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        int i8 = (int) f;
        layoutParams2.width = i8;
        layoutParams2.height = i8;
        this$0.getButtonMode().setLayoutParams(layoutParams2);
        this$0.getButtonMode().setAlpha(f * 5);
        ViewGroup.LayoutParams layoutParams3 = this$0.getEditeTextContainer().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
        ((ViewGroup.MarginLayoutParams) layoutParams4).width = i8;
        ((ViewGroup.MarginLayoutParams) layoutParams4).height = i8;
        this$0.getEditeTextContainer().setLayoutParams(layoutParams4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void scaleButtonMode$lambda$33$lambda$32(OSLiquidSearchBar this$0, DynamicAnimation dynamicAnimation, boolean z2, float f, float f4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getEditeTextContainer().setClickable(true);
        this$0.getLeftIcon().setVisibility(8);
        this$0.getButtonMode().setAlpha(1.0f);
    }

    public static /* synthetic */ void setSearchBarState$default(OSLiquidSearchBar oSLiquidSearchBar, int i8, int i9, boolean z2, Boolean bool, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setSearchBarState");
        }
        if ((i10 & 4) != 0) {
            z2 = false;
        }
        if ((i10 & 8) != 0) {
            bool = Boolean.FALSE;
        }
        oSLiquidSearchBar.setSearchBarState(i8, i9, z2, bool);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setSearchBarState$lambda$11(OSLiquidSearchBar this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showKeyboard();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setSearchBarState$lambda$14(OSLiquidSearchBar this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewGroup.LayoutParams layoutParams = this$0.getEditeTextContainer().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = ((this$0.getMeasuredWidth() - this$0.getLeftIconWidth()) - this$0.getEditeDefaultMarginStart()) - (this$0.getResources().getDimensionPixelSize(R.dimen.os_space200) * 2);
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = this$0.getSearchModeHeight();
        this$0.getEditeTextContainer().setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setSearchBarState$lambda$16(OSLiquidSearchBar this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewGroup.LayoutParams layoutParams = this$0.getEditeTextContainer().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = ((this$0.getMeasuredWidth() - this$0.getLeftIconWidth()) - this$0.getEditeDefaultMarginStart()) - (this$0.getResources().getDimensionPixelSize(R.dimen.os_space200) * 2);
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = this$0.getSearchModeHeight();
        this$0.getEditeTextContainer().setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setSearchBarState$lambda$17(OSLiquidSearchBar this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showKeyboard();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setSearchBarState$lambda$9(OSLiquidSearchBar this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showKeyboard();
    }

    private final void setShadowShow(boolean showShadow) {
        getLeftIcon().setShowShadow(showShadow);
        getEditeTextContainer().setShowShadow(showShadow);
        getRightIcon().setShowShadow(showShadow);
        getRightIcon2().setShowShadow(showShadow);
    }

    private final void setupClickListeners() {
        getLeftIcon().setOnLiquidClickListener(new Function0<Unit>() { // from class: com.transsion.widgetsliquid.view.OSLiquidSearchBar.setupClickListeners.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Function0 function0 = OSLiquidSearchBar.this.onBackClickListener;
                if (function0 != null) {
                    function0.invoke();
                }
            }
        });
        getRightIcon().setOnLiquidClickListener(new Function0<Unit>() { // from class: com.transsion.widgetsliquid.view.OSLiquidSearchBar.setupClickListeners.2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Function0 function0 = OSLiquidSearchBar.this.onRightIconClickListener;
                if (function0 != null) {
                    function0.invoke();
                }
            }
        });
        getRightIcon2().setOnLiquidClickListener(new Function0<Unit>() { // from class: com.transsion.widgetsliquid.view.OSLiquidSearchBar.setupClickListeners.3
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Function0 function0 = OSLiquidSearchBar.this.onRightIcon2ClickListener;
                if (function0 != null) {
                    function0.invoke();
                }
            }
        });
        final int i8 = 0;
        getInnerRightIcon().setOnClickListener(new View.OnClickListener(this) { // from class: je.i

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ OSLiquidSearchBar f6209b;

            {
                this.f6209b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i9 = i8;
                OSLiquidSearchBar oSLiquidSearchBar = this.f6209b;
                switch (i9) {
                    case 0:
                        OSLiquidSearchBar.setupClickListeners$lambda$34(oSLiquidSearchBar, view);
                        break;
                    default:
                        OSLiquidSearchBar.setupClickListeners$lambda$35(oSLiquidSearchBar, view);
                        break;
                }
            }
        });
        final int i9 = 1;
        getSearchEditText().setOnClickListener(new View.OnClickListener(this) { // from class: je.i

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ OSLiquidSearchBar f6209b;

            {
                this.f6209b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i10 = i9;
                OSLiquidSearchBar oSLiquidSearchBar = this.f6209b;
                switch (i10) {
                    case 0:
                        OSLiquidSearchBar.setupClickListeners$lambda$34(oSLiquidSearchBar, view);
                        break;
                    default:
                        OSLiquidSearchBar.setupClickListeners$lambda$35(oSLiquidSearchBar, view);
                        break;
                }
            }
        });
        getEditeTextContainer().setOnLiquidClickListener(new Function0<Unit>() { // from class: com.transsion.widgetsliquid.view.OSLiquidSearchBar.setupClickListeners.6
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (OSLiquidSearchBar.this.mCurrentSearchState == 3 || OSLiquidSearchBar.this.mCurrentSearchState == 4 || OSLiquidSearchBar.this.mCurrentSearchState == 5) {
                    Function1 function1 = OSLiquidSearchBar.this.mSearchButtonModeClickListener;
                    if (function1 != null) {
                        function1.invoke(OSLiquidSearchBar.this.getEditeTextContainer());
                        return;
                    }
                    return;
                }
                Function1 function2 = OSLiquidSearchBar.this.mSearchBarClickListener;
                if (function2 != null) {
                    function2.invoke(OSLiquidSearchBar.this.getEditeTextContainer());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupClickListeners$lambda$34(OSLiquidSearchBar this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!TextUtils.isEmpty(this$0.getSearchEditText().getText()) || this$0.getSearchEditText().length() > 0) {
            this$0.getSearchEditText().setText((CharSequence) null);
            this$0.showKeyboard();
        } else {
            Function1<? super View, Unit> function1 = this$0.mSearchBarInnerRightIconClickListener;
            if (function1 != null) {
                function1.invoke(this$0.getInnerRightIcon());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupClickListeners$lambda$35(OSLiquidSearchBar this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i8 = this$0.mCurrentSearchState;
        if (i8 == 3 || i8 == 4 || i8 == 5) {
            Function1<? super View, Unit> function1 = this$0.mSearchButtonModeClickListener;
            if (function1 != null) {
                function1.invoke(this$0.getEditeTextContainer());
                return;
            }
            return;
        }
        Function1<? super View, Unit> function2 = this$0.mSearchBarClickListener;
        if (function2 != null) {
            function2.invoke(this$0.getEditeTextContainer());
        }
    }

    private final void showKeyboard() {
        Object systemService = getContext().getSystemService(TCCPSourceApi.KEY_FEATURE_INPUT_METHOD);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(getSearchEditText(), 1);
    }

    public final void changeIcon(OSIconTextView oSIconTextView, boolean z2, String str) {
        Intrinsics.checkNotNullParameter(oSIconTextView, "<this>");
        int dimensionPixelSize = oSIconTextView.getResources().getDimensionPixelSize(z2 ? R.dimen.os_search_bar_icon_inner_close_size : R.dimen.os_search_bar_icon_inner_cus_size);
        ViewGroup.LayoutParams layoutParams = oSIconTextView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = dimensionPixelSize;
            layoutParams.height = dimensionPixelSize;
            getInnerRightIcon().setLayoutParams(layoutParams);
        }
        oSIconTextView.setText(str);
        oSIconTextView.setTextSize(0, dimensionPixelSize);
    }

    public final void copyScale(OSLiquidSearchBar osLiquidSearchBar) {
        Intrinsics.checkNotNullParameter(osLiquidSearchBar, "osLiquidSearchBar");
        getEditeTextContainer().setScaleX(osLiquidSearchBar.getEditTextContainer().getScaleX());
        getEditeTextContainer().setScaleY(osLiquidSearchBar.getEditTextContainer().getScaleY());
    }

    public final SpringAnimation endSearchForTransition() {
        setSearchBarState$default(this, this.mCurrentSearchState, 0, true, null, 8, null);
        return this.expandAnimator;
    }

    public final void exitSearchStateCompose() {
        int leftIconWidth = getLeftIconWidth();
        int editeDefaultMarginStart = getEditeDefaultMarginStart();
        final int editeTotalMarginStart = getEditeTotalMarginStart();
        int measuredWidth = getMeasuredWidth();
        Context context = getContext();
        int i8 = this.singleIconDimen;
        String[] strArr = j.f8764a;
        final float fA = (measuredWidth - a.a(context, i8)) - editeDefaultMarginStart;
        final int i9 = leftIconWidth + editeDefaultMarginStart;
        final int searchModeHeight = getSearchModeHeight();
        final int buttonModeHeight = getButtonModeHeight();
        final int measuredWidth2 = ((getMeasuredWidth() - getLeftIconWidth()) - getEditeDefaultMarginStart()) - (getResources().getDimensionPixelSize(R.dimen.os_space200) * 2);
        final int buttonModeHeight2 = getButtonModeHeight();
        SpringAnimation springAnimation = new SpringAnimation(new FloatValueHolder());
        SpringForce springForce = new SpringForce();
        springForce.setDampingRatio(0.75f);
        springForce.setStiffness(300.0f);
        springForce.setFinalPosition(fA);
        springAnimation.setSpring(springForce);
        springAnimation.setStartValue(i9);
        springAnimation.addUpdateListener(new DynamicAnimation.OnAnimationUpdateListener() { // from class: je.k
            @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
            public final void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f4) {
                OSLiquidSearchBar.exitSearchStateCompose$lambda$27$lambda$25(editeTotalMarginStart, i9, fA, this, searchModeHeight, buttonModeHeight, measuredWidth2, buttonModeHeight2, dynamicAnimation, f, f4);
            }
        });
        springAnimation.addEndListener(new je.j(this, 1));
        springAnimation.start();
        this.expandAnimator = springAnimation;
    }

    public final View getBackView() {
        return getLeftIcon();
    }

    public final View getDeleteButton() {
        return getInnerRightIcon();
    }

    public final EditText getEditText() {
        return getSearchEditText();
    }

    public final OSLiquidContainerRootLayout getEditTextContainer() {
        return getEditeTextContainer();
    }

    public final AutoCompleteTextView getEditTextView() {
        return getSearchEditText();
    }

    public final View getInnerRightIconView() {
        return getDeleteButton();
    }

    public final OSLiquidButton getLeftIconView() {
        return getLeftIcon();
    }

    public final OSLiquidButton getRightIcon2View() {
        return getRightIcon2();
    }

    public final OSLiquidButton getRightIconView() {
        return getRightIcon();
    }

    /* JADX INFO: renamed from: getSearchBarState, reason: from getter */
    public final int getMCurrentSearchState() {
        return this.mCurrentSearchState;
    }

    public final View getSearchIconView() {
        return getInnerLeftIcon();
    }

    public final String getText() {
        return getSearchEditText().getText().toString();
    }

    public final void goSearchStateForCompose(boolean isBackIconVisible) {
        final int buttonModeHeight = getButtonModeHeight();
        final int searchModeHeight = getSearchModeHeight();
        final int buttonModeHeight2 = getButtonModeHeight();
        final int measuredWidth = ((getMeasuredWidth() - getLeftIconWidth()) - getEditeDefaultMarginStart()) - (getResources().getDimensionPixelSize(R.dimen.os_space200) * 2);
        SpringAnimation springAnimation = new SpringAnimation(new FloatValueHolder());
        SpringForce springForce = new SpringForce();
        springForce.setDampingRatio(0.75f);
        springForce.setStiffness(300.0f);
        springForce.setFinalPosition(measuredWidth);
        springAnimation.setSpring(springForce);
        springAnimation.setStartValue(buttonModeHeight2);
        if (isBackIconVisible) {
            getLeftIcon().setVisibility(0);
        } else {
            getLeftIcon().setVisibility(8);
        }
        getLeftIcon().setAlpha(0.0f);
        springAnimation.addUpdateListener(new DynamicAnimation.OnAnimationUpdateListener() { // from class: je.l
            @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
            public final void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f4) {
                OSLiquidSearchBar.goSearchStateForCompose$lambda$22$lambda$20(buttonModeHeight2, measuredWidth, this, searchModeHeight, buttonModeHeight, dynamicAnimation, f, f4);
            }
        });
        springAnimation.addEndListener(new je.j(this, 2));
        springAnimation.start();
        this.expandAnimator = springAnimation;
    }

    public final boolean isOnSearch() {
        int i8 = this.mCurrentSearchState;
        return (i8 == 0 || i8 == 3) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        z8.b(TAG, "onAttachedToWindow");
        if (this.mTextWatcher != null) {
            getSearchEditText().addTextChangedListener(this.mTextWatcher);
        } else {
            Log.w(TAG, "addTextChangedListener failed:mTextWatcher is null");
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        z8.b(TAG, "onDetachedFromWindow");
        SpringAnimation springAnimation = this.expandAnimator;
        if (springAnimation != null) {
            springAnimation.cancel();
        }
        if (this.mTextWatcher != null) {
            getSearchEditText().removeTextChangedListener(this.mTextWatcher);
        } else {
            Log.w(TAG, "removeTextChangedListener failed:mTextWatcher is null");
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof SavedState)) {
            super.onRestoreInstanceState(state);
            return;
        }
        SavedState savedState = (SavedState) state;
        super.onRestoreInstanceState(savedState.getSuperState());
        int searchState = savedState.getSearchState();
        this.mCurrentSearchState = searchState;
        setSearchBarState$default(this, -1, searchState, false, null, 8, null);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.setSearchState(this.mCurrentSearchState);
        return savedState;
    }

    public final void requireSearchAnimManagerTrans(boolean requireSearchAnimManagerTrans) {
        this.mRequireSearchAnimManagerTrans = requireSearchAnimManagerTrans;
    }

    public final void scaleButtonMode(boolean scale) {
        int buttonModeHeight = getButtonModeHeight();
        int searchModeHeight = getSearchModeHeight();
        SpringAnimation springAnimation = new SpringAnimation(new FloatValueHolder());
        SpringForce springForce = new SpringForce();
        springForce.setDampingRatio(0.75f);
        springForce.setStiffness(300.0f);
        springForce.setFinalPosition(scale ? buttonModeHeight : searchModeHeight);
        springAnimation.setSpring(springForce);
        springAnimation.setStartValue(scale ? searchModeHeight : buttonModeHeight);
        springAnimation.addUpdateListener(new h(this, 1));
        springAnimation.addEndListener(new je.j(this, 0));
        springAnimation.start();
        this.expandAnimator = springAnimation;
    }

    public final void setBlurNightMode(boolean nightMode) {
        getEditeTextContainer().setBlurNightMode(nightMode);
        getLeftIcon().setBlurNightMode(nightMode);
        getRightIcon().setBlurNightMode(nightMode);
        getRightIcon2().setBlurNightMode(nightMode);
    }

    public final void setHint(String hint) {
        Intrinsics.checkNotNullParameter(hint, "hint");
        getSearchEditText().setHint(hint);
    }

    public final void setImeHeight(float imeHeight) {
        this.imeMaxHeight = imeHeight;
    }

    public final void setInnerRightIconRes(String iconRes) {
        this.innerRightIconRes = iconRes;
        dealDeleteIconVisibility();
    }

    public final void setInputMax(int max, int resId) {
        setInputMax(max, getResources().getString(resId));
    }

    public final void setLeftIcon(String drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        this.leftIconRes = drawable;
        getLeftIcon().setIcon(drawable);
    }

    @RequiresApi(31)
    public final void setMixLevel(int mixLevel) {
        getRightIcon().setMixLevel(mixLevel);
        getRightIcon2().setMixLevel(mixLevel);
        getLeftIcon().setMixLevel(mixLevel);
        getEditeTextContainer().setMixLevel(mixLevel);
    }

    public final void setOnBackClickListener(Function0<Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onBackClickListener = listener;
    }

    public final void setOnRightIcon2ClickListener(Function0<Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onRightIcon2ClickListener = listener;
    }

    public final void setOnRightIconClickListener(Function0<Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onRightIconClickListener = listener;
    }

    public final void setOnSearchBarInnerRightIconClickListener(Function1<? super View, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mSearchBarInnerRightIconClickListener = listener;
    }

    public final void setOnSearchBarListener(Function1<? super View, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mSearchBarClickListener = listener;
    }

    public final void setOnSearchButtonModeClickListener(Function1<? super View, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mSearchButtonModeClickListener = listener;
    }

    public final void setRightIcon(String drawable) {
        this.rightIconRes = drawable;
        getRightIcon().setIcon(drawable);
    }

    public final void setRightIcon2(String drawable) {
        this.rightIconRes2 = drawable;
        getRightIcon2().setIcon(drawable);
    }

    public final void setSearchBarState(int fromState, int toState, boolean animation, Boolean scaleHeight) {
        StringBuilder sbR = d.r(fromState, toState, "setSearchBarState: fromState = ", " toState = ", " animation = ");
        sbR.append(animation);
        z8.b(TAG, sbR.toString());
        if (fromState == toState) {
            Log.v(TAG, "fromState == toState return");
        }
        int i8 = this.mCurrentSearchState;
        this.mCurrentSearchState = toState;
        if (toState == 0) {
            getSearchEditText().setFocusable(false);
            getSearchEditText().setLongClickable(false);
            getSearchEditText().setFocusableInTouchMode(false);
            getSearchEditText().setClickable(false);
            getSearchEditText().setShouldInterceptEvents(false);
            getEditeTextContainer().setClickable(true);
            getEditeTextContainer().attachPressAnim();
            getRightIcon2().setVisibility(TextUtils.isEmpty(this.rightIconRes2) ? 8 : 0);
            getRightIcon().setVisibility(TextUtils.isEmpty(this.rightIconRes) ? 8 : 0);
            if (animation) {
                getEditeTextContainer().setClickable(false);
                getEditeTextContainer().detachPressAnim();
                exitSearchState(true);
            } else {
                getLeftIcon().setVisibility(8);
                ViewGroup.LayoutParams layoutParams = getEditeTextContainer().getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                layoutParams2.setMarginStart(getEditeDefaultMarginStart());
                layoutParams2.setMarginEnd(getEditeTotalMarginEndNoAnim(true));
                getEditeTextContainer().setLayoutParams(layoutParams2);
            }
            clearFocus();
            hideKeyboard();
            return;
        }
        if (toState == 1) {
            getSearchEditText().setFocusable(true);
            getSearchEditText().setLongClickable(true);
            getSearchEditText().setFocusableInTouchMode(true);
            getSearchEditText().setClickable(true);
            getSearchEditText().setShouldInterceptEvents(true);
            getEditeTextContainer().setClickable(false);
            getEditeTextContainer().detachPressAnim();
            getRightIcon2().setVisibility(8);
            getRightIcon().setVisibility(8);
            if (animation) {
                getRightIcon2().setVisibility(TextUtils.isEmpty(this.rightIconRes2) ? 8 : 0);
                getRightIcon().setVisibility(TextUtils.isEmpty(this.rightIconRes) ? 8 : 0);
                getLeftIcon().setVisibility(0);
                goSearchState(scaleHeight);
            } else {
                getLeftIcon().setVisibility(0);
                getLeftIcon().setAlpha(1.0f);
                ViewGroup.LayoutParams layoutParams3 = getEditeTextContainer().getLayoutParams();
                Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
                layoutParams4.setMarginStart(getEditeTotalMarginStart());
                layoutParams4.setMarginEnd(getEditeTotalMarginEndNoAnim$default(this, false, 1, null));
                getEditeTextContainer().setLayoutParams(layoutParams4);
            }
            requestFocus();
            final int i9 = 0;
            postDelayed(new Runnable(this) { // from class: je.o

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ OSLiquidSearchBar f6233b;

                {
                    this.f6233b = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    int i10 = i9;
                    OSLiquidSearchBar oSLiquidSearchBar = this.f6233b;
                    switch (i10) {
                        case 0:
                            OSLiquidSearchBar.setSearchBarState$lambda$9(oSLiquidSearchBar);
                            break;
                        case 1:
                            OSLiquidSearchBar.setSearchBarState$lambda$11(oSLiquidSearchBar);
                            break;
                        case 2:
                            OSLiquidSearchBar.setSearchBarState$lambda$14(oSLiquidSearchBar);
                            break;
                        case 3:
                            OSLiquidSearchBar.setSearchBarState$lambda$16(oSLiquidSearchBar);
                            break;
                        default:
                            OSLiquidSearchBar.setSearchBarState$lambda$17(oSLiquidSearchBar);
                            break;
                    }
                }
            }, 50L);
            return;
        }
        if (toState == 2) {
            getSearchEditText().setFocusable(true);
            getSearchEditText().setLongClickable(true);
            getSearchEditText().setFocusableInTouchMode(true);
            getSearchEditText().setClickable(true);
            getSearchEditText().setShouldInterceptEvents(true);
            getEditeTextContainer().detachPressAnim();
            getLeftIcon().setVisibility(8);
            getRightIcon2().setVisibility(8);
            getRightIcon().setVisibility(8);
            ViewGroup.LayoutParams layoutParams5 = getEditeTextContainer().getLayoutParams();
            Intrinsics.checkNotNull(layoutParams5, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams6 = (ConstraintLayout.LayoutParams) layoutParams5;
            layoutParams6.setMarginStart(getEditeDefaultMarginStart());
            layoutParams6.setMarginEnd(getEditeDefaultMarginEnd());
            getEditeTextContainer().setLayoutParams(layoutParams6);
            getEditeTextContainer().setClickable(false);
            requestFocus();
            final int i10 = 1;
            postDelayed(new Runnable(this) { // from class: je.o

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ OSLiquidSearchBar f6233b;

                {
                    this.f6233b = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    int i11 = i10;
                    OSLiquidSearchBar oSLiquidSearchBar = this.f6233b;
                    switch (i11) {
                        case 0:
                            OSLiquidSearchBar.setSearchBarState$lambda$9(oSLiquidSearchBar);
                            break;
                        case 1:
                            OSLiquidSearchBar.setSearchBarState$lambda$11(oSLiquidSearchBar);
                            break;
                        case 2:
                            OSLiquidSearchBar.setSearchBarState$lambda$14(oSLiquidSearchBar);
                            break;
                        case 3:
                            OSLiquidSearchBar.setSearchBarState$lambda$16(oSLiquidSearchBar);
                            break;
                        default:
                            OSLiquidSearchBar.setSearchBarState$lambda$17(oSLiquidSearchBar);
                            break;
                    }
                }
            }, 50L);
            return;
        }
        if (toState == 3) {
            SpringAnimation springAnimation = this.expandAnimator;
            if (springAnimation != null) {
                springAnimation.cancel();
            }
            getSearchEditText().setFocusable(false);
            getSearchEditText().setLongClickable(false);
            getSearchEditText().setFocusableInTouchMode(false);
            getSearchEditText().setClickable(false);
            getSearchEditText().setShouldInterceptEvents(false);
            getEditeTextContainer().setClickable(true);
            getEditeTextContainer().attachPressAnim();
            getEditeTextContainer().setScaleRatio(1.25f);
            getRightIcon2().setVisibility(8);
            getRightIcon().setVisibility(8);
            getButtonMode().setVisibility(0);
            getSearchEditText().setVisibility(8);
            getLeftIcon().setVisibility(8);
            getInnerLeftIcon().setVisibility(8);
            getInnerRightIcon().setVisibility(8);
            if (!animation) {
                ViewGroup.LayoutParams layoutParams7 = getEditeTextContainer().getLayoutParams();
                Intrinsics.checkNotNull(layoutParams7, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams8 = (ConstraintLayout.LayoutParams) layoutParams7;
                ((ViewGroup.MarginLayoutParams) layoutParams8).width = getButtonModeHeight();
                ((ViewGroup.MarginLayoutParams) layoutParams8).height = getButtonModeHeight();
                getEditeTextContainer().setLayoutParams(layoutParams8);
            } else if (i8 == 5) {
                getButtonMode().setVisibility(0);
                scaleButtonMode(true);
            } else {
                getLeftIcon().setVisibility(0);
                getSearchEditText().setVisibility(0);
                getInnerLeftIcon().setVisibility(0);
                getButtonMode().setVisibility(0);
                exitSearchStateCompose();
            }
            clearFocus();
            hideKeyboard();
            return;
        }
        if (toState != 4) {
            if (toState != 5) {
                return;
            }
            SpringAnimation springAnimation2 = this.expandAnimator;
            if (springAnimation2 != null) {
                springAnimation2.cancel();
            }
            getSearchEditText().setFocusable(false);
            getSearchEditText().setLongClickable(false);
            getSearchEditText().setFocusableInTouchMode(false);
            getSearchEditText().setClickable(false);
            getSearchEditText().setShouldInterceptEvents(false);
            getEditeTextContainer().setClickable(true);
            getEditeTextContainer().attachPressAnim();
            getEditeTextContainer().setScaleRatio(1.05f);
            getRightIcon2().setVisibility(8);
            getRightIcon().setVisibility(8);
            getButtonMode().setVisibility(0);
            getSearchEditText().setVisibility(0);
            getLeftIcon().setVisibility(8);
            getInnerRightIcon().setVisibility(8);
            getInnerLeftIcon().setVisibility(0);
            if (animation) {
                getButtonMode().setVisibility(0);
                scaleButtonMode(false);
                goSearchStateForCompose(false);
            } else {
                getButtonMode().setVisibility(8);
                final int i11 = 2;
                post(new Runnable(this) { // from class: je.o

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ OSLiquidSearchBar f6233b;

                    {
                        this.f6233b = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        int i12 = i11;
                        OSLiquidSearchBar oSLiquidSearchBar = this.f6233b;
                        switch (i12) {
                            case 0:
                                OSLiquidSearchBar.setSearchBarState$lambda$9(oSLiquidSearchBar);
                                break;
                            case 1:
                                OSLiquidSearchBar.setSearchBarState$lambda$11(oSLiquidSearchBar);
                                break;
                            case 2:
                                OSLiquidSearchBar.setSearchBarState$lambda$14(oSLiquidSearchBar);
                                break;
                            case 3:
                                OSLiquidSearchBar.setSearchBarState$lambda$16(oSLiquidSearchBar);
                                break;
                            default:
                                OSLiquidSearchBar.setSearchBarState$lambda$17(oSLiquidSearchBar);
                                break;
                        }
                    }
                });
            }
            getSearchEditText().setAlpha(1.0f);
            getButtonMode().setAlpha(1.0f);
            clearFocus();
            hideKeyboard();
            return;
        }
        SpringAnimation springAnimation3 = this.expandAnimator;
        if (springAnimation3 != null) {
            springAnimation3.cancel();
        }
        getSearchEditText().setFocusable(true);
        getSearchEditText().setLongClickable(true);
        getSearchEditText().setFocusableInTouchMode(true);
        getSearchEditText().setClickable(true);
        getSearchEditText().setShouldInterceptEvents(true);
        getEditeTextContainer().setClickable(false);
        getEditeTextContainer().detachPressAnim();
        getEditeTextContainer().setScaleRatio(1.05f);
        getRightIcon2().setVisibility(8);
        getRightIcon().setVisibility(8);
        getLeftIcon().setVisibility(0);
        if (animation) {
            dealDeleteIconVisibility();
            getButtonMode().setVisibility(0);
            getSearchEditText().setVisibility(0);
            getInnerLeftIcon().setVisibility(0);
            doBackIconAlphaAnim(this.mCurrentSearchState);
            if (fromState == 3) {
                goSearchStateForCompose$default(this, false, 1, null);
            }
        } else {
            getButtonMode().setVisibility(8);
            getSearchEditText().setVisibility(0);
            getInnerLeftIcon().setVisibility(0);
            getLeftIcon().setAlpha(1.0f);
            final int i12 = 3;
            post(new Runnable(this) { // from class: je.o

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ OSLiquidSearchBar f6233b;

                {
                    this.f6233b = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    int i13 = i12;
                    OSLiquidSearchBar oSLiquidSearchBar = this.f6233b;
                    switch (i13) {
                        case 0:
                            OSLiquidSearchBar.setSearchBarState$lambda$9(oSLiquidSearchBar);
                            break;
                        case 1:
                            OSLiquidSearchBar.setSearchBarState$lambda$11(oSLiquidSearchBar);
                            break;
                        case 2:
                            OSLiquidSearchBar.setSearchBarState$lambda$14(oSLiquidSearchBar);
                            break;
                        case 3:
                            OSLiquidSearchBar.setSearchBarState$lambda$16(oSLiquidSearchBar);
                            break;
                        default:
                            OSLiquidSearchBar.setSearchBarState$lambda$17(oSLiquidSearchBar);
                            break;
                    }
                }
            });
        }
        requestFocus();
        final int i13 = 4;
        postDelayed(new Runnable(this) { // from class: je.o

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ OSLiquidSearchBar f6233b;

            {
                this.f6233b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                int i14 = i13;
                OSLiquidSearchBar oSLiquidSearchBar = this.f6233b;
                switch (i14) {
                    case 0:
                        OSLiquidSearchBar.setSearchBarState$lambda$9(oSLiquidSearchBar);
                        break;
                    case 1:
                        OSLiquidSearchBar.setSearchBarState$lambda$11(oSLiquidSearchBar);
                        break;
                    case 2:
                        OSLiquidSearchBar.setSearchBarState$lambda$14(oSLiquidSearchBar);
                        break;
                    case 3:
                        OSLiquidSearchBar.setSearchBarState$lambda$16(oSLiquidSearchBar);
                        break;
                    default:
                        OSLiquidSearchBar.setSearchBarState$lambda$17(oSLiquidSearchBar);
                        break;
                }
            }
        }, 50L);
    }

    public final void setText(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        getSearchEditText().setText(text);
    }

    public final void setTextHeightElegant(boolean elegant) {
        getSearchEditText().setElegantTextHeight(elegant);
    }

    public final SpringAnimation startSearchForTransition(float scale, float offset) {
        setSearchBarState(this.mCurrentSearchState, 1, true, Boolean.TRUE);
        return this.expandAnimator;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSLiquidSearchBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void setInputMax(int max, String resStr) {
        getSearchEditText().setFilters(new InputFilter[]{new OSLengthFilter(getContext(), max, resStr)});
    }

    public /* synthetic */ OSLiquidSearchBar(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }

    public final SpringAnimation endSearchForTransition(float scale, float offset) {
        setSearchBarState$default(this, this.mCurrentSearchState, 0, true, null, 8, null);
        return this.expandAnimator;
    }

    public final SpringAnimation startSearchForTransition() {
        setSearchBarState(this.mCurrentSearchState, 1, true, Boolean.TRUE);
        return this.expandAnimator;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSLiquidSearchBar(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.checkNotNullParameter(context, "context");
        this.edittextViewStub = LazyKt.lazy(new Function0<ViewStub>() { // from class: com.transsion.widgetsliquid.view.OSLiquidSearchBar$edittextViewStub$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewStub invoke() {
                return (ViewStub) this.this$0.findViewById(R.id.edittext_viewstub);
            }
        });
        this.searchEditText = LazyKt.lazy(new Function0<OSAutoCompleteTextView>() { // from class: com.transsion.widgetsliquid.view.OSLiquidSearchBar$searchEditText$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final OSAutoCompleteTextView invoke() {
                return (OSAutoCompleteTextView) this.this$0.getEdittextViewStub().inflate().findViewById(R.id.search_edit_text);
            }
        });
        this.leftIcon = LazyKt.lazy(new Function0<OSLiquidButton>() { // from class: com.transsion.widgetsliquid.view.OSLiquidSearchBar$leftIcon$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final OSLiquidButton invoke() {
                return (OSLiquidButton) this.this$0.findViewById(R.id.left_icon);
            }
        });
        this.rightIcon = LazyKt.lazy(new Function0<OSLiquidButton>() { // from class: com.transsion.widgetsliquid.view.OSLiquidSearchBar$rightIcon$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final OSLiquidButton invoke() {
                return (OSLiquidButton) this.this$0.findViewById(R.id.right_icon);
            }
        });
        this.buttonMode = LazyKt.lazy(new Function0<OSIconTextView>() { // from class: com.transsion.widgetsliquid.view.OSLiquidSearchBar$buttonMode$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final OSIconTextView invoke() {
                OSIconTextView oSIconTextView = (OSIconTextView) this.this$0.findViewById(R.id.button_mode);
                oSIconTextView.setClickable(false);
                return oSIconTextView;
            }
        });
        this.rightIcon2 = LazyKt.lazy(new Function0<OSLiquidButton>() { // from class: com.transsion.widgetsliquid.view.OSLiquidSearchBar$rightIcon2$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final OSLiquidButton invoke() {
                return (OSLiquidButton) this.this$0.findViewById(R.id.right_icon_2);
            }
        });
        this.innerRightIcon = LazyKt.lazy(new Function0<OSIconTextView>() { // from class: com.transsion.widgetsliquid.view.OSLiquidSearchBar$innerRightIcon$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final OSIconTextView invoke() {
                return (OSIconTextView) this.this$0.findViewById(R.id.inner_right_icon);
            }
        });
        this.editeTextContainer = LazyKt.lazy(new Function0<OSLiquidContainerRootLayout>() { // from class: com.transsion.widgetsliquid.view.OSLiquidSearchBar$editeTextContainer$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final OSLiquidContainerRootLayout invoke() {
                OSLiquidContainerRootLayout oSLiquidContainerRootLayout = (OSLiquidContainerRootLayout) this.this$0.findViewById(R.id.edite_text_container);
                oSLiquidContainerRootLayout.enableUnionBlur(this.this$0.isUseUnionBlur);
                return oSLiquidContainerRootLayout;
            }
        });
        this.innerLeftIcon = LazyKt.lazy(new Function0<OSIconTextView>() { // from class: com.transsion.widgetsliquid.view.OSLiquidSearchBar$innerLeftIcon$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final OSIconTextView invoke() {
                return (OSIconTextView) this.this$0.findViewById(R.id.inner_left_icon);
            }
        });
        this.mTextWatcher = new SearchBarTextWatcher();
        this.hintText = "";
        this.buttonModeIconRes = "";
        this.showRightIcon = true;
        this.singleIconDimen = 60;
        this.edittextLayoutRes = -1;
        this.imeMaxHeight = 959.0f;
        this.mSearchBarClickListener = new Function1<View, Unit>() { // from class: com.transsion.widgetsliquid.view.OSLiquidSearchBar$mSearchBarClickListener$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (this.this$0.mCurrentSearchState == 0) {
                    OSLiquidSearchBar oSLiquidSearchBar = this.this$0;
                    OSLiquidSearchBar.setSearchBarState$default(oSLiquidSearchBar, oSLiquidSearchBar.mCurrentSearchState, 1, true, null, 8, null);
                }
            }
        };
        this.mSearchButtonModeClickListener = new Function1<View, Unit>() { // from class: com.transsion.widgetsliquid.view.OSLiquidSearchBar$mSearchButtonModeClickListener$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (this.this$0.mCurrentSearchState == 3) {
                    OSLiquidSearchBar oSLiquidSearchBar = this.this$0;
                    OSLiquidSearchBar.setSearchBarState$default(oSLiquidSearchBar, oSLiquidSearchBar.mCurrentSearchState, 4, false, null, 12, null);
                }
            }
        };
        this.onBackClickListener = new Function0<Unit>() { // from class: com.transsion.widgetsliquid.view.OSLiquidSearchBar$onBackClickListener$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (this.this$0.mCurrentSearchState == 1) {
                    OSLiquidSearchBar oSLiquidSearchBar = this.this$0;
                    OSLiquidSearchBar.setSearchBarState$default(oSLiquidSearchBar, oSLiquidSearchBar.mCurrentSearchState, 0, true, null, 8, null);
                }
            }
        };
        initAttributes(attributeSet);
        initViews(attributeSet);
        setupClickListeners();
    }
}
