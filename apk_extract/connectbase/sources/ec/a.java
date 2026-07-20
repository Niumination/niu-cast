package ec;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Bundle;
import android.os.RemoteException;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.util.TranSignUtils;
import com.transsion.hubsdk.verifykey.ITranVerifyKeyManager;
import dc.e;
import fc.b;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f4243a = "a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f4244b = -8;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static ITranVerifyKeyManager f4245c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Binder f4246d = new Binder();

    public static ITranVerifyKeyManager a(String str) {
        if (b.b(str) && f4245c == null) {
            f4245c = ITranVerifyKeyManager.Stub.asInterface(TranServiceManager.getServiceIBinder("verify_key"));
        }
        return f4245c;
    }

    public static void b(ITranVerifyKeyManager iTranVerifyKeyManager) {
        f4245c = iTranVerifyKeyManager;
    }

    public static int c(Context context) {
        if (a(b.a.f5981a) == null || context == null) {
            String str = f4243a;
            StringBuilder sb2 = new StringBuilder("service or context is null ");
            sb2.append(f4245c == null);
            e.n(str, sb2.toString());
            return -8;
        }
        String packageName = context.getPackageName();
        String certSHA1 = TranSignUtils.getCertSHA1(context);
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(packageName, 128).metaData;
            if (bundle != null) {
                return f4245c.verify(f4246d, bundle.getString("com.transsion.appkey"), packageName, certSHA1);
            }
            e.n(f4243a, "AppKey is null");
            return f4245c.verify(f4246d, (String) null, packageName, certSHA1);
        } catch (PackageManager.NameNotFoundException | RemoteException e10) {
            e.c(f4243a, "TranVerifyKeyManager verify Exception:" + e10);
            return -8;
        }
    }
}
