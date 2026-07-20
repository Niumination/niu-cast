package h4;

/* JADX INFO: loaded from: classes.dex */
public abstract class l {
    public static l equals() {
        return h.INSTANCE;
    }

    public static l identity() {
        return j.INSTANCE;
    }

    public abstract boolean doEquivalent(Object obj, Object obj2);

    public abstract int doHash(Object obj);

    public final boolean equivalent(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        return doEquivalent(obj, obj2);
    }

    public final r equivalentTo(Object obj) {
        return new i(this, obj);
    }

    public final int hash(Object obj) {
        if (obj == null) {
            return 0;
        }
        return doHash(obj);
    }

    public final <F> l onResultOf(m mVar) {
        return new n(mVar, this);
    }

    public final <S> l pairwise() {
        return new p(this);
    }

    public final <S> k wrap(S s2) {
        return new k(this, s2, null);
    }
}
