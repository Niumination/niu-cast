package tq;

import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
public final class i<T> extends h<T, T> {
    public i(sq.i iVar, um.g gVar, int i10, pq.i iVar2, int i11, kn.w wVar) {
        super(iVar, (i11 & 2) != 0 ? um.i.INSTANCE : gVar, (i11 & 4) != 0 ? -3 : i10, (i11 & 8) != 0 ? pq.i.SUSPEND : iVar2);
    }

    @Override // tq.e
    @os.l
    public e<T> j(@os.l um.g gVar, int i10, @os.l pq.i iVar) {
        return new i(this.f16038d, gVar, i10, iVar);
    }

    @Override // tq.e
    @os.l
    public sq.i<T> k() {
        return (sq.i<T>) this.f16038d;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // tq.h
    @os.m
    public Object s(@os.l sq.j<? super T> jVar, @os.l um.d<? super l2> dVar) {
        Object objA = this.f16038d.a((sq.j<? super S>) jVar, dVar);
        return objA == wm.a.COROUTINE_SUSPENDED ? objA : l2.f10208a;
    }

    public i(@os.l sq.i<? extends T> iVar, @os.l um.g gVar, int i10, @os.l pq.i iVar2) {
        super(iVar, gVar, i10, iVar2);
    }
}
