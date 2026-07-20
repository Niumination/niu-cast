package qe;

import android.content.Context;
import com.transsion.hubsdk.internal.util.TranLatencyTracker;

/* JADX INFO: loaded from: classes2.dex */
public class c implements kh.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f13989b = bc.a.a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranLatencyTracker f13988a = new TranLatencyTracker(this.f13989b);

    @Override // kh.c
    public void a(int i10, int i11) {
        TranLatencyTracker tranLatencyTracker = this.f13988a;
        if (tranLatencyTracker != null) {
            tranLatencyTracker.logAction(i10, i11);
        }
    }

    @Override // kh.c
    public String b(int i10) {
        TranLatencyTracker tranLatencyTracker = this.f13988a;
        return tranLatencyTracker != null ? tranLatencyTracker.getNameOfAction(i10) : "";
    }

    @Override // kh.c
    public void c(int i10) {
        TranLatencyTracker tranLatencyTracker = this.f13988a;
        if (tranLatencyTracker != null) {
            tranLatencyTracker.onActionCancel(i10);
        }
    }

    @Override // kh.c
    public void d(int i10) {
        TranLatencyTracker tranLatencyTracker = this.f13988a;
        if (tranLatencyTracker != null) {
            tranLatencyTracker.onActionEnd(i10);
        }
    }

    @Override // kh.c
    public void e(int i10, String str) {
        TranLatencyTracker tranLatencyTracker = this.f13988a;
        if (tranLatencyTracker != null) {
            tranLatencyTracker.onActionStart(i10, str);
        }
    }
}
