package oo;

import eo.t0;
import eo.y0;
import os.l;
import os.m;
import uo.n;
import uo.q;

/* JADX INFO: loaded from: classes3.dex */
public interface g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f12349a = new a();

    public static class a implements g {
        public static /* synthetic */ void f(int i10) {
            Object[] objArr = new Object[3];
            switch (i10) {
                case 1:
                    objArr[0] = "member";
                    break;
                case 2:
                case 4:
                case 6:
                case 8:
                    objArr[0] = "descriptor";
                    break;
                case 3:
                    objArr[0] = "element";
                    break;
                case 5:
                    objArr[0] = "field";
                    break;
                case 7:
                    objArr[0] = "javaClass";
                    break;
                default:
                    objArr[0] = "fqName";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/JavaResolverCache$1";
            switch (i10) {
                case 1:
                case 2:
                    objArr[2] = "recordMethod";
                    break;
                case 3:
                case 4:
                    objArr[2] = "recordConstructor";
                    break;
                case 5:
                case 6:
                    objArr[2] = "recordField";
                    break;
                case 7:
                case 8:
                    objArr[2] = "recordClass";
                    break;
                default:
                    objArr[2] = "getClassResolvedFromSource";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // oo.g
        public void a(@l n nVar, @l t0 t0Var) {
            if (nVar == null) {
                f(5);
            }
            if (t0Var == null) {
                f(6);
            }
        }

        @Override // oo.g
        public void b(@l q qVar, @l y0 y0Var) {
            if (qVar == null) {
                f(1);
            }
            if (y0Var == null) {
                f(2);
            }
        }

        @Override // oo.g
        public void c(@l uo.g gVar, @l eo.e eVar) {
            if (gVar == null) {
                f(7);
            }
            if (eVar == null) {
                f(8);
            }
        }

        @Override // oo.g
        @m
        public eo.e d(@l dp.c cVar) {
            if (cVar != null) {
                return null;
            }
            f(0);
            return null;
        }

        @Override // oo.g
        public void e(@l uo.l lVar, @l eo.l lVar2) {
            if (lVar == null) {
                f(3);
            }
            if (lVar2 == null) {
                f(4);
            }
        }
    }

    void a(@l n nVar, @l t0 t0Var);

    void b(@l q qVar, @l y0 y0Var);

    void c(@l uo.g gVar, @l eo.e eVar);

    @m
    eo.e d(@l dp.c cVar);

    void e(@l uo.l lVar, @l eo.l lVar2);
}
