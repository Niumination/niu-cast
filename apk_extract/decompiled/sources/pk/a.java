package pk;

import java.util.ArrayList;
import k3.x1;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f8917c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final fk.d f8918d;

    public a(f fVar, f fVar2) {
        super(fVar);
        this.f8918d = fk.d.f5057a;
        this.f8917c = fVar2;
    }

    public static a b() {
        f fVar = new f();
        fVar.onTerminated = new a8.a(fVar, 13);
        return new a(fVar, fVar);
    }

    @Override // ck.d
    public final void onCompleted() {
        f fVar = this.f8917c;
        if (fVar.active) {
            this.f8918d.getClass();
            fk.a aVar = fk.d.f5058b;
            for (e eVar : fVar.terminate(aVar)) {
                eVar.a(aVar, fVar.nl);
            }
        }
    }

    @Override // ck.d
    public final void onError(Throwable th2) {
        f fVar = this.f8917c;
        if (fVar.active) {
            this.f8918d.getClass();
            fk.c cVar = new fk.c(th2);
            ArrayList arrayList = null;
            for (e eVar : fVar.terminate(cVar)) {
                try {
                    eVar.a(cVar, fVar.nl);
                } catch (Throwable th3) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th3);
                }
            }
            x1.a(arrayList);
        }
    }

    @Override // ck.d
    public final void onNext(Object obj) {
        for (e eVar : this.f8917c.observers()) {
            eVar.onNext(obj);
        }
    }
}
