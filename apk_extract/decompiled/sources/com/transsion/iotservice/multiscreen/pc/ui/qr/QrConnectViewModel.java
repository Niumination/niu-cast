package com.transsion.iotservice.multiscreen.pc.ui.qr;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModel;
import bf.d;
import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.iotservice.multiscreen.pc.state.DeviceConnectState;
import com.transsion.iotservice.multiscreen.pc.state.Initial;
import com.transsion.iotservice.multiscreen.pc.ue.P2PConnectService;
import dc.g;
import eb.k1;
import eb.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import k3.gc;
import k3.pb;
import k3.ub;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsKt;
import na.k;
import oi.g0;
import tj.w;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/ui/qr/QrConnectViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nQrConnectViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 QrConnectViewModel.kt\ncom/transsion/iotservice/multiscreen/pc/ui/qr/QrConnectViewModel\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,217:1\n1863#2,2:218\n1#3:220\n*S KotlinDebug\n*F\n+ 1 QrConnectViewModel.kt\ncom/transsion/iotservice/multiscreen/pc/ui/qr/QrConnectViewModel\n*L\n187#1:218,2\n*E\n"})
public final class QrConnectViewModel extends ViewModel {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f2800d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f2801a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public wb.a f2802b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2803c;

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(ArrayList arrayList, Continuation continuation) {
        a aVar;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i8 = aVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                aVar.label = i8 - Integer.MIN_VALUE;
            } else {
                aVar = new a(this, continuation);
            }
        } else {
            aVar = new a(this, continuation);
        }
        Object objC = aVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = aVar.label;
        if (i9 == 0) {
            ResultKt.throwOnFailure(objC);
            aVar.L$0 = this;
            aVar.L$1 = arrayList;
            aVar.label = 1;
            objC = c(arrayList, aVar);
            if (objC == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i9 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            arrayList = (ArrayList) aVar.L$1;
            this = (QrConnectViewModel) aVar.L$0;
            ResultKt.throwOnFailure(objC);
        }
        if (((Boolean) objC).booleanValue()) {
            Intrinsics.checkNotNullParameter("QrConnectViewModel", "tag");
            Intrinsics.checkNotNullParameter("to check P2P", "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("QrConnectViewModel"), "to check P2P");
            }
            return Unit.INSTANCE;
        }
        this.getClass();
        DeviceConnectState deviceConnectState = DeviceConnectState.INSTANCE;
        if (deviceConnectState.isConnecting()) {
            k kVar = k.f8141a;
            Application applicationA = pb.a();
            String string = pb.a().getString(R$string.module_pc_connecting);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            kVar.d(applicationA, string);
            ob.b.f8417b.o();
            wb.a aVar2 = this.f2802b;
            if (aVar2 != null) {
                aVar2.invoke();
            }
            Intrinsics.checkNotNullParameter("QrConnectViewModel", "tag");
            Intrinsics.checkNotNullParameter("connecting", "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("QrConnectViewModel"), "connecting");
            }
            return Unit.INSTANCE;
        }
        if (!deviceConnectState.isConnected()) {
            this.e(arrayList);
            return Unit.INSTANCE;
        }
        k kVar2 = k.f8141a;
        Application applicationA2 = pb.a();
        String string2 = pb.a().getString(R$string.module_this_pc_using);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        kVar2.d(applicationA2, string2);
        ob.b.f8417b.o();
        wb.a aVar3 = this.f2802b;
        if (aVar3 != null) {
            aVar3.invoke();
        }
        Intrinsics.checkNotNullParameter("QrConnectViewModel", "tag");
        Intrinsics.checkNotNullParameter("connected", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("QrConnectViewModel"), "connected");
        }
        return Unit.INSTANCE;
    }

    public final Object b(SuspendLambda suspendLambda) throws Throwable {
        gc.c("QrConnectViewModel", "checkEnv");
        ob.b bVar = ob.b.f8417b;
        bVar.getClass();
        ob.b.f8423j = "qr_code_connect";
        ArrayList arrayList = new ArrayList();
        HashMap map = this.f2801a;
        if (!map.isEmpty()) {
            String str = (String) map.get("PID");
            if (str != null) {
                arrayList.add(str);
            }
            String str2 = (String) map.get("DeviceName");
            if (str2 != null) {
                arrayList.add(str2);
            }
            String str3 = (String) map.get("DPORT");
            if (str3 != null) {
                arrayList.add(str3);
            }
            String str4 = (String) map.get("DID");
            if (str4 != null) {
                arrayList.add(str4);
            }
            String str5 = (String) map.get("SSID");
            if (str5 != null) {
                arrayList.add(str5);
            }
            String str6 = (String) map.get("PWD");
            if (str6 != null) {
                arrayList.add(str6);
            }
            String str7 = (String) map.get("Chan");
            if (str7 != null) {
                arrayList.add(str7);
            }
        }
        if (arrayList.size() < 4) {
            bVar.o();
            wb.a aVar = this.f2802b;
            if (aVar != null) {
                aVar.invoke();
            }
            return Unit.INSTANCE;
        }
        if (ub.b()) {
            k kVar = k.f8141a;
            Application applicationA = pb.a();
            String string = pb.a().getResources().getString(R$string.module_pc_close_hotspot_conn_toast);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            kVar.d(applicationA, string);
            bVar.o();
            wb.a aVar2 = this.f2802b;
            if (aVar2 != null) {
                aVar2.invoke();
            }
            gc.c("QrConnectViewModel", "checkEnv: SettingUtils.isWifiHotSpotOpen");
            return Unit.INSTANCE;
        }
        y yVar = y.f4799a;
        gc.c("QrConnectViewModel", "checkEnv:isResetToInitial:" + y.q + " state:" + y.f4804h);
        if (!y.q || Intrinsics.areEqual(y.f4804h, new Initial())) {
            Object objA = a(arrayList, suspendLambda);
            return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Unit.INSTANCE;
        }
        g0 g0Var = y.f4806j;
        d dVar = new d(3, this, arrayList);
        g0Var.getClass();
        Object objI = g0.i(g0Var, dVar, suspendLambda);
        return objI == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objI : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object c(ArrayList arrayList, ContinuationImpl continuationImpl) {
        b bVar;
        if (continuationImpl instanceof b) {
            bVar = (b) continuationImpl;
            int i8 = bVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                bVar.label = i8 - Integer.MIN_VALUE;
            } else {
                bVar = new b(this, continuationImpl);
            }
        } else {
            bVar = new b(this, continuationImpl);
        }
        Object obj = bVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = bVar.label;
        if (i9 == 0) {
            ResultKt.throwOnFailure(obj);
            int i10 = this.f2803c == 1 ? 6 : 0;
            y yVar = y.f4799a;
            if (y.f == i10) {
                return Boxing.boxBoolean(false);
            }
            String strM = o.d.m("connect for new service:", "QrConnectViewModel", "tag", "log", i10);
            if (gc.f6462a <= 6) {
                Log.e(gc.f6463b.concat("QrConnectViewModel"), strM);
            }
            gi.a aVar = new gi.a(13, this, arrayList);
            g gVar = g.f4406a;
            Application applicationA = pb.a();
            bVar.label = 1;
            if (gVar.a(i10, applicationA, aVar, bVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i9 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Boxing.boxBoolean(true);
    }

    public final void d(Intent intent) {
        int i8;
        if (intent == null) {
            Intrinsics.checkNotNullParameter("QrConnectViewModel", "tag");
            Intrinsics.checkNotNullParameter("intent is null", "log");
            if (gc.f6462a <= 6) {
                Log.e(gc.f6463b.concat("QrConnectViewModel"), "intent is null");
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(intent.getAction(), "com.transsion.intent.pad.connection")) {
            f2800d = System.currentTimeMillis();
            ob.b.f8417b.f8437a.getClass();
            w.X("pad_connection_phone_start_connect", new Bundle());
            i8 = 1;
        } else {
            i8 = 0;
        }
        this.f2803c = i8;
        String stringExtra = intent.getStringExtra("QR_message");
        if (stringExtra == null || StringsKt.isBlank(stringExtra)) {
            Intrinsics.checkNotNullParameter("QrConnectViewModel", "tag");
            Intrinsics.checkNotNullParameter("qrMessage is null or blank", "log");
            if (gc.f6462a <= 6) {
                Log.e(gc.f6463b.concat("QrConnectViewModel"), "qrMessage is null or blank");
                return;
            }
            return;
        }
        HashMap map = this.f2801a;
        map.clear();
        if (stringExtra.length() > 0) {
            List listSplit$default = StringsKt__StringsKt.split$default(stringExtra, new String[]{"&"}, false, 0, 6, (Object) null);
            map.clear();
            Iterator it = listSplit$default.iterator();
            while (it.hasNext()) {
                List listSplit$default2 = StringsKt__StringsKt.split$default((String) it.next(), new String[]{"="}, false, 0, 6, (Object) null);
                if (!listSplit$default2.isEmpty()) {
                    String string = StringsKt__StringsKt.trim((CharSequence) ((String) listSplit$default2.get(0))).toString();
                    String string2 = StringsKt__StringsKt.trim((CharSequence) ((String) listSplit$default2.get(1))).toString();
                    String log = h0.a.k("QR keyMap:", string, ":", string2);
                    Intrinsics.checkNotNullParameter("QrConnectViewModel", "tag");
                    Intrinsics.checkNotNullParameter(log, "log");
                    if (gc.f6462a <= 4) {
                        Log.i(gc.f6463b.concat("QrConnectViewModel"), log);
                    }
                    map.put(string, string2);
                }
            }
        }
    }

    public final void e(ArrayList arrayList) {
        Intrinsics.checkNotNullParameter("QrConnectViewModel", "tag");
        Intrinsics.checkNotNullParameter("startP2PConnect", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("QrConnectViewModel"), "startP2PConnect");
        }
        k1 k1Var = k1.f4765a;
        k1.j("qr");
        Intrinsics.checkNotNullParameter("QrConnectViewModel", "tag");
        Intrinsics.checkNotNullParameter("startP2pService", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("QrConnectViewModel"), "startP2pService");
        }
        Intent intent = new Intent(pb.a(), (Class<?>) P2PConnectService.class);
        intent.putStringArrayListExtra("remote_device_info", arrayList);
        intent.putExtra("business_type", this.f2803c);
        pb.a().startService(intent);
        wb.a aVar = this.f2802b;
        if (aVar != null) {
            aVar.invoke();
        }
    }
}
