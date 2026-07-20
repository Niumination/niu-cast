package r2;

import android.animation.ValueAnimator;
import android.content.Context;
import android.location.LocationManager;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Display;
import android.view.DisplayCutout;
import android.widget.ListPopupWindow;
import com.transsion.athena.data.TrackData;
import com.transsion.widgetslib.view.damping.OSSmartScrollbar;
import com.transsion.widgetslib.view.letter.LetterSelectorLayout;
import com.transsion.widgetslib.widget.FootOperationBar;
import com.transsion.widgetslib.widget.InvertArrowSpinner;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import m3.g0;
import ze.y;

/* JADX INFO: loaded from: classes.dex */
public final class w implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f9376b;

    public /* synthetic */ w(Object obj, int i8) {
        this.f9375a = i8;
        this.f9376b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        boolean z2;
        DisplayCutout cutout;
        ListPopupWindow listPopupWindow;
        switch (this.f9375a) {
            case 0:
                throw null;
            case 1:
                ((OSSmartScrollbar) this.f9376b).f3248n.start();
                return;
            case 2:
                LetterSelectorLayout letterSelectorLayout = (LetterSelectorLayout) this.f9376b;
                ValueAnimator valueAnimator = letterSelectorLayout.f3297b;
                if (valueAnimator == null || valueAnimator.isRunning()) {
                    return;
                }
                letterSelectorLayout.f3297b.start();
                letterSelectorLayout.f3299c.start();
                return;
            case 3:
                Context context = e8.b.f4712i;
                i1.a aVarA = i1.a.a(context);
                String strI = aVarA.i("athena_id");
                try {
                    str = g0.b(context).f5115a;
                    break;
                } catch (Exception e) {
                    z6.a.b("%s", e.getMessage());
                    str = null;
                }
                if (!TextUtils.isEmpty(str) && !TextUtils.equals(strI, str)) {
                    aVarA.g("athena_id", str);
                    if (!TextUtils.isEmpty(strI)) {
                        try {
                            z2 = (z6.b.f(context, "android.permission.READ_PHONE_STATE") || z6.b.f(context, "android.permission.READ_PRIVILEGED_PHONE_STATE")) ? !z6.b.i(context) : false;
                        } catch (Exception unused) {
                            z2 = true;
                        }
                        if (z2) {
                            if (TextUtils.isEmpty(g0.k())) {
                                TrackData trackData = new TrackData();
                                trackData.e(2, "en", "device_id_transfer");
                                trackData.b(1, 1, "cnt");
                                long j8 = 9999;
                                e8.b.n(j8).o("data_discard", trackData, j8);
                            } else {
                                TrackData trackData2 = new TrackData();
                                trackData2.g("pre_gaid", strI);
                                trackData2.g("sn", g0.k());
                                long j10 = 9999;
                                e8.b.n(j10).o("device_id_transfer", trackData2, j10);
                            }
                        }
                    }
                    strI = str;
                }
                if (!TextUtils.isEmpty(strI)) {
                    z6.b.f11259a = strI;
                }
                if (!((TextUtils.isEmpty(strI) && TextUtils.isEmpty(g0.c(context, 0))) ? false : true)) {
                    z6.a.b("%s", "device gaid and iid are null");
                }
                ((Handler) this.f9376b).postDelayed(this, 7200000L);
                return;
            case 4:
                x6.c cVar = (x6.c) this.f9376b;
                try {
                    cVar.m(null);
                    LocationManager locationManager = (LocationManager) ((Context) cVar.f1434b).getApplicationContext().getSystemService("location");
                    if (locationManager != null) {
                        locationManager.removeUpdates(cVar.f10881r);
                        return;
                    }
                    return;
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return;
                }
            case 5:
                FootOperationBar footOperationBar = (FootOperationBar) this.f9376b;
                Display display = footOperationBar.getDisplay();
                if (display == null || (cutout = display.getCutout()) == null || (listPopupWindow = footOperationBar.f3371c) == null) {
                    return;
                }
                listPopupWindow.setHorizontalOffset(-cutout.getSafeInsetRight());
                return;
            case 6:
                InvertArrowSpinner invertArrowSpinner = (InvertArrowSpinner) ((kd.a) this.f9376b).f6822b;
                if (invertArrowSpinner.f3391c) {
                    return;
                }
                invertArrowSpinner.performClick();
                return;
            default:
                try {
                    ((ze.s) this.f9376b).t(new TimeoutException("context timed out"));
                    return;
                } catch (Throwable th2) {
                    y.f11473d.log(Level.SEVERE, "Cancel threw an exception, which should not happen", th2);
                    return;
                }
        }
    }

    public w(j jVar, ef.o oVar) {
        this.f9375a = 0;
        this.f9376b = oVar;
    }
}
