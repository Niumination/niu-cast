package nm;

import io.netty.handler.codec.rtsp.RtspHeaders;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import java.util.SortedSet;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes3.dex */
@kn.r1({"SMAP\n_ArraysJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _ArraysJvm.kt\nkotlin/collections/ArraysKt___ArraysJvmKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,3042:1\n13896#2,14:3043\n13919#2,14:3057\n13942#2,14:3071\n13965#2,14:3085\n13988#2,14:3099\n14011#2,14:3113\n14034#2,14:3127\n14057#2,14:3141\n14080#2,14:3155\n16482#2,14:3169\n16505#2,14:3183\n16528#2,14:3197\n16551#2,14:3211\n16574#2,14:3225\n16597#2,14:3239\n16620#2,14:3253\n16643#2,14:3267\n16666#2,14:3281\n*S KotlinDebug\n*F\n+ 1 _ArraysJvm.kt\nkotlin/collections/ArraysKt___ArraysJvmKt\n*L\n2434#1:3043,14\n2441#1:3057,14\n2448#1:3071,14\n2455#1:3085,14\n2462#1:3099,14\n2469#1:3113,14\n2476#1:3127,14\n2483#1:3141,14\n2490#1:3155,14\n2632#1:3169,14\n2639#1:3183,14\n2646#1:3197,14\n2653#1:3211,14\n2660#1:3225,14\n2667#1:3239,14\n2674#1:3253,14\n2681#1:3267,14\n2688#1:3281,14\n*E\n"})
public class p extends n {

    public static final class a extends nm.c<Byte> implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ byte[] f11658b;

        public a(byte[] bArr) {
            this.f11658b = bArr;
        }

        public boolean a(byte b10) {
            return r.m8(this.f11658b, b10);
        }

        @Override // nm.c, java.util.List
        @os.l
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Byte get(int i10) {
            return Byte.valueOf(this.f11658b[i10]);
        }

        @Override // nm.a, java.util.Collection, java.util.List
        public final boolean contains(Object obj) {
            if (!(obj instanceof Byte)) {
                return false;
            }
            return r.m8(this.f11658b, ((Number) obj).byteValue());
        }

        public int e(byte b10) {
            return r.Cf(this.f11658b, b10);
        }

        public int f(byte b10) {
            return r.Gh(this.f11658b, b10);
        }

        @Override // nm.c, nm.a
        public int getSize() {
            return this.f11658b.length;
        }

        @Override // nm.c, java.util.List
        public final int indexOf(Object obj) {
            if (!(obj instanceof Byte)) {
                return -1;
            }
            return r.Cf(this.f11658b, ((Number) obj).byteValue());
        }

        @Override // nm.a, java.util.Collection
        public boolean isEmpty() {
            return this.f11658b.length == 0;
        }

