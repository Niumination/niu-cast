package y2;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.moduleinstall.ModuleAvailabilityResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallResponse;
import k3.uc;

/* JADX INFO: loaded from: classes.dex */
public final class e extends h3.b implements c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f11027c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ q3.g f11028d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(q3.g gVar, int i8) {
        super("com.google.android.gms.common.moduleinstall.internal.IModuleInstallCallbacks", 0);
        this.f11027c = i8;
        this.f11028d = gVar;
    }

    @Override // y2.c
    public void a(Status status, ModuleInstallResponse moduleInstallResponse) {
        switch (this.f11027c) {
            case 1:
                uc.a(status, moduleInstallResponse, this.f11028d);
                return;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // y2.c
    public void b(Status status, ModuleAvailabilityResponse moduleAvailabilityResponse) {
        switch (this.f11027c) {
            case 0:
                uc.a(status, moduleAvailabilityResponse, this.f11028d);
                return;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // h3.b
    public final boolean i(int i8, Parcel parcel, Parcel parcel2) {
        if (i8 == 1) {
            Status status = (Status) h3.c.a(parcel, Status.CREATOR);
            ModuleAvailabilityResponse moduleAvailabilityResponse = (ModuleAvailabilityResponse) h3.c.a(parcel, ModuleAvailabilityResponse.CREATOR);
            h3.c.b(parcel);
            b(status, moduleAvailabilityResponse);
        } else {
            if (i8 != 2) {
                if (i8 == 3) {
                    h3.c.b(parcel);
                    throw new UnsupportedOperationException();
                }
                if (i8 != 4) {
                    return false;
                }
                h3.c.b(parcel);
                throw new UnsupportedOperationException();
            }
            Status status2 = (Status) h3.c.a(parcel, Status.CREATOR);
            ModuleInstallResponse moduleInstallResponse = (ModuleInstallResponse) h3.c.a(parcel, ModuleInstallResponse.CREATOR);
            h3.c.b(parcel);
            a(status2, moduleInstallResponse);
        }
        return true;
    }
}
