package org.example

import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import java.net.URL
import java.util.*

class RouteTrackingController: Initializable {

    @FXML var imageView: ImageView? = null

    @FXML var driverNameLabel: Label? = null
    @FXML var routeCodeLabel: Label? = null
    @FXML var nextStopNameLabel: Label? = null

    @FXML var nextBusETAImageView: ImageView? = null
    @FXML var nextBusETALabel: Label? = null

    @FXML var currentBusETAImageView: ImageView? = null
    @FXML var currentBusETALabel: Label? = null

    @FXML var previousBusETAImageView: ImageView? = null
    @FXML var previousBusETALabel: Label? = null

    @FXML var initialHourLabel: Label? = null
    @FXML var finalHourLabel: Label? = null
    @FXML var timeLabel: Label? = null

    @FXML var nextStopLabel: Label? = null
    @FXML var speedLabel: Label? = null
    @FXML var nextStopDistanceLabel: Label? = null

    @FXML var closeRouteTrackingFragmentButton: Button? = null

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        imageView?.image = Image(javaClass.getResourceAsStream("/images/route_service_background.png"))
        nextBusETAImageView?.image = Image(javaClass.getResourceAsStream("/images/bus_siva.png"))
        currentBusETAImageView?.image = Image(javaClass.getResourceAsStream("/images/bus_siva.png"))
        previousBusETAImageView?.image = Image(javaClass.getResourceAsStream("/images/bus_siva.png"))
    }
}