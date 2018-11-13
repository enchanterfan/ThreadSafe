package JavaDemo.thread_de;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 线程安全演示类
 * Created by captain on 2017/7/27.
 */
public class ThreadSafeDemo1 implements Runnable{

    private List<String> list;

    public ThreadSafeDemo1(List<String> list){
        this.list = list;
    }

    @Override
    public void run() {
        Random random = new Random();
        System.out.println("线程："+ random.nextInt());
        synchronized(this){
            Iterator<String> iterator = list.iterator();
            int cnt = 0;
            String a = null;
            while(iterator.hasNext()){
                a = iterator.next();
                list.remove(a);
//            	list.remove(iterator.next());
                cnt++;
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("移除元素的数量："+cnt);
        }
    }
}
