package i4;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class h1 implements Serializable {
    final j1 multimap;

    public h1(j1 j1Var) {
        this.multimap = j1Var;
    }

    public Object readResolve() {
        return this.multimap.keys();
    }
}
