package nk;

import ik.r0;
import kn.l0;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends s.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final jn.p<pl.n, um.d<? super l2>, Object> f11518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.m
    public final ik.i f11519c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.m
    public final r0 f11520d;

    public /* synthetic */ f(jn.p pVar, ik.i iVar, r0 r0Var, int i10, kn.w wVar) {
        this(pVar, iVar, (i10 & 4) != 0 ? null : r0Var);
    }

    @Override // nk.s
    @os.m
    public ik.i c() {
        return this.f11519c;
    }

    @Override // nk.s
    @os.m
    public r0 g() {
        return this.f11520d;
    }

    @Override // nk.s.e
    @os.m
    public Object j(@os.l pl.n nVar, @os.l um.d<? super l2> dVar) {
        Object objInvoke = this.f11518b.invoke(nVar, dVar);
        return objInvoke == wm.a.COROUTINE_SUSPENDED ? objInvoke : l2.f10208a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(@os.l jn.p<? super pl.n, ? super um.d<? super l2>, ? extends Object> pVar, @os.m ik.i iVar, @os.m r0 r0Var) {
        l0.p(pVar, "body");
        this.f11518b = pVar;
        this.f11519c = iVar;
        this.f11520d = r0Var;
    }
}
