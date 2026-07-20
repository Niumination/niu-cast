package com.transsion.widgetPerGuide.perguide;

import a4.b;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.widgetPerGuide.R$layout;
import com.transsion.widgetslib.view.damping.OSScrollbarLayout;
import com.transsion.widgetsliquid.effect.OSMaskFrameLayout;
import ed.f;
import ed.g;
import ed.h;
import ed.i;
import ed.j;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOnew;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/transsion/widgetPerGuide/perguide/PerGuideDialog;", "", "Landroid/view/View$OnClickListener;", "Lcom/transsion/widgetPerGuide/perguide/PerGuideBaseDialog;", "<init>", "()V", "widgetPerGuide_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nPerGuideDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PerGuideDialog.kt\ncom/transsion/widgetPerGuide/perguide/PerGuideDialog\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,204:1\n1549#2:205\n1620#2,3:206\n*S KotlinDebug\n*F\n+ 1 PerGuideDialog.kt\ncom/transsion/widgetPerGuide/perguide/PerGuideDialog\n*L\n127#1:205\n127#1:206,3\n*E\n"})
public class PerGuideDialog extends PerGuideBaseDialog implements View.OnClickListener {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ int f2974x = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f2978v;
    public final Lazy p = LazyKt.lazy(new i(this));
    public final Lazy q = LazyKt.lazy(new j(this));

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f2975r = LazyKt.lazy(new g(this));

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f2976s = LazyKt.lazy(new f(this));

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f2977t = LazyKt.lazy(new h(this));
    public final ArrayList u = new ArrayList();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final PerGuideDialog$mScrollListener$1 f2979w = new RecyclerView.OnScrollListener() { // from class: com.transsion.widgetPerGuide.perguide.PerGuideDialog$mScrollListener$1
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public final void onScrolled(RecyclerView recyclerView, int i8, int i9) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i8, i9);
            int i10 = PerGuideDialog.f2974x;
            PerGuideDialog perGuideDialog = this.f2980a;
            boolean zCanScrollVertically = perGuideDialog.A().canScrollVertically(1);
            Lazy lazy = perGuideDialog.f2976s;
            if (zCanScrollVertically) {
                OSMaskFrameLayout oSMaskFrameLayout = (OSMaskFrameLayout) lazy.getValue();
                if (oSMaskFrameLayout != null) {
                    oSMaskFrameLayout.setMaskVisibility(0);
                    return;
                }
                return;
            }
            OSMaskFrameLayout oSMaskFrameLayout2 = (OSMaskFrameLayout) lazy.getValue();
            if (oSMaskFrameLayout2 != null) {
                oSMaskFrameLayout2.setMaskVisibility(8);
            }
        }
    };

    public final RecyclerView A() {
        Object value = this.p.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mPerRec>(...)");
        return (RecyclerView) value;
    }

    @Override // com.transsion.widgetsbottomsheet.bottomsheet.OSBaseBottomSheetDialog
    public final int n() {
        getBaseContext();
        return pd.j.s() ? R$layout.os_ultra_small_dialog_perguide_layout : R$layout.os_dialog_perguide_layout;
    }

    @Override // com.transsion.widgetsbottomsheet.bottomsheet.OSBaseBottomSheetDialog, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        A().removeOnScrollListener(this.f2979w);
        super.onDestroy();
    }

    @Override // com.transsion.widgetPerGuide.perguide.PerGuideBaseDialog, com.transsion.widgetsbottomsheet.bottomsheet.OSBaseBottomSheetDialog
    public final void q() {
        super.q();
        Lazy lazy = this.f2977t;
        ((PerGuideAdapter) lazy.getValue()).f2965b = this;
        A().setAdapter((PerGuideAdapter) lazy.getValue());
        A().setLayoutManager(new LinearLayoutManager(this));
        A().addOnScrollListener(this.f2979w);
        A().setClipToPadding(false);
        Lazy lazy2 = this.q;
        Object value = lazy2.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mTvAnnouncement>(...)");
        ((TextView) value).setClickable(true);
        Object value2 = lazy2.getValue();
        Intrinsics.checkNotNullExpressionValue(value2, "<get-mTvAnnouncement>(...)");
        ((TextView) value2).setMovementMethod(LinkMovementMethod.getInstance());
        z1OoOnew z1ooonewC = b8.g.c(A());
        Lazy lazy3 = this.f2975r;
        Object value3 = lazy3.getValue();
        Intrinsics.checkNotNullExpressionValue(value3, "<get-mOsDamp>(...)");
        ((OSScrollbarLayout) value3).setOverScrollView(A());
        if (z1ooonewC != null) {
            z1ooonewC.A = new b(this, 6);
        }
        Object value4 = lazy3.getValue();
        Intrinsics.checkNotNullExpressionValue(value4, "<get-mOsDamp>(...)");
        OSScrollbarLayout oSScrollbarLayout = (OSScrollbarLayout) value4;
        if (oSScrollbarLayout.q == null) {
            return;
        }
        try {
            Method declaredMethod = View.class.getDeclaredMethod("awakenScrollBars", null);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(oSScrollbarLayout.q, null);
            oSScrollbarLayout.b();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            Log.e("OSScrollbarLayout", "invoke awakenScrollBars error", e);
        }
    }

    @Override // com.transsion.widgetsbottomsheet.bottomsheet.OSBaseBottomSheetDialog
    public final boolean u() {
        return false;
    }
}
