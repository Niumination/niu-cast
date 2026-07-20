package p9;

import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f13041c = "d";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public qc.d f13042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public x6.d f13043b;

    public jf.d a(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f13041c, "TranThubPackageItemInfo");
            qc.d dVar = this.f13042a;
            if (dVar != null) {
                return dVar;
            }
            qc.d dVar2 = new qc.d();
            this.f13042a = dVar2;
            return dVar2;
        }
        dc.e.f(f13041c, "TranAospPackageItemInfo");
        x6.d dVar3 = this.f13043b;
        if (dVar3 != null) {
            return dVar3;
        }
        x6.d dVar4 = new x6.d();
        this.f13043b = dVar4;
        return dVar4;
    }

    public CharSequence b(PackageItemInfo packageItemInfo, PackageManager packageManager, float f10, int i10) {
        return a(fc.b.a.f5987g).a(packageItemInfo, packageManager, f10, i10);
    }
}
