package el;

import ik.y0;
import java.util.ArrayList;
import java.util.List;
import kn.l0;
import lm.z0;

/* JADX INFO: loaded from: classes2.dex */
public class f<S> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final un.d<S> f4519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final un.s f4520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public m<S> f4521c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final List<z> f4522d;

    @z0
    public f(@os.l un.d<S> dVar, @os.l un.s sVar) {
        l0.p(dVar, y0.a.f8215h);
        l0.p(sVar, "typeInfo");
        this.f4519a = dVar;
        this.f4520b = sVar;
        this.f4521c = o.f(sVar);
        this.f4522d = new ArrayList();
    }

    @os.l
    public final m<S> a() {
        return this.f4521c;
    }

    @os.l
    public final List<z> b() {
        return this.f4522d;
    }

    @os.l
    public final un.d<S> c() {
        return this.f4519a;
    }

    @os.l
    public final un.s d() {
        return this.f4520b;
    }

    public final void e(@os.l m<S> mVar) {
        l0.p(mVar, "<set-?>");
        this.f4521c = mVar;
    }

    public final void f(@os.l z zVar) {
        l0.p(zVar, "transformer");
        this.f4522d.add(zVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @lm.k(message = "Use builder functions instead.")
    public f(@os.l un.d<S> dVar) {
        this(dVar, vn.g.d(dVar));
        l0.p(dVar, y0.a.f8215h);
    }
}
