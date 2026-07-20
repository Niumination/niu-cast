package p001if;

import i4.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f5818a = new HashMap();

    public final double a() {
        HashMap map = this.f5818a;
        if (map.isEmpty()) {
            return 0.0d;
        }
        Iterator it = map.values().iterator();
        int i8 = 0;
        int i9 = 0;
        while (it.hasNext()) {
            i9++;
            if (((i) it.next()).d()) {
                i8++;
            }
        }
        return (((double) i8) / ((double) i9)) * 100.0d;
    }

    @Override // i4.y
    public final Object delegate() {
        return this.f5818a;
    }

    @Override // i4.x, i4.y
    public final Map delegate() {
        return this.f5818a;
    }
}
