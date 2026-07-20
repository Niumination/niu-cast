package ej;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.widgetslib.R;
import rb.s;

/* JADX INFO: loaded from: classes2.dex */
public class h extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f4439a;

    public static class a extends b {
        public a(Context context, int i10) {
            this(context, 0, i10);
        }

        public a(Context context, int i10, int i11) {
            super(context, i10);
            if (i11 != 3) {
                g(false);
                h(false);
            }
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public h f4440a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final i f4441b;

        public b(Context context) {
            this(context, 0);
        }

        public b A(int i10) {
            this.f4441b.M = i10;
            return this;
        }

        public b B(DialogInterface.OnCancelListener onCancelListener) {
            this.f4441b.f4462o = onCancelListener;
            return this;
        }

        public b C(DialogInterface.OnDismissListener onDismissListener) {
            this.f4441b.f4463p = onDismissListener;
            return this;
        }

        public b D(AdapterView.OnItemSelectedListener onItemSelectedListener) {
            this.f4441b.F = onItemSelectedListener;
            return this;
        }

        public b E(DialogInterface.OnKeyListener onKeyListener) {
            this.f4441b.f4464q = onKeyListener;
            return this;
        }

        public b F(int i10, DialogInterface.OnClickListener onClickListener) {
            i iVar = this.f4441b;
            iVar.f4453f = iVar.f4448a.getText(i10);
            this.f4441b.f4454g = onClickListener;
            return this;
        }

        public b G(int i10, boolean z10, DialogInterface.OnClickListener onClickListener) {
            i iVar = this.f4441b;
            iVar.f4453f = iVar.f4448a.getText(i10);
            i iVar2 = this.f4441b;
            iVar2.f4454g = onClickListener;
            iVar2.H = z10;
            return this;
        }

        public b H(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            i iVar = this.f4441b;
            iVar.f4453f = charSequence;
            iVar.f4454g = onClickListener;
            return this;
        }

        public b I(CharSequence charSequence, boolean z10, DialogInterface.OnClickListener onClickListener) {
            i iVar = this.f4441b;
            iVar.f4453f = charSequence;
            iVar.f4454g = onClickListener;
            iVar.H = z10;
            return this;
        }

        public b J(CharSequence charSequence, boolean z10, DialogInterface.OnClickListener onClickListener) {
            i iVar = this.f4441b;
            iVar.O = charSequence;
            iVar.f4470w = onClickListener;
            iVar.P = z10;
            return this;
        }

        public b K(int i10, int i11, DialogInterface.OnClickListener onClickListener) {
            i iVar = this.f4441b;
            iVar.f4467t = iVar.f4448a.getResources().getTextArray(i10);
            i iVar2 = this.f4441b;
            iVar2.B = i11;
            iVar2.f4470w = onClickListener;
            iVar2.f4472y = true;
            return this;
        }

        public b L(Cursor cursor, int i10, String str, DialogInterface.OnClickListener onClickListener) {
            i iVar = this.f4441b;
            iVar.C = cursor;
            iVar.B = i10;
            iVar.D = str;
            iVar.f4470w = onClickListener;
            iVar.f4472y = true;
            return this;
        }

        public b M(ListAdapter listAdapter, int i10, DialogInterface.OnClickListener onClickListener) {
            i iVar = this.f4441b;
            iVar.f4469v = listAdapter;
            iVar.B = i10;
            iVar.f4470w = onClickListener;
            iVar.f4472y = true;
            return this;
        }

        public b N(RecyclerView.Adapter<?> adapter, int i10, DialogInterface.OnClickListener onClickListener) {
            i iVar = this.f4441b;
            iVar.f4468u = adapter;
            iVar.B = i10;
            iVar.f4470w = onClickListener;
            iVar.f4472y = true;
            return this;
        }

        public b O(CharSequence[] charSequenceArr, int i10, DialogInterface.OnClickListener onClickListener) {
            i iVar = this.f4441b;
            iVar.f4467t = charSequenceArr;
            iVar.B = i10;
            iVar.f4470w = onClickListener;
            iVar.f4472y = true;
            return this;
        }

        public b P(int i10) {
            i iVar = this.f4441b;
            iVar.f4449b = iVar.f4448a.getText(i10);
            return this;
        }

        public b Q(CharSequence charSequence) {
            this.f4441b.f4449b = charSequence;
            return this;
        }

        public b R(int i10) {
            i iVar = this.f4441b;
            iVar.f4450c = iVar.f4448a.getText(i10);
            return this;
        }

        public b S(CharSequence charSequence) {
            this.f4441b.f4450c = charSequence;
            return this;
        }

        public b T(int i10) {
            i iVar = this.f4441b;
            iVar.f4466s = null;
            iVar.f4465r = i10;
            return this;
        }

        public b U(View view) {
            i iVar = this.f4441b;
            iVar.f4466s = view;
            iVar.f4465r = 0;
            return this;
        }

        public h V() {
            h hVarA = a();
            hVarA.show();
            return hVarA;
        }

        public h a() {
            this.f4441b.a(this.f4440a.f4439a);
            this.f4440a.setCancelable(this.f4441b.f4460m);
            this.f4440a.setCanceledOnTouchOutside(this.f4441b.f4461n);
            i iVar = this.f4441b;
            if (!iVar.L) {
                this.f4440a.setOnCancelListener(iVar.f4462o);
                this.f4440a.setOnDismissListener(this.f4441b.f4463p);
            }
            DialogInterface.OnKeyListener onKeyListener = this.f4441b.f4464q;
            if (onKeyListener != null) {
                this.f4440a.setOnKeyListener(onKeyListener);
            }
            if (hj.h.B(this.f4441b.f4448a) && (!hj.h.F(this.f4441b.f4448a) || hj.h.x(this.f4441b.f4448a))) {
                Drawable drawable = ContextCompat.getDrawable(this.f4441b.f4448a, R.drawable.os_dialog_background_fold);
                this.f4440a.getWindow().setGravity(17);
                this.f4440a.getWindow().setWindowAnimations(R.style.OS_Animation_Fold_Dialog);
                this.f4440a.getWindow().setBackgroundDrawable(drawable);
                if (hj.h.D(this.f4441b.f4448a) && hj.h.G()) {
                    this.f4440a.getWindow().setTitle(this.f4441b.f4448a.getString(R.string.os_string_fold_dialog_title_verify));
                    this.f4440a.getWindow().getAttributes().setTitle(this.f4441b.f4448a.getString(R.string.os_string_fold_dialog_title_verify));
                    this.f4440a.getWindow().setType(s.f14432g);
                }
                i iVar2 = this.f4441b;
                hj.h.N(iVar2.f4448a, this.f4440a, iVar2.f4460m, iVar2.f4461n);
            } else if (this.f4440a.f4439a.D()) {
                hj.h.U(this.f4441b.f4448a, this.f4440a.getWindow());
            } else {
                i iVar3 = this.f4441b;
                hj.h.T(iVar3.f4448a, this.f4440a, iVar3.f4460m, iVar3.f4461n);
            }
            return this.f4440a;
        }

        public Context b() {
            return this.f4441b.f4448a;
        }

        public b c(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            i iVar = this.f4441b;
            iVar.f4469v = listAdapter;
            iVar.f4470w = onClickListener;
            return this;
        }

        public b d(RecyclerView.Adapter<?> adapter, DialogInterface.OnClickListener onClickListener) {
            i iVar = this.f4441b;
            iVar.f4468u = adapter;
            iVar.f4470w = onClickListener;
            return this;
        }

        public b e(boolean z10) {
            this.f4441b.I = z10;
            return this;
        }

        public b f(boolean z10) {
            this.f4441b.J = z10;
            return this;
        }

        public b g(boolean z10) {
            this.f4441b.f4460m = z10;
            return this;
        }

        public b h(boolean z10) {
            this.f4441b.f4461n = z10;
            return this;
        }

        public b i(Cursor cursor, DialogInterface.OnClickListener onClickListener, String str) {
            i iVar = this.f4441b;
            iVar.C = cursor;
            iVar.D = str;
            iVar.f4470w = onClickListener;
            return this;
        }

        public b j(boolean z10) {
            this.f4441b.N = z10;
            return this;
        }

        public b k(int i10) {
            i iVar = this.f4441b;
            iVar.f4451d = ContextCompat.getDrawable(iVar.f4448a, i10);
            return this;
        }

        public b l(Drawable drawable) {
            this.f4441b.f4451d = drawable;
            return this;
        }

        public b m(boolean z10) {
            this.f4441b.f4455h = z10;
            return this;
        }

        public void n(boolean z10) {
            this.f4441b.K = z10;
        }

        public b o(boolean z10) {
            this.f4441b.L = z10;
            return this;
        }

        public b p(int i10, DialogInterface.OnClickListener onClickListener) {
            i iVar = this.f4441b;
            iVar.f4467t = iVar.f4448a.getResources().getTextArray(i10);
            this.f4441b.f4470w = onClickListener;
            return this;
        }

        public b q(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
            i iVar = this.f4441b;
            iVar.f4467t = charSequenceArr;
            iVar.f4470w = onClickListener;
            return this;
        }

        public b r(int i10) {
            i iVar = this.f4441b;
            iVar.f4452e = iVar.f4448a.getText(i10);
            return this;
        }

        public b s(CharSequence charSequence) {
            this.f4441b.f4452e = charSequence;
            return this;
        }

        public b t(int i10, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            i iVar = this.f4441b;
            iVar.f4467t = iVar.f4448a.getResources().getTextArray(i10);
            i iVar2 = this.f4441b;
            iVar2.f4473z = zArr;
            iVar2.A = onMultiChoiceClickListener;
            iVar2.f4471x = true;
            return this;
        }

        public b u(Cursor cursor, String str, String str2, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            i iVar = this.f4441b;
            iVar.C = cursor;
            iVar.E = str;
            iVar.D = str2;
            iVar.A = onMultiChoiceClickListener;
            iVar.f4471x = true;
            return this;
        }

        public b v(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            i iVar = this.f4441b;
            iVar.f4467t = charSequenceArr;
            iVar.f4473z = zArr;
            iVar.A = onMultiChoiceClickListener;
            iVar.f4471x = true;
            return this;
        }

        public b w(int i10, DialogInterface.OnClickListener onClickListener) {
            i iVar = this.f4441b;
            iVar.f4456i = iVar.f4448a.getText(i10);
            this.f4441b.f4457j = onClickListener;
            return this;
        }

        public b x(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            i iVar = this.f4441b;
            iVar.f4456i = charSequence;
            iVar.f4457j = onClickListener;
            return this;
        }

        public b y(int i10, DialogInterface.OnClickListener onClickListener) {
            i iVar = this.f4441b;
            iVar.f4458k = iVar.f4448a.getText(i10);
            this.f4441b.f4459l = onClickListener;
            return this;
        }

        public b z(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            i iVar = this.f4441b;
            iVar.f4458k = charSequence;
            iVar.f4459l = onClickListener;
            return this;
        }

        public b(Context context, int i10) {
            i iVar = new i(new ContextThemeWrapper(context, h.e(context, i10)));
            this.f4441b = iVar;
            this.f4440a = new h(iVar.f4448a, h.e(context, i10));
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f4442a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f4443b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f4444c = 2;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f4445d = 3;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f4446e = 4;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f4447f = 5;
    }

    public h(Context context) {
        this(context, 0);
    }

    public static int e(Context context, int i10) {
        return i10 >= 16777216 ? i10 : R.style.OS_Dialog_Alert_Base;
    }

    public Button c(int i10) {
        return this.f4439a.t(i10);
    }

    public View d() {
        return this.f4439a.f4400l;
    }

    public void f(int i10, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.f4439a.I(i10, charSequence, onClickListener, null);
    }

    public void g(int i10, CharSequence charSequence, Message message) {
        this.f4439a.I(i10, charSequence, null, message);
    }

    public void h(CharSequence charSequence) {
        this.f4439a.W(charSequence);
    }

    public void i() {
        this.f4439a.j0();
    }

    public void j(int i10) {
        this.f4439a.l0(getContext().getResources().getString(i10));
    }

    public void k(CharSequence charSequence) {
        this.f4439a.l0(charSequence);
    }

    public void l(View view) {
        this.f4439a.m0(0, view);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f4439a.E();
        if (hj.h.B(getContext())) {
            if (!hj.h.F(getContext()) || hj.h.x(getContext())) {
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                attributes.width = ui.a.d(getContext(), 360);
                getWindow().setAttributes(attributes);
            }
        }
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        this.f4439a.i0(charSequence);
    }

    public h(Context context, int i10) {
        super(context, e(context, i10));
        this.f4439a = new g(getContext(), this, getWindow());
    }

    public h(Context context, boolean z10, DialogInterface.OnCancelListener onCancelListener) {
        this(context, 0);
        setCancelable(z10);
        if (this.f4439a.I) {
            return;
        }
        setOnCancelListener(onCancelListener);
    }
}
