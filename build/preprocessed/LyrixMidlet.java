/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Vector;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.rms.RecordStoreException;

/**
 * @author patrik
 * 
 * så, vad är nu detta?
 * Lyrix är ett mobil program för att söka och läsa musik texter
 * Programmet kopplar upp sig mot en mot en databas för att sedan få tillgång
 * musik texter, dessa texter visas sedan. Programmet lagrar även sökningar, 
 * dock endast sökorden och max 10 poster(fler poster kan lagras i minnet under
 * körningen men inte i RecordStore). 
 * PS: ganska kasst att ha readme i källkoden...
 * Observera!! Programmet använder sig av en temporär och begränsad nyckel,
 * detta medför att visningen är begränsad och aningen slumpartad (det är en 
 * prototyp)
 * Den nuvarande nyckeln håller endast till söndagen den 9 nov
 * 
 * en ny nyckel hittas här: http://lyricsfly.com/api/
 * bara att ändra Strängen "key"(den översta) för att föra in en ny nyckel
 * 
 */

public class LyrixMidlet extends MIDlet implements CommandListener {
    private String key="8fb5e64c6a6626298-temporary.API.access";
    private boolean midletPaused = false;
    private HttpUtil httpUtil;
    private RecordUtil recUtil;
    private Vector searches;
    private String recordStoreName = this.getAppProperty("RecordStoreName");
    private String baseUrl = "http://lyricsfly.com/api/api.php?i="+key;
//<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
private List list;
private Form seatchform;
private TextField artistTf;
private TextField songTF;
private TextBox textTB;
private List searchList;
private Command exitCommand;
private Command okCommand;
private Command exitCommand1;
private Command backCommand;
private Command backCommand1;
private Command startC;
private Command okCommand1;
private Command backCommand2;
//</editor-fold>//GEN-END:|fields|0|

