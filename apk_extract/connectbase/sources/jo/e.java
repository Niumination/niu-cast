package jo;

import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
    @os.m
    public static final Class<?> a(@os.l ClassLoader classLoader, @os.l String str) {
        l0.p(classLoader, "<this>");
        l0.p(str, "fqName");
        try {
            return Class.forName(str, false, classLoader);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
