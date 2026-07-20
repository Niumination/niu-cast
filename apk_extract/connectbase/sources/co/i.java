package co;

import ao.k;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kn.l0;
import nm.d0;
import nm.p1;
import nm.y;
import os.l;
import wo.w;

/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final i f1735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public static final Set<String> f1736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public static final Set<String> f1737c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public static final Set<String> f1738d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @l
    public static final Set<String> f1739e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @l
    public static final Set<String> f1740f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @l
    public static final Set<String> f1741g;

    static {
        i iVar = new i();
        f1735a = iVar;
        w wVar = w.f19826a;
        f1736b = p1.E(wVar.f("Collection", "toArray()[Ljava/lang/Object;", "toArray([Ljava/lang/Object;)[Ljava/lang/Object;"), "java/lang/annotation/Annotation.annotationType()Ljava/lang/Class;");
        f1737c = p1.D(p1.D(p1.D(p1.D(p1.D(p1.D(iVar.b(), wVar.f("List", "sort(Ljava/util/Comparator;)V")), wVar.e("String", "codePointAt(I)I", "codePointBefore(I)I", "codePointCount(II)I", "compareToIgnoreCase(Ljava/lang/String;)I", "concat(Ljava/lang/String;)Ljava/lang/String;", "contains(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/StringBuffer;)Z", "endsWith(Ljava/lang/String;)Z", "equalsIgnoreCase(Ljava/lang/String;)Z", "getBytes()[B", "getBytes(II[BI)V", "getBytes(Ljava/lang/String;)[B", "getBytes(Ljava/nio/charset/Charset;)[B", "getChars(II[CI)V", "indexOf(I)I", "indexOf(II)I", "indexOf(Ljava/lang/String;)I", "indexOf(Ljava/lang/String;I)I", "intern()Ljava/lang/String;", "isEmpty()Z", "lastIndexOf(I)I", "lastIndexOf(II)I", "lastIndexOf(Ljava/lang/String;)I", "lastIndexOf(Ljava/lang/String;I)I", "matches(Ljava/lang/String;)Z", "offsetByCodePoints(II)I", "regionMatches(ILjava/lang/String;II)Z", "regionMatches(ZILjava/lang/String;II)Z", "replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(CC)Ljava/lang/String;", "replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", "split(Ljava/lang/String;I)[Ljava/lang/String;", "split(Ljava/lang/String;)[Ljava/lang/String;", "startsWith(Ljava/lang/String;I)Z", "startsWith(Ljava/lang/String;)Z", "substring(II)Ljava/lang/String;", "substring(I)Ljava/lang/String;", "toCharArray()[C", "toLowerCase()Ljava/lang/String;", "toLowerCase(Ljava/util/Locale;)Ljava/lang/String;", "toUpperCase()Ljava/lang/String;", "toUpperCase(Ljava/util/Locale;)Ljava/lang/String;", "trim()Ljava/lang/String;", "isBlank()Z", "lines()Ljava/util/stream/Stream;", "repeat(I)Ljava/lang/String;")), wVar.e("Double", "isInfinite()Z", "isNaN()Z")), wVar.e("Float", "isInfinite()Z", "isNaN()Z")), wVar.e("Enum", "getDeclaringClass()Ljava/lang/Class;", "finalize()V")), wVar.e("CharSequence", "isEmpty()Z"));
        f1738d = p1.D(p1.D(p1.D(p1.D(p1.D(p1.D(wVar.e("CharSequence", "codePoints()Ljava/util/stream/IntStream;", "chars()Ljava/util/stream/IntStream;"), wVar.f("Iterator", "forEachRemaining(Ljava/util/function/Consumer;)V")), wVar.e("Iterable", "forEach(Ljava/util/function/Consumer;)V", "spliterator()Ljava/util/Spliterator;")), wVar.e("Throwable", "setStackTrace([Ljava/lang/StackTraceElement;)V", "fillInStackTrace()Ljava/lang/Throwable;", "getLocalizedMessage()Ljava/lang/String;", "printStackTrace()V", "printStackTrace(Ljava/io/PrintStream;)V", "printStackTrace(Ljava/io/PrintWriter;)V", "getStackTrace()[Ljava/lang/StackTraceElement;", "initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "getSuppressed()[Ljava/lang/Throwable;", "addSuppressed(Ljava/lang/Throwable;)V")), wVar.f("Collection", "spliterator()Ljava/util/Spliterator;", "parallelStream()Ljava/util/stream/Stream;", "stream()Ljava/util/stream/Stream;", "removeIf(Ljava/util/function/Predicate;)Z")), wVar.f("List", "replaceAll(Ljava/util/function/UnaryOperator;)V")), wVar.f("Map", "getOrDefault(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "forEach(Ljava/util/function/BiConsumer;)V", "replaceAll(Ljava/util/function/BiFunction;)V", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;"));
        f1739e = p1.D(p1.D(wVar.f("Collection", "removeIf(Ljava/util/function/Predicate;)Z"), wVar.f("List", "replaceAll(Ljava/util/function/UnaryOperator;)V", "sort(Ljava/util/Comparator;)V")), wVar.f("Map", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove(Ljava/lang/Object;Ljava/lang/Object;)Z", "replaceAll(Ljava/util/function/BiFunction;)V", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z"));
        Set<String> setA = iVar.a();
        String[] strArrB = wVar.b("D");
        Set setD = p1.D(setA, wVar.e("Float", (String[]) Arrays.copyOf(strArrB, strArrB.length)));
        String[] strArrB2 = wVar.b("[C", "[CII", "[III", "[BIILjava/lang/String;", "[BIILjava/nio/charset/Charset;", "[BLjava/lang/String;", "[BLjava/nio/charset/Charset;", "[BII", "[B", "Ljava/lang/StringBuffer;", "Ljava/lang/StringBuilder;");
        f1740f = p1.D(setD, wVar.e("String", (String[]) Arrays.copyOf(strArrB2, strArrB2.length)));
        String[] strArrB3 = wVar.b("Ljava/lang/String;Ljava/lang/Throwable;ZZ");
        f1741g = wVar.e("Throwable", (String[]) Arrays.copyOf(strArrB3, strArrB3.length));
    }

    public final Set<String> a() {
        w wVar = w.f19826a;
        mp.e eVar = mp.e.BOOLEAN;
        mp.e eVar2 = mp.e.BYTE;
        List listO = y.O(eVar, eVar2, mp.e.DOUBLE, mp.e.FLOAT, eVar2, mp.e.INT, mp.e.LONG, mp.e.SHORT);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = listO.iterator();
        while (it.hasNext()) {
            String strB = ((mp.e) it.next()).getWrapperFqName().g().b();
            l0.o(strB, "it.wrapperFqName.shortName().asString()");
            String[] strArrB = wVar.b("Ljava/lang/String;");
            d0.r0(linkedHashSet, wVar.e(strB, (String[]) Arrays.copyOf(strArrB, strArrB.length)));
        }
        return linkedHashSet;
    }

    public final Set<String> b() {
        w wVar = w.f19826a;
        List<mp.e> listO = y.O(mp.e.BOOLEAN, mp.e.CHAR);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (mp.e eVar : listO) {
            String strB = eVar.getWrapperFqName().g().b();
            l0.o(strB, "it.wrapperFqName.shortName().asString()");
            d0.r0(linkedHashSet, wVar.e(strB, eVar.getJavaKeywordName() + "Value()" + eVar.getDesc()));
        }
        return linkedHashSet;
    }

    @l
    public final Set<String> c() {
        return f1736b;
    }

    @l
    public final Set<String> d() {
        return f1740f;
    }

    @l
    public final Set<String> e() {
        return f1737c;
    }

    @l
    public final Set<String> f() {
        return f1739e;
    }

    @l
    public final Set<String> g() {
        return f1741g;
    }

    @l
    public final Set<String> h() {
        return f1738d;
    }

    public final boolean i(@l dp.d dVar) {
        l0.p(dVar, "fqName");
        return l0.g(dVar, k.a.f587i) || k.e(dVar);
    }

    public final boolean j(@l dp.d dVar) {
        l0.p(dVar, "fqName");
        if (i(dVar)) {
            return true;
        }
        dp.b bVarO = c.f1685a.o(dVar);
        if (bVarO == null) {
            return false;
        }
        try {
            return Serializable.class.isAssignableFrom(Class.forName(bVarO.b().b()));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}
