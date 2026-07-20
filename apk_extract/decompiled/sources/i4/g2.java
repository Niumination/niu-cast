package i4;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.RandomAccess;
import k3.cb;
import k3.v8;

/* JADX INFO: loaded from: classes.dex */
public final class g2 extends AbstractList implements Serializable, RandomAccess {
    private static final long serialVersionUID = 0;
    final Object first;
    final Object[] rest;

    public g2(Object obj, Object[] objArr) {
        this.first = obj;
        objArr.getClass();
        this.rest = objArr;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i8) {
        v8.h(i8, size());
        return i8 == 0 ? this.first : this.rest[i8 - 1];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return cb.b(((long) this.rest.length) + ((long) 1));
    }
}
