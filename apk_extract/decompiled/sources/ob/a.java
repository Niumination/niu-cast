package ob;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.jvm.internal.Intrinsics;
import tj.w;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends w {
    @Override // tj.w
    public final void G(String triggerScene) {
        Intrinsics.checkNotNullParameter(triggerScene, "triggerScene");
        w.X("pad_pc_con_newtipspage_ex", new Bundle());
    }

    @Override // tj.w
    public final void H(String triggerScene) {
        Intrinsics.checkNotNullParameter(triggerScene, "triggerScene");
        if (TextUtils.equals(triggerScene, "shortcut_open_click")) {
            Intrinsics.checkNotNullParameter("control_center", "triggerScene");
            Bundle bundle = new Bundle();
            bundle.putString("trigger_scene", "control_center");
            w.X("pad_pc_con_newtipspage_exit", bundle);
            return;
        }
        Intrinsics.checkNotNullParameter(triggerScene, "triggerScene");
        Bundle bundle2 = new Bundle();
        bundle2.putString("trigger_scene", triggerScene);
        w.X("pad_pc_con_newtipspage_exit", bundle2);
    }

    @Override // tj.w
    public final void I(String triggerScene) {
        Intrinsics.checkNotNullParameter(triggerScene, "triggerScene");
        w.X("pad_pc_con_newtipspage_startnow_cl", new Bundle());
    }

    @Override // tj.w
    public final void J(String handleResult) {
        Intrinsics.checkNotNullParameter(handleResult, "handleResult");
        Intrinsics.checkNotNullParameter(handleResult, "handleResult");
        Bundle bundle = new Bundle();
        bundle.putString("handle_result", handleResult);
        w.X("pad_pc_con_connect_conflict_handle", bundle);
    }

    @Override // tj.w
    public final void K() {
    }

    @Override // tj.w
    public final void L(int i8, String triggerScene) {
        Intrinsics.checkNotNullParameter(triggerScene, "triggerScene");
        Bundle bundle = new Bundle();
        bundle.putInt("scan_pc_quantity", i8);
        bundle.putString("is_first_connect", w.x());
        w.X("pad_pc_con_open_pc_scan_find", bundle);
    }

    @Override // tj.w
    public final void O(String conFailureType, String did, String pid, String triggerScene, String startByPcOrPhone) {
        Intrinsics.checkNotNullParameter(conFailureType, "conFailureType");
        Intrinsics.checkNotNullParameter(did, "did");
        Intrinsics.checkNotNullParameter(pid, "pid");
        Intrinsics.checkNotNullParameter(triggerScene, "triggerScene");
        Intrinsics.checkNotNullParameter(startByPcOrPhone, "startByPcOrPhone");
        Intrinsics.checkNotNullParameter(conFailureType, "conFailureType");
        Intrinsics.checkNotNullParameter(did, "did");
        Intrinsics.checkNotNullParameter(pid, "pid");
        Intrinsics.checkNotNullParameter(startByPcOrPhone, "startByPcOrPhone");
        Bundle bundle = new Bundle();
        bundle.putString("connect_failure_type", conFailureType);
        bundle.putString("connected_pc_id", did);
        bundle.putString("pc_pid", pid);
        bundle.putString("start_by_pc_or_phone", startByPcOrPhone);
        w.X("pad_pc_con_failure", bundle);
    }

    @Override // tj.w
    public final void P(String startByPcOrPhone, String pid, String conType, String triggerScene, String did) {
        Intrinsics.checkNotNullParameter(startByPcOrPhone, "startByPcOrPhone");
        Intrinsics.checkNotNullParameter(pid, "pid");
        Intrinsics.checkNotNullParameter(conType, "conType");
        Intrinsics.checkNotNullParameter(triggerScene, "triggerScene");
        Intrinsics.checkNotNullParameter(did, "did");
        Intrinsics.checkNotNullParameter(startByPcOrPhone, "startByPcOrPhone");
        Intrinsics.checkNotNullParameter(pid, "pid");
        Intrinsics.checkNotNullParameter(conType, "conType");
        Intrinsics.checkNotNullParameter(triggerScene, "triggerScene");
        Intrinsics.checkNotNullParameter(did, "did");
        Bundle bundle = new Bundle();
        bundle.putString("is_first_connect", w.y());
        bundle.putString("start_by_pc_or_phone", startByPcOrPhone);
        bundle.putString("pc_pid", pid);
        bundle.putString("connect_type", conType);
        bundle.putString("connected_pc_id", did);
        w.X("pad_pc_con_success", bundle);
    }

    @Override // tj.w
    public final void Q(long j8) {
        Intrinsics.checkNotNullParameter("shortcut_center", "entry");
        Intrinsics.checkNotNullParameter("shortcut_center", "entry");
        Bundle bundle = new Bundle();
        bundle.putString("is_first_connect", w.y());
        bundle.putString("entry", "shortcut_center");
        bundle.putLong("enable_time", j8);
        w.X("pad_pc_con_turn_off", bundle);
    }

    @Override // tj.w
    public final void R(String triggerScene) {
        Intrinsics.checkNotNullParameter(triggerScene, "triggerScene");
        w.X("pad_pc_con_permissionpage_ex", new Bundle());
    }

    @Override // tj.w
    public final void S(String pid, long j8) {
        Intrinsics.checkNotNullParameter(pid, "pid");
        Intrinsics.checkNotNullParameter(pid, "pid");
        Bundle bundle = new Bundle();
        bundle.putLong(TypedValues.TransitionType.S_DURATION, j8);
        bundle.putString("pc_pid", pid);
        w.X("pad_pc_con_pad_connect_pc_duration", bundle);
    }

    @Override // tj.w
    public final void T(long j8) {
        Bundle bundle = new Bundle();
        bundle.putLong(TypedValues.TransitionType.S_DURATION, j8);
        w.X("pad_pc_con_scan_pc_duration", bundle);
    }

    @Override // tj.w
    public final void U(String conStatus, String entry) {
        Intrinsics.checkNotNullParameter(conStatus, "conStatus");
        Intrinsics.checkNotNullParameter("pc_connection", "workMode");
        Intrinsics.checkNotNullParameter(entry, "entry");
        Intrinsics.checkNotNullParameter(conStatus, "conStatus");
        Intrinsics.checkNotNullParameter(entry, "entry");
        Bundle bundle = new Bundle();
        bundle.putString("is_first_connect", w.y());
        bundle.putString("scanqr_connect_status", conStatus);
        bundle.putString("entry", entry);
        w.X("pad_pc_con_scanqr_result", bundle);
    }

    @Override // tj.w
    public final void V() {
        Bundle bundle = new Bundle();
        bundle.putString("is_first_connect", w.x());
        w.X("pad_pc_con_pad_select_pc_click", bundle);
    }

    @Override // tj.w
    public final void W(String entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        w.X("pad_pc_con_settings_entry_click", new Bundle());
    }

    @Override // tj.w
    public final void Y() {
        Intrinsics.checkNotNullParameter("shortcut_center", "entry");
        Bundle bundle = new Bundle();
        bundle.putString("entry", "shortcut_center");
        bundle.putString("is_first_connect", w.x());
        w.X("pad_pc_con_enable", bundle);
    }

    @Override // tj.w
    public final void n() {
        Bundle bundle = new Bundle();
        bundle.putString("is_first_connect", w.x());
        w.X("pad_pc_con_cable_connect_entry_click", bundle);
    }

    @Override // tj.w
    public final void p(String triggerScene) {
        Intrinsics.checkNotNullParameter(triggerScene, "triggerScene");
        Bundle bundle = new Bundle();
        bundle.putString("is_first_connect", w.x());
        w.X("pad_pc_con_cancel_scan_pc_window", bundle);
    }

    @Override // tj.w
    public final void q(String requestConnectStatus, String triggerScene) {
        Intrinsics.checkNotNullParameter(requestConnectStatus, "requestConnectStatus");
        Intrinsics.checkNotNullParameter(triggerScene, "triggerScene");
        Intrinsics.checkNotNullParameter(requestConnectStatus, "requestConnectStatus");
        Bundle bundle = new Bundle();
        bundle.putString("is_first_connect", w.x());
        bundle.putString("request_connect_status", requestConnectStatus);
        w.X("pad_pc_con_confirm_connect_dialog_by_pc", bundle);
    }

    @Override // tj.w
    public final void r(String requestConStatus, String isRememberDevice) {
        Intrinsics.checkNotNullParameter(requestConStatus, "requestConStatus");
        Intrinsics.checkNotNullParameter(isRememberDevice, "isRememberDevice");
        Intrinsics.checkNotNullParameter(requestConStatus, "requestConStatus");
        Intrinsics.checkNotNullParameter(isRememberDevice, "isRememberDevice");
        Bundle bundle = new Bundle();
        bundle.putString("request_connect_status", requestConStatus);
        bundle.putString("is_remember_device", isRememberDevice);
        bundle.putString("is_first_connect", w.x());
        w.X("pad_pc_con_confirm_connect_dialog_by_phone", bundle);
    }

    @Override // tj.w
    public final void s(String triggerScene) {
        Intrinsics.checkNotNullParameter(triggerScene, "triggerScene");
        if (triggerScene.length() == 0) {
            w.M("pc_connection");
        } else {
            w.M(triggerScene);
        }
    }

    @Override // tj.w
    public final void t(String did, String reason) {
        Intrinsics.checkNotNullParameter(did, "did");
        Intrinsics.checkNotNullParameter("pc_connection", "workMode");
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(did, "did");
        Intrinsics.checkNotNullParameter(reason, "reason");
        Bundle bundle = new Bundle();
        bundle.putString("connected_pc_id", did);
        bundle.putString("disconnect_reason", reason);
        w.X("pad_pc_con_disconnect_by_system", bundle);
    }

    @Override // tj.w
    public final void u(String entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        Bundle bundle = new Bundle();
        bundle.putString("is_first_connect", w.x());
        w.X("pad_pc_con_enter_scan_page", bundle);
    }

    @Override // tj.w
    public final void v(int i8) {
        Bundle bundle = new Bundle();
        bundle.putString("is_first_connect", w.x());
        bundle.putInt("scan_pc_quantity", i8);
        w.X("pad_pc_finddevicepage_devicenum_change", bundle);
    }

    @Override // tj.w
    public final void w(String triggerScene) {
        Intrinsics.checkNotNullParameter(triggerScene, "triggerScene");
        if (TextUtils.equals(triggerScene, "setting_open_click")) {
            w.N("settings");
        } else {
            w.N("control_center");
        }
    }
}
