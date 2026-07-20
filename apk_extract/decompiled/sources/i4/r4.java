package i4;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class r4 extends s1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient t0 f5684c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient Object[] f5685d;
    public final transient int e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final transient int f5686h;

    public r4(t0 t0Var, Object[] objArr, int i8, int i9) {
        this.f5684c = t0Var;
        this.f5685d = objArr;
        this.e = i8;
        this.f5686h = i9;
    }

    @Override // i4.a0, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        Object value = entry.getValue();
        return value != null && value.equals(this.f5684c.get(key));
    }

    @Override // i4.a0
    public int copyIntoArray(Object[] objArr, int i8) {
        return asList().copyIntoArray(objArr, i8);
    }

    @Override // i4.s1
    public h0 createAsList() {
        return new q4(this);
    }

    @Override // i4.a0
    public boolean isPartialView() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f5686h;
    }

    @Override // i4.s1, i4.a0, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public h5 iterator() {
        return asList().iterator();
    }
}
