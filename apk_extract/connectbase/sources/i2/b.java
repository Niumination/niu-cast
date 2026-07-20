package i2;

import android.graphics.Bitmap;
import f2.a0;
import f2.b0;
import kn.l0;
import l2.o;
import lm.t0;
import os.m;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m
    public t0<a0, b0> f7673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m
    public t0<a0, b0> f7674b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7675c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @m
    public Bitmap f7676d;

    public b() {
    }

    @m
    public final Bitmap a() {
        return this.f7676d;
    }

    @m
    public final t0<a0, b0> b() {
        return this.f7674b;
    }

    public final int c() {
        return this.f7675c;
    }

    @m
    public final t0<a0, b0> d() {
        return this.f7673a;
    }

    public final void e() {
        this.f7676d = null;
        this.f7673a = null;
        this.f7674b = null;
    }

    public boolean equals(@m Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (!l0.g(this.f7676d, bVar.f7676d)) {
                t0<a0, b0> t0Var = this.f7673a;
                a0 first = t0Var == null ? null : t0Var.getFirst();
                t0<a0, b0> t0Var2 = bVar.f7673a;
                if (!l0.g(first, t0Var2 == null ? null : t0Var2.getFirst())) {
                    t0<a0, b0> t0Var3 = this.f7673a;
                    b0 second = t0Var3 == null ? null : t0Var3.getSecond();
                    t0<a0, b0> t0Var4 = bVar.f7673a;
                    if (!l0.g(second, t0Var4 == null ? null : t0Var4.getSecond())) {
                        t0<a0, b0> t0Var5 = this.f7674b;
                        a0 first2 = t0Var5 == null ? null : t0Var5.getFirst();
                        t0<a0, b0> t0Var6 = bVar.f7674b;
                        if (!l0.g(first2, t0Var6 == null ? null : t0Var6.getFirst())) {
                            t0<a0, b0> t0Var7 = this.f7674b;
                            b0 second2 = t0Var7 == null ? null : t0Var7.getSecond();
                            t0<a0, b0> t0Var8 = bVar.f7674b;
                            if (!l0.g(second2, t0Var8 != null ? t0Var8.getSecond() : null)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final void f(@m Bitmap bitmap) {
        int i10 = this.f7675c;
        if (i10 > 0) {
            o.f9680a.b(i10);
            this.f7675c = 0;
        }
        this.f7676d = bitmap;
    }

    public final void g(Bitmap bitmap) {
        this.f7676d = bitmap;
    }

    public final void h(@m t0<a0, b0> t0Var) {
        this.f7674b = t0Var;
    }

    public int hashCode() {
        Bitmap bitmap = this.f7676d;
        int iHashCode = (bitmap == null ? 0 : bitmap.hashCode()) * 31;
        t0<a0, b0> t0Var = this.f7673a;
        int iHashCode2 = (iHashCode + (t0Var == null ? 0 : t0Var.hashCode())) * 31;
        t0<a0, b0> t0Var2 = this.f7674b;
        return iHashCode2 + (t0Var2 != null ? t0Var2.hashCode() : 0);
    }

    public final void i(@m t0<a0, b0> t0Var) {
        this.f7673a = t0Var;
    }

    public final int j() {
        int iA = o.f9680a.a(this.f7676d);
        this.f7675c = iA;
        return iA;
    }

    public b(@m Bitmap bitmap, @m t0<a0, b0> t0Var, @m t0<a0, b0> t0Var2) {
        this.f7674b = t0Var;
        this.f7673a = t0Var2;
        this.f7676d = bitmap;
    }
}
