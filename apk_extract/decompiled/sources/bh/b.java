package bh;

import com.google.android.material.color.utilities.DynamicColor;
import com.google.android.material.color.utilities.DynamicScheme;
import com.google.android.material.color.utilities.Hct;
import com.google.android.material.color.utilities.TemperatureCache;
import com.google.android.material.color.utilities.TonalPalette;
import java.util.function.Function;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class b implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1329b;

    public /* synthetic */ b(Object obj, int i8) {
        this.f1328a = i8;
        this.f1329b = obj;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f1328a) {
            case 0:
                return ((a) this.f1329b).f1327b.invoke();
            case 1:
                return DynamicColor.lambda$fromArgb$0((TonalPalette) this.f1329b, (DynamicScheme) obj);
            case 2:
                return DynamicColor.lambda$fromArgb$1((Hct) this.f1329b, (DynamicScheme) obj);
            default:
                return ((TemperatureCache) this.f1329b).lambda$getHctsByTemp$0((Hct) obj);
        }
    }
}
