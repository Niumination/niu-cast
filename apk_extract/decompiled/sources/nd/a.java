package nd;

import android.view.View;
import com.transsion.widgetslib.flipper.FlipperLayout;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f8169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f8170c;

    public /* synthetic */ a(int i8, int i9, Object obj) {
        this.f8168a = i9;
        this.f8170c = obj;
        this.f8169b = i8;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f8168a) {
            case 0:
                Function1 oic = (Function1) this.f8170c;
                Intrinsics.checkNotNullParameter(oic, "$oic");
                oic.invoke(Integer.valueOf(this.f8169b));
                break;
            default:
                FlipperLayout this_inflateLayoutDot = (FlipperLayout) this.f8170c;
                Intrinsics.checkNotNullParameter(this_inflateLayoutDot, "$this_inflateLayoutDot");
                l.a(this_inflateLayoutDot.getViewPager(), this.f8169b, true);
                break;
        }
    }
}
