package jb;

import kotlin.coroutines.CoroutineContext;
import li.g0;
import li.h0;
import li.i2;
import li.l0;
import li.v0;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ qi.c f6133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dc.b f6134b;

    public e() {
        i2 i2VarD = l0.d();
        v0 v0Var = v0.f7498a;
        this.f6133a = h0.a(CoroutineContext.Element.DefaultImpls.plus(i2VarD, si.e.f10118a));
        this.f6134b = dc.b.f4399a;
    }

    @Override // li.g0
    public final CoroutineContext getCoroutineContext() {
        return this.f6133a.f9137a;
    }
}
