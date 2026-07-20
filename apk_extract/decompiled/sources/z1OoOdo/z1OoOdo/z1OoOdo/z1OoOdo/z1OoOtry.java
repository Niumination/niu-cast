package z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo;

import android.util.Log;
import android.view.VelocityTracker;
import android.view.View;
import b8.d;
import b8.f;
import sk.a;
import vk.b;

/* JADX INFO: loaded from: classes3.dex */
public class z1OoOtry extends z1OoOnew {
    @Override // b8.e
    public final boolean d(d dVar) {
        a aVar = this.f11257z;
        if (aVar != null) {
            return aVar.d(dVar);
        }
        return false;
    }

    @Override // z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOnew
    public final float f(float f, float f4, boolean z2, boolean z3) {
        int i8 = this.f11239b.getView().getContext().getResources().getDisplayMetrics().heightPixels;
        float f10 = 1.0f;
        if (i8 < 1) {
            Log.e("BounceEffect", "viewPortLength:" + i8);
            return 1.0f;
        }
        float fE = !z2 ? 0.8f : e((Math.abs(f) - Math.abs(f4)) / i8);
        if (this.f11248n && this.f11244j) {
            fE /= 2.5f;
        }
        if (b.f10615b && !this.D) {
            f10 = z3 ? 1.1f : 1.56f;
        }
        return fE * f10;
    }

    @Override // z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOnew
    public final float g(VelocityTracker velocityTracker) {
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, 5000.0f);
        float yVelocity = velocityTracker.getYVelocity();
        if (Math.abs(yVelocity) <= 500.0f) {
            return 0.0f;
        }
        float f = yVelocity - 500.0f;
        return yVelocity > 500.0f ? (f * 3000.0f) / 4500.0f : ((-f) * 3000.0f) / 4500.0f;
    }

    @Override // z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOnew
    public final float h(View view) {
        return view.getTranslationY();
    }

    /* JADX WARN: Code duplicated, block: B:23:0x006c  */
    /* JADX WARN: Code duplicated, block: B:26:0x0082  */
    /* JADX WARN: Code duplicated, block: B:30:0x009f  */
    @Override // z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOnew
    public final void i() {
        float f;
        View view = this.f11239b.getView();
        float translationY = view.getTranslationY();
        d8.d dVar = this.u;
        if (dVar != null) {
            dVar.b();
            Log.d("BounceEffect", "cancel animator");
        } else {
            this.u = new d8.d(view, d8.d.f4378n);
        }
        if (this.E) {
            if (b.f10615b) {
                z1OoOnew.J = 311.0f;
                f = 1.11f;
            } else if (Math.abs(translationY) < ((double) this.I) * 0.286d) {
                z1OoOnew.J = 360.0f;
                f = 1.2f;
            } else if (Math.abs(translationY) > ((double) this.I) * 0.571d) {
                z1OoOnew.J = 300.0f;
                f = 1.0f;
            } else {
                z1OoOnew.J = 330.0f;
                f = 1.1f;
            }
        } else if (this.D) {
            Math.abs(translationY);
            z1OoOnew.J = 150.0f;
            f = 0.5f;
        } else if (b.f10615b) {
            z1OoOnew.J = 311.0f;
            f = 1.11f;
        } else if (Math.abs(translationY) < ((double) this.I) * 0.286d) {
            z1OoOnew.J = 330.0f;
            f = 1.1f;
        } else if (Math.abs(translationY) > ((double) this.I) * 0.571d) {
            z1OoOnew.J = 270.0f;
            f = 0.9f;
        } else {
            z1OoOnew.J = 300.0f;
            f = 1.0f;
        }
        z1OoOnew.K = f;
        d8.d dVar2 = this.u;
        uk.b bVar = new uk.b(0.0f);
        bVar.c(z1OoOnew.J);
        bVar.b(z1OoOnew.K);
        dVar2.f4391k = bVar;
        Log.d("BounceEffect", "createAnimation stiffness=" + z1OoOnew.J + " damping=" + z1OoOnew.K + " CurrentOffset=" + translationY + " mScreenHeight=" + this.I);
    }

    @Override // z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOnew
    public final void j(View view, float f) {
        f fVar = this.A;
        if (fVar != null) {
            fVar.d(f);
        }
        view.setTranslationY(f);
    }

    @Override // z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOnew
    public final sk.b l() {
        return new sk.b(this, 1);
    }

    @Override // z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOnew
    public final boolean m(View view) {
        float translationY = view.getTranslationY();
        if (translationY <= Float.MAX_VALUE && translationY >= -3.4028235E38f) {
            return true;
        }
        Log.e("BounceEffect", "view tanslationY:" + translationY);
        view.setTranslationY(0.0f);
        return false;
    }

    @Override // z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOnew
    public final boolean n() {
        return true;
    }
}
