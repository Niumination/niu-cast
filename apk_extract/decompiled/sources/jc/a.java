package jc;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.util.Log;
import com.transsion.iotservice.physicalconnect.receiver.usb.UsbStateManager$mUsbStateReceiver$1;
import com.transsion.iotservice.physicalconnect.receiver.usb.UsbStateManager$mUsbTetheringReceiver$1;
import com.transsion.iotservice.physicalconnect.receiver.usb.UsbTetheringReceiver;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import jc.a;
import k3.gc;
import k3.pb;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import o.d;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f6148c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final sj.a f6146a = new sj.a(5);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Application f6147b = pb.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentLinkedQueue f6149d = new ConcurrentLinkedQueue();
    public static final UsbStateManager$mUsbStateReceiver$1 e = new BroadcastReceiver() { // from class: com.transsion.iotservice.physicalconnect.receiver.usb.UsbStateManager$mUsbStateReceiver$1
        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (Intrinsics.areEqual("android.hardware.usb.action.USB_STATE", intent != null ? intent.getAction() : null)) {
                boolean booleanExtra = intent.getBooleanExtra("connected", false);
                gc.b("UsbStateManager", "usb state: " + booleanExtra);
                if (booleanExtra) {
                    return;
                }
                gc.c("UsbStateManager", "usb plug out.");
                Iterator it = a.f6149d.iterator();
                while (it.hasNext()) {
                    ((Function1) it.next()).invoke(Boolean.FALSE);
                }
            }
        }
    };
    public static final UsbStateManager$mUsbTetheringReceiver$1 f = new UsbTetheringReceiver() { // from class: com.transsion.iotservice.physicalconnect.receiver.usb.UsbStateManager$mUsbTetheringReceiver$1
        @Override // com.transsion.iotservice.physicalconnect.receiver.usb.UsbTetheringReceiver
        public final void a(boolean z2) {
            String strO = d.o("onTetheringStateChanged ", z2, "UsbStateManager", "tag", "log");
            if (gc.f6462a <= 6) {
                Log.e(gc.f6463b.concat("UsbStateManager"), strO);
            }
            Iterator it = a.f6149d.iterator();
            while (it.hasNext()) {
                ((Function1) it.next()).invoke(Boolean.valueOf(z2));
            }
        }
    };

    public static void a(Function1 tetheringCallback) {
        Application application = f6147b;
        sj.a aVar = f6146a;
        Intrinsics.checkNotNullParameter(tetheringCallback, "tetheringCallback");
        String log = "registerTetherStateListener " + tetheringCallback;
        Intrinsics.checkNotNullParameter("UsbStateManager", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 6) {
            Log.e(gc.f6463b.concat("UsbStateManager"), log);
        }
        ConcurrentLinkedQueue concurrentLinkedQueue = f6149d;
        if (!concurrentLinkedQueue.contains(tetheringCallback)) {
            concurrentLinkedQueue.add(tetheringCallback);
        }
        boolean z2 = f6148c;
        if (z2) {
            return;
        }
        String strO = d.o("registerUsbReceiver ", z2, "UsbStateManager", "tag", "log");
        if (gc.f6462a <= 6) {
            Log.e(gc.f6463b.concat("UsbStateManager"), strO);
        }
        IntentFilter intentFilter = new IntentFilter("android.hardware.usb.action.USB_STATE");
        try {
            UsbStateManager$mUsbStateReceiver$1 usbStateManager$mUsbStateReceiver$1 = e;
            UserHandle CURRENT = z8.a.f11265a;
            Intrinsics.checkNotNullExpressionValue(CURRENT, "CURRENT");
            pb.b(aVar, application, usbStateManager$mUsbStateReceiver$1, intentFilter, new Handler(Looper.getMainLooper()));
        } catch (Exception e4) {
            String log2 = "registerUsb exception:" + e4;
            Intrinsics.checkNotNullParameter("UsbStateManager", "tag");
            Intrinsics.checkNotNullParameter(log2, "log");
            if (gc.f6462a <= 6) {
                Log.e(gc.f6463b.concat("UsbStateManager"), log2);
            }
        }
        gc.b("UsbStateManager", "registerUsbTetherReceiver " + f6148c);
        try {
            IntentFilter intentFilter2 = new IntentFilter("android.net.conn.TETHER_STATE_CHANGED");
            UsbStateManager$mUsbTetheringReceiver$1 usbStateManager$mUsbTetheringReceiver$1 = f;
            UserHandle CURRENT2 = z8.a.f11265a;
            Intrinsics.checkNotNullExpressionValue(CURRENT2, "CURRENT");
            pb.b(aVar, application, usbStateManager$mUsbTetheringReceiver$1, intentFilter2, new Handler(Looper.getMainLooper()));
            gc.d("UsbStateManager", " ===registerUsbTetherReceiver===");
        } catch (Exception e10) {
            Intrinsics.checkNotNullParameter("UsbStateManager", "tag");
            Intrinsics.checkNotNullParameter(e10, "e");
            Log.e(gc.f6463b.concat("UsbStateManager"), e10.getMessage(), e10);
        }
        f6148c = true;
    }

    public static void b(Function1 tetheringCallback) {
        Intrinsics.checkNotNullParameter(tetheringCallback, "tetheringCallback");
        String log = "unregisterTetherResult " + tetheringCallback;
        Intrinsics.checkNotNullParameter("UsbStateManager", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 6) {
            Log.e(gc.f6463b.concat("UsbStateManager"), log);
        }
        ConcurrentLinkedQueue concurrentLinkedQueue = f6149d;
        if (concurrentLinkedQueue.contains(tetheringCallback)) {
            concurrentLinkedQueue.remove(tetheringCallback);
        }
    }
}
