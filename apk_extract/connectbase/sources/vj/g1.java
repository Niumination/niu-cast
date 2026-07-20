package vj;

import androidx.core.app.NotificationCompat;

/* JADX INFO: loaded from: classes2.dex */
@t0
public final class g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b1 f17156a;

    public g1(b1 b1Var) {
        this.f17156a = (b1) c1.h0.F(b1Var, NotificationCompat.CATEGORY_TRANSPORT);
    }

    public Object a(w1<?, ?> w1Var) {
        return w1Var.f17489j.get(this.f17156a.ordinal());
    }

    public void b(w1<?, ?> w1Var, Object obj) {
        w1Var.t(this.f17156a.ordinal(), obj);
    }
}
