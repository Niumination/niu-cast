package xp;

import dp.f;
import eo.b;
import eo.e;
import eo.e0;
import eo.e1;
import eo.h1;
import eo.u;
import eo.w0;
import eo.y;
import eo.y0;
import eo.z0;
import fo.g;
import ho.g0;
import ho.p;
import java.util.Collection;
import java.util.List;
import os.l;
import os.m;
import vp.f0;
import vp.f1;
import vp.x;

/* JADX INFO: loaded from: classes3.dex */
public class a extends g0 {
    public final x.d V;

    /* JADX INFO: renamed from: xp.a$a, reason: collision with other inner class name */
    public class C0533a implements y.a<y0> {
        public C0533a() {
        }

        /* JADX WARN: Code duplicated, block: B:16:0x0030  */
        private static /* synthetic */ void u(int i10) {
            String str;
            int i11;
            if (i10 != 1 && i10 != 3 && i10 != 5 && i10 != 10 && i10 != 12 && i10 != 14 && i10 != 16 && i10 != 18 && i10 != 30 && i10 != 7 && i10 != 8) {
                switch (i10) {
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                        str = "@NotNull method %s.%s must not return null";
                        break;
                    default:
                        str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                        break;
                }
            } else {
                str = "@NotNull method %s.%s must not return null";
            }
            if (i10 != 1 && i10 != 3 && i10 != 5 && i10 != 10 && i10 != 12 && i10 != 14 && i10 != 16 && i10 != 18 && i10 != 30 && i10 != 7 && i10 != 8) {
                switch (i10) {
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
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
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                case 14:
                case 16:
                case 18:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 30:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1";
                    break;
                case 2:
                    objArr[0] = "modality";
                    break;
                case 4:
                    objArr[0] = "visibility";
                    break;
                case 6:
                    objArr[0] = "kind";
                    break;
                case 9:
                    objArr[0] = "name";
                    break;
                case 11:
                case 17:
                    objArr[0] = "parameters";
                    break;
                case 13:
                    objArr[0] = "substitution";
                    break;
                case 15:
                    objArr[0] = "userDataKey";
                    break;
                case 19:
                    objArr[0] = ik.y0.a.f8215h;
                    break;
                case 29:
                    objArr[0] = "additionalAnnotations";
                    break;
                default:
                    objArr[0] = "owner";
                    break;
            }
            if (i10 == 1) {
                objArr[1] = "setOwner";
            } else if (i10 == 3) {
                objArr[1] = "setModality";
            } else if (i10 == 5) {
                objArr[1] = "setVisibility";
            } else if (i10 == 10) {
                objArr[1] = "setName";
            } else if (i10 == 12) {
                objArr[1] = "setValueParameters";
            } else if (i10 == 14) {
                objArr[1] = "setSubstitution";
            } else if (i10 == 16) {
                objArr[1] = "putUserData";
            } else if (i10 == 18) {
                objArr[1] = "setTypeParameters";
            } else if (i10 == 30) {
                objArr[1] = "setAdditionalAnnotations";
            } else if (i10 == 7) {
                objArr[1] = "setKind";
            } else if (i10 != 8) {
                switch (i10) {
                    case 20:
                        objArr[1] = "setReturnType";
                        break;
                    case 21:
                        objArr[1] = "setExtensionReceiverParameter";
                        break;
                    case 22:
                        objArr[1] = "setDispatchReceiverParameter";
                        break;
                    case 23:
                        objArr[1] = "setOriginal";
                        break;
                    case 24:
                        objArr[1] = "setSignatureChange";
                        break;
                    case 25:
                        objArr[1] = "setPreserveSourceElement";
                        break;
                    case 26:
                        objArr[1] = "setDropOriginalInContainingParts";
                        break;
                    case 27:
                        objArr[1] = "setHiddenToOvercomeSignatureClash";
                        break;
                    case 28:
                        objArr[1] = "setHiddenForResolutionEverywhereBesideSupercalls";
                        break;
                    default:
                        objArr[1] = "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1";
                        break;
                }
            } else {
                objArr[1] = "setCopyOverrides";
            }
            switch (i10) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                case 14:
                case 16:
                case 18:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 30:
                    break;
                case 2:
                    objArr[2] = "setModality";
                    break;
                case 4:
                    objArr[2] = "setVisibility";
                    break;
                case 6:
                    objArr[2] = "setKind";
                    break;
                case 9:
                    objArr[2] = "setName";
                    break;
                case 11:
                    objArr[2] = "setValueParameters";
                    break;
                case 13:
                    objArr[2] = "setSubstitution";
                    break;
                case 15:
                    objArr[2] = "putUserData";
                    break;
                case 17:
                    objArr[2] = "setTypeParameters";
                    break;
                case 19:
                    objArr[2] = "setReturnType";
                    break;
                case 29:
                    objArr[2] = "setAdditionalAnnotations";
                    break;
                default:
                    objArr[2] = "setOwner";
                    break;
            }
            String str2 = String.format(str, objArr);
            if (i10 != 1 && i10 != 3 && i10 != 5 && i10 != 10 && i10 != 12 && i10 != 14 && i10 != 16 && i10 != 18 && i10 != 30 && i10 != 7 && i10 != 8) {
                switch (i10) {
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                        break;
                    default:
                        throw new IllegalArgumentException(str2);
                }
            }
            throw new IllegalStateException(str2);
        }

