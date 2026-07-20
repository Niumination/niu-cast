package bb;

import com.transsion.iotservice.multiscreen.pc.helper.BaseSettingActivity;
import k3.pb;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class e implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseSettingActivity f1234b;

    public /* synthetic */ e(BaseSettingActivity baseSettingActivity, int i8) {
        this.f1233a = i8;
        this.f1234b = baseSettingActivity;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        BaseSettingActivity baseSettingActivity = this.f1234b;
        switch (this.f1233a) {
            case 0:
                int i8 = BaseSettingActivity.f2662k;
                baseSettingActivity.n().f(pb.a());
                baseSettingActivity.f2666h = null;
                return Unit.INSTANCE;
            case 1:
                int i9 = BaseSettingActivity.f2662k;
                baseSettingActivity.n().e(pb.a());
                baseSettingActivity.e = null;
                return Unit.INSTANCE;
            case 2:
                int i10 = BaseSettingActivity.f2662k;
                baseSettingActivity.getClass();
                return new l(baseSettingActivity);
            default:
                int i11 = BaseSettingActivity.f2662k;
                baseSettingActivity.n().d(pb.a());
                baseSettingActivity.f2665d = null;
                return Unit.INSTANCE;
        }
    }
}
