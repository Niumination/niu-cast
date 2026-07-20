package d6;

import android.os.Handler;
import com.tencent.qgame.animplayer.AnimView;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AnimView f4311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f4312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f4313c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public t f4314d;
    public l e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f4315g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f4316h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f4317i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f4318j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f4319k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Runnable f4320l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f4321m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f4322n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final sj.a f4323o;
    public final ef.g p;

    public d(AnimView animView) {
        Intrinsics.checkNotNullParameter(animView, "animView");
        this.f4311a = animView;
        this.f4312b = true;
        this.f4317i = 1;
        this.f4323o = new sj.a(this);
        this.p = new ef.g(this);
    }

    public final void a(e6.b fileContainer) {
        l lVar;
        int i8 = 1;
        synchronized (d.class) {
            try {
                if (this.f4319k) {
                    this.f4321m = false;
                    t tVar = this.f4314d;
                    if (tVar != null) {
                        Intrinsics.checkNotNullParameter(fileContainer, "fileContainer");
                        tVar.f4353j = false;
                        tVar.f4358o = false;
                        tVar.f4352i = true;
                        Handler handler = tVar.f4348c.f4335b;
                        if (handler != null) {
                            handler.post(new a0.e(7, tVar, fileContainer));
                        }
                    }
                    if (!this.f4322n && (lVar = this.e) != null) {
                        lVar.c(fileContainer);
                    }
                } else {
                    this.f4320l = new b(this, fileContainer, i8);
                    this.f4311a.b();
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void b(e6.b fileContainer, boolean z2) {
        l lVar;
        int i8 = 1;
        synchronized (d.class) {
            try {
                if (this.f4319k) {
                    this.f4321m = false;
                    t tVar = this.f4314d;
                    if (tVar != null) {
                        tVar.f4351h = z2;
                    }
                    if (tVar != null) {
                        Intrinsics.checkNotNullParameter(fileContainer, "fileContainer");
                        tVar.f4353j = false;
                        tVar.f4358o = false;
                        tVar.f4352i = true;
                        Handler handler = tVar.f4348c.f4335b;
                        if (handler != null) {
                            handler.post(new a0.e(7, tVar, fileContainer));
                        }
                    }
                    if (!this.f4322n && (lVar = this.e) != null) {
                        lVar.c(fileContainer);
                    }
                } else {
                    this.f4320l = new c(this, fileContainer, z2, i8);
                    this.f4311a.b();
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final boolean c() {
        if (!this.f4321m) {
            t tVar = this.f4314d;
            if (!(tVar == null ? false : tVar.f4352i)) {
                return false;
            }
        }
        return true;
    }

    public final void d() {
        this.f4319k = false;
        this.f4321m = false;
        t tVar = this.f4314d;
        if (tVar != null) {
            if (tVar.f4352i) {
                tVar.f4358o = true;
                tVar.f4353j = true;
            } else {
                tVar.g();
            }
        }
        l lVar = this.e;
        if (lVar == null) {
            return;
        }
        if (!lVar.f) {
            lVar.a();
        } else {
            lVar.f4333i = true;
            lVar.f4332h = true;
        }
    }

    public final void e() {
        if (this.f4314d == null) {
            t tVar = new t(this);
            tVar.f4360s = this.f4312b;
            tVar.f4350g = this.f4316h;
            int i8 = this.f;
            j6.l lVar = (j6.l) tVar.f4354k.getValue();
            lVar.getClass();
            if (i8 > 0) {
                lVar.f6125c = 1000000 / ((long) i8);
            }
            Unit unit = Unit.INSTANCE;
            this.f4314d = tVar;
        }
        if (this.e == null) {
            l lVar2 = new l(this);
            lVar2.f4331g = this.f4316h;
            Unit unit2 = Unit.INSTANCE;
            this.e = lVar2;
        }
    }
}
