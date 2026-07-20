package w3;

import com.google.android.material.color.utilities.DynamicScheme;
import com.google.android.material.color.utilities.MaterialDynamicColors;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10652a;

    public /* synthetic */ a(int i8) {
        this.f10652a = i8;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        DynamicScheme dynamicScheme = (DynamicScheme) obj;
        switch (this.f10652a) {
            case 0:
                return MaterialDynamicColors.lambda$surface$15(dynamicScheme);
            case 1:
                return MaterialDynamicColors.lambda$onSecondary$70(dynamicScheme);
            case 2:
                return MaterialDynamicColors.lambda$onSecondary$71(dynamicScheme);
            case 3:
                return MaterialDynamicColors.lambda$secondary$67(dynamicScheme);
            case 4:
                return MaterialDynamicColors.lambda$secondary$68(dynamicScheme);
            case 5:
                return MaterialDynamicColors.lambda$surfaceContainerLowest$21(dynamicScheme);
            case 6:
                return MaterialDynamicColors.lambda$surfaceContainerLowest$22(dynamicScheme);
            case 7:
                return MaterialDynamicColors.lambda$outline$42(dynamicScheme);
            case 8:
                return MaterialDynamicColors.lambda$outline$43(dynamicScheme);
            case 9:
                return MaterialDynamicColors.lambda$neutralPaletteKeyColor$6(dynamicScheme);
            case 10:
                return MaterialDynamicColors.lambda$surfaceTint$50(dynamicScheme);
            case 11:
                return MaterialDynamicColors.lambda$surfaceTint$51(dynamicScheme);
            case 12:
                return MaterialDynamicColors.lambda$onSecondaryFixed$123(dynamicScheme);
            case 13:
                return MaterialDynamicColors.lambda$onSecondaryFixed$124(dynamicScheme);
            case 14:
                return MaterialDynamicColors.lambda$inverseOnSurface$39(dynamicScheme);
            case 15:
                return MaterialDynamicColors.lambda$inverseOnSurface$40(dynamicScheme);
            case 16:
                return MaterialDynamicColors.lambda$onTertiaryContainer$88(dynamicScheme);
            case 17:
                return MaterialDynamicColors.lambda$neutralPaletteKeyColor$7(dynamicScheme);
            case 18:
                return MaterialDynamicColors.lambda$onSecondaryContainer$76(dynamicScheme);
            case 19:
                return MaterialDynamicColors.lambda$onPrimaryFixed$109(dynamicScheme);
            case 20:
                return MaterialDynamicColors.lambda$onPrimaryFixed$110(dynamicScheme);
            case 21:
                return MaterialDynamicColors.lambda$error$91(dynamicScheme);
            case 22:
                return MaterialDynamicColors.lambda$surfaceDim$17(dynamicScheme);
            case 23:
                return MaterialDynamicColors.lambda$error$92(dynamicScheme);
            case 24:
                return MaterialDynamicColors.lambda$textPrimaryInverse$152(dynamicScheme);
            case 25:
                return MaterialDynamicColors.lambda$textPrimaryInverse$153(dynamicScheme);
            case 26:
                return MaterialDynamicColors.lambda$surfaceContainer$25(dynamicScheme);
            case 27:
                return MaterialDynamicColors.lambda$surfaceContainer$26(dynamicScheme);
            case 28:
                return MaterialDynamicColors.lambda$onSurfaceVariant$35(dynamicScheme);
            default:
                return MaterialDynamicColors.lambda$onSurfaceVariant$36(dynamicScheme);
        }
    }
}
