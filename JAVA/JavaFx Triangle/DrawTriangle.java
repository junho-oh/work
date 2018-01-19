package q2;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

/**
 * <p>
 * COMP 1510 assignment 4 q2.
 * </p>
 * <p>
 * The program draws an equilateral triangle using a rubber banding technique.
 * The triangle size and orientation are determined by a mouse drag. the
 * original mouse press location is the center, and the dragged position of the
 * mouse is one of the corners.
 * </p>
 *
 * @author JunHo Oh
 * @version 1.0
 */
public class DrawTriangle extends Application {

    /**
     * Final value of atCenter radius.
     */
    private static final int RADIUS = 3;

    /**
     * Final value of numbers of point of the triangle.
     */
    private static final int TRI_POINT = 3;
    
    /**
     * Final value of the number four 
     * for the equation of the equilateral triangle. 
     */
    private static final int FOUR = 4;
    
    /** The contents of the application scene. */
    private Group root;

    /** center point. */
    private Point2D center;

    /** circle to move to first mouse click location. */
    private Circle atCenter = new Circle(0, 0, RADIUS);
    /**
     * Starting point of the mouse drag.
     */
    private Point2D start;

    /**
     * Displays an initially empty scene, 
     * waiting for the user to draw lines with the mouse.
     * 
     * @param primaryStage
     *            a Stage
     */
    public void start(Stage primaryStage) {
        root = new Group(atCenter);
        atCenter.setFill(Color.CYAN);

        final int appWidth = 800;
        final int appHeight = 500;
        Scene scene = new Scene(root, appWidth, appHeight, Color.BLACK);

        scene.setOnMousePressed(this::processMousePress);
        scene.setOnMouseDragged(this::processMouseDrag);

        primaryStage.setTitle("Equilateral Triangle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * <p>
     * Adds a new circle to the scene when the mouse button is pressed.
     * </p>
     * 
     * @param event
     *            invoked this method
     */
    public void processMousePress(MouseEvent event) {
        center = new Point2D(event.getSceneX(), event.getSceneY());
        atCenter = new Circle(event.getSceneX(), event.getSceneY(), RADIUS);
        atCenter.setFill(Color.CYAN);
        root.getChildren().clear();
        root.getChildren().add(atCenter);
    }

    /**
     * <p>
     * Draws an equilateral triangle. The triangle size and orientation are
     * determined by a mouse drag. Sets the original mouse press location as the
     * center, and the dragged position of the mouse as one of the corners.
     * </p>
     * 
     * @param event
     *            invoked this method
     */
    public void processMouseDrag(MouseEvent event) {
        start = new Point2D(event.getSceneX(), event.getSceneY());

        Point2D centerP = new Point2D(start.getX() - center.getX(), 
                start.getY() - center.getY());

        double bX = centerP.getX() * Math.cos((2 * Math.PI) / TRI_POINT) 
                - (centerP.getY() * Math.sin((2 * Math.PI) / TRI_POINT));
        double bY = centerP.getX() * Math.sin((2 * Math.PI) / TRI_POINT) 
                + (centerP.getY() * Math.cos((2 * Math.PI) / TRI_POINT));

        double cX = centerP.getX() * Math.cos((FOUR * Math.PI) / TRI_POINT) 
                - (centerP.getY() * Math.sin((FOUR * Math.PI) / TRI_POINT));
        
        double cY = centerP.getX() * Math.sin((FOUR * Math.PI) / TRI_POINT) 
                + (centerP.getY() * Math.cos((FOUR * Math.PI) / TRI_POINT));

        Point2D secondPoint = new Point2D(bX, bY);
        Point2D thirdPoint = new Point2D(cX, cY);
        Double[] list = {centerP.getX() + center.getX(), 
                centerP.getY() + center.getY(),
                secondPoint.getX() + center.getX(), 
                secondPoint.getY() + center.getY(),
                thirdPoint.getX() + center.getX(), 
                thirdPoint.getY() + center.getY()};

        Polygon triangle = new Polygon();
        triangle.getPoints().addAll(list);
        triangle.setStroke(Color.CYAN);
        root.getChildren().clear();
        root.getChildren().add(triangle);
        root.getChildren().add(atCenter);
    }

    /**
     * Launches the JavaFX application.
     * 
     * @param args
     *            command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
