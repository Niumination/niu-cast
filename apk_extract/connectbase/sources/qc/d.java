package qc;

import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import com.transsion.hubsdk.content.pm.TranPackageItemInfo;

/* JADX INFO: loaded from: classes2.dex */
public class d implements jf.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranPackageItemInfo f13905a;

    public d() {
        this.f13905a = null;
        this.f13905a = new TranPackageItemInfo();
    }

    @Override // jf.d
    public CharSequence a(PackageItemInfo packageItemInfo, PackageManager packageManager, float f10, int i10) {
        return this.f13905a.loadSafeLabel(packageItemInfo, packageManager, f10, i10);
    }
}
