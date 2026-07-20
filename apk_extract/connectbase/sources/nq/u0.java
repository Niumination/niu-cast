package nq;

/* JADX INFO: loaded from: classes3.dex */
public enum u0 {
    DEFAULT,
    LAZY,
    ATOMIC,
    UNDISPATCHED;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11948a;

        static {
            int[] iArr = new int[u0.values().length];
            try {
                iArr[u0.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[u0.ATOMIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[u0.UNDISPATCHED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[u0.LAZY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f11948a = iArr;
        }
    }

    @g2
    public static /* synthetic */ void isLazy$annotations() {
    }

    @g2
    public final <T> void invoke(@os.l jn.l<? super um.d<? super T>, ? extends Object> lVar, @os.l um.d<? super T> dVar) throws Throwable {
        int i10 = a.f11948a[ordinal()];
        if (i10 == 1) {
            wq.a.c(lVar, dVar);
            return;
        }
        if (i10 == 2) {
            um.f.h(lVar, dVar);
        } else if (i10 == 3) {
            wq.b.a(lVar, dVar);
        } else if (i10 != 4) {
            throw new lm.i0();
        }
    }

    public final boolean isLazy() {
        return this == LAZY;
    }

    @g2
    public final <R, T> void invoke(@os.l jn.p<? super R, ? super um.d<? super T>, ? extends Object> pVar, R r10, @os.l um.d<? super T> dVar) {
        int i10 = a.f11948a[ordinal()];
        if (i10 == 1) {
            wq.a.f(pVar, r10, dVar, null, 4, null);
            return;
        }
        if (i10 == 2) {
            um.f.i(pVar, r10, dVar);
        } else if (i10 == 3) {
            wq.b.b(pVar, r10, dVar);
        } else if (i10 != 4) {
            throw new lm.i0();
        }
    }
}
