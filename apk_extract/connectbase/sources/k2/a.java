package k2;

import android.view.MotionEvent;
import f2.g;
import j2.e;
import java.util.Iterator;
import java.util.List;
import kn.l0;
import kn.w;
import nm.y;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @l
    public static final C0233a f8905h = new C0233a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @l
    public static final String f8906i = "AnimPlayer.AnimPluginManager";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f8907j = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final g f8908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final e f8909b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public final i2.a f8910c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public final List<b> f8911d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f8912e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f8913f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f8914g;

    /* JADX INFO: renamed from: k2.a$a, reason: collision with other inner class name */
    public static final class C0233a {
        public C0233a() {
        }

        public C0233a(w wVar) {
        }
    }

    public a(@l g gVar) {
        l0.p(gVar, "player");
        this.f8908a = gVar;
        e eVar = new e(gVar);
        this.f8909b = eVar;
        i2.a aVar = new i2.a(gVar);
        this.f8910c = aVar;
        this.f8911d = y.O(eVar, aVar);
    }

    @m
    public final i2.a a() {
        return this.f8910c;
    }

    @m
    public final e b() {
        return this.f8909b;
    }

    @l
    public final g c() {
        return this.f8908a;
    }

    public final int d(@l f2.a aVar) {
        l0.p(aVar, "config");
        l2.a.f9640a.e(f8906i, "onConfigCreate");
        Iterator<T> it = this.f8911d.iterator();
        while (it.hasNext()) {
            int iE = ((b) it.next()).e(aVar);
            if (iE != 0) {
                return iE;
            }
        }
        return 0;
    }

    public final void e(int i10) {
        l2.a.f9640a.a(f8906i, l0.C("onDecoding decodeIndex=", Integer.valueOf(i10)));
        this.f8913f = i10;
        Iterator<T> it = this.f8911d.iterator();
        while (it.hasNext()) {
            ((b) it.next()).f(i10);
        }
    }

    public final void f() {
        l2.a.f9640a.e(f8906i, "onDestroy");
        Iterator<T> it = this.f8911d.iterator();
        while (it.hasNext()) {
            ((b) it.next()).b();
        }
    }

    public final boolean g(@l MotionEvent motionEvent) {
        l0.p(motionEvent, "ev");
        Iterator<T> it = this.f8911d.iterator();
        while (it.hasNext()) {
            if (((b) it.next()).c(motionEvent)) {
                return true;
            }
        }
        return false;
    }

    public final void h() {
        l2.a.f9640a.e(f8906i, "onLoopStart");
        this.f8912e = 0;
        this.f8913f = 0;
    }

    public final void i() {
        l2.a.f9640a.e(f8906i, "onRelease");
        Iterator<T> it = this.f8911d.iterator();
        while (it.hasNext()) {
            ((b) it.next()).d();
        }
    }

    public final void j() {
        l2.a.f9640a.e(f8906i, "onRenderCreate");
        this.f8912e = 0;
        this.f8913f = 0;
        Iterator<T> it = this.f8911d.iterator();
        while (it.hasNext()) {
            ((b) it.next()).g();
        }
    }

    public final void k() {
        if (this.f8913f > this.f8912e + 1 || this.f8914g >= 4) {
            l2.a.f9640a.e(f8906i, "jump frameIndex= " + this.f8912e + ",decodeIndex=" + this.f8913f + ",frameDiffTimes=" + this.f8914g);
            this.f8912e = this.f8913f;
        }
        int i10 = this.f8913f;
        int i11 = this.f8912e;
        if (i10 != i11) {
            this.f8914g++;
        } else {
            this.f8914g = 0;
        }
        l2.a.f9640a.a(f8906i, l0.C("onRendering frameIndex=", Integer.valueOf(i11)));
        Iterator<T> it = this.f8911d.iterator();
        while (it.hasNext()) {
            ((b) it.next()).a(this.f8912e);
        }
        this.f8912e++;
    }
}
