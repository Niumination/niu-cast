package un;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kn.h0;
import kn.l0;
import kn.r1;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nTypesJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypesJVM.kt\nkotlin/reflect/ParameterizedTypeImpl\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,230:1\n37#2,2:231\n*S KotlinDebug\n*F\n+ 1 TypesJVM.kt\nkotlin/reflect/ParameterizedTypeImpl\n*L\n190#1:231,2\n*E\n"})
@lm.r
public final class x implements ParameterizedType, y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final Class<?> f16355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.m
    public final Type f16356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final Type[] f16357c;

    public /* synthetic */ class a extends h0 implements jn.l<Type, String> {
        public static final a INSTANCE = new a();

        public a() {
            super(1, b0.class, "typeToString", "typeToString(Ljava/lang/reflect/Type;)Ljava/lang/String;", 1);
        }

        @Override // jn.l
        @os.l
        public final String invoke(@os.l Type type) {
            l0.p(type, "p0");
            return b0.j(type);
        }
    }

    public x(@os.l Class<?> cls, @os.m Type type, @os.l List<? extends Type> list) {
        l0.p(cls, "rawType");
        l0.p(list, "typeArguments");
        this.f16355a = cls;
        this.f16356b = type;
        this.f16357c = (Type[]) list.toArray(new Type[0]);
    }

    public boolean equals(@os.m Object obj) {
        if (obj instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) obj;
            if (l0.g(this.f16355a, parameterizedType.getRawType()) && l0.g(this.f16356b, parameterizedType.getOwnerType()) && Arrays.equals(this.f16357c, parameterizedType.getActualTypeArguments())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.ParameterizedType
    @os.l
    public Type[] getActualTypeArguments() {
        return this.f16357c;
    }

    @Override // java.lang.reflect.ParameterizedType
    @os.m
    public Type getOwnerType() {
        return this.f16356b;
    }

    @Override // java.lang.reflect.ParameterizedType
    @os.l
    public Type getRawType() {
        return this.f16355a;
    }

    @Override // java.lang.reflect.Type, un.y
    @os.l
    public String getTypeName() throws IOException {
        StringBuilder sb2 = new StringBuilder();
        Type type = this.f16356b;
        if (type != null) {
            sb2.append(b0.j(type));
            sb2.append("$");
            sb2.append(this.f16355a.getSimpleName());
        } else {
            sb2.append(b0.j(this.f16355a));
        }
        Type[] typeArr = this.f16357c;
        if (!(typeArr.length == 0)) {
            nm.r.Kg(typeArr, sb2, (50 & 2) != 0 ? ", " : null, (50 & 4) != 0 ? "" : "<", (50 & 8) == 0 ? ">" : "", (50 & 16) != 0 ? -1 : 0, (50 & 32) != 0 ? "..." : null, (50 & 64) != 0 ? null : a.INSTANCE);
        }
        String string = sb2.toString();
        l0.o(string, "toString(...)");
        return string;
    }

    public int hashCode() {
        int iHashCode = this.f16355a.hashCode();
        Type type = this.f16356b;
        return Arrays.hashCode(this.f16357c) ^ (iHashCode ^ (type != null ? type.hashCode() : 0));
    }

    @os.l
    public String toString() {
        return getTypeName();
    }
}
