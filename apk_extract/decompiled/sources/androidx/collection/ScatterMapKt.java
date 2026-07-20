package androidx.collection;

import a1.a;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0001\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u001e\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u00190\u0017\"\u0004\b\u0000\u0010\u0018\"\u0004\b\u0001\u0010\u0019\u001a\u001d\u0010\u001a\u001a\u00060\u0001j\u0002`\u001b2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\bH\u0080\b\u001a\u0011\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\bH\u0080\b\u001a\u0011\u0010 \u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\bH\u0080\b\u001a\u0013\u0010\u001f\u001a\u00020\b2\b\u0010!\u001a\u0004\u0018\u00010\u0010H\u0080\b\u001a\u0019\u0010\"\u001a\u00020#2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010$\u001a\u00020\bH\u0080\b\u001a\u0019\u0010%\u001a\u00020#2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010$\u001a\u00020\bH\u0080\b\u001a\u0011\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020\u0001H\u0081\b\u001a\u0019\u0010&\u001a\u00020#2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010$\u001a\u00020\bH\u0080\b\u001a\u0010\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\bH\u0000\u001a\u001e\u0010*\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u00190\u000f\"\u0004\b\u0000\u0010\u0018\"\u0004\b\u0001\u0010\u0019\u001aO\u0010*\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u00190\u000f\"\u0004\b\u0000\u0010\u0018\"\u0004\b\u0001\u0010\u00192*\u0010+\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u00190-0,\"\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u00190-¢\u0006\u0002\u0010.\u001a\u0010\u0010/\u001a\u00020\b2\u0006\u0010)\u001a\u00020\bH\u0000\u001a\u0010\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\bH\u0000\u001a\u0019\u00102\u001a\u00020\u00012\u0006\u00103\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\bH\u0081\b\u001a\u0010\u00104\u001a\u00020\b2\u0006\u0010)\u001a\u00020\bH\u0000\u001a!\u00105\u001a\u0002062\u0006\u00103\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010'\u001a\u00020\u0001H\u0080\b\u001a\u0011\u00107\u001a\u00020\b*\u00060\u0001j\u0002`8H\u0080\b\u001a\u0011\u00109\u001a\u00020#*\u00060\u0001j\u0002`8H\u0080\b\u001a\u0011\u0010:\u001a\u00020\b*\u00060\u0001j\u0002`;H\u0081\b\u001a\u0015\u0010<\u001a\u00060\u0001j\u0002`8*\u00060\u0001j\u0002`\u001bH\u0080\b\u001a\u0015\u0010=\u001a\u00060\u0001j\u0002`8*\u00060\u0001j\u0002`\u001bH\u0081\b\u001a\u001d\u0010>\u001a\u00060\u0001j\u0002`8*\u00060\u0001j\u0002`\u001b2\u0006\u0010?\u001a\u00020\bH\u0081\b\u001a\u0011\u0010@\u001a\u00020\u0001*\u00060\u0001j\u0002`8H\u0080\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0003\u0010\u0004\"\u0016\u0010\u0005\u001a\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0004\"\u000e\u0010\u0007\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0010\u0010\f\u001a\u00020\r8\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u001c\u0010\u000e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0014\u001a\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0004*\f\b\u0000\u0010A\"\u00020\u00012\u00020\u0001*\f\b\u0000\u0010B\"\u00020\u00012\u00020\u0001*\f\b\u0000\u0010C\"\u00020\u00012\u00020\u0001¨\u0006D"}, d2 = {"AllEmpty", "", "BitmaskLsb", "getBitmaskLsb$annotations", "()V", "BitmaskMsb", "getBitmaskMsb$annotations", "ClonedMetadataCount", "", "DefaultScatterCapacity", "Deleted", "Empty", "EmptyGroup", "", "EmptyScatterMap", "Landroidx/collection/MutableScatterMap;", "", "", "GroupWidth", "MurmurHashC1", "Sentinel", "getSentinel$annotations", "emptyScatterMap", "Landroidx/collection/ScatterMap;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "group", "Landroidx/collection/Group;", "metadata", TypedValues.CycleType.S_WAVE_OFFSET, "h1", "hash", "h2", "k", "isDeleted", "", "index", "isEmpty", "isFull", "value", "loadedCapacity", "capacity", "mutableScatterMapOf", "pairs", "", "Lkotlin/Pair;", "([Lkotlin/Pair;)Landroidx/collection/MutableScatterMap;", "nextCapacity", "normalizeCapacity", "n", "readRawMetadata", "data", "unloadedCapacity", "writeRawMetadata", "", "get", "Landroidx/collection/Bitmask;", "hasNext", "lowestBitSet", "Landroidx/collection/StaticBitmask;", "maskEmpty", "maskEmptyOrDeleted", "match", "m", "next", "Bitmask", "Group", "StaticBitmask", "collection"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nScatterMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n*L\n1#1,1850:1\n1661#1:1851\n1661#1:1852\n1661#1:1853\n1715#1:1854\n*S KotlinDebug\n*F\n+ 1 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n*L\n1680#1:1851\n1682#1:1852\n1685#1:1853\n1721#1:1854\n*E\n"})
public final class ScatterMapKt {
    public static final long AllEmpty = -9187201950435737472L;
    public static final long BitmaskLsb = 72340172838076673L;
    public static final long BitmaskMsb = -9187201950435737472L;
    public static final int ClonedMetadataCount = 7;
    public static final int DefaultScatterCapacity = 6;
    public static final long Deleted = 254;
    public static final long Empty = 128;