    /**
     * The LyrixMidlet constructor.
     */
    public LyrixMidlet() {
        
        httpUtil = new HttpUtil(baseUrl);
        recUtil = new RecordUtil(recordStoreName);
        
        try {
            searches = recUtil.load();
        } catch (RecordStoreException ex) {
            ex.printStackTrace();
        }
        httpUtil.httpPassQuery();
    }

//<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
//</editor-fold>//GEN-END:|methods|0|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize
/**
 * Initilizes the application.
 * It is called only once when the MIDlet is started. The method is called before the <code>startMIDlet</code> method.
 */
private void initialize () {//GEN-END:|0-initialize|0|0-preInitialize
        // write pre-initialize user code here
//GEN-LINE:|0-initialize|1|0-postInitialize
        // write post-initialize user code here
}//GEN-BEGIN:|0-initialize|2|
//</editor-fold>//GEN-END:|0-initialize|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
/**
 * Performs an action assigned to the Mobile Device - MIDlet Started point.
 */
public void startMIDlet () {//GEN-END:|3-startMIDlet|0|3-preAction
        // write pre-action user code here
switchDisplayable (null, getList ());//GEN-LINE:|3-startMIDlet|1|3-postAction
        // write post-action user code here
}//GEN-BEGIN:|3-startMIDlet|2|
//</editor-fold>//GEN-END:|3-startMIDlet|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: resumeMIDlet ">//GEN-BEGIN:|4-resumeMIDlet|0|4-preAction
/**
 * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
 */
public void resumeMIDlet () {//GEN-END:|4-resumeMIDlet|0|4-preAction
        // write pre-action user code here
//GEN-LINE:|4-resumeMIDlet|1|4-postAction
        // write post-action user code here
}//GEN-BEGIN:|4-resumeMIDlet|2|
//</editor-fold>//GEN-END:|4-resumeMIDlet|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|5-switchDisplayable|0|5-preSwitch
/**
 * Switches a current displayable in a display. The <code>display</code> instance is taken from <code>getDisplay</code> method. This method is used by all actions in the design for switching displayable.
 * @param alert the Alert which is temporarily set to the display; if <code>null</code>, then <code>nextDisplayable</code> is set immediately
 * @param nextDisplayable the Displayable to be set
 */
public void switchDisplayable (Alert alert, Displayable nextDisplayable) {//GEN-END:|5-switchDisplayable|0|5-preSwitch
        // write pre-switch user code here
Display display = getDisplay ();//GEN-BEGIN:|5-switchDisplayable|1|5-postSwitch
if (alert == null) {
display.setCurrent (nextDisplayable);
} else {
display.setCurrent (alert, nextDisplayable);
}//GEN-END:|5-switchDisplayable|1|5-postSwitch
        // write post-switch user code here
}//GEN-BEGIN:|5-switchDisplayable|2|
//</editor-fold>//GEN-END:|5-switchDisplayable|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Displayables ">//GEN-BEGIN:|7-commandAction|0|7-preCommandAction
/**
 * Called by a system to indicated that a command has been invoked on a particular displayable.
 * @param command the Command that was invoked
 * @param displayable the Displayable where the command was invoked
 */
public void commandAction (Command command, Displayable displayable) {//GEN-END:|7-commandAction|0|7-preCommandAction
 // write pre-action user code here
if (displayable == list) {//GEN-BEGIN:|7-commandAction|1|15-preAction
if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|1|15-preAction
 // write pre-action user code here
listAction ();//GEN-LINE:|7-commandAction|2|15-postAction
 // write post-action user code here
} else if (command == exitCommand) {//GEN-LINE:|7-commandAction|3|20-preAction
 // write pre-action user code here
exitMIDlet ();//GEN-LINE:|7-commandAction|4|20-postAction
 // write post-action user code here
}//GEN-BEGIN:|7-commandAction|5|46-preAction
} else if (displayable == searchList) {
if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|5|46-preAction
 // write pre-action user code here
searchListAction ();//GEN-LINE:|7-commandAction|6|46-postAction
 // write post-action user code here
} else if (command == backCommand2) {//GEN-LINE:|7-commandAction|7|54-preAction
 // write pre-action user code here
switchDisplayable (null, getList ());//GEN-LINE:|7-commandAction|8|54-postAction
 // write post-action user code here
} else if (command == okCommand1) {//GEN-LINE:|7-commandAction|9|51-preAction
 // write pre-action user code here
switchDisplayable (null, getTextTB ());//GEN-LINE:|7-commandAction|10|51-postAction
    
    String sTerm = (String) searches.elementAt(searchList.getSelectedIndex());
    
    String artist = sTerm.substring(0, sTerm.indexOf(";"));
    String song = sTerm.substring(sTerm.indexOf(";")+1);
    this.seatchText(artist,song);
    artistTf.setString(artist);
    songTF.setString(song);
}//GEN-BEGIN:|7-commandAction|11|36-preAction
} else if (displayable == seatchform) {
if (command == backCommand) {//GEN-END:|7-commandAction|11|36-preAction
 // write pre-action user code here
switchDisplayable (null, getList ());//GEN-LINE:|7-commandAction|12|36-postAction
 // write post-action user code here
} else if (command == okCommand) {//GEN-LINE:|7-commandAction|13|31-preAction
 // write pre-action user code here
   
switchDisplayable (null, getTextTB ());//GEN-LINE:|7-commandAction|14|31-postAction
    searches.insertElementAt(artistTf.getString()+";"+songTF.getString(), 0);
    recUtil.updateRecord(searches);
    this.seatchText(artistTf.getString(),songTF.getString());
}//GEN-BEGIN:|7-commandAction|15|40-preAction
} else if (displayable == textTB) {
if (command == backCommand1) {//GEN-END:|7-commandAction|15|40-preAction
 // write pre-action user code here
switchDisplayable (null, getSeatchform ());//GEN-LINE:|7-commandAction|16|40-postAction
 // write post-action user code here
} else if (command == startC) {//GEN-LINE:|7-commandAction|17|43-preAction
 // write pre-action user code here
switchDisplayable (null, getList ());//GEN-LINE:|7-commandAction|18|43-postAction
 // write post-action user code here
}//GEN-BEGIN:|7-commandAction|19|7-postCommandAction
}//GEN-END:|7-commandAction|19|7-postCommandAction
 // write post-action user code here
}//GEN-BEGIN:|7-commandAction|20|
//</editor-fold>//GEN-END:|7-commandAction|20|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: list ">//GEN-BEGIN:|13-getter|0|13-preInit
/**
 * Returns an initiliazed instance of list component.
 * @return the initialized component instance
 */
