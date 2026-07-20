package k5;

import android.os.SystemClock;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import w4.o1;

/* JADX INFO: loaded from: classes2.dex */
public class c0 implements e0<j.a, MotionEvent> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f8984f = "ExtendTouchEventConverter";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f8985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8987c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f8988d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public i6.c<j.a> f8989e;

    public c0(View view) {
        this.f8985a = view;
    }

    @Override // k5.e0
    public void a(int i10, int i11) {
        if (i10 < 0) {
            i10 = 0;
        }
        if (i11 < 0) {
            i11 = 0;
        }
        this.f8986b = i10;
        this.f8987c = i11;
    }

    @Override // k5.e0
    public void b(int i10) {
        m2.b.a("setOrientation:", i10, f8984f);
        this.f8988d = i10;
    }

    @Override // k5.e0
    public void d(i6.c<j.a> cVar) {
        this.f8989e = cVar;
    }

    public final Pair<Double, Double> e(float f10, float f11) {
        int i10 = this.f8988d;
        if (i10 == 1) {
            return new Pair<>(Double.valueOf(i(Math.abs(this.f8987c - f11))), Double.valueOf(h(f10)));
        }
        if (i10 == 2) {
            return new Pair<>(Double.valueOf(h(Math.abs(this.f8986b - f10))), Double.valueOf(i(Math.abs(this.f8987c - f11))));
        }
        if (i10 != 3) {
            return new Pair<>(Double.valueOf(h(f10)), Double.valueOf(i(f11)));
        }
        return new Pair<>(Double.valueOf(i(f11)), Double.valueOf(h(Math.abs(this.f8986b - f10))));
    }

    public final j.a f(List<j.b> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return new j.a(list);
    }

    public final j.e g(float f10, float f11, int i10, int i11) {
        Pair<Double, Double> pairE = e(f10, f11);
        return new j.e(SystemClock.elapsedRealtime(), i10, ((Double) pairE.first).doubleValue(), ((Double) pairE.second).doubleValue(), 0, i11);
    }

    public final double h(float f10) {
        if (this.f8986b == 0) {
            return 0.0d;
        }
        return ((double) (f10 - this.f8985a.getLeft())) / ((double) this.f8986b);
    }

    public final double i(float f10) {
        if (this.f8987c == 0) {
            return 0.0d;
        }
        return ((double) (f10 - this.f8985a.getTop())) / ((double) this.f8987c);
    }

    @Override // k5.e0
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public void c(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        int actionIndex = motionEvent.getActionIndex();
        int actionMasked = motionEvent.getActionMasked();
        ArrayList arrayList = new ArrayList(pointerCount);
        if (actionMasked == 2) {
            for (int i10 = 0; i10 < pointerCount; i10++) {
                arrayList.add(g(motionEvent.getX(i10), motionEvent.getY(i10), actionMasked, motionEvent.getPointerId(i10)));
            }
        } else {
            arrayList.add(g(motionEvent.getX(actionIndex), motionEvent.getY(actionIndex), actionMasked, motionEvent.getPointerId(actionIndex)));
        }
        k(f(arrayList));
        o1.a.f18113a.p();
    }

    public final void k(j.a aVar) {
        i6.c<j.a> cVar = this.f8989e;
        if (cVar != null) {
            cVar.a(aVar);
        }
    }
}
