
import java.util.Vector;
import javax.microedition.rms.RecordEnumeration;
import javax.microedition.rms.RecordStore;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.microedition.rms.RecordStoreException;
import javax.microedition.rms.RecordStoreNotOpenException;

/**
 *
 * @author patrik
 */
public class RecordUtil {

    
    private String recordStoreName;

    public RecordUtil(String recordStoreName) {
        this.recordStoreName = recordStoreName;
    }

    public Vector load() throws RecordStoreException {
        RecordEnumeration enumeration = null;
        RecordStore rs = null;
        Vector seatchesV = null;
        try {

            rs = RecordStore.openRecordStore(recordStoreName, true);
            enumeration = rs.enumerateRecords(null, null, true);
            seatchesV = new Vector();
            int i = 0;
            //I'et är för att max ha 10 variabler i lista, dock så kan man ha fler
            //när man kör programmet, detta för att inte "irritera" användaren
            //minnet "rensas" alltså vi slutet av körningen
            while (enumeration.hasNextElement() && i != 10) {
                
                byte[] data = enumeration.nextRecord();
               
                seatchesV.insertElementAt(new String(data), 0);
                i++;
            }
        } finally {
            if (enumeration != null) {
                enumeration.destroy();
            }
            if (rs != null) {
                rs.closeRecordStore();
            }

        }
        
        return seatchesV;

    }

    void updateRecord(Vector searchV) {
        RecordEnumeration enumeration = null;
        RecordStore rs = null;
        try {
            rs = RecordStore.openRecordStore(recordStoreName, true);
            enumeration = rs.enumerateRecords(null, null, false);
            while (enumeration.hasNextElement()) {
                int nextId = enumeration.nextRecordId();
                rs.deleteRecord(nextId);
            }
            //Endast spara 10 st sökningar
            searchV.size();
            for (int i = 0; i < 10 && i < searchV.size(); i++) {
                String notis = (String) searchV.elementAt(i);
                byte[] data = notis.getBytes();
                rs.addRecord(data, 0, data.length);
            }
        } catch (RecordStoreException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (enumeration != null) {
                    enumeration.destroy();
                }
                if (rs != null) {
                    rs.closeRecordStore();
                }
            } catch (RecordStoreNotOpenException ex) {
                ex.printStackTrace();
            } catch (RecordStoreException ex) {
                ex.printStackTrace();
            }
        }

    }
}

