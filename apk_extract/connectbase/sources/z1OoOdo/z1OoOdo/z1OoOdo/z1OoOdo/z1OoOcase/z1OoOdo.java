package z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOcase;

import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
import us.b;

/* JADX INFO: loaded from: classes3.dex */
public class z1OoOdo extends ViewPager2.OnPageChangeCallback implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewPager2 f21772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f21773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f21774c;

    public z1OoOdo(ViewPager2 viewPager2) {
        this.f21773b = 0;
        this.f21772a = viewPager2;
        viewPager2.registerOnPageChangeCallback(this);
        this.f21773b = viewPager2.getCurrentItem();
        this.f21774c = 0.0f;
    }

    @Override // us.b
    public View a() {
        return this.f21772a;
    }

    @Override // us.b
    public boolean b() {
        return this.f21773b == this.f21772a.getAdapter().getItemCount() - 1 && this.f21774c == 0.0f;
    }

    @Override // us.b
    public boolean c() {
        return this.f21773b == 0 && this.f21774c == 0.0f;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrollStateChanged(int i10) {
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrolled(int i10, float f10, int i11) {
        this.f21773b = i10;
        this.f21774c = f10;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageSelected(int i10) {
    }
}
