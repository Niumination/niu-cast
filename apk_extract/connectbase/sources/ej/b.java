package ej;

import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import com.google.android.material.timepicker.TimeModel;
import com.transsion.connectx.sdk.TCCPSourceApi;
import com.transsion.widgetslib.R;
import com.transsion.widgetslib.widget.editext.ExtendedEditText;
import com.transsion.widgetslib.widget.editext.OSMaterialEditText;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class b implements View.OnFocusChangeListener {
    public boolean H = true;
    public String I;
    public OSMaterialEditText J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f4325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ej.h.b f4326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ExtendedEditText f4327c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f4328d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public DialogInterface.OnDismissListener f4329e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f4330f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f4331g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f4332i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f4333n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f4334p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f4335v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f4336w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f4337x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f4338y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f4339z;

    public class a implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f4340a;

        public a(i iVar) {
            this.f4340a = iVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            i iVar = this.f4340a;
            if (iVar != null) {
                iVar.a(b.this.f4327c.getText().toString());
            }
        }
    }

    /* JADX INFO: renamed from: ej.b$b, reason: collision with other inner class name */
    public class RunnableC0101b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CharSequence f4342a;

        public RunnableC0101b(CharSequence charSequence) {
            this.f4342a = charSequence;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f4327c.setHint(TextUtils.ellipsize(this.f4342a, b.this.f4327c.getPaint(), (b.this.f4327c.getWidth() - b.this.f4327c.getPaddingStart()) - b.this.f4327c.getPaddingEnd(), TextUtils.TruncateAt.END).toString());
        }
    }

    public class c implements ViewTreeObserver.OnGlobalLayoutListener {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ((InputMethodManager) b.this.f4325a.getSystemService(TCCPSourceApi.KEY_FEATURE_INPUT_METHOD)).showSoftInput(b.this.f4327c, 0);
            }
        }

        public c() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            b bVar = b.this;
            if (bVar.f4330f) {
                return;
            }
            bVar.f4330f = true;
            bVar.f4327c.requestFocus();
            b.this.f4327c.postDelayed(new a(), 200L);
        }
    }

    public class d implements DialogInterface.OnDismissListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            b.this.l(dialogInterface);
        }
    }

    public static class e implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<b> f4347a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f4348b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f4349c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f4350d;

        public e(b bVar, int i10) {
            if (bVar != null) {
                this.f4347a = new WeakReference<>(bVar);
                this.f4348b = i10;
                this.f4350d = bVar.f4336w;
                this.f4349c = bVar.f4337x;
            }
        }

        @Override // android.text.TextWatcher
        @b.a({"DefaultLocale"})
        public void afterTextChanged(Editable editable) {
            b bVar = this.f4347a.get();
            if (bVar == null) {
                return;
            }
            if (bVar.m(-1) != null && bVar.n()) {
                bVar.m(-1).setEnabled(editable.toString().length() > 0);
            }
            TextView textView = bVar.f4332i;
            if (textView != null && textView.getVisibility() == 0) {
                int length = editable.length();
                int i10 = this.f4348b;
                if (length < i10) {
                    TextView textView2 = bVar.f4332i;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(length)));
                    sb2.append("/");
                    sb2.append(String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(this.f4348b)));
                    textView2.setText(sb2);
                } else if (length == i10 && length != 0) {
                    TextView textView3 = bVar.f4332i;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(this.f4348b)));
                    sb3.append("/");
                    sb3.append(String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(this.f4348b)));
                    textView3.setText(sb3);
                }
            }
            TextView textView4 = bVar.f4331g;
            if (textView4 == null || textView4.getVisibility() != 0) {
                return;
            }
            bVar.x("");
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    public static class f extends InputFilter.LengthFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<b> f4351a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f4352b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Toast f4353c;

        public f(b bVar, int i10) {
            super(i10);
            if (bVar != null) {
                this.f4351a = new WeakReference<>(bVar);
                this.f4352b = i10;
            }
        }

        @Override // android.text.InputFilter.LengthFilter, android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i10, int i11, Spanned spanned, int i12, int i13) {
            String str;
            CharSequence charSequenceFilter = super.filter(charSequence, i10, i11, spanned, i12, i13);
            if (spanned == null) {
                return charSequenceFilter;
            }
            int length = spanned.length();
            b bVar = this.f4351a.get();
            if (bVar != null && length >= this.f4352b && length != 0 && charSequenceFilter != null && (str = bVar.I) != null && !str.isEmpty()) {
                if (this.f4353c == null) {
                    this.f4353c = Toast.makeText(bVar.f4325a, str, 1);
                }
                this.f4353c.show();
            }
            return charSequenceFilter;
        }
    }

    public interface g {
        void a(EditText editText);
    }

    public interface h {
        void a(EditText editText, TextView textView);
    }

    public interface i {
        void a(String str);
    }

    public b(Context context) {
        this.f4325a = context;
        ej.h.b bVar = new ej.h.b(context, 0);
        this.f4326b = bVar;
        bVar.n(true);
        this.f4335v = ContextCompat.getColor(this.f4325a, R.color.os_red_basic_color);
        this.f4336w = ContextCompat.getColor(this.f4325a, R.color.os_gray_secondary_color);
        this.f4337x = ContextCompat.getColor(this.f4325a, R.color.os_fill_primary_color);
        if (this.f4333n == null) {
            j();
        }
        q();
    }

    public void A(boolean z10) {
        View view = this.f4334p;
        if (view != null) {
            view.setBackgroundColor(ContextCompat.getColor(this.f4325a, z10 ? R.color.os_fill_primary_color : R.color.os_gray_secondary_color));
        }
    }

    public b B(g gVar) {
        return C(null, null, gVar);
    }

    public b C(CharSequence charSequence, CharSequence charSequence2, g gVar) {
        this.f4327c.setText(charSequence);
        U(charSequence2);
        if (gVar != null) {
            gVar.a(this.f4327c);
        }
        return this;
    }

    public b D(CharSequence charSequence, CharSequence charSequence2, int i10, h hVar) {
        this.f4327c.setText(charSequence);
        U(charSequence2);
        this.f4332i = (TextView) this.f4333n.findViewById(R.id.num_text);
        this.f4327c.addTextChangedListener(new e(this, i10));
        if (i10 == 0) {
            this.f4332i.setVisibility(8);
        } else {
            this.f4332i.setVisibility(0);
            this.f4327c.setFilters(new InputFilter[]{new f(this, i10)});
        }
        if (charSequence.toString().length() < i10) {
            this.f4327c.setText(charSequence);
            this.f4332i.setText(String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(charSequence.toString().length())) + "/" + String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(i10)));
        } else {
            this.f4332i.setText(String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(i10)) + "/" + String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(i10)));
            this.f4327c.setText(charSequence.toString().substring(0, i10));
        }
        if (hVar != null) {
            hVar.a(this.f4327c, this.f4332i);
        }
        return this;
    }

    public b E(int i10) {
        this.f4327c.addTextChangedListener(new e(this, 0));
        this.f4327c.setText(this.f4325a.getResources().getString(i10));
        return this;
    }

    public b F(String str) {
        this.f4327c.addTextChangedListener(new e(this, 0));
        this.f4327c.setText(str);
        return this;
    }

    public b G(boolean z10) {
        this.H = z10;
        return this;
    }

    public b H(int i10, DialogInterface.OnClickListener onClickListener) {
        return I(this.f4325a.getText(i10), onClickListener);
    }

    public b I(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.f4326b.x(charSequence, onClickListener);
        return this;
    }

    public void J(boolean z10) {
        OSMaterialEditText oSMaterialEditText = this.J;
        if (oSMaterialEditText != null) {
            oSMaterialEditText.f(z10);
        }
    }

    public void K(DialogInterface.OnDismissListener onDismissListener) {
        this.f4329e = onDismissListener;
    }

    public b L(int i10, DialogInterface.OnClickListener onClickListener) {
        return M(this.f4325a.getText(i10), onClickListener);
    }

    public b M(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.f4326b.H(charSequence, onClickListener);
        return this;
    }

    public b N(boolean z10) {
        this.f4338y = z10;
        return this;
    }

    public void O(TextWatcher textWatcher) {
        this.f4327c.addTextChangedListener(textWatcher);
    }

    public b P(@StringRes int i10) {
        return Q(this.f4325a.getString(i10));
    }

    public b Q(String str) {
        this.I = str;
        return this;
    }

    public b R(int i10) {
        this.f4326b.P(i10);
        return this;
    }

    public b S(CharSequence charSequence) {
        this.f4326b.Q(charSequence);
        return this;
    }

    public ej.h T() {
        ej.h hVarK = k();
        hVarK.show();
        return hVarK;
    }

    public final void U(CharSequence charSequence) {
        if (this.f4327c == null || TextUtils.isEmpty(charSequence)) {
            return;
        }
        this.f4327c.post(new RunnableC0101b(charSequence));
    }

    public final void j() {
        View viewInflate = LayoutInflater.from(this.f4325a).inflate(R.layout.os_input_dialog_layout, (ViewGroup) null);
        this.f4333n = viewInflate;
        this.f4326b.U(viewInflate);
    }

    public ej.h k() {
        ExtendedEditText extendedEditText;
        ej.h hVarA = this.f4326b.a();
        hVarA.getWindow().setSoftInputMode(16);
        if (this.f4338y && (extendedEditText = this.f4327c) != null) {
            if (extendedEditText.getText().length() != 0) {
                ExtendedEditText extendedEditText2 = this.f4327c;
                extendedEditText2.setSelection(extendedEditText2.getText().length());
            }
            this.f4328d = new c();
            this.f4327c.getViewTreeObserver().addOnGlobalLayoutListener(this.f4328d);
        }
        if (!this.f4339z) {
            hVarA.setOnDismissListener(new d());
        }
        return hVarA;
    }

    public void l(DialogInterface dialogInterface) {
        ExtendedEditText extendedEditText;
        if (this.f4328d != null && (extendedEditText = this.f4327c) != null && extendedEditText.getViewTreeObserver() != null) {
            this.f4327c.getViewTreeObserver().removeOnGlobalLayoutListener(this.f4328d);
            this.f4328d = null;
        }
        DialogInterface.OnDismissListener onDismissListener = this.f4329e;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
        ExtendedEditText extendedEditText2 = this.f4327c;
        if (extendedEditText2 != null) {
            extendedEditText2.a();
        }
        this.f4330f = false;
    }

    public Button m(int i10) {
        return this.f4326b.f4440a.c(i10);
    }

    public boolean n() {
        return this.H;
    }

    public EditText o() {
        return this.f4327c;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z10) {
        View view2 = this.f4334p;
        if (view2 != null) {
            view2.setBackgroundColor(z10 ? this.f4337x : this.f4336w);
        }
        if (m(-1) == null || !this.H) {
            return;
        }
        m(-1).setEnabled(this.f4327c.getText().toString().length() > 0);
    }

    public TextView p() {
        return this.f4331g;
    }

    public final void q() {
        OSMaterialEditText oSMaterialEditText = (OSMaterialEditText) this.f4333n.findViewById(R.id.input_edit_text);
        this.J = oSMaterialEditText;
        oSMaterialEditText.h(0, 0, 0, 0);
        ExtendedEditText editText = this.J.getEditText();
        this.f4327c = editText;
        editText.setOnFocusChangeListener(this);
        this.f4327c.addTextChangedListener(new e(this, 0));
        this.I = this.f4325a.getString(R.string.os_dialog_input_tip_max);
    }

    public void r(TextWatcher textWatcher) {
        this.f4327c.removeTextChangedListener(textWatcher);
    }

    public b s(boolean z10) {
        this.f4339z = z10;
        return this;
    }

    public b t(boolean z10) {
        this.f4326b.e(z10);
        return this;
    }

    public b u(boolean z10) {
        this.f4326b.g(z10);
        return this;
    }

    public b v(boolean z10) {
        this.f4326b.h(z10);
        return this;
    }

    public b w(int i10) {
        TextView textView = (TextView) this.f4333n.findViewById(R.id.error_text);
        this.f4331g = textView;
        textView.setText(this.f4325a.getResources().getString(i10));
        View view = this.f4334p;
        if (view != null) {
            view.setBackgroundColor(this.f4335v);
        }
        J(i10 != 0);
        return this;
    }

    public b x(CharSequence charSequence) {
        TextView textView = (TextView) this.f4333n.findViewById(R.id.error_text);
        this.f4331g = textView;
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            this.f4331g.setVisibility(8);
            View view = this.f4334p;
            if (view != null) {
                view.setBackgroundColor(this.f4336w);
            }
        } else {
            this.f4331g.setVisibility(0);
            View view2 = this.f4334p;
            if (view2 != null) {
                view2.setBackgroundColor(this.f4335v);
            }
        }
        J(!TextUtils.isEmpty(charSequence));
        return this;
    }

    public b y(int i10, i iVar) {
        return z(this.f4325a.getText(i10), iVar);
    }

    public b z(CharSequence charSequence, i iVar) {
        this.f4326b.H(charSequence, new a(iVar));
        return this;
    }
}
