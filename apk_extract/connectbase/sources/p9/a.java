package p9;

import android.content.pm.ActivityInfo;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f13031c = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public qc.a f13032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public x6.a f13033b;

    public jf.a a(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f13031c, "TranThubActivityInfo");
            qc.a aVar = this.f13032a;
            if (aVar != null) {
                return aVar;
            }
            qc.a aVar2 = new qc.a();
            this.f13032a = aVar2;
            return aVar2;
        }
        dc.e.f(f13031c, "TranAospActivityInfo");
        x6.a aVar3 = this.f13033b;
        if (aVar3 != null) {
            return aVar3;
        }
        x6.a aVar4 = new x6.a();
        this.f13033b = aVar4;
        return aVar4;
    }

    public boolean b(int i10) {
        return a(fc.b.a.f5985e).b(i10);
    }

    public int c(ActivityInfo activityInfo) {
        if (activityInfo != null) {
            return a(fc.b.a.f5985e).a(activityInfo);
        }
        throw new IllegalArgumentException("info cannot be null");
    }
}
