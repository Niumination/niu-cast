package m4;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.view.InputEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.WindowManager;
import java.util.List;
import java.util.Objects;
import k4.m;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
public class a implements c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f10372b = "FrameworkProxy";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f10373c = "itIsNull";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final c f10374a;

    /* JADX INFO: renamed from: m4.a$a, reason: collision with other inner class name */
    public static final class C0275a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f10375a = new a(e.D());
    }

    public static a D() {
        return C0275a.f10375a;
    }

    @Override // m4.c
    public int A(int i10) {
        return this.f10374a.A(i10);
    }

    @Override // m4.c
    public void B(String str, KeyEvent keyEvent) {
        this.f10374a.B(str, keyEvent);
    }

    @Override // m4.c
    public void C(InputEvent inputEvent) {
        try {
            this.f10374a.C(inputEvent);
        } catch (Exception e10) {
            m.d(f10372b, e10);
        }
    }

    public String E(String str, String str2, String str3) {
        String strT = t(str, f10373c);
        if (Objects.equals(strT, f10373c)) {
            strT = t(str2, str3);
            str = str2;
        }
        m.e(f10372b, "getProperty finalKey: " + str + " systemProperty: " + strT + " default: " + str3);
        return strT;
    }

    public String F(String str, String str2, String str3) {
        String strW = w(str, f10373c);
        if (Objects.equals(strW, f10373c)) {
            strW = w(str2, str3);
            str = str2;
        }
        m.e(f10372b, "getPropertyByProp finalKey: " + str + " appProperty: " + strW + " default: " + str3);
        return strW;
    }

    @Override // m4.c
    public l4.a a() {
        return this.f10374a.a();
    }

    @Override // m4.c
    public void b(WindowManager.LayoutParams layoutParams) {
        this.f10374a.b(layoutParams);
    }

    @Override // m4.c
    public boolean c(InputEvent inputEvent, int i10) {
        return this.f10374a.c(inputEvent, i10);
    }

    @Override // m4.c
    public boolean d() {
        return this.f10374a.d();
    }

    @Override // m4.c
    public void e() {
        this.f10374a.e();
    }

    @Override // m4.c
    public void f(int i10) {
        this.f10374a.f(i10);
    }

    @Override // m4.c
    public void g(boolean z10) {
        this.f10374a.g(z10);
    }

    @Override // m4.c
    public void h(boolean z10, int i10) {
        this.f10374a.h(z10, i10);
    }

    @Override // m4.c
    public AudioRecord i() {
        return this.f10374a.i();
    }

    @Override // m4.c
    public void j(List<Integer> list, int i10) {
        this.f10374a.j(list, i10);
    }

    @Override // m4.c
    public void k(int i10, int i11, boolean z10) {
        this.f10374a.k(i10, i11, z10);
    }

    @Override // m4.c
    public boolean l() {
        return this.f10374a.l();
    }

    @Override // m4.c
    public void m() {
        this.f10374a.m();
    }

    @Override // m4.c
    public int n() {
        try {
            return this.f10374a.n();
        } catch (Exception e10) {
            m.d(f10372b, e10);
            return 0;
        }
    }

    @Override // m4.c
    public KeyEvent o(long j10, long j11, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, String str) {
        return this.f10374a.o(j10, j11, i10, i11, i12, i13, i14, i15, i16, i17, i18, str);
    }

    @Override // m4.c
    public void p(String str, String str2) {
        this.f10374a.p(str, str2);
    }

    @Override // m4.c
    public int q() {
        return this.f10374a.q();
    }

    @Override // m4.c
    public void r(Context context, int i10, AudioFormat audioFormat) {
        this.f10374a.r(context, i10, audioFormat);
    }

    @Override // m4.c
    public MotionEvent s(long j10, long j11, int i10, int i11, MotionEvent.PointerProperties[] pointerPropertiesArr, MotionEvent.PointerCoords[] pointerCoordsArr, int i12, int i13, float f10, float f11, int i14, int i15, int i16, int i17, int i18) {
        return this.f10374a.s(j10, j11, i10, i11, pointerPropertiesArr, pointerCoordsArr, i12, i13, f10, f11, i14, i15, i16, i17, i18);
    }

    @Override // m4.c
    public String t(String str, String str2) {
        return this.f10374a.t(str, str2);
    }

    @Override // m4.c
    public void u(int i10, boolean z10, d dVar) {
        this.f10374a.u(i10, z10, dVar);
    }

    @Override // m4.c
    public void v(List<String> list) {
        this.f10374a.v(list);
    }

    @Override // m4.c
    public String w(String str, String str2) {
        return this.f10374a.w(str, str2);
    }

    @Override // m4.c
    public int x() {
        return this.f10374a.x();
    }

    @Override // m4.c
    public void y() {
        this.f10374a.y();
    }

    @Override // m4.c
    public String z(String str) {
        return this.f10374a.z(str);
    }

    public a(c cVar) {
        this.f10374a = cVar;
    }
}
