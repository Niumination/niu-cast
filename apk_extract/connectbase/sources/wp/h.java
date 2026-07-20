package wp;

import eo.g0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kn.l0;
import nm.z;
import vp.f0;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final g0<p<x>> f19854a = new g0<>("KotlinTypeRefiner");

    @os.l
    public static final g0<p<x>> a() {
        return f19854a;
    }

    @os.l
    public static final List<f0> b(@os.l g gVar, @os.l Iterable<? extends f0> iterable) {
        l0.p(gVar, "<this>");
        l0.p(iterable, "types");
        ArrayList arrayList = new ArrayList(z.b0(iterable, 10));
        Iterator<? extends f0> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(gVar.a(it.next()));
        }
        return arrayList;
    }
}
