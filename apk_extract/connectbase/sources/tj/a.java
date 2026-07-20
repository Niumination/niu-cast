package tj;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements uj.c {
    public abstract Collection<k1> a();

    public final boolean equals(Object obj) {
        return (obj instanceof a) && render().equals(((a) obj).render());
    }

    public final int hashCode() {
        return render().hashCode();
    }

    @Override // uj.c
    public final String render() {
        StringBuilder sb2 = new StringBuilder();
        Iterator<T> it = a().iterator();
        while (it.hasNext()) {
            sb2.append(((k1) it.next()).e());
        }
        return sb2.toString();
    }
}
