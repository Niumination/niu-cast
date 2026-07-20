package h7;

import android.os.CancellationSignal;
import android.os.Handler;

/* JADX INFO: loaded from: classes2.dex */
public class b implements sf.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f6981c = "b";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Class<?> f6982d = cc.a.a("android.hardware.face.FaceManager");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f6983e = "face";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f6984a = bc.a.a().getSystemService("face");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f6985b;

    public class a implements c.InterfaceC0194c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y9.b.a f6986a;

        public a(y9.b.a aVar) {
            this.f6986a = aVar;
        }

        @Override // h7.c.InterfaceC0194c
        public void a(int i10, CharSequence charSequence) {
            y9.b.a aVar = this.f6986a;
            if (aVar != null) {
                aVar.a(i10, charSequence);
            }
        }

        @Override // h7.c.InterfaceC0194c
        public void b(int i10) {
            y9.b.a aVar = this.f6986a;
            if (aVar != null) {
                aVar.b(i10);
            }
        }

        @Override // h7.c.InterfaceC0194c
        public void c(int i10, CharSequence charSequence) {
            y9.b.a aVar = this.f6986a;
            if (aVar != null) {
                aVar.c(i10, charSequence);
            }
        }

        @Override // h7.c.InterfaceC0194c
        public void d() {
            y9.b.a aVar = this.f6986a;
            if (aVar != null) {
                aVar.d();
            }
        }

        @Override // h7.c.InterfaceC0194c
        public void e(String str) {
            y9.b.a aVar = this.f6986a;
            if (aVar != null) {
                aVar.e(str);
            }
        }
    }

    @b.a({"WrongConstant"})
    public b() {
    }

    @Override // sf.b
    public boolean a() {
        return Boolean.TRUE.equals(cc.a.j(cc.a.g(f6982d, "hasEnrolledTemplates", new Class[0]), this.f6984a, new Object[0]));
    }

    @Override // sf.b
    public void b(CancellationSignal cancellationSignal, y9.b.a aVar, Handler handler, int i10, boolean z10) {
        a aVar2 = new a(aVar);
        if (fc.a.d() || fc.a.b()) {
            c().b(cancellationSignal, aVar2, handler, i10, z10);
        } else if (fc.a.f()) {
            c().a(cancellationSignal, aVar2, handler, i10);
        }
    }

    public final c c() {
        if (this.f6985b == null) {
            this.f6985b = new c(bc.a.a());
        }
        return this.f6985b;
    }
}
