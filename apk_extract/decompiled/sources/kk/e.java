package kk;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends f {
    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return true;
    }

    @Override // java.util.Queue
    public final boolean offer(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        long j8 = this.f6983a + 1;
        long j10 = Long.MAX_VALUE;
        while (true) {
            long[] jArr = this.f6987h;
            long j11 = c.f6985i;
            long jI = c.i(jArr, j11);
            if (jI == 0) {
                if (k()) {
                    a.h(this.f6984b, a.f6982d, obj);
                    c.j(jArr, j11, 1L);
                    return true;
                }
            } else if (jI < 0) {
                long j12 = 0 - j8;
                if (j12 > j10) {
                    continue;
                } else {
                    if (j12 <= 0) {
                        return false;
                    }
                    j10 = 0;
                }
            } else {
                continue;
            }
        }
    }

    @Override // java.util.Queue
    public final Object peek() {
        return a.e(this.f6984b, a.f6982d);
    }

    @Override // java.util.Queue, kk.d
    public final Object poll() {
        while (true) {
            long[] jArr = this.f6987h;
            long j8 = c.f6985i;
            long jI = c.i(jArr, j8) - 1;
            if (jI == 0) {
                if (l()) {
                    Object[] objArr = this.f6984b;
                    long j10 = a.f6982d;
                    Object objE = a.e(objArr, j10);
                    a.h(objArr, j10, null);
                    c.j(jArr, j8, this.f6983a + 1);
                    return objE;
                }
            } else if (jI < 0) {
                return null;
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return (int) 0;
    }
}
