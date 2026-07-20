package kn;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends nm.n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final float[] f9303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9304b;

    public f(@os.l float[] fArr) {
        l0.p(fArr, dc.d.f3685p);
        this.f9303a = fArr;
    }

    @Override // nm.n0
    public float c() {
        try {
            float[] fArr = this.f9303a;
            int i10 = this.f9304b;
            this.f9304b = i10 + 1;
            return fArr[i10];
        } catch (ArrayIndexOutOfBoundsException e10) {
            this.f9304b--;
            throw new NoSuchElementException(e10.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f9304b < this.f9303a.length;
    }
}
