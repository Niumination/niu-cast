package com.transsion.widgetsbottomsheet.bottomsheet;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.LayoutTransition;
import android.animation.ValueAnimator;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.animation.LinearInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import com.transsion.connectx.sdk.TCCPSourceApi;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.CastControlDialog;
import com.transsion.widgetsbottomsheet.R$attr;
import com.transsion.widgetsbottomsheet.R$color;
import com.transsion.widgetsbottomsheet.R$dimen;
import com.transsion.widgetsbottomsheet.databinding.OsBottomSheetContainerBinding;
import com.transsion.widgetsbottomsheet.followsoft.BottomSheetTranslateDeferringInsetsAnimationCallback;
import com.transsion.widgetslib.view.followsoft.RootViewDeferringInsetsCallback;
import fd.c;
import fd.e;
import gd.a;
import gd.b;
import gd.j;
import gd.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import k3.z8;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import se.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/transsion/widgetsbottomsheet/bottomsheet/OSBaseBottomSheetDialog;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "Landroid/view/View;", "view", "", "setContentView", "(Landroid/view/View;)V", "widgetsbottomsheet_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nOSBaseBottomSheetDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OSBaseBottomSheetDialog.kt\ncom/transsion/widgetsbottomsheet/bottomsheet/OSBaseBottomSheetDialog\n+ 2 ViewGroup.kt\nandroidx/core/view/ViewGroupKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,471:1\n45#2:472\n350#3:473\n*S KotlinDebug\n*F\n+ 1 OSBaseBottomSheetDialog.kt\ncom/transsion/widgetsbottomsheet/bottomsheet/OSBaseBottomSheetDialog\n*L\n320#1:472\n431#1:473\n*E\n"})
public abstract class OSBaseBottomSheetDialog extends AppCompatActivity {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f2985i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f2986a = LazyKt.lazy(new a(this));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2987b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Stack f2988c = new Stack();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Stack f2989d = new Stack();
    public boolean e = true;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f2990h = LazyKt.lazy(new b(this));

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.e) {
            OSBSContainerFrameLayout oSBSContainerFrameLayout = o().e;
            if (oSBSContainerFrameLayout.getLayoutTransition() == null || !oSBSContainerFrameLayout.getLayoutTransition().isRunning()) {
                return super.dispatchTouchEvent(motionEvent);
            }
        }
        return !this.e;
    }

    public OSPageView j(View view) {
        OSPageView showView;
        Intrinsics.checkNotNullParameter(view, "view");
        Stack<OSPageView> stack = this.f2988c;
        for (OSPageView pageView : stack) {
            if (Intrinsics.areEqual(pageView.getF3017b(), view)) {
                Intrinsics.checkNotNullExpressionValue(pageView, "pageView");
                return pageView;
            }
        }
        if (!o().e.isAttachedToWindow()) {
            setContentView(0);
        }
        Stack stack2 = this.f2989d;
        if (stack2.isEmpty()) {
            showView = new OSPageView(this, null, 0, 14);
        } else {
            Object objPop = stack2.pop();
            Intrinsics.checkNotNullExpressionValue(objPop, "{\n            mPageConta…cyclePool.pop()\n        }");
            showView = (OSPageView) objPop;
        }
        showView.setVisibility(0);
        Object objPeek = stack.isEmpty() ? null : stack.peek();
        ViewParent parent = view.getParent();
        if (parent != null) {
            ((ViewGroup) parent).removeView(view);
        }
        showView.addView(view);
        OSBSContainerFrameLayout oSBSContainerFrameLayout = o().e;
        oSBSContainerFrameLayout.removeView(showView);
        oSBSContainerFrameLayout.addView(showView);
        showView.setVisibility(0);
        OSPageView hideView = (OSPageView) objPeek;
        if (hideView != null) {
            hideView.setVisibility(8);
            AnimatorSet animatorSet = c.f5021a;
            OSBottomSheetPanel dragView = o().f3027d;
            Intrinsics.checkNotNullExpressionValue(dragView, "mContainerViewBinding.dragPanel");
            d callBack = new d();
            Intrinsics.checkNotNullParameter(dragView, "dragView");
            Intrinsics.checkNotNullParameter(hideView, "hideView");
            Intrinsics.checkNotNullParameter(showView, "showView");
            Intrinsics.checkNotNullParameter(callBack, "callBack");
            AnimatorSet animatorSet2 = c.f5021a;
            if (animatorSet2 != null && animatorSet2.isRunning()) {
                animatorSet2.cancel();
            }
            showView.setAlpha(0.5f);
            c.f5021a = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(c.b(hideView));
            arrayList.add(c.c(showView, callBack));
            AnimatorSet animatorSet3 = c.f5021a;
            Intrinsics.checkNotNull(animatorSet3);
            animatorSet3.playTogether(arrayList);
            AnimatorSet animatorSet4 = c.f5021a;
            Intrinsics.checkNotNull(animatorSet4);
            animatorSet4.start();
        }
        stack.push(showView);
        OSBSContainerFrameLayout oSBSContainerFrameLayout2 = o().e;
        Intrinsics.checkNotNullExpressionValue(oSBSContainerFrameLayout2, "mContainerViewBinding.panelContent");
        int childCount = oSBSContainerFrameLayout2.getChildCount();
        int size = stack.size();
        int iHashCode = showView.hashCode();
        StringBuilder sbR = o.d.r(childCount, size, "addPage mRealContainer.size ", " mPageContainerStack.size = ", " osPageView = ");
        sbR.append(iHashCode);
        z8.f("OSBaseBottomSheetDialog", sbR.toString());
        return showView;
    }

    public final void k() {
        OSBottomSheetPanel oSBottomSheetPanel = o().f3027d;
        Object systemService = getSystemService(TCCPSourceApi.KEY_FEATURE_INPUT_METHOD);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        if (inputMethodManager != null && inputMethodManager.isActive()) {
            inputMethodManager.hideSoftInputFromWindow(o().f3027d.getWindowToken(), 0);
        }
        SpringAnimation springAnimation = oSBottomSheetPanel.f2998d;
        if (springAnimation.isRunning()) {
            springAnimation.cancel();
        }
        ValueAnimator valueAnimator = oSBottomSheetPanel.f2997c;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            valueAnimator.cancel();
        }
        if (oSBottomSheetPanel.f2996b == null) {
            OSBaseBottomSheetDialog oSBaseBottomSheetDialog = oSBottomSheetPanel.f2999h;
            if (oSBaseBottomSheetDialog != null) {
                oSBaseBottomSheetDialog.e = false;
            }
            float translationY = oSBottomSheetPanel.getTranslationY();
            LinearInterpolator linearInterpolator = e.f5027a;
            Property TRANSLATION_Y = LinearLayout.TRANSLATION_Y;
            Intrinsics.checkNotNullExpressionValue(TRANSLATION_Y, "TRANSLATION_Y");
            fd.d dVar = new fd.d(oSBottomSheetPanel, TRANSLATION_Y, translationY, oSBottomSheetPanel.mPanelVisibleHeight, 200.0f, OSBottomSheetPanel.L);
            View view = oSBottomSheetPanel.mOutsideView;
            Intrinsics.checkNotNull(view);
            Property ALPHA = LinearLayout.ALPHA;
            Intrinsics.checkNotNullExpressionValue(ALPHA, "ALPHA");
            ValueAnimator valueAnimatorA = e.a(200L, dVar, new fd.d(view, ALPHA, oSBottomSheetPanel.A, 0.0f, 200.0f, OSBottomSheetPanel.M));
            oSBottomSheetPanel.f2996b = valueAnimatorA;
            valueAnimatorA.addListener(new j(oSBottomSheetPanel, 1));
            valueAnimatorA.start();
        }
    }

    public int l() {
        return pd.j.e(getBaseContext(), R$attr.os_open_bg, R$color.os_open_bg_hios);
    }

    public boolean m() {
        return !(this instanceof CastControlDialog);
    }

    public int n() {
        return 0;
    }

    public final OsBottomSheetContainerBinding o() {
        return (OsBottomSheetContainerBinding) this.f2986a.getValue();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        int i8 = 2;
        Stack stack = this.f2988c;
        if (stack.size() < 2) {
            if (this.f2987b) {
                k();
                return;
            }
            return;
        }
        OSPageView hideView = (OSPageView) stack.get(CollectionsKt.getLastIndex(stack));
        OSPageView showView = (OSPageView) stack.get(CollectionsKt.getLastIndex(stack) - 1);
        stack.remove(hideView);
        if (showView != null) {
            o().e.removeView(hideView);
            showView.setVisibility(0);
            AnimatorSet animatorSet = c.f5021a;
            OSBottomSheetPanel dragView = o().f3027d;
            Intrinsics.checkNotNullExpressionValue(dragView, "mContainerViewBinding.dragPanel");
            Intrinsics.checkNotNullExpressionValue(hideView, "osPageView");
            n6.a callBack = new n6.a(i8, this, hideView);
            Intrinsics.checkNotNullParameter(dragView, "dragView");
            Intrinsics.checkNotNullParameter(hideView, "hideView");
            Intrinsics.checkNotNullParameter(showView, "showView");
            Intrinsics.checkNotNullParameter(callBack, "callBack");
            AnimatorSet animatorSet2 = c.f5021a;
            if (animatorSet2 != null && animatorSet2.isRunning()) {
                animatorSet2.cancel();
            }
            showView.setAlpha(0.5f);
            c.f5021a = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(c.b(hideView));
            arrayList.add(c.c(showView, callBack));
            AnimatorSet animatorSet3 = c.f5021a;
            Intrinsics.checkNotNull(animatorSet3);
            animatorSet3.playTogether(arrayList);
            AnimatorSet animatorSet4 = c.f5021a;
            Intrinsics.checkNotNull(animatorSet4);
            animatorSet4.start();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        w();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        pd.j.G(getWindow());
        if (n() > 0) {
            setContentView(n());
        }
        q();
        Window window = getWindow();
        OSBottomSheetPanel oSBottomSheetPanel = o().f3027d;
        Intrinsics.checkNotNullExpressionValue(oSBottomSheetPanel, "mContainerViewBinding.dragPanel");
        boolean zU = u();
        OSBottomSheetContainer oSBottomSheetContainer = o().f3024a;
        OSBottomSheetContainer oSBottomSheetContainer2 = o().f3024a;
        Intrinsics.checkNotNullExpressionValue(oSBottomSheetContainer2, "mContainerViewBinding.root");
        View[] viewArr = {oSBottomSheetContainer2};
        WindowCompat.setDecorFitsSystemWindows(window, zU);
        int iNavigationBars = WindowInsetsCompat.Type.navigationBars();
        int iIme = WindowInsetsCompat.Type.ime();
        RootViewDeferringInsetsCallback rootViewDeferringInsetsCallback = new RootViewDeferringInsetsCallback(1);
        rootViewDeferringInsetsCallback.f3254d = null;
        rootViewDeferringInsetsCallback.e = null;
        rootViewDeferringInsetsCallback.f3255h = false;
        rootViewDeferringInsetsCallback.f3251a = iNavigationBars;
        rootViewDeferringInsetsCallback.f3252b = iIme;
        rootViewDeferringInsetsCallback.f3253c = zU;
        if ((iNavigationBars & iIme) != 0) {
            throw new IllegalArgumentException("persistentInsetTypes and deferredInsetTypes can not contain any of  same WindowInsetsCompat.Type values");
        }
        ViewCompat.setWindowInsetsAnimationCallback(oSBottomSheetContainer, rootViewDeferringInsetsCallback);
        ViewCompat.setOnApplyWindowInsetsListener(oSBottomSheetContainer, rootViewDeferringInsetsCallback);
        View view = viewArr[0];
        int iSystemBars = WindowInsetsCompat.Type.systemBars();
        int iIme2 = WindowInsetsCompat.Type.ime();
        BottomSheetTranslateDeferringInsetsAnimationCallback bottomSheetTranslateDeferringInsetsAnimationCallback = new BottomSheetTranslateDeferringInsetsAnimationCallback(1);
        bottomSheetTranslateDeferringInsetsAnimationCallback.f3036b = iIme2;
        bottomSheetTranslateDeferringInsetsAnimationCallback.f3035a = iSystemBars;
        bottomSheetTranslateDeferringInsetsAnimationCallback.f3037c = view;
        if ((iSystemBars & iIme2) != 0) {
            throw new IllegalArgumentException("persistentInsetTypes and deferredInsetTypes can not contain any of  same WindowInsetsCompat.Type values");
        }
        bottomSheetTranslateDeferringInsetsAnimationCallback.f3038d = oSBottomSheetPanel;
        ViewCompat.setWindowInsetsAnimationCallback(view, bottomSheetTranslateDeferringInsetsAnimationCallback);
        getWindow().getDecorView().post(new a4.c(this, 20));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        AnimatorSet animatorSet = c.f5021a;
        if (animatorSet != null) {
            Iterator<Animator> it = animatorSet.getChildAnimations().iterator();
            while (it.hasNext()) {
                it.next().removeAllListeners();
            }
            animatorSet.removeAllListeners();
            if (animatorSet.isRunning()) {
                animatorSet.cancel();
            }
            c.f5021a = null;
        }
        super.onDestroy();
    }

    public boolean p() {
        return !(this instanceof CastControlDialog);
    }

    public abstract void q();

    public void r() {
    }

    public final void s(boolean z2) {
        if (this.f2987b != z2) {
            this.f2987b = z2;
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void setContentView(int i8) {
        super.setContentView(x(i8, null, null));
        pd.j.z(this);
    }

    public final void t(boolean z2) {
        if (z2 && !this.f2987b) {
            this.f2987b = true;
        }
        o().f3024a.setCanceledOnTouchOutside(z2);
    }

    public boolean u() {
        return !(this instanceof CastControlDialog);
    }

    public final void v(boolean z2) {
        int dimensionPixelSize;
        gd.c cVar = (gd.c) this.f2990h.getValue();
        int iL = l();
        OSBaseBottomSheetDialog oSBaseBottomSheetDialog = cVar.f5137a;
        OsBottomSheetContainerBinding osBottomSheetContainerBindingO = oSBaseBottomSheetDialog.o();
        boolean z3 = pd.j.t(oSBaseBottomSheetDialog) && (!pd.j.r(oSBaseBottomSheetDialog) || pd.j.m(oSBaseBottomSheetDialog) || pd.j.u(oSBaseBottomSheetDialog));
        if (pd.j.r(oSBaseBottomSheetDialog) && pd.j.t(oSBaseBottomSheetDialog)) {
            dimensionPixelSize = oSBaseBottomSheetDialog.getResources().getDimensionPixelSize(R$dimen.os_bottom_sheet_large_margin_bottom_normal);
        } else if (z3) {
            dimensionPixelSize = 0;
        } else if (pd.j.q(oSBaseBottomSheetDialog) || !pd.j.y(oSBaseBottomSheetDialog.getWindow()) || pd.j.A(oSBaseBottomSheetDialog)) {
            dimensionPixelSize = oSBaseBottomSheetDialog.getResources().getDimensionPixelSize(R$dimen.os_bottom_sheet_inset_bottom_nav_gone);
        } else {
            Resources resources = oSBaseBottomSheetDialog.getResources();
            dimensionPixelSize = resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"));
        }
        ViewGroup.LayoutParams layoutParams = osBottomSheetContainerBindingO.f3026c.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = z3 ? oSBaseBottomSheetDialog.getResources().getDimensionPixelOffset(R$dimen.os_bottom_sheet_large_margin_bottom_normal) : 0;
        }
        ViewGroup.LayoutParams layoutParams2 = osBottomSheetContainerBindingO.e.getLayoutParams();
        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
            OSBSContainerFrameLayout oSBSContainerFrameLayout = oSBaseBottomSheetDialog.o().e;
            Intrinsics.checkNotNullExpressionValue(oSBSContainerFrameLayout, "mContainerViewBinding.panelContent");
            ViewGroup.LayoutParams layoutParams3 = oSBSContainerFrameLayout.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams3 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams3 : null;
            marginLayoutParams.topMargin = marginLayoutParams2 != null ? marginLayoutParams2.topMargin : 0;
        }
        z8.f("OSBaseBottomSheetDialog", "updBottomPadding: paddingBottom = " + dimensionPixelSize + " adaptLargeScreen = " + z3);
        View view = osBottomSheetContainerBindingO.f3028h;
        OSSmoothCornerLinearLayout oSSmoothCornerLinearLayout = osBottomSheetContainerBindingO.f3026c;
        if (z3) {
            oSSmoothCornerLinearLayout.setOutlineProvider(new ae.a(1));
            oSSmoothCornerLinearLayout.setClipToOutline(true);
            osBottomSheetContainerBindingO.f3027d.setBackground(null);
            view.setBackgroundColor(0);
            oSSmoothCornerLinearLayout.setPadding(oSSmoothCornerLinearLayout.getPaddingLeft(), oSSmoothCornerLinearLayout.getPaddingTop(), oSSmoothCornerLinearLayout.getPaddingRight(), 0);
            return;
        }
        oSSmoothCornerLinearLayout.setBackground(null);
        oSSmoothCornerLinearLayout.setOutlineProvider(null);
        oSSmoothCornerLinearLayout.setClipToOutline(false);
        view.setBackgroundColor(iL);
        oSSmoothCornerLinearLayout.setBackground(null);
        oSSmoothCornerLinearLayout.setPadding(oSSmoothCornerLinearLayout.getPaddingLeft(), oSSmoothCornerLinearLayout.getPaddingTop(), oSSmoothCornerLinearLayout.getPaddingRight(), z2 ? dimensionPixelSize : 0);
        ae.a aVar = new ae.a(2);
        RelativeLayout relativeLayout = osBottomSheetContainerBindingO.f3025b;
        relativeLayout.setOutlineProvider(aVar);
        relativeLayout.setClipToOutline(true);
    }

    public final void w() {
        View decorView = getWindow().getDecorView();
        String[] strArr = pd.j.f8764a;
        int[] iArr = new int[2];
        decorView.getLocationOnScreen(iArr);
        if (iArr[1] == 0 && !pd.j.t(this) && pd.j.r(this)) {
            v(false);
        } else {
            v(true);
        }
    }

    public final OSBottomSheetContainer x(int i8, View view, ViewGroup.LayoutParams layoutParams) {
        OSBSContainerFrameLayout oSBSContainerFrameLayout = o().e;
        Intrinsics.checkNotNull(oSBSContainerFrameLayout, "null cannot be cast to non-null type android.widget.FrameLayout");
        oSBSContainerFrameLayout.setOnTouchListener(new b4.e(1));
        Intrinsics.checkNotNullExpressionValue(o().f3024a, "mContainerViewBinding.root");
        OSBottomSheetPanel oSBottomSheetPanel = o().f3027d;
        Intrinsics.checkNotNullParameter(this, "dialog");
        oSBottomSheetPanel.f2999h = this;
        oSBottomSheetPanel.f2995a = new q(this, oSBottomSheetPanel);
        if (i8 != 0 && view == null) {
            view = getLayoutInflater().inflate(i8, (ViewGroup) o().e, false);
        }
        o().e.removeAllViews();
        if (view != null) {
            if (layoutParams == null) {
                o().e.addView(view);
            } else {
                o().e.addView(view, layoutParams);
            }
        }
        o().f3027d.setDragHandleVisibility(m());
        o().f3027d.setSupportGesture(p());
        if (o().f3027d.getMFixedHeight()) {
            o().e.setLayoutTransition(null);
        } else {
            OSBSContainerFrameLayout oSBSContainerFrameLayout2 = o().e;
            if (oSBSContainerFrameLayout2.getLayoutTransition() == null) {
                oSBSContainerFrameLayout2.setLayoutTransition(new LayoutTransition());
            }
            LayoutTransition layoutTransition = oSBSContainerFrameLayout2.getLayoutTransition();
            if (layoutTransition != null) {
                layoutTransition.setAnimator(2, null);
                layoutTransition.setAnimator(3, null);
                layoutTransition.setAnimator(1, null);
                layoutTransition.setDuration(0, 350L);
                layoutTransition.setInterpolator(0, new ud.a());
            }
        }
        OSBottomSheetContainer oSBottomSheetContainer = o().f3024a;
        Intrinsics.checkNotNullExpressionValue(oSBottomSheetContainer, "mContainerViewBinding.root");
        return oSBottomSheetContainer;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        super.setContentView(x(0, view, null));
        pd.j.z(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(x(0, view, layoutParams));
        pd.j.z(this);
    }
}