        @Override // nm.c, java.util.List
        public final int lastIndexOf(Object obj) {
            if (!(obj instanceof Byte)) {
                return -1;
            }
            return r.Gh(this.f11658b, ((Number) obj).byteValue());
        }
    }

    public static final class b extends nm.c<Short> implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ short[] f11659b;

        public b(short[] sArr) {
            this.f11659b = sArr;
        }

        public boolean a(short s10) {
            return r.t8(this.f11659b, s10);
        }

        @Override // nm.c, java.util.List
        @os.l
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Short get(int i10) {
            return Short.valueOf(this.f11659b[i10]);
        }

        @Override // nm.a, java.util.Collection, java.util.List
        public final boolean contains(Object obj) {
            if (!(obj instanceof Short)) {
                return false;
            }
            return r.t8(this.f11659b, ((Number) obj).shortValue());
        }

        public int e(short s10) {
            return r.Jf(this.f11659b, s10);
        }

        public int f(short s10) {
            return r.Nh(this.f11659b, s10);
        }

        @Override // nm.c, nm.a
        public int getSize() {
            return this.f11659b.length;
        }

        @Override // nm.c, java.util.List
        public final int indexOf(Object obj) {
            if (!(obj instanceof Short)) {
                return -1;
            }
            return r.Jf(this.f11659b, ((Number) obj).shortValue());
        }

        @Override // nm.a, java.util.Collection
        public boolean isEmpty() {
            return this.f11659b.length == 0;
        }

        @Override // nm.c, java.util.List
        public final int lastIndexOf(Object obj) {
            if (!(obj instanceof Short)) {
                return -1;
            }
            return r.Nh(this.f11659b, ((Number) obj).shortValue());
        }
    }

    public static final class c extends nm.c<Integer> implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f11660b;

        public c(int[] iArr) {
            this.f11660b = iArr;
        }

        public boolean a(int i10) {
            return r.q8(this.f11660b, i10);
        }

        @Override // nm.c, java.util.List
        @os.l
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Integer get(int i10) {
            return Integer.valueOf(this.f11660b[i10]);
        }

        @Override // nm.a, java.util.Collection, java.util.List
        public final boolean contains(Object obj) {
            if (!(obj instanceof Integer)) {
                return false;
            }
            return r.q8(this.f11660b, ((Number) obj).intValue());
        }

        public int e(int i10) {
            return r.Gf(this.f11660b, i10);
        }

        public int f(int i10) {
            return r.Kh(this.f11660b, i10);
        }

        @Override // nm.c, nm.a
        public int getSize() {
            return this.f11660b.length;
        }

        @Override // nm.c, java.util.List
        public final int indexOf(Object obj) {
            if (!(obj instanceof Integer)) {
                return -1;
            }
            return r.Gf(this.f11660b, ((Number) obj).intValue());
        }

        @Override // nm.a, java.util.Collection
        public boolean isEmpty() {
            return this.f11660b.length == 0;
        }

        @Override // nm.c, java.util.List
        public final int lastIndexOf(Object obj) {
            if (!(obj instanceof Integer)) {
                return -1;
            }
            return r.Kh(this.f11660b, ((Number) obj).intValue());
        }
    }

    public static final class d extends nm.c<Long> implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long[] f11661b;

        public d(long[] jArr) {
            this.f11661b = jArr;
        }

        public boolean a(long j10) {
            return r.r8(this.f11661b, j10);
        }

        @Override // nm.c, java.util.List
        @os.l
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Long get(int i10) {
            return Long.valueOf(this.f11661b[i10]);
        }

        @Override // nm.a, java.util.Collection, java.util.List
        public final boolean contains(Object obj) {
            if (!(obj instanceof Long)) {
                return false;
            }
            return r.r8(this.f11661b, ((Number) obj).longValue());
        }

        public int e(long j10) {
            return r.Hf(this.f11661b, j10);
        }

        public int f(long j10) {
            return r.Lh(this.f11661b, j10);
        }

        @Override // nm.c, nm.a
        public int getSize() {
            return this.f11661b.length;
        }

        @Override // nm.c, java.util.List
        public final int indexOf(Object obj) {
            if (!(obj instanceof Long)) {
                return -1;
            }
            return r.Hf(this.f11661b, ((Number) obj).longValue());
        }

        @Override // nm.a, java.util.Collection
        public boolean isEmpty() {
            return this.f11661b.length == 0;
        }

        @Override // nm.c, java.util.List
        public final int lastIndexOf(Object obj) {
            if (!(obj instanceof Long)) {
                return -1;
            }
            return r.Lh(this.f11661b, ((Number) obj).longValue());
        }
    }

    @kn.r1({"SMAP\n_ArraysJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _ArraysJvm.kt\nkotlin/collections/ArraysKt___ArraysJvmKt$asList$5\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,3042:1\n12524#2,2:3043\n1687#2,6:3045\n1795#2,6:3051\n*S KotlinDebug\n*F\n+ 1 _ArraysJvm.kt\nkotlin/collections/ArraysKt___ArraysJvmKt$asList$5\n*L\n199#1:3043,2\n201#1:3045,6\n202#1:3051,6\n*E\n"})
    public static final class e extends nm.c<Float> implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float[] f11662b;

        public e(float[] fArr) {
            this.f11662b = fArr;
        }

        public boolean a(float f10) {
            for (float f11 : this.f11662b) {
                if (Float.floatToIntBits(f11) == Float.floatToIntBits(f10)) {
                    return true;
                }
            }
            return false;
        }

        @Override // nm.c, java.util.List
        @os.l
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Float get(int i10) {
            return Float.valueOf(this.f11662b[i10]);
        }

        @Override // nm.a, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Float) {
                return a(((Number) obj).floatValue());
            }
            return false;
        }

        public int e(float f10) {
            float[] fArr = this.f11662b;
            int length = fArr.length;
            for (int i10 = 0; i10 < length; i10++) {
                if (Float.floatToIntBits(fArr[i10]) == Float.floatToIntBits(f10)) {
                    return i10;
                }
            }
            return -1;
        }

        public int f(float f10) {
            float[] fArr = this.f11662b;
            int length = fArr.length - 1;
            if (length < 0) {
                return -1;
            }
            while (true) {
                int i10 = length - 1;
                if (Float.floatToIntBits(fArr[length]) == Float.floatToIntBits(f10)) {
                    return length;
                }
                if (i10 < 0) {
                    return -1;
                }
                length = i10;
            }
        }

        @Override // nm.c, nm.a
        public int getSize() {
            return this.f11662b.length;
        }

        @Override // nm.c, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Float) {
                return e(((Number) obj).floatValue());
            }
            return -1;
        }

        @Override // nm.a, java.util.Collection
        public boolean isEmpty() {
            return this.f11662b.length == 0;
        }

        @Override // nm.c, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Float) {
                return f(((Number) obj).floatValue());
            }
            return -1;
        }
    }

    @kn.r1({"SMAP\n_ArraysJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _ArraysJvm.kt\nkotlin/collections/ArraysKt___ArraysJvmKt$asList$6\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,3042:1\n12534#2,2:3043\n1699#2,6:3045\n1807#2,6:3051\n*S KotlinDebug\n*F\n+ 1 _ArraysJvm.kt\nkotlin/collections/ArraysKt___ArraysJvmKt$asList$6\n*L\n213#1:3043,2\n215#1:3045,6\n216#1:3051,6\n*E\n"})
    public static final class f extends nm.c<Double> implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ double[] f11663b;

        public f(double[] dArr) {
            this.f11663b = dArr;
        }

        public boolean a(double d10) {
            for (double d11 : this.f11663b) {
                if (Double.doubleToLongBits(d11) == Double.doubleToLongBits(d10)) {
                    return true;
                }
            }
            return false;
        }

        @Override // nm.c, java.util.List
        @os.l
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Double get(int i10) {
            return Double.valueOf(this.f11663b[i10]);
        }

        @Override // nm.a, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Double) {
                return a(((Number) obj).doubleValue());
            }
            return false;
        }

        public int e(double d10) {
            double[] dArr = this.f11663b;
            int length = dArr.length;
            for (int i10 = 0; i10 < length; i10++) {
                if (Double.doubleToLongBits(dArr[i10]) == Double.doubleToLongBits(d10)) {
                    return i10;
                }
            }
            return -1;
        }

        public int f(double d10) {
            double[] dArr = this.f11663b;
            int length = dArr.length - 1;
            if (length < 0) {
                return -1;
            }
            while (true) {
                int i10 = length - 1;
                if (Double.doubleToLongBits(dArr[length]) == Double.doubleToLongBits(d10)) {
                    return length;
                }
                if (i10 < 0) {
                    return -1;
                }
                length = i10;
            }
        }

        @Override // nm.c, nm.a
        public int getSize() {
            return this.f11663b.length;
        }

        @Override // nm.c, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Double) {
                return e(((Number) obj).doubleValue());
            }
            return -1;
        }

        @Override // nm.a, java.util.Collection
        public boolean isEmpty() {
            return this.f11663b.length == 0;
        }

        @Override // nm.c, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Double) {
                return f(((Number) obj).doubleValue());
            }
            return -1;
        }
    }

    public static final class g extends nm.c<Boolean> implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean[] f11664b;

        public g(boolean[] zArr) {
            this.f11664b = zArr;
        }

        public boolean a(boolean z10) {
            return r.u8(this.f11664b, z10);
        }

        @Override // nm.c, java.util.List
        @os.l
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Boolean get(int i10) {
            return Boolean.valueOf(this.f11664b[i10]);
        }

        @Override // nm.a, java.util.Collection, java.util.List
        public final boolean contains(Object obj) {
            if (!(obj instanceof Boolean)) {
                return false;
            }
            return r.u8(this.f11664b, ((Boolean) obj).booleanValue());
        }

        public int e(boolean z10) {
            return r.Kf(this.f11664b, z10);
        }

        public int f(boolean z10) {
            return r.Oh(this.f11664b, z10);
        }

        @Override // nm.c, nm.a
        public int getSize() {
            return this.f11664b.length;
        }

        @Override // nm.c, java.util.List
        public final int indexOf(Object obj) {
            if (!(obj instanceof Boolean)) {
                return -1;
            }
            return r.Kf(this.f11664b, ((Boolean) obj).booleanValue());
        }

        @Override // nm.a, java.util.Collection
        public boolean isEmpty() {
            return this.f11664b.length == 0;
        }

        @Override // nm.c, java.util.List
        public final int lastIndexOf(Object obj) {
            if (!(obj instanceof Boolean)) {
                return -1;
            }
            return r.Oh(this.f11664b, ((Boolean) obj).booleanValue());
        }
    }

    public static final class h extends nm.c<Character> implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ char[] f11665b;

        public h(char[] cArr) {
            this.f11665b = cArr;
        }

        public boolean a(char c10) {
            return r.n8(this.f11665b, c10);
        }

        @Override // nm.c, java.util.List
        @os.l
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Character get(int i10) {
            return Character.valueOf(this.f11665b[i10]);
        }

        @Override // nm.a, java.util.Collection, java.util.List
        public final boolean contains(Object obj) {
            if (!(obj instanceof Character)) {
                return false;
            }
            return r.n8(this.f11665b, ((Character) obj).charValue());
        }

        public int e(char c10) {
            return r.Df(this.f11665b, c10);
        }

        public int f(char c10) {
            return r.Hh(this.f11665b, c10);
        }

        @Override // nm.c, nm.a
        public int getSize() {
            return this.f11665b.length;
        }

        @Override // nm.c, java.util.List
        public final int indexOf(Object obj) {
            if (!(obj instanceof Character)) {
                return -1;
            }
            return r.Df(this.f11665b, ((Character) obj).charValue());
        }

        @Override // nm.a, java.util.Collection
        public boolean isEmpty() {
            return this.f11665b.length == 0;
        }

        @Override // nm.c, java.util.List
        public final int lastIndexOf(Object obj) {
            if (!(obj instanceof Character)) {
                return -1;
            }
            return r.Hh(this.f11665b, ((Character) obj).charValue());
        }
    }

    public static final int A(@os.l int[] iArr, int i10, int i11, int i12) {
        kn.l0.p(iArr, "<this>");
        return Arrays.binarySearch(iArr, i11, i12, i10);
    }

    @lm.f1(version = "1.3")
    @os.l
    public static long[] A0(@os.l long[] jArr, @os.l long[] jArr2, int i10, int i11, int i12) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(jArr2, RtspHeaders.Values.DESTINATION);
        System.arraycopy(jArr, i11, jArr2, i10, i12 - i11);
        return jArr2;
    }

    @an.f
    public static final float A1(float[] fArr, int i10) {
        kn.l0.p(fArr, "<this>");
        return fArr[i10];
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use maxWithOrNull instead.", replaceWith = @lm.a1(expression = "this.maxWithOrNull(comparator)", imports = {}))
    public static final /* synthetic */ Object A2(Object[] objArr, Comparator comparator) {
        kn.l0.p(objArr, "<this>");
        kn.l0.p(comparator, "comparator");
        return r.il(objArr, comparator);
    }

    @os.l
    public static short[] A3(@os.l short[] sArr, short s10) {
        kn.l0.p(sArr, "<this>");
        int length = sArr.length;
        short[] sArrCopyOf = Arrays.copyOf(sArr, length + 1);
        sArrCopyOf[length] = s10;
        kn.l0.m(sArrCopyOf);
        return sArrCopyOf;
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfBigInteger")
    @lm.f1(version = "1.4")
    public static final BigInteger A4(short[] sArr, jn.l<? super Short, ? extends BigInteger> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        kn.l0.o(bigIntegerValueOf, "valueOf(...)");
        for (short s10 : sArr) {
            bigIntegerValueOf = bigIntegerValueOf.add(lVar.invoke(Short.valueOf(s10)));
            kn.l0.o(bigIntegerValueOf, "add(...)");
        }
        return bigIntegerValueOf;
    }

    public static final int B(@os.l long[] jArr, long j10, int i10, int i11) {
        kn.l0.p(jArr, "<this>");
        return Arrays.binarySearch(jArr, i10, i11, j10);
    }

    @lm.f1(version = "1.3")
    @os.l
    public static <T> T[] B0(@os.l T[] tArr, @os.l T[] tArr2, int i10, int i11, int i12) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(tArr2, RtspHeaders.Values.DESTINATION);
        System.arraycopy(tArr, i11, tArr2, i10, i12 - i11);
        return tArr2;
    }

    @an.f
    public static final int B1(int[] iArr, int i10) {
        kn.l0.p(iArr, "<this>");
        return iArr[i10];
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use maxWithOrNull instead.", replaceWith = @lm.a1(expression = "this.maxWithOrNull(comparator)", imports = {}))
    public static final /* synthetic */ Short B2(short[] sArr, Comparator comparator) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(comparator, "comparator");
        return r.jl(sArr, comparator);
    }

    @os.l
    public static short[] B3(@os.l short[] sArr, @os.l short[] sArr2) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(sArr2, "elements");
        int length = sArr.length;
        int length2 = sArr2.length;
        short[] sArrCopyOf = Arrays.copyOf(sArr, length + length2);
        System.arraycopy(sArr2, 0, sArrCopyOf, length, length2);
        kn.l0.m(sArrCopyOf);
        return sArrCopyOf;
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfBigInteger")
    @lm.f1(version = "1.4")
    public static final BigInteger B4(boolean[] zArr, jn.l<? super Boolean, ? extends BigInteger> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        kn.l0.o(bigIntegerValueOf, "valueOf(...)");
        for (boolean z10 : zArr) {
            bigIntegerValueOf = bigIntegerValueOf.add(lVar.invoke(Boolean.valueOf(z10)));
            kn.l0.o(bigIntegerValueOf, "add(...)");
        }
        return bigIntegerValueOf;
    }

    public static final <T> int C(@os.l T[] tArr, T t10, int i10, int i11) {
        kn.l0.p(tArr, "<this>");
        return Arrays.binarySearch(tArr, i10, i11, t10);
    }

    @lm.f1(version = "1.3")
    @os.l
    public static short[] C0(@os.l short[] sArr, @os.l short[] sArr2, int i10, int i11, int i12) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(sArr2, RtspHeaders.Values.DESTINATION);
        System.arraycopy(sArr, i11, sArr2, i10, i12 - i11);
        return sArr2;
    }

    @an.f
    public static final long C1(long[] jArr, int i10) {
        kn.l0.p(jArr, "<this>");
        return jArr[i10];
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use minOrNull instead.", replaceWith = @lm.a1(expression = "this.minOrNull()", imports = {}))
    public static final /* synthetic */ Byte C2(byte[] bArr) {
        kn.l0.p(bArr, "<this>");
        return r.fn(bArr);
    }

    @os.l
    public static final boolean[] C3(@os.l boolean[] zArr, @os.l Collection<Boolean> collection) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(collection, "elements");
        int length = zArr.length;
        boolean[] zArrCopyOf = Arrays.copyOf(zArr, collection.size() + length);
        Iterator<Boolean> it = collection.iterator();
        while (it.hasNext()) {
            zArrCopyOf[length] = it.next().booleanValue();
            length++;
        }
        kn.l0.m(zArrCopyOf);
        return zArrCopyOf;
    }

    @os.l
    public static final SortedSet<Byte> C4(@os.l byte[] bArr) {
        kn.l0.p(bArr, "<this>");
        return (SortedSet) r.jy(bArr, new TreeSet());
    }

    public static final <T> int D(@os.l T[] tArr, T t10, @os.l Comparator<? super T> comparator, int i10, int i11) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(comparator, "comparator");
        return Arrays.binarySearch(tArr, i10, i11, t10, comparator);
    }

    @lm.f1(version = "1.3")
    @os.l
    public static final boolean[] D0(@os.l boolean[] zArr, @os.l boolean[] zArr2, int i10, int i11, int i12) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(zArr2, RtspHeaders.Values.DESTINATION);
        System.arraycopy(zArr, i11, zArr2, i10, i12 - i11);
        return zArr2;
    }

    @an.f
    public static final <T> T D1(T[] tArr, int i10) {
        kn.l0.p(tArr, "<this>");
        return tArr[i10];
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use minOrNull instead.", replaceWith = @lm.a1(expression = "this.minOrNull()", imports = {}))
    public static final /* synthetic */ Character D2(char[] cArr) {
        kn.l0.p(cArr, "<this>");
        return r.gn(cArr);
    }

    @os.l
    public static final boolean[] D3(@os.l boolean[] zArr, boolean z10) {
        kn.l0.p(zArr, "<this>");
        int length = zArr.length;
        boolean[] zArrCopyOf = Arrays.copyOf(zArr, length + 1);
        zArrCopyOf[length] = z10;
        kn.l0.m(zArrCopyOf);
        return zArrCopyOf;
    }

    @os.l
    public static final SortedSet<Character> D4(@os.l char[] cArr) {
        kn.l0.p(cArr, "<this>");
        return (SortedSet) r.ky(cArr, new TreeSet());
    }

    public static final int E(@os.l short[] sArr, short s10, int i10, int i11) {
        kn.l0.p(sArr, "<this>");
        return Arrays.binarySearch(sArr, i10, i11, s10);
    }

    public static /* synthetic */ byte[] E0(byte[] bArr, byte[] bArr2, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = bArr.length;
        }
        return v0(bArr, bArr2, i10, i11, i12);
    }

    @an.f
    public static final short E1(short[] sArr, int i10) {
        kn.l0.p(sArr, "<this>");
        return sArr[i10];
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use minOrNull instead.", replaceWith = @lm.a1(expression = "this.minOrNull()", imports = {}))
    public static final /* synthetic */ Comparable E2(Comparable[] comparableArr) {
        kn.l0.p(comparableArr, "<this>");
        return r.hn(comparableArr);
    }

    @os.l
    public static final boolean[] E3(@os.l boolean[] zArr, @os.l boolean[] zArr2) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(zArr2, "elements");
        int length = zArr.length;
        int length2 = zArr2.length;
        boolean[] zArrCopyOf = Arrays.copyOf(zArr, length + length2);
        System.arraycopy(zArr2, 0, zArrCopyOf, length, length2);
        kn.l0.m(zArrCopyOf);
        return zArrCopyOf;
    }

    @os.l
    public static final SortedSet<Double> E4(@os.l double[] dArr) {
        kn.l0.p(dArr, "<this>");
        return (SortedSet) r.ly(dArr, new TreeSet());
    }

    public static /* synthetic */ int F(byte[] bArr, byte b10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = bArr.length;
        }
        return w(bArr, b10, i10, i11);
    }

    public static /* synthetic */ char[] F0(char[] cArr, char[] cArr2, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = cArr.length;
        }
        return w0(cArr, cArr2, i10, i11, i12);
    }

    @an.f
    public static final boolean F1(boolean[] zArr, int i10) {
        kn.l0.p(zArr, "<this>");
        return zArr[i10];
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use minOrNull instead.", replaceWith = @lm.a1(expression = "this.minOrNull()", imports = {}))
    public static final /* synthetic */ Double F2(double[] dArr) {
        kn.l0.p(dArr, "<this>");
        return r.in(dArr);
    }

    @an.f
    public static final <T> T[] F3(T[] tArr, T t10) {
        kn.l0.p(tArr, "<this>");
        return (T[]) w3(tArr, t10);
    }

    @os.l
    public static final SortedSet<Float> F4(@os.l float[] fArr) {
        kn.l0.p(fArr, "<this>");
        return (SortedSet) r.my(fArr, new TreeSet());
    }

    public static /* synthetic */ int G(char[] cArr, char c10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = cArr.length;
        }
        return x(cArr, c10, i10, i11);
    }

    public static /* synthetic */ double[] G0(double[] dArr, double[] dArr2, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = dArr.length;
        }
        return x0(dArr, dArr2, i10, i11, i12);
    }

    public static void G1(@os.l byte[] bArr, byte b10, int i10, int i11) {
        kn.l0.p(bArr, "<this>");
        Arrays.fill(bArr, i10, i11, b10);
    }

    @lm.f1(version = "1.1")
    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use minOrNull instead.", replaceWith = @lm.a1(expression = "this.minOrNull()", imports = {}))
    public static final /* synthetic */ Double G2(Double[] dArr) {
        kn.l0.p(dArr, "<this>");
        return r.jn(dArr);
    }

    public static final void G3(@os.l byte[] bArr) {
        kn.l0.p(bArr, "<this>");
        if (bArr.length > 1) {
            Arrays.sort(bArr);
        }
    }

    @os.l
    public static final SortedSet<Integer> G4(@os.l int[] iArr) {
        kn.l0.p(iArr, "<this>");
        return (SortedSet) r.ny(iArr, new TreeSet());
    }

    public static /* synthetic */ int H(double[] dArr, double d10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = dArr.length;
        }
        return y(dArr, d10, i10, i11);
    }

    public static /* synthetic */ float[] H0(float[] fArr, float[] fArr2, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = fArr.length;
        }
        return y0(fArr, fArr2, i10, i11, i12);
    }

    public static final void H1(@os.l char[] cArr, char c10, int i10, int i11) {
        kn.l0.p(cArr, "<this>");
        Arrays.fill(cArr, i10, i11, c10);
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use minOrNull instead.", replaceWith = @lm.a1(expression = "this.minOrNull()", imports = {}))
    public static final /* synthetic */ Float H2(float[] fArr) {
        kn.l0.p(fArr, "<this>");
        return r.kn(fArr);
    }

    public static final void H3(@os.l byte[] bArr, int i10, int i11) {
        kn.l0.p(bArr, "<this>");
        Arrays.sort(bArr, i10, i11);
    }

    @os.l
    public static final SortedSet<Long> H4(@os.l long[] jArr) {
        kn.l0.p(jArr, "<this>");
        return (SortedSet) r.oy(jArr, new TreeSet());
    }

    public static /* synthetic */ int I(float[] fArr, float f10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = fArr.length;
        }
        return z(fArr, f10, i10, i11);
    }

    public static /* synthetic */ int[] I0(int[] iArr, int[] iArr2, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = iArr.length;
        }
        return z0(iArr, iArr2, i10, i11, i12);
    }

    public static final void I1(@os.l double[] dArr, double d10, int i10, int i11) {
        kn.l0.p(dArr, "<this>");
        Arrays.fill(dArr, i10, i11, d10);
    }

    @lm.f1(version = "1.1")
    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use minOrNull instead.", replaceWith = @lm.a1(expression = "this.minOrNull()", imports = {}))
    public static final /* synthetic */ Float I2(Float[] fArr) {
        kn.l0.p(fArr, "<this>");
        return r.ln(fArr);
    }

    public static final void I3(@os.l char[] cArr) {
        kn.l0.p(cArr, "<this>");
        if (cArr.length > 1) {
            Arrays.sort(cArr);
        }
    }

    @os.l
    public static final <T extends Comparable<? super T>> SortedSet<T> I4(@os.l T[] tArr) {
        kn.l0.p(tArr, "<this>");
        return (SortedSet) r.py(tArr, new TreeSet());
    }

    public static /* synthetic */ int J(int[] iArr, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i11 = 0;
        }
        if ((i13 & 4) != 0) {
            i12 = iArr.length;
        }
        return A(iArr, i10, i11, i12);
    }

    public static /* synthetic */ long[] J0(long[] jArr, long[] jArr2, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = jArr.length;
        }
        return A0(jArr, jArr2, i10, i11, i12);
    }

    public static final void J1(@os.l float[] fArr, float f10, int i10, int i11) {
        kn.l0.p(fArr, "<this>");
        Arrays.fill(fArr, i10, i11, f10);
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use minOrNull instead.", replaceWith = @lm.a1(expression = "this.minOrNull()", imports = {}))
    public static final /* synthetic */ Integer J2(int[] iArr) {
        kn.l0.p(iArr, "<this>");
        return r.mn(iArr);
    }

    public static final void J3(@os.l char[] cArr, int i10, int i11) {
        kn.l0.p(cArr, "<this>");
        Arrays.sort(cArr, i10, i11);
    }

    @os.l
    public static final <T> SortedSet<T> J4(@os.l T[] tArr, @os.l Comparator<? super T> comparator) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(comparator, "comparator");
        return (SortedSet) r.py(tArr, new TreeSet(comparator));
    }

    public static /* synthetic */ int K(long[] jArr, long j10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = jArr.length;
        }
        return B(jArr, j10, i10, i11);
    }

    public static /* synthetic */ Object[] K0(Object[] objArr, Object[] objArr2, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = objArr.length;
        }
        return B0(objArr, objArr2, i10, i11, i12);
    }

    public static void K1(@os.l int[] iArr, int i10, int i11, int i12) {
        kn.l0.p(iArr, "<this>");
        Arrays.fill(iArr, i11, i12, i10);
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use minOrNull instead.", replaceWith = @lm.a1(expression = "this.minOrNull()", imports = {}))
    public static final /* synthetic */ Long K2(long[] jArr) {
        kn.l0.p(jArr, "<this>");
        return r.nn(jArr);
    }

    public static final void K3(@os.l double[] dArr) {
        kn.l0.p(dArr, "<this>");
        if (dArr.length > 1) {
            Arrays.sort(dArr);
        }
    }

    @os.l
    public static final SortedSet<Short> K4(@os.l short[] sArr) {
        kn.l0.p(sArr, "<this>");
        return (SortedSet) r.qy(sArr, new TreeSet());
    }

    public static /* synthetic */ int L(Object[] objArr, Object obj, int i10, int i11, int i12, Object obj2) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = objArr.length;
        }
        return C(objArr, obj, i10, i11);
    }

    public static /* synthetic */ short[] L0(short[] sArr, short[] sArr2, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = sArr.length;
        }
        return C0(sArr, sArr2, i10, i11, i12);
    }

    public static void L1(@os.l long[] jArr, long j10, int i10, int i11) {
        kn.l0.p(jArr, "<this>");
        Arrays.fill(jArr, i10, i11, j10);
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use minOrNull instead.", replaceWith = @lm.a1(expression = "this.minOrNull()", imports = {}))
    public static final /* synthetic */ Short L2(short[] sArr) {
        kn.l0.p(sArr, "<this>");
        return r.on(sArr);
    }

    public static final void L3(@os.l double[] dArr, int i10, int i11) {
        kn.l0.p(dArr, "<this>");
        Arrays.sort(dArr, i10, i11);
    }

    @os.l
    public static final SortedSet<Boolean> L4(@os.l boolean[] zArr) {
        kn.l0.p(zArr, "<this>");
        return (SortedSet) r.ry(zArr, new TreeSet());
    }

    public static /* synthetic */ int M(Object[] objArr, Object obj, Comparator comparator, int i10, int i11, int i12, Object obj2) {
        if ((i12 & 4) != 0) {
            i10 = 0;
        }
        if ((i12 & 8) != 0) {
            i11 = objArr.length;
        }
        return D(objArr, obj, comparator, i10, i11);
    }

    public static /* synthetic */ boolean[] M0(boolean[] zArr, boolean[] zArr2, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = zArr.length;
        }
        return D0(zArr, zArr2, i10, i11, i12);
    }

    public static final <T> void M1(@os.l T[] tArr, T t10, int i10, int i11) {
        kn.l0.p(tArr, "<this>");
        Arrays.fill(tArr, i10, i11, t10);
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use minByOrNull instead.", replaceWith = @lm.a1(expression = "this.minByOrNull(selector)", imports = {}))
    public static final <R extends Comparable<? super R>> Boolean M2(boolean[] zArr, jn.l<? super Boolean, ? extends R> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (zArr.length == 0) {
            return null;
        }
        boolean z10 = zArr[0];
        int iYe = r.ye(zArr);
        if (iYe == 0) {
            return Boolean.valueOf(z10);
        }
        R rInvoke = lVar.invoke(Boolean.valueOf(z10));
        v0 v0VarA = o.a(1, iYe, 1);
        while (v0VarA.hasNext()) {
            boolean z11 = zArr[v0VarA.nextInt()];
            R rInvoke2 = lVar.invoke(Boolean.valueOf(z11));
            if (rInvoke.compareTo(rInvoke2) > 0) {
                z10 = z11;
                rInvoke = rInvoke2;
            }
        }
        return Boolean.valueOf(z10);
    }

    public static final void M3(@os.l float[] fArr) {
        kn.l0.p(fArr, "<this>");
        if (fArr.length > 1) {
            Arrays.sort(fArr);
        }
    }

    @os.l
    public static final Boolean[] M4(@os.l boolean[] zArr) {
        kn.l0.p(zArr, "<this>");
        Boolean[] boolArr = new Boolean[zArr.length];
        int length = zArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            boolArr[i10] = Boolean.valueOf(zArr[i10]);
        }
        return boolArr;
    }

    public static /* synthetic */ int N(short[] sArr, short s10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = sArr.length;
        }
        return E(sArr, s10, i10, i11);
    }

    @an.f
    public static final byte[] N0(byte[] bArr) {
        kn.l0.p(bArr, "<this>");
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        kn.l0.o(bArrCopyOf, "copyOf(...)");
        return bArrCopyOf;
    }

    public static void N1(@os.l short[] sArr, short s10, int i10, int i11) {
        kn.l0.p(sArr, "<this>");
        Arrays.fill(sArr, i10, i11, s10);
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use minByOrNull instead.", replaceWith = @lm.a1(expression = "this.minByOrNull(selector)", imports = {}))
    public static final <R extends Comparable<? super R>> Byte N2(byte[] bArr, jn.l<? super Byte, ? extends R> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (bArr.length == 0) {
            return null;
        }
        byte b10 = bArr[0];
        int iQe = r.qe(bArr);
        if (iQe == 0) {
            return Byte.valueOf(b10);
        }
        R rInvoke = lVar.invoke(Byte.valueOf(b10));
        v0 v0VarA = o.a(1, iQe, 1);
        while (v0VarA.hasNext()) {
            byte b11 = bArr[v0VarA.nextInt()];
            R rInvoke2 = lVar.invoke(Byte.valueOf(b11));
            if (rInvoke.compareTo(rInvoke2) > 0) {
                b10 = b11;
                rInvoke = rInvoke2;
            }
        }
        return Byte.valueOf(b10);
    }

    public static final void N3(@os.l float[] fArr, int i10, int i11) {
        kn.l0.p(fArr, "<this>");
        Arrays.sort(fArr, i10, i11);
    }

    @os.l
    public static final Byte[] N4(@os.l byte[] bArr) {
        kn.l0.p(bArr, "<this>");
        Byte[] bArr2 = new Byte[bArr.length];
        int length = bArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            bArr2[i10] = Byte.valueOf(bArr[i10]);
        }
        return bArr2;
    }

    @an.h
    @an.f
    @in.i(name = "contentDeepEqualsInline")
    @lm.f1(version = "1.1")
    public static final <T> boolean O(T[] tArr, T[] tArr2) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(tArr2, "other");
        return an.m.a(1, 3, 0) ? n.g(tArr, tArr2) : Arrays.deepEquals(tArr, tArr2);
    }

    @an.f
    public static final byte[] O0(byte[] bArr, int i10) {
        kn.l0.p(bArr, "<this>");
        byte[] bArrCopyOf = Arrays.copyOf(bArr, i10);
        kn.l0.o(bArrCopyOf, "copyOf(...)");
        return bArrCopyOf;
    }

    public static final void O1(@os.l boolean[] zArr, boolean z10, int i10, int i11) {
        kn.l0.p(zArr, "<this>");
        Arrays.fill(zArr, i10, i11, z10);
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use minByOrNull instead.", replaceWith = @lm.a1(expression = "this.minByOrNull(selector)", imports = {}))
    public static final <R extends Comparable<? super R>> Character O2(char[] cArr, jn.l<? super Character, ? extends R> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (cArr.length == 0) {
            return null;
        }
        char c10 = cArr[0];
        int iRe = r.re(cArr);
        if (iRe == 0) {
            return Character.valueOf(c10);
        }
        R rInvoke = lVar.invoke(Character.valueOf(c10));
        v0 v0VarA = o.a(1, iRe, 1);
        while (v0VarA.hasNext()) {
            char c11 = cArr[v0VarA.nextInt()];
            R rInvoke2 = lVar.invoke(Character.valueOf(c11));
            if (rInvoke.compareTo(rInvoke2) > 0) {
                c10 = c11;
                rInvoke = rInvoke2;
            }
        }
        return Character.valueOf(c10);
    }

    public static final void O3(@os.l int[] iArr) {
        kn.l0.p(iArr, "<this>");
        if (iArr.length > 1) {
            Arrays.sort(iArr);
        }
    }

    @os.l
    public static final Character[] O4(@os.l char[] cArr) {
        kn.l0.p(cArr, "<this>");
        Character[] chArr = new Character[cArr.length];
        int length = cArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            chArr[i10] = Character.valueOf(cArr[i10]);
        }
        return chArr;
    }

    @lm.f1(version = "1.4")
    @an.f
    @in.i(name = "contentDeepEqualsNullable")
    public static final <T> boolean P(T[] tArr, T[] tArr2) {
        return an.m.a(1, 3, 0) ? n.g(tArr, tArr2) : Arrays.deepEquals(tArr, tArr2);
    }

    @an.f
    public static final char[] P0(char[] cArr) {
        kn.l0.p(cArr, "<this>");
        char[] cArrCopyOf = Arrays.copyOf(cArr, cArr.length);
        kn.l0.o(cArrCopyOf, "copyOf(...)");
        return cArrCopyOf;
    }

    public static /* synthetic */ void P1(byte[] bArr, byte b10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = bArr.length;
        }
        G1(bArr, b10, i10, i11);
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use minByOrNull instead.", replaceWith = @lm.a1(expression = "this.minByOrNull(selector)", imports = {}))
    public static final <R extends Comparable<? super R>> Double P2(double[] dArr, jn.l<? super Double, ? extends R> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (dArr.length == 0) {
            return null;
        }
        double d10 = dArr[0];
        int iSe = r.se(dArr);
        if (iSe == 0) {
            return Double.valueOf(d10);
        }
        R rInvoke = lVar.invoke(Double.valueOf(d10));
        v0 v0VarA = o.a(1, iSe, 1);
        while (v0VarA.hasNext()) {
            double d11 = dArr[v0VarA.nextInt()];
            R rInvoke2 = lVar.invoke(Double.valueOf(d11));
            if (rInvoke.compareTo(rInvoke2) > 0) {
                d10 = d11;
                rInvoke = rInvoke2;
            }
        }
        return Double.valueOf(d10);
    }

    public static final void P3(@os.l int[] iArr, int i10, int i11) {
        kn.l0.p(iArr, "<this>");
        Arrays.sort(iArr, i10, i11);
    }

    @os.l
    public static final Double[] P4(@os.l double[] dArr) {
        kn.l0.p(dArr, "<this>");
        Double[] dArr2 = new Double[dArr.length];
        int length = dArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            dArr2[i10] = Double.valueOf(dArr[i10]);
        }
        return dArr2;
    }

    @an.h
    @an.f
    @in.i(name = "contentDeepHashCodeInline")
    @lm.f1(version = "1.1")
    public static final <T> int Q(T[] tArr) {
        kn.l0.p(tArr, "<this>");
        return an.m.a(1, 3, 0) ? Arrays.deepHashCode(tArr) : Arrays.deepHashCode(tArr);
    }

    @an.f
    public static final char[] Q0(char[] cArr, int i10) {
        kn.l0.p(cArr, "<this>");
        char[] cArrCopyOf = Arrays.copyOf(cArr, i10);
        kn.l0.o(cArrCopyOf, "copyOf(...)");
        return cArrCopyOf;
    }

    public static /* synthetic */ void Q1(char[] cArr, char c10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = cArr.length;
        }
        H1(cArr, c10, i10, i11);
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use minByOrNull instead.", replaceWith = @lm.a1(expression = "this.minByOrNull(selector)", imports = {}))
    public static final <R extends Comparable<? super R>> Float Q2(float[] fArr, jn.l<? super Float, ? extends R> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (fArr.length == 0) {
            return null;
        }
        float f10 = fArr[0];
        int iTe = r.te(fArr);
        if (iTe == 0) {
            return Float.valueOf(f10);
        }
        R rInvoke = lVar.invoke(Float.valueOf(f10));
        v0 v0VarA = o.a(1, iTe, 1);
        while (v0VarA.hasNext()) {
            float f11 = fArr[v0VarA.nextInt()];
            R rInvoke2 = lVar.invoke(Float.valueOf(f11));
            if (rInvoke.compareTo(rInvoke2) > 0) {
                f10 = f11;
                rInvoke = rInvoke2;
            }
        }
        return Float.valueOf(f10);
    }

    public static final void Q3(@os.l long[] jArr) {
        kn.l0.p(jArr, "<this>");
        if (jArr.length > 1) {
            Arrays.sort(jArr);
        }
    }

    @os.l
    public static final Float[] Q4(@os.l float[] fArr) {
        kn.l0.p(fArr, "<this>");
        Float[] fArr2 = new Float[fArr.length];
        int length = fArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            fArr2[i10] = Float.valueOf(fArr[i10]);
        }
        return fArr2;
    }

    @lm.f1(version = "1.4")
    @an.f
    @in.i(name = "contentDeepHashCodeNullable")
    public static final <T> int R(T[] tArr) {
        return an.m.a(1, 3, 0) ? Arrays.deepHashCode(tArr) : Arrays.deepHashCode(tArr);
    }

    @an.f
    public static final double[] R0(double[] dArr) {
        kn.l0.p(dArr, "<this>");
        double[] dArrCopyOf = Arrays.copyOf(dArr, dArr.length);
        kn.l0.o(dArrCopyOf, "copyOf(...)");
        return dArrCopyOf;
    }

    public static /* synthetic */ void R1(double[] dArr, double d10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = dArr.length;
        }
        I1(dArr, d10, i10, i11);
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use minByOrNull instead.", replaceWith = @lm.a1(expression = "this.minByOrNull(selector)", imports = {}))
    public static final <R extends Comparable<? super R>> Integer R2(int[] iArr, jn.l<? super Integer, ? extends R> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (iArr.length == 0) {
            return null;
        }
        int i10 = iArr[0];
        int iUe = r.ue(iArr);
        if (iUe == 0) {
            return Integer.valueOf(i10);
        }
        R rInvoke = lVar.invoke(Integer.valueOf(i10));
        v0 v0VarA = o.a(1, iUe, 1);
        while (v0VarA.hasNext()) {
            int i11 = iArr[v0VarA.nextInt()];
            R rInvoke2 = lVar.invoke(Integer.valueOf(i11));
            if (rInvoke.compareTo(rInvoke2) > 0) {
                i10 = i11;
                rInvoke = rInvoke2;
            }
        }
        return Integer.valueOf(i10);
    }

    public static final void R3(@os.l long[] jArr, int i10, int i11) {
        kn.l0.p(jArr, "<this>");
        Arrays.sort(jArr, i10, i11);
    }

    @os.l
    public static final Integer[] R4(@os.l int[] iArr) {
        kn.l0.p(iArr, "<this>");
        Integer[] numArr = new Integer[iArr.length];
        int length = iArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            numArr[i10] = Integer.valueOf(iArr[i10]);
        }
        return numArr;
    }

    @an.h
    @an.f
    @in.i(name = "contentDeepToStringInline")
    @lm.f1(version = "1.1")
    public static final <T> String S(T[] tArr) {
        kn.l0.p(tArr, "<this>");
        if (an.m.a(1, 3, 0)) {
            return n.h(tArr);
        }
        String strDeepToString = Arrays.deepToString(tArr);
        kn.l0.o(strDeepToString, "deepToString(...)");
        return strDeepToString;
    }

    @an.f
    public static final double[] S0(double[] dArr, int i10) {
        kn.l0.p(dArr, "<this>");
        double[] dArrCopyOf = Arrays.copyOf(dArr, i10);
        kn.l0.o(dArrCopyOf, "copyOf(...)");
        return dArrCopyOf;
    }

    public static /* synthetic */ void S1(float[] fArr, float f10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = fArr.length;
        }
        J1(fArr, f10, i10, i11);
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use minByOrNull instead.", replaceWith = @lm.a1(expression = "this.minByOrNull(selector)", imports = {}))
    public static final <R extends Comparable<? super R>> Long S2(long[] jArr, jn.l<? super Long, ? extends R> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (jArr.length == 0) {
            return null;
        }
        long j10 = jArr[0];
        int iVe = r.ve(jArr);
        if (iVe == 0) {
            return Long.valueOf(j10);
        }
        R rInvoke = lVar.invoke(Long.valueOf(j10));
        v0 v0VarA = o.a(1, iVe, 1);
        while (v0VarA.hasNext()) {
            long j11 = jArr[v0VarA.nextInt()];
            R rInvoke2 = lVar.invoke(Long.valueOf(j11));
            if (rInvoke.compareTo(rInvoke2) > 0) {
                j10 = j11;
                rInvoke = rInvoke2;
            }
        }
        return Long.valueOf(j10);
    }

    @an.f
    public static final <T extends Comparable<? super T>> void S3(T[] tArr) {
        kn.l0.p(tArr, "<this>");
        U3(tArr);
    }

    @os.l
    public static final Long[] S4(@os.l long[] jArr) {
        kn.l0.p(jArr, "<this>");
        Long[] lArr = new Long[jArr.length];
        int length = jArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            lArr[i10] = Long.valueOf(jArr[i10]);
        }
        return lArr;
    }

    @lm.f1(version = "1.4")
    @an.f
    @in.i(name = "contentDeepToStringNullable")
    public static final <T> String T(T[] tArr) {
        if (an.m.a(1, 3, 0)) {
            return n.h(tArr);
        }
        String strDeepToString = Arrays.deepToString(tArr);
        kn.l0.o(strDeepToString, "deepToString(...)");
        return strDeepToString;
    }

    @an.f
    public static final float[] T0(float[] fArr) {
        kn.l0.p(fArr, "<this>");
        float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
        kn.l0.o(fArrCopyOf, "copyOf(...)");
        return fArrCopyOf;
    }

    public static /* synthetic */ void T1(int[] iArr, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i11 = 0;
        }
        if ((i13 & 4) != 0) {
            i12 = iArr.length;
        }
        K1(iArr, i10, i11, i12);
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use minByOrNull instead.", replaceWith = @lm.a1(expression = "this.minByOrNull(selector)", imports = {}))
    public static final <T, R extends Comparable<? super R>> T T2(T[] tArr, jn.l<? super T, ? extends R> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (tArr.length == 0) {
            return null;
        }
        T t10 = tArr[0];
        int iWe = r.we(tArr);
        if (iWe != 0) {
            R rInvoke = lVar.invoke(t10);
            v0 v0VarA = o.a(1, iWe, 1);
            while (v0VarA.hasNext()) {
                T t11 = tArr[v0VarA.nextInt()];
                R rInvoke2 = lVar.invoke(t11);
                if (rInvoke.compareTo(rInvoke2) > 0) {
                    t10 = t11;
                    rInvoke = rInvoke2;
                }
            }
        }
        return t10;
    }

    @lm.f1(version = "1.4")
    public static final <T extends Comparable<? super T>> void T3(@os.l T[] tArr, int i10, int i11) {
        kn.l0.p(tArr, "<this>");
        Arrays.sort(tArr, i10, i11);
    }

    @os.l
    public static final Short[] T4(@os.l short[] sArr) {
        kn.l0.p(sArr, "<this>");
        Short[] shArr = new Short[sArr.length];
        int length = sArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            shArr[i10] = Short.valueOf(sArr[i10]);
        }
        return shArr;
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final boolean U(byte[] bArr, byte[] bArr2) {
        return Arrays.equals(bArr, bArr2);
    }

    @an.f
    public static final float[] U0(float[] fArr, int i10) {
        kn.l0.p(fArr, "<this>");
        float[] fArrCopyOf = Arrays.copyOf(fArr, i10);
        kn.l0.o(fArrCopyOf, "copyOf(...)");
        return fArrCopyOf;
    }

    public static /* synthetic */ void U1(long[] jArr, long j10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = jArr.length;
        }
        L1(jArr, j10, i10, i11);
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use minByOrNull instead.", replaceWith = @lm.a1(expression = "this.minByOrNull(selector)", imports = {}))
    public static final <R extends Comparable<? super R>> Short U2(short[] sArr, jn.l<? super Short, ? extends R> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (sArr.length == 0) {
            return null;
        }
        short s10 = sArr[0];
        int iXe = r.xe(sArr);
        if (iXe == 0) {
            return Short.valueOf(s10);
        }
        R rInvoke = lVar.invoke(Short.valueOf(s10));
        v0 v0VarA = o.a(1, iXe, 1);
        while (v0VarA.hasNext()) {
            short s11 = sArr[v0VarA.nextInt()];
            R rInvoke2 = lVar.invoke(Short.valueOf(s11));
            if (rInvoke.compareTo(rInvoke2) > 0) {
                s10 = s11;
                rInvoke = rInvoke2;
            }
        }
        return Short.valueOf(s10);
    }

    public static final <T> void U3(@os.l T[] tArr) {
        kn.l0.p(tArr, "<this>");
        if (tArr.length > 1) {
            Arrays.sort(tArr);
        }
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final boolean V(char[] cArr, char[] cArr2) {
        return Arrays.equals(cArr, cArr2);
    }

    @an.f
    public static final int[] V0(int[] iArr) {
        kn.l0.p(iArr, "<this>");
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        kn.l0.o(iArrCopyOf, "copyOf(...)");
        return iArrCopyOf;
    }

    public static /* synthetic */ void V1(Object[] objArr, Object obj, int i10, int i11, int i12, Object obj2) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = objArr.length;
        }
        M1(objArr, obj, i10, i11);
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use minWithOrNull instead.", replaceWith = @lm.a1(expression = "this.minWithOrNull(comparator)", imports = {}))
    public static final /* synthetic */ Boolean V2(boolean[] zArr, Comparator comparator) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(comparator, "comparator");
        return r.zn(zArr, comparator);
    }

    public static final <T> void V3(@os.l T[] tArr, int i10, int i11) {
        kn.l0.p(tArr, "<this>");
        Arrays.sort(tArr, i10, i11);
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final boolean W(double[] dArr, double[] dArr2) {
        return Arrays.equals(dArr, dArr2);
    }

    @an.f
    public static final int[] W0(int[] iArr, int i10) {
        kn.l0.p(iArr, "<this>");
        int[] iArrCopyOf = Arrays.copyOf(iArr, i10);
        kn.l0.o(iArrCopyOf, "copyOf(...)");
        return iArrCopyOf;
    }

    public static /* synthetic */ void W1(short[] sArr, short s10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = sArr.length;
        }
        N1(sArr, s10, i10, i11);
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use minWithOrNull instead.", replaceWith = @lm.a1(expression = "this.minWithOrNull(comparator)", imports = {}))
    public static final /* synthetic */ Byte W2(byte[] bArr, Comparator comparator) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(comparator, "comparator");
        return r.An(bArr, comparator);
    }

    public static final void W3(@os.l short[] sArr) {
        kn.l0.p(sArr, "<this>");
        if (sArr.length > 1) {
            Arrays.sort(sArr);
        }
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final boolean X(float[] fArr, float[] fArr2) {
        return Arrays.equals(fArr, fArr2);
    }

    @an.f
    public static final long[] X0(long[] jArr) {
        kn.l0.p(jArr, "<this>");
        long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
        kn.l0.o(jArrCopyOf, "copyOf(...)");
        return jArrCopyOf;
    }

    public static /* synthetic */ void X1(boolean[] zArr, boolean z10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = zArr.length;
        }
        O1(zArr, z10, i10, i11);
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use minWithOrNull instead.", replaceWith = @lm.a1(expression = "this.minWithOrNull(comparator)", imports = {}))
    public static final /* synthetic */ Character X2(char[] cArr, Comparator comparator) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(comparator, "comparator");
        return r.Bn(cArr, comparator);
    }

    public static final void X3(@os.l short[] sArr, int i10, int i11) {
        kn.l0.p(sArr, "<this>");
        Arrays.sort(sArr, i10, i11);
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final boolean Y(int[] iArr, int[] iArr2) {
        return Arrays.equals(iArr, iArr2);
    }

    @an.f
    public static final long[] Y0(long[] jArr, int i10) {
        kn.l0.p(jArr, "<this>");
        long[] jArrCopyOf = Arrays.copyOf(jArr, i10);
        kn.l0.o(jArrCopyOf, "copyOf(...)");
        return jArrCopyOf;
    }

    @os.l
    public static final <R> List<R> Y1(@os.l Object[] objArr, @os.l Class<R> cls) {
        kn.l0.p(objArr, "<this>");
        kn.l0.p(cls, "klass");
        return (List) Z1(objArr, new ArrayList(), cls);
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use minWithOrNull instead.", replaceWith = @lm.a1(expression = "this.minWithOrNull(comparator)", imports = {}))
    public static final /* synthetic */ Double Y2(double[] dArr, Comparator comparator) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(comparator, "comparator");
        return r.Cn(dArr, comparator);
    }

    public static /* synthetic */ void Y3(byte[] bArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = bArr.length;
        }
        H3(bArr, i10, i11);
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final boolean Z(long[] jArr, long[] jArr2) {
        return Arrays.equals(jArr, jArr2);
    }

    @an.f
    public static final <T> T[] Z0(T[] tArr) {
        kn.l0.p(tArr, "<this>");
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, tArr.length);
        kn.l0.o(tArr2, "copyOf(...)");
        return tArr2;
    }

    @os.l
    public static final <C extends Collection<? super R>, R> C Z1(@os.l Object[] objArr, @os.l C c10, @os.l Class<R> cls) {
        kn.l0.p(objArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(cls, "klass");
        for (Object obj : objArr) {
            if (cls.isInstance(obj)) {
                c10.add(obj);
            }
        }
        return c10;
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use minWithOrNull instead.", replaceWith = @lm.a1(expression = "this.minWithOrNull(comparator)", imports = {}))
    public static final /* synthetic */ Float Z2(float[] fArr, Comparator comparator) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(comparator, "comparator");
        return r.Dn(fArr, comparator);
    }

    public static /* synthetic */ void Z3(char[] cArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = cArr.length;
        }
        J3(cArr, i10, i11);
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final <T> boolean a0(T[] tArr, T[] tArr2) {
        return Arrays.equals(tArr, tArr2);
    }

    @an.f
    public static final <T> T[] a1(T[] tArr, int i10) {
        kn.l0.p(tArr, "<this>");
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, i10);
        kn.l0.o(tArr2, "copyOf(...)");
        return tArr2;
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use maxOrNull instead.", replaceWith = @lm.a1(expression = "this.maxOrNull()", imports = {}))
    public static final /* synthetic */ Byte a2(byte[] bArr) {
        kn.l0.p(bArr, "<this>");
        return r.Hk(bArr);
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use minWithOrNull instead.", replaceWith = @lm.a1(expression = "this.minWithOrNull(comparator)", imports = {}))
    public static final /* synthetic */ Integer a3(int[] iArr, Comparator comparator) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(comparator, "comparator");
        return r.En(iArr, comparator);
    }

    public static /* synthetic */ void a4(double[] dArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = dArr.length;
        }
        L3(dArr, i10, i11);
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final boolean b0(short[] sArr, short[] sArr2) {
        return Arrays.equals(sArr, sArr2);
    }

    @an.f
    public static final short[] b1(short[] sArr) {
        kn.l0.p(sArr, "<this>");
        short[] sArrCopyOf = Arrays.copyOf(sArr, sArr.length);
        kn.l0.o(sArrCopyOf, "copyOf(...)");
        return sArrCopyOf;
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use maxOrNull instead.", replaceWith = @lm.a1(expression = "this.maxOrNull()", imports = {}))
    public static final /* synthetic */ Character b2(char[] cArr) {
        kn.l0.p(cArr, "<this>");
        return r.Ik(cArr);
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use minWithOrNull instead.", replaceWith = @lm.a1(expression = "this.minWithOrNull(comparator)", imports = {}))
    public static final /* synthetic */ Long b3(long[] jArr, Comparator comparator) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(comparator, "comparator");
        return r.Fn(jArr, comparator);
    }

    public static /* synthetic */ void b4(float[] fArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = fArr.length;
        }
        N3(fArr, i10, i11);
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final boolean c0(boolean[] zArr, boolean[] zArr2) {
        return Arrays.equals(zArr, zArr2);
    }

    @an.f
    public static final short[] c1(short[] sArr, int i10) {
        kn.l0.p(sArr, "<this>");
        short[] sArrCopyOf = Arrays.copyOf(sArr, i10);
        kn.l0.o(sArrCopyOf, "copyOf(...)");
        return sArrCopyOf;
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use maxOrNull instead.", replaceWith = @lm.a1(expression = "this.maxOrNull()", imports = {}))
    public static final /* synthetic */ Comparable c2(Comparable[] comparableArr) {
        kn.l0.p(comparableArr, "<this>");
        return r.Jk(comparableArr);
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use minWithOrNull instead.", replaceWith = @lm.a1(expression = "this.minWithOrNull(comparator)", imports = {}))
    public static final /* synthetic */ Object c3(Object[] objArr, Comparator comparator) {
        kn.l0.p(objArr, "<this>");
        kn.l0.p(comparator, "comparator");
        return r.Gn(objArr, comparator);
    }

    public static /* synthetic */ void c4(int[] iArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = iArr.length;
        }
        P3(iArr, i10, i11);
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final int d0(byte[] bArr) {
        return Arrays.hashCode(bArr);
    }

    @an.f
    public static final boolean[] d1(boolean[] zArr) {
        kn.l0.p(zArr, "<this>");
        boolean[] zArrCopyOf = Arrays.copyOf(zArr, zArr.length);
        kn.l0.o(zArrCopyOf, "copyOf(...)");
        return zArrCopyOf;
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use maxOrNull instead.", replaceWith = @lm.a1(expression = "this.maxOrNull()", imports = {}))
    public static final /* synthetic */ Double d2(double[] dArr) {
        kn.l0.p(dArr, "<this>");
        return r.Kk(dArr);
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use minWithOrNull instead.", replaceWith = @lm.a1(expression = "this.minWithOrNull(comparator)", imports = {}))
    public static final /* synthetic */ Short d3(short[] sArr, Comparator comparator) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(comparator, "comparator");
        return r.Hn(sArr, comparator);
    }

    public static /* synthetic */ void d4(long[] jArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = jArr.length;
        }
        R3(jArr, i10, i11);
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final int e0(char[] cArr) {
        return Arrays.hashCode(cArr);
    }

    @an.f
    public static final boolean[] e1(boolean[] zArr, int i10) {
        kn.l0.p(zArr, "<this>");
        boolean[] zArrCopyOf = Arrays.copyOf(zArr, i10);
        kn.l0.o(zArrCopyOf, "copyOf(...)");
        return zArrCopyOf;
    }

    @lm.f1(version = "1.1")
    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use maxOrNull instead.", replaceWith = @lm.a1(expression = "this.maxOrNull()", imports = {}))
    public static final /* synthetic */ Double e2(Double[] dArr) {
        kn.l0.p(dArr, "<this>");
        return r.Lk(dArr);
    }

    @os.l
    public static byte[] e3(@os.l byte[] bArr, byte b10) {
        kn.l0.p(bArr, "<this>");
        int length = bArr.length;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, length + 1);
        bArrCopyOf[length] = b10;
        kn.l0.m(bArrCopyOf);
        return bArrCopyOf;
    }

    public static /* synthetic */ void e4(Comparable[] comparableArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = comparableArr.length;
        }
        T3(comparableArr, i10, i11);
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final int f0(double[] dArr) {
        return Arrays.hashCode(dArr);
    }

    @in.i(name = "copyOfRange")
    @lm.f1(version = "1.3")
    @lm.z0
    @os.l
    public static byte[] f1(@os.l byte[] bArr, int i10, int i11) {
        kn.l0.p(bArr, "<this>");
        m.c(i11, bArr.length);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i10, i11);
        kn.l0.o(bArrCopyOfRange, "copyOfRange(...)");
        return bArrCopyOfRange;
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use maxOrNull instead.", replaceWith = @lm.a1(expression = "this.maxOrNull()", imports = {}))
    public static final /* synthetic */ Float f2(float[] fArr) {
        kn.l0.p(fArr, "<this>");
        return r.Mk(fArr);
    }

    @os.l
    public static final byte[] f3(@os.l byte[] bArr, @os.l Collection<Byte> collection) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(collection, "elements");
        int length = bArr.length;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, collection.size() + length);
        Iterator<Byte> it = collection.iterator();
        while (it.hasNext()) {
            bArrCopyOf[length] = it.next().byteValue();
            length++;
        }
        kn.l0.m(bArrCopyOf);
        return bArrCopyOf;
    }

    public static /* synthetic */ void f4(Object[] objArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = objArr.length;
        }
        V3(objArr, i10, i11);
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final int g0(float[] fArr) {
        return Arrays.hashCode(fArr);
    }

    @in.i(name = "copyOfRange")
    @lm.f1(version = "1.3")
    @lm.z0
    @os.l
    public static final char[] g1(@os.l char[] cArr, int i10, int i11) {
        kn.l0.p(cArr, "<this>");
        m.c(i11, cArr.length);
        char[] cArrCopyOfRange = Arrays.copyOfRange(cArr, i10, i11);
        kn.l0.o(cArrCopyOfRange, "copyOfRange(...)");
        return cArrCopyOfRange;
    }

    @lm.f1(version = "1.1")
    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use maxOrNull instead.", replaceWith = @lm.a1(expression = "this.maxOrNull()", imports = {}))
    public static final /* synthetic */ Float g2(Float[] fArr) {
        kn.l0.p(fArr, "<this>");
        return r.Nk(fArr);
    }

    @os.l
    public static byte[] g3(@os.l byte[] bArr, @os.l byte[] bArr2) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(bArr2, "elements");
        int length = bArr.length;
        int length2 = bArr2.length;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, length + length2);
        System.arraycopy(bArr2, 0, bArrCopyOf, length, length2);
        kn.l0.m(bArrCopyOf);
        return bArrCopyOf;
    }

    public static /* synthetic */ void g4(short[] sArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = sArr.length;
        }
        X3(sArr, i10, i11);
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final int h0(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    @in.i(name = "copyOfRange")
    @lm.f1(version = "1.3")
    @lm.z0
    @os.l
    public static final double[] h1(@os.l double[] dArr, int i10, int i11) {
        kn.l0.p(dArr, "<this>");
        m.c(i11, dArr.length);
        double[] dArrCopyOfRange = Arrays.copyOfRange(dArr, i10, i11);
        kn.l0.o(dArrCopyOfRange, "copyOfRange(...)");
        return dArrCopyOfRange;
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use maxOrNull instead.", replaceWith = @lm.a1(expression = "this.maxOrNull()", imports = {}))
    public static final /* synthetic */ Integer h2(int[] iArr) {
        kn.l0.p(iArr, "<this>");
        return r.Ok(iArr);
    }

    @os.l
    public static final char[] h3(@os.l char[] cArr, char c10) {
        kn.l0.p(cArr, "<this>");
        int length = cArr.length;
        char[] cArrCopyOf = Arrays.copyOf(cArr, length + 1);
        cArrCopyOf[length] = c10;
        kn.l0.m(cArrCopyOf);
        return cArrCopyOf;
    }

    public static final <T> void h4(@os.l T[] tArr, @os.l Comparator<? super T> comparator) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(comparator, "comparator");
        if (tArr.length > 1) {
            Arrays.sort(tArr, comparator);
        }
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final int i0(long[] jArr) {
        return Arrays.hashCode(jArr);
    }

    @in.i(name = "copyOfRange")
    @lm.f1(version = "1.3")
    @lm.z0
    @os.l
    public static final float[] i1(@os.l float[] fArr, int i10, int i11) {
        kn.l0.p(fArr, "<this>");
        m.c(i11, fArr.length);
        float[] fArrCopyOfRange = Arrays.copyOfRange(fArr, i10, i11);
        kn.l0.o(fArrCopyOfRange, "copyOfRange(...)");
        return fArrCopyOfRange;
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use maxOrNull instead.", replaceWith = @lm.a1(expression = "this.maxOrNull()", imports = {}))
    public static final /* synthetic */ Long i2(long[] jArr) {
        kn.l0.p(jArr, "<this>");
        return r.Pk(jArr);
    }

    @os.l
    public static final char[] i3(@os.l char[] cArr, @os.l Collection<Character> collection) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(collection, "elements");
        int length = cArr.length;
        char[] cArrCopyOf = Arrays.copyOf(cArr, collection.size() + length);
        Iterator<Character> it = collection.iterator();
        while (it.hasNext()) {
            cArrCopyOf[length] = it.next().charValue();
            length++;
        }
        kn.l0.m(cArrCopyOf);
        return cArrCopyOf;
    }

    public static final <T> void i4(@os.l T[] tArr, @os.l Comparator<? super T> comparator, int i10, int i11) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(comparator, "comparator");
        Arrays.sort(tArr, i10, i11, comparator);
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final <T> int j0(T[] tArr) {
        return Arrays.hashCode(tArr);
    }

    @in.i(name = "copyOfRange")
    @lm.f1(version = "1.3")
    @lm.z0
    @os.l
    public static int[] j1(@os.l int[] iArr, int i10, int i11) {
        kn.l0.p(iArr, "<this>");
        m.c(i11, iArr.length);
        int[] iArrCopyOfRange = Arrays.copyOfRange(iArr, i10, i11);
        kn.l0.o(iArrCopyOfRange, "copyOfRange(...)");
        return iArrCopyOfRange;
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use maxOrNull instead.", replaceWith = @lm.a1(expression = "this.maxOrNull()", imports = {}))
    public static final /* synthetic */ Short j2(short[] sArr) {
        kn.l0.p(sArr, "<this>");
        return r.Qk(sArr);
    }

    @os.l
    public static final char[] j3(@os.l char[] cArr, @os.l char[] cArr2) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(cArr2, "elements");
        int length = cArr.length;
        int length2 = cArr2.length;
        char[] cArrCopyOf = Arrays.copyOf(cArr, length + length2);
        System.arraycopy(cArr2, 0, cArrCopyOf, length, length2);
        kn.l0.m(cArrCopyOf);
        return cArrCopyOf;
    }

    public static /* synthetic */ void j4(Object[] objArr, Comparator comparator, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = objArr.length;
        }
        i4(objArr, comparator, i10, i11);
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final int k0(short[] sArr) {
        return Arrays.hashCode(sArr);
    }

    @in.i(name = "copyOfRange")
    @lm.f1(version = "1.3")
    @lm.z0
    @os.l
    public static long[] k1(@os.l long[] jArr, int i10, int i11) {
        kn.l0.p(jArr, "<this>");
        m.c(i11, jArr.length);
        long[] jArrCopyOfRange = Arrays.copyOfRange(jArr, i10, i11);
        kn.l0.o(jArrCopyOfRange, "copyOfRange(...)");
        return jArrCopyOfRange;
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use maxByOrNull instead.", replaceWith = @lm.a1(expression = "this.maxByOrNull(selector)", imports = {}))
    public static final <R extends Comparable<? super R>> Boolean k2(boolean[] zArr, jn.l<? super Boolean, ? extends R> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (zArr.length == 0) {
            return null;
        }
        boolean z10 = zArr[0];
        int iYe = r.ye(zArr);
        if (iYe == 0) {
            return Boolean.valueOf(z10);
        }
        R rInvoke = lVar.invoke(Boolean.valueOf(z10));
        v0 v0VarA = o.a(1, iYe, 1);
        while (v0VarA.hasNext()) {
            boolean z11 = zArr[v0VarA.nextInt()];
            R rInvoke2 = lVar.invoke(Boolean.valueOf(z11));
            if (rInvoke.compareTo(rInvoke2) < 0) {
                z10 = z11;
                rInvoke = rInvoke2;
            }
        }
        return Boolean.valueOf(z10);
    }

    @os.l
    public static final double[] k3(@os.l double[] dArr, double d10) {
        kn.l0.p(dArr, "<this>");
        int length = dArr.length;
        double[] dArrCopyOf = Arrays.copyOf(dArr, length + 1);
        dArrCopyOf[length] = d10;
        kn.l0.m(dArrCopyOf);
        return dArrCopyOf;
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfBigDecimal")
    @lm.f1(version = "1.4")
    public static final BigDecimal k4(byte[] bArr, jn.l<? super Byte, ? extends BigDecimal> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        kn.l0.o(bigDecimalValueOf, "valueOf(...)");
        for (byte b10 : bArr) {
            bigDecimalValueOf = bigDecimalValueOf.add(lVar.invoke(Byte.valueOf(b10)));
            kn.l0.o(bigDecimalValueOf, "add(...)");
        }
        return bigDecimalValueOf;
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final int l0(boolean[] zArr) {
        return Arrays.hashCode(zArr);
    }

    @in.i(name = "copyOfRange")
    @lm.f1(version = "1.3")
    @lm.z0
    @os.l
    public static <T> T[] l1(@os.l T[] tArr, int i10, int i11) {
        kn.l0.p(tArr, "<this>");
        m.c(i11, tArr.length);
        T[] tArr2 = (T[]) Arrays.copyOfRange(tArr, i10, i11);
        kn.l0.o(tArr2, "copyOfRange(...)");
        return tArr2;
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use maxByOrNull instead.", replaceWith = @lm.a1(expression = "this.maxByOrNull(selector)", imports = {}))
    public static final <R extends Comparable<? super R>> Byte l2(byte[] bArr, jn.l<? super Byte, ? extends R> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (bArr.length == 0) {
            return null;
        }
        byte b10 = bArr[0];
        int iQe = r.qe(bArr);
        if (iQe == 0) {
            return Byte.valueOf(b10);
        }
        R rInvoke = lVar.invoke(Byte.valueOf(b10));
        v0 v0VarA = o.a(1, iQe, 1);
        while (v0VarA.hasNext()) {
            byte b11 = bArr[v0VarA.nextInt()];
            R rInvoke2 = lVar.invoke(Byte.valueOf(b11));
            if (rInvoke.compareTo(rInvoke2) < 0) {
                b10 = b11;
                rInvoke = rInvoke2;
            }
        }
        return Byte.valueOf(b10);
    }

    @os.l
    public static final double[] l3(@os.l double[] dArr, @os.l Collection<Double> collection) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(collection, "elements");
        int length = dArr.length;
        double[] dArrCopyOf = Arrays.copyOf(dArr, collection.size() + length);
        Iterator<Double> it = collection.iterator();
        while (it.hasNext()) {
            dArrCopyOf[length] = it.next().doubleValue();
            length++;
        }
        kn.l0.m(dArrCopyOf);
        return dArrCopyOf;
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfBigDecimal")
    @lm.f1(version = "1.4")
    public static final BigDecimal l4(char[] cArr, jn.l<? super Character, ? extends BigDecimal> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        kn.l0.o(bigDecimalValueOf, "valueOf(...)");
        for (char c10 : cArr) {
            bigDecimalValueOf = bigDecimalValueOf.add(lVar.invoke(Character.valueOf(c10)));
            kn.l0.o(bigDecimalValueOf, "add(...)");
        }
        return bigDecimalValueOf;
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final String m0(byte[] bArr) {
        String string = Arrays.toString(bArr);
        kn.l0.o(string, "toString(...)");
        return string;
    }

    @in.i(name = "copyOfRange")
    @lm.f1(version = "1.3")
    @lm.z0
    @os.l
    public static short[] m1(@os.l short[] sArr, int i10, int i11) {
        kn.l0.p(sArr, "<this>");
        m.c(i11, sArr.length);
        short[] sArrCopyOfRange = Arrays.copyOfRange(sArr, i10, i11);
        kn.l0.o(sArrCopyOfRange, "copyOfRange(...)");
        return sArrCopyOfRange;
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use maxByOrNull instead.", replaceWith = @lm.a1(expression = "this.maxByOrNull(selector)", imports = {}))
    public static final <R extends Comparable<? super R>> Character m2(char[] cArr, jn.l<? super Character, ? extends R> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (cArr.length == 0) {
            return null;
        }
        char c10 = cArr[0];
        int iRe = r.re(cArr);
        if (iRe == 0) {
            return Character.valueOf(c10);
        }
        R rInvoke = lVar.invoke(Character.valueOf(c10));
        v0 v0VarA = o.a(1, iRe, 1);
        while (v0VarA.hasNext()) {
            char c11 = cArr[v0VarA.nextInt()];
            R rInvoke2 = lVar.invoke(Character.valueOf(c11));
            if (rInvoke.compareTo(rInvoke2) < 0) {
                c10 = c11;
                rInvoke = rInvoke2;
            }
        }
        return Character.valueOf(c10);
    }

    @os.l
    public static final double[] m3(@os.l double[] dArr, @os.l double[] dArr2) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(dArr2, "elements");
        int length = dArr.length;
        int length2 = dArr2.length;
        double[] dArrCopyOf = Arrays.copyOf(dArr, length + length2);
        System.arraycopy(dArr2, 0, dArrCopyOf, length, length2);
        kn.l0.m(dArrCopyOf);
        return dArrCopyOf;
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfBigDecimal")
    @lm.f1(version = "1.4")
    public static final BigDecimal m4(double[] dArr, jn.l<? super Double, ? extends BigDecimal> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        kn.l0.o(bigDecimalValueOf, "valueOf(...)");
        for (double d10 : dArr) {
            bigDecimalValueOf = bigDecimalValueOf.add(lVar.invoke(Double.valueOf(d10)));
            kn.l0.o(bigDecimalValueOf, "add(...)");
        }
        return bigDecimalValueOf;
    }

    @os.l
    public static final List<Byte> n(@os.l byte[] bArr) {
        kn.l0.p(bArr, "<this>");
        return new a(bArr);
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final String n0(char[] cArr) {
        String string = Arrays.toString(cArr);
        kn.l0.o(string, "toString(...)");
        return string;
    }

    @in.i(name = "copyOfRange")
    @lm.f1(version = "1.3")
    @lm.z0
    @os.l
    public static final boolean[] n1(@os.l boolean[] zArr, int i10, int i11) {
        kn.l0.p(zArr, "<this>");
        m.c(i11, zArr.length);
        boolean[] zArrCopyOfRange = Arrays.copyOfRange(zArr, i10, i11);
        kn.l0.o(zArrCopyOfRange, "copyOfRange(...)");
        return zArrCopyOfRange;
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use maxByOrNull instead.", replaceWith = @lm.a1(expression = "this.maxByOrNull(selector)", imports = {}))
    public static final <R extends Comparable<? super R>> Double n2(double[] dArr, jn.l<? super Double, ? extends R> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (dArr.length == 0) {
            return null;
        }
        double d10 = dArr[0];
        int iSe = r.se(dArr);
        if (iSe == 0) {
            return Double.valueOf(d10);
        }
        R rInvoke = lVar.invoke(Double.valueOf(d10));
        v0 v0VarA = o.a(1, iSe, 1);
        while (v0VarA.hasNext()) {
            double d11 = dArr[v0VarA.nextInt()];
            R rInvoke2 = lVar.invoke(Double.valueOf(d11));
            if (rInvoke.compareTo(rInvoke2) < 0) {
                d10 = d11;
                rInvoke = rInvoke2;
            }
        }
        return Double.valueOf(d10);
    }

    @os.l
    public static final float[] n3(@os.l float[] fArr, float f10) {
        kn.l0.p(fArr, "<this>");
        int length = fArr.length;
        float[] fArrCopyOf = Arrays.copyOf(fArr, length + 1);
        fArrCopyOf[length] = f10;
        kn.l0.m(fArrCopyOf);
        return fArrCopyOf;
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfBigDecimal")
    @lm.f1(version = "1.4")
    public static final BigDecimal n4(float[] fArr, jn.l<? super Float, ? extends BigDecimal> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        kn.l0.o(bigDecimalValueOf, "valueOf(...)");
        for (float f10 : fArr) {
            bigDecimalValueOf = bigDecimalValueOf.add(lVar.invoke(Float.valueOf(f10)));
            kn.l0.o(bigDecimalValueOf, "add(...)");
        }
        return bigDecimalValueOf;
    }

    @os.l
    public static final List<Character> o(@os.l char[] cArr) {
        kn.l0.p(cArr, "<this>");
        return new h(cArr);
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final String o0(double[] dArr) {
        String string = Arrays.toString(dArr);
        kn.l0.o(string, "toString(...)");
        return string;
    }

    @an.f
    @in.i(name = "copyOfRangeInline")
    public static final byte[] o1(byte[] bArr, int i10, int i11) {
        kn.l0.p(bArr, "<this>");
        if (an.m.a(1, 3, 0)) {
            return f1(bArr, i10, i11);
        }
        if (i11 <= bArr.length) {
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i10, i11);
            kn.l0.m(bArrCopyOfRange);
            return bArrCopyOfRange;
        }
        StringBuilder sbA = h.b.a("toIndex: ", i11, ", size: ");
        sbA.append(bArr.length);
        throw new IndexOutOfBoundsException(sbA.toString());
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use maxByOrNull instead.", replaceWith = @lm.a1(expression = "this.maxByOrNull(selector)", imports = {}))
    public static final <R extends Comparable<? super R>> Float o2(float[] fArr, jn.l<? super Float, ? extends R> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (fArr.length == 0) {
            return null;
        }
        float f10 = fArr[0];
        int iTe = r.te(fArr);
        if (iTe == 0) {
            return Float.valueOf(f10);
        }
        R rInvoke = lVar.invoke(Float.valueOf(f10));
        v0 v0VarA = o.a(1, iTe, 1);
        while (v0VarA.hasNext()) {
            float f11 = fArr[v0VarA.nextInt()];
            R rInvoke2 = lVar.invoke(Float.valueOf(f11));
            if (rInvoke.compareTo(rInvoke2) < 0) {
                f10 = f11;
                rInvoke = rInvoke2;
            }
        }
        return Float.valueOf(f10);
    }

    @os.l
    public static final float[] o3(@os.l float[] fArr, @os.l Collection<Float> collection) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(collection, "elements");
        int length = fArr.length;
        float[] fArrCopyOf = Arrays.copyOf(fArr, collection.size() + length);
        Iterator<Float> it = collection.iterator();
        while (it.hasNext()) {
            fArrCopyOf[length] = it.next().floatValue();
            length++;
        }
        kn.l0.m(fArrCopyOf);
        return fArrCopyOf;
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfBigDecimal")
    @lm.f1(version = "1.4")
    public static final BigDecimal o4(int[] iArr, jn.l<? super Integer, ? extends BigDecimal> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        kn.l0.o(bigDecimalValueOf, "valueOf(...)");
        for (int i10 : iArr) {
            bigDecimalValueOf = bigDecimalValueOf.add(lVar.invoke(Integer.valueOf(i10)));
            kn.l0.o(bigDecimalValueOf, "add(...)");
        }
        return bigDecimalValueOf;
    }

    @os.l
    public static List<Double> p(@os.l double[] dArr) {
        kn.l0.p(dArr, "<this>");
        return new f(dArr);
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final String p0(float[] fArr) {
        String string = Arrays.toString(fArr);
        kn.l0.o(string, "toString(...)");
        return string;
    }

    @an.f
    @in.i(name = "copyOfRangeInline")
    public static final char[] p1(char[] cArr, int i10, int i11) {
        kn.l0.p(cArr, "<this>");
        if (an.m.a(1, 3, 0)) {
            return g1(cArr, i10, i11);
        }
        if (i11 <= cArr.length) {
            char[] cArrCopyOfRange = Arrays.copyOfRange(cArr, i10, i11);
            kn.l0.m(cArrCopyOfRange);
            return cArrCopyOfRange;
        }
        StringBuilder sbA = h.b.a("toIndex: ", i11, ", size: ");
        sbA.append(cArr.length);
        throw new IndexOutOfBoundsException(sbA.toString());
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use maxByOrNull instead.", replaceWith = @lm.a1(expression = "this.maxByOrNull(selector)", imports = {}))
    public static final <R extends Comparable<? super R>> Integer p2(int[] iArr, jn.l<? super Integer, ? extends R> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (iArr.length == 0) {
            return null;
        }
        int i10 = iArr[0];
        int iUe = r.ue(iArr);
        if (iUe == 0) {
            return Integer.valueOf(i10);
        }
        R rInvoke = lVar.invoke(Integer.valueOf(i10));
        v0 v0VarA = o.a(1, iUe, 1);
        while (v0VarA.hasNext()) {
            int i11 = iArr[v0VarA.nextInt()];
            R rInvoke2 = lVar.invoke(Integer.valueOf(i11));
            if (rInvoke.compareTo(rInvoke2) < 0) {
                i10 = i11;
                rInvoke = rInvoke2;
            }
        }
        return Integer.valueOf(i10);
    }

    @os.l
    public static final float[] p3(@os.l float[] fArr, @os.l float[] fArr2) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(fArr2, "elements");
        int length = fArr.length;
        int length2 = fArr2.length;
        float[] fArrCopyOf = Arrays.copyOf(fArr, length + length2);
        System.arraycopy(fArr2, 0, fArrCopyOf, length, length2);
        kn.l0.m(fArrCopyOf);
        return fArrCopyOf;
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfBigDecimal")
    @lm.f1(version = "1.4")
    public static final BigDecimal p4(long[] jArr, jn.l<? super Long, ? extends BigDecimal> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        kn.l0.o(bigDecimalValueOf, "valueOf(...)");
        for (long j10 : jArr) {
            bigDecimalValueOf = bigDecimalValueOf.add(lVar.invoke(Long.valueOf(j10)));
            kn.l0.o(bigDecimalValueOf, "add(...)");
        }
        return bigDecimalValueOf;
    }

    @os.l
    public static final List<Float> q(@os.l float[] fArr) {
        kn.l0.p(fArr, "<this>");
        return new e(fArr);
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final String q0(int[] iArr) {
        String string = Arrays.toString(iArr);
        kn.l0.o(string, "toString(...)");
        return string;
    }

    @an.f
    @in.i(name = "copyOfRangeInline")
    public static final double[] q1(double[] dArr, int i10, int i11) {
        kn.l0.p(dArr, "<this>");
        if (an.m.a(1, 3, 0)) {
            return h1(dArr, i10, i11);
        }
        if (i11 <= dArr.length) {
            double[] dArrCopyOfRange = Arrays.copyOfRange(dArr, i10, i11);
            kn.l0.m(dArrCopyOfRange);
            return dArrCopyOfRange;
        }
        StringBuilder sbA = h.b.a("toIndex: ", i11, ", size: ");
        sbA.append(dArr.length);
        throw new IndexOutOfBoundsException(sbA.toString());
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use maxByOrNull instead.", replaceWith = @lm.a1(expression = "this.maxByOrNull(selector)", imports = {}))
    public static final <R extends Comparable<? super R>> Long q2(long[] jArr, jn.l<? super Long, ? extends R> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (jArr.length == 0) {
            return null;
        }
        long j10 = jArr[0];
        int iVe = r.ve(jArr);
        if (iVe == 0) {
            return Long.valueOf(j10);
        }
        R rInvoke = lVar.invoke(Long.valueOf(j10));
        v0 v0VarA = o.a(1, iVe, 1);
        while (v0VarA.hasNext()) {
            long j11 = jArr[v0VarA.nextInt()];
            R rInvoke2 = lVar.invoke(Long.valueOf(j11));
            if (rInvoke.compareTo(rInvoke2) < 0) {
                j10 = j11;
                rInvoke = rInvoke2;
            }
        }
        return Long.valueOf(j10);
    }

    @os.l
    public static int[] q3(@os.l int[] iArr, int i10) {
        kn.l0.p(iArr, "<this>");
        int length = iArr.length;
        int[] iArrCopyOf = Arrays.copyOf(iArr, length + 1);
        iArrCopyOf[length] = i10;
        kn.l0.m(iArrCopyOf);
        return iArrCopyOf;
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfBigDecimal")
    @lm.f1(version = "1.4")
    public static final <T> BigDecimal q4(T[] tArr, jn.l<? super T, ? extends BigDecimal> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        kn.l0.o(bigDecimalValueOf, "valueOf(...)");
        for (T t10 : tArr) {
            bigDecimalValueOf = bigDecimalValueOf.add(lVar.invoke(t10));
            kn.l0.o(bigDecimalValueOf, "add(...)");
        }
        return bigDecimalValueOf;
    }

    @os.l
    public static List<Integer> r(@os.l int[] iArr) {
        kn.l0.p(iArr, "<this>");
        return new c(iArr);
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final String r0(long[] jArr) {
        String string = Arrays.toString(jArr);
        kn.l0.o(string, "toString(...)");
        return string;
    }

    @an.f
    @in.i(name = "copyOfRangeInline")
    public static final float[] r1(float[] fArr, int i10, int i11) {
        kn.l0.p(fArr, "<this>");
        if (an.m.a(1, 3, 0)) {
            return i1(fArr, i10, i11);
        }
        if (i11 <= fArr.length) {
            float[] fArrCopyOfRange = Arrays.copyOfRange(fArr, i10, i11);
            kn.l0.m(fArrCopyOfRange);
            return fArrCopyOfRange;
        }
        StringBuilder sbA = h.b.a("toIndex: ", i11, ", size: ");
        sbA.append(fArr.length);
        throw new IndexOutOfBoundsException(sbA.toString());
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use maxByOrNull instead.", replaceWith = @lm.a1(expression = "this.maxByOrNull(selector)", imports = {}))
    public static final <T, R extends Comparable<? super R>> T r2(T[] tArr, jn.l<? super T, ? extends R> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (tArr.length == 0) {
            return null;
        }
        T t10 = tArr[0];
        int iWe = r.we(tArr);
        if (iWe != 0) {
            R rInvoke = lVar.invoke(t10);
            v0 v0VarA = o.a(1, iWe, 1);
            while (v0VarA.hasNext()) {
                T t11 = tArr[v0VarA.nextInt()];
                R rInvoke2 = lVar.invoke(t11);
                if (rInvoke.compareTo(rInvoke2) < 0) {
                    t10 = t11;
                    rInvoke = rInvoke2;
                }
            }
        }
        return t10;
    }

    @os.l
    public static final int[] r3(@os.l int[] iArr, @os.l Collection<Integer> collection) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(collection, "elements");
        int length = iArr.length;
        int[] iArrCopyOf = Arrays.copyOf(iArr, collection.size() + length);
        Iterator<Integer> it = collection.iterator();
        while (it.hasNext()) {
            iArrCopyOf[length] = it.next().intValue();
            length++;
        }
        kn.l0.m(iArrCopyOf);
        return iArrCopyOf;
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfBigDecimal")
    @lm.f1(version = "1.4")
    public static final BigDecimal r4(short[] sArr, jn.l<? super Short, ? extends BigDecimal> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        kn.l0.o(bigDecimalValueOf, "valueOf(...)");
        for (short s10 : sArr) {
            bigDecimalValueOf = bigDecimalValueOf.add(lVar.invoke(Short.valueOf(s10)));
            kn.l0.o(bigDecimalValueOf, "add(...)");
        }
        return bigDecimalValueOf;
    }

    @os.l
    public static List<Long> s(@os.l long[] jArr) {
        kn.l0.p(jArr, "<this>");
        return new d(jArr);
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final <T> String s0(T[] tArr) {
        String string = Arrays.toString(tArr);
        kn.l0.o(string, "toString(...)");
        return string;
    }

    @an.f
    @in.i(name = "copyOfRangeInline")
    public static final int[] s1(int[] iArr, int i10, int i11) {
        kn.l0.p(iArr, "<this>");
        if (an.m.a(1, 3, 0)) {
            return j1(iArr, i10, i11);
        }
        if (i11 <= iArr.length) {
            int[] iArrCopyOfRange = Arrays.copyOfRange(iArr, i10, i11);
            kn.l0.m(iArrCopyOfRange);
            return iArrCopyOfRange;
        }
        StringBuilder sbA = h.b.a("toIndex: ", i11, ", size: ");
        sbA.append(iArr.length);
        throw new IndexOutOfBoundsException(sbA.toString());
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use maxByOrNull instead.", replaceWith = @lm.a1(expression = "this.maxByOrNull(selector)", imports = {}))
    public static final <R extends Comparable<? super R>> Short s2(short[] sArr, jn.l<? super Short, ? extends R> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (sArr.length == 0) {
            return null;
        }
        short s10 = sArr[0];
        int iXe = r.xe(sArr);
        if (iXe == 0) {
            return Short.valueOf(s10);
        }
        R rInvoke = lVar.invoke(Short.valueOf(s10));
        v0 v0VarA = o.a(1, iXe, 1);
        while (v0VarA.hasNext()) {
            short s11 = sArr[v0VarA.nextInt()];
            R rInvoke2 = lVar.invoke(Short.valueOf(s11));
            if (rInvoke.compareTo(rInvoke2) < 0) {
                s10 = s11;
                rInvoke = rInvoke2;
            }
        }
        return Short.valueOf(s10);
    }

    @os.l
    public static int[] s3(@os.l int[] iArr, @os.l int[] iArr2) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(iArr2, "elements");
        int length = iArr.length;
        int length2 = iArr2.length;
        int[] iArrCopyOf = Arrays.copyOf(iArr, length + length2);
        System.arraycopy(iArr2, 0, iArrCopyOf, length, length2);
        kn.l0.m(iArrCopyOf);
        return iArrCopyOf;
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfBigDecimal")
    @lm.f1(version = "1.4")
    public static final BigDecimal s4(boolean[] zArr, jn.l<? super Boolean, ? extends BigDecimal> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        kn.l0.o(bigDecimalValueOf, "valueOf(...)");
        for (boolean z10 : zArr) {
            bigDecimalValueOf = bigDecimalValueOf.add(lVar.invoke(Boolean.valueOf(z10)));
            kn.l0.o(bigDecimalValueOf, "add(...)");
        }
        return bigDecimalValueOf;
    }

    @os.l
    public static <T> List<T> t(@os.l T[] tArr) {
        kn.l0.p(tArr, "<this>");
        List<T> listAsList = Arrays.asList(tArr);
        kn.l0.o(listAsList, "asList(...)");
        return listAsList;
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final String t0(short[] sArr) {
        String string = Arrays.toString(sArr);
        kn.l0.o(string, "toString(...)");
        return string;
    }

    @an.f
    @in.i(name = "copyOfRangeInline")
    public static final long[] t1(long[] jArr, int i10, int i11) {
        kn.l0.p(jArr, "<this>");
        if (an.m.a(1, 3, 0)) {
            return k1(jArr, i10, i11);
        }
        if (i11 <= jArr.length) {
            long[] jArrCopyOfRange = Arrays.copyOfRange(jArr, i10, i11);
            kn.l0.m(jArrCopyOfRange);
            return jArrCopyOfRange;
        }
        StringBuilder sbA = h.b.a("toIndex: ", i11, ", size: ");
        sbA.append(jArr.length);
        throw new IndexOutOfBoundsException(sbA.toString());
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use maxWithOrNull instead.", replaceWith = @lm.a1(expression = "this.maxWithOrNull(comparator)", imports = {}))
    public static final /* synthetic */ Boolean t2(boolean[] zArr, Comparator comparator) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(comparator, "comparator");
        return r.bl(zArr, comparator);
    }

    @os.l
    public static long[] t3(@os.l long[] jArr, long j10) {
        kn.l0.p(jArr, "<this>");
        int length = jArr.length;
        long[] jArrCopyOf = Arrays.copyOf(jArr, length + 1);
        jArrCopyOf[length] = j10;
        kn.l0.m(jArrCopyOf);
        return jArrCopyOf;
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfBigInteger")
    @lm.f1(version = "1.4")
    public static final BigInteger t4(byte[] bArr, jn.l<? super Byte, ? extends BigInteger> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        kn.l0.o(bigIntegerValueOf, "valueOf(...)");
        for (byte b10 : bArr) {
            bigIntegerValueOf = bigIntegerValueOf.add(lVar.invoke(Byte.valueOf(b10)));
            kn.l0.o(bigIntegerValueOf, "add(...)");
        }
        return bigIntegerValueOf;
    }

    @os.l
    public static final List<Short> u(@os.l short[] sArr) {
        kn.l0.p(sArr, "<this>");
        return new b(sArr);
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final String u0(boolean[] zArr) {
        String string = Arrays.toString(zArr);
        kn.l0.o(string, "toString(...)");
        return string;
    }

    @an.f
    @in.i(name = "copyOfRangeInline")
    public static final <T> T[] u1(T[] tArr, int i10, int i11) {
        kn.l0.p(tArr, "<this>");
        if (an.m.a(1, 3, 0)) {
            return (T[]) l1(tArr, i10, i11);
        }
        if (i11 <= tArr.length) {
            T[] tArr2 = (T[]) Arrays.copyOfRange(tArr, i10, i11);
            kn.l0.m(tArr2);
            return tArr2;
        }
        StringBuilder sbA = h.b.a("toIndex: ", i11, ", size: ");
        sbA.append(tArr.length);
        throw new IndexOutOfBoundsException(sbA.toString());
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use maxWithOrNull instead.", replaceWith = @lm.a1(expression = "this.maxWithOrNull(comparator)", imports = {}))
    public static final /* synthetic */ Byte u2(byte[] bArr, Comparator comparator) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(comparator, "comparator");
        return r.cl(bArr, comparator);
    }

    @os.l
    public static final long[] u3(@os.l long[] jArr, @os.l Collection<Long> collection) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(collection, "elements");
        int length = jArr.length;
        long[] jArrCopyOf = Arrays.copyOf(jArr, collection.size() + length);
        Iterator<Long> it = collection.iterator();
        while (it.hasNext()) {
            jArrCopyOf[length] = it.next().longValue();
            length++;
        }
        kn.l0.m(jArrCopyOf);
        return jArrCopyOf;
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfBigInteger")
    @lm.f1(version = "1.4")
    public static final BigInteger u4(char[] cArr, jn.l<? super Character, ? extends BigInteger> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        kn.l0.o(bigIntegerValueOf, "valueOf(...)");
        for (char c10 : cArr) {
            bigIntegerValueOf = bigIntegerValueOf.add(lVar.invoke(Character.valueOf(c10)));
            kn.l0.o(bigIntegerValueOf, "add(...)");
        }
        return bigIntegerValueOf;
    }

    @os.l
    public static final List<Boolean> v(@os.l boolean[] zArr) {
        kn.l0.p(zArr, "<this>");
        return new g(zArr);
    }

    @lm.f1(version = "1.3")
    @os.l
    public static byte[] v0(@os.l byte[] bArr, @os.l byte[] bArr2, int i10, int i11, int i12) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(bArr2, RtspHeaders.Values.DESTINATION);
        System.arraycopy(bArr, i11, bArr2, i10, i12 - i11);
        return bArr2;
    }

    @an.f
    @in.i(name = "copyOfRangeInline")
    public static final short[] v1(short[] sArr, int i10, int i11) {
        kn.l0.p(sArr, "<this>");
        if (an.m.a(1, 3, 0)) {
            return m1(sArr, i10, i11);
        }
        if (i11 <= sArr.length) {
            short[] sArrCopyOfRange = Arrays.copyOfRange(sArr, i10, i11);
            kn.l0.m(sArrCopyOfRange);
            return sArrCopyOfRange;
        }
        StringBuilder sbA = h.b.a("toIndex: ", i11, ", size: ");
        sbA.append(sArr.length);
        throw new IndexOutOfBoundsException(sbA.toString());
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use maxWithOrNull instead.", replaceWith = @lm.a1(expression = "this.maxWithOrNull(comparator)", imports = {}))
    public static final /* synthetic */ Character v2(char[] cArr, Comparator comparator) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(comparator, "comparator");
        return r.dl(cArr, comparator);
    }

    @os.l
    public static long[] v3(@os.l long[] jArr, @os.l long[] jArr2) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(jArr2, "elements");
        int length = jArr.length;
        int length2 = jArr2.length;
        long[] jArrCopyOf = Arrays.copyOf(jArr, length + length2);
        System.arraycopy(jArr2, 0, jArrCopyOf, length, length2);
        kn.l0.m(jArrCopyOf);
        return jArrCopyOf;
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfBigInteger")
    @lm.f1(version = "1.4")
    public static final BigInteger v4(double[] dArr, jn.l<? super Double, ? extends BigInteger> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        kn.l0.o(bigIntegerValueOf, "valueOf(...)");
        for (double d10 : dArr) {
            bigIntegerValueOf = bigIntegerValueOf.add(lVar.invoke(Double.valueOf(d10)));
            kn.l0.o(bigIntegerValueOf, "add(...)");
        }
        return bigIntegerValueOf;
    }

    public static final int w(@os.l byte[] bArr, byte b10, int i10, int i11) {
        kn.l0.p(bArr, "<this>");
        return Arrays.binarySearch(bArr, i10, i11, b10);
    }

    @lm.f1(version = "1.3")
    @os.l
    public static final char[] w0(@os.l char[] cArr, @os.l char[] cArr2, int i10, int i11, int i12) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(cArr2, RtspHeaders.Values.DESTINATION);
        System.arraycopy(cArr, i11, cArr2, i10, i12 - i11);
        return cArr2;
    }

    @an.f
    @in.i(name = "copyOfRangeInline")
    public static final boolean[] w1(boolean[] zArr, int i10, int i11) {
        kn.l0.p(zArr, "<this>");
        if (an.m.a(1, 3, 0)) {
            return n1(zArr, i10, i11);
        }
        if (i11 <= zArr.length) {
            boolean[] zArrCopyOfRange = Arrays.copyOfRange(zArr, i10, i11);
            kn.l0.m(zArrCopyOfRange);
            return zArrCopyOfRange;
        }
        StringBuilder sbA = h.b.a("toIndex: ", i11, ", size: ");
        sbA.append(zArr.length);
        throw new IndexOutOfBoundsException(sbA.toString());
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use maxWithOrNull instead.", replaceWith = @lm.a1(expression = "this.maxWithOrNull(comparator)", imports = {}))
    public static final /* synthetic */ Double w2(double[] dArr, Comparator comparator) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(comparator, "comparator");
        return r.el(dArr, comparator);
    }

    @os.l
    public static final <T> T[] w3(@os.l T[] tArr, T t10) {
        kn.l0.p(tArr, "<this>");
        int length = tArr.length;
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, length + 1);
        tArr2[length] = t10;
        kn.l0.m(tArr2);
        return tArr2;
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfBigInteger")
    @lm.f1(version = "1.4")
    public static final BigInteger w4(float[] fArr, jn.l<? super Float, ? extends BigInteger> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        kn.l0.o(bigIntegerValueOf, "valueOf(...)");
        for (float f10 : fArr) {
            bigIntegerValueOf = bigIntegerValueOf.add(lVar.invoke(Float.valueOf(f10)));
            kn.l0.o(bigIntegerValueOf, "add(...)");
        }
        return bigIntegerValueOf;
    }

    public static int x(@os.l char[] cArr, char c10, int i10, int i11) {
        kn.l0.p(cArr, "<this>");
        return Arrays.binarySearch(cArr, i10, i11, c10);
    }

    @lm.f1(version = "1.3")
    @os.l
    public static final double[] x0(@os.l double[] dArr, @os.l double[] dArr2, int i10, int i11, int i12) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(dArr2, RtspHeaders.Values.DESTINATION);
        System.arraycopy(dArr, i11, dArr2, i10, i12 - i11);
        return dArr2;
    }

    @an.f
    public static final byte x1(byte[] bArr, int i10) {
        kn.l0.p(bArr, "<this>");
        return bArr[i10];
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use maxWithOrNull instead.", replaceWith = @lm.a1(expression = "this.maxWithOrNull(comparator)", imports = {}))
    public static final /* synthetic */ Float x2(float[] fArr, Comparator comparator) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(comparator, "comparator");
        return r.fl(fArr, comparator);
    }

    @os.l
    public static final <T> T[] x3(@os.l T[] tArr, @os.l Collection<? extends T> collection) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(collection, "elements");
        int length = tArr.length;
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, collection.size() + length);
        Iterator<? extends T> it = collection.iterator();
        while (it.hasNext()) {
            tArr2[length] = it.next();
            length++;
        }
        kn.l0.m(tArr2);
        return tArr2;
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfBigInteger")
    @lm.f1(version = "1.4")
    public static final BigInteger x4(int[] iArr, jn.l<? super Integer, ? extends BigInteger> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        kn.l0.o(bigIntegerValueOf, "valueOf(...)");
        for (int i10 : iArr) {
            bigIntegerValueOf = bigIntegerValueOf.add(lVar.invoke(Integer.valueOf(i10)));
            kn.l0.o(bigIntegerValueOf, "add(...)");
        }
        return bigIntegerValueOf;
    }

    public static final int y(@os.l double[] dArr, double d10, int i10, int i11) {
        kn.l0.p(dArr, "<this>");
        return Arrays.binarySearch(dArr, i10, i11, d10);
    }

    @lm.f1(version = "1.3")
    @os.l
    public static final float[] y0(@os.l float[] fArr, @os.l float[] fArr2, int i10, int i11, int i12) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(fArr2, RtspHeaders.Values.DESTINATION);
        System.arraycopy(fArr, i11, fArr2, i10, i12 - i11);
        return fArr2;
    }

    @an.f
    public static final char y1(char[] cArr, int i10) {
        kn.l0.p(cArr, "<this>");
        return cArr[i10];
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use maxWithOrNull instead.", replaceWith = @lm.a1(expression = "this.maxWithOrNull(comparator)", imports = {}))
    public static final /* synthetic */ Integer y2(int[] iArr, Comparator comparator) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(comparator, "comparator");
        return r.gl(iArr, comparator);
    }

    @os.l
    public static final <T> T[] y3(@os.l T[] tArr, @os.l T[] tArr2) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(tArr2, "elements");
        int length = tArr.length;
        int length2 = tArr2.length;
        T[] tArr3 = (T[]) Arrays.copyOf(tArr, length + length2);
        System.arraycopy(tArr2, 0, tArr3, length, length2);
        kn.l0.m(tArr3);
        return tArr3;
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfBigInteger")
    @lm.f1(version = "1.4")
    public static final BigInteger y4(long[] jArr, jn.l<? super Long, ? extends BigInteger> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        kn.l0.o(bigIntegerValueOf, "valueOf(...)");
        for (long j10 : jArr) {
            bigIntegerValueOf = bigIntegerValueOf.add(lVar.invoke(Long.valueOf(j10)));
            kn.l0.o(bigIntegerValueOf, "add(...)");
        }
        return bigIntegerValueOf;
    }

    public static final int z(@os.l float[] fArr, float f10, int i10, int i11) {
        kn.l0.p(fArr, "<this>");
        return Arrays.binarySearch(fArr, i10, i11, f10);
    }

    @lm.f1(version = "1.3")
    @os.l
    public static int[] z0(@os.l int[] iArr, @os.l int[] iArr2, int i10, int i11, int i12) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(iArr2, RtspHeaders.Values.DESTINATION);
        System.arraycopy(iArr, i11, iArr2, i10, i12 - i11);
        return iArr2;
    }

    @an.f
    public static final double z1(double[] dArr, int i10) {
        kn.l0.p(dArr, "<this>");
        return dArr[i10];
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use maxWithOrNull instead.", replaceWith = @lm.a1(expression = "this.maxWithOrNull(comparator)", imports = {}))
    public static final /* synthetic */ Long z2(long[] jArr, Comparator comparator) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(comparator, "comparator");
        return r.hl(jArr, comparator);
    }

    @os.l
    public static final short[] z3(@os.l short[] sArr, @os.l Collection<Short> collection) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(collection, "elements");
        int length = sArr.length;
        short[] sArrCopyOf = Arrays.copyOf(sArr, collection.size() + length);
        Iterator<Short> it = collection.iterator();
        while (it.hasNext()) {
            sArrCopyOf[length] = it.next().shortValue();
            length++;
        }
        kn.l0.m(sArrCopyOf);
        return sArrCopyOf;
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfBigInteger")
    @lm.f1(version = "1.4")
    public static final <T> BigInteger z4(T[] tArr, jn.l<? super T, ? extends BigInteger> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        kn.l0.o(bigIntegerValueOf, "valueOf(...)");
        for (T t10 : tArr) {
            bigIntegerValueOf = bigIntegerValueOf.add(lVar.invoke(t10));
            kn.l0.o(bigIntegerValueOf, "add(...)");
        }
        return bigIntegerValueOf;
    }
}
