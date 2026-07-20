package kb;

import dc.e;
import fc.b;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f9166c = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ke.a f9167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public u8.a f9168b;

    public eh.a a(String str) {
        if (b.b(str)) {
            e.f(f9166c, "TranThubImsFeature");
            ke.a aVar = this.f9167a;
            if (aVar != null) {
                return aVar;
            }
            ke.a aVar2 = new ke.a();
            this.f9167a = aVar2;
            return aVar2;
        }
        e.f(f9166c, "TranAospImsFeature");
        u8.a aVar3 = this.f9168b;
        if (aVar3 != null) {
            return aVar3;
        }
        u8.a aVar4 = new u8.a();
        this.f9168b = aVar4;
        return aVar4;
    }

    public boolean b(Object obj, int i10) {
        if (obj != null) {
            return a(b.a.f6001u).a(obj, i10);
        }
        throw new IllegalArgumentException("capabilities is null");
    }
}
