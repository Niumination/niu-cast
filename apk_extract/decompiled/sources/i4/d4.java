package i4;

import k3.u8;

/* JADX INFO: loaded from: classes.dex */
public abstract class d4 implements b4 {
    public boolean equals(Object obj) {
        if (!(obj instanceof b4)) {
            return false;
        }
        b4 b4Var = (b4) obj;
        return getCount() == b4Var.getCount() && u8.a(getElement(), b4Var.getElement());
    }

    public int hashCode() {
        Object element = getElement();
        return getCount() ^ (element == null ? 0 : element.hashCode());
    }

    public String toString() {
        String strValueOf = String.valueOf(getElement());
        int count = getCount();
        if (count == 1) {
            return strValueOf;
        }
        return strValueOf + " x " + count;
    }
}
