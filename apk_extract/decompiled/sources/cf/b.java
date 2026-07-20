package cf;

import af.l2;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements ef.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ef.c f1483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f1484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1485c;

    public b(Object obj, ef.c cVar, int i8) {
        this.f1484b = i8;
        this.f1485c = obj;
        this.f1483a = cVar;
    }

    @Override // ef.c
    public final int J() {
        return this.f1483a.J();
    }

    @Override // ef.c
    public final void O(ArrayList arrayList, int i8, boolean z2) {
        this.f1483a.O(arrayList, i8, z2);
    }

    @Override // ef.c
    public void Q(boolean z2, int i8, ArrayList arrayList) {
        switch (this.f1484b) {
            case 1:
                l2 l2Var = ((h0) this.f1485c).f1545m;
                l2Var.f431d = l2Var.f430c;
                l2Var.f = 0;
                k(arrayList, i8, z2);
                break;
            default:
                k(arrayList, i8, z2);
                break;
        }
    }

    @Override // ef.c
    public void Z(ef.o oVar) {
        switch (this.f1484b) {
            case 0:
                ((c) this.f1485c).f1501n++;
                a(oVar);
                break;
            default:
                a(oVar);
                break;
        }
    }

    public final void a(ef.o oVar) {
        this.f1483a.Z(oVar);
    }

    public final void c(boolean z2, int i8, qj.f fVar, int i9) {
        this.f1483a.e0(z2, i8, fVar, i9);
    }

    @Override // ef.c
    public final void c0(int i8, ef.a aVar, byte[] bArr) {
        this.f1483a.c0(i8, aVar, bArr);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f1483a.close();
    }

    @Override // ef.c
    public final void d(int i8, long j8) {
        this.f1483a.d(i8, j8);
    }

    @Override // ef.c
    public final void e(ef.o oVar) {
        this.f1483a.e(oVar);
    }

    @Override // ef.c
    public void e0(boolean z2, int i8, qj.f fVar, int i9) {
        switch (this.f1484b) {
            case 1:
                l2 l2Var = ((h0) this.f1485c).f1545m;
                l2Var.f431d = l2Var.f430c;
                l2Var.f = 0;
                c(z2, i8, fVar, i9);
                break;
            default:
                c(z2, i8, fVar, i9);
                break;
        }
    }

    @Override // ef.c
    public void f(int i8, ef.a aVar) {
        switch (this.f1484b) {
            case 0:
                ((c) this.f1485c).f1501n++;
                i(i8, aVar);
                break;
            default:
                i(i8, aVar);
                break;
        }
    }

    @Override // ef.c
    public void f0(int i8, ArrayList arrayList) {
        switch (this.f1484b) {
            case 1:
                l2 l2Var = ((h0) this.f1485c).f1545m;
                l2Var.f431d = l2Var.f430c;
                l2Var.f = 0;
                g(i8, arrayList);
                break;
            default:
                g(i8, arrayList);
                break;
        }
    }

    @Override // ef.c
    public final void flush() {
        this.f1483a.flush();
    }

    public final void g(int i8, ArrayList arrayList) {
        this.f1483a.f0(i8, arrayList);
    }

    public final void h(boolean z2, int i8, int i9) {
        this.f1483a.j(z2, i8, i9);
    }

    public final void i(int i8, ef.a aVar) {
        this.f1483a.f(i8, aVar);
    }

    @Override // ef.c
    public void j(boolean z2, int i8, int i9) {
        switch (this.f1484b) {
            case 0:
                if (z2) {
                    ((c) this.f1485c).f1501n++;
                }
                h(z2, i8, i9);
                break;
            default:
                h(z2, i8, i9);
                break;
        }
    }

    public final void k(ArrayList arrayList, int i8, boolean z2) {
        this.f1483a.Q(z2, i8, arrayList);
    }

    @Override // ef.c
    public final void r() {
        this.f1483a.r();
    }
}
