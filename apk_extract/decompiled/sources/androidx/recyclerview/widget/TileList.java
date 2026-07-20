package androidx.recyclerview.widget;

import android.util.SparseArray;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes.dex */
class TileList<T> {
    Tile<T> mLastAccessedTile;
    final int mTileSize;
    private final SparseArray<Tile<T>> mTiles = new SparseArray<>(10);

    public static class Tile<T> {
        public int mItemCount;
        public final T[] mItems;
        Tile<T> mNext;
        public int mStartPosition;

        public Tile(Class<T> cls, int i8) {
            this.mItems = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i8));
        }

        public boolean containsPosition(int i8) {
            int i9 = this.mStartPosition;
            return i9 <= i8 && i8 < i9 + this.mItemCount;
        }

        public T getByPosition(int i8) {
            return this.mItems[i8 - this.mStartPosition];
        }
    }

    public TileList(int i8) {
        this.mTileSize = i8;
    }

    public Tile<T> addOrReplace(Tile<T> tile) {
        int iIndexOfKey = this.mTiles.indexOfKey(tile.mStartPosition);
        if (iIndexOfKey < 0) {
            this.mTiles.put(tile.mStartPosition, tile);
            return null;
        }
        Tile<T> tileValueAt = this.mTiles.valueAt(iIndexOfKey);
        this.mTiles.setValueAt(iIndexOfKey, tile);
        if (this.mLastAccessedTile == tileValueAt) {
            this.mLastAccessedTile = tile;
        }
        return tileValueAt;
    }

    public void clear() {
        this.mTiles.clear();
    }

    public Tile<T> getAtIndex(int i8) {
        return this.mTiles.valueAt(i8);
    }

    public T getItemAt(int i8) {
        Tile<T> tile = this.mLastAccessedTile;
        if (tile == null || !tile.containsPosition(i8)) {
            int iIndexOfKey = this.mTiles.indexOfKey(i8 - (i8 % this.mTileSize));
            if (iIndexOfKey < 0) {
                return null;
            }
            this.mLastAccessedTile = this.mTiles.valueAt(iIndexOfKey);
        }
        return this.mLastAccessedTile.getByPosition(i8);
    }

    public Tile<T> removeAtPos(int i8) {
        Tile<T> tile = this.mTiles.get(i8);
        if (this.mLastAccessedTile == tile) {
            this.mLastAccessedTile = null;
        }
        this.mTiles.delete(i8);
        return tile;
    }

    public int size() {
        return this.mTiles.size();
    }
}
