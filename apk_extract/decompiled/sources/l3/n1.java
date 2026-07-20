package l3;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class n1 {
    public static final void a(Object obj, Object obj2) {
        m1 m1Var = (m1) obj;
        if (obj2 != null) {
            throw new ClassCastException();
        }
        if (m1Var.isEmpty()) {
            return;
        }
        Iterator it = m1Var.entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            entry.getKey();
            entry.getValue();
            throw null;
        }
    }

    public static final m1 b(Object obj, Object obj2) {
        m1 m1VarZzb = (m1) obj;
        m1 m1Var = (m1) obj2;
        if (!m1Var.isEmpty()) {
            if (!m1VarZzb.zze()) {
                m1VarZzb = m1VarZzb.zzb();
            }
            m1VarZzb.zzd(m1Var);
        }
        return m1VarZzb;
    }
}
