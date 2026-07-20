package cf;

import java.net.InetSocketAddress;
import k3.v8;
import ze.e2;
import ze.h2;
import ze.i2;

/* JADX INFO: loaded from: classes3.dex */
public final class z extends i2 {
    @Override // ze.i2
    public boolean a() {
        return true;
    }

    @Override // ze.i2
    public h2 b(int i8, e2 e2Var) {
        n6.a aVar;
        int i9 = 1;
        a8.a aVar2 = y.q;
        Object obj = null;
        if (e2Var instanceof ze.j0) {
            aVar = new n6.a(i9, new n5.a(), obj);
        } else {
            String strConcat = "Unsupported credential type: ".concat(e2Var.getClass().getName());
            v8.i(strConcat, "error");
            aVar = new n6.a(i9, obj, strConcat);
        }
        String str = (String) aVar.f8123c;
        return str != null ? new h2(null, str) : new h2(new y(new InetSocketAddress(i8), (n5.a) aVar.f8122b), null);
    }

    @Override // ze.i2
    public int c() {
        return 4;
    }
}
