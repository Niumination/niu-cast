package cf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements ef.c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Logger f1517d = Logger.getLogger(q.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f1518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f1519b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ka.d f1520c = new ka.d(Level.FINE, q.class);

    public e(d dVar, b bVar) {
        this.f1518a = dVar;
        this.f1519b = bVar;
    }

    @Override // ef.c
    public final int J() {
        return this.f1519b.f1483a.J();
    }

    @Override // ef.c
    public final void O(ArrayList arrayList, int i8, boolean z2) {
        try {
            this.f1519b.O(arrayList, i8, z2);
        } catch (IOException e) {
            this.f1518a.b(e);
        }
    }

    @Override // ef.c
    public final void Q(boolean z2, int i8, ArrayList arrayList) {
        try {
            this.f1519b.Q(z2, i8, arrayList);
        } catch (IOException e) {
            this.f1518a.b(e);
        }
    }

    @Override // ef.c
    public final void Z(ef.o oVar) {
        r rVar = r.OUTBOUND;
        ka.d dVar = this.f1520c;
        if (dVar.f()) {
            ((Logger) dVar.f6816a).log((Level) dVar.f6817b, rVar + " SETTINGS: ack=true");
        }
        try {
            this.f1519b.Z(oVar);
        } catch (IOException e) {
            this.f1518a.b(e);
        }
    }

    @Override // ef.c
    public final void c0(int i8, ef.a aVar, byte[] bArr) {
        b bVar = this.f1519b;
        this.f1520c.h(r.OUTBOUND, i8, aVar, qj.j.of(bArr));
        try {
            bVar.c0(i8, aVar, bArr);
            bVar.flush();
        } catch (IOException e) {
            this.f1518a.b(e);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        try {
            this.f1519b.close();
        } catch (IOException e) {
            f1517d.log(e.getClass().equals(IOException.class) ? Level.FINE : Level.INFO, "Failed closing connection", (Throwable) e);
        }
    }

    @Override // ef.c
    public final void d(int i8, long j8) {
        this.f1520c.o(r.OUTBOUND, i8, j8);
        try {
            this.f1519b.d(i8, j8);
        } catch (IOException e) {
            this.f1518a.b(e);
        }
    }

    @Override // ef.c
    public final void e(ef.o oVar) {
        this.f1520c.n(r.OUTBOUND, oVar);
        try {
            this.f1519b.e(oVar);
        } catch (IOException e) {
            this.f1518a.b(e);
        }
    }

    @Override // ef.c
    public final void e0(boolean z2, int i8, qj.f fVar, int i9) {
        r rVar = r.OUTBOUND;
        fVar.getClass();
        this.f1520c.g(rVar, i8, fVar, i9, z2);
        try {
            this.f1519b.e0(z2, i8, fVar, i9);
        } catch (IOException e) {
            this.f1518a.b(e);
        }
    }

    @Override // ef.c
    public final void f(int i8, ef.a aVar) {
        this.f1520c.m(r.OUTBOUND, i8, aVar);
        try {
            this.f1519b.f(i8, aVar);
        } catch (IOException e) {
            this.f1518a.b(e);
        }
    }

    @Override // ef.c
    public final void f0(int i8, ArrayList arrayList) {
        this.f1520c.i(r.OUTBOUND, i8, arrayList, false);
        try {
            this.f1519b.f0(i8, arrayList);
        } catch (IOException e) {
            this.f1518a.b(e);
        }
    }

    @Override // ef.c
    public final void flush() {
        try {
            this.f1519b.flush();
        } catch (IOException e) {
            this.f1518a.b(e);
        }
    }

    @Override // ef.c
    public final void j(boolean z2, int i8, int i9) {
        ka.d dVar = this.f1520c;
        if (z2) {
            dVar.k(r.OUTBOUND, (4294967295L & ((long) i9)) | (((long) i8) << 32));
        } else {
            dVar.j(r.OUTBOUND, (4294967295L & ((long) i9)) | (((long) i8) << 32));
        }
        try {
            this.f1519b.j(z2, i8, i9);
        } catch (IOException e) {
            this.f1518a.b(e);
        }
    }

    @Override // ef.c
    public final void r() {
        try {
            this.f1519b.r();
        } catch (IOException e) {
            this.f1518a.b(e);
        }
    }
}
