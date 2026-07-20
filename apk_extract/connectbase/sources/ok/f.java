package ok;

import java.util.ArrayList;
import java.util.List;
import kn.l0;
import nm.h0;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final List<e> f12290a = new ArrayList();

    @os.l
    public final e a() {
        return this.f12290a.size() == 1 ? (e) h0.B2(this.f12290a) : new s(this.f12290a);
    }

    @os.l
    public final f b(@os.l String str) {
        l0.p(str, "value");
        this.f12290a.add(new u(str));
        return this;
    }

    @os.l
    public final f c(@os.l e eVar) {
        l0.p(eVar, "grammar");
        this.f12290a.add(eVar);
        return this;
    }

    public final void d(@os.l String str) {
        l0.p(str, "<this>");
        this.f12290a.add(new u(str));
    }

    public final void e(@os.l jn.a<? extends e> aVar) {
        l0.p(aVar, "<this>");
        this.f12290a.add(aVar.invoke());
    }

    public final void f(@os.l e eVar) {
        l0.p(eVar, "<this>");
        this.f12290a.add(eVar);
    }
}
