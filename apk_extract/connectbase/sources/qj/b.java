package qj;

import android.content.res.Resources;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.transsion.widgetsThemes.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static float f14000n = 0.0f;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static int f14001o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static int f14002p = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f14003q = 1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f14004r = 2;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f14005s = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f14006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f14007b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList<a> f14010e;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a f14014i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public a f14015j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public a f14016k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f14017l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f14018m;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14008c = 300;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f14011f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f14012g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f14013h = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Interpolator f14009d = new AccelerateInterpolator();

    public b(View view) {
        this.f14006a = view;
        Resources resources = view.getResources();
        f14000n = resources.getDimension(R.dimen.os_overflowmenu_circle_radiu);
        int dimension = (int) resources.getDimension(R.dimen.os_overflowmenu_circle_spacing);
        f14001o = dimension;
        f14002p = (int) ((f14000n * 2.0f) + dimension);
        c();
    }

    public void a() {
        if (this.f14011f != 4) {
            return;
        }
        if (this.f14012g) {
            this.f14011f = 2;
        } else {
            this.f14011f = 1;
        }
        e(this.f14010e.get(1), this.f14010e.get(2), 0);
    }

    public final void b(ArrayList<a> arrayList) {
        int i10 = this.f14017l - f14002p;
        this.f14014i.c(i10, i10, f14000n);
        int i11 = this.f14018m;
        this.f14015j.c(i10, i11, f14000n);
        int i12 = this.f14018m + f14002p;
        this.f14016k.c(i10, i12, f14000n);
        this.f14015j.b(i12, i10);
        this.f14016k.b(i11, i11);
        arrayList.add(0, this.f14014i);
        arrayList.add(1, this.f14015j);
        arrayList.add(2, this.f14016k);
    }

    public final void c() {
        this.f14014i = new a();
        this.f14015j = new a();
        this.f14016k = new a();
    }

    public final void d(ArrayList<a> arrayList) {
        int i10 = this.f14017l;
        int i11 = f14002p;
        int i12 = i10 + i11;
        int i13 = this.f14018m - i11;
        this.f14014i.c(i12, i13, f14000n);
        int i14 = this.f14018m;
        this.f14015j.c(i12, i14, f14000n);
        this.f14016k.c(i12, this.f14018m + f14002p, f14000n);
        this.f14015j.b(i13, i13);
        this.f14016k.b(i14, i14);
        arrayList.add(0, this.f14014i);
        arrayList.add(1, this.f14015j);
        arrayList.add(2, this.f14016k);
    }

    public final void e(a aVar, a aVar2, int i10) {
        if (this.f14012g) {
            this.f14011f = 2;
            if (this.f14013h == 0) {
                aVar.b(this.f14017l - f14002p, this.f14018m);
                int i11 = this.f14017l;
                int i12 = f14002p;
                aVar2.b(i11 - i12, this.f14018m + i12);
            } else {
                aVar.b(this.f14017l + f14002p, this.f14018m);
                int i13 = this.f14017l;
                int i14 = f14002p;
                aVar2.b(i13 + i14, this.f14018m + i14);
            }
        } else {
            this.f14011f = 1;
            if (this.f14013h == 0) {
                int i15 = this.f14017l;
                int i16 = f14002p;
                aVar.b(i15 + i16, this.f14018m - i16);
                aVar2.b(this.f14017l, this.f14018m);
            } else {
                int i17 = this.f14017l;
                int i18 = f14002p;
                aVar.b(i17 - i18, this.f14018m - i18);
                aVar2.b(this.f14017l, this.f14018m);
            }
        }
        this.f14006a.invalidate();
    }

    public void f(int i10, int i11) {
        this.f14017l = i10;
        this.f14018m = i11;
    }

    public void g(int i10) {
        this.f14008c = i10;
    }

    public void h(int i10, ArrayList<a> arrayList) {
        if (this.f14013h != i10) {
            arrayList.clear();
            if (i10 == 0) {
                b(arrayList);
            } else {
                d(arrayList);
            }
        }
        this.f14010e = arrayList;
        this.f14013h = i10;
    }

    public void i(boolean z10, int i10) {
        if (this.f14011f == 4) {
            e(this.f14010e.get(1), this.f14010e.get(2), 1);
        }
        this.f14012g = z10;
        this.f14007b = AnimationUtils.currentAnimationTimeMillis();
        this.f14011f = 4;
        j();
    }

    public void j() {
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        float interpolation = this.f14009d.getInterpolation(Math.min((jCurrentAnimationTimeMillis - this.f14007b) / (this.f14008c * 1.0f), 1.0f));
        if (this.f14010e.size() < 3) {
            return;
        }
        a aVar = this.f14010e.get(1);
        int i10 = aVar.f13995a;
        aVar.f13995a = (int) (((aVar.f13997c - i10) * interpolation) + i10);
        int i11 = aVar.f13996b;
        aVar.f13996b = (int) (((aVar.f13998d - i11) * interpolation) + i11);
        a aVar2 = this.f14010e.get(2);
        int i12 = aVar2.f13995a;
        aVar2.f13995a = (int) (((aVar2.f13997c - i12) * interpolation) + i12);
        int i13 = aVar2.f13996b;
        aVar2.f13996b = (int) (((aVar2.f13998d - i13) * interpolation) + i13);
        this.f14006a.invalidate();
        if (jCurrentAnimationTimeMillis - this.f14007b >= this.f14008c) {
            e(aVar, aVar2, 0);
        }
    }
}
