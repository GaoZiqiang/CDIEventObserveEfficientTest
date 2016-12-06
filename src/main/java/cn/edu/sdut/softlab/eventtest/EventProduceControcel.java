package cn.edu.sdut.softlab.eventtest;

import javax.enterprise.context.RequestScoped;
/**

* 事件生产者
*

* @author GaoZiqiang

* @Time 2016-11-18

*

*/
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Event的触发控制类
 * 
 * @author gaoziqiang
 *
 */
@Named("producer")
@RequestScoped
public class EventProduceControcel {

	@Inject
	@IntEvent
	Event<Integer> intEvent;
	// fire次数
	private int num;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	// 事件生产者通过调用fire()方法,并传递"事件对象"从而激活事件处理.
	public void produce() {
		System.out.println("fire次数" + num + "次");// 后台打印查看fire的次数
		for (int i = 0; i < num; i++) {
			intEvent.fire(new Integer(i));// fire()方法的参数是个对象
		}
	}

}
