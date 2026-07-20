package r2;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public final class v extends o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q3.g f9374b;

    public v(f fVar, q3.g gVar) {
        super(4);
        this.f9374b = gVar;
    }

    @Override // r2.o
    public final boolean a(l lVar) {
        return false;
    }

    @Override // r2.o
    public final Feature[] b(l lVar) {
        return null;
    }

    @Override // r2.o
    public final void c(Status status) {
        this.f9374b.a(new q2.d(status));
    }

    @Override // r2.o
    public final void d(RuntimeException runtimeException) {
        this.f9374b.a(runtimeException);
    }

    @Override // r2.o
    public final void e(l lVar) throws DeadObjectException {
        try {
            h(lVar);
        } catch (DeadObjectException e) {
            c(o.g(e));
            throw e;
        } catch (RemoteException e4) {
            c(o.g(e4));
        } catch (RuntimeException e10) {
            this.f9374b.a(e10);
        }
    }

    @Override // r2.o
    public final /* bridge */ /* synthetic */ void f(f5.a aVar, boolean z2) {
    }

    public final void h(l lVar) {
        q3.g gVar = this.f9374b;
        gVar.f8950a.i(Boolean.FALSE);
    }
}
