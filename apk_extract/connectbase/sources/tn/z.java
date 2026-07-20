package tn;

import java.util.Iterator;
import java.util.NoSuchElementException;
import lm.a2;
import lm.f1;

/* JADX INFO: loaded from: classes3.dex */
@f1(version = "1.3")
public final class z implements Iterator<a2>, ln.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f15948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f15949b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f15950c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f15951d;

    public /* synthetic */ z(long j10, long j11, long j12, kn.w wVar) {
        this(j10, j11, j12);
    }

    public long a() {
        long j10 = this.f15951d;
        if (j10 != this.f15948a) {
            this.f15951d = a2.m(this.f15950c + j10);
        } else {
            if (!this.f15949b) {
                throw new NoSuchElementException();
            }
            this.f15949b = false;
        }
        return j10;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f15949b;
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ a2 next() {
        return a2.b(a());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public z(long j10, long j11, long j12) {
        this.f15948a = j11;
        boolean z10 = false;
        if (j12 <= 0 ? Long.compareUnsigned(j10, j11) >= 0 : Long.compareUnsigned(j10, j11) <= 0) {
            z10 = true;
        }
        this.f15949b = z10;
        this.f15950c = a2.m(j12);
        this.f15951d = this.f15949b ? j10 : j11;
    }
}
