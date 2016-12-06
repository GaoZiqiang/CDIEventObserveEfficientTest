package cn.edu.sdut.softlab.eventtest;

import javax.enterprise.context.RequestScoped;
/**

* 事件观察者
* 一个观察者的处理方式是在方法中,加入一个参数注解@Observes

* @author GaoZiqiang

* @Time 2016-11-18

*

*/
import javax.enterprise.event.Observes;
import javax.inject.Named;

/**
 * Event的Observe类
 * 
 * @author gaoziqiang
 *
 */
@Named("listener")
@RequestScoped
public class EventObserve {
	// 带注解的参数称为事件参数。事件的参数类型是观察到的事件类型
	// 监听次数
	private int observeTime;
	// 监听所有事件的总时间
	private long totalObserveTime;

	long endTime;

	public long getTotalObserveTime() {
		return totalObserveTime;
	}

	public void setTotalObserveTime(long totalObserveTime) {
		this.totalObserveTime = totalObserveTime;
	}

	public int getObserveTime() {
		return observeTime;
	}

	public void setObserveTime(int observeTime) {
		this.observeTime = observeTime;
	}

	long startTime = System.currentTimeMillis();

	public void onWalk(@Observes Integer intEvent) {// 不能同时有多个@Observes
		// System.out.println("监听器已经响应......");
		observeTime++;// 每监听一次，observeTime+1
		endTime = System.currentTimeMillis();
		totalObserveTime = (endTime - startTime) + totalObserveTime;
		// System.out.println(totalObserveTime + "毫秒");
	}

}
