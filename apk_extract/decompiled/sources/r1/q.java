package r1;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f9288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PointF f9289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f9290c;

    public q(PointF pointF, boolean z2, List list) {
        this.f9289b = pointF;
        this.f9290c = z2;
        this.f9288a = new ArrayList(list);
    }

    public final void a(float f, float f4) {
        if (this.f9289b == null) {
            this.f9289b = new PointF();
        }
        this.f9289b.set(f, f4);
    }

    public final String toString() {
        return "ShapeData{numCurves=" + this.f9288a.size() + "closed=" + this.f9290c + '}';
    }

    public q() {
        this.f9288a = new ArrayList();
    }
}
