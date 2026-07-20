package c5;

import android.app.Application;
import android.content.Intent;
import com.transsion.connectx.mirror.source.SourceApplication;
import com.transsion.connectx.mirror.source.activity.ExtendScreenActivity;
import k4.u;
import p2.f;
import v4.g;

/* JADX INFO: loaded from: classes2.dex */
public class b implements ji.a<Object> {
    @Override // ji.a
    public Short a() {
        return Short.valueOf(g.M);
    }

    @Override // ji.a
    public void b(Object obj) {
        f fVar = (f) ji.a.f8709a.a(String.valueOf(obj), f.class);
        if (fVar != null) {
            Application applicationB = SourceApplication.b();
            Intent intent = new Intent(applicationB, (Class<?>) ExtendScreenActivity.class);
            intent.setFlags(268435456);
            intent.putExtra(ExtendScreenActivity.f1899y, fVar);
            applicationB.startActivity(intent);
            u.a.f8983a.e();
        }
    }
}
