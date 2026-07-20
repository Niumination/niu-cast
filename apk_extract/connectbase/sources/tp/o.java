package tp;

import java.util.List;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class o extends b {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(@os.l up.n nVar, @os.l jn.a<? extends List<? extends fo.c>> aVar) {
        super(nVar, aVar);
        l0.p(nVar, "storageManager");
        l0.p(aVar, "compute");
    }

    @Override // tp.b, fo.g
    public boolean isEmpty() {
        return false;
    }
}
