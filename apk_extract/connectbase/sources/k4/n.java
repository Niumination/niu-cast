package k4;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes2.dex */
public class n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f8968b = "PackageUtils";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile n f8969c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PackageManager f8970a;

    public n(Context context) {
        this.f8970a = context.getPackageManager();
    }

    public static n c(Context context) {
        if (f8969c == null) {
            synchronized (n.class) {
                try {
                    if (f8969c == null) {
                        f8969c = new n(context);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f8969c;
    }

    public Drawable a(String str) {
        PackageManager packageManager = this.f8970a;
        if (packageManager == null) {
            return null;
        }
        try {
            return packageManager.getApplicationInfo(str, 0).loadIcon(this.f8970a);
        } catch (PackageManager.NameNotFoundException e10) {
            m.d(f8968b, e10);
            return null;
        }
    }

    public String b(String str) {
        PackageManager packageManager = this.f8970a;
        if (packageManager == null) {
            return "";
        }
        try {
            return packageManager.getApplicationInfo(str, 0).loadLabel(this.f8970a).toString();
        } catch (PackageManager.NameNotFoundException e10) {
            m.d(f8968b, e10);
            return "";
        }
    }
}
