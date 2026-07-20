package c;

import android.annotation.SystemApi;
import android.content.Context;
import android.provider.SearchIndexableData;
import gm.i;

/* JADX INFO: loaded from: classes.dex */
@SystemApi
public class b extends SearchIndexableData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1102a;

    public b(int i10, int i11, String str, int i12) {
        this.rank = i10;
        this.f1102a = i11;
        this.className = str;
        this.iconResId = i12;
    }

    @i
    public String a() {
        StringBuilder sb2 = new StringBuilder("SearchIndexableResource[");
        sb2.append(super.toString());
        sb2.append(", xmlResId: ");
        return a.a(sb2, this.f1102a, "]");
    }

    public b(Context context) {
        super(context);
    }
}
