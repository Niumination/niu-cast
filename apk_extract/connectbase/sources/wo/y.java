package wo;

import java.util.Collection;
import kn.l0;
import nm.h0;
import vp.f0;

/* JADX INFO: loaded from: classes3.dex */
public final class y implements x<k> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final y f19827a = new y();

    @Override // wo.x
    @os.m
    public String a(@os.l eo.e eVar) {
        return x.a.a(this, eVar);
    }

    @Override // wo.x
    public void b(@os.l f0 f0Var, @os.l eo.e eVar) {
        l0.p(f0Var, "kotlinType");
        l0.p(eVar, "descriptor");
    }

    @Override // wo.x
    @os.m
    public String c(@os.l eo.e eVar) {
        l0.p(eVar, "classDescriptor");
        return null;
    }

    @Override // wo.x
    @os.m
    public f0 e(@os.l f0 f0Var) {
        return x.a.b(this, f0Var);
    }

    @Override // wo.x
    @os.l
    public f0 f(@os.l Collection<? extends f0> collection) {
        l0.p(collection, "types");
        throw new AssertionError(l0.C("There should be no intersection type in existing descriptors, but found: ", h0.m3(collection, null, null, null, 0, null, null, 63, null)));
    }

    @Override // wo.x
    @os.m
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public k d(@os.l eo.e eVar) {
        l0.p(eVar, "classDescriptor");
        return null;
    }
}
