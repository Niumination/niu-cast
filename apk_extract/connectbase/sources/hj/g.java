package hj;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.snackbar.Snackbar;
import com.transsion.widgetslib.R;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f7202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Snackbar f7203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f7204c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Snackbar.SnackbarLayout f7205d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CoordinatorLayout f7206e;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar = g.this.f7204c;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    public interface b {
        void a();
    }

    public g(Context context, int i10) {
        this.f7202a = context;
        Activity activity = (Activity) context;
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(i10);
        View viewInflate = activity.getLayoutInflater().inflate(R.layout.os_snackbar_layout, (ViewGroup) null);
        this.f7206e = (CoordinatorLayout) viewInflate.findViewById(R.id.snackbar_coordinator);
        viewGroup.addView(viewInflate);
    }

    public final void b(int i10) {
        View viewInflate = LayoutInflater.from(this.f7202a).inflate(i10, (ViewGroup) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        this.f7205d.addView(viewInflate, 0, layoutParams);
    }

    public void c(b bVar) {
        this.f7204c = bVar;
    }

    public final void d(int i10, View view, int i11) {
        ((TextView) view.findViewById(R.id.snackbar_text)).setTextColor(i10);
        ((TextView) view.findViewById(R.id.snackbar_action)).setTextColor(i11);
    }

    public final void e(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f7203b.setAction(str, new a());
    }

    public Snackbar f(String str, String str2, int i10, int i11, int i12, int i13) {
        Snackbar snackbarMake = Snackbar.make(this.f7206e, str, i13);
        this.f7203b = snackbarMake;
        Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) snackbarMake.getView();
        this.f7205d = snackbarLayout;
        TextView textView = (TextView) snackbarLayout.findViewById(R.id.snackbar_action);
        textView.setBackgroundResource(R.drawable.os_btn_bg_no_stroke_dark);
        textView.setAllCaps(true);
        if (i10 != 0 && i11 != 0) {
            d(i10, this.f7205d, i11);
        }
        if (i12 != 0) {
            b(i12);
        }
        this.f7205d.setBackgroundResource(R.drawable.os_snackbar_background);
        this.f7203b.show();
        if (str2 != null) {
            e(str2);
        }
        return this.f7203b;
    }

    public Snackbar g(String str, int i10) {
        return h(str, null, 0, i10);
    }

    public Snackbar h(String str, String str2, int i10, int i11) {
        Snackbar snackbarMake = Snackbar.make(this.f7206e, str, i11);
        this.f7203b = snackbarMake;
        Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) snackbarMake.getView();
        this.f7205d = snackbarLayout;
        TextView textView = (TextView) snackbarLayout.findViewById(R.id.snackbar_action);
        TextView textView2 = (TextView) this.f7205d.findViewById(R.id.snackbar_text);
        textView.setBackgroundResource(R.drawable.os_btn_bg_no_stroke_dark);
        textView.setAllCaps(true);
        textView.setTextSize(14.0f);
        textView2.setLineSpacing(0.0f, 1.3f);
        textView2.setTextColor(this.f7202a.getResources().getColor(R.color.os_snackbar_text_color));
        if (i10 != 0) {
            textView.setTextColor(i10);
        } else {
            TypedArray typedArrayObtainStyledAttributes = this.f7202a.obtainStyledAttributes(new int[]{R.attr.os_platform_basic_color});
            textView.setTextColor(typedArrayObtainStyledAttributes.getColor(0, this.f7202a.getResources().getColor(R.color.os_platform_basic_color_hios)));
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f7205d.setBackgroundResource(R.drawable.os_snackbar_background);
        this.f7203b.show();
        if (str2 != null) {
            e(str2);
        }
        return this.f7203b;
    }
}
