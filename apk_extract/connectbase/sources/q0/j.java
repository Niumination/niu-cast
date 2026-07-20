package q0;

import android.graphics.PointF;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class j extends f<PointF> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final PointF f13374i;

    public j(List<a1.a<PointF>> list) {
        super(list);
        this.f13374i = new PointF();
    }

    @Override // q0.a
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public PointF i(a1.a<PointF> aVar, float f10) {
        return j(aVar, f10, f10, f10);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // q0.a
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public PointF j(a1.a<PointF> aVar, float f10, float f11, float f12) {
        PointF pointF;
        PointF pointF2;
        PointF pointF3 = aVar.f6b;
        if (pointF3 == null || (pointF = aVar.f7c) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF4 = pointF3;
        PointF pointF5 = pointF;
        a1.j<A> jVar = this.f13354e;
        if (jVar != 0 && (pointF2 = (PointF) jVar.b(aVar.f11g, aVar.f12h.floatValue(), pointF4, pointF5, f10, e(), f())) != null) {
            return pointF2;
        }
        PointF pointF6 = this.f13374i;
        float f13 = pointF4.x;
        float fA = g.a.a(pointF5.x, f13, f11, f13);
        float f14 = pointF4.y;
        pointF6.set(fA, g.a.a(pointF5.y, f14, f12, f14));
        return this.f13374i;
    }
}
