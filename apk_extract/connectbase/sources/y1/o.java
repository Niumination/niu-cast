package y1;

import com.google.gson.annotations.SerializedName;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* JADX INFO: loaded from: classes.dex */
public final class o {
    public static final v1.z<AtomicBoolean> ATOMIC_BOOLEAN;
    public static final v1.a0 ATOMIC_BOOLEAN_FACTORY;
    public static final v1.z<AtomicInteger> ATOMIC_INTEGER;
    public static final v1.z<AtomicIntegerArray> ATOMIC_INTEGER_ARRAY;
    public static final v1.a0 ATOMIC_INTEGER_ARRAY_FACTORY;
    public static final v1.a0 ATOMIC_INTEGER_FACTORY;
    public static final v1.z<BigDecimal> BIG_DECIMAL;
    public static final v1.z<BigInteger> BIG_INTEGER;
    public static final v1.z<BitSet> BIT_SET;
    public static final v1.a0 BIT_SET_FACTORY;
    public static final v1.z<Boolean> BOOLEAN;
    public static final v1.z<Boolean> BOOLEAN_AS_STRING;
    public static final v1.a0 BOOLEAN_FACTORY;
    public static final v1.z<Number> BYTE;
    public static final v1.a0 BYTE_FACTORY;
    public static final v1.z<Calendar> CALENDAR;
    public static final v1.a0 CALENDAR_FACTORY;
    public static final v1.z<Character> CHARACTER;
    public static final v1.a0 CHARACTER_FACTORY;
    public static final v1.z<Class> CLASS;
    public static final v1.a0 CLASS_FACTORY;
    public static final v1.z<Currency> CURRENCY;
    public static final v1.a0 CURRENCY_FACTORY;
    public static final v1.z<Number> DOUBLE;
    public static final v1.a0 ENUM_FACTORY;
    public static final v1.z<Number> FLOAT;
    public static final v1.z<InetAddress> INET_ADDRESS;
    public static final v1.a0 INET_ADDRESS_FACTORY;
    public static final v1.z<Number> INTEGER;
    public static final v1.a0 INTEGER_FACTORY;
    public static final v1.z<v1.k> JSON_ELEMENT;
    public static final v1.a0 JSON_ELEMENT_FACTORY;
    public static final v1.z<x1.h> LAZILY_PARSED_NUMBER;
    public static final v1.z<Locale> LOCALE;
    public static final v1.a0 LOCALE_FACTORY;
    public static final v1.z<Number> LONG;
    public static final v1.z<Number> SHORT;
    public static final v1.a0 SHORT_FACTORY;
    public static final v1.z<String> STRING;
    public static final v1.z<StringBuffer> STRING_BUFFER;
    public static final v1.a0 STRING_BUFFER_FACTORY;
    public static final v1.z<StringBuilder> STRING_BUILDER;
    public static final v1.a0 STRING_BUILDER_FACTORY;
    public static final v1.a0 STRING_FACTORY;
    public static final v1.z<URI> URI;
    public static final v1.a0 URI_FACTORY;
    public static final v1.z<URL> URL;
    public static final v1.a0 URL_FACTORY;
    public static final v1.z<UUID> UUID;
    public static final v1.a0 UUID_FACTORY;

    public class a extends v1.z<AtomicIntegerArray> {
        @Override // v1.z
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AtomicIntegerArray read(d2.a aVar) throws IOException {
            ArrayList arrayList = new ArrayList();
            aVar.beginArray();
            while (aVar.hasNext()) {
                try {
                    arrayList.add(Integer.valueOf(aVar.nextInt()));
                } catch (NumberFormatException e10) {
                    throw new v1.u(e10);
                }
            }
            aVar.endArray();
            int size = arrayList.size();
            AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
            for (int i10 = 0; i10 < size; i10++) {
                atomicIntegerArray.set(i10, ((Integer) arrayList.get(i10)).intValue());
            }
            return atomicIntegerArray;
        }

