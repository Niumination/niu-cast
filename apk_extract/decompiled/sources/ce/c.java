package ce;

import android.os.Message;
import android.view.View;
import android.widget.BaseAdapter;
import com.transsion.widgetslib.widget.FootOperationBar;
import com.transsion.widgetslib.widget.editext.OSMaterialEditText;
import com.transsion.widgetslib.widget.tablayout.OSTabLayout;
import ld.j;
import zd.g;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1464b;

    public /* synthetic */ c(BaseAdapter baseAdapter, int i8, int i9) {
        this.f1463a = i9;
        this.f1464b = baseAdapter;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Message messageObtain;
        Message message;
        Message message2;
        Message message3;
        Object obj = this.f1464b;
        switch (this.f1463a) {
            case 0:
                ((OSMaterialEditText) obj).e.setText("");
                break;
            case 1:
                ge.c cVar = (ge.c) obj;
                OSTabLayout oSTabLayout = cVar.f5166a;
                int i8 = OSTabLayout.p;
                oSTabLayout.getClass();
                cVar.f5166a.e.dismiss();
                break;
            case 2:
                j jVar = (j) obj;
                if (view == jVar.f7394v && (message3 = jVar.f7396x) != null) {
                    messageObtain = Message.obtain(message3);
                } else if (view != jVar.f7398z || (message2 = jVar.B) == null) {
                    messageObtain = (view != jVar.D || (message = jVar.F) == null) ? null : Message.obtain(message);
                } else {
                    messageObtain = Message.obtain(message2);
                }
                if (messageObtain != null) {
                    messageObtain.sendToTarget();
                }
                if (jVar.H) {
                    jVar.e.obtainMessage(1, jVar.f7379b).sendToTarget();
                }
                break;
            default:
                g gVar = (g) obj;
                FootOperationBar footOperationBar = gVar.f11288a;
                int i9 = FootOperationBar.H;
                footOperationBar.getClass();
                gVar.f11288a.f3371c.dismiss();
                break;
        }
    }

    public /* synthetic */ c(Object obj, int i8) {
        this.f1463a = i8;
        this.f1464b = obj;
    }
}
