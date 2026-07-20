package rd;

import com.transsion.widgetslib.view.damping.DampingLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DampingLayout f9397b;

    public /* synthetic */ b(DampingLayout dampingLayout, int i8) {
        this.f9396a = i8;
        this.f9397b = dampingLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f9396a) {
            case 0:
                DampingLayout dampingLayout = this.f9397b;
                dampingLayout.mRect.set(dampingLayout.mViewScrollBar.getLeft(), dampingLayout.mViewScrollBar.getTop(), dampingLayout.mViewScrollBar.getRight(), dampingLayout.mViewScrollBar.getBottom());
                break;
            case 1:
                DampingLayout dampingLayout2 = this.f9397b;
                dampingLayout2.cancelAnim(dampingLayout2.mAnimScrollBarFade);
                dampingLayout2.mAnimScrollBarFade.setStartDelay(dampingLayout2.getScrollBarDefaultDelayBeforeFade());
                dampingLayout2.mAnimScrollBarFade.start();
                break;
            case 2:
                this.f9397b.initUpOverScroll();
                break;
            case 3:
                this.f9397b.refreshFinishAnim();
                break;
            default:
                DampingLayout dampingLayout3 = this.f9397b;
                if (dampingLayout3.computeVerticalScrollRange() > dampingLayout3.getHeight()) {
                    dampingLayout3.cancelAnim(dampingLayout3.mAnimScrollBarFade);
                    if (dampingLayout3.mViewScrollBar != null && dampingLayout3.mViewScrollBar.getAlpha() != 1.0f) {
                        dampingLayout3.mViewScrollBar.setAlpha(1.0f);
                    }
                    dampingLayout3.sendScrollBarFadeMsg();
                }
                break;
        }
    }
}
