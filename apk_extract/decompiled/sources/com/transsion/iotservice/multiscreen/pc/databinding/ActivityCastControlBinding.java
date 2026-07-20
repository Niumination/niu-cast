package com.transsion.iotservice.multiscreen.pc.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.tencent.qgame.animplayer.AnimView;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.CastControlViewModel;
import com.transsion.widgetslib.view.OverBoundNestedScrollView;
import com.transsion.widgetslib.view.damping.OSScrollbarLayout;
import sb.e;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ActivityCastControlBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f2404n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppCompatButton f2405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f2406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f2407c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f2408d;
    public final LinearLayout e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final OverBoundNestedScrollView f2409h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final OSScrollbarLayout f2410i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TextView f2411j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AnimView f2412k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public CastControlViewModel f2413l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public e f2414m;

    public ActivityCastControlBinding(DataBindingComponent dataBindingComponent, View view, AppCompatButton appCompatButton, FrameLayout frameLayout, LinearLayout linearLayout, FrameLayout frameLayout2, LinearLayout linearLayout2, OverBoundNestedScrollView overBoundNestedScrollView, OSScrollbarLayout oSScrollbarLayout, TextView textView, AnimView animView) {
        super((Object) dataBindingComponent, view, 3);
        this.f2405a = appCompatButton;
        this.f2406b = frameLayout;
        this.f2407c = linearLayout;
        this.f2408d = frameLayout2;
        this.e = linearLayout2;
        this.f2409h = overBoundNestedScrollView;
        this.f2410i = oSScrollbarLayout;
        this.f2411j = textView;
        this.f2412k = animView;
    }

    public abstract void d(e eVar);

    public abstract void e(CastControlViewModel castControlViewModel);
}
