package pd;

import android.content.ContextWrapper;
import android.provider.Settings;
import android.text.TextUtils;
import com.transsion.widgetslib.R$bool;
import com.transsion.widgetslib.R$integer;
import com.transsion.widgetslib.R$style;
import java.util.HashMap;
import k3.z8;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap f8716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f8717b;

    static {
        HashMap map = new HashMap();
        f8716a = map;
        f8717b = new int[]{R$style.OSBrandBlueDy, R$style.OSBrandGreenDy, R$style.OSTrendyDy, R$style.OSElegantDy, R$style.OSPovaDy};
        map.put("preset_brand", 0);
        map.put("preset_brand_green", 1);
        map.put("preset_trendy", 2);
        map.put("preset_elegant", 3);
        map.put("preset_pova", 4);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x014f  */
    public static final void a(ContextWrapper context, int i8, boolean z2) {
        int iIntValue;
        HashMap map = f8716a;
        Intrinsics.checkNotNullParameter(context, "context");
        if ((j.f8770i && j.f8774m < 14) || z2) {
            context.getTheme().applyStyle(i8, true);
            return;
        }
        z8.b("DynamicColorTool", "gpMarket = false");
        Intrinsics.checkNotNullParameter(context, "context");
        if (context.getResources().getBoolean(R$bool.os_custom_theme) && context.getResources().getInteger(R$integer.os_theme_pkg_version) < 1610) {
            context.getTheme().applyStyle(R$style.OSCompileBgStyle, true);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(context, "context");
        boolean z3 = context.getResources().getBoolean(R$bool.os_custom_theme);
        int i9 = Settings.System.getInt(context.getContentResolver(), "os_common_control_current_color", 1);
        boolean z5 = context.getResources().getBoolean(R$bool.os_custom_platform_color);
        z8.b("DynamicColorTool", "osCustomTheme = " + z3 + " osCustomPlatformColor = " + z5 + " transCurrentColor = " + i9 + " packageName = " + context.getPackageName());
        if (z3 && z5 && i9 == 1) {
            context.getTheme().applyStyle(R$style.OSThemePackage, true);
            return;
        }
        int i10 = Settings.System.getInt(context.getContentResolver(), "dynamic_color_state", 1);
        z8.f("DynamicColorTool", "isDyOpen: " + i10);
        boolean z10 = i10 != 0;
        z8.f("DynamicColorTool", "adaptDyColor: dyOpen = " + z10 + " DY_DEFAULT_STYLE_MAP = " + map.size());
        if (!z10) {
            context.getTheme().applyStyle(i8, true);
            return;
        }
        z8.f("DynamicColorTool", "adaptDyColor getRequireDy: osType = " + j.f);
        String[] strArr = j.f8764a;
        String[] strArr2 = j.f8764a;
        String[] strArr3 = j.f8764a;
        z8.f("DynamicColorTool", "adaptDyColor getRequireDy: nonDyOS = NONE");
        z8.f("DynamicColorTool", "adaptDyColor: requireDy = true");
        String string = Settings.System.getString(context.getContentResolver(), "trans_dynamic_applied_json");
        z8.f("DynamicColorTool", "adaptDyColor transDynamicAppliedJsonStr: " + string);
        if (TextUtils.isEmpty(string)) {
            iIntValue = -1;
        } else {
            try {
                JSONObject jSONObject = new JSONObject(string);
                if (jSONObject.has("android.theme.customization.trans_color_type")) {
                    String colorSource = jSONObject.optString("android.theme.customization.trans_color_type");
                    if (TextUtils.isEmpty(colorSource)) {
                        iIntValue = -1;
                    } else {
                        Intrinsics.checkNotNullExpressionValue(colorSource, "colorSource");
                        if (StringsKt__StringsKt.contains$default(colorSource, "PRESET_COLOR", false, 2, (Object) null) && jSONObject.has("android.theme.customization.preset_name")) {
                            String strOptString = jSONObject.optString("android.theme.customization.preset_name");
                            if (TextUtils.isEmpty(strOptString) || !map.containsKey(strOptString)) {
                                iIntValue = -1;
                            } else {
                                Object obj = map.get(strOptString);
                                Intrinsics.checkNotNull(obj);
                                iIntValue = ((Number) obj).intValue();
                                z8.f("DynamicColorTool", "adaptDyColor: dyType = " + iIntValue);
                            }
                        } else {
                            iIntValue = -1;
                        }
                    }
                } else {
                    iIntValue = -1;
                }
            } catch (JSONException e) {
                System.out.print(e.getStackTrace());
            }
        }
        z8.f("DynamicColorTool", "adaptDyColor: brandColorIndexFromJson " + iIntValue);
        if (iIntValue <= -1 || iIntValue >= map.size()) {
            return;
        }
        context.getTheme().applyStyle(f8717b[iIntValue], true);
    }
}
