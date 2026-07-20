package com.transsion.iotservice.multiscreen.pc.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.github.rubensousa.gravitysnaphelper.GravitySnapRecyclerView;
import com.tencent.qgame.animplayer.AnimView;
import com.transsion.iotservice.multiscreen.pc.adapter.SearchPcItemAdapter;
import com.transsion.iotservice.multiscreen.pc.ui.SharedViewModel;
import com.transsion.iotservice.multiscreen.pc.ui.search.viewModel.DeviceViewModel;
import com.transsion.iotservice.multiscreen.pc.ui.search.viewModel.SearchFragmentViewModel;
import yb.b;
import yb.f;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FragmentSearchPcBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f2583o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AnimView f2584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LottieAnimationView f2585b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConstraintLayout f2586c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final GravitySnapRecyclerView f2587d;
    public final TextView e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f2588h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public DeviceViewModel f2589i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public SearchPcItemAdapter f2590j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public SharedViewModel f2591k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public SearchFragmentViewModel f2592l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public b f2593m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public f f2594n;

    public FragmentSearchPcBinding(DataBindingComponent dataBindingComponent, View view, AnimView animView, LottieAnimationView lottieAnimationView, ConstraintLayout constraintLayout, GravitySnapRecyclerView gravitySnapRecyclerView, TextView textView, TextView textView2) {
        super((Object) dataBindingComponent, view, 5);
        this.f2584a = animView;
        this.f2585b = lottieAnimationView;
        this.f2586c = constraintLayout;
        this.f2587d = gravitySnapRecyclerView;
        this.e = textView;
        this.f2588h = textView2;
    }

    public abstract void d(SearchPcItemAdapter searchPcItemAdapter);

    public abstract void e(f fVar);

    public abstract void f(b bVar);

    public abstract void g(DeviceViewModel deviceViewModel);

    public abstract void h(SearchFragmentViewModel searchFragmentViewModel);

    public abstract void i(SharedViewModel sharedViewModel);
}