public List getList () {
if (list == null) {//GEN-END:|13-getter|0|13-preInit
 // write pre-init user code here
list = new List ("list", Choice.IMPLICIT);//GEN-BEGIN:|13-getter|1|13-postInit
list.append ("S\u00F6k text", null);
list.append ("Tidigare s\u00F6kningar", null);
list.addCommand (getExitCommand ());
list.setCommandListener (this);
list.setSelectedFlags (new boolean[] { false, false });//GEN-END:|13-getter|1|13-postInit
 // write post-init user code here
}//GEN-BEGIN:|13-getter|2|
return list;
}
//</editor-fold>//GEN-END:|13-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: listAction ">//GEN-BEGIN:|13-action|0|13-preAction
/**
 * Performs an action assigned to the selected list element in the list component.
 */
public void listAction () {//GEN-END:|13-action|0|13-preAction
 // enter pre-action user code here
String __selectedString = getList ().getString (getList ().getSelectedIndex ());//GEN-BEGIN:|13-action|1|17-preAction
if (__selectedString != null) {
if (__selectedString.equals ("S\u00F6k text")) {//GEN-END:|13-action|1|17-preAction
 // write pre-action user code here
switchDisplayable (null, getSeatchform ());//GEN-LINE:|13-action|2|17-postAction
 // write post-action user code here
} else if (__selectedString.equals ("Tidigare s\u00F6kningar")) {//GEN-LINE:|13-action|3|18-preAction
 // write pre-action user code here
switchDisplayable (null, getSearchList ());//GEN-LINE:|13-action|4|18-postAction
 // write post-action user code here
}//GEN-BEGIN:|13-action|5|13-postAction
}//GEN-END:|13-action|5|13-postAction
 // enter post-action user code here
}//GEN-BEGIN:|13-action|6|
//</editor-fold>//GEN-END:|13-action|6|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: seatchform ">//GEN-BEGIN:|23-getter|0|23-preInit
/**
 * Returns an initiliazed instance of seatchform component.
 * @return the initialized component instance
 */
public Form getSeatchform () {
if (seatchform == null) {//GEN-END:|23-getter|0|23-preInit
 // write pre-init user code here
seatchform = new Form ("S\u00F6k", new Item[] { getArtistTf (), getSongTF () });//GEN-BEGIN:|23-getter|1|23-postInit
seatchform.addCommand (getOkCommand ());
seatchform.addCommand (getBackCommand ());
seatchform.setCommandListener (this);//GEN-END:|23-getter|1|23-postInit
 // write post-init user code here
}//GEN-BEGIN:|23-getter|2|
return seatchform;
}
//</editor-fold>//GEN-END:|23-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: artistTf ">//GEN-BEGIN:|28-getter|0|28-preInit
/**
 * Returns an initiliazed instance of artistTf component.
 * @return the initialized component instance
 */
public TextField getArtistTf () {
if (artistTf == null) {//GEN-END:|28-getter|0|28-preInit
 // write pre-init user code here
artistTf = new TextField ("Artist/gruppnamn", null, 32, TextField.ANY);//GEN-LINE:|28-getter|1|28-postInit
 // write post-init user code here
}//GEN-BEGIN:|28-getter|2|
return artistTf;
}
//</editor-fold>//GEN-END:|28-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: songTF ">//GEN-BEGIN:|29-getter|0|29-preInit
/**
 * Returns an initiliazed instance of songTF component.
 * @return the initialized component instance
 */
public TextField getSongTF () {
if (songTF == null) {//GEN-END:|29-getter|0|29-preInit
 // write pre-init user code here
songTF = new TextField ("L\u00E5tnamn", null, 32, TextField.ANY);//GEN-LINE:|29-getter|1|29-postInit
 // write post-init user code here
}//GEN-BEGIN:|29-getter|2|
return songTF;
}
//</editor-fold>//GEN-END:|29-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: textTB ">//GEN-BEGIN:|38-getter|0|38-preInit
/**
 * Returns an initiliazed instance of textTB component.
 * @return the initialized component instance
 */
