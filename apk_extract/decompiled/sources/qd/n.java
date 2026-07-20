package qd;

import androidx.viewpager.widget.ViewPager;
import com.transsion.widgetslib.view.ViewPagerTabs;

/* JADX INFO: loaded from: classes2.dex */
public final class n implements ViewPager.OnPageChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewPagerTabs f8991a;

    public n(ViewPagerTabs viewPagerTabs) {
        this.f8991a = viewPagerTabs;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrollStateChanged(int i8) {
        int i9 = ViewPagerTabs.u;
        ViewPagerTabs viewPagerTabs = this.f8991a;
        ViewPager.OnPageChangeListener onPageChangeListener = viewPagerTabs.q;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(i8);
        }
        if (i8 == 0) {
            viewPagerTabs.c();
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrolled(int i8, float f, int i9) {
        ViewPager.OnPageChangeListener onPageChangeListener = this.f8991a.q;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrolled(i8, f, i9);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageSelected(int i8) {
        int i9 = ViewPagerTabs.u;
        ViewPagerTabs viewPagerTabs = this.f8991a;
        viewPagerTabs.getClass();
        ViewPager.OnPageChangeListener onPageChangeListener = viewPagerTabs.q;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageSelected(i8);
        }
        m mVar = viewPagerTabs.f3199a;
        if (mVar != null) {
            mVar.f8987a = viewPagerTabs.b(i8);
            mVar.f8990d.c();
        }
    }
}
