package ph;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;
import bb.s;
import bb.w;
import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.iotservice.multiscreen.pc.socket.EventListener;
import com.transsion.iotservice.multiscreen.pc.socket.TCCPHandshakeSocketClient;
import com.transsion.iotservice.multiscreen.pc.socket.tccp.config.TccpConfig;
import com.transsion.iotservice.multiscreen.pc.socket.tccp.pack.bean.TCCPPacket;
import com.transsion.iotservice.multiscreen.pc.socket.tccp.pack.bean.TccpDisConnectSocketBean;
import com.transsion.iotservice.multiscreen.pc.socket.tccp.pack.bean.TccpHeartBeat;
import com.transsion.iotservice.multiscreen.pc.socket.tccp.pack.bean.TccpRequestConnectBean;
import com.transsion.iotservice.multiscreen.pc.socket.tccp.pack.bean.TccpResponseConnectBean;
import com.transsion.iotservice.multiscreen.pc.socket.tccp.pack.bean.TccpScreenLockRequestBean;
import com.transsion.iotservice.multiscreen.pc.socket.tccp.pack.bean.TccpSwitchAbilityBean;
import com.transsion.iotservice.multiscreen.pc.socket.tccp.pack.bean.TccpSwitchSdkInitPortBean;
import com.transsion.iotservice.multiscreen.pc.socket.tccp.pack.bean.TccpSwitchSdkInitPortResponseBean;
import com.transsion.iotservice.multiscreen.pc.state.BaseState;
import com.transsion.iotservice.multiscreen.pc.state.DeviceConnectState;
import com.transsion.iotservice.multiscreen.pc.state.MainSocketConnected;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.UsbConnectFailDialog;
import dk.g;
import eb.a0;
import eb.k1;
import eb.m;
import eb.n;
import eb.u1;
import eb.y;
import eb.y1;
import eb.z;
import g3.d;
import java.util.List;
import k3.gc;
import k3.gd;
import k3.pb;
import k3.qb;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import li.g2;
import li.l0;
import na.k;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements EventListener, d, ek.b, m1.b, w {
    @Override // m1.b
    public boolean a(float f) {
        throw new IllegalStateException("not implemented");
    }

    @Override // m1.b
    public x1.a b() {
        throw new IllegalStateException("not implemented");
    }

    @Override // m1.b
    public boolean c(float f) {
        return false;
    }

    @Override // ek.b
    /* JADX INFO: renamed from: call */
    public void mo0call(Object obj) {
        throw new g((Throwable) obj);
    }

    @Override // bb.w
    public void d(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.pcconnection.online"));
        intent.addFlags(268435456);
        pb.a().startActivity(intent);
        Intrinsics.checkNotNullParameter("UsbConnectFailViewModel", "tag");
        Intrinsics.checkNotNullParameter("Successfully opened download link", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("UsbConnectFailViewModel"), "Successfully opened download link");
        }
    }

    @Override // m1.b
    public float e() {
        return 0.0f;
    }

    @Override // g3.d
    public g3.c f(Context context, String str, g3.b bVar) {
        g3.c cVar = new g3.c();
        int iA = bVar.a(context, str, true);
        cVar.f5095b = iA;
        if (iA != 0) {
            cVar.f5096c = 1;
        } else {
            int iB = bVar.b(context, str);
            cVar.f5094a = iB;
            if (iB != 0) {
                cVar.f5096c = -1;
            }
        }
        return cVar;
    }

    @Override // m1.b
    public float g() {
        return 1.0f;
    }

    @Override // m1.b
    public boolean isEmpty() {
        return true;
    }

    @Override // com.transsion.iotservice.multiscreen.pc.socket.EventListener
    public void onConnected() {
        Intrinsics.checkNotNullParameter("SocketClientManager", "tag");
        Intrinsics.checkNotNullParameter("onConnected", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("SocketClientManager"), "onConnected");
        }
        g2 g2Var = y1.f4827b;
        if (g2Var != null) {
            g2Var.h(null);
        }
        y yVar = y.f4799a;
        y.i("sendConnectMainSocketSuccessEvent");
        l0.p(y.f4800b, null, null, new n(null), 3);
    }

    @Override // com.transsion.iotservice.multiscreen.pc.socket.EventListener
    public void onDisconnected() {
        Intrinsics.checkNotNullParameter("SocketClientManager", "tag");
        Intrinsics.checkNotNullParameter("onDisconnected", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("SocketClientManager"), "onDisconnected");
        }
        y yVar = y.f4799a;
        if (y.f4804h.compareTo((BaseState) new MainSocketConnected()) >= 0) {
            return;
        }
        y.i("sendHandshakeConnectFailEvent");
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
            k kVar = k.f8141a;
            Application applicationA = pb.a();
            String string = pb.a().getString(R$string.toast_usb_connect_fail);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            kVar.b(applicationA, string);
        }
        l0.p(y.f4800b, null, null, new m(null), 3);
        y1.f4826a = null;
        g2 g2Var = a0.f4743a;
        Intrinsics.checkNotNullParameter("HeartBeatTimeoutChecker", "tag");
        Intrinsics.checkNotNullParameter("stopTimer", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("HeartBeatTimeoutChecker"), "stopTimer");
        }
        g2 g2Var2 = a0.f4743a;
        if (g2Var2 != null) {
            g2Var2.h(null);
        }
    }

    @Override // com.transsion.iotservice.multiscreen.pc.socket.EventListener
    public void onReceiveRequest(TCCPPacket request) {
        Intrinsics.checkNotNullParameter(request, "request");
        String log = "onReceiveRequest:" + request;
        Intrinsics.checkNotNullParameter("SocketClientManager", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("SocketClientManager"), log);
        }
        TCCPHandshakeSocketClient tCCPHandshakeSocketClient = y1.f4826a;
        String log2 = "onHandlePeerRequest:" + request;
        Intrinsics.checkNotNullParameter("SocketClientManager", "tag");
        Intrinsics.checkNotNullParameter(log2, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("SocketClientManager"), log2);
        }
        int iA = qb.a(request.getOperationFlag());
        TccpConfig tccpConfig = TccpConfig.INSTANCE;
        DefaultConstructorMarker defaultConstructorMarker = null;
        if (iA == qb.a(tccpConfig.getSWITCH_ABILITY_FLAG())) {
            TccpSwitchAbilityBean tccpSwitchAbilityBean = (TccpSwitchAbilityBean) request.getPayload(TccpSwitchAbilityBean.class);
            if (tccpSwitchAbilityBean == null) {
                Intrinsics.checkNotNullParameter("SocketClientManager", "tag");
                Intrinsics.checkNotNullParameter("handleOnExchangeAbilityReq payload is null.", "log");
                if (gc.f6462a <= 6) {
                    Log.e(gc.f6463b.concat("SocketClientManager"), "handleOnExchangeAbilityReq payload is null.");
                    return;
                }
                return;
            }
            String log3 = "handleOnExchangeAbilityReq:" + tccpSwitchAbilityBean;
            Intrinsics.checkNotNullParameter("SocketClientManager", "tag");
            Intrinsics.checkNotNullParameter(log3, "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("SocketClientManager"), log3);
            }
            k1 k1Var = k1.f4765a;
            int iE = k1.e();
            List list = eb.a.f4742a;
            eb.a.b(iE, tccpSwitchAbilityBean.getContents());
            TCCPHandshakeSocketClient tCCPHandshakeSocketClient2 = y1.f4826a;
            if (tCCPHandshakeSocketClient2 != null) {
                tCCPHandshakeSocketClient2.sendResponse(tccpConfig.getSWITCH_ABILITY_FLAG(), new TccpSwitchAbilityBean(eb.a.a(), 0, 2, defaultConstructorMarker));
            }
            y1.f();
            return;
        }
        if (iA == qb.a(tccpConfig.getSDK_INIT_PORT())) {
            y1.e = System.currentTimeMillis();
            TccpSwitchSdkInitPortBean tccpSwitchSdkInitPortBean = (TccpSwitchSdkInitPortBean) request.getPayload(TccpSwitchSdkInitPortBean.class);
            if (tccpSwitchSdkInitPortBean == null) {
                Intrinsics.checkNotNullParameter("SocketClientManager", "tag");
                Intrinsics.checkNotNullParameter("handlePeerSdkInitReq payload is null.", "log");
                if (gc.f6462a <= 6) {
                    Log.e(gc.f6463b.concat("SocketClientManager"), "handlePeerSdkInitReq payload is null.");
                    return;
                }
                return;
            }
            String log4 = "handlePeerSdkInitReq:" + tccpSwitchSdkInitPortBean;
            Intrinsics.checkNotNullParameter("SocketClientManager", "tag");
            Intrinsics.checkNotNullParameter(log4, "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("SocketClientManager"), log4);
            }
            y1.f = tccpSwitchSdkInitPortBean.getDeviceName();
            TCCPHandshakeSocketClient tCCPHandshakeSocketClient3 = y1.f4826a;
            if (tCCPHandshakeSocketClient3 != null) {
                tCCPHandshakeSocketClient3.sendResponse(tccpConfig.getSDK_INIT_PORT(), new TccpSwitchSdkInitPortResponseBean(null, null, null, null, null, null, 63, null));
            }
            DeviceConnectState.INSTANCE.refreshCastState(1);
            l0.p(y1.f4828c, null, null, new u1(tccpSwitchSdkInitPortBean, null), 3);
            return;
        }
        if (iA == qb.a(tccpConfig.getSCAN_CONFIRM_FLAG())) {
            if (((TccpRequestConnectBean) request.getPayload(TccpRequestConnectBean.class)) == null) {
                Intrinsics.checkNotNullParameter("SocketClientManager", "tag");
                Intrinsics.checkNotNullParameter("handlePeerConnectReq payload is null.", "log");
                if (gc.f6462a <= 6) {
                    Log.e(gc.f6463b.concat("SocketClientManager"), "handlePeerConnectReq payload is null.");
                    return;
                }
                return;
            }
            y yVar = y.f4799a;
            int i8 = y.f;
            String BRAND = Build.BRAND;
            Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
            Application context = pb.a();
            Intrinsics.checkNotNullParameter(context, "context");
            String string = Settings.Global.getString(context.getContentResolver(), "device_name");
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            TccpResponseConnectBean tccpResponseConnectBean = new TccpResponseConnectBean(1, false, i8, BRAND, string, ma.b.f7956b.f7957a.e());
            TCCPHandshakeSocketClient tCCPHandshakeSocketClient4 = y1.f4826a;
            if (tCCPHandshakeSocketClient4 != null) {
                tCCPHandshakeSocketClient4.sendResponse(tccpConfig.getSCAN_CONFIRM_FLAG(), tccpResponseConnectBean);
                return;
            }
            return;
        }
        if (iA == qb.a(tccpConfig.getDISCONNECT_SOCKET())) {
            TccpDisConnectSocketBean tccpDisConnectSocketBean = (TccpDisConnectSocketBean) request.getPayload(TccpDisConnectSocketBean.class);
            if (tccpDisConnectSocketBean == null) {
                Intrinsics.checkNotNullParameter("SocketClientManager", "tag");
                Intrinsics.checkNotNullParameter("handleDisconnectSocketReq payload is null.", "log");
                if (gc.f6462a <= 6) {
                    Log.e(gc.f6463b.concat("SocketClientManager"), "handleDisconnectSocketReq payload is null.");
                    return;
                }
                return;
            }
            if (tccpDisConnectSocketBean.isDisconnect()) {
                TCCPHandshakeSocketClient tCCPHandshakeSocketClient5 = y1.f4826a;
                if (tCCPHandshakeSocketClient5 != null) {
                    tCCPHandshakeSocketClient5.sendResponse(tccpConfig.getDISCONNECT_SOCKET(), new TccpDisConnectSocketBean(true));
                    return;
                }
                return;
            }
            Intrinsics.checkNotNullParameter("SocketClientManager", "tag");
            Intrinsics.checkNotNullParameter("handleDisconnectSocketReq is not disconnect", "log");
            if (gc.f6462a <= 6) {
                Log.e(gc.f6463b.concat("SocketClientManager"), "handleDisconnectSocketReq is not disconnect");
                return;
            }
            return;
        }
        if (iA == qb.a(tccpConfig.getHEARTBEAT_TCCP())) {
            TccpHeartBeat tccpHeartBeat = (TccpHeartBeat) request.getPayload(TccpHeartBeat.class);
            if (tccpHeartBeat == null) {
                Intrinsics.checkNotNullParameter("SocketClientManager", "tag");
                Intrinsics.checkNotNullParameter("handleHeartbeatReq payload is null.", "log");
                if (gc.f6462a <= 6) {
                    Log.e(gc.f6463b.concat("SocketClientManager"), "handleHeartbeatReq payload is null.");
                    return;
                }
                return;
            }
            g2 g2Var = a0.f4743a;
            long heartbeatInterval = tccpHeartBeat.getHeartbeatInterval();
            s onTimeout = y1.f4831h;
            Intrinsics.checkNotNullParameter(onTimeout, "onTimeout");
            String log5 = "startTimer, timeout:" + heartbeatInterval;
            Intrinsics.checkNotNullParameter("HeartBeatTimeoutChecker", "tag");
            Intrinsics.checkNotNullParameter(log5, "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("HeartBeatTimeoutChecker"), log5);
            }
            a0.f4745c = heartbeatInterval * ((long) 5);
            g2 g2Var2 = a0.f4743a;
            if (g2Var2 != null) {
                g2Var2.h(null);
            }
            a0.f4743a = l0.p(a0.f4744b, null, null, new z(onTimeout, null), 3);
            TCCPHandshakeSocketClient tCCPHandshakeSocketClient6 = y1.f4826a;
            if (tCCPHandshakeSocketClient6 != null) {
                tCCPHandshakeSocketClient6.sendResponse(tccpConfig.getHEARTBEAT_TCCP(), "");
                return;
            }
            return;
        }
        if (iA == qb.a(tccpConfig.getLOCKSCREEN_TCCP())) {
            TccpScreenLockRequestBean tccpScreenLockRequestBean = (TccpScreenLockRequestBean) request.getPayload(TccpScreenLockRequestBean.class);
            if (tccpScreenLockRequestBean == null) {
                Intrinsics.checkNotNullParameter("SocketClientManager", "tag");
                Intrinsics.checkNotNullParameter("handleLockScreenNotifyReq payload is null.", "log");
                if (gc.f6462a <= 6) {
                    Log.e(gc.f6463b.concat("SocketClientManager"), "handleLockScreenNotifyReq payload is null.");
                    return;
                }
                return;
            }
            y yVar2 = y.f4799a;
            String strO = o.d.o("onRemoteDeviceScreenStateChanged:", tccpScreenLockRequestBean.getLockScreen(), "ConnectionManager", "tag", "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("ConnectionManager"), strO);
                return;
            }
            return;
        }
        if (iA == qb.a(tccpConfig.getWIFI_FREQUENCY_STATE())) {
            y1.f();
            return;
        }
        if (iA == qb.a(tccpConfig.getREQUEST_DISCONNECT())) {
            String log6 = "handleRequestDisconnectReq:" + request;
            Intrinsics.checkNotNullParameter("SocketClientManager", "tag");
            Intrinsics.checkNotNullParameter(log6, "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("SocketClientManager"), log6);
            }
            y1.e();
        }
    }

    @Override // com.transsion.iotservice.multiscreen.pc.socket.EventListener
    public void onReceiveResponse(TCCPPacket response) {
        Intrinsics.checkNotNullParameter(response, "response");
        String log = "onReceiveResponse:" + response;
        Intrinsics.checkNotNullParameter("SocketClientManager", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("SocketClientManager"), log);
        }
        TCCPHandshakeSocketClient tCCPHandshakeSocketClient = y1.f4826a;
        String log2 = "onHandlePeerResponse:" + response;
        Intrinsics.checkNotNullParameter("SocketClientManager", "tag");
        Intrinsics.checkNotNullParameter(log2, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("SocketClientManager"), log2);
        }
        if (qb.a(response.getOperationFlag()) == qb.a(TccpConfig.INSTANCE.getDISCONNECT_SOCKET())) {
            y1.d("remote accept disconnect");
        }
    }
}
