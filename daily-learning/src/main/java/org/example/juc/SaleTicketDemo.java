package org.example.juc;

/**
 * @author: hanchaowei
 * @date 2023/3/8
 * @description: 三个售货员卖30张票
 */

public class SaleTicketDemo {
}

class Ticket {
	private int number = 30;

	public  void saleTicket() {
		if (number > 0) {
			System.out.println(Thread.currentThread().getName() + "\t 卖出第：" + (number--) + "\t 还剩下：" + number);
		}
	}

	public static void main(String[] args) {
		Ticket ticket = new Ticket();
		// A窗口
		new Thread(() -> {
			for (int i = 0; i < 30; i++) {
				ticket.saleTicket();
			}
		},"窗口A").start();
		// B窗口
		new Thread(() -> {
			for (int i = 0; i < 30; i++) {
				ticket.saleTicket();
			}
		},"窗口B").start();
		// C窗口
		new Thread(() -> {
			for (int i = 0; i < 30; i++) {
				ticket.saleTicket();
			}
		},"窗口C").start();
	}
}