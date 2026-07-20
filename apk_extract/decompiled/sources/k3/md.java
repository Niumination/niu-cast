package k3;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.Looper;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class md {
    public static se.e a(Context context) throws PackageManager.NameNotFoundException, IOException {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot be called from the main thread");
        }
        context.getPackageManager().getPackageInfo("com.android.vending", 0);
        g8.b bVar = new g8.b(1);
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (context.bindService(intent, bVar, 1)) {
            try {
                try {
                    IBinder iBinderA = bVar.a();
                    if (iBinderA != null) {
                        g8.c cVar = new g8.c(1);
                        cVar.f5120c = iBinderA;
                        String strE = cVar.e();
                        cVar.g();
                        se.e eVar = new se.e(strE, 19);
                        context.unbindService(bVar);
                        return eVar;
                    }
                    context.unbindService(bVar);
                } catch (Exception e) {
                    throw e;
                }
            } catch (Throwable th2) {
                context.unbindService(bVar);
                throw th2;
            }
            context.unbindService(bVar);
            throw th2;
        }
        throw new IOException("Google Play connection failed");
    }
}
