package c;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCallerKt;
import com.transsion.iotcardsdk.DeviceProviderService;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements ActivityResultCallback, ek.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f1355b;

    public /* synthetic */ a(int i8, Function1 function1) {
        this.f1354a = i8;
        this.f1355b = function1;
    }

    @Override // ek.b
    /* JADX INFO: renamed from: call */
    public void mo0call(Object obj) {
        DeviceProviderService.onMessageEvent$lambda$0(this.f1355b, obj);
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public void onActivityResult(Object obj) {
        int i8 = this.f1354a;
        Function1 function1 = this.f1355b;
        switch (i8) {
            case 0:
                ActivityResultCallerKt.registerForActivityResult$lambda$0(function1, obj);
                break;
            default:
                ActivityResultCallerKt.registerForActivityResult$lambda$1(function1, obj);
                break;
        }
    }
}
