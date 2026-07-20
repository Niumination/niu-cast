package mo;

import java.io.Serializable;
import kn.w;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements Serializable {

    @l
    public static final a Companion = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final e f10857a = new e(-1, -1);
    private final int column;
    private final int line;

    public static final class a {
        public a() {
        }

        @l
        public final e a() {
            return e.f10857a;
        }

        public a(w wVar) {
        }
    }

    public e(int i10, int i11) {
        this.line = i10;
        this.column = i11;
    }

    public boolean equals(@m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.line == eVar.line && this.column == eVar.column;
    }

    public int hashCode() {
        return (this.line * 31) + this.column;
    }

    @l
    public String toString() {
        StringBuilder sb2 = new StringBuilder("Position(line=");
        sb2.append(this.line);
        sb2.append(", column=");
        return u.a.a(sb2, this.column, ')');
    }
}
