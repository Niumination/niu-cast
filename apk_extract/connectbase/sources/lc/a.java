package lc;

import android.os.RemoteException;
import com.transsion.hubsdk.appm.ITranAppmCallback;
import com.transsion.hubsdk.appm.ITranAppmManager;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f9791a = "a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<c> f9792b = new ArrayList();

    public static class b extends ITranAppmCallback.Stub {
        public void a(String str, String str2) {
            for (c cVar : a.f9792b) {
                if (cVar.f9794b.equals(this)) {
                    try {
                        cVar.f9793a.i(str, str2);
                        return;
                    } catch (RemoteException e10) {
                        dc.e.c(a.f9791a, e10.toString());
                        return;
                    }
                }
            }
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public k9.a f9793a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ITranAppmCallback f9794b;

        public c() {
        }

        public ITranAppmCallback a() {
            return this.f9794b;
        }

        public k9.a b() {
            return this.f9793a;
        }

        public void c(ITranAppmCallback iTranAppmCallback) {
            this.f9794b = iTranAppmCallback;
        }

        public void d(k9.a aVar) {
            this.f9793a = aVar;
        }

        public c(C0260a c0260a) {
        }
    }

    public static void c(ITranAppmManager iTranAppmManager, k9.a aVar) {
        c cVar = new c(null);
        cVar.d(aVar);
        b bVar = new b();
        cVar.c(bVar);
        f9792b.add(cVar);
        try {
            iTranAppmManager.registerAppmCallback(bVar);
        } catch (RemoteException e10) {
            dc.e.c(f9791a, e10.toString());
        }
    }

    public static void d(ITranAppmManager iTranAppmManager, k9.a aVar) {
        for (c cVar : f9792b) {
            if (cVar.b().equals(aVar)) {
                try {
                    iTranAppmManager.unregisterAppmCallback(cVar.a());
                } catch (RemoteException e10) {
                    dc.e.c(f9791a, e10.toString());
                }
                f9792b.remove(cVar);
                return;
            }
        }
    }
}
