package nb;

import dc.e;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f11435c = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ne.a f11436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public y8.a f11437b;

    public String a(String str) {
        return c(fc.b.a.C).get(str);
    }

    public boolean b(String str, boolean z10) {
        return c(fc.b.a.C).a(str, z10);
    }

    public hh.a c(String str) {
        if (fc.b.b(str)) {
            ne.a aVar = this.f11436a;
            if (aVar != null) {
                return aVar;
            }
            ne.a aVar2 = new ne.a();
            this.f11436a = aVar2;
            return aVar2;
        }
        e.f(f11435c, "TranAospAppProperties");
        y8.a aVar3 = this.f11437b;
        if (aVar3 != null) {
            return aVar3;
        }
        y8.a aVar4 = new y8.a();
        this.f11437b = aVar4;
        return aVar4;
    }

    public void d(String str) {
        c(fc.b.a.C).b(str);
    }
}
