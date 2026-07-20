package k3;

/* JADX INFO: loaded from: classes.dex */
public abstract class bc {
    public static ni.m a(int i8, int i9, ni.c cVar) {
        ni.m yVar;
        if ((i9 & 1) != 0) {
            i8 = 0;
        }
        if ((i9 & 2) != 0) {
            cVar = ni.c.SUSPEND;
        }
        if (i8 != -2) {
            if (i8 == -1) {
                if (cVar == ni.c.SUSPEND) {
                    return new ni.y(1, ni.c.DROP_OLDEST, null);
                }
                throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
            }
            if (i8 == 0) {
                yVar = cVar == ni.c.SUSPEND ? new ni.m(0, null) : new ni.y(1, cVar, null);
            } else {
                if (i8 != Integer.MAX_VALUE) {
                    return cVar == ni.c.SUSPEND ? new ni.m(i8, null) : new ni.y(i8, cVar, null);
                }
                yVar = new ni.m(Integer.MAX_VALUE, null);
            }
        } else if (cVar == ni.c.SUSPEND) {
            ni.q.f.getClass();
            yVar = new ni.m(ni.p.f8322b, null);
        } else {
            yVar = new ni.y(1, cVar, null);
        }
        return yVar;
    }
}
