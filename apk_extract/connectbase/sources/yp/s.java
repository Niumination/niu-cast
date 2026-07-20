package yp;

import kn.l0;
import lm.i0;
import vp.o1;

/* JADX INFO: loaded from: classes3.dex */
public final class s {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21699a;

        static {
            int[] iArr = new int[o1.values().length];
            iArr[o1.INVARIANT.ordinal()] = 1;
            iArr[o1.IN_VARIANCE.ordinal()] = 2;
            iArr[o1.OUT_VARIANCE.ordinal()] = 3;
            f21699a = iArr;
        }
    }

    @os.l
    public static final w a(@os.l o1 o1Var) {
        l0.p(o1Var, "<this>");
        int i10 = a.f21699a[o1Var.ordinal()];
        if (i10 == 1) {
            return w.INV;
        }
        if (i10 == 2) {
            return w.IN;
        }
        if (i10 == 3) {
            return w.OUT;
        }
        throw new i0();
    }
}
