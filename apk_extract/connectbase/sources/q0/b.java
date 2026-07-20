package q0;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b extends f<Integer> {
    public b(List<a1.a<Integer>> list) {
        super(list);
    }

    public int p() {
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
    public int q(a1.a<Integer> aVar, float f10) {
        Integer num;
        Integer num2 = aVar.f6b;
        if (num2 == null || aVar.f7c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        Integer num3 = num2;
        int iIntValue = num3.intValue();
        Integer num4 = aVar.f7c;
        int iIntValue2 = num4.intValue();
        a1.j<A> jVar = this.f13354e;
        return (jVar == 0 || (num = (Integer) jVar.b(aVar.f11g, aVar.f12h.floatValue(), num3, num4, f10, e(), f())) == null) ? z0.b.c(z0.g.c(f10, 0.0f, 1.0f), iIntValue, iIntValue2) : num.intValue();
    }

    @Override // q0.a
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public Integer i(a1.a<Integer> aVar, float f10) {
        return Integer.valueOf(q(aVar, f10));
    }
}
