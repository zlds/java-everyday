package org.example.gof.bridgingpattern.geektime.v1;

import java.util.List;

/**
 * @author: hanchaowei
 * @date 2023/5/3
 * @description: v1版本中所有的通知方式都写在一个类中，如果后续有新的通知方式，需要修改这个类，违反了开闭原则。
 */

public class Notificaton {
	private List<String> emailAddresses;
	private List<String> telephones;
	private List<String> wechatIds;

	public void setEmailAddresses(List<String> emailAddresses) {
		this.emailAddresses = emailAddresses;
	}

	public void setTelephones(List<String> telephones) {
		this.telephones = telephones;
	}

	public void setWechatIds(List<String> wechatIds) {
		this.wechatIds = wechatIds;
	}

	/**
	 * 发送通知
	 * @param level
	 * @param message
	 */
	public void notify(NotificationEmergencyLevel level,String message) {
		if (level.equals(NotificationEmergencyLevel.SEVERE)) {
			//...自动语音电话
		} else if (level.equals(NotificationEmergencyLevel.URGENCY)) {
			//...发微信
		} else if (level.equals(NotificationEmergencyLevel.NORMAL)) {
			//...发邮件
		} else if (level.equals(NotificationEmergencyLevel.TRIVIAL)) {
			//...发邮件
		}
	}
}
