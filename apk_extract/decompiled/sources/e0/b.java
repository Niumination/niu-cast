package e0;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.camera.core.processing.DefaultSurfaceProcessor;
import androidx.camera.video.internal.encoder.Encoder;
import androidx.camera.video.internal.encoder.EncoderConfig;
import androidx.camera.video.internal.encoder.EncoderFactory;
import androidx.camera.video.internal.encoder.EncoderImpl;
import androidx.constraintlayout.core.state.Interpolator;
import androidx.constraintlayout.core.state.Transition;
import androidx.core.util.Supplier;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.carousel.MaskableFrameLayout;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.textfield.TextInputLayout;
import com.transsion.athena.data.TrackData;
import com.transsion.message.cast.ChatActivity;
import e8.d;
import e8.g;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import k3.gc;
import kotlin.jvm.internal.Intrinsics;
import s6.c;
import u6.e;
import x4.t;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Interpolator, TextInputLayout.LengthCounter, Supplier, ShapeAppearanceModel.CornerSizeUnaryOperator, OnApplyWindowInsetsListener, EncoderFactory, t, e, ActivityResultCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4659a;

    public /* synthetic */ b(int i8) {
        this.f4659a = i8;
    }

    @Override // com.google.android.material.shape.ShapeAppearanceModel.CornerSizeUnaryOperator
    public CornerSize apply(CornerSize cornerSize) {
        return MaskableFrameLayout.lambda$setShapeAppearanceModel$0(cornerSize);
    }

    @Override // x4.t
    public Object construct() {
        switch (this.f4659a) {
            case 12:
                return x4.b.lambda$newMapConstructor$14();
            case 13:
                return x4.b.lambda$newMapConstructor$15();
            case 14:
                return x4.b.lambda$newMapConstructor$16();
            case 15:
                return x4.b.lambda$newMapConstructor$17();
            case 16:
                return x4.b.lambda$newMapConstructor$18();
            case 17:
                return x4.b.lambda$newCollectionConstructor$10();
            case 18:
                return x4.b.lambda$newCollectionConstructor$11();
            case 19:
                return x4.b.lambda$newCollectionConstructor$12();
            default:
                return x4.b.lambda$newCollectionConstructor$13();
        }
    }

    @Override // com.google.android.material.textfield.TextInputLayout.LengthCounter
    public int countLength(Editable editable) {
        return TextInputLayout.lambda$new$0(editable);
    }

    @Override // androidx.camera.video.internal.encoder.EncoderFactory
    public Encoder createEncoder(Executor executor, EncoderConfig encoderConfig) {
        return new EncoderImpl(executor, encoderConfig);
    }

    @Override // u6.e
    public void e(Object obj) {
        switch (this.f4659a) {
            case 21:
                SparseArray sparseArray = (SparseArray) obj;
                ArrayList arrayList = new ArrayList(sparseArray.size());
                for (int i8 = 0; i8 < sparseArray.size(); i8++) {
                    arrayList.add((c) sparseArray.valueAt(i8));
                }
                CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) ((i1.b) m6.a.f().f7948a.f8123c).f5528b;
                copyOnWriteArrayList.clear();
                copyOnWriteArrayList.addAll(arrayList);
                break;
            case 22:
                Bundle bundle = new Bundle();
                bundle.putString("v", (String) obj);
                g.f4735b.a(new d("cleanupEvents_oom", bundle));
                break;
            case 23:
                String str = (String) obj;
                Bundle bundle2 = new Bundle();
                bundle2.putString("v", str);
                g.f4735b.a(new d("cleanupEvents_off", bundle2));
                z6.a.f("handleTidChange cleanupList : %s", str);
                break;
            default:
                SparseArray sparseArray2 = (SparseArray) obj;
                for (int i9 = 0; i9 < sparseArray2.size(); i9++) {
                    t6.e eVar = (t6.e) sparseArray2.valueAt(i9);
                    Bundle bundle3 = new Bundle();
                    bundle3.putInt("appid", eVar.f10186a);
                    bundle3.putString("date", eVar.f10187b);
                    bundle3.putInt("count", eVar.f10188c);
                    bundle3.putInt("packet", eVar.f10189d);
                    a7.a aVar = new a7.a("day_up_record", 9999);
                    ((TrackData) aVar.f42c).d(0, "eparam", bundle3);
                    aVar.a();
                    int i10 = t6.d.f10184a;
                    if (i10 > 0) {
                        a7.a aVar2 = new a7.a("day_up_record", i10);
                        ((TrackData) aVar2.f42c).d(0, "eparam", bundle3);
                        aVar2.a();
                    }
                }
                break;
        }
    }

    @Override // androidx.core.util.Supplier
    public Object get() {
        return new DefaultSurfaceProcessor();
    }

    @Override // androidx.constraintlayout.core.state.Interpolator
    public float getInterpolation(float f) {
        switch (this.f4659a) {
            case 0:
                return Transition.lambda$getInterpolator$1(f);
            case 1:
                return Transition.lambda$getInterpolator$2(f);
            case 2:
                return Transition.lambda$getInterpolator$3(f);
            case 3:
                return Transition.lambda$getInterpolator$4(f);
            case 4:
                return Transition.lambda$getInterpolator$5(f);
            case 5:
                return Transition.lambda$getInterpolator$6(f);
            default:
                return Transition.lambda$getInterpolator$7(f);
        }
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public void onActivityResult(Object obj) {
        ActivityResult it = (ActivityResult) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        String strO = o.d.o("permissionDialogLauncher result: ", it.getResultCode() == 10, "BaseSearchFragment", "tag", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("BaseSearchFragment"), strO);
        }
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return ChatActivity.onCreate$lambda$0(view, windowInsetsCompat);
    }
}
