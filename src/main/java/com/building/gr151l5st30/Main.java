package com.buildings.gr151l5st30;

import eu.printingin3d.javascad.utils.SaveScadFiles;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        new SaveScadFiles(new File("E:")).
                addModel("building_grKN01151st30.scad", new Building()).
                saveScadFiles();
    }
}
