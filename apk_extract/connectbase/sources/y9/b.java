package y9;

import android.os.CancellationSignal;
import android.os.Handler;
import dc.e;
import zc.d;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f20772c = "b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f20773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h7.b f20774b;

    public interface a {
        void a(int i10, CharSequence charSequence);

        void b(int i10);

        void c(int i10, CharSequence charSequence);

        void d();

        void e(String str);
    }

    public void a(CancellationSignal cancellationSignal, a aVar, Handler handler, int i10, boolean z10) {
        b(fc.b.a.f5993m).b(cancellationSignal, aVar, handler, i10, z10);
    }

    public sf.b b(String str) {
        if (fc.b.b(str)) {
            e.f(f20772c, "TranThubFaceManager");
            d dVar = this.f20773a;
            if (dVar != null) {
                return dVar;
            }
            d dVar2 = new d();
            this.f20773a = dVar2;
            return dVar2;
        }
        e.f(f20772c, "TranAospFaceManager");
        h7.b bVar = this.f20774b;
        if (bVar != null) {
            return bVar;
        }
        h7.b bVar2 = new h7.b();
        this.f20774b = bVar2;
        return bVar2;
    }

    public boolean c() {
        return b(fc.b.a.f5993m).a();
    }
}
