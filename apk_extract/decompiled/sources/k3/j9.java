package k3;

/* JADX INFO: loaded from: classes.dex */
public abstract class j9 {
    public static boolean a(i4.c4 c4Var, Object obj) {
        if (obj == c4Var) {
            return true;
        }
        if (obj instanceof i4.c4) {
            i4.c4 c4Var2 = (i4.c4) obj;
            if (c4Var.size() == c4Var2.size() && c4Var.entrySet().size() == c4Var2.entrySet().size()) {
                for (i4.b4 b4Var : c4Var2.entrySet()) {
                    if (c4Var.count(b4Var.getElement()) != b4Var.getCount()) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
