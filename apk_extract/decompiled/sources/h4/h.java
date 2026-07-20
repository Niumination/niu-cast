package h4;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class h extends l implements Serializable {
    static final h INSTANCE = new h();
    private static final long serialVersionUID = 1;

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // h4.l
    public boolean doEquivalent(Object obj, Object obj2) {
        return obj.equals(obj2);
    }

    @Override // h4.l
    public int doHash(Object obj) {
        return obj.hashCode();
    }
}
