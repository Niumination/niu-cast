package ej;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.transsion.widgetslib.R;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f4378k = "ProgressDialog";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f4379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h.b f4380b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f4381c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f4382d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f4383e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ProgressBar f4384f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LinearLayout f4385g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f4386h = 100;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f4387i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f4388j = false;

    public f(Context context) {
        this.f4379a = context;
        this.f4380b = new h.b(context, 0);
        e(false);
        d(false);
        this.f4380b.A(hj.b.a(16, this.f4379a));
        if (this.f4381c == null) {
            c();
        }
    }

    public h a() {
        if (this.f4387i) {
            this.f4382d.setVisibility(0);
        }
        h hVarA = this.f4380b.a();
        hVarA.getWindow().setSoftInputMode(0);
        return hVarA;
    }

    public final void b() {
        if (this.f4383e.getVisibility() == 0 && this.f4388j) {
            this.f4385g.setPadding(0, (int) this.f4379a.getResources().getDimension(R.dimen.os_progress_intro_padding_top), 0, 0);
        }
    }

    public final void c() {
        View viewInflate = LayoutInflater.from(this.f4379a).inflate(R.layout.os_dialog_progress, (ViewGroup) null);
        this.f4381c = viewInflate;
        this.f4384f = (ProgressBar) viewInflate.findViewById(R.id.dialog_progress_bar);
        this.f4382d = (TextView) this.f4381c.findViewById(R.id.dialog_progress_tv);
        this.f4383e = (TextView) this.f4381c.findViewById(R.id.text_progress_message);
        this.f4385g = (LinearLayout) this.f4381c.findViewById(R.id.ll_intro);
        if (this.f4387i) {
            this.f4382d.setVisibility(0);
        }
        this.f4380b.U(this.f4381c);
    }

    public f d(boolean z10) {
        this.f4380b.g(z10);
        return this;
    }

    public f e(boolean z10) {
        this.f4380b.h(z10);
        return this;
    }

    public f f(int i10) {
        this.f4380b.k(i10);
        this.f4388j = true;
        b();
        return this;
    }

    public f g(Drawable drawable) {
        this.f4380b.l(drawable);
        this.f4388j = true;
        b();
        return this;
    }

    public f h(int i10) {
        this.f4386h = i10;
        this.f4384f.setMax(i10);
        return this;
    }

    public f i(int i10) {
        this.f4380b.r(i10);
        return this;
    }

    public f j(CharSequence charSequence) {
        this.f4380b.s(charSequence);
        return this;
    }

    public f k(int i10, DialogInterface.OnClickListener onClickListener) {
        return l(this.f4379a.getText(i10), onClickListener);
    }

    public f l(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.f4380b.x(charSequence, onClickListener);
        return this;
    }

    public f m(boolean z10) {
        this.f4387i = z10;
        return this;
    }

    public f n(int i10, DialogInterface.OnClickListener onClickListener) {
        return o(this.f4379a.getText(i10), onClickListener);
    }

    public f o(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.f4380b.H(charSequence, onClickListener);
        return this;
    }

    public f p(int i10) {
        if (this.f4381c == null) {
            c();
        }
        this.f4384f.setProgress(Math.min(i10, this.f4386h));
        String language = this.f4379a.getResources().getConfiguration().locale.getLanguage();
        int iFloor = (int) Math.floor((Math.min(i10, this.f4386h) / this.f4386h) * 100.0f);
        if ("tr".equals(language) || "ar".equals(language) || hj.h.J()) {
            this.f4382d.setLayoutDirection(0);
            this.f4382d.setText(String.format(Locale.getDefault(), "%%%d", Integer.valueOf(iFloor)));
        } else {
            this.f4382d.setText(String.format(Locale.getDefault(), "%d%%", Integer.valueOf(iFloor)));
        }
        return this;
    }

    public f q(int i10) {
        TextView textView = this.f4383e;
        if (textView != null) {
            textView.setVisibility(0);
            this.f4383e.setText(this.f4379a.getText(i10));
        }
        b();
        return this;
    }

    public f r(CharSequence charSequence) {
        TextView textView = this.f4383e;
        if (textView != null) {
            textView.setVisibility(0);
            this.f4383e.setText(charSequence);
        }
        b();
        return this;
    }

    public f s(int i10) {
        if (this.f4381c == null) {
            c();
        }
        this.f4384f.setSecondaryProgress(Math.min(i10, this.f4386h));
        return this;
    }

    public f t(int i10) {
        this.f4380b.P(i10);
        this.f4388j = true;
        b();
        return this;
    }

    public f u(CharSequence charSequence) {
        this.f4380b.Q(charSequence);
        this.f4388j = true;
        b();
        return this;
    }

    public h v() {
        h hVarA = a();
        hVarA.show();
        return hVarA;
    }
}
