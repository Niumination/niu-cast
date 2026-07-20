package m3;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class na implements ma {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f7791a;

    public na(Context context, la laVar) {
        ArrayList arrayList = new ArrayList();
        this.f7791a = arrayList;
        arrayList.add(new pa(context, laVar));
    }

    @Override // m3.ma
    public final void a(i1.a aVar) {
        Iterator it = this.f7791a.iterator();
        while (it.hasNext()) {
            ((ma) it.next()).a(aVar);
        }
    }
}
