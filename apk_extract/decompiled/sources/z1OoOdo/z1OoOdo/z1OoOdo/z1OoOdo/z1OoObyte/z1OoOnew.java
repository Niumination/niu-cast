package z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoObyte;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import tk.a;

/* JADX INFO: loaded from: classes3.dex */
public class z1OoOnew implements a, ViewPager.OnPageChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f11233b;

    @Override // tk.a
    public final boolean a() {
        throw null;
    }

    @Override // tk.a
    public final boolean b() {
        return this.f11232a == 0 && this.f11233b == 0.0f;
    }

    @Override // tk.a
    public final View getView() {
        return null;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrollStateChanged(int i8) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrolled(int i8, float f, int i9) {
        this.f11232a = i8;
        this.f11233b = f;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageSelected(int i8) {
    }
}