public TextBox getTextTB () {
if (textTB == null) {//GEN-END:|38-getter|0|38-preInit
 // write pre-init user code here
textTB = new TextBox ("Lyric", "None", 500, TextField.ANY | TextField.UNEDITABLE);//GEN-BEGIN:|38-getter|1|38-postInit
textTB.addCommand (getBackCommand1 ());
textTB.addCommand (getStartC ());
textTB.setCommandListener (this);
textTB.setInitialInputMode ("UTF8");//GEN-END:|38-getter|1|38-postInit
 // write post-init user code here
}//GEN-BEGIN:|38-getter|2|
return textTB;
}
//</editor-fold>//GEN-END:|38-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand ">//GEN-BEGIN:|19-getter|0|19-preInit
/**
 * Returns an initiliazed instance of exitCommand component.
 * @return the initialized component instance
 */
public Command getExitCommand () {
if (exitCommand == null) {//GEN-END:|19-getter|0|19-preInit
 // write pre-init user code here
exitCommand = new Command ("Exit", Command.EXIT, 0);//GEN-LINE:|19-getter|1|19-postInit
 // write post-init user code here
}//GEN-BEGIN:|19-getter|2|
return exitCommand;
}
//</editor-fold>//GEN-END:|19-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand ">//GEN-BEGIN:|30-getter|0|30-preInit
/**
 * Returns an initiliazed instance of okCommand component.
 * @return the initialized component instance
 */
public Command getOkCommand () {
if (okCommand == null) {//GEN-END:|30-getter|0|30-preInit
 // write pre-init user code here
okCommand = new Command ("Ok", Command.OK, 0);//GEN-LINE:|30-getter|1|30-postInit
 // write post-init user code here
}//GEN-BEGIN:|30-getter|2|
return okCommand;
}
//</editor-fold>//GEN-END:|30-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand1 ">//GEN-BEGIN:|32-getter|0|32-preInit
/**
 * Returns an initiliazed instance of exitCommand1 component.
 * @return the initialized component instance
 */
public Command getExitCommand1 () {
if (exitCommand1 == null) {//GEN-END:|32-getter|0|32-preInit
 // write pre-init user code here
exitCommand1 = new Command ("Exit", Command.EXIT, 0);//GEN-LINE:|32-getter|1|32-postInit
 // write post-init user code here
}//GEN-BEGIN:|32-getter|2|
return exitCommand1;
}
//</editor-fold>//GEN-END:|32-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand ">//GEN-BEGIN:|35-getter|0|35-preInit
/**
 * Returns an initiliazed instance of backCommand component.
 * @return the initialized component instance
 */
public Command getBackCommand () {
if (backCommand == null) {//GEN-END:|35-getter|0|35-preInit
 // write pre-init user code here
backCommand = new Command ("Back", Command.BACK, 0);//GEN-LINE:|35-getter|1|35-postInit
 // write post-init user code here
}//GEN-BEGIN:|35-getter|2|
return backCommand;
}
//</editor-fold>//GEN-END:|35-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: searchList ">//GEN-BEGIN:|45-getter|0|45-preInit
/**
 * Returns an initiliazed instance of searchList component.
 * @return the initialized component instance
 */
public List getSearchList () {
if (searchList == null) {//GEN-END:|45-getter|0|45-preInit
 // write pre-init user code here
searchList = new List ("Tidigare S\u00F6kningar", Choice.IMPLICIT);//GEN-BEGIN:|45-getter|1|45-postInit
searchList.addCommand (getOkCommand1 ());
searchList.addCommand (getBackCommand2 ());
searchList.setCommandListener (this);//GEN-END:|45-getter|1|45-postInit
 // write post-init user code here
int size = searches.size();
                for(int i = 0; i < size; i++){
                    String content = (String) searches.elementAt(i);
                    String title = content.substring(0,content.indexOf(";"));
                    
                    searchList.append(title, null);
            }
}//GEN-BEGIN:|45-getter|2|
return searchList;
}
//</editor-fold>//GEN-END:|45-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: searchListAction ">//GEN-BEGIN:|45-action|0|45-preAction
/**
 * Performs an action assigned to the selected list element in the searchList component.
 */
