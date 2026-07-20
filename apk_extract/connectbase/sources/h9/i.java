package h9;

import android.app.ActivityOptions;
import android.os.Bundle;
import android.os.Messenger;
import ic.t0;

/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f7038c = "i";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f7039d = "android:activity.overrideTaskTransition";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p6.i f7040a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public t0 f7041b = null;

    public ActivityOptions a(Bundle bundle) {
        return b(fc.b.a.f5985e).f(bundle);
    }

    public bf.f b(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f7038c, "TranThubActivityOptions");
            t0 t0Var = this.f7041b;
            if (t0Var != null) {
                return t0Var;
            }
            t0 t0Var2 = new t0();
            this.f7041b = t0Var2;
            return t0Var2;
        }
        dc.e.f(f7038c, "TranAospActivityOptions");
        p6.i iVar = this.f7040a;
        if (iVar != null) {
            return iVar;
        }
        p6.i iVar2 = new p6.i();
        this.f7040a = iVar2;
        return iVar2;
    }

    @Deprecated
    public void c(ActivityOptions activityOptions, Messenger messenger, long j10, long j11) {
        if (activityOptions == null) {
            throw new NullPointerException("ActivityOptions cannot be null");
        }
        b(fc.b.a.f5998r).h(activityOptions, messenger, j10, j11);
    }

    public void d(boolean z10) {
        b(fc.b.a.f5988h).e(z10);
    }

    public void e(ActivityOptions activityOptions, int i10) {
        b(fc.b.a.f5985e).c(activityOptions, i10);
    }

    public void f(ActivityOptions activityOptions, int i10) {
        b(fc.b.a.f5985e).a(activityOptions, i10);
    }

    public void g(int i10) {
        b(fc.b.a.f5988h).g(i10);
    }

    public void h(ActivityOptions activityOptions, int i10) {
        if (activityOptions == null) {
            throw new IllegalArgumentException("ActivityOptions cannot be null");
        }
        b(fc.b.a.A).b(activityOptions, i10);
    }

    public void i(ActivityOptions activityOptions, boolean z10) {
        if (activityOptions == null) {
            throw new IllegalArgumentException("ActivityOptions cannot be null");
        }
        b(fc.b.a.f6001u).i(activityOptions, z10);
    }

    public Bundle j() {
        return b(fc.b.a.f5988h).d();
    }
}