        @Override // eo.y.a
        @l
        public y.a<y0> a() {
            return this;
        }

        @Override // eo.y.a
        @l
        public y.a<y0> b(@l e0 e0Var) {
            if (e0Var == null) {
                u(2);
            }
            return this;
        }

        @Override // eo.y.a
        @l
        public y.a<y0> c(@l List<h1> list) {
            if (list == null) {
                u(11);
            }
            return this;
        }

        @Override // eo.y.a
        @l
        public y.a<y0> d() {
            return this;
        }

        @Override // eo.y.a
        @l
        public y.a<y0> e(@m b bVar) {
            return this;
        }

        @Override // eo.y.a
        @l
        public y.a<y0> f() {
            return this;
        }

        @Override // eo.y.a
        @l
        public y.a<y0> g(@m w0 w0Var) {
            return this;
        }

        @Override // eo.y.a
        @l
        public <V> y.a<y0> h(@l eo.a.InterfaceC0106a<V> interfaceC0106a, V v10) {
            if (interfaceC0106a == null) {
                u(15);
            }
            return this;
        }

        @Override // eo.y.a
        @l
        public y.a<y0> i() {
            return this;
        }

        @Override // eo.y.a
        @l
        public y.a<y0> j(@m w0 w0Var) {
            return this;
        }

        @Override // eo.y.a
        @l
        public y.a<y0> k(@l g gVar) {
            if (gVar == null) {
                u(29);
            }
            return this;
        }

        @Override // eo.y.a
        @l
        public y.a<y0> l(@l u uVar) {
            if (uVar == null) {
                u(4);
            }
            return this;
        }

        @Override // eo.y.a
        @l
        public y.a<y0> m(boolean z10) {
            return this;
        }

        @Override // eo.y.a
        @l
        public y.a<y0> n(@l eo.m mVar) {
            if (mVar == null) {
                u(0);
            }
            return this;
        }

        @Override // eo.y.a
        @l
        public y.a<y0> o(@l List<e1> list) {
            if (list == null) {
                u(17);
            }
            return this;
        }

        @Override // eo.y.a
        @l
        public y.a<y0> p(@l b.a aVar) {
            if (aVar == null) {
                u(6);
            }
            return this;
        }

        @Override // eo.y.a
        @l
        public y.a<y0> q(@l f0 f0Var) {
            if (f0Var == null) {
                u(19);
            }
            return this;
        }

        @Override // eo.y.a
        @l
        public y.a<y0> r(@l f fVar) {
            if (fVar == null) {
                u(9);
            }
            return this;
        }

        @Override // eo.y.a
        @l
        public y.a<y0> s(@l f1 f1Var) {
            if (f1Var == null) {
                u(13);
            }
            return this;
        }

        @Override // eo.y.a
        @l
        public y.a<y0> t() {
            return this;
        }

        @Override // eo.y.a
        @m
        /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
        public y0 build() {
            return a.this;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@l e eVar, @l x.d dVar) {
        super(eVar, null, g.a.f6169b, f.n("<ERROR FUNCTION>"), b.a.DECLARATION, z0.f4654a);
        if (eVar == null) {
            B(0);
        }
        if (dVar == null) {
            B(1);
        }
        g.f6167h.getClass();
        this.V = dVar;
    }

    private static /* synthetic */ void B(int i10) {
        String str = (i10 == 6 || i10 == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 6 || i10 == 7) ? 2 : 3];
        switch (i10) {
            case 1:
                objArr[0] = "ownerScope";
                break;
            case 2:
                objArr[0] = "newOwner";
                break;
            case 3:
                objArr[0] = "kind";
                break;
            case 4:
                objArr[0] = "annotations";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl";
                break;
            case 8:
                objArr[0] = "overriddenDescriptors";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        if (i10 == 6) {
            objArr[1] = "createSubstitutedCopy";
        } else if (i10 != 7) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl";
        } else {
            objArr[1] = "copy";
        }
        switch (i10) {
            case 2:
            case 3:
            case 4:
            case 5:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 6:
            case 7:
                break;
            case 8:
                objArr[2] = "setOverriddenDescriptors";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i10 != 6 && i10 != 7) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // ho.g0, ho.p
    @l
    public p F0(@l eo.m mVar, @m y yVar, @l b.a aVar, @m f fVar, @l g gVar, @l z0 z0Var) {
        if (mVar == null) {
            B(2);
        }
        if (aVar == null) {
            B(3);
        }
        if (gVar == null) {
            B(4);
        }
        if (z0Var == null) {
            B(5);
        }
        return this;
    }

    @Override // ho.g0, ho.p, eo.b
    @l
    /* JADX INFO: renamed from: e1 */
    public y0 h0(eo.m mVar, e0 e0Var, u uVar, b.a aVar, boolean z10) {
        return this;
    }

    @Override // ho.p, eo.y
    public boolean isSuspend() {
        return false;
    }

    @Override // ho.p, eo.a
    public <V> V j0(eo.a.InterfaceC0106a<V> interfaceC0106a) {
        return null;
    }

    @Override // ho.g0, ho.p, eo.y
    @l
    public y.a<? extends y0> w() {
        return new C0533a();
    }

    @Override // ho.p, eo.b
    public void z0(@l Collection<? extends b> collection) {
        if (collection == null) {
            B(8);
        }
    }
}
