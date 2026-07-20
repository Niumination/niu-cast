package lj;

import android.view.MotionEvent;

/* JADX INFO: loaded from: classes2.dex */
public class c extends b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f10029g = "LeftHorizontal";

    public c(g gVar) {
        super(1, gVar);
    }

    @Override // lj.b
    public void a(e eVar, int i10, int i11) {
        eVar.w(i10, -i10, i11);
    }

    @Override // lj.b
    public void b(e eVar, int i10, int i11, int i12, int i13, int i14) {
        eVar.e(i10, i11, i12, i13, i14);
    }

    @Override // lj.b
    public void c(e eVar, int i10, int i11) {
        eVar.w(Math.abs(i10), i().k() - Math.abs(i10), i11);
    }

    @Override // lj.b
    public void d(e eVar, int i10, int i11, int i12, int i13, int i14) {
        eVar.e(i10, i11, i12, i13, i14);
    }

    @Override // lj.b
    public b.a e(int i10, int i11) {
        b.a aVar = this.f10024c;
        aVar.f10026a = i10;
        aVar.f10027b = i11;
        aVar.f10028c = false;
        if (i10 == 0) {
            aVar.f10028c = true;
        }
        if (i10 >= 0) {
            aVar.f10026a = 0;
        }
        if (aVar.f10026a <= (-i().k())) {
            this.f10024c.f10026a = -i().k();
        }
        return this.f10024c;
    }

    @Override // lj.b
    public int f(int i10, float f10, MotionEvent motionEvent, boolean z10) {
        int iJ;
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        int iH = h();
        if (iH <= 0 || x10 < i10 - j() || (iJ = j()) <= 0) {
            return -1;
        }
        if (!z10 || !i().o()) {
            return ((int) (x10 - (i10 - iJ))) / (iJ / iH);
        }
        float fO = i().i().get(0).o();
        int i11 = i10 - iJ;
        int iJ2 = (int) (((x10 - i11) - (i().j() * 2)) / fO);
        if (iJ2 >= 0 && iJ2 < iH) {
            if (Math.sqrt(Math.pow(((double) y10) - ((double) (f10 / 2.0f)), 2.0d) + Math.pow(((double) x10) - ((double) (((iJ2 * fO) + (i().j() + i11)) + i().f())), 2.0d)) > i().f()) {
                return -1;
            }
        }
        return iJ2;
    }

    @Override // lj.b
    public boolean l(int i10, float f10) {
        return f10 < ((float) i10);
    }

    @Override // lj.b
    public boolean n(int i10) {
        int iG = g() * i().k();
        return Math.abs(i10 - iG) <= 8 && iG != 0;
    }

    @Override // lj.b
    public boolean o(int i10) {
        return i10 < g() * (-i().k());
    }
}
