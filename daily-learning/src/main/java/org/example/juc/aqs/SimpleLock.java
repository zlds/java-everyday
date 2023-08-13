package org.example.juc.aqs;


import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author: hanchaowei
 * @date 2023/8/13
 * @description: 通过AQS实现简单的锁
 */

public class SimpleLock {

	private final Sync sync = new Sync();

	private static class Sync extends AbstractQueuedSynchronizer {
		// 检查当前线程是否持有锁
		protected boolean isHeldExclusively() {
			return getState() == 1;
		}
		// 尝试获取锁,当状态为0时，表示没有线程持有锁。通过CAS设置状态为1，表示获取锁成功
		public boolean tryAcquire(int acquires) {
			if (compareAndSetState(0,1)) {
				setExclusiveOwnerThread(Thread.currentThread());
				return true;
			}
			return false;
		}

		// 释放锁,将持有锁的线程设置为null，将状态设置为0
		protected boolean tryRelease(int release) {
			setExclusiveOwnerThread(null);
			setState(0);
			return true;
		}
	}

	public void lock() {
		sync.acquire(1);
	}

	public void unlock() {
		sync.release(1);
	}

	public static void main(String[] args) {
		SimpleLock simpleLock = new SimpleLock();
		simpleLock.lock();
		System.out.println("lock");
		simpleLock.unlock();
		System.out.println("unlock");
	}
}
