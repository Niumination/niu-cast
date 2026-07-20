package d8;

import a8.e;
import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.util.Log;
import android.view.Choreographer;
import android.view.View;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f4377m = new a(0);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a f4378n = new a(1);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a f4379o = new a(2);
    public static final a p = new a(4);
    public static final a q = new a(5);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final a f4380r = new a(6);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final a f4381s = new a(7);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final a f4382t = new a(3);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f4385c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f4386d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f4387g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public uk.a f4390j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public uk.b f4391k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f4392l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f4383a = 0.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f4384b = Float.MAX_VALUE;
    public boolean e = false;
    public long f = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList f4388h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayList f4389i = new ArrayList();

    public d(View view, a aVar) {
        this.f4385c = view;
        this.f4386d = aVar;
        this.f4387g = (aVar == q || aVar == f4380r || aVar == f4381s) ? 0.1f : aVar == f4382t ? 0.00390625f : (aVar == f4379o || aVar == p) ? 0.002f : 1.0f;
        this.f4391k = null;
        this.f4392l = Float.MAX_VALUE;
    }

    public final void a(c cVar) {
        if (this.e) {
            throw new UnsupportedOperationException("Error: Update listeners must be added beforethe animation.");
        }
        ArrayList arrayList = this.f4389i;
        if (arrayList.contains(cVar)) {
            return;
        }
        arrayList.add(cVar);
    }

    public final void b() {
        ad.b bVar = d().e;
        bVar.getClass();
        if (Thread.currentThread() != ((Looper) bVar.f93b).getThread()) {
            throw new AndroidRuntimeException("Animations may only be canceled from the same thread as the animation handler");
        }
        if (this.e) {
            c(true);
        }
        float f = this.f4392l;
        if (f != Float.MAX_VALUE) {
            uk.b bVar2 = this.f4391k;
            if (bVar2 == null) {
                this.f4391k = new uk.b(f);
            } else {
                bVar2.f10455i = f;
            }
            this.f4392l = Float.MAX_VALUE;
        }
    }

    public final void c(boolean z2) {
        ArrayList arrayList;
        int i8 = 0;
        this.e = false;
        uk.a aVarD = d();
        aVarD.f10444a.remove(this);
        ArrayList arrayList2 = aVarD.f10445b;
        int iIndexOf = arrayList2.indexOf(this);
        if (iIndexOf >= 0) {
            arrayList2.set(iIndexOf, null);
            aVarD.f10448g = true;
        }
        this.f = 0L;
        while (true) {
            arrayList = this.f4388h;
            if (i8 >= arrayList.size()) {
                break;
            }
            if (arrayList.get(i8) != null) {
                ((b) arrayList.get(i8)).mo1636b();
            }
            i8++;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    public final uk.a d() {
        if (this.f4390j == null) {
            ThreadLocal threadLocal = uk.a.f10443h;
            if (threadLocal.get() == null) {
                threadLocal.set(new uk.a(new ad.b(6)));
            }
            this.f4390j = (uk.a) threadLocal.get();
        }
        return this.f4390j;
    }

    public final void e(float f) {
        a aVar = this.f4386d;
        View view = this.f4385c;
        switch (aVar.f4376a) {
            case 0:
                view.setTranslationX(f);
                break;
            case 1:
                view.setTranslationY(f);
                break;
            case 2:
                view.setScaleX(f);
                break;
            case 3:
                view.setAlpha(f);
                break;
            case 4:
                view.setScaleY(f);
                break;
            case 5:
                view.setRotation(f);
                break;
            case 6:
                view.setRotationX(f);
                break;
            default:
                view.setRotationY(f);
                break;
        }
        int i8 = 0;
        while (true) {
            ArrayList arrayList = this.f4389i;
            if (i8 >= arrayList.size()) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (arrayList.get(size) == null) {
                        arrayList.remove(size);
                    }
                }
                return;
            }
            if (arrayList.get(i8) != null) {
                ((c) arrayList.get(i8)).d(this.f4384b);
            }
            i8++;
        }
    }

    public final void f() {
        float translationX;
        if (this.f4391k == null) {
            uk.b bVar = new uk.b(0.0f);
            bVar.c(200.0f);
            bVar.b(1.0f);
            this.f4391k = bVar;
            Log.e("SpringAnimation", "Incomplete SpringAnimation: Either final\"\n                    + \" position or a spring force needs to be set.");
        }
        uk.b bVar2 = this.f4391k;
        double d7 = (float) bVar2.f10455i;
        if (d7 > Float.MAX_VALUE) {
            throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
        }
        if (d7 < -3.4028235E38f) {
            throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
        }
        double dAbs = Math.abs(this.f4387g * 0.75f);
        bVar2.f10452d = dAbs;
        bVar2.e = dAbs * 62.5d;
        ad.b bVar3 = d().e;
        bVar3.getClass();
        if (Thread.currentThread() != ((Looper) bVar3.f93b).getThread()) {
            throw new AndroidRuntimeException("Animations may only be started on the same thread as the animation handler");
        }
        boolean z2 = this.e;
        if (z2 || z2) {
            return;
        }
        this.e = true;
        a aVar = this.f4386d;
        View view = this.f4385c;
        switch (aVar.f4376a) {
            case 0:
                translationX = view.getTranslationX();
                break;
            case 1:
                translationX = view.getTranslationY();
                break;
            case 2:
                translationX = view.getScaleX();
                break;
            case 3:
                translationX = view.getAlpha();
                break;
            case 4:
                translationX = view.getScaleY();
                break;
            case 5:
                translationX = view.getRotation();
                break;
            case 6:
                translationX = view.getRotationX();
                break;
            default:
                translationX = view.getRotationY();
                break;
        }
        this.f4384b = translationX;
        if (translationX > Float.MAX_VALUE || translationX < -3.4028235E38f) {
            throw new IllegalArgumentException("Starting value need to be in between min value and max value");
        }
        uk.a aVarD = d();
        if (aVarD.f10445b.size() == 0) {
            ad.b bVar4 = aVarD.e;
            bVar4.getClass();
            ((Choreographer) bVar4.f92a).postFrameCallback(new a8.b(aVarD.f10447d, 1));
        }
        ArrayList arrayList = aVarD.f10445b;
        if (arrayList.contains(this)) {
            return;
        }
        arrayList.add(this);
    }

    public final boolean g(long j8) {
        uk.b bVar;
        double d7;
        double d10;
        long j10;
        if (this.f4392l != Float.MAX_VALUE) {
            j10 = j8 / 2;
            e eVarA = this.f4391k.a(this.f4384b, this.f4383a, j10);
            bVar = this.f4391k;
            bVar.f10455i = this.f4392l;
            this.f4392l = Float.MAX_VALUE;
            d7 = eVarA.f55a;
            d10 = eVarA.f56b;
        } else {
            bVar = this.f4391k;
            d7 = this.f4384b;
            d10 = this.f4383a;
            j10 = j8;
        }
        e eVarA2 = bVar.a(d7, d10, j10);
        this.f4384b = eVarA2.f55a;
        this.f4383a = eVarA2.f56b;
        float fMax = Math.max(this.f4384b, -3.4028235E38f);
        this.f4384b = fMax;
        float fMin = Math.min(fMax, Float.MAX_VALUE);
        this.f4384b = fMin;
        float f = this.f4383a;
        uk.b bVar2 = this.f4391k;
        bVar2.getClass();
        if (Math.abs(f) >= bVar2.e || Math.abs(fMin - ((float) bVar2.f10455i)) >= bVar2.f10452d) {
            return false;
        }
        this.f4384b = (float) this.f4391k.f10455i;
        this.f4383a = 0.0f;
        return true;
    }
}
