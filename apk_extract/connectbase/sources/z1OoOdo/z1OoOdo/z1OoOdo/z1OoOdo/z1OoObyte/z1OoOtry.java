package z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoObyte;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import us.b;

/* JADX INFO: loaded from: classes3.dex */
public class z1OoOtry implements b, ViewPager.OnPageChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewPager f21769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f21770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f21771c;

    public z1OoOtry(ViewPager viewPager) {
        this.f21770b = 0;
        this.f21769a = viewPager;
        viewPager.addOnPageChangeListener(this);
        this.f21770b = viewPager.getCurrentItem();
        this.f21771c = 0.0f;
    }

    @Override // us.b
    public View a() {
        return this.f21769a;
    }

    @Override // us.b
    public boolean b() {
        return this.f21770b == this.f21769a.getAdapter().getCount() - 1 && this.f21771c == 0.0f;
    }

    @Override // us.b
    public boolean c() {
        return this.f21770b == 0 && this.f21771c == 0.0f;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i10) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i10, float f10, int i11) {
        this.f21770b = i10;
        this.f21771c = f10;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i10) {
    }
}
