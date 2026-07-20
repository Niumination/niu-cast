package ee;

import android.os.Bundle;
import android.os.RemoteException;
import com.transsion.hubsdk.resmonitor.ITranResMonitorManager;
import com.transsion.hubsdk.resmonitor.ITranResmonitorAsyncCallback;
import com.transsion.hubsdk.resmonitor.TranResMonitorManager;
import com.transsion.hubsdk.util.TranLog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f4316a = "t";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<c> f4317b = new ArrayList();

    public static class b extends ITranResmonitorAsyncCallback.Stub {
        public void a(int i10, String str) throws RemoteException {
            for (c cVar : t.f4317b) {
                if (cVar.f4319b.equals(this)) {
                    cVar.f4318a.L(i10, str);
                    t.f4317b.remove(cVar);
                    return;
                }
            }
        }

        public void b(int i10, Bundle bundle) throws RemoteException {
            for (c cVar : t.f4317b) {
                if (cVar.f4319b.equals(this)) {
                    cVar.f4318a.K(i10, bundle);
                    t.f4317b.remove(cVar);
                    return;
                }
            }
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public eb.b f4318a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ITranResmonitorAsyncCallback f4319b;

        public c() {
        }

        public eb.b a() {
            return this.f4318a;
        }

        public ITranResmonitorAsyncCallback b() {
            return this.f4319b;
        }

        public void c(eb.b bVar) {
            this.f4318a = bVar;
        }

        public void d(ITranResmonitorAsyncCallback iTranResmonitorAsyncCallback) {
            this.f4319b = iTranResmonitorAsyncCallback;
        }

        public c(a aVar) {
        }
    }

    public static void b(ITranResMonitorManager iTranResMonitorManager, int i10, String str, eb.b bVar) {
        c cVar = new c(null);
        cVar.c(bVar);
        b bVar2 = new b();
        cVar.d(bVar2);
        f4317b.add(cVar);
        if (iTranResMonitorManager == null) {
            TranResMonitorManager.getEventAsyncStatic(i10, str, bVar2);
            return;
        }
        try {
            iTranResMonitorManager.getEventAsync(i10, str, bVar2);
        } catch (RemoteException unused) {
            TranLog.e(f4316a, "getEventAsync error!!!");
        }
    }

    public static void c(ITranResMonitorManager iTranResMonitorManager, Bundle bundle, eb.b bVar) {
        c cVar = new c(null);
        cVar.c(bVar);
        b bVar2 = new b();
        cVar.d(bVar2);
        f4317b.add(cVar);
        if (iTranResMonitorManager == null) {
            TranResMonitorManager.getEventBundleAsyncStatic(bundle, bVar2);
            return;
        }
        try {
            iTranResMonitorManager.getEventBundleAsync(bundle, bVar2);
        } catch (RemoteException unused) {
            TranLog.e(f4316a, "getEventBundleAsync error!!!");
        }
    }
}
