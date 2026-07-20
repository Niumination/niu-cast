package zf;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class z implements Comparable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final z f11564c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final z f11565d;
    public static final z e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final z f11566h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final z f11567i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final z f11568j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final z f11569k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final z f11570l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final z f11571m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final z f11572n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final z f11573o;
    public static final z p;
    public static final z q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final z f11574r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final z f11575s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final z f11576t;
    public static final z u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final z f11577v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final z f11578w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final z f11579x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final List f11580y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f11582b;

    static {
        z zVar = new z(100, "Continue");
        f11564c = zVar;
        z zVar2 = new z(101, "Switching Protocols");
        f11565d = zVar2;
        z zVar3 = new z(102, "Processing");
        z zVar4 = new z(200, "OK");
        e = zVar4;
        z zVar5 = new z(l5.a.CODE_SCANNER_CANCELLED, "Created");
        z zVar6 = new z(l5.a.CODE_SCANNER_CAMERA_PERMISSION_NOT_GRANTED, "Accepted");
        z zVar7 = new z(l5.a.CODE_SCANNER_APP_NAME_UNAVAILABLE, "Non-Authoritative Information");
        z zVar8 = new z(l5.a.CODE_SCANNER_TASK_IN_PROGRESS, "No Content");
        f11566h = zVar8;
        z zVar9 = new z(l5.a.CODE_SCANNER_PIPELINE_INITIALIZATION_ERROR, "Reset Content");
        z zVar10 = new z(l5.a.CODE_SCANNER_PIPELINE_INFERENCE_ERROR, "Partial Content");
        z zVar11 = new z(l5.a.CODE_SCANNER_GOOGLE_PLAY_SERVICES_VERSION_TOO_OLD, "Multi-Status");
        z zVar12 = new z(300, "Multiple Choices");
        z zVar13 = new z(301, "Moved Permanently");
        f11567i = zVar13;
        z zVar14 = new z(302, "Found");
        f11568j = zVar14;
        z zVar15 = new z(303, "See Other");
        f11569k = zVar15;
        z zVar16 = new z(304, "Not Modified");
        f11570l = zVar16;
        z zVar17 = new z(305, "Use Proxy");
        z zVar18 = new z(306, "Switch Proxy");
        z zVar19 = new z(307, "Temporary Redirect");
        f11571m = zVar19;
        z zVar20 = new z(308, "Permanent Redirect");
        f11572n = zVar20;
        z zVar21 = new z(400, "Bad Request");
        f11573o = zVar21;
        z zVar22 = new z(TypedValues.CycleType.TYPE_CURVE_FIT, "Unauthorized");
        z zVar23 = new z(TypedValues.CycleType.TYPE_VISIBILITY, "Payment Required");
        z zVar24 = new z(TypedValues.CycleType.TYPE_ALPHA, "Forbidden");
        z zVar25 = new z(404, "Not Found");
        p = zVar25;
        z zVar26 = new z(405, "Method Not Allowed");
        q = zVar26;
        z zVar27 = new z(406, "Not Acceptable");
        f11574r = zVar27;
        z zVar28 = new z(407, "Proxy Authentication Required");
        z zVar29 = new z(408, "Request Timeout");
        z zVar30 = new z(409, "Conflict");
        z zVar31 = new z(410, "Gone");
        f11575s = zVar31;
        z zVar32 = new z(411, "Length Required");
        z zVar33 = new z(412, "Precondition Failed");
        z zVar34 = new z(413, "Payload Too Large");
        f11576t = zVar34;
        z zVar35 = new z(414, "Request-URI Too Long");
        z zVar36 = new z(415, "Unsupported Media Type");
        u = zVar36;
        z zVar37 = new z(TypedValues.CycleType.TYPE_PATH_ROTATE, "Requested Range Not Satisfiable");
        z zVar38 = new z(417, "Expectation Failed");
        f11577v = zVar38;
        z zVar39 = new z(TypedValues.CycleType.TYPE_CUSTOM_WAVE_SHAPE, "Unprocessable Entity");
        z zVar40 = new z(TypedValues.CycleType.TYPE_WAVE_PERIOD, "Locked");
        z zVar41 = new z(TypedValues.CycleType.TYPE_WAVE_OFFSET, "Failed Dependency");
        z zVar42 = new z(TypedValues.CycleType.TYPE_WAVE_PHASE, "Too Early");
        z zVar43 = new z(426, "Upgrade Required");
        z zVar44 = new z(429, "Too Many Requests");
        z zVar45 = new z(431, "Request Header Fields Too Large");
        z zVar46 = new z(500, "Internal Server Error");
        f11578w = zVar46;
        z zVar47 = new z(TypedValues.PositionType.TYPE_TRANSITION_EASING, "Not Implemented");
        z zVar48 = new z(TypedValues.PositionType.TYPE_DRAWPATH, "Bad Gateway");
        z zVar49 = new z(TypedValues.PositionType.TYPE_PERCENT_WIDTH, "Service Unavailable");
        z zVar50 = new z(TypedValues.PositionType.TYPE_PERCENT_HEIGHT, "Gateway Timeout");
        f11579x = zVar50;
        List listListOf = CollectionsKt.listOf((Object[]) new z[]{zVar, zVar2, zVar3, zVar4, zVar5, zVar6, zVar7, zVar8, zVar9, zVar10, zVar11, zVar12, zVar13, zVar14, zVar15, zVar16, zVar17, zVar18, zVar19, zVar20, zVar21, zVar22, zVar23, zVar24, zVar25, zVar26, zVar27, zVar28, zVar29, zVar30, zVar31, zVar32, zVar33, zVar34, zVar35, zVar36, zVar37, zVar38, zVar39, zVar40, zVar41, zVar42, zVar43, zVar44, zVar45, zVar46, zVar47, zVar48, zVar49, zVar50, new z(TypedValues.PositionType.TYPE_SIZE_PERCENT, "HTTP Version Not Supported"), new z(TypedValues.PositionType.TYPE_PERCENT_X, "Variant Also Negotiates"), new z(TypedValues.PositionType.TYPE_PERCENT_Y, "Insufficient Storage")});
        f11580y = listListOf;
        List list = listListOf;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.i(list)), 16));
        for (Object obj : list) {
            linkedHashMap.put(Integer.valueOf(((z) obj).f11581a), obj);
        }
    }

    public z(int i8, String description) {
        Intrinsics.checkNotNullParameter(description, "description");
        this.f11581a = i8;
        this.f11582b = description;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        z other = (z) obj;
        Intrinsics.checkNotNullParameter(other, "other");
        return this.f11581a - other.f11581a;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof z) && ((z) obj).f11581a == this.f11581a;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f11581a);
    }

    public final String toString() {
        return this.f11581a + ' ' + this.f11582b;
    }
}
