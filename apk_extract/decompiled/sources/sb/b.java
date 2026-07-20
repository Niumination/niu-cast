package sb;

import android.os.Handler;
import androidx.lifecycle.MediatorLiveData;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.CastControlDialog;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f9601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Handler f9602b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MediatorLiveData f9603c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f9604d;
    public final /* synthetic */ Ref.BooleanRef e;

    public /* synthetic */ b(Ref.ObjectRef objectRef, Handler handler, MediatorLiveData mediatorLiveData, Ref.BooleanRef booleanRef, Ref.BooleanRef booleanRef2) {
        this.f9601a = objectRef;
        this.f9602b = handler;
        this.f9603c = mediatorLiveData;
        this.f9604d = booleanRef;
        this.e = booleanRef2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [T, a0.g, java.lang.Object, java.lang.Runnable] */
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        int i8 = CastControlDialog.f2710n;
        Ref.ObjectRef objectRef = this.f9601a;
        Runnable runnable = (Runnable) objectRef.element;
        Handler handler = this.f9602b;
        if (runnable != null) {
            handler.removeCallbacks(runnable);
        }
        ?? gVar = new a0.g(this.f9603c, 4, this.f9604d, this.e);
        objectRef.element = gVar;
        Intrinsics.checkNotNull(gVar);
        return Boolean.valueOf(handler.postDelayed(gVar, 100L));
    }
}
