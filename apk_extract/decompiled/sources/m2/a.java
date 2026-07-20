package m2;

import a2.c;
import android.util.SparseArray;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SparseArray f7627a = new SparseArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap f7628b;

    static {
        HashMap map = new HashMap();
        f7628b = map;
        map.put(c.DEFAULT, 0);
        map.put(c.VERY_LOW, 1);
        map.put(c.HIGHEST, 2);
        for (c cVar : map.keySet()) {
            f7627a.append(((Integer) f7628b.get(cVar)).intValue(), cVar);
        }
    }

    public static int a(c cVar) {
        Integer num = (Integer) f7628b.get(cVar);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + cVar);
    }

    public static c b(int i8) {
        c cVar = (c) f7627a.get(i8);
        if (cVar != null) {
            return cVar;
        }
        throw new IllegalArgumentException(a1.a.o(i8, "Unknown Priority for value "));
    }
}
