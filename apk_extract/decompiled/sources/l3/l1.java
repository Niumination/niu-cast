package l3;

import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class l1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l0 f7263b = new l0(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f7264a;

    public l1(int i8) {
        p1 p1Var;
        switch (i8) {
            case 1:
                this.f7264a = new ArrayDeque();
                break;
            default:
                try {
                    p1Var = (p1) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
                } catch (Exception unused) {
                    p1Var = f7263b;
                }
                k1 k1Var = new k1(l0.f7261b, p1Var);
                Charset charset = z0.f7328a;
                this.f7264a = k1Var;
                break;
        }
    }

    public void a(int i8, int i9) {
        c0 c0Var = (c0) this.f7264a;
        c0Var.j(i8, (i9 >> 31) ^ (i9 + i9));
    }

    public void b(int i8, long j8) {
        c0 c0Var = (c0) this.f7264a;
        c0Var.l(i8, (j8 >> 63) ^ (j8 + j8));
    }

    public void c(int i8, int i9) {
        ((c0) this.f7264a).j(i8, i9);
    }

    public void d(int i8, long j8) {
        ((c0) this.f7264a).l(i8, j8);
    }

    public void e(int i8, boolean z2) {
        c0 c0Var = (c0) this.f7264a;
        c0Var.k(i8 << 3);
        c0Var.a(z2 ? (byte) 1 : (byte) 0);
    }

    public void f(b0 b0Var) {
        if (!b0Var.zzh()) {
            if (!(b0Var instanceof e2)) {
                throw new IllegalArgumentException("Has a new type of ByteString been created? Found ".concat(String.valueOf(b0Var.getClass())));
            }
            e2 e2Var = (e2) b0Var;
            f(e2Var.zzd);
            f(e2Var.zze);
            return;
        }
        int iBinarySearch = Arrays.binarySearch(e2.zza, b0Var.zzd());
        if (iBinarySearch < 0) {
            iBinarySearch = (-(iBinarySearch + 1)) - 1;
        }
        int iZzc = e2.zzc(iBinarySearch + 1);
        ArrayDeque arrayDeque = (ArrayDeque) this.f7264a;
        if (arrayDeque.isEmpty() || ((b0) arrayDeque.peek()).zzd() >= iZzc) {
            arrayDeque.push(b0Var);
            return;
        }
        int iZzc2 = e2.zzc(iBinarySearch);
        b0 e2Var2 = (b0) arrayDeque.pop();
        while (true) {
            if (arrayDeque.isEmpty() || ((b0) arrayDeque.peek()).zzd() >= iZzc2) {
                break;
            } else {
                e2Var2 = new e2((b0) arrayDeque.pop(), e2Var2);
            }
        }
        e2 e2Var3 = new e2(e2Var2, b0Var);
        while (!arrayDeque.isEmpty()) {
            int iBinarySearch2 = Arrays.binarySearch(e2.zza, e2Var3.zzd());
            if (iBinarySearch2 < 0) {
                iBinarySearch2 = (-(iBinarySearch2 + 1)) - 1;
            }
            if (((b0) arrayDeque.peek()).zzd() >= e2.zzc(iBinarySearch2 + 1)) {
                break;
            } else {
                e2Var3 = new e2((b0) arrayDeque.pop(), e2Var3);
            }
        }
        arrayDeque.push(e2Var3);
    }

    public void g(int i8, b0 b0Var) {
        ((c0) this.f7264a).c(i8, b0Var);
    }

    public void h(int i8, double d7) {
        ((c0) this.f7264a).f(i8, Double.doubleToRawLongBits(d7));
    }

    public void i(int i8, int i9) {
        c0 c0Var = (c0) this.f7264a;
        c0Var.k(i8 << 3);
        if (i9 >= 0) {
            c0Var.k(i9);
        } else {
            c0Var.m(i9);
        }
    }

    public void j(int i8, int i9) {
        ((c0) this.f7264a).d(i8, i9);
    }

    public void k(int i8, long j8) {
        ((c0) this.f7264a).f(i8, j8);
    }

    public void l(int i8, float f) {
        ((c0) this.f7264a).d(i8, Float.floatToRawIntBits(f));
    }

    public void m(int i8, Object obj, f2 f2Var) {
        c0 c0Var = (c0) this.f7264a;
        c0Var.i(i8, 3);
        f2Var.e((q1) obj, c0Var.f7207a);
        c0Var.i(i8, 4);
    }

    public void n(int i8, int i9) {
        c0 c0Var = (c0) this.f7264a;
        c0Var.k(i8 << 3);
        if (i9 >= 0) {
            c0Var.k(i9);
        } else {
            c0Var.m(i9);
        }
    }

    public void o(int i8, long j8) {
        ((c0) this.f7264a).l(i8, j8);
    }

    public void p(int i8, Object obj, f2 f2Var) {
        q1 q1Var = (q1) obj;
        c0 c0Var = (c0) this.f7264a;
        c0Var.k((i8 << 3) | 2);
        c0Var.k(((q) q1Var).b(f2Var));
        f2Var.e(q1Var, c0Var.f7207a);
    }

    public void q(int i8, Object obj) {
        boolean z2 = obj instanceof b0;
        c0 c0Var = (c0) this.f7264a;
        if (z2) {
            c0Var.k(11);
            c0Var.j(2, i8);
            c0Var.c(3, (b0) obj);
            c0Var.k(12);
            return;
        }
        c0Var.k(11);
        c0Var.j(2, i8);
        c0Var.k(26);
        q0 q0Var = (q0) ((q1) obj);
        c0Var.k(q0Var.c());
        q0Var.l(c0Var);
        c0Var.k(12);
    }

    public void r(int i8, int i9) {
        ((c0) this.f7264a).d(i8, i9);
    }

    public void s(int i8, long j8) {
        ((c0) this.f7264a).f(i8, j8);
    }

    public l1(c0 c0Var) {
        Charset charset = z0.f7328a;
        this.f7264a = c0Var;
        c0Var.f7207a = this;
    }
}
