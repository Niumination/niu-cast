package dc;

import android.util.Log;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import java.util.ArrayList;
import k3.gc;
import k3.o1;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class j implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f4415b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ActivityResultLauncher f4416c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Function1 f4417d;
    public final /* synthetic */ FragmentActivity e;

    public /* synthetic */ j(FragmentActivity fragmentActivity, ArrayList arrayList, ActivityResultLauncher activityResultLauncher, Function1 function1, int i8) {
        this.f4414a = i8;
        this.e = fragmentActivity;
        this.f4415b = arrayList;
        this.f4416c = activityResultLauncher;
        this.f4417d = function1;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.f4414a) {
            case 0:
                Intrinsics.checkNotNullParameter("PermissionExt", "tag");
                Intrinsics.checkNotNullParameter("Permission not granted", "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("PermissionExt"), "Permission not granted");
                }
                o1.b((AppCompatActivity) this.e, this.f4415b, this.f4416c, this.f4417d, "PermissionExt");
                break;
            default:
                Intrinsics.checkNotNullParameter("QrScanActivity", "tag");
                Intrinsics.checkNotNullParameter("Permission not granted", "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("QrScanActivity"), "Permission not granted");
                }
                o1.b(this.e, this.f4415b, this.f4416c, null, "QrScanActivity");
                this.f4417d.invoke(Boolean.FALSE);
                break;
        }
        return Unit.INSTANCE;
    }
}
