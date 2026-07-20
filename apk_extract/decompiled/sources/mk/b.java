package mk;

import ck.d;
import dk.j;
import ef.o;
import k3.x1;
import pk.c;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f8111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f8112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f8113c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public o f8114d;
    public final fk.d e = fk.d.f5057a;

    public b(c cVar) {
        this.f8111a = cVar;
    }

    @Override // ck.d
    public final void onCompleted() {
        if (this.f8113c) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f8113c) {
                    return;
                }
                this.f8113c = true;
                if (!this.f8112b) {
                    this.f8112b = true;
                    this.f8111a.onCompleted();
                    return;
                }
                o oVar = this.f8114d;
                if (oVar == null) {
                    oVar = new o();
                    this.f8114d = oVar;
                }
                this.e.getClass();
                oVar.a(fk.d.f5058b);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // ck.d
    public final void onError(Throwable th2) {
        x1.b(th2);
        if (this.f8113c) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f8113c) {
                    return;
                }
                this.f8113c = true;
                if (!this.f8112b) {
                    this.f8112b = true;
                    this.f8111a.onError(th2);
                    return;
                }
                o oVar = this.f8114d;
                if (oVar == null) {
                    oVar = new o();
                    this.f8114d = oVar;
                }
                this.e.getClass();
                oVar.a(new fk.c(th2));
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    @Override // ck.d
    public final void onNext(Object obj) {
        if (this.f8113c) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f8113c) {
                    return;
                }
                if (this.f8112b) {
                    o oVar = this.f8114d;
                    if (oVar == null) {
                        oVar = new o();
                        this.f8114d = oVar;
                    }
                    this.e.getClass();
                    if (obj == null) {
                        obj = fk.d.f5059c;
                    }
                    oVar.a(obj);
                    return;
                }
                this.f8112b = true;
                try {
                    this.f8111a.onNext(obj);
                    while (true) {
                        for (int i8 = 0; i8 < 1024; i8++) {
                            synchronized (this) {
                                try {
                                    o oVar2 = this.f8114d;
                                    if (oVar2 == null) {
                                        this.f8112b = false;
                                        return;
                                    }
                                    this.f8114d = null;
                                    for (Object obj2 : (Object[]) oVar2.f4952b) {
                                        if (obj2 == null) {
                                            break;
                                        }
                                        try {
                                            fk.d dVar = this.e;
                                            c cVar = this.f8111a;
                                            dVar.getClass();
                                            if (fk.d.a(cVar, obj2)) {
                                                this.f8113c = true;
                                                return;
                                            }
                                        } catch (Throwable th2) {
                                            this.f8113c = true;
                                            x1.b(th2);
                                            this.f8111a.onError(j.addValueAsLastCause(th2, obj));
                                            return;
                                        }
                                    }
                                } catch (Throwable th3) {
                                    throw th3;
                                }
                            }
                        }
                    }
                } catch (Throwable th4) {
                    this.f8113c = true;
                    x1.c(th4, this.f8111a, obj);
                }
            } catch (Throwable th5) {
                throw th5;
            }
        }
    }
}