        @Override // v1.z
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(d2.d dVar, AtomicIntegerArray atomicIntegerArray) throws IOException {
            dVar.beginArray();
            int length = atomicIntegerArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                dVar.value(atomicIntegerArray.get(i10));
            }
            dVar.endArray();
        }
    }

    public class a0 implements v1.a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Class f20659a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ v1.z f20660b;

        /* JADX INFO: Add missing generic type declarations: [T1] */
        public class a<T1> extends v1.z<T1> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Class f20661a;

            public a(Class cls) {
                this.f20661a = cls;
            }

            @Override // v1.z
            public T1 read(d2.a aVar) throws IOException {
                T1 t10 = (T1) a0.this.f20660b.read(aVar);
                if (t10 == null || this.f20661a.isInstance(t10)) {
                    return t10;
                }
                throw new v1.u("Expected a " + this.f20661a.getName() + " but was " + t10.getClass().getName() + "; at path " + aVar.getPreviousPath());
            }

            @Override // v1.z
            public void write(d2.d dVar, T1 t10) throws IOException {
                a0.this.f20660b.write(dVar, t10);
            }
        }

        public a0(Class cls, v1.z zVar) {
            this.f20659a = cls;
            this.f20660b = zVar;
        }

        @Override // v1.a0
        public <T2> v1.z<T2> create(v1.e eVar, c2.a<T2> aVar) {
            Class<? super T2> rawType = aVar.getRawType();
            if (this.f20659a.isAssignableFrom(rawType)) {
                return new a(rawType);
            }
            return null;
        }

        public String toString() {
            return "Factory[typeHierarchy=" + this.f20659a.getName() + ",adapter=" + this.f20660b + "]";
        }
    }

    public class b extends v1.z<Number> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // v1.z
        public Number read(d2.a aVar) throws IOException {
            if (aVar.peek() == d2.c.NULL) {
                aVar.nextNull();
                return null;
            }
            try {
                return Long.valueOf(aVar.nextLong());
            } catch (NumberFormatException e10) {
                throw new v1.u(e10);
            }
        }

        @Override // v1.z
        public void write(d2.d dVar, Number number) throws IOException {
            if (number == null) {
                dVar.nullValue();
            } else {
                dVar.value(number.longValue());
            }
        }
    }

    public static /* synthetic */ class b0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20663a;

        static {
            int[] iArr = new int[d2.c.values().length];
            f20663a = iArr;
            try {
                iArr[d2.c.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20663a[d2.c.STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f20663a[d2.c.BOOLEAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f20663a[d2.c.BEGIN_ARRAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f20663a[d2.c.BEGIN_OBJECT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f20663a[d2.c.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public class c extends v1.z<Number> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // v1.z
        public Number read(d2.a aVar) throws IOException {
            if (aVar.peek() != d2.c.NULL) {
                return Float.valueOf((float) aVar.nextDouble());
            }
            aVar.nextNull();
            return null;
        }

        @Override // v1.z
        public void write(d2.d dVar, Number number) throws IOException {
            if (number == null) {
                dVar.nullValue();
                return;
            }
            if (!(number instanceof Float)) {
                number = Float.valueOf(number.floatValue());
            }
            dVar.value(number);
        }
    }

    public class c0 extends v1.z<Boolean> {
        @Override // v1.z
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean read(d2.a aVar) throws IOException {
            d2.c cVarPeek = aVar.peek();
            if (cVarPeek != d2.c.NULL) {
                return cVarPeek == d2.c.STRING ? Boolean.valueOf(Boolean.parseBoolean(aVar.nextString())) : Boolean.valueOf(aVar.nextBoolean());
            }
            aVar.nextNull();
            return null;
        }

        @Override // v1.z
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(d2.d dVar, Boolean bool) throws IOException {
            dVar.value(bool);
        }
    }

    public class d extends v1.z<Number> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // v1.z
        public Number read(d2.a aVar) throws IOException {
            if (aVar.peek() != d2.c.NULL) {
                return Double.valueOf(aVar.nextDouble());
            }
            aVar.nextNull();
            return null;
        }

        @Override // v1.z
        public void write(d2.d dVar, Number number) throws IOException {
            if (number == null) {
                dVar.nullValue();
            } else {
                dVar.value(number.doubleValue());
            }
        }
    }

    public class d0 extends v1.z<Boolean> {
        @Override // v1.z
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean read(d2.a aVar) throws IOException {
            if (aVar.peek() != d2.c.NULL) {
                return Boolean.valueOf(aVar.nextString());
            }
            aVar.nextNull();
            return null;
        }

        @Override // v1.z
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(d2.d dVar, Boolean bool) throws IOException {
            dVar.value(bool == null ? d6.a.E : bool.toString());
        }
    }

    public class e extends v1.z<Character> {
        @Override // v1.z
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Character read(d2.a aVar) throws IOException {
            if (aVar.peek() == d2.c.NULL) {
                aVar.nextNull();
                return null;
            }
            String strNextString = aVar.nextString();
            if (strNextString.length() == 1) {
                return Character.valueOf(strNextString.charAt(0));
            }
            StringBuilder sbA = e.a.a("Expecting character, got: ", strNextString, "; at ");
            sbA.append(aVar.getPreviousPath());
            throw new v1.u(sbA.toString());
        }

        @Override // v1.z
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(d2.d dVar, Character ch2) throws IOException {
            dVar.value(ch2 == null ? null : String.valueOf(ch2));
        }
    }

    public class e0 extends v1.z<Number> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // v1.z
        public Number read(d2.a aVar) throws IOException {
            if (aVar.peek() == d2.c.NULL) {
                aVar.nextNull();
                return null;
            }
            try {
                int iNextInt = aVar.nextInt();
                if (iNextInt <= 255 && iNextInt >= -128) {
                    return Byte.valueOf((byte) iNextInt);
                }
                StringBuilder sbA = h.b.a("Lossy conversion from ", iNextInt, " to byte; at path ");
                sbA.append(aVar.getPreviousPath());
                throw new v1.u(sbA.toString());
            } catch (NumberFormatException e10) {
                throw new v1.u(e10);
            }
        }

        @Override // v1.z
        public void write(d2.d dVar, Number number) throws IOException {
            if (number == null) {
                dVar.nullValue();
            } else {
                dVar.value(number.byteValue());
            }
        }
    }

    public class f extends v1.z<String> {
        @Override // v1.z
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String read(d2.a aVar) throws IOException {
            d2.c cVarPeek = aVar.peek();
            if (cVarPeek != d2.c.NULL) {
                return cVarPeek == d2.c.BOOLEAN ? Boolean.toString(aVar.nextBoolean()) : aVar.nextString();
            }
            aVar.nextNull();
            return null;
        }

        @Override // v1.z
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(d2.d dVar, String str) throws IOException {
            dVar.value(str);
        }
    }

    public class f0 extends v1.z<Number> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // v1.z
        public Number read(d2.a aVar) throws IOException {
            if (aVar.peek() == d2.c.NULL) {
                aVar.nextNull();
                return null;
            }
            try {
                int iNextInt = aVar.nextInt();
                if (iNextInt <= 65535 && iNextInt >= -32768) {
                    return Short.valueOf((short) iNextInt);
                }
                StringBuilder sbA = h.b.a("Lossy conversion from ", iNextInt, " to short; at path ");
                sbA.append(aVar.getPreviousPath());
                throw new v1.u(sbA.toString());
            } catch (NumberFormatException e10) {
                throw new v1.u(e10);
            }
        }

        @Override // v1.z
        public void write(d2.d dVar, Number number) throws IOException {
            if (number == null) {
                dVar.nullValue();
            } else {
                dVar.value(number.shortValue());
            }
        }
    }

    public class g extends v1.z<BigDecimal> {
        @Override // v1.z
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BigDecimal read(d2.a aVar) throws IOException {
            if (aVar.peek() == d2.c.NULL) {
                aVar.nextNull();
                return null;
            }
            String strNextString = aVar.nextString();
            try {
                return new BigDecimal(strNextString);
            } catch (NumberFormatException e10) {
                StringBuilder sbA = e.a.a("Failed parsing '", strNextString, "' as BigDecimal; at path ");
                sbA.append(aVar.getPreviousPath());
                throw new v1.u(sbA.toString(), e10);
            }
        }

        @Override // v1.z
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(d2.d dVar, BigDecimal bigDecimal) throws IOException {
            dVar.value(bigDecimal);
        }
    }

    public class g0 extends v1.z<Number> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // v1.z
        public Number read(d2.a aVar) throws IOException {
            if (aVar.peek() == d2.c.NULL) {
                aVar.nextNull();
                return null;
            }
            try {
                return Integer.valueOf(aVar.nextInt());
            } catch (NumberFormatException e10) {
                throw new v1.u(e10);
            }
        }

        @Override // v1.z
        public void write(d2.d dVar, Number number) throws IOException {
            if (number == null) {
                dVar.nullValue();
            } else {
                dVar.value(number.intValue());
            }
        }
    }

    public class h extends v1.z<BigInteger> {
        @Override // v1.z
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BigInteger read(d2.a aVar) throws IOException {
            if (aVar.peek() == d2.c.NULL) {
                aVar.nextNull();
                return null;
            }
            String strNextString = aVar.nextString();
            try {
                return new BigInteger(strNextString);
            } catch (NumberFormatException e10) {
                StringBuilder sbA = e.a.a("Failed parsing '", strNextString, "' as BigInteger; at path ");
                sbA.append(aVar.getPreviousPath());
                throw new v1.u(sbA.toString(), e10);
            }
        }

        @Override // v1.z
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(d2.d dVar, BigInteger bigInteger) throws IOException {
            dVar.value(bigInteger);
        }
    }

    public class h0 extends v1.z<AtomicInteger> {
        @Override // v1.z
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AtomicInteger read(d2.a aVar) throws IOException {
            try {
                return new AtomicInteger(aVar.nextInt());
            } catch (NumberFormatException e10) {
                throw new v1.u(e10);
            }
        }

        @Override // v1.z
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(d2.d dVar, AtomicInteger atomicInteger) throws IOException {
            dVar.value(atomicInteger.get());
        }
    }

    public class i extends v1.z<x1.h> {
        @Override // v1.z
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public x1.h read(d2.a aVar) throws IOException {
            if (aVar.peek() != d2.c.NULL) {
                return new x1.h(aVar.nextString());
            }
            aVar.nextNull();
            return null;
        }

        @Override // v1.z
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(d2.d dVar, x1.h hVar) throws IOException {
            dVar.value(hVar);
        }
    }

    public class i0 extends v1.z<AtomicBoolean> {
        @Override // v1.z
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AtomicBoolean read(d2.a aVar) throws IOException {
            return new AtomicBoolean(aVar.nextBoolean());
        }

        @Override // v1.z
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(d2.d dVar, AtomicBoolean atomicBoolean) throws IOException {
            dVar.value(atomicBoolean.get());
        }
    }

    public class j extends v1.z<StringBuilder> {
        @Override // v1.z
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public StringBuilder read(d2.a aVar) throws IOException {
            if (aVar.peek() != d2.c.NULL) {
                return new StringBuilder(aVar.nextString());
            }
            aVar.nextNull();
            return null;
        }

        @Override // v1.z
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(d2.d dVar, StringBuilder sb2) throws IOException {
            dVar.value(sb2 == null ? null : sb2.toString());
        }
    }

    public static final class j0<T extends Enum<T>> extends v1.z<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, T> f20664a = new HashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<String, T> f20665b = new HashMap();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map<T, String> f20666c = new HashMap();

        public class a implements PrivilegedAction<Field[]> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Class f20667a;

            public a(Class cls) {
                this.f20667a = cls;
            }

            @Override // java.security.PrivilegedAction
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Field[] run() {
                Field[] declaredFields = this.f20667a.getDeclaredFields();
                ArrayList arrayList = new ArrayList(declaredFields.length);
                for (Field field : declaredFields) {
                    if (field.isEnumConstant()) {
                        arrayList.add(field);
                    }
                }
                Field[] fieldArr = (Field[]) arrayList.toArray(new Field[0]);
                AccessibleObject.setAccessible(fieldArr, true);
                return fieldArr;
            }
        }

        public j0(Class<T> cls) {
            try {
                for (Field field : (Field[]) AccessController.doPrivileged(new a(cls))) {
                    Enum r10 = (Enum) field.get(null);
                    String strName = r10.name();
                    String string = r10.toString();
                    SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
                    if (serializedName != null) {
                        strName = serializedName.value();
                        for (String str : serializedName.alternate()) {
                            this.f20664a.put(str, (T) r10);
                        }
                    }
                    this.f20664a.put(strName, (T) r10);
                    this.f20665b.put(string, (T) r10);
                    this.f20666c.put((T) r10, strName);
                }
            } catch (IllegalAccessException e10) {
                throw new AssertionError(e10);
            }
        }

        @Override // v1.z
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public T read(d2.a aVar) throws IOException {
            if (aVar.peek() == d2.c.NULL) {
                aVar.nextNull();
                return null;
            }
            String strNextString = aVar.nextString();
            T t10 = this.f20664a.get(strNextString);
            return t10 == null ? this.f20665b.get(strNextString) : t10;
        }

        @Override // v1.z
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(d2.d dVar, T t10) throws IOException {
            dVar.value(t10 == null ? null : this.f20666c.get(t10));
        }
    }

    public class k extends v1.z<Class> {
        @Override // v1.z
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Class read(d2.a aVar) throws IOException {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }

        @Override // v1.z
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(d2.d dVar, Class cls) throws IOException {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }
    }

    public class l extends v1.z<StringBuffer> {
        @Override // v1.z
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public StringBuffer read(d2.a aVar) throws IOException {
            if (aVar.peek() != d2.c.NULL) {
                return new StringBuffer(aVar.nextString());
            }
            aVar.nextNull();
            return null;
        }

        @Override // v1.z
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(d2.d dVar, StringBuffer stringBuffer) throws IOException {
            dVar.value(stringBuffer == null ? null : stringBuffer.toString());
        }
    }

    public class m extends v1.z<URL> {
        @Override // v1.z
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public URL read(d2.a aVar) throws IOException {
            if (aVar.peek() == d2.c.NULL) {
                aVar.nextNull();
                return null;
            }
            String strNextString = aVar.nextString();
            if (d6.a.E.equals(strNextString)) {
                return null;
            }
            return new URL(strNextString);
        }

        @Override // v1.z
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(d2.d dVar, URL url) throws IOException {
            dVar.value(url == null ? null : url.toExternalForm());
        }
    }

    public class n extends v1.z<URI> {
        @Override // v1.z
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public URI read(d2.a aVar) throws IOException {
            if (aVar.peek() == d2.c.NULL) {
                aVar.nextNull();
                return null;
            }
            try {
                String strNextString = aVar.nextString();
                if (d6.a.E.equals(strNextString)) {
                    return null;
                }
                return new URI(strNextString);
            } catch (URISyntaxException e10) {
                throw new v1.l(e10);
            }
        }

        @Override // v1.z
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(d2.d dVar, URI uri) throws IOException {
            dVar.value(uri == null ? null : uri.toASCIIString());
        }
    }

    /* JADX INFO: renamed from: y1.o$o, reason: collision with other inner class name */
    public class C0537o extends v1.z<InetAddress> {
        @Override // v1.z
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public InetAddress read(d2.a aVar) throws IOException {
            if (aVar.peek() != d2.c.NULL) {
                return InetAddress.getByName(aVar.nextString());
            }
            aVar.nextNull();
            return null;
        }

        @Override // v1.z
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(d2.d dVar, InetAddress inetAddress) throws IOException {
            dVar.value(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    }

    public class p extends v1.z<UUID> {
        @Override // v1.z
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public UUID read(d2.a aVar) throws IOException {
            if (aVar.peek() == d2.c.NULL) {
                aVar.nextNull();
                return null;
            }
            String strNextString = aVar.nextString();
            try {
                return UUID.fromString(strNextString);
            } catch (IllegalArgumentException e10) {
                StringBuilder sbA = e.a.a("Failed parsing '", strNextString, "' as UUID; at path ");
                sbA.append(aVar.getPreviousPath());
                throw new v1.u(sbA.toString(), e10);
            }
        }

        @Override // v1.z
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(d2.d dVar, UUID uuid) throws IOException {
            dVar.value(uuid == null ? null : uuid.toString());
        }
    }

    public class q extends v1.z<Currency> {
        @Override // v1.z
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Currency read(d2.a aVar) throws IOException {
            String strNextString = aVar.nextString();
            try {
                return Currency.getInstance(strNextString);
            } catch (IllegalArgumentException e10) {
                StringBuilder sbA = e.a.a("Failed parsing '", strNextString, "' as Currency; at path ");
                sbA.append(aVar.getPreviousPath());
                throw new v1.u(sbA.toString(), e10);
            }
        }

        @Override // v1.z
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(d2.d dVar, Currency currency) throws IOException {
            dVar.value(currency.getCurrencyCode());
        }
    }

    public class r extends v1.z<Calendar> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f20669a = "year";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f20670b = "month";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f20671c = "dayOfMonth";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final String f20672d = "hourOfDay";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final String f20673e = "minute";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final String f20674f = "second";

        @Override // v1.z
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Calendar read(d2.a aVar) throws IOException {
            if (aVar.peek() == d2.c.NULL) {
                aVar.nextNull();
                return null;
            }
            aVar.beginObject();
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            while (aVar.peek() != d2.c.END_OBJECT) {
                String strNextName = aVar.nextName();
                int iNextInt = aVar.nextInt();
                if (f20669a.equals(strNextName)) {
                    i10 = iNextInt;
                } else if (f20670b.equals(strNextName)) {
                    i11 = iNextInt;
                } else if (f20671c.equals(strNextName)) {
                    i12 = iNextInt;
                } else if (f20672d.equals(strNextName)) {
                    i13 = iNextInt;
                } else if (f20673e.equals(strNextName)) {
                    i14 = iNextInt;
                } else if (f20674f.equals(strNextName)) {
                    i15 = iNextInt;
                }
            }
            aVar.endObject();
            return new GregorianCalendar(i10, i11, i12, i13, i14, i15);
        }

        @Override // v1.z
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(d2.d dVar, Calendar calendar) throws IOException {
            if (calendar == null) {
                dVar.nullValue();
                return;
            }
            dVar.beginObject();
            dVar.name(f20669a);
            dVar.value(calendar.get(1));
            dVar.name(f20670b);
            dVar.value(calendar.get(2));
            dVar.name(f20671c);
            dVar.value(calendar.get(5));
            dVar.name(f20672d);
            dVar.value(calendar.get(11));
            dVar.name(f20673e);
            dVar.value(calendar.get(12));
            dVar.name(f20674f);
            dVar.value(calendar.get(13));
            dVar.endObject();
        }
    }

    public class s extends v1.z<Locale> {
        @Override // v1.z
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Locale read(d2.a aVar) throws IOException {
            if (aVar.peek() == d2.c.NULL) {
                aVar.nextNull();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(aVar.nextString(), "_");
            String strNextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String strNextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String strNextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            if (strNextToken2 == null && strNextToken3 == null) {
                return new Locale(strNextToken);
            }
            return strNextToken3 == null ? new Locale(strNextToken, strNextToken2) : new Locale(strNextToken, strNextToken2, strNextToken3);
        }

        @Override // v1.z
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(d2.d dVar, Locale locale) throws IOException {
            dVar.value(locale == null ? null : locale.toString());
        }
    }

    public class t extends v1.z<v1.k> {
        @Override // v1.z
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public v1.k read(d2.a aVar) throws IOException {
            if (aVar instanceof y1.f) {
                return ((y1.f) aVar).c();
            }
            d2.c cVarPeek = aVar.peek();
            v1.k kVarC = c(aVar, cVarPeek);
            if (kVarC == null) {
                return b(aVar, cVarPeek);
            }
            ArrayDeque arrayDeque = new ArrayDeque();
            while (true) {
                if (aVar.hasNext()) {
                    String strNextName = kVarC instanceof v1.n ? aVar.nextName() : null;
                    d2.c cVarPeek2 = aVar.peek();
                    v1.k kVarC2 = c(aVar, cVarPeek2);
                    boolean z10 = kVarC2 != null;
                    if (kVarC2 == null) {
                        kVarC2 = b(aVar, cVarPeek2);
                    }
                    if (kVarC instanceof v1.h) {
                        ((v1.h) kVarC).add(kVarC2);
                    } else {
                        ((v1.n) kVarC).add(strNextName, kVarC2);
                    }
                    if (z10) {
                        arrayDeque.addLast(kVarC);
                        kVarC = kVarC2;
                    }
                } else {
                    if (kVarC instanceof v1.h) {
                        aVar.endArray();
                    } else {
                        aVar.endObject();
                    }
                    if (arrayDeque.isEmpty()) {
                        return kVarC;
                    }
                    kVarC = (v1.k) arrayDeque.removeLast();
                }
            }
        }

        public final v1.k b(d2.a aVar, d2.c cVar) throws IOException {
            int i10 = b0.f20663a[cVar.ordinal()];
            if (i10 == 1) {
                return new v1.q(new x1.h(aVar.nextString()));
            }
            if (i10 == 2) {
                return new v1.q(aVar.nextString());
            }
            if (i10 == 3) {
                return new v1.q(Boolean.valueOf(aVar.nextBoolean()));
            }
            if (i10 == 6) {
                aVar.nextNull();
                return v1.m.INSTANCE;
            }
            throw new IllegalStateException("Unexpected token: " + cVar);
        }

        public final v1.k c(d2.a aVar, d2.c cVar) throws IOException {
            int i10 = b0.f20663a[cVar.ordinal()];
            if (i10 == 4) {
                aVar.beginArray();
                return new v1.h();
            }
            if (i10 != 5) {
                return null;
            }
            aVar.beginObject();
            return new v1.n();
        }

        @Override // v1.z
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void write(d2.d dVar, v1.k kVar) throws IOException {
            if (kVar == null || kVar.isJsonNull()) {
                dVar.nullValue();
                return;
            }
            if (kVar.isJsonPrimitive()) {
                v1.q asJsonPrimitive = kVar.getAsJsonPrimitive();
                if (asJsonPrimitive.isNumber()) {
                    dVar.value(asJsonPrimitive.getAsNumber());
                    return;
                } else if (asJsonPrimitive.isBoolean()) {
                    dVar.value(asJsonPrimitive.getAsBoolean());
                    return;
                } else {
                    dVar.value(asJsonPrimitive.getAsString());
                    return;
                }
            }
            if (kVar.isJsonArray()) {
                dVar.beginArray();
                Iterator<v1.k> it = kVar.getAsJsonArray().iterator();
                while (it.hasNext()) {
                    write(dVar, it.next());
                }
                dVar.endArray();
                return;
            }
            if (!kVar.isJsonObject()) {
                throw new IllegalArgumentException("Couldn't write " + kVar.getClass());
            }
            dVar.beginObject();
            for (Map.Entry<String, v1.k> entry : kVar.getAsJsonObject().entrySet()) {
                dVar.name(entry.getKey());
                write(dVar, entry.getValue());
            }
            dVar.endObject();
        }
    }

    public class u implements v1.a0 {
        @Override // v1.a0
        public <T> v1.z<T> create(v1.e eVar, c2.a<T> aVar) {
            Class<? super T> rawType = aVar.getRawType();
            if (!Enum.class.isAssignableFrom(rawType) || rawType == Enum.class) {
                return null;
            }
            if (!rawType.isEnum()) {
                rawType = rawType.getSuperclass();
            }
            return new j0(rawType);
        }
    }

    public class v extends v1.z<BitSet> {
        @Override // v1.z
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BitSet read(d2.a aVar) throws IOException {
            BitSet bitSet = new BitSet();
            aVar.beginArray();
            d2.c cVarPeek = aVar.peek();
            int i10 = 0;
            while (cVarPeek != d2.c.END_ARRAY) {
                int i11 = b0.f20663a[cVarPeek.ordinal()];
                boolean zNextBoolean = true;
                if (i11 == 1 || i11 == 2) {
                    int iNextInt = aVar.nextInt();
                    if (iNextInt == 0) {
                        zNextBoolean = false;
                    } else if (iNextInt != 1) {
                        StringBuilder sbA = h.b.a("Invalid bitset value ", iNextInt, ", expected 0 or 1; at path ");
                        sbA.append(aVar.getPreviousPath());
                        throw new v1.u(sbA.toString());
                    }
                } else {
                    if (i11 != 3) {
                        throw new v1.u("Invalid bitset value type: " + cVarPeek + "; at path " + aVar.getPath());
                    }
                    zNextBoolean = aVar.nextBoolean();
                }
                if (zNextBoolean) {
                    bitSet.set(i10);
                }
                i10++;
                cVarPeek = aVar.peek();
            }
            aVar.endArray();
            return bitSet;
        }

        @Override // v1.z
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(d2.d dVar, BitSet bitSet) throws IOException {
            dVar.beginArray();
            int length = bitSet.length();
            for (int i10 = 0; i10 < length; i10++) {
                dVar.value(bitSet.get(i10) ? 1L : 0L);
            }
            dVar.endArray();
        }
    }

    public class w implements v1.a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c2.a f20675a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ v1.z f20676b;

        public w(c2.a aVar, v1.z zVar) {
            this.f20675a = aVar;
            this.f20676b = zVar;
        }

        @Override // v1.a0
        public <T> v1.z<T> create(v1.e eVar, c2.a<T> aVar) {
            if (aVar.equals(this.f20675a)) {
                return this.f20676b;
            }
            return null;
        }
    }

    public class x implements v1.a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Class f20677a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ v1.z f20678b;

        public x(Class cls, v1.z zVar) {
            this.f20677a = cls;
            this.f20678b = zVar;
        }

        @Override // v1.a0
        public <T> v1.z<T> create(v1.e eVar, c2.a<T> aVar) {
            if (aVar.getRawType() == this.f20677a) {
                return this.f20678b;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f20677a.getName() + ",adapter=" + this.f20678b + "]";
        }
    }

    public class y implements v1.a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Class f20679a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Class f20680b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ v1.z f20681c;

        public y(Class cls, Class cls2, v1.z zVar) {
            this.f20679a = cls;
            this.f20680b = cls2;
            this.f20681c = zVar;
        }

        @Override // v1.a0
        public <T> v1.z<T> create(v1.e eVar, c2.a<T> aVar) {
            Class<? super T> rawType = aVar.getRawType();
            if (rawType == this.f20679a || rawType == this.f20680b) {
                return this.f20681c;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f20680b.getName() + ps.d.ANY_NON_NULL_MARKER + this.f20679a.getName() + ",adapter=" + this.f20681c + "]";
        }
    }

    public class z implements v1.a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Class f20682a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Class f20683b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ v1.z f20684c;

        public z(Class cls, Class cls2, v1.z zVar) {
            this.f20682a = cls;
            this.f20683b = cls2;
            this.f20684c = zVar;
        }

        @Override // v1.a0
        public <T> v1.z<T> create(v1.e eVar, c2.a<T> aVar) {
            Class<? super T> rawType = aVar.getRawType();
            if (rawType == this.f20682a || rawType == this.f20683b) {
                return this.f20684c;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f20682a.getName() + ps.d.ANY_NON_NULL_MARKER + this.f20683b.getName() + ",adapter=" + this.f20684c + "]";
        }
    }

    static {
        v1.z<Class> zVarNullSafe = new k().nullSafe();
        CLASS = zVarNullSafe;
        CLASS_FACTORY = newFactory(Class.class, zVarNullSafe);
        v1.z<BitSet> zVarNullSafe2 = new v().nullSafe();
        BIT_SET = zVarNullSafe2;
        BIT_SET_FACTORY = newFactory(BitSet.class, zVarNullSafe2);
        c0 c0Var = new c0();
        BOOLEAN = c0Var;
        BOOLEAN_AS_STRING = new d0();
        BOOLEAN_FACTORY = newFactory(Boolean.TYPE, Boolean.class, c0Var);
        e0 e0Var = new e0();
        BYTE = e0Var;
        BYTE_FACTORY = newFactory(Byte.TYPE, Byte.class, e0Var);
        f0 f0Var = new f0();
        SHORT = f0Var;
        SHORT_FACTORY = newFactory(Short.TYPE, Short.class, f0Var);
        g0 g0Var = new g0();
        INTEGER = g0Var;
        INTEGER_FACTORY = newFactory(Integer.TYPE, Integer.class, g0Var);
        v1.z<AtomicInteger> zVarNullSafe3 = new h0().nullSafe();
        ATOMIC_INTEGER = zVarNullSafe3;
        ATOMIC_INTEGER_FACTORY = newFactory(AtomicInteger.class, zVarNullSafe3);
        v1.z<AtomicBoolean> zVarNullSafe4 = new i0().nullSafe();
        ATOMIC_BOOLEAN = zVarNullSafe4;
        ATOMIC_BOOLEAN_FACTORY = newFactory(AtomicBoolean.class, zVarNullSafe4);
        v1.z<AtomicIntegerArray> zVarNullSafe5 = new a().nullSafe();
        ATOMIC_INTEGER_ARRAY = zVarNullSafe5;
        ATOMIC_INTEGER_ARRAY_FACTORY = newFactory(AtomicIntegerArray.class, zVarNullSafe5);
        LONG = new b();
        FLOAT = new c();
        DOUBLE = new d();
        e eVar = new e();
        CHARACTER = eVar;
        CHARACTER_FACTORY = newFactory(Character.TYPE, Character.class, eVar);
        f fVar = new f();
        STRING = fVar;
        BIG_DECIMAL = new g();
        BIG_INTEGER = new h();
        LAZILY_PARSED_NUMBER = new i();
        STRING_FACTORY = newFactory(String.class, fVar);
        j jVar = new j();
        STRING_BUILDER = jVar;
        STRING_BUILDER_FACTORY = newFactory(StringBuilder.class, jVar);
        l lVar = new l();
        STRING_BUFFER = lVar;
        STRING_BUFFER_FACTORY = newFactory(StringBuffer.class, lVar);
        m mVar = new m();
        URL = mVar;
        URL_FACTORY = newFactory(URL.class, mVar);
        n nVar = new n();
        URI = nVar;
        URI_FACTORY = newFactory(URI.class, nVar);
        C0537o c0537o = new C0537o();
        INET_ADDRESS = c0537o;
        INET_ADDRESS_FACTORY = newTypeHierarchyFactory(InetAddress.class, c0537o);
        p pVar = new p();
        UUID = pVar;
        UUID_FACTORY = newFactory(UUID.class, pVar);
        v1.z<Currency> zVarNullSafe6 = new q().nullSafe();
        CURRENCY = zVarNullSafe6;
        CURRENCY_FACTORY = newFactory(Currency.class, zVarNullSafe6);
        r rVar = new r();
        CALENDAR = rVar;
        CALENDAR_FACTORY = newFactoryForMultipleTypes(Calendar.class, GregorianCalendar.class, rVar);
        s sVar = new s();
        LOCALE = sVar;
        LOCALE_FACTORY = newFactory(Locale.class, sVar);
        t tVar = new t();
        JSON_ELEMENT = tVar;
        JSON_ELEMENT_FACTORY = newTypeHierarchyFactory(v1.k.class, tVar);
        ENUM_FACTORY = new u();
    }

    private o() {
        throw new UnsupportedOperationException();
    }

    public static <TT> v1.a0 newFactory(c2.a<TT> aVar, v1.z<TT> zVar) {
        return new w(aVar, zVar);
    }

    public static <TT> v1.a0 newFactoryForMultipleTypes(Class<TT> cls, Class<? extends TT> cls2, v1.z<? super TT> zVar) {
        return new z(cls, cls2, zVar);
    }

    public static <T1> v1.a0 newTypeHierarchyFactory(Class<T1> cls, v1.z<T1> zVar) {
        return new a0(cls, zVar);
    }

    public static <TT> v1.a0 newFactory(Class<TT> cls, v1.z<TT> zVar) {
        return new x(cls, zVar);
    }

    public static <TT> v1.a0 newFactory(Class<TT> cls, Class<TT> cls2, v1.z<? super TT> zVar) {
        return new y(cls, cls2, zVar);
    }
}
