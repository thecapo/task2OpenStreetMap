package com.example.jenny.task2openstreetmap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;

import static org.junit.Assert.*;

/**
 * Created by jenny on 8/10/17.
 */
public class MainActivityTest {

    private MapView myMap;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void onCreate() throws Exception {

    }

    @Test
    public void addMarker() throws Exception {
        Marker marker = new Marker(myMap);

    }

}