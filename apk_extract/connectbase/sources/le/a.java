package le;

import android.os.RemoteException;
import com.transsion.hubsdk.trancare.cloudengine.ITranCloudEngineCallback;
import com.transsion.hubsdk.trancare.trancare.TranTrancareManager;
import com.transsion.hubsdk.util.TranLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f9815b = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b> f9816a = new CopyOnWriteArrayList();

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public lb.a f9817a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ITranCloudEngineCallback f9818b;

        public b() {
        }

        public lb.a a() {
            return this.f9817a;
        }

        public ITranCloudEngineCallback b() {
            return this.f9818b;
        }

        public void c(lb.a aVar) {
            this.f9817a = aVar;
        }

        public void d(ITranCloudEngineCallback iTranCloudEngineCallback) {
            this.f9818b = iTranCloudEngineCallback;
        }

        public b(C0261a c0261a) {
        }
    }

    public class c extends ITranCloudEngineCallback.Stub {
        public c() {
        }

        public void a(String str, boolean z10, String str2) throws RemoteException {
            try {
                for (b bVar : a.this.f9816a) {
                    if (bVar.b().equals(this)) {
                        bVar.a().o(str, z10, str2);
                        return;
                    }
                }
            } catch (Exception unused) {
                TranLog.e(a.f9815b, "api call back error!!!");
            }
        }
    }

    public void c(String str, String str2, lb.a aVar) {
        if (!this.f9816a.isEmpty()) {
            Iterator<b> it = this.f9816a.iterator();
            while (it.hasNext()) {
                if (it.next().a().equals(aVar)) {
                    TranLog.w(f9815b, "this callback has resgistered, return!");
                    return;
                }
            }
        }
        b bVar = new b(null);
        bVar.c(aVar);
        c cVar = new c();
        bVar.d(cVar);
        this.f9816a.add(bVar);
        TranTrancareManager.regCloudEngineCallback(str, str2, cVar);
    }

    public void d(String str, lb.a aVar) {
        for (b bVar : this.f9816a) {
            if (bVar.a().equals(aVar)) {
                this.f9816a.remove(bVar);
                TranTrancareManager.unregCloudEngineCallback(str, bVar.b());
                return;
            }
        }
    }
}
