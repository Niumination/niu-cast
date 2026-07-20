package un;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import kn.l0;
import kn.r1;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nTypesJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypesJVM.kt\nkotlin/reflect/WildcardTypeImpl\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,230:1\n26#2:231\n*S KotlinDebug\n*F\n+ 1 TypesJVM.kt\nkotlin/reflect/WildcardTypeImpl\n*L\n163#1:231\n*E\n"})
@lm.r
public final class c0 implements WildcardType, y {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final a f16340c = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final c0 f16341d = new c0(null, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.m
    public final Type f16342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.m
    public final Type f16343b;

    public static final class a {
        public a() {
        }

        @os.l
        public final c0 a() {
            return c0.f16341d;
        }

        public a(kn.w wVar) {
        }
    }

    public c0(@os.m Type type, @os.m Type type2) {
        this.f16342a = type;
        this.f16343b = type2;
    }

    public boolean equals(@os.m Object obj) {
        if (obj instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) obj;
            if (Arrays.equals(getUpperBounds(), wildcardType.getUpperBounds()) && Arrays.equals(getLowerBounds(), wildcardType.getLowerBounds())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.WildcardType
    @os.l
    public Type[] getLowerBounds() {
        Type type = this.f16343b;
        return type == null ? new Type[0] : new Type[]{type};
    }

    @Override // java.lang.reflect.Type, un.y
    @os.l
    public String getTypeName() {
        if (this.f16343b != null) {
            return "? super " + b0.j(this.f16343b);
        }
        Type type = this.f16342a;
        if (type == null || l0.g(type, Object.class)) {
            return "?";
        }
        return "? extends " + b0.j(this.f16342a);
    }

    @Override // java.lang.reflect.WildcardType
    @os.l
    public Type[] getUpperBounds() {
        Type type = this.f16342a;
        if (type == null) {
            type = Object.class;
        }
        return new Type[]{type};
    }

    public int hashCode() {
        return Arrays.hashCode(getLowerBounds()) ^ Arrays.hashCode(getUpperBounds());
    }

    @os.l
    public String toString() {
        return getTypeName();
    }
}
