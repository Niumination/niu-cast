package tn;

import java.util.NoSuchElementException;
import nm.w0;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f15924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f15925b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f15926c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f15927d;

    public n(long j10, long j11, long j12) {
        this.f15924a = j12;
        this.f15925b = j11;
        boolean z10 = false;
        if (j12 <= 0 ? j10 >= j11 : j10 <= j11) {
            z10 = true;
        }
        this.f15926c = z10;
        this.f15927d = z10 ? j10 : j11;
    }

    public final long a() {
        return this.f15924a;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f15926c;
    }

    @Override // nm.w0
    public long nextLong() {
        long j10 = this.f15927d;
        if (j10 != this.f15925b) {
            this.f15927d = this.f15924a + j10;
        } else {
            if (!this.f15926c) {
                throw new NoSuchElementException();
            }
            this.f15926c = false;
        }
        return j10;
    }
}
