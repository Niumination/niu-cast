package hp;

import java.util.Collection;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class i {
    public abstract void a(@os.l eo.b bVar);

    public abstract void b(@os.l eo.b bVar, @os.l eo.b bVar2);

    public abstract void c(@os.l eo.b bVar, @os.l eo.b bVar2);

    public void d(@os.l eo.b bVar, @os.l Collection<? extends eo.b> collection) {
        l0.p(bVar, "member");
        l0.p(collection, "overridden");
        bVar.z0(collection);
    }
}
