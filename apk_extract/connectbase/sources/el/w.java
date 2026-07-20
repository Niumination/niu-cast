package el;

import androidx.core.app.NotificationCompat;
import java.util.List;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class w implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final String f4551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final a f4552b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final List<z> f4553c;

    /* JADX WARN: Multi-variable type inference failed */
    public w(@os.l String str, @os.l a aVar, @os.l List<? extends z> list) {
        l0.p(str, "name");
        l0.p(aVar, "configuration");
        l0.p(list, "transformers");
        this.f4551a = str;
        this.f4552b = aVar;
        this.f4553c = list;
    }

    @Override // el.v
    @os.m
    public String a(@os.l dk.b bVar) {
        l0.p(bVar, NotificationCompat.CATEGORY_CALL);
        return d0.a(this.f4553c, bVar.d().e().b(this.f4551a, this.f4552b.f4493b));
    }

    @Override // el.v
    public void b(@os.l dk.b bVar, @os.l String str) {
        l0.p(bVar, NotificationCompat.CATEGORY_CALL);
        l0.p(str, "value");
        kl.d dVarC = kl.a.c(null, 1, null);
        long j10 = this.f4552b.f4492a;
        kl.d dVarC2 = j10 != 0 ? kl.b.c(dVarC, 1000 * j10) : null;
        String str2 = this.f4551a;
        String strB = d0.b(this.f4553c, str);
        ik.o oVar = this.f4552b.f4493b;
        int iC = (int) tn.u.C(j10, 2147483647L);
        a aVar = this.f4552b;
        bVar.e().e().a(new ik.l(str2, strB, oVar, iC, dVarC2, aVar.f4494c, aVar.f4495d, aVar.f4496e, aVar.f4497f, aVar.f4498g));
    }

    @Override // el.v
    public void c(@os.l dk.b bVar) {
        l0.p(bVar, NotificationCompat.CATEGORY_CALL);
        vk.f fVarE = bVar.e().e();
        String str = this.f4551a;
        a aVar = this.f4552b;
        fVarE.f(str, aVar.f4494c, aVar.f4495d);
    }

    @os.l
    public final a d() {
        return this.f4552b;
    }

    @os.l
    public final String e() {
        return this.f4551a;
    }

    @os.l
    public final List<z> f() {
        return this.f4553c;
    }

    @os.l
    public String toString() {
        return l0.C("SessionTransportCookie: ", this.f4551a);
    }
}
