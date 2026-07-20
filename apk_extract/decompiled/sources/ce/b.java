package ce;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.transsion.widgetslib.R$dimen;
import com.transsion.widgetslib.widget.editext.OSMaterialEditText;
import md.f;
import pd.j;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OSMaterialEditText f1462b;

    public /* synthetic */ b(OSMaterialEditText oSMaterialEditText, int i8) {
        this.f1461a = i8;
        this.f1462b = oSMaterialEditText;
    }

    @Override // java.lang.Runnable
    public final void run() {
        OSMaterialEditText oSMaterialEditText = this.f1462b;
        switch (this.f1461a) {
            case 0:
                int i8 = OSMaterialEditText.j0;
                Context context = oSMaterialEditText.getContext();
                String[] strArr = j.f8764a;
                int iA = hd.a.a(context, 1);
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setStyle(Paint.Style.STROKE);
                float f = iA;
                paint.setStrokeWidth(f);
                paint.setColor(oSMaterialEditText.U);
                int measuredHeight = oSMaterialEditText.K.getMeasuredHeight() - iA;
                f fVar = oSMaterialEditText.g0;
                Context context2 = oSMaterialEditText.f3494a;
                if (fVar == null) {
                    if (oSMaterialEditText.f0) {
                        oSMaterialEditText.g0 = new f(context2, new RectF(f, f, oSMaterialEditText.f3498c - iA, measuredHeight), context2.getResources().getDimension(R$dimen.os_radius_xs), paint);
                    } else {
                        oSMaterialEditText.g0 = new f(context2, new RectF(f, f, oSMaterialEditText.f3498c - iA, measuredHeight), context2.getResources().getDimension(R$dimen.os_radius_m), paint);
                    }
                }
                if (oSMaterialEditText.O == 0 && oSMaterialEditText.P == 0) {
                    int measuredWidth = oSMaterialEditText.I.getMeasuredWidth();
                    int i9 = oSMaterialEditText.N;
                    int i10 = measuredWidth + i9;
                    int measuredWidth2 = oSMaterialEditText.J.getMeasuredWidth() + i9;
                    ImageView imageView = oSMaterialEditText.f3501h;
                    int iA2 = (imageView == null || imageView.getVisibility() == 8) ? 0 : (-oSMaterialEditText.f3501h.getMeasuredWidth()) - hd.a.a(context2, 10);
                    oSMaterialEditText.O = i10;
                    oSMaterialEditText.P = measuredWidth2 + iA2;
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) oSMaterialEditText.M.getLayoutParams();
                    marginLayoutParams.setMargins(oSMaterialEditText.O, 0, oSMaterialEditText.P, 0);
                    oSMaterialEditText.M.setLayoutParams(marginLayoutParams);
                    break;
                }
                break;
            default:
                oSMaterialEditText.c();
                break;
        }
    }
}
