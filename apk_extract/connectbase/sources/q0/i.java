package q0;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class i extends f<PointF> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final PointF f13370i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float[] f13371j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final PathMeasure f13372k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public h f13373l;

    public i(List<? extends a1.a<PointF>> list) {
        super(list);
        this.f13370i = new PointF();
        this.f13371j = new float[2];
        this.f13372k = new PathMeasure();
    }

    /* JADX WARN: Multi-variable type inference failed */
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
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public PointF i(a1.a<PointF> aVar, float f10) {
        PointF pointF;
        h hVar = (h) aVar;
        Path pathJ = hVar.j();
        if (pathJ == null) {
            return aVar.f6b;
        }
        a1.j<A> jVar = this.f13354e;
        if (jVar != 0 && (pointF = (PointF) jVar.b(hVar.f11g, hVar.f12h.floatValue(), hVar.f6b, hVar.f7c, e(), f10, f())) != null) {
            return pointF;
        }
        if (this.f13373l != hVar) {
            this.f13372k.setPath(pathJ, false);
            this.f13373l = hVar;
        }
        PathMeasure pathMeasure = this.f13372k;
        pathMeasure.getPosTan(pathMeasure.getLength() * f10, this.f13371j, null);
        PointF pointF2 = this.f13370i;
        float[] fArr = this.f13371j;
        pointF2.set(fArr[0], fArr[1]);
        return this.f13370i;
    }
}
