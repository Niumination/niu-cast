package co;

import eo.h0;
import ho.x;
import java.util.List;
import kn.g1;
import kn.l0;
import kn.l1;
import kn.n0;
import os.l;
import os.m;
import un.o;
import up.n;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends ao.h {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ o<Object>[] f1712l = {l1.f9319a.n(new g1(l1.d(f.class), "customizer", "getCustomizer()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsCustomizer;"))};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @l
    public final a f1713i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @m
    public jn.a<b> f1714j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @l
    public final up.i f1715k;

    public enum a {
        FROM_DEPENDENCIES,
        FROM_CLASS_LOADER,
        FALLBACK
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @l
        public final h0 f1717a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f1718b;

        public b(@l h0 h0Var, boolean z10) {
            l0.p(h0Var, "ownerModuleDescriptor");
            this.f1717a = h0Var;
            this.f1718b = z10;
        }

        @l
        public final h0 a() {
            return this.f1717a;
        }

        public final boolean b() {
            return this.f1718b;
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1719a;

        static {
            int[] iArr = new int[a.values().length];
            iArr[a.FROM_DEPENDENCIES.ordinal()] = 1;
            iArr[a.FROM_CLASS_LOADER.ordinal()] = 2;
            iArr[a.FALLBACK.ordinal()] = 3;
            f1719a = iArr;
        }
    }

    public static final class d extends n0 implements jn.a<g> {
        final /* synthetic */ n $storageManager;

        public static final class a extends n0 implements jn.a<b> {
            final /* synthetic */ f this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(f fVar) {
                super(0);
                this.this$0 = fVar;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // jn.a
            @l
            public final b invoke() {
                jn.a aVar = this.this$0.f1714j;
                if (aVar == null) {
                    throw new AssertionError("JvmBuiltins instance has not been initialized properly");
                }
                b bVar = (b) aVar.invoke();
                this.this$0.f1714j = null;
                return bVar;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(n nVar) {
            super(0);
            this.$storageManager = nVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.a
        @l
        public final g invoke() {
            x xVarR = f.this.r();
            l0.o(xVarR, "builtInsModule");
            return new g(xVarR, this.$storageManager, new a(f.this));
        }
    }

    public static final class e extends n0 implements jn.a<b> {
        final /* synthetic */ boolean $isAdditionalBuiltInsFeatureSupported;
        final /* synthetic */ h0 $moduleDescriptor;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(h0 h0Var, boolean z10) {
            super(0);
            this.$moduleDescriptor = h0Var;
            this.$isAdditionalBuiltInsFeatureSupported = z10;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.a
        @l
        public final b invoke() {
            return new b(this.$moduleDescriptor, this.$isAdditionalBuiltInsFeatureSupported);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@l n nVar, @l a aVar) {
        super(nVar);
        l0.p(nVar, "storageManager");
        l0.p(aVar, "kind");
        this.f1713i = aVar;
        this.f1715k = nVar.h(new d(nVar));
        int i10 = c.f1719a[aVar.ordinal()];
        if (i10 == 2) {
            f(false);
        } else {
            if (i10 != 3) {
                return;
            }
            f(true);
        }
    }

    @Override // ao.h
    @l
    /* JADX INFO: renamed from: F0, reason: merged with bridge method [inline-methods] */
    public List<go.b> v() {
        Iterable<go.b> iterableV = super.v();
        l0.o(iterableV, "super.getClassDescriptorFactories()");
        n nVarU = U();
        l0.o(nVarU, "storageManager");
        x xVarR = r();
        l0.o(xVarR, "builtInsModule");
        return nm.h0.B4(iterableV, new co.e(nVarU, xVarR, null, 4, null));
    }

    @l
    public final g G0() {
        return (g) up.m.a(this.f1715k, this, f1712l[0]);
    }

    public final void H0(@l h0 h0Var, boolean z10) {
        l0.p(h0Var, "moduleDescriptor");
        I0(new e(h0Var, z10));
    }

    public final void I0(@l jn.a<b> aVar) {
        l0.p(aVar, "computation");
        this.f1714j = aVar;
    }

    @Override // ao.h
    @l
    public go.c M() {
        return G0();
    }

    @Override // ao.h
    @l
    public go.a g() {
        return G0();
    }
}
