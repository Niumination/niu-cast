package i4;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class x4 implements Serializable {
    private static final long serialVersionUID = 0;
    final int[] counts;
    final Object[] elements;

    public x4(c4 c4Var) {
        int size = c4Var.entrySet().size();
        this.elements = new Object[size];
        this.counts = new int[size];
        int i8 = 0;
        for (b4 b4Var : c4Var.entrySet()) {
            this.elements[i8] = b4Var.getElement();
            this.counts[i8] = b4Var.getCount();
            i8++;
        }
    }

    public Object readResolve() {
        int length = this.elements.length;
        k4 k4Var = new k4();
        k4Var.e(length);
        int i8 = 0;
        while (true) {
            Object[] objArr = this.elements;
            if (i8 >= objArr.length) {
                break;
            }
            Object obj = objArr[i8];
            int i9 = this.counts[i8];
            if (i9 != 0) {
                obj.getClass();
                k4Var.f(k4Var.b(obj) + i9, obj);
            }
            i8++;
        }
        return k4Var.f5624c == 0 ? o1.of() : new y4(k4Var);
    }
}
