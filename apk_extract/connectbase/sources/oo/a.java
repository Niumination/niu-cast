package oo;

import eo.h1;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import jn.l;
import lm.l2;
import os.m;
import rp.q;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: oo.a$a, reason: collision with other inner class name */
    public static class C0314a extends hp.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q f12327a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Set f12328b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f12329c;

        /* JADX INFO: renamed from: oo.a$a$a, reason: collision with other inner class name */
        public class C0315a implements l<eo.b, l2> {
            public C0315a() {
            }

            private static /* synthetic */ void a(int i10) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1$1", "invoke"));
            }

            @Override // jn.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public l2 invoke(@os.l eo.b bVar) {
                if (bVar == null) {
                    a(0);
                }
                C0314a.this.f12327a.b(bVar);
                return l2.f10208a;
            }
        }

        public C0314a(q qVar, Set set, boolean z10) {
            this.f12327a = qVar;
            this.f12328b = set;
            this.f12329c = z10;
        }

        private static /* synthetic */ void f(int i10) {
            Object[] objArr = new Object[3];
            if (i10 == 1) {
                objArr[0] = "fromSuper";
            } else if (i10 == 2) {
                objArr[0] = "fromCurrent";
            } else if (i10 == 3) {
                objArr[0] = "member";
            } else if (i10 != 4) {
                objArr[0] = "fakeOverride";
            } else {
                objArr[0] = "overridden";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1";
            if (i10 == 1 || i10 == 2) {
                objArr[2] = "conflict";
            } else if (i10 == 3 || i10 == 4) {
                objArr[2] = "setOverriddenDescriptors";
            } else {
                objArr[2] = "addFakeOverride";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // hp.i
        public void a(@os.l eo.b bVar) {
            if (bVar == null) {
                f(0);
            }
            hp.j.L(bVar, new C0315a());
            this.f12328b.add(bVar);
        }

        @Override // hp.i
        public void d(@os.l eo.b bVar, @os.l Collection<? extends eo.b> collection) {
            if (bVar == null) {
                f(3);
            }
            if (collection == null) {
                f(4);
            }
            if (!this.f12329c || bVar.getKind() == eo.b.a.FAKE_OVERRIDE) {
                super.d(bVar, collection);
            }
        }

        @Override // hp.h
        public void e(@os.l eo.b bVar, @os.l eo.b bVar2) {
            if (bVar == null) {
                f(1);
            }
            if (bVar2 == null) {
                f(2);
            }
        }
    }

    public static /* synthetic */ void a(int i10) {
        String str = i10 != 18 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i10 != 18 ? 3 : 2];
        switch (i10) {
            case 1:
            case 7:
            case 13:
                objArr[0] = "membersFromSupertypes";
                break;
            case 2:
            case 8:
            case 14:
                objArr[0] = "membersFromCurrent";
                break;
            case 3:
            case 9:
            case 15:
                objArr[0] = "classDescriptor";
                break;
            case 4:
            case 10:
            case 16:
                objArr[0] = "errorReporter";
                break;
            case 5:
            case 11:
            case 17:
                objArr[0] = "overridingUtil";
                break;
            case 6:
            case 12:
            case 19:
            default:
                objArr[0] = "name";
                break;
            case 18:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
                break;
            case 20:
                objArr[0] = "annotationClass";
                break;
        }
        if (i10 != 18) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
        } else {
            objArr[1] = "resolveOverrides";
        }
        switch (i10) {
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                objArr[2] = "resolveOverridesForStaticMembers";
                break;
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
                objArr[2] = "resolveOverrides";
                break;
            case 18:
                break;
            case 19:
            case 20:
                objArr[2] = "getAnnotationParameterByName";
                break;
            default:
                objArr[2] = "resolveOverridesForNonStaticMembers";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i10 == 18) {
            throw new IllegalStateException(str2);
        }
    }

    @m
    public static h1 b(@os.l dp.f fVar, @os.l eo.e eVar) {
        if (fVar == null) {
            a(19);
        }
        if (eVar == null) {
            a(20);
        }
        Collection<eo.d> collectionG = eVar.g();
        if (collectionG.size() != 1) {
            return null;
        }
        for (h1 h1Var : collectionG.iterator().next().h()) {
            if (h1Var.getName().equals(fVar)) {
                return h1Var;
            }
        }
        return null;
    }

    @os.l
    public static <D extends eo.b> Collection<D> c(@os.l dp.f fVar, @os.l Collection<D> collection, @os.l Collection<D> collection2, @os.l eo.e eVar, @os.l q qVar, @os.l hp.j jVar, boolean z10) {
        if (fVar == null) {
            a(12);
        }
        if (collection == null) {
            a(13);
        }
        if (collection2 == null) {
            a(14);
        }
        if (eVar == null) {
            a(15);
        }
        if (qVar == null) {
            a(16);
        }
        if (jVar == null) {
            a(17);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        jVar.w(fVar, collection, collection2, eVar, new C0314a(qVar, linkedHashSet, z10));
        return linkedHashSet;
    }

    @os.l
    public static <D extends eo.b> Collection<D> d(@os.l dp.f fVar, @os.l Collection<D> collection, @os.l Collection<D> collection2, @os.l eo.e eVar, @os.l q qVar, @os.l hp.j jVar) {
        if (fVar == null) {
            a(0);
        }
        if (collection == null) {
            a(1);
        }
        if (collection2 == null) {
            a(2);
        }
        if (eVar == null) {
            a(3);
        }
        if (qVar == null) {
            a(4);
        }
        if (jVar == null) {
            a(5);
        }
        return c(fVar, collection, collection2, eVar, qVar, jVar, false);
    }

    @os.l
    public static <D extends eo.b> Collection<D> e(@os.l dp.f fVar, @os.l Collection<D> collection, @os.l Collection<D> collection2, @os.l eo.e eVar, @os.l q qVar, @os.l hp.j jVar) {
        if (fVar == null) {
            a(6);
        }
        if (collection == null) {
            a(7);
        }
        if (collection2 == null) {
            a(8);
        }
        if (eVar == null) {
            a(9);
        }
        if (qVar == null) {
            a(10);
        }
        if (jVar == null) {
            a(11);
        }
        return c(fVar, collection, collection2, eVar, qVar, jVar, true);
    }
}
