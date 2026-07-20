package xm;

import kn.e0;
import kn.l0;
import kn.l1;
import lm.f1;

/* JADX INFO: loaded from: classes3.dex */
@f1(version = "1.3")
public abstract class o extends d implements e0<Object>, n {
    private final int arity;

    public o(int i10, @os.m um.d<Object> dVar) {
        super(dVar);
        this.arity = i10;
    }

    @Override // kn.e0
    public int getArity() {
        return this.arity;
    }

    @Override // xm.a
    @os.l
    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        String strW = l1.w(this);
        l0.o(strW, "renderLambdaToString(...)");
        return strW;
    }

    public o(int i10) {
        this(i10, null);
    }
}
