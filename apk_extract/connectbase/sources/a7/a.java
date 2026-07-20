package a7;

import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IRemoteCallback;
import android.os.Looper;
import android.os.RemoteException;
import android.service.dreams.IDreamService;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f130a = "TranAospDreamServiceWrapperExt";

    /* JADX INFO: renamed from: a7.a$a, reason: collision with other inner class name */
    public interface InterfaceC0003a {
        void b();

        void c(int i10);

        void d();

        void e(IBinder iBinder, boolean z10, b bVar);
    }

    public interface b {
        void a(Bundle bundle);
    }

    public static class c extends IDreamService.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public InterfaceC0003a f131a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Handler f132b = new Handler(Looper.getMainLooper());

        public c(InterfaceC0003a interfaceC0003a) {
            this.f131a = interfaceC0003a;
        }

        public static /* synthetic */ void h(IRemoteCallback iRemoteCallback, Bundle bundle) {
            if (iRemoteCallback != null) {
                try {
                    dc.e.a(a.f130a, "sendResult started:" + iRemoteCallback);
                    iRemoteCallback.sendResult(bundle);
                } catch (Exception e10) {
                    dc.e.a(a.f130a, "IRemoteCallback  sendResult fail" + e10);
                }
            }
        }

        public void e(final IBinder iBinder, final boolean z10, boolean z11, final IRemoteCallback iRemoteCallback) throws RemoteException {
            dc.e.a(a.f130a, "attach started:" + iRemoteCallback);
            if (this.f131a != null) {
                this.f132b.post(new Runnable() { // from class: a7.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f134a.i(iBinder, z10, iRemoteCallback);
                    }
                });
            }
        }

        public void f() throws RemoteException {
        }

        public void g() {
            dc.e.a(a.f130a, "detach");
            if (this.f131a != null) {
                this.f132b.post(new Runnable() { // from class: a7.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f138a.j();
                    }
                });
            }
        }

        public final /* synthetic */ void i(IBinder iBinder, boolean z10, final IRemoteCallback iRemoteCallback) {
            this.f131a.e(iBinder, z10, new b() { // from class: a7.e
                @Override // a7.a.b
                public final void a(Bundle bundle) {
                    a.c.h(iRemoteCallback, bundle);
                }
            });
        }

        public final /* synthetic */ void j() {
            this.f131a.b();
        }

        public final /* synthetic */ void k() {
            this.f131a.d();
        }

        public void l() {
            dc.e.a(a.f130a, "wakeUp");
            if (this.f131a != null) {
                this.f132b.post(new Runnable() { // from class: a7.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f133a.k();
                    }
                });
            }
        }
    }

    public IBinder a(InterfaceC0003a interfaceC0003a) {
        return new c(interfaceC0003a);
    }
}
