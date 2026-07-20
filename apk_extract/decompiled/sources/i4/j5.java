package i4;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class j5 extends o4 implements Serializable {
    static final j5 INSTANCE = new j5();
    private static final long serialVersionUID = 0;

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return obj.toString().compareTo(obj2.toString());
    }

    public String toString() {
        return "Ordering.usingToString()";
    }
}
