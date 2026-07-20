package wo;

import eo.z0;

/* JADX INFO: loaded from: classes3.dex */
public interface p {

    public interface a {
        void a();

        void b(@os.l dp.f fVar, @os.l dp.b bVar, @os.l dp.f fVar2);

        void c(@os.m dp.f fVar, @os.m Object obj);

        @os.m
        b d(@os.l dp.f fVar);

        @os.m
        a e(@os.l dp.f fVar, @os.l dp.b bVar);

        void f(@os.l dp.f fVar, @os.l jp.f fVar2);
    }

    public interface b {
        void a();

        void b(@os.l dp.b bVar, @os.l dp.f fVar);

        void c(@os.l jp.f fVar);

        @os.m
        a d(@os.l dp.b bVar);

        void e(@os.m Object obj);
    }

    public interface c {
        void a();

        @os.m
        a b(@os.l dp.b bVar, @os.l z0 z0Var);
    }

    public interface d {
        @os.m
        c a(@os.l dp.f fVar, @os.l String str, @os.m Object obj);

        @os.m
        e b(@os.l dp.f fVar, @os.l String str);
    }

    public interface e extends c {
        @os.m
        a c(int i10, @os.l dp.b bVar, @os.l z0 z0Var);
    }

    void a(@os.l d dVar, @os.m byte[] bArr);

    @os.l
    xo.a b();

    void c(@os.l c cVar, @os.m byte[] bArr);

    @os.l
    dp.b f();

    @os.l
    String getLocation();
}
