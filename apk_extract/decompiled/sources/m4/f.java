package m4;

import k3.jb;

/* JADX INFO: loaded from: classes.dex */
public final class f extends jb {
    @Override // k3.jb
    public final boolean a(j jVar, d dVar, d dVar2) {
        synchronized (jVar) {
            try {
                if (jVar.f7932b != dVar) {
                    return false;
                }
                jVar.f7932b = dVar2;
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // k3.jb
    public final boolean b(j jVar, Object obj, Object obj2) {
        synchronized (jVar) {
            try {
                if (jVar.f7931a != obj) {
                    return false;
                }
                jVar.f7931a = obj2;
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // k3.jb
    public final boolean c(j jVar, i iVar, i iVar2) {
        synchronized (jVar) {
            try {
                if (jVar.f7933c != iVar) {
                    return false;
                }
                jVar.f7933c = iVar2;
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // k3.jb
    public final d d(j jVar) {
        d dVar;
        d dVar2 = d.f7913d;
        synchronized (jVar) {
            dVar = jVar.f7932b;
            if (dVar != dVar2) {
                jVar.f7932b = dVar2;
            }
        }
        return dVar;
    }

    @Override // k3.jb
    public final i e(j jVar) {
        i iVar;
        i iVar2 = i.f7925c;
        synchronized (jVar) {
            iVar = jVar.f7933c;
            if (iVar != iVar2) {
                jVar.f7933c = iVar2;
            }
        }
        return iVar;
    }

    @Override // k3.jb
    public final void f(i iVar, i iVar2) {
        iVar.f7927b = iVar2;
    }

    @Override // k3.jb
    public final void g(i iVar, Thread thread) {
        iVar.f7926a = thread;
    }
}
