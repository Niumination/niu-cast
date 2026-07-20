package ha;

import android.os.Handler;
import id.b;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f7097c = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f7098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public q7.a f7099b;

    @yb.a(level = 0)
    public Handler a() {
        return b(fc.b.a.f5982b).getHandler();
    }

    public bg.a b(String str) {
        if (fc.b.b(str)) {
            b bVar = this.f7098a;
            if (bVar != null) {
                return bVar;
            }
            b bVar2 = new b();
            this.f7098a = bVar2;
            return bVar2;
        }
        q7.a aVar = this.f7099b;
        if (aVar != null) {
            return aVar;
        }
        q7.a aVar2 = new q7.a();
        this.f7099b = aVar2;
        return aVar2;
    }
}
