package b;

import android.content.Context;
import androidx.activity.ComponentActivity;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements OnContextAvailableListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f1163b;

    public /* synthetic */ c(ComponentActivity componentActivity, int i8) {
        this.f1162a = i8;
        this.f1163b = componentActivity;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public final void onContextAvailable(Context context) {
        int i8 = this.f1162a;
        ComponentActivity componentActivity = this.f1163b;
        switch (i8) {
            case 0:
                ComponentActivity._init_$lambda$5(componentActivity, context);
                break;
            default:
                ((FragmentActivity) componentActivity).lambda$init$3(context);
                break;
        }
    }
}
