package fl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class u0 implements ParameterizedType {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final un.s f6104a;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6105a;

        static {
            int[] iArr = new int[un.v.values().length];
            iArr[un.v.IN.ordinal()] = 1;
            iArr[un.v.OUT.ordinal()] = 2;
            f6105a = iArr;
        }
    }

    public u0(@os.l un.s sVar) {
        kn.l0.p(sVar, ik.y0.a.f8215h);
        this.f6104a = sVar;
    }

    @os.l
    public final un.s a() {
        return this.f6104a;
    }

    @Override // java.lang.reflect.ParameterizedType
    @os.l
    public Type[] getActualTypeArguments() {
        Type iVar;
        List<un.u> listN = this.f6104a.n();
        ArrayList arrayList = new ArrayList(nm.z.b0(listN, 10));
        for (un.u uVar : listN) {
            un.v vVar = uVar.f16348a;
            int i10 = vVar == null ? -1 : a.f6105a[vVar.ordinal()];
            if (i10 == -1 || i10 == 1 || i10 == 2) {
                iVar = new i(uVar);
            } else {
                un.s sVar = uVar.f16349b;
                kn.l0.m(sVar);
                iVar = l1.a(sVar);
            }
            arrayList.add(iVar);
        }
        Object[] array = arrayList.toArray(new Type[0]);
        if (array != null) {
            return (Type[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    @Override // java.lang.reflect.ParameterizedType
    @os.m
    public Type getOwnerType() {
        return null;
    }

    @Override // java.lang.reflect.ParameterizedType
    @os.l
    public Type getRawType() {
        return in.b.g(wn.d.b(this.f6104a));
    }
}
