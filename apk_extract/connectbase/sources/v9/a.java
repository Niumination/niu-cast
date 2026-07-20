package v9;

import dc.e;
import wc.b;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f16689c = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f16690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e7.a f16691b;

    public pf.a a(String str) {
        if (fc.b.b(str)) {
            e.f(f16689c, "TranThubCameraManager");
            b bVar = this.f16690a;
            if (bVar != null) {
                return bVar;
            }
            b bVar2 = new b();
            this.f16690a = bVar2;
            return bVar2;
        }
        e.f(f16689c, "TranAospCameraManager");
        e7.a aVar = this.f16691b;
        if (aVar != null) {
            return aVar;
        }
        e7.a aVar2 = new e7.a();
        this.f16691b = aVar2;
        return aVar2;
    }

    @yb.a(level = 1)
    public void b(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("cameraId was null");
        }
        if (str2 == null) {
            throw new IllegalArgumentException("customKey was null");
        }
        a(fc.b.a.f5988h).a(str, str2);
    }
}
