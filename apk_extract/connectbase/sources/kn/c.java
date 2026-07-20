package kn;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends nm.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final byte[] f9294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9295b;

    public c(@os.l byte[] bArr) {
        l0.p(bArr, dc.d.f3685p);
        this.f9294a = bArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f9295b < this.f9294a.length;
    }

    @Override // nm.u
    public byte nextByte() {
        try {
            byte[] bArr = this.f9294a;
            int i10 = this.f9295b;
            this.f9295b = i10 + 1;
            return bArr[i10];
        } catch (ArrayIndexOutOfBoundsException e10) {
            this.f9295b--;
            throw new NoSuchElementException(e10.getMessage());
        }
    }
}
