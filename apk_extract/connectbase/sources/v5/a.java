package v5;

import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;
import k6.g;

/* JADX INFO: loaded from: classes2.dex */
public class a implements c {
    public static final String A = "iot_pc_con_screen_cast_success";
    public static final String A0 = "selected_files_num";
    public static final String B = "iot_pc_con_start_app_cast";
    public static final String B0 = "selected_videos_num";
    public static final String C = "iot_pc_con_close_phone_cast_windows";
    public static final String C0 = "total_size_mb";
    public static final String D = "iot_pc_con_close_app_cast_windows";
    public static final String D0 = "device_type";
    public static final String E = "iot_pc_con_files_drag_share_end";
    public static final String E0 = "operate";
    public static final String F = "iot_pc_con_hotpot_con";
    public static final String F0 = "screenOrientation";
    public static final String G = "iot_pc_con_privacy_mode_stopped";
    public static final String G0 = "system_gesture_action";
    public static final String H = "iot_pc_con_disconnect_by_system";
    public static final String H0 = "connect_status";
    public static final String I = "iot_pc_con_backup_get_files_from_phone";
    public static final String I0 = "mode";
    public static final String J = "iot_pc_con_backup_manual_start";
    public static final String J0 = "pc_connection";
    public static final String K = "iot_pc_con_backup_delete";
    public static final String K0 = "subdisplay";
    public static final String L = "pad_connection_pad_mirror_window_load_success";
    public static final String L0 = "heartbeat_overtime";
    public static final String M = "pad_connection_pad_control_phone";
    public static final String M0 = "connect_type";
    public static final String N = "pad_connection_mirror_more_feature_click";
    public static final String N0 = "multiconnect_enable_athena_test";
    public static final String O = "pad_connection_mirror_more_feature_feature_click";
    public static final String O0 = "connected_device_name";
    public static final String P = "pad_connection_mirror_window_lock_or_unlock";
    public static final String P0 = "did";
    public static final String Q = "pad_connection_mirror_privacy_mode_enter";
    public static final String Q0 = "use_time";
    public static final String R = "pad_connection_share_clipboard_copied";
    public static final String R0 = "exit_way";
    public static final String S = "pad_connection_mirror_window_close";
    public static final String T = "iot_multi_con_screen_locked_when_mirroring";
    public static final String U = "iot_multi_con_castpc_landscape_enter";
    public static final String V = "iot_multi_con_castpad_landscape_enter";
    public static final String W = "iot_multi_con_castpc_auto_fullscreen_enter";
    public static final String X = "iot_multi_con_castpad_auto_fullscreen_enter";
    public static final String Y = "iot_pc_con_pc_control_phone_guesture";
    public static final String Z = "pad_pc_con_mirror_success";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f16600a = 7800;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final String f16601a0 = "pad_pc_con_extend_succss";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f16602b = 780060000033L;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final String f16603b0 = "pad_pc_con_extend_screen_enter_background";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f16604c = 780060000035L;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final String f16605c0 = "pad_pc_con_pad_control_pc";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f16606d = 780060000036L;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final String f16607d0 = "iot_multi_con_phonepad_connect_widescreen_enable";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f16608e = 780060000037L;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final String f16609e0 = "iot_multi_con_phonepad_connect_exit_successfully";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f16610f = 780060000038L;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final String f16611f0 = "iot_multi_con_phonepad_connect_gesture";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final long f16612g = 780060000039L;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final String f16613g0 = "how_to_enable";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final long f16614h = 780060000034L;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final String f16615h0 = "duration";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final long f16616i = 780060000044L;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final String f16617i0 = "pc_pid";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final long f16618j = 780060000089L;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final String f16619j0 = "pc_did";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final long f16620k = 780060000090L;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final String f16621k0 = "is_first_connect";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final long f16622l = 780060000097L;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final String f16623l0 = "cast_app_name";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final long f16624m = 780060000106L;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final String f16625m0 = "cast_window_left_num";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final long f16626n = 780060000110L;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final String f16627n0 = "cast_duration";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final long f16628o = 780060000111L;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public static final String f16629o0 = "close_window_app_name";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final long f16630p = 780060000112L;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final String f16631p0 = "hotpot_time_duration";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final long f16632q = 780060000113L;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public static final String f16633q0 = "time_cost";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final long f16634r = 780060000114L;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public static final String f16635r0 = "total_file_num";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final long f16636s = 780060000115L;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public static final String f16637s0 = "total_file_size";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final long f16638t = 780060000116L;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public static final String f16639t0 = "files_source";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final long f16640u = 780060000148L;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public static final String f16641u0 = "how_transfer_ends";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final long f16642v = 780060000150L;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public static final String f16643v0 = "transfer_success_num";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final long f16644w = 780060000151L;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public static final String f16645w0 = "connected_pc_id";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final long f16646x = 780060000152L;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public static final String f16647x0 = "work_mode";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final long f16648y = 780060000153L;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public static final String f16649y0 = "disconnect_reason";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final long f16650z = 780060000174L;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public static final String f16651z0 = "file_num";

