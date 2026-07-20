package lj;

import android.view.MotionEvent;

/* JADX INFO: loaded from: classes2.dex */
public class f extends b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f10069g = "RightHorizontal";

    public f(g gVar) {
        super(-1, gVar);
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
        eVar.w(i10, Math.abs(i10) + (-i().k()), i11);
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
        if (i10 < 0) {
            aVar.f10026a = 0;
        }
        if (aVar.f10026a > i().k()) {
            this.f10024c.f10026a = i().k();
        }
        return this.f10024c;
    }

    @Override // lj.b
    public int f(int i10, float f10, MotionEvent motionEvent, boolean z10) {
        int iJ;
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        int iH = h();
        if (iH <= 0 || x10 > j() || (iJ = j()) <= 0) {
            return -1;
        }
        if (!z10 || !i().o()) {
            return ((int) Math.abs(x10)) / (iJ / iH);
        }
        float fO = i().i().get(0).o();
        int iAbs = (int) (Math.abs(x10 - i().j()) / fO);
        if (iAbs >= 0 && iAbs < iH) {
            if (Math.sqrt(Math.pow(((double) y10) - ((double) (f10 / 2.0f)), 2.0d) + Math.pow(((double) x10) - ((double) (((iAbs * fO) + i().j()) + i().f())), 2.0d)) > i().f()) {
                return -1;
            }
        }
        return iAbs;
    }

    @Override // lj.b
    public boolean l(int i10, float f10) {
        return f10 > ((float) i().k());
    }

    @Override // lj.b
    public boolean n(int i10) {
        int iG = g() * i().k();
        return Math.abs(i10 - iG) <= 8 && iG != 0;
    }

    @Override // lj.b
    public boolean o(int i10) {
        return i10 > g() * (-i().k());
    }
}
