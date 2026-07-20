package u0;

import android.graphics.PointF;

/* JADX INFO: loaded from: classes.dex */
public class i implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f16113b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t0.b f16114c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final t0.m<PointF, PointF> f16115d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final t0.b f16116e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final t0.b f16117f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final t0.b f16118g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final t0.b f16119h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final t0.b f16120i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f16121j;

    public enum a {
        STAR(1),
        POLYGON(2);

        private final int value;

        a(int i10) {
            this.value = i10;
        }

        public static a forValue(int i10) {
            for (a aVar : values()) {
                if (aVar.value == i10) {
                    return aVar;
                }
            }
            return null;
        }
    }

    public i(String str, a aVar, t0.b bVar, t0.m<PointF, PointF> mVar, t0.b bVar2, t0.b bVar3, t0.b bVar4, t0.b bVar5, t0.b bVar6, boolean z10) {
        this.f16112a = str;
        this.f16113b = aVar;
        this.f16114c = bVar;
        this.f16115d = mVar;
        this.f16116e = bVar2;
        this.f16117f = bVar3;
        this.f16118g = bVar4;
        this.f16119h = bVar5;
        this.f16120i = bVar6;
        this.f16121j = z10;
    }

    @Override // u0.b
    public p0.c a(n0.j jVar, v0.a aVar) {
        return new p0.o(jVar, aVar, this);
    }

    public t0.b b() {
        return this.f16117f;
    }

    public t0.b c() {
        return this.f16119h;
    }

    public String d() {
        return this.f16112a;
    }

    public t0.b e() {
        return this.f16118g;
    }

    public t0.b f() {
        return this.f16120i;
    }

    public t0.b g() {
        return this.f16114c;
    }

    public t0.m<PointF, PointF> h() {
        return this.f16115d;
    }

    public t0.b i() {
        return this.f16116e;
    }

    public a j() {
        return this.f16113b;
    }

    public boolean k() {
        return this.f16121j;
    }
}
