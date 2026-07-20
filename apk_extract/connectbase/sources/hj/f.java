package hj;

import android.content.res.Resources;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.transsion.widgetslib.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static float f7183n = 0.0f;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static int f7184o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static int f7185p = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f7186q = 1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f7187r = 2;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f7188s = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f7189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f7190b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList<e> f7193e;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public e f7197i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public e f7198j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public e f7199k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f7200l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f7201m;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7191c = 300;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f7194f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f7195g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f7196h = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Interpolator f7192d = new AccelerateInterpolator();

    public f(View view) {
        this.f7189a = view;
        Resources resources = view.getResources();
        f7183n = resources.getDimension(R.dimen.os_overflowmenu_circle_radiu);
        int dimension = (int) resources.getDimension(R.dimen.os_overflowmenu_circle_spacing);
        f7184o = dimension;
        f7185p = (int) ((f7183n * 2.0f) + dimension);
        c();
    }

    public void a() {
        if (this.f7194f != 4) {
            return;
        }
        if (this.f7195g) {
            this.f7194f = 2;
        } else {
            this.f7194f = 1;
        }
        e(this.f7193e.get(1), this.f7193e.get(2), 0);
    }

    public final void b(ArrayList<e> arrayList) {
        int i10 = this.f7200l - f7185p;
        this.f7197i.c(i10, i10, f7183n);
        int i11 = this.f7201m;
        this.f7198j.c(i10, i11, f7183n);
        int i12 = this.f7201m + f7185p;
        this.f7199k.c(i10, i12, f7183n);
        this.f7198j.b(i12, i10);
        this.f7199k.b(i11, i11);
        arrayList.add(0, this.f7197i);
        arrayList.add(1, this.f7198j);
        arrayList.add(2, this.f7199k);
    }

    public final void c() {
        this.f7197i = new e();
        this.f7198j = new e();
        this.f7199k = new e();
    }

    public final void d(ArrayList<e> arrayList) {
        int i10 = this.f7200l;
        int i11 = f7185p;
        int i12 = i10 + i11;
        int i13 = this.f7201m - i11;
        this.f7197i.c(i12, i13, f7183n);
        int i14 = this.f7201m;
        this.f7198j.c(i12, i14, f7183n);
        this.f7199k.c(i12, this.f7201m + f7185p, f7183n);
        this.f7198j.b(i13, i13);
        this.f7199k.b(i14, i14);
        arrayList.add(0, this.f7197i);
        arrayList.add(1, this.f7198j);
        arrayList.add(2, this.f7199k);
    }

    public final void e(e eVar, e eVar2, int i10) {
        if (this.f7195g) {
            this.f7194f = 2;
            if (this.f7196h == 0) {
                eVar.b(this.f7200l - f7185p, this.f7201m);
                int i11 = this.f7200l;
                int i12 = f7185p;
                eVar2.b(i11 - i12, this.f7201m + i12);
            } else {
                eVar.b(this.f7200l + f7185p, this.f7201m);
                int i13 = this.f7200l;
                int i14 = f7185p;
                eVar2.b(i13 + i14, this.f7201m + i14);
            }
        } else {
            this.f7194f = 1;
            if (this.f7196h == 0) {
                int i15 = this.f7200l;
                int i16 = f7185p;
                eVar.b(i15 + i16, this.f7201m - i16);
                eVar2.b(this.f7200l, this.f7201m);
            } else {
                int i17 = this.f7200l;
                int i18 = f7185p;
                eVar.b(i17 - i18, this.f7201m - i18);
                eVar2.b(this.f7200l, this.f7201m);
            }
        }
        this.f7189a.invalidate();
    }

    public void f(int i10, int i11) {
        this.f7200l = i10;
        this.f7201m = i11;
    }

    public void g(int i10) {
        this.f7191c = i10;
    }

    public void h(int i10, ArrayList<e> arrayList) {
        if (this.f7196h != i10) {
            arrayList.clear();
            if (i10 == 0) {
                b(arrayList);
            } else {
                d(arrayList);
            }
        }
        this.f7193e = arrayList;
        this.f7196h = i10;
    }

    public void i(boolean z10, int i10) {
        if (this.f7194f == 4) {
            e(this.f7193e.get(1), this.f7193e.get(2), 1);
        }
        this.f7195g = z10;
        this.f7190b = AnimationUtils.currentAnimationTimeMillis();
        this.f7194f = 4;
        j();
    }

    public void j() {
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        float interpolation = this.f7192d.getInterpolation(Math.min((jCurrentAnimationTimeMillis - this.f7190b) / (this.f7191c * 1.0f), 1.0f));
        if (this.f7193e.size() < 3) {
            return;
        }
        e eVar = this.f7193e.get(1);
        int i10 = eVar.f7178a;
        eVar.f7178a = (int) (((eVar.f7180c - i10) * interpolation) + i10);
        int i11 = eVar.f7179b;
        eVar.f7179b = (int) (((eVar.f7181d - i11) * interpolation) + i11);
        e eVar2 = this.f7193e.get(2);
        int i12 = eVar2.f7178a;
        eVar2.f7178a = (int) (((eVar2.f7180c - i12) * interpolation) + i12);
        int i13 = eVar2.f7179b;
        eVar2.f7179b = (int) (((eVar2.f7181d - i13) * interpolation) + i13);
        this.f7189a.invalidate();
        if (jCurrentAnimationTimeMillis - this.f7190b >= this.f7191c) {
            e(eVar, eVar2, 0);
        }
    }
}
