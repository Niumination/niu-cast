package q0;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class c extends f<Float> {
    public c(List<a1.a<Float>> list) {
        super(list);
    }

    public float p() {
        return q(b(), d());
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
    public float q(a1.a<Float> aVar, float f10) {
        Float f11;
        if (aVar.f6b == null || aVar.f7c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        a1.j<A> jVar = this.f13354e;
        return (jVar == 0 || (f11 = (Float) jVar.b(aVar.f11g, aVar.f12h.floatValue(), aVar.f6b, aVar.f7c, f10, e(), f())) == null) ? z0.g.k(aVar.f(), aVar.c(), f10) : f11.floatValue();
    }

    @Override // q0.a
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public Float i(a1.a<Float> aVar, float f10) {
        return Float.valueOf(q(aVar, f10));
    }
}
