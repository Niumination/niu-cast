package kn;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends nm.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final boolean[] f9289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9290b;

    public b(@os.l boolean[] zArr) {
        l0.p(zArr, dc.d.f3685p);
        this.f9289a = zArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f9290b < this.f9289a.length;
    }

    @Override // nm.t
    public boolean nextBoolean() {
        try {
            boolean[] zArr = this.f9289a;
            int i10 = this.f9290b;
            this.f9290b = i10 + 1;
            return zArr[i10];
        } catch (ArrayIndexOutOfBoundsException e10) {
            this.f9290b--;
            throw new NoSuchElementException(e10.getMessage());
        }
    }
}
