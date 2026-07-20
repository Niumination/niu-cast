package nq;

/* JADX INFO: loaded from: classes3.dex */
public abstract class x2 extends n0 {
    @os.l
    public abstract x2 f0();

    @os.m
    @g2
    public final String j0() {
        x2 x2VarF0;
        x2 x2VarE = k1.e();
        if (this == x2VarE) {
            return "Dispatchers.Main";
        }
        try {
            x2VarF0 = x2VarE.f0();
        } catch (UnsupportedOperationException unused) {
            x2VarF0 = null;
        }
        if (this == x2VarF0) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }

    @Override // nq.n0
    @os.l
    public n0 limitedParallelism(int i10) {
        vq.v.a(i10);
        return this;
    }

    @Override // nq.n0
    @os.l
    public String toString() {
        String strJ0 = j0();
        if (strJ0 != null) {
            return strJ0;
        }
        return x0.a(this) + '@' + x0.b(this);
    }
}
