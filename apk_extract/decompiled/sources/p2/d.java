package p2;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.transsion.widgetslib.R$id;
import com.transsion.widgetslib.R$layout;
import com.transsion.widgetslib.view.liquid.effect.OSLiquidContainerRootLayoutInner;
import java.util.concurrent.Executors;
import zd.n;

/* JADX INFO: loaded from: classes.dex */
public final class d implements f2.b, g3.b, ek.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static d f8654a;

    public static final View c(View view) {
        ViewGroup viewGroup;
        int i8 = n.f11295m;
        if (view == null) {
            return null;
        }
        View viewInflate = LayoutInflater.from(view.getContext()).inflate(R$layout.os_liquid_popup_window_container, (ViewGroup) null);
        if (!(viewInflate instanceof ViewGroup)) {
            return view;
        }
        ViewGroup viewGroup2 = (ViewGroup) viewInflate;
        View viewFindViewById = viewGroup2.findViewById(R$id.liquid_popview);
        OSLiquidContainerRootLayoutInner oSLiquidContainerRootLayoutInner = (OSLiquidContainerRootLayoutInner) viewGroup2.findViewById(R$id.liquid_container);
        if (viewFindViewById instanceof ViewGroup) {
            ViewParent parent = view.getParent();
            viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
            ViewGroup viewGroup3 = (ViewGroup) viewFindViewById;
            viewGroup3.removeAllViews();
            viewGroup3.addView(view, new ViewGroup.LayoutParams(-1, -2));
        } else if (viewFindViewById != null) {
            ViewParent parent2 = viewFindViewById.getParent();
            viewGroup = parent2 instanceof ViewGroup ? (ViewGroup) parent2 : null;
            int iIndexOfChild = viewGroup != null ? viewGroup.indexOfChild(viewFindViewById) : -1;
            ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
            if (viewGroup != null) {
                viewGroup.removeView(viewFindViewById);
            }
            view.setLayoutParams(layoutParams);
            if (iIndexOfChild < 0) {
                viewGroup2.addView(view);
            } else if (viewGroup != null) {
                viewGroup.addView(view, iIndexOfChild);
            }
        } else {
            viewGroup2.addView(view, new ViewGroup.LayoutParams(-1, -2));
        }
        oSLiquidContainerRootLayoutInner.forceHasOverlappingRendering(false);
        return viewInflate;
    }

    public static final g d(PackageInfo packageInfo, g... gVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null) {
            return null;
        }
        if (signatureArr.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        h hVar = new h(packageInfo.signatures[0].toByteArray());
        for (int i8 = 0; i8 < gVarArr.length; i8++) {
            if (gVarArr[i8].equals(hVar)) {
                return gVarArr[i8];
            }
        }
        return null;
    }

    public static final boolean e(PackageInfo packageInfo) {
        ApplicationInfo applicationInfo;
        boolean z2 = packageInfo == null || !(("com.android.vending".equals(packageInfo.packageName) || "com.google.android.gms".equals(packageInfo.packageName)) && ((applicationInfo = packageInfo.applicationInfo) == null || (applicationInfo.flags & 129) == 0));
        if (packageInfo != null && packageInfo.signatures != null) {
            if ((z2 ? d(packageInfo, i.f8660a) : d(packageInfo, i.f8660a[0])) != null) {
                return true;
            }
        }
        return false;
    }

    @Override // g3.b
    public int a(Context context, String str, boolean z2) {
        return g3.e.d(context, str, z2);
    }

    @Override // g3.b
    public int b(Context context, String str) {
        return g3.e.a(context, str);
    }

    @Override // yh.a
    public Object get() {
        return new d2.h(Executors.newSingleThreadExecutor(), 0);
    }
}
