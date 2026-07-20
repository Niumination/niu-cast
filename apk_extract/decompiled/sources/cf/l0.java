package cf;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class l0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Runnable f1585b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1586c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1587d;
    public int e;
    public final k0 f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ o0 f1589h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final qj.f f1584a = new qj.f();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f1588g = false;

    public l0(o0 o0Var, int i8, int i9, k0 k0Var) {
        this.f1589h = o0Var;
        this.f1586c = i8;
        this.f1587d = i9;
        this.f = k0Var;
    }

    public final boolean a() {
        return this.f1584a.f9195b > 0;
    }

    public final int b(int i8) {
        if (i8 <= 0 || Integer.MAX_VALUE - i8 >= this.f1587d) {
            int i9 = this.f1587d + i8;
            this.f1587d = i9;
            return i9;
        }
        throw new IllegalArgumentException("Window size overflow for stream: " + this.f1586c);
    }

    public final void c(int i8, qj.f fVar, boolean z2) {
        do {
            o0 o0Var = this.f1589h;
            int iMin = Math.min(i8, ((e) o0Var.f1605c).J());
            int i9 = -iMin;
            ((l0) o0Var.f1606d).b(i9);
            b(i9);
            try {
                ((e) o0Var.f1605c).e0(fVar.f9195b == ((long) iMin) && z2, this.f1586c, fVar, iMin);
                this.f.a(iMin);
                i8 -= iMin;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } while (i8 > 0);
    }

    public final void d(int i8, n0 n0Var) {
        Runnable runnable;
        int i9 = this.f1587d;
        o0 o0Var = this.f1589h;
        int iMin = Math.min(i8, Math.min(i9, ((l0) o0Var.f1606d).f1587d));
        int i10 = 0;
        while (a() && iMin > 0) {
            long j8 = iMin;
            qj.f fVar = this.f1584a;
            long j10 = fVar.f9195b;
            if (j8 >= j10) {
                int i11 = (int) j10;
                i10 += i11;
                c(i11, fVar, this.f1588g);
            } else {
                i10 += iMin;
                c(iMin, fVar, false);
            }
            n0Var.f1602a++;
            iMin = Math.min(i8 - i10, Math.min(this.f1587d, ((l0) o0Var.f1606d).f1587d));
        }
        if (a() || (runnable = this.f1585b) == null) {
            return;
        }
        runnable.run();
        this.f1585b = null;
    }
}
