package hf;

import k3.a9;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends a9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ze.j f5306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f5307b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f5308c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f5309d = false;

    public h(ze.j jVar, boolean z2) {
        this.f5306a = jVar;
        this.f5307b = z2;
    }

    @Override // hf.v
    public final void onCompleted() {
        this.f5306a.b();
        this.f5309d = true;
    }

    @Override // hf.v
    public final void onError(Throwable th2) {
        this.f5306a.a("Cancelled by client with StreamObserver.onError()", th2);
        this.f5308c = true;
    }

    @Override // hf.v
    public final void onNext(Object obj) {
        v8.n(!this.f5308c, "Stream was terminated by error, no further calls are allowed");
        v8.n(!this.f5309d, "Stream is already completed, no further calls are allowed");
        this.f5306a.e(obj);
    }
}
