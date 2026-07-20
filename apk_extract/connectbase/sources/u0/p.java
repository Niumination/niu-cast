package u0;

import android.graphics.Paint;
import androidx.annotation.Nullable;
import java.util.List;
import p0.s;

/* JADX INFO: loaded from: classes.dex */
public class p implements u0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final t0.b f16150b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<t0.b> f16151c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final t0.a f16152d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final t0.d f16153e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final t0.b f16154f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f16155g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f16156h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f16157i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f16158j;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16159a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f16160b;

        static {
            int[] iArr = new int[c.values().length];
            f16160b = iArr;
            try {
                iArr[c.BEVEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16160b[c.MITER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16160b[c.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[b.values().length];
            f16159a = iArr2;
            try {
                iArr2[b.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f16159a[b.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f16159a[b.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public enum b {
        BUTT,
        ROUND,
        UNKNOWN;

        public Paint.Cap toPaintCap() {
            int i10 = a.f16159a[ordinal()];
            if (i10 != 1) {
                return i10 != 2 ? Paint.Cap.SQUARE : Paint.Cap.ROUND;
            }
            return Paint.Cap.BUTT;
        }
    }

    public enum c {
        MITER,
        ROUND,
        BEVEL;

        public Paint.Join toPaintJoin() {
            int i10 = a.f16160b[ordinal()];
            if (i10 == 1) {
                return Paint.Join.BEVEL;
            }
            if (i10 == 2) {
                return Paint.Join.MITER;
            }
            if (i10 != 3) {
                return null;
            }
            return Paint.Join.ROUND;
        }
    }

    public p(String str, @Nullable t0.b bVar, List<t0.b> list, t0.a aVar, t0.d dVar, t0.b bVar2, b bVar3, c cVar, float f10, boolean z10) {
        this.f16149a = str;
        this.f16150b = bVar;
        this.f16151c = list;
        this.f16152d = aVar;
        this.f16153e = dVar;
        this.f16154f = bVar2;
        this.f16155g = bVar3;
        this.f16156h = cVar;
        this.f16157i = f10;
        this.f16158j = z10;
    }

    @Override // u0.b
    public p0.c a(n0.j jVar, v0.a aVar) {
        return new s(jVar, aVar, this);
    }

    public b b() {
        return this.f16155g;
    }

    public t0.a c() {
        return this.f16152d;
    }

    public t0.b d() {
        return this.f16150b;
    }

    public c e() {
        return this.f16156h;
    }

    public List<t0.b> f() {
        return this.f16151c;
    }

    public float g() {
        return this.f16157i;
    }

    public String h() {
        return this.f16149a;
    }

    public t0.d i() {
        return this.f16153e;
    }

    public t0.b j() {
        return this.f16154f;
    }

    public boolean k() {
        return this.f16158j;
    }
}
