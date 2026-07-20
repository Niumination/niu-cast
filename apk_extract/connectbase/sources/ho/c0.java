package ho;

import eo.e1;
import eo.s0;
import eo.t0;
import eo.u0;
import eo.v0;
import eo.w0;
import eo.z0;
import ik.y0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import vp.f1;
import vp.h1;
import vp.o1;

/* JADX INFO: loaded from: classes3.dex */
public class c0 extends n0 implements t0 {
    public final boolean H;
    public final boolean I;
    public final boolean J;
    public final boolean K;
    public final boolean L;
    public w0 M;
    public w0 N;
    public List<e1> O;
    public d0 P;
    public v0 Q;
    public boolean R;
    public eo.w S;
    public eo.w T;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final eo.e0 f7302p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public eo.u f7303v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Collection<? extends t0> f7304w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final t0 f7305x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final eo.b.a f7306y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final boolean f7307z;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public eo.m f7308a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public eo.e0 f7309b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public eo.u f7310c;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public eo.b.a f7313f;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public w0 f7316i;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public dp.f f7318k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public vp.f0 f7319l;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public t0 f7311d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f7312e = false;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public f1 f7314g = f1.f17686b;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f7315h = true;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public List<e1> f7317j = null;

        public a() {
            this.f7308a = c0.this.b();
            this.f7309b = c0.this.s();
            this.f7310c = c0.this.getVisibility();
            this.f7313f = c0.this.getKind();
            this.f7316i = c0.this.M;
            this.f7318k = c0.this.getName();
            this.f7319l = c0.this.getType();
        }

