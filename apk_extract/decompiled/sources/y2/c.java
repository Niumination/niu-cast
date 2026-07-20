package y2;

import android.os.IInterface;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.moduleinstall.ModuleAvailabilityResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallResponse;

/* JADX INFO: loaded from: classes.dex */
public interface c extends IInterface {
    void a(Status status, ModuleInstallResponse moduleInstallResponse);

    void b(Status status, ModuleAvailabilityResponse moduleAvailabilityResponse);
}
