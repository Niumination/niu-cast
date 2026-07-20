package nk;

import java.util.List;
import kn.l0;
import nm.k0;

/* JADX INFO: loaded from: classes2.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final fl.b<List<a0>> f11513a = new fl.b<>("VersionList");

    @os.l
    public static final i a(@os.l String str) {
        l0.p(str, "spec");
        return i.f11522d.c(str);
    }

    @os.l
    public static final fl.b<List<a0>> b() {
        return f11513a;
    }

    @os.l
    public static final List<a0> c(@os.l s sVar) {
        l0.p(sVar, "<this>");
        List<a0> list = (List) sVar.f(f11513a);
        return list == null ? k0.INSTANCE : list;
    }

    public static final void d(@os.l s sVar, @os.l List<? extends a0> list) {
        l0.p(sVar, "<this>");
        l0.p(list, "value");
        sVar.i(f11513a, list);
    }
}
