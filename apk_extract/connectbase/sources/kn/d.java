package kn;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends nm.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final char[] f9299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9300b;

    public d(@os.l char[] cArr) {
        l0.p(cArr, dc.d.f3685p);
        this.f9299a = cArr;
    }

    @Override // nm.v
    public char c() {
        try {
            char[] cArr = this.f9299a;
            int i10 = this.f9300b;
            this.f9300b = i10 + 1;
            return cArr[i10];
        } catch (ArrayIndexOutOfBoundsException e10) {
            this.f9300b--;
            throw new NoSuchElementException(e10.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f9300b < this.f9299a.length;
    }
}
