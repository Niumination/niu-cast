package ik;

import java.util.List;
import java.util.Map;
import java.util.Set;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
@lm.k(level = lm.m.ERROR, message = "Empty headers is internal", replaceWith = @lm.a1(expression = "Headers.Empty", imports = {}))
public final class s implements b0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final s f8187d = new s();

    @Override // fl.o1
    public boolean a() {
        return true;
    }

    @Override // fl.o1
    @os.m
    public List<String> b(@os.l String str) {
        kn.l0.p(str, "name");
        return null;
    }

    @Override // fl.o1
    public boolean contains(@os.l String str) {
        return b0.b.a(this, str);
    }

    @Override // fl.o1
    public boolean d(@os.l String str, @os.l String str2) {
        return b0.b.b(this, str, str2);
    }

    @Override // fl.o1
    public void e(@os.l jn.p<? super String, ? super List<String>, l2> pVar) {
        b0.b.c(this, pVar);
    }

    @Override // fl.o1
    @os.l
    public Set<Map.Entry<String, List<String>>> entries() {
        return nm.m0.INSTANCE;
    }

    @Override // fl.o1
    @os.m
    public String get(@os.l String str) {
        return b0.b.d(this, str);
    }

    @Override // fl.o1
    public boolean isEmpty() {
        return true;
    }

    @Override // fl.o1
    @os.l
    public Set<String> names() {
        return nm.m0.INSTANCE;
    }

    @os.l
    public String toString() {
        return kn.l0.C("Headers ", nm.m0.INSTANCE);
    }
}
