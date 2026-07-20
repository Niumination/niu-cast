package com.transsion.iotservice.multiscreen.pc.ui.gesture;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import za.b;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/ui/gesture/GestureViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class GestureViewModel extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData f2769a = b.f11269b;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData f2770b = b.f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableLiveData f2771c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableLiveData f2772d;
    public final MutableLiveData e;
    public final MutableLiveData f;

    public GestureViewModel() {
        MutableLiveData mutableLiveData = new MutableLiveData();
        this.f2771c = mutableLiveData;
        this.f2772d = mutableLiveData;
        MutableLiveData mutableLiveData2 = new MutableLiveData();
        this.e = mutableLiveData2;
        this.f = mutableLiveData2;
    }
}
