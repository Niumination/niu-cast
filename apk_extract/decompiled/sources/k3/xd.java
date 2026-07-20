package k3;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class xd implements wd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f6710a;

    public xd(Context context, vd vdVar) {
        ArrayList arrayList = new ArrayList();
        this.f6710a = arrayList;
        if (vdVar.f6686b) {
            arrayList.add(new de(context, vdVar));
        }
    }

    @Override // k3.wd
    public final void a(df.m mVar) {
        Iterator it = this.f6710a.iterator();
        while (it.hasNext()) {
            ((wd) it.next()).a(mVar);
        }
    }
}
