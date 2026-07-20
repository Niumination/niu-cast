package xj;

import jn.p;
import kn.l0;
import nq.n3;
import os.l;
import os.m;
import vj.w;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements n3<w> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public static final a f20254b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final w f20255a;

    public static final class a implements um.g.c<e> {
        public a() {
        }

        @l
        public final e a() {
            w wVarO = w.o();
            l0.o(wVarO, "current()");
            return new e(wVarO);
        }

        public a(kn.w wVar) {
        }
    }

    public e(@l w wVar) {
        l0.p(wVar, "grpcContext");
        this.f20255a = wVar;
    }

    @Override // nq.n3
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void D1(@l um.g gVar, @l w wVar) {
        l0.p(gVar, "context");
        l0.p(wVar, "oldState");
        this.f20255a.q(wVar);
    }

    @Override // nq.n3
    @l
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public w u0(@l um.g gVar) {
        l0.p(gVar, "context");
        w wVarC = this.f20255a.c();
        l0.o(wVarC, "grpcContext.attach()");
        return wVarC;
    }

    @Override // um.g.b, um.g
    public <R> R fold(R r10, @l p<? super R, ? super um.g.b, ? extends R> pVar) {
        return (R) um.g.b.a.a(this, r10, pVar);
    }

    @Override // um.g.b, um.g
    @m
    public <E extends um.g.b> E get(@l um.g.c<E> cVar) {
        return (E) um.g.b.a.b(this, cVar);
    }

    @Override // um.g.b
    @l
    public um.g.c<e> getKey() {
        return f20254b;
    }

    @Override // um.g.b, um.g
    @l
    public um.g minusKey(@l um.g.c<?> cVar) {
        return um.g.b.a.c(this, cVar);
    }

    @Override // um.g
    @l
    public um.g plus(@l um.g gVar) {
        return um.g.b.a.d(this, gVar);
    }
}
