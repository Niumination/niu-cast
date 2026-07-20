package ok;

import java.util.List;
import java.util.Map;
import kn.l0;
import nm.h0;
import nm.k0;

/* JADX INFO: loaded from: classes2.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final Map<String, List<String>> f12296a;

    /* JADX WARN: Multi-variable type inference failed */
    public m(@os.l Map<String, ? extends List<String>> map) {
        l0.p(map, "mapping");
        this.f12296a = map;
    }

    public final boolean a(@os.l String str) {
        l0.p(str, cb.b.c.f1408o);
        return this.f12296a.containsKey(str);
    }

    @os.m
    public final String b(@os.l String str) {
        l0.p(str, cb.b.c.f1408o);
        List<String> list = this.f12296a.get(str);
        if (list == null) {
            return null;
        }
        return (String) h0.G2(list);
    }

    @os.l
    public final List<String> c(@os.l String str) {
        l0.p(str, cb.b.c.f1408o);
        List<String> list = this.f12296a.get(str);
        return list == null ? k0.INSTANCE : list;
    }
}
