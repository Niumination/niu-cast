package l1;

import android.graphics.ColorFilter;
import android.graphics.Path;
import j1.b0;
import j1.x;
import java.util.ArrayList;
import java.util.List;
import r1.y;

/* JADX INFO: loaded from: classes.dex */
public final class u implements o, m1.a, l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f7189c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final x f7190d;
    public final m1.n e;
    public boolean f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f7187a = new Path();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f7191g = new c(0);

    public u(x xVar, s1.c cVar, r1.t tVar) {
        this.f7188b = tVar.f9298a;
        this.f7189c = tVar.f9301d;
        this.f7190d = xVar;
        m1.n nVar = new m1.n((List) tVar.f9300c.f574b);
        this.e = nVar;
        cVar.f(nVar);
        nVar.a(this);
    }

    @Override // m1.a
    public final void a() {
        this.f = false;
        this.f7190d.invalidateSelf();
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0029  */
    /* JADX WARN: Code duplicated, block: B:12:0x002d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:13:0x002f  */
    /* JADX WARN: Code duplicated, block: B:21:0x0039 A[SYNTHETIC] */
    @Override // l1.d
    public final void b(List list, List list2) {
        ArrayList arrayList = null;
        int i8 = 0;
        while (true) {
            ArrayList arrayList2 = (ArrayList) list;
            if (i8 >= arrayList2.size()) {
                this.e.f7604m = arrayList;
                return;
            }
            d dVar = (d) arrayList2.get(i8);
            if (dVar instanceof w) {
                w wVar = (w) dVar;
                if (wVar.f7198c == y.SIMULTANEOUSLY) {
                    this.f7191g.f7096a.add(wVar);
                    wVar.c(this);
                } else if (!(dVar instanceof t)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add((t) dVar);
                }
            } else if (!(dVar instanceof t)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add((t) dVar);
            }
            i8++;
        }
    }

    @Override // p1.g
    public final void c(p1.f fVar, int i8, ArrayList arrayList, p1.f fVar2) {
        w1.f.f(fVar, i8, arrayList, fVar2, this);
    }

    @Override // p1.g
    public final void e(ColorFilter colorFilter, x1.c cVar) {
        if (colorFilter == b0.K) {
            this.e.k(cVar);
        }
    }

    @Override // l1.d
    public final String getName() {
        return this.f7188b;
    }

    @Override // l1.o
    public final Path getPath() {
        boolean z2 = this.f;
        Path path = this.f7187a;
        m1.n nVar = this.e;
        if (z2 && nVar.e == null) {
            return path;
        }
        path.reset();
        if (this.f7189c) {
            this.f = true;
            return path;
        }
        Path path2 = (Path) nVar.f();
        if (path2 == null) {
            return path;
        }
        path.set(path2);
        path.setFillType(Path.FillType.EVEN_ODD);
        this.f7191g.a(path);
        this.f = true;
        return path;
    }
}
