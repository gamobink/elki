package de.lmu.ifi.dbs.elki.math.geometry;
/*
 This file is part of ELKI:
 Environment for Developing KDD-Applications Supported by Index-Structures

 Copyright (C) 2016
 Ludwig-Maximilians-Universität München
 Lehr- und Forschungseinheit für Datenbanksysteme
 ELKI Development Team

 This program is free software: you can redistribute it and/or modify
 it under the terms of the GNU Affero General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU Affero General Public License for more details.

 You should have received a copy of the GNU Affero General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;

/**
 * Unit test for graham scan convex hulls.
 *
 * TODO: as this test shows, we sometimes create too complex hulls on colinear
 * points!
 *
 * @author Erich Schubert
 */
public class GrahamScanConvexHull2DTest {
  @Test
  public void simple() {
    GrahamScanConvexHull2D t = new GrahamScanConvexHull2D();
    t.add(0, 0);
    t.add(1, 0);
    t.add(0, 1);
    t.add(1, 1);
    assertEquals("Hull size not as expected.", 4, t.getHull().size());
  }

  @Test
  public void simple2() {
    GrahamScanConvexHull2D t = new GrahamScanConvexHull2D();
    t.add(0, 0);
    t.add(0, 1);
    t.add(1, 0);
    t.add(1, 1);
    assertEquals("Hull size not as expected.", 4, t.getHull().size());
  }

  @Test
  public void duplicates() {
    GrahamScanConvexHull2D t = new GrahamScanConvexHull2D();
    t.add(0, 0);
    t.add(0, 0);
    t.add(0, 0);
    t.add(0, 0);
    assertEquals("Hull size not as expected.", 1, t.getHull().size());
  }

  @Test
  public void degeneratre() {
    GrahamScanConvexHull2D t = new GrahamScanConvexHull2D();
    t.add(0, 0);
    t.add(0, 0);
    t.add(0, 0);
    t.add(0, 0);
    t.add(1, 1);
    t.add(1, 1);
    t.add(1, 1);
    t.add(1, 1);
    t.add(2, 2);
    // TODO: Size 2 would be enough!
    assertEquals("Hull size not as expected.", 3, t.getHull().size());
  }

  @Test
  public void random() {
    GrahamScanConvexHull2D t = new GrahamScanConvexHull2D();
    Random r = new Random(0L);
    for(int i = 0; i < 1000; i++) {
      t.add(r.nextDouble(), r.nextDouble());
    }
    assertEquals("Hull size not as expected.", 21, t.getHull().size());
  }

  @Test
  public void difficult() {
    GrahamScanConvexHull2D t = new GrahamScanConvexHull2D();
    t.add(47.82, 13.0);
    t.add(47.825, 13.0);
    t.add(47.82, 13.005);
    t.add(47.825, 13.005);
    t.add(47.825, 13.01);
    t.add(47.825, 12.995);
    t.add(47.83, 12.995);
    t.add(47.83, 13.);
    t.add(47.83, 13.005);
    t.add(47.83, 13.01);
    t.add(47.83, 12.99);
    t.add(47.835, 12.99);
    t.add(47.835, 12.995);
    t.add(47.835, 13.);
    t.add(47.835, 13.005);
    t.add(47.835, 13.01);
    t.add(47.84, 13.);
    t.add(47.84, 13.005);
    t.add(47.84, 13.01);
    t.add(47.845, 13.005);
    t.add(47.845, 13.01);
    t.add(47.85, 13.005);
    t.add(47.85, 13.01);
    t.add(47.855, 13.005);
    assertEquals("Hull size not as expected.", 7, t.getHull().size());
  }
}