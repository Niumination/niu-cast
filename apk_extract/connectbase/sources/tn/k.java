package tn;

import java.util.NoSuchElementException;
import nm.v0;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f15914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f15915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f15916c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f15917d;

    public k(int i10, int i11, int i12) {
        this.f15914a = i12;
        this.f15915b = i11;
        boolean z10 = false;
        if (i12 <= 0 ? i10 >= i11 : i10 <= i11) {
            z10 = true;
        }
        this.f15916c = z10;
        this.f15917d = z10 ? i10 : i11;
    }

    public final int a() {
        return this.f15914a;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f15916c;
    }

    @Override // nm.v0
    public int nextInt() {
        int i10 = this.f15917d;
        if (i10 != this.f15915b) {
            this.f15917d = this.f15914a + i10;
        } else {
            if (!this.f15916c) {
                throw new NoSuchElementException();
            }
            this.f15916c = false;
        }
        return i10;
    }
}
