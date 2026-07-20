package va;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f16699b = "d";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static pg.c f16700c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static pg.c f16701d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f16702e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f16703f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f16704g = 2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f16705h = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public dc.c f16706a = new dc.c("com.transsion.hubsdk.os.TranBuild");

    public static String E() {
        return F(fc.b.a.f5986f).F0();
    }

    public static pg.c F(String str) {
        if (fc.b.b(str)) {
            pg.c cVar = f16700c;
            if (cVar != null) {
                return cVar;
            }
            vd.d dVar = new vd.d();
            f16700c = dVar;
            return dVar;
        }
        dc.e.f(f16699b, "TranAospSettings");
        pg.c cVar2 = f16701d;
        if (cVar2 != null) {
            return cVar2;
        }
        e8.c cVar3 = new e8.c();
        f16701d = cVar3;
        return cVar3;
    }

    public int A() {
        return F(fc.b.a.F).J();
    }

    public int A0() {
        return m(fc.b.a.F, "TRAN_SCREENSHOT_SUPPORT").H0();
    }

    public int B() {
        return F(fc.b.a.F).Q();
    }

    public String B0() {
        return m(fc.b.a.F, "TRAN_SENSOR_IR_LED_BACK").X0();
    }

    public int C() {
        return F(fc.b.a.H).l0();
    }

    public int C0() {
        return m(fc.b.a.G, "TRAN_SLIDER_PANEL_SUPPORT").b0();
    }

    public String D() {
        return F(fc.b.a.F).d();
    }

    public int D0() {
        return m(fc.b.a.F, "TRAN_SMART_RECOGNITION_SUPPORT").w0();
    }

    public int E0() {
        return m(fc.b.a.G, "TRAN_SMARTPANEL_SUPPORT").H();
    }

    public String F0() {
        return F(fc.b.a.F).E0();
    }

    public String G() {
        return F(fc.b.a.F).Z();
    }

    public int G0() {
        return F(fc.b.a.F).B();
    }

    public String H() {
        return F(fc.b.a.F).a1();
    }

    public int H0() {
        return F(fc.b.a.F).s();
    }

    public int I() {
        return F(fc.b.a.F).x0();
    }

    public int I0() {
        return F(fc.b.a.F).q0();
    }

    public int J() {
        return F(fc.b.a.F).c0();
    }

    public int J0() {
        return F(fc.b.a.F).o0();
    }

    public int K() {
        return F(fc.b.a.F).C();
    }

    public String K0() {
        return F(fc.b.a.F).y();
    }

    public String L() {
        return m(fc.b.a.F, "TRAN_AIR_TRANSFER_SUPPORT").R();
    }

    public int L0() {
        return m(fc.b.a.F, "TRAN_ULTRA_POWER_SAVE_SUPPORT").i0();
    }

    public String M() {
        return F(fc.b.a.F).h0();
    }

    public String M0() {
        return m(fc.b.a.F, "TRAN_VENDOR_HR_SPO2_TIMEMILLIS").N0();
    }

    public String N() {
        return F(fc.b.a.F).l();
    }

    public boolean N0() {
        return m(fc.b.a.G, "TRAN_VENDOR_VIB30_SUPPORT").P();
    }

    public int O() {
        return m(fc.b.a.F, "TRAN_CHOOSER_PRIVACY_SUPPORT").L();
    }

    public boolean O0() {
        return m(fc.b.a.G, "TRAN_VIBRATE10_SUPPORT").d1();
    }

    public int P() {
        return m(fc.b.a.G, "TRAN_CLOUDSERVER_SUPPORT").m();
    }

    public boolean P0() {
        return m(fc.b.a.G, "TRAN_VIBRATE20_SUPPORT").V0();
    }

    public int Q() {
        return m(fc.b.a.F, "TRAN_CUTEPET_SUPPORT").X();
    }

    public int Q0() {
        return F(fc.b.a.F).M0();
    }

    public int R() {
        return m(fc.b.a.F, "TRAN_DUAL_SYS_SUPPORT").u();
    }

    public int R0() {
        return m(fc.b.a.H, "TRAN_ZEROSCREEN_AICARD_SUPPORT").Y0();
    }

    public int S() {
        return m(fc.b.a.G, "TRAN_DYNAMICBAR_SUPPORT").o();
    }

    public boolean S0() {
        return F(fc.b.a.F).T();
    }

    public int T() {
        return m(fc.b.a.F, "TRAN_EYE_CARE_SUPPORT").a0();
    }

    public boolean T0() {
        return F(fc.b.a.F).K0();
    }

    public int U() {
        return m(fc.b.a.F, "TRAN_FLIP_SCREEN_SUPPORT").r0();
    }

    public boolean U0() {
        return F(fc.b.a.F).T0();
    }

    public int V() {
        return m(fc.b.a.F, "TRAN_FOLDABLE_SCREEN_SUPPORT").w();
    }

    public boolean V0() {
        return F(fc.b.a.F).k0();
    }

    public int W() {
        return m(fc.b.a.F, "TRAN_GAME_TP_ESPORTS10_SUPPORT").V();
    }

    public boolean W0() {
        return F(fc.b.a.F).e1();
    }

    public int X() {
        return m(fc.b.a.F, "TRAN_GAME_TP_ESPORTS20_SUPPORT").K();
    }

    public boolean X0() {
        return F(fc.b.a.F).U();
    }

    public int Y() {
        return m(fc.b.a.F, "TRAN_GAME_TP_ESPORTS30_SUPPORT").I();
    }

    public boolean Y0() {
        return F(fc.b.a.F).Z0();
    }

    public int Z() {
        return m(fc.b.a.F, "TRAN_GLOBALGUIDE_SUPPORT").g();
    }

    public boolean Z0() {
        return F(fc.b.a.F).b();
    }

    public int a() {
        return F(fc.b.a.F).b1();
    }

    public String a0() {
        return m(fc.b.a.F, "TRAN_HR_SPO2_SUPPORT").W0();
    }

    public boolean a1() {
        return F(fc.b.a.F).S();
    }

    public int b() {
        return F(fc.b.a.F).E();
    }

    public String b0() {
        return m(fc.b.a.F, "TRAN_HRV_STRESS_SUPPORT").R0();
    }

    public boolean b1() {
        return F(fc.b.a.F).m0();
    }

    public String c() {
        return F(fc.b.a.F).O();
    }

    public int c0() {
        return F(fc.b.a.F).C0();
    }

    public boolean c1() {
        return F(fc.b.a.F).G0();
    }

    public String d() {
        return F(fc.b.a.F).h();
    }

    public int d0() {
        return F(fc.b.a.F).I0();
    }

    public boolean d1() {
        return F(fc.b.a.F).L0();
    }

    public String e() {
        return F(fc.b.a.F).D();
    }

    public int e0() {
        return F(fc.b.a.F).i();
    }

    public boolean e1() {
        return m(fc.b.a.F, "TRAN_DRAGDROP_SUPPORT").q();
    }

    public int f() {
        return F(fc.b.a.F).W();
    }

    public int f0() {
        return F(fc.b.a.F).Q0();
    }

    public boolean f1() {
        return m(fc.b.a.F, "TRAN_REALVIB05_SUPPORT").Y();
    }

    public int g() {
        return F(fc.b.a.F).c();
    }

    public int g0() {
        return F(fc.b.a.F).v0();
    }

    public boolean g1() {
        return m(fc.b.a.F, "TRAN_VIBRATE30_Z_SUPPORT").P0();
    }

    public int h() {
        return F(fc.b.a.F).j0();
    }

    public int h0() {
        return F(fc.b.a.F).c1();
    }

    public boolean h1() {
        return F(fc.b.a.F).e();
    }

    public int i() {
        return F(fc.b.a.F).S0();
    }

    public int i0() {
        return F(fc.b.a.F).G();
    }

    public int j() {
        return F(fc.b.a.F).t0();
    }

    public int j0() {
        return F(fc.b.a.F).n();
    }

    public int k() {
        return F(fc.b.a.F).M();
    }

    public int k0() {
        return F(fc.b.a.F).a();
    }

    public int l() {
        return F(fc.b.a.F).t();
    }

    public int l0() {
        return F(fc.b.a.F).p();
    }

    public pg.c m(String str, String str2) {
        if (fc.b.b(str) && this.f16706a.g(str2)) {
            pg.c cVar = f16700c;
            if (cVar != null) {
                return cVar;
            }
            vd.d dVar = new vd.d();
            f16700c = dVar;
            return dVar;
        }
        dc.e.f(f16699b, "TranAospSettings");
        pg.c cVar2 = f16701d;
        if (cVar2 != null) {
            return cVar2;
        }
        e8.c cVar3 = new e8.c();
        f16701d = cVar3;
        return cVar3;
    }

    public int m0() {
        return m(fc.b.a.F, "TRAN_LIGHTNING_MULTI_WINDOW_SUPPORT").U0();
    }

    public int n() {
        return F(fc.b.a.F).f0();
    }

    public int n0() {
        return m(fc.b.a.F, "TRAN_MISTOUCH_SUPPORT").d0();
    }

    public int o() {
        return F(fc.b.a.F).g0();
    }

    public int o0() {
        return m(fc.b.a.F, "TRAN_OPENWITH_SUPPORT").u0();
    }

    public int p() {
        return F(fc.b.a.F).J0();
    }

    public int p0() {
        return F(fc.b.a.F).A0();
    }

    public int q() {
        return F(fc.b.a.F).y0();
    }

    public String q0() {
        return F(fc.b.a.F).n0();
    }

    public int r() {
        return F(fc.b.a.F).z();
    }

    public String r0() {
        return F(fc.b.a.F).z0();
    }

    public int s() {
        return F(fc.b.a.F).f();
    }

    public String s0() {
        return F(fc.b.a.F).e0();
    }

    public int t() {
        return F(fc.b.a.F).D0();
    }

    public String t0() {
        return F(fc.b.a.F).F();
    }

    public int u() {
        return F(fc.b.a.F).O0();
    }

    public int u0() {
        return m(fc.b.a.F, "TRAN_PRIVACY_HUB_SUPPORT").A();
    }

    public String v() {
        return m(fc.b.a.G, "NAV_BAR_OVERRIDE").f1();
    }

    public int v0() {
        return m(fc.b.a.F, "TRAN_PRODUCT_PERSONALIZED_DISPLAY_FLIP_SUPPORT").B0();
    }

    public int w() {
        return F(fc.b.a.F).N();
    }

    public int w0() {
        return m(fc.b.a.F, "TRAN_PT_REMOTE_LOCK_SUPPORT").j();
    }

    public int x() {
        return F(fc.b.a.F).x();
    }

    public int x0() {
        return m(fc.b.a.F, "TRAN_REPAIR_MODE_SUPPORT").k();
    }

    public int y() {
        return F(fc.b.a.F).p0();
    }

    @Deprecated
    public int y0() {
        return m(fc.b.a.F, "TRAN_SCREENRECORD_MIC_SCALE_LEVEL").r();
    }

    public int z() {
        return F(fc.b.a.F).s0();
    }

    public int z0() {
        return m(fc.b.a.F, "TRAN_SCREENRECORD_SR_SA_SUPPORT").v();
    }
}
