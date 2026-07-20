package wo;

import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public interface n extends rp.t {

    public static abstract class a {

        /* JADX INFO: renamed from: wo.n$a$a, reason: collision with other inner class name */
        public static final class C0492a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @os.l
            public final byte[] f19815a;

            @os.l
            public final byte[] b() {
                return this.f19815a;
            }
        }

        public a() {
        }

        @os.m
        public final p a() {
            b bVar = this instanceof b ? (b) this : null;
            if (bVar == null) {
                return null;
            }
            return bVar.f19816a;
        }

        public static final class b extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @os.l
            public final p f19816a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @os.m
            public final byte[] f19817b;

            public b(@os.l p pVar, @os.m byte[] bArr) {
                l0.p(pVar, "kotlinJvmBinaryClass");
                this.f19816a = pVar;
                this.f19817b = bArr;
            }

            @os.l
            public final p b() {
                return this.f19816a;
            }

            public /* synthetic */ b(p pVar, byte[] bArr, int i10, kn.w wVar) {
                this(pVar, (i10 & 2) != 0 ? null : bArr);
            }
        }

        public a(kn.w wVar) {
        }
    }

    @os.m
    a a(@os.l dp.b bVar);

    @os.m
    a b(@os.l uo.g gVar);
}
