package hk;

import ik.u;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends ck.h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final TimeUnit f5491c = TimeUnit.SECONDS;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e f5492d;
    public static final b e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference f5493b;

    static {
        e eVar = new e(u.NONE);
        f5492d = eVar;
        eVar.unsubscribe();
        b bVar = new b(null, 0L, null);
        e = bVar;
        bVar.a();
    }

    public f(u uVar) {
        b bVar = e;
        AtomicReference atomicReference = new AtomicReference(bVar);
        this.f5493b = atomicReference;
        b bVar2 = new b(uVar, 60L, f5491c);
        if (atomicReference.compareAndSet(bVar, bVar2)) {
            return;
        }
        bVar2.a();
    }

    @Override // ck.h
    public final ck.g a() {
        return new d((b) this.f5493b.get());
    }
}
