package ho;

import eo.e1;
import eo.h1;
import eo.j1;
import eo.w0;
import eo.z0;
import ik.y0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import vp.f1;
import vp.o1;

/* JADX INFO: loaded from: classes3.dex */
public abstract class p extends k implements eo.y {
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public Collection<? extends eo.y> P;
    public volatile jn.a<Collection<eo.y>> Q;
    public final eo.y R;
    public final eo.b.a S;

    @os.m
    public eo.y T;
    public Map<eo.a.InterfaceC0106a<?>, Object> U;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<e1> f7398e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<h1> f7399f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public vp.f0 f7400g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public w0 f7401i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public w0 f7402n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public eo.e0 f7403p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public eo.u f7404v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f7405w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f7406x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f7407y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f7408z;

    public class a implements jn.a<Collection<eo.y>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ vp.h1 f7409a;

        public a(vp.h1 h1Var) {
            this.f7409a = h1Var;
        }

        @Override // jn.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Collection<eo.y> invoke() {
            eq.e eVar = new eq.e();
            Iterator<? extends eo.y> it = p.this.d().iterator();
            while (it.hasNext()) {
                eVar.add(it.next().c(this.f7409a));
            }
            return eVar;
        }
    }

    public static class b implements jn.a<List<j1>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f7411a;

        public b(List list) {
            this.f7411a = list;
        }

        public List<j1> a() {
            return this.f7411a;
        }

        @Override // jn.a
        public List<j1> invoke() {
            return this.f7411a;
        }
    }

    public class c implements eo.y.a<eo.y> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public f1 f7412a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public eo.m f7413b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.l
        public eo.e0 f7414c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @os.l
        public eo.u f7415d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @os.m
        public eo.y f7416e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @os.l
        public eo.b.a f7417f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @os.l
        public List<h1> f7418g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @os.m
        public w0 f7419h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @os.m
        public w0 f7420i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @os.l
        public vp.f0 f7421j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @os.m
        public dp.f f7422k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f7423l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f7424m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f7425n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f7426o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f7427p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public List<e1> f7428q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public fo.g f7429r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public boolean f7430s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public Map<eo.a.InterfaceC0106a<?>, Object> f7431t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public Boolean f7432u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public boolean f7433v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final /* synthetic */ p f7434w;

        public c(@os.l p pVar, @os.l f1 f1Var, @os.l eo.m mVar, @os.l eo.e0 e0Var, @os.l eo.u uVar, @os.l eo.b.a aVar, @os.m List<h1> list, @os.l w0 w0Var, @os.m vp.f0 f0Var, dp.f fVar) {
            if (f1Var == null) {
                u(0);
            }
            if (mVar == null) {
                u(1);
            }
            if (e0Var == null) {
                u(2);
            }
            if (uVar == null) {
                u(3);
            }
            if (aVar == null) {
                u(4);
            }
            if (list == null) {
                u(5);
            }
            if (f0Var == null) {
                u(6);
            }
            this.f7434w = pVar;
            this.f7416e = null;
            this.f7420i = pVar.f7402n;
            this.f7423l = true;
            this.f7424m = false;
            this.f7425n = false;
            this.f7426o = false;
            this.f7427p = pVar.y0();
            this.f7428q = null;
            this.f7429r = null;
            this.f7430s = pVar.A0();
            this.f7431t = new LinkedHashMap();
            this.f7432u = null;
            this.f7433v = false;
            this.f7412a = f1Var;
            this.f7413b = mVar;
            this.f7414c = e0Var;
            this.f7415d = uVar;
            this.f7417f = aVar;
            this.f7418g = list;
            this.f7419h = w0Var;
            this.f7421j = f0Var;
            this.f7422k = fVar;
        }

        public static /* synthetic */ void u(int i10) {
            String str;
            int i11;
            switch (i10) {
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                case 9:
                case 11:
                case 13:
                case 16:
                case 18:
                case 20:
                case 22:
                case 32:
                case 34:
                case 36:
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            switch (i10) {
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    i11 = 2;
                    break;
                case 9:
                case 11:
                case 13:
                case 16:
                case 18:
                case 20:
                case 22:
                case 32:
                case 34:
                case 36:
                default:
                    i11 = 3;
                    break;
            }
            Object[] objArr = new Object[i11];
            switch (i10) {
                case 1:
                    objArr[0] = "newOwner";
                    break;
                case 2:
                    objArr[0] = "newModality";
                    break;
                case 3:
                    objArr[0] = "newVisibility";
                    break;
                case 4:
                case 13:
                    objArr[0] = "kind";
                    break;
                case 5:
                    objArr[0] = "newValueParameterDescriptors";
                    break;
                case 6:
                    objArr[0] = "newReturnType";
                    break;
                case 7:
                    objArr[0] = "owner";
                    break;
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
                    break;
                case 9:
                    objArr[0] = "modality";
                    break;
                case 11:
                    objArr[0] = "visibility";
                    break;
                case 16:
                    objArr[0] = "name";
                    break;
                case 18:
                case 20:
                    objArr[0] = "parameters";
                    break;
                case 22:
                    objArr[0] = y0.a.f8215h;
                    break;
                case 32:
                    objArr[0] = "additionalAnnotations";
                    break;
                case 34:
                default:
                    objArr[0] = "substitution";
                    break;
                case 36:
                    objArr[0] = "userDataKey";
                    break;
            }
            switch (i10) {
                case 8:
                    objArr[1] = "setOwner";
                    break;
                case 9:
                case 11:
                case 13:
                case 16:
                case 18:
                case 20:
                case 22:
                case 32:
                case 34:
                case 36:
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
                    break;
                case 10:
                    objArr[1] = "setModality";
                    break;
                case 12:
                    objArr[1] = "setVisibility";
                    break;
                case 14:
                    objArr[1] = "setKind";
                    break;
                case 15:
                    objArr[1] = "setCopyOverrides";
                    break;
                case 17:
                    objArr[1] = "setName";
                    break;
                case 19:
                    objArr[1] = "setValueParameters";
                    break;
                case 21:
                    objArr[1] = "setTypeParameters";
                    break;
                case 23:
                    objArr[1] = "setReturnType";
                    break;
                case 24:
                    objArr[1] = "setExtensionReceiverParameter";
                    break;
                case 25:
                    objArr[1] = "setDispatchReceiverParameter";
                    break;
                case 26:
                    objArr[1] = "setOriginal";
                    break;
                case 27:
                    objArr[1] = "setSignatureChange";
                    break;
                case 28:
                    objArr[1] = "setPreserveSourceElement";
                    break;
                case 29:
                    objArr[1] = "setDropOriginalInContainingParts";
                    break;
                case 30:
                    objArr[1] = "setHiddenToOvercomeSignatureClash";
                    break;
                case 31:
                    objArr[1] = "setHiddenForResolutionEverywhereBesideSupercalls";
                    break;
                case 33:
                    objArr[1] = "setAdditionalAnnotations";
                    break;
                case 35:
                    objArr[1] = "setSubstitution";
                    break;
                case 37:
                    objArr[1] = "putUserData";
                    break;
                case 38:
                    objArr[1] = "getSubstitution";
                    break;
                case 39:
                    objArr[1] = "setJustForTypeSubstitution";
                    break;
            }
            switch (i10) {
                case 7:
                    objArr[2] = "setOwner";
                    break;
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    break;
                case 9:
                    objArr[2] = "setModality";
                    break;
                case 11:
                    objArr[2] = "setVisibility";
                    break;
                case 13:
                    objArr[2] = "setKind";
                    break;
                case 16:
                    objArr[2] = "setName";
                    break;
                case 18:
                    objArr[2] = "setValueParameters";
                    break;
                case 20:
                    objArr[2] = "setTypeParameters";
                    break;
                case 22:
                    objArr[2] = "setReturnType";
                    break;
                case 32:
                    objArr[2] = "setAdditionalAnnotations";
                    break;
                case 34:
                    objArr[2] = "setSubstitution";
                    break;
                case 36:
                    objArr[2] = "putUserData";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String str2 = String.format(str, objArr);
            switch (i10) {
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    throw new IllegalStateException(str2);
                case 9:
                case 11:
                case 13:
                case 16:
                case 18:
                case 20:
                case 22:
                case 32:
                case 34:
                case 36:
                default:
                    throw new IllegalArgumentException(str2);
            }
        }

        @Override // eo.y.a
        @os.l
        /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
        public c k(@os.l fo.g gVar) {
            if (gVar == null) {
                u(32);
            }
            this.f7429r = gVar;
            return this;
        }

        @Override // eo.y.a
        @os.l
        /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
        public c m(boolean z10) {
            this.f7423l = z10;
            return this;
        }

        @Override // eo.y.a
        @os.l
        /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
        public c g(@os.m w0 w0Var) {
            this.f7420i = w0Var;
            return this;
        }

        @Override // eo.y.a
        @os.l
        /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
        public c a() {
            this.f7426o = true;
            return this;
        }

        @Override // eo.y.a
        @os.l
        /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
        public c j(@os.m w0 w0Var) {
            this.f7419h = w0Var;
            return this;
        }

        public c G(boolean z10) {
            this.f7432u = Boolean.valueOf(z10);
            return this;
        }

        @Override // eo.y.a
        @os.l
        /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
        public c d() {
            this.f7430s = true;
            return this;
        }

        @Override // eo.y.a
        @os.l
        /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
        public c f() {
            this.f7427p = true;
            return this;
        }

        @os.l
        public c J(boolean z10) {
            this.f7433v = z10;
            return this;
        }

        @Override // eo.y.a
        @os.l
        /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
        public c p(@os.l eo.b.a aVar) {
            if (aVar == null) {
                u(13);
            }
            this.f7417f = aVar;
            return this;
        }

        @Override // eo.y.a
        @os.l
        /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
        public c b(@os.l eo.e0 e0Var) {
            if (e0Var == null) {
                u(9);
            }
            this.f7414c = e0Var;
            return this;
        }

        @Override // eo.y.a
        @os.l
        /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
        public c r(@os.l dp.f fVar) {
            if (fVar == null) {
                u(16);
            }
            this.f7422k = fVar;
            return this;
        }

        @Override // eo.y.a
        @os.l
        /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
        public c e(@os.m eo.b bVar) {
            this.f7416e = (eo.y) bVar;
            return this;
        }

        @Override // eo.y.a
        @os.l
        /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
        public c n(@os.l eo.m mVar) {
            if (mVar == null) {
                u(7);
            }
            this.f7413b = mVar;
            return this;
        }

        @Override // eo.y.a
        @os.l
        /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
        public c i() {
            this.f7425n = true;
            return this;
        }

        @Override // eo.y.a
        @os.l
        /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
        public c q(@os.l vp.f0 f0Var) {
            if (f0Var == null) {
                u(22);
            }
            this.f7421j = f0Var;
            return this;
        }

        @Override // eo.y.a
        @os.l
        /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
        public c t() {
            this.f7424m = true;
            return this;
        }

        @Override // eo.y.a
        @os.l
        /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
        public c s(@os.l f1 f1Var) {
            if (f1Var == null) {
                u(34);
            }
            this.f7412a = f1Var;
            return this;
        }

        @Override // eo.y.a
        @os.l
        /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
        public c o(@os.l List<e1> list) {
            if (list == null) {
                u(20);
            }
            this.f7428q = list;
            return this;
        }

        @Override // eo.y.a
        @os.l
        /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
        public c c(@os.l List<h1> list) {
            if (list == null) {
                u(18);
            }
            this.f7418g = list;
            return this;
        }

        @Override // eo.y.a
        @os.l
        /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
        public c l(@os.l eo.u uVar) {
            if (uVar == null) {
                u(11);
            }
            this.f7415d = uVar;
            return this;
        }

        @Override // eo.y.a
        @os.m
        public eo.y build() {
            return this.f7434w.G0(this);
        }

        @Override // eo.y.a
        @os.l
        public <V> eo.y.a<eo.y> h(@os.l eo.a.InterfaceC0106a<V> interfaceC0106a, V v10) {
            if (interfaceC0106a == null) {
                u(36);
            }
            this.f7431t.put(interfaceC0106a, v10);
            return this;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(@os.l eo.m mVar, @os.m eo.y yVar, @os.l fo.g gVar, @os.l dp.f fVar, @os.l eo.b.a aVar, @os.l z0 z0Var) {
        super(mVar, gVar, fVar, z0Var);
        if (mVar == null) {
            B(0);
        }
        if (gVar == null) {
            B(1);
        }
        if (fVar == null) {
            B(2);
        }
        if (aVar == null) {
            B(3);
        }
        if (z0Var == null) {
            B(4);
        }
        this.f7404v = eo.t.f4637i;
        this.f7405w = false;
        this.f7406x = false;
        this.f7407y = false;
        this.f7408z = false;
        this.H = false;
        this.I = false;
        this.J = false;
        this.K = false;
        this.L = false;
        this.M = false;
        this.N = true;
        this.O = false;
        this.P = null;
        this.Q = null;
        this.T = null;
        this.U = null;
        this.R = yVar == null ? this : yVar;
        this.S = aVar;
    }

    private static /* synthetic */ void B(int i10) {
        String str;
        int i11;
        switch (i10) {
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 9:
            case 10:
            case 11:
            case 15:
            case 20:
            case 22:
            case 23:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i10) {
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                i11 = 2;
                break;
            case 9:
            case 10:
            case 11:
            case 15:
            case 20:
            case 22:
            case 23:
            default:
                i11 = 3;
                break;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = "kind";
                break;
            case 4:
                objArr[0] = "source";
                break;
            case 5:
                objArr[0] = "typeParameters";
                break;
            case 6:
            case 26:
            case 28:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 7:
            case 9:
                objArr[0] = "visibility";
                break;
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
                break;
            case 10:
                objArr[0] = "unsubstitutedReturnType";
                break;
            case 11:
                objArr[0] = "extensionReceiverParameter";
                break;
            case 15:
                objArr[0] = "overriddenDescriptors";
                break;
            case 20:
                objArr[0] = "originalSubstitutor";
                break;
            case 22:
            case 27:
            case 29:
                objArr[0] = "substitutor";
                break;
            case 23:
                objArr[0] = "configuration";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i10) {
            case 8:
                objArr[1] = "initialize";
                break;
            case 9:
            case 10:
            case 11:
            case 15:
            case 20:
            case 22:
            case 23:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
                break;
            case 12:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 13:
                objArr[1] = "getModality";
                break;
            case 14:
                objArr[1] = "getVisibility";
                break;
            case 16:
                objArr[1] = "getTypeParameters";
                break;
            case 17:
                objArr[1] = "getValueParameters";
                break;
            case 18:
                objArr[1] = "getOriginal";
                break;
            case 19:
                objArr[1] = "getKind";
                break;
            case 21:
                objArr[1] = "newCopyBuilder";
                break;
            case 24:
                objArr[1] = "copy";
                break;
            case 25:
                objArr[1] = "getSourceToUseForCopy";
                break;
        }
        switch (i10) {
            case 5:
            case 6:
            case 7:
                objArr[2] = "initialize";
                break;
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                break;
            case 9:
                objArr[2] = "setVisibility";
                break;
            case 10:
                objArr[2] = "setReturnType";
                break;
            case 11:
                objArr[2] = "setExtensionReceiverParameter";
                break;
            case 15:
                objArr[2] = "setOverriddenDescriptors";
                break;
            case 20:
                objArr[2] = "substitute";
                break;
            case 22:
                objArr[2] = "newCopyBuilder";
                break;
            case 23:
                objArr[2] = "doSubstitute";
                break;
            case 26:
            case 27:
            case 28:
            case 29:
                objArr[2] = "getSubstitutedValueParameters";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i10) {
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                throw new IllegalStateException(str2);
            case 9:
            case 10:
            case 11:
            case 15:
            case 20:
            case 22:
            case 23:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @os.m
    public static List<h1> I0(eo.y yVar, @os.l List<h1> list, @os.l vp.h1 h1Var) {
        if (list == null) {
            B(26);
        }
        if (h1Var == null) {
            B(27);
        }
        return J0(yVar, list, h1Var, false, false, null);
    }

    @os.m
    public static List<h1> J0(eo.y yVar, @os.l List<h1> list, @os.l vp.h1 h1Var, boolean z10, boolean z11, @os.m boolean[] zArr) {
        if (list == null) {
            B(28);
        }
        if (h1Var == null) {
            B(29);
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (h1 h1Var2 : list) {
            vp.f0 type = h1Var2.getType();
            o1 o1Var = o1.IN_VARIANCE;
            vp.f0 f0VarP = h1Var.p(type, o1Var);
            vp.f0 f0VarS0 = h1Var2.s0();
            vp.f0 f0VarP2 = f0VarS0 == null ? null : h1Var.p(f0VarS0, o1Var);
            if (f0VarP == null) {
                return null;
            }
            if ((f0VarP != h1Var2.getType() || f0VarS0 != f0VarP2) && zArr != null) {
                zArr[0] = true;
            }
            arrayList.add(l0.F0(yVar, z10 ? null : h1Var2, h1Var2.f(), h1Var2.getAnnotations(), h1Var2.getName(), f0VarP, h1Var2.w0(), h1Var2.p0(), h1Var2.n0(), f0VarP2, z11 ? h1Var2.getSource() : z0.f4654a, h1Var2 instanceof l0.b ? new b(((l0.b) h1Var2).I0()) : null));
        }
        return arrayList;
    }

    private void X0(@os.m eo.y yVar) {
        this.T = yVar;
    }

    public <R, D> R A(eo.o<R, D> oVar, D d10) {
        return oVar.m(this, d10);
    }

    @Override // eo.y
    public boolean A0() {
        return this.L;
    }

    public boolean D() {
        return this.H;
    }

    @Override // eo.b
    @os.l
    /* JADX INFO: renamed from: E0 */
    public eo.y h0(eo.m mVar, eo.e0 e0Var, eo.u uVar, eo.b.a aVar, boolean z10) {
        eo.y yVarBuild = w().n(mVar).b(e0Var).l(uVar).p(aVar).m(z10).build();
        if (yVarBuild == null) {
            B(24);
        }
        return yVarBuild;
    }

    @os.l
    public abstract p F0(@os.l eo.m mVar, @os.m eo.y yVar, @os.l eo.b.a aVar, @os.m dp.f fVar, @os.l fo.g gVar, @os.l z0 z0Var);

    @os.m
    public eo.y G0(@os.l c cVar) {
        f0 f0Var;
        w0 w0Var;
        vp.f0 f0VarP;
        if (cVar == null) {
            B(23);
        }
        boolean[] zArr = new boolean[1];
        fo.g gVarA = cVar.f7429r != null ? fo.i.a(getAnnotations(), cVar.f7429r) : getAnnotations();
        eo.m mVar = cVar.f7413b;
        eo.y yVar = cVar.f7416e;
        p pVarF0 = F0(mVar, yVar, cVar.f7417f, cVar.f7422k, gVarA, H0(cVar.f7425n, yVar));
        List<e1> typeParameters = cVar.f7428q;
        if (typeParameters == null) {
            typeParameters = getTypeParameters();
        }
        zArr[0] = zArr[0] | (!typeParameters.isEmpty());
        ArrayList arrayList = new ArrayList(typeParameters.size());
        vp.h1 h1VarC = vp.s.c(typeParameters, cVar.f7412a, pVarF0, arrayList, zArr);
        if (h1VarC == null) {
            return null;
        }
        w0 w0Var2 = cVar.f7419h;
        if (w0Var2 != null) {
            vp.f0 f0VarP2 = h1VarC.p(w0Var2.getType(), o1.IN_VARIANCE);
            if (f0VarP2 == null) {
                return null;
            }
            f0 f0Var2 = new f0(pVarF0, new pp.b(pVarF0, f0VarP2, cVar.f7419h.getValue()), cVar.f7419h.getAnnotations());
            zArr[0] = (f0VarP2 != cVar.f7419h.getType()) | zArr[0];
            f0Var = f0Var2;
        } else {
            f0Var = null;
        }
        w0 w0Var3 = cVar.f7420i;
        if (w0Var3 != null) {
            w0 w0VarC = w0Var3.c(h1VarC);
            if (w0VarC == null) {
                return null;
            }
            zArr[0] = zArr[0] | (w0VarC != cVar.f7420i);
            w0Var = w0VarC;
        } else {
            w0Var = null;
        }
        List<h1> listJ0 = J0(pVarF0, cVar.f7418g, h1VarC, cVar.f7426o, cVar.f7425n, zArr);
        if (listJ0 == null || (f0VarP = h1VarC.p(cVar.f7421j, o1.OUT_VARIANCE)) == null) {
            return null;
        }
        boolean z10 = zArr[0] | (f0VarP != cVar.f7421j);
        zArr[0] = z10;
        if (!z10 && cVar.f7433v) {
            return this;
        }
        pVarF0.L0(f0Var, w0Var, arrayList, listJ0, f0VarP, cVar.f7414c, cVar.f7415d);
        pVarF0.Z0(this.f7405w);
        pVarF0.W0(this.f7406x);
        pVarF0.R0(this.f7407y);
        pVarF0.Y0(this.f7408z);
        pVarF0.c1(this.H);
        pVarF0.b1(this.M);
        pVarF0.Q0(this.I);
        pVarF0.P0(this.J);
        pVarF0.S0(this.N);
        pVarF0.K = cVar.f7427p;
        pVarF0.L = cVar.f7430s;
        Boolean bool = cVar.f7432u;
        pVarF0.T0(bool != null ? bool.booleanValue() : this.O);
        if (!cVar.f7431t.isEmpty() || this.U != null) {
            Map<eo.a.InterfaceC0106a<?>, Object> map = cVar.f7431t;
            Map<eo.a.InterfaceC0106a<?>, Object> map2 = this.U;
            if (map2 != null) {
                for (Map.Entry<eo.a.InterfaceC0106a<?>, Object> entry : map2.entrySet()) {
                    if (!map.containsKey(entry.getKey())) {
                        map.put(entry.getKey(), entry.getValue());
                    }
                }
            }
            if (map.size() == 1) {
                pVarF0.U = Collections.singletonMap(map.keySet().iterator().next(), map.values().iterator().next());
            } else {
                pVarF0.U = map;
            }
        }
        if (cVar.f7424m || q0() != null) {
            pVarF0.T = (q0() != null ? q0() : this).c(h1VarC);
        }
        if (cVar.f7423l && !a().d().isEmpty()) {
            if (cVar.f7412a.f()) {
                jn.a<Collection<eo.y>> aVar = this.Q;
                if (aVar != null) {
                    pVarF0.Q = aVar;
                } else {
                    pVarF0.z0(d());
                }
            } else {
                pVarF0.Q = new a(h1VarC);
            }
        }
        return pVarF0;
    }

    @os.l
    public final z0 H0(boolean z10, @os.m eo.y yVar) {
        z0 source;
        if (z10) {
            if (yVar == null) {
                yVar = a();
            }
            source = yVar.getSource();
        } else {
            source = z0.f4654a;
        }
        if (source == null) {
            B(25);
        }
        return source;
    }

    public boolean K0() {
        return this.N;
    }

    @os.l
    public p L0(@os.m w0 w0Var, @os.m w0 w0Var2, @os.l List<? extends e1> list, @os.l List<h1> list2, @os.m vp.f0 f0Var, @os.m eo.e0 e0Var, @os.l eo.u uVar) {
        if (list == null) {
            B(5);
        }
        if (list2 == null) {
            B(6);
        }
        if (uVar == null) {
            B(7);
        }
        this.f7398e = nm.h0.V5(list);
        this.f7399f = nm.h0.V5(list2);
        this.f7400g = f0Var;
        this.f7403p = e0Var;
        this.f7404v = uVar;
        this.f7401i = w0Var;
        this.f7402n = w0Var2;
        for (int i10 = 0; i10 < list.size(); i10++) {
            e1 e1Var = list.get(i10);
            if (e1Var.f() != i10) {
                throw new IllegalStateException(e1Var + " index is " + e1Var.f() + " but position is " + i10);
            }
        }
        for (int i11 = 0; i11 < list2.size(); i11++) {
            h1 h1Var = list2.get(i11);
            if (h1Var.f() != i11) {
                throw new IllegalStateException(h1Var + "index is " + h1Var.f() + " but position is " + i11);
            }
        }
        return this;
    }

    @os.l
    public c M0(@os.l vp.h1 h1Var) {
        if (h1Var == null) {
            B(22);
        }
        return new c(this, h1Var.j(), b(), s(), getVisibility(), getKind(), h(), R(), getReturnType(), null);
    }

    public final void N0() {
        jn.a<Collection<eo.y>> aVar = this.Q;
        if (aVar != null) {
            this.P = aVar.invoke();
            this.Q = null;
        }
    }

    @Override // eo.a
    @os.m
    public w0 O() {
        return this.f7402n;
    }

    public <V> void O0(eo.a.InterfaceC0106a<V> interfaceC0106a, Object obj) {
        if (this.U == null) {
            this.U = new LinkedHashMap();
        }
        this.U.put(interfaceC0106a, obj);
    }

    public void P0(boolean z10) {
        this.J = z10;
    }

    public void Q0(boolean z10) {
        this.I = z10;
    }

    @Override // eo.a
    @os.m
    public w0 R() {
        return this.f7401i;
    }

    public void R0(boolean z10) {
        this.f7407y = z10;
    }

    public void S0(boolean z10) {
        this.N = z10;
    }

    public void T0(boolean z10) {
        this.O = z10;
    }

    public final void U0(boolean z10) {
        this.L = z10;
    }

    public final void V0(boolean z10) {
        this.K = z10;
    }

    public void W0(boolean z10) {
        this.f7406x = z10;
    }

    @Override // eo.d0
    public boolean Y() {
        return this.J;
    }

    public void Y0(boolean z10) {
        this.f7408z = z10;
    }

    public void Z0(boolean z10) {
        this.f7405w = z10;
    }

    public void a1(@os.l vp.f0 f0Var) {
        if (f0Var == null) {
            B(10);
        }
        this.f7400g = f0Var;
    }

    public void b1(boolean z10) {
        this.M = z10;
    }

    public void c1(boolean z10) {
        this.H = z10;
    }

    @os.l
    public Collection<? extends eo.y> d() {
        N0();
        Collection<? extends eo.y> collectionEmptyList = this.P;
        if (collectionEmptyList == null) {
            collectionEmptyList = Collections.emptyList();
        }
        if (collectionEmptyList == null) {
            B(12);
        }
        return collectionEmptyList;
    }

    public void d1(@os.l eo.u uVar) {
        if (uVar == null) {
            B(9);
        }
        this.f7404v = uVar;
    }

    @Override // eo.a
    public boolean e0() {
        return this.O;
    }

    @Override // eo.b
    @os.l
    public eo.b.a getKind() {
        eo.b.a aVar = this.S;
        if (aVar == null) {
            B(19);
        }
        return aVar;
    }

    public vp.f0 getReturnType() {
        return this.f7400g;
    }

    @Override // eo.a
    @os.l
    public List<e1> getTypeParameters() {
        List<e1> list = this.f7398e;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException("typeParameters == null for " + this);
    }

    @Override // eo.q, eo.d0
    @os.l
    public eo.u getVisibility() {
        eo.u uVar = this.f7404v;
        if (uVar == null) {
            B(14);
        }
        return uVar;
    }

    @Override // eo.a
    @os.l
    public List<h1> h() {
        List<h1> list = this.f7399f;
        if (list == null) {
            B(17);
        }
        return list;
    }

    @Override // eo.d0
    public boolean i0() {
        return this.I;
    }

    public boolean isExternal() {
        return this.f7407y;
    }

    @Override // eo.y
    public boolean isInfix() {
        if (this.f7406x) {
            return true;
        }
        Iterator<? extends eo.y> it = a().d().iterator();
        while (it.hasNext()) {
            if (it.next().isInfix()) {
                return true;
            }
        }
        return false;
    }

    public boolean isInline() {
        return this.f7408z;
    }

    @Override // eo.y
    public boolean isOperator() {
        if (this.f7405w) {
            return true;
        }
        Iterator<? extends eo.y> it = a().d().iterator();
        while (it.hasNext()) {
            if (it.next().isOperator()) {
                return true;
            }
        }
        return false;
    }

    @Override // eo.y
    public boolean isSuspend() {
        return this.M;
    }

    @Override // eo.a
    public <V> V j0(eo.a.InterfaceC0106a<V> interfaceC0106a) {
        Map<eo.a.InterfaceC0106a<?>, Object> map = this.U;
        if (map == null) {
            return null;
        }
        return (V) map.get(interfaceC0106a);
    }

    @Override // eo.y
    @os.m
    public eo.y q0() {
        return this.T;
    }

    @Override // eo.d0
    @os.l
    public eo.e0 s() {
        eo.e0 e0Var = this.f7403p;
        if (e0Var == null) {
            B(13);
        }
        return e0Var;
    }

    @os.l
    public eo.y.a<? extends eo.y> w() {
        c cVarM0 = M0(vp.h1.f17703b);
        if (cVarM0 == null) {
            B(21);
        }
        return cVarM0;
    }

    @Override // eo.y
    public boolean y0() {
        return this.K;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void z0(@os.l Collection<? extends eo.b> collection) {
        if (collection == 0) {
            B(15);
        }
        this.P = collection;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (((eo.y) it.next()).A0()) {
                this.L = true;
                return;
            }
        }
    }

    @Override // eo.y, eo.b1
    public eo.y c(@os.l vp.h1 h1Var) {
        if (h1Var == null) {
            B(20);
        }
        return h1Var.k() ? this : M0(h1Var).e(a()).i().J(true).build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [eo.y] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    @Override // ho.k
    @os.l
    public eo.y a() {
        eo.y yVarA;
        eo.y yVar = this.R;
        ?? r10 = this;
        if (yVar != this) {
            yVarA = yVar.a();
        }
        if (r10 == 0) {
            r10 = yVarA;
            B(18);
        }
        r10 = yVarA;
        return r10;
    }
}
