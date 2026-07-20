package com.transsion.connectx.mirror.source.activity;

import android.view.Surface;
import androidx.lifecycle.ViewModel;
import com.transsion.connectx.mirror.source.SourceApplication;
import k4.m;
import k5.a;
import k5.b0;
import k5.d0;
import k5.z;
import m2.b;
import p2.f;
import w4.c0;
import w4.l1;

/* JADX INFO: loaded from: classes2.dex */
public class ExtendScreenViewModel extends ViewModel {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f1918f = "ExtendScreenViewModel";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f1919g = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f1920h = 2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f1921i = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile int f1922a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d0 f1923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1924c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1925d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b0 f1926e;

    public final void a() {
        g();
        z.a.f9097a.Q();
        z.a.f9097a.P();
    }

    public void b() {
        if (this.f1923b != null) {
            m.e(f1918f, "already init");
            return;
        }
        this.f1923b = new d0();
        this.f1922a = 1;
        c0.b.f17991a.u0();
    }

    public void c(int i10, int i11, Surface surface, int i12) {
        if (this.f1923b == null) {
            m.e(f1918f, "[EXTEND] loadScreenDecoder: screenDecoder is null");
            return;
        }
        h();
        if (this.f1922a != 3) {
            m.e(f1918f, "loadScreenDecoder");
            this.f1923b.h(i10, i11, surface, i12);
        } else {
            this.f1922a = 2;
            m.e(f1918f, "[EXTEND] loadScreenDecoder: restartDecoder");
            this.f1923b.l(surface, i10, i11, i12);
        }
    }

    public void d(int i10, Surface surface) {
        b.a("loadScreenDecoder: orientation:", i10, f1918f);
        if (this.f1923b != null) {
            c(this.f1924c, this.f1925d, surface, i10);
        }
    }

    public void e() {
        if (this.f1922a == 3) {
            m.e(f1918f, "already pause state");
            return;
        }
        this.f1922a = 3;
        d0 d0Var = this.f1923b;
        if (d0Var != null) {
            d0Var.j();
        }
        z.a.f9097a.N();
    }

    public void f(b0 b0Var) {
        this.f1926e = b0Var;
        z.a.f9097a.O(this.f1926e);
        l1.h.f18073a.B1(this.f1926e);
    }

    public void g() {
        d0 d0Var = this.f1923b;
        if (d0Var == null) {
            m.e(f1918f, "[EXTEND] releaseDecoder: screenDecoder is null");
        } else {
            d0Var.p();
            this.f1923b.k();
        }
    }

    public void h() {
        m.e(f1918f, "resumeExtendScreen");
        z.a.f9097a.W();
    }

    public boolean i(int i10, Surface surface) {
        int i11;
        int orientation = z.a.f9097a.q().getOrientation();
        if (i10 != 0) {
            i11 = 3;
            if (i10 != 2) {
                i11 = i10 != 3 ? 0 : 2;
            }
        } else {
            i11 = 1;
        }
        m.e(f1918f, "rotateExtendScreen: original:" + i10 + "; calVal:" + i11);
        if (orientation == i11) {
            m.e(f1918f, "rotateExtendScreen: rotation same");
            return false;
        }
        z.a.f9097a.X(i11);
        d(i10, surface);
        return true;
    }

    public void j(f fVar) {
        this.f1922a = 2;
        boolean z10 = fVar.getWidth() >= 0 || fVar.getHeight() >= 0;
        this.f1924c = z10 ? fVar.getWidth() : a.c(SourceApplication.b());
        this.f1925d = z10 ? fVar.getHeight() : a.a(SourceApplication.b());
        z.a.f9097a.l(fVar, this.f1923b);
    }

    public void k(b0 b0Var) {
        this.f1926e = null;
        z.a.f9097a.Z(b0Var);
        l1.h.f18073a.V1(b0Var);
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        a();
        z.a.f9097a.Z(this.f1926e);
        l1.h.f18073a.V1(this.f1926e);
        c0.b.f17991a.n0();
    }
}
