package com.buildings.grKN01151st30;

import eu.printingin3d.javascad.coords.Angles3d;
import java.util.ArrayList;
import java.util.List;

import eu.printingin3d.javascad.models.Abstract3dModel;
import eu.printingin3d.javascad.models.Sphere;
import eu.printingin3d.javascad.coords.Coords3d;
import eu.printingin3d.javascad.coords.Dims3d;
import eu.printingin3d.javascad.coords.Triangle3d;
import eu.printingin3d.javascad.models.*;
import eu.printingin3d.javascad.tranzitions.Difference;
import eu.printingin3d.javascad.tranzitions.Scale;
import eu.printingin3d.javascad.tranzitions.Union;

class Building extends Union {
    Building() {
        super(getModels());
    }
    static Abstract3dModel MainHouse () {
        Abstract3dModel house = new Cube(new Dims3d(30, 30, 8));
        Abstract3dModel roof = new Cube(new Dims3d(32, 32, 13.5));
        roof = new Difference(roof.move(Coords3d.zOnly(2.7)),
            new Cube(new Dims3d(32, 32, 12))
                .rotate(Angles3d.xOnly(30)).move(new Coords3d(0, -12, 4.9)),
            new Cube(new Dims3d(32, 32, 12))
                .rotate(Angles3d.yOnly(30)).move(new Coords3d(12, 0, 4.9)),
            new Cube(new Dims3d(32, 32, 12))
                .rotate(Angles3d.xOnly(-30)).move(new Coords3d(0, 12, 4.9)),
            new Cube(new Dims3d(32, 32, 12))
                .rotate(Angles3d.yOnly(-30)).move(new Coords3d(-12, 0, 4.9))
        );
        house = new Union(house, roof.move(Coords3d.zOnly(8)));
        house = house.move(Coords3d.zOnly(4));
        return house;
    }
    static Abstract3dModel BuildX () {
        Abstract3dModel model = new Cube(new Dims3d(30, 12, 15));
        model = new Difference(model,
            new Cube(new Dims3d(32, 10, 6))
                .rotate(Angles3d.xOnly(30)).move(new Coords3d(0, -4, 7)),
            new Cube(new Dims3d(32, 10, 6))
                .rotate(Angles3d.xOnly(-30)).move(new Coords3d(0, 4, 7))
        );
        Abstract3dModel window = new Cube(new Dims3d(0.8, 2.5, 1.5));
        window = new Difference(window, new Cube(new Dims3d(1, 2.1, 1.1)));
        window = new Union(window,
            new Cube(new Dims3d(0.6, 2.5, 0.1)).move(Coords3d.zOnly(0.6)),
            new Cube(new Dims3d(0.6, 2.5, 0.1)).move(Coords3d.zOnly(-0.6)),
            new Cube(new Dims3d(0.6, 0.1, 1.5)).move(Coords3d.yOnly(0.35)),
            new Cube(new Dims3d(0.6, 0.1, 1.5)).move(Coords3d.yOnly(-0.35))
        );
        model = new Union(model,
            new Cube(new Dims3d(32, 7.4, 0.8))
                .rotate(Angles3d.xOnly(30)).move(new Coords3d(0, -3, 3.8)),
            new Cube(new Dims3d(32, 7.4, 0.8))
                .rotate(Angles3d.xOnly(-30)).move(new Coords3d(0, 3, 3.8)),
            window.move(new Coords3d(14.8, 0, 1.5)),
            window.move(new Coords3d(-14.8, 0, 1.5)),
            Window().rotate(Angles3d.zOnly(90)).move(new Coords3d(-14.8, 0, -4)),
            Window().rotate(Angles3d.zOnly(90)).move(new Coords3d(-14.8,-10, -4)),
            Window().rotate(Angles3d.zOnly(90)).move(new Coords3d(-14.8, 10, -4))
        );
        model = model.move(Coords3d.zOnly(7.5));
        return model;
    }
    static Abstract3dModel BuildY () {
        Abstract3dModel model = new Cube(new Dims3d(12, 37, 15));
        model = new Difference(model,
            new Cube(new Dims3d(10, 42, 6))
                .rotate(Angles3d.yOnly(-30)).move(new Coords3d(-4, 0, 7)),
            new Cube(new Dims3d(10, 42, 6))
                .rotate(Angles3d.yOnly(30)).move(new Coords3d(4, 0, 7))
        );
        model = new Union(model,
            new Cube(new Dims3d(7.4, 38, 0.8))
                .rotate(Angles3d.yOnly(-30)).move(new Coords3d(-3, 0, 3.8)),
            new Cube(new Dims3d(7.4, 38, 0.8))
                .rotate(Angles3d.yOnly(30)).move(new Coords3d(3, 0, 3.8))
        );
        Abstract3dModel balcoon = new Union(new Cylinder(0.2, 3),
            new Difference(new Cylinder(0.2, 3), new Cylinder(0.3, 2.5))
                .move(Coords3d.zOnly(1))
        );
        Abstract3dModel doorOnBalcoon = new Union(
            new Cube(new Dims3d(2.5, 0.5, 3.5)),
            new Cylinder(0.5, 1.25).rotate(Angles3d.xOnly(90)).move(Coords3d.zOnly(1.5))
        );
        model = new Difference(model,
            doorOnBalcoon.move(new Coords3d(0, 18.5, 0.8)),
            doorOnBalcoon.move(new Coords3d(0,-18.5, 0.8))
        );
        model = new Union(model,
            balcoon.move(new Coords3d(0, 18.5, -1)),
            balcoon.move(new Coords3d(0,-18.5, -1)),
            Window().move(new Coords3d(0, 18.4, -3.5)),
            Window().move(new Coords3d(0,-18.4, -3.5))
        );
        model = model.move(Coords3d.zOnly(7.5));
        return model;
    }   
    static Abstract3dModel Window () {
        Abstract3dModel model = new Cube(new Dims3d(2.5, 0.8, 3.5));
        model = new Difference(model, new Cube(new Dims3d(2.1, 1, 3.1)));
        model = new Union(model,
            new Cube(new Dims3d(2.5, 0.6, 0.1)).move(Coords3d.zOnly(0.6)),
            new Cube(new Dims3d(2.5, 0.6, 0.1)).move(Coords3d.zOnly(-0.6)),
            new Cube(new Dims3d(0.1, 0.6, 3.5)).move(Coords3d.xOnly(0.35)),
            new Cube(new Dims3d(0.1, 0.6, 3.5)).move(Coords3d.xOnly(-0.35))
        );
        return model;
    }
    static Abstract3dModel Kollona () {
        return new Union(
            new Cylinder(0.8, 0.5).move(Coords3d.zOnly(2.6)),
            new Cylinder(0.8, 0.4).move(Coords3d.zOnly(1.8)),
            new Cylinder(3, 0.3),
            new Cylinder(0.8, 0.4).move(Coords3d.zOnly(-1.8)),
            new Cylinder(0.8, 0.5).move(Coords3d.zOnly(-2.6))
        );
    }
    static Abstract3dModel Dumohod () {
        return new Union(
            new Cube(new Dims3d(3, 1, 8)),
            new Cube(new Dims3d(3.5, 1.5, 0.6)).move(Coords3d.zOnly(3.7)),
            new Cube(new Dims3d(3.5, 1.5, 0.6)).move(Coords3d.zOnly(2.7))
        );
    }
    private static List<Abstract3dModel> getModels() {
        List<Abstract3dModel> models = new ArrayList<Abstract3dModel>();
        Abstract3dModel house = MainHouse();
        house = new Difference(house,
            new Cube(new Dims3d(3, 12, 3)).move(new Coords3d(15, 0, 8)),
            new Cube(new Dims3d(3, 12, 3)).move(new Coords3d(-15, 0, 8))
        );
        house = new Union(house, BuildX(), BuildY());
        house = new Union(house,
            Window().move(new Coords3d(10, 14.8, 3.5)), Window().move(new Coords3d(-10, 14.8, 3.5)),
            Window().move(new Coords3d(10,-14.8, 3.5)), Window().move(new Coords3d(-10,-14.8, 3.5))
        );
        Abstract3dModel krulcco = new Cube(new Dims3d(7, 7, 2));
        krulcco = new Difference(krulcco,
            new Cube(new Dims3d(15, 15, 5))
                .rotate(Angles3d.yOnly(25)).move(Coords3d.zOnly(3)),
            new Cube(new Dims3d(12, 15, 5))
                .rotate(Angles3d.xOnly(30)).move(new Coords3d(0,-1.5, 3)),
            new Cube(new Dims3d(12, 15, 5))
                .rotate(Angles3d.xOnly(-30)).move(new Coords3d(0,1.5, 3))
        );
        house = new Union(house,
            krulcco.move(new Coords3d(16.5, 0, 7)),
            new Cube(new Dims3d(6, 6, 0.4)).move(new Coords3d(15.5, 0, 5.8)),
            Kollona().move(new Coords3d(15.2, 2.5, 3)),
            Kollona().move(new Coords3d(15.2,-2.5, 3)),
            Kollona().move(new Coords3d(18, 2.5, 3)),
            Kollona().move(new Coords3d(18,-2.5, 3)),
            Dumohod().move(new Coords3d(4, 10, 12)),
            Dumohod().rotate(Angles3d.zOnly(90)).move(new Coords3d(-4, 10, 12))
        );
        house = new Difference(house,
            new Cube(new Dims3d(0.5, 3, 6)).move(new Coords3d(15, 0, 2.5))
        );
        models.add(house);
        return models;
    }
}