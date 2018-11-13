package JavaDemo.thread_de;

import java.util.List;

/**
 * 线程安全演示类
 * Created by captain on 2017/7/27.
 */
public class ThreadSafeDemo3 implements Runnable{

    private List<String> list;

    public ThreadSafeDemo3(List<String> list){
        this.list = list;
    }

    @Override
    public void run() {
    	synchronized(this){
        while(true){
            if(list.size()>0){
                list.remove(0);
                System.out.println("删除一个后尺寸："+list.size());
                try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        	}
    	}
    }
}
