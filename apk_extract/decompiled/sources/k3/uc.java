package k3;

import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public abstract class uc {
    public static void a(Status status, Object obj, q3.g gVar) {
        if (status.f1819b <= 0) {
            gVar.f8950a.i(obj);
        } else {
            gVar.a(status.f1821d != null ? new q2.k(status) : new q2.d(status));
        }
    }
}
