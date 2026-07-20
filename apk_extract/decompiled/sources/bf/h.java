package bf;

import com.google.protobuf.MessageLite;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import ze.p1;
import ze.q2;
import ze.r2;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends ze.f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ni.m f1285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t f1286b;

    public h(ni.m mVar, t tVar) {
        this.f1285a = mVar;
        this.f1286b = tVar;
    }

    @Override // ze.f0
    public final void f(q2 status, p1 trailersMetadata) {
        Throwable th2;
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(trailersMetadata, "trailersMetadata");
        if (status.e()) {
            th2 = null;
        } else {
            Throwable r2Var = status.f11415c;
            if (!(r2Var instanceof CancellationException)) {
                r2Var = new r2(status, trailersMetadata);
            }
            th2 = r2Var;
        }
        this.f1285a.g(false, th2);
    }

    @Override // ze.f0
    public final void i(MessageLite messageLite) throws Throwable {
        Object objF = this.f1285a.f(messageLite);
        if (objF instanceof ni.t) {
            Throwable thA = ni.u.a(objF);
            if (thA != null) {
                throw thA;
            }
            throw new AssertionError("onMessage should never be called until responses is ready");
        }
    }

    @Override // ze.f0
    public final void j() throws Throwable {
        Object objF = this.f1286b.f1295b.f(Unit.INSTANCE);
        if (objF instanceof ni.t) {
            Throwable thA = ni.u.a(objF);
            if (thA != null) {
                throw thA;
            }
            throw new AssertionError("Should be impossible; a CONFLATED channel should never return false on offer");
        }
    }
}
