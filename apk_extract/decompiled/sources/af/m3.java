package af;

import java.lang.ref.ReferenceQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public final class m3 extends h1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReferenceQueue f454c = new ReferenceQueue();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap f455d = new ConcurrentHashMap();
    public static final Logger e = Logger.getLogger(m3.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l3 f456b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m3(j3 j3Var) {
        super(j3Var);
        ReferenceQueue referenceQueue = f454c;
        ConcurrentHashMap concurrentHashMap = f455d;
        this.f456b = new l3(this, j3Var, referenceQueue, concurrentHashMap);
    }

    @Override // ze.e1
    public final ze.e1 i() {
        l3 l3Var = this.f456b;
        if (!l3Var.e.getAndSet(true)) {
            l3Var.clear();
        }
        j3 j3Var = this.f306a;
        j3Var.i();
        return j3Var;
    }
}
