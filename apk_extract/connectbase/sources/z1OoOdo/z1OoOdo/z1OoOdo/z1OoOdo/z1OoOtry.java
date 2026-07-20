package z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo;

import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import g6.c;
import us.b;

/* JADX INFO: loaded from: classes3.dex */
public class z1OoOtry extends z1OoOnew {

    public class a extends z1OoOnew.c {
        public a() {
        }

        @Override // z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOnew.c
        public boolean a(View view, MotionEvent motionEvent, z1OoOnew.b bVar) {
            int rawX = (int) (motionEvent.getRawX(0) + 0.5f);
            int rawY = (int) (motionEvent.getRawY(0) + 0.5f);
            z1OoOtry z1oootry = z1OoOtry.this;
            if (z1oootry.f21793y == Integer.MAX_VALUE || z1oootry.f21794z == Integer.MAX_VALUE) {
                z1oootry.H = rawX;
                z1oootry.f21793y = rawX;
                z1oootry.I = rawY;
                z1oootry.f21794z = rawY;
                this.f21799c = false;
                Log.e("BounceEffect", "touch move but not down yet");
                return false;
            }
            int i10 = rawX - z1oootry.H;
            int i11 = rawY - z1oootry.I;
            z1oootry.H = rawX;
            z1oootry.I = rawY;
            if (z1oootry.f21782c != bVar && z1oootry.f21784e != bVar) {
                this.f21799c = false;
            } else {
                if (Math.abs(i10) > Math.abs(i11)) {
                    this.f21797a = view.getTranslationY();
                    float f10 = i11;
                    this.f21798b = f10;
                    this.f21800d = f10 > 0.0f;
                    return true;
                }
                if (!this.f21799c) {
                    int iAbs = Math.abs(i11);
                    int i12 = z1OoOtry.this.J;
                    if (iAbs > i12 && i11 != 0) {
                        i11 = i12 * (i11 < 0 ? -1 : 1);
                        this.f21799c = true;
                    }
                }
            }
            this.f21797a = view.getTranslationY();
            float f11 = i11;
            this.f21798b = f11;
            this.f21800d = f11 > 0.0f;
            return false;
        }
    }

    public z1OoOtry(b bVar) {
        super(bVar);
    }

    @Override // z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOnew
    public float i(float f10, float f11, boolean z10) {
        int i10 = this.f21781b.a().getContext().getResources().getDisplayMetrics().heightPixels;
        if (i10 >= 1) {
            float fPow = !z10 ? 0.8f : (float) (Math.pow(1.0f - ((Math.abs(f10) - Math.abs(f11)) / i10), 4.0d) * 0.800000011920929d);
            return (this.f21791w && this.f21787i) ? fPow / 2.5f : fPow;
        }
        Log.e("BounceEffect", "viewPortLength:" + i10);
        return 1.0f;
    }

    @Override // z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOnew
    public float j(VelocityTracker velocityTracker) {
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, 2000.0f);
        float yVelocity = velocityTracker.getYVelocity();
        if (Math.abs(yVelocity) < 500.0f) {
            return 0.0f;
        }
        return yVelocity;
    }

    @Override // z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOnew
    public float k(View view) {
        return view.getTranslationY();
    }

    @Override // z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOnew
    public void l() {
        View viewA = this.f21781b.a();
        SpringAnimation springAnimation = this.K;
        if (springAnimation != null) {
            springAnimation.cancel();
            Log.d("BounceEffect", "cancel animator");
        } else {
            SpringAnimation springAnimation2 = new SpringAnimation(viewA, DynamicAnimation.TRANSLATION_Y);
            this.K = springAnimation2;
            springAnimation2.setSpring(new SpringForce(0.0f).setStiffness(400.0f).setDampingRatio(1.2f));
        }
    }

    @Override // z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOnew
    public void m(View view, float f10) {
        c cVar = this.O;
        if (cVar != null) {
            cVar.a(f10);
        }
        view.setTranslationY(f10);
    }

    @Override // z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOnew
    public z1OoOnew.c r() {
        return new a();
    }

    @Override // z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOnew
    public boolean t(View view) {
        float translationY = view.getTranslationY();
        if (translationY <= Float.MAX_VALUE && translationY >= -3.4028235E38f) {
            return true;
        }
        Log.e("BounceEffect", "view tanslationY:" + translationY);
        view.setTranslationY(0.0f);
        return false;
    }
}
