package com.transsion.iotservice.multiscreen.pc.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.transsion.iotservice.multiscreen.pc.ui.search.viewModel.ConnectingViewModel;
import com.transsion.iotservice.multiscreen.pc.ui.search.viewModel.SearchActivityViewModel;
import yb.b;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FragmentConnectingBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f2557o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f2558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f2559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f2560c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LottieAnimationView f2561d;
    public final ConstraintLayout e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Button f2562h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Button f2563i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TextView f2564j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ConstraintLayout f2565k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public SearchActivityViewModel f2566l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public b f2567m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ConnectingViewModel f2568n;

    public FragmentConnectingBinding(DataBindingComponent dataBindingComponent, View view, TextView textView, ConstraintLayout constraintLayout, ImageView imageView, LottieAnimationView lottieAnimationView, ConstraintLayout constraintLayout2, Button button, Button button2, TextView textView2, ConstraintLayout constraintLayout3) {
        super((Object) dataBindingComponent, view, 4);
        this.f2558a = textView;
        this.f2559b = constraintLayout;
        this.f2560c = imageView;
        this.f2561d = lottieAnimationView;
        this.e = constraintLayout2;
        this.f2562h = button;
        this.f2563i = button2;
        this.f2564j = textView2;
        this.f2565k = constraintLayout3;
    }

    public abstract void d(b bVar);

    public abstract void e(SearchActivityViewModel searchActivityViewModel);

    public abstract void f(ConnectingViewModel connectingViewModel);
}
