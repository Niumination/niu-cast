package ya;

import dc.e;
import yd.b;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f20775c = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f20776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h8.a f20777b;

    public int a() {
        return b(fc.b.a.f5992l).a();
    }

    public sg.a b(String str) {
        if (fc.b.b(str)) {
            e.f(f20775c, "TranThubPersistentDataBlockManager");
            b bVar = this.f20776a;
            if (bVar != null) {
                return bVar;
            }
            b bVar2 = new b();
            this.f20776a = bVar2;
            return bVar2;
        }
        e.f(f20775c, "TranAospPersistentDataBlockManager");
        h8.a aVar = this.f20777b;
        if (aVar != null) {
            return aVar;
        }
        h8.a aVar2 = new h8.a();
        this.f20777b = aVar2;
        return aVar2;
    }
}
