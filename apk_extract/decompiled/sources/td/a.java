package td;

import androidx.viewpager2.widget.ViewPager2;
import com.transsion.widgetslib.view.indicator.OSWatchPageIndicator;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends ViewPager2.OnPageChangeCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OSWatchPageIndicator f10211a;

    public a(OSWatchPageIndicator oSWatchPageIndicator) {
        this.f10211a = oSWatchPageIndicator;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public final void onPageScrollStateChanged(int i8) {
        super.onPageScrollStateChanged(i8);
        this.f10211a.a(i8);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public final void onPageScrolled(int i8, float f, int i9) {
        super.onPageScrolled(i8, f, i9);
        this.f10211a.c(f, i8, i9);
    }
}
