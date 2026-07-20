package v8;

import android.os.RemoteException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f16672b = "a";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f16673c = "com.transsion.log.cloudengine.CloudEngine";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b> f16674a = new CopyOnWriteArrayList();

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public lb.a f16675a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public gi.a f16676b;

        public b() {
        }

        public gi.a a() {
            return this.f16676b;
        }

        public lb.a b() {
            return this.f16675a;
        }

        public void c(gi.a aVar) {
            this.f16676b = aVar;
        }

        public void d(lb.a aVar) {
            this.f16675a = aVar;
        }

        public b(C0448a c0448a) {
        }
    }

    public class c extends gi.a.b {
        public c() {
        }

        @Override // gi.a
        public void o(String str, boolean z10, String str2) throws RemoteException {
            for (b bVar : a.this.f16674a) {
                if (bVar.f16676b.equals(this)) {
                    bVar.f16675a.o(str, z10, str2);
                    return;
                }
            }
        }
    }

    public void b(String str, String str2, lb.a aVar) {
        if (!this.f16674a.isEmpty()) {
            Iterator<b> it = this.f16674a.iterator();
            while (it.hasNext()) {
                if (it.next().f16675a.equals(aVar)) {
                    dc.e.n(f16672b, "this callback has resgistered, return!");
                    return;
                }
            }
        }
        b bVar = new b();
        bVar.f16675a = aVar;
        c cVar = new c();
        bVar.f16676b = cVar;
        this.f16674a.add(bVar);
        try {
            Class.forName("com.transsion.log.cloudengine.CloudEngine").getDeclaredMethod("regCloudEngineCallback", String.class, String.class, gi.a.class).invoke(null, str, str2, cVar);
        } catch (Exception e10) {
            dc.e.c(f16672b, "regCallback error: " + e10.getMessage());
        }
    }

    public void c(String str, lb.a aVar) {
        for (b bVar : this.f16674a) {
            if (aVar.equals(bVar.f16675a)) {
                try {
                    Class.forName("com.transsion.log.cloudengine.CloudEngine").getDeclaredMethod("unregCloudEngineCallback", String.class, gi.a.class).invoke(null, str, bVar.f16676b);
                } catch (Exception e10) {
                    dc.e.c(f16672b, "unRegCallback error: " + e10.getMessage());
                }
                this.f16674a.remove(bVar);
                return;
            }
        }
    }
}
