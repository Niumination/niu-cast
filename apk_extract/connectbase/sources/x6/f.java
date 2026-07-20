package x6;

import android.content.Context;
import android.content.pm.IPackageDeleteObserver;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f20092b = "TranAospPackageManagerExt";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f20093a;

    public interface a {
        void a(String str, int i10);
    }

    public static class b extends IPackageDeleteObserver.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public a f20094a;

        public b(a aVar) {
            this.f20094a = aVar;
        }

        public void a(String str, int i10) throws RemoteException {
            a aVar = this.f20094a;
            if (aVar != null) {
                aVar.a(str, i10);
            }
        }
    }

    public f(Context context) {
        this.f20093a = context;
    }
}
