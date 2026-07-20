package com.transsion.iotservice.multiscreen.pc.ui.dialog;

import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import eb.k1;
import eb.y;
import eb.y1;
import hc.c;
import k3.gc;
import k3.sb;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import li.g2;
import li.l0;
import o.d;
import o7.a;
import oi.g0;
import oi.j;
import oi.z;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/ui/dialog/CastControlViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class CastControlViewModel extends ViewModel {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static boolean f2715l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static boolean f2716m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g2 f2717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f2718b = 500;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g0 f2719c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final z f2720d;
    public g2 e;
    public final MutableLiveData f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MutableLiveData f2721g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MutableLiveData f2722h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final MutableLiveData f2723i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final MutableLiveData f2724j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final MutableLiveData f2725k;

    public CastControlViewModel() {
        String str;
        g0 g0VarA = j.a();
        this.f2719c = g0VarA;
        this.f2720d = new z(g0VarA);
        this.f = y.f4808l;
        this.f2721g = y.f4810n;
        this.f2722h = new MutableLiveData(Boolean.valueOf(a.c("com.transsion.phone_extend_pad")));
        if (sb.b()) {
            k1 k1Var = k1.f4765a;
            c cVar = k1.e;
            str = (cVar == null || (str = cVar.f5287b) == null) ? "Unknown Device" : str;
            String log = "deviceName=".concat(str);
            Intrinsics.checkNotNullParameter("CastControlViewModel", "tag");
            Intrinsics.checkNotNullParameter(log, "log");
            if (gc.f6462a <= 3) {
                Log.d(gc.f6463b.concat("CastControlViewModel"), log);
            }
        } else {
            str = y1.f;
            String strN = d.n("deviceName=", str, "CastControlViewModel", "tag", "log");
            if (gc.f6462a <= 3) {
                Log.d(gc.f6463b.concat("CastControlViewModel"), strN);
            }
        }
        this.f2723i = new MutableLiveData(str);
        MutableLiveData mutableLiveData = new MutableLiveData();
        this.f2724j = mutableLiveData;
        this.f2725k = mutableLiveData;
    }

    public final void a(boolean z2, boolean z3) {
        String log = "applyStates: toMirror: " + z2 + ", toExtend: " + z3;
        Intrinsics.checkNotNullParameter("CastControlViewModel", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("CastControlViewModel"), log);
        }
        g2 g2Var = this.f2717a;
        if (g2Var != null) {
            g2Var.h(null);
        }
        y yVar = y.f4799a;
        y.t(z3);
        y.v(z2);
        this.f2717a = l0.p(ViewModelKt.getViewModelScope(this), null, null, new sb.j(this, z2, z3, null), 3);
    }
}
