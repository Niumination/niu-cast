package dc;

import android.app.Activity;
import android.content.DialogInterface;
import com.transsion.iotservice.multiscreen.pc.R$string;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ld.m f4427a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v3, types: [T, android.app.Dialog, ld.m] */
    public static ld.m a(Activity activity, String str, String[] strArr, final int i8, final Function1 function1, Function0 function0, boolean z2, int i9) {
        if ((i9 & 512) != 0) {
            z2 = false;
        }
        final boolean z3 = z2;
        if (activity.isFinishing() || activity.isDestroyed()) {
            return null;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ld.k kVar = new ld.k(activity);
        ld.n nVar = kVar.f7400b;
        nVar.f7403b = str;
        final boolean z5 = true;
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: dc.k
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                ld.m mVar;
                if (z5 && i10 == i8) {
                    return;
                }
                function1.invoke(Integer.valueOf(i10));
                if (!z3 || (mVar = (ld.m) objectRef.element) == null) {
                    return;
                }
                mVar.dismiss();
            }
        };
        nVar.f7414o = strArr;
        nVar.u = i8;
        nVar.p = onClickListener;
        nVar.f7415r = true;
        kVar.b(activity.getString(R$string.permission_cancel), new bc.c(1));
        nVar.f7409j = true;
        nVar.f7410k = true;
        ?? E = kVar.e();
        objectRef.element = E;
        E.setOnDismissListener(new l(function0, 0));
        return (ld.m) objectRef.element;
    }
}
