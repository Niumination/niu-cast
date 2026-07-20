package lm;

/* JADX INFO: loaded from: classes3.dex */
public class f0 {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10186a;

        static {
            int[] iArr = new int[h0.values().length];
            try {
                iArr[h0.SYNCHRONIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[h0.PUBLICATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[h0.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f10186a = iArr;
        }
    }

    @os.l
    public static final <T> d0<T> a(@os.m Object obj, @os.l jn.a<? extends T> aVar) {
        kn.l0.p(aVar, "initializer");
        return new m1(aVar, obj);
    }

    @os.l
    public static <T> d0<T> b(@os.l jn.a<? extends T> aVar) {
        kn.l0.p(aVar, "initializer");
        kn.w wVar = null;
        return new m1(aVar, wVar, 2, wVar);
    }

    @os.l
    public static <T> d0<T> c(@os.l h0 h0Var, @os.l jn.a<? extends T> aVar) {
        kn.l0.p(h0Var, "mode");
        kn.l0.p(aVar, "initializer");
        int i10 = a.f10186a[h0Var.ordinal()];
        int i11 = 2;
        if (i10 == 1) {
            kn.w wVar = null;
            return new m1(aVar, wVar, i11, wVar);
        }
        if (i10 == 2) {
            return new e1(aVar);
        }
        if (i10 == 3) {
            return new m2(aVar);
        }
        throw new i0();
    }
}
