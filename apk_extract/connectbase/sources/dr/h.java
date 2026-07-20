package dr;

import com.transsion.sdk.oneid.data.IdChangeInfo;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<IdChangeInfo> f3849a;

    public h(ArrayList<IdChangeInfo> arrayList) {
        this.f3849a = arrayList;
    }

    public i<String> a() {
        return f.a(l.e().a(), new v1.e().toJson(this.f3849a), 0);
    }
}
