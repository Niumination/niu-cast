package tj;

import java.io.ObjectStreamException;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class c0 extends d implements Serializable {
    private static final long serialVersionUID = 2;

    public c0(sj.o oVar) {
        super(oVar);
    }

    private Object writeReplace() throws ObjectStreamException {
        return new z0(this);
    }

    @Override // tj.d
    public void render(StringBuilder sb2, int i10, boolean z10, sj.s sVar) {
        sb2.append(d6.a.E);
    }

    @Override // tj.d
    public String transformToString() {
        return d6.a.E;
    }

    @Override // sj.x
    public Object unwrapped() {
        return null;
    }

    @Override // sj.x
    public sj.z valueType() {
        return sj.z.NULL;
    }

    @Override // tj.d
    public c0 newCopy(sj.o oVar) {
        return new c0(oVar);
    }
}
