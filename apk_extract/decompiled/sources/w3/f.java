package w3;

import com.google.android.material.color.utilities.DynamicScheme;
import com.google.android.material.color.utilities.MaterialDynamicColors;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MaterialDynamicColors f10659b;

    public /* synthetic */ f(MaterialDynamicColors materialDynamicColors, int i8) {
        this.f10658a = i8;
        this.f10659b = materialDynamicColors;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i8 = this.f10658a;
        MaterialDynamicColors materialDynamicColors = this.f10659b;
        DynamicScheme dynamicScheme = (DynamicScheme) obj;
        switch (i8) {
            case 0:
                return materialDynamicColors.lambda$onPrimaryFixedVariant$116(dynamicScheme);
            case 1:
                return materialDynamicColors.lambda$tertiaryFixedDim$136(dynamicScheme);
            case 2:
                return materialDynamicColors.lambda$onTertiary$84(dynamicScheme);
            case 3:
                return materialDynamicColors.lambda$onError$96(dynamicScheme);
            case 4:
                return materialDynamicColors.lambda$onPrimaryContainer$62(dynamicScheme);
            case 5:
                return materialDynamicColors.lambda$onPrimaryContainer$63(dynamicScheme);
            case 6:
                return materialDynamicColors.lambda$secondaryFixedDim$122(dynamicScheme);
            case 7:
                return materialDynamicColors.lambda$primaryFixed$105(dynamicScheme);
            case 8:
                return materialDynamicColors.lambda$primaryFixedDim$108(dynamicScheme);
            case 9:
                return materialDynamicColors.lambda$tertiaryContainer$87(dynamicScheme);
            default:
                return materialDynamicColors.highestSurface(dynamicScheme);
        }
    }
}
