package i4;

import java.io.Serializable;
import k3.d9;

/* JADX INFO: loaded from: classes.dex */
public final class e4 extends d4 implements Serializable {
    private static final long serialVersionUID = 0;
    private final int count;
    private final Object element;

    public e4(Object obj, int i8) {
        this.element = obj;
        this.count = i8;
        d9.b(i8, "count");
    }

    @Override // i4.b4
    public final int getCount() {
        return this.count;
    }

    @Override // i4.b4
    public final Object getElement() {
        return this.element;
    }

    public e4 nextInBucket() {
        return null;
    }
}
