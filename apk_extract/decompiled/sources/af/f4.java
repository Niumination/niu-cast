package af;

import java.util.concurrent.atomic.AtomicBoolean;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class f4 extends ze.z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ze.i f282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f283b = new AtomicBoolean(false);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ g4 f284c;

    public f4(g4 g4Var, ze.i iVar) {
        this.f284c = g4Var;
        v8.i(iVar, "subchannel");
        this.f282a = iVar;
    }

    @Override // ze.z0
    public final ze.x0 a(i4 i4Var) {
        if (this.f283b.compareAndSet(false, true)) {
            this.f284c.f292d.d().execute(new f(this, 7));
        }
        return ze.x0.e;
    }
}
