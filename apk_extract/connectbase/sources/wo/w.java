package wo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kn.l0;
import kn.n0;
import nm.h0;

/* JADX INFO: loaded from: classes3.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final w f19826a = new w();

    public static final class a extends n0 implements jn.l<String, CharSequence> {
        public static final a INSTANCE = new a();

        public a() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final CharSequence invoke(@os.l String str) {
            l0.p(str, "it");
            return w.f19826a.c(str);
        }
    }

    @os.l
    public final String[] b(@os.l String... strArr) {
        l0.p(strArr, "signatures");
        ArrayList arrayList = new ArrayList(strArr.length);
        int length = strArr.length;
        int i10 = 0;
        while (i10 < length) {
            String str = strArr[i10];
            i10++;
            arrayList.add("<init>(" + str + ")V");
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public final String c(String str) {
        if (str.length() <= 1) {
            return str;
        }
        return "L" + str + ';';
    }

    @os.l
    public final Set<String> d(@os.l String str, @os.l String... strArr) {
        l0.p(str, "internalName");
        l0.p(strArr, "signatures");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int length = strArr.length;
        int i10 = 0;
        while (i10 < length) {
            String str2 = strArr[i10];
            i10++;
            linkedHashSet.add(str + n1.e.f11183c + str2);
        }
        return linkedHashSet;
    }

    @os.l
    public final Set<String> e(@os.l String str, @os.l String... strArr) {
        l0.p(str, "name");
        l0.p(strArr, "signatures");
        return d(h(str), (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    @os.l
    public final Set<String> f(@os.l String str, @os.l String... strArr) {
        l0.p(str, "name");
        l0.p(strArr, "signatures");
        return d(i(str), (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    @os.l
    public final String g(@os.l String str) {
        l0.p(str, "name");
        return l0.C("java/util/function/", str);
    }

    @os.l
    public final String h(@os.l String str) {
        l0.p(str, "name");
        return l0.C("java/lang/", str);
    }

    @os.l
    public final String i(@os.l String str) {
        l0.p(str, "name");
        return l0.C("java/util/", str);
    }

    @os.l
    public final String j(@os.l String str, @os.l List<String> list, @os.l String str2) {
        l0.p(str, "name");
        l0.p(list, "parameters");
        l0.p(str2, "ret");
        return str + '(' + h0.m3(list, "", null, null, 0, null, a.INSTANCE, 30, null) + ')' + c(str2);
    }

    @os.l
    public final String k(@os.l String str, @os.l String str2) {
        l0.p(str, "internalName");
        l0.p(str2, "jvmDescriptor");
        return str + n1.e.f11183c + str2;
    }
}
