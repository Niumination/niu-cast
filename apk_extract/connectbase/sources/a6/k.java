package a6;

import android.app.ActivityManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import com.transsion.connectx.mirror.source.SourceApplication;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f75h = "QuickActionHelper";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f76i = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f77j = "source";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f78k = "source-service";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f79l = "com.android.systemui";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f80m = "com.transsion.screenrecorder";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f81n = "com.transsion.hilauncher";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f82o = "com.transsion.screencapture.TakeScreenshotService";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f83p = "com.android.systemui.screenshot.TakeScreenshotService";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f84q = "com.android.systemui.screenrecord.ScreenRecordDialog";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f85r = "com.android.systemui.screenrecord.RecordingService";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f86s = "com.android.systemui.screenrecord.START_FROM_EXTRA";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f87t = "transsion.intent.screenrecorder.RECORDER_SERVICE";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f88u = "tran.intent.action.SPLITSCREEN_SERVICE";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f89v = "com.transsion.screencapture";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f90w = "com.transsion.ossettingsext";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f91x = "transsion.intent.action.minilauncher.MAIN";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final boolean f92y = m4.a.C0275a.f10375a.E("ro.tr_screenshot.support", "ro.os_supershot_apk", hi.b.f7118g).equals("1");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AudioManager f93a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ServiceConnection f94b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Application f95c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public rj.a f96d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public IBinder f97e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f98f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ServiceConnection f99g;

    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            k4.m.e(k.f75h, "startSplitScreenService onServiceConnected");
            k.this.f96d = rj.a.b.O(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            k4.m.e(k.f75h, "SplitScreenService onServiceDisconnected");
            k.this.f96d = null;
            k.this.l();
        }
    }

    public class b implements ServiceConnection {

        public class a extends Handler {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ServiceConnection f102a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Looper looper, ServiceConnection serviceConnection) {
                super(looper);
                this.f102a = serviceConnection;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                synchronized (k.this.f98f) {
                    try {
                        if (k.this.f94b == this.f102a) {
                            k4.m.e(k.f75h, "handleMessage finish");
                            k kVar = k.this;
                            kVar.f95c.unbindService(kVar.f94b);
                            k.this.f94b = null;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        }

        public b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            k4.m.e(k.f75h, "on screen shot Service Connected" + componentName);
            synchronized (k.this.f98f) {
                k.this.f97e = iBinder;
                Messenger messenger = new Messenger(iBinder);
                Message messageObtain = Message.obtain((Handler) null, 1);
                messageObtain.replyTo = new Messenger(new a(Looper.getMainLooper(), this));
                messageObtain.arg1 = 1;
                messageObtain.arg2 = 1;
                Bundle bundle = new Bundle();
                bundle.putString("source", k.f78k);
                messageObtain.obj = bundle;
                try {
                    messenger.send(messageObtain);
                } catch (RemoteException e10) {
                    e10.printStackTrace();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (k.this.f98f) {
                try {
                    k kVar = k.this;
                    ServiceConnection serviceConnection = kVar.f94b;
                    if (serviceConnection != null) {
                        kVar.f95c.unbindService(serviceConnection);
                        k kVar2 = k.this;
                        kVar2.f94b = null;
                        kVar2.f97e = null;
                        k4.m.e(k.f75h, "onServiceDisconnected ");
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            k4.m.e(k.f75h, "on screen shot Service Disconnected" + componentName);
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k f104a = new k();
    }

    public static k j() {
        return c.f104a;
    }

    public void g() {
        this.f93a.adjustVolume(-1, 1);
    }

    public void h() {
        this.f93a.adjustVolume(-100, 1);
    }

    public void i() {
        this.f93a.adjustVolume(1, 1);
    }

    public void k() {
        m4.a.C0275a.f10375a.h(false, 1);
    }

    public void l() {
        Intent intent = new Intent(f88u);
        intent.setPackage(f79l);
        this.f95c.bindService(intent, this.f99g, 1);
    }

    public void m() {
        this.f95c.unbindService(this.f99g);
    }

    public void n() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 == 31) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(f79l, f84q));
            intent.setFlags(268435456);
            if (intent.resolveActivity(this.f95c.getPackageManager()) != null) {
                this.f95c.startActivity(intent);
                return;
            }
            return;
        }
        if (i10 == 32) {
            Intent intent2 = new Intent(f86s);
            intent2.setComponent(new ComponentName(f79l, f85r));
            intent2.setFlags(268435456);
            this.f95c.startForegroundService(intent2);
        }
        Intent intent3 = new Intent(f87t);
        intent3.putExtra("start_source ", f78k);
        intent3.setPackage(f80m);
        this.f95c.startForegroundService(intent3);
    }

    public void o() {
        ComponentName componentName;
        if (this.f94b != null) {
            if (this.f97e != null) {
                try {
                    new Messenger(this.f97e).send(Message.obtain((Handler) null, 1));
                    return;
                } catch (RemoteException e10) {
                    e10.printStackTrace();
                    return;
                }
            }
            return;
        }
        Intent intent = new Intent();
        if (f92y) {
            intent.setPackage(f89v);
            componentName = new ComponentName(f89v, f82o);
        } else {
            intent.setPackage(f79l);
            componentName = new ComponentName(f79l, f83p);
        }
        intent.setComponent(componentName);
        b bVar = new b();
        if (this.f95c.bindServiceAsUser(intent, bVar, 1, Process.myUserHandle())) {
            this.f94b = bVar;
        }
    }

    public void p(int i10) {
        if (!m4.a.C0275a.f10375a.d()) {
            k4.m.e(f75h, "current is not in Split Screen");
            return;
        }
        rj.a aVar = this.f96d;
        if (aVar == null) {
            k4.m.e(f75h, "mBinder == null");
            return;
        }
        try {
            List<String> listG = aVar.G();
            if (listG != null && listG.size() > 1) {
                this.f96d.A(Integer.parseInt(listG.get(i10).split(ks.g.f9491d)[1]));
                return;
            }
            k4.m.e(f75h, "terminateSplitWindow screenInfo unusual");
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    public void q() {
        if (this.f96d == null) {
            k4.m.e(f75h, "mBinder == null");
            return;
        }
        if (m4.a.C0275a.f10375a.E("ro.tr_splitscreen.snapmode.feature.support", "ro.tran_split_screen_snap_mode.support", hi.b.f7118g).equals(hi.b.f7118g)) {
            k4.m.c(f75h, "startSplitWindow is not support");
            return;
        }
        List<ActivityManager.RunningTaskInfo> listA = k4.a.a(SourceApplication.b());
        if (listA == null) {
            k4.m.e(f75h, "startSplitWindow runningTaskInfoList is null");
            return;
        }
        String packageName = listA.get(0).topActivity.getPackageName();
        if (TextUtils.equals(f81n, packageName)) {
            k4.m.e(f75h, "current top activity is desktop ");
            return;
        }
        if (k4.a.d(SourceApplication.f1881c, packageName)) {
            k4.m.e(f75h, "topActivityPackageName:  " + packageName + " is not Support SplitScreenMultiWindow");
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setPackage(f90w);
            intent.setAction(f91x);
            intent.setFlags(1342177280);
            this.f96d.r(PendingIntent.getActivity(this.f95c, 0, intent, 33554432), new Intent(), listA.get(0).taskId, null, null, 1, 0.5f);
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    public k() {
        this.f94b = null;
        this.f98f = new Object();
        this.f99g = new a();
        Application applicationB = SourceApplication.b();
        this.f95c = applicationB;
        this.f93a = (AudioManager) applicationB.getSystemService("audio");
    }
}
