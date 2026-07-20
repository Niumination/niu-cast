package ap;

import fp.j;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes3.dex */
public class b {
    public static final C0019b A;
    public static final C0019b B;
    public static final C0019b C;
    public static final C0019b D;
    public static final C0019b E;
    public static final C0019b F;
    public static final C0019b G;
    public static final C0019b H;
    public static final C0019b I;
    public static final C0019b J;
    public static final C0019b K;
    public static final C0019b L;
    public static final C0019b M;
    public static final C0019b N;
    public static final C0019b O;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0019b f639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0019b f640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0019b f641c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d<yo.a.x> f642d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d<yo.a.k> f643e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d<yo.a.c.EnumC0567c> f644f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final C0019b f645g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final C0019b f646h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final C0019b f647i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final C0019b f648j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final C0019b f649k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final C0019b f650l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final C0019b f651m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final C0019b f652n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final d<yo.a.j> f653o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final C0019b f654p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final C0019b f655q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final C0019b f656r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final C0019b f657s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final C0019b f658t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final C0019b f659u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final C0019b f660v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final C0019b f661w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final C0019b f662x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final C0019b f663y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final C0019b f664z;

    /* JADX INFO: renamed from: ap.b$b, reason: collision with other inner class name */
    public static class C0019b extends d<Boolean> {
        public C0019b(int i10) {
            super(i10, 1);
        }

        public static /* synthetic */ void f(int i10) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$BooleanFlagField", "get"));
        }

        @Override // ap.b.d
        @l
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public Boolean d(int i10) {
            return Boolean.valueOf(((1 << this.f666a) & i10) != 0);
        }

