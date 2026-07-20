package rp;

import kn.l0;
import lm.i0;
import vp.o1;

/* JADX INFO: loaded from: classes3.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final a0 f14685a = new a0();

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14686a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f14687b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f14688c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int[] f14689d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ int[] f14690e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ int[] f14691f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ int[] f14692g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final /* synthetic */ int[] f14693h;

        static {
            int[] iArr = new int[yo.a.k.values().length];
            iArr[yo.a.k.FINAL.ordinal()] = 1;
            iArr[yo.a.k.OPEN.ordinal()] = 2;
            iArr[yo.a.k.ABSTRACT.ordinal()] = 3;
            iArr[yo.a.k.SEALED.ordinal()] = 4;
            f14686a = iArr;
            int[] iArr2 = new int[eo.e0.values().length];
            iArr2[eo.e0.FINAL.ordinal()] = 1;
            iArr2[eo.e0.OPEN.ordinal()] = 2;
            iArr2[eo.e0.ABSTRACT.ordinal()] = 3;
            iArr2[eo.e0.SEALED.ordinal()] = 4;
            f14687b = iArr2;
            int[] iArr3 = new int[yo.a.x.values().length];
            iArr3[yo.a.x.INTERNAL.ordinal()] = 1;
            iArr3[yo.a.x.PRIVATE.ordinal()] = 2;
            iArr3[yo.a.x.PRIVATE_TO_THIS.ordinal()] = 3;
            iArr3[yo.a.x.PROTECTED.ordinal()] = 4;
            iArr3[yo.a.x.PUBLIC.ordinal()] = 5;
            iArr3[yo.a.x.LOCAL.ordinal()] = 6;
            f14688c = iArr3;
            int[] iArr4 = new int[yo.a.c.EnumC0567c.values().length];
            iArr4[yo.a.c.EnumC0567c.CLASS.ordinal()] = 1;
            iArr4[yo.a.c.EnumC0567c.INTERFACE.ordinal()] = 2;
            iArr4[yo.a.c.EnumC0567c.ENUM_CLASS.ordinal()] = 3;
            iArr4[yo.a.c.EnumC0567c.ENUM_ENTRY.ordinal()] = 4;
            iArr4[yo.a.c.EnumC0567c.ANNOTATION_CLASS.ordinal()] = 5;
            iArr4[yo.a.c.EnumC0567c.OBJECT.ordinal()] = 6;
            iArr4[yo.a.c.EnumC0567c.COMPANION_OBJECT.ordinal()] = 7;
            f14689d = iArr4;
            int[] iArr5 = new int[eo.f.values().length];
            iArr5[eo.f.CLASS.ordinal()] = 1;
            iArr5[eo.f.INTERFACE.ordinal()] = 2;
            iArr5[eo.f.ENUM_CLASS.ordinal()] = 3;
            iArr5[eo.f.ENUM_ENTRY.ordinal()] = 4;
            iArr5[eo.f.ANNOTATION_CLASS.ordinal()] = 5;
            iArr5[eo.f.OBJECT.ordinal()] = 6;
            f14690e = iArr5;
            int[] iArr6 = new int[yo.a.s.c.values().length];
            iArr6[yo.a.s.c.IN.ordinal()] = 1;
            iArr6[yo.a.s.c.OUT.ordinal()] = 2;
            iArr6[yo.a.s.c.INV.ordinal()] = 3;
            f14691f = iArr6;
            int[] iArr7 = new int[yo.a.q.b.c.values().length];
            iArr7[yo.a.q.b.c.IN.ordinal()] = 1;
            iArr7[yo.a.q.b.c.OUT.ordinal()] = 2;
            iArr7[yo.a.q.b.c.INV.ordinal()] = 3;
            iArr7[yo.a.q.b.c.STAR.ordinal()] = 4;
            f14692g = iArr7;
            int[] iArr8 = new int[o1.values().length];
            iArr8[o1.IN_VARIANCE.ordinal()] = 1;
            iArr8[o1.OUT_VARIANCE.ordinal()] = 2;
            iArr8[o1.INVARIANT.ordinal()] = 3;
            f14693h = iArr8;
        }
    }

    @os.l
    public final eo.f a(@os.m yo.a.c.EnumC0567c enumC0567c) {
        switch (enumC0567c == null ? -1 : a.f14689d[enumC0567c.ordinal()]) {
            case 1:
                return eo.f.CLASS;
            case 2:
                return eo.f.INTERFACE;
            case 3:
                return eo.f.ENUM_CLASS;
            case 4:
                return eo.f.ENUM_ENTRY;
            case 5:
                return eo.f.ANNOTATION_CLASS;
            case 6:
            case 7:
                return eo.f.OBJECT;
            default:
                return eo.f.CLASS;
        }
    }

    @os.l
    public final eo.e0 b(@os.m yo.a.k kVar) {
        int i10 = kVar == null ? -1 : a.f14686a[kVar.ordinal()];
        if (i10 == 1) {
            return eo.e0.FINAL;
        }
        if (i10 == 2) {
            return eo.e0.OPEN;
        }
        if (i10 != 3) {
            return i10 != 4 ? eo.e0.FINAL : eo.e0.SEALED;
        }
        return eo.e0.ABSTRACT;
    }

    @os.l
    public final o1 c(@os.l yo.a.q.b.c cVar) {
        l0.p(cVar, "projection");
        int i10 = a.f14692g[cVar.ordinal()];
        if (i10 == 1) {
            return o1.IN_VARIANCE;
        }
        if (i10 == 2) {
            return o1.OUT_VARIANCE;
        }
        if (i10 == 3) {
            return o1.INVARIANT;
        }
        if (i10 != 4) {
            throw new i0();
        }
        throw new IllegalArgumentException(l0.C("Only IN, OUT and INV are supported. Actual argument: ", cVar));
    }

    @os.l
    public final o1 d(@os.l yo.a.s.c cVar) {
        l0.p(cVar, "variance");
        int i10 = a.f14691f[cVar.ordinal()];
        if (i10 == 1) {
            return o1.IN_VARIANCE;
        }
        if (i10 == 2) {
            return o1.OUT_VARIANCE;
        }
        if (i10 == 3) {
            return o1.INVARIANT;
        }
        throw new i0();
    }
}
