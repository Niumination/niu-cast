package bf;

import android.content.Context;
import android.util.Log;
import android.view.WindowMetrics;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.camera.camera2.interop.CaptureRequestOptions;
import androidx.camera.core.CameraX;
import androidx.camera.core.ImageProcessor;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.processing.DefaultSurfaceProcessor;
import androidx.camera.core.processing.InternalImageProcessor;
import androidx.camera.core.processing.ShaderProvider;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.video.VideoCapture;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.window.embedding.EmbeddingAdapter;
import androidx.window.embedding.EmbeddingCompat;
import androidx.window.embedding.EmbeddingInterfaceCompat;
import androidx.window.embedding.SplitPairRule;
import androidx.window.embedding.SplitPlaceholderRule;
import androidx.window.extensions.core.util.function.Consumer;
import androidx.window.extensions.core.util.function.Predicate;
import com.transsion.iotservice.multiscreen.pc.ui.UsbEntranceActivity;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import k3.bc;
import k3.gc;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import li.l0;
import ze.c2;
import ze.d2;
import ze.y1;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class u implements d2, Predicate, Consumer, Config.OptionMatcher, CallbackToFutureAdapter.Resolver, ActivityResultCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1298c;

    public /* synthetic */ u(int i8, Object obj, Object obj2) {
        this.f1296a = i8;
        this.f1297b = obj;
        this.f1298c = obj2;
    }

    @Override // androidx.window.extensions.core.util.function.Consumer
    public void accept(Object obj) {
        EmbeddingCompat.setEmbeddingCallback$lambda$0((EmbeddingInterfaceCompat.EmbeddingCallbackInterface) this.f1297b, (EmbeddingCompat) this.f1298c, (List) obj);
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        switch (this.f1296a) {
            case 5:
                return ((CameraX) this.f1297b).lambda$initInternal$0((Context) this.f1298c, completer);
            case 6:
                return ((SurfaceRequest) this.f1297b).lambda$initialSurfaceRecreationCompleter$6((AtomicReference) this.f1298c, completer);
            case 7:
            default:
                return ((VideoCapture) this.f1297b).lambda$setupSurfaceUpdateNotifier$6((SessionConfig.Builder) this.f1298c, completer);
            case 8:
                return ((DefaultSurfaceProcessor) this.f1297b).lambda$initGlRenderer$5((ShaderProvider) this.f1298c, completer);
            case 9:
                return ((InternalImageProcessor) this.f1297b).lambda$safeProcess$1((ImageProcessor.Request) this.f1298c, completer);
            case 10:
                return ((ProcessCameraProvider) this.f1297b).lambda$getOrCreateCameraXInstance$2((CameraX) this.f1298c, completer);
        }
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, kotlin.jvm.functions.Function1] */
    @Override // ze.d2
    public ze.i e(c2 call) {
        CoroutineContext context = (CoroutineContext) this.f1297b;
        Intrinsics.checkNotNullParameter(context, "$context");
        ?? implementation = this.f1298c;
        Intrinsics.checkNotNullParameter(implementation, "$implementation");
        sj.a aVar = n.f1287a;
        aVar.getClass();
        y1 y1Var = ze.y.i().f11475b;
        Object objA = y1Var == null ? null : y1Var.a(aVar, aVar.hashCode(), 0);
        if (objA == null) {
            objA = (EmptyCoroutineContext) aVar.f10138c;
        }
        Intrinsics.checkNotNullExpressionValue(objA, "CoroutineContextServerIn…ROUTINE_CONTEXT_KEY.get()");
        CoroutineContext coroutineContextPlus = context.plus((CoroutineContext) objA);
        ze.y yVarI = ze.y.i();
        Intrinsics.checkNotNullExpressionValue(yVarI, "current()");
        CoroutineContext coroutineContextPlus2 = coroutineContextPlus.plus(new p(yVarI));
        Intrinsics.checkNotNullExpressionValue(call, "call");
        t tVar = new t(new w(call));
        ni.m mVarA = bc.a(1, 6, null);
        return new v(l0.p(li.h0.a(coroutineContextPlus2), null, null, new a0(implementation, new oi.b0(new x(new AtomicBoolean(false), call, mVarA, null)), tVar, call, null), 3), mVarA, call, tVar);
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public void onActivityResult(Object obj) {
        ActivityResult it = (ActivityResult) obj;
        int i8 = UsbEntranceActivity.f2702a;
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.getResultCode() != 10) {
            ((UsbEntranceActivity) this.f1298c).finish();
            return;
        }
        Intrinsics.checkNotNullParameter("UsbEntranceActivity", "tag");
        Intrinsics.checkNotNullParameter("mPermissionDialogLauncher:granted", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("UsbEntranceActivity"), "mPermissionDialogLauncher:granted");
        }
        ((ag.a) this.f1297b).invoke();
    }

    @Override // androidx.camera.core.impl.Config.OptionMatcher
    public boolean onOptionMatched(Config.Option option) {
        return CaptureRequestOptions.Builder.lambda$from$0((CaptureRequestOptions.Builder) this.f1297b, (Config) this.f1298c, option);
    }

    @Override // androidx.window.extensions.core.util.function.Predicate
    public boolean test(Object obj) {
        switch (this.f1296a) {
            case 1:
                return EmbeddingAdapter.translateSplitPlaceholderRule$lambda$11((SplitPlaceholderRule) this.f1297b, (Context) this.f1298c, (WindowMetrics) obj);
            default:
                return EmbeddingAdapter.translateSplitPairRule$lambda$6((SplitPairRule) this.f1297b, (Context) this.f1298c, (WindowMetrics) obj);
        }
    }
}
