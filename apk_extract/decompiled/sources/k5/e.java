package k5;

import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6773a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TreeSet f6774b = new TreeSet();

    public abstract String a(int i8);

    public abstract int b(int i8);

    public abstract void c(ObjectInput objectInput);

    public abstract void d(ObjectOutput objectOutput);

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        int i8 = this.f6773a;
        for (int i9 = 0; i9 < i8; i9++) {
            sb2.append(b(i9));
            sb2.append("|");
            sb2.append(a(i9));
            sb2.append("\n");
        }
        return sb2.toString();
    }
}
