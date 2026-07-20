package el;

import java.util.Iterator;
import java.util.List;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class d0 {
    @os.m
    public static final String a(@os.l List<? extends z> list, @os.m String str) {
        l0.p(list, "<this>");
        if (str == null) {
            return null;
        }
        Iterator it = nm.e0.a1(list).iterator();
        while (it.hasNext()) {
            str = ((z) it.next()).a(str);
            if (str == null) {
                return null;
            }
        }
        return str;
    }

    @os.l
    public static final String b(@os.l List<? extends z> list, @os.l String str) {
        l0.p(list, "<this>");
        l0.p(str, "value");
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            str = ((z) it.next()).b(str);
        }
        return str;
    }
}
