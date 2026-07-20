package bo;

import eo.y;
import java.util.List;
import kn.l0;
import nm.k0;
import nm.x;
import os.l;
import up.n;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends op.e {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1002a;

        static {
            int[] iArr = new int[c.values().length];
            iArr[c.Function.ordinal()] = 1;
            iArr[c.SuspendFunction.ordinal()] = 2;
            f1002a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@l n nVar, @l b bVar) {
        super(nVar, bVar);
        l0.p(nVar, "storageManager");
        l0.p(bVar, "containingClass");
    }

    @Override // op.e
    @l
    public List<y> j() {
        int i10 = a.f1002a[((b) this.f12397b).f992n.ordinal()];
        if (i10 != 1) {
            return i10 != 2 ? k0.INSTANCE : x.k(e.V.a((b) this.f12397b, true));
        }
        return x.k(e.V.a((b) this.f12397b, false));
    }
}
