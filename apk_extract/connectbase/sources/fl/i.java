package fl;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements WildcardType {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final un.u f6051a;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6052a;

        static {
            int[] iArr = new int[un.v.values().length];
            iArr[un.v.OUT.ordinal()] = 1;
            iArr[un.v.IN.ordinal()] = 2;
            f6052a = iArr;
        }
    }

    public i(@os.l un.u uVar) {
        kn.l0.p(uVar, ik.y0.a.f8215h);
        this.f6051a = uVar;
    }

    @os.l
    public final un.u a() {
        return this.f6051a;
    }

    @Override // java.lang.reflect.WildcardType
    @os.l
    public Type[] getLowerBounds() {
        un.v vVar = this.f6051a.f16348a;
        int i10 = vVar == null ? -1 : a.f6052a[vVar.ordinal()];
        if (i10 == -1 || i10 == 1) {
            return new Type[]{Object.class};
        }
        un.s sVar = this.f6051a.f16349b;
        kn.l0.m(sVar);
        return new Type[]{l1.a(sVar)};
    }

    @Override // java.lang.reflect.WildcardType
    @os.l
    public Type[] getUpperBounds() {
        un.v vVar = this.f6051a.f16348a;
        int i10 = vVar == null ? -1 : a.f6052a[vVar.ordinal()];
        if (i10 == -1 || i10 == 2) {
            return new Type[]{Object.class};
        }
        un.s sVar = this.f6051a.f16349b;
        kn.l0.m(sVar);
        return new Type[]{l1.a(sVar)};
    }
}
