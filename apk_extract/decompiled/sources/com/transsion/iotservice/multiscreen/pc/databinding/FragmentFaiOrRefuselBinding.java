package com.transsion.iotservice.multiscreen.pc.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.transsion.iotservice.multiscreen.pc.ui.search.viewModel.DeviceViewModel;
import com.transsion.iotservice.multiscreen.pc.ui.search.viewModel.SearchActivityViewModel;
import yb.b;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FragmentFaiOrRefuselBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f2571k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Button f2572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f2573b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConstraintLayout f2574c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f2575d;
    public final Button e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SearchActivityViewModel f2576h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public DeviceViewModel f2577i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b f2578j;

    public FragmentFaiOrRefuselBinding(DataBindingComponent dataBindingComponent, View view, Button button, ImageView imageView, ConstraintLayout constraintLayout, TextView textView, Button button2) {
        super((Object) dataBindingComponent, view, 1);
        this.f2572a = button;
        this.f2573b = imageView;
        this.f2574c = constraintLayout;
        this.f2575d = textView;
        this.e = button2;
    }

    public abstract void d(b bVar);

    public abstract void e(DeviceViewModel deviceViewModel);

    public abstract void f(SearchActivityViewModel searchActivityViewModel);
}
