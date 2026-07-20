package va;

import android.annotation.NonNull;
import vd.j0;

/* JADX INFO: loaded from: classes2.dex */
public class q {
    public static final long A = 4194304;
    public static final long B = 8388608;
    public static final long C = 16777216;
    public static final long D = 33554432;
    public static final long E = 67108864;
    public static final long F = 134217728;
    public static final int G = 127;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f16808c = "q";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f16809d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f16810e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f16811f = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final long f16812g = 4;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final long f16813h = 8;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final long f16814i = 16;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final long f16815j = 32;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final long f16816k = 64;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final long f16817l = 128;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final long f16818m = 256;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final long f16819n = 512;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final long f16820o = 1024;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final long f16821p = 2048;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final long f16822q = 4096;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final long f16823r = 8192;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final long f16824s = 16384;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final long f16825t = 32768;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final long f16826u = 65536;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final long f16827v = 131072;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final long f16828w = 262144;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final long f16829x = 524288;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final long f16830y = 1048576;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final long f16831z = 2097152;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j0 f16832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e8.r f16833b;

    public void a(long j10, @NonNull String str, int i10) {
        c(fc.b.a.G).b(j10, str, i10);
    }

    public void b(long j10, @NonNull String str, int i10) {
        c(fc.b.a.G).a(j10, str, i10);
    }

    public pg.n c(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f16808c, "TranThubTraceManager");
            j0 j0Var = this.f16832a;
            if (j0Var != null) {
                return j0Var;
            }
            j0 j0Var2 = new j0();
            this.f16832a = j0Var2;
            return j0Var2;
        }
        dc.e.f(f16808c, "TranAospTraceManager");
        e8.r rVar = this.f16833b;
        if (rVar != null) {
            return rVar;
        }
        e8.r rVar2 = new e8.r();
        this.f16833b = rVar2;
        return rVar2;
    }

    @yb.a(level = 1)
    public void d(long j10, String str) {
        c(fc.b.a.f5981a).d(j10, str);
    }

    @yb.a(level = 1)
    public void e(long j10) {
        c(fc.b.a.f5981a).c(j10);
    }
}
