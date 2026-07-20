package u1;

import android.graphics.Color;
import android.graphics.PointF;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f5.a f10307a = f5.a.g("x", "y");

    public static int a(v1.d dVar) {
        dVar.a();
        int iL = (int) (dVar.l() * 255.0d);
        int iL2 = (int) (dVar.l() * 255.0d);
        int iL3 = (int) (dVar.l() * 255.0d);
        while (dVar.i()) {
            dVar.B();
        }
        dVar.g();
        return Color.argb(255, iL, iL2, iL3);
    }

    public static PointF b(v1.d dVar, float f) {
        int i8 = n.f10306a[dVar.s().ordinal()];
        if (i8 == 1) {
            float fL = (float) dVar.l();
            float fL2 = (float) dVar.l();
            while (dVar.i()) {
                dVar.B();
            }
            return new PointF(fL * f, fL2 * f);
        }
        if (i8 == 2) {
            dVar.a();
            float fL3 = (float) dVar.l();
            float fL4 = (float) dVar.l();
            while (dVar.s() != v1.c.END_ARRAY) {
                dVar.B();
            }
            dVar.g();
            return new PointF(fL3 * f, fL4 * f);
        }
        if (i8 != 3) {
            throw new IllegalArgumentException("Unknown point starts with " + dVar.s());
        }
        dVar.c();
        float fD = 0.0f;
        float fD2 = 0.0f;
        while (dVar.i()) {
            int iW = dVar.w(f10307a);
            if (iW == 0) {
                fD = d(dVar);
            } else if (iW != 1) {
                dVar.A();
                dVar.B();
            } else {
                fD2 = d(dVar);
            }
        }
        dVar.h();
        return new PointF(fD * f, fD2 * f);
    }

    public static ArrayList c(v1.d dVar, float f) {
        ArrayList arrayList = new ArrayList();
        dVar.a();
        while (dVar.s() == v1.c.BEGIN_ARRAY) {
            dVar.a();
            arrayList.add(b(dVar, f));
            dVar.g();
        }
        dVar.g();
        return arrayList;
    }

    public static float d(v1.d dVar) {
        v1.c cVarS = dVar.s();
        int i8 = n.f10306a[cVarS.ordinal()];
        if (i8 == 1) {
            return (float) dVar.l();
        }
        if (i8 != 2) {
            throw new IllegalArgumentException("Unknown value for token of type " + cVarS);
        }
        dVar.a();
        float fL = (float) dVar.l();
        while (dVar.i()) {
            dVar.B();
        }
        dVar.g();
        return fL;
    }
}
