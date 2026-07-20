package u2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.StrictMode;
import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class s implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f10362a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10363b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f10364c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public IBinder f10365d;
    public final r e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ComponentName f10366h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ u f10367i;

    public s(u uVar, r rVar) {
        this.f10367i = uVar;
        this.e = rVar;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0062 A[Catch: all -> 0x0079, TryCatch #1 {all -> 0x0079, blocks: (B:3:0x0017, B:11:0x005a, B:12:0x005e, B:14:0x0062, B:17:0x007b, B:18:0x007e, B:6:0x0031, B:7:0x003a, B:10:0x0052), top: B:27:0x0017 }] */
    /* JADX WARN: Code duplicated, block: B:17:0x007b A[Catch: all -> 0x0079, TRY_LEAVE, TryCatch #1 {all -> 0x0079, blocks: (B:3:0x0017, B:11:0x005a, B:12:0x005e, B:14:0x0062, B:17:0x007b, B:18:0x007e, B:6:0x0031, B:7:0x003a, B:10:0x0052), top: B:27:0x0017 }] */
    public final void a(String str) {
        boolean zBindService;
        this.f10363b = 3;
        StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder(vmPolicy).permitUnsafeIntentLaunch().build());
        try {
            u uVar = this.f10367i;
            c3.a aVar = uVar.f10375d;
            Context context = uVar.f10373b;
            Intent intentA = this.e.a(context);
            int i8 = this.e.f10360c;
            aVar.getClass();
            ComponentName component = intentA.getComponent();
            if (component != null) {
                String packageName = component.getPackageName();
                "com.google.android.gms".equals(packageName);
                try {
                    zBindService = false;
                    if ((((Context) e3.a.a(context).f8405a).getPackageManager().getApplicationInfo(packageName, 0).flags & 2097152) != 0) {
                        Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                }
                this.f10364c = zBindService;
                if (zBindService) {
                    this.f10367i.f10374c.sendMessageDelayed(this.f10367i.f10374c.obtainMessage(1, this.e), this.f10367i.f);
                } else {
                    this.f10363b = 2;
                    try {
                        u uVar2 = this.f10367i;
                        uVar2.f10375d.a(uVar2.f10373b, this);
                    } catch (IllegalArgumentException unused2) {
                    }
                }
            }
            zBindService = context.bindService(intentA, this, i8);
            this.f10364c = zBindService;
            if (zBindService) {
                this.f10367i.f10374c.sendMessageDelayed(this.f10367i.f10374c.obtainMessage(1, this.e), this.f10367i.f);
            } else {
                this.f10363b = 2;
                u uVar3 = this.f10367i;
                uVar3.f10375d.a(uVar3.f10373b, this);
            }
        } finally {
            StrictMode.setVmPolicy(vmPolicy);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f10367i.f10372a) {
            try {
                this.f10367i.f10374c.removeMessages(1, this.e);
                this.f10365d = iBinder;
                this.f10366h = componentName;
                Iterator it = this.f10362a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceConnected(componentName, iBinder);
                }
                this.f10363b = 1;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f10367i.f10372a) {
            try {
                this.f10367i.f10374c.removeMessages(1, this.e);
                this.f10365d = null;
                this.f10366h = componentName;
                Iterator it = this.f10362a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceDisconnected(componentName);
                }
                this.f10363b = 2;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