        @Override // ap.b.d
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public int e(Boolean bool) {
            if (bool.booleanValue()) {
                return 1 << this.f666a;
            }
            return 0;
        }
    }

    public static class c<E extends j.a> extends d<E> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final E[] f665c;

        public c(int i10, E[] eArr) {
            super(i10, g(eArr));
            this.f665c = eArr;
        }

        private static /* synthetic */ void f(int i10) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "enumEntries", "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$EnumLiteFlagField", "bitWidth"));
        }

        public static <E> int g(@l E[] eArr) {
            if (eArr == null) {
                f(0);
            }
            int length = eArr.length - 1;
            if (length == 0) {
                return 1;
            }
            for (int i10 = 31; i10 >= 0; i10--) {
                if (((1 << i10) & length) != 0) {
                    return i10 + 1;
                }
            }
            throw new IllegalStateException("Empty enum: " + eArr.getClass());
        }

        @Override // ap.b.d
        @m
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public E d(int i10) {
            int i11 = (1 << this.f667b) - 1;
            int i12 = this.f666a;
            int i13 = (i10 & (i11 << i12)) >> i12;
            for (E e10 : this.f665c) {
                if (e10.getNumber() == i13) {
                    return e10;
                }
            }
            return null;
        }

        @Override // ap.b.d
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public int e(E e10) {
            return e10.getNumber() << this.f666a;
        }
    }

    public static abstract class d<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f666a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f667b;

        /* JADX WARN: Incorrect types in method signature: <E::Lfp/j$a;>(Lap/b$d<*>;[TE;)Lap/b$d<TE;>; */
        public static d a(d dVar, j.a[] aVarArr) {
            return new c(dVar.f666a + dVar.f667b, aVarArr);
        }

        public static C0019b b(d<?> dVar) {
            return new C0019b(dVar.f666a + dVar.f667b, 1);
        }

        public static C0019b c() {
            return new C0019b(0, 1);
        }

        public abstract E d(int i10);

        public abstract int e(E e10);

        public d(int i10, int i11) {
            this.f666a = i10;
            this.f667b = i11;
        }
    }

    static {
        C0019b c0019bC = d.c();
        f639a = c0019bC;
        f640b = d.b(c0019bC);
        C0019b c0019bC2 = d.c();
        f641c = c0019bC2;
        d<yo.a.x> dVarA = d.a(c0019bC2, yo.a.x.values());
        f642d = dVarA;
        d<yo.a.k> dVarA2 = d.a(dVarA, yo.a.k.values());
        f643e = dVarA2;
        d<yo.a.c.EnumC0567c> dVarA3 = d.a(dVarA2, yo.a.c.EnumC0567c.values());
        f644f = dVarA3;
        C0019b c0019bB = d.b(dVarA3);
        f645g = c0019bB;
        C0019b c0019bB2 = d.b(c0019bB);
        f646h = c0019bB2;
        C0019b c0019bB3 = d.b(c0019bB2);
        f647i = c0019bB3;
        C0019b c0019bB4 = d.b(c0019bB3);
        f648j = c0019bB4;
        C0019b c0019bB5 = d.b(c0019bB4);
        f649k = c0019bB5;
        f650l = d.b(c0019bB5);
        C0019b c0019bB6 = d.b(dVarA);
        f651m = c0019bB6;
        f652n = d.b(c0019bB6);
        d<yo.a.j> dVarA4 = d.a(dVarA2, yo.a.j.values());
        f653o = dVarA4;
        C0019b c0019bB7 = d.b(dVarA4);
        f654p = c0019bB7;
        C0019b c0019bB8 = d.b(c0019bB7);
        f655q = c0019bB8;
        C0019b c0019bB9 = d.b(c0019bB8);
        f656r = c0019bB9;
        C0019b c0019bB10 = d.b(c0019bB9);
        f657s = c0019bB10;
        C0019b c0019bB11 = d.b(c0019bB10);
        f658t = c0019bB11;
        C0019b c0019bB12 = d.b(c0019bB11);
        f659u = c0019bB12;
        C0019b c0019bB13 = d.b(c0019bB12);
        f660v = c0019bB13;
        f661w = d.b(c0019bB13);
        C0019b c0019bB14 = d.b(dVarA4);
        f662x = c0019bB14;
        C0019b c0019bB15 = d.b(c0019bB14);
        f663y = c0019bB15;
        C0019b c0019bB16 = d.b(c0019bB15);
        f664z = c0019bB16;
        C0019b c0019bB17 = d.b(c0019bB16);
        A = c0019bB17;
        C0019b c0019bB18 = d.b(c0019bB17);
        B = c0019bB18;
        C0019b c0019bB19 = d.b(c0019bB18);
        C = c0019bB19;
        C0019b c0019bB20 = d.b(c0019bB19);
        D = c0019bB20;
        C0019b c0019bB21 = d.b(c0019bB20);
        E = c0019bB21;
        F = d.b(c0019bB21);
        C0019b c0019bB22 = d.b(c0019bC2);
        G = c0019bB22;
        C0019b c0019bB23 = d.b(c0019bB22);
        H = c0019bB23;
        I = d.b(c0019bB23);
        C0019b c0019bB24 = d.b(dVarA2);
        J = c0019bB24;
        C0019b c0019bB25 = d.b(c0019bB24);
        K = c0019bB25;
        L = d.b(c0019bB25);
        C0019b c0019bC3 = d.c();
        M = c0019bC3;
        N = d.b(c0019bC3);
        O = d.c();
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0021  */
    /* JADX WARN: Code duplicated, block: B:18:0x002b  */
    public static /* synthetic */ void a(int i10) {
        Object[] objArr = new Object[3];
        if (i10 == 1) {
            objArr[0] = "modality";
        } else if (i10 == 2) {
            objArr[0] = "kind";
        } else if (i10 == 5) {
            objArr[0] = "modality";
        } else if (i10 == 6) {
            objArr[0] = "memberKind";
        } else if (i10 == 8) {
            objArr[0] = "modality";
        } else if (i10 == 9) {
            objArr[0] = "memberKind";
        } else if (i10 != 11) {
            objArr[0] = "visibility";
        } else {
            objArr[0] = "modality";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags";
        switch (i10) {
            case 3:
                objArr[2] = "getConstructorFlags";
                break;
            case 4:
            case 5:
            case 6:
                objArr[2] = "getFunctionFlags";
                break;
            case 7:
            case 8:
            case 9:
                objArr[2] = "getPropertyFlags";
                break;
            case 10:
            case 11:
                objArr[2] = "getAccessorFlags";
                break;
            default:
                objArr[2] = "getClassFlags";
                break;
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public static int b(boolean z10, @l yo.a.x xVar, @l yo.a.k kVar, boolean z11, boolean z12, boolean z13) {
        if (xVar == null) {
            a(10);
        }
        if (kVar == null) {
            a(11);
        }
        return f641c.e(Boolean.valueOf(z10)) | f643e.e(kVar) | f642d.e(xVar) | J.e(Boolean.valueOf(z11)) | K.e(Boolean.valueOf(z12)) | L.e(Boolean.valueOf(z13));
    }
}
