/**
 * @(#)Temperature.java
 *
 *
 * @author 
 * @version 1.00 2017/6/1
 */
package org.eclipse.om2m.ipu.sample;


public class Temperature extends Thread{
	int temp = 0;
    int i;
    public void run(){
        while(true)
        {
            for(i=0; i<5; i++){
                temp = (int) (Math.random() * 3 + 26);
                Desk curr = SampleMonitor.DESKS.get(Desk.TYPE+"_"+i);
                curr.setTemperature(temp);
                // System.out.println(temp);
            }
            try{
                Thread.sleep(3000);
            } catch(InterruptedException ie){}
        }
    }
    
}
