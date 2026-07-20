package qb;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f13887c = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public qe.a f13888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a9.a f13889b;

    public kh.a a(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f13887c, "TranThubFeatureFlagUtils");
            qe.a aVar = this.f13888a;
            if (aVar != null) {
                return aVar;
            }
            qe.a aVar2 = new qe.a();
            this.f13888a = aVar2;
            return aVar2;
        }
        dc.e.f(f13887c, "TranAospFeatureFlagUtils");
        a9.a aVar3 = this.f13889b;
        if (aVar3 != null) {
            return aVar3;
        }
        a9.a aVar4 = new a9.a();
        this.f13889b = aVar4;
        return aVar4;
    }

    public boolean b(Context context, String str) {
        return a(fc.b.a.f5989i).a(context, str);
    }
}
