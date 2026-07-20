package tj;

import java.io.ObjectStreamException;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class l extends d0 implements Serializable {
    private static final long serialVersionUID = 2;
    private final double value;

    public l(sj.o oVar, double d10, String str) {
        super(oVar, str);
        this.value = d10;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new z0(this);
    }

    @Override // tj.d0
    public double doubleValue() {
        return this.value;
    }

    @Override // tj.d0
    public long longValue() {
        return (long) this.value;
    }

    @Override // tj.d0, tj.d
    public String transformToString() {
        String strTransformToString = super.transformToString();
        return strTransformToString == null ? Double.toString(this.value) : strTransformToString;
    }

    @Override // sj.x
    public sj.z valueType() {
        return sj.z.NUMBER;
    }

    @Override // tj.d
    public l newCopy(sj.o oVar) {
        return new l(oVar, this.value, this.originalText);
    }

    @Override // tj.d0, sj.x
    public Double unwrapped() {
        return Double.valueOf(this.value);
    }
}
