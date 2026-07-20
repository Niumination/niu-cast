package p0;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<t> f12568a = new ArrayList();

    public void a(t tVar) {
        this.f12568a.add(tVar);
    }

    public void b(Path path) {
        for (int size = this.f12568a.size() - 1; size >= 0; size--) {
            z0.h.b(path, this.f12568a.get(size));
        }
    }
}
