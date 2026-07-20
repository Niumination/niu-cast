package i4;

import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class s0 implements Serializable {
    private static final long serialVersionUID = 0;
    private final Object keys;
    private final Object values;

    public s0(t0 t0Var) {
        Object[] objArr = new Object[t0Var.size()];
        Object[] objArr2 = new Object[t0Var.size()];
        h5 it = t0Var.entrySet().iterator();
        int i8 = 0;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            objArr[i8] = entry.getKey();
            objArr2[i8] = entry.getValue();
            i8++;
        }
        this.keys = objArr;
        this.values = objArr2;
    }

    public final Object legacyReadResolve() {
        Object[] objArr = (Object[]) this.keys;
        Object[] objArr2 = (Object[]) this.values;
        m0 m0VarMakeBuilder = makeBuilder(objArr.length);
        for (int i8 = 0; i8 < objArr.length; i8++) {
            m0VarMakeBuilder.b(objArr[i8], objArr2[i8]);
        }
        return m0VarMakeBuilder.a();
    }

    public m0 makeBuilder(int i8) {
        return new m0(i8);
    }

    public final Object readResolve() {
        Object obj = this.keys;
        if (!(obj instanceof s1)) {
            return legacyReadResolve();
        }
        s1 s1Var = (s1) obj;
        a0 a0Var = (a0) this.values;
        m0 m0VarMakeBuilder = makeBuilder(s1Var.size());
        h5 it = s1Var.iterator();
        h5 it2 = a0Var.iterator();
        while (it.hasNext()) {
            m0VarMakeBuilder.b(it.next(), it2.next());
        }
        return m0VarMakeBuilder.a();
    }
}
