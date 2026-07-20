package nd;

import androidx.viewpager2.widget.ViewPager2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class l {
    public static final void a(ViewPager2 viewPager2, int i8, boolean z2) {
        Intrinsics.checkNotNullParameter(viewPager2, "<this>");
        if (viewPager2.isFakeDragging()) {
            return;
        }
        viewPager2.setCurrentItem(i8, z2);
    }
}
