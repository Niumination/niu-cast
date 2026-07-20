package tj;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public enum y0 {
    UNRESOLVED,
    RESOLVED;

    public static final y0 fromBoolean(boolean z10) {
        return z10 ? RESOLVED : UNRESOLVED;
    }

    public static final y0 fromValues(Collection<? extends d> collection) {
        Iterator<? extends d> it = collection.iterator();
        while (it.hasNext()) {
            y0 y0VarResolveStatus = it.next().resolveStatus();
            y0 y0Var = UNRESOLVED;
            if (y0VarResolveStatus == y0Var) {
                return y0Var;
            }
        }
        return RESOLVED;
    }
}
