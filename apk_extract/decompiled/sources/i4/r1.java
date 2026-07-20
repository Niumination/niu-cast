package i4;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class r1 implements Serializable {
    private static final long serialVersionUID = 0;
    final Object[] elements;

    public r1(Object[] objArr) {
        this.elements = objArr;
    }

    public Object readResolve() {
        return s1.copyOf(this.elements);
    }
}
