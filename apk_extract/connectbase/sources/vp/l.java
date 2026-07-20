package vp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class l extends b implements a1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final eo.e f17718d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<eo.e1> f17719e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Collection<f0> f17720f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(@os.l eo.e eVar, @os.l List<? extends eo.e1> list, @os.l Collection<f0> collection, @os.l up.n nVar) {
        super(nVar);
        if (eVar == null) {
            u(0);
        }
        if (list == null) {
            u(1);
        }
        if (collection == null) {
            u(2);
        }
        if (nVar == null) {
            u(3);
        }
        this.f17718d = eVar;
        this.f17719e = Collections.unmodifiableList(new ArrayList(list));
        this.f17720f = Collections.unmodifiableCollection(collection);
    }

    public static /* synthetic */ void u(int i10) {
        String str = (i10 == 4 || i10 == 5 || i10 == 6 || i10 == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 4 || i10 == 5 || i10 == 6 || i10 == 7) ? 2 : 3];
        switch (i10) {
            case 1:
                objArr[0] = "parameters";
                break;
            case 2:
                objArr[0] = "supertypes";
                break;
            case 3:
                objArr[0] = "storageManager";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl";
                break;
            default:
                objArr[0] = "classDescriptor";
                break;
        }
        if (i10 == 4) {
            objArr[1] = "getParameters";
        } else if (i10 == 5) {
            objArr[1] = "getDeclarationDescriptor";
        } else if (i10 == 6) {
            objArr[1] = "computeSupertypes";
        } else if (i10 != 7) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl";
        } else {
            objArr[1] = "getSupertypeLoopChecker";
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

    @Override // vp.a1
    public boolean e() {
        return true;
    }

    @Override // vp.a1
    @os.l
    public List<eo.e1> getParameters() {
        List<eo.e1> list = this.f17719e;
        if (list == null) {
            u(4);
        }
        return list;
    }

    @Override // vp.h
    @os.l
    public Collection<f0> k() {
        Collection<f0> collection = this.f17720f;
        if (collection == null) {
            u(6);
        }
        return collection;
    }

    @Override // vp.h
    @os.l
    public eo.c1 p() {
        eo.c1.a aVar = eo.c1.a.f4596a;
        if (aVar == null) {
            u(7);
        }
        return aVar;
    }

    public String toString() {
        return hp.d.m(this.f17718d).b();
    }

    @Override // vp.b, vp.m, vp.a1
    @os.l
    /* JADX INFO: renamed from: v */
    public eo.e d() {
        eo.e eVar = this.f17718d;
        if (eVar == null) {
            u(5);
        }
        return eVar;
    }
}
