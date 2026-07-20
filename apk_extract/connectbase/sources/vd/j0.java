package vd;

import android.annotation.NonNull;
import android.os.RemoteException;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.os.ITranTrace;
import com.transsion.hubsdk.os.TranAsyncTrace;

/* JADX INFO: loaded from: classes2.dex */
public class j0 implements pg.n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f16945c = "j0";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranTrace f16946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TranAsyncTrace f16947b;

    public j0() {
        new zb.f().a(new zb.f.a() { // from class: vd.f0
            @Override // zb.f.a
            public final Object run() {
                return this.f16925a.m();
            }
        }, "trace");
    }

    @Override // pg.n
    public void a(final long j10, @NonNull final String str, final int i10) {
        new zb.f().a(new zb.f.a() { // from class: vd.e0
            @Override // zb.f.a
            public final Object run() {
                return this.f16921a.l(j10, str, i10);
            }
        }, "trace");
    }

    @Override // pg.n
    public void b(final long j10, @NonNull final String str, final int i10) {
        new zb.f().a(new zb.f.a() { // from class: vd.g0
            @Override // zb.f.a
            public final Object run() {
                return this.f16927a.k(j10, str, i10);
            }
        }, "trace");
    }

    @Override // pg.n
    public void c(final long j10) {
        new zb.f().a(new zb.f.a() { // from class: vd.i0
            @Override // zb.f.a
            public final Object run() {
                return this.f16939a.o(j10);
            }
        }, "trace");
    }

    @Override // pg.n
    public void d(final long j10, final String str) {
        new zb.f().a(new zb.f.a() { // from class: vd.h0
            @Override // zb.f.a
            public final Object run() {
                return this.f16934a.n(j10, str);
            }
        }, "trace");
    }

    public TranAsyncTrace j() {
        if (this.f16947b == null) {
            this.f16947b = new TranAsyncTrace();
        }
        return this.f16947b;
    }

    public final /* synthetic */ Object k(long j10, String str, int i10) throws RemoteException {
        j();
        TranAsyncTrace.asyncTraceBegin(j10, str, i10);
        return null;
    }

    public final /* synthetic */ Object l(long j10, String str, int i10) throws RemoteException {
        j();
        TranAsyncTrace.asyncTraceEnd(j10, str, i10);
        return null;
    }

    public final /* synthetic */ Object m() throws RemoteException {
        this.f16946a = ITranTrace.Stub.asInterface(TranServiceManager.getServiceIBinder("trace"));
        return null;
    }

    public final /* synthetic */ Object n(long j10, String str) throws RemoteException {
        ITranTrace iTranTrace = this.f16946a;
        if (iTranTrace == null) {
            return null;
        }
        iTranTrace.traceBegin(j10, str);
        dc.e.a(f16945c, "traceBegin");
        return null;
    }

    public final /* synthetic */ Object o(long j10) throws RemoteException {
        ITranTrace iTranTrace = this.f16946a;
        if (iTranTrace == null) {
            return null;
        }
        iTranTrace.traceEnd(j10);
        dc.e.a(f16945c, "traceEnd");
        return null;
    }
}
