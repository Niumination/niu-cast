package tn;

import java.util.Iterator;
import java.util.NoSuchElementException;
import lm.f1;
import lm.w1;

/* JADX INFO: loaded from: classes3.dex */
@f1(version = "1.3")
public final class w implements Iterator<w1>, ln.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f15938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f15939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f15940c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f15941d;

    public /* synthetic */ w(int i10, int i11, int i12, kn.w wVar) {
        this(i10, i11, i12);
    }

    public int a() {
        int i10 = this.f15941d;
        if (i10 != this.f15938a) {
            this.f15941d = w1.m(this.f15940c + i10);
        } else {
            if (!this.f15939b) {
                throw new NoSuchElementException();
            }
            this.f15939b = false;
        }
        return i10;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f15939b;
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ w1 next() {
        return w1.b(a());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public w(int i10, int i11, int i12) {
        this.f15938a = i11;
        boolean z10 = false;
        int iCompareUnsigned = Integer.compareUnsigned(i10, i11);
        if (i12 <= 0 ? iCompareUnsigned >= 0 : iCompareUnsigned <= 0) {
            z10 = true;
        }
        this.f15939b = z10;
        this.f15940c = w1.m(i12);
        this.f15941d = this.f15939b ? i10 : i11;
    }
}
