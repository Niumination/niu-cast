package rd;

import android.view.ViewGroup;
import com.transsion.widgetslib.view.damping.DampingLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements d8.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DampingLayout f9395b;

    public /* synthetic */ a(DampingLayout dampingLayout, int i8) {
        this.f9394a = i8;
        this.f9395b = dampingLayout;
    }

    @Override // d8.c
    public final void d(float f) {
        switch (this.f9394a) {
            case 0:
                DampingLayout dampingLayout = this.f9395b;
                if (dampingLayout.mViewScrollBar != null) {
                    ViewGroup.LayoutParams layoutParams = dampingLayout.mViewScrollBar.getLayoutParams();
                    dampingLayout.mRect.top = (int) Math.abs(f);
                    if (dampingLayout.mBarPullMinLen + dampingLayout.mRect.top >= layoutParams.height) {
                        dampingLayout.mRect.top = layoutParams.height - dampingLayout.mBarPullMinLen;
                    }
                    dampingLayout.mViewScrollBar.layout(dampingLayout.mRect.left, dampingLayout.mRect.top, dampingLayout.mRect.right, dampingLayout.mRect.bottom);
                    break;
                }
                break;
            default:
                DampingLayout dampingLayout2 = this.f9395b;
                if (dampingLayout2.mViewScrollBar != null) {
                    dampingLayout2.mRect.bottom = (int) (dampingLayout2.mViewScrollBar.getLayoutParams().height - f);
                    if (dampingLayout2.mRect.bottom <= dampingLayout2.mBarPullMinLen) {
                        dampingLayout2.mRect.bottom = dampingLayout2.mBarPullMinLen;
                    }
                    dampingLayout2.mViewScrollBar.layout(dampingLayout2.mRect.left, dampingLayout2.mRect.top, dampingLayout2.mRect.right, dampingLayout2.mRect.bottom);
                    break;
                }
                break;
        }
    }
}
