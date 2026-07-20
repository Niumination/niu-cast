package bb;

import android.preference.PreferenceFragment;
import android.widget.ListView;
import dc.e;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f804c = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public be.a f805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public l8.a f806b;

    public ListView a(PreferenceFragment preferenceFragment) {
        return b(fc.b.a.f5989i).a(preferenceFragment);
    }

    public vg.a b(String str) {
        if (fc.b.b(str)) {
            e.f(f804c, "TranThubPreferenceFragment");
            be.a aVar = this.f805a;
            if (aVar != null) {
                return aVar;
            }
            be.a aVar2 = new be.a();
            this.f805a = aVar2;
            return aVar2;
        }
        e.f(f804c, "TranAospPreferenceFragment");
        l8.a aVar3 = this.f806b;
        if (aVar3 != null) {
            return aVar3;
        }
        l8.a aVar4 = new l8.a();
        this.f806b = aVar4;
        return aVar4;
    }
}
