package r2;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class u extends o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f9371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q3.g f9372c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p2.d f9373d;

    public u(int i8, i iVar, q3.g gVar, p2.d dVar) {
        super(i8);
        this.f9372c = gVar;
        this.f9371b = iVar;
        this.f9373d = dVar;
        if (i8 == 2 && iVar.f9336b) {
            throw new IllegalArgumentException("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
        }
    }

    @Override // r2.o
    public final boolean a(l lVar) {
        return this.f9371b.f9336b;
    }

    @Override // r2.o
    public final Feature[] b(l lVar) {
        return this.f9371b.f9335a;
    }

    @Override // r2.o
    public final void c(Status status) {
        this.f9373d.getClass();
        this.f9372c.a(status.f1821d != null ? new q2.k(status) : new q2.d(status));
    }

    @Override // r2.o
    public final void d(RuntimeException runtimeException) {
        this.f9372c.a(runtimeException);
    }

    @Override // r2.o
    public final void e(l lVar) throws DeadObjectException {
        q3.g gVar = this.f9372c;
        try {
            i iVar = this.f9371b;
            ((h) ((i) iVar.f9338d).f9338d).accept(lVar.f9341c, gVar);
        } catch (DeadObjectException e) {
            throw e;
        } catch (RemoteException e4) {
            c(o.g(e4));
        } catch (RuntimeException e10) {
            gVar.a(e10);
        }
    }

    @Override // r2.o
    public final void f(f5.a aVar, boolean z2) {
        Boolean boolValueOf = Boolean.valueOf(z2);
        Map map = (Map) aVar.f4985b;
        q3.g gVar = this.f9372c;
        map.put(gVar, boolValueOf);
        ad.b bVar = new ad.b(aVar, gVar);
        q3.k kVar = gVar.f8950a;
        kVar.getClass();
        kVar.f8958b.k(new q3.i(q3.h.f8951a, bVar));
        kVar.j();
    }
}
