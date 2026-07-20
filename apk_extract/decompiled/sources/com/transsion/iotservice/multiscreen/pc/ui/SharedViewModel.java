package com.transsion.iotservice.multiscreen.pc.ui;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import k3.pb;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/ui/SharedViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SharedViewModel extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData f2700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData f2701b;

    public SharedViewModel() {
        MutableLiveData mutableLiveData = new MutableLiveData();
        this.f2700a = mutableLiveData;
        this.f2701b = mutableLiveData;
    }

    public final void a() {
        boolean z2 = (pb.a().getResources().getConfiguration().uiMode & 48) == 32;
        MutableLiveData mutableLiveData = this.f2700a;
        if (Intrinsics.areEqual(mutableLiveData.getValue(), Boolean.valueOf(z2))) {
            return;
        }
        mutableLiveData.setValue(Boolean.valueOf(z2));
    }
}
