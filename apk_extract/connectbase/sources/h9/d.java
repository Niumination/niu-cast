package h9;

import android.app.ActionBar;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f7020c = "d";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ic.a f7021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p6.a f7022b;

    public bf.a a(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f7020c, "TranThubActionBar");
            ic.a aVar = this.f7021a;
            if (aVar != null) {
                return aVar;
            }
            ic.a aVar2 = new ic.a();
            this.f7021a = aVar2;
            return aVar2;
        }
        dc.e.f(f7020c, "TranAospActionBar");
        p6.a aVar3 = this.f7022b;
        if (aVar3 != null) {
            return aVar3;
        }
        p6.a aVar4 = new p6.a();
        this.f7022b = aVar4;
        return aVar4;
    }

    public void b(ActionBar actionBar, boolean z10) {
        a(fc.b.a.f5989i).a(actionBar, z10);
    }
}
