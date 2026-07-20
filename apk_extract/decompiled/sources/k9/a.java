package k9;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Bundle;
import android.os.RemoteException;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.util.TranSignUtils;
import com.transsion.hubsdk.verifykey.ITranVerifyKeyManager;
import l9.b;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ITranVerifyKeyManager f6805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Binder f6806b = new Binder();

    public static ITranVerifyKeyManager a() {
        if (b.a(l9.a.f7342a) && f6805a == null) {
            f6805a = ITranVerifyKeyManager.Stub.asInterface(TranServiceManager.getServiceIBinder("verify_key"));
        }
        return f6805a;
    }

    public static void b(Context context) {
        String str = l9.a.f7342a;
        if (a() == null || context == null) {
            StringBuilder sb2 = new StringBuilder("service or context is null ");
            sb2.append(f6805a == null);
            j9.a.d(sb2.toString());
            return;
        }
        String packageName = context.getPackageName();
        String certSHA1 = TranSignUtils.getCertSHA1(context);
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(packageName, 128).metaData;
            Binder binder = f6806b;
            if (bundle != null) {
                f6805a.verify(binder, bundle.getString("com.transsion.appkey"), packageName, certSHA1);
            } else {
                j9.a.d("AppKey is null");
                f6805a.verify(binder, (String) null, packageName, certSHA1);
            }
        } catch (PackageManager.NameNotFoundException | RemoteException e) {
            j9.a.b("a", "TranVerifyKeyManager verify Exception:" + e);
        }
    }
}
