package hk;

import ik.y0;
import nq.l0;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends Exception implements l0<a> {

    @l
    private final un.d<?> type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@l un.d<?> dVar) {
        super("Type " + wn.c.a(dVar) + " is excluded so couldn't be used in receive");
        kn.l0.p(dVar, y0.a.f8215h);
        this.type = dVar;
    }

    @Override // nq.l0
    @l
    public a createCopy() {
        a aVar = new a(this.type);
        aVar.initCause(this);
        return aVar;
    }
}
