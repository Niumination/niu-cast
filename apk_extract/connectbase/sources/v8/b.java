package v8;

import android.os.RemoteException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f16678b = "b";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f16679c = "transsion.log.Athena";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<C0449b> f16680a = new CopyOnWriteArrayList();

    public class a extends fi.b {
        public a() {
        }

        @Override // fi.b, fi.a
        public void c() {
            try {
                for (C0449b c0449b : b.this.f16680a) {
                    if (c0449b.f16683b.equals(this)) {
                        c0449b.f16682a.c();
                        return;
                    }
                }
            } catch (RemoteException e10) {
                dc.e.c(b.f16678b, "trigger callback error: " + e10.getMessage());
            }
        }
    }

    /* JADX INFO: renamed from: v8.b$b, reason: collision with other inner class name */
    public static final class C0449b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public lb.c f16682a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public fi.b f16683b;

        public C0449b() {
        }

        public fi.b a() {
            return this.f16683b;
        }

        public lb.c b() {
            return this.f16682a;
        }

        public void c(fi.b bVar) {
            this.f16683b = bVar;
        }

        public void d(lb.c cVar) {
            this.f16682a = cVar;
        }

        public C0449b(a aVar) {
        }
    }

    public void c(lb.c cVar) {
        if (!this.f16680a.isEmpty()) {
            Iterator<C0449b> it = this.f16680a.iterator();
            while (it.hasNext()) {
                if (it.next().f16682a.equals(cVar)) {
                    dc.e.n(f16678b, "this callback has resgistered, return!");
                    return;
                }
            }
        }
        C0449b c0449b = new C0449b();
        c0449b.f16682a = cVar;
        a aVar = new a();
        c0449b.f16683b = aVar;
        this.f16680a.add(c0449b);
        try {
            Class.forName("transsion.log.Athena").getDeclaredMethod("regTranLogCallback", fi.b.class).invoke(null, aVar);
        } catch (Exception e10) {
            dc.e.c(f16678b, "regCallback error: " + e10.getMessage());
        }
    }

    public void d(lb.c cVar) {
        for (C0449b c0449b : this.f16680a) {
            if (cVar.equals(c0449b.f16682a)) {
                try {
                    Class.forName("transsion.log.Athena").getDeclaredMethod("unregTranLogCallback", fi.b.class).invoke(null, c0449b.f16683b);
                } catch (Exception e10) {
                    dc.e.c(f16678b, "unRegCallback error: " + e10.getMessage());
                }
                this.f16680a.remove(c0449b);
                return;
            }
        }
    }
}
