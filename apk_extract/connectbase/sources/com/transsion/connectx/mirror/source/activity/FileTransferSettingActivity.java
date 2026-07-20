package com.transsion.connectx.mirror.source.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.transsion.connectx.mirror.source.R;
import k4.m;
import m5.g1;

/* JADX INFO: loaded from: classes2.dex */
public class FileTransferSettingActivity extends Activity {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f1927b = "FileTransferSettingActivity";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f1928a;

    public final String c() {
        return getSharedPreferences("fileConfig", 0).getString("savePath", g1.c("receiveFile"));
    }

    public final /* synthetic */ void d(View view) {
        f();
    }

    public final /* synthetic */ void e(View view) {
        g(this.f1928a.getText().toString());
        finish();
    }

    public final void f() {
        startActivityForResult(new Intent("android.intent.action.OPEN_DOCUMENT_TREE"), 1);
    }

    public final void g(String str) {
        SharedPreferences.Editor editorEdit = getSharedPreferences("fileConfig", 0).edit();
        editorEdit.putString("savePath", str);
        editorEdit.apply();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (intent == null) {
            return;
        }
        String path = intent.getData().getPath();
        String strC = g1.c(path.substring(path.indexOf(":") + 1));
        this.f1928a.setText(strC);
        m.b(f1927b, strC);
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_file_transfer_setting);
        this.f1928a = (TextView) findViewById(R.id.tv_title);
        findViewById(R.id.bt_choose_path).setOnClickListener(new View.OnClickListener() { // from class: x4.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f20039a.f();
            }
        });
        findViewById(R.id.btn_save).setOnClickListener(new View.OnClickListener() { // from class: x4.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f20040a.e(view);
            }
        });
        this.f1928a.setText(c());
    }
}
