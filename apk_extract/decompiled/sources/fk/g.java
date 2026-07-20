package fk;

import com.transsion.iotcardsdk.event.EventBean;
import k3.t9;
import k3.x1;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends ck.i {
    public final /* synthetic */ int e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ck.i f5067h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Object f5068i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f5069j;

    public g(ck.i iVar) {
        this.e = 2;
        this.f5067h = iVar;
        this.f5068i = EventBean.class;
    }

    @Override // ck.i
    public final void b(ck.e eVar) {
        switch (this.e) {
            case 0:
                super.b(eVar);
                this.f5067h.b(eVar);
                break;
            case 1:
                this.f5067h.b(eVar);
                break;
            default:
                this.f5067h.b(eVar);
                break;
        }
    }

    @Override // ck.d
    public final void onCompleted() {
        switch (this.e) {
            case 0:
                if (!this.f5069j) {
                    this.f5067h.onCompleted();
                    break;
                }
                break;
            case 1:
                if (!this.f5069j) {
                    this.f5067h.onCompleted();
                    break;
                }
                break;
            default:
                if (!this.f5069j) {
                    this.f5067h.onCompleted();
                    break;
                }
                break;
        }
    }

    @Override // ck.d
    public final void onError(Throwable th2) {
        switch (this.e) {
            case 0:
                if (!this.f5069j) {
                    this.f5069j = true;
                    this.f5067h.onError(th2);
                } else {
                    t9.a();
                }
                break;
            case 1:
                if (!this.f5069j) {
                    this.f5069j = true;
                    this.f5067h.onError(th2);
                } else {
                    t9.a();
                }
                break;
            default:
                if (!this.f5069j) {
                    this.f5069j = true;
                    this.f5067h.onError(th2);
                } else {
                    t9.a();
                }
                break;
        }
    }

    @Override // ck.d
    public final void onNext(Object obj) {
        switch (this.e) {
            case 0:
                try {
                    if (!((Boolean) ((ek.g) this.f5068i).call(obj)).booleanValue()) {
                        a(1L);
                    } else {
                        this.f5067h.onNext(obj);
                    }
                } catch (Throwable th2) {
                    x1.b(th2);
                    unsubscribe();
                    onError(dk.j.addValueAsLastCause(th2, obj));
                    return;
                }
                break;
            case 1:
                try {
                    this.f5067h.onNext(((ek.g) this.f5068i).call(obj));
                } catch (Throwable th3) {
                    x1.b(th3);
                    unsubscribe();
                    onError(dk.j.addValueAsLastCause(th3, obj));
                }
                break;
            default:
                try {
                    this.f5067h.onNext(((Class) this.f5068i).cast(obj));
                } catch (Throwable th4) {
                    x1.b(th4);
                    unsubscribe();
                    onError(dk.j.addValueAsLastCause(th4, obj));
                    return;
                }
                break;
        }
    }

    public g(ck.i iVar, ek.g gVar, int i8) {
        this.e = i8;
        switch (i8) {
            case 1:
                this.f5067h = iVar;
                this.f5068i = gVar;
                break;
            default:
                this.f5067h = iVar;
                this.f5068i = gVar;
                a(0L);
                break;
        }
    }
}
