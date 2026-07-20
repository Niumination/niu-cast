package ed;

import android.os.IBinder;
import android.os.LocaleList;
import android.os.RemoteException;
import com.android.internal.annotations.VisibleForTesting;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.internal.app.ITranLocalePicker;
import com.transsion.hubsdk.internal.app.TranLocale;
import com.transsion.hubsdk.internal.app.TranLocaleInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class g implements xf.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f4266b = "g";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranLocalePicker f4267a;

    public g() {
        IBinder serviceIBinder = TranServiceManager.getServiceIBinder("locale_picker");
        dc.e.a(f4266b, "TranThubLocalePickerManager: " + serviceIBinder);
        this.f4267a = ITranLocalePicker.Stub.asInterface(serviceIBinder);
    }

    @Override // xf.c
    public void a(LocaleList localeList) {
        ITranLocalePicker iTranLocalePicker = this.f4267a;
        if (iTranLocalePicker == null) {
            return;
        }
        try {
            iTranLocalePicker.updateLocales(localeList);
        } catch (RemoteException e10) {
            dc.e.a(f4266b, "updateLocales fail: " + e10);
        }
    }

    @Override // xf.c
    public List<da.e> b(boolean z10) {
        ArrayList arrayList = new ArrayList();
        if (this.f4267a == null) {
            return arrayList;
        }
        List<TranLocaleInfo> arrayList2 = new ArrayList();
        try {
            arrayList2 = this.f4267a.getAllAssetLocales(z10);
        } catch (RemoteException e10) {
            dc.e.a(f4266b, "getAllAssetLocales fail: " + e10);
        }
        for (TranLocaleInfo tranLocaleInfo : arrayList2) {
            arrayList.add(new da.e(tranLocaleInfo.getLabel(), tranLocaleInfo.getLocale()));
        }
        return arrayList;
    }

    @Override // xf.c
    public void c(final Locale locale) {
        new zb.f().c(new zb.f.b() { // from class: ed.f
            @Override // zb.f.b
            public final Object run() {
                return this.f4264a.e(locale);
            }
        }, "locale_picker");
        dc.e.a(f4266b, "updateLocale");
    }

    public final /* synthetic */ Object e(Locale locale) throws RemoteException {
        TranLocale tranLocale = new TranLocale(locale);
        ITranLocalePicker iTranLocalePicker = this.f4267a;
        if (iTranLocalePicker == null) {
            return null;
        }
        iTranLocalePicker.updateLocale(tranLocale);
        return null;
    }

    @VisibleForTesting
    public void f(ITranLocalePicker iTranLocalePicker) {
        this.f4267a = iTranLocalePicker;
    }
}
