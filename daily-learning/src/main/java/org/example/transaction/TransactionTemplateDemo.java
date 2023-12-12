package org.example.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @author: hanchaowei
 * @date 2023/12/12
 * @description:
 */
@Service
public class TransactionTemplateDemo {
	/**
	 * 在大多数情况下使用@Transactional注解就足够了，但是在某些情况下，我们可能需要更加精细的控制事务，这时候我们就可以使用TransactionTemplate来实现。
	 * 代码中显式开启事务，提供了更细粒度的控制，允许在更复杂的逻辑中精确管理事务。
	 * TransactionTemplate可以做到动态决定事务提交或回滚(满足某个条件提交，或者根据不同类型的异常来决定不同的回滚策略)，而不是像声明式事务那样，只能在方法开始时或者结束时进行事务的提交或回滚。
	 */

	@Autowired
	private TransactionTemplate transactionTemplate;


	public void processOrder(String s) {
		transactionTemplate.execute(new TransactionCallback<Void>() {
			@Override
			public Void doInTransaction(TransactionStatus transactionStatus) {
				try {
					// 创建订单
					createOrder(s);
					// 更新库存
					updateInventory(s);
					// 事务自动提交
				} catch (Exception e) {
					// 事务回滚
					transactionStatus.setRollbackOnly();
					e.printStackTrace();
				}
				return null;
			}
		});
	}


	public void createOrder(String s) {
		System.out.println("创建订单: " + s);
	}

	public void updateInventory(String s) {
		System.out.println("更新库存: " + s);
	}

	public static void main(String[] args) {
		TransactionTemplateDemo transactionTemplateDemo = new TransactionTemplateDemo();
		transactionTemplateDemo.processOrder("123");
	}

}
