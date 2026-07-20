package k3;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class dc {
    public Object a(Class cls) {
        u4.a aVarB = b(cls);
        if (aVarB == null) {
            return null;
        }
        return aVarB.get();
    }

    public abstract u4.a b(Class cls);

    public Set c(Class cls) {
        return (Set) d(cls).get();
    }

    public abstract u4.a d(Class cls);
}
