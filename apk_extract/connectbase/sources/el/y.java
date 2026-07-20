package el;

import androidx.core.app.NotificationCompat;
import ik.j0;
import java.util.List;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class y implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final String f4555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final List<z> f4556b;

    /* JADX WARN: Multi-variable type inference failed */
    public y(@os.l String str, @os.l List<? extends z> list) {
        l0.p(str, "name");
        l0.p(list, "transformers");
        this.f4555a = str;
        this.f4556b = list;
        j0.f8048a.a(str);
    }

    @Override // el.v
    @os.m
    public String a(@os.l dk.b bVar) {
        l0.p(bVar, NotificationCompat.CATEGORY_CALL);
        return d0.a(this.f4556b, bVar.d().b().get(this.f4555a));
    }

    @Override // el.v
    public void b(@os.l dk.b bVar, @os.l String str) {
        l0.p(bVar, NotificationCompat.CATEGORY_CALL);
        l0.p(str, "value");
        vk.c.m(bVar.e(), this.f4555a, d0.b(this.f4556b, str));
    }

    @Override // el.v
    public void c(@os.l dk.b bVar) {
        l0.p(bVar, NotificationCompat.CATEGORY_CALL);
    }

    @os.l
    public final String d() {
        return this.f4555a;
    }

    @os.l
    public final List<z> e() {
        return this.f4556b;
    }

    @os.l
    public String toString() {
        return l0.C("SessionTransportHeader: ", this.f4555a);
    }
}
