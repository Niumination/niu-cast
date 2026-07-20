package f1;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
@b1.b(serializable = true)
@x0
public final class a8 extends l5<Object> implements Serializable {
    static final a8 INSTANCE = new a8();
    private static final long serialVersionUID = 0;

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // f1.l5, java.util.Comparator
    public int compare(Object left, Object right) {
        return left.toString().compareTo(right.toString());
    }

    public String toString() {
        return "Ordering.usingToString()";
    }
}
