package tj;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.DateTimeException;
import java.time.Duration;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes2.dex */
public final class c1 implements sj.a, m0, Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long serialVersionUID = 1;
    private final c object;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15574a;

        static {
            int[] iArr = new int[ChronoUnit.values().length];
            f15574a = iArr;
            try {
                iArr[ChronoUnit.DAYS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15574a[ChronoUnit.WEEKS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15574a[ChronoUnit.MONTHS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f15574a[ChronoUnit.YEARS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public enum b {
        BYTES("", 1024, 0),
        KILOBYTES("kilo", 1000, 1),
        MEGABYTES("mega", 1000, 2),
        GIGABYTES("giga", 1000, 3),
        TERABYTES("tera", 1000, 4),
        PETABYTES("peta", 1000, 5),
        EXABYTES("exa", 1000, 6),
        ZETTABYTES("zetta", 1000, 7),
        YOTTABYTES("yotta", 1000, 8),
        KIBIBYTES("kibi", 1024, 1),
        MEBIBYTES("mebi", 1024, 2),
        GIBIBYTES("gibi", 1024, 3),
        TEBIBYTES("tebi", 1024, 4),
        PEBIBYTES("pebi", 1024, 5),
        EXBIBYTES("exbi", 1024, 6),
        ZEBIBYTES("zebi", 1024, 7),
        YOBIBYTES("yobi", 1024, 8);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static Map<String, b> f15575a = a();
        final BigInteger bytes;
        final int power;
        final int powerOf;
        final String prefix;

        b(String str, int i10, int i11) {
            this.prefix = str;
            this.powerOf = i10;
            this.power = i11;
            this.bytes = BigInteger.valueOf(i10).pow(i11);
        }

        public static Map<String, b> a() {
            HashMap map = new HashMap();
            for (b bVar : values()) {
                map.put(bVar.prefix + "byte", bVar);
                map.put(bVar.prefix + "bytes", bVar);
                if (bVar.prefix.length() == 0) {
                    map.put("b", bVar);
                    map.put("B", bVar);
                    map.put("", bVar);
                } else {
                    String strSubstring = bVar.prefix.substring(0, 1);
                    String upperCase = strSubstring.toUpperCase();
                    int i10 = bVar.powerOf;
                    if (i10 == 1024) {
                        map.put(strSubstring, bVar);
                        map.put(upperCase, bVar);
                        map.put(upperCase + b9.i.f771b, bVar);
                        map.put(upperCase + "iB", bVar);
                    } else {
                        if (i10 != 1000) {
                            throw new RuntimeException("broken MemoryUnit enum");
                        }
                        if (bVar.power == 1) {
                            map.put(strSubstring.concat("B"), bVar);
                        } else {
                            map.put(upperCase + "B", bVar);
                        }
                    }
                }
            }
            return map;
        }

        public static b parseUnit(String str) {
            return f15575a.get(str);
        }
    }

    public c1(c cVar) {
        this.object = cVar;
    }

    public static String A(String str) {
        int length = str.length() - 1;
        while (length >= 0 && Character.isLetter(str.charAt(length))) {
            length--;
        }
        return str.substring(length + 1);
    }

    public static boolean C(sj.x xVar, d dVar) {
        if (l((d) xVar)) {
            return true;
        }
        return D(xVar.valueType(), dVar);
    }

    public static boolean D(sj.z zVar, d dVar) {
        if (zVar == sj.z.NULL || l(dVar)) {
            return true;
        }
        if (zVar == sj.z.OBJECT) {
            return dVar instanceof c;
        }
        if (zVar == sj.z.LIST) {
            return (dVar instanceof e1) || (dVar instanceof f1);
        }
        return zVar == sj.z.STRING || (dVar instanceof g0) || zVar == dVar.valueType();
    }

    private d F(p0 p0Var) {
        return root().peekPath(p0Var);
    }

    public static Period G(int i10, ChronoUnit chronoUnit) {
        if (chronoUnit.isTimeBased()) {
            throw new DateTimeException(chronoUnit + " cannot be converted to a java.time.Period");
        }
        int i11 = a.f15574a[chronoUnit.ordinal()];
        if (i11 == 1) {
            return Period.ofDays(i10);
        }
        if (i11 == 2) {
            return Period.ofWeeks(i10);
        }
        if (i11 == 3) {
            return Period.ofMonths(i10);
        }
        if (i11 == 4) {
            return Period.ofYears(i10);
        }
        throw new DateTimeException(chronoUnit + " cannot be converted to a java.time.Period");
    }

    public static d H(d dVar, sj.z zVar, p0 p0Var) {
        if (dVar.valueType() == sj.z.NULL) {
            throw new sj.c.i(dVar.origin(), p0Var.k(), zVar != null ? zVar.name() : null);
        }
        return dVar;
    }

    public static void addMissing(List<sj.c.m> list, sj.z zVar, p0 p0Var, sj.o oVar) {
        b(list, w(zVar), p0Var, oVar);
    }

    public static void b(List<sj.c.m> list, String str, p0 p0Var, sj.o oVar) {
        e(list, p0Var, oVar, "No setting at '" + p0Var.k() + "', expecting: " + str);
    }

    public static void checkValid(p0 p0Var, sj.z zVar, d dVar, List<sj.c.m> list) {
        if (!D(zVar, dVar)) {
            h(list, zVar, dVar, p0Var);
            return;
        }
        sj.z zVar2 = sj.z.LIST;
        if (zVar == zVar2 && (dVar instanceof f1) && !(i0.a(dVar, zVar2) instanceof e1)) {
            h(list, zVar, dVar, p0Var);
        }
    }

    public static void d(List<sj.c.m> list, sj.x xVar, p0 p0Var, sj.o oVar) {
        b(list, v(xVar), p0Var, oVar);
    }

    public static void e(List<sj.c.m> list, p0 p0Var, sj.o oVar, String str) {
        list.add(new sj.c.m(p0Var.k(), oVar, str));
    }

    public static void f(List<sj.c.m> list, String str, d dVar, p0 p0Var) {
        e(list, p0Var, dVar.origin(), "Wrong value type at '" + p0Var.k() + "', expecting: " + str + " but got: " + v(dVar));
    }

    public static void g(List<sj.c.m> list, sj.x xVar, d dVar, p0 p0Var) {
        f(list, v(xVar), dVar, p0Var);
    }

    public static void h(List<sj.c.m> list, sj.z zVar, d dVar, p0 p0Var) {
        f(list, w(zVar), dVar, p0Var);
    }

    public static void i(p0 p0Var, e1 e1Var, e1 e1Var2, List<sj.c.m> list) {
        if (e1Var.isEmpty() || e1Var2.isEmpty()) {
            return;
        }
        d dVar = e1Var.get(0);
        Iterator<sj.x> it = e1Var2.iterator();
        while (it.hasNext()) {
            d dVar2 = (d) it.next();
            if (!C(dVar, dVar2)) {
                e(list, p0Var, dVar2.origin(), "List at '" + p0Var.k() + "' contains wrong value type, expecting list of " + v(dVar) + " but got element of type " + v(dVar2));
                return;
            }
        }
    }

    public static void j(p0 p0Var, sj.x xVar, d dVar, List<sj.c.m> list) {
        if (!C(xVar, dVar)) {
            g(list, xVar, dVar, p0Var);
            return;
        }
        if ((xVar instanceof c) && (dVar instanceof c)) {
            k(p0Var, (c) xVar, (c) dVar, list);
            return;
        }
        boolean z10 = xVar instanceof e1;
        if (z10 && (dVar instanceof e1)) {
            i(p0Var, (e1) xVar, (e1) dVar, list);
            return;
        }
        if (z10 && (dVar instanceof f1)) {
            e1 e1Var = (e1) xVar;
            d dVarA = i0.a(dVar, sj.z.LIST);
            if (dVarA instanceof e1) {
                i(p0Var, e1Var, (e1) dVarA, list);
            } else {
                g(list, xVar, dVar, p0Var);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void k(p0 p0Var, c cVar, c cVar2, List<sj.c.m> list) {
        for (Map.Entry<String, sj.x> entry : cVar.entrySet()) {
            String key = entry.getKey();
            p0 p0VarI = p0Var != null ? p0.f(key).i(p0Var) : p0.f(key);
            d dVar = cVar2.get((Object) key);
            if (dVar == null) {
                d(list, entry.getValue(), p0VarI, cVar2.origin());
            } else {
                j(p0VarI, entry.getValue(), dVar, list);
            }
        }
    }

    public static boolean l(d dVar) {
        sj.z zVar = sj.z.NULL;
        return i0.a(dVar, zVar).valueType() == zVar;
    }

    public static d m(c cVar, String str, sj.z zVar, p0 p0Var) {
        return H(n(cVar, str, zVar, p0Var), zVar, p0Var);
    }

    public static d n(c cVar, String str, sj.z zVar, p0 p0Var) {
        d dVarPeekAssumingResolved = cVar.peekAssumingResolved(str, p0Var);
        if (dVarPeekAssumingResolved == null) {
            throw new sj.c.g(cVar.origin(), p0Var.k());
        }
        if (zVar != null) {
            dVarPeekAssumingResolved = i0.a(dVarPeekAssumingResolved, zVar);
        }
        if (zVar == null || dVarPeekAssumingResolved.valueType() == zVar || dVarPeekAssumingResolved.valueType() == sj.z.NULL) {
            return dVarPeekAssumingResolved;
        }
        throw new sj.c.n(dVarPeekAssumingResolved.origin(), p0Var.k(), zVar.name(), dVarPeekAssumingResolved.valueType().name());
    }

    public static d p(c cVar, p0 p0Var, sj.z zVar, p0 p0Var2) {
        try {
            String str = p0Var.f15726a;
            p0 p0Var3 = p0Var.f15727b;
            return p0Var3 == null ? n(cVar, str, zVar, p0Var2) : p((c) m(cVar, str, sj.z.OBJECT, p0Var2.n(0, p0Var2.e() - p0Var3.e())), p0Var3, zVar, p0Var2);
        } catch (sj.c.h e10) {
            throw m.v(p0Var, e10);
        }
    }

    public static BigInteger parseBytes(String str, sj.o oVar, String str2) {
        String strO = n.o(str);
        String strA = A(strO);
        String strO2 = n.o(strO.substring(0, strO.length() - strA.length()));
        if (strO2.length() == 0) {
            throw new sj.c.C0371c(oVar, str2, n.a.a("No number in size-in-bytes value '", str, "'"));
        }
        b unit = b.parseUnit(strA);
        if (unit == null) {
            throw new sj.c.C0371c(oVar, str2, n.a.a("Could not parse size-in-bytes unit '", strA, "' (try k, K, kB, KiB, kilobytes, kibibytes)"));
        }
        try {
            return strO2.matches("[0-9]+") ? unit.bytes.multiply(new BigInteger(strO2)) : new BigDecimal(unit.bytes).multiply(new BigDecimal(strO2)).toBigInteger();
        } catch (NumberFormatException unused) {
            throw new sj.c.C0371c(oVar, str2, n.a.a("Could not parse size-in-bytes number '", strO2, "'"));
        }
    }

    public static long parseDuration(String str, sj.o oVar, String str2) {
        TimeUnit timeUnit;
        String strO = n.o(str);
        String strA = A(strO);
        String strO2 = n.o(strO.substring(0, strO.length() - strA.length()));
        if (strO2.length() == 0) {
            throw new sj.c.C0371c(oVar, str2, n.a.a("No number in duration value '", str, "'"));
        }
        String strConcat = (strA.length() <= 2 || strA.endsWith(p6.s.f13016a)) ? strA : strA.concat(p6.s.f13016a);
        if (strConcat.equals("") || strConcat.equals("ms") || strConcat.equals("millis") || strConcat.equals("milliseconds")) {
            timeUnit = TimeUnit.MILLISECONDS;
        } else if (strConcat.equals("us") || strConcat.equals("micros") || strConcat.equals("microseconds")) {
            timeUnit = TimeUnit.MICROSECONDS;
        } else if (strConcat.equals("ns") || strConcat.equals("nanos") || strConcat.equals("nanoseconds")) {
            timeUnit = TimeUnit.NANOSECONDS;
        } else if (strConcat.equals("d") || strConcat.equals("days")) {
            timeUnit = TimeUnit.DAYS;
        } else if (strConcat.equals("h") || strConcat.equals("hours")) {
            timeUnit = TimeUnit.HOURS;
        } else if (strConcat.equals(p6.s.f13016a) || strConcat.equals("seconds")) {
            timeUnit = TimeUnit.SECONDS;
        } else {
            if (!strConcat.equals(p6.m.f13003a) && !strConcat.equals("minutes")) {
                throw new sj.c.C0371c(oVar, str2, n.a.a("Could not parse time unit '", strA, "' (try ns, us, ms, s, m, h, d)"));
            }
            timeUnit = TimeUnit.MINUTES;
        }
        try {
            if (strO2.matches("[+-]?[0-9]+")) {
                return timeUnit.toNanos(Long.parseLong(strO2));
            }
            return (long) (Double.parseDouble(strO2) * timeUnit.toNanos(1L));
        } catch (NumberFormatException unused) {
            throw new sj.c.C0371c(oVar, str2, n.a.a("Could not parse duration number '", strO2, "'"));
        }
    }

    public static Period parsePeriod(String str, sj.o oVar, String str2) {
        ChronoUnit chronoUnit;
        String strO = n.o(str);
        String strA = A(strO);
        String strO2 = n.o(strO.substring(0, strO.length() - strA.length()));
        if (strO2.length() == 0) {
            throw new sj.c.C0371c(oVar, str2, n.a.a("No number in period value '", str, "'"));
        }
        String strConcat = (strA.length() <= 2 || strA.endsWith(p6.s.f13016a)) ? strA : strA.concat(p6.s.f13016a);
        if (strConcat.equals("") || strConcat.equals("d") || strConcat.equals("days")) {
            chronoUnit = ChronoUnit.DAYS;
        } else if (strConcat.equals(p6.w.f13020a) || strConcat.equals("weeks")) {
            chronoUnit = ChronoUnit.WEEKS;
        } else if (strConcat.equals(p6.m.f13003a) || strConcat.equals("mo") || strConcat.equals("months")) {
            chronoUnit = ChronoUnit.MONTHS;
        } else {
            if (!strConcat.equals("y") && !strConcat.equals("years")) {
                throw new sj.c.C0371c(oVar, str2, n.a.a("Could not parse time unit '", strA, "' (try d, w, mo, y)"));
            }
            chronoUnit = ChronoUnit.YEARS;
        }
        try {
            return G(Integer.parseInt(strO2), chronoUnit);
        } catch (NumberFormatException unused) {
            throw new sj.c.C0371c(oVar, str2, n.a.a("Could not parse duration number '", strO2, "'"));
        }
    }

    public static void r(Set<Map.Entry<String, sj.x>> set, p0 p0Var, c cVar) {
        for (Map.Entry<String, sj.x> entry : cVar.entrySet()) {
            String key = entry.getKey();
            sj.x value = entry.getValue();
            p0 p0VarF = p0.f(key);
            if (p0Var != null) {
                p0VarF = p0VarF.i(p0Var);
            }
            if (value instanceof c) {
                r(set, p0VarF, (c) value);
            } else if (!(value instanceof c0)) {
                set.add(new AbstractMap.SimpleImmutableEntry(p0VarF.k(), value));
            }
        }
    }

    public static String v(sj.x xVar) {
        if (!(xVar instanceof c)) {
            return w(xVar.valueType());
        }
        c cVar = (c) xVar;
        if (cVar.isEmpty()) {
            return w(xVar.valueType());
        }
        return "object with keys " + cVar.keySet();
    }

    public static String w(sj.z zVar) {
        return zVar.name().toLowerCase();
    }

    private Object writeReplace() throws ObjectStreamException {
        return new z0(this);
    }

    public final sj.x B(String str) {
        p0 p0VarD = r0.d(str);
        try {
            return this.object.peekPath(p0VarD);
        } catch (sj.c.h e10) {
            throw m.v(p0VarD, e10);
        }
    }

    public final /* synthetic */ Long E(sj.x xVar, String str, BigInteger bigInteger) {
        return I(bigInteger, xVar.origin(), str);
    }

    public final Long I(BigInteger bigInteger, sj.o oVar, String str) {
        if (bigInteger.bitLength() < 64) {
            return Long.valueOf(bigInteger.longValue());
        }
        throw new sj.c.C0371c(oVar, str, "size-in-bytes value is out of range for a 64-bit long: '" + bigInteger + "'");
    }

    @Override // sj.a
    public sj.a atPath(String str) {
        return root().atPath(str);
    }

    @Override // sj.a
    public Set<Map.Entry<String, sj.x>> entrySet() {
        HashSet hashSet = new HashSet();
        r(hashSet, null, this.object);
        return hashSet;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof c1) {
            return this.object.equals(((c1) obj).object);
        }
        return false;
    }

    public d find(p0 p0Var, sj.z zVar, p0 p0Var2) {
        return H(p(this.object, p0Var, zVar, p0Var2), zVar, p0Var2);
    }

    @Override // sj.a
    public Object getAnyRef(String str) {
        return find(str, null).unwrapped();
    }

    @Override // sj.a
    public List<? extends Object> getAnyRefList(String str) {
        ArrayList arrayList = new ArrayList();
        Iterator<sj.x> it = getList(str).iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().unwrapped());
        }
        return arrayList;
    }

    @Override // sj.a
    public boolean getBoolean(String str) {
        return ((Boolean) find(str, sj.z.BOOLEAN).unwrapped()).booleanValue();
    }

    @Override // sj.a
    public List<Boolean> getBooleanList(String str) {
        return y(str, sj.z.BOOLEAN);
    }

    @Override // sj.a
    public Long getBytes(String str) {
        return I(s(str), find(str, sj.z.STRING).origin(), str);
    }

    @Override // sj.a
    public List<Long> getBytesList(final String str) {
        final d dVarFind = find(str, sj.z.LIST);
        return (List) t(str).stream().map(new Function() { // from class: tj.a1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f15570a.E(dVarFind, str, (BigInteger) obj);
            }
        }).collect(Collectors.toList());
    }

    @Override // sj.a
    public List<? extends sj.a> getConfigList(String str) {
        List<sj.n> objectList = getObjectList(str);
        ArrayList arrayList = new ArrayList();
        Iterator<sj.n> it = objectList.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toConfig());
        }
        return arrayList;
    }

    @Override // sj.a
    public double getDouble(String str) {
        return getNumber(str).doubleValue();
    }

    @Override // sj.a
    public List<Double> getDoubleList(String str) {
        ArrayList arrayList = new ArrayList();
        Iterator<Number> it = getNumberList(str).iterator();
        while (it.hasNext()) {
            arrayList.add(Double.valueOf(it.next().doubleValue()));
        }
        return arrayList;
    }

    @Override // sj.a
    public long getDuration(String str, TimeUnit timeUnit) {
        d dVarFind = find(str, sj.z.STRING);
        return timeUnit.convert(parseDuration((String) dVarFind.unwrapped(), dVarFind.origin(), str), TimeUnit.NANOSECONDS);
    }

    @Override // sj.a
    public List<Long> getDurationList(String str, TimeUnit timeUnit) {
        ArrayList arrayList = new ArrayList();
        for (sj.x xVar : getList(str)) {
            if (xVar.valueType() == sj.z.NUMBER) {
                arrayList.add(Long.valueOf(timeUnit.convert(((Number) xVar.unwrapped()).longValue(), TimeUnit.MILLISECONDS)));
            } else {
                if (xVar.valueType() != sj.z.STRING) {
                    throw new sj.c.n(xVar.origin(), str, "duration string or number of milliseconds", xVar.valueType().name());
                }
                arrayList.add(Long.valueOf(timeUnit.convert(parseDuration((String) xVar.unwrapped(), xVar.origin(), str), TimeUnit.NANOSECONDS)));
            }
        }
        return arrayList;
    }

    @Override // sj.a
    public <T extends Enum<T>> T getEnum(Class<T> cls, String str) {
        return (T) x(str, cls, find(str, sj.z.STRING));
    }

    @Override // sj.a
    public <T extends Enum<T>> List<T> getEnumList(Class<T> cls, String str) {
        List listZ = z(str, sj.z.STRING);
        ArrayList arrayList = new ArrayList();
        Iterator it = listZ.iterator();
        while (it.hasNext()) {
            arrayList.add(x(str, cls, (g0) it.next()));
        }
        return arrayList;
    }

    @Override // sj.a
    public int getInt(String str) {
        return u(str).intValueRangeChecked(str);
    }

    @Override // sj.a
    public List<Integer> getIntList(String str) {
        ArrayList arrayList = new ArrayList();
        Iterator it = z(str, sj.z.NUMBER).iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((d0) ((d) it.next())).intValueRangeChecked(str)));
        }
        return arrayList;
    }

    @Override // sj.a
    public boolean getIsNull(String str) {
        return o(str, null).valueType() == sj.z.NULL;
    }

    @Override // sj.a
    public sj.j getList(String str) {
        return (sj.j) find(str, sj.z.LIST);
    }

    @Override // sj.a
    public long getLong(String str) {
        return getNumber(str).longValue();
    }

    @Override // sj.a
    public List<Long> getLongList(String str) {
        ArrayList arrayList = new ArrayList();
        Iterator<Number> it = getNumberList(str).iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(it.next().longValue()));
        }
        return arrayList;
    }

    @Override // sj.a
    public sj.l getMemorySize(String str) {
        return new sj.l(s(str));
    }

    @Override // sj.a
    public List<sj.l> getMemorySizeList(String str) {
        return (List) t(str).stream().map(new b1()).collect(Collectors.toList());
    }

    @Override // sj.a
    @Deprecated
    public Long getMilliseconds(String str) {
        return Long.valueOf(getDuration(str, TimeUnit.MILLISECONDS));
    }

    @Override // sj.a
    @Deprecated
    public List<Long> getMillisecondsList(String str) {
        return getDurationList(str, TimeUnit.MILLISECONDS);
    }

    @Override // sj.a
    @Deprecated
    public Long getNanoseconds(String str) {
        return Long.valueOf(getDuration(str, TimeUnit.NANOSECONDS));
    }

    @Override // sj.a
    @Deprecated
    public List<Long> getNanosecondsList(String str) {
        return getDurationList(str, TimeUnit.NANOSECONDS);
    }

    @Override // sj.a
    public Number getNumber(String str) {
        return u(str).unwrapped();
    }

    @Override // sj.a
    public List<Number> getNumberList(String str) {
        return y(str, sj.z.NUMBER);
    }

    @Override // sj.a
    public List<sj.n> getObjectList(String str) {
        return z(str, sj.z.OBJECT);
    }

    @Override // sj.a
    public Period getPeriod(String str) {
        d dVarFind = find(str, sj.z.STRING);
        return parsePeriod((String) dVarFind.unwrapped(), dVarFind.origin(), str);
    }

    @Override // sj.a
    public String getString(String str) {
        return (String) find(str, sj.z.STRING).unwrapped();
    }

    @Override // sj.a
    public List<String> getStringList(String str) {
        return y(str, sj.z.STRING);
    }

    @Override // sj.a
    public TemporalAmount getTemporal(String str) {
        try {
            return getDuration(str);
        } catch (sj.c.C0371c unused) {
            return getPeriod(str);
        }
    }

    @Override // sj.a
    public boolean hasPath(String str) {
        sj.x xVarB = B(str);
        return (xVarB == null || xVarB.valueType() == sj.z.NULL) ? false : true;
    }

    @Override // sj.a
    public boolean hasPathOrNull(String str) {
        return B(str) != null;
    }

    public final int hashCode() {
        return this.object.hashCode() * 41;
    }

    @Override // sj.a
    public boolean isEmpty() {
        return this.object.isEmpty();
    }

    @Override // sj.a
    public boolean isResolved() {
        return root().resolveStatus() == y0.RESOLVED;
    }

    public final d o(String str, sj.z zVar) {
        p0 p0VarD = r0.d(str);
        return p(this.object, p0VarD, zVar, p0VarD);
    }

    @Override // sj.a
    public sj.o origin() {
        return this.object.origin();
    }

    public final d q(p0 p0Var, sj.z zVar, p0 p0Var2) {
        return p(this.object, p0Var, zVar, p0Var2);
    }

    public final BigInteger s(String str) {
        BigInteger bytes;
        d dVarFind = find(str, sj.z.STRING);
        try {
            bytes = BigInteger.valueOf(getLong(str));
        } catch (sj.c.n unused) {
            bytes = parseBytes((String) dVarFind.unwrapped(), dVarFind.origin(), str);
        }
        if (bytes.signum() >= 0) {
            return bytes;
        }
        throw new sj.c.C0371c(dVarFind.origin(), str, "Attempt to construct memory size with negative number: " + bytes);
    }

    public final List<BigInteger> t(String str) {
        BigInteger bytes;
        ArrayList arrayList = new ArrayList();
        for (sj.x xVar : getList(str)) {
            if (xVar.valueType() == sj.z.NUMBER) {
                bytes = BigInteger.valueOf(((Number) xVar.unwrapped()).longValue());
            } else {
                if (xVar.valueType() != sj.z.STRING) {
                    throw new sj.c.n(xVar.origin(), str, "memory size string or number of bytes", xVar.valueType().name());
                }
                bytes = parseBytes((String) xVar.unwrapped(), xVar.origin(), str);
            }
            if (bytes.signum() < 0) {
                throw new sj.c.C0371c(xVar.origin(), str, "Attempt to construct ConfigMemorySize with negative number: " + bytes);
            }
            arrayList.add(bytes);
        }
        return arrayList;
    }

    public String toString() {
        return "Config(" + this.object.toString() + ")";
    }

    public final d0 u(String str) {
        return (d0) find(str, sj.z.NUMBER);
    }

    public final <T extends Enum<T>> T x(String str, Class<T> cls, sj.x xVar) {
        String str2 = (String) xVar.unwrapped();
        try {
            return (T) Enum.valueOf(cls, str2);
        } catch (IllegalArgumentException unused) {
            ArrayList arrayList = new ArrayList();
            T[] enumConstants = cls.getEnumConstants();
            if (enumConstants != null) {
                for (T t10 : enumConstants) {
                    arrayList.add(t10.name());
                }
            }
            throw new sj.c.C0371c(xVar.origin(), str, String.format("The enum class %s has no constant of the name '%s' (should be one of %s.)", cls.getSimpleName(), str2, arrayList));
        }
    }

    public final <T> List<T> y(String str, sj.z zVar) {
        ArrayList arrayList = new ArrayList();
        for (d dVarA : getList(str)) {
            if (zVar != null) {
                dVarA = i0.a(dVarA, zVar);
            }
            if (dVarA.valueType() != zVar) {
                throw new sj.c.n(dVarA.origin(), str, "list of " + zVar.name(), "list of " + dVarA.valueType().name());
            }
            arrayList.add(dVarA.unwrapped());
        }
        return arrayList;
    }

    public final <T extends sj.x> List<T> z(String str, sj.z zVar) {
        ArrayList arrayList = new ArrayList();
        for (d dVarA : getList(str)) {
            if (zVar != null) {
                dVarA = i0.a(dVarA, zVar);
            }
            if (dVarA.valueType() != zVar) {
                throw new sj.c.n(dVarA.origin(), str, "list of " + zVar.name(), "list of " + dVarA.valueType().name());
            }
            arrayList.add(dVarA);
        }
        return arrayList;
    }

    public c1 atKey(sj.o oVar, String str) {
        return root().atKey(oVar, str);
    }

    public d find(String str, sj.z zVar) {
        p0 p0VarD = r0.d(str);
        return find(p0VarD, zVar, p0VarD);
    }

    @Override // sj.a
    public c1 getConfig(String str) {
        return getObject(str).toConfig();
    }

    @Override // sj.a
    public c getObject(String str) {
        return (c) find(str, sj.z.OBJECT);
    }

    @Override // sj.a
    public d getValue(String str) {
        return find(str, null);
    }

    @Override // sj.a
    public c root() {
        return this.object;
    }

    @Override // tj.m0
    public c toFallbackValue() {
        return this.object;
    }

    @Override // sj.a
    public c1 withOnlyPath(String str) {
        return new c1(root().withOnlyPath(r0.d(str)));
    }

    @Override // sj.a
    public c1 withValue(String str, sj.x xVar) {
        return new c1(root().withValue(r0.d(str), xVar));
    }

    @Override // sj.a
    public c1 withoutPath(String str) {
        return new c1(root().withoutPath(r0.d(str)));
    }

    @Override // sj.a
    public c1 atKey(String str) {
        return root().atKey(str);
    }

    @Override // sj.a
    public c1 resolve() {
        return resolve(sj.t.b());
    }

    @Override // sj.a
    public c1 resolveWith(sj.a aVar) {
        return resolveWith(aVar, sj.t.b());
    }

    @Override // sj.a, sj.m
    public c1 withFallback(sj.m mVar) {
        return this.object.withFallback(mVar).toConfig();
    }

    @Override // sj.a
    public Duration getDuration(String str) {
        d dVarFind = find(str, sj.z.STRING);
        return Duration.ofNanos(parseDuration((String) dVarFind.unwrapped(), dVarFind.origin(), str));
    }

    @Override // sj.a
    public c1 resolve(sj.t tVar) {
        return resolveWith((sj.a) this, tVar);
    }

    @Override // sj.a
    public c1 resolveWith(sj.a aVar, sj.t tVar) {
        d dVarK = u0.k(this.object, ((c1) aVar).object, tVar);
        return dVarK == this.object ? this : new c1((c) dVarK);
    }

    @Override // sj.a
    public void checkValid(sj.a aVar, String... strArr) {
        c1 c1Var = (c1) aVar;
        y0 y0VarResolveStatus = c1Var.root().resolveStatus();
        y0 y0Var = y0.RESOLVED;
        if (y0VarResolveStatus == y0Var) {
            if (root().resolveStatus() == y0Var) {
                ArrayList arrayList = new ArrayList();
                if (strArr.length == 0) {
                    k(null, c1Var.root(), root(), arrayList);
                } else {
                    for (String str : strArr) {
                        p0 p0VarD = r0.d(str);
                        d dVarF = c1Var.F(p0VarD);
                        if (dVarF != null) {
                            d dVarF2 = F(p0VarD);
                            if (dVarF2 != null) {
                                j(p0VarD, dVarF, dVarF2, arrayList);
                            } else {
                                d(arrayList, dVarF, p0VarD, origin());
                            }
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    throw new sj.c.l(arrayList);
                }
                return;
            }
            throw new sj.c.h("need to Config#resolve() each config before using it, see the API docs for Config#resolve()");
        }
        throw new sj.c.d("do not call checkValid() with an unresolved reference config, call Config#resolve(), see Config#resolve() API docs");
    }

    @Override // sj.a
    public List<Duration> getDurationList(String str) {
        List<Long> durationList = getDurationList(str, TimeUnit.NANOSECONDS);
        ArrayList arrayList = new ArrayList(durationList.size());
        Iterator<Long> it = durationList.iterator();
        while (it.hasNext()) {
            arrayList.add(Duration.ofNanos(it.next().longValue()));
        }
        return arrayList;
    }
}
