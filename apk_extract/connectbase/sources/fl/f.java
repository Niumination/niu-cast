package fl;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class f {
    public static final void a(@os.l c cVar, @os.l c cVar2) {
        kn.l0.p(cVar, "<this>");
        kn.l0.p(cVar2, "other");
        Iterator<T> it = cVar2.f().iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            cVar.g(bVar, cVar2.h(bVar));
        }
    }
}
