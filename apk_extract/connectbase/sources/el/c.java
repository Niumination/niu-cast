package el;

import ik.y0;
import java.util.ArrayList;
import java.util.List;
import kn.l0;
import lm.z0;

/* JADX INFO: loaded from: classes2.dex */
public class c<S> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final un.d<S> f4503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final un.s f4504b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public m<S> f4505c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final List<z> f4506d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final a f4507e;

    @z0
    public c(@os.l un.d<S> dVar, @os.l un.s sVar) {
        l0.p(dVar, y0.a.f8215h);
        l0.p(sVar, "typeInfo");
        this.f4503a = dVar;
        this.f4504b = sVar;
        this.f4505c = o.f(sVar);
        this.f4506d = new ArrayList();
        this.f4507e = new a();
    }

    @os.l
    public final a a() {
        return this.f4507e;
    }

    @os.l
    public final m<S> b() {
        return this.f4505c;
    }

    @os.l
    public final List<z> c() {
        return this.f4506d;
    }

    @os.l
    public final un.d<S> d() {
        return this.f4503a;
    }

    @os.l
    public final un.s e() {
        return this.f4504b;
    }

    public final void f(@os.l m<S> mVar) {
        l0.p(mVar, "<set-?>");
        this.f4505c = mVar;
    }

    public final void g(@os.l z zVar) {
        l0.p(zVar, "transformer");
        this.f4506d.add(zVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @lm.k(message = "Use builder functions instead.")
    public c(@os.l un.d<S> dVar) {
        this(dVar, vn.g.d(dVar));
        l0.p(dVar, y0.a.f8215h);
    }
}
