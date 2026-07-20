package ho;

import eo.d1;
import eo.w0;
import eo.z0;
import java.util.List;
import kn.g1;
import kn.l1;
import vp.h1;
import vp.o1;
import vp.q0;

/* JADX INFO: loaded from: classes3.dex */
public final class j0 extends p implements i0 {

    @os.l
    public final up.n V;

    @os.l
    public final d1 W;

    @os.l
    public final up.j X;

    @os.l
    public eo.d Y;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final /* synthetic */ un.o<Object>[] f7360a0 = {l1.f9319a.n(new g1(l1.d(j0.class), "withDispatchReceiver", "getWithDispatchReceiver()Lorg/jetbrains/kotlin/descriptors/impl/TypeAliasConstructorDescriptor;"))};

    @os.l
    public static final a Z = new a();

    public static final class a {
        public a() {
        }

        @os.m
        public final i0 b(@os.l up.n nVar, @os.l d1 d1Var, @os.l eo.d dVar) {
            eo.d dVarC;
            kn.l0.p(nVar, "storageManager");
            kn.l0.p(d1Var, "typeAliasDescriptor");
            kn.l0.p(dVar, "constructor");
            h1 h1VarC = c(d1Var);
            w0 w0VarF = null;
            if (h1VarC == null || (dVarC = dVar.c(h1VarC)) == null) {
                return null;
            }
            fo.g annotations = dVar.getAnnotations();
            eo.b.a kind = dVar.getKind();
            kn.l0.o(kind, "constructor.kind");
            z0 source = d1Var.getSource();
            kn.l0.o(source, "typeAliasDescriptor.source");
            j0 j0Var = new j0(nVar, d1Var, dVarC, null, annotations, kind, source);
            List<eo.h1> listI0 = p.I0(j0Var, dVar.h(), h1VarC);
            if (listI0 == null) {
                return null;
            }
            vp.n0 n0VarC = vp.c0.c(dVarC.getReturnType().J0());
            vp.n0 n0VarQ = d1Var.q();
            kn.l0.o(n0VarQ, "typeAliasDescriptor.defaultType");
            vp.n0 n0VarJ = q0.j(n0VarC, n0VarQ);
            w0 w0VarO = dVar.O();
            if (w0VarO != null) {
                vp.f0 f0VarN = h1VarC.n(w0VarO.getType(), o1.INVARIANT);
                fo.g.f6167h.getClass();
                w0VarF = hp.c.f(j0Var, f0VarN, fo.g.a.f6169b);
            }
            j0Var.L0(w0VarF, null, d1Var.r(), listI0, n0VarJ, eo.e0.FINAL, d1Var.getVisibility());
            return j0Var;
        }

        public final h1 c(d1 d1Var) {
            if (d1Var.v() == null) {
                return null;
            }
            return h1.f(d1Var.J());
        }

        public a(kn.w wVar) {
        }
    }

    public static final class b extends kn.n0 implements jn.a<j0> {
        final /* synthetic */ eo.d $underlyingConstructorDescriptor;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(eo.d dVar) {
            super(0);
            this.$underlyingConstructorDescriptor = dVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.a
        @os.m
        public final j0 invoke() {
            j0 j0Var = j0.this;
            up.n nVar = j0Var.V;
            d1 d1Var = j0Var.W;
            eo.d dVar = this.$underlyingConstructorDescriptor;
            fo.g annotations = dVar.getAnnotations();
            eo.b.a kind = this.$underlyingConstructorDescriptor.getKind();
            kn.l0.o(kind, "underlyingConstructorDescriptor.kind");
            z0 source = j0.this.W.getSource();
            kn.l0.o(source, "typeAliasDescriptor.source");
            j0 j0Var2 = new j0(nVar, d1Var, dVar, j0Var, annotations, kind, source);
            j0 j0Var3 = j0.this;
            eo.d dVar2 = this.$underlyingConstructorDescriptor;
            h1 h1VarC = j0.Z.c(j0Var3.W);
            if (h1VarC == null) {
                return null;
            }
            w0 w0VarO = dVar2.O();
            j0Var2.L0(null, w0VarO != null ? w0VarO.c(h1VarC) : null, j0Var3.W.r(), j0Var3.h(), j0Var3.getReturnType(), eo.e0.FINAL, j0Var3.W.getVisibility());
            return j0Var2;
        }
    }

    public /* synthetic */ j0(up.n nVar, d1 d1Var, eo.d dVar, i0 i0Var, fo.g gVar, eo.b.a aVar, z0 z0Var, kn.w wVar) {
        this(nVar, d1Var, dVar, i0Var, gVar, aVar, z0Var);
    }

