package l1;

import android.graphics.Path;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f7096a;

    public c(int i8) {
        switch (i8) {
            case 1:
                Intrinsics.checkNotNullParameter("NearThreadHandler", "threadName");
                this.f7096a = new ArrayList();
                break;
            default:
                this.f7096a = new ArrayList();
                break;
        }
    }

    public void a(Path path) {
        ArrayList arrayList = this.f7096a;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            w wVar = (w) arrayList.get(size);
            g3.h hVar = w1.g.f10647a;
            if (wVar != null && !wVar.f7196a) {
                w1.g.a(path, wVar.f7199d.l() / 100.0f, wVar.e.l() / 100.0f, wVar.f.l() / 360.0f);
            }
        }
    }
}
