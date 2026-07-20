package z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo;

import android.util.Log;
import android.view.VelocityTracker;
import android.view.View;
import b8.d;
import b8.f;
import uk.b;

/* JADX INFO: loaded from: classes3.dex */
public class z1OoOif extends z1OoOnew {
    @Override // b8.e
    public final boolean d(d dVar) {
        return false;
    }

    @Override // z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOnew
    public final float f(float f, float f4, boolean z2, boolean z3) {
        int i8 = this.f11239b.getView().getContext().getResources().getDisplayMetrics().widthPixels;
        if (i8 >= 1) {
            if (z2) {
                return e((Math.abs(f) - Math.abs(f4)) / i8);
            }
            return 0.8f;
        }
        Log.e("BounceEffect", "viewPortLength:" + i8);
        return 1.0f;
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
        return view.getTranslationX();
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0071  */
    /* JADX WARN: Code duplicated, block: B:24:0x008d  */
    @Override // z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOnew
    public final void i() {
        float f;
        View view = this.f11239b.getView();
        float translationX = view.getTranslationX();
        d8.d dVar = this.u;
        if (dVar != null) {
            dVar.b();
            Log.d("BounceEffect", "cancel animator");
        } else {
            this.u = new d8.d(view, d8.d.f4377m);
        }
        if (this.E) {
            if (Math.abs(translationX) < ((double) this.H) * 0.286d) {
                z1OoOnew.J = 390.0f;
                f = 1.3f;
            } else if (Math.abs(translationX) > ((double) this.H) * 0.571d) {
                z1OoOnew.J = 330.0f;
                f = 1.1f;
            } else {
                z1OoOnew.J = 360.0f;
                f = 1.2f;
            }
        } else if (this.D) {
            Math.abs(translationX);
            z1OoOnew.J = 180.0f;
            f = 0.6f;
        } else if (Math.abs(translationX) < ((double) this.H) * 0.286d) {
            z1OoOnew.J = 360.0f;
            f = 1.2f;
        } else if (Math.abs(translationX) > ((double) this.H) * 0.571d) {
            z1OoOnew.J = 300.0f;
            f = 1.0f;
        } else {
            z1OoOnew.J = 330.0f;
            f = 1.1f;
        }
        z1OoOnew.K = f;
        d8.d dVar2 = this.u;
        b bVar = new b(0.0f);
        bVar.c(z1OoOnew.J);
        bVar.b(z1OoOnew.K);
        dVar2.f4391k = bVar;
        Log.d("BounceEffect", "createAnimation stiffness=" + z1OoOnew.J + " damping=" + z1OoOnew.K + " CurrentOffset=" + translationX + " mScreenWidth=" + this.H);
    }

    @Override // z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOnew
    public final void j(View view, float f) {
        f fVar = this.A;
        if (fVar != null) {
            fVar.d(f);
        }
        view.setTranslationX(f);
    }

    @Override // z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOnew
    public final sk.b l() {
        return new sk.b(this, 0);
    }

    @Override // z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOnew
    public final boolean m(View view) {
        float translationX = view.getTranslationX();
        if (translationX <= Float.MAX_VALUE && translationX >= -3.4028235E38f) {
            return true;
        }
        Log.e("BounceEffect", "view tanslationX:" + translationX);
        view.setTranslationX(0.0f);
        return false;
    }
}
