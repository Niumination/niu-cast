package td;

import androidx.viewpager.widget.ViewPager;
import com.transsion.widgetslib.view.indicator.OSWatchPageIndicator;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends ViewPager.SimpleOnPageChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OSWatchPageIndicator f10212a;

    public b(OSWatchPageIndicator oSWatchPageIndicator) {
        this.f10212a = oSWatchPageIndicator;
    }

    @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrollStateChanged(int i8) {
        super.onPageScrollStateChanged(i8);
        OSWatchPageIndicator oSWatchPageIndicator = this.f10212a;
        oSWatchPageIndicator.f3270s = i8;
        oSWatchPageIndicator.a(i8);
    }

    @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrolled(int i8, float f, int i9) {
        super.onPageScrolled(i8, f, i9);
        this.f10212a.c(f, i8, i9);
    }
}
