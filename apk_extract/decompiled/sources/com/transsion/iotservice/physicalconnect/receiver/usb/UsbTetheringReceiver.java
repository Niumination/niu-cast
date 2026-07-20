package com.transsion.iotservice.physicalconnect.receiver.usb;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import ba.a;
import i1.b;
import j3.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import k3.gc;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import o.d;
import tj.x;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/transsion/iotservice/physicalconnect/receiver/usb/UsbTetheringReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "scanconnect_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nUsbTetheringReceiver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UsbTetheringReceiver.kt\ncom/transsion/iotservice/physicalconnect/receiver/usb/UsbTetheringReceiver\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,57:1\n13402#2,2:58\n*S KotlinDebug\n*F\n+ 1 UsbTetheringReceiver.kt\ncom/transsion/iotservice/physicalconnect/receiver/usb/UsbTetheringReceiver\n*L\n37#1:58,2\n*E\n"})
public abstract class UsbTetheringReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f2908a = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f2909b = new b();

    public abstract void a(boolean z2);

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        x xVar;
        a aVar;
        q9.a aVar2;
        Intrinsics.checkNotNullParameter("UsbTetheringReceiver", "tag");
        Intrinsics.checkNotNullParameter("UsbTetheringReceiver onReceive", "log");
        int i8 = 3;
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("UsbTetheringReceiver"), "UsbTetheringReceiver onReceive");
        }
        if (Intrinsics.areEqual(intent != null ? intent.getAction() : null, "android.net.conn.TETHER_STATE_CHANGED")) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("tetherArray");
            b bVar = this.f2909b;
            bVar.getClass();
            if (l9.b.a(l9.a.f7346g)) {
                aVar2 = (q9.a) bVar.f5527a;
                if (aVar2 == null) {
                    aVar = aVar2;
                    q9.a aVar3 = new q9.a();
                    bVar.f5527a = aVar3;
                    aVar = aVar3;
                }
            } else {
                xVar = (x) bVar.f5528b;
                if (xVar == null) {
                    x xVar2 = new x();
                    Context context2 = z.f6093b;
                    if (((ConnectivityManager) xVar2.f10264a) == null) {
                        aVar = xVar;
                        xVar2.f10264a = (ConnectivityManager) context2.getSystemService("connectivity");
                    }
                    aVar = xVar;
                    bVar.f5528b = xVar2;
                    aVar = xVar2;
                }
            }
            aVar = xVar;
            aVar = aVar2;
            String[] tetherableUsbRegexs = aVar.getTetherableUsbRegexs();
            AtomicBoolean atomicBoolean = this.f2908a;
            if (stringArrayListExtra != null) {
                Iterator<String> it = stringArrayListExtra.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    String next = it.next();
                    String strN = d.n("UsbTetheringReceiver active enabled: ", next, "UsbTetheringReceiver", "tag", "log");
                    if (gc.f6462a <= i8) {
                        Log.d(gc.f6463b.concat("UsbTetheringReceiver"), strN);
                    }
                    if (tetherableUsbRegexs != null) {
                        int length = tetherableUsbRegexs.length;
                        int i9 = 0;
                        while (i9 < length) {
                            String str = tetherableUsbRegexs[i9];
                            Intrinsics.checkNotNull(next);
                            Locale locale = Locale.getDefault();
                            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
                            String lowerCase = next.toLowerCase(locale);
                            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                            Intrinsics.checkNotNull(str);
                            if (new Regex(str).matches(lowerCase)) {
                                String log = "USB interface matched ".concat(next);
                                Intrinsics.checkNotNullParameter("UsbTetheringReceiver", "tag");
                                Intrinsics.checkNotNullParameter(log, "log");
                                if (gc.f6462a <= 4) {
                                    Log.i(gc.f6463b.concat("UsbTetheringReceiver"), log);
                                }
                                atomicBoolean.compareAndSet(false, true);
                                a(true);
                                return;
                            }
                            i9++;
                            i8 = 3;
                        }
                    }
                }
            }
            if (atomicBoolean.compareAndSet(true, false)) {
                Intrinsics.checkNotNullParameter("UsbTetheringReceiver", "tag");
                Intrinsics.checkNotNullParameter("UsbTethering disconnect", "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("UsbTetheringReceiver"), "UsbTethering disconnect");
                }
                a(false);
            }
        }
    }
}
