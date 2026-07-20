package c3;

import com.transsion.connectx.mirror.source.receiver.HomeKeyReceiver;
import kn.l0;
import kn.w;

/* JADX INFO: loaded from: classes2.dex */
public class l implements x2.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final a f1310b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final String f1311c = "FileListenerDelegate";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final x2.d f1312a;

    public static final class a {
        public a() {
        }

        public a(w wVar) {
        }
    }

    public l(@os.l x2.d dVar) {
        l0.p(dVar, "listener");
        this.f1312a = dVar;
    }

    public static /* synthetic */ void d(l lVar, long j10, Exception exc, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onFail");
        }
        if ((i10 & 2) != 0) {
            exc = null;
        }
        lVar.a(j10, exc);
    }

    public final void a(long j10, @os.m Exception exc) {
        b(j10, n.f1317a.a(exc));
    }

    @Override // x2.d
    public void b(long j10, @os.l r2.w wVar) {
        l0.p(wVar, HomeKeyReceiver.f2161e);
        j3.b.f8554a.c(f1311c, "onFail taskId=" + j10 + ", reason=" + wVar);
        m.f1313a.h(j10, 3);
        this.f1312a.b(j10, wVar);
    }

    @Override // x2.d
    public void g(long j10) {
        this.f1312a.g(j10);
    }

    @Override // x2.d
    public void onCancel(long j10, boolean z10) {
        j3.b.f8554a.e(f1311c, "onCancel taskId=" + j10 + ", isRemoteCancel=" + z10);
        m.f1313a.h(j10, 4);
        this.f1312a.onCancel(j10, z10);
    }

    @Override // x2.d
    public void onFinish(long j10) {
        j3.b.f8554a.e(f1311c, "onFinish taskId=" + j10);
        m.f1313a.h(j10, 2);
        this.f1312a.onFinish(j10);
    }

    @Override // x2.d
    public void onProgress(long j10, double d10, int i10, int i11) {
        this.f1312a.onProgress(j10, d10, i10, i11);
    }
}
