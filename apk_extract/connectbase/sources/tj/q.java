package tj;

import java.io.ObjectStreamException;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class q extends d0 implements Serializable {
    private static final long serialVersionUID = 2;
    private final long value;

    public q(sj.o oVar, long j10, String str) {
        super(oVar, str);
        this.value = j10;
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
        return this.value;
    }

    @Override // tj.d0, tj.d
    public String transformToString() {
        String strTransformToString = super.transformToString();
        return strTransformToString == null ? Long.toString(this.value) : strTransformToString;
    }

    @Override // sj.x
    public sj.z valueType() {
        return sj.z.NUMBER;
    }

    @Override // tj.d
    public q newCopy(sj.o oVar) {
        return new q(oVar, this.value, this.originalText);
    }

    @Override // tj.d0, sj.x
    public Long unwrapped() {
        return Long.valueOf(this.value);
    }
}
