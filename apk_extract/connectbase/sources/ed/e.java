package ed;

import android.os.IBinder;
import bf.l;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.internal.app.ITranLocaleHelperService;
import com.transsion.hubsdk.internal.app.TranLocale;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class e implements l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f4262b = "e";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranLocaleHelperService f4263a;

    public e() {
        IBinder serviceIBinder = TranServiceManager.getServiceIBinder("locale_helper");
        dc.e.a(f4262b, "TranThubLocaleHelper: " + serviceIBinder);
        this.f4263a = ITranLocaleHelperService.Stub.asInterface(serviceIBinder);
    }

    @Override // bf.l
    public String a(Locale locale, Locale locale2, boolean z10) {
        try {
            return this.f4263a.getDisplayName(new TranLocale(locale), new TranLocale(locale2), z10);
        } catch (Exception e10) {
            dc.e.d(f4262b, "getDisplayName: ", e10);
            return null;
        }
    }

    @Override // bf.l
    public String b(Locale locale, boolean z10) {
        return new m7.f().b(locale, z10);
    }
}
