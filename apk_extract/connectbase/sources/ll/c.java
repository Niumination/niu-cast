package ll;

import fl.t0;
import kn.l0;
import lm.l2;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
@t0
public class c extends e {
    @Override // ll.e
    public final boolean G() {
        throw new UnsupportedOperationException();
    }

    @l
    public final Void N() {
        throw new UnsupportedOperationException();
    }

    public final <T extends e> void O(jn.l<? super T, l2> lVar) {
        l0.p(lVar, "block");
        for (e eVarX = (e) v(); !l0.g(eVarX, this); eVarX = eVarX.x()) {
            l0.P();
            if (eVarX != null) {
                lVar.invoke(eVarX);
            }
        }
    }

    public final boolean P() {
        return v() == this;
    }

    public final void Q() {
        e eVar = (e) v();
        e eVar2 = this;
        while (!l0.g(eVar, this)) {
            e eVarX = eVar.x();
            eVar.M(eVar2, eVarX);
            eVar2 = eVar;
            eVar = eVarX;
        }
        M(eVar2, (e) v());
    }

    @Override // ll.e
    public a p() {
        throw new UnsupportedOperationException();
    }
}
