package na;

import android.os.UserHandle;
import dc.e;
import nd.b;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f11431c = "a";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f11432d = "package name should not be null";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f11433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public w7.a f11434b;

    public hg.a a(String str) {
        if (fc.b.b(str)) {
            e.f(f11431c, "TranThubLocationManager");
            b bVar = this.f11433a;
            if (bVar != null) {
                return bVar;
            }
            b bVar2 = new b();
            this.f11433a = bVar2;
            return bVar2;
        }
        e.f(f11431c, "TranAospLocationManager");
        w7.a aVar = this.f11434b;
        if (aVar != null) {
            return aVar;
        }
        w7.a aVar2 = new w7.a();
        this.f11434b = aVar2;
        return aVar2;
    }

    @yb.a(level = 2)
    public void b(boolean z10, UserHandle userHandle) {
        a(fc.b.a.f5989i).a(z10, userHandle);
    }
}
