package jp;

import eo.h0;
import java.util.Arrays;
import kn.l0;
import vp.n0;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends o<Character> {
    public e(char c10) {
        super(Character.valueOf(c10));
    }

    public final String c(char c10) {
        if (c10 == '\b') {
            return "\\b";
        }
        if (c10 == '\t') {
            return "\\t";
        }
        if (c10 == '\n') {
            return "\\n";
        }
        if (c10 == '\f') {
            return "\\f";
        }
        if (c10 == '\r') {
            return "\\r";
        }
        return e(c10) ? String.valueOf(c10) : "?";
    }

    @Override // jp.g
    @os.l
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public n0 a(@os.l h0 h0Var) {
        l0.p(h0Var, "module");
        n0 n0VarU = h0Var.n().u();
        l0.o(n0VarU, "module.builtIns.charType");
        return n0VarU;
    }

    public final boolean e(char c10) {
        byte type = (byte) Character.getType(c10);
        return (type == 0 || type == 13 || type == 14 || type == 15 || type == 16 || type == 18 || type == 19) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // jp.g
    @os.l
    public String toString() {
        String str = String.format("\\u%04X ('%s')", Arrays.copyOf(new Object[]{Integer.valueOf(((Character) this.f8774a).charValue()), c(((Character) this.f8774a).charValue())}, 2));
        l0.o(str, "format(this, *args)");
        return str;
    }
}
