/**
 * @(#)Light.java
 *
 *
 * @author 
 * @version 1.00 2017/6/1
 */

package org.eclipse.om2m.ipu.sample;

	public class Light extends Thread{
		static int light;
        int i;
		public void run(){
            while(true)
            {
                for(i=0; i<5; i++){
        	        light = (int) (Math.random() * 5);
                    Desk curr = SampleMonitor.DESKS.get(Desk.TYPE+"_"+i);
                    curr.setBright(light);
        	        // System.out.println(light);
                }
        	    try{
                    Thread.sleep(3000);
        	    } catch(InterruptedException ie){}
            }
		}
	}
