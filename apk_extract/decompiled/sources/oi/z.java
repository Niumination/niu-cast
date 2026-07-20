package oi;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes3.dex */
public final class z implements c0, h, pi.s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g0 f8564a;

    public z(g0 g0Var) {
        this.f8564a = g0Var;
    }

    @Override // oi.h
    public final Object a(i iVar, Continuation continuation) {
        return g0.i(this.f8564a, iVar, continuation);
    }

    @Override // pi.s
    public final h b(CoroutineContext coroutineContext, int i8, ni.c cVar) {
        return j.i(this, coroutineContext, i8, cVar);
    }
}
