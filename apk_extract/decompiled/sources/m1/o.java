package m1;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public final class o extends e {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final PointF f7605i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final PointF f7606j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final i f7607k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final i f7608l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public x1.c f7609m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public x1.c f7610n;

    public o(i iVar, i iVar2) {
        super(Collections.emptyList());
        this.f7605i = new PointF();
        this.f7606j = new PointF();
        this.f7607k = iVar;
        this.f7608l = iVar2;
        j(this.f7577d);
    }

    @Override // m1.e
    public final Object f() {
        return l();
    }

    @Override // m1.e
    public final /* bridge */ /* synthetic */ Object g(x1.a aVar, float f) {
        return l();
    }

    @Override // m1.e
    public final void j(float f) {
        i iVar = this.f7607k;
        iVar.j(f);
        i iVar2 = this.f7608l;
        iVar2.j(f);
        this.f7605i.set(((Float) iVar.f()).floatValue(), ((Float) iVar2.f()).floatValue());
        int i8 = 0;
        while (true) {
            ArrayList arrayList = this.f7574a;
            if (i8 >= arrayList.size()) {
                return;
            }
            ((a) arrayList.get(i8)).a();
            i8++;
        }
    }

    public final PointF l() {
        Float f;
        i iVar;
        x1.a aVarB;
        i iVar2;
        x1.a aVarB2;
        Float f4 = null;
        if (this.f7609m == null || (aVarB2 = (iVar2 = this.f7607k).b()) == null) {
            f = null;
        } else {
            Float f10 = aVarB2.f10811h;
            x1.c cVar = this.f7609m;
            float f11 = aVarB2.f10810g;
            f = (Float) cVar.b(f11, f10 == null ? f11 : f10.floatValue(), (Float) aVarB2.f10807b, (Float) aVarB2.f10808c, iVar2.d(), iVar2.e(), iVar2.f7577d);
        }
        if (this.f7610n != null && (aVarB = (iVar = this.f7608l).b()) != null) {
            Float f12 = aVarB.f10811h;
            x1.c cVar2 = this.f7610n;
            float f13 = aVarB.f10810g;
            f4 = (Float) cVar2.b(f13, f12 == null ? f13 : f12.floatValue(), (Float) aVarB.f10807b, (Float) aVarB.f10808c, iVar.d(), iVar.e(), iVar.f7577d);
        }
        PointF pointF = this.f7605i;
        PointF pointF2 = this.f7606j;
        if (f == null) {
            pointF2.set(pointF.x, 0.0f);
        } else {
            pointF2.set(f.floatValue(), 0.0f);
        }
        if (f4 == null) {
            pointF2.set(pointF2.x, pointF.y);
        } else {
            pointF2.set(pointF2.x, f4.floatValue());
        }
        return pointF2;
    }
}
