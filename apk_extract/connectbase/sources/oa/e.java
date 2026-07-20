package oa;

import od.c1;
import x7.f;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    public static final int A = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f12130c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f12131d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f12132e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f12133f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f12134g = 2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f12135h = 4;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f12136i = 8;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f12137j = 16;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f12138k = 32;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f12139l = 64;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f12140m = 128;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f12141n = 256;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f12142o = 512;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f12143p = 1024;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f12144q = 1024;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f12145r = 67108864;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f12146s = 32768;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f12147t = 8192;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f12148u = 16384;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f12149v = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f12150w = 1073741824;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f12151x = -2147475456;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f12152y = 3;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f12153z = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c1 f12154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f12155b;

    public int a(int i10) {
        return c(fc.b.a.f5989i).d(i10);
    }

    public String b(int i10) {
        return c(fc.b.a.f5987g).e(i10);
    }

    public ig.e c(String str) {
        if (fc.b.b(str)) {
            c1 c1Var = this.f12154a;
            if (c1Var != null) {
                return c1Var;
            }
            c1 c1Var2 = new c1();
            this.f12154a = c1Var2;
            return c1Var2;
        }
        f fVar = this.f12155b;
        if (fVar != null) {
            return fVar;
        }
        f fVar2 = new f();
        this.f12155b = fVar2;
        return fVar2;
    }

    public boolean d(int i10) {
        return c(fc.b.a.f5987g).b(i10);
    }

    public int e() {
        return c(fc.b.a.f5989i).c();
    }

    public int f(int i10, int i11) {
        return c(fc.b.a.f5989i).a(i10, i11);
    }
}
