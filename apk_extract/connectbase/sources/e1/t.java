package e1;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@i
public interface t<K, V> {
    long getAccessTime();

    int getHash();

    @gm.a
    K getKey();

    @gm.a
    t<K, V> getNext();

    t<K, V> getNextInAccessQueue();

    t<K, V> getNextInWriteQueue();

    t<K, V> getPreviousInAccessQueue();

    t<K, V> getPreviousInWriteQueue();

    @gm.a
    m.a0<K, V> getValueReference();

    long getWriteTime();

    void setAccessTime(long time);

    void setNextInAccessQueue(t<K, V> next);

    void setNextInWriteQueue(t<K, V> next);

    void setPreviousInAccessQueue(t<K, V> previous);

    void setPreviousInWriteQueue(t<K, V> previous);

    void setValueReference(m.a0<K, V> valueReference);

    void setWriteTime(long time);
}
