package pp;

import ik.y0;
import os.l;
import os.m;
import vp.f0;

/* JADX INFO: loaded from: classes3.dex */
public class h extends a {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h(@l f0 f0Var) {
        this(f0Var, null);
        if (f0Var == null) {
            b(0);
        }
    }

    private static /* synthetic */ void b(int i10) {
        Object[] objArr = new Object[3];
        if (i10 != 2) {
            objArr[0] = y0.a.f8215h;
        } else {
            objArr[0] = "newType";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/TransientReceiver";
        if (i10 != 2) {
            objArr[2] = "<init>";
        } else {
            objArr[2] = "replaceType";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public String toString() {
        return "{Transient} : " + getType();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@l f0 f0Var, @m e eVar) {
        super(f0Var, eVar);
        if (f0Var == null) {
            b(1);
        }
    }
}
