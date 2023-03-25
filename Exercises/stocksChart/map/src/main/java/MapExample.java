import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.input.PanKeyListener;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCenter;
import org.jxmapviewer.input.ZoomMouseWheelListenerCursor;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;

import javax.swing.*;
import javax.swing.event.MouseInputListener;

public class MapExample {
    public static void main(String[] args) {
        JFrame frame= new JFrame("map");
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JXMapViewer mapViewer = new JXMapViewer();

        TileFactoryInfo tileFactoryInfo= new OSMTileFactoryInfo();
        DefaultTileFactory defaultTileFactory= new DefaultTileFactory(tileFactoryInfo);
        mapViewer.setTileFactory(defaultTileFactory);

        GeoPosition position= new GeoPosition(51.308686207385584, 18.38371165946372);
        mapViewer.setZoom(10);
        mapViewer.setAddressLocation(position);

        MouseInputListener inputListener= new PanMouseInputListener(mapViewer);
        mapViewer.addMouseListener(inputListener);
        mapViewer.addMouseMotionListener(inputListener);

        mapViewer.addMouseWheelListener(new ZoomMouseWheelListenerCursor(mapViewer));
        mapViewer.addKeyListener(new PanKeyListener(mapViewer));

        frame.getContentPane().add(mapViewer);
        frame.setVisible(true);
    }
}
