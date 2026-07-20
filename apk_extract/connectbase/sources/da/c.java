package da;

import android.os.Bundle;
import android.os.IBinder;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f3638c = "c";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ed.d f3639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public m7.e f3640b;

    public interface a {
        void a();

        void onShown();
    }

    public xf.b a(String str) {
        if (fc.b.b(str)) {
            ed.d dVar = this.f3639a;
            if (dVar != null) {
                return dVar;
            }
            ed.d dVar2 = new ed.d();
            this.f3639a = dVar2;
            return dVar2;
        }
        m7.e eVar = this.f3640b;
        if (eVar != null) {
            return eVar;
        }
        m7.e eVar2 = new m7.e();
        this.f3640b = eVar2;
        return eVar2;
    }

    @Deprecated
    public boolean b(Bundle bundle, int i10, a aVar, IBinder iBinder) {
        return c(bundle, i10, aVar, iBinder);
    }

    public boolean c(Bundle bundle, int i10, a aVar, IBinder iBinder) {
        return a(fc.b.a.f5988h).b(bundle, i10, aVar, iBinder);
    }
}
