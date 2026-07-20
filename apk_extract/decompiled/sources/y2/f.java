package y2;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.moduleinstall.ModuleAvailabilityResponse;
import com.google.android.gms.common.moduleinstall.internal.ApiFeatureRequest;
import java.util.Arrays;
import q2.j;
import q3.k;
import r2.i;
import tj.w;
import u2.l;

/* JADX INFO: loaded from: classes.dex */
public final class f extends q2.f {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final u6.c f11029i = new u6.c("ModuleInstall.API", new o3.b(3), new n5.a());

    public final k c(j... jVarArr) {
        l.a("Please provide at least one OptionalModuleApi.", jVarArr.length > 0);
        for (j jVar : jVarArr) {
            l.f(jVar, "Requested API must not be null.");
        }
        ApiFeatureRequest apiFeatureRequestG = ApiFeatureRequest.g(Arrays.asList(jVarArr), false);
        if (apiFeatureRequestG.f1921a.isEmpty()) {
            ModuleAvailabilityResponse moduleAvailabilityResponse = new ModuleAvailabilityResponse(true, 0);
            k kVar = new k();
            kVar.g(moduleAvailabilityResponse);
            return kVar;
        }
        i iVar = new i();
        iVar.f9335a = new Feature[]{h3.d.f5240c};
        iVar.f9337c = 27301;
        iVar.f9336b = false;
        iVar.f9338d = new w(this, apiFeatureRequestG);
        return b(0, iVar.a());
    }
}
