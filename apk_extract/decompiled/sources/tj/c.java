package tj;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.Log;
import com.transsion.message.cast.transfer.TransferServiceImpl;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile c f10239j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p f10240a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public v f10241b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public s f10242c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public j f10243d;
    public Context f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f10244g;
    public final CopyOnWriteArrayList e = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f10245h = new a(this);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f10246i = new b(this);

    public static void a(c cVar, boolean z2) {
        for (xc.a aVar : cVar.e) {
            try {
                TransferServiceImpl.initialize$lambda$0(aVar.f10915a, aVar.f10916b, z2);
            } catch (Exception e) {
                Log.e("AIotSDK", "notifyConnectListeners error", e);
            }
        }
    }

    public final void b() {
        Log.d("AIotSDK", "bindService.");
        Intent intent = new Intent("com.transsion.aiot.mulcollaboration.MulCooperateService");
        String str = "com.transsion.aiot.mulcollaboration";
        try {
            this.f.getPackageManager().getPackageInfo("com.transsion.aiot.mulcollaboration", 1);
            Log.d("AIotSDK", "Primary package found: com.transsion.aiot.mulcollaboration");
        } catch (PackageManager.NameNotFoundException unused) {
            Log.d("AIotSDK", "Primary package not found, using fallback: com.transsion.iotservice");
            str = "com.transsion.iotservice";
        }
        intent.setPackage(str);
        Log.d("AIotSDK", "Binding to package: ".concat(str));
        this.f.bindService(intent, this.f10246i, 1);
    }

    public final void c(Context context, xc.a aVar) {
        if (context == null) {
            Log.w("AIotSDK", "init called with null context, ignore");
            return;
        }
        if (this.f == null) {
            this.f = context.getApplicationContext();
        }
        CopyOnWriteArrayList copyOnWriteArrayList = this.e;
        if (!copyOnWriteArrayList.contains(aVar)) {
            copyOnWriteArrayList.add(aVar);
            Log.d("AIotSDK", "Listener registered, total listeners: " + copyOnWriteArrayList.size());
        }
        if (this.f10240a == null) {
            b();
        } else if (this.f10244g) {
            TransferServiceImpl.initialize$lambda$0(aVar.f10915a, aVar.f10916b, true);
        }
    }
}
