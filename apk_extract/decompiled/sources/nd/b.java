package nd;

import androidx.viewpager2.widget.ViewPager2;
import com.transsion.widgetslib.flipper.FlipperLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8171a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FlipperLayout f8172b;

    public /* synthetic */ b(FlipperLayout flipperLayout, int i8) {
        this.f8171a = i8;
        this.f8172b = flipperLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FlipperLayout this$0 = this.f8172b;
        switch (this.f8171a) {
            case 0:
                int i8 = FlipperLayout.E;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                if (this$0.animator != null) {
                    this$0.f();
                } else {
                    this$0.post(new a0.e(28, this$0, new e(this$0)));
                }
                break;
            case 1:
                int i9 = FlipperLayout.E;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                ViewPager2 viewPager2 = this$0.f3052a;
                if (viewPager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                    viewPager2 = null;
                }
                this$0.f3068w = viewPager2.getMeasuredHeight() / 2.0f;
                break;
            default:
                Intrinsics.checkNotNullParameter(this$0, "$it");
                this$0.requestLayout();
                break;
        }
    }
}
