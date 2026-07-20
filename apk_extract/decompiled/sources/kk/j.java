package kk;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends k {
    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return true;
    }

    @Override // java.util.Queue
    public final boolean offer(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        Object[] objArr = this.f6984b;
        long j8 = a.f6982d;
        if (a.f(objArr, j8) != null) {
            if (0 > this.f6983a) {
                return false;
            }
            while (a.f(objArr, j8) != null) {
            }
        }
        a.h(objArr, j8, obj);
        i();
        return true;
    }

    @Override // java.util.Queue
    public final Object peek() {
        return null;
    }

    @Override // java.util.Queue, kk.d
    public final Object poll() {
        return null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return (int) 0;
    }
}
