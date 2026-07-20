package jq;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface p {

    public static final class a {
        @os.l
        public static b a(@os.l p pVar) {
            return new b(pVar);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final p f8889a;

        public b(@os.l p pVar) {
            kn.l0.p(pVar, "match");
            this.f8889a = pVar;
        }

        @an.f
        public final String a() {
            return this.f8889a.b().get(1);
        }

        @an.f
        public final String b() {
            return this.f8889a.b().get(10);
        }

        @an.f
        public final String c() {
            return this.f8889a.b().get(2);
        }

        @an.f
        public final String d() {
            return this.f8889a.b().get(3);
        }

        @an.f
        public final String e() {
            return this.f8889a.b().get(4);
        }

        @an.f
        public final String f() {
            return this.f8889a.b().get(5);
        }

        @an.f
        public final String g() {
            return this.f8889a.b().get(6);
        }

        @an.f
        public final String h() {
            return this.f8889a.b().get(7);
        }

        @an.f
        public final String i() {
            return this.f8889a.b().get(8);
        }

        @an.f
        public final String j() {
            return this.f8889a.b().get(9);
        }

        @os.l
        public final p k() {
            return this.f8889a;
        }

        @os.l
        public final List<String> l() {
            return this.f8889a.b().subList(1, this.f8889a.b().size());
        }
    }

    @os.l
    b a();

    @os.l
    List<String> b();

    @os.l
    tn.l c();

    @os.l
    n d();

    @os.l
    String getValue();

    @os.m
    p next();
}
