package bb;

import android.R;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import bb.s;
import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.iotservice.multiscreen.pc.bean.ConnectedDevice;
import com.transsion.iotservice.multiscreen.pc.helper.BaseSettingActivity;
import com.transsion.iotservice.multiscreen.pc.socket.TCCPHandshakeSocketServer;
import com.transsion.iotservice.multiscreen.pc.socket.tccp.config.TccpConfig;
import com.transsion.iotservice.multiscreen.pc.socket.tccp.pack.bean.TccpRequestNetworkSharingStateChangeBean;
import com.transsion.iotservice.multiscreen.pc.state.DeviceConnectState;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.DialogUtilActivity;
import com.transsion.iotservice.multiscreen.pc.ui.trust.TrustDevicesActivity;
import eb.g0;
import eb.l2;
import java.util.LinkedHashMap;
import k3.gc;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseSettingActivity f1239a;

    public l(BaseSettingActivity baseSettingActivity) {
        this.f1239a = baseSettingActivity;
    }

    public final void a(boolean z2) {
        int i8 = BaseSettingActivity.f2662k;
        this.f1239a.p(z2);
    }

    public final void b() {
        Intrinsics.checkNotNullParameter("BaseSettingActivity", "tag");
        Intrinsics.checkNotNullParameter("onJumpToTrustDevicesPage", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("BaseSettingActivity"), "onJumpToTrustDevicesPage");
        }
        BaseSettingActivity baseSettingActivity = this.f1239a;
        baseSettingActivity.startActivity(new Intent(baseSettingActivity, (Class<?>) TrustDevicesActivity.class));
    }

    public final void c() {
        ld.m mVarA;
        int i8 = 1;
        Intrinsics.checkNotNullParameter("BaseSettingActivity", "tag");
        Intrinsics.checkNotNullParameter("onSwitchToShareCallPad", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("BaseSettingActivity"), "onSwitchToShareCallPad");
        }
        int i9 = BaseSettingActivity.f2662k;
        final BaseSettingActivity activity = this.f1239a;
        if (activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        ld.m mVar = activity.e;
        if (mVar == null || !mVar.isShowing()) {
            int iC = lb.a.c("multi_device_connection.share_call_pad");
            final d onChange = new d(activity, i8);
            e eVar = new e(activity, 1);
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(onChange, "onChange");
            String[] strArr = {activity.getString(R$string.only_cast_tip), activity.getString(R$string.connect_tip), activity.getString(R$string.no_tip)};
            g0 g0Var = g0.f4753a;
            if (g0.f4754b) {
                final ListView listView = new ListView(activity);
                listView.setChoiceMode(1);
                listView.setAdapter((ListAdapter) new ArrayAdapter(activity, R.layout.simple_list_item_single_choice, strArr));
                listView.setDivider(null);
                listView.setDividerHeight(0);
                listView.setItemChecked(iC, true);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: dc.m
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView adapterView, View view, int i10, long j8) {
                        int i11 = 2;
                        BaseSettingActivity context = activity;
                        ListView listView2 = listView;
                        bb.d dVar = onChange;
                        String strO = o.d.o("isSameWlan:", g0.f4760j, "MultiConnectManager", "tag", "log");
                        if (gc.f6462a <= 4) {
                            Log.i(gc.f6463b.concat("MultiConnectManager"), strO);
                        }
                        boolean z2 = g0.f4760j;
                        boolean z3 = i10 == 2;
                        if (!z2 && !z3) {
                            boolean z5 = DialogUtilActivity.f2733j;
                            cj.b bVar = new cj.b(listView2, i10, dVar);
                            Intrinsics.checkNotNullParameter(context, "context");
                            Intent intent = new Intent(context, (Class<?>) DialogUtilActivity.class);
                            intent.putExtra("DialogType", 4);
                            intent.setFlags(268435456);
                            DialogUtilActivity.f2735l = bVar;
                            context.startActivity(intent);
                            return;
                        }
                        dVar.invoke(Integer.valueOf(i10));
                        boolean zIsConnected = DeviceConnectState.INSTANCE.isConnected();
                        LinkedHashMap linkedHashMap = lb.a.f7355a;
                        boolean z10 = lb.a.f7357c;
                        String log = "isConnected: " + zIsConnected + ", isSameWlan: " + z2 + ", isNoTip: " + z3 + ", isPhoneCallSharingOn: " + z10;
                        Intrinsics.checkNotNullParameter("SettingsDialogUtil", "tag");
                        Intrinsics.checkNotNullParameter(log, "log");
                        if (gc.f6462a <= 4) {
                            Log.i(gc.f6463b.concat("SettingsDialogUtil"), log);
                        }
                        if (!zIsConnected || !z2 || z3 || z10) {
                            ld.m mVar2 = n.f4427a;
                            if (mVar2 != null) {
                                mVar2.dismiss();
                                return;
                            }
                            return;
                        }
                        boolean z11 = DialogUtilActivity.f2733j;
                        s sVar = new s(i11);
                        Intrinsics.checkNotNullParameter(context, "context");
                        Intent intent2 = new Intent(context, (Class<?>) DialogUtilActivity.class);
                        intent2.putExtra("DialogType", 3);
                        intent2.setFlags(268435456);
                        DialogUtilActivity.f2736m = sVar;
                        context.startActivity(intent2);
                    }
                });
                ld.k kVar = new ld.k(activity);
                String string = activity.getString(R$string.allow_call_tip);
                ld.n nVar = kVar.f7400b;
                nVar.f7403b = string;
                nVar.f7413n = listView;
                kVar.b(activity.getString(R$string.permission_cancel), new bc.c(2));
                ld.m mVarE = kVar.e();
                dc.n.f4427a = mVarE;
                mVarE.setOnDismissListener(new dc.l(eVar, i8));
                mVarA = mVarE;
            } else {
                Intrinsics.checkNotNullParameter("SettingsDialogUtil", "tag");
                Intrinsics.checkNotNullParameter("NOT CONNECT", "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("SettingsDialogUtil"), "NOT CONNECT");
                }
                String string2 = activity.getString(R$string.allow_call_tip);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                mVarA = dc.n.a(activity, string2, strArr, iC, onChange, eVar, true, 448);
            }
            activity.e = mVarA;
        }
    }

    public final void d(boolean z2) {
        Intrinsics.checkNotNullParameter("BaseSettingActivity", "tag");
        Intrinsics.checkNotNullParameter("onSwitchToShareNetwork", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("BaseSettingActivity"), "onSwitchToShareNetwork");
        }
        ob.b.f8417b.f8437a.getClass();
        tj.w.X("iot_multi_con_shareclipboard_settings_switch", tj.w.D());
        if (Intrinsics.areEqual(Boolean.valueOf(z2), this.f1239a.n().f2865c.getValue())) {
            return;
        }
        lb.a.e("multi_device_connection.share_network", z2);
        u7.e eVar = u7.e.f10405a;
        u7.e.f10411i.set(z2);
        if (!z2) {
            eVar.b();
        }
        if (!z2) {
            Intrinsics.checkNotNullParameter("SettingViewModel", "tag");
            Intrinsics.checkNotNullParameter("sendNetworkSharingClose", "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("SettingViewModel"), "sendNetworkSharingClose");
            }
            TCCPHandshakeSocketServer tCCPHandshakeSocketServer = l2.f4772a;
            Intrinsics.checkNotNullParameter("SocketServerManager", "tag");
            Intrinsics.checkNotNullParameter("Phone NetworkSharingClose", "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("SocketServerManager"), "Phone NetworkSharingClose");
            }
            TCCPHandshakeSocketServer tCCPHandshakeSocketServer2 = l2.f4772a;
            if (tCCPHandshakeSocketServer2 != null) {
                tCCPHandshakeSocketServer2.sendRequest(TccpConfig.INSTANCE.getNETWORK_SHARING_CLOSE_FLAG(), new TccpRequestNetworkSharingStateChangeBean(false));
            }
            g0 g0Var = g0.f4753a;
            g0.a(ConnectedDevice.INSTANCE.getSUBTITLE_SHARE_NETWORK(), false);
        }
        String strO = o.d.o("toggleNetworkSharingSwitch: newState=", z2, "SettingViewModel", "tag", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("SettingViewModel"), strO);
        }
    }

    public final void e() {
        int i8 = 0;
        Intrinsics.checkNotNullParameter("BaseSettingActivity", "tag");
        Intrinsics.checkNotNullParameter("onSwitchToShareSmsPad", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("BaseSettingActivity"), "onSwitchToShareSmsPad");
        }
        int i9 = BaseSettingActivity.f2662k;
        BaseSettingActivity activity = this.f1239a;
        if (activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        ld.m mVar = activity.f2666h;
        if (mVar == null || !mVar.isShowing()) {
            int iC = lb.a.c("multi_device_connection.share_sms_pad");
            d onChange = new d(activity, i8);
            e eVar = new e(activity, 0);
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(onChange, "onChange");
            String[] strArr = {activity.getString(R$string.only_cast_tip), activity.getString(R$string.connect_tip), activity.getString(R$string.no_tip)};
            String string = activity.getString(R$string.allow_sms_tip);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            activity.f2666h = dc.n.a(activity, string, strArr, iC, onChange, eVar, true, 448);
        }
    }
}