public void searchListAction () {//GEN-END:|45-action|0|45-preAction
 // enter pre-action user code here
String __selectedString = getSearchList ().getString (getSearchList ().getSelectedIndex ());//GEN-LINE:|45-action|1|45-postAction
 // enter post-action user code here
}//GEN-BEGIN:|45-action|2|
//</editor-fold>//GEN-END:|45-action|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand1 ">//GEN-BEGIN:|39-getter|0|39-preInit
/**
 * Returns an initiliazed instance of backCommand1 component.
 * @return the initialized component instance
 */
public Command getBackCommand1 () {
if (backCommand1 == null) {//GEN-END:|39-getter|0|39-preInit
 // write pre-init user code here
backCommand1 = new Command ("Back", Command.BACK, 0);//GEN-LINE:|39-getter|1|39-postInit
 // write post-init user code here
}//GEN-BEGIN:|39-getter|2|
return backCommand1;
}
//</editor-fold>//GEN-END:|39-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: startC ">//GEN-BEGIN:|42-getter|0|42-preInit
/**
 * Returns an initiliazed instance of startC component.
 * @return the initialized component instance
 */
public Command getStartC () {
if (startC == null) {//GEN-END:|42-getter|0|42-preInit
 // write pre-init user code here
startC = new Command ("Start", Command.OK, 0);//GEN-LINE:|42-getter|1|42-postInit
 // write post-init user code here
}//GEN-BEGIN:|42-getter|2|
return startC;
}
//</editor-fold>//GEN-END:|42-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand1 ">//GEN-BEGIN:|50-getter|0|50-preInit
/**
 * Returns an initiliazed instance of okCommand1 component.
 * @return the initialized component instance
 */
public Command getOkCommand1 () {
if (okCommand1 == null) {//GEN-END:|50-getter|0|50-preInit
 // write pre-init user code here
okCommand1 = new Command ("Ok", Command.OK, 0);//GEN-LINE:|50-getter|1|50-postInit
 // write post-init user code here
}//GEN-BEGIN:|50-getter|2|
return okCommand1;
}
//</editor-fold>//GEN-END:|50-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand2 ">//GEN-BEGIN:|53-getter|0|53-preInit
/**
 * Returns an initiliazed instance of backCommand2 component.
 * @return the initialized component instance
 */
public Command getBackCommand2 () {
if (backCommand2 == null) {//GEN-END:|53-getter|0|53-preInit
 // write pre-init user code here
backCommand2 = new Command ("Back", Command.BACK, 0);//GEN-LINE:|53-getter|1|53-postInit
 // write post-init user code here
}//GEN-BEGIN:|53-getter|2|
return backCommand2;
}
//</editor-fold>//GEN-END:|53-getter|2|

    /**
     * Returns a display instance.
     * @return the display instance.
     */
    public Display getDisplay () {
        return Display.getDisplay(this);
    }

    /**
     * Exits MIDlet.
     */
    public void exitMIDlet() {
        switchDisplayable (null, null);
        destroyApp(true);
        notifyDestroyed();
    }

    /**
     * Called when MIDlet is started.
     * Checks whether the MIDlet have been already started and initialize/starts or resumes the MIDlet.
     */
    public void startApp() {
        if (midletPaused) {
            resumeMIDlet ();
        } else {
            initialize ();
            startMIDlet ();
        }
        midletPaused = false;
    }

    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp() {
        midletPaused = true;
    }

    /**
     * Called to signal the MIDlet to terminate.
     * @param unconditional if true, then the MIDlet has to be unconditionally terminated and all resources has to be released.
     */
    public void destroyApp(boolean unconditional) {
    }

    private void seatchText(String artist, String song) {
        String lyric;
        lyric = httpUtil.httpGetQuery(artist, song);
        
        textTB.setMaxSize(lyric.length()+1);
        textTB.setString(lyric);
        searchList=null;
    }

}