    @JvmField
    public static final long[] EmptyGroup = {-9187201950435737345L, -1};
    private static final MutableScatterMap EmptyScatterMap = new MutableScatterMap(0);
    public static final int GroupWidth = 8;
    public static final int MurmurHashC1 = -862048943;
    public static final long Sentinel = 255;

    public static final <K, V> ScatterMap<K, V> emptyScatterMap() {
        MutableScatterMap mutableScatterMap = EmptyScatterMap;
        Intrinsics.checkNotNull(mutableScatterMap, "null cannot be cast to non-null type androidx.collection.ScatterMap<K of androidx.collection.ScatterMapKt.emptyScatterMap, V of androidx.collection.ScatterMapKt.emptyScatterMap>");
        return mutableScatterMap;
    }

    public static final int get(long j8) {
        return Long.numberOfTrailingZeros(j8) >> 3;
    }

    @PublishedApi
    public static /* synthetic */ void getBitmaskLsb$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getBitmaskMsb$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getSentinel$annotations() {
    }

    public static final long group(long[] metadata, int i8) {
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        int i9 = i8 >> 3;
        int i10 = (i8 & 7) << 3;
        return (((-i10) >> 63) & (metadata[i9 + 1] << (64 - i10))) | (metadata[i9] >>> i10);
    }

    public static final int h1(int i8) {
        return i8 >>> 7;
    }

    public static final int h2(int i8) {
        return i8 & 127;
    }

    public static final boolean hasNext(long j8) {
        return j8 != 0;
    }

    public static final int hash(Object obj) {
        int iHashCode = (obj != null ? obj.hashCode() : 0) * MurmurHashC1;
        return iHashCode ^ (iHashCode << 16);
    }

    public static final boolean isDeleted(long[] metadata, int i8) {
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        return ((metadata[i8 >> 3] >> ((i8 & 7) << 3)) & 255) == 254;
    }

    public static final boolean isEmpty(long[] metadata, int i8) {
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        return ((metadata[i8 >> 3] >> ((i8 & 7) << 3)) & 255) == 128;
    }

    @PublishedApi
    public static final boolean isFull(long j8) {
        return j8 < 128;
    }

    public static final int loadedCapacity(int i8) {
        if (i8 == 7) {
            return 6;
        }
        return i8 - (i8 / 8);
    }

    @PublishedApi
    public static final int lowestBitSet(long j8) {
        return Long.numberOfTrailingZeros(j8) >> 3;
    }

    public static final long maskEmpty(long j8) {
        return j8 & ((~j8) << 6) & (-9187201950435737472L);
    }

    @PublishedApi
    public static final long maskEmptyOrDeleted(long j8) {
        return j8 & ((~j8) << 7) & (-9187201950435737472L);
    }

    @PublishedApi
    public static final long match(long j8, int i8) {
        long j10 = j8 ^ (((long) i8) * BitmaskLsb);
        return (~j10) & (j10 - BitmaskLsb) & (-9187201950435737472L);
    }

    public static final <K, V> MutableScatterMap<K, V> mutableScatterMapOf() {
        return new MutableScatterMap<>(0, 1, null);
    }

    public static final long next(long j8) {
        return j8 & (j8 - 1);
    }

    public static final int nextCapacity(int i8) {
        if (i8 == 0) {
            return 6;
        }
        return (i8 * 2) + 1;
    }

    public static final int normalizeCapacity(int i8) {
        if (i8 > 0) {
            return (-1) >>> Integer.numberOfLeadingZeros(i8);
        }
        return 0;
    }

    @PublishedApi
    public static final long readRawMetadata(long[] data, int i8) {
        Intrinsics.checkNotNullParameter(data, "data");
        return (data[i8 >> 3] >> ((i8 & 7) << 3)) & 255;
    }

    public static final int unloadedCapacity(int i8) {
        if (i8 == 7) {
            return 8;
        }
        return a.d(i8, 1, 7, i8);
    }

    public static final void writeRawMetadata(long[] data, int i8, long j8) {
        Intrinsics.checkNotNullParameter(data, "data");
        int i9 = i8 >> 3;
        int i10 = (i8 & 7) << 3;
        data[i9] = (j8 << i10) | (data[i9] & (~(255 << i10)));
    }

    public static final boolean isFull(long[] metadata, int i8) {
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        return ((metadata[i8 >> 3] >> ((i8 & 7) << 3)) & 255) < 128;
    }

    public static final <K, V> MutableScatterMap<K, V> mutableScatterMapOf(Pair<? extends K, ? extends V>... pairs) {
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        MutableScatterMap<K, V> mutableScatterMap = new MutableScatterMap<>(pairs.length);
        mutableScatterMap.putAll(pairs);
        return mutableScatterMap;
    }
}
