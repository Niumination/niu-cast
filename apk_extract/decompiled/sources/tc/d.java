package tc;

import android.app.Application;
import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import android.widget.RemoteViews;
import bb.s;
import com.transsion.iotservice.multiscreen.pc.R$id;
import com.transsion.iotservice.multiscreen.pc.R$string;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import k3.gc;
import k3.v8;
import k3.xb;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import m3.j;
import na.k;
import ze.r1;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements fb.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile d f10208c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f10209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f10210b;

    public d(String str, String str2) {
        Object[] objArr = {str, 23};
        if (!(str.length() <= 23)) {
            throw new IllegalArgumentException(String.format("tag \"%s\" is longer than the %d character maximum", objArr));
        }
        this.f10209a = str;
        if (str2 == null || str2.length() <= 0) {
            this.f10210b = null;
        } else {
            this.f10210b = str2;
        }
    }

    public static d h() {
        if (f10208c == null) {
            synchronized (d.class) {
                try {
                    if (f10208c == null) {
                        f10208c = new d();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f10208c;
    }

    @Override // fb.a
    public void a(int i8) {
        Lazy lazy = (Lazy) this.f10210b;
        if (i8 == 3) {
            k.f8141a.c((Application) lazy.getValue(), R$string.module_pc_swift_send_success);
        } else {
            if (i8 != 5) {
                return;
            }
            k.f8141a.c((Application) lazy.getValue(), R$string.module_pc_swift_copy_success);
        }
    }

    @Override // fb.a
    public void b(boolean z2) {
        hb.a aVar = (hb.a) ((Lazy) this.f10209a).getValue();
        aVar.getClass();
        String strN = o.d.n("closeNotification, thread: ", Thread.currentThread().getName(), "TransferNotification", "tag", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("TransferNotification"), strN);
        }
        aVar.f5276a.cancel(1);
        aVar.f5278c = null;
        aVar.f5277b = null;
    }

    @Override // fb.a
    public void c(Application context, int i8, int i9, int i10) {
        Intrinsics.checkNotNullParameter(context, "context");
        hb.a aVar = (hb.a) ((Lazy) this.f10209a).getValue();
        aVar.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        aVar.a(context, 100);
        aVar.b(context, i10);
        RemoteViews remoteViews = aVar.f5277b;
        if (remoteViews != null) {
            remoteViews.setTextViewText(R$id.progress_number, xb.a(i8, i9));
        }
        RemoteViews remoteViews2 = aVar.f5277b;
        if (remoteViews2 != null) {
            remoteViews2.setProgressBar(R$id.notification_pBar, 100, 100, false);
        }
        RemoteViews remoteViews3 = aVar.f5277b;
        if (remoteViews3 != null) {
            remoteViews3.setTextViewText(R$id.progress_percent, xb.b(100));
        }
        String strN = o.d.n("updateTaskProgress, thread: ", Thread.currentThread().getName(), "TransferNotification", "tag", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("TransferNotification"), strN);
        }
        aVar.f5276a.notify(1, aVar.f5278c);
    }

    @Override // fb.a
    public void d(Application context, int i8, int i9, int i10, int i11) {
        Intrinsics.checkNotNullParameter(context, "context");
        hb.a aVar = (hb.a) ((Lazy) this.f10209a).getValue();
        aVar.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        aVar.a(context, i8);
        aVar.b(context, i9);
        RemoteViews remoteViews = aVar.f5277b;
        if (remoteViews != null) {
            remoteViews.setTextViewText(R$id.progress_number, xb.a(i10, i11));
        }
        RemoteViews remoteViews2 = aVar.f5277b;
        if (remoteViews2 != null) {
            remoteViews2.setProgressBar(R$id.notification_pBar, 100, i8, false);
        }
        RemoteViews remoteViews3 = aVar.f5277b;
        if (remoteViews3 != null) {
            remoteViews3.setTextViewText(R$id.progress_percent, xb.b(i8));
        }
        String strN = o.d.n("updateProgress, thread: ", Thread.currentThread().getName(), "TransferNotification", "tag", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("TransferNotification"), strN);
        }
        aVar.f5276a.notify(1, aVar.f5278c);
    }

    @Override // fb.a
    public void e() {
        Lazy lazy = (Lazy) this.f10210b;
        String string = ((Application) lazy.getValue()).getResources().getString(R$string.module_pc_file_transfer_fail);
        k kVar = k.f8141a;
        Application application = (Application) lazy.getValue();
        Intrinsics.checkNotNull(string);
        kVar.d(application, string);
    }

    public void f(r1 r1Var) {
        ArrayList arrayList = (ArrayList) this.f10210b;
        v8.i(r1Var, "method");
        arrayList.add(r1Var);
    }

    public void g() {
        if (!k()) {
            vc.a.b("KolunScannerManager", "mKolunScanner is dead");
            return;
        }
        if (i().isEmpty()) {
            vc.a.b("KolunScannerManager", "mContext is null");
            return;
        }
        try {
            ((a) ((c) this.f10209a)).e(i());
        } catch (RemoteException e) {
            vc.a.a(5, "KolunScannerManager", "enableBluetooth,err:", e);
        }
    }

    public String i() {
        WeakReference weakReference = (WeakReference) this.f10210b;
        return (weakReference == null || weakReference.get() == null) ? "" : ((Context) ((WeakReference) this.f10210b).get()).getPackageName();
    }

    public void j(Context context) {
        IBinder iBinderE;
        rc.c cVar;
        this.f10210b = new WeakReference(context);
        if (!(j.a() != null)) {
            vc.a.b("KolunScannerManager", "Kolun System Service not exists");
            return;
        }
        if (k()) {
            vc.a.b("KolunScannerManager", "IKolunScanner already init");
            return;
        }
        try {
            if (context == null) {
                throw new IllegalArgumentException("context is NonNull");
            }
            Context applicationContext = context.getApplicationContext();
            c cVar2 = null;
            try {
                IBinder iBinderA = j.a();
                if (iBinderA == null) {
                    cVar = null;
                } else {
                    int i8 = rc.b.f9393b;
                    IInterface iInterfaceQueryLocalInterface = iBinderA.queryLocalInterface("com.transsion.kolun.IKolunCore");
                    if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof rc.c)) {
                        rc.a aVar = new rc.a();
                        aVar.f9392b = iBinderA;
                        cVar = aVar;
                    } else {
                        cVar = (rc.c) iInterfaceQueryLocalInterface;
                    }
                }
                iBinderE = ((rc.a) cVar).e(applicationContext.getPackageName());
            } catch (RemoteException | NullPointerException e) {
                vc.a.b("Kolun", "service is not ready or feature not supported " + e);
                iBinderE = null;
            }
            int i9 = b.f10207b;
            if (iBinderE != null) {
                IInterface iInterfaceQueryLocalInterface2 = iBinderE.queryLocalInterface("com.transsion.kolun.kolunscanner.IKolunScanner");
                if (iInterfaceQueryLocalInterface2 == null || !(iInterfaceQueryLocalInterface2 instanceof c)) {
                    a aVar2 = new a();
                    aVar2.f10206b = iBinderE;
                    cVar2 = aVar2;
                } else {
                    cVar2 = (c) iInterfaceQueryLocalInterface2;
                }
            }
            this.f10209a = cVar2;
            vc.a.b("KolunScannerManager", "initKolunScanner init IKolunScanner ");
        } catch (Exception e4) {
            vc.a.b("KolunScannerManager", "initKolunScanner,err:" + e4.toString());
        }
    }

    public boolean k() {
        c cVar = (c) this.f10209a;
        if (cVar == null) {
            vc.a.b("KolunScannerManager", "mKolunScanner is null");
            return false;
        }
        if (((a) cVar).f10206b.isBinderAlive()) {
            c cVar2 = (c) this.f10209a;
            return cVar2 != null && ((a) cVar2).f10206b.isBinderAlive();
        }
        vc.a.b("KolunScannerManager", "mKolunScanner is binder dead");
        return false;
    }

    public String l(String str) {
        String str2 = (String) this.f10210b;
        return str2 == null ? str : str2.concat(str);
    }

    public d(int i8) {
        switch (i8) {
            case 2:
                this.f10209a = LazyKt.lazy(new s(14));
                this.f10210b = LazyKt.lazy(new s(15));
                break;
            default:
                this.f10209a = new ArrayList();
                this.f10210b = new ArrayList();
                break;
        }
    }
}
