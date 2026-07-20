package rd;

import android.animation.ValueAnimator;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.transsion.widgetslib.R$anim;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f9404b;

    public /* synthetic */ f(g gVar, int i8) {
        this.f9403a = i8;
        this.f9404b = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i8 = 5;
        g gVar = this.f9404b;
        switch (this.f9403a) {
            case 0:
                TextView textView = gVar.f9408d;
                textView.setPivotX(textView.getWidth() / 2.0f);
                gVar.f9408d.setPivotY(0.0f);
                break;
            case 1:
                gVar.f9407c.setPullPercent(1.0f);
                gVar.f9407c.h();
                break;
            case 2:
                float f = gVar.f9405a;
                if (gVar.f9412j == null) {
                    ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 0.0f);
                    gVar.f9412j = valueAnimatorOfFloat;
                    valueAnimatorOfFloat.setDuration(300L);
                    gVar.f9412j.setInterpolator(AnimationUtils.loadInterpolator(gVar.f9413k, R$anim.os_damping_collapse));
                    gVar.f9412j.addUpdateListener(new ee.k(gVar, 5));
                    gVar.f9412j.addListener(new ke.d(gVar, i8));
                }
                gVar.f9412j.setFloatValues(f, gVar.f9414l);
                gVar.f9412j.start();
                break;
            default:
                gVar.getClass();
                break;
        }
    }
}
