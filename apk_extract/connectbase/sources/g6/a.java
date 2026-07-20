package g6;

import android.graphics.Canvas;
import android.util.Log;
import android.view.View;
import android.widget.EdgeEffect;
import androidx.annotation.NonNull;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;

/* JADX INFO: loaded from: classes2.dex */
@b.b(14)
public class a extends EdgeEffect {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f6413e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f6414f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f6415g = 2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f6416h = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f6417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SpringAnimation f6418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f6419c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f6420d;

    /* JADX WARN: Code duplicated, block: B:18:0x0033  */
    /* JADX WARN: Code duplicated, block: B:20:0x003d  */
    public a(@NonNull View view, int i10) {
        SpringAnimation springAnimation;
        super(view.getContext());
        this.f6419c = true;
        this.f6420d = 0.0f;
        this.f6417a = view;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 == 2) {
                    this.f6420d = -1.0f;
                } else if (i10 == 3) {
                    this.f6420d = -1.0f;
                }
                if (this.f6419c) {
                    springAnimation = new SpringAnimation(view, DynamicAnimation.TRANSLATION_Y);
                } else {
                    springAnimation = new SpringAnimation(view, DynamicAnimation.TRANSLATION_X);
                }
                this.f6418b = springAnimation;
                this.f6418b.setSpring(new SpringForce(0.0f).setStiffness(200.0f).setDampingRatio(1.0f));
            }
            this.f6420d = 1.0f;
            this.f6419c = true;
            if (this.f6419c) {
                springAnimation = new SpringAnimation(view, DynamicAnimation.TRANSLATION_Y);
            } else {
                springAnimation = new SpringAnimation(view, DynamicAnimation.TRANSLATION_X);
            }
            this.f6418b = springAnimation;
            this.f6418b.setSpring(new SpringForce(0.0f).setStiffness(200.0f).setDampingRatio(1.0f));
        }
        this.f6420d = 1.0f;
        this.f6419c = false;
        if (this.f6419c) {
            springAnimation = new SpringAnimation(view, DynamicAnimation.TRANSLATION_Y);
        } else {
            springAnimation = new SpringAnimation(view, DynamicAnimation.TRANSLATION_X);
        }
        this.f6418b = springAnimation;
        this.f6418b.setSpring(new SpringForce(0.0f).setStiffness(200.0f).setDampingRatio(1.0f));
    }

    public void a() {
        this.f6418b.cancel();
    }

    @Override // android.widget.EdgeEffect
    public boolean draw(Canvas canvas) {
        return false;
    }

    @Override // android.widget.EdgeEffect
    public void onAbsorb(int i10) {
        Log.d("BounceEdgeEffect", "on absorb:" + i10);
        View view = this.f6417a;
        if (view == null) {
            return;
        }
        float translationY = this.f6419c ? view.getTranslationY() : view.getTranslationX();
        Log.d("BounceEdgeEffect", "view tanslation:" + translationY);
        if (translationY > Float.MAX_VALUE || translationY < -3.4028235E38f) {
            return;
        }
        this.f6418b.setStartVelocity(i10 * this.f6420d);
        this.f6418b.start();
    }

    @Override // android.widget.EdgeEffect
    public void onPull(float f10) {
        Log.d("BounceEdgeEffect", "onPull");
    }

    @Override // android.widget.EdgeEffect
    public void onRelease() {
        Log.d("BounceEdgeEffect", "onRelease");
    }

    @Override // android.widget.EdgeEffect
    public void onPull(float f10, float f11) {
        Log.d("BounceEdgeEffect", "onPull2：" + f10);
    }
}
