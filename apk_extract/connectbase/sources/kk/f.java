package kk;

import fl.t0;
import gq.s;
import gq.v;
import java.io.IOException;
import kn.l0;
import kn.n0;
import lm.j0;

/* JADX INFO: loaded from: classes2.dex */
@t0
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final lk.c f9213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public int[] f9215c;

    public static final class b extends n0 implements jn.l<Integer, Integer> {
        public static final b INSTANCE = new b();

        public b() {
            super(1);
        }

        @os.l
        public final Integer invoke(int i10) {
            return Integer.valueOf(i10 * 8);
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
            return invoke(num.intValue());
        }
    }

    public f(@os.l lk.c cVar) {
        l0.p(cVar, "builder");
        this.f9213a = cVar;
        this.f9215c = (int[]) g.f9220e.W0();
    }

    public static /* synthetic */ int d(f fVar, String str, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return fVar.c(str, i10);
    }

    public final int c(@os.l String str, int i10) {
        l0.p(str, "name");
        int i11 = lk.f.i(str, 0, 0, 3, null);
        int i12 = this.f9214b;
        while (i10 < i12) {
            int i13 = i10 + 1;
            if (this.f9215c[i10 * 8] == i11) {
                return i10;
            }
            i10 = i13;
        }
        return -1;
    }

    @os.m
    public final CharSequence e(@os.l String str) {
        l0.p(str, "name");
        int i10 = 0;
        int i11 = lk.f.i(str, 0, 0, 3, null);
        int i12 = this.f9214b;
        while (i10 < i12) {
            int i13 = i10 + 1;
            int i14 = i10 * 8;
            int[] iArr = this.f9215c;
            if (iArr[i14] == i11) {
                return this.f9213a.subSequence(iArr[i14 + 4], iArr[i14 + 5]);
            }
            i10 = i13;
        }
        return null;
    }

    @os.l
    public final gq.m<CharSequence> f(@os.l String str) {
        l0.p(str, "name");
        return v.k1(v.p0(v.k1(s.l(0, new a()), b.INSTANCE), new c(lk.f.i(str, 0, 0, 3, null))), new d());
    }

    public final int g() {
        return this.f9214b;
    }

    @os.l
    public final CharSequence h(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (i10 >= this.f9214b) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        int i11 = i10 * 8;
        int[] iArr = this.f9215c;
        return this.f9213a.subSequence(iArr[i11 + 2], iArr[i11 + 3]);
    }

    public final void i(int i10, int i11, int i12, int i13, int i14, int i15) {
        int i16 = this.f9214b;
        int i17 = i16 * 8;
        int[] iArr = this.f9215c;
        if (i17 >= iArr.length) {
            throw new j0(l0.C("An operation is not implemented: ", "Implement headers overflow"));
        }
        iArr[i17] = i10;
        iArr[i17 + 1] = i11;
        iArr[i17 + 2] = i12;
        iArr[i17 + 3] = i13;
        iArr[i17 + 4] = i14;
        iArr[i17 + 5] = i15;
        iArr[i17 + 6] = -1;
        iArr[i17 + 7] = -1;
        this.f9214b = i16 + 1;
    }

    public final void j() {
        this.f9214b = 0;
        int[] iArr = this.f9215c;
        this.f9215c = g.f9219d;
        if (iArr != g.f9219d) {
            g.f9220e.recycle(iArr);
        }
    }

    @os.l
    public final CharSequence k(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (i10 >= this.f9214b) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        int i11 = i10 * 8;
        int[] iArr = this.f9215c;
        return this.f9213a.subSequence(iArr[i11 + 4], iArr[i11 + 5]);
    }

    @os.l
    public String toString() throws IOException {
        StringBuilder sb2 = new StringBuilder();
        g.c(this, "", sb2);
        String string = sb2.toString();
        l0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static final class a extends n0 implements jn.l<Integer, Integer> {
        public a() {
            super(1);
        }

        @os.m
        public final Integer invoke(int i10) {
            int i11 = i10 + 1;
            if (i11 >= f.this.f9214b) {
                return null;
            }
            return Integer.valueOf(i11);
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
            return invoke(num.intValue());
        }
    }

    public static final class c extends n0 implements jn.l<Integer, Boolean> {
        final /* synthetic */ int $nameHash;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(int i10) {
            super(1);
            this.$nameHash = i10;
        }

        @os.l
        public final Boolean invoke(int i10) {
            return Boolean.valueOf(f.this.f9215c[i10] == this.$nameHash);
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
            return invoke(num.intValue());
        }
    }

    public static final class d extends n0 implements jn.l<Integer, CharSequence> {
        public d() {
            super(1);
        }

        @os.l
        public final CharSequence invoke(int i10) {
            f fVar = f.this;
            lk.c cVar = fVar.f9213a;
            int[] iArr = fVar.f9215c;
            return cVar.subSequence(iArr[i10 + 4], iArr[i10 + 5]);
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ CharSequence invoke(Integer num) {
            return invoke(num.intValue());
        }
    }
}
