package ge;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.transsion.widgetslib.widget.tablayout.TabLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements ViewPager.OnAdapterChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f5167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TabLayout f5168b;

    public d(TabLayout tabLayout) {
        this.f5168b = tabLayout;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
    public final void onAdapterChanged(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
        TabLayout tabLayout = this.f5168b;
        if (tabLayout.H == viewPager) {
            tabLayout.o(pagerAdapter2, this.f5167a);
        }
    }
}
