package tq;

import lm.l2;
import nq.g2;
import pq.g0;

/* JADX INFO: loaded from: classes3.dex */
@g2
public final class y<T> implements sq.j<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final g0<T> f16067a;

    /* JADX WARN: Multi-variable type inference failed */
    public y(@os.l g0<? super T> g0Var) {
        this.f16067a = g0Var;
    }

    @Override // sq.j
    @os.m
    public Object emit(T t10, @os.l um.d<? super l2> dVar) {
        Object objL = this.f16067a.L(t10, dVar);
        return objL == wm.a.COROUTINE_SUSPENDED ? objL : l2.f10208a;
    }
}
