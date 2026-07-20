package af;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes3.dex */
public final class w0 implements d0, vj.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Collection f642c;

    public w0() {
        this.f640a = false;
        this.f641b = new ConcurrentHashMap();
        this.f642c = new LinkedBlockingQueue();
    }

    public void a(Runnable runnable) {
        synchronized (this) {
            try {
                if (this.f640a) {
                    runnable.run();
                } else {
                    ((List) this.f642c).add(runnable);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // vj.a
    public synchronized vj.b d(String str) {
        xj.j jVar;
        jVar = (xj.j) ((ConcurrentHashMap) this.f641b).get(str);
        if (jVar == null) {
            jVar = new xj.j(str, (LinkedBlockingQueue) this.f642c, this.f640a);
            ((ConcurrentHashMap) this.f641b).put(str, jVar);
        }
        return jVar;
    }

    @Override // af.d0
    public void i(ze.p1 p1Var) {
        a(new e(13, this, p1Var));
    }

    @Override // af.j6
    public void j(a8.a aVar) {
        if (this.f640a) {
            ((d0) this.f641b).j(aVar);
        } else {
            a(new e(12, this, aVar));
        }
    }

    @Override // af.d0
    public void l(ze.q2 q2Var, c0 c0Var, ze.p1 p1Var) {
        a(new a(1, this, q2Var, c0Var, p1Var));
    }

    @Override // af.j6
    public void q() {
        if (this.f640a) {
            ((d0) this.f641b).q();
        } else {
            a(new f(this, 2));
        }
    }

    public w0(d0 d0Var) {
        this.f642c = new ArrayList();
        this.f641b = d0Var;
    }
}
