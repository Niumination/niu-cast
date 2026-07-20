package com.transsion.connectx.mirror.source.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.transsion.connectx.mirror.source.R;
import com.transsion.connectx.mirror.source.SourceApplication;
import com.transsion.connectx.mirror.source.activity.CastSettingActivity;
import com.transsion.connectx.mirror.source.service.SourceService;
import p5.m0;
import w4.c;
import w4.l1;
import x4.d;
import x4.f;
import x4.g;
import z4.e;

/* JADX INFO: loaded from: classes2.dex */
public class CastSettingActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Intent f1898a;

    public class a implements ServiceConnection {
        public a(CastSettingActivity castSettingActivity) {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static void j(View view) {
        l1.h.f18073a.J1();
    }

    public static /* synthetic */ void k(EditText editText, View view) {
        m0.f12861a.x(editText.getText().toString(), l1.S);
    }

    public static void l(View view) {
        l1 l1Var = l1.h.f18073a;
        l1Var.W(c.q());
        l1Var.a0(c.p(SourceApplication.b(), "phone_mirror_pad"));
    }

    public static void m(View view) {
        l1 l1Var = l1.h.f18073a;
        l1Var.W(c.q());
        l1Var.Y(c.p(SourceApplication.b(), e.f21818e));
    }

    public static void n(View view) {
        l1.h.f18073a.L1();
    }

    public static /* synthetic */ void o(View view) {
        m0.f12861a.I();
    }

    public static void p(View view) {
        l1.h.f18073a.M1();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @b.a({"MissingInflatedId"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_cast_setting);
        getApplicationContext().bindService(new Intent(getApplicationContext(), (Class<?>) SourceService.class), new a(), 1);
        final EditText editText = (EditText) findViewById(R.id.peer_ip);
        findViewById(R.id.start_tccp).setOnClickListener(new x4.a());
        findViewById(R.id.connect_tccp).setOnClickListener(new View.OnClickListener() { // from class: x4.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CastSettingActivity.k(editText, view);
            }
        });
        findViewById(R.id.open_screen).setOnClickListener(new x4.c());
        findViewById(R.id.open_extend).setOnClickListener(new d());
        findViewById(R.id.close_screen).setOnClickListener(new x4.e());
        findViewById(R.id.close_tccp).setOnClickListener(new f());
        findViewById(R.id.tear_down).setOnClickListener(new g());
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Intent intent = this.f1898a;
        if (intent != null) {
            stopService(intent);
            this.f1898a = null;
        }
    }
}
