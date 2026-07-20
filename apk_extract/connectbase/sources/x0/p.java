package x0;

import android.graphics.Color;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y0.c.a f19922a = y0.c.a.a("x", "y");

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19923a;

        static {
            int[] iArr = new int[y0.c.b.values().length];
            f19923a = iArr;
            try {
                iArr[y0.c.b.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19923a[y0.c.b.BEGIN_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f19923a[y0.c.b.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static PointF a(y0.c cVar, float f10) throws IOException {
        cVar.c();
        float fQ = (float) cVar.q();
        float fQ2 = (float) cVar.q();
        while (cVar.O() != y0.c.b.END_ARRAY) {
            cVar.g0();
        }
        cVar.h();
        return new PointF(fQ * f10, fQ2 * f10);
    }

    public static PointF b(y0.c cVar, float f10) throws IOException {
        float fQ = (float) cVar.q();
        float fQ2 = (float) cVar.q();
        while (cVar.o()) {
            cVar.g0();
        }
        return new PointF(fQ * f10, fQ2 * f10);
    }

    public static PointF c(y0.c cVar, float f10) throws IOException {
        cVar.d();
        float fG = 0.0f;
        float fG2 = 0.0f;
        while (cVar.o()) {
            int iE0 = cVar.e0(f19922a);
            if (iE0 == 0) {
                fG = g(cVar);
            } else if (iE0 != 1) {
                cVar.f0();
                cVar.g0();
            } else {
                fG2 = g(cVar);
            }
        }
        cVar.k();
        return new PointF(fG * f10, fG2 * f10);
    }

    @ColorInt
    public static int d(y0.c cVar) throws IOException {
        cVar.c();
        int iQ = (int) (cVar.q() * 255.0d);
        int iQ2 = (int) (cVar.q() * 255.0d);
        int iQ3 = (int) (cVar.q() * 255.0d);
        while (cVar.o()) {
            cVar.g0();
        }
        cVar.h();
        return Color.argb(255, iQ, iQ2, iQ3);
    }

    public static PointF e(y0.c cVar, float f10) throws IOException {
        int i10 = a.f19923a[cVar.O().ordinal()];
        if (i10 == 1) {
            return b(cVar, f10);
        }
        if (i10 == 2) {
            return a(cVar, f10);
        }
        if (i10 == 3) {
            return c(cVar, f10);
        }
        throw new IllegalArgumentException("Unknown point starts with " + cVar.O());
    }

    public static List<PointF> f(y0.c cVar, float f10) throws IOException {
        ArrayList arrayList = new ArrayList();
        cVar.c();
        while (cVar.O() == y0.c.b.BEGIN_ARRAY) {
            cVar.c();
            arrayList.add(e(cVar, f10));
            cVar.h();
        }
        cVar.h();
        return arrayList;
    }

    public static float g(y0.c cVar) throws IOException {
        y0.c.b bVarO = cVar.O();
        int i10 = a.f19923a[bVarO.ordinal()];
        if (i10 == 1) {
            return (float) cVar.q();
        }
        if (i10 != 2) {
            throw new IllegalArgumentException("Unknown value for token of type " + bVarO);
        }
        cVar.c();
        float fQ = (float) cVar.q();
        while (cVar.o()) {
            cVar.g0();
        }
        cVar.h();
        return fQ;
    }
}
