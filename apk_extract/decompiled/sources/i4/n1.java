package i4;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class n1 implements Serializable {
    final o1 multiset;

    public n1(o1 o1Var) {
        this.multiset = o1Var;
    }

    public Object readResolve() {
        return this.multiset.entrySet();
    }
}
