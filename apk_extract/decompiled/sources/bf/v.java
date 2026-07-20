package bf;

import com.google.protobuf.MessageLite;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import li.g2;
import li.l0;
import ze.c2;
import ze.q2;
import ze.r2;

/* JADX INFO: loaded from: classes3.dex */
public final class v extends ze.i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1299d = true;
    public final /* synthetic */ g2 e;
    public final /* synthetic */ ni.m f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ c2 f1300g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ t f1301h;

    public v(g2 g2Var, ni.m mVar, c2 c2Var, t tVar) {
        this.e = g2Var;
        this.f = mVar;
        this.f1300g = c2Var;
        this.f1301h = tVar;
    }

    @Override // ze.i
    public final void i() {
        l0.g("Cancellation received from client", null, this.e);
    }

    @Override // ze.i
    public final void k() {
        this.f.q(null);
    }

    @Override // ze.i
    public final void l(MessageLite messageLite) throws r2 {
        if (this.f1299d) {
            Object objF = this.f.f(messageLite);
            boolean z2 = objF instanceof ni.t;
            this.f1299d = !z2;
            if (z2) {
                Throwable thA = ni.u.a(objF);
                if (!(thA instanceof CancellationException)) {
                    r2 r2Var = new r2(q2.f11410m.h("onMessage should never be called when requestsChannel is unready").g(thA));
                    Intrinsics.checkNotNullExpressionValue(r2Var, "INTERNAL\n               …           .asException()");
                    throw r2Var;
                }
            }
        }
        if (this.f1299d) {
            return;
        }
        this.f1300g.b(1);
    }

    @Override // ze.i
    public final void m() throws Throwable {
        Object objF = this.f1301h.f1295b.f(Unit.INSTANCE);
        if (objF instanceof ni.t) {
            Throwable thA = ni.u.a(objF);
            if (thA != null) {
                throw thA;
            }
            throw new AssertionError("Should be impossible; a CONFLATED channel should never return false on offer");
        }
    }
}
