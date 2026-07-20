package eb;

import android.app.Application;
import android.content.Intent;
import android.util.Log;
import com.transsion.connectx.sdk.TCCPSourceApi;
import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.iotservice.multiscreen.pc.socket.TCCPHandshakeSocketServer;
import com.transsion.iotservice.multiscreen.pc.socket.tccp.config.TccpConfig;
import com.transsion.iotservice.multiscreen.pc.socket.tccp.pack.bean.TccpSwitchAbilityBean;
import com.transsion.iotservice.multiscreen.pc.socket.tccp.pack.bean.TccpSwitchSdkInitPortBean;
import com.transsion.iotservice.multiscreen.pc.state.DeviceConnectState;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.CommonDialog;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import k3.gc;
import k3.pb;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes2.dex */
public final class c2 extends SuspendLambda implements Function2 {
    final /* synthetic */ TccpSwitchAbilityBean $result;
    int I$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c2(TccpSwitchAbilityBean tccpSwitchAbilityBean, Continuation<? super c2> continuation) {
        super(2, continuation);
        this.$result = tccpSwitchAbilityBean;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new c2(this.$result, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0090  */
    /* JADX WARN: Code duplicated, block: B:33:0x00af  */
    /* JADX WARN: Code duplicated, block: B:34:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:49:0x018e  */
    /* JADX WARN: Code duplicated, block: B:55:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:57:0x01da  */
    /* JADX WARN: Code duplicated, block: B:60:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:67:0x0218  */
    /* JADX WARN: Code duplicated, block: B:70:0x0225  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE;
        Object objF;
        int i8;
        int port;
        String strM;
        TCCPHandshakeSocketServer tCCPHandshakeSocketServer;
        pa.a aVar;
        o6.a aVar2;
        hc.c cVar;
        Integer numValueOf;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = this.label;
        if (i9 != 0) {
            if (i9 == 1) {
                ResultKt.throwOnFailure(obj);
                objE = obj;
            } else {
                if (i9 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i10 = this.I$0;
                ResultKt.throwOnFailure(obj);
                objF = obj;
                i8 = i10;
            }
            port = ((q7.e) objF).getPort();
            List list = a.f4742a;
            a.b(i8, this.$result.getContents());
            if (o7.a.c("com.transsion.heartbeat")) {
                l2.f4779j.start();
            }
            if (!o7.a.c("com.transsion.extendscreen_v3") && k3.l1.b()) {
                TCCPHandshakeSocketServer tCCPHandshakeSocketServer2 = l2.f4772a;
                k1 k1Var = k1.f4765a;
                cVar = k1.e;
                if (cVar != null) {
                    numValueOf = Integer.valueOf(cVar.f5289d);
                } else {
                    numValueOf = null;
                }
                String str = "TECNO PC Manager";
                if ((numValueOf != null || numValueOf.intValue() != 3) && numValueOf != null && numValueOf.intValue() == 4) {
                }
                String str2 = CommonDialog.f2728c;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = pb.a().getString(R$string.capability_not_support_dialog_title);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                String title = String.format(string, Arrays.copyOf(new Object[]{str}, 1));
                Intrinsics.checkNotNullExpressionValue(title, "format(...)");
                Intrinsics.checkNotNullParameter(title, "title");
                CommonDialog.f2728c = title;
                String string2 = pb.a().getString(R$string.capability_not_support_dialog_desc);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                String message = String.format(string2, Arrays.copyOf(new Object[]{str, pb.a().getResources().getString(R$string.module_pc_expand_screen_title), pb.a().getResources().getString(R$string.module_pc_get_our_pc_connect_www)}, 3));
                Intrinsics.checkNotNullExpressionValue(message, "format(...)");
                Intrinsics.checkNotNullParameter(message, "message");
                CommonDialog.f2729d = message;
                String negativeButton = pb.a().getString(R$string.capability_not_support_dialog_cancel);
                Intrinsics.checkNotNullExpressionValue(negativeButton, "getString(...)");
                Intrinsics.checkNotNullParameter(negativeButton, "negativeButton");
                CommonDialog.f2730h = negativeButton;
                String positiveButton = pb.a().getString(R$string.capability_not_support_dialog_ok);
                Intrinsics.checkNotNullExpressionValue(positiveButton, "getString(...)");
                Intrinsics.checkNotNullParameter(positiveButton, "positiveButton");
                CommonDialog.e = positiveButton;
                ag.b listener = new ag.b(9);
                Intrinsics.checkNotNullParameter(listener, "listener");
                CommonDialog.f2731i = listener;
                Application context = pb.a();
                Intrinsics.checkNotNullParameter(context, "context");
                Intent intent = new Intent(context, (Class<?>) CommonDialog.class);
                intent.setFlags(268435456);
                context.startActivity(intent);
            }
            if (((v7.a) o7.a.b("com.transsion.screen_control")) != null) {
                j3.z screenControl = l2.f4781l;
                Intrinsics.checkNotNullParameter(screenControl, "listener");
                int i11 = w7.d.f10679a;
                Intrinsics.checkNotNullParameter(screenControl, "screenControl");
                w7.d.f10682d = screenControl;
                aVar = pa.a.f8703a;
                if (!pa.a.j("ro.tr_project.flip_screen.support") || pa.a.j("ro.tr_project.foldable_screen.support")) {
                    ag.q displayFoldChangeCallback = new ag.q(18);
                    aVar2 = w7.d.f10680b;
                    aVar2.getClass();
                    Intrinsics.checkNotNullParameter(displayFoldChangeCallback, "displayFoldChangeCallback");
                    ((AtomicBoolean) aVar2.f8409d).compareAndSet(false, true);
                    Intrinsics.checkNotNullParameter("FoldChangeHelper", "tag");
                    Intrinsics.checkNotNullParameter("registerDisplayFoldListener", "log");
                    if (gc.f6462a <= 3) {
                        Log.d(gc.f6463b.concat("FoldChangeHelper"), "registerDisplayFoldListener");
                    }
                    aVar2.f8407b = displayFoldChangeCallback;
                    if (((lc.a) aVar2.e) == null) {
                        lc.a aVar3 = new lc.a(aVar2, 2);
                        aVar2.e = aVar3;
                        try {
                            aVar.c(aVar3);
                        } catch (Throwable e) {
                            Intrinsics.checkNotNullParameter("FoldChangeHelper", "tag");
                            Intrinsics.checkNotNullParameter(e, "e");
                            Log.e(gc.f6463b.concat("FoldChangeHelper"), e.getMessage(), e);
                        }
                    }
                } else {
                    w7.d.a();
                }
            }
            strM = o.d.m("switch sdk init port:", "SocketServerManager", "tag", "log", port);
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("SocketServerManager"), strM);
            }
            tCCPHandshakeSocketServer = l2.f4772a;
            if (tCCPHandshakeSocketServer != null) {
                tCCPHandshakeSocketServer.sendRequest(TccpConfig.INSTANCE.getSDK_INIT_PORT(), new TccpSwitchSdkInitPortBean(port, null, null, null, i8, null, null, null, 238, null));
            }
            x7.f.g(new se.h());
            x7.i iVar = x7.i.f10886a;
            x7.i.d(new i2());
            x7.i.c(new h2());
            String packageName = pb.a().getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
            x7.i.e(packageName, new bd.b());
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        DeviceConnectState.INSTANCE.refreshCastState(1);
        TCCPSourceApi tCCPSourceApi = x7.f.f10882a;
        this.label = 1;
        objE = x7.f.e(this);
        if (objE == coroutine_suspended) {
            return coroutine_suspended;
        }
        if (!((Boolean) objE).booleanValue()) {
            Intrinsics.checkNotNullParameter("SocketServerManager", "tag");
            Intrinsics.checkNotNullParameter("Connect source-server fail", "log");
            if (gc.f6462a <= 6) {
                Log.e(gc.f6463b.concat("SocketServerManager"), "Connect source-server fail");
            }
            return Unit.INSTANCE;
        }
        k1 k1Var2 = k1.f4765a;
        int iE = k1.e();
        x7.i iVar2 = x7.i.f10886a;
        String str3 = k1.f4767c;
        this.I$0 = iE;
        this.label = 2;
        objF = iVar2.f(iE, str3, this);
        if (objF == coroutine_suspended) {
            return coroutine_suspended;
        }
        i8 = iE;
        port = ((q7.e) objF).getPort();
        List list2 = a.f4742a;
        a.b(i8, this.$result.getContents());
        if (o7.a.c("com.transsion.heartbeat")) {
            l2.f4779j.start();
        }
        if (!o7.a.c("com.transsion.extendscreen_v3")) {
            TCCPHandshakeSocketServer tCCPHandshakeSocketServer3 = l2.f4772a;
            k1 k1Var3 = k1.f4765a;
            cVar = k1.e;
            if (cVar != null) {
                numValueOf = Integer.valueOf(cVar.f5289d);
            } else {
                numValueOf = null;
            }
            String str4 = "TECNO PC Manager";
            str4 = numValueOf != null ? "PC Client" : "PC Client";
            String str5 = CommonDialog.f2728c;
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String string3 = pb.a().getString(R$string.capability_not_support_dialog_title);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            String title2 = String.format(string3, Arrays.copyOf(new Object[]{str4}, 1));
            Intrinsics.checkNotNullExpressionValue(title2, "format(...)");
            Intrinsics.checkNotNullParameter(title2, "title");
            CommonDialog.f2728c = title2;
            String string4 = pb.a().getString(R$string.capability_not_support_dialog_desc);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            String message2 = String.format(string4, Arrays.copyOf(new Object[]{str4, pb.a().getResources().getString(R$string.module_pc_expand_screen_title), pb.a().getResources().getString(R$string.module_pc_get_our_pc_connect_www)}, 3));
            Intrinsics.checkNotNullExpressionValue(message2, "format(...)");
            Intrinsics.checkNotNullParameter(message2, "message");
            CommonDialog.f2729d = message2;
            String negativeButton2 = pb.a().getString(R$string.capability_not_support_dialog_cancel);
            Intrinsics.checkNotNullExpressionValue(negativeButton2, "getString(...)");
            Intrinsics.checkNotNullParameter(negativeButton2, "negativeButton");
            CommonDialog.f2730h = negativeButton2;
            String positiveButton2 = pb.a().getString(R$string.capability_not_support_dialog_ok);
            Intrinsics.checkNotNullExpressionValue(positiveButton2, "getString(...)");
            Intrinsics.checkNotNullParameter(positiveButton2, "positiveButton");
            CommonDialog.e = positiveButton2;
            ag.b listener2 = new ag.b(9);
            Intrinsics.checkNotNullParameter(listener2, "listener");
            CommonDialog.f2731i = listener2;
            Application context2 = pb.a();
            Intrinsics.checkNotNullParameter(context2, "context");
            Intent intent2 = new Intent(context2, (Class<?>) CommonDialog.class);
            intent2.setFlags(268435456);
            context2.startActivity(intent2);
        }
        if (((v7.a) o7.a.b("com.transsion.screen_control")) != null) {
            j3.z screenControl2 = l2.f4781l;
            Intrinsics.checkNotNullParameter(screenControl2, "listener");
            int i12 = w7.d.f10679a;
            Intrinsics.checkNotNullParameter(screenControl2, "screenControl");
            w7.d.f10682d = screenControl2;
            aVar = pa.a.f8703a;
            if (pa.a.j("ro.tr_project.flip_screen.support")) {
                ag.q displayFoldChangeCallback2 = new ag.q(18);
                aVar2 = w7.d.f10680b;
                aVar2.getClass();
                Intrinsics.checkNotNullParameter(displayFoldChangeCallback2, "displayFoldChangeCallback");
                ((AtomicBoolean) aVar2.f8409d).compareAndSet(false, true);
                Intrinsics.checkNotNullParameter("FoldChangeHelper", "tag");
                Intrinsics.checkNotNullParameter("registerDisplayFoldListener", "log");
                if (gc.f6462a <= 3) {
                    Log.d(gc.f6463b.concat("FoldChangeHelper"), "registerDisplayFoldListener");
                }
                aVar2.f8407b = displayFoldChangeCallback2;
                if (((lc.a) aVar2.e) == null) {
                    lc.a aVar4 = new lc.a(aVar2, 2);
                    aVar2.e = aVar4;
                    aVar.c(aVar4);
                }
            } else {
                ag.q displayFoldChangeCallback3 = new ag.q(18);
                aVar2 = w7.d.f10680b;
                aVar2.getClass();
                Intrinsics.checkNotNullParameter(displayFoldChangeCallback3, "displayFoldChangeCallback");
                ((AtomicBoolean) aVar2.f8409d).compareAndSet(false, true);
                Intrinsics.checkNotNullParameter("FoldChangeHelper", "tag");
                Intrinsics.checkNotNullParameter("registerDisplayFoldListener", "log");
                if (gc.f6462a <= 3) {
                    Log.d(gc.f6463b.concat("FoldChangeHelper"), "registerDisplayFoldListener");
                }
                aVar2.f8407b = displayFoldChangeCallback3;
                if (((lc.a) aVar2.e) == null) {
                    lc.a aVar5 = new lc.a(aVar2, 2);
                    aVar2.e = aVar5;
                    aVar.c(aVar5);
                }
            }
        }
        strM = o.d.m("switch sdk init port:", "SocketServerManager", "tag", "log", port);
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("SocketServerManager"), strM);
        }
        tCCPHandshakeSocketServer = l2.f4772a;
        if (tCCPHandshakeSocketServer != null) {
            tCCPHandshakeSocketServer.sendRequest(TccpConfig.INSTANCE.getSDK_INIT_PORT(), new TccpSwitchSdkInitPortBean(port, null, null, null, i8, null, null, null, 238, null));
        }
        x7.f.g(new se.h());
        x7.i iVar3 = x7.i.f10886a;
        x7.i.d(new i2());
        x7.i.c(new h2());
        String packageName2 = pb.a().getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName2, "getPackageName(...)");
        x7.i.e(packageName2, new bd.b());
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((c2) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
