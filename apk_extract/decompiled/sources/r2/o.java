package r2;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9353a;

    public o(int i8) {
        this.f9353a = i8;
    }

    public static /* bridge */ /* synthetic */ Status g(RemoteException remoteException) {
        return new Status(19, remoteException.getClass().getSimpleName() + ": " + remoteException.getLocalizedMessage());
    }

    public abstract boolean a(l lVar);

    public abstract Feature[] b(l lVar);

    public abstract void c(Status status);

    public abstract void d(RuntimeException runtimeException);

    public abstract void e(l lVar);

    public abstract void f(f5.a aVar, boolean z2);
}
