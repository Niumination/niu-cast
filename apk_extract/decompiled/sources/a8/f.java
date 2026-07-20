package a8;

import android.view.Choreographer;
import android.view.View;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final d f57n = new d(1);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final d f58o = new d(2);
    public static final d p = new d(3);
    public static final d q = new d(4);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final d f59r = new d(5);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final d f60s = new d(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f64d;
    public final d e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f66h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public c f69k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public g f70l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f71m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f61a = 0.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f62b = Float.MAX_VALUE;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f63c = false;
    public boolean f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f65g = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayList f67i = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArrayList f68j = new ArrayList();

    public f(Object obj, d dVar) {
        this.f64d = obj;
        this.e = dVar;
        if (dVar == p || dVar == q || dVar == f59r) {
            this.f66h = 0.1f;
        } else if (dVar == f60s) {
            this.f66h = 0.00390625f;
        } else if (dVar == f57n || dVar == f58o) {
            this.f66h = 0.002f;
        } else {
            this.f66h = 1.0f;
        }
        this.f70l = null;
        this.f71m = Float.MAX_VALUE;
    }

    public final c a() {
        if (this.f69k == null) {
            ThreadLocal threadLocal = c.f47g;
            if (threadLocal.get() == null) {
                threadLocal.set(new c(new o5.c(1)));
            }
            this.f69k = (c) threadLocal.get();
        }
        return this.f69k;
    }

    public final void b(float f) {
        d dVar = this.e;
        Object obj = this.f64d;
        switch (dVar.f54a) {
            case 0:
                ((View) obj).setAlpha(f);
                break;
            case 1:
                ((View) obj).setScaleX(f);
                break;
            case 2:
                ((View) obj).setScaleY(f);
                break;
            case 3:
                ((View) obj).setRotation(f);
                break;
            case 4:
                ((View) obj).setRotationX(f);
                break;
            default:
                ((View) obj).setRotationY(f);
                break;
        }
        int i8 = 0;
        while (true) {
            ArrayList arrayList = this.f68j;
            if (i8 >= arrayList.size()) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (arrayList.get(size) == null) {
                        arrayList.remove(size);
                    }
                }
                return;
            }
            if (arrayList.get(i8) != null) {
                arrayList.get(i8).getClass();
                throw new ClassCastException();
            }
            i8++;
        }
    }

    public final void c() {
        float alpha;
        g gVar = this.f70l;
        if (gVar == null) {
            throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
        }
        double d7 = (float) gVar.f78i;
        if (d7 > Float.MAX_VALUE) {
            throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
        }
        if (d7 < -3.4028235E38f) {
            throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
        }
        double dAbs = Math.abs(this.f66h * 0.75f);
        gVar.f75d = dAbs;
        gVar.e = dAbs * 62.5d;
        boolean z2 = this.f;
        if (z2 || z2) {
            return;
        }
        this.f = true;
        if (!this.f63c) {
            d dVar = this.e;
            Object obj = this.f64d;
            switch (dVar.f54a) {
                case 0:
                    alpha = ((View) obj).getAlpha();
                    break;
                case 1:
                    alpha = ((View) obj).getScaleX();
                    break;
                case 2:
                    alpha = ((View) obj).getScaleY();
                    break;
                case 3:
                    alpha = ((View) obj).getRotation();
                    break;
                case 4:
                    alpha = ((View) obj).getRotationX();
                    break;
                default:
                    alpha = ((View) obj).getRotationY();
                    break;
            }
            this.f62b = alpha;
        }
        float f = this.f62b;
        if (f > Float.MAX_VALUE || f < -3.4028235E38f) {
            throw new IllegalArgumentException("Starting value need to be in between min value and max value");
        }
        c cVarA = a();
        ArrayList arrayList = cVarA.f49b;
        if (arrayList.size() == 0) {
            o5.c cVar = cVarA.e;
            cVar.getClass();
            ((Choreographer) cVar.f8405a).postFrameCallback(new b(cVarA.f51d, 0));
        }
        if (arrayList.contains(this)) {
            return;
        }
        arrayList.add(this);
    }
}
