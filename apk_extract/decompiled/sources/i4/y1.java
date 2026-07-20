package i4;

import java.io.Serializable;
import java.util.Comparator;
import k3.k9;

/* JADX INFO: loaded from: classes.dex */
public final class y1 implements Serializable {
    private static final long serialVersionUID = 0;
    final Comparator<Object> comparator;
    final Object[] elements;

    public y1(Comparator<Object> comparator, Object[] objArr) {
        this.comparator = comparator;
        this.elements = objArr;
    }

    public Object readResolve() {
        x1 x1Var = new x1(this.comparator);
        Object[] objArr = this.elements;
        if (x1Var.f5682d != null) {
            for (Object obj : objArr) {
                x1Var.d(obj);
            }
        } else {
            int length = objArr.length;
            k9.a(length, objArr);
            x1Var.c(x1Var.f5713b + length);
            System.arraycopy(objArr, 0, x1Var.f5712a, x1Var.f5713b, length);
            x1Var.f5713b += length;
        }
        return x1Var.e();
    }
}
