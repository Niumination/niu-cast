package com.transsion.connectx.mirror.source.activity;

import a6.s;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.transsion.connectx.mirror.source.R;
import com.transsion.connectx.mirror.source.pad.view.ShortCutTextView;
import k4.m;
import kn.l0;
import kn.w;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
public final class ShortCutHelperActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final a f1929a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public static final String f1930b = "ShortCutHelperActivity";

    public static final class a {
        public a() {
        }

        public final void a(@l Context context) {
            l0.p(context, "context");
            m.e(ShortCutHelperActivity.f1930b, "goToShortCutHelperActivity");
            Intent intent = new Intent(context, (Class<?>) ShortCutHelperActivity.class);
            intent.setFlags(268435456);
            context.startActivity(intent);
        }

        public a(w wVar) {
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@os.m Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_short_cut_helper);
        ShortCutTextView shortCutTextView = (ShortCutTextView) findViewById(R.id.short_cut_more_line_1);
        if (shortCutTextView != null) {
            String strA = s.a(R.string.pad_more_task);
            l0.o(strA, "getXmlString(...)");
            shortCutTextView.a(strA, s.a(R.string.pad_mouse_middle) + "\n" + s.a(R.string.pad_short_cut_3), "/");
        }
    }
}
