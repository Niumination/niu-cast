package ej;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.widgetslib.R;
import com.transsion.widgetslib.adapter.RecyclerAdapter;
import com.transsion.widgetslib.view.damping.DampingLayout;
import com.transsion.widgetslib.view.damping.OSScrollbarLayout;
import com.transsion.widgetslib.widget.timepicker.OSDateTimePicker;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class g {
    public Message A;
    public boolean B;
    public Button C;
    public CharSequence D;
    public Message E;
    public Drawable F;
    public int J;
    public int K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DialogInterface f4390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Window f4391c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LayoutInflater f4392d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handler f4393e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FrameLayout f4394f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RelativeLayout f4395g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinearLayout f4396h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LinearLayout f4397i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public DampingLayout f4398j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public FrameLayout f4399k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f4400l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public CheckedTextView f4401m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public l f4402n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean[] f4404p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f4406r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f4407s;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Button f4409u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public CharSequence f4410v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Message f4411w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f4412x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Button f4413y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public CharSequence f4414z;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f4403o = -1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f4405q = false;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f4408t = true;
    public boolean G = true;
    public boolean H = false;
    public boolean I = false;
    public final View.OnClickListener L = new b();

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f4415a;

        public a(ViewGroup viewGroup) {
            this.f4415a = viewGroup;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f4415a.getHeight() >= g.this.f4400l.getHeight()) {
                g gVar = g.this;
                if (gVar.K <= 0 || gVar.f4399k.getHeight() >= g.this.K) {
                    return;
                }
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) g.this.f4399k.getLayoutParams();
            layoutParams.removeRule(3);
            layoutParams.addRule(12);
            g.this.f4399k.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f4415a.getLayoutParams();
            layoutParams.removeRule(3);
            layoutParams2.addRule(3, R.id.os_module_dialog_damping_layout_title);
            layoutParams2.addRule(2, R.id.os_module_dialog_custom_view);
            this.f4415a.setLayoutParams(layoutParams2);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Message messageObtain;
            Message message;
            Message message2;
            Message message3;
            g gVar = g.this;
            if (view == gVar.f4409u && (message3 = gVar.f4411w) != null) {
                messageObtain = Message.obtain(message3);
            } else if (view != gVar.f4413y || (message2 = gVar.A) == null) {
                messageObtain = (view != gVar.C || (message = gVar.E) == null) ? null : Message.obtain(message);
            } else {
                messageObtain = Message.obtain(message2);
            }
            if (messageObtain != null) {
                messageObtain.sendToTarget();
            }
            g gVar2 = g.this;
            if (gVar2.G) {
                gVar2.f4393e.obtainMessage(1, gVar2.f4390b).sendToTarget();
            }
        }
    }

    public class c implements View.OnTouchListener {
        public c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    public class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DialogInterface.OnClickListener f4419a;

        public d(DialogInterface.OnClickListener onClickListener) {
            this.f4419a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CheckedTextView checkedTextView = g.this.f4401m;
            checkedTextView.setChecked(!checkedTextView.isChecked());
            g gVar = g.this;
            Button button = gVar.f4409u;
            if (button != null) {
                button.setEnabled(gVar.f4401m.isChecked());
            }
            DialogInterface.OnClickListener onClickListener = this.f4419a;
            if (onClickListener != null) {
                onClickListener.onClick(g.this.f4390b, 0);
            }
        }
    }

    public class e implements AdapterView.OnItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DialogInterface.OnClickListener f4421a;

        public e(DialogInterface.OnClickListener onClickListener) {
            this.f4421a = onClickListener;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            DialogInterface.OnClickListener onClickListener = this.f4421a;
            if (onClickListener != null) {
                onClickListener.onClick(g.this.f4390b, i10);
                g.this.f4390b.dismiss();
            }
        }
    }

    public class f implements AdapterView.OnItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DialogInterface.OnClickListener f4423a;

        public f(DialogInterface.OnClickListener onClickListener) {
            this.f4423a = onClickListener;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            DialogInterface.OnClickListener onClickListener = this.f4423a;
            if (onClickListener != null) {
                onClickListener.onClick(g.this.f4390b, i10);
            }
            l lVar = g.this.f4402n;
            if (lVar != null) {
                lVar.k(i10);
            }
            g.this.V();
        }
    }

    /* JADX INFO: renamed from: ej.g$g, reason: collision with other inner class name */
    public class C0103g implements AdapterView.OnItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DialogInterface.OnMultiChoiceClickListener f4425a;

        public C0103g(DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.f4425a = onMultiChoiceClickListener;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            l lVar;
            if (this.f4425a != null) {
                g gVar = g.this;
                if (gVar.f4400l == null || (lVar = gVar.f4402n) == null) {
                    return;
                }
                if (gVar.f4404p != null) {
                    lVar.k(i10);
                }
                g.this.V();
                DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener = this.f4425a;
                g gVar2 = g.this;
                onMultiChoiceClickListener.onClick(gVar2.f4390b, i10, gVar2.f4402n.h(i10));
            }
        }
    }

    public class h implements g6.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OSScrollbarLayout f4427a;

        public h(OSScrollbarLayout oSScrollbarLayout) {
            this.f4427a = oSScrollbarLayout;
        }

        @Override // g6.c
        public void a(float f10) {
            this.f4427a.x(f10);
        }
    }

    public class i implements AdapterView.OnItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DialogInterface.OnClickListener f4429a;

        public i(DialogInterface.OnClickListener onClickListener) {
            this.f4429a = onClickListener;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            DialogInterface.OnClickListener onClickListener = this.f4429a;
            if (onClickListener != null) {
                onClickListener.onClick(g.this.f4390b, i10);
            }
            g.this.V();
        }
    }

    public class j implements AdapterView.OnItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DialogInterface.OnClickListener f4431a;

        public j(DialogInterface.OnClickListener onClickListener) {
            this.f4431a = onClickListener;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            DialogInterface.OnClickListener onClickListener = this.f4431a;
            if (onClickListener != null) {
                onClickListener.onClick(g.this.f4390b, i10);
                g.this.f4390b.dismiss();
            }
        }
    }

    public static final class k extends Handler {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f4433b = 1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<DialogInterface> f4434a;

        public k(DialogInterface dialogInterface) {
            this.f4434a = new WeakReference<>(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                int i10 = message.what;
                if (i10 == -3 || i10 == -2 || i10 == -1) {
                    ((DialogInterface.OnClickListener) message.obj).onClick(this.f4434a.get(), message.what);
                } else if (i10 == 1) {
                    ((DialogInterface) message.obj).dismiss();
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public static final class l extends RecyclerAdapter<CharSequence, m> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public WeakReference<g> f4435c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f4436d;

        public l(List<CharSequence> list) {
            this(list, 0);
        }

        public int g() {
            WeakReference<g> weakReference = this.f4435c;
            if (weakReference == null || weakReference.get() == null || this.f4435c.get().f4404p == null) {
                return 0;
            }
            int i10 = 0;
            for (boolean z10 : this.f4435c.get().f4404p) {
                if (z10) {
                    i10++;
                }
            }
            return i10;
        }

        public boolean h(int i10) {
            WeakReference<g> weakReference = this.f4435c;
            if (weakReference == null || weakReference.get() == null || this.f4435c.get().f4404p == null) {
                return false;
            }
            boolean[] zArr = this.f4435c.get().f4404p;
            return i10 >= 0 && i10 < zArr.length && zArr[i10];
        }

        @Override // com.transsion.widgetslib.adapter.RecyclerAdapter
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void c(@NonNull m mVar, int i10, CharSequence charSequence) {
            mVar.f4437c.setText((CharSequence) this.f2307a.get(i10));
            WeakReference<g> weakReference = this.f4435c;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            int i11 = this.f4436d;
            boolean z10 = false;
            if (i11 == 1) {
                mVar.f4437c.setChecked(this.f4435c.get().f4403o == i10);
            } else if (i11 == 2) {
                boolean[] zArr = this.f4435c.get().f4404p;
                CheckedTextView checkedTextView = mVar.f4437c;
                if (zArr != null && zArr[i10]) {
                    z10 = true;
                }
                checkedTextView.setChecked(z10);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public m onCreateViewHolder(@NonNull ViewGroup viewGroup, int i10) {
            m mVar = new m(viewGroup);
            mVar.f2309a = this.f2308b != null;
            mVar.d(this.f4436d);
            return mVar;
        }

        public void k(int i10) {
            boolean[] zArr;
            WeakReference<g> weakReference = this.f4435c;
            if (weakReference == null || weakReference.get() == null || i10 < 0) {
                return;
            }
            int itemCount = getItemCount();
            int i11 = this.f4436d;
            if (i11 != 1) {
                if (i11 != 2 || (zArr = this.f4435c.get().f4404p) == null || zArr.length > itemCount) {
                    return;
                }
                zArr[i10] = !zArr[i10];
                notifyItemChanged(i10);
                return;
            }
            int i12 = this.f4435c.get().f4403o;
            if (i12 >= 0 && i12 < itemCount) {
                notifyItemChanged(i12);
            }
            if (i10 < itemCount) {
                this.f4435c.get().f4403o = i10;
                notifyItemChanged(this.f4435c.get().f4403o);
            }
        }

        public void l(g gVar) {
            this.f4435c = new WeakReference<>(gVar);
        }

        public l(List<CharSequence> list, int i10) {
            super(list);
            this.f4436d = i10;
        }
    }

    public static final class m extends RecyclerAdapter.Holder {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final CheckedTextView f4437c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Context f4438d;

        public m(ViewGroup viewGroup) {
            super(viewGroup, R.layout.os_prompt_dialog_list_item_compat);
            this.f4437c = (CheckedTextView) this.itemView.findViewById(R.id.text_list_item_compat);
            this.f4438d = viewGroup.getContext();
        }

        /* JADX WARN: Code duplicated, block: B:12:0x003c  */
        public void d(int i10) {
            Drawable drawable;
            TypedValue typedValue = new TypedValue();
            if (i10 == 1) {
                if (this.f4438d.getTheme().resolveAttribute(android.R.attr.listChoiceIndicatorSingle, typedValue, true)) {
                    drawable = ContextCompat.getDrawable(this.f4438d, typedValue.resourceId);
                } else {
                    drawable = null;
                }
            } else if (i10 == 2 && this.f4438d.getTheme().resolveAttribute(android.R.attr.listChoiceIndicatorMultiple, typedValue, true)) {
                drawable = ContextCompat.getDrawable(this.f4438d, typedValue.resourceId);
            } else {
                drawable = null;
            }
            if (drawable != null) {
                this.f4437c.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
            }
        }
    }

    public g(Context context, DialogInterface dialogInterface, Window window) {
        this.f4389a = context;
        this.f4390b = dialogInterface;
        this.f4391c = window;
        this.f4393e = new k(dialogInterface);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        this.f4392d = layoutInflaterFrom;
        window.requestFeature(1);
        window.setGravity(80);
        FrameLayout frameLayout = (FrameLayout) layoutInflaterFrom.inflate(R.layout.os_prompt_dialog_container, (ViewGroup) null);
        this.f4394f = frameLayout;
        frameLayout.setOnTouchListener(new c());
        this.f4395g = (RelativeLayout) frameLayout.findViewById(R.id.mContainer);
        this.f4396h = (LinearLayout) frameLayout.findViewById(R.id.btnLayout);
    }

    public static boolean p(View view) {
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
            if (childAt.getVisibility() == 0 && p(childAt)) {
                return true;
            }
        }
        return false;
    }

    public int A() {
        return this.J;
    }

    public TextView B() {
        LinearLayout linearLayout = this.f4397i;
        if (linearLayout != null) {
            return (TextView) linearLayout.findViewById(R.id.text_title);
        }
        return null;
    }

    public final boolean C(View view) {
        if (view.getVisibility() == 0 && (view instanceof OSDateTimePicker)) {
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
            if (childAt.getVisibility() == 0 && C(childAt)) {
                return true;
            }
        }
        return false;
    }

    public boolean D() {
        RelativeLayout relativeLayout;
        return this.H || ((relativeLayout = this.f4395g) != null && p(relativeLayout));
    }

    public void E() {
        this.f4391c.setContentView(this.f4394f);
        this.f4391c.setWindowAnimations(R.style.OsInputDialogAnimStyle);
        o0();
    }

    public final void F() {
        ((FrameLayout.LayoutParams) this.f4395g.getLayoutParams()).setMargins(0, 0, 0, this.J);
    }

    public void G(ej.i.a aVar) {
        View view = this.f4400l;
        if (view instanceof ListView) {
            aVar.onPrepareListView((ListView) view);
        }
    }

    public void H(boolean z10) {
        this.G = z10;
    }

    public void I(int i10, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message) {
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        if (message == null && onClickListener != null) {
            message = this.f4393e.obtainMessage(i10, onClickListener);
        }
        if (i10 == -3) {
            this.D = charSequence;
            this.E = message;
            this.B = true;
        } else if (i10 == -2) {
            this.f4414z = charSequence;
            this.A = message;
            this.f4412x = true;
        } else {
            if (i10 != -1) {
                throw new IllegalArgumentException("Button does not exist");
            }
            this.f4410v = charSequence;
            this.f4411w = message;
            this.f4407s = true;
        }
    }

    public void J(boolean z10) {
        this.f4405q = z10;
    }

    public void K(int i10) {
        this.f4403o = i10;
        View view = this.f4400l;
        if (view instanceof ListView) {
            ListView listView = (ListView) view;
            listView.setItemChecked(i10, true);
            listView.setSelection(i10);
        }
    }

    public void L(boolean z10) {
        TextView textView;
        DampingLayout dampingLayout = this.f4398j;
        if (dampingLayout == null || (textView = (TextView) dampingLayout.findViewById(R.id.text_message)) == null || z10 == textView.getPaint().isElegantTextHeight()) {
            return;
        }
        textView.setElegantTextHeight(z10);
    }

    public void M(Drawable drawable) {
        if (this.F == drawable && drawable == null) {
            return;
        }
        if (this.f4397i == null) {
            this.f4397i = (LinearLayout) this.f4392d.inflate(R.layout.os_prompt_dialog_title, (ViewGroup) this.f4395g, false);
        }
        N(drawable);
        this.F = drawable;
    }

    public final void N(Drawable drawable) {
        ImageView imageView = (ImageView) this.f4397i.findViewById(R.id.iconImg);
        if (imageView != null) {
            imageView.setVisibility(0);
            imageView.setImageDrawable(drawable);
        }
    }

    public void O(boolean z10) {
        this.f4406r = z10;
    }

    public void P(boolean z10) {
        this.I = z10;
    }

    public void Q(boolean z10) {
        this.H = z10;
    }

    public void R(Cursor cursor, String str, DialogInterface.OnClickListener onClickListener) {
        try {
            ArrayList arrayList = new ArrayList();
            while (cursor.moveToNext()) {
                arrayList.add(cursor.getString(cursor.getColumnIndex(str)));
            }
            T(new l(arrayList, 0), onClickListener);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void S(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
        this.f4400l = r(listAdapter, new j(onClickListener));
    }

    public void T(RecyclerView.Adapter<?> adapter, DialogInterface.OnClickListener onClickListener) {
        this.f4400l = s(adapter, new e(onClickListener));
    }

    public void U(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
        T(new l(Arrays.asList(charSequenceArr), 0), onClickListener);
    }

    public final void V() {
        Button button;
        View view;
        if (this.f4408t || (button = this.f4409u) == null || (view = this.f4400l) == null) {
            return;
        }
        l lVar = this.f4402n;
        if (lVar != null) {
            button.setEnabled(lVar.g() > 0);
        } else if (view instanceof ListView) {
            button.setEnabled(((ListView) view).getCheckedItemCount() > 0);
        }
    }

    public void W(CharSequence charSequence) {
        DampingLayout dampingLayout = this.f4398j;
        if (dampingLayout != null) {
            ((TextView) dampingLayout.findViewById(R.id.text_message)).setText(charSequence);
        } else {
            X(charSequence);
        }
    }

    public void X(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        DampingLayout dampingLayout = (DampingLayout) this.f4392d.inflate(R.layout.os_prompt_dialog_message, (ViewGroup) this.f4395g, false);
        this.f4398j = dampingLayout;
        ((TextView) dampingLayout.findViewById(R.id.text_message)).setText(charSequence);
    }

    public void Y(Cursor cursor, String str, String str2, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        try {
            ArrayList arrayList = new ArrayList();
            while (cursor.moveToNext()) {
                arrayList.add(cursor.getString(cursor.getColumnIndex(str)));
            }
            Z(new l(arrayList, 2), onMultiChoiceClickListener);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final void Z(RecyclerView.Adapter<?> adapter, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        this.f4400l = s(adapter, new C0103g(onMultiChoiceClickListener));
    }

    public void a0(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        q(charSequenceArr, zArr);
        Z(new l(Arrays.asList(charSequenceArr), 2), onMultiChoiceClickListener);
    }

    public void b0(int i10) {
        this.J = i10;
    }

    public void c0(boolean z10) {
        this.f4408t = z10;
    }

    public void d0(CharSequence charSequence, boolean z10, DialogInterface.OnClickListener onClickListener) {
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        m0(R.layout.os_prompt_dialog_singlechecked, null);
        FrameLayout frameLayout = this.f4399k;
        if (frameLayout != null) {
            CheckedTextView checkedTextView = (CheckedTextView) frameLayout.findViewById(R.id.text_choice);
            this.f4401m = checkedTextView;
            if (checkedTextView != null) {
                checkedTextView.setText(charSequence);
                this.f4401m.setChecked(z10);
                this.f4401m.setOnClickListener(new d(onClickListener));
            }
        }
    }

    public void e0(Cursor cursor, String str, DialogInterface.OnClickListener onClickListener) {
        try {
            ArrayList arrayList = new ArrayList();
            while (cursor.moveToNext()) {
                arrayList.add(cursor.getString(cursor.getColumnIndex(str)));
            }
            g0(new l(arrayList, 1), onClickListener);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void f0(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
        View viewR = r(listAdapter, new i(onClickListener));
        this.f4400l = viewR;
        if (viewR instanceof ListView) {
            ((ListView) viewR).setChoiceMode(1);
        }
    }

    public void g0(RecyclerView.Adapter<?> adapter, DialogInterface.OnClickListener onClickListener) {
        this.f4400l = s(adapter, new f(onClickListener));
    }

    public void h0(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
        g0(new l(Arrays.asList(charSequenceArr), 1), onClickListener);
    }

    public void i0(CharSequence charSequence) {
        LinearLayout linearLayout = this.f4397i;
        if (linearLayout != null) {
            ((TextView) linearLayout.findViewById(R.id.text_title)).setText(charSequence);
        } else {
            k0(charSequence);
        }
    }

    public void j0() {
        LinearLayout linearLayout = this.f4397i;
        if (linearLayout != null) {
            TextView textView = (TextView) linearLayout.findViewById(R.id.text_title);
            textView.setSingleLine();
            textView.setEllipsize(TextUtils.TruncateAt.END);
        } else {
            LinearLayout linearLayout2 = (LinearLayout) this.f4392d.inflate(R.layout.os_prompt_dialog_title, (ViewGroup) this.f4395g, false);
            this.f4397i = linearLayout2;
            TextView textView2 = (TextView) linearLayout2.findViewById(R.id.text_title);
            textView2.setSingleLine();
            textView2.setEllipsize(TextUtils.TruncateAt.END);
        }
    }

    public void k0(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        if (this.f4397i == null) {
            this.f4397i = (LinearLayout) this.f4392d.inflate(R.layout.os_prompt_dialog_title, (ViewGroup) this.f4395g, false);
        }
        ((TextView) this.f4397i.findViewById(R.id.text_title)).setText(charSequence);
    }

    public void l0(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        if (this.f4397i == null) {
            this.f4397i = (LinearLayout) this.f4392d.inflate(R.layout.os_prompt_dialog_title, (ViewGroup) this.f4395g, false);
        }
        TextView textView = (TextView) this.f4397i.findViewById(R.id.text_top_title);
        textView.setTextColor(ContextCompat.getColor(this.f4389a, R.color.os_text_tertiary_color));
        textView.setVisibility(0);
        textView.setText(charSequence);
    }

    public void m0(int i10, View view) {
        if (i10 == 0 && view == null) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.f4392d.inflate(R.layout.os_prompt_dialog_view, (ViewGroup) this.f4395g, false);
        this.f4399k = frameLayout;
        if (i10 != 0) {
            frameLayout.addView(this.f4392d.inflate(i10, (ViewGroup) frameLayout, false));
        } else {
            frameLayout.addView(view);
        }
        int measuredHeight = this.f4399k.getMeasuredHeight();
        this.K = measuredHeight;
        if (measuredHeight == 0) {
            this.f4399k.measure(0, 0);
            this.K = this.f4399k.getMeasuredHeight();
        }
    }

    public final void n0(boolean z10) {
        if (!this.f4407s && !this.f4412x && !this.B) {
            F();
            return;
        }
        if (z10 && p(this.f4399k)) {
            this.f4405q = false;
        } else {
            LinearLayout linearLayout = this.f4396h;
            linearLayout.addView(this.f4392d.inflate(R.layout.os_dialog_horizontal_divider, (ViewGroup) linearLayout, false));
            this.f4391c.setFlags(131072, 131072);
        }
        View viewInflate = this.f4392d.inflate(this.f4405q ? R.layout.os_prompt_dialog_buttons_vertical : R.layout.os_prompt_dialog_buttons_horizontal, (ViewGroup) this.f4396h, false);
        Button button = (Button) viewInflate.findViewById(R.id.btn_positive);
        this.f4409u = button;
        if (this.f4407s) {
            button.setText(this.f4410v);
            this.f4409u.setOnClickListener(this.L);
            CheckedTextView checkedTextView = this.f4401m;
            if (checkedTextView != null) {
                this.f4409u.setEnabled(checkedTextView.isChecked());
            } else {
                this.f4409u.setEnabled(this.f4408t);
            }
            if (this.f4406r) {
                this.f4409u.setTextColor(ContextCompat.getColor(this.f4389a, R.color.os_dialog_positive_btn_alert_color));
            }
        } else {
            button.setVisibility(8);
        }
        Button button2 = (Button) viewInflate.findViewById(R.id.btn_negative);
        this.f4413y = button2;
        if (this.f4412x) {
            button2.setText(this.f4414z);
            this.f4413y.setOnClickListener(this.L);
        } else {
            button2.setVisibility(8);
        }
        Button button3 = (Button) viewInflate.findViewById(R.id.btn_neutral);
        this.C = button3;
        if (this.B) {
            button3.setText(this.D);
            this.C.setOnClickListener(this.L);
        } else {
            button3.setVisibility(8);
        }
        this.f4396h.addView(viewInflate);
        if (this.f4395g != null) {
            int dimension = (int) this.f4389a.getResources().getDimension(R.dimen.os_dialog_button_height);
            if (this.f4405q) {
                dimension = (dimension * (this.B ? 1 : 0)) + ((this.f4412x ? 1 : 0) * dimension) + ((this.f4407s ? 1 : 0) * dimension);
            }
            if (this.H) {
                ((FrameLayout.LayoutParams) this.f4395g.getLayoutParams()).setMargins(0, 0, 0, (int) (this.f4389a.getResources().getDimension(R.dimen.os_dialog_divider_margin_10) + dimension));
            } else {
                ((FrameLayout.LayoutParams) this.f4395g.getLayoutParams()).setMargins(0, 0, 0, dimension + ((int) this.f4389a.getResources().getDimension(this.f4400l != null ? R.dimen.os_dialog_divider_margin_10 : R.dimen.os_dialog_divider_margin)));
            }
        }
    }

    public final void o0() {
        LinearLayout linearLayout;
        TextView textView;
        TextView textViewB;
        this.f4395g.removeAllViews();
        this.f4396h.removeAllViews();
        LinearLayout linearLayout2 = this.f4397i;
        boolean z10 = linearLayout2 != null;
        boolean z11 = this.f4398j != null;
        boolean z12 = this.f4399k != null;
        boolean z13 = this.f4400l != null;
        if (z10) {
            linearLayout2.setBackgroundColor(ContextCompat.getColor(this.f4389a, R.color.os_altitude_secondary_color));
            this.f4397i.setId(R.id.os_module_dialog_damping_layout_title);
        }
        if (z11) {
            if (z10) {
                this.f4398j.setPadding(0, (int) this.f4389a.getResources().getDimension(R.dimen.os_dialog_message_padding_top), 0, 0);
            } else if (z12) {
                this.f4398j.setPadding(0, 0, 0, (int) this.f4389a.getResources().getDimension(R.dimen.os_dialog_message_padding_top));
            } else {
                this.f4398j.setPadding(0, 0, 0, 0);
            }
            if (z10) {
                this.f4395g.addView(this.f4398j, w());
            } else {
                this.f4395g.addView(this.f4398j);
            }
        }
        if (z13 && !z11) {
            ViewGroup viewGroup = (ViewGroup) this.f4400l.getParent();
            if (z10) {
                this.f4395g.addView(viewGroup, w());
            } else {
                this.f4395g.addView(viewGroup);
            }
        }
        if (z13 && z10 && (textViewB = B()) != null) {
            textViewB.setPaddingRelative((int) this.f4389a.getResources().getDimension(R.dimen.os_dialog_padding_left_right), 0, (int) this.f4389a.getResources().getDimension(R.dimen.os_dialog_title_padding_end), (int) this.f4389a.getResources().getDimension(R.dimen.os_dialog_title_padding_bottom));
        }
        if (z13 && !z10) {
            this.f4395g.setPadding(0, 0, 0, 0);
        }
        if (z12) {
            if (z11) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f4398j.getLayoutParams();
                layoutParams.height = -2;
                this.f4398j.setLayoutParams(layoutParams);
            } else if (z13) {
                if (this.f4395g.indexOfChild((ViewGroup) this.f4400l.getParent()) != -1) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f4399k.getLayoutParams();
                    layoutParams2.height = -2;
                    layoutParams2.addRule(3, R.id.os_damp_list_view_parent);
                    this.f4399k.setLayoutParams(layoutParams2);
                }
            } else if (C(this.f4399k) && (linearLayout = this.f4397i) != null && (textView = (TextView) linearLayout.findViewById(R.id.text_title)) != null) {
                textView.setTextSize(0, this.f4389a.getResources().getDimension(R.dimen.os_body_font));
                int dimensionPixelSize = this.f4389a.getResources().getDimensionPixelSize(R.dimen.os_dialog_padding_left_right);
                textView.setPaddingRelative(dimensionPixelSize, 0, (int) (dimensionPixelSize / 1.5f), 0);
            }
            if (z11) {
                this.f4399k.setBackgroundColor(ContextCompat.getColor(this.f4389a, R.color.os_altitude_secondary_color));
                this.f4395g.addView(this.f4399k, x());
            } else if (z13) {
                ViewGroup viewGroup2 = (ViewGroup) this.f4400l.getParent();
                viewGroup2.post(new a(viewGroup2));
                this.f4399k.setBackgroundColor(ContextCompat.getColor(this.f4389a, R.color.os_altitude_secondary_color));
                this.f4395g.addView(this.f4399k);
            } else {
                this.f4395g.addView(this.f4399k, w());
            }
        }
        if (z10 && this.f4395g.indexOfChild(this.f4397i) == -1) {
            this.f4395g.addView(this.f4397i, y());
        }
        n0(z12);
    }

    public final void q(CharSequence[] charSequenceArr, boolean[] zArr) {
        if (zArr == null) {
            this.f4404p = new boolean[charSequenceArr.length];
            return;
        }
        if (charSequenceArr.length == zArr.length) {
            this.f4404p = zArr;
            return;
        }
        this.f4404p = new boolean[charSequenceArr.length];
        int i10 = 0;
        while (i10 < charSequenceArr.length) {
            this.f4404p[i10] = i10 < zArr.length && zArr[i10];
            i10++;
        }
    }

    public final View r(ListAdapter listAdapter, AdapterView.OnItemClickListener onItemClickListener) {
        ListView listView = (ListView) this.f4392d.inflate(R.layout.os_prompt_dialog_list_compat, (ViewGroup) this.f4395g, false).findViewById(R.id.os_damp_list_view_compat);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(onItemClickListener);
        listView.setDivider(null);
        return listView;
    }

    public final RecyclerView s(RecyclerView.Adapter<?> adapter, AdapterView.OnItemClickListener onItemClickListener) {
        View viewInflate = this.f4392d.inflate(R.layout.os_prompt_dialog_list, (ViewGroup) this.f4395g, false);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.os_damp_list_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.f4389a, 1, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        if (adapter instanceof RecyclerAdapter) {
            ((RecyclerAdapter) adapter).f(onItemClickListener);
            if (adapter instanceof l) {
                l lVar = (l) adapter;
                this.f4402n = lVar;
                lVar.l(this);
            }
        }
        recyclerView.setAdapter(adapter);
        g6.b bVarJ = g6.d.j(recyclerView, 0, false);
        View viewFindViewById = viewInflate.findViewById(R.id.os_damp_list_view_parent);
        if ((viewFindViewById instanceof OSScrollbarLayout) && bVarJ != null) {
            OSScrollbarLayout oSScrollbarLayout = (OSScrollbarLayout) viewFindViewById;
            oSScrollbarLayout.setOverScrollView(recyclerView);
            bVarJ.h(new h(oSScrollbarLayout));
        }
        return recyclerView;
    }

    public Button t(int i10) {
        if (i10 == -3) {
            return this.C;
        }
        if (i10 == -2) {
            return this.f4413y;
        }
        if (i10 != -1) {
            return null;
        }
        return this.f4409u;
    }

    public CheckedTextView u() {
        return this.f4401m;
    }

    public boolean v() {
        return this.I;
    }

    public final RelativeLayout.LayoutParams w() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, R.id.os_module_dialog_damping_layout_title);
        return layoutParams;
    }

    public final RelativeLayout.LayoutParams x() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, R.id.os_module_dialog_damping_layout_content);
        return layoutParams;
    }

    public final RelativeLayout.LayoutParams y() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(10);
        return layoutParams;
    }

    public View z() {
        return this.f4400l;
    }
}
