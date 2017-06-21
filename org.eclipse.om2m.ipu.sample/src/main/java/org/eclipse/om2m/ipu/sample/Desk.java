package org.eclipse.om2m.ipu.sample;

/*
import org.eclipse.om2m.commons.obix.Bool;
import org.eclipse.om2m.commons.obix.Contract;
import org.eclipse.om2m.commons.obix.Obj;
import org.eclipse.om2m.commons.obix.Op;
import org.eclipse.om2m.commons.obix.Str;
import org.eclipse.om2m.commons.obix.Uri;
*/
import org.eclipse.om2m.commons.obix.io.ObixEncoder;
import org.eclipse.om2m.commons.obix.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class Desk {
    /** Logger */
    private static Log LOGGER = LogFactory.getLog(Desk.class);
    /** Application point of contact for the desk controller {@link SampleController} */
    public final static String APOCPATH = "desks";
    /** Default Desks location */
    public final static String LOCATION = "Home";
    /** Toggle */
    public final static String TOGGLE = "toggle";
    /** Default Desks type */
    public final static String TYPE = "DESK";
    /** Desk state */
    private boolean state = false;
    /** Desk Height*/
    private int height = 0;
    /** Desk temperature 'C*/
    private int temp = 0;
    /** Desk has socket */
    private boolean socket = false;
    /** Desk brightness*/
    private int bright = 0;
    /** Desk seatNumber*/
    private int seatNum = 0;

    /**
     * @param sclId - SclBase id
     * @param appId - Application Id
     * @param stateCont - the STATE container id
     * @return Obix XML representation
     */
    
    public static String getDescriptorRep(String sclId, String appId, String stateCont) {
        LOGGER.info("Descriptor Representation Construction");
        // oBIX
        Obj obj = new Obj();
        obj.add(new Str("type",TYPE));
        obj.add(new Str("location",LOCATION));
        obj.add(new Str("appId",appId));
        // OP GetState from SCL DataBase
        Op opState = new Op();
        opState.setName("getState");
        opState.setHref(new Uri(sclId+"/"+"applications/"+appId+"/containers/"+stateCont+"/contentInstances/latest/content"));
        opState.setIs(new Contract("retrieve"));
        opState.setIn(new Contract("obix:Nil"));
        opState.setOut(new Contract("obix:Nil"));
        obj.add(opState);
        // OP GetState from SCL IPU
        Op opStateDirect = new Op();
        opStateDirect.setName("getState(Direct)");
        opStateDirect.setHref(new Uri(sclId+"/"+"applications/"+appId+"/"+APOCPATH));
        opStateDirect.setIs(new Contract("retrieve"));
        opStateDirect.setIn(new Contract("obix:Nil"));
        opStateDirect.setOut(new Contract("obix:Nil"));
        obj.add(opStateDirect);
        // OP SwitchON
        Op opON = new Op();
        opON.setName("switchON");
        opON.setHref(new Uri(sclId+"/"+"applications/"+appId+"/"+APOCPATH+"/true"));
        opON.setIs(new Contract("execute"));
        opON.setIn(new Contract("obix:Nil"));
        opON.setOut(new Contract("obix:Nil"));
        obj.add(opON);
        // OP SwitchOFF
        Op opOFF = new Op();
        opOFF.setName("switchOFF");
        opOFF.setHref(new Uri(sclId+"/"+"applications/"+appId+"/"+APOCPATH+"/false"));
        opOFF.setIs(new Contract("execute"));
        opOFF.setIn(new Contract("obix:Nil"));
        opOFF.setOut(new Contract("obix:Nil"));
        obj.add(opOFF);
        // OP Toggle
        Op opToggle = new Op();
        opToggle.setName("toggle");
        opToggle.setHref(new Uri(sclId+"/"+"applications/"+appId+"/"+APOCPATH+"/"+TOGGLE));
        opToggle.setIs(new Contract("execute"));
        opToggle.setIn(new Contract("obix:Nil"));
        opToggle.setOut(new Contract("obix:Nil"));
        obj.add(opToggle);

        return ObixEncoder.toString(obj);
    }

    /**
     * Returns an obix XML representation describing the current state.
     * @param appId - Application Id
     * @param value - current lamp state
     * @return Obix XML representation
     */
    public static String getStateRep(String appId, boolean state, int temp, int height, int seatNum, int bright, boolean socket) {
        // oBIX
        Obj obj = new Obj();
        obj.add(new Str("type",TYPE));
        obj.add(new Str("location",LOCATION));
        obj.add(new Str("appId",appId));
        obj.add(new Bool("state",state));
        obj.add(new Int("temperature", temp));
        obj.add(new Int("height", height));
        obj.add(new Int("seat number", seatNum));
        obj.add(new Int("brightness", bright));
        obj.add(new Bool("has socket", socket));
        return ObixEncoder.toString(obj);

    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getHeight(){
        return height;
    }

    public void setHeight(int height){
        this.height = height;
    }
    
    public boolean getSocket() {
        return socket;
    }

    public void setSocket(boolean socket) {
        this.socket = socket;
    }

    public int getBright() {
        return bright;
    }
    
    public void setBright(int bright) {
        this.bright = bright;
    }

    public int getSeatNumber() {
        return seatNum;
    }

    public void setSeatNumber(int seatNum) {
        this.seatNum = seatNum;
    }

    public int getTemperature() {
        return temp;
    }

    public void setTemperature(int temp) {
        this.temp = temp;
    }
}
