package q0;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class k extends f<a1.k> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a1.k f13375i;

    public k(List<a1.a<a1.k>> list) {
        super(list);
        this.f13375i = new a1.k();
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
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public a1.k i(a1.a<a1.k> aVar, float f10) {
        a1.k kVar;
        a1.k kVar2;
        a1.k kVar3 = aVar.f6b;
        if (kVar3 == null || (kVar = aVar.f7c) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        a1.k kVar4 = kVar3;
        a1.k kVar5 = kVar;
        a1.j<A> jVar = this.f13354e;
        if (jVar != 0 && (kVar2 = (a1.k) jVar.b(aVar.f11g, aVar.f12h.floatValue(), kVar4, kVar5, f10, e(), f())) != null) {
            return kVar2;
        }
        this.f13375i.d(z0.g.k(kVar4.b(), kVar5.b(), f10), z0.g.k(kVar4.c(), kVar5.c(), f10));
        return this.f13375i;
    }
}
