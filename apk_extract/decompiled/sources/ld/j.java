package ld;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.widgetslib.R$attr;
import com.transsion.widgetslib.R$color;
import com.transsion.widgetslib.R$dimen;
import com.transsion.widgetslib.R$id;
import com.transsion.widgetslib.R$layout;
import com.transsion.widgetslib.view.damping.DampingLayout;
import com.transsion.widgetslib.view.damping.OSScrollbarLayout;
import com.transsion.widgetslib.view.liquid.effect.OSLiquidContainerRootLayoutInner;
import com.transsion.widgetslib.widget.OSSmoothCornerFrameLayout;
import z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOnew;

/* JADX INFO: loaded from: classes2.dex */
public final class j {
    public Message B;
    public boolean C;
    public Button D;
    public Message F;
    public Drawable G;
    public int L;
    public boolean M;
    public boolean N;
    public int P;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f7379b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Window f7380c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LayoutInflater f7381d;
    public final ad.e e;
    public final OSLiquidContainerRootLayoutInner f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ConstraintLayout f7382g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinearLayout f7383h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LinearLayout f7384i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public FrameLayout f7385j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public FrameLayout f7386k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ViewGroup f7387l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f7388m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public CheckedTextView f7389n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public h f7390o;
    public boolean[] q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f7392s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f7393t;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Button f7394v;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Message f7396x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f7397y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Button f7398z;
    public int p = -1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f7391r = false;
    public boolean u = true;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public CharSequence f7395w = null;
    public CharSequence A = null;
    public CharSequence E = null;
    public boolean H = true;
    public boolean I = false;
    public boolean J = false;
    public boolean K = false;
    public boolean O = false;
    public final ce.c Q = new ce.c(this, 2);

    public j(Context context, m mVar, Window window) {
        this.f7378a = context;
        this.f7379b = mVar;
        this.f7380c = window;
        this.e = new ad.e(mVar);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        this.f7381d = layoutInflaterFrom;
        window.requestFeature(1);
        window.setGravity(80);
        OSLiquidContainerRootLayoutInner oSLiquidContainerRootLayoutInner = (OSLiquidContainerRootLayoutInner) layoutInflaterFrom.inflate(R$layout.os_prompt_dialog_container, (ViewGroup) null);
        this.f = oSLiquidContainerRootLayoutInner;
        oSLiquidContainerRootLayoutInner.setShowShadow(false);
        ((OSSmoothCornerFrameLayout) oSLiquidContainerRootLayoutInner.findViewById(R$id.os_prompt_dialog_layout)).setDialogController(this);
        oSLiquidContainerRootLayoutInner.setOnTouchListener(new b(this, context));
        this.f7382g = (ConstraintLayout) oSLiquidContainerRootLayoutInner.findViewById(R$id.mContainer);
        this.f7383h = (LinearLayout) oSLiquidContainerRootLayoutInner.findViewById(R$id.btnLayout);
    }

    public static void a(j jVar) {
        Button button;
        ViewGroup viewGroup;
        if (jVar.u || (button = jVar.f7394v) == null || (viewGroup = jVar.f7387l) == null) {
            return;
        }
        h hVar = jVar.f7390o;
        if (hVar != null) {
            button.setEnabled(hVar.getCheckedItemCount() > 0);
        } else if (viewGroup instanceof ListView) {
            button.setEnabled(((ListView) viewGroup).getCheckedItemCount() > 0);
        }
    }

