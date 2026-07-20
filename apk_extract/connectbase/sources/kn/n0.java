package kn;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public abstract class n0<R> implements e0<R>, Serializable {
    private final int arity;

    public n0(int i10) {
        this.arity = i10;
    }

    @Override // kn.e0
    public int getArity() {
        return this.arity;
    }

    @os.l
    public String toString() {
        String strX = l1.x(this);
        l0.o(strX, "renderLambdaToString(...)");
        return strX;
    }
}
