package h7;

import android.content.Context;
import android.hardware.biometrics.CryptoObject;
import android.hardware.face.FaceManager;
import android.os.CancellationSignal;
import android.os.Handler;
import dc.e;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f6988c = "TranAospFaceManagerExt";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f6989d = "face";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f6990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f6991b;

    public class a extends FaceManager.AuthenticationCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC0194c f6992a;

        public a(InterfaceC0194c interfaceC0194c) {
            this.f6992a = interfaceC0194c;
        }

        public void a(int i10) {
            this.f6992a.b(i10);
        }

        public void b(int i10, CharSequence charSequence) {
            this.f6992a.a(i10, charSequence);
        }

        public void c() {
            this.f6992a.d();
        }

        public void d(int i10, CharSequence charSequence) {
            this.f6992a.c(i10, charSequence);
        }

        public void e(FaceManager.AuthenticationResult authenticationResult) {
            this.f6992a.e(authenticationResult.toString());
        }
    }

    public class b extends FaceManager.AuthenticationCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC0194c f6994a;

        public b(InterfaceC0194c interfaceC0194c) {
            this.f6994a = interfaceC0194c;
        }

        public void a(int i10) {
            this.f6994a.b(i10);
        }

        public void b(int i10, CharSequence charSequence) {
            this.f6994a.a(i10, charSequence);
        }

        public void c() {
            this.f6994a.d();
        }

        public void d(int i10, CharSequence charSequence) {
            this.f6994a.c(i10, charSequence);
        }

        public void e(FaceManager.AuthenticationResult authenticationResult) {
            this.f6994a.e(authenticationResult.toString());
        }
    }

    /* JADX INFO: renamed from: h7.c$c, reason: collision with other inner class name */
    public interface InterfaceC0194c {
        void a(int i10, CharSequence charSequence);

        void b(int i10);

        void c(int i10, CharSequence charSequence);

        void d();

        void e(String str);
    }

    @b.a({"WrongConstant"})
    public c(Context context) {
        this.f6990a = context;
        this.f6991b = context.getSystemService("face");
    }

    public void a(CancellationSignal cancellationSignal, InterfaceC0194c interfaceC0194c, Handler handler, int i10) {
        b bVar = new b(interfaceC0194c);
        Object obj = this.f6991b;
        if (obj != null) {
            cc.a.j(cc.a.g(obj.getClass(), "authenticate", CryptoObject.class, CancellationSignal.class, FaceManager.AuthenticationCallback.class, Handler.class, Integer.TYPE), this.f6991b, null, cancellationSignal, bVar, handler, Integer.valueOf(i10));
            e.f(f6988c, "authenticate for U");
        }
    }

    public void b(CancellationSignal cancellationSignal, InterfaceC0194c interfaceC0194c, Handler handler, int i10, boolean z10) {
        a aVar = new a(interfaceC0194c);
        Object obj = this.f6991b;
        if (obj != null) {
            cc.a.j(cc.a.g(obj.getClass(), "authenticate", CryptoObject.class, CancellationSignal.class, FaceManager.AuthenticationCallback.class, Handler.class, Integer.TYPE, Boolean.TYPE), this.f6991b, null, cancellationSignal, aVar, handler, Integer.valueOf(i10), Boolean.valueOf(z10));
            e.f(f6988c, "authenticate for T");
        }
    }
}
