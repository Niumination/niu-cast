package kn;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends nm.i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final double[] f9301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9302b;

    public e(@os.l double[] dArr) {
        l0.p(dArr, dc.d.f3685p);
        this.f9301a = dArr;
    }

    @Override // nm.i0
    public double c() {
        try {
            double[] dArr = this.f9301a;
            int i10 = this.f9302b;
            this.f9302b = i10 + 1;
            return dArr[i10];
        } catch (ArrayIndexOutOfBoundsException e10) {
            this.f9302b--;
            throw new NoSuchElementException(e10.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f9302b < this.f9301a.length;
    }
}