        public static /* synthetic */ void a(int i10) {
            String str = (i10 == 1 || i10 == 2 || i10 == 3 || i10 == 5 || i10 == 7 || i10 == 9 || i10 == 11 || i10 == 19 || i10 == 13 || i10 == 14 || i10 == 16 || i10 == 17) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i10 == 1 || i10 == 2 || i10 == 3 || i10 == 5 || i10 == 7 || i10 == 9 || i10 == 11 || i10 == 19 || i10 == 13 || i10 == 14 || i10 == 16 || i10 == 17) ? 2 : 3];
            switch (i10) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 9:
                case 11:
                case 13:
                case 14:
                case 16:
                case 17:
                case 19:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
                    break;
                case 4:
                    objArr[0] = y0.a.f8215h;
                    break;
                case 6:
                    objArr[0] = "modality";
                    break;
                case 8:
                    objArr[0] = "visibility";
                    break;
                case 10:
                    objArr[0] = "kind";
                    break;
                case 12:
                    objArr[0] = "typeParameters";
                    break;
                case 15:
                    objArr[0] = "substitution";
                    break;
                case 18:
                    objArr[0] = "name";
                    break;
                default:
                    objArr[0] = "owner";
                    break;
            }
            if (i10 == 1) {
                objArr[1] = "setOwner";
            } else if (i10 == 2) {
                objArr[1] = "setOriginal";
            } else if (i10 == 3) {
                objArr[1] = "setPreserveSourceElement";
            } else if (i10 == 5) {
                objArr[1] = "setReturnType";
            } else if (i10 == 7) {
                objArr[1] = "setModality";
            } else if (i10 == 9) {
                objArr[1] = "setVisibility";
            } else if (i10 == 11) {
                objArr[1] = "setKind";
            } else if (i10 == 19) {
                objArr[1] = "setName";
            } else if (i10 == 13) {
                objArr[1] = "setTypeParameters";
            } else if (i10 == 14) {
                objArr[1] = "setDispatchReceiverParameter";
            } else if (i10 == 16) {
                objArr[1] = "setSubstitution";
            } else if (i10 != 17) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
            } else {
                objArr[1] = "setCopyOverrides";
            }
            switch (i10) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 9:
                case 11:
                case 13:
                case 14:
                case 16:
                case 17:
                case 19:
                    break;
                case 4:
                    objArr[2] = "setReturnType";
                    break;
                case 6:
                    objArr[2] = "setModality";
                    break;
                case 8:
                    objArr[2] = "setVisibility";
                    break;
                case 10:
                    objArr[2] = "setKind";
                    break;
                case 12:
                    objArr[2] = "setTypeParameters";
                    break;
                case 15:
                    objArr[2] = "setSubstitution";
                    break;
                case 18:
                    objArr[2] = "setName";
                    break;
                default:
                    objArr[2] = "setOwner";
                    break;
            }
            String str2 = String.format(str, objArr);
            if (i10 != 1 && i10 != 2 && i10 != 3 && i10 != 5 && i10 != 7 && i10 != 9 && i10 != 11 && i10 != 19 && i10 != 13 && i10 != 14 && i10 != 16 && i10 != 17) {
                throw new IllegalArgumentException(str2);
            }
            throw new IllegalStateException(str2);
        }

        @os.m
        public t0 n() {
            return c0.this.K0(this);
        }

        public u0 o() {
            t0 t0Var = this.f7311d;
            if (t0Var == null) {
                return null;
            }
            return t0Var.getGetter();
        }

        public v0 p() {
            t0 t0Var = this.f7311d;
            if (t0Var == null) {
                return null;
            }
            return t0Var.getSetter();
        }

        @os.l
        public a q(boolean z10) {
            this.f7315h = z10;
            return this;
        }

        @os.l
        public a r(@os.l eo.b.a aVar) {
            if (aVar == null) {
                a(10);
            }
            this.f7313f = aVar;
            return this;
        }

        @os.l
        public a s(@os.l eo.e0 e0Var) {
            if (e0Var == null) {
                a(6);
            }
            this.f7309b = e0Var;
            return this;
        }

        @os.l
        public a t(@os.m eo.b bVar) {
            this.f7311d = (t0) bVar;
            return this;
        }

        @os.l
        public a u(@os.l eo.m mVar) {
            if (mVar == null) {
                a(0);
            }
            this.f7308a = mVar;
            return this;
        }

        @os.l
        public a v(@os.l f1 f1Var) {
            if (f1Var == null) {
                a(15);
            }
            this.f7314g = f1Var;
            return this;
        }

        @os.l
        public a w(@os.l eo.u uVar) {
            if (uVar == null) {
                a(8);
            }
            this.f7310c = uVar;
            return this;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(@os.l eo.m mVar, @os.m t0 t0Var, @os.l fo.g gVar, @os.l eo.e0 e0Var, @os.l eo.u uVar, boolean z10, @os.l dp.f fVar, @os.l eo.b.a aVar, @os.l z0 z0Var, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16) {
        super(mVar, gVar, fVar, null, z10, z0Var);
        if (mVar == null) {
            B(0);
        }
        if (gVar == null) {
            B(1);
        }
        if (e0Var == null) {
            B(2);
        }
        if (uVar == null) {
            B(3);
        }
        if (fVar == null) {
            B(4);
        }
        if (aVar == null) {
            B(5);
        }
        if (z0Var == null) {
            B(6);
        }
        this.f7304w = null;
        this.f7302p = e0Var;
        this.f7303v = uVar;
        this.f7305x = t0Var == null ? this : t0Var;
        this.f7306y = aVar;
        this.f7307z = z11;
        this.H = z12;
        this.I = z13;
        this.J = z14;
        this.K = z15;
        this.L = z16;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001a  */
    private static /* synthetic */ void B(int i10) {
        String str;
        int i11;
        if (i10 != 24 && i10 != 34 && i10 != 35 && i10 != 37 && i10 != 38) {
            switch (i10) {
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i10 != 24 && i10 != 34 && i10 != 35 && i10 != 37 && i10 != 38) {
            switch (i10) {
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                    i11 = 2;
                    break;
                default:
                    i11 = 3;
                    break;
            }
        } else {
            i11 = 2;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
            case 8:
                objArr[0] = "annotations";
                break;
            case 2:
            case 9:
                objArr[0] = "modality";
                break;
            case 3:
            case 10:
            case 17:
                objArr[0] = "visibility";
                break;
            case 4:
            case 11:
                objArr[0] = "name";
                break;
            case 5:
            case 12:
            case 31:
                objArr[0] = "kind";
                break;
            case 6:
            case 13:
            case 33:
                objArr[0] = "source";
                break;
            case 7:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 14:
                objArr[0] = "inType";
                break;
            case 15:
                objArr[0] = "outType";
                break;
            case 16:
                objArr[0] = "typeParameters";
                break;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 24:
            case 34:
            case 35:
            case 37:
            case 38:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl";
                break;
            case 23:
                objArr[0] = "originalSubstitutor";
                break;
            case 25:
                objArr[0] = "copyConfiguration";
                break;
            case 26:
                objArr[0] = "substitutor";
                break;
            case 27:
                objArr[0] = "accessorDescriptor";
                break;
            case 28:
                objArr[0] = "newOwner";
                break;
            case 29:
                objArr[0] = "newModality";
                break;
            case 30:
                objArr[0] = "newVisibility";
                break;
            case 32:
                objArr[0] = "newName";
                break;
            case 36:
                objArr[0] = "overriddenDescriptors";
                break;
        }
        if (i10 == 24) {
            objArr[1] = "getSourceToUseForCopy";
        } else if (i10 == 34) {
            objArr[1] = "getOriginal";
        } else if (i10 == 35) {
            objArr[1] = "getKind";
        } else if (i10 == 37) {
            objArr[1] = "getOverriddenDescriptors";
        } else if (i10 != 38) {
            switch (i10) {
                case 18:
                    objArr[1] = "getTypeParameters";
                    break;
                case 19:
                    objArr[1] = "getReturnType";
                    break;
                case 20:
                    objArr[1] = "getModality";
                    break;
                case 21:
                    objArr[1] = "getVisibility";
                    break;
                case 22:
                    objArr[1] = "getAccessors";
                    break;
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl";
                    break;
            }
        } else {
            objArr[1] = "copy";
        }
        switch (i10) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                objArr[2] = "create";
                break;
            case 14:
                objArr[2] = "setInType";
                break;
            case 15:
            case 16:
                objArr[2] = "setType";
                break;
            case 17:
                objArr[2] = "setVisibility";
                break;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 24:
            case 34:
            case 35:
            case 37:
            case 38:
                break;
            case 23:
                objArr[2] = "substitute";
                break;
            case 25:
                objArr[2] = "doSubstitute";
                break;
            case 26:
            case 27:
                objArr[2] = "getSubstitutedInitialSignatureDescriptor";
                break;
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 36:
                objArr[2] = "setOverriddenDescriptors";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i10 != 24 && i10 != 34 && i10 != 35 && i10 != 37 && i10 != 38) {
            switch (i10) {
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                    break;
                default:
                    throw new IllegalArgumentException(str2);
            }
        }
        throw new IllegalStateException(str2);
    }

    @os.l
    public static c0 I0(@os.l eo.m mVar, @os.l fo.g gVar, @os.l eo.e0 e0Var, @os.l eo.u uVar, boolean z10, @os.l dp.f fVar, @os.l eo.b.a aVar, @os.l z0 z0Var, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16) {
        if (mVar == null) {
            B(7);
        }
        if (gVar == null) {
            B(8);
        }
        if (e0Var == null) {
            B(9);
        }
        if (uVar == null) {
            B(10);
        }
        if (fVar == null) {
            B(11);
        }
        if (aVar == null) {
            B(12);
        }
        if (z0Var == null) {
            B(13);
        }
        return new c0(mVar, null, gVar, e0Var, uVar, z10, fVar, aVar, z0Var, z11, z12, z13, z14, z15, z16);
    }

    public static eo.y N0(@os.l h1 h1Var, @os.l s0 s0Var) {
        if (h1Var == null) {
            B(26);
        }
        if (s0Var == null) {
            B(27);
        }
        if (s0Var.q0() != null) {
            return s0Var.q0().c(h1Var);
        }
        return null;
    }

    public static eo.u S0(eo.u uVar, eo.b.a aVar) {
        return (aVar == eo.b.a.FAKE_OVERRIDE && eo.t.g(uVar.f())) ? eo.t.f4636h : uVar;
    }

    @Override // eo.m
    public <R, D> R A(eo.o<R, D> oVar, D d10) {
        return oVar.b(this, d10);
    }

    @Override // eo.k1
    public boolean C() {
        return this.L;
    }

    @Override // eo.b
    @os.l
    /* JADX INFO: renamed from: H0, reason: merged with bridge method [inline-methods] */
    public t0 h0(eo.m mVar, eo.e0 e0Var, eo.u uVar, eo.b.a aVar, boolean z10) {
        t0 t0VarN = R0().u(mVar).t(null).s(e0Var).w(uVar).r(aVar).q(z10).n();
        if (t0VarN == null) {
            B(38);
        }
        return t0VarN;
    }

    @os.l
    public c0 J0(@os.l eo.m mVar, @os.l eo.e0 e0Var, @os.l eo.u uVar, @os.m t0 t0Var, @os.l eo.b.a aVar, @os.l dp.f fVar, @os.l z0 z0Var) {
        if (mVar == null) {
            B(28);
        }
        if (e0Var == null) {
            B(29);
        }
        if (uVar == null) {
            B(30);
        }
        if (aVar == null) {
            B(31);
        }
        if (fVar == null) {
            B(32);
        }
        if (z0Var == null) {
            B(33);
        }
        return new c0(mVar, t0Var, getAnnotations(), e0Var, uVar, Q(), fVar, aVar, z0Var, u0(), isConst(), i0(), Y(), isExternal(), C());
    }

    @os.m
    public t0 K0(@os.l a aVar) {
        w0 w0VarC;
        f0 f0Var;
        up.j<jp.g<?>> jVar;
        if (aVar == null) {
            B(25);
        }
        eo.m mVar = aVar.f7308a;
        eo.e0 e0Var = aVar.f7309b;
        eo.u uVar = aVar.f7310c;
        t0 t0Var = aVar.f7311d;
        c0 c0VarJ0 = J0(mVar, e0Var, uVar, t0Var, aVar.f7313f, aVar.f7318k, M0(aVar.f7312e, t0Var));
        List<e1> typeParameters = aVar.f7317j;
        if (typeParameters == null) {
            typeParameters = getTypeParameters();
        }
        ArrayList arrayList = new ArrayList(typeParameters.size());
        h1 h1VarB = vp.s.b(typeParameters, aVar.f7314g, c0VarJ0, arrayList);
        vp.f0 f0Var2 = aVar.f7319l;
        o1 o1Var = o1.OUT_VARIANCE;
        vp.f0 f0VarP = h1VarB.p(f0Var2, o1Var);
        if (f0VarP == null) {
            return null;
        }
        o1 o1Var2 = o1.IN_VARIANCE;
        vp.f0 f0VarP2 = h1VarB.p(f0Var2, o1Var2);
        if (f0VarP2 != null) {
            c0VarJ0.T0(f0VarP2);
        }
        w0 w0Var = aVar.f7316i;
        if (w0Var != null) {
            w0VarC = w0Var.c(h1VarB);
            if (w0VarC == null) {
                return null;
            }
        } else {
            w0VarC = null;
        }
        w0 w0Var2 = this.N;
        if (w0Var2 != null) {
            vp.f0 f0VarP3 = h1VarB.p(w0Var2.getType(), o1Var2);
            if (f0VarP3 == null) {
                return null;
            }
            f0Var = new f0(c0VarJ0, new pp.b(c0VarJ0, f0VarP3, this.N.getValue()), this.N.getAnnotations());
        } else {
            f0Var = null;
        }
        c0VarJ0.V0(f0VarP, arrayList, w0VarC, f0Var);
        d0 d0Var = this.P == null ? null : new d0(c0VarJ0, this.P.getAnnotations(), aVar.f7309b, S0(this.P.getVisibility(), aVar.f7313f), this.P.I(), this.P.isExternal(), this.P.isInline(), aVar.f7313f, aVar.o(), z0.f4654a);
        if (d0Var != null) {
            vp.f0 returnType = this.P.getReturnType();
            d0Var.H0(N0(h1VarB, this.P));
            d0Var.K0(returnType != null ? h1VarB.p(returnType, o1Var) : null);
        }
        e0 e0Var2 = this.Q == null ? null : new e0(c0VarJ0, this.Q.getAnnotations(), aVar.f7309b, S0(this.Q.getVisibility(), aVar.f7313f), this.Q.I(), this.Q.isExternal(), this.Q.isInline(), aVar.f7313f, aVar.p(), z0.f4654a);
        if (e0Var2 != null) {
            List<eo.h1> listJ0 = p.J0(e0Var2, this.Q.h(), h1VarB, false, false, null);
            if (listJ0 == null) {
                c0VarJ0.U0(true);
                listJ0 = Collections.singletonList(e0.J0(e0Var2, lp.a.g(aVar.f7308a).H(), this.Q.h().get(0).getAnnotations()));
            }
            if (listJ0.size() != 1) {
                throw new IllegalStateException();
            }
            e0Var2.H0(N0(h1VarB, this.Q));
            e0Var2.L0(listJ0.get(0));
        }
        eo.w wVar = this.S;
        o oVar = wVar == null ? null : new o(wVar.getAnnotations(), c0VarJ0);
        eo.w wVar2 = this.T;
        c0VarJ0.P0(d0Var, e0Var2, oVar, wVar2 != null ? new o(wVar2.getAnnotations(), c0VarJ0) : null);
        if (aVar.f7315h) {
            eq.f fVarA = eq.f.a();
            Iterator<? extends t0> it = d().iterator();
            while (it.hasNext()) {
                fVarA.add(it.next().c(h1VarB));
            }
            c0VarJ0.z0(fVarA);
        }
        if (isConst() && (jVar = this.f7396i) != null) {
            c0VarJ0.F0(jVar);
        }
        return c0VarJ0;
    }

    @Override // eo.t0
    @os.m
    /* JADX INFO: renamed from: L0, reason: merged with bridge method [inline-methods] */
    public d0 getGetter() {
        return this.P;
    }

    @os.l
    public final z0 M0(boolean z10, @os.m t0 t0Var) {
        z0 source;
        if (z10) {
            if (t0Var == null) {
                t0Var = a();
            }
            source = t0Var.getSource();
        } else {
            source = z0.f4654a;
        }
        if (source == null) {
            B(24);
        }
        return source;
    }

    @Override // ho.m0, eo.a
    @os.m
    public w0 O() {
        return this.M;
    }

    public void O0(@os.m d0 d0Var, @os.m v0 v0Var) {
        P0(d0Var, v0Var, null, null);
    }

    public void P0(@os.m d0 d0Var, @os.m v0 v0Var, @os.m eo.w wVar, @os.m eo.w wVar2) {
        this.P = d0Var;
        this.Q = v0Var;
        this.S = wVar;
        this.T = wVar2;
    }

    public boolean Q0() {
        return this.R;
    }

    @Override // ho.m0, eo.a
    @os.m
    public w0 R() {
        return this.N;
    }

    @os.l
    public a R0() {
        return new a();
    }

    @Override // eo.t0
    @os.m
    public eo.w S() {
        return this.T;
    }

    public void T0(@os.l vp.f0 f0Var) {
        if (f0Var == null) {
            B(14);
        }
    }

    public void U0(boolean z10) {
        this.R = z10;
    }

    public void V0(@os.l vp.f0 f0Var, @os.l List<? extends e1> list, @os.m w0 w0Var, @os.m w0 w0Var2) {
        if (f0Var == null) {
            B(15);
        }
        if (list == null) {
            B(16);
        }
        E0(f0Var);
        this.O = new ArrayList(list);
        this.N = w0Var2;
        this.M = w0Var;
    }

    public void W0(@os.l eo.u uVar) {
        if (uVar == null) {
            B(17);
        }
        this.f7303v = uVar;
    }

    @Override // eo.d0
    public boolean Y() {
        return this.J;
    }

    @Override // ho.m0, eo.a
    @os.l
    public Collection<? extends t0> d() {
        Collection<? extends t0> collectionEmptyList = this.f7304w;
        if (collectionEmptyList == null) {
            collectionEmptyList = Collections.emptyList();
        }
        if (collectionEmptyList == null) {
            B(37);
        }
        return collectionEmptyList;
    }

    @Override // eo.b
    @os.l
    public eo.b.a getKind() {
        eo.b.a aVar = this.f7306y;
        if (aVar == null) {
            B(35);
        }
        return aVar;
    }

    @Override // ho.m0, eo.a
    @os.l
    public vp.f0 getReturnType() {
        vp.f0 type = getType();
        if (type == null) {
            B(19);
        }
        return type;
    }

    @Override // eo.t0
    @os.m
    public v0 getSetter() {
        return this.Q;
    }

    @Override // ho.m0, eo.a
    @os.l
    public List<e1> getTypeParameters() {
        List<e1> list = this.O;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException("typeParameters == null for " + toString());
    }

    @Override // eo.q, eo.d0
    @os.l
    public eo.u getVisibility() {
        eo.u uVar = this.f7303v;
        if (uVar == null) {
            B(21);
        }
        return uVar;
    }

    @Override // eo.d0
    public boolean i0() {
        return this.I;
    }

    @Override // ho.m0, eo.j1
    public boolean isConst() {
        return this.H;
    }

    @Override // eo.d0
    public boolean isExternal() {
        return this.K;
    }

    @Override // ho.m0, eo.a
    @os.m
    public <V> V j0(eo.a.InterfaceC0106a<V> interfaceC0106a) {
        return null;
    }

    @Override // eo.d0
    @os.l
    public eo.e0 s() {
        eo.e0 e0Var = this.f7302p;
        if (e0Var == null) {
            B(20);
        }
        return e0Var;
    }

    @Override // eo.t0
    @os.m
    public eo.w t0() {
        return this.S;
    }

    @Override // eo.j1
    public boolean u0() {
        return this.f7307z;
    }

    @Override // eo.t0
    @os.l
    public List<s0> z() {
        ArrayList arrayList = new ArrayList(2);
        d0 d0Var = this.P;
        if (d0Var != null) {
            arrayList.add(d0Var);
        }
        v0 v0Var = this.Q;
        if (v0Var != null) {
            arrayList.add(v0Var);
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // eo.b
    public void z0(@os.l Collection<? extends eo.b> collection) {
        if (collection == 0) {
            B(36);
        }
        this.f7304w = collection;
    }

    @Override // eo.b1
    public t0 c(@os.l h1 h1Var) {
        if (h1Var == null) {
            B(23);
        }
        return h1Var.k() ? this : R0().v(h1Var.j()).t(a()).n();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [eo.t0] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    @Override // ho.m0, ho.k
    @os.l
    public t0 a() {
        t0 t0VarA;
        t0 t0Var = this.f7305x;
        ?? r10 = this;
        if (t0Var != this) {
            t0VarA = t0Var.a();
        }
        if (r10 == 0) {
            r10 = t0VarA;
            B(34);
        }
        r10 = t0VarA;
        return r10;
    }
}
