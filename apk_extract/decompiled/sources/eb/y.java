package eb;

import android.app.Application;
import android.app.NotificationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import com.transsion.connectx.sdk.TCCPSourceApi;
import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.iotservice.multiscreen.pc.socket.TCCPHandshakeSocketClient;
import com.transsion.iotservice.multiscreen.pc.socket.TCCPHandshakeSocketServer;
import com.transsion.iotservice.multiscreen.pc.state.BaseState;
import com.transsion.iotservice.multiscreen.pc.state.DeviceConnectState;
import com.transsion.iotservice.multiscreen.pc.state.Initial;
import com.transsion.iotservice.multiscreen.pc.state.MainSocketConnected;
import com.transsion.iotservice.multiscreen.pc.state.MainSocketInit;
import com.transsion.iotservice.multiscreen.pc.state.PhysicalConnected;
import com.transsion.iotservice.multiscreen.pc.state.PhysicalConnecting;
import com.transsion.iotservice.multiscreen.pc.state.PhysicalDisconnecting;
import com.transsion.iotservice.multiscreen.pc.state.PhysicalScanning;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.UsbConnectFailDialog;
import com.transsion.pcconnect.invoke.bridge.Device;
import com.transsion.pcconnect.service.FileService;
import java.util.concurrent.CopyOnWriteArraySet;
import k3.gc;
import k3.gd;
import k3.pb;
import k3.sb;
import kotlin.Lazy;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class y {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static li.g2 f4801c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static li.g2 f4802d;
    public static volatile int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f4803g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final oi.g0 f4805i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final oi.g0 f4806j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final MutableLiveData f4807k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final MutableLiveData f4808l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final MutableLiveData f4809m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final MutableLiveData f4810n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static volatile li.g2 f4811o;
    public static q1 p;
    public static volatile boolean q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final d f4812r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y f4799a = new y();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final qi.c f4800b = li.h0.a(li.v0.f7499b);
    public static final long e = 500;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static BaseState f4804h = new Initial();

    static {
        oi.g0 g0VarA = oi.j.a();
        f4805i = g0VarA;
        f4806j = g0VarA;
        Boolean bool = Boolean.FALSE;
        MutableLiveData mutableLiveData = new MutableLiveData(bool);
        f4807k = mutableLiveData;
        f4808l = mutableLiveData;
        MutableLiveData mutableLiveData2 = new MutableLiveData(bool);
        f4809m = mutableLiveData2;
        f4810n = mutableLiveData2;
        f4812r = new d(0);
    }

    public static final Object a(SuspendLambda suspendLambda) {
        Object objD;
        y yVar = f4799a;
        Intrinsics.checkNotNullParameter("ConnectionManager", "tag");
        Intrinsics.checkNotNullParameter("executeToInitial", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("ConnectionManager"), "executeToInitial");
        }
        return (!(f4803g && Intrinsics.areEqual(f4804h, new PhysicalScanning())) && (objD = yVar.d(suspendLambda)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? objD : Unit.INSTANCE;
    }

    public static void b() {
        if (Intrinsics.areEqual(k1.f4766b, "cable")) {
            u7.c cVar = sb.b() ? (u7.c) o7.a.b("com.transsion.network_sharing") : (u7.c) o7.a.b("com.transsion.pad_network_sharing");
            if (cVar != null && cVar.f10404c) {
                Intrinsics.checkNotNullParameter("ConnectionManager", "tag");
                Intrinsics.checkNotNullParameter("disableNetworkSharingIfNeed:network sharing,ignore", "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("ConnectionManager"), "disableNetworkSharingIfNeed:network sharing,ignore");
                    return;
                }
                return;
            }
            Object systemService = pb.a().getSystemService("connectivity");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
            if (((networkInfo == null || !networkInfo.isConnected()) && (networkInfo2 == null || !networkInfo2.isConnected())) || f4804h.compareTo((BaseState) new MainSocketConnected()) < 0) {
                return;
            }
            Intrinsics.checkNotNullParameter("ConnectionManager", "tag");
            Intrinsics.checkNotNullParameter("disableNetworkSharingIfNeed:on connected via cable.", "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("ConnectionManager"), "disableNetworkSharingIfNeed:on connected via cable.");
            }
            li.l0.p(f4800b, null, null, new b(null), 3);
        }
    }

    public static Object c(BaseState baseState, ContinuationImpl continuationImpl) {
        String log = "emit state from " + f4804h + " to " + baseState;
        Intrinsics.checkNotNullParameter("ConnectionManager", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("ConnectionManager"), log);
        }
        f4804h = baseState;
        Object objEmit = f4805i.emit(baseState, continuationImpl);
        return objEmit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit : Unit.INSTANCE;
    }

    public static Object g(ContinuationImpl continuationImpl) {
        Intrinsics.checkNotNullParameter("ConnectionManager", "tag");
        Intrinsics.checkNotNullParameter("onPhysicalConnecting", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("ConnectionManager"), "onPhysicalConnecting");
        }
        Object objC = c(new PhysicalConnecting(), continuationImpl);
        return objC == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objC : Unit.INSTANCE;
    }

    public static void h() {
        String strO = o.d.o("onTCCPDisconnect:in search:", f4803g, "ConnectionManager", "tag", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("ConnectionManager"), strO);
        }
        u(false);
        if (!f4803g) {
            li.l0.p(f4800b, null, null, new g(null), 3);
        }
        int i8 = FileService.f2953b;
        m3.k0.a(true);
        f = 0;
        li.l0.p(f4800b, null, null, new h(null), 3);
    }

    public static void i(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        String log = tag + ":currentState:" + f4804h;
        Intrinsics.checkNotNullParameter("ConnectionManager", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("ConnectionManager"), log);
        }
    }

    public static void m() {
        i("sendConnectMainSocketTimeoutEvent");
        k1 k1Var = k1.f4765a;
        hc.c cVar = k1.e;
        ob.b.f8417b.n(cVar != null ? cVar.f5288c : null, cVar != null ? cVar.f5286a : null);
        if (Intrinsics.areEqual(k1.f4766b, "cable")) {
            Intrinsics.checkNotNullParameter("ConnectionManager", "tag");
            Intrinsics.checkNotNullParameter("sendHandshakeTimeoutEvent with cable connect.", "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("ConnectionManager"), "sendHandshakeTimeoutEvent with cable connect.");
            }
            int i8 = UsbConnectFailDialog.e;
            gd.a(pb.a());
            na.k kVar = na.k.f8141a;
            Application applicationA = pb.a();
            String string = pb.a().getString(R$string.toast_usb_connect_fail);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            kVar.b(applicationA, string);
        }
        li.l0.p(f4800b, null, null, new p(null), 3);
    }

    public static void o(boolean z2) {
        String strO = o.d.o("setSearchActivityActive:", z2, "ConnectionManager", "tag", "log");
        if (gc.f6462a <= 5) {
            Log.w(gc.f6463b.concat("ConnectionManager"), strO);
        }
        f4803g = z2;
    }

    public static void r(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        new Handler(Looper.getMainLooper()).post(new a4.c(text, 15));
    }

    public static void s(boolean z2) {
        li.g2 g2Var = f4802d;
        if (g2Var != null) {
            g2Var.h(null);
        }
        f4802d = li.l0.p(f4800b, null, null, new w(z2, null), 3);
    }

    public static void t(boolean z2) {
        String strO = o.d.o("updateExtendStateDirect:", z2, "ConnectionManager", "tag", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("ConnectionManager"), strO);
        }
        f4809m.postValue(Boolean.valueOf(z2));
    }

    public static void u(boolean z2) {
        li.g2 g2Var = f4801c;
        if (g2Var != null) {
            g2Var.h(null);
        }
        f4801c = li.l0.p(f4800b, null, null, new x(z2, null), 3);
    }

    public static void v(boolean z2) {
        String strO = o.d.o("updateVideoStateDirect:", z2, "ConnectionManager", "tag", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("ConnectionManager"), strO);
        }
        f4807k.postValue(Boolean.valueOf(z2));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object d(ContinuationImpl continuationImpl) {
        c cVar;
        if (continuationImpl instanceof c) {
            cVar = (c) continuationImpl;
            int i8 = cVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                cVar.label = i8 - Integer.MIN_VALUE;
            } else {
                cVar = new c(this, continuationImpl);
            }
        } else {
            cVar = new c(this, continuationImpl);
        }
        Object obj = cVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = cVar.label;
        if (i9 == 0) {
            ResultKt.throwOnFailure(obj);
            Intrinsics.checkNotNullParameter("ConnectionManager", "tag");
            Intrinsics.checkNotNullParameter("initStateMachine", "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("ConnectionManager"), "initStateMachine");
            }
            q = false;
            li.g2 g2Var = f4811o;
            if (g2Var != null) {
                g2Var.h(null);
            }
            Initial initial = new Initial();
            cVar.label = 1;
            if (c(initial, cVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i9 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        li.g2 g2Var2 = f4811o;
        if (g2Var2 != null) {
            g2Var2.h(null);
        }
        NotificationManager notificationManager = bb.v.f1256a;
        bb.v.a();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object e(Device device, ContinuationImpl continuationImpl) {
        f fVar;
        if (continuationImpl instanceof f) {
            fVar = (f) continuationImpl;
            int i8 = fVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                fVar.label = i8 - Integer.MIN_VALUE;
            } else {
                fVar = new f(this, continuationImpl);
            }
        } else {
            fVar = new f(this, continuationImpl);
        }
        Object obj = fVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = fVar.label;
        if (i9 == 0) {
            ResultKt.throwOnFailure(obj);
            String log = "onPhysicalConnected ip:" + device.f2950d + " targetDevice:" + device;
            Intrinsics.checkNotNullParameter("ConnectionManager", "tag");
            Intrinsics.checkNotNullParameter(log, "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("ConnectionManager"), log);
            }
            li.g2 g2Var = f4811o;
            if (g2Var != null) {
                g2Var.h(null);
            }
            PhysicalConnected physicalConnected = new PhysicalConnected();
            fVar.L$0 = this;
            fVar.L$1 = device;
            fVar.label = 1;
            if (c(physicalConnected, fVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i9 != 1) {
                if (i9 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                if (i9 == 3) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                if (i9 != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            device = (Device) fVar.L$1;
            this = (y) fVar.L$0;
            ResultKt.throwOnFailure(obj);
        }
        this.getClass();
        if (sb.b()) {
            TCCPHandshakeSocketServer tCCPHandshakeSocketServer = l2.f4772a;
            l2.e();
            MainSocketInit mainSocketInit = new MainSocketInit();
            fVar.L$0 = null;
            fVar.L$1 = null;
            fVar.label = 2;
            if (c(mainSocketInit, fVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
        if (!Intrinsics.areEqual(device.f2949c, ExifInterface.GPS_MEASUREMENT_3D)) {
            TCCPHandshakeSocketClient tCCPHandshakeSocketClient = y1.f4826a;
            String str = device.f2950d;
            fVar.L$0 = null;
            fVar.L$1 = null;
            fVar.label = 4;
            if (y1.b(str, fVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
        TCCPHandshakeSocketServer tCCPHandshakeSocketServer2 = l2.f4772a;
        l2.e();
        MainSocketInit mainSocketInit2 = new MainSocketInit();
        fVar.L$0 = null;
        fVar.L$1 = null;
        fVar.label = 3;
        if (c(mainSocketInit2, fVar) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object f(ContinuationImpl continuationImpl) {
        e eVar;
        if (continuationImpl instanceof e) {
            eVar = (e) continuationImpl;
            int i8 = eVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                eVar.label = i8 - Integer.MIN_VALUE;
            } else {
                eVar = new e(this, continuationImpl);
            }
        } else {
            eVar = new e(this, continuationImpl);
        }
        Object obj = eVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = eVar.label;
        if (i9 == 0) {
            ResultKt.throwOnFailure(obj);
            String log = "onPhysicalConnected ip:" + k1.f4767c + " targetDevice:" + k1.e;
            Intrinsics.checkNotNullParameter("ConnectionManager", "tag");
            Intrinsics.checkNotNullParameter(log, "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("ConnectionManager"), log);
            }
            li.g2 g2Var = f4811o;
            if (g2Var != null) {
                g2Var.h(null);
            }
            PhysicalConnected physicalConnected = new PhysicalConnected();
            eVar.L$0 = this;
            eVar.label = 1;
            if (c(physicalConnected, eVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i9 != 1) {
                if (i9 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                if (i9 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            this = (y) eVar.L$0;
            ResultKt.throwOnFailure(obj);
        }
        this.getClass();
        if (!sb.b() && f != 1) {
            TCCPHandshakeSocketClient tCCPHandshakeSocketClient = y1.f4826a;
            String str = k1.f4767c;
            eVar.L$0 = null;
            eVar.label = 3;
            if (y1.b(str, eVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
        TCCPHandshakeSocketServer tCCPHandshakeSocketServer = l2.f4772a;
        l2.e();
        MainSocketInit mainSocketInit = new MainSocketInit();
        eVar.L$0 = null;
        eVar.label = 2;
        if (c(mainSocketInit, eVar) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    public final Object j(String str, boolean z2, Continuation continuation) {
        i iVar;
        if (continuation instanceof i) {
            iVar = (i) continuation;
            int i8 = iVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                iVar.label = i8 - Integer.MIN_VALUE;
            } else {
                iVar = new i(this, continuation);
            }
        } else {
            iVar = new i(this, continuation);
        }
        Object obj = iVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = iVar.label;
        if (i9 == 0) {
            ResultKt.throwOnFailure(obj);
            if (Intrinsics.areEqual(f4804h, new PhysicalDisconnecting()) || Intrinsics.areEqual(f4804h, new Initial())) {
                Intrinsics.checkNotNullParameter("ConnectionManager", "tag");
                Intrinsics.checkNotNullParameter("reset:PhysicalDisconnecting or Initial  return", "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("ConnectionManager"), "reset:PhysicalDisconnecting or Initial  return");
                }
                return Unit.INSTANCE;
            }
            q = true;
            q1 listener = p;
            if (listener != null) {
                Application context = pb.a();
                Intrinsics.checkNotNullParameter(context, "context");
                synchronized (r1.f4793a) {
                    Intrinsics.checkNotNullParameter(context, "context");
                    Intrinsics.checkNotNullParameter(listener, "listener");
                    CopyOnWriteArraySet copyOnWriteArraySet = r1.f4795c;
                    copyOnWriteArraySet.remove(listener);
                    if (r1.f4794b != null && copyOnWriteArraySet.isEmpty()) {
                        Intrinsics.checkNotNullParameter("ScreenStateManager", "tag");
                        Intrinsics.checkNotNullParameter("unregister receiver", "log");
                        if (gc.f6462a <= 4) {
                            Log.i(gc.f6463b.concat("ScreenStateManager"), "unregister receiver");
                        }
                        context.unregisterReceiver(r1.f4794b);
                        r1.f4794b = null;
                    }
                }
                listener.f4788c = null;
            }
            p = null;
            if (StringsKt__StringsKt.contains$default(str, "remote accept disconnect", false, 2, (Object) null)) {
                ob.b.f8417b.f8437a.getClass();
                Bundle bundle = new Bundle();
                bundle.putString("device_type", tj.w.B());
                tj.w.X("pad_connection_connection_end_by_user", bundle);
                Intrinsics.checkNotNullParameter("ConnectionManager", "tag");
                Intrinsics.checkNotNullParameter("disConnect by user", "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("ConnectionManager"), "disConnect by user");
                }
            } else {
                ob.b.f8417b.f8437a.getClass();
                Bundle bundle2 = new Bundle();
                bundle2.putString("device_type", tj.w.B());
                tj.w.X("pad_connection_lost_connection_automatic", bundle2);
                Intrinsics.checkNotNullParameter("ConnectionManager", "tag");
                Intrinsics.checkNotNullParameter("disConnect automatically", "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("ConnectionManager"), "disConnect automatically");
                }
            }
            i("reset from " + str);
            if (sb.b()) {
                TCCPHandshakeSocketServer tCCPHandshakeSocketServer = l2.f4772a;
                l2.f();
                x7.i iVar2 = x7.i.f10886a;
                x7.i.b();
            } else {
                TCCPHandshakeSocketClient tCCPHandshakeSocketClient = y1.f4826a;
                y1.c();
                x7.i iVar3 = x7.i.f10886a;
                Intrinsics.checkNotNullParameter("SourceServiceConnectHelper", "tag");
                Intrinsics.checkNotNullParameter("disconnectTCCPServer", "log");
                if (gc.f6462a <= 3) {
                    Log.d(gc.f6463b.concat("SourceServiceConnectHelper"), "disconnectTCCPServer");
                }
                TCCPSourceApi tCCPSourceApi = x7.f.f10882a;
                Intrinsics.checkNotNullParameter("ConnectSdkProxy", "tag");
                Intrinsics.checkNotNullParameter("disconnectTCCPServer", "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("ConnectSdkProxy"), "disconnectTCCPServer");
                }
                x7.f.f10882a.disconnectTccpServer();
            }
            try {
                Intrinsics.checkNotNullParameter("ConnectionManager", "tag");
                Intrinsics.checkNotNullParameter("resetStateToInitial", "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("ConnectionManager"), "resetStateToInitial");
                }
                li.g2 g2Var = f4811o;
                if (g2Var != null) {
                    g2Var.h(null);
                }
                f4811o = li.l0.p(f4800b, si.e.f10118a, null, new j(null), 2);
                Lazy lazy = mc.b.f7958a;
                ag.b listener2 = new ag.b(6);
                Intrinsics.checkNotNullParameter(listener2, "listener");
                mc.b.f7968m = listener2;
            } catch (Exception unused) {
                Intrinsics.checkNotNullParameter("ConnectionManager", "tag");
                Intrinsics.checkNotNullParameter("resetStateToInitial:exception", "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("ConnectionManager"), "resetStateToInitial:exception");
                }
            }
            iVar.Z$0 = z2;
            iVar.label = 1;
            if (l(iVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i9 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            z2 = iVar.Z$0;
            ResultKt.throwOnFailure(obj);
        }
        k1 k1Var = k1.f4765a;
        k1.j("none");
        DeviceConnectState.INSTANCE.refreshCastState(0);
        if (!f4803g) {
            y0 y0Var = y0.f4813a;
            y0.c("ConnectionManagerreset", z2);
        }
        u7.a.b();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0072 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object l(ContinuationImpl continuationImpl) {
        l lVar;
        if (continuationImpl instanceof l) {
            lVar = (l) continuationImpl;
            int i8 = lVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                lVar.label = i8 - Integer.MIN_VALUE;
            } else {
                lVar = new l(this, continuationImpl);
            }
        } else {
            lVar = new l(this, continuationImpl);
        }
        Object obj = lVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = lVar.label;
        if (i9 == 0) {
            ResultKt.throwOnFailure(obj);
            i("sendDisconnectPhysicalConnectEvent");
            if (f4804h.compareTo((BaseState) new PhysicalConnecting()) >= 0 && !Intrinsics.areEqual(f4804h, new PhysicalDisconnecting())) {
                PhysicalDisconnecting physicalDisconnecting = new PhysicalDisconnecting();
                lVar.label = 1;
                if (c(physicalDisconnecting, lVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                k1 k1Var = k1.f4765a;
                lVar.label = 2;
                if (k1.i() == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i9 == 1) {
            ResultKt.throwOnFailure(obj);
            k1 k1Var2 = k1.f4765a;
            lVar.label = 2;
            if (k1.i() == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i9 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        x7.i iVar = x7.i.f10886a;
        x7.i.a(pb.a());
        return Unit.INSTANCE;
    }

    public final synchronized void n() {
        Intrinsics.checkNotNullParameter("ConnectionManager", "tag");
        Intrinsics.checkNotNullParameter("sendTccpConnectSuccessEvent", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("ConnectionManager"), "sendTccpConnectSuccessEvent");
        }
        i("sendConnectCapabilitySocketSuccessEvent");
        li.l0.p(f4800b, null, null, new q(null), 3);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object p(Function1 function1, ContinuationImpl continuationImpl) {
        r rVar;
        Unit unit;
        if (continuationImpl instanceof r) {
            rVar = (r) continuationImpl;
            int i8 = rVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                rVar.label = i8 - Integer.MIN_VALUE;
            } else {
                rVar = new r(this, continuationImpl);
            }
        } else {
            rVar = new r(this, continuationImpl);
        }
        Object obj = rVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = rVar.label;
        if (i9 != 0) {
            if (i9 == 1) {
                function1 = (Function1) rVar.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i9 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Boxing.boxBoolean(true);
        }
        ResultKt.throwOnFailure(obj);
        i("startBleScan");
        if (!Intrinsics.areEqual(f4804h, new Initial())) {
            return Boxing.boxBoolean(false);
        }
        PhysicalScanning physicalScanning = new PhysicalScanning();
        rVar.L$0 = function1;
        rVar.label = 1;
        if (c(physicalScanning, rVar) == coroutine_suspended) {
            return coroutine_suspended;
        }
        o1 o1Var = o1.f4782a;
        rVar.L$0 = null;
        rVar.label = 2;
        if (o1.e) {
            Intrinsics.checkNotNullParameter("ScanManager", "tag");
            Intrinsics.checkNotNullParameter("startScan:already scanning", "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("ScanManager"), "startScan:already scanning");
            }
            unit = Unit.INSTANCE;
        } else {
            li.l0.p(o1.f4784c, null, null, new n1(function1, null), 3);
            unit = Unit.INSTANCE;
        }
        if (unit == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Boxing.boxBoolean(true);
    }

    public final Object q(SuspendLambda suspendLambda) {
        Object objD;
        Intrinsics.checkNotNullParameter("ConnectionManager", "tag");
        Intrinsics.checkNotNullParameter("stopBleScan", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("ConnectionManager"), "stopBleScan");
        }
        o1 o1Var = o1.f4782a;
        o1.b();
        return (Intrinsics.areEqual(f4804h, new PhysicalScanning()) && (objD = d(suspendLambda)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? objD : Unit.INSTANCE;
    }
}
