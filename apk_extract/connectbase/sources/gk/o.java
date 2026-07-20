package gk;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final String f6682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final m f6683b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final List<jn.p<dk.b, nk.s, Boolean>> f6684c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double f6685d;

    /* JADX WARN: Multi-variable type inference failed */
    public o(@os.l String str, @os.l m mVar, @os.l List<? extends jn.p<? super dk.b, ? super nk.s, Boolean>> list, double d10) {
        kn.l0.p(str, "name");
        kn.l0.p(mVar, "encoder");
        kn.l0.p(list, "conditions");
        this.f6682a = str;
        this.f6683b = mVar;
        this.f6684c = list;
        this.f6685d = d10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ o f(o oVar, String str, m mVar, List list, double d10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = oVar.f6682a;
        }
        if ((i10 & 2) != 0) {
            mVar = oVar.f6683b;
        }
        m mVar2 = mVar;
        if ((i10 & 4) != 0) {
            list = oVar.f6684c;
        }
        List list2 = list;
        if ((i10 & 8) != 0) {
            d10 = oVar.f6685d;
        }
        return oVar.e(str, mVar2, list2, d10);
    }

    @os.l
    public final String a() {
        return this.f6682a;
    }

    @os.l
    public final m b() {
        return this.f6683b;
    }

    @os.l
    public final List<jn.p<dk.b, nk.s, Boolean>> c() {
        return this.f6684c;
    }

    public final double d() {
        return this.f6685d;
    }

    @os.l
    public final o e(@os.l String str, @os.l m mVar, @os.l List<? extends jn.p<? super dk.b, ? super nk.s, Boolean>> list, double d10) {
        kn.l0.p(str, "name");
        kn.l0.p(mVar, "encoder");
        kn.l0.p(list, "conditions");
        return new o(str, mVar, list, d10);
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return kn.l0.g(this.f6682a, oVar.f6682a) && kn.l0.g(this.f6683b, oVar.f6683b) && kn.l0.g(this.f6684c, oVar.f6684c) && kn.l0.g(Double.valueOf(this.f6685d), Double.valueOf(oVar.f6685d));
    }

    @os.l
    public final List<jn.p<dk.b, nk.s, Boolean>> g() {
        return this.f6684c;
    }

    @os.l
    public final m h() {
        return this.f6683b;
    }

    public int hashCode() {
        return Double.hashCode(this.f6685d) + ((this.f6684c.hashCode() + ((this.f6683b.hashCode() + (this.f6682a.hashCode() * 31)) * 31)) * 31);
    }

    @os.l
    public final String i() {
        return this.f6682a;
    }

    public final double j() {
        return this.f6685d;
    }

    @os.l
    public String toString() {
        return "CompressionEncoderConfig(name=" + this.f6682a + ", encoder=" + this.f6683b + ", conditions=" + this.f6684c + ", priority=" + this.f6685d + ')';
    }
}
