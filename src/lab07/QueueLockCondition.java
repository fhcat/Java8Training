package lab07;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by shenv on 4/20/2017.
 */
public class QueueLockCondition implements SynchronizedQueue {
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private Condition vAdded = lock.writeLock().newCondition();

    private Element first, last;
    private int curSize, maxSize;

    public QueueLockCondition(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public void put(Object object) throws InterruptedException {
        lock.writeLock().lock();
        try {
            while (this.curSize == maxSize) {
                vAdded.await();
            }

            if (this.first == null) {
                this.first = (this.last = new Element(object));
            } else {
                this.last = (this.last.next = new Element(object));
            }

            this.curSize++;
            vAdded.signalAll();
        } catch (InterruptedException giveup) {

        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public Object get() throws InterruptedException {
        Object o = null;
        lock.writeLock().lock();
        try {
            while (this.curSize == 0) {
                vAdded.await();
            }

            o = this.first.value;
            this.first = this.first.next;
            this.curSize--;
            vAdded.signalAll();
        } catch (InterruptedException giveup) {
        } finally {
            lock.writeLock().unlock();
        }
        return o;
    }

    private static class Element {
        final Object value;
        Element next;

        Element(Object value) {
            this.value = value;
        }
    }
}
