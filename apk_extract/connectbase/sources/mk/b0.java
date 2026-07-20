package mk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kn.l0;
import kn.n0;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
@f
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final List<jn.a<w<?>>> f10736a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final Boolean[] f10737b;

    public static final class a extends n0 implements jn.l<Object, l2> {
        public static final a INSTANCE = new a();

        public a() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l Object obj) {
            l0.p(obj, "$this$null");
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Object obj) {
            invoke2(obj);
            return l2.f10208a;
        }
    }

    public static final class b extends n0 implements jn.a<w<?>> {
        final /* synthetic */ jn.l<ConfigType, l2> $config;
        final /* synthetic */ x<ConfigType, ?> $extension;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(x<ConfigType, ?> xVar, jn.l<? super ConfigType, l2> lVar) {
            super(0);
            this.$extension = xVar;
            this.$config = lVar;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // jn.a
        @os.l
        public final w<?> invoke() {
            return this.$extension.d(this.$config);
        }
    }

    public b0() {
        Boolean bool = Boolean.FALSE;
        this.f10737b = new Boolean[]{bool, bool, bool};
    }

    public static /* synthetic */ void d(b0 b0Var, x xVar, jn.l lVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            lVar = a.INSTANCE;
        }
        b0Var.c(xVar, lVar);
    }

    @os.l
    public final List<w<?>> a() {
        List<jn.a<w<?>>> list = this.f10736a;
        ArrayList arrayList = new ArrayList(nm.z.b0(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((w) ((jn.a) it.next()).invoke());
        }
        return arrayList;
    }

    public final void b(x<?, ?> xVar) {
        boolean z10 = true;
        if ((!xVar.a() || !this.f10737b[1].booleanValue()) && ((!xVar.b() || !this.f10737b[2].booleanValue()) && (!xVar.c() || !this.f10737b[3].booleanValue()))) {
            z10 = false;
        }
        if (z10) {
            throw new IllegalStateException("Failed to install extension. Please check configured extensions for conflicts.");
        }
    }

    public final <ConfigType> void c(@os.l x<ConfigType, ?> xVar, @os.l jn.l<? super ConfigType, l2> lVar) {
        l0.p(xVar, "extension");
        l0.p(lVar, "config");
        b(xVar);
        this.f10736a.add(new b(xVar, lVar));
    }
}
