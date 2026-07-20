package oi;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes3.dex */
public final class a0 implements i0, h, pi.s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y f8534a;

    public a0(y yVar) {
        this.f8534a = yVar;
    }

    @Override // oi.h
    public final Object a(i iVar, Continuation continuation) {
        return ((k0) this.f8534a).a(iVar, continuation);
    }

    @Override // pi.s
    public final h b(CoroutineContext coroutineContext, int i8, ni.c cVar) {
        return (((i8 < 0 || i8 >= 2) && i8 != -2) || cVar != ni.c.DROP_OLDEST) ? j.i(this, coroutineContext, i8, cVar) : this;
    }

    @Override // oi.i0
    public final Object getValue() {
        return ((k0) this.f8534a).getValue();
    }
}
