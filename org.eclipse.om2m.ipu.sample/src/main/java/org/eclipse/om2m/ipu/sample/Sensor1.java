/**
 * AWT Sample application
 *
 * @author 
 * @version 1.00 17/06/01
 */
 
package org.eclipse.om2m.ipu.sample;
 
 
	
public class Sensor1 {
    public static void start() {
    	Thread t1 = new Light();
    	Thread t2 = new Temperature();
        myServer server = new myServer();
        int i;
        String deskId;
    	t1.start();
    	t2.start();
        server.start();
        System.out.println("\n\n\n\nSensor Start!!\n\n\n");
        while(true)
        {
            for(i=0; i<5; i++)
            {
                deskId = Desk.TYPE+"_"+i;
                SampleMonitor.setDeskState(deskId);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {}
            }
        }
    }
}

