package le;

import com.transsion.hubsdk.trancare.trancare.TranTrancareCallback;
import com.transsion.hubsdk.trancare.trancare.TranTrancareManager;
import com.transsion.hubsdk.util.TranLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f9829b = "b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<C0262b> f9830a = new CopyOnWriteArrayList();

    public class a extends TranTrancareCallback {
        public a() {
        }

        public void a() {
            try {
                for (C0262b c0262b : b.this.f9830a) {
                    if (c0262b.b().equals(this)) {
                        c0262b.a().c();
                        return;
                    }
                }
            } catch (Exception unused) {
                TranLog.e(b.f9829b, "api call back error!!!");
            }
        }
    }

    /* JADX INFO: renamed from: le.b$b, reason: collision with other inner class name */
    public static final class C0262b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public lb.c f9832a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public TranTrancareCallback f9833b;

        public C0262b() {
        }

        public lb.c a() {
            return this.f9832a;
        }

        public TranTrancareCallback b() {
            return this.f9833b;
        }

        public void c(lb.c cVar) {
            this.f9832a = cVar;
        }

        public void d(TranTrancareCallback tranTrancareCallback) {
            this.f9833b = tranTrancareCallback;
        }

        public C0262b(a aVar) {
        }
    }

    public void c(lb.c cVar) {
        if (!this.f9830a.isEmpty()) {
            Iterator<C0262b> it = this.f9830a.iterator();
            while (it.hasNext()) {
                if (it.next().a().equals(cVar)) {
                    TranLog.w(f9829b, "this callback has resgistered, return!");
                    return;
                }
            }
        }
        C0262b c0262b = new C0262b(null);
        c0262b.c(cVar);
        a aVar = new a();
        c0262b.d(aVar);
        this.f9830a.add(c0262b);
        TranTrancareManager.regTranLogCallback(aVar);
    }

    public void d(lb.c cVar) {
        for (C0262b c0262b : this.f9830a) {
            if (c0262b.a().equals(cVar)) {
                this.f9830a.remove(c0262b);
                TranTrancareManager.unregTranLogCallback(c0262b.b());
                return;
            }
        }
    }
}
