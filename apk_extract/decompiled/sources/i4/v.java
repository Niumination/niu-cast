package i4;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class v extends o4 implements Serializable {
    private static final long serialVersionUID = 0;
    final t0 rankMap;

    public v(t0 t0Var) {
        this.rankMap = t0Var;
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        Integer num = (Integer) this.rankMap.get(obj);
        if (num == null) {
            throw new n4(obj);
        }
        int iIntValue = num.intValue();
        Integer num2 = (Integer) this.rankMap.get(obj2);
        if (num2 != null) {
            return iIntValue - num2.intValue();
        }
        throw new n4(obj2);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj instanceof v) {
            return this.rankMap.equals(((v) obj).rankMap);
        }
        return false;
    }

    public int hashCode() {
        return this.rankMap.hashCode();
    }

    public String toString() {
        return "Ordering.explicit(" + this.rankMap.keySet() + ")";
    }

    public v(List<Object> list) {
        m0 m0Var = new m0(list.size());
        Iterator<Object> it = list.iterator();
        int i8 = 0;
        while (it.hasNext()) {
            m0Var.b(it.next(), Integer.valueOf(i8));
            i8++;
        }
        this(m0Var.a());
    }
}
