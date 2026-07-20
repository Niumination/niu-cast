package nd;

import android.graphics.drawable.Drawable;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.widgetslib.flipper.DefaultAdapter;
import com.transsion.widgetslib.flipper.FlipperLayout;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends Lambda implements Function0 {
    final /* synthetic */ List<Drawable> $drawableList;
    final /* synthetic */ FlipperLayout this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(List<Drawable> list, FlipperLayout flipperLayout) {
        super(0);
        this.$drawableList = list;
        this.this$0 = flipperLayout;
    }

    @Override // kotlin.jvm.functions.Function0
    public final RecyclerView.Adapter<RecyclerView.ViewHolder> invoke() {
        DefaultAdapter defaultAdapter = new DefaultAdapter(this.$drawableList);
        this.this$0.f3062n = defaultAdapter;
        return defaultAdapter;
    }
}
