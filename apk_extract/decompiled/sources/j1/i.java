package j1;

import com.airbnb.lottie.LottieAnimationView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class i implements a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference f5963b;

    public i(LottieAnimationView lottieAnimationView, int i8) {
        this.f5962a = i8;
        switch (i8) {
            case 1:
                this.f5963b = new WeakReference(lottieAnimationView);
                break;
            default:
                this.f5963b = new WeakReference(lottieAnimationView);
                break;
        }
    }

    @Override // j1.a0
    public final void onResult(Object obj) {
        switch (this.f5962a) {
            case 0:
                Throwable th2 = (Throwable) obj;
                LottieAnimationView lottieAnimationView = (LottieAnimationView) this.f5963b.get();
                if (lottieAnimationView != null) {
                    int i8 = lottieAnimationView.f1743d;
                    if (i8 != 0) {
                        lottieAnimationView.setImageResource(i8);
                    }
                    a0 a0Var = lottieAnimationView.f1742c;
                    if (a0Var == null) {
                        a0Var = LottieAnimationView.p;
                    }
                    a0Var.onResult(th2);
                    break;
                }
                break;
            default:
                j jVar = (j) obj;
                LottieAnimationView lottieAnimationView2 = (LottieAnimationView) this.f5963b.get();
                if (lottieAnimationView2 != null) {
                    lottieAnimationView2.setComposition(jVar);
                    break;
                }
                break;
        }
    }
}
