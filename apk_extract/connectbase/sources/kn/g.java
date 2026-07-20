package kn;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends nm.v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final int[] f9305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9306b;

    public g(@os.l int[] iArr) {
        l0.p(iArr, dc.d.f3685p);
        this.f9305a = iArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f9306b < this.f9305a.length;
    }

    @Override // nm.v0
    public int nextInt() {
        try {
            int[] iArr = this.f9305a;
            int i10 = this.f9306b;
            this.f9306b = i10 + 1;
            return iArr[i10];
        } catch (ArrayIndexOutOfBoundsException e10) {
            this.f9306b--;
            throw new NoSuchElementException(e10.getMessage());
        }
    }
}
