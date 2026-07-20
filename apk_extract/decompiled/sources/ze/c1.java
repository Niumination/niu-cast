package ze;

import java.util.Map;
import k3.t8;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c1 {
    public abstract String a();

    public abstract int b();

    public abstract boolean c();

    public abstract b1 d(f0 f0Var);

    public abstract s1 e(Map map);

    public final boolean equals(Object obj) {
        return this == obj;
    }

    public final String toString() {
        o6.a aVarA = t8.a(this);
        aVarA.d(a(), "policy");
        aVarA.c(b(), "priority");
        aVarA.f("available", c());
        return aVarA.toString();
    }
}
