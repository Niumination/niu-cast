package tn;

import java.util.NoSuchElementException;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends nm.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f15896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f15897b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f15898c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f15899d;

    public b(char c10, char c11, int i10) {
        this.f15896a = i10;
        this.f15897b = c11;
        boolean z10 = false;
        if (i10 <= 0 ? l0.t(c10, c11) >= 0 : l0.t(c10, c11) <= 0) {
            z10 = true;
        }
        this.f15898c = z10;
        this.f15899d = z10 ? c10 : c11;
    }

    @Override // nm.v
    public char c() {
        int i10 = this.f15899d;
        if (i10 != this.f15897b) {
            this.f15899d = this.f15896a + i10;
        } else {
            if (!this.f15898c) {
                throw new NoSuchElementException();
            }
            this.f15898c = false;
        }
        return (char) i10;
    }

    public final int e() {
        return this.f15896a;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f15898c;
    }
}
