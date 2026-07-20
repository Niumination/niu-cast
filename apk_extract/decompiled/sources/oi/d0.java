package oi;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import li.x0;

/* JADX INFO: loaded from: classes3.dex */
public final class d0 implements x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g0 f8537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f8538b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f8539c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final li.l f8540d;

    public d0(g0 g0Var, long j8, Object obj, li.l lVar) {
        this.f8537a = g0Var;
        this.f8538b = j8;
        this.f8539c = obj;
        this.f8540d = lVar;
    }

    @Override // li.x0
    public final void dispose() {
        g0 g0Var = this.f8537a;
        synchronized (g0Var) {
            if (this.f8538b < g0Var.m()) {
                return;
            }
            Object[] objArr = g0Var.f8547i;
            Intrinsics.checkNotNull(objArr);
            long j8 = this.f8538b;
            if (objArr[((int) j8) & (objArr.length - 1)] != this) {
                return;
            }
            j.b(objArr, j8, j.f8554a);
            g0Var.h();
            Unit unit = Unit.INSTANCE;
        }
    }
}