    /* JADX INFO: renamed from: v5.a$a, reason: collision with other inner class name */
    public static final class C0447a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f16652a = new a();
    }

    public a() {
    }

    public static a c() {
        return C0447a.f16652a;
    }

    public void A(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString(F0, str);
        bundle.putString(O0, str2);
        bundle.putString(P0, str3);
        C(f16607d0, bundle);
    }

    public void B(String str, long j10, Bundle bundle) {
        new a4.a(str, j10).m(bundle, null).k();
    }

    public void C(String str, Bundle bundle) {
        new a4.a(str).m(bundle, null).k();
    }

    public void D(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(f16623l0, str);
        B(B, f16604c, bundle);
    }

    public void E(String str, long j10, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString(f16613g0, str);
        bundle.putLong("duration", j10);
        bundle.putString(f16617i0, str2);
        bundle.putString(f16621k0, str3);
        B(A, f16602b, bundle);
    }

    public void F(String str, int i10, long j10) {
        Bundle bundle = new Bundle();
        bundle.putString(f16629o0, str);
        bundle.putInt(f16625m0, i10);
        bundle.putLong(f16627n0, j10);
        B(D, f16608e, bundle);
    }

    public void G(int i10, long j10) {
        Bundle bundle = new Bundle();
        bundle.putInt(f16625m0, i10);
        bundle.putLong(f16627n0, j10);
        B(C, f16606d, bundle);
    }

    public void H(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString(f16645w0, str);
        bundle.putString(f16647x0, str3);
        bundle.putString(f16649y0, str2);
        B(H, f16616i, bundle);
    }

    public void I(long j10, int i10, long j11, String str, String str2, int i11) {
        Bundle bundle = new Bundle();
        bundle.putLong(f16633q0, j10);
        bundle.putInt(f16635r0, i10);
        bundle.putLong(f16637s0, j11);
        bundle.putString(f16639t0, str);
        bundle.putString(f16641u0, str2);
        bundle.putInt(f16643v0, i11);
        B(E, f16610f, bundle);
    }

    public void J(String str, long j10) {
        Bundle bundle = new Bundle();
        bundle.putString(f16617i0, str);
        bundle.putLong(f16631p0, j10);
        B(F, f16612g, bundle);
    }

    @Override // v5.c
    public void a(Context context) {
        g.u0(context, null, f16600a, true, true);
        s3.g.C(e(context));
    }

    public void b(String str, String str2, int i10) {
        Bundle bundle = new Bundle();
        bundle.putString(f16619j0, str);
        bundle.putString(f16617i0, str2);
        bundle.putInt(A0, i10);
        B(K, f16622l, bundle);
    }

    public void d(String str, String str2, int i10) {
        Bundle bundle = new Bundle();
        bundle.putString(f16619j0, str);
        bundle.putString(f16617i0, str2);
        bundle.putInt(f16651z0, i10);
        B(I, f16618j, bundle);
    }

    public final boolean e(Context context) {
        return "1".equals(Settings.Global.getString(context.getContentResolver(), N0));
    }

    public void f(String str, String str2, int i10, int i11, int i12) {
        Bundle bundle = new Bundle();
        bundle.putString(f16619j0, str);
        bundle.putString(f16617i0, str2);
        bundle.putInt(A0, i10);
        bundle.putInt(B0, i11);
        bundle.putInt(C0, i12);
        B(J, f16620k, bundle);
    }

    public void g(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(E0, str);
        bundle.putString(F0, str2);
        B(O, f16632q, bundle);
    }

    public void h(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(F0, str);
        B(N, f16630p, bundle);
    }

    public void i() {
        B(Q, f16636s, new Bundle());
    }

    public void j(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(E0, str);
        B(P, f16634r, bundle);
    }

    public void k(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString(G0, str);
        bundle.putString(f16619j0, str2);
        bundle.putString(f16617i0, str3);
        B(Y, f16650z, bundle);
    }

    public void l(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(G0, str);
        B(M, f16628o, bundle);
    }

    public void m(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(H0, str);
        bundle.putString(F0, str2);
        B(S, f16624m, bundle);
    }

    public void n(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(F0, str);
        B(L, f16626n, bundle);
    }

    public void o(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(G0, str);
        C(f16611f0, bundle);
    }

    public void p() {
        B(X, f16648y, new Bundle());
    }

    public void q(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(f16617i0, str);
        B(W, f16646x, bundle);
    }

    public void r() {
        B(V, f16644w, new Bundle());
    }

    public void s() {
        B(U, f16642v, new Bundle());
    }

    public void t(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(M0, str);
        B(T, f16640u, bundle);
    }

    public void u(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(D0, str);
        B(R, f16638t, bundle);
    }

    public void v(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(f16617i0, str);
        C(f16603b0, bundle);
    }

    public void w(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString(f16617i0, str);
        bundle.putString(O0, str2);
        bundle.putString(P0, str3);
        C(f16601a0, bundle);
    }

    public void x(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString(f16617i0, str);
        bundle.putString(O0, str2);
        bundle.putString(P0, str3);
        C(Z, bundle);
    }

    public void y(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("mode", str);
        C(f16605c0, bundle);
    }

    public void z(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(Q0, str2);
        bundle.putString(R0, str);
        C(f16609e0, bundle);
    }

    public a(b bVar) {
    }
}
