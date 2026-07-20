package p0;

import android.graphics.Path;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class r implements n, q0.a.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12675b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f12676c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n0.j f12677d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final q0.a<?, Path> f12678e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f12679f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f12674a = new Path();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f12680g = new b();

    public r(n0.j jVar, v0.a aVar, u0.o oVar) {
        this.f12675b = oVar.b();
        this.f12676c = oVar.d();
        this.f12677d = jVar;
        q0.a<u0.l, Path> aVarL = oVar.c().l();
        this.f12678e = aVarL;
        aVar.i(aVarL);
        aVarL.a(this);
    }

    private void d() {
        this.f12679f = false;
        this.f12677d.invalidateSelf();
    }

    @Override // q0.a.b
    public void a() {
        d();
    }

    @Override // p0.c
    public void b(List<c> list, List<c> list2) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            c cVar = list.get(i10);
            if (cVar instanceof t) {
                t tVar = (t) cVar;
                if (tVar.i() == u0.q.a.SIMULTANEOUSLY) {
                    this.f12680g.a(tVar);
                    tVar.d(this);
                }
            }
        }
    }

    @Override // p0.c
    public String getName() {
        return this.f12675b;
    }

    @Override // p0.n
    public Path getPath() {
        if (this.f12679f) {
            return this.f12674a;
        }
        this.f12674a.reset();
        if (this.f12676c) {
            this.f12679f = true;
            return this.f12674a;
        }
        this.f12674a.set(this.f12678e.h());
        this.f12674a.setFillType(Path.FillType.EVEN_ODD);
        this.f12680g.b(this.f12674a);
        this.f12679f = true;
        return this.f12674a;
    }
}
