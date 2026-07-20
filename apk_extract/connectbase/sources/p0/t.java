package p0;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class t implements c, q0.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f12686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f12687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<q0.a.b> f12688c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final u0.q.a f12689d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final q0.a<?, Float> f12690e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final q0.a<?, Float> f12691f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final q0.a<?, Float> f12692g;

    public t(v0.a aVar, u0.q qVar) {
        this.f12686a = qVar.c();
        this.f12687b = qVar.g();
        this.f12689d = qVar.f();
        q0.a<Float, Float> aVarL = qVar.e().l();
        this.f12690e = aVarL;
        q0.a<Float, Float> aVarL2 = qVar.b().l();
        this.f12691f = aVarL2;
        q0.a<Float, Float> aVarL3 = qVar.d().l();
        this.f12692g = aVarL3;
        aVar.i(aVarL);
        aVar.i(aVarL2);
        aVar.i(aVarL3);
        aVarL.a(this);
        aVarL2.a(this);
        aVarL3.a(this);
    }

    @Override // q0.a.b
    public void a() {
        for (int i10 = 0; i10 < this.f12688c.size(); i10++) {
            this.f12688c.get(i10).a();
        }
    }

    @Override // p0.c
    public void b(List<c> list, List<c> list2) {
    }

    public void d(q0.a.b bVar) {
        this.f12688c.add(bVar);
    }

    public q0.a<?, Float> e() {
        return this.f12691f;
    }

    public q0.a<?, Float> f() {
        return this.f12692g;
    }

    @Override // p0.c
    public String getName() {
        return this.f12686a;
    }

    public q0.a<?, Float> h() {
        return this.f12690e;
    }

    public u0.q.a i() {
        return this.f12689d;
    }

    public boolean j() {
        return this.f12687b;
    }
}
