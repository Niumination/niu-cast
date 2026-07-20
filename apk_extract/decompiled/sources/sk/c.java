package sk;

import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import b8.f;
import java.util.ArrayList;
import z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOnew;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements d, d8.b, d8.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f10149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ z1OoOnew f10150b;

    public c(z1OoOnew z1ooonew) {
        this.f10150b = z1ooonew;
        this.f10149a = z1ooonew.l();
    }

    @Override // sk.d
    public final boolean a(MotionEvent motionEvent) {
        Log.d("BounceEffect", "touch down bounceback");
        z1OoOnew z1ooonew = this.f10150b;
        if (z1ooonew.f11238a.f10151a != motionEvent.getPointerId(0)) {
            return true;
        }
        int[] iArr = new int[2];
        z1ooonew.f11239b.getView().getLocationOnScreen(iArr);
        int x2 = (int) (motionEvent.getX(0) + iArr[0] + 0.5f);
        z1ooonew.f11250r = x2;
        z1ooonew.p = x2;
        int y3 = (int) (motionEvent.getY(0) + iArr[1] + 0.5f);
        z1ooonew.f11251s = y3;
        z1ooonew.q = y3;
        VelocityTracker velocityTracker = z1ooonew.f11253v;
        if (velocityTracker == null) {
            z1ooonew.f11253v = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
        z1ooonew.f11253v.addMovement(motionEvent);
        if (!z1ooonew.f11243i) {
            return true;
        }
        Log.d("BounceEffect", "touch down bounceback not handle");
        return false;
    }

    @Override // sk.d
    public final int b() {
        return 3;
    }

    @Override // sk.d
    public final boolean c(MotionEvent motionEvent) {
        z1OoOnew z1ooonew = this.f10150b;
        e eVar = z1ooonew.f11238a;
        if (eVar.f10151a != motionEvent.getPointerId(0)) {
            return true;
        }
        View view = z1ooonew.f11239b.getView();
        b bVar = this.f10149a;
        bVar.a(view, motionEvent, z1ooonew.e);
        if (z1ooonew.f11253v == null) {
            z1ooonew.f11253v = VelocityTracker.obtain();
        }
        z1ooonew.f11253v.addMovement(motionEvent);
        if (!bVar.f10146c) {
            return false;
        }
        float f = bVar.f10144a + bVar.f10145b;
        d8.d dVar = z1ooonew.u;
        if (dVar != null && dVar.e) {
            z1ooonew.f11256y = true;
            dVar.b();
        }
        if (eVar.f10152b == bVar.f10147d) {
            z1ooonew.k(z1ooonew.f11241d);
            Log.d("BounceEffect", "touch move bounceback handled");
            return true;
        }
        Log.d("BounceEffect", "out bounceback:" + f + "orig:0.0");
        boolean z2 = eVar.f10152b;
        if ((z2 && !bVar.f10147d && f <= 0.0f) || (!z2 && bVar.f10147d && f >= 0.0f)) {
            z1ooonew.k(z1ooonew.f11240c);
            f = 0.0f;
        }
        z1ooonew.j(view, f);
        return true;
    }

    @Override // d8.c
    public final void d(float f) {
        z1OoOnew z1ooonew = this.f10150b;
        f fVar = z1ooonew.A;
        if (fVar != null) {
            fVar.d(z1ooonew.h(z1ooonew.f11239b.getView()));
        }
    }

    @Override // sk.d
    public final void e(d dVar) {
        if (dVar == this) {
            return;
        }
        z1OoOnew z1ooonew = this.f10150b;
        z1ooonew.i();
        ArrayList arrayList = z1ooonew.u.f4388h;
        if (!arrayList.contains(this)) {
            arrayList.add(this);
        }
        z1ooonew.u.a(this);
        View view = z1ooonew.f11239b.getView();
        z1ooonew.f11249o = view.getOverScrollMode();
        view.setOverScrollMode(2);
        if (z1ooonew.m(view)) {
            z1ooonew.u.f4383a = z1ooonew.g(z1ooonew.f11253v);
            Log.d("BounceEffect", "velocity:" + z1ooonew.g(z1ooonew.f11253v));
            z1ooonew.u.f();
        }
    }

    @Override // sk.d
    public final boolean f(MotionEvent motionEvent) {
        z1OoOnew z1ooonew = this.f10150b;
        e eVar = z1ooonew.f11238a;
        if (eVar.f10151a != motionEvent.getPointerId(0)) {
            return true;
        }
        d8.d dVar = z1ooonew.u;
        tk.a aVar = z1ooonew.f11239b;
        if (dVar != null) {
            Log.d("BounceEffect", "touch up bounceback start anim");
            if (z1ooonew.m(aVar.getView())) {
                z1ooonew.u.f4383a = z1ooonew.g(z1ooonew.f11253v);
                z1ooonew.u.f();
            }
        }
        VelocityTracker velocityTracker = z1ooonew.f11253v;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            z1ooonew.f11253v = null;
        }
        View view = aVar.getView();
        b bVar = this.f10149a;
        bVar.a(view, motionEvent, z1ooonew.f11241d);
        Log.d("BounceEffect", "touch up bounceback");
        if (eVar.f10152b != bVar.f10147d) {
            view.setOverScrollMode(z1ooonew.f11249o);
            Log.d("BounceEffect", "touch up bounceback not handle");
            return false;
        }
        if (aVar.getView() instanceof RecyclerView) {
            ((RecyclerView) aVar.getView()).stopScroll();
        }
        return true;
    }

    @Override // d8.b
    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public final void mo1636b() {
        Log.d("BounceEffect", "onAnimationEnd");
        z1OoOnew z1ooonew = this.f10150b;
        z1ooonew.f11239b.getView().setOverScrollMode(z1ooonew.f11249o);
        if (z1ooonew.f11242h == z1ooonew.e) {
            if (z1ooonew.f11256y) {
                z1ooonew.f11256y = false;
            } else {
                z1ooonew.k(z1ooonew.f11240c);
            }
        }
    }
}
