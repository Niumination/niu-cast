package va;

import android.R;
import android.content.BroadcastReceiver;
import android.content.ContextWrapper;
import android.content.IntentFilter;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import com.transsion.iotservice.multiscreen.pc.R$id;
import com.transsion.iotservice.multiscreen.pc.ui.BaseActivity;
import com.transsion.message.cast.analytics.p000const.EAnalyticsParams;
import com.transsion.widgetsThemes.R$color;
import com.transsion.widgetsbottomsheet.bottomsheet.OSBaseBottomSheetDialog;
import com.transsion.widgetslib.R$style;
import java.util.ArrayList;
import java.util.Arrays;
import k3.gc;
import k3.pb;
import k3.sb;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import pd.j;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {
    public static final void a(AppCompatActivity appCompatActivity) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "<this>");
        pd.a.a(appCompatActivity, j.c(R$style.OSDefaultColorHIOS, R$style.OSDefaultColorXOS, R$style.OSDefaultColorITELOS), false);
        if (sb.b()) {
            return;
        }
        pd.a.a(appCompatActivity, j.c(com.transsion.widgetsThemes.R$style.OSDefaultColorHIOS, com.transsion.widgetsThemes.R$style.OSDefaultColorXOS, com.transsion.widgetsThemes.R$style.OSDefaultColorITELOS), true);
    }

    public static final void b(AppCompatActivity appCompatActivity, boolean z2) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "<this>");
        if (!TextUtils.equals("phone", EAnalyticsParams.DEVICE_TYPE_PAD)) {
            pd.d.c(appCompatActivity, pb.a());
        }
        j.F(appCompatActivity, com.transsion.iotservice.multiscreen.pc.R$style.Theme_PcConnectTheme_hios, com.transsion.iotservice.multiscreen.pc.R$style.Theme_PcConnectTheme_xos, com.transsion.iotservice.multiscreen.pc.R$style.Theme_PcConnectTheme_itel, z2);
        a(appCompatActivity);
    }

    public static final int c(BaseActivity baseActivity) {
        TypedValue typedValue = new TypedValue();
        if (baseActivity.getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true)) {
            return TypedValue.complexToDimensionPixelSize(typedValue.data, baseActivity.getResources().getDisplayMetrics());
        }
        return 0;
    }

    public static final String d(int i8, int... params) {
        Intrinsics.checkNotNullParameter(params, "params");
        ArrayList arrayList = new ArrayList(params.length);
        for (int i9 : params) {
            arrayList.add(pb.a().getString(i9));
        }
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = pb.a().getString(i8);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        Object[] objArrCopyOf = Arrays.copyOf(strArr, strArr.length);
        return o.d.q(objArrCopyOf, objArrCopyOf.length, string, "format(...)");
    }

    public static final void e(final BaseActivity context) {
        int i8;
        Intrinsics.checkNotNullParameter(context, "<this>");
        int color = na.c.a() ? context.getColor(R$color.os_bg_primary_color_xos) : context.getColor(R$color.os_bg_primary_color_hios);
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            i8 = Settings.Secure.getInt(context.getApplicationContext().getContentResolver(), "navigation_mode", 0);
        } catch (Exception e) {
            e.printStackTrace();
            i8 = 0;
        }
        final boolean z2 = i8 == 2;
        context.getWindow().setStatusBarColor(0);
        if (z2) {
            context.getWindow().setNavigationBarColor(0);
            WindowCompat.setDecorFitsSystemWindows(context.getWindow(), false);
        } else {
            context.getWindow().setNavigationBarColor(color);
            WindowCompat.setDecorFitsSystemWindows(context.getWindow(), true);
        }
        View decorView = context.getWindow().getDecorView();
        Intrinsics.checkNotNull(decorView, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) decorView;
        viewGroup.setClipToPadding(false);
        ViewCompat.setOnApplyWindowInsetsListener(viewGroup, new OnApplyWindowInsetsListener() { // from class: va.a
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View v3, WindowInsetsCompat insets) {
                Intrinsics.checkNotNullParameter(v3, "v");
                Intrinsics.checkNotNullParameter(insets, "insets");
                Insets insets2 = insets.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout());
                Intrinsics.checkNotNullExpressionValue(insets2, "getInsets(...)");
                int i9 = insets2.top;
                int i10 = insets2.bottom;
                View viewFindViewById = v3.findViewById(R$id.liquidBar);
                if (viewFindViewById != null) {
                    viewFindViewById.setPadding(0, i9, 0, 0);
                }
                View viewFindViewById2 = v3.findViewById(R$id.damping_layout);
                ViewGroup.LayoutParams layoutParams = viewFindViewById2.getLayoutParams();
                FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
                BaseActivity baseActivity = context;
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = b.c(baseActivity) + i9;
                    viewFindViewById2.setLayoutParams(layoutParams2);
                }
                if (!z2) {
                    v3.setPadding(0, 0, 0, i10);
                    v3.setOnTouchListener(new b4.e(2));
                }
                int iC = b.c(baseActivity);
                int i11 = insets2.bottom;
                StringBuilder sbR = o.d.r(i9, iC, "window.decorView: top:", ",actionBar:", ". bottom:");
                sbR.append(i11);
                sbR.append(" ");
                String log = sbR.toString();
                Intrinsics.checkNotNullParameter("initWindowStyle", "tag");
                Intrinsics.checkNotNullParameter(log, "log");
                if (gc.f6462a <= 6) {
                    Log.e(gc.f6463b.concat("initWindowStyle"), log);
                }
                return insets;
            }
        });
    }

    public static final void f(ContextWrapper contextWrapper, BroadcastReceiver broadcastReceiver, String filter, boolean z2) {
        Intrinsics.checkNotNullParameter(contextWrapper, "<this>");
        Intrinsics.checkNotNullParameter(broadcastReceiver, "broadcastReceiver");
        Intrinsics.checkNotNullParameter(filter, "filter");
        if (z2) {
            contextWrapper.registerReceiver(broadcastReceiver, new IntentFilter(filter), 2);
        } else {
            contextWrapper.registerReceiver(broadcastReceiver, new IntentFilter(filter), 4);
        }
    }

    public static final void g(OSBaseBottomSheetDialog oSBaseBottomSheetDialog) {
        Intrinsics.checkNotNullParameter(oSBaseBottomSheetDialog, "<this>");
        oSBaseBottomSheetDialog.getWindow().setStatusBarColor(0);
        Intrinsics.checkNotNullParameter(oSBaseBottomSheetDialog, "<this>");
        oSBaseBottomSheetDialog.setRequestedOrientation((!sb.b() || na.d.a()) ? -1 : 1);
        if (!TextUtils.equals("phone", EAnalyticsParams.DEVICE_TYPE_PAD)) {
            pd.d.c(oSBaseBottomSheetDialog, pb.a());
        }
        j.F(oSBaseBottomSheetDialog, R$style.OS_Theme_AppCompat_hios_NoActionBar_Transparent, R$style.OS_Theme_AppCompat_xos_NoActionBar_Transparent, R$style.OS_Theme_AppCompat_itel_NoActionBar_Transparent, true);
        a(oSBaseBottomSheetDialog);
    }
}
