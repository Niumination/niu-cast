package pp;

import kn.l0;
import os.l;
import os.m;
import vp.n0;

/* JADX INFO: loaded from: classes3.dex */
public class c implements d, g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final eo.e f13233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final c f13234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public final eo.e f13235c;

    public c(@l eo.e eVar, @m c cVar) {
        l0.p(eVar, "classDescriptor");
        this.f13233a = eVar;
        this.f13234b = cVar == null ? this : cVar;
        this.f13235c = eVar;
    }

    @Override // pp.e
    @l
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public n0 getType() {
        n0 n0VarQ = this.f13233a.q();
        l0.o(n0VarQ, "classDescriptor.defaultType");
        return n0VarQ;
    }

    public boolean equals(@m Object obj) {
        eo.e eVar = this.f13233a;
        c cVar = obj instanceof c ? (c) obj : null;
        return l0.g(eVar, cVar != null ? cVar.f13233a : null);
    }

    public int hashCode() {
        return this.f13233a.hashCode();
    }

    @l
    public String toString() {
        return "Class{" + getType() + rs.f.f14860b;
    }

    @Override // pp.g
    @l
    public final eo.e v() {
        return this.f13233a;
    }
}
