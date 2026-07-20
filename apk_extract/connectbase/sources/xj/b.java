package xj;

import kn.l0;
import kn.w;
import os.l;
import xj.b;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b<S extends b<S>> extends ak.d<S> {
    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ b(vj.f fVar, vj.e eVar, int i10, w wVar) {
        if ((i10 & 2) != 0) {
            eVar = vj.e.f17085l;
            l0.o(eVar, "DEFAULT");
        }
        this(fVar, eVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@l vj.f fVar, @l vj.e eVar) {
        super(fVar, eVar);
        l0.p(fVar, "channel");
        l0.p(eVar, "callOptions");
    }
}
