package tq;

import lm.z0;

/* JADX INFO: loaded from: classes3.dex */
public final class q {
    @z0
    public static final int a(int i10) {
        if (i10 >= 0) {
            return i10;
        }
        throw new ArithmeticException("Index overflow has happened");
    }

    public static final void b(@os.l a aVar, @os.l sq.j<?> jVar) {
        if (aVar.owner != jVar) {
            throw aVar;
        }
    }
}
