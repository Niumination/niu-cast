package kk;

/* JADX INFO: loaded from: classes3.dex */
public final class o extends r {
    public o(int i8) {
        super(i8);
        Math.min(i8 / 4, p.f6991h.intValue());
    }

    public final long i() {
        return s.f6994a.getLongVolatile(this, r.f6993j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return j() == i();
    }

    public final long j() {
        return s.f6994a.getLongVolatile(this, q.f6992i);
    }

    public final void k() {
        s.f6994a.putOrderedLong(this, r.f6993j, 1L);
    }

    public final void l() {
        s.f6994a.putOrderedLong(this, q.f6992i, 1L);
    }

    @Override // java.util.Queue
    public final boolean offer(Object obj) {
        if (obj == null) {
            throw new NullPointerException("null elements not allowed");
        }
        Object[] objArr = this.f6984b;
        long j8 = a.f6982d;
        if (a.f(objArr, j8) != null) {
            return false;
        }
        l();
        a.g(objArr, j8, obj);
        return true;
    }

    @Override // java.util.Queue
    public final Object peek() {
        return a.f(this.f6984b, a.f6982d);
    }

    @Override // java.util.Queue, kk.d
    public final Object poll() {
        Object[] objArr = this.f6984b;
        long j8 = a.f6982d;
        Object objF = a.f(objArr, j8);
        if (objF == null) {
            return null;
        }
        k();
        a.g(objArr, j8, null);
        return objF;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        long jI = i();
        while (true) {
            long j8 = j();
            long jI2 = i();
            if (jI == jI2) {
                return (int) (j8 - jI2);
            }
            jI = jI2;
        }
    }
}
