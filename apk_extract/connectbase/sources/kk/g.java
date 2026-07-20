package kk;

import fl.t0;
import java.io.IOException;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f9216a = 64;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f9217b = 8;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f9218c = 1000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final int[] f9219d = new int[0];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final bm.d<int[]> f9220e = new a();

    public static final class a extends bm.d<int[]> {
        public a() {
            super(1000);
        }

        @Override // bm.d
        public int[] n() {
            return new int[512];
        }

        @os.l
        public int[] y() {
            return new int[512];
        }
    }

    @t0
    public static final void c(@os.l f fVar, @os.l String str, @os.l Appendable appendable) throws IOException {
        l0.p(fVar, "<this>");
        l0.p(str, "indent");
        l0.p(appendable, "out");
        int i10 = fVar.f9214b;
        for (int i11 = 0; i11 < i10; i11++) {
            appendable.append(str);
            appendable.append(fVar.h(i11));
            appendable.append(" => ");
            appendable.append(fVar.k(i11));
            appendable.append("\n");
        }
    }

    public static /* synthetic */ void d() {
    }

    public static /* synthetic */ void e() {
    }
}
