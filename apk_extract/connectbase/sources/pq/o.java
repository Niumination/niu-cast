package pq;

import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
public final class o {
    @lm.k(level = lm.m.HIDDEN, message = "Since 1.4.0, binary compatibility with earlier versions")
    public static final /* synthetic */ l a(int i10) {
        return d(i10, null, null, 6, null);
    }

    @os.l
    public static final <E> l<E> b(int i10, @os.l i iVar, @os.m jn.l<? super E, l2> lVar) {
        l<E> yVar;
        if (i10 != -2) {
            if (i10 == -1) {
                if (iVar == i.SUSPEND) {
                    return new y(1, i.DROP_OLDEST, lVar);
                }
                throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
            }
            if (i10 != 0) {
                if (i10 != Integer.MAX_VALUE) {
                    return iVar == i.SUSPEND ? new j(i10, lVar) : new y(i10, iVar, lVar);
                }
                return new j(Integer.MAX_VALUE, lVar);
            }
            yVar = iVar == i.SUSPEND ? new j<>(0, lVar) : new y<>(1, iVar, lVar);
        } else if (iVar == i.SUSPEND) {
            l.f13292l.getClass();
            yVar = new j<>(l.b.f13306h, lVar);
        } else {
            yVar = new y<>(1, iVar, lVar);
        }
        return yVar;
    }

    public static /* synthetic */ l c(int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        return a(i10);
    }

    public static /* synthetic */ l d(int i10, i iVar, jn.l lVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        if ((i11 & 2) != 0) {
            iVar = i.SUSPEND;
        }
        if ((i11 & 4) != 0) {
            lVar = null;
        }
        return b(i10, iVar, lVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T e(@os.l Object obj, @os.l jn.l<? super Throwable, ? extends T> lVar) {
        return obj instanceof p.c ? lVar.invoke(p.f(obj)) : obj;
    }

    @os.l
    public static final <T> Object f(@os.l Object obj, @os.l jn.l<? super Throwable, l2> lVar) {
        if (obj instanceof p.a) {
            lVar.invoke(p.f(obj));
        }
        return obj;
    }

    @os.l
    public static final <T> Object g(@os.l Object obj, @os.l jn.l<? super Throwable, l2> lVar) {
        if (obj instanceof p.c) {
            lVar.invoke(p.f(obj));
        }
        return obj;
    }

    @os.l
    public static final <T> Object h(@os.l Object obj, @os.l jn.l<? super T, l2> lVar) {
        if (!(obj instanceof p.c)) {
            lVar.invoke(obj);
        }
        return obj;
    }
}
