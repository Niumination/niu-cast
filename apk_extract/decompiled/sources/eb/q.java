package eb;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.os.EnvironmentCompat;
import androidx.work.PeriodicWorkRequest;
import com.transsion.connectx.sdk.TCCPSourceApi;
import com.transsion.core.log.LogUtils;
import com.transsion.iotservice.multiscreen.pc.R$mipmap;
import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.iotservice.multiscreen.pc.bean.ConnectedDevice;
import com.transsion.iotservice.multiscreen.pc.socket.TCCPHandshakeSocketServer;
import com.transsion.iotservice.multiscreen.pc.state.CapabilitySocketConnected;
import com.transsion.iotservice.multiscreen.pc.state.DeviceConnectState;
import com.transsion.iotservice.multiscreen.pc.ui.guide.FunctionGuideActivity;
import com.transsion.message.cast.analytics.p000const.EAnalyticsParams;
import com.transsion.pcconnect.invoke.bridge.Device;
import com.transsion.pcconnect.service.FileService;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;
import k3.gc;
import k3.pb;
import k3.rb;
import k3.sb;
import k3.vb;
import kotlin.Lazy;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class q extends SuspendLambda implements Function2 {
    int label;

    public q(Continuation<? super q> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new q(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String deviceName;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        SharedPreferences sharedPreferences = null;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            y yVar = y.f4799a;
            if (y.f != 6) {
                na.k kVar = na.k.f8141a;
                Application applicationA = pb.a();
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = pb.a().getString(R$string.module_pc_toast_connect_success);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                k1 k1Var = k1.f4765a;
                hc.c cVar = k1.e;
                kVar.d(applicationA, o.d.q(new Object[]{cVar != null ? cVar.f5287b : null}, 1, string, "format(...)"));
            }
            Intrinsics.checkNotNullParameter("ConnectionManager", "tag");
            Intrinsics.checkNotNullParameter("emit CapabilitySocketConnected State", "log");
            if (gc.f6462a <= 3) {
                Log.d(gc.f6463b.concat("ConnectionManager"), "emit CapabilitySocketConnected State");
            }
            CapabilitySocketConnected capabilitySocketConnected = new CapabilitySocketConnected();
            this.label = 1;
            if (y.c(capabilitySocketConnected, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        if (jb.f.f6135a.b()) {
            y yVar2 = y.f4799a;
            String str6 = sb.b() ? "phone" : EAnalyticsParams.DEVICE_TYPE_PAD;
            String log = "Current device type: ".concat(str6);
            Intrinsics.checkNotNullParameter("ConnectionManager", "tag");
            Intrinsics.checkNotNullParameter(log, "log");
            if (gc.f6462a <= 3) {
                Log.d(gc.f6463b.concat("ConnectionManager"), log);
            }
            if (!Intrinsics.areEqual(str6, EAnalyticsParams.DEVICE_TYPE_PAD) || y.f != 6) {
                int i9 = FunctionGuideActivity.f2774o;
                se.d.c(pb.a(), 7);
            }
        }
        if (Intrinsics.areEqual(k1.f4766b, "cable")) {
            y yVar3 = y.f4799a;
            Intrinsics.checkNotNullParameter("ConnectionManager", "tag");
            Intrinsics.checkNotNullParameter("initCableConnect", "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("ConnectionManager"), "initCableConnect");
            }
            y.b();
            Lazy lazy = u7.a.f10398a;
            u7.a.a(y.f4812r);
        }
        g0 g0Var = g0.f4753a;
        if (Intrinsics.areEqual(g0.d(), "nfc") || Intrinsics.areEqual(g0.d(), "cable")) {
            String strN = o.d.n("ConnectType：", g0.d(), "ConnectionManager", "tag", "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("ConnectionManager"), strN);
            }
            ob.b bVar = ob.b.f8417b;
            bVar.getClass();
            try {
                Intrinsics.checkNotNullParameter("connected_count", "key");
                SharedPreferences sharedPreferences2 = vb.f6684a;
                if (sharedPreferences2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                    sharedPreferences2 = null;
                }
                int i10 = sharedPreferences2.getInt("connected_count", 0) + 1;
                Intrinsics.checkNotNullParameter("connected_count", "key");
                SharedPreferences sharedPreferences3 = vb.f6684a;
                if (sharedPreferences3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                    sharedPreferences3 = null;
                }
                SharedPreferences.Editor editorEdit = sharedPreferences3.edit();
                editorEdit.putInt("connected_count", i10);
                editorEdit.apply();
            } catch (Exception e) {
                LogUtils.e("AppSharedPreference", e);
                Intrinsics.checkNotNullParameter("connected_count", "key");
                SharedPreferences sharedPreferences4 = vb.f6684a;
                if (sharedPreferences4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                    sharedPreferences4 = null;
                }
                SharedPreferences.Editor editorEdit2 = sharedPreferences4.edit();
                editorEdit2.remove("connected_count");
                editorEdit2.apply();
                Intrinsics.checkNotNullParameter("connected_count", "key");
                SharedPreferences sharedPreferences5 = vb.f6684a;
                if (sharedPreferences5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                    sharedPreferences5 = null;
                }
                SharedPreferences.Editor editorEdit3 = sharedPreferences5.edit();
                editorEdit3.putInt("connected_count", 1);
                editorEdit3.apply();
            }
            k1 k1Var2 = k1.f4765a;
            hc.c cVar2 = k1.e;
            String str7 = cVar2 != null ? cVar2.f5286a : null;
            String str8 = cVar2 != null ? cVar2.f5288c : null;
            if (str7 != null && str7.length() != 0) {
                long j8 = ob.b.f8421h;
                if (j8 != 0) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime() - j8;
                    String pid = ob.b.e(str7, str8);
                    Intrinsics.checkNotNullParameter(pid, "pid");
                    bVar.f8437a.S(pid, jElapsedRealtime);
                    ob.b.f8421h = 0L;
                }
            }
            Intrinsics.checkNotNullParameter("connect_success", "conStatus");
            if (TextUtils.equals("qr_code_connect", ob.b.f8423j)) {
                ob.b.g();
                String entry = ob.b.e;
                Intrinsics.checkNotNullParameter("connect_success", "conStatus");
                Intrinsics.checkNotNullParameter("pc_connection", "workMode");
                Intrinsics.checkNotNullParameter(entry, "entry");
                bVar.f8437a.U("connect_success", entry);
            }
            String str9 = cVar2 != null ? cVar2.f5286a : null;
            String str10 = cVar2 != null ? cVar2.f5288c : null;
            String triggerScene = (TextUtils.equals(ob.b.f8423j, "phone_pick_pc_connect") || TextUtils.equals(ob.b.f8423j, "phone_accept_pc_connect")) ? ob.b.f8418c : ob.b.f8423j;
            String did = ob.b.e(str9, str10);
            g0 g0Var2 = g0.f4753a;
            String conType = g0.d();
            String pid2 = g0.c();
            String startByPcOrPhone = ob.b.f8422i;
            Intrinsics.checkNotNullParameter(startByPcOrPhone, "startByPcOrPhone");
            Intrinsics.checkNotNullParameter(pid2, "pid");
            Intrinsics.checkNotNullParameter(conType, "conType");
            Intrinsics.checkNotNullParameter(triggerScene, "triggerScene");
            Intrinsics.checkNotNullParameter(did, "did");
            bVar.f8437a.P(startByPcOrPhone, pid2, conType, triggerScene, did);
        }
        y yVar4 = y.f4799a;
        int i11 = y.f;
        if (i11 == 0) {
            Intrinsics.checkNotNullParameter("ConnectionManager", "tag");
            Intrinsics.checkNotNullParameter("Action: castScreen", "log");
            if (gc.f6462a <= 3) {
                Log.d(gc.f6463b.concat("ConnectionManager"), "Action: castScreen");
            }
            rb.a(R$mipmap.pc_status_bar);
            a.c();
            y0 y0Var = y0.f4813a;
            y0.d("ConnectionManager:castScreen");
            int i12 = FileService.f2953b;
            m3.k0.a(true);
        } else if (i11 == 1) {
            a.c();
            int i13 = FileService.f2953b;
            m3.k0.a(true);
        } else if (i11 != 6) {
            y0 y0Var2 = y0.f4813a;
            y0.d("PCConnectionStateManager:capabilitySocketConnected");
            DeviceConnectState.INSTANCE.refreshCastState(6);
        } else {
            Intrinsics.checkNotNullParameter("ConnectionManager", "tag");
            Intrinsics.checkNotNullParameter("PConstant.LinkType.AIR_CAST", "log");
            if (gc.f6462a <= 3) {
                Log.d(gc.f6463b.concat("ConnectionManager"), "PConstant.LinkType.AIR_CAST");
            }
            q1 listener = new q1();
            y.p = listener;
            Application context = pb.a();
            e0.b listener2 = new e0.b(24);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(listener2, "listener");
            synchronized (r1.f4793a) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(listener, "listener");
                CopyOnWriteArraySet copyOnWriteArraySet = r1.f4795c;
                if (!copyOnWriteArraySet.contains(listener)) {
                    if (r1.f4794b == null) {
                        r1.b(context);
                    }
                    copyOnWriteArraySet.add(listener);
                }
            }
            listener.f4788c = listener2;
            listener.f4789d = PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS;
            ob.b bVar2 = ob.b.f8417b;
            bVar2.f8437a.getClass();
            tj.w.X("pad_connection_pad_connect_result", new Bundle());
            hc.c cVar3 = k1.e;
            if (cVar3 != null && (deviceName = cVar3.f5287b) != null) {
                NotificationManager notificationManager = bb.v.f1256a;
                Intrinsics.checkNotNullParameter(deviceName, "deviceName");
                Intrinsics.checkNotNullParameter("CastStatusNotificationManager", "tag");
                Intrinsics.checkNotNullParameter("createConnectNotification", "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("CastStatusNotificationManager"), "createConnectNotification");
                }
                bb.v.f1258c = deviceName;
                bb.v.b();
                Notification.Builder builder = bb.v.f1257b;
                bb.v.f1256a.notify(144, builder != null ? builder.build() : null);
            }
            if (sb.b()) {
                rb.a(R$mipmap.pad_connecting);
                int i14 = FileService.f2953b;
                m3.k0.a(false);
            } else {
                bVar2.f8437a.getClass();
                Bundle bundle = new Bundle();
                int i15 = pb.a().getResources().getConfiguration().orientation;
                if (i15 != 1) {
                    str5 = i15 != 2 ? "Undefined" : "landscape";
                } else {
                    str5 = "vertical";
                }
                bundle.putString("screenOrientation", str5);
                tj.w.X("pad_connection_pad_mirror_window_load_success", bundle);
            }
        }
        Device device = g0.f;
        if (device != null) {
            TCCPSourceApi tCCPSourceApi = x7.f.f10882a;
            x7.f.h(new q7.d(device.f2947a, device.f2949c, device.f2948b));
        }
        String log2 = "startLinkTypeFirst linkType:" + y.f + ", MultiConnecting:" + g0.f4754b;
        Intrinsics.checkNotNullParameter("ConnectionManager", "tag");
        Intrinsics.checkNotNullParameter(log2, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("ConnectionManager"), log2);
        }
        if (g0.f4754b) {
            synchronized (dc.i.f4411a) {
                try {
                    String log3 = "startProcessing：isRunning:" + dc.i.f4413c;
                    Intrinsics.checkNotNullParameter("MultiEventQuene", "tag");
                    Intrinsics.checkNotNullParameter(log3, "log");
                    if (gc.f6462a <= 4) {
                        Log.i(gc.f6463b.concat("MultiEventQuene"), log3);
                    }
                    if (dc.i.f4413c) {
                        Iterator it = dc.i.f4412b.iterator();
                        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                        while (it.hasNext()) {
                            ((Runnable) it.next()).run();
                        }
                        dc.i.f4413c = false;
                        dc.i.f4412b.clear();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            ta.a aVar = ta.b.f10202a;
            x7.f.f("disable_clipboard", "");
            Device device2 = g0.f;
            if (device2 != null) {
                g0 g0Var3 = g0.f4753a;
                g0.f4756d.postValue(ConnectedDevice.INSTANCE.create(device2));
                cb.b.f1456a.e(device2);
            }
        } else {
            hc.c cVar4 = k1.e;
            if (cVar4 == null || (str = cVar4.f5286a) == null) {
                str = "-1";
            }
            hc.c cVar5 = k1.e;
            if (cVar5 == null || (str2 = cVar5.f5287b) == null) {
                str2 = EnvironmentCompat.MEDIA_UNKNOWN;
            }
            hc.c cVar6 = k1.e;
            cb.b.f1456a.e(new Device(str, str2, String.valueOf(cVar6 != null ? cVar6.f : 0), k1.f4767c));
            if (i11 == 0) {
                TCCPHandshakeSocketServer tCCPHandshakeSocketServer = l2.f4772a;
                l2.c();
            } else if (i11 == 1) {
                TCCPHandshakeSocketServer tCCPHandshakeSocketServer2 = l2.f4772a;
                Intrinsics.checkNotNullParameter("SocketServerManager", "tag");
                Intrinsics.checkNotNullParameter("startExtendScreen", "log");
                if (gc.f6462a <= 3) {
                    Log.d(gc.f6463b.concat("SocketServerManager"), "startExtendScreen");
                }
                List list = a.f4742a;
                o7.c cVarB = o7.a.b("com.transsion.extendscreen_v3");
                if (cVarB != null) {
                    cVarB.start();
                }
                TCCPSourceApi tCCPSourceApi2 = x7.f.f10882a;
                hc.c cVar7 = k1.e;
                String str11 = "";
                if (cVar7 == null || (str3 = cVar7.f5286a) == null) {
                    str3 = "";
                }
                hc.c cVar8 = k1.e;
                String strValueOf = String.valueOf(cVar8 != null ? Integer.valueOf(cVar8.f) : null);
                hc.c cVar9 = k1.e;
                if (cVar9 != null && (str4 = cVar9.f5287b) != null) {
                    str11 = str4;
                }
                x7.f.h(new q7.d(str3, strValueOf, str11));
                y0 y0Var3 = y0.f4813a;
                y0.d("SocketServerManager:startExtendScreen");
                DeviceConnectState.INSTANCE.refreshCastState(3);
            } else if (i11 == 6) {
                TCCPHandshakeSocketServer tCCPHandshakeSocketServer3 = l2.f4772a;
                l2.c();
            }
        }
        k1 k1Var3 = k1.f4765a;
        hc.c device3 = k1.e;
        if (device3 != null) {
            Intrinsics.checkNotNullParameter(device3, "device");
            String str12 = device3.f5288c;
            Locale ENGLISH = Locale.ENGLISH;
            Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
            String value = str12.toUpperCase(ENGLISH);
            Intrinsics.checkNotNullExpressionValue(value, "toUpperCase(...)");
            if (StringsKt.isBlank(value) || value.length() == 0) {
                Intrinsics.checkNotNullParameter("ShareUtils", "tag");
                Intrinsics.checkNotNullParameter("putConnectedDevice cacheMac is empty cacheMac", "log");
                if (gc.f6462a <= 6) {
                    Log.e(gc.f6463b.concat("ShareUtils"), "putConnectedDevice cacheMac is empty cacheMac");
                }
            } else {
                Intrinsics.checkNotNullParameter("recent_connect_device", "key");
                Intrinsics.checkNotNullParameter(value, "value");
                SharedPreferences sharedPreferences6 = vb.f6684a;
                if (sharedPreferences6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                } else {
                    sharedPreferences = sharedPreferences6;
                }
                SharedPreferences.Editor editorEdit4 = sharedPreferences.edit();
                editorEdit4.putString("recent_connect_device", value);
                editorEdit4.apply();
            }
            HashMap mapD = dc.b.d();
            gc.c("AppSharedPreference", "saveRecentConnectDevice: now mac" + value + ",connected list:" + mapD);
            if (!mapD.keySet().contains(value)) {
                gc.c("AppSharedPreference", "saveRecentConnectDevice:new device,save to connected list:" + value);
                dc.b.g(value, false);
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((q) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
