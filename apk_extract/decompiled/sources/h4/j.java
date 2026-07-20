package h4;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class j extends l implements Serializable {
    static final j INSTANCE = new j();
    private static final long serialVersionUID = 1;

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // h4.l
    public boolean doEquivalent(Object obj, Object obj2) {
        return false;
    }

    @Override // h4.l
    public int doHash(Object obj) {
        return System.identityHashCode(obj);
    }
}
