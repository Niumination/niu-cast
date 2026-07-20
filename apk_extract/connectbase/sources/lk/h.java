package lk;

import fl.t0;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
@t0
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10127b;

    public h(int i10, int i11) {
        this.f10126a = i10;
        this.f10127b = i11;
    }

    public final int a() {
        return this.f10127b;
    }

    public final int b() {
        return this.f10126a;
    }

    public final void c(int i10) {
        this.f10127b = i10;
    }

    public final void d(int i10) {
        this.f10126a = i10;
    }

    @l
    public String toString() {
        StringBuilder sb2 = new StringBuilder("MutableRange(start=");
        sb2.append(this.f10126a);
        sb2.append(", end=");
        return u.a.a(sb2, this.f10127b, ')');
    }
}
