package qk;

import ck.j;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ek.d f9235c = new ek.d(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference f9237b;

    public a(int i8) {
        this.f9236a = i8;
        switch (i8) {
            case 1:
                this.f9237b = new AtomicReference(new c(false, new a(0)));
                break;
            default:
                this.f9237b = new AtomicReference();
                break;
        }
    }

    public void a(j jVar) {
        c cVar;
        boolean z2;
        if (jVar == null) {
            throw new IllegalArgumentException("Subscription can not be null");
        }
        AtomicReference atomicReference = this.f9237b;
        do {
            cVar = (c) atomicReference.get();
            z2 = cVar.f9240a;
            if (z2) {
                jVar.unsubscribe();
                return;
            }
        } while (!atomicReference.compareAndSet(cVar, new c(z2, jVar)));
    }

    @Override // ck.j
    public final boolean isUnsubscribed() {
        switch (this.f9236a) {
            case 0:
                return this.f9237b.get() == f9235c;
            default:
                return ((c) this.f9237b.get()).f9240a;
        }
    }

    @Override // ck.j
    public final void unsubscribe() {
        ek.a aVar;
        c cVar;
        j jVar;
        switch (this.f9236a) {
            case 0:
                AtomicReference atomicReference = this.f9237b;
                ek.a aVar2 = (ek.a) atomicReference.get();
                ek.d dVar = f9235c;
                if (aVar2 != dVar && (aVar = (ek.a) atomicReference.getAndSet(dVar)) != null && aVar != dVar) {
                    aVar.call();
                    break;
                }
                break;
            default:
                AtomicReference atomicReference2 = this.f9237b;
                do {
                    cVar = (c) atomicReference2.get();
                    if (!cVar.f9240a) {
                        jVar = cVar.f9241b;
                    }
                    break;
                } while (!atomicReference2.compareAndSet(cVar, new c(true, jVar)));
                jVar.unsubscribe();
                break;
        }
    }

    public a(ek.a aVar) {
        this.f9236a = 0;
        this.f9237b = new AtomicReference(aVar);
    }
}
