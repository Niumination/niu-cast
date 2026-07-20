package kn;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends nm.q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final short[] f9317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9318b;

    public l(@os.l short[] sArr) {
        l0.p(sArr, dc.d.f3685p);
        this.f9317a = sArr;
    }

    @Override // nm.q1
    public short c() {
        try {
            short[] sArr = this.f9317a;
            int i10 = this.f9318b;
            this.f9318b = i10 + 1;
            return sArr[i10];
        } catch (ArrayIndexOutOfBoundsException e10) {
            this.f9318b--;
            throw new NoSuchElementException(e10.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f9318b < this.f9317a.length;
    }
}
