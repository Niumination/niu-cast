package wo;

import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final b f19801a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final d f19802b = new d(mp.e.BOOLEAN);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final d f19803c = new d(mp.e.CHAR);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final d f19804d = new d(mp.e.BYTE);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final d f19805e = new d(mp.e.SHORT);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public static final d f19806f = new d(mp.e.INT);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public static final d f19807g = new d(mp.e.FLOAT);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @os.l
    public static final d f19808h = new d(mp.e.LONG);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.l
    public static final d f19809i = new d(mp.e.DOUBLE);

    public static final class a extends k {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @os.l
        public final k f19810j;

        public a(@os.l k kVar) {
            l0.p(kVar, "elementType");
            this.f19810j = kVar;
        }

        @os.l
        public final k i() {
            return this.f19810j;
        }
    }

    public static final class b {
        public b() {
        }

        @os.l
        public final d a() {
            return k.f19802b;
        }

        @os.l
        public final d b() {
            return k.f19804d;
        }

        @os.l
        public final d c() {
            return k.f19803c;
        }

        @os.l
        public final d d() {
            return k.f19809i;
        }

        @os.l
        public final d e() {
            return k.f19807g;
        }

        @os.l
        public final d f() {
            return k.f19806f;
        }

        @os.l
        public final d g() {
            return k.f19808h;
        }

        @os.l
        public final d h() {
            return k.f19805e;
        }

        public b(kn.w wVar) {
        }
    }

    public static final class c extends k {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @os.l
        public final String f19811j;

        public c(@os.l String str) {
            l0.p(str, "internalName");
            this.f19811j = str;
        }

        @os.l
        public final String i() {
            return this.f19811j;
        }
    }

    public static final class d extends k {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @os.m
        public final mp.e f19812j;

        public d(@os.m mp.e eVar) {
            this.f19812j = eVar;
        }

        @os.m
        public final mp.e i() {
            return this.f19812j;
        }
    }

    public k() {
    }

    @os.l
    public String toString() {
        return m.f19813a.l(this);
    }

    public k(kn.w wVar) {
    }
}