    @os.l
    public final up.n P() {
        return this.V;
    }

    @Override // ho.i0
    @os.l
    public eo.d U() {
        return this.Y;
    }

    @Override // ho.p, ho.k, ho.j, eo.m
    public eo.a a() {
        return (i0) super.a();
    }

    @Override // ho.k, eo.m
    public eo.i b() {
        return this.W;
    }

    @Override // eo.l
    public boolean b0() {
        return this.Y.b0();
    }

    @Override // eo.l
    @os.l
    public eo.e c0() {
        eo.e eVarC0 = this.Y.c0();
        kn.l0.o(eVarC0, "underlyingConstructorDescriptor.constructedClass");
        return eVarC0;
    }

    @Override // ho.p, eo.b
    @os.l
    /* JADX INFO: renamed from: e1, reason: merged with bridge method [inline-methods] */
    public i0 h0(@os.l eo.m mVar, @os.l eo.e0 e0Var, @os.l eo.u uVar, @os.l eo.b.a aVar, boolean z10) {
        kn.l0.p(mVar, "newOwner");
        kn.l0.p(e0Var, "modality");
        kn.l0.p(uVar, "visibility");
        kn.l0.p(aVar, "kind");
        eo.y yVarBuild = w().n(mVar).b(e0Var).l(uVar).p(aVar).m(z10).build();
        if (yVarBuild != null) {
            return (i0) yVarBuild;
        }
        throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
    }

    @Override // ho.p, ho.k
    /* JADX INFO: renamed from: f0 */
    public eo.p a() {
        return (i0) super.a();
    }

    @Override // ho.p
    @os.l
    /* JADX INFO: renamed from: f1, reason: merged with bridge method [inline-methods] */
    public j0 F0(@os.l eo.m mVar, @os.m eo.y yVar, @os.l eo.b.a aVar, @os.m dp.f fVar, @os.l fo.g gVar, @os.l z0 z0Var) {
        kn.l0.p(mVar, "newOwner");
        kn.l0.p(aVar, "kind");
        kn.l0.p(gVar, "annotations");
        kn.l0.p(z0Var, "source");
        eo.b.a aVar2 = eo.b.a.DECLARATION;
        if (aVar != aVar2) {
            eo.b.a aVar3 = eo.b.a.SYNTHESIZED;
        }
        return new j0(this.V, this.W, this.Y, this, gVar, aVar2, z0Var);
    }

    @os.l
    public d1 g1() {
        return this.W;
    }

    @Override // ho.p, eo.a
    @os.l
    public vp.f0 getReturnType() {
        vp.f0 f0Var = this.f7400g;
        kn.l0.m(f0Var);
        kn.l0.o(f0Var, "super.getReturnType()!!");
        return f0Var;
    }

    @os.l
    public i0 h1() {
        return (i0) super.a();
    }

    @os.l
    public d1 i1() {
        return this.W;
    }

    @Override // ho.p, eo.y, eo.b1
    @os.m
    /* JADX INFO: renamed from: j1, reason: merged with bridge method [inline-methods] */
    public i0 c(@os.l h1 h1Var) {
        kn.l0.p(h1Var, "substitutor");
        eo.y yVarC = super.c(h1Var);
        if (yVarC == null) {
            throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptorImpl");
        }
        j0 j0Var = (j0) yVarC;
        h1 h1VarF = h1.f(j0Var.getReturnType());
        kn.l0.o(h1VarF, "create(substitutedTypeAliasConstructor.returnType)");
        eo.d dVarC = this.Y.a().c(h1VarF);
        if (dVarC == null) {
            return null;
        }
        j0Var.Y = dVarC;
        return j0Var;
    }

    public j0(up.n nVar, d1 d1Var, eo.d dVar, i0 i0Var, fo.g gVar, eo.b.a aVar, z0 z0Var) {
        super(d1Var, i0Var, gVar, dp.h.f3832i, aVar, z0Var);
        this.V = nVar;
        this.W = d1Var;
        this.J = d1Var.Y();
        this.X = nVar.g(new b(dVar));
        this.Y = dVar;
    }

    @Override // ho.p, ho.k, ho.j, eo.m
    public eo.b a() {
        return (i0) super.a();
    }

    @Override // ho.k, eo.m
    public eo.m b() {
        return this.W;
    }

    @Override // ho.p, ho.k, ho.j, eo.m
    public eo.m a() {
        return (i0) super.a();
    }

    @Override // ho.p, ho.k, ho.j, eo.m
    public eo.y a() {
        return (i0) super.a();
    }
}
