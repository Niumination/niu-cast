package com.transsion.iotservice.multiscreen.pc.receiver;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.UserHandle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.connectx.sdk.TCCPSourceApi;
import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.iotservice.multiscreen.pc.socket.TCCPHandshakeSocketServer;
import com.transsion.iotservice.multiscreen.pc.state.DeviceConnectState;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.PcRequestConnectViewModel;
import com.transsion.iotservice.multiscreen.pc.ui.guide.FunctionGuideActivity;
import com.transsion.iotservice.multiscreen.pc.ui.permission.PermissionGuideDialog;
import com.transsion.iotservice.multiscreen.pc.ui.search.GestureHandleActivity;
import com.transsion.iotservice.multiscreen.pc.ui.search.SearchActivity;
import com.transsion.message.TextSelection;
import eb.k1;
import eb.l2;
import eb.y;
import eb.y0;
import hc.c;
import k3.gc;
import k3.pb;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import na.k;
import o.d;
import pa.a;
import tj.w;
import x7.f;
import x7.i;
import za.b;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/receiver/GestureReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class GestureReceiver extends BroadcastReceiver {
    public static boolean a() {
        k1 k1Var = k1.f4765a;
        c cVar = k1.e;
        boolean z2 = true;
        if (cVar != null) {
            z2 = cVar.f == 3;
            String strO = d.o("verifyCapability: ", z2, "GestureReceiver", "tag", "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("GestureReceiver"), strO);
            }
            if (!z2) {
                k.f8141a.c(pb.a(), R$string.module_pc_the_device_not_suppot);
            }
        }
        return z2;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action;
        String state;
        if (intent == null || (action = intent.getAction()) == null) {
            action = "";
        }
        gc.c("GestureReceiver", "onReceive:".concat(action));
        String strG = a.f8703a.g();
        if (strG == null) {
            gc.c("GestureReceiver", "onReceive fail, top activity state is null");
            return;
        }
        Context context2 = context == null ? pb.a() : context;
        Intrinsics.checkNotNullParameter(context2, "context");
        boolean zAreEqual = Intrinsics.areEqual(Settings.Global.getString(context2.getContentResolver(), "transsion_game_mode"), "1");
        if (Intrinsics.areEqual(strG, FunctionGuideActivity.class.getName()) || Intrinsics.areEqual(strG, PermissionGuideDialog.class.getName()) || Intrinsics.areEqual(strG, SearchActivity.class.getName()) || zAreEqual) {
            gc.c("GestureReceiver", "illegal top activity state:" + strG + " isGameMode:" + zAreEqual);
            return;
        }
        int iHashCode = action.hashCode();
        sj.a aVar = za.a.f11267b;
        if (iHashCode == -1723251491) {
            if (action.equals("com.transsion.iotservice.pcconnect.gesture.action.AIR_COPY") && a()) {
                gc.a("GestureAction", "onAirCopyGesture");
                if (!za.a.a()) {
                    gc.d("GestureAction", "onAirCopyGesture not support");
                    return;
                }
                if (!Intrinsics.areEqual(b.f11271d.getValue(), Boolean.TRUE)) {
                    gc.b("GestureAction", "onAirCopyGesture:switch disabled");
                    return;
                }
                if (PcRequestConnectViewModel.f2746j) {
                    return;
                }
                gc.a("GestureAction", "copyTextToPC");
                String str = TextSelection.get(pb.a());
                if (TextUtils.isEmpty(str)) {
                    gc.d("GestureAction", "copyTextToPC: text is empty");
                } else {
                    ob.b bVar = ob.b.f8417b;
                    bVar.getClass();
                    DeviceConnectState deviceConnectState = DeviceConnectState.INSTANCE;
                    bVar.s("text", 0, 0L, deviceConnectState.isConnected() ? "yes" : "no", ob.b.h() ? "yes" : "no");
                    if (deviceConnectState.isConnected()) {
                        gc.a("GestureAction", "copyTextToPC: already connected, to send text");
                        y yVar = y.f4799a;
                        Intrinsics.checkNotNull(str);
                        y.r(str);
                    } else {
                        ob.b.F = "swift_copy";
                        y0 y0Var = y0.f4813a;
                        y0.d("openPhoneMirrorOnPC");
                        Intent intent2 = new Intent(pb.a(), (Class<?>) GestureHandleActivity.class);
                        intent2.putExtra("INTENT_FROM_PATH", 4);
                        intent2.putExtra("textContent", str);
                        intent2.addFlags(268435456);
                        intent2.addFlags(32768);
                        Application applicationA = pb.a();
                        UserHandle CURRENT = z8.a.f11265a;
                        Intrinsics.checkNotNullExpressionValue(CURRENT, "CURRENT");
                        pb.d(aVar, applicationA, intent2);
                    }
                }
                za.a.b("com.transsion.iotservice.action.SWIFT_COPY");
                return;
            }
            return;
        }
        if (iHashCode == 24256775) {
            if (action.equals("com.transsion.iotservice.pcconnect.gesture.action.SWIFT_SEND") && a()) {
                gc.a("GestureAction", "onSwiftSendGesture");
                if (!za.a.a()) {
                    gc.d("GestureAction", "onSwiftSendGesture:gesture not support");
                    return;
                } else if (!Intrinsics.areEqual(b.f.getValue(), Boolean.TRUE)) {
                    gc.b("GestureAction", "onSwiftSendGesture:switch disabled");
                    return;
                } else {
                    if (PcRequestConnectViewModel.f2746j) {
                        return;
                    }
                    za.a.b("com.transsion.iotservice.action.SWIFT_SEND");
                    return;
                }
            }
            return;
        }
        if (iHashCode == 1247902572 && action.equals("com.transsion.iotservice.pcconnect.gesture.action.MIRROR_CAST")) {
            gc.a("GestureAction", "onMirrorGesture");
            ob.b bVar2 = ob.b.f8417b;
            bVar2.getClass();
            if (ob.b.h()) {
                state = "already_mirroring";
            } else {
                state = DeviceConnectState.INSTANCE.isConnected() ? "connected_pc_idle" : "unconnected_pc";
            }
            Intrinsics.checkNotNullParameter(state, "state");
            bVar2.f8437a.getClass();
            Intrinsics.checkNotNullParameter(state, "state");
            Bundle bundle = new Bundle();
            bundle.putString("state", state);
            w.X("iot_pc_con_trigger_mirror_guesture", bundle);
            if (!za.a.a()) {
                gc.d("GestureAction", "onMirrorGesture not support");
                return;
            }
            if (!Intrinsics.areEqual(b.f11269b.getValue(), Boolean.TRUE)) {
                gc.b("GestureAction", "onMirrorGesture:switch disabled");
                return;
            }
            if (PcRequestConnectViewModel.f2746j) {
                return;
            }
            gc.a("GestureAction", "<openPhoneMirror>");
            i iVar = i.f10886a;
            if (Settings.Global.getInt(pb.a().getContentResolver(), "connectx.cast.status.service.enabled", 0) == 1) {
                TCCPSourceApi tCCPSourceApi = f.f10882a;
                if (tCCPSourceApi.isServiceAvailable() && tCCPSourceApi.getTCCPStatus() == 4) {
                    gc.a("GestureAction", "openPhoneMirrorOnPC: is casting");
                    k.f8141a.c(pb.a(), R$string.module_pc_gesture_hint_in_mirroring);
                    return;
                }
            }
            if (DeviceConnectState.INSTANCE.isConnected()) {
                gc.a("GestureAction", "openPhoneMirrorOnPC: already connected to cast");
                TCCPHandshakeSocketServer tCCPHandshakeSocketServer = l2.f4772a;
                l2.c();
                return;
            }
            ob.b.F = "cast_gesture";
            Intent intent3 = new Intent(pb.a(), (Class<?>) GestureHandleActivity.class);
            intent3.putExtra("INTENT_FROM_PATH", 5);
            intent3.addFlags(268435456);
            intent3.addFlags(32768);
            Application applicationA2 = pb.a();
            UserHandle CURRENT2 = z8.a.f11265a;
            Intrinsics.checkNotNullExpressionValue(CURRENT2, "CURRENT");
            pb.d(aVar, applicationA2, intent3);
        }
    }
}
