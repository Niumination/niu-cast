package com.transsion.iotservice.multiscreen.pc.ue;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import eb.t;
import eb.y;
import eb.y0;
import hc.a;
import hc.d;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import k3.gc;
import k3.ub;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import li.g2;
import li.h0;
import li.l0;
import li.v0;
import pb.f;
import pb.g;
import pb.h;
import qi.c;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/ue/P2PConnectService;", "Landroid/app/IntentService;", "<init>", "()V", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class P2PConnectService extends IntentService {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f2682i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f2683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g2 f2684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f2685c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f2686d;
    public int e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final P2PConnectService$mIconEnableObserver$1 f2687h;

    /* JADX WARN: Type inference failed for: r0v5, types: [com.transsion.iotservice.multiscreen.pc.ue.P2PConnectService$mIconEnableObserver$1] */
    public P2PConnectService() {
        super("P2PConnectService");
        this.f2683a = h0.a(v0.f7499b);
        this.f2685c = new AtomicBoolean(false);
        this.f2686d = "qr";
        this.f2687h = new Observer<Boolean>() { // from class: com.transsion.iotservice.multiscreen.pc.ue.P2PConnectService$mIconEnableObserver$1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Boolean bool) {
                g2 g2Var;
                if (bool.booleanValue()) {
                    return;
                }
                y0.f4816d.removeObserver(this);
                Intrinsics.checkNotNullParameter("P2PConnectService", "tag");
                Intrinsics.checkNotNullParameter("P2PConnectService:receive icon closed.Cancel connect.", "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("P2PConnectService"), "P2PConnectService:receive icon closed.Cancel connect.");
                }
                P2PConnectService p2PConnectService = this.f2688a;
                g2 g2Var2 = p2PConnectService.f2684b;
                if (g2Var2 != null && g2Var2.a() && (g2Var = p2PConnectService.f2684b) != null) {
                    g2Var.h(null);
                }
                if (p2PConnectService.f2685c.compareAndSet(true, false)) {
                    y yVar = y.f4799a;
                    l0.p(y.f4800b, null, null, new t(null), 3);
                }
            }
        };
    }

    @Override // android.app.IntentService, android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        Intrinsics.checkNotNullParameter("P2PConnectService", "tag");
        Intrinsics.checkNotNullParameter("onDestroy", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("P2PConnectService"), "onDestroy");
        }
    }

    @Override // android.app.IntentService
    public final void onHandleIntent(Intent intent) {
        d dVar;
        String strSubstring;
        int i8;
        int i9;
        if (intent != null) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("remote_device_info");
            int intExtra = intent.getIntExtra("business_type", 0);
            gc.c("P2PConnectService", "onHandleIntent:businessType:" + intExtra);
            if (intExtra == 0) {
                this.e = 0;
            } else if (intExtra == 1) {
                this.e = 8;
            }
            if (stringArrayListExtra == null || stringArrayListExtra.isEmpty()) {
                gc.b("P2PConnectService", "onHandleIntent:data is empty");
                return;
            }
            String stringExtra = intent.getStringExtra("connect_type");
            if (stringExtra == null) {
                stringExtra = "qr";
            }
            this.f2686d = stringExtra;
            gc.c("P2PConnectService", "deviceInfo:" + stringArrayListExtra + ";" + stringArrayListExtra.size());
            int size = stringArrayListExtra.size();
            c cVar = this.f2683a;
            if (size < 6) {
                if (stringArrayListExtra.size() >= 2) {
                    a aVar = new a();
                    String str = stringArrayListExtra.get(2);
                    Intrinsics.checkNotNullExpressionValue(str, "get(...)");
                    aVar.a(StringsKt__StringsJVMKt.replace$default(str, "-", ":", false, 4, (Object) null));
                    gc.c("P2PConnectService", "connectWithOldDataFormat nfc get MAC:" + aVar.f5288c);
                    this.f2685c.compareAndSet(false, true);
                    this.f2684b = l0.p(cVar, null, null, new g(this, aVar, null), 3);
                    return;
                }
                return;
            }
            if (Intrinsics.areEqual(this.f2686d, "nfc")) {
                String str2 = stringArrayListExtra.get(0);
                Intrinsics.checkNotNullExpressionValue(str2, "get(...)");
                if (Intrinsics.areEqual(str2, "N9F9B9D9")) {
                    dVar = new d();
                    String str3 = stringArrayListExtra.get(3);
                    Intrinsics.checkNotNullExpressionValue(str3, "get(...)");
                    dVar.a(StringsKt__StringsJVMKt.replace$default(str3, "-", ":", false, 4, (Object) null));
                    String str4 = stringArrayListExtra.get(4);
                    Intrinsics.checkNotNullParameter(str4, "<set-?>");
                    dVar.f5290g = str4;
                    String str5 = stringArrayListExtra.get(5);
                    Intrinsics.checkNotNullParameter(str5, "<set-?>");
                    dVar.f5291h = str5;
                    String str6 = stringArrayListExtra.get(6);
                    Intrinsics.checkNotNullExpressionValue(str6, "get(...)");
                    dVar.f5292i = Integer.parseInt(str6);
                    dVar.e = this.e;
                    dVar.f = 3;
                    String log = "getP2PConnectDeviceFromNfc p2PConnectDevice:" + dVar;
                    Intrinsics.checkNotNullParameter("P2PConnectService", "tag");
                    Intrinsics.checkNotNullParameter(log, "log");
                    if (gc.f6462a <= 3) {
                        Log.d(gc.f6463b.concat("P2PConnectService"), log);
                    }
                } else {
                    dVar = null;
                }
            } else {
                dVar = new d();
                String str7 = stringArrayListExtra.get(1);
                Intrinsics.checkNotNullParameter(str7, "<set-?>");
                dVar.f5287b = str7;
                String str8 = stringArrayListExtra.get(3);
                Intrinsics.checkNotNullExpressionValue(str8, "get(...)");
                dVar.a(StringsKt__StringsJVMKt.replace$default(str8, "-", ":", false, 4, (Object) null));
                String str9 = stringArrayListExtra.get(4);
                Intrinsics.checkNotNullParameter(str9, "<set-?>");
                dVar.f5290g = str9;
                String str10 = stringArrayListExtra.get(5);
                Intrinsics.checkNotNullParameter(str10, "<set-?>");
                dVar.f5291h = str10;
                String str11 = stringArrayListExtra.get(6);
                Intrinsics.checkNotNullExpressionValue(str11, "get(...)");
                dVar.f5292i = Integer.parseInt(str11);
                dVar.e = this.e;
                String str12 = stringArrayListExtra.get(0);
                Intrinsics.checkNotNullExpressionValue(str12, "get(...)");
                String pid = str12;
                Intrinsics.checkNotNullParameter(pid, "pid");
                int length = pid.length();
                String strSubstring2 = "FF";
                if (length == 12) {
                    strSubstring = pid.substring(2, 4);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                } else if (length != 18) {
                    strSubstring = "FF";
                } else {
                    strSubstring = pid.substring(6, 8);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                }
                dVar.f5289d = Integer.parseInt(strSubstring);
                String str13 = stringArrayListExtra.get(0);
                Intrinsics.checkNotNullExpressionValue(str13, "get(...)");
                String pid2 = str13;
                Intrinsics.checkNotNullParameter(pid2, "pid");
                int length2 = pid2.length();
                if (length2 == 12) {
                    i8 = 4;
                    strSubstring2 = pid2.substring(0, 2);
                    Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                } else if (length2 != 18) {
                    i8 = 4;
                } else {
                    i8 = 4;
                    strSubstring2 = pid2.substring(2, 4);
                    Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                }
                byte b9 = Byte.parseByte(strSubstring2, CharsKt.checkRadix(16));
                if (b9 == 13) {
                    i9 = 1;
                } else if (b9 == 21) {
                    i9 = 5;
                } else if (b9 == 15) {
                    i9 = 6;
                } else if (b9 == 18) {
                    i9 = 2;
                } else if (b9 == 10) {
                    i9 = 3;
                } else {
                    i9 = b9 == 11 ? i8 : 0;
                }
                dVar.f = i9;
                String log2 = "getP2PConnectDeviceFromQr p2PConnectDevice:" + dVar;
                Intrinsics.checkNotNullParameter("P2PConnectService", "tag");
                Intrinsics.checkNotNullParameter(log2, "log");
                if (gc.f6462a <= 3) {
                    Log.d(gc.f6463b.concat("P2PConnectService"), log2);
                }
            }
            if (dVar == null) {
                gc.b("P2PConnectService", "onHandleIntent:deviceInfo is invalid");
            } else if (ub.a(this)) {
                this.f2684b = l0.p(cVar, null, null, new f(this, dVar, null), 3);
            } else {
                this.f2684b = l0.p(cVar, null, null, new h(this, dVar, null), 3);
            }
        }
    }
}