    public static boolean b(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt.getVisibility() == 0 && b(childAt)) {
                return true;
            }
        }
        return false;
    }

    public final RecyclerView c(h hVar, AdapterView.OnItemClickListener onItemClickListener) {
        View viewInflate = this.f7381d.inflate(R$layout.os_prompt_dialog_list, (ViewGroup) this.f7382g, false);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R$id.os_damp_list_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.f7378a, 1, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        hVar.setOnItemClickListener(onItemClickListener);
        this.f7390o = hVar;
        hVar.setWeakReference(this);
        recyclerView.setAdapter(hVar);
        if (!pd.j.f8769h) {
            z1OoOnew z1ooonewC = b8.g.c(recyclerView);
            View viewFindViewById = viewInflate.findViewById(R$id.os_damp_list_view_parent);
            if (z1ooonewC != null) {
                z1ooonewC.G = false;
            }
            if ((viewFindViewById instanceof OSScrollbarLayout) && z1ooonewC != null) {
                OSScrollbarLayout oSScrollbarLayout = (OSScrollbarLayout) viewFindViewById;
                oSScrollbarLayout.setOverScrollView(recyclerView);
                z1ooonewC.A = new g(oSScrollbarLayout);
            }
        }
        return recyclerView;
    }

    public final boolean d() {
        ConstraintLayout constraintLayout;
        FrameLayout frameLayout;
        return this.I || ((constraintLayout = this.f7382g) != null && b(constraintLayout)) || ((frameLayout = this.f7386k) != null && b(frameLayout));
    }

    public final void e(int i8, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        Message messageObtainMessage = onClickListener != null ? this.e.obtainMessage(i8, onClickListener) : null;
        if (i8 == -3) {
            this.E = charSequence;
            this.F = messageObtainMessage;
            this.C = true;
        } else if (i8 == -2) {
            this.A = charSequence;
            this.B = messageObtainMessage;
            this.f7397y = true;
        } else {
            if (i8 != -1) {
                throw new IllegalArgumentException("Button does not exist");
            }
            this.f7395w = charSequence;
            this.f7396x = messageObtainMessage;
            this.f7393t = true;
        }
    }

    public final void f(int i8, View view) {
        if (i8 == 0 && view == null) {
            return;
        }
        int i9 = R$layout.os_prompt_dialog_view;
        LayoutInflater layoutInflater = this.f7381d;
        FrameLayout frameLayout = (FrameLayout) layoutInflater.inflate(i9, (ViewGroup) this.f7382g, false);
        this.f7386k = frameLayout;
        frameLayout.removeAllViews();
        if (i8 != 0) {
            FrameLayout frameLayout2 = this.f7386k;
            frameLayout2.addView(layoutInflater.inflate(i8, (ViewGroup) frameLayout2, false));
        } else {
            this.f7386k.addView(view);
        }
        if (this.f7386k.getMeasuredHeight() == 0) {
            this.f7386k.measure(0, 0);
            this.f7386k.getMeasuredHeight();
        }
    }

    public CheckedTextView getCheckedView() {
        return this.f7389n;
    }

    public boolean getIsAppDialogFragment() {
        return this.K;
    }

    public View getListView() {
        return this.f7387l;
    }

    public int getNoBtnBottomInsets() {
        return this.L;
    }

    public TextView getTitleView() {
        LinearLayout linearLayout = this.f7384i;
        if (linearLayout != null) {
            return (TextView) linearLayout.findViewById(R$id.text_title);
        }
        return null;
    }

    public void setAutoDismiss(boolean z2) {
        this.H = z2;
    }

    public void setButtonChoiceDialog(boolean z2) {
        this.J = z2;
    }

    public void setButtonVertical(boolean z2) {
        this.f7391r = z2;
    }

    public void setCancelable(boolean z2) {
        this.M = z2;
    }

    public void setCanceledOnTouchOutside(boolean z2) {
        this.N = z2;
    }

    public void setCheckedItem(int i8) {
        this.p = i8;
        ViewGroup viewGroup = this.f7387l;
        if (viewGroup instanceof ListView) {
            ListView listView = (ListView) viewGroup;
            listView.setItemChecked(i8, true);
            listView.setSelection(i8);
        }
    }

    public void setElegantTextHeight(boolean z2) {
        TextView textView;
        FrameLayout frameLayout = this.f7385j;
        if (frameLayout == null || (textView = (TextView) frameLayout.findViewById(R$id.text_message)) == null || z2 == textView.getPaint().isElegantTextHeight()) {
            return;
        }
        textView.setElegantTextHeight(z2);
    }

    public void setFillColor(@NonNull int i8) {
        OSLiquidContainerRootLayoutInner oSLiquidContainerRootLayoutInner = this.f;
        if (oSLiquidContainerRootLayoutInner != null) {
            ((OSSmoothCornerFrameLayout) oSLiquidContainerRootLayoutInner.findViewById(R$id.os_prompt_dialog_layout)).setFillColor(i8);
            oSLiquidContainerRootLayoutInner.setDefaultBgColor(i8);
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.G == drawable && drawable == null) {
            return;
        }
        if (this.f7384i == null) {
            this.f7384i = (LinearLayout) this.f7381d.inflate(R$layout.os_prompt_dialog_title, (ViewGroup) this.f7382g, false);
        }
        ImageView imageView = (ImageView) this.f7384i.findViewById(R$id.iconImg);
        TextView textView = (TextView) this.f7384i.findViewById(R$id.text_title);
        boolean zS = pd.j.s();
        Context context = this.f7378a;
        if (zS) {
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R$dimen.os_ultra_small_space200);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, dimensionPixelSize);
            imageView.setLayoutParams(layoutParams);
        }
        if (imageView != null) {
            imageView.setVisibility(0);
            imageView.setImageDrawable(drawable);
        }
        if (textView != null) {
            textView.setPaddingRelative((int) context.getResources().getDimension(R$dimen.os_dialog_title_padding_bottom), 0, (int) context.getResources().getDimension(R$dimen.os_dialog_title_padding_end), 0);
        }
        this.G = drawable;
    }

    public void setInputMessagePosition(int i8) {
        this.P = i8;
    }

    public void setIsAlert(boolean z2) {
        this.f7392s = z2;
    }

    public void setIsAppDialogFragment(boolean z2) {
        this.K = z2;
    }

    public void setIsInputDialog(boolean z2) {
        this.I = z2;
    }

    public void setMessage(CharSequence charSequence) {
        setMessageView(charSequence);
    }

    public void setMessageView(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        Paint paint = new Paint();
        Context context = this.f7378a;
        paint.setTextSize(context.getResources().getDimensionPixelSize(R$dimen.os_body_font));
        this.O = paint.measureText(charSequence.toString()) > ((float) ((pd.j.k(context) - (hd.a.a(context, 16) * 2)) - (context.getResources().getDimensionPixelSize(R$dimen.os_dialog_padding_left_right) * 2)));
        if (this.f7385j == null) {
            FrameLayout frameLayout = (FrameLayout) this.f7381d.inflate(R$layout.os_prompt_dialog_message, (ViewGroup) this.f7382g, false);
            this.f7385j = frameLayout;
            ((DampingLayout) frameLayout.findViewById(R$id.os_damping_inner)).setVibrateEnable(false);
        }
        TextView textView = (TextView) this.f7385j.findViewById(R$id.text_message);
        if (pd.j.s()) {
            textView.setPaddingRelative(context.getResources().getDimensionPixelSize(R$dimen.os_ultra_small_dialog_padding_left_right), textView.getPaddingTop(), context.getResources().getDimensionPixelSize(R$dimen.os_ultra_small_dialog_padding_left_right), textView.getPaddingBottom());
            textView.setMinHeight(hd.a.a(context, 24));
        }
        textView.setText(charSequence);
        textView.setGravity(!this.O ? 17 : GravityCompat.START);
    }

    public void setNoBtnBottomInsets(int i8) {
        this.L = i8;
    }

    public void setPositiveButtonEnable(boolean z2) {
        this.u = z2;
    }

    public void setPromptDialogPaddingTop(int i8) {
        OSLiquidContainerRootLayoutInner oSLiquidContainerRootLayoutInner = this.f;
        if (oSLiquidContainerRootLayoutInner != null) {
            oSLiquidContainerRootLayoutInner.findViewById(R$id.os_prompt_dialog_layout).setPadding(oSLiquidContainerRootLayoutInner.getPaddingLeft(), i8, oSLiquidContainerRootLayoutInner.getPaddingRight(), oSLiquidContainerRootLayoutInner.getPaddingBottom());
        }
    }

    public void setTitle(CharSequence charSequence) {
        LinearLayout linearLayout = this.f7384i;
        if (linearLayout != null) {
            ((TextView) linearLayout.findViewById(R$id.text_title)).setText(charSequence);
        } else {
            setTitleView(charSequence);
        }
    }

    public void setTitleView(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        if (this.f7384i == null) {
            this.f7384i = (LinearLayout) this.f7381d.inflate(R$layout.os_prompt_dialog_title, (ViewGroup) this.f7382g, false);
        }
        ((TextView) this.f7384i.findViewById(R$id.text_title)).setText(charSequence);
    }

    public void setTitleViewBg(@ColorInt int i8) {
        LinearLayout linearLayout = this.f7384i;
        if (linearLayout != null) {
            linearLayout.setBackgroundColor(i8);
        }
    }

    public void setTopTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        if (this.f7384i == null) {
            this.f7384i = (LinearLayout) this.f7381d.inflate(R$layout.os_prompt_dialog_title, (ViewGroup) this.f7382g, false);
        }
        TextView textView = (TextView) this.f7384i.findViewById(R$id.text_top_title);
        boolean zS = pd.j.s();
        Context context = this.f7378a;
        if (zS) {
            textView.setPaddingRelative(context.getResources().getDimensionPixelSize(R$dimen.os_ultra_small_dialog_padding_left_right), textView.getPaddingTop(), context.getResources().getDimensionPixelSize(R$dimen.os_ultra_small_dialog_title_padding_end), textView.getPaddingBottom());
            textView.setTextSize(2, context.getResources().getDimension(R$dimen.os_ultra_small_space200));
        }
        textView.setTextColor(pd.j.e(context, R$attr.os_text_info, R$color.os_text_info_hios));
        textView.setVisibility(0);
        textView.setText(charSequence);
    }
}
