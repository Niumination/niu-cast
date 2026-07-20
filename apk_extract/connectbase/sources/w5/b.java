package w5;

import android.content.Context;
import android.os.SystemClock;
import android.view.MotionEvent;
import java.lang.reflect.InvocationTargetException;
import k4.m;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f18151f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f18152g = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f18153h = 2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f18154i = "GameKeymapController";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f18158d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MotionEvent.PointerProperties[] f18155a = new MotionEvent.PointerProperties[10];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MotionEvent.PointerCoords[] f18156b = new MotionEvent.PointerCoords[10];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f18157c = new j();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final m4.c f18159e = m4.a.C0275a.f10375a;

    public b(Context context, int i10) {
        b();
    }

    public void a(x5.a aVar) {
        try {
            c(aVar);
        } catch (IllegalAccessException | InvocationTargetException e10) {
            m.d(f18154i, e10);
        }
    }

    public final void b() {
        for (int i10 = 0; i10 < 10; i10++) {
            MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
            pointerProperties.toolType = 1;
            MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
            pointerCoords.orientation = 0.0f;
            pointerCoords.size = 0.0f;
            this.f18155a[i10] = pointerProperties;
            this.f18156b[i10] = pointerCoords;
        }
    }

    public final void c(x5.a aVar) throws IllegalAccessException, InvocationTargetException {
        int iA = aVar.a();
        int iC = aVar.c();
        int iB = aVar.b();
        if (iA != 0 && iA != 1 && iA != 2) {
            m.b(f18154i, "Unsupported action: " + iA);
            return;
        }
        if (iC < 0 || iC > 9) {
            m.b(f18154i, "Unsupported id[0-9]: " + iC);
            return;
        }
        int iC2 = this.f18157c.c(iC);
        if (iC2 == -1) {
            m.c(f18154i, "error index");
            return;
        }
        this.f18157c.b(iC2).f(aVar);
        int iG = this.f18157c.g(this.f18155a, this.f18156b);
        if (iG == 1) {
            if (iA == 0) {
                this.f18158d = SystemClock.uptimeMillis();
            }
        } else if (iA == 1) {
            iA = (iC2 << 8) | 6;
        } else if (iA == 0) {
            iA = (iC2 << 8) | 5;
        }
        MotionEvent motionEventS = this.f18159e.s(this.f18158d, SystemClock.uptimeMillis(), iA, iG, this.f18155a, this.f18156b, 0, 0, 1.0f, 1.0f, 0, 0, 4098, iB, 0);
        this.f18159e.c(motionEventS, 0);
        this.f18159e.C(motionEventS);
    }
}
