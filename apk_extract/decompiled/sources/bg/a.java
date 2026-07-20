package bg;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final char f1306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f1307b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f1308c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a[] f1309d;

    /* JADX WARN: Multi-variable type inference failed */
    public a(char c9, List exact, ArrayList children) {
        Intrinsics.checkNotNullParameter(exact, "exact");
        Intrinsics.checkNotNullParameter(children, "children");
        this.f1306a = c9;
        this.f1307b = exact;
        this.f1308c = children;
        a[] aVarArr = new a[256];
        for (int i8 = 0; i8 < 256; i8++) {
            Iterator it = this.f1308c.iterator();
            Object obj = null;
            boolean z2 = false;
            Object obj2 = null;
            while (true) {
                if (!it.hasNext()) {
                    if (!z2) {
                        break;
                    }
                    obj = obj2;
                    break;
                } else {
                    Object next = it.next();
                    if (((a) next).f1306a == i8) {
                        if (z2) {
                            break;
                        }
                        z2 = true;
                        obj2 = next;
                    }
                }
            }
            aVarArr[i8] = obj;
        }
        this.f1309d = aVarArr;
    }
}
