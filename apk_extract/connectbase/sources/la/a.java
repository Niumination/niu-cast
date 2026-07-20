package la;

import android.content.Context;
import dc.e;
import fc.b;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f9752c = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ld.a f9753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public u7.a f9754b;

    public fg.a a(String str) {
        if (b.b(str)) {
            e.f(f9752c, "TranThubRotationPolicy");
            ld.a aVar = this.f9753a;
            if (aVar != null) {
                return aVar;
            }
            ld.a aVar2 = new ld.a();
            this.f9753a = aVar2;
            return aVar2;
        }
        e.f(f9752c, "TranAospRotationPolicy");
        u7.a aVar3 = this.f9754b;
        if (aVar3 != null) {
            return aVar3;
        }
        u7.a aVar4 = new u7.a();
        this.f9754b = aVar4;
        return aVar4;
    }

    public boolean b(Context context) {
        return a(b.a.f5988h).a(context);
    }
}
