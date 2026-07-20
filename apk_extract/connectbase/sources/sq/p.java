package sq;

import nq.l2;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class p {
    @os.l
    public static final <T> i<T> b(@os.l i<? extends T> iVar, int i10, @os.l pq.i iVar2) {
        if (i10 < 0 && i10 != -2 && i10 != -1) {
            throw new IllegalArgumentException(h.a.a("Buffer size should be non-negative, BUFFERED, or CONFLATED, but was ", i10).toString());
        }
        if (i10 == -1 && iVar2 != pq.i.SUSPEND) {
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
        }
        if (i10 == -1) {
            iVar2 = pq.i.DROP_OLDEST;
            i10 = 0;
        }
        int i11 = i10;
        pq.i iVar3 = iVar2;
        return iVar instanceof tq.r ? tq.r.a.a((tq.r) iVar, null, i11, iVar3, 1, null) : new tq.i(iVar, null, i11, iVar3, 2, null);
    }

    public static /* synthetic */ i c(i iVar, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = -2;
        }
        return d(iVar, i10, null, 2, null);
    }

    public static i d(i iVar, int i10, pq.i iVar2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = -2;
        }
        if ((i11 & 2) != 0) {
            iVar2 = pq.i.SUSPEND;
        }
        return b(iVar, i10, iVar2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @os.l
    public static final <T> i<T> e(@os.l i<? extends T> iVar) {
        return iVar instanceof c ? iVar : new d(iVar);
    }

    public static final void f(um.g gVar) {
        if (gVar.get(l2.f11882k) == null) {
            return;
        }
        throw new IllegalArgumentException(("Flow context cannot contain job in it. Had " + gVar).toString());
    }

    @os.l
    public static final <T> i<T> g(@os.l i<? extends T> iVar) {
        return d(iVar, -1, null, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @os.l
    public static final <T> i<T> h(@os.l i<? extends T> iVar, @os.l um.g gVar) {
        f(gVar);
        if (kn.l0.g(gVar, um.i.INSTANCE)) {
            return iVar;
        }
        return iVar instanceof tq.r ? tq.r.a.a((tq.r) iVar, gVar, 0, null, 6, null) : new tq.i(iVar, gVar, 0, null, 12, null);
    }
}
