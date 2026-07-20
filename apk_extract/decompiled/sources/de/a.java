package de;

import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import com.transsion.widgetslib.widget.elasticitylistView.ElasticityListView;
import pd.b;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements AbsListView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4428a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ElasticityListView f4429b;

    public a(ElasticityListView elasticityListView) {
        this.f4429b = elasticityListView;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i8, int i9, int i10) {
        ElasticityListView elasticityListView = this.f4429b;
        elasticityListView.f3522c = i8;
        elasticityListView.f3523d = i9;
        AbsListView.OnScrollListener onScrollListener = elasticityListView.f3525i;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i8, i9, i10);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i8) {
        ElasticityListView elasticityListView = this.f4429b;
        if (i8 == 0 && this.f4428a == 2) {
            int i9 = ElasticityListView.f3519l;
            if (elasticityListView.b()) {
                elasticityListView.f3520a = 0.0f;
                elasticityListView.f3521b = 1.02f;
            }
            if (elasticityListView.c()) {
                elasticityListView.f3520a = elasticityListView.getMeasuredHeight();
                elasticityListView.f3521b = 1.02f;
            }
            float f = elasticityListView.f3521b;
            if (f != 1.0f) {
                b bVar = elasticityListView.f3527k;
                float f4 = elasticityListView.f3520a;
                bVar.f8719b = elasticityListView;
                bVar.e = 1.0f;
                bVar.f = f;
                bVar.f8722g = f4;
                long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                bVar.f8718a = 2;
                bVar.f8720c = jCurrentAnimationTimeMillis;
                bVar.f8721d = 150.0f;
                elasticityListView.f3521b = 1.0f;
                elasticityListView.invalidate();
            }
        }
        this.f4428a = i8;
        AbsListView.OnScrollListener onScrollListener = elasticityListView.f3525i;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i8);
        }
    }
}
