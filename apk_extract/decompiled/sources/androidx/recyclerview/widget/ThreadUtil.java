package androidx.recyclerview.widget;

/* JADX INFO: loaded from: classes.dex */
interface ThreadUtil<T> {

    public interface BackgroundCallback<T> {
        void loadTile(int i8, int i9);

        void recycleTile(TileList.Tile<T> tile);

        void refresh(int i8);

        void updateRange(int i8, int i9, int i10, int i11, int i12);
    }

    public interface MainThreadCallback<T> {
        void addTile(int i8, TileList.Tile<T> tile);

        void removeTile(int i8, int i9);

        void updateItemCount(int i8, int i9);
    }

    BackgroundCallback<T> getBackgroundProxy(BackgroundCallback<T> backgroundCallback);

    MainThreadCallback<T> getMainThreadProxy(MainThreadCallback<T> mainThreadCallback);
}
