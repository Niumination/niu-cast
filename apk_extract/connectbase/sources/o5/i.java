package o5;

import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Collection<String> f12096a;

    public abstract void a(String str);

    public abstract void b(String str);

    public boolean c(String str) {
        Collection<String> collection = this.f12096a;
        if (collection == null) {
            return false;
        }
        return collection.contains(str);
    }

    public abstract void d();
}
