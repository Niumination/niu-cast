package md;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import com.transsion.widgetslib.view.OSCheckBox;
import com.transsion.widgetslib.view.OSRadioButton;
import k3.z8;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ValueAnimator.AnimatorUpdateListener f7976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Drawable f7977c;

    public /* synthetic */ b(Drawable drawable, ValueAnimator.AnimatorUpdateListener animatorUpdateListener, int i8) {
        this.f7975a = i8;
        this.f7977c = drawable;
        this.f7976b = animatorUpdateListener;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.f7976b;
        Drawable drawable = this.f7977c;
        switch (this.f7975a) {
            case 0:
                super.onAnimationEnd(animator);
                c cVar = (c) drawable;
                cVar.f7978a.removeUpdateListener((a) animatorUpdateListener);
                cVar.f7978a.removeListener(this);
                int i8 = OSCheckBox.f3137i;
                StringBuilder sb2 = new StringBuilder("onAnimationEnd, mTickLength: ");
                sb2.append(cVar.q);
                sb2.append(", mPosEnd x: ");
                float[] fArr = cVar.B;
                sb2.append(fArr[0]);
                sb2.append(", y: ");
                sb2.append(fArr[1]);
                sb2.append(", mTan x: ");
                float[] fArr2 = cVar.C;
                sb2.append(fArr2[0]);
                sb2.append(", y: ");
                sb2.append(fArr2[1]);
                sb2.append(", mExecFraction: ");
                sb2.append(cVar.D);
                sb2.append(", object: ");
                sb2.append(cVar);
                z8.f("OSCheckBox", sb2.toString());
                StringBuilder sb3 = new StringBuilder("onAnimationEnd, mStartLength: ");
                sb3.append(cVar.f7997z);
                sb3.append(", mPosStart x: ");
                float[] fArr3 = cVar.f7994w;
                sb3.append(fArr3[0]);
                sb3.append(", y: ");
                sb3.append(fArr3[1]);
                sb3.append(", mTan x: ");
                float[] fArr4 = cVar.f7995x;
                sb3.append(fArr4[0]);
                sb3.append(", y: ");
                sb3.append(fArr4[1]);
                sb3.append(", mTickLength: ");
                sb3.append(cVar.q);
                sb3.append(", mStartLength: ");
                sb3.append(cVar.f7997z);
                z8.b("OSCheckBox", sb3.toString());
                break;
            default:
                super.onAnimationEnd(animator);
                e eVar = (e) drawable;
                eVar.f8015r.removeUpdateListener((d) animatorUpdateListener);
                eVar.f8015r.removeListener(this);
                int i9 = OSRadioButton.f3185a;
                z8.b("OSRadioButton", "onAnimationEnd, mStrokeColor: " + eVar.f8008i + ", mOuterRadius: " + eVar.f8010k + ", mInnerRadius: " + eVar.f8012m + ", mExecFraction: " + eVar.p + ", object: " + eVar);
                break;
        }
    }
}
