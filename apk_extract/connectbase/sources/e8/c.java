package e8;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class c implements pg.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f4100b = "c";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Class<?> f4101c = cc.a.a("android.os.Build");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p f4102a = new p();

    @Override // pg.c
    public int A() {
        return h1("ro.os_privacy_hub_support", "ro.tr_privacy.privacy_hub.feature.support", 1);
    }

    @Override // pg.c
    public int A0() {
        return h1("ro.tran_operatorbookmark_support", "ro.tr_tocc.bookmark.support", 1);
    }

    @Override // pg.c
    public int B() {
        return h1("ro.tran_split_screen_snap_mode.support", "ro.tr_splitscreen.snapmode.feature.support", 1);
    }

    @Override // pg.c
    public int B0() {
        return h1("ro.product.personalized_display_flip.support", "ro.tr_build.personalized_display_flip.support", 0);
    }

    @Override // pg.c
    public int C() {
        return h1("ro.sys.tran.aicore_llm_support", "ro.tr_aiservice.aicorellm.feature.support", 1);
    }

    @Override // pg.c
    public int C0() {
        return h1("persist.sys.tran_led_camon_support", "persist.tr_lighting.camon.feature.support", 0);
    }

    @Override // pg.c
    public String D() {
        return i1("ro.build_number", "ro.tr_build.build_number", "");
    }

    @Override // pg.c
    public int D0() {
        return h1("ro.os_kolun_go_support", "ro.tr_aiservice.kolungo.feature.support", 0);
    }

    @Override // pg.c
    public int E() {
        return h1("sys.apm.limit_block_mode", "tr_apm.limit_block_mode", 1);
    }

    @Override // pg.c
    public String E0() {
        return i1("ro.transsion_spacesaver.support", "ro.tr_spacesaver.feature.support", "1");
    }

    @Override // pg.c
    public String F() {
        return i1("ro.tran_palm_find_1.2.0_support", "ro.tr_palm_find.bluetooth_headset.feature.support", "1");
    }

    @Override // pg.c
    public String F0() {
        Method methodG = cc.a.g(f4101c, "getSerial", new Class[0]);
        try {
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(null, null);
            if (objInvoke == null || !(objInvoke instanceof String)) {
                return null;
            }
            return (String) objInvoke;
        } catch (Throwable th2) {
            m7.a.a("getSerial fail ", th2, f4100b);
            return null;
        }
    }

    @Override // pg.c
    public int G() {
        return h1("persist.sys.tran_led_note_support", "persist.tr_lighting.note.feature.support", 0);
    }

    @Override // pg.c
    public boolean G0() {
        return g1("ro.sys.tran.assist_vow_dualmic", "ro.tr_aiassistant.vow.dualmic.support", false);
    }

    @Override // pg.c
    public int H() {
        return h1("ro.os_smartpanel_support", "ro.tr_smartpanel.os_smartpanel.support", 1);
    }

    @Override // pg.c
    public int H0() {
        return h1("ro.os_supershot_apk", "ro.tr_screenshot.support", 1);
    }

    @Override // pg.c
    public int I() {
        return h1("ro.os_game_tp_esports30.support", "ro.tr_game.tp_esports30.feature.support", 0);
    }

    @Override // pg.c
    public int I0() {
        return h1("persist.sys.tran_led_control_center_support", "persist.tr_lighting.controlcenter.feature.support", 0);
    }

    @Override // pg.c
    public int J() {
        return h1("ro.os_note_sunia_pen_support", "ro.tr_note.sunia_pen.support", 0);
    }

    @Override // pg.c
    public int J0() {
        return h1("ro.tran_geniex_support", "ro.tr_telephony.vsim.support", 1);
    }

    @Override // pg.c
    public int K() {
        return h1("ro.os_game_tp_esports20.support", "ro.tr_game.tp_esports20.feature.support", 0);
    }

    @Override // pg.c
    public boolean K0() {
        try {
            return "1".equals(this.f4102a.e("ro.faceid.hal.support", hi.b.f7118g));
        } catch (Exception e10) {
            p6.b.a("isFaceIdHalSupport fail: ", e10, f4100b);
            return false;
        }
    }

    @Override // pg.c
    public int L() {
        return h1("ro.os_share_privacy_support", "ro.tr_sharevia.chooser.privacy.feature.support", 1);
    }

    @Override // pg.c
    public boolean L0() {
        return g1("ro.sys.tran.assist_vow_support", "ro.tr_aiassistant.vow.support", false);
    }

    @Override // pg.c
    public int M() {
        return h1("ro.childmode.support", "ro.tr_childmode.feature.support", 0);
    }

    @Override // pg.c
    public int M0() {
        return h1("ro.vendor.trancare.uxdetectorrest", "ro.tr_aiservice.uxdetector_rest.feature.support", 1);
    }

    @Override // pg.c
    public int N() {
        return h1("ro.os_note_ai_bg_support", "ro.tr_note.ai_bg.support", 0);
    }

    @Override // pg.c
    public String N0() {
        return i1("ro.vendor.tran.hr_spo2.test_time", "ro.odm.tr_sensor.hr_spo2.timeoutmillis", "");
    }

    @Override // pg.c
    public String O() {
        try {
            return this.f4102a.e("ro.board.platform", "");
        } catch (Exception e10) {
            p6.b.a("getBoardPlatform fail: ", e10, f4100b);
            return "";
        }
    }

    @Override // pg.c
    public int O0() {
        return h1("ro.os_kolun_support", "ro.tr_aiservice.kolun.feature.support", 1);
    }

    @Override // pg.c
    public boolean P() {
        return g1("ro.vendor.tran_vib3_support", "ro.tr_vibrate.vibrate30.feature.support", false);
    }

    @Override // pg.c
    public boolean P0() {
        return g1("ro.vendor.tran_vib3_z_support", "ro.tr_vibrate.vibrate30_z.feature.support", false);
    }

    @Override // pg.c
    public int Q() {
        return h1("ro.os_customized_split_screen_support", "ro.tr_splitscreen.customized.feature.support", 1);
    }

    @Override // pg.c
    public int Q0() {
        return h1("persist.sys.tran_led_gt_support", "persist.tr_lighting.gt.feature.support", 0);
    }

    @Override // pg.c
    public String R() {
        return i1("ro.product.tran_air_transfer_support", "ro.tr_airtransfer.feature.support", "");
    }

    @Override // pg.c
    public String R0() {
        return i1("ro.odm.tr_sensor.hrv_stress.support", "ro.odm.tr_sensor.hrv_stress.support", "");
    }

    @Override // pg.c
    public boolean S() {
        return g1("ro.sys.tran.assist_support", "ro.tr_aiassistant.feature.support", false);
    }

    @Override // pg.c
    public int S0() {
        return h1("ro.os_charging_power_hide", "ro.tr_charging.power_hide", 0);
    }

    @Override // pg.c
    public boolean T() {
        return g1("ro.product.assist_online", "ro.tr_aiassistant.online.feature.support", false);
    }

    @Override // pg.c
    public boolean T0() {
        try {
            return this.f4102a.a("ro.odm.tr_audio_hifi.feature.support", false);
        } catch (Exception e10) {
            p6.b.a("isOmdHifiSupport fail: ", e10, f4100b);
            return false;
        }
    }

    @Override // pg.c
    public boolean U() {
        return g1("ro.sys.tran.aiphone_support", "ro.tr_aiassistant.aiphone.feature.support", false);
    }

    @Override // pg.c
    public int U0() {
        return h1("ro.product.lightning_multi_window.support", "ro.tr_multiwindow.lightning_multi_window.support", 1);
    }

    @Override // pg.c
    public int V() {
        return h1("ro.os_game_tp_esports10.support", "ro.tr_game.tp_esports10.feature.support", 0);
    }

    @Override // pg.c
    public boolean V0() {
        return g1("ro.tran_vibrate_ontouch2.0.support", "ro.tr_vibrate.vibrate20.feature.support", false);
    }

    @Override // pg.c
    public int W() {
        return h1("ro.os_charging_animation_support", "ro.tr_charging.animation.support", 0);
    }

    @Override // pg.c
    public String W0() {
        return i1("ro.vendor.tran.hr_spo2.option", "ro.odm.tr_sensor.hr_spo2.support", "");
    }

    @Override // pg.c
    public int X() {
        return h1("ro.os_cutepet_support", "ro.tr_cutepet.feature.support", 0);
    }

    @Override // pg.c
    public String X0() {
        return i1("ro.vendor.tran.ir.led.back", "ro.odm.tr_sensor.ir_led_back.support", "");
    }

    @Override // pg.c
    public boolean Y() {
        return g1("ro.vendor.tran_0012ir", "ro.tr_vibrate.realvib05.feature.support", false);
    }

    @Override // pg.c
    public int Y0() {
        return h1("tr_zeroscreen.ai.card.support", "tr_zeroscreen.ai.card.support", 1);
    }

    @Override // pg.c
    public String Z() {
        return i1("persist.sys.oobe_country", "persist.tr_oobe.country", "");
    }

    @Override // pg.c
    public boolean Z0() {
        return g1("ro.sys.tran.assist_highpower_wakeup", "ro.tr_aiassistant.vow.highpower.support", true);
    }

    @Override // pg.c
    public int a() {
        return h1("persist.sys.tran_led_spark_support", "persist.tr_lighting.spark.feature.support", 0);
    }

    @Override // pg.c
    public int a0() {
        return h1("ro.tran_eye_care_support", "ro.tr_game.eye_care.support", 0);
    }

    @Override // pg.c
    public String a1() {
        try {
            return this.f4102a.e("persist.sys.user_experience", "");
        } catch (Exception e10) {
            p6.b.a("getSysUserExperience fail: ", e10, f4100b);
            return "";
        }
    }

    @Override // pg.c
    public boolean b() {
        return g1("ro.sys.tran.assist_power_wakeup_support", "ro.tr_aiassistant.power_wakeup.feature.support", true);
    }

    @Override // pg.c
    public int b0() {
        return h1("ro.os_slider_panel_support", "ro.tr_smartpanel.os_slider_panel.support", 1);
    }

    @Override // pg.c
    public int b1() {
        return h1("ro.aicore.offline_llm_support", "ro.tr_aiservice.aisettings_offlinellm.feature.support", 0);
    }

    @Override // pg.c
    public int c() {
        return h1("ro.os.charging_animation_wire_power", "ro.tr_charging.animation_wire_power", 0);
    }

    @Override // pg.c
    public int c0() {
        return h1("ro.sys.tran.ai_subtitles_support", "ro.tr_aiservice.aicorespeech_subtitle.feature.support", 0);
    }

    @Override // pg.c
    public int c1() {
        return h1("persist.sys.tran_led_itels_support", "persist.tr_lighting.itels.feature.support", 0);
    }

    @Override // pg.c
    public String d() {
        try {
            return this.f4102a.e("ro.product.brand", "");
        } catch (Exception e10) {
            p6.b.a("getProductBrand fail: ", e10, f4100b);
            return "";
        }
    }

    @Override // pg.c
    public int d0() {
        return h1("ro.vendor.tran_mistouch_support", "ro.tr_mistouch.feature.support", 0);
    }

    @Override // pg.c
    public boolean d1() {
        return g1("ro.tran_vibrate_ontouch.support", "ro.tr_vibrate.vibrate10.feature.support", false);
    }

    @Override // pg.c
    public boolean e() {
        try {
            return this.f4102a.a("ro.vendor.tran.hifiaudio_support", false);
        } catch (Exception e10) {
            p6.b.a("isVendorHifiSupport fail: ", e10, f4100b);
            return false;
        }
    }

    @Override // pg.c
    public String e0() {
        return i1("ro.tran_palm_find_support", "ro.tr_palm_find.feature.support", "1");
    }

    @Override // pg.c
    public boolean e1() {
        return g1("ro.sys.tran.aiphone_summary_support", "ro.tr_aiassistant.aiphone_summany.feature.support", false);
    }

    @Override // pg.c
    public int f() {
        return h1("ro.os_keyguard_theme_support", "ro.tr_keyguard.theme.support", 1);
    }

    @Override // pg.c
    public int f0() {
        return h1("persist.sys.fans.onsale", "persist.tr_build.onsale", 0);
    }

    @Override // pg.c
    public String f1() {
        return i1("qemu.hw.mainkeys", "qemu.hw.mainkeys", "");
    }

    @Override // pg.c
    public int g() {
        return h1("ro.os_globalguide_support", "ro.tr_globalguide.feature.support", 0);
    }

    @Override // pg.c
    public int g0() {
        return h1("ro.tran_geniex_entrance_support", "ro.tr_telephony.vsim_geniex_entrance.support", 1);
    }

    public boolean g1(String str, String str2, boolean z10) {
        try {
            return fc.a.h() ? this.f4102a.a(str2, z10) : this.f4102a.a(str, z10);
        } catch (Exception e10) {
            p6.b.a("getPropertyByBool fail: ", e10, f4100b);
            return false;
        }
    }

    @Override // pg.c
    public String h() {
        try {
            return this.f4102a.e("ro.build.display.id", "");
        } catch (Exception e10) {
            p6.b.a("getBuildDisplayId fail: ", e10, f4100b);
            return "";
        }
    }

    @Override // pg.c
    public String h0() {
        return i1("ro.sys.tran.assist_voiceprint_support", "ro.tr_aiassistant.vow.solution", "aispeech");
    }

    public int h1(String str, String str2, int i10) {
        try {
            return fc.a.h() ? this.f4102a.d(str2, i10) : this.f4102a.d(str, i10);
        } catch (Exception e10) {
            p6.b.a("getPropertyByInt fail: ", e10, f4100b);
            return 0;
        }
    }

    @Override // pg.c
    public int i() {
        return h1("persist.sys.tran_led_ella_support", "persist.tr_lighting.ella.feature.support", 0);
    }

    @Override // pg.c
    public int i0() {
        return h1("ro.tran.ultra.power.save.support", "ro.tr_battery.ultra_power_save.feature.support", 0);
    }

    public String i1(String str, String str2, String str3) {
        try {
            return fc.a.h() ? this.f4102a.e(str2, str3) : this.f4102a.e(str, str3);
        } catch (Exception e10) {
            p6.b.a("getPropertyByString fail: ", e10, f4100b);
            return "";
        }
    }

    @Override // pg.c
    public int j() {
        return h1("ro.tran_pt.remote_lock.support", "ro.tr_telephony.pt.remote.lock.support", 1);
    }

    @Override // pg.c
    public int j0() {
        return h1("ro.os.charging_animation_wireless_power", "ro.tr_charging.animation_wireless_power", 0);
    }

    @Override // pg.c
    public int k() {
        return h1("ro.os_repair_mode_support", "ro.tr_privacy.repair_mode.feature.support", 1);
    }

    @Override // pg.c
    public boolean k0() {
        return g1("ro.sys.tran.aiphone_animation_60hz", "ro.tr_aiassistant.aiphone_animation_60hz.feature.config", false);
    }

    @Override // pg.c
    public String l() {
        return i1("ro.tran.bom", "ro.tr_build.bom", "");
    }

    @Override // pg.c
    public int l0() {
        try {
            String lowerCase = i1("ro.hardware", "ro.hardware", "").toLowerCase();
            if (lowerCase.startsWith("mt")) {
                return 1;
            }
            if (lowerCase.startsWith("ums")) {
                return 2;
            }
            return lowerCase.startsWith("qcom") ? 3 : 0;
        } catch (Exception e10) {
            p6.b.a("getPlatform fail: ", e10, f4100b);
            return 0;
        }
    }

    @Override // pg.c
    public int m() {
        return h1("ro.os_cloud_server_support", "ro.tr_cloudserver.feature.support", 0);
    }

    @Override // pg.c
    public boolean m0() {
        return g1("ro.sys.tran.assist_voiceprint_dynamic_hotword", "ro.tr_aiassistant.vow.dynamicswitch.support", false);
    }

    @Override // pg.c
    public int n() {
        return h1("persist.sys.tran_led_pova_support", "persist.tr_lighting.pova.support", 0);
    }

    @Override // pg.c
    public String n0() {
        try {
            return this.f4102a.e("ro.tranos.type", "");
        } catch (Exception e10) {
            p6.b.a("getTranOsType fail: ", e10, f4100b);
            return "";
        }
    }

    @Override // pg.c
    public int o() {
        return h1("ro.os_dynamicbar_support", "ro.tr_dynamicbar.support", 1);
    }

    @Override // pg.c
    public int o0() {
        return h1("ro.tran_stk_mpesa_support", "ro.tr_stk.mpesa.feature.support", 1);
    }

    @Override // pg.c
    public int p() {
        return h1("persist.sys.tran_led_support", "persist.tr_lighting.feature.support", 0);
    }

    @Override // pg.c
    public int p0() {
        return h1("ro.os_note_canvas_support", "ro.tr_note.canvas.support", 1);
    }

    @Override // pg.c
    public boolean q() {
        return g1("ro.os_dragdrop_support", "ro.tr_dragdrop.feature.support", false);
    }

    @Override // pg.c
    public int q0() {
        return h1("ro.tran_stk_athena_support", "ro.tr_stk.athena.feature.support", 1);
    }

    @Override // pg.c
    @Deprecated
    public int r() {
        return h1("ro.os_screenrecord_mic_scale_level", "ro.tr_screenrecord.mic_scale_level", 1);
    }

    @Override // pg.c
    public int r0() {
        return h1("ro.os_flip_screen_support", "ro.tr_project.flip_screen.support", 0);
    }

    @Override // pg.c
    public int s() {
        return h1("ro.tran_split_screen.top_bottom", "ro.tr_splitscreen.topbottom.feature.support", 1);
    }

    @Override // pg.c
    public int s0() {
        return h1("ro.os_note_fans_link_support", "ro.tr_note.fans_link.support", 1);
    }

    @Override // pg.c
    public int t() {
        return h1("ro.dynamically_stk_icon_support", "ro.tr_stk.dynamic_icon.feature.support", 1);
    }

    @Override // pg.c
    public int t0() {
        return h1("sys.child_mode_open", "tr_childmode.open.status", 0);
    }

    @Override // pg.c
    public int u() {
        return h1("ro.tran.dual_sys_support", "ro.tr_privacy.dual_sys.feature.support", 1);
    }

    @Override // pg.c
    public int u0() {
        return h1("ro.os_openwith_wps_support", "ro.tr_sharevia.openwith.feature.support", 1);
    }

    @Override // pg.c
    public int v() {
        return h1("ro.os_screenrecord_sr_sa_0019_009_support", "ro.tr_screenrecord.sr_sa_0019_009.support", 1);
    }

    @Override // pg.c
    public int v0() {
        return h1("persist.sys.tran_led_hot_support", "persist.tr_lighting.hot.feature.support", 0);
    }

    @Override // pg.c
    public int w() {
        return h1("ro.os_foldable_screen_support", "ro.tr_project.foldable_screen.support", 0);
    }

    @Override // pg.c
    public int w0() {
        return h1("ro.os_kolun_exocr_support", "ro.tr_smartrecognition.feature.support", 0);
    }

    @Override // pg.c
    public int x() {
        return h1("ro.os_note_ai_draw_support", "ro.tr_note.ai_draw.support", 0);
    }

    @Override // pg.c
    public int x0() {
        return h1("ro.tran.ai.key.support", "ro.tr_aiassistant.aikey.feature.support", 0);
    }

    @Override // pg.c
    public String y() {
        return i1("ro.tran.sw.market", "ro.tr_build.sw_market", "");
    }

    @Override // pg.c
    public int y0() {
        return h1("ro.tran_gotii_entrance_support", "ro.tr_telephony.vsim_gotii_entrance.support", 1);
    }

    @Override // pg.c
    public int z() {
        return h1("ro.os.keyguard_pova_theme_support", "ro.tr_keyguard.pova_theme.support", 0);
    }

    @Override // pg.c
    public String z0() {
        try {
            return this.f4102a.e("ro.tranos.version", "");
        } catch (Exception e10) {
            p6.b.a("getTranOsVersion fail: ", e10, f4100b);
            return "";
        }
    }
}
