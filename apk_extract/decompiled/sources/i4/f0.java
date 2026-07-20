package i4;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class f0 implements Serializable {
    private static final long serialVersionUID = 0;
    final Object[] elements;

    public f0(Object[] objArr) {
        this.elements = objArr;
    }

    public Object readResolve() {
        return h0.copyOf(this.elements);
    }
}
