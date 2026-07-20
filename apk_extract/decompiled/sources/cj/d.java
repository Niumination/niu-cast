package cj;

import android.util.Log;
import android.view.View;
import android.view.animation.AnimationSet;
import androidx.activity.result.ActivityResultLauncher;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.iotservice.multiscreen.pc.ui.BlankActivity;
import java.util.ArrayList;
import k3.gc;
import k3.o1;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import zf.r0;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class d implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1705c;

    public /* synthetic */ d(int i8, Object obj, Object obj2) {
        this.f1703a = i8;
        this.f1705c = obj;
        this.f1704b = obj2;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Object obj = this.f1704b;
        Object obj2 = this.f1705c;
        switch (this.f1703a) {
            case 0:
                e eVar = (e) obj2;
                eVar.getClass();
                Enum[] enumArr = eVar.f1706a;
                c cVar = new c((String) obj, enumArr.length);
                for (Enum r7 : enumArr) {
                    cVar.f(r7.name(), false);
                }
                return cVar;
            case 1:
                ((nf.e) obj2).f8210h.remove((String) obj);
                return Unit.INSTANCE;
            case 2:
                Runnable runnable = BlankActivity.f2696b;
                Intrinsics.checkNotNullParameter("BlankActivity", "tag");
                Intrinsics.checkNotNullParameter("Permission not granted", "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("BlankActivity"), "Permission not granted");
                }
                ArrayList arrayList = BlankActivity.f2697c;
                if (arrayList == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNotGrantPermissions");
                    arrayList = null;
                }
                o1.b((BlankActivity) obj2, arrayList, (ActivityResultLauncher) obj, null, "BlankActivity");
                return Unit.INSTANCE;
            case 3:
                RecyclerView recyclerView = (RecyclerView) obj2;
                recyclerView.startAnimation((AnimationSet) obj);
                recyclerView.setVisibility(0);
                return Unit.INSTANCE;
            case 4:
                View view = (View) obj2;
                view.startAnimation((AnimationSet) obj);
                view.setVisibility(0);
                return Unit.INSTANCE;
            default:
                if (((ArrayList) obj2).isEmpty()) {
                    return "";
                }
                r0 r0Var = (r0) obj;
                int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) r0Var.f, '/', r0Var.f11544j.f11526a.length() + 3, false, 4, (Object) null);
                if (iIndexOf$default == -1) {
                    return "";
                }
                String str = r0Var.f;
                int iIndexOfAny$default = StringsKt__StringsKt.indexOfAny$default((CharSequence) str, new char[]{'?', '#'}, iIndexOf$default, false, 4, (Object) null);
                if (iIndexOfAny$default == -1) {
                    String strSubstring = str.substring(iIndexOf$default);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    return strSubstring;
                }
                String strSubstring2 = str.substring(iIndexOf$default, iIndexOfAny$default);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                return strSubstring2;
        }
    }
}
