package no;

import java.util.Arrays;
import java.util.Set;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public interface o {
    @os.m
    uo.g a(@os.l a aVar);

    @os.m
    uo.u b(@os.l dp.c cVar);

    @os.m
    Set<String> c(@os.l dp.c cVar);

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final dp.b f11764a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.m
        public final byte[] f11765b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.m
        public final uo.g f11766c;

        public a(@os.l dp.b bVar, @os.m byte[] bArr, @os.m uo.g gVar) {
            l0.p(bVar, "classId");
            this.f11764a = bVar;
            this.f11765b = bArr;
            this.f11766c = gVar;
        }

        @os.l
        public final dp.b a() {
            return this.f11764a;
        }

        public boolean equals(@os.m Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return l0.g(this.f11764a, aVar.f11764a) && l0.g(this.f11765b, aVar.f11765b) && l0.g(this.f11766c, aVar.f11766c);
        }

        public int hashCode() {
            int iHashCode = this.f11764a.hashCode() * 31;
            byte[] bArr = this.f11765b;
            int iHashCode2 = (iHashCode + (bArr == null ? 0 : Arrays.hashCode(bArr))) * 31;
            uo.g gVar = this.f11766c;
            return iHashCode2 + (gVar != null ? gVar.hashCode() : 0);
        }

        @os.l
        public String toString() {
            return "Request(classId=" + this.f11764a + ", previouslyFoundClassFileContent=" + Arrays.toString(this.f11765b) + ", outerClass=" + this.f11766c + ')';
        }

        public /* synthetic */ a(dp.b bVar, byte[] bArr, uo.g gVar, int i10, kn.w wVar) {
            this(bVar, (i10 & 2) != 0 ? null : bArr, (i10 & 4) != 0 ? null : gVar);
        }
    }
}
