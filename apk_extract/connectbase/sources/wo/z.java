package wo;

import androidx.core.app.FrameMetricsAggregator;
import androidx.core.view.PointerIconCompat;
import kn.l0;
import vp.o1;

/* JADX INFO: loaded from: classes3.dex */
public final class z {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @os.l
    public static final a f19828k = new a();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @in.f
    @os.l
    public static final z f19829l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @in.f
    @os.l
    public static final z f19830m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @in.f
    @os.l
    public static final z f19831n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @in.f
    @os.l
    public static final z f19832o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @in.f
    @os.l
    public static final z f19833p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @in.f
    @os.l
    public static final z f19834q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @in.f
    @os.l
    public static final z f19835r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @in.f
    @os.l
    public static final z f19836s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @in.f
    @os.l
    public static final z f19837t;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f19838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f19839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f19840c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f19841d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f19842e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.m
    public final z f19843f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f19844g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @os.m
    public final z f19845h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.m
    public final z f19846i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f19847j;

    public static final class a {
        public a() {
        }

        public a(kn.w wVar) {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19848a;

        static {
            int[] iArr = new int[o1.values().length];
            iArr[o1.IN_VARIANCE.ordinal()] = 1;
            iArr[o1.INVARIANT.ordinal()] = 2;
            f19848a = iArr;
        }
    }

    static {
        kn.w wVar = null;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        z zVar = null;
        boolean z14 = false;
        z zVar2 = null;
        z zVar3 = null;
        boolean z15 = false;
        z zVar4 = new z(z10, false, z11, z12, z13, zVar, z14, zVar2, zVar3, z15, 1023, wVar);
        f19829l = zVar4;
        kn.w wVar2 = null;
        boolean z16 = false;
        boolean z17 = false;
        boolean z18 = false;
        boolean z19 = false;
        boolean z20 = false;
        boolean z21 = false;
        z zVar5 = null;
        z zVar6 = null;
        boolean z22 = true;
        z zVar7 = new z(z16, z17, z18, z19, z20, null, z21, zVar5, zVar6, z22, FrameMetricsAggregator.EVERY_DURATION, wVar2);
        f19830m = zVar7;
        f19831n = new z(z10, true, z11, z12, z13, zVar, z14, zVar2, zVar3, z15, PointerIconCompat.TYPE_GRABBING, wVar);
        int i10 = 988;
        f19832o = new z(z10, false, z11, z12, z13, zVar4, z14, zVar2, zVar3, z15, i10, wVar);
        f19833p = new z(z16, z17, z18, z19, z20, zVar7, z21, zVar5, zVar6, z22, 476, wVar2);
        f19834q = new z(z10, true, z11, z12, z13, zVar4, z14, zVar2, zVar3, z15, i10, wVar);
        boolean z23 = false;
        boolean z24 = true;
        f19835r = new z(z10, z23, z11, z24, z13, zVar4, z14, zVar2, zVar3, z15, 983, wVar);
        f19836s = new z(z10, z23, z11, z24, z13, zVar4, z14, zVar2, zVar3, z15, 919, wVar);
        f19837t = new z(z10, z23, true, false, z13, zVar4, z14, zVar2, zVar3, z15, 984, wVar);
    }

    public z() {
        this(false, false, false, false, false, null, false, null, null, false, 1023, null);
    }

    public final boolean a() {
        return this.f19844g;
    }

    public final boolean b() {
        return this.f19847j;
    }

    public final boolean c() {
        return this.f19839b;
    }

    public final boolean d() {
        return this.f19838a;
    }

    public final boolean e() {
        return this.f19840c;
    }

    @os.l
    public final z f(@os.l o1 o1Var, boolean z10) {
        z zVar;
        l0.p(o1Var, "effectiveVariance");
        if (z10 && this.f19840c) {
            return this;
        }
        int i10 = b.f19848a[o1Var.ordinal()];
        if (i10 == 1) {
            zVar = this.f19845h;
            if (zVar == null) {
                return this;
            }
        } else if (i10 != 2) {
            zVar = this.f19843f;
            if (zVar == null) {
                return this;
            }
        } else {
            zVar = this.f19846i;
            if (zVar == null) {
                return this;
            }
        }
        return zVar;
    }

    @os.l
    public final z g() {
        return new z(this.f19838a, true, this.f19840c, this.f19841d, this.f19842e, this.f19843f, this.f19844g, this.f19845h, this.f19846i, false, 512, null);
    }

    public z(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, @os.m z zVar, boolean z15, @os.m z zVar2, @os.m z zVar3, boolean z16) {
        this.f19838a = z10;
        this.f19839b = z11;
        this.f19840c = z12;
        this.f19841d = z13;
        this.f19842e = z14;
        this.f19843f = zVar;
        this.f19844g = z15;
        this.f19845h = zVar2;
        this.f19846i = zVar3;
        this.f19847j = z16;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ z(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, z zVar, boolean z15, z zVar2, z zVar3, boolean z16, int i10, kn.w wVar) {
        z10 = (i10 & 1) != 0 ? true : z10;
        z11 = (i10 & 2) != 0 ? true : z11;
        z12 = (i10 & 4) != 0 ? false : z12;
        z13 = (i10 & 8) != 0 ? false : z13;
        z14 = (i10 & 16) != 0 ? false : z14;
        zVar = (i10 & 32) != 0 ? null : zVar;
        this(z10, z11, z12, z13, z14, zVar, (i10 & 64) != 0 ? true : z15, (i10 & 128) != 0 ? zVar : zVar2, (i10 & 256) != 0 ? zVar : zVar3, (i10 & 512) != 0 ? false : z16);
    }
}
