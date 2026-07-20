package f1;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@x0
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte f4864a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f4865b = 5;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f4866c = 32;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f4867d = 31;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f4868e = 1073741823;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f4869f = 3;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f4870g = 4;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f4871h = 256;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f4872i = 255;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f4873j = 65536;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f4874k = 65535;

    public static Object a(int buckets) {
        if (buckets < 2 || buckets > 1073741824 || Integer.highestOneBit(buckets) != buckets) {
            throw new IllegalArgumentException(h.a.a("must be power of 2 between 2^1 and 2^30: ", buckets));
        }
        if (buckets <= 256) {
            return new byte[buckets];
        }
        return buckets <= 65536 ? new short[buckets] : new int[buckets];
    }

    public static int b(int value, int mask) {
        return value & (~mask);
    }

    public static int c(int entry, int mask) {
        return entry & mask;
    }

    public static int d(int prefix, int suffix, int mask) {
        return (prefix & (~mask)) | (suffix & mask);
    }

    public static int e(int mask) {
        return (mask + 1) * (mask < 32 ? 4 : 2);
    }

    public static int f(@gm.a Object key, @gm.a Object value, int mask, Object table, int[] entries, Object[] keys, @gm.a Object[] values) {
        int iD = z2.d(key);
        int i10 = iD & mask;
        int iH = h(table, i10);
        if (iH == 0) {
            return -1;
        }
        int i11 = ~mask;
        int i12 = iD & i11;
        int i13 = -1;
        while (true) {
            int i14 = iH - 1;
            int i15 = entries[i14];
            if ((i15 & i11) == i12 && c1.b0.a(key, keys[i14]) && (values == null || c1.b0.a(value, values[i14]))) {
                int i16 = i15 & mask;
                if (i13 == -1) {
                    i(table, i10, i16);
                } else {
                    entries[i13] = d(entries[i13], i16, mask);
                }
                return i14;
            }
            int i17 = i15 & mask;
            if (i17 == 0) {
                return -1;
            }
            i13 = i14;
            iH = i17;
        }
    }

    public static void g(Object table) {
        if (table instanceof byte[]) {
            Arrays.fill((byte[]) table, (byte) 0);
        } else if (table instanceof short[]) {
            Arrays.fill((short[]) table, (short) 0);
        } else {
            Arrays.fill((int[]) table, 0);
        }
    }

    public static int h(Object table, int index) {
        if (table instanceof byte[]) {
            return ((byte[]) table)[index] & 255;
        }
        return table instanceof short[] ? ((short[]) table)[index] & lm.g2.f10190d : ((int[]) table)[index];
    }

    public static void i(Object table, int index, int entry) {
        if (table instanceof byte[]) {
            ((byte[]) table)[index] = (byte) entry;
        } else if (table instanceof short[]) {
            ((short[]) table)[index] = (short) entry;
        } else {
            ((int[]) table)[index] = entry;
        }
    }

    public static int j(int expectedSize) {
        return Math.max(4, z2.a(expectedSize + 1, 1.0d));
    }
}
