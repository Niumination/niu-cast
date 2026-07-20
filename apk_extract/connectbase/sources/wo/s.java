package wo;

import kn.l0;
import lm.i0;

/* JADX INFO: loaded from: classes3.dex */
public final class s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final a f19823b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final String f19824a;

    public static final class a {
        public a() {
        }

        @in.n
        @os.l
        public final s a(@os.l String str, @os.l String str2) {
            l0.p(str, "name");
            l0.p(str2, "desc");
            return new s(str + '#' + str2);
        }

        @in.n
        @os.l
        public final s b(@os.l cp.d dVar) {
            l0.p(dVar, "signature");
            if (dVar instanceof cp.d.b) {
                cp.d.b bVar = (cp.d.b) dVar;
                return d(bVar.f3367a, bVar.f3368b);
            }
            if (!(dVar instanceof cp.d.a)) {
                throw new i0();
            }
            cp.d.a aVar = (cp.d.a) dVar;
            return a(aVar.f3365a, aVar.f3366b);
        }

        @in.n
        @os.l
        public final s c(@os.l ap.c cVar, @os.l bp.a.c cVar2) {
            l0.p(cVar, "nameResolver");
            l0.p(cVar2, "signature");
            return d(cVar.c(cVar2.getName()), cVar.c(cVar2.getDesc()));
        }

        @in.n
        @os.l
        public final s d(@os.l String str, @os.l String str2) {
            l0.p(str, "name");
            l0.p(str2, "desc");
            return new s(l0.C(str, str2));
        }

        @in.n
        @os.l
        public final s e(@os.l s sVar, int i10) {
            l0.p(sVar, "signature");
            return new s(sVar.f19824a + '@' + i10);
        }

        public a(kn.w wVar) {
        }
    }

    public /* synthetic */ s(String str, kn.w wVar) {
        this(str);
    }

    @os.l
    public final String a() {
        return this.f19824a;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof s) && l0.g(this.f19824a, ((s) obj).f19824a);
    }

    public int hashCode() {
        return this.f19824a.hashCode();
    }

    @os.l
    public String toString() {
        return l.a.a(new StringBuilder("MemberSignature(signature="), this.f19824a, ')');
    }

    public s(String str) {
        this.f19824a = str;
    }
}
