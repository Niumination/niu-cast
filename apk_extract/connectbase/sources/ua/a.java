package ua;

import dc.e;
import fc.b;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f16241c = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ud.a f16242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d8.a f16243b;

    public String a() {
        return b(b.a.f5999s).a();
    }

    public og.a b(String str) {
        if (b.b(str)) {
            e.f(f16241c, "TranOemUnlockDataManager");
            ud.a aVar = this.f16242a;
            if (aVar != null) {
                return aVar;
            }
            ud.a aVar2 = new ud.a();
            this.f16242a = aVar2;
            return aVar2;
        }
        e.f(f16241c, "TranAospOemUnlockDataManager");
        d8.a aVar3 = this.f16243b;
        if (aVar3 != null) {
            return aVar3;
        }
        d8.a aVar4 = new d8.a();
        this.f16243b = aVar4;
        return aVar4;
    }

    public int c(int i10, byte[] bArr) {
        return b(b.a.f5999s).b(i10, bArr);
    }
}
