package plunzi.sh.parkour.schematic;

import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.extension.platform.Actor;
import com.sk89q.worldedit.extent.clipboard.Clipboard;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormat;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormats;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardReader;
import com.sk89q.worldedit.function.operation.Operation;
import com.sk89q.worldedit.function.operation.Operations;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.session.ClipboardHolder;
import com.sk89q.worldedit.world.World;

import java.util.concurrent.ThreadLocalRandom;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class load {
    public void load() throws IOException {
        Clipboard clipboard;
        int randomNum = ThreadLocalRandom.current().nextInt(1, 7 + 1);
        String file = "parkour_"+ randomNum+"_schem";
        ClipboardFormat format = ClipboardFormats.findByFile(new File((file)));
        try (ClipboardReader reader = format.getReader(new FileInputStream(file))) {
            clipboard = reader.read();
        }

        Actor world = null;
        try (EditSession editSession = WorldEdit.getInstance().newEditSession((World)world)) {
            Operation operation = new ClipboardHolder(clipboard)
                    .createPaste(editSession)
                    .to(BlockVector3.at(0, 0, 0))
                    // configure here
                    .build();
            Operations.complete(operation);
        }
    }
}

