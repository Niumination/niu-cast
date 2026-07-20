package jo;

import java.util.List;
import kn.l0;
import rp.q;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final j f8764b = new j();

    @Override // rp.q
    public void a(@os.l eo.e eVar, @os.l List<String> list) {
        l0.p(eVar, "descriptor");
        l0.p(list, "unresolvedSuperClasses");
        throw new IllegalStateException("Incomplete hierarchy for class " + eVar.getName() + ", unresolved classes " + list);
    }

    @Override // rp.q
    public void b(@os.l eo.b bVar) {
        l0.p(bVar, "descriptor");
        throw new IllegalStateException(l0.C("Cannot infer visibility for ", bVar));
    }
}
