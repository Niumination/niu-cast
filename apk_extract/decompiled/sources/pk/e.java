package pk;

import ck.i;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements ck.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f8924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f8925b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f8926c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList f8927d;
    public boolean e;

    public e(i iVar) {
        this.f8924a = iVar;
    }

    public final void a(Serializable serializable, fk.d dVar) {
        if (!this.e) {
            synchronized (this) {
                try {
                    this.f8925b = false;
                    if (this.f8926c) {
                        if (this.f8927d == null) {
                            this.f8927d = new ArrayList();
                        }
                        this.f8927d.add(serializable);
                        return;
                    }
                    this.e = true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        i iVar = this.f8924a;
        dVar.getClass();
        fk.d.a(iVar, serializable);
    }

    @Override // ck.d
    public final void onCompleted() {
        this.f8924a.onCompleted();
    }

    @Override // ck.d
    public final void onError(Throwable th2) {
        this.f8924a.onError(th2);
    }

    @Override // ck.d
    public final void onNext(Object obj) {
        this.f8924a.onNext(obj);
    }
}
