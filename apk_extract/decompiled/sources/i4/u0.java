package i4;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class u0 implements Serializable {
    private static final long serialVersionUID = 0;
    final t0 map;

    public u0(t0 t0Var) {
        this.map = t0Var;
    }

    public Object readResolve() {
        return this.map.entrySet();
    }
}
