package mj;

import android.content.res.Resources;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.transsion.widgetslib.R;
import hj.e;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static float f10717k = 0.0f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static int f10718l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static int f10719m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f10720n = 1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f10721o = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f10722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f10723b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList<e> f10726e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f10728g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f10729h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f10730i;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10724c = 300;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f10727f = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f10731j = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Interpolator f10725d = new AccelerateInterpolator();

    public a(View view) {
        this.f10722a = view;
        Resources resources = view.getResources();
        f10717k = resources.getDimension(R.dimen.os_overflowmenu_circle_radiu);
        int dimension = (int) resources.getDimension(R.dimen.os_overflowmenu_circle_spacing);
        f10718l = dimension;
        f10719m = (int) ((f10717k * 2.0f) + dimension);
    }

    public void a(ArrayList arrayList) {
        if (this.f10728g == 0) {
            int i10 = this.f10729h;
            int i11 = f10719m;
            int i12 = i10 + i11;
            int i13 = i10 - i11;
            e eVar = new e(i12, i13, f10717k);
            int i14 = this.f10730i;
            e eVar2 = new e(i12, i14, f10717k);
            e eVar3 = new e(i12, this.f10730i + f10719m, f10717k);
            arrayList.add(0, eVar);
            arrayList.add(1, eVar2);
            arrayList.add(2, eVar3);
            eVar.f7180c = i12;
            eVar.f7181d = i13;
            eVar2.f7180c = i12;
            eVar2.f7181d = i14;
        } else {
            int i15 = this.f10729h;
            int i16 = f10719m;
            int i17 = i15 - i16;
            int i18 = i15 - i16;
            e eVar4 = new e(i17, i18, f10717k);
            int i19 = this.f10730i;
            e eVar5 = new e(i17, i19, f10717k);
            e eVar6 = new e(i17, this.f10730i + f10719m, f10717k);
            arrayList.add(0, eVar4);
            arrayList.add(1, eVar5);
            arrayList.add(2, eVar6);
            eVar4.f7180c = i17;
            eVar4.f7181d = i18;
            eVar5.f7180c = i17;
            eVar5.f7181d = i19;
        }
        this.f10726e = arrayList;
    }

    public void b(int i10, int i11) {
        this.f10729h = i10;
        this.f10730i = i11;
    }

    public void c(int i10) {
        this.f10728g = i10;
    }

    public void d(boolean z10, int i10) {
        this.f10727f = z10;
        this.f10723b = AnimationUtils.currentAnimationTimeMillis();
        this.f10731j = 4;
        e();
    }

    public void e() {
        float interpolation = this.f10725d.getInterpolation(Math.min((AnimationUtils.currentAnimationTimeMillis() - this.f10723b) / (this.f10724c * 1.0f), 1.0f));
        if (this.f10726e.size() < 3) {
            return;
        }
        e eVar = this.f10726e.get(0);
        e eVar2 = this.f10726e.get(1);
        if (this.f10728g == 0) {
            if (this.f10727f) {
                float f10 = eVar.f7180c;
                int i10 = f10719m;
                eVar.f7178a = (int) (f10 - (i10 * interpolation));
                eVar.f7179b = (int) ((i10 * interpolation) + eVar.f7181d);
                eVar2.f7178a = (int) (eVar2.f7180c - ((i10 * 2) * interpolation));
                eVar2.f7179b = (int) ((i10 * interpolation) + eVar2.f7181d);
            } else {
                int i11 = eVar.f7178a;
                eVar.f7178a = (int) (((eVar.f7180c - i11) * interpolation) + i11);
                int i12 = eVar.f7179b;
                eVar.f7179b = (int) (((eVar.f7181d - i12) * interpolation) + i12);
                int i13 = eVar2.f7178a;
                eVar2.f7178a = (int) (((eVar2.f7180c - i13) * interpolation) + i13);
                int i14 = eVar2.f7179b;
                eVar2.f7179b = (int) (((eVar2.f7181d - i14) * interpolation) + i14);
            }
        } else if (this.f10727f) {
            float f11 = eVar.f7180c;
            int i15 = f10719m;
            eVar.f7178a = (int) ((i15 * interpolation) + f11);
            eVar.f7179b = (int) ((i15 * interpolation) + eVar.f7181d);
            eVar2.f7178a = (int) ((i15 * 2 * interpolation) + eVar2.f7180c);
            eVar2.f7179b = (int) ((i15 * interpolation) + eVar2.f7181d);
        } else {
            int i16 = eVar.f7178a;
            eVar.f7178a = (int) (((eVar.f7180c - i16) * interpolation) + i16);
            int i17 = eVar.f7179b;
            eVar.f7179b = (int) (((eVar.f7181d - i17) * interpolation) + i17);
            int i18 = eVar2.f7178a;
            eVar2.f7178a = (int) (((eVar2.f7180c - i18) * interpolation) + i18);
            int i19 = eVar2.f7179b;
            eVar2.f7179b = (int) (((eVar2.f7181d - i19) * interpolation) + i19);
        }
        this.f10722a.invalidate();
    }
}
