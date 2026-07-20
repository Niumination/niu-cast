package com.transsion.iotservice.multiscreen.pc.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.transsion.iotservice.multiscreen.pc.ui.search.viewModel.SearchActivityViewModel;
import com.transsion.iotservice.multiscreen.pc.ui.search.viewModel.WaitAcceptViewModel;
import yb.b;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FragmentWaitAcceptBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f2595j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f2596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f2597b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConstraintLayout f2598c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f2599d;
    public SearchActivityViewModel e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b f2600h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public WaitAcceptViewModel f2601i;

    public FragmentWaitAcceptBinding(DataBindingComponent dataBindingComponent, View view, ConstraintLayout constraintLayout, ImageView imageView, ConstraintLayout constraintLayout2, TextView textView) {
        super((Object) dataBindingComponent, view, 2);
        this.f2596a = constraintLayout;
        this.f2597b = imageView;
        this.f2598c = constraintLayout2;
        this.f2599d = textView;
    }

    public abstract void d(b bVar);

    public abstract void e(SearchActivityViewModel searchActivityViewModel);

    public abstract void f(WaitAcceptViewModel waitAcceptViewModel);
}
