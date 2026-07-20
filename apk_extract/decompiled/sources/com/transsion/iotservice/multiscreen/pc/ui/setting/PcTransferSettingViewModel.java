package com.transsion.iotservice.multiscreen.pc.ui.setting;

import android.os.Bundle;
import android.os.SystemClock;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import tj.w;
import za.b;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/ui/setting/PcTransferSettingViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class PcTransferSettingViewModel extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData f2879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData f2880b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableLiveData f2881c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableLiveData f2882d;
    public final MutableLiveData e;

    public PcTransferSettingViewModel() {
        MutableLiveData mutableLiveData = new MutableLiveData();
        this.f2879a = mutableLiveData;
        this.f2880b = mutableLiveData;
        this.f2881c = b.f;
        MutableLiveData mutableLiveData2 = new MutableLiveData();
        this.f2882d = mutableLiveData2;
        this.e = mutableLiveData2;
        ob.b bVar = ob.b.f8417b;
        bVar.getClass();
        ob.b.f8428o = SystemClock.elapsedRealtime();
        bVar.f8437a.getClass();
        w.X("iot_pc_con_enter_mirror_gesture_page", w.D());
    }

    @Override // androidx.lifecycle.ViewModel
    public final void onCleared() {
        super.onCleared();
        ob.b bVar = ob.b.f8417b;
        bVar.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime() - ob.b.f8428o;
        bVar.f8437a.getClass();
        Bundle bundle = new Bundle();
        bundle.putLong("stay_time", jElapsedRealtime);
        w.X("iot_pc_con_leave_swift_trasfer_page", bundle);
    }
}
