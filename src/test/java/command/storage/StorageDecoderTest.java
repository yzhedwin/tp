package command.storage;

import module.Module;
import module.ModuleList;
import module.Schedule;
import org.junit.jupiter.api.Test;

class StorageDecoderTest {

    @Test
    public void decodeModuleList_normalModuleList_success() {
        ModuleList modules = new ModuleList();
        modules.add(new Module("CS2102"));
        modules.add(new Module("CS2112"));
        modules.add(new Module("CS2132"));
        modules.get(0).addTask("sleep");
        modules.get(0).addCredits(4);
        modules.get(2).addClass(new Schedule("Monday", "12pm","E3", "Bad"));
        modules.get(0).addClass(new Schedule("Monday", "12pm","D3", "Bad"));
        modules.get(0).addClass(new Schedule("Tuesday", "12pm","D3", "Bad"));
        StorageEncoder.encodeModuleListToJson(modules);
        ModuleList loadedModules = StorageDecoder.decodeJsonToModuleList();
        loadedModules.printModules();
    }

}