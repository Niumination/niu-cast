package ve;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f10551a = 0;

    static {
        Intrinsics.checkNotNullExpressionValue(UUID.fromString("0000FD35-0000-1000-8000-00805f9b34fb"), "fromString(...)");
        new ArrayBlockingQueue(1000);
        new ArrayList();
    }
}
