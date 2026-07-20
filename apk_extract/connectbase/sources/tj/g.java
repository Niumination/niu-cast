package tj;

import java.io.ObjectStreamException;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends d implements Serializable {
    private static final long serialVersionUID = 2;
    private final boolean value;

    public g(sj.o oVar, boolean z10) {
        super(oVar);
        this.value = z10;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new z0(this);
    }

    @Override // tj.d
    public String transformToString() {
        return this.value ? "true" : "false";
    }

    @Override // sj.x
    public sj.z valueType() {
        return sj.z.BOOLEAN;
    }

    @Override // tj.d
    public g newCopy(sj.o oVar) {
        return new g(oVar, this.value);
    }

    @Override // sj.x
    public Boolean unwrapped() {
        return Boolean.valueOf(this.value);
    }
}
