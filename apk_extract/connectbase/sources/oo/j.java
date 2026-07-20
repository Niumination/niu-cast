package oo;

import eo.e1;
import eo.h1;
import java.util.Collections;
import java.util.List;
import os.l;
import os.m;
import uo.r;
import vp.f0;

/* JADX INFO: loaded from: classes3.dex */
public interface j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f12354a = new a();

    public static class a implements j {
        public static /* synthetic */ void c(int i10) {
            Object[] objArr = new Object[3];
            switch (i10) {
                case 1:
                    objArr[0] = "owner";
                    break;
                case 2:
                    objArr[0] = "returnType";
                    break;
                case 3:
                    objArr[0] = "valueParameters";
                    break;
                case 4:
                    objArr[0] = "typeParameters";
                    break;
                case 5:
                    objArr[0] = "descriptor";
                    break;
                case 6:
                    objArr[0] = "signatureErrors";
                    break;
                default:
                    objArr[0] = "method";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$1";
            if (i10 == 5 || i10 == 6) {
                objArr[2] = "reportSignatureErrors";
            } else {
                objArr[2] = "resolvePropagatedSignature";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // oo.j
        public void a(@l eo.b bVar, @l List<String> list) {
            if (bVar == null) {
                c(5);
            }
            if (list == null) {
                c(6);
            }
            throw new UnsupportedOperationException("Should not be called");
        }

        @Override // oo.j
        @l
        public b b(@l r rVar, @l eo.e eVar, @l f0 f0Var, @m f0 f0Var2, @l List<h1> list, @l List<e1> list2) {
            if (rVar == null) {
                c(0);
            }
            if (eVar == null) {
                c(1);
            }
            if (f0Var == null) {
                c(2);
            }
            if (list == null) {
                c(3);
            }
            if (list2 == null) {
                c(4);
            }
            return new b(f0Var, f0Var2, list, list2, Collections.emptyList(), false);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f0 f12355a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final f0 f12356b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<h1> f12357c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<e1> f12358d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List<String> f12359e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f12360f;

        public b(@l f0 f0Var, @m f0 f0Var2, @l List<h1> list, @l List<e1> list2, @l List<String> list3, boolean z10) {
            if (f0Var == null) {
                a(0);
            }
            if (list == null) {
                a(1);
            }
            if (list2 == null) {
                a(2);
            }
            if (list3 == null) {
                a(3);
            }
            this.f12355a = f0Var;
            this.f12356b = f0Var2;
            this.f12357c = list;
            this.f12358d = list2;
            this.f12359e = list3;
            this.f12360f = z10;
        }

        public static /* synthetic */ void a(int i10) {
            String str = (i10 == 4 || i10 == 5 || i10 == 6 || i10 == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i10 == 4 || i10 == 5 || i10 == 6 || i10 == 7) ? 2 : 3];
            switch (i10) {
                case 1:
                    objArr[0] = "valueParameters";
                    break;
                case 2:
                    objArr[0] = "typeParameters";
                    break;
                case 3:
                    objArr[0] = "signatureErrors";
                    break;
                case 4:
                case 5:
                case 6:
                case 7:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature";
                    break;
                default:
                    objArr[0] = "returnType";
                    break;
            }
            if (i10 == 4) {
                objArr[1] = "getReturnType";
            } else if (i10 == 5) {
                objArr[1] = "getValueParameters";
            } else if (i10 == 6) {
                objArr[1] = "getTypeParameters";
            } else if (i10 != 7) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature";
            } else {
                objArr[1] = "getErrors";
            }
            if (i10 != 4 && i10 != 5 && i10 != 6 && i10 != 7) {
                objArr[2] = "<init>";
            }
            String str2 = String.format(str, objArr);
            if (i10 != 4 && i10 != 5 && i10 != 6 && i10 != 7) {
                throw new IllegalArgumentException(str2);
            }
            throw new IllegalStateException(str2);
        }

        @l
        public List<String> b() {
            List<String> list = this.f12359e;
            if (list == null) {
                a(7);
            }
            return list;
        }

        @m
        public f0 c() {
            return this.f12356b;
        }

        @l
        public f0 d() {
            f0 f0Var = this.f12355a;
            if (f0Var == null) {
                a(4);
            }
            return f0Var;
        }

        @l
        public List<e1> e() {
            List<e1> list = this.f12358d;
            if (list == null) {
                a(6);
            }
            return list;
        }

        @l
        public List<h1> f() {
            List<h1> list = this.f12357c;
            if (list == null) {
                a(5);
            }
            return list;
        }

        public boolean g() {
            return this.f12360f;
        }
    }

    void a(@l eo.b bVar, @l List<String> list);

    @l
    b b(@l r rVar, @l eo.e eVar, @l f0 f0Var, @m f0 f0Var2, @l List<h1> list, @l List<e1> list2);
}
