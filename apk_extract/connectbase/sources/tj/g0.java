package tj;

import java.io.ObjectStreamException;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g0 extends d implements Serializable {
    private static final long serialVersionUID = 2;
    protected final String value;

    public static final class a extends g0 {
        public a(sj.o oVar, String str) {
            super(oVar, str);
        }

        private Object writeReplace() throws ObjectStreamException {
            return new z0(this);
        }

        @Override // tj.g0, sj.x
        public /* bridge */ /* synthetic */ Object unwrapped() {
            return super.unwrapped();
        }

        @Override // tj.d
        public a newCopy(sj.o oVar) {
            return new a(oVar, this.value);
        }
    }

    public static final class b extends g0 {
        public b(sj.o oVar, String str) {
            super(oVar, str);
        }

        private Object writeReplace() throws ObjectStreamException {
            return new z0(this);
        }

        @Override // tj.g0, sj.x
        public /* bridge */ /* synthetic */ Object unwrapped() {
            return super.unwrapped();
        }

        @Override // tj.d
        public b newCopy(sj.o oVar) {
            return new b(oVar, this.value);
        }
    }

    public g0(sj.o oVar, String str) {
        super(oVar);
        this.value = str;
    }

    @Override // tj.d
    public void render(StringBuilder sb2, int i10, boolean z10, sj.s sVar) {
        sb2.append(sVar.f15098d ? n.i(this.value) : n.j(this.value));
    }

    @Override // tj.d
    public String transformToString() {
        return this.value;
    }

    @Override // sj.x
    public sj.z valueType() {
        return sj.z.STRING;
    }

    public boolean wasQuoted() {
        return this instanceof a;
    }

    @Override // sj.x
    public String unwrapped() {
        return this.value;
    }
}
