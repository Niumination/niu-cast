package fb;

import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f5966d = "f";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public fe.a f5967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p8.a f5968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f5969c = new Handler(Looper.getMainLooper());

    public class a implements a7.a.InterfaceC0003a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f5970a;

        public a(b bVar) {
            this.f5970a = bVar;
        }

        public static /* synthetic */ void g(b bVar, IBinder iBinder, boolean z10, final a7.a.b bVar2) {
            Objects.requireNonNull(bVar2);
            bVar.a(iBinder, z10, new c() { // from class: fb.e
                @Override // fb.f.c
                public final void a(Bundle bundle) {
                    bVar2.a(bundle);
                }
            });
        }

        @Override // a7.a.InterfaceC0003a
        public void b() {
            if (this.f5970a != null) {
                Handler handler = f.this.f5969c;
                final b bVar = this.f5970a;
                Objects.requireNonNull(bVar);
                handler.post(new Runnable() { // from class: fb.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        bVar.b();
                    }
                });
            }
        }

        @Override // a7.a.InterfaceC0003a
        public void c(final int i10) {
            if (this.f5970a != null) {
                Handler handler = f.this.f5969c;
                final b bVar = this.f5970a;
                handler.post(new Runnable() { // from class: fb.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        bVar.c(i10);
                    }
                });
            }
        }

        @Override // a7.a.InterfaceC0003a
        public void d() {
            if (this.f5970a != null) {
                Handler handler = f.this.f5969c;
                final b bVar = this.f5970a;
                Objects.requireNonNull(bVar);
                handler.post(new Runnable() { // from class: fb.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        bVar.d();
                    }
                });
            }
        }

        @Override // a7.a.InterfaceC0003a
        public void e(final IBinder iBinder, final boolean z10, final a7.a.b bVar) {
            if (this.f5970a != null) {
                Handler handler = f.this.f5969c;
                final b bVar2 = this.f5970a;
                handler.post(new Runnable() { // from class: fb.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        f.a.g(bVar2, iBinder, z10, bVar);
                    }
                });
            }
        }
    }

    public interface b {
        void a(IBinder iBinder, boolean z10, c cVar);

        void b();

        void c(int i10);

        void d();
    }

    public interface c {
        void a(Bundle bundle);
    }

    @yb.a(level = 1)
    public void b(IBinder iBinder, boolean z10) {
        c(fc.b.a.f5989i).a(iBinder, z10);
    }

    public zg.a c(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f5966d, "TranThubDreamService");
            fe.a aVar = this.f5967a;
            if (aVar != null) {
                return aVar;
            }
            fe.a aVar2 = new fe.a();
            this.f5967a = aVar2;
            return aVar2;
        }
        dc.e.f(f5966d, "TranAospDreamService");
        p8.a aVar3 = this.f5968b;
        if (aVar3 != null) {
            return aVar3;
        }
        p8.a aVar4 = new p8.a();
        this.f5968b = aVar4;
        return aVar4;
    }

    public IBinder d(b bVar) {
        return c(fc.b.a.f5989i).d(new a(bVar));
    }

    public void e(IBinder iBinder, int i10, int i11) {
        c(fc.b.a.f5989i).c(iBinder, i10, i11);
    }

    public void f(IBinder iBinder) {
        c(fc.b.a.f5989i).b(iBinder);
    }
}
