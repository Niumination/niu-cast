package jp;

import eo.h0;
import kn.l0;
import vp.n0;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends o<Byte> {
    public d(byte b10) {
        super(Byte.valueOf(b10));
    }

    @Override // jp.g
    @os.l
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n0 a(@os.l h0 h0Var) {
        l0.p(h0Var, "module");
        n0 n0VarT = h0Var.n().t();
        l0.o(n0VarT, "module.builtIns.byteType");
        return n0VarT;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // jp.g
    @os.l
    public String toString() {
        return ((Number) this.f8774a).intValue() + ".toByte()";
    }
}
