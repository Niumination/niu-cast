package e8;

import android.os.UEventObserver;
import java.lang.reflect.Field;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class v {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f4147c = "TranAospUEventObserverManagerExt";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f4148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f4149b;

    public interface a {
        void a();
    }

    public interface b {
        void a(va.r rVar);
    }

    public void a(a aVar) {
        this.f4148a = new c(aVar);
    }

    public void b(b bVar) {
        this.f4149b = new c(bVar);
    }

    public void c(String str) {
        try {
            c cVar = this.f4148a;
            if (cVar != null) {
                cVar.getClass().getMethod("startObserving", String.class).invoke(this.f4148a, str);
            }
            c cVar2 = this.f4149b;
            if (cVar2 != null) {
                cVar2.getClass().getMethod("startObserving", String.class).invoke(this.f4149b, str);
            }
        } catch (Exception e10) {
            dc.e.a(f4147c, "startObserving fail :" + e10);
        }
    }

    public void d() {
        try {
            c cVar = this.f4148a;
            if (cVar != null) {
                cVar.getClass().getMethod("stopObserving", null).invoke(this.f4148a, null);
            }
            c cVar2 = this.f4149b;
            if (cVar2 != null) {
                cVar2.getClass().getMethod("stopObserving", null).invoke(this.f4149b, null);
            }
        } catch (Exception e10) {
            dc.e.a(f4147c, "stopObserving fail :" + e10);
        }
    }

    public static class c extends UEventObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public a f4150a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public b f4151b;

        public c(a aVar) {
            this.f4150a = aVar;
        }

        public void a(UEventObserver.UEvent uEvent) {
            a aVar = this.f4150a;
            if (aVar != null) {
                aVar.a();
            }
            if (this.f4151b != null) {
                Field fieldD = cc.a.d(uEvent.getClass(), "mMap");
                HashMap<String, String> map = new HashMap<>();
                if (fieldD != null) {
                    map = (HashMap) cc.a.f(fieldD, uEvent);
                }
                va.r rVar = new va.r();
                rVar.f16834a = map;
                this.f4151b.a(rVar);
            }
        }

        public c(b bVar) {
            this.f4151b = bVar;
        }
    }
}
