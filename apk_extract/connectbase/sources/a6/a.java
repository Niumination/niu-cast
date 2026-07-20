package a6;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.transsion.connectx.mirror.source.SourceApplication;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<z4.a> f55a;

    /* JADX INFO: renamed from: a6.a$a, reason: collision with other inner class name */
    public static class C0002a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f56a = new a();
    }

    public static a c() {
        return C0002a.f56a;
    }

    public final Boolean a(String str, PackageManager packageManager) {
        return Boolean.valueOf(packageManager.getLaunchIntentForPackage(str) == null);
    }

    public ArrayList<z4.a> b() {
        return this.f55a;
    }

    public a() {
        this.f55a = new ArrayList<>();
        PackageManager packageManager = SourceApplication.b().getPackageManager();
        for (ApplicationInfo applicationInfo : packageManager.getInstalledApplications(8192)) {
            if (!a(applicationInfo.packageName, packageManager).booleanValue()) {
                this.f55a.add(new z4.a(applicationInfo.loadLabel(packageManager).toString(), applicationInfo.packageName, applicationInfo.loadIcon(packageManager)));
            }
        }
    }
}
