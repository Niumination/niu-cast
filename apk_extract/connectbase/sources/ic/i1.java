package ic;

import com.transsion.hubsdk.app.TranAppGlobals;

/* JADX INFO: loaded from: classes2.dex */
public class i1 implements bf.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f7815a = "i1";

    @Override // bf.j
    public int a(String str, int i10) {
        try {
            return TranAppGlobals.getIntCoreSetting(str, i10);
        } catch (RuntimeException e10) {
            dc.e.c(f7815a, "startDozing fail " + e10);
            return 0;
        }
    }
}
