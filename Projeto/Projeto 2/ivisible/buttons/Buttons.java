package ivisible.buttons;

import java.awt.*;
import java.awt.geom.Ellipse2D;

import ivisible.*;
import ivisible.figures.*;

public abstract class Buttons implements IVisible {
    public int x, y, w, h;
    public int index;
    public boolean focus;
    public abstract void paint (Graphics g);
    public abstract boolean area (Point point);
}