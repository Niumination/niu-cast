package tj;

import java.io.ObjectStreamException;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d0 extends d implements Serializable {
    private static final long serialVersionUID = 2;
    protected final String originalText;

    public d0(sj.o oVar, String str) {
        super(oVar);
        this.originalText = str;
    }

    public static d0 newNumber(sj.o oVar, long j10, String str) {
        return (j10 > 2147483647L || j10 < -2147483648L) ? new q(oVar, j10, str) : new p(oVar, (int) j10, str);
    }

    private Object writeReplace() throws ObjectStreamException {
        return new z0(this);
    }

    @Override // tj.d
    public boolean canEqual(Object obj) {
        return obj instanceof d0;
    }

    public abstract double doubleValue();

    @Override // tj.d
    public boolean equals(Object obj) {
        if (!(obj instanceof d0) || !canEqual(obj)) {
            return false;
        }
        d0 d0Var = (d0) obj;
        if (f()) {
            return d0Var.f() && longValue() == d0Var.longValue();
        }
        return !d0Var.f() && doubleValue() == d0Var.doubleValue();
    }

    public final boolean f() {
        return ((double) longValue()) == doubleValue();
    }

    @Override // tj.d
    public int hashCode() {
        long jLongValue = f() ? longValue() : Double.doubleToLongBits(doubleValue());
        return (int) (jLongValue ^ (jLongValue >>> 32));
    }

    public int intValueRangeChecked(String str) {
        long jLongValue = longValue();
        if (jLongValue < -2147483648L || jLongValue > 2147483647L) {
            throw new sj.c.n(origin(), str, "32-bit integer", h0.b.a("out-of-range value ", jLongValue));
        }
        return (int) jLongValue;
    }

    public abstract long longValue();

    @Override // tj.d
    public String transformToString() {
        return this.originalText;
    }

    @Override // sj.x
    public abstract Number unwrapped();

    public static d0 newNumber(sj.o oVar, double d10, String str) {
        long j10 = (long) d10;
        if (j10 == d10) {
            return newNumber(oVar, j10, str);
        }
        return new l(oVar, d10, str);
    }
}
