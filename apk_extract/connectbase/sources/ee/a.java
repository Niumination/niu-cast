package ee;

import android.os.RemoteException;
import com.transsion.hubsdk.resmonitor.ITranResMonitorCallback;
import com.transsion.hubsdk.resmonitor.TranResMonitorManager;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<b> f4269a = new ArrayList();

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public eb.a f4270a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ITranResMonitorCallback f4271b;

        public b() {
        }

        public eb.a a() {
            return this.f4270a;
        }

        public ITranResMonitorCallback b() {
            return this.f4271b;
        }

        public void c(eb.a aVar) {
            this.f4270a = aVar;
        }

        public void d(ITranResMonitorCallback iTranResMonitorCallback) {
            this.f4271b = iTranResMonitorCallback;
        }

        public b(C0100a c0100a) {
        }
    }

    public static class c extends ITranResMonitorCallback.Stub {
        public void a(int i10, String str) throws RemoteException {
            for (b bVar : a.f4269a) {
                if (bVar.f4271b.equals(this)) {
                    bVar.f4270a.f(i10, str);
                    return;
                }
            }
        }
    }

    public static void b(int i10, eb.a aVar, int i11, int i12, int i13, int i14) {
        b bVar = new b(null);
        bVar.c(aVar);
        c cVar = new c();
        bVar.d(cVar);
        f4269a.add(bVar);
        TranResMonitorManager.regCallbackStatic(i10, cVar, i11, i12, i13, i14);
    }

    public static void c(eb.a aVar) {
        for (b bVar : f4269a) {
            if (bVar.a().equals(aVar)) {
                TranResMonitorManager.unregCallbackStatic(bVar.b());
                f4269a.remove(bVar);
                return;
            }
        }
    }
}
