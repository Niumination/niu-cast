package m4;

import android.content.ComponentName;
import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.text.TextUtils;
import android.view.InputDevice;
import android.view.InputEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.WindowManager;
import h9.j;
import h9.p;
import java.lang.reflect.Field;
import java.util.List;
import k4.m;
import rb.g;
import rb.h;
import rb.s;
import va.i;
import va.n;

/* JADX INFO: loaded from: classes2.dex */
public class e implements c {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f10376o = "ThubSdkManager";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static String f10377p = "com.transsion.connectx.mirror.source";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f10378q = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final sb.c f10379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x9.b f10380b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i f10381c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f10382d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g f10383e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final aa.a f10384f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ra.c f10385g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final p f10386h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final j f10387i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final qa.a f10388j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final gb.a f10389k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final s f10390l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final oa.c f10391m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final nb.a f10392n;

    public class a implements qa.a.InterfaceC0341a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f10393a;

        public a(e eVar, d dVar) {
            this.f10393a = dVar;
        }

        @Override // qa.a.InterfaceC0341a
        public void a() {
            this.f10393a.a();
        }

        @Override // qa.a.InterfaceC0341a
        public void b() {
            this.f10393a.b();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f10394a = new e();
    }

    public static e D() {
        return b.f10394a;
    }

    public static void F(String str) {
        f10377p = str;
    }

    @Override // m4.c
    public int A(int i10) {
        for (int i11 : InputDevice.getDeviceIds()) {
            InputDevice device = InputDevice.getDevice(i11);
            if (device != null && device.supportsSource(i10)) {
                return i11;
            }
        }
        return 0;
    }

    @Override // m4.c
    public void B(String str, KeyEvent keyEvent) {
        this.f10379a.a(keyEvent, str);
    }

    @Override // m4.c
    public void C(InputEvent inputEvent) {
        try {
            this.f10382d.f(inputEvent, true);
        } catch (Throwable th2) {
            m.d(f10376o, th2);
        }
    }

    public final int E(String str) {
        try {
            Field declaredField = MotionEvent.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            int iIntValue = ((Integer) declaredField.get(null)).intValue();
            m.e(f10376o, str + " = " + iIntValue);
            return iIntValue;
        } catch (IllegalAccessException e10) {
            StringBuilder sbA = k.c.a(str, " not access err：");
            sbA.append(e10.getMessage());
            m.e(f10376o, sbA.toString());
            return 0;
        } catch (NoSuchFieldException e11) {
            StringBuilder sbA2 = k.c.a(str, " not found err：");
            sbA2.append(e11.getMessage());
            m.e(f10376o, sbA2.toString());
            return 0;
        }
    }

    @Override // m4.c
    public l4.a a() {
        ra.a aVarI = this.f10385g.i();
        return new l4.a(aVarI.f14317a, aVarI.f14319c, aVarI.f14318b);
    }

    @Override // m4.c
    public void b(WindowManager.LayoutParams layoutParams) {
        this.f10390l.n(layoutParams);
    }

    @Override // m4.c
    public boolean c(InputEvent inputEvent, int i10) {
        return this.f10384f.b(inputEvent, i10);
    }

    @Override // m4.c
    public boolean d() {
        return this.f10387i.g0();
    }

    @Override // m4.c
    public void e() {
        this.f10389k.j();
    }

    @Override // m4.c
    public void f(int i10) {
        this.f10388j.k(i10);
    }

    @Override // m4.c
    public void g(boolean z10) {
        this.f10381c.o(z10);
    }

    @Override // m4.c
    public void h(boolean z10, int i10) {
        this.f10387i.K0(z10, i10);
    }

    @Override // m4.c
    public AudioRecord i() {
        return this.f10391m.a();
    }

    @Override // m4.c
    public void j(List<Integer> list, int i10) {
        this.f10391m.e(list, i10);
    }

    @Override // m4.c
    public void k(int i10, int i11, boolean z10) {
        this.f10387i.r0(i10, i11, z10);
    }

    @Override // m4.c
    public boolean l() {
        return this.f10385g.m();
    }

    @Override // m4.c
    public void m() {
        this.f10389k.k();
    }

    @Override // m4.c
    public int n() {
        return this.f10380b.h();
    }

    @Override // m4.c
    public KeyEvent o(long j10, long j11, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, String str) {
        return this.f10383e.b(j10, j11, i10, i11, i12, i13, i14, i15, i16, i17, i18, str);
    }

    @Override // m4.c
    public void p(String str, String str2) {
        this.f10386h.u(new ComponentName(str, str2), true);
    }

    @Override // m4.c
    public int q() {
        return E("FLAG_TOUCH_FROM_CONNECT_SHOWIM") | E("FLAG_TOUCH_FROM_CONNECT");
    }

    @Override // m4.c
    public void r(Context context, int i10, AudioFormat audioFormat) {
        this.f10391m.c(context, i10, audioFormat);
    }

    @Override // m4.c
    public MotionEvent s(long j10, long j11, int i10, int i11, MotionEvent.PointerProperties[] pointerPropertiesArr, MotionEvent.PointerCoords[] pointerCoordsArr, int i12, int i13, float f10, float f11, int i14, int i15, int i16, int i17, int i18) {
        return this.f10382d.e(j10, j11, i10, i11, pointerPropertiesArr, pointerCoordsArr, i12, i13, f10, f11, i14, i15, i16, i17, i18);
    }

    @Override // m4.c
    public String t(String str, String str2) {
        return n.b(str, str2);
    }

    @Override // m4.c
    public void u(int i10, boolean z10, d dVar) {
        this.f10388j.j(i10, z10, new a(this, dVar));
    }

    @Override // m4.c
    public void v(List<String> list) {
        this.f10387i.v0(list);
    }

    @Override // m4.c
    public String w(String str, String str2) {
        String strA;
        try {
            strA = this.f10392n.a(str);
        } catch (Exception e10) {
            m.c(f10376o, "getPropertyByProp error: " + e10);
            strA = "";
        }
        return TextUtils.isEmpty(strA) ? str2 : strA;
    }

    @Override // m4.c
    public int x() {
        return E("FLAG_TOUCH_FROM_PADEXTEND");
    }

    @Override // m4.c
    public void y() {
        this.f10391m.d();
    }

    @Override // m4.c
    public String z(String str) {
        return n.a(str);
    }

    public e() {
        this.f10379a = new sb.c();
        this.f10380b = new x9.b();
        this.f10381c = new i();
        this.f10382d = new h();
        this.f10384f = new aa.a();
        this.f10383e = new g();
        this.f10385g = new ra.c();
        this.f10386h = new p();
        this.f10387i = new j();
        this.f10388j = new qa.a();
        this.f10389k = new gb.a();
        nb.a aVar = new nb.a();
        this.f10392n = aVar;
        aVar.d(f10377p);
        this.f10390l = new s();
        this.f10391m = new oa.c();
    }
}
