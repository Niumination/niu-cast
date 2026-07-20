package q0;

import android.graphics.PointF;
import androidx.annotation.Nullable;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public class m extends a<PointF, PointF> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final PointF f13378i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final PointF f13379j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final a<Float, Float> f13380k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final a<Float, Float> f13381l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    public a1.j<Float> f13382m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public a1.j<Float> f13383n;

    public m(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.f13378i = new PointF();
        this.f13379j = new PointF();
        this.f13380k = aVar;
        this.f13381l = aVar2;
        m(f());
    }

    @Override // q0.a
    public void m(float f10) {
        this.f13380k.m(f10);
        this.f13381l.m(f10);
        this.f13378i.set(this.f13380k.h().floatValue(), this.f13381l.h().floatValue());
        for (int i10 = 0; i10 < this.f13350a.size(); i10++) {
            this.f13350a.get(i10).a();
        }
    }

    @Override // q0.a
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public PointF h() {
        return i(null, 0.0f);
    }

    @Override // q0.a
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public PointF i(a1.a<PointF> aVar, float f10) {
        Float fB;
        a1.a<Float> aVarB;
        a1.a<Float> aVarB2;
        Float fB2 = null;
        if (this.f13382m == null || (aVarB2 = this.f13380k.b()) == null) {
            fB = null;
        } else {
            float fD = this.f13380k.d();
            Float f11 = aVarB2.f12h;
            a1.j<Float> jVar = this.f13382m;
            float f12 = aVarB2.f11g;
            fB = jVar.b(f12, f11 == null ? f12 : f11.floatValue(), aVarB2.f6b, aVarB2.f7c, f10, f10, fD);
        }
        if (this.f13383n != null && (aVarB = this.f13381l.b()) != null) {
            float fD2 = this.f13381l.d();
            Float f13 = aVarB.f12h;
            a1.j<Float> jVar2 = this.f13383n;
            float f14 = aVarB.f11g;
            fB2 = jVar2.b(f14, f13 == null ? f14 : f13.floatValue(), aVarB.f6b, aVarB.f7c, f10, f10, fD2);
        }
        if (fB == null) {
            this.f13379j.set(this.f13378i.x, 0.0f);
        } else {
            this.f13379j.set(fB.floatValue(), 0.0f);
        }
        if (fB2 == null) {
            PointF pointF = this.f13379j;
            pointF.set(pointF.x, this.f13378i.y);
        } else {
            PointF pointF2 = this.f13379j;
            pointF2.set(pointF2.x, fB2.floatValue());
        }
        return this.f13379j;
    }

    public void r(@Nullable a1.j<Float> jVar) {
        a1.j<Float> jVar2 = this.f13382m;
        if (jVar2 != null) {
            jVar2.f34b = null;
        }
        this.f13382m = jVar;
        if (jVar != null) {
            jVar.f34b = this;
        }
    }

    public void s(@Nullable a1.j<Float> jVar) {
        a1.j<Float> jVar2 = this.f13383n;
        if (jVar2 != null) {
            jVar2.f34b = null;
        }
        this.f13383n = jVar;
        if (jVar != null) {
            jVar.f34b = this;
        }
    }
}
