package kn;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends nm.w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final long[] f9314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9315b;

    public k(@os.l long[] jArr) {
        l0.p(jArr, dc.d.f3685p);
        this.f9314a = jArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f9315b < this.f9314a.length;
    }

    @Override // nm.w0
    public long nextLong() {
        try {
            long[] jArr = this.f9314a;
            int i10 = this.f9315b;
            this.f9315b = i10 + 1;
            return jArr[i10];
        } catch (ArrayIndexOutOfBoundsException e10) {
            this.f9315b--;
            throw new NoSuchElementException(e10.getMessage());
        }
    }
}
