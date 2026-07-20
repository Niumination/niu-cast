package c6;

import com.tencent.qgame.animplayer.AnimView;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Lambda f1439b;

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ c(int i8, Function0 function0) {
        this.f1438a = i8;
        this.f1439b = (Lambda) function0;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.jvm.functions.Function0, kotlin.jvm.internal.Lambda] */
    @Override // java.lang.Runnable
    public final void run() {
        ?? callback = this.f1439b;
        switch (this.f1438a) {
            case 0:
                Intrinsics.checkNotNullParameter(callback, "$callback");
                callback.invoke();
                break;
            default:
                int i8 = AnimView.p;
                Intrinsics.checkNotNullParameter(callback, "$f");
                callback.invoke();
                break;
        }
    }
}
