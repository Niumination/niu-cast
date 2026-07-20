package oi;

import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes3.dex */
public final class h0 extends pi.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f8552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public li.l f8553b;

    @Override // pi.d
    public final boolean a(pi.b bVar) {
        g0 g0Var = (g0) bVar;
        if (this.f8552a >= 0) {
            return false;
        }
        long j8 = g0Var.f8548j;
        if (j8 < g0Var.f8549k) {
            g0Var.f8549k = j8;
        }
        this.f8552a = j8;
        return true;
    }

    @Override // pi.d
    public final Continuation[] b(pi.b bVar) {
        long j8 = this.f8552a;
        this.f8552a = -1L;
        this.f8553b = null;
        return ((g0) bVar).s(j8);
    }
}
