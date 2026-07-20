package fk;

import k3.x1;
import tj.w;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends ck.i {
    public boolean e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f5063h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ gk.a f5064i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ ck.i f5065j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ w f5066k;

    public f(w wVar, gk.a aVar, ck.i iVar) {
        this.f5066k = wVar;
        this.f5064i = aVar;
        this.f5065j = iVar;
    }

    @Override // ck.d
    public final void onCompleted() {
        if (this.f5063h) {
            return;
        }
        this.f5063h = true;
        boolean z2 = this.e;
        gk.a aVar = this.f5064i;
        if (z2) {
            aVar.setValue(Boolean.FALSE);
        } else {
            this.f5066k.getClass();
            aVar.setValue(Boolean.TRUE);
        }
    }

    @Override // ck.d
    public final void onError(Throwable th2) {
        this.f5065j.onError(th2);
    }

    @Override // ck.d
    public final void onNext(Object obj) {
        w wVar = this.f5066k;
        this.e = true;
        try {
            if (!((Boolean) ((ik.w) wVar.f10262b).call(obj)).booleanValue() || this.f5063h) {
                return;
            }
            this.f5063h = true;
            this.f5064i.setValue(Boolean.FALSE);
            unsubscribe();
        } catch (Throwable th2) {
            x1.c(th2, this, obj);
        }
    }
}
